package org.util.qrclub.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.util.qrclub.dto.ParticipantRequestDto;
import org.util.qrclub.dto.ParticipantResponseDto;
import org.util.qrclub.exception.ParticipantNotFoundException;
import org.util.qrclub.mapper.ParticipantMapper;
import org.util.qrclub.model.ParticipantEntity;
import org.util.qrclub.model.QRCodeEntity;
import org.util.qrclub.repository.ParticipantRepository;
import org.util.qrclub.service.ParticipantService;
import org.util.qrclub.service.QRCodeService;

import java.util.List;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;
    private final QRCodeService qrCodeService;

    public ParticipantServiceImpl(
            ParticipantRepository participantRepository,
            ParticipantMapper participantMapper, QRCodeService qrCodeService
    ) {
        this.participantRepository = participantRepository;
        this.participantMapper = participantMapper;
        this.qrCodeService = qrCodeService;
    }

    @Override
    public ParticipantResponseDto create(ParticipantRequestDto dto) {
        ParticipantEntity participant = participantMapper.toEntity(dto);

        QRCodeEntity qrCode = new QRCodeEntity();
        qrCodeService.refreshUuid(qrCode);
        qrCode.setParticipant(participant);

        participant.setQrCode(qrCode);

        ParticipantEntity saved = participantRepository.save(participant);
        return participantMapper.toResponse(saved);
    }

    @Override
    public ParticipantResponseDto update(Long id, ParticipantRequestDto dto) {
        ParticipantEntity participant = participantRepository.findById(id)
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
        ParticipantEntity participant = participantRepository.findById(id)
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
