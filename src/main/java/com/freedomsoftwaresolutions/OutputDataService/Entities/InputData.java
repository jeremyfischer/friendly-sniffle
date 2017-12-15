package com.freedomsoftwaresolutions.OutputDataService.Entities;

import java.net.InetAddress;

public final class InputData {
    private final String zip;
    private final InetAddress ip;
    public InputData(String zip, InetAddress ip) {
        this.zip = zip;
        this.ip = ip;
    }

    public String getZip() {
        return zip;
    }

    public InetAddress getIp() {
        return ip;
    }
}
