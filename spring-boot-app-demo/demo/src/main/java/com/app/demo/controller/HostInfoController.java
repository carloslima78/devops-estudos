package com.app.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/hostinfo")
public class HostInfoController {

    @GetMapping("/")
    public String get() {

        String ipAddress = "";
        String hostName = "";

        try {

            InetAddress inetAddress = InetAddress.getLocalHost();
            ipAddress = inetAddress.getHostAddress();
            hostName = inetAddress.getHostName();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        StringBuilder hostInfo = new StringBuilder();
        hostInfo.append("Dados da máquina de execução da aplicação" + "<br><br>");
        hostInfo.append("- IP: " + ipAddress + "<br>");
        hostInfo.append("- Host: " + hostName);

        return hostInfo.toString();
    }
}
