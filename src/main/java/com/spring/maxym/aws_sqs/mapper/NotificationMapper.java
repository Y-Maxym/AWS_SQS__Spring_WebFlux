package com.spring.maxym.aws_sqs.mapper;

import com.spring.maxym.aws_sqs.dto.NotificationDto;
import com.spring.maxym.aws_sqs.entity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto toDto(NotificationEntity notification);

    @InheritInverseConfiguration
    NotificationEntity toEntity(NotificationDto notification);
}
