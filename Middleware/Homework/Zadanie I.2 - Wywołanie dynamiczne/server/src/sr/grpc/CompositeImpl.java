package sr.grpc;

import gen.*;
import io.grpc.stub.StreamObserver;
import gen.CompositeResult;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static sr.grpc.CompositeNumbers.isComposite;


public class CompositeImpl extends CompositeServiceGrpc.CompositeServiceImplBase {
    Logger logger = Logger.getLogger(GrpcServer.class.getName());

    @Override
    public void generateCompositeNumbers(CompositeInput request, StreamObserver<CompositeStreamResult> responseObserver) {
        try {
            if (request.getMax() < 0) {
                logger.info("generateCompositeNumbers max=" + request.getMax());
                responseObserver.onError(io.grpc.Status.INVALID_ARGUMENT.withDescription("max < 0").asRuntimeException());
                return;
            }
        } catch (Exception e) {
            logger.info("generateCompositeNumbers with no max");
            responseObserver.onError(io.grpc.Status.INVALID_ARGUMENT.withDescription("no max").asRuntimeException());
            return;
        }

        for (long value = 0; value < request.getMax(); value++) {
            if (isComposite(value)) {
                CompositeStreamResult result = CompositeStreamResult.newBuilder().setValue(value).build();
                responseObserver.onNext(result);
            }
        }

        responseObserver.onCompleted();

        logger.info("generateCompositeNumbers ended");
    }


    @Override
    public void getCompositeNumbersList(CompositeInput request, StreamObserver<CompositeResult> responseObserver) {
        try {
            if (request.getMax() < 0) {
                logger.info("getCompositeNumbersList max=" + request.getMax());
                responseObserver.onError(io.grpc.Status.INVALID_ARGUMENT.withDescription("max < 0").asRuntimeException());
                return;
            }
        } catch (Exception e) {
            logger.info("getCompositeNumbersList with no max");
            responseObserver.onError(io.grpc.Status.INVALID_ARGUMENT.withDescription("no max").asRuntimeException());
            return;
        }

        List<Long> compositeNumbers = new ArrayList<>();

        for (long value = 0; value < request.getMax(); value++) {
            if (isComposite(value)) {
                compositeNumbers.add(value);
            }
        }

        CompositeResult compositesResult = CompositeResult.newBuilder().addAllComposites(compositeNumbers).build();
        responseObserver.onNext(compositesResult);
        responseObserver.onCompleted();

        logger.info("getCompositeNumbersList ended");
    }

}
