package org.util.qrclub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QRCodeRequestDto {

    @NotNull(message = "UUID must not be null")
    private UUID uuid;
}



