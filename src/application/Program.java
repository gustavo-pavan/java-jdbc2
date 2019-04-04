package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbExcepetion;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;  // criar connexao
		Statement st = null;	 // criar query
		ResultSet rs = null; 	 // guardar resultado do banco

		try {
			conn = DB.getConnetion(); 						  // abrindo conexao com banco
			st = conn.createStatement(); 					  //criando um statement
			rs = st.executeQuery("select * from department"); // executando query
			
			while(rs.next()) // percorrer até não conter mais dados
			{
				System.out.println(rs.getInt("Id") + ". " + rs.getString("Name")); //imprimir dados na tela
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnetion();
		}
	}

}
