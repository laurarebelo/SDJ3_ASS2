package via.sdj3.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.via.sdj3.iwillunderstandgrpc.HelloRequest;
import java.via.sdj3.iwillunderstandgrpc.HelloResponse;
import java.via.sdj3.iwillunderstandgrpc.HelloServiceGrpc;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getFirstName() + " " + request.getLastName();
        System.out.println("Received name: " + name);

        HelloResponse response = HelloResponse.newBuilder().setGreeting("Hello " + name + ", it's good to hear from you.").build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
