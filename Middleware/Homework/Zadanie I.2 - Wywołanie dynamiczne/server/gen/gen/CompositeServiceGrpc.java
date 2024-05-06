package gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: composite.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CompositeServiceGrpc {

  private CompositeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "calculator.CompositeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gen.CompositeInput,
      gen.CompositeStreamResult> getGenerateCompositeNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateCompositeNumbers",
      requestType = gen.CompositeInput.class,
      responseType = gen.CompositeStreamResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<gen.CompositeInput,
      gen.CompositeStreamResult> getGenerateCompositeNumbersMethod() {
    io.grpc.MethodDescriptor<gen.CompositeInput, gen.CompositeStreamResult> getGenerateCompositeNumbersMethod;
    if ((getGenerateCompositeNumbersMethod = CompositeServiceGrpc.getGenerateCompositeNumbersMethod) == null) {
      synchronized (CompositeServiceGrpc.class) {
        if ((getGenerateCompositeNumbersMethod = CompositeServiceGrpc.getGenerateCompositeNumbersMethod) == null) {
          CompositeServiceGrpc.getGenerateCompositeNumbersMethod = getGenerateCompositeNumbersMethod =
              io.grpc.MethodDescriptor.<gen.CompositeInput, gen.CompositeStreamResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateCompositeNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gen.CompositeInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gen.CompositeStreamResult.getDefaultInstance()))
              .setSchemaDescriptor(new CompositeServiceMethodDescriptorSupplier("GenerateCompositeNumbers"))
              .build();
        }
      }
    }
    return getGenerateCompositeNumbersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<gen.CompositeInput,
      gen.CompositeResult> getGetCompositeNumbersListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCompositeNumbersList",
      requestType = gen.CompositeInput.class,
      responseType = gen.CompositeResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gen.CompositeInput,
      gen.CompositeResult> getGetCompositeNumbersListMethod() {
    io.grpc.MethodDescriptor<gen.CompositeInput, gen.CompositeResult> getGetCompositeNumbersListMethod;
    if ((getGetCompositeNumbersListMethod = CompositeServiceGrpc.getGetCompositeNumbersListMethod) == null) {
      synchronized (CompositeServiceGrpc.class) {
        if ((getGetCompositeNumbersListMethod = CompositeServiceGrpc.getGetCompositeNumbersListMethod) == null) {
          CompositeServiceGrpc.getGetCompositeNumbersListMethod = getGetCompositeNumbersListMethod =
              io.grpc.MethodDescriptor.<gen.CompositeInput, gen.CompositeResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCompositeNumbersList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gen.CompositeInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gen.CompositeResult.getDefaultInstance()))
              .setSchemaDescriptor(new CompositeServiceMethodDescriptorSupplier("GetCompositeNumbersList"))
              .build();
        }
      }
    }
    return getGetCompositeNumbersListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CompositeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompositeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompositeServiceStub>() {
        @java.lang.Override
        public CompositeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompositeServiceStub(channel, callOptions);
        }
      };
    return CompositeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompositeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompositeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompositeServiceBlockingStub>() {
        @java.lang.Override
        public CompositeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompositeServiceBlockingStub(channel, callOptions);
        }
      };
    return CompositeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CompositeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompositeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompositeServiceFutureStub>() {
        @java.lang.Override
        public CompositeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompositeServiceFutureStub(channel, callOptions);
        }
      };
    return CompositeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void generateCompositeNumbers(gen.CompositeInput request,
        io.grpc.stub.StreamObserver<gen.CompositeStreamResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateCompositeNumbersMethod(), responseObserver);
    }

    /**
     */
    default void getCompositeNumbersList(gen.CompositeInput request,
        io.grpc.stub.StreamObserver<gen.CompositeResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCompositeNumbersListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CompositeService.
   */
  public static abstract class CompositeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CompositeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CompositeService.
   */
  public static final class CompositeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CompositeServiceStub> {
    private CompositeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompositeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompositeServiceStub(channel, callOptions);
    }

    /**
     */
    public void generateCompositeNumbers(gen.CompositeInput request,
        io.grpc.stub.StreamObserver<gen.CompositeStreamResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGenerateCompositeNumbersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCompositeNumbersList(gen.CompositeInput request,
        io.grpc.stub.StreamObserver<gen.CompositeResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCompositeNumbersListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CompositeService.
   */
  public static final class CompositeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CompositeServiceBlockingStub> {
    private CompositeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompositeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompositeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<gen.CompositeStreamResult> generateCompositeNumbers(
        gen.CompositeInput request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGenerateCompositeNumbersMethod(), getCallOptions(), request);
    }

    /**
     */
    public gen.CompositeResult getCompositeNumbersList(gen.CompositeInput request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCompositeNumbersListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CompositeService.
   */
  public static final class CompositeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CompositeServiceFutureStub> {
    private CompositeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompositeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompositeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gen.CompositeResult> getCompositeNumbersList(
        gen.CompositeInput request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCompositeNumbersListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_COMPOSITE_NUMBERS = 0;
  private static final int METHODID_GET_COMPOSITE_NUMBERS_LIST = 1;

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
        case METHODID_GENERATE_COMPOSITE_NUMBERS:
          serviceImpl.generateCompositeNumbers((gen.CompositeInput) request,
              (io.grpc.stub.StreamObserver<gen.CompositeStreamResult>) responseObserver);
          break;
        case METHODID_GET_COMPOSITE_NUMBERS_LIST:
          serviceImpl.getCompositeNumbersList((gen.CompositeInput) request,
              (io.grpc.stub.StreamObserver<gen.CompositeResult>) responseObserver);
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
          getGenerateCompositeNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              gen.CompositeInput,
              gen.CompositeStreamResult>(
                service, METHODID_GENERATE_COMPOSITE_NUMBERS)))
        .addMethod(
          getGetCompositeNumbersListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              gen.CompositeInput,
              gen.CompositeResult>(
                service, METHODID_GET_COMPOSITE_NUMBERS_LIST)))
        .build();
  }

  private static abstract class CompositeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompositeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gen.CompositeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CompositeService");
    }
  }

  private static final class CompositeServiceFileDescriptorSupplier
      extends CompositeServiceBaseDescriptorSupplier {
    CompositeServiceFileDescriptorSupplier() {}
  }

  private static final class CompositeServiceMethodDescriptorSupplier
      extends CompositeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CompositeServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CompositeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CompositeServiceFileDescriptorSupplier())
              .addMethod(getGenerateCompositeNumbersMethod())
              .addMethod(getGetCompositeNumbersListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
