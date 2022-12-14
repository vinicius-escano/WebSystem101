package com.websystem.websystem;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


@SpringBootApplication
public class WebsystemApplication {

    public static void main(String[] args) {
        if (!Desktop.isDesktopSupported()) {
            System.out.println("This app needs a desktop manager to run, exiting.");
            System.exit(1);
        }
        new SpringApplicationBuilder(WebsystemApplication.class).headless(false).run(args);
        //SpringApplication.run(WebsystemApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void openBrowserAfterStartup() throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URI("http://localhost:7777"));
    }
}
