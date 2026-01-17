package com.dev.venda_api.dto;

import jakarta.validation.constraints.NotNull;

public record VendaDto(

        @NotNull(message = "O campo 'nameProduct' não pode ser vazio. Por favor, forneça um valor válido.")
        String nameProduct

) {
}
