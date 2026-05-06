package app_grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class ServiceBMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090)
                .addService(new ReferenceServiceImpl())
                .build();

        server.start();
        System.out.println("!!! Сервис обслуживания запущен на порту 9090 !!!");
        server.awaitTermination();
    }
}