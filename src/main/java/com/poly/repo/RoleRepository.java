package com.poly.repo;

import com.poly.mod.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Winnie on 14/04/2017.
 */@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
