package org.util.qrclub.repository;

import org.springframework.context.annotation.Bean;
import org.util.qrclub.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
