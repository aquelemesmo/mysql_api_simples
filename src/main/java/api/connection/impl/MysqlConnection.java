package api.connection.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import api.connection.IConnection;
import api.models.enums.ConnectionType;
import api.models.utils.Checkers;

public class MysqlConnection extends TCPConnectionAtributes implements IConnection<TCPConnectionAtributes>{

	private void initializeVariables() {
		
		if(Checkers.isEmpty(getAdress())) {
			setAdress("127.0.0.1");
		}
		
		if(getPort() ==0) {
			setPort(3306);
		}
		
		if(Checkers.isEmpty(getPassword())) {
			setPassword("");
		}
		
	}
	@Override
	public String getAtributesConnection() {
	
		this.initializeVariables();
		return "jdbc:mysql"+getAtributesConnectionTCP();
	}
	@Override
	public Connection openConnection() {
		
		this.initializeVariables();
		if(Checkers.isEmpty(getAdress())) {
			
			throw new NullPointerException("Database is null");
		}
		
		Connection connection=null;
			try {
				connection = DriverManager.getConnection(getAtributesConnection(),getUsername(),getPassword());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				e.printStackTrace();
				return null;
			}
			
	
		return connection;
	}

	@Override
	public void closeConnection(Connection connection) {
		
		if(connection != null) {
			
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao com o MYSQL");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void closeResultSet(ResultSet resultSet) {
	
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	@Override
	public TCPConnectionAtributes getAtributes() {
		
		return this;
	}
	@Override
	public ConnectionType geConnectionType() {
	
		return ConnectionType.MYSQL;
	}
	@Override
	public void syncronize() {
		
		
	}

}
