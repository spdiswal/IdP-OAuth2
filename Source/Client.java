// PLAYLIST MANAGER.

// Hosts HTML page.
// Wants to access protected resources.

import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;

public class Client
{
    private HttpServer server;

    public Client()
    {
        try
        {
            server = HttpServer.create(new InetSocketAddress(8082), 0);

            server.createContext("/test", t ->
            {
                String response = "This is the response";
                t.sendResponseHeaders(200, response.length());
                OutputStream os = t.getResponseBody();
                os.write(response.getBytes());
                os.close();
            });

            server.setExecutor(null);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void start()
    {
        server.start();
    }
}
