package com.spring.maxym.aws_sqs.mapper;

import com.spring.maxym.aws_sqs.dto.RecipientDto;
import com.spring.maxym.aws_sqs.entity.RecipientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientDto toDto(RecipientEntity recipient);

    @InheritInverseConfiguration
    RecipientEntity toEntity(RecipientDto recipient);
}
