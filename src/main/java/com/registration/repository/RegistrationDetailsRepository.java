package com.registration.repository;

import com.registration.entity.RegistrationDetails;
import com.registration.entity.RegistrationKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationDetailsRepository extends CrudRepository<RegistrationDetails, RegistrationKey> {
}
