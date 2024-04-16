package com.spring.maxym.aws_sqs.service;

import com.spring.maxym.aws_sqs.dto.NotificationDto;
import com.spring.maxym.aws_sqs.mapper.NotificationMapper;
import com.spring.maxym.aws_sqs.repository.NotificationRepository;
import com.spring.maxym.aws_sqs.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final NotificationMapper notificationMapper;

    public Mono<NotificationDto> findNotificationByUid(String uid) {
        return notificationRepository.findById(uid)
                .map(notificationMapper::toDto);
    }

    public Mono<NotificationDto> findNotificationWithRecipientByUid(String uid) {
        return notificationRepository.findById(uid)
                .flatMap(notificationEntity -> recipientRepository.findById(notificationEntity.getRecipientUid())
                        .map(recipient -> {
                            notificationEntity.setRecipient(recipient);
                            return notificationEntity;
                        })).map(notificationMapper::toDto);
    }
}
