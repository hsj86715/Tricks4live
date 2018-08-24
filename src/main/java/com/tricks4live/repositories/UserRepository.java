//package com.tricks4live.repositories;
//
//import com.tricks4live.entries.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, String> {
//
//    @Query(value = "select u from User u where u.userName=:userName")
//    User findByUserName(@Param("userName") String userName);
//
//
//    @Query(value = "select u from User u where u.email=:email")
//    User findByEmail(@Param("email") String email);
//
//    @Query(value = "select u from User u where u.phone=:phone")
//    User findByPhone(@Param("phone") String phone);
//
//    @Query(value = "select u from User u where u.userName=:userName and u.password=:password")
//    User findByUsernameAndPassword(@Param("userName") String userName, @Param("password") String password);
//}
