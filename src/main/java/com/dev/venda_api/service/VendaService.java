package com.dev.venda_api.service;

import com.dev.venda_api.dto.VendaDto;
import com.dev.venda_api.dto.VendaResponseDto;
import com.dev.venda_api.mapper.VendaMapper;
import com.dev.venda_api.model.Audit;
import com.dev.venda_api.model.VendaModel;
import com.dev.venda_api.repository.VendaRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final VendaMapper vendaMapper;
    private static final Logger log = LoggerFactory.getLogger(VendaService.class);

    public VendaService(VendaMapper vendaMapper, VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
        this.vendaMapper = vendaMapper;
    }

    public List<VendaResponseDto> find() {
        return vendaRepository.findAll().stream()
                .map(vendaMapper::toDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<VendaModel> optional = vendaRepository.findById(id);
        return optional.<ResponseEntity<Object>>map(vendaModel ->
                ResponseEntity.status(HttpStatus.OK).body(vendaModel)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado"));
    }

    public ResponseEntity<Object> insert(VendaDto vendaDto) {
        VendaModel vendaModel = vendaMapper.toEntity(vendaDto);
        try {
            vendaRepository.save(vendaModel);
        } catch (ConstraintViolationException e) {
            e.getConstraintViolations().forEach(violation -> {
                System.out.println(violation.getMessage());
                log.error("Erro ao cadastrar cliente", e);
            });
        }
        return ResponseEntity.status(HttpStatus.OK).body("!!!Venda inserida com sucesso!!!");
    }

    public ResponseEntity<Object> update(Long id, VendaDto vendaDto) {
        Optional<VendaModel> optional = vendaRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        }
        VendaModel vendaModel = optional.get();
        BeanUtils.copyProperties(vendaDto, vendaModel);
        vendaRepository.save(vendaModel);
        return ResponseEntity.status(HttpStatus.OK).body("!!!Venda atualizada com sucesso!!!");
    }

    public ResponseEntity<Object> delete(Long id) {
        Optional<VendaModel> optional = vendaRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        }
        vendaRepository.delete(optional.get());
        return ResponseEntity.status(HttpStatus.OK).body("!!!Venda deletada com sucesso!!!");
    }
}
