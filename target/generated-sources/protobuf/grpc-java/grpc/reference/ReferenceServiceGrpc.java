package grpc.reference;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: reference.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReferenceServiceGrpc {

  private ReferenceServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ReferenceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.reference.PolicyTypeRequest,
      grpc.reference.PolicyTypeResponse> getResolvePolicyTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResolvePolicyType",
      requestType = grpc.reference.PolicyTypeRequest.class,
      responseType = grpc.reference.PolicyTypeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.reference.PolicyTypeRequest,
      grpc.reference.PolicyTypeResponse> getResolvePolicyTypeMethod() {
    io.grpc.MethodDescriptor<grpc.reference.PolicyTypeRequest, grpc.reference.PolicyTypeResponse> getResolvePolicyTypeMethod;
    if ((getResolvePolicyTypeMethod = ReferenceServiceGrpc.getResolvePolicyTypeMethod) == null) {
      synchronized (ReferenceServiceGrpc.class) {
        if ((getResolvePolicyTypeMethod = ReferenceServiceGrpc.getResolvePolicyTypeMethod) == null) {
          ReferenceServiceGrpc.getResolvePolicyTypeMethod = getResolvePolicyTypeMethod =
              io.grpc.MethodDescriptor.<grpc.reference.PolicyTypeRequest, grpc.reference.PolicyTypeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResolvePolicyType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.PolicyTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.PolicyTypeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReferenceServiceMethodDescriptorSupplier("ResolvePolicyType"))
              .build();
        }
      }
    }
    return getResolvePolicyTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.reference.CustomerValidationRequest,
      grpc.reference.ValidationResponse> getValidateCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateCustomer",
      requestType = grpc.reference.CustomerValidationRequest.class,
      responseType = grpc.reference.ValidationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.reference.CustomerValidationRequest,
      grpc.reference.ValidationResponse> getValidateCustomerMethod() {
    io.grpc.MethodDescriptor<grpc.reference.CustomerValidationRequest, grpc.reference.ValidationResponse> getValidateCustomerMethod;
    if ((getValidateCustomerMethod = ReferenceServiceGrpc.getValidateCustomerMethod) == null) {
      synchronized (ReferenceServiceGrpc.class) {
        if ((getValidateCustomerMethod = ReferenceServiceGrpc.getValidateCustomerMethod) == null) {
          ReferenceServiceGrpc.getValidateCustomerMethod = getValidateCustomerMethod =
              io.grpc.MethodDescriptor.<grpc.reference.CustomerValidationRequest, grpc.reference.ValidationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.CustomerValidationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.ValidationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReferenceServiceMethodDescriptorSupplier("ValidateCustomer"))
              .build();
        }
      }
    }
    return getValidateCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.reference.DamageValidationRequest,
      grpc.reference.ValidationResponse> getValidateDamageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateDamage",
      requestType = grpc.reference.DamageValidationRequest.class,
      responseType = grpc.reference.ValidationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.reference.DamageValidationRequest,
      grpc.reference.ValidationResponse> getValidateDamageMethod() {
    io.grpc.MethodDescriptor<grpc.reference.DamageValidationRequest, grpc.reference.ValidationResponse> getValidateDamageMethod;
    if ((getValidateDamageMethod = ReferenceServiceGrpc.getValidateDamageMethod) == null) {
      synchronized (ReferenceServiceGrpc.class) {
        if ((getValidateDamageMethod = ReferenceServiceGrpc.getValidateDamageMethod) == null) {
          ReferenceServiceGrpc.getValidateDamageMethod = getValidateDamageMethod =
              io.grpc.MethodDescriptor.<grpc.reference.DamageValidationRequest, grpc.reference.ValidationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateDamage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.DamageValidationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.ValidationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReferenceServiceMethodDescriptorSupplier("ValidateDamage"))
              .build();
        }
      }
    }
    return getValidateDamageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.reference.PremiumRequest,
      grpc.reference.PremiumResponse> getCalculatePremiumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculatePremium",
      requestType = grpc.reference.PremiumRequest.class,
      responseType = grpc.reference.PremiumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.reference.PremiumRequest,
      grpc.reference.PremiumResponse> getCalculatePremiumMethod() {
    io.grpc.MethodDescriptor<grpc.reference.PremiumRequest, grpc.reference.PremiumResponse> getCalculatePremiumMethod;
    if ((getCalculatePremiumMethod = ReferenceServiceGrpc.getCalculatePremiumMethod) == null) {
      synchronized (ReferenceServiceGrpc.class) {
        if ((getCalculatePremiumMethod = ReferenceServiceGrpc.getCalculatePremiumMethod) == null) {
          ReferenceServiceGrpc.getCalculatePremiumMethod = getCalculatePremiumMethod =
              io.grpc.MethodDescriptor.<grpc.reference.PremiumRequest, grpc.reference.PremiumResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CalculatePremium"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.PremiumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.PremiumResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReferenceServiceMethodDescriptorSupplier("CalculatePremium"))
              .build();
        }
      }
    }
    return getCalculatePremiumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.reference.PayoutValidationRequest,
      grpc.reference.ValidationResponse> getValidatePayoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidatePayout",
      requestType = grpc.reference.PayoutValidationRequest.class,
      responseType = grpc.reference.ValidationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.reference.PayoutValidationRequest,
      grpc.reference.ValidationResponse> getValidatePayoutMethod() {
    io.grpc.MethodDescriptor<grpc.reference.PayoutValidationRequest, grpc.reference.ValidationResponse> getValidatePayoutMethod;
    if ((getValidatePayoutMethod = ReferenceServiceGrpc.getValidatePayoutMethod) == null) {
      synchronized (ReferenceServiceGrpc.class) {
        if ((getValidatePayoutMethod = ReferenceServiceGrpc.getValidatePayoutMethod) == null) {
          ReferenceServiceGrpc.getValidatePayoutMethod = getValidatePayoutMethod =
              io.grpc.MethodDescriptor.<grpc.reference.PayoutValidationRequest, grpc.reference.ValidationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidatePayout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.PayoutValidationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.ValidationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReferenceServiceMethodDescriptorSupplier("ValidatePayout"))
              .build();
        }
      }
    }
    return getValidatePayoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.reference.NumberRequest,
      grpc.reference.NumberResponse> getGenerateNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateNumber",
      requestType = grpc.reference.NumberRequest.class,
      responseType = grpc.reference.NumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.reference.NumberRequest,
      grpc.reference.NumberResponse> getGenerateNumberMethod() {
    io.grpc.MethodDescriptor<grpc.reference.NumberRequest, grpc.reference.NumberResponse> getGenerateNumberMethod;
    if ((getGenerateNumberMethod = ReferenceServiceGrpc.getGenerateNumberMethod) == null) {
      synchronized (ReferenceServiceGrpc.class) {
        if ((getGenerateNumberMethod = ReferenceServiceGrpc.getGenerateNumberMethod) == null) {
          ReferenceServiceGrpc.getGenerateNumberMethod = getGenerateNumberMethod =
              io.grpc.MethodDescriptor.<grpc.reference.NumberRequest, grpc.reference.NumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.NumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.reference.NumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReferenceServiceMethodDescriptorSupplier("GenerateNumber"))
              .build();
        }
      }
    }
    return getGenerateNumberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReferenceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReferenceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReferenceServiceStub>() {
        @java.lang.Override
        public ReferenceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReferenceServiceStub(channel, callOptions);
        }
      };
    return ReferenceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReferenceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReferenceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReferenceServiceBlockingStub>() {
        @java.lang.Override
        public ReferenceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReferenceServiceBlockingStub(channel, callOptions);
        }
      };
    return ReferenceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReferenceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReferenceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReferenceServiceFutureStub>() {
        @java.lang.Override
        public ReferenceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReferenceServiceFutureStub(channel, callOptions);
        }
      };
    return ReferenceServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void resolvePolicyType(grpc.reference.PolicyTypeRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.PolicyTypeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResolvePolicyTypeMethod(), responseObserver);
    }

    /**
     */
    default void validateCustomer(grpc.reference.CustomerValidationRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.ValidationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateCustomerMethod(), responseObserver);
    }

    /**
     */
    default void validateDamage(grpc.reference.DamageValidationRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.ValidationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateDamageMethod(), responseObserver);
    }

    /**
     */
    default void calculatePremium(grpc.reference.PremiumRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.PremiumResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCalculatePremiumMethod(), responseObserver);
    }

    /**
     */
    default void validatePayout(grpc.reference.PayoutValidationRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.ValidationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidatePayoutMethod(), responseObserver);
    }

    /**
     */
    default void generateNumber(grpc.reference.NumberRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.NumberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateNumberMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReferenceService.
   */
  public static abstract class ReferenceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReferenceServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReferenceService.
   */
  public static final class ReferenceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReferenceServiceStub> {
    private ReferenceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReferenceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReferenceServiceStub(channel, callOptions);
    }

    /**
     */
    public void resolvePolicyType(grpc.reference.PolicyTypeRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.PolicyTypeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResolvePolicyTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateCustomer(grpc.reference.CustomerValidationRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.ValidationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateDamage(grpc.reference.DamageValidationRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.ValidationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateDamageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void calculatePremium(grpc.reference.PremiumRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.PremiumResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCalculatePremiumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validatePayout(grpc.reference.PayoutValidationRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.ValidationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidatePayoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void generateNumber(grpc.reference.NumberRequest request,
        io.grpc.stub.StreamObserver<grpc.reference.NumberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateNumberMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReferenceService.
   */
  public static final class ReferenceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReferenceServiceBlockingStub> {
    private ReferenceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReferenceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReferenceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.reference.PolicyTypeResponse resolvePolicyType(grpc.reference.PolicyTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResolvePolicyTypeMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.reference.ValidationResponse validateCustomer(grpc.reference.CustomerValidationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.reference.ValidationResponse validateDamage(grpc.reference.DamageValidationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateDamageMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.reference.PremiumResponse calculatePremium(grpc.reference.PremiumRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculatePremiumMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.reference.ValidationResponse validatePayout(grpc.reference.PayoutValidationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidatePayoutMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.reference.NumberResponse generateNumber(grpc.reference.NumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateNumberMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReferenceService.
   */
  public static final class ReferenceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReferenceServiceFutureStub> {
    private ReferenceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReferenceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReferenceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.reference.PolicyTypeResponse> resolvePolicyType(
        grpc.reference.PolicyTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResolvePolicyTypeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.reference.ValidationResponse> validateCustomer(
        grpc.reference.CustomerValidationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.reference.ValidationResponse> validateDamage(
        grpc.reference.DamageValidationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateDamageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.reference.PremiumResponse> calculatePremium(
        grpc.reference.PremiumRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCalculatePremiumMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.reference.ValidationResponse> validatePayout(
        grpc.reference.PayoutValidationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidatePayoutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.reference.NumberResponse> generateNumber(
        grpc.reference.NumberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateNumberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RESOLVE_POLICY_TYPE = 0;
  private static final int METHODID_VALIDATE_CUSTOMER = 1;
  private static final int METHODID_VALIDATE_DAMAGE = 2;
  private static final int METHODID_CALCULATE_PREMIUM = 3;
  private static final int METHODID_VALIDATE_PAYOUT = 4;
  private static final int METHODID_GENERATE_NUMBER = 5;

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
        case METHODID_RESOLVE_POLICY_TYPE:
          serviceImpl.resolvePolicyType((grpc.reference.PolicyTypeRequest) request,
              (io.grpc.stub.StreamObserver<grpc.reference.PolicyTypeResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_CUSTOMER:
          serviceImpl.validateCustomer((grpc.reference.CustomerValidationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.reference.ValidationResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_DAMAGE:
          serviceImpl.validateDamage((grpc.reference.DamageValidationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.reference.ValidationResponse>) responseObserver);
          break;
        case METHODID_CALCULATE_PREMIUM:
          serviceImpl.calculatePremium((grpc.reference.PremiumRequest) request,
              (io.grpc.stub.StreamObserver<grpc.reference.PremiumResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_PAYOUT:
          serviceImpl.validatePayout((grpc.reference.PayoutValidationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.reference.ValidationResponse>) responseObserver);
          break;
        case METHODID_GENERATE_NUMBER:
          serviceImpl.generateNumber((grpc.reference.NumberRequest) request,
              (io.grpc.stub.StreamObserver<grpc.reference.NumberResponse>) responseObserver);
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
          getResolvePolicyTypeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.reference.PolicyTypeRequest,
              grpc.reference.PolicyTypeResponse>(
                service, METHODID_RESOLVE_POLICY_TYPE)))
        .addMethod(
          getValidateCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.reference.CustomerValidationRequest,
              grpc.reference.ValidationResponse>(
                service, METHODID_VALIDATE_CUSTOMER)))
        .addMethod(
          getValidateDamageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.reference.DamageValidationRequest,
              grpc.reference.ValidationResponse>(
                service, METHODID_VALIDATE_DAMAGE)))
        .addMethod(
          getCalculatePremiumMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.reference.PremiumRequest,
              grpc.reference.PremiumResponse>(
                service, METHODID_CALCULATE_PREMIUM)))
        .addMethod(
          getValidatePayoutMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.reference.PayoutValidationRequest,
              grpc.reference.ValidationResponse>(
                service, METHODID_VALIDATE_PAYOUT)))
        .addMethod(
          getGenerateNumberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              grpc.reference.NumberRequest,
              grpc.reference.NumberResponse>(
                service, METHODID_GENERATE_NUMBER)))
        .build();
  }

  private static abstract class ReferenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReferenceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.reference.Reference.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReferenceService");
    }
  }

  private static final class ReferenceServiceFileDescriptorSupplier
      extends ReferenceServiceBaseDescriptorSupplier {
    ReferenceServiceFileDescriptorSupplier() {}
  }

  private static final class ReferenceServiceMethodDescriptorSupplier
      extends ReferenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReferenceServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReferenceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReferenceServiceFileDescriptorSupplier())
              .addMethod(getResolvePolicyTypeMethod())
              .addMethod(getValidateCustomerMethod())
              .addMethod(getValidateDamageMethod())
              .addMethod(getCalculatePremiumMethod())
              .addMethod(getValidatePayoutMethod())
              .addMethod(getGenerateNumberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
