package com.vit.isf.jcomponent.transaction.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vit.isf.jcomponent.transaction.model.Finance;
@Repository
public interface FinanceRepository extends MongoRepository<Finance, Object>{

}
