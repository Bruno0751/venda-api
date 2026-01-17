package com.dev.venda_api.api;

import com.dev.venda_api.dto.VendaDto;
import com.dev.venda_api.dto.VendaResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Vendas"})
@RequestMapping("/v1/vendas")
public interface VendaApi {

    @ApiOperation(value = "Buscar vendas", notes = "Retorno todos as vendas cadastrados.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    List<VendaResponseDto> find();

    @ApiOperation(value = "Buscar uma venda por ID", notes = "Forneça um ID válido para obter os detalhes da veda.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> findById(@PathVariable(value = "id") Long id);

    @ApiOperation(value = "Cadastrar venda", notes = "Forneça dados válido para cadastrar venda.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Object> insert(@RequestBody @Valid VendaDto vendaDto);

    @ApiOperation(value = "Atualizar venda", notes = "Forneça um ID válido e seus dados atualizados para atualizar a venda.")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "{id}")
    ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                  @RequestBody @Valid VendaDto vendaDto);

    @ApiOperation(value = "Deletar venda", notes = "Forneça um ID válido para deletar venda.")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "{id}")
    ResponseEntity<Object> delete(@PathVariable(value = "id") Long id);
}
