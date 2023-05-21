package kademlia;

import generated.*;
import generated.Kad.TargetOrBuilder;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import auction.User;

import static java.lang.Integer.parseInt;

public class Node {

    private String id;
    private byte[] hashedId;
    private String ip;
    private String port;
    private int failedConns;
    private StreamObserver[] connList;
    private static Set<StreamObserver<User>> observers = ConcurrentHashMap.newKeySet();
    static final int MAX_TRY_CONN_COUNT = 3;

    public String getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public int getFailedConns() {
        return failedConns;
    }

    public byte[] getHashedId(){
        return hashedId;
    }

    public StreamObserver[] getConnList(){
        return connList;
    }

    public Node(String ip, String port) {
        this.id = String.valueOf(Math.random()).substring(2);
        this.hashedId = convertPeerID(this.id);
        this.ip = ip;
        this.port = port;
        this.failedConns = 0;

        try {
            myServer();
        } catch (IOException ioEx) {
            System.out.println("Server start not possible.\n");
            ioEx.printStackTrace();
        } catch (InterruptedException iEx) {
            System.out.println("Server process interrupted\n");
            iEx.printStackTrace();
        }
    }

    public void myServer() throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(parseInt(this.port)).addService(new PingServiceImpl()).build();

        server.start();
    }

    public void ping(String ip, String port) {
        int portInt = parseInt(port);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, portInt).usePlaintext().build();
        PingServiceGrpc.PingServiceBlockingStub stub = PingServiceGrpc.newBlockingStub(channel);

        Kad.NodeInfo thisNode = Kad.NodeInfo.newBuilder()
                .setIp(this.ip)
                .setPort(this.port)
                .build();

        Kad.NodeInfo nodeInfo = stub.ping(
                Kad.Target.newBuilder()
                        .setTargetId(ip)
                        .setSender(thisNode)
                        .build());
        channel.shutdown();
    }

    // ConvertPeerID creates a DHT id by hashing a Peer id
    public final byte[] convertPeerID(String id) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha256");
            byte[] hash = messageDigest.digest(id.getBytes());// transforma a mensagem numa hash em bytes
            return hash;
        } catch (NoSuchAlgorithmException e) {// caso existe não reconheça o algoritmo de hash especificado
            throw new RuntimeException(e);
        }
    }
}
