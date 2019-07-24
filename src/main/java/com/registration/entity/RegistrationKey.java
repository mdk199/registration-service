package com.registration.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public @Data
@EqualsAndHashCode
class RegistrationKey extends AbstractEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "semester")
    @Enumerated(value = EnumType.STRING)
    private Semester semester;
}
