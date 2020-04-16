package com.akgs.interview.kristalai.usermanagement.repository;

import com.akgs.interview.kristalai.usermanagement.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByLastName(@Param("name") String name);

    User findByUsername(@Param("username") String username);
}
