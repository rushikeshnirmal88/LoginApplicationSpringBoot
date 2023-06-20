package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.entity.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{

   public User findByEmailid(String emailid);
   


   public User findByEmailidAndPassword(String emailid, String password);

}
