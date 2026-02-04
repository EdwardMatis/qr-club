package org.util.qrclub.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.util.qrclub.dto.*;
import org.util.qrclub.service.ParticipantService;
import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping
    public ParticipantResponseDto create(
            @RequestBody @Valid ParticipantRequestDto dto
    ) {
        return participantService.create(dto);
    }

    @PutMapping("/{id}")
    public ParticipantResponseDto update(
            @PathVariable Long id,
            @RequestBody @Valid ParticipantRequestDto dto
    ) {
        return participantService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        participantService.delete(id);
    }

    @GetMapping("/{id}")
    public ParticipantResponseDto getById(@PathVariable Long id) {
        return participantService.getById(id);
    }

    @GetMapping
    public List<ParticipantResponseDto> getAll() {
        return participantService.getAll();
    }
}

