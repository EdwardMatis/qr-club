package org.util.qrclub.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.util.qrclub.dto.ParticipantRequestDto;
import org.util.qrclub.dto.ParticipantResponseDto;
import org.util.qrclub.exception.ParticipantNotFoundException;
import org.util.qrclub.mapper.ParticipantMapper;
import org.util.qrclub.model.Participant;
import org.util.qrclub.model.QRCode;
import org.util.qrclub.repository.ParticipantRepository;
import org.util.qrclub.service.ParticipantService;

import java.util.List;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;

    public ParticipantServiceImpl(
            ParticipantRepository participantRepository,
            ParticipantMapper participantMapper
    ) {
        this.participantRepository = participantRepository;
        this.participantMapper = participantMapper;
    }

    @Override
    public ParticipantResponseDto create(ParticipantRequestDto dto) {
        Participant participant = participantMapper.toEntity(dto);

        QRCode qrCode = new QRCode();
        qrCode.refreshUuid();
        qrCode.setParticipant(participant);

        participant.setQrCode(qrCode);

        Participant saved = participantRepository.save(participant);
        return participantMapper.toResponse(saved);
    }

    @Override
    public ParticipantResponseDto update(Long id, ParticipantRequestDto dto) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));

        participantMapper.updateEntity(dto, participant);

        return participantMapper.toResponse(participant);
    }

    @Override
    public void delete(Long id) {
        if (!participantRepository.existsById(id)) {
            throw new ParticipantNotFoundException(id);
        }
        participantRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ParticipantResponseDto getById(Long id) {
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new ParticipantNotFoundException(id));

        return participantMapper.toResponse(participant);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ParticipantResponseDto> getAll() {
        return participantRepository.findAll().stream()
                .map(participantMapper::toResponse)
                .toList();
    }

}
