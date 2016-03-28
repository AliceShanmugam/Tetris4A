package Interfaces;

import java.net.InetAddress;

public class AccueilResult {

    public boolean solo;
    public String ip;

    public AccueilResult(boolean solo, String ip){
        this.solo = solo;
        this.ip = ip;
    }
}
