package com.libreria.model.repository;

import java.util.ArrayList;

import com.libreria.model.dto.Client;
import com.libreria.model.dto.ClienteDto;

public interface IClientModel {

	ArrayList<ClienteDto> clientList();

	boolean insertClient(Client c);

	boolean editClient(ClienteDto c);

	boolean deleteClient(int clientNumber);

}
