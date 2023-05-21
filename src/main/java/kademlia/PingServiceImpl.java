package kademlia;

import generated.*;
import generated.Kad;
import io.grpc.*;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;

public class PingServiceImpl extends PingServiceGrpc.PingServiceImplBase{

    @Override
    public void ping(Kad.Target request, StreamObserver<Kad.NodeInfo> responseObserver){
        System.out.println(request);

        System.out.println("Hello there, " + request.getSender().getId());

        Kad.NodeInfo response = Kad.NodeInfo.newBuilder()
                .setId(request.getSender().getId())
                .setIp(request.getSender().getIp())
                .setPort(request.getSender().getPort())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public ServerServiceDefinition bindService() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bindService'");
    }
}
