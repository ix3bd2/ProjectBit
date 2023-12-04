package com.project.bit.api.user.repository;

import com.project.bit.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
