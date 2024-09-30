package com.deepjyot.job_seeker_service.dto;




public class Service {

    private String name;
    private int port;
    private String hostPort;
    private String uri;
    private String hostPortEnvVariable;

    // Custom Constructor (with custom initialization logic if needed)
    public Service(String name, int port, String hostPort, String uri, String hostPortEnvVariable) {
        this.name = name != null ? name : "Unknown Service";
        this.port = (port > 0) ? port : 8080;  // Default to 8080 if port is invalid
        this.hostPort = hostPort != null ? hostPort : "localhost:8080";
        this.uri = uri != null ? uri : "/";
        this.hostPortEnvVariable = hostPortEnvVariable != null ? hostPortEnvVariable : "HOST_PORT";
    }

    // Custom Getter for 'name'
    public String getName() {
        return name != null ? name : "Unknown Service";
    }

    // Custom Setter for 'name'
    public void setName(String name) {
        this.name = (name != null && !name.trim().isEmpty()) ? name : "Unknown Service";
    }

    // Custom Getter for 'port'
    public int getPort() {
        return port > 0 ? port : 8080;  // Return 8080 if port is not valid
    }

    // Custom Setter for 'port'
    public void setPort(int port) {
        this.port = port > 0 ? port : 8080;  // Set to 8080 if invalid port
    }

    // Custom Getter for 'hostPort'
    public String getHostPort() {
        return hostPort != null ? hostPort : "localhost:8080";  // Default value if null
    }

    // Custom Setter for 'hostPort'
    public void setHostPort(String hostPort) {
        this.hostPort = (hostPort != null && !hostPort.trim().isEmpty()) ? hostPort : "localhost:8080";
    }

    // Custom Getter for 'uri'
    public String getUri() {
        return uri != null ? uri : "/";  // Default value if null
    }

    // Custom Setter for 'uri'
    public void setUri(String uri) {
        this.uri = (uri != null && !uri.trim().isEmpty()) ? uri : "/";
    }

    // Custom Getter for 'hostPortEnvVariable'
    public String getHostPortEnvVariable() {
        return hostPortEnvVariable != null ? hostPortEnvVariable : "HOST_PORT";  // Default value if null
    }

    // Custom Setter for 'hostPortEnvVariable'
    public void setHostPortEnvVariable(String hostPortEnvVariable) {
        this.hostPortEnvVariable = (hostPortEnvVariable != null && !hostPortEnvVariable.trim().isEmpty()) ? hostPortEnvVariable : "HOST_PORT";
    }
}
