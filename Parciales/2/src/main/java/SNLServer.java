import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class SNLServer {
    private static List<RandomGenerator> randomGenerators;
    private static int indice = 0;
    private static class myHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            InputStream is = t.getRequestBody();

            int respuesta = randomGenerators.get(indice).randomGenerator();
            indice++;
            if (indice == 4) {
                indice = 0;
            }

            t.sendResponseHeaders(200, respuesta);
            OutputStream os = t.getResponseBody();
            os.write(respuesta);
            os.close();
        }
    }
    public static void comenzar() throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        randomGenerators = SNLProcessor.createRandomInstances(RandomGenerator.class, 4);
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8000), 0);
        servidor.createContext("parcial/", new myHandler());
        servidor.setExecutor(null);
        servidor.start();
    }
}
