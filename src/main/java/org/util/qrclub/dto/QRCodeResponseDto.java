package org.util.qrclub.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class QRCodeResponseDto {
    private Long id;
    private UUID uuid;
}

