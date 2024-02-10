package com.example.demo.service;

import com.example.demo.model.dto.ClientDto;
import com.example.demo.model.entity.Client;

public interface ICliente {
    Client save(ClientDto cliente);
    Client findById(Integer id_cliente);
    void delete(Client cliente);
}
