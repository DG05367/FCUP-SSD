package pow;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
    private final MerkleNode root;

    public MerkleTree(List<String> data) throws NoSuchAlgorithmException {
        this.root = buildTree(data);
    }

    public String getRootHash() {
        return root != null ? root.hash : "";
    }

    private MerkleNode buildTree(List<String> data) throws NoSuchAlgorithmException {
        List<MerkleNode> nodes = new ArrayList<>();

        // Create leaf nodes
        for (String value : data) {
            MerkleNode node = new MerkleNode(value);
            nodes.add(node);
        }

        // Build tree by combining nodes
        while (nodes.size() > 1) {
            List<MerkleNode> tempNodes = new ArrayList<>();

            // Combine adjacent nodes
            for (int i = 0; i < nodes.size(); i += 2) {
                MerkleNode left = nodes.get(i);
                MerkleNode right = (i + 1 < nodes.size()) ? nodes.get(i + 1) : null;
                MerkleNode parent = combineNodes(left, right);
                tempNodes.add(parent);
            }

            nodes = tempNodes;
        }

        return (nodes.size() == 1) ? nodes.get(0) : null;
    }

    private MerkleNode combineNodes(MerkleNode left, MerkleNode right) throws NoSuchAlgorithmException {
        MerkleNode parent = new MerkleNode();

        // Concatenate the hash values of left and right nodes
        String combinedHash = left.hash + (right != null ? right.hash : "");
        parent.hash = calculateHash(combinedHash);

        parent.left = left;
        parent.right = right;

        return parent;
    }

    private static String calculateHash(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static class MerkleNode {
        private String hash;
        private MerkleNode left;
        private MerkleNode right;

        public MerkleNode() {
        }

        public MerkleNode(String value) throws NoSuchAlgorithmException {
            this.hash = calculateHash(value);
        }
    }
}
