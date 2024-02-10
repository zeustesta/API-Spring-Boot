package com.example.demo.service.impl;

import com.example.demo.model.dao.ClientDao;
import com.example.demo.model.dto.ClientDto;
import com.example.demo.model.entity.Client;
import com.example.demo.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientImpl implements ICliente {
    @Autowired
    private ClientDao clientDao;

    @Transactional
    @Override
    public Client save(ClientDto clientDto) {
        Client client = Client.builder()
            .id_cliente(clientDto.getId_cliente())
            .nombre(clientDto.getNombre())
            .apellido(clientDto.getApellido())
            .correo(clientDto.getCorreo())
            .fecha_registro(clientDto.getFecha_registro())
            .build();
        return clientDao.save(client);
    }

    @Transactional(readOnly = true)
    @Override
    public Client findById(Integer id_client) {
        return clientDao.findById(id_client).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }
}
