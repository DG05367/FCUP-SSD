package kademlia;

import java.util.*;

public class RoutingTable {
    private final Map<byte[], Node> nodes;

    public RoutingTable() {
        this.nodes = new HashMap<>();
    }

    public void addNode(Node node) {
        nodes.put(node.getNodeId(), node);
    }

    public void removeNode(byte[] nodeId) {
        nodes.remove(nodeId);
    }

    public Node findNode(byte[] nodeId) {
        return nodes.get(nodeId);
    }
}