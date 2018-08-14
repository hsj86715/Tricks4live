package com.tricks4live.repositories;

import com.tricks4live.enrties.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query(value = "select c from Category c where c.level=:level")
    List<Category> findByLevel(@Param("level") Integer level);

    @Query(value = "select c from Category c where c.cSuperId=:superId")
    List<Category> findBySuperId(@Param("superId") String superId);
}
