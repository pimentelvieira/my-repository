package br.com.caelum;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestaPool {

	public static void main(String[] args) throws PropertyVetoException, SQLException {
		ComboPooledDataSource dataSource = (ComboPooledDataSource) new JpaConfigurator().getDataSource();
		Connection connection = dataSource.getConnection();
		Connection connection2 = dataSource.getConnection();
		Connection connection3 = dataSource.getConnection();
		Connection connection4 = dataSource.getConnection();
		Connection connection5 = dataSource.getConnection();
		
		System.out.println(dataSource.getNumBusyConnections());
		System.out.println(dataSource.getNumIdleConnections());
		
		//Essa configuração serve para testar as conexões ociosas a cada segundo, isso faz com que 
		dataSource.setIdleConnectionTestPeriod(1);
	}
}
