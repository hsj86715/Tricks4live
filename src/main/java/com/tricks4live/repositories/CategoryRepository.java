//package com.tricks4live.repositories;
//
//import com.tricks4live.entries.BaseDBEntry;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface CategoryRepository extends JpaRepository<BaseDBEntry, String> {
//
//    @Query(value = "select c from BaseDBEntry c where c.level=:level")
//    List<BaseDBEntry> findByLevel(@Param("level") Integer level);
//
//    @Query(value = "select c from BaseDBEntry c where c.superId=:superId")
//    List<BaseDBEntry> findBySuperId(@Param("superId") String superId);
//}
