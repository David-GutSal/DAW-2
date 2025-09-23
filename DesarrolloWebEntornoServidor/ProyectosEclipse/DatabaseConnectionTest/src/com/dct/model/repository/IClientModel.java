package com.dct.model.repository;

import java.util.ArrayList;

import com.dct.model.dto.Client;
import com.dct.model.dto.ClienteDto;

public interface IClientModel {

	ArrayList<ClienteDto> clientList();

	boolean insertClient(Client c);

	boolean editClient(ClienteDto c);

	boolean deleteClient(int clientNumber);

}
