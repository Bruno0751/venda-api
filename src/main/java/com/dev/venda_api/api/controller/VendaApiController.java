package com.dev.venda_api.api.controller;

import com.dev.venda_api.api.VendaApi;
import com.dev.venda_api.dto.VendaDto;
import com.dev.venda_api.dto.VendaResponseDto;
import com.dev.venda_api.service.VendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class VendaApiController implements VendaApi {

    final VendaService vendaService;

    public VendaApiController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @Override
    public List<VendaResponseDto> find() {
        return vendaService.find();
    }

    @Override
    public ResponseEntity<Object> findById(Long id) {
        return vendaService.findById(id);
    }

    @Override
    public ResponseEntity<Object> insert(VendaDto vendaDto) {
        return vendaService.insert(vendaDto);
    }

    @Override
    public ResponseEntity<Object> update(Long id, VendaDto vendaDto) {
        return vendaService.update(id, vendaDto);
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        return vendaService.delete(id);
    }
}
