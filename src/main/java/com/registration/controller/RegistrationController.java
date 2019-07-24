package com.registration.controller;

import com.registration.entity.Course;
import com.registration.entity.RegistrationDetails;
import com.registration.entity.Semester;
import com.registration.request.RegistrationRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/registration-service")
public interface RegistrationController {

    @GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Course> getAllCourses(@RequestParam(name = "semester") Semester semester);

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    RegistrationDetails register(@RequestBody RegistrationRequest registrationRequest);

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RegistrationDetails> getAllRegistrations(@PathVariable Long userId);
}
