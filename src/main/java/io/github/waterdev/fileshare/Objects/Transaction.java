package io.github.waterdev.fileshare.Objects;

public class Transaction {

    public int blockheight;
    public int fee;
    public String hash;
    public boolean isCoinbaseTransaction;
    public String paymentID;
    public int timestamp;
    public int umlockTime;
    Transfers[] transfers;

}
