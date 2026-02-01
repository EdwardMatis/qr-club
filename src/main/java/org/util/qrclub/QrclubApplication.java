package org.util.qrclub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.util.qrclub.model.Participant;
import org.util.qrclub.repository.ParticipantRepository;

import java.util.UUID;

@SpringBootApplication
public class QrclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrclubApplication.class, args);
    }


}
