package com.libreria.controller;

import java.util.ArrayList;

import com.libreria.model.dto.Client;
import com.libreria.model.dto.ClienteDto;

public interface IMainController {

	ArrayList<ClienteDto> requestList();

	boolean addClient(Client c);

	boolean editClient(ClienteDto cd);

	boolean deleteClient(int clientNumber);

}
