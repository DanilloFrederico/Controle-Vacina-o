package TabelasDeVacinacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoBancoDados {

	public List<Vacinacoes> listarVacinacoes() {
		List<Vacinacoes> listaVacinacoes = new ArrayList<Vacinacoes>();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM ListaVacinacoes");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Vacinacoes vacinacoes = new Vacinacoes();

				vacinacoes.unidadeid = (rs.getInt("UnidadeDeSaudeId"));
				vacinacoes.pessoaid = (rs.getInt("PessoaId"));
				vacinacoes.vacinaid = (rs.getInt("VacinaId"));
				vacinacoes.dataVacinacao = (rs.getString("DataVacinacao"));

				listaVacinacoes.add(vacinacoes);
			}

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return listaVacinacoes;

	}

	public void adicionar(int unidadeid, int pessoaid, int vacinaid, String dataVacinacao) {
		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement(
					"INSERT INTO ListaVacinacoes (UnidadeDeSaudeId,PessoaId,VacinaId,DataVacinacao) VALUES ("
							+ unidadeid + "," + pessoaid + "," + vacinaid + ",'" + dataVacinacao + "')");
			smt.execute();

			smt.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Vacinacoes obterVacinacoes(int id) {

		Vacinacoes vacinacoes = new Vacinacoes();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM ListaVacinacoes WHERE Id = " + id);
			ResultSet rs = smt.executeQuery();

			rs.next();

			vacinacoes.unidadeid = (rs.getInt("UnidadeDeSaudeId"));
			vacinacoes.pessoaid = (rs.getInt("PessoaId"));
			vacinacoes.vacinaid = (rs.getInt("VacinaId"));
			vacinacoes.dataVacinacao = (rs.getString("DataVacinacao"));

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return vacinacoes;
	}

	public void deletar(int pessoaid) {

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("DELETE FROM ListaVacinacoes WHERE PessoaId = " + pessoaid);
			smt.execute();

			smt.close();
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Regioes> listaRegiao() {
		List<Regioes> listaRegiao = new ArrayList<Regioes>();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM Regioes");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Regioes regiao = new Regioes();

				regiao.id = (rs.getInt("Id"));
				regiao.cidadeid = (rs.getInt("CidadeId"));
				regiao.nome = (rs.getString("Nome"));
				regiao.regiao_ = (rs.getString("Regiao"));

				listaRegiao.add(regiao);
			}

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return listaRegiao;

	}

	public List<UnidadeDeSaude> listaUnidade() {
		List<UnidadeDeSaude> listaUnidade = new ArrayList<UnidadeDeSaude>();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM UnidadesDeSaude");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				UnidadeDeSaude unidadesaude = new UnidadeDeSaude();

				unidadesaude.id = (rs.getInt("Id"));
				unidadesaude.nome = (rs.getString("Nome"));
				unidadesaude.regiaoid = (rs.getInt("RegiaoId"));

				listaUnidade.add(unidadesaude);
			}

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return listaUnidade;

	}

	public List<Telefone> listaTelefones() {
		List<Telefone> listaTelefones = new ArrayList<Telefone>();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM Telefones");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Telefone telefone = new Telefone();

				telefone.pessoasid = (rs.getInt("PessoasId"));
				telefone.telefone1 = (rs.getString("Telefone1"));
				telefone.telefone2 = (rs.getString("Telefone2"));
				telefone.telefone3 = (rs.getString("Telefone3"));
				telefone.telefone4 = (rs.getString("Telefone4"));

				listaTelefones.add(telefone);
			}

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return listaTelefones;

	}

	public List<Vacinas> listarVacinas() {
		List<Vacinas> listaVacinas = new ArrayList<Vacinas>();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM Vacinas");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Vacinas vacina = new Vacinas();

				vacina.id = (rs.getInt("Id"));
				vacina.tipo = (rs.getString("Tipos"));

				listaVacinas.add(vacina);
			}

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return listaVacinas;

	}

	public Vacinas ObterVacina(int id) {
		Vacinas vacina = new Vacinas();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM Vacinas WHERE Id = " + id);
			ResultSet rs = smt.executeQuery();

			rs.next();

			vacina.id = (rs.getInt("Id"));
			vacina.tipo = (rs.getString("Tipos"));

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return vacina;
	}

	public List<Pessoas> listarPessoas() {
		List<Pessoas> listaPessoas = new ArrayList<Pessoas>();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM Pessoas");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Pessoas pessoa = new Pessoas();

				pessoa.id = (rs.getInt("Id"));
				pessoa.nome = (rs.getString("Nome"));
				pessoa.cpf = (rs.getString("Cpf"));
				pessoa.dataNasc = (rs.getString("DataNascimento"));
				pessoa.cep = (rs.getString("CEP"));
				pessoa.rua = (rs.getString("Rua"));
				pessoa.complemento = (rs.getString("Complemento"));

				listaPessoas.add(pessoa);
			}

			con.close();
			smt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return listaPessoas;
	}

	public Pessoas ObterPessoa(int id) {
		Pessoas pessoa = new Pessoas();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM Pessoas WHERE Id = " + id);
			ResultSet rs = smt.executeQuery();

			rs.next();

			pessoa.id = (rs.getInt("Id"));
			pessoa.nome = (rs.getString("Nome"));
			pessoa.cpf = (rs.getString("Cpf"));
			pessoa.dataNasc = (rs.getString("DataNascimento"));
			pessoa.cep = (rs.getString("CEP"));
			pessoa.rua = (rs.getString("Rua"));
			pessoa.complemento = (rs.getString("Complemento"));

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return pessoa;
	}

	public List<Cidades> listar() {
		List<Cidades> listaCidades = new ArrayList<Cidades>();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM Cidades");
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Cidades cidade = new Cidades();

				cidade.id = (rs.getInt("Id"));
				cidade.nome = (rs.getString("Nome"));

				listaCidades.add(cidade);
			}

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return listaCidades;
	}

	public Cidades ObterCidade(int id) {
		Cidades cidade = new Cidades();

		try {
			Connection con = new ConexaoBancoDados().ObtenhaConexao();
			PreparedStatement smt = con.prepareStatement("SELECT * FROM Cidades WHERE Id = " + id);
			ResultSet rs = smt.executeQuery();

			rs.next();

			cidade.id = (rs.getInt("id"));
			cidade.nome = (rs.getString("Nome"));

			rs.close();
			smt.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return cidade;
	}
}
	

	
	


