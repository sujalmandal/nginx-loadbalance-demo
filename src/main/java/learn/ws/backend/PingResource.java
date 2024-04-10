package learn.ws.backend;

import java.util.Map;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/ping")
public class PingResource {

    @GET
    @Path("/{payload}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> ping(@PathParam("payload") String payload) {
        return Map.of("served-by", System.getenv("HOSTNAME"), "reply", payload);
    }
}
