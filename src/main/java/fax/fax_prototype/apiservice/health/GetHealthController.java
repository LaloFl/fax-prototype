package fax.fax_prototype.apiservice.health;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;

@Controller
public class GetHealthController {
    public GetHealthController() {
    }

    public GetHealthResponse getHealth() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return new GetHealthResponse(
                "ok",
                "fax-prototype",
                "0.0.1",
                "dev",
                timestamp.toString());
    }
}
