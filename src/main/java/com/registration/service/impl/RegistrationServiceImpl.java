package com.registration.service.impl;

import com.registration.entity.Course;
import com.registration.entity.RegistrationDetails;
import com.registration.entity.RegistrationKey;
import com.registration.entity.Semester;
import com.registration.repository.CourseRepository;
import com.registration.repository.RegistrationDetailsRepository;
import com.registration.repository.StudentRepository;
import com.registration.request.RegistrationRequest;
import com.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    RegistrationDetailsRepository registrationDetailsRepository;

    @Autowired
    StudentRepository studentRepository;


    @Override
    public List<Course> getAllCourses(Semester semester) {
        List<Course> result = new ArrayList<>();
        Iterator<Course> courseIterator = courseRepository.findAll().iterator();
        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            if (semester.equals(course.getSemester()))
                result.add(course);
        }
        return result;
    }

    @Override
    public RegistrationDetails register(RegistrationRequest registrationRequest) {
        RegistrationDetails registrationDetails = new RegistrationDetails();
        RegistrationKey registrationKey = new RegistrationKey();
        registrationKey.setSemester(registrationRequest.getSemester());
        registrationKey.setUserId(registrationRequest.getUserId());
        registrationDetails.setRegistrationKey(registrationKey);

        Iterator<Course> courseIterator = courseRepository.findAllById(registrationRequest.getCourseIds()).iterator();
        List<Course> courses = new ArrayList<>();
        while (courseIterator.hasNext()) {
            courses.add(courseIterator.next());
        }

        registrationDetails.setCourses(courses);
        registrationDetails.setCreatedOn(new Date());
        RegistrationDetails registration = registrationDetailsRepository.save(registrationDetails);
        return registration;
    }

    @Override
    public List<RegistrationDetails> getAllRegistrations(Long userId) {
        return studentRepository.findById(userId).get().getRegistrationDetails();
    }
}
