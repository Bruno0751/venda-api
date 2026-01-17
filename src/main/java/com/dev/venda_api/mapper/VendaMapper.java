package com.dev.venda_api.mapper;

import com.dev.venda_api.dto.VendaDto;
import com.dev.venda_api.dto.VendaResponseDto;
import com.dev.venda_api.model.Audit;
import com.dev.venda_api.model.VendaModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VendaMapper {

    @Mapping(source = "id", target = "idVenda", qualifiedByName = "leftPad3")
    VendaResponseDto toDto(VendaModel vendaModel);

    VendaModel toEntity(VendaDto vendaDto);

    @AfterMapping
    default void addAudit(@MappingTarget VendaModel vendaModel) {
        if (vendaModel.getIdAudit() == null) {
            vendaModel.setIdAudit(new Audit());
        }
    }

    @Named("leftPad3")
    default String leftPad3(Long id) {
        if (id == null) {
            return null;
        }
        return String.format("%04d", id);
    }

}
