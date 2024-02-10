package com.example.demo.model.dao;

import com.example.demo.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<Client, Integer> {

}
