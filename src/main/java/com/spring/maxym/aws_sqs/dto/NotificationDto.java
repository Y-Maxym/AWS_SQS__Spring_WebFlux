package com.spring.maxym.aws_sqs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record NotificationDto(String id,
                              String subject,
                              String text,
                              String recipientUid,
                              RecipientDto recipient) {
}
