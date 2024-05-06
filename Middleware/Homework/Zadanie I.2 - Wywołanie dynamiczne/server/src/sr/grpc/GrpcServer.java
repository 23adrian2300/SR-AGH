package sr.grpc;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;


import java.util.logging.Logger;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

public class GrpcServer
{
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    private io.grpc.Server server;

    private SocketAddress socket;

    private void start() throws IOException
    {
        String address = "127.0.0.5";
        int port = 50051;
        try { socket = new InetSocketAddress(InetAddress.getByName(address), port);	} catch(UnknownHostException ignored) {};

        //You will want to employ flow-control so that the queue doesn't blow up your memory. You can cast StreamObserver to CallStreamObserver to get flow-control API
        server = NettyServerBuilder.forAddress(socket).executor(Executors.newFixedThreadPool(6))
                .addService(ProtoReflectionService.newInstance())
                .addService(new CalculatorImpl())
                .addService(new CompositeImpl())
                .build()
                .start();
        logger.info("Server started, listening on "+ address + ":" + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                logger.info("Shutting down gRPC server...");
                GrpcServer.this.stop();
                logger.info("Server shut down.");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }

}
