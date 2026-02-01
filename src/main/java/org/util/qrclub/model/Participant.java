package org.util.qrclub.model;

import org.util.qrclub.model.QRCode;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "participants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "patronymic")
    private String patronymic;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private QRCode qrCode;
}

