package com.libreria;

import java.io.IOException;
import java.sql.SQLException;

import com.libreria.view.MainTerminalView;

public class Main {
	public static void main(String[] arg) throws ClassNotFoundException, SQLException, IOException {
		MainTerminalView mtv = new MainTerminalView();
		mtv.start();
	}	
}
