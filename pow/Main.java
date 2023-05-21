package pow;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Create transactions
            Transaction transaction1 = new Transaction("Alice", "Bob", 10.0);
            Transaction transaction2 = new Transaction("Bob", "Charlie", 5.0);
            Transaction transaction3 = new Transaction("Alice", "Charlie", 3.0);

            // Create a Merkle tree with transaction data
            List<String> transactionData = new ArrayList<>();
            transactionData.add(transaction1.getTransactionData());
            transactionData.add(transaction2.getTransactionData());
            transactionData.add(transaction3.getTransactionData());
            MerkleTree merkleTree = new MerkleTree(transactionData);

            // Get the root hash of the Merkle tree
            String rootHash = merkleTree.getRootHash();
            System.out.println("Merkle Tree Root Hash: " + rootHash);

            // Create a blockchain with a difficulty level of 3
            int difficulty = 3;
            Blockchain blockchain = new Blockchain(difficulty);

            // Create a block with the Merkle root hash and add transactions
            Block block1 = new Block(rootHash,"0", System.currentTimeMillis(), difficulty);
            block1.addTransaction(transaction1);
            block1.addTransaction(transaction2);
            block1.addTransaction(transaction3);

            // Mine the block
            block1.mineBlock();

            // Add the block to the blockchain
            blockchain.addBlock(block1);

            // Validate the blockchain
            boolean isValid = blockchain.validate();
            System.out.println("Is Blockchain Valid? " + isValid);

            // Print the blockchain
            System.out.println("Blockchain:");
            blockchain.print();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
