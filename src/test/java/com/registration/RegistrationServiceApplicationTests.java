package com.registration;

import com.registration.controller.impl.RegistrationControllerImpl;
import com.registration.entity.Course;
import com.registration.entity.Semester;
import com.registration.service.RegistrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationControllerImpl.class)
public class RegistrationServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistrationService registrationService;

    @Test
    public void testGetAllCoursesForSemester() throws Exception{
        Course A = new Course();
        A.setId(1L);
        A.setDescription("D1");
        A.setName("A");
        A.setSemester(Semester.FIRST);

        Course B = new Course();
        A.setId(1L);
        A.setDescription("D2");
        A.setName("B");
        A.setSemester(Semester.FIRST);

        given(this.registrationService.getAllCourses(Semester.FIRST))
                .willReturn(Arrays.asList(A, B));
        this.mockMvc.perform(get("/registration-service/courses?semester=FIRST").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
