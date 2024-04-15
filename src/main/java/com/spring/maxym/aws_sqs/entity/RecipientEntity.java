package com.spring.maxym.aws_sqs.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.StringUtils;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table("recipients")
public class RecipientEntity implements Persistable<String> {

    @Id
    private String id;
    @Column("channel")
    private String channel;
    @Column("address")
    private String address;
    @Column("full_name")
    private String fullName;

    @Transient
    @ToString.Exclude
    private List<NotificationEntity> notifications;

    @Override
    public boolean isNew() {
        return !StringUtils.hasText(id);
    }
}
