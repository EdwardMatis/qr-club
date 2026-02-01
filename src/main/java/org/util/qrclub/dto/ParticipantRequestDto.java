package org.util.qrclub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantRequestDto {

    @NotBlank(message = "First name must not be blank")
    @Size(max = 100, message = "First name must be at most 100 characters")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    @Size(max = 100, message = "Last name must be at most 100 characters")
    private String lastName;

    @Size(max = 100, message = "Patronymic must be at most 100 characters")
    private String patronymic;
}


