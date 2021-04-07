package com.efi.scrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.efi.scrapper.domain.Televisor;

public interface TelevisorRepository extends MongoRepository<Televisor,Integer> {

}
