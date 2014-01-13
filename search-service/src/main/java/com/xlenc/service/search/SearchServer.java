package com.xlenc.service.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xlenc.service.search.SchemaTypes.question.QuestionData;
import com.yammer.dropwizard.lifecycle.Managed;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import java.util.HashMap;

/**
 * User: Michael Williams
 * Date: 12/1/13
 * Time: 7:29 PM
 */
public class SearchServer implements SearchPersistence, Managed {

    private static Client client;
    private String host;
    private Integer port;

    public SearchServer(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void start() throws Exception {
        client = new TransportClient()
                .addTransportAddress(new InetSocketTransportAddress(this.host, this.port))
                .addTransportAddress(new InetSocketTransportAddress(this.host, this.port));
    }

    @Override
    public Object updateQuestion(String index, String type, String id, QuestionData itemToIndex) {
        if (itemToIndex == null) {
            return null;
        }

        //TODO: the following check needs to be implemented properly. The return
        // might not be null even if record doesn't exist.
        if (getQuestionData(index, type, id)==null) {
            return null;
        }
        return updateQuestionIndex(index, type, id, itemToIndex);
    }

    private Object updateQuestionIndex(String index, String type, String id, QuestionData itemToIndex) {
        String source = null;
        ObjectMapper mapperES = new ObjectMapper();
        try{
            source = mapperES.writeValueAsString(itemToIndex);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        final IndexResponse indexResponse = client.prepareIndex(index, type, id).setSource(source).execute().actionGet();
        return new HashMap<String, Object>() {{
            put("ok", true);
            put("_id", indexResponse.getId());
            put("_type", indexResponse.getType());
            put("_index", indexResponse.getIndex());
            put("_version", indexResponse.getVersion());
        }};
    }

    @Override
    public Object addQuestion(String index, String type, QuestionData itemToIndex) {
        if (itemToIndex == null || itemToIndex.getId() == null || itemToIndex.getId().isEmpty()) {
            return null;
        }
        return updateQuestionIndex(index, type, itemToIndex.getId(), itemToIndex);
    }

    @Override
    public QuestionData getQuestionData(String index, String type, String id) {
        final GetResponse getResponse = client.prepareGet(index, type, id).execute().actionGet();
        ObjectMapper objectMapper = new ObjectMapper();
        QuestionData questionData = null;
        try {
            questionData = objectMapper.readValue(getResponse.getSourceAsString(), QuestionData.class);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return questionData;
    }

    @Override
    public Object deleteQuestion(String index, String type, String id) {
        final DeleteResponse response = client.prepareDelete("twitter", "tweet", "1")
                .execute()
                .actionGet();

        return new HashMap<String, Object>() {{
            put("ok", true);
            put("_id", response.getId());
            put("_type", response.getType());
            put("_index", response.getIndex());
            put("_version", response.getVersion());
            put("_notFound", response.isNotFound());
        }};
    }

    @Override
    public void stop() throws Exception {
        if (client != null) {
            client.close();
        }
    }

    public Client getClient() {
        return client;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
