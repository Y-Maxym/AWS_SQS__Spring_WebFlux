package com.spring.maxym.aws_sqs.service;

import com.spring.maxym.aws_sqs.dto.RecipientDto;
import com.spring.maxym.aws_sqs.entity.NotificationEntity;
import com.spring.maxym.aws_sqs.entity.RecipientEntity;
import com.spring.maxym.aws_sqs.mapper.RecipientMapper;
import com.spring.maxym.aws_sqs.repository.NotificationRepository;
import com.spring.maxym.aws_sqs.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final RecipientRepository recipientRepository;
    private final NotificationRepository notificationRepository;
    private final RecipientMapper recipientMapper;

    public Mono<RecipientDto> findRecipientWithNotificationsByUid(String uid) {
        return Mono.zip(recipientRepository.findById(uid),
                notificationRepository.findAllByRecipientUid(uid).collectList())
                .map(tuples -> {
                    RecipientEntity recipientEntity = tuples.getT1();
                    List<NotificationEntity> notificationEntity = tuples.getT2();
                    recipientEntity.setNotifications(notificationEntity);
                    return recipientMapper.toDto(recipientEntity);
                });
    }
}
