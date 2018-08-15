package com.tricks4live.repositories;

import com.tricks4live.enrties.Label;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends MongoRepository<Label, String> {

}
