package TabelasDeVacinacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pessoas {

	public int id;
	public String nome;
	public String cpf;
	public String dataNasc;
	public String cep;
	public String rua;
	public String complemento;

	public class ServicoBancoDados {

		public List<Pessoas> listar() {
			List<Pessoas> listaPessoas = new ArrayList<Pessoas>();

			try {
				Connection con = new ConexaoBancoDados().ObtenhaConexao();
				PreparedStatement smt = con.prepareStatement("SELECT * FROM Pessoas");
				ResultSet rs = smt.executeQuery();

				while (rs.next()) {
					Pessoas pessoas = new Pessoas();

					pessoas.id = (rs.getInt("Id"));
					pessoas.nome = (rs.getString("nome"));

					listaPessoas.add(pessoas);
				}

				rs.close();
				smt.close();
				con.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			return listaPessoas;
		}

	}

}
