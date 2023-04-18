package com.example.blockchain;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class BlockchainApplication {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 5;

	public static void main(String[] args) {

        blockchain.add(new Block("FIRST BLOCK", "0"));
        System.out.println("FIRST block TRY...");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("SECOND BLOCK", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("SECOND block TRY...");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("THIRD BLOCK", blockchain.get(blockchain.size() - 1).hash));
        System.out.println("THIRD block TRY...");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("\nBLOCK CHAIN VALUE : " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\n block chain : ");
        System.out.println(blockchainJson);
    }

    //블록체인 무결성 검사
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("불일치");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("현재 해쉬 이전 해쉬 불일치");
                return false;
            }
        }
        // 동일
        return true;
    }
}
