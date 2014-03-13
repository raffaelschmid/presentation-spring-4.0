package com.trivadis.boot.sec.userdetails;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.trivadis.boot.sec.userdetails.Role;
import com.trivadis.boot.sec.userdetails.User;

public interface RoleRepository extends Repository<Role, String> {

	List<Role> findAllByUser(User user);

}
