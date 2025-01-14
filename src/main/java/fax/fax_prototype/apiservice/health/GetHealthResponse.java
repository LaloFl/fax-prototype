package fax.fax_prototype.apiservice.health;

public class GetHealthResponse {
    private String status;
    private String applicationName;
    private String version;
    private String environment;
    private String timestamp;

    public GetHealthResponse(String status, String applicationName, String version, String environment,
            String timestamp) {
        this.status = status;
        this.applicationName = applicationName;
        this.version = version;
        this.environment = environment;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
