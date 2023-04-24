package kademlia;

public class Main {
    public static void main(String[] args) {
        Node bootstrapNode = new Node(kademlia.Node.generateNodeId());
        RoutingTable routingTable = new RoutingTable();
        routingTable.addNode(bootstrapNode);
        System.out.println(bootstrapNode.id);
    }
}
