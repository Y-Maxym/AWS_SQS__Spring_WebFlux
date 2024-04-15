package com.spring.maxym.aws_sqs.poller;


import com.spring.maxym.aws_sqs.dto.NotificationDto;
import com.spring.maxym.aws_sqs.entity.NotificationEntity;
import com.spring.maxym.aws_sqs.mapper.NotificationMapper;
import com.spring.maxym.aws_sqs.repository.NotificationRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationsSQSPoller {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMessage(@Payload NotificationDto message) {
        log.info("received notification: {}", message);
        NotificationEntity notification = notificationMapper.toEntity(message);
        notificationRepository.save(notification).subscribe();
    }
}
