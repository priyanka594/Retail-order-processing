package com.usecase.retail.repository;

import com.usecase.retail.models.ERole;
import com.usecase.retail.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
