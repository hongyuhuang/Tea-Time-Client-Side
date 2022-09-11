package web;

import io.jooby.Jooby;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;

public class Server extends Jooby {


	public Server() {
		setServerOptions(new ServerOptions().setPort(8085));

		install(new GsonModule());

		mount(new StaticAssetModule());
	}

	public static void main(String[] args) {
		System.out.println("\nStarting Server.");
		new Server().start();
	}

}
