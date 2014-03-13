package com.trivadis.boot.sec.userdetails;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, String>{

	User findByName(String username);

}
