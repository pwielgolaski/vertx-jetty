
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientOptions;

public class Client {

    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {

        Vertx.vertx().createHttpClient(new HttpClientOptions().setSsl(true).setTrustAll(true)).getNow(4443, "localhost", "/", resp -> {
            System.out.println("Got response " + resp.statusCode());
            resp.bodyHandler(body -> System.out.println("Got data " + body.toString("ISO-8859-1")));
        });
    }
}
