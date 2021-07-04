package com.vit.isf.jcomponent.transaction.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vit.isf.jcomponent.transaction.model.Audit;

public interface AuditRepository extends MongoRepository<Audit,Integer> {

}
