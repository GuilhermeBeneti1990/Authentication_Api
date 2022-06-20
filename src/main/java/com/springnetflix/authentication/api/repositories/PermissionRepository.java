package com.springnetflix.authentication.api.repositories;

import com.springnetflix.authentication.api.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query("SELECT p FROM Permissions p WHERE p.description =:description")
    Permission findByDescription(@Param("description") String description);

}
