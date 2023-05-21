package pow;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> chain;
    private final int difficulty;

    public Blockchain(int difficulty) {
        this.chain = new ArrayList<>();
        this.difficulty = difficulty;
        // Genesis block
        Block genesisBlock = createGenesisBlock();
        chain.add(genesisBlock);
    }

    private Block createGenesisBlock() {
        List<Transaction> transactions = new ArrayList<>();  
        return new Block(transactions, "0", System.currentTimeMillis(), difficulty);
    }

    public void addBlock(Block block) throws NoSuchAlgorithmException {
        if (block.validateTransactions()) {
            block.mineBlock();
            block.setPreviousBlockHash(chain.get(chain.size() - 1).calculateHash());
            chain.add(block);
        } else {
            System.out.println("Invalid transactions in the block. Block not added to the chain.");
        }
    }

    public boolean isChainValid() throws NoSuchAlgorithmException {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.calculateHash().equals(currentBlock.calculateHash())) {
                System.out.println("Invalid block hash for block " + i);
                return false;
            }

            if (!currentBlock.getPreviousBlockHash().equals(previousBlock.calculateHash())) {
                System.out.println("Invalid previous block hash for block " + i);
                return false;
            }

            if (!currentBlock.validateTransactions()) {
                System.out.println("Invalid transactions in block " + i);
                return false;
            }
        }
        return true;
    }

    public void handleFork(Blockchain newChain) throws NoSuchAlgorithmException {
        if (newChain.chain.size() > this.chain.size()) {
            if (newChain.isChainValid()) {
                this.chain = newChain.chain;
                System.out.println("Blockchain updated with the new longer chain.");
            } else {
                System.out.println("Received invalid chain. Blockchain not updated.");
            }
        } else {
            System.out.println("Received chain is not longer. Blockchain not updated.");
        }
    }

    public boolean validate() throws NoSuchAlgorithmException {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            // Check if the block's hash is valid
            if (!currentBlock.calculateHash().equals(currentBlock.getHash())) {
                System.out.println("Invalid block hash at height " + i);
                return false;
            }

            // Check if the previous block hash is correct
            if (!currentBlock.getPreviousBlockHash().equals(previousBlock.getHash())) {
                System.out.println("Invalid previous block hash at height " + i);
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < chain.size(); i++) {
            Block block = chain.get(i);
            System.out.println("Block Height: " + i);
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Block Hash: " + block.getHash());
            System.out.println("Previous Block Hash: " + block.getPreviousBlockHash());
            System.out.println("Merkle Root Hash: " + block.getMerkleRootHash());
            System.out.println("Transactions: ");
            List<Transaction> transactions = block.getTransactions();
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getTransactionData());
            }
            System.out.println("-----------------------------");
        }
    }
}
