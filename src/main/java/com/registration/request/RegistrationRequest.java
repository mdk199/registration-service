package com.registration.request;

import com.registration.entity.Semester;
import lombok.Data;

import java.util.Set;

public @Data
class RegistrationRequest {
    private Long userId;

    private Semester semester;

    private Set<Long> courseIds;
}
