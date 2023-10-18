package br.com.fiap.megafarma.model.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.megafarma.model.entity.Remedio;

public class RemedioRepository extends Repository {
	
	public static ArrayList<Remedio> findAll(){
		ArrayList<Remedio> remedios = new ArrayList<Remedio>();
		
		String sql = "select * from tb_remedios";
		try {
			java.sql.PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
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
			System.out.println("Erro ao listar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		
		return remedios;
	}

}

