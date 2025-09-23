package com.dct.controller;

import java.util.ArrayList;

import com.dct.model.dto.Client;
import com.dct.model.dto.ClienteDto;

public interface IMainController {

	ArrayList<ClienteDto> requestList();

	boolean addClient(Client c);

	boolean editClient(ClienteDto cd);

	boolean deleteClient(int clientNumber);

}
