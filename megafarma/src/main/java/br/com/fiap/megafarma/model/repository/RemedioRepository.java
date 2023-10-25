package br.com.fiap.megafarma.model.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.megafarma.model.entity.Remedio;

public class RemedioRepository extends Repository {
	
	public static ArrayList<Remedio> findAll(){
		ArrayList<Remedio> remedios = new ArrayList<Remedio>();		
		String sql = "select * from tb_remedios";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Remedio remedio = new Remedio();
					remedio.setId(rs.getLong("id"));
					remedio.setNome(rs.getString("nome"));
					remedio.setPreco(rs.getDouble("preco"));
					remedio.setDataDeFabricacao(rs.getDate("data_de_fabricacao").toLocalDate());
					remedio.setDataDeValidade(rs.getDate("data_de_validade").toLocalDate());
					remedios.add(remedio);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao listar: " +e.getMessage());
		} finally {
			closeConnection();
		}
		return remedios;
	}
	
	public static Remedio save(Remedio remedio) {
		String sql = "insert into tb_remedios"
				+ "(id, nome, preco, data_de_fabricacao, data_de_validade)"
				+ " values(null, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, remedio.getNome());
			ps.setDouble(2, remedio.getPreco());
			ps.setDate(3, Date.valueOf(remedio.getDataDeFabricacao()));
			ps.setDate(4, Date.valueOf(remedio.getDataDeValidade()));
			if (ps.executeUpdate() > 0) {
				return remedio;
			} else {				
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	public static boolean delete(Long id) {
		String sql = "delete fom tb_remedios where id=?"; 
				try {
					PreparedStatement ps = getConnection().prepareStatement(sql);
					ps.setLong(1, id);
					if (ps.executeUpdate() > 0) {
						return true;
					} else {
						return false;
					}
				}
				catch (SQLException e) {
					System.out.println("Erro ao salvar: " + e.getMessage());
				} 
				finally {
					closeConnection();
				}
				return false;
	}
	public static Remedio update(Remedio remedio) {
		String sql = "UPDATE tb_remedios SET nome=?, preco=?, data_de_fabricacao=?, data_de_validade=? WHERE id=?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, remedio.getNome());
			ps.setDouble(2, remedio.getPreco());
			ps.setDate(3, Date.valueOf(remedio.getDataDeFabricacao()));
			ps.setDate(4, Date.valueOf(remedio.getDataDeValidade()));
			ps.setLong(5, remedio.getId());
			if (ps.executeUpdate() > 0) {
				return remedio;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
		} 
		finally {
			closeConnection();
		}
		return null;
	}
}








