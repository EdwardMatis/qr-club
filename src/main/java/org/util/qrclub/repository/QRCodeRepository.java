package org.util.qrclub.repository;

import org.util.qrclub.model.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QRCodeRepository extends JpaRepository<QRCode, Long> {
    Optional<QRCode> findByUuid(UUID uuid);
}