//package com.tricks4live.repositories;
//
//import com.tricks4live.entries.Comment;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface CommentRepository extends MongoRepository<Comment, String> {
//
//    @Query(value = "{'super_id':?0}")
//    Comment findBySuperId(String superId);
//}
