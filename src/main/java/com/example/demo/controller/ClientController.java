package com.example.demo.controller;

import com.example.demo.model.dto.ClientDto;
import com.example.demo.model.entity.Client;
import com.example.demo.model.payload.MessageResponse;
import com.example.demo.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class ClientController {
  @Autowired
  private ICliente clientService;

  @PostMapping("client")
  @ResponseStatus(HttpStatus.CREATED)
  public ClientDto create(@RequestBody ClientDto clientDto) {
    Client clientSave = clientService.save(clientDto);
    return ClientDto.builder()
        .id_cliente(clientSave.getId_cliente())
        .nombre(clientSave.getNombre())
        .apellido(clientSave.getApellido())
        .correo(clientSave.getCorreo())
        .fecha_registro(clientSave.getFecha_registro())
        .build();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PutMapping("client")
  public ClientDto update(@RequestBody ClientDto clientDto) {
    Client clientUpdate = clientService.save(clientDto);
    return ClientDto.builder()
        .id_cliente(clientUpdate.getId_cliente())
        .nombre(clientUpdate.getNombre())
        .apellido(clientUpdate.getApellido())
        .correo(clientUpdate.getCorreo())
        .fecha_registro(clientUpdate.getFecha_registro())
        .build();
  }

  @DeleteMapping("client/{id_client}")
  public ResponseEntity<?> delete(@PathVariable Integer id_client) {
    try {
      Client deleteClient = clientService.findById(id_client);
      clientService.delete(deleteClient);
      return new ResponseEntity<>(deleteClient, HttpStatus.NO_CONTENT);
    } catch (DataAccessException dEx) {
      return new ResponseEntity<>(
          MessageResponse.builder()
            .message(dEx.getMessage())
            .object(null)
            .build()
          , HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("client/{id_client}")
  public ClientDto showById(@PathVariable Integer id_client) {
    Client client = clientService.findById(id_client);
    return ClientDto.builder()
        .id_cliente(client.getId_cliente())
        .nombre(client.getNombre())
        .apellido(client.getApellido())
        .correo(client.getCorreo())
        .fecha_registro(client.getFecha_registro())
        .build();
  }
}
