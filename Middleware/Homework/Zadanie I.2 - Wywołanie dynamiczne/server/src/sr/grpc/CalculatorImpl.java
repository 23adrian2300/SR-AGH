package sr.grpc;


import gen.ArithmeticOperationArguments;
import gen.ArithmeticOperationResult;
import gen.CalculatorGrpc.CalculatorImplBase;
import gen.CompositeTesterArguments;
import gen.CompositeTesterResult;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.logging.Logger;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static sr.grpc.CompositeNumbers.isComposite;


public class CalculatorImpl extends CalculatorImplBase {

    Logger logger = Logger.getLogger(CalculatorImpl.class.getName());
    private double inf = Double.POSITIVE_INFINITY;

    @Override
    public void operation(ArithmeticOperationArguments request, StreamObserver<ArithmeticOperationResult> responseObserver) {
        logger.info("Request received from client:\n" + request);

        double result = inf;
        switch (request.getOperationtype()) {
            case ADD:
                List<Double> args1 = request.getArgumentsList();
                for (Double value : args1) {
                    result += value;
                }
                break;
            case MIN:
                List<Double> args2 = request.getArgumentsList();
                result = Double.MAX_VALUE;
                for (Double aDouble : args2) {
                    result = min(result, aDouble);
                }
                break;
            case MAX:
                List<Double> args3 = request.getArgumentsList();
                for (Double aDouble : args3) {
                    result = max(result, aDouble);
                }
                break;
            case AVG:
                List<Double> args4 = request.getArgumentsList();
                for (Double aDouble : args4) {
                    result += aDouble;
                }
                if (!args4.isEmpty()) {
                    result = result / args4.size();
                } else {
                    result = 0;
                }
                break;
            case UNRECOGNIZED:
                logger.info("Unrecognized operation type");
                break;
            default:
                logger.info("Failed!");
                break;
        }
        ArithmeticOperationResult res = ArithmeticOperationResult.newBuilder().setResult(result).build();

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }


    @Override
    public void compositeTester(CompositeTesterArguments request, StreamObserver<CompositeTesterResult> responseObserver) {
        logger.info("Request received from client:\n" + request);

        long val = request.getNumber();
        boolean isComposite = isComposite(val);
        String answer = "";

        if (!isComposite) {
            answer = "No";
        } else if (isComposite) {
            answer = "Yes";
        } else {
            answer = "Error";
        }

        CompositeTesterResult res = CompositeTesterResult.newBuilder().setIsComposite(answer).build();
        logger.info("Response sent to client:\n" + res);

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

}
