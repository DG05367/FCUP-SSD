package pow;

import pow.Transaction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Block {
    private List<Transaction> transactions;
    private String previousBlockHash;
    private final long timestamp;
    private int nonce;
    private final int difficulty;
    private String merkleRootHash;
    private String hash;

    public Block(List<Transaction> transactions, String previousBlockHash, long timestamp, int difficulty) {
        this.transactions = transactions;
        this.previousBlockHash = previousBlockHash;
        this.timestamp = timestamp;
        this.nonce = 0;
        this.difficulty = difficulty;
    }

    public String getHash() {
        return hash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getMerkleRootHash() {
        return merkleRootHash;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String calculateHash() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        for (Transaction transaction : transactions) {
            sb.append(transaction.getTransactionData());
        }
        sb.append(previousBlockHash).append(timestamp).append(nonce).append(difficulty);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(sb.toString().getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public void mineBlock() throws NoSuchAlgorithmException {
        String target = "0".repeat(difficulty);
        while (true) {
            String hash = calculateHash();
            if (hash.startsWith(target)) {
                System.out.println("Block mined: " + hash);
                break;
            }
            nonce++;
        }
    }

    public boolean validateTransactions() {
        for (Transaction transaction : transactions) {
            if (!transaction.isValid()) {
                return false;
            }
        }
        return true;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public void addTransaction(Transaction transaction) {
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
        transactions.add(transaction);
        String merkleRootHash = calculateMerkleRootHash();
    }

    private String calculateMerkleRootHash() {
        if (transactions == null || transactions.isEmpty()) {
            return "";
        }
        List<String> transactionData = new ArrayList<>();
        for (Transaction transaction : transactions) {
            transactionData.add(transaction.getTransactionData());
        }
        try {
            MerkleTree merkleTree = new MerkleTree(transactionData);
            return merkleTree.getRootHash();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
