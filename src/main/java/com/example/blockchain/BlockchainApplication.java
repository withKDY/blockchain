package com.example.blockchain;

public class BlockchainApplication {

	public static void main(String[] args) {
        Block genesisBlock = new Block("FIRST BLOCK", "0");
        System.out.println("FIRST = " + genesisBlock.hash);

        Block secondBlock = new Block("SECOND BLOCK", genesisBlock.hash);
        System.out.println("SECOND = " + secondBlock.hash);

        Block thirdBlock = new Block("THIRD BLOCK", secondBlock.hash);
        System.out.println("THIRD = " + thirdBlock.hash);

	}

}
