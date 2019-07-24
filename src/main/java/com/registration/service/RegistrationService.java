package com.registration.service;

import com.registration.entity.Course;
import com.registration.entity.RegistrationDetails;
import com.registration.entity.Semester;
import com.registration.request.RegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RegistrationService {

    List<Course> getAllCourses(Semester semester);

    RegistrationDetails register(RegistrationRequest registrationRequest);

    List<RegistrationDetails> getAllRegistrations(Long userId);
}
