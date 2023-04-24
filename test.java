import java.util.*;
import java.security.*;

public class test {
    public static class RoutingTable {
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

    public static class Node {
        byte[] id;
        private final Map<byte[], byte[]> values;
        private final Set<Node> neighbors;
        private static final int HASH_BITS = 160;

        public Node(byte[] id) {
            this.id = id;
            this.values = new HashMap<>();
            this.neighbors = new HashSet<>();
        }

        public byte[] getNodeId() {
            return id;
        }

        public void addNeighbor(Node node) {
            neighbors.add(node);
        }

        public byte[] findNode(byte[] targetId) {
            // TODO: Implement node lookup.
            return null;
        }

        public byte[] findValue(byte[] key) {
            // TODO: Implement value lookup.
            return null;
        }

        public void joinNetwork(Node bootstrapNode) {
            // TODO: Implement node join.
        }

        public void storeValue(byte[] key, byte[] value) {
            // TODO: Implement value store.
        }

        // Generate a unique node ID using SHA-1
        public static byte[] generateNodeId() {
            byte[] nodeId = new byte[HASH_BITS / 8];

            do {
                // Generate a random value
                SecureRandom random = new SecureRandom();
                byte[] randomValue = new byte[nodeId.length];
                random.nextBytes(randomValue);

                // Calculate the SHA-1 hash of the random value
                try {
                    MessageDigest digest = MessageDigest.getInstance("SHA-1");
                    byte[] hash = digest.digest(randomValue);

                    // Check if the hash value is valid for use as a node ID
                    if (isValidNodeId(hash)) {
                        nodeId = hash;
                    }
                } catch (NoSuchAlgorithmException e) {
                    // Handle exception

                }
            } while (nodeId.length == 0);

            return nodeId;
        }

        // Check if a hash value is valid for use as a node ID
        private static boolean isValidNodeId(byte[] hash) {
            int k = 20; // Nodes in the network

            // Check if the hash value has at least one bit set to 1 in the first 160 - k
            // bits
            int numBits = HASH_BITS - k;
            for (int i = 0; i < numBits / 8; i++) {
                if (hash[i] != 0) {
                    return true;
                }
            }

            return (hash[numBits / 8] & (0xFF << (8 - numBits % 8))) != 0;
        }

    }

    public static void main(String[] args) {
        Node bootstrapNode = new Node(Node.generateNodeId());
        RoutingTable routingTable = new RoutingTable();
        routingTable.addNode(bootstrapNode);
        System.out.println(bootstrapNode.neighbors);
    }
}
