package com.xlenc.service.search;

import com.yammer.dropwizard.lifecycle.Managed;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Michael Williams
 * Date: 12/1/13
 * Time: 7:29 PM
 */
public class SearchServer implements SearchPersistence, Managed {

    private Node node;

    @Override
    public void start() throws Exception {
        final ImmutableSettings.Builder settings = ImmutableSettings.settingsBuilder();
        settings.put("node.name", "orange11-node");
        settings.put("path.data", "/data/index");
        settings.put("http.enabled", false);
        node = NodeBuilder.nodeBuilder()
                .settings(settings)
                .clusterName("orange11-cluster")
                .data(true)
                .local(true)
                .node();

    }

    @Override
    public Map<String, Object> addIndexItem(String index, String type, String id, Map<String, Object> map) {
        final Client client   = node.client();
        final IndexResponse indexResponse = client.prepareIndex(index, type, id).setSource(map).execute().actionGet();
        return new HashMap<String, Object>() {{
            put("ok", true);
            put("_id", indexResponse.getId());
            put("_type", indexResponse.getType());
            put("_index", indexResponse.getIndex());
            put("_version", indexResponse.getVersion());
        }};
    }

    @Override
    public void stop() throws Exception {
        if (node != null) {
            node.close();
        }
    }

}
