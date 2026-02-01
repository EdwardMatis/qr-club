package org.util.qrclub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "qr_codes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID uuid;

    @OneToOne
    @JoinColumn(name = "participant_id", nullable = false, unique = true)
    private Participant participant;

    public void refreshUuid() {
        this.uuid = UUID.randomUUID();
    }
}
