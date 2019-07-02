package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import services.AccountService;
import servlets.SignInServlet;
import servlets.SignUpServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();

        SignInServlet signIn = new SignInServlet(accountService);
        SignUpServlet signUp = new SignUpServlet(accountService);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet(new ServletHolder(signIn), "/signin");
        handler.addServlet(new ServletHolder(signUp), "/signup");

        Server server = new Server(8080);
        server.setHandler(handler);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();

    }
}
