package com.dgs.model;

import java.io.IOException;
import java.util.ArrayList;

public interface IConsultaDatos {
	ArrayList<String> consultaCartas(String nombre) throws IOException;
}
