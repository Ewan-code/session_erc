package com.ericsson.session_client;

import com.ericsson.session_client.dto.RequestDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class SessionClientApplication {

    public static void main(String[] args) {
        SessionCreator creator = new SessionCreator();
        creator.creator();
        System.out.println("end");
    }

}
