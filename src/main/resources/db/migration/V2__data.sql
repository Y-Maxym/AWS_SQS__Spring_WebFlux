CREATE TABLE IF NOT EXISTS recipients
(
    id        VARCHAR(36) PRIMARY KEY DEFAULT uuid_generate_v4(),
    channel   VARCHAR(255) NOT NULL,
    address   VARCHAR(1024),
    full_name VARCHAR(1024)
);

ALTER TABLE notifications ADD CONSTRAINT fk_notifications_recipient_uid
FOREIGN KEY (recipient_uid) REFERENCES recipients(id);