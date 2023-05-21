package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: kad.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FindNodeServiceGrpc {

  private FindNodeServiceGrpc() {}

  public static final String SERVICE_NAME = "kad.FindNodeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.Kad.Target,
      generated.Kad.Nodes> getFindNodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindNode",
      requestType = generated.Kad.Target.class,
      responseType = generated.Kad.Nodes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.Kad.Target,
      generated.Kad.Nodes> getFindNodeMethod() {
    io.grpc.MethodDescriptor<generated.Kad.Target, generated.Kad.Nodes> getFindNodeMethod;
    if ((getFindNodeMethod = FindNodeServiceGrpc.getFindNodeMethod) == null) {
      synchronized (FindNodeServiceGrpc.class) {
        if ((getFindNodeMethod = FindNodeServiceGrpc.getFindNodeMethod) == null) {
          FindNodeServiceGrpc.getFindNodeMethod = getFindNodeMethod =
              io.grpc.MethodDescriptor.<generated.Kad.Target, generated.Kad.Nodes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindNode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Kad.Target.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Kad.Nodes.getDefaultInstance()))
              .setSchemaDescriptor(new FindNodeServiceMethodDescriptorSupplier("FindNode"))
              .build();
        }
      }
    }
    return getFindNodeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FindNodeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindNodeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FindNodeServiceStub>() {
        @java.lang.Override
        public FindNodeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FindNodeServiceStub(channel, callOptions);
        }
      };
    return FindNodeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FindNodeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindNodeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FindNodeServiceBlockingStub>() {
        @java.lang.Override
        public FindNodeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FindNodeServiceBlockingStub(channel, callOptions);
        }
      };
    return FindNodeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FindNodeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindNodeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FindNodeServiceFutureStub>() {
        @java.lang.Override
        public FindNodeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FindNodeServiceFutureStub(channel, callOptions);
        }
      };
    return FindNodeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void findNode(generated.Kad.Target request,
        io.grpc.stub.StreamObserver<generated.Kad.Nodes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindNodeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FindNodeService.
   */
  public static abstract class FindNodeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FindNodeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FindNodeService.
   */
  public static final class FindNodeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FindNodeServiceStub> {
    private FindNodeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindNodeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindNodeServiceStub(channel, callOptions);
    }

    /**
     */
    public void findNode(generated.Kad.Target request,
        io.grpc.stub.StreamObserver<generated.Kad.Nodes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindNodeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FindNodeService.
   */
  public static final class FindNodeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FindNodeServiceBlockingStub> {
    private FindNodeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindNodeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindNodeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.Kad.Nodes findNode(generated.Kad.Target request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindNodeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FindNodeService.
   */
  public static final class FindNodeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FindNodeServiceFutureStub> {
    private FindNodeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindNodeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindNodeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Kad.Nodes> findNode(
        generated.Kad.Target request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindNodeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_NODE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_NODE:
          serviceImpl.findNode((generated.Kad.Target) request,
              (io.grpc.stub.StreamObserver<generated.Kad.Nodes>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getFindNodeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.Kad.Target,
              generated.Kad.Nodes>(
                service, METHODID_FIND_NODE)))
        .build();
  }

  private static abstract class FindNodeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FindNodeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.Kad.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FindNodeService");
    }
  }

  private static final class FindNodeServiceFileDescriptorSupplier
      extends FindNodeServiceBaseDescriptorSupplier {
    FindNodeServiceFileDescriptorSupplier() {}
  }

  private static final class FindNodeServiceMethodDescriptorSupplier
      extends FindNodeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FindNodeServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FindNodeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FindNodeServiceFileDescriptorSupplier())
              .addMethod(getFindNodeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
