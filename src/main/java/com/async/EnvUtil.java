package com.async;


import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvUtil {
    @Autowired
    Environment environment;
    private String port;
    private String hostname;

    public EnvUtil() {
    }

    public String getPort() {
        if (this.port == null) {
            this.port = this.environment.getProperty("local.server.port");
        }

        return this.port;
    }

    public Integer getPortAsInt() {
        return Integer.valueOf(this.getPort());
    }

    public String getHostname() throws UnknownHostException {
        if (this.hostname == null) {
            this.hostname = InetAddress.getLocalHost().getHostAddress();
        }

        return this.hostname;
    }

    public String getServerUrlPrefi() throws UnknownHostException {
        return "http://" + this.getHostname() + ":" + this.getPort();
    }
}

