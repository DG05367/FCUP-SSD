package generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: kad.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FindValueServiceGrpc {

  private FindValueServiceGrpc() {}

  public static final String SERVICE_NAME = "kad.FindValueService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.Kad.Target,
      generated.Kad.Nodes> getFindValueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Find_value",
      requestType = generated.Kad.Target.class,
      responseType = generated.Kad.Nodes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.Kad.Target,
      generated.Kad.Nodes> getFindValueMethod() {
    io.grpc.MethodDescriptor<generated.Kad.Target, generated.Kad.Nodes> getFindValueMethod;
    if ((getFindValueMethod = FindValueServiceGrpc.getFindValueMethod) == null) {
      synchronized (FindValueServiceGrpc.class) {
        if ((getFindValueMethod = FindValueServiceGrpc.getFindValueMethod) == null) {
          FindValueServiceGrpc.getFindValueMethod = getFindValueMethod =
              io.grpc.MethodDescriptor.<generated.Kad.Target, generated.Kad.Nodes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Find_value"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Kad.Target.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.Kad.Nodes.getDefaultInstance()))
              .setSchemaDescriptor(new FindValueServiceMethodDescriptorSupplier("Find_value"))
              .build();
        }
      }
    }
    return getFindValueMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FindValueServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindValueServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FindValueServiceStub>() {
        @java.lang.Override
        public FindValueServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FindValueServiceStub(channel, callOptions);
        }
      };
    return FindValueServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FindValueServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindValueServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FindValueServiceBlockingStub>() {
        @java.lang.Override
        public FindValueServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FindValueServiceBlockingStub(channel, callOptions);
        }
      };
    return FindValueServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FindValueServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindValueServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FindValueServiceFutureStub>() {
        @java.lang.Override
        public FindValueServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FindValueServiceFutureStub(channel, callOptions);
        }
      };
    return FindValueServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void findValue(generated.Kad.Target request,
        io.grpc.stub.StreamObserver<generated.Kad.Nodes> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFindValueMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FindValueService.
   */
  public static abstract class FindValueServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FindValueServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FindValueService.
   */
  public static final class FindValueServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FindValueServiceStub> {
    private FindValueServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindValueServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindValueServiceStub(channel, callOptions);
    }

    /**
     */
    public void findValue(generated.Kad.Target request,
        io.grpc.stub.StreamObserver<generated.Kad.Nodes> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindValueMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FindValueService.
   */
  public static final class FindValueServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FindValueServiceBlockingStub> {
    private FindValueServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindValueServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindValueServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public generated.Kad.Nodes findValue(generated.Kad.Target request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindValueMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FindValueService.
   */
  public static final class FindValueServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FindValueServiceFutureStub> {
    private FindValueServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindValueServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindValueServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.Kad.Nodes> findValue(
        generated.Kad.Target request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindValueMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_VALUE = 0;

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
        case METHODID_FIND_VALUE:
          serviceImpl.findValue((generated.Kad.Target) request,
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
          getFindValueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generated.Kad.Target,
              generated.Kad.Nodes>(
                service, METHODID_FIND_VALUE)))
        .build();
  }

  private static abstract class FindValueServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FindValueServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.Kad.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FindValueService");
    }
  }

  private static final class FindValueServiceFileDescriptorSupplier
      extends FindValueServiceBaseDescriptorSupplier {
    FindValueServiceFileDescriptorSupplier() {}
  }

  private static final class FindValueServiceMethodDescriptorSupplier
      extends FindValueServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FindValueServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FindValueServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FindValueServiceFileDescriptorSupplier())
              .addMethod(getFindValueMethod())
              .build();
        }
      }
    }
    return result;
  }
}
