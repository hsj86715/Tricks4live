package com.tricks4live.repositories;

import com.tricks4live.enrties.Improvement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImprovementRepository extends MongoRepository<Improvement, String> {
}
