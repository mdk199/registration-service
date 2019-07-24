package com.registration.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "registration_details")
public @Data
@EqualsAndHashCode
class RegistrationDetails extends AbstractEntity {

    @EmbeddedId
    private RegistrationKey registrationKey;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = com.registration.entity.Course.class)
    private List<Course> courses;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "last_modified_on")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModifiedOn;
}
