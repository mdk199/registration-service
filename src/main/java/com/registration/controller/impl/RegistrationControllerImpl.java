package com.registration.controller.impl;

import com.registration.controller.RegistrationController;
import com.registration.entity.Course;
import com.registration.entity.RegistrationDetails;
import com.registration.entity.Semester;
import com.registration.request.RegistrationRequest;
import com.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegistrationControllerImpl implements RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @Override
    public List<Course> getAllCourses(Semester semester) {
        return registrationService.getAllCourses(semester);
    }

    @Override
    public RegistrationDetails register(RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest);
    }

    @Override
    public List<RegistrationDetails> getAllRegistrations(Long userId) {
        return registrationService.getAllRegistrations(userId);
    }
}
