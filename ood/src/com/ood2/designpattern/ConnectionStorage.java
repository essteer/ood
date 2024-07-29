package com.ood2.designpattern;

import java.util.ArrayList;
import java.util.List;

public class ConnectionStorage {
	
	private static ConnectionStorage connectionStorage;
	private static boolean initialised = false;
	private List<Connection> connectionList;
	
	private ConnectionStorage() {}
	
	private void init() {
		this.connectionList = new ArrayList<>();
		Connection connection1 = new Connection();
		Connection connection2 = new Connection();
		Connection connection3 = new Connection();
		connectionList.add(connection1);
		connectionList.add(connection2);
		connectionList.add(connection3);
	}
	
	public ConnectionStorage getConnectionStorage() {
		if (initialised) return connectionStorage;
		connectionStorage = new ConnectionStorage();
		connectionStorage.init();
		return connectionStorage;
	}

}
