package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.Conexao;
import model.Cliente;
import model.Usuario;

public class DAO {
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	
	private static String CADASTRAR_CLIENTE = " INSERT INTO CLIENTE "
			+ " (ID, NOME, CPFCNPJ, EMAIL, TELEFONE, ENDEREÇO) "
			+ " VALUES(NULL, ?, ?, ?, ?, ?) ";
	
	private static String CONSULTAR_CLIENTE = " SELECT * FROM CLIENTE "
			+ " WHERE ID = ? ";
	
	private static String ALTERAR_CLIENTE = " UPDATE CLIENTE SET "
			+ " (NOME = ?, CPFCNPJ = ?, EMAIL = ?, TELEFONE = ?, ENDEREÇO = ?) "
			+ " WHERE ID = ? ";
	
	private static String EXCLUIR_CLIENTE = " DELETE FROM CLIENTE "
			+ " WHERE ID = ? ";
	
	private static String LISTAR_CLIENTE = " SELECT * FROM CLIENTE "
			+ " WHERE 1 = 1 ";
	
	private static String CONSULTAR_USUARIO = " SELECT USUARIO, SENHA "
			+ " FROM USUARIO "
			+ " WHERE USUARIO = ? "
			+ " AND SENHA = ? ";
	
	public DAO(){
		
	}
	//------------------CADASTRAR_CLIENTE------------------//
	public void cadastrarCliente(Cliente cliente){
		Connection connection = Conexao.getInstancia().abrirConexao();
		
		String query = CADASTRAR_CLIENTE;
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			// NOME, CPFCNPJ, EMAIL, TELEFONE, ENDEREÇO
			preparedStatement.setString(i++, cliente.getNome());
			preparedStatement.setString(i++, cliente.getCpfcnpj());
			preparedStatement.setString(i++, cliente.getEmail());
			preparedStatement.setString(i++, cliente.getTelefone());
			preparedStatement.setString(i++, cliente.getEndereco());
			
			connection.commit();
			
			JOptionPane.showMessageDialog(null, "Cliente INCLUIDO com sucesso");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	//-----------------CONSULTAR_CLIENTE-----------------//
	public Cliente consultarCliente(String id) throws Exception{
		Connection connection = Conexao.getInstancia().abrirConexao();
		
		Cliente cliente = null;
		String query = CONSULTAR_CLIENTE;
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			// NOME, CPFCNPJ, EMAIL, TELEFONE, ENDEREÇO
			preparedStatement.setString(i++, id);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				//String id, String nome, String cpfcnpj, String email, String telefone, String endereco
				cliente = new Cliente(	resultSet.getString("ID"),
										resultSet.getString("NOME"),
										resultSet.getString("CPFCNPJ"),
										resultSet.getString("EMAIL"),
										resultSet.getString("TELEFONE"),
										resultSet.getString("ENDERECO"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		if(cliente == null){
			JOptionPane.showMessageDialog(null, "Não foi possível localizar o cliente selecionado ", "",JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não foi possível localizar o cliente selecionado");
		}
		return cliente;
	}

	//------------------ALTERAR_CLIENTE------------------//
	public void alterarCliente(String id, Cliente cliente){
		Connection connection = Conexao.getInstancia().abrirConexao();
		
		String query = ALTERAR_CLIENTE;
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;

			preparedStatement.setString(i++, cliente.getNome());
			preparedStatement.setString(i++, cliente.getCpfcnpj());
			preparedStatement.setString(i++, cliente.getEmail());
			preparedStatement.setString(i++, cliente.getTelefone());
			preparedStatement.setString(i++, cliente.getEndereco());
			preparedStatement.setString(i++, id);
			
			preparedStatement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, "Cliente ALTERADO com sucesso");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}

	//------------------EXCLUIR_CLIENTE------------------//
	public void excluirCliente(String id){
		Connection connection = Conexao.getInstancia().abrirConexao();
		
		String query = EXCLUIR_CLIENTE;
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;

			preparedStatement.setString(i++, id);
			
			preparedStatement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, "Cliente EXCLUIDO com sucesso");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	//------------------LISTAR_CLIENTES------------------//
	public ArrayList<Cliente> listarCliente() throws Exception{
		Connection connection = Conexao.getInstancia().abrirConexao();
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		String query = LISTAR_CLIENTE;
		try {
			preparedStatement = connection.prepareStatement(query);
			
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				clientes.add(new Cliente(	resultSet.getString("ID"),
											resultSet.getString("NOME"),
											resultSet.getString("CPFCNPJ"),
											resultSet.getString("EMAIL"),
											resultSet.getString("TELEFONE"),
											resultSet.getString("ENDERECO")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		if(clientes.size() < 0){
			JOptionPane.showMessageDialog(null, "Não ha clientes cadastrados ", "",JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não ha clientes cadastrados");
		}
		return clientes;
	}
	
	//-----------------CONSULTAR_USUARIO-----------------//
	public Usuario consultarUsuario(String nomeUsuario, String senhaCriptografada) throws Exception{
		Connection connection = Conexao.getInstancia().abrirConexao();
		
		Usuario usuario = null;
		String query = CONSULTAR_USUARIO;
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;

			preparedStatement.setString(i++, nomeUsuario);
			preparedStatement.setString(i++, senhaCriptografada);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				usuario = new Usuario(	resultSet.getInt("ID"),
										resultSet.getString("USUARIO"),
										resultSet.getString("SENHA"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		if(usuario == null){
			JOptionPane.showMessageDialog(null, "Não foi possível localizar o usuario selecionado ", "",JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não foi possível localizar o usuario selecionado");
		}
		return usuario;
	}
	
	private void fecharConexao() {
		
			try {
				if(resultSet!=null){
				resultSet.close();
				}
				if(preparedStatement!=null){
					preparedStatement.close();
				}
				Conexao.getInstancia().fecharConexao();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}

