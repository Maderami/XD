package com.docjpa.laba2.JPA.S.repo;


import com.docjpa.laba2.JPA.S.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
}
