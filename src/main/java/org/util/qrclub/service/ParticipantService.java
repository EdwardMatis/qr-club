package org.util.qrclub.service;

import org.util.qrclub.dto.ParticipantRequestDto;
import org.util.qrclub.dto.ParticipantResponseDto;

import java.util.List;

public interface ParticipantService {

    ParticipantResponseDto create(ParticipantRequestDto dto);

    ParticipantResponseDto update(Long id, ParticipantRequestDto dto);

    void delete(Long id);

    ParticipantResponseDto getById(Long id);

    List<ParticipantResponseDto> getAll();
}

