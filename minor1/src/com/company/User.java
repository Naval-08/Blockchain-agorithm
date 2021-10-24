package com.company;


import com.google.gson.GsonBuilder;

public class User extends Thread{
        long id;
        BlockChain chain;
        public User(int id , BlockChain chain ){
            this.chain = chain;
            this.id = id;

        }

        public void run(){

            chain.addBlock(new Block( chain.getLength()+1 , "second block" , chain.getLatestBlock().hash));

            if(Thread.currentThread().isInterrupted()) {

                return;
            }



            String blockchainJson1 = new GsonBuilder().setPrettyPrinting().create().toJson(chain.blockchain);

            System.out.println(blockchainJson1);
            System.out.println("Block mined by user"+id);

        }

    }