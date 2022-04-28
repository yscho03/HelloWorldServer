import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HelloWorldServer {
	private static final int PORT = 5000;
	private Server server;

	public void start() throws IOException {
		server = ServerBuilder.forPort(PORT).addService(new HelloWorldServiceImpl()).build().start();
	}

	public void blockUntilShutdown() throws InterruptedException {
		if (server == null) {
			return;
		}

		server.awaitTermination();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("start HelloWorldServer...");
		HelloWorldServer server = new HelloWorldServer();
		server.start();
		server.blockUntilShutdown();
	}
}