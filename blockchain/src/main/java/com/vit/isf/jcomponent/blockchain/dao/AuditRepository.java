package com.vit.isf.jcomponent.blockchain.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vit.isf.jcomponent.blockchain.model.Audit;

public interface AuditRepository extends MongoRepository<Audit,Integer> {

}
