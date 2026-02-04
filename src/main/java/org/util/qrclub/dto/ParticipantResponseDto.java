package org.util.qrclub.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ParticipantResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private UUID uuid;
}

