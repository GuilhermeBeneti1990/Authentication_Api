package com.springnetflix.authentication.api.repositories;

import com.springnetflix.authentication.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM Users u WHERE u.user_name =:user_name")
    User findByUserName(@Param("user_name") String user_name);

}
