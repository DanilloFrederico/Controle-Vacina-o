package TabelasDeVacinacao;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/*
 * MENU: 0 -> Principal
 *      
 *
 * OPCAO: 1 -> Exibir todos    
 *         2 -> Cadastrar
 *         3 -> Atualizar
 *         4 -> Deletar
 *         5 -> Voltar
 */

public class ListaDeVacinacao {
	static int menu = 0;
	static int opcao = 0;

	public static void main(String[] args) {
		interfaceMenuPrincipal();
	}

	public static void interfaceMenuPrincipal() {
		Scanner teclado = new Scanner(System.in);
		int entrada = 0;

		while (true) {
			do {
				System.out.println("**** MENU PRINCIPAL ****");
				System.out.println("1 - Cidade");
				System.out.println("2 - Pessoa");
				System.out.println("3 - Telefone");
				System.out.println("4 - Unidade de Saude");
				System.out.println("5 - Lista Vacinações");
				System.out.println("6 - Vacinas");
				System.out.println("7 - Regiões");

				System.out.println(">> ");
				entrada = teclado.nextInt();

			} while (entrada < 0 && entrada > 8);

			if (entrada == 1) {
				menu = 1;
				interfaceMenu();
			} else if (entrada == 2) {
				menu = 2;
				interfaceMenu();
			} else if (entrada == 3) {
				menu = 3;
				interfaceMenu();
			} else if (entrada == 4) {
				menu = 4;
				interfaceMenu();
			} else if (entrada == 5) {
				menu = 5;
				interfaceMenu();
			} else if (entrada == 6) {
				menu = 6;
				interfaceMenu();
			} else if (entrada == 7) {
				menu = 7;
				interfaceMenu();
			}

		}

	}

	public static void interfaceMenu() {
		Scanner teclado = new Scanner(System.in);
		int entrada;

		while (true) {
			opcao = 0;

			do {
				System.out.println("***" + ObterNomeMenu(menu) + "***");
				System.out.println("1 - Exibir todos");
				System.out.println("2 - Cadastrar");
				System.out.println("3 - Deletar");
				System.out.println("4 - Voltar");

				System.out.println(">>");
				entrada = teclado.nextInt();
				teclado.nextLine();

			} while (entrada < 0 && entrada > 5);

			if (entrada == 4) {
				menu = 0;
				opcao = 0;
				break;
			} else if (entrada == 1) {
				opcao = 1;
				interfaceOpcao();
			} else if (entrada == 2) {
				opcao = 2;
				interfaceOpcao();
			} else if (entrada == 3) {
				opcao = 3;
				interfaceOpcao();
			}
		}
	}

	public static void interfaceOpcao() {
		// Listar
		if (menu == 1 && opcao == 1) {
			ServicoBancoDados servicoCidade = new ServicoBancoDados();
			Scanner teclado = new Scanner(System.in);
			int entrada;

			do {
				List<Cidades> cidades = servicoCidade.listar();

				System.out.println("...::" + ObterNomeMenu(menu) + " - " + ObterNomeOpcao(opcao) + "::...");

				for (Cidades cidade : cidades) {
					System.out.println("id = " + cidade.id + " | nome = " + cidade.nome);
				}

				System.out.println("-------");
				System.out.println("1 - Voltar");
				System.out.println(">> ");
				entrada = teclado.nextInt();
			}

			while (entrada != 1);
		}

		else if (menu == 2 && opcao == 1) {
			ServicoBancoDados servicoPessoas = new ServicoBancoDados();
			Scanner teclado = new Scanner(System.in);
			int entrada;

			do {
				List<Pessoas> pessoas = servicoPessoas.listarPessoas();

				System.out.println("...:: " + ObterNomeMenu(menu) + " - " + ObterNomeOpcao(opcao) + " ::...");

				for (Pessoas pessoa : pessoas) {
					System.out.println("id = " + pessoa.id + " | nome = " + pessoa.nome + " | CPF = " + pessoa.cpf
							+ " | Rua = " + pessoa.rua);
				}

				System.out.println("-------");
				System.out.println("1 - Voltar");
				System.out.print(">> ");
				entrada = teclado.nextInt();
			} while (entrada != 1);

		}

		else if (menu == 6 && opcao == 1) {
			ServicoBancoDados servicoVacinas = new ServicoBancoDados();
			Scanner teclado = new Scanner(System.in);
			int entrada;

			do {
				List<Vacinas> Vacinas = servicoVacinas.listarVacinas();

				System.out.println("...::" + ObterNomeMenu(menu) + " - " + ObterNomeOpcao(opcao) + "::...");

				for (Vacinas vacina : Vacinas) {
					System.out.println("id = " + vacina.id + " | nome = " + vacina.tipo);
				}

				System.out.println("-------");
				System.out.println("1 - Voltar");
				System.out.println(">> ");
				entrada = teclado.nextInt();
			}

			while (entrada != 1);
		}

		else if (menu == 3 && opcao == 1) {
			ServicoBancoDados servicoTelefone = new ServicoBancoDados();
			Scanner teclado = new Scanner(System.in);
			int entrada;

			do {
				List<Telefone> Telefone = servicoTelefone.listaTelefones();

				System.out.println("...::" + ObterNomeMenu(menu) + " - " + ObterNomeOpcao(opcao) + "::...");

				for (Telefone telefone : Telefone) {
					System.out.println("Id Pessoa = " + telefone.pessoasid + " | Telefone 1 = " + telefone.telefone1
							+ " | Telefone 2 = " + telefone.telefone2 + " | Telefone 3 = " + telefone.telefone3
							+ " | Telefone 4 = " + telefone.telefone4);
				}

				System.out.println("-------");
				System.out.println("1 - Voltar");
				System.out.println(">> ");
				entrada = teclado.nextInt();
			}

			while (entrada != 1);

		}

		else if (menu == 4 && opcao == 1) {
			ServicoBancoDados servicoUnidade = new ServicoBancoDados();
			Scanner teclado = new Scanner(System.in);
			int entrada;

			do {
				List<UnidadeDeSaude> UnidadeDeSaude = servicoUnidade.listaUnidade();

				System.out.println("...::" + ObterNomeMenu(menu) + " - " + ObterNomeOpcao(opcao) + "::...");

				for (UnidadeDeSaude unidadesaude : UnidadeDeSaude) {
					System.out.println("Id = " + unidadesaude.id + " | Nome = " + unidadesaude.nome + " | Regiao Id = "
							+ unidadesaude.regiaoid);
				}

				System.out.println("-------");
				System.out.println("1 - Voltar");
				System.out.println(">> ");
				entrada = teclado.nextInt();
			}

			while (entrada != 1);

		}

		else if (menu == 7 && opcao == 1) {
			ServicoBancoDados servicoRegiao = new ServicoBancoDados();
			Scanner teclado = new Scanner(System.in);
			int entrada;

			do {
				List<Regioes> Regioes = servicoRegiao.listaRegiao();

				System.out.println("...::" + ObterNomeMenu(menu) + " - " + ObterNomeOpcao(opcao) + "::...");

				for (Regioes regiao : Regioes) {
					System.out.println("Id = " + regiao.id + " | Nome = " + regiao.nome + " | Cidade Id = "
							+ regiao.cidadeid + " | Regiao = " + regiao.regiao_);
				}

				System.out.println("-------");
				System.out.println("1 - Voltar");
				System.out.println(">> ");
				entrada = teclado.nextInt();
			}

			while (entrada != 1);

		} else if (menu == 5 && opcao == 1) {
			ServicoBancoDados servicoVacinacoes = new ServicoBancoDados();
			Scanner teclado = new Scanner(System.in);
			int entrada = 0;

			do {
				List<Vacinacoes> vacinacoes = servicoVacinacoes.listarVacinacoes();

				System.out.println("...:: " + ObterNomeMenu(menu) + " - " + ObterNomeOpcao(opcao) + " ::...");

				// vacinados
				System.out.println("**** VACINADOS ****");
				for (Vacinacoes vacinacao : vacinacoes) {
					PessoaVacina pessoaVacina = new PessoaVacina();
					Pessoas Pessoa = servicoVacinacoes.ObterPessoa(vacinacao.pessoaid);
					Vacinas Vacina = servicoVacinacoes.ObterVacina(vacinacao.vacinaid);

					pessoaVacina.nome = Pessoa.nome;
					pessoaVacina.cpf = Pessoa.cpf;
					pessoaVacina.vacina = Vacina.tipo;

					System.out.println("Nome Pessoa = " + pessoaVacina.nome + " | Pessoa CPF = " + pessoaVacina.cpf
							+ " | Vacina tipo = " + pessoaVacina.vacina);
				}

				System.out.println("**** NAO VACINADOS ****");
				List<Pessoas> pessoas = servicoVacinacoes.listarPessoas();
				Boolean vacinou = false;
				int qtdPessoasNaoVacinadas = 0;
				// nao vacinados
				for (Pessoas pessoa : pessoas) {

					for (Vacinacoes vacinacao : vacinacoes) {
						if (pessoa.id == vacinacao.pessoaid) {
							vacinou = true;

						} else {
							vacinou = false;
						}

						if (vacinou == true) {
							break;
						}
					}

					if (vacinou == false) {
						PessoaVacina pessoaVacina = new PessoaVacina();
						pessoaVacina.nome = pessoa.nome;
						pessoaVacina.cpf = pessoa.cpf;
						System.out.println("Nome Pessoa = " + pessoaVacina.nome + " | Pessoa CPF = " + pessoaVacina.cpf
								+ " | Vacina tipo = " + pessoaVacina.vacina);

						qtdPessoasNaoVacinadas++;
					}

				}

				DecimalFormat df = new DecimalFormat("#,###.00");

				System.out.println("**** DETALHES ****");
				System.out.println("Total pessoas: " + pessoas.size() + " [100%]");
				System.out.println("Total vacinados: " + vacinacoes.size() + " ["
						+ df.format(100.00 * vacinacoes.size() / pessoas.size()) + "%]");
				System.out.println("Total nao vacinados: " + qtdPessoasNaoVacinadas + " ["
						+ df.format(100.0 * qtdPessoasNaoVacinadas / pessoas.size()) + "%]");

				System.out.println("-------");
				System.out.println("1 - Voltar");
				System.out.print(">> ");
				entrada = teclado.nextInt();

			} while (entrada != 1);
		}

		// adicionar
		if (menu == 5 && opcao == 2) {
			List<Vacinacoes> novasVacinacoes = new ArrayList<Vacinacoes>();

			do {
				System.out.println("...:: " + ObterNomeMenu(menu) + " - " + ObterNomeOpcao(opcao) + " ::...");

				ServicoBancoDados servicoVacinacao = new ServicoBancoDados();
				int entrada = 0;
				int unidadeid;
				int pessoaid;
				int vacinaid;
				String data = DataAtual();

				Scanner teclado = new Scanner(System.in);

				System.out.print("Informe id da Unidade: ");
				unidadeid = teclado.nextInt();

				System.out.print("Informe id da Pessoa: ");
				pessoaid = teclado.nextInt();

				System.out.print("Informe id da Vacina: ");
				vacinaid = teclado.nextInt();

				Vacinacoes novaVacinacao = new Vacinacoes();
				novaVacinacao.unidadeid = unidadeid;
				novaVacinacao.pessoaid = pessoaid;
				novaVacinacao.vacinaid = vacinaid;
				novaVacinacao.dataVacinacao = data;

				novasVacinacoes.add(novaVacinacao);

				System.out.println("-------");
				System.out.println("1 - Voltar");
				System.out.println("2 - Salvar e voltar");
				System.out.println("3 - Cadastrar outro");

				System.out.print(">> ");
				entrada = teclado.nextInt();

				if (entrada == 1) {
					break;
				} else if (entrada == 2) {
					for (Vacinacoes vacina : novasVacinacoes) {
						servicoVacinacao.adicionar(vacina.unidadeid, vacina.pessoaid, vacina.vacinaid,
								vacina.dataVacinacao);
					}

					System.out.println("\nCadastrado com sucesso");

					break;
				}

			} while (true);

		}
		// excluir
		if (menu == 5 && opcao == 3) {

			List<Integer> pessoasId = new ArrayList<Integer>();

			do {
				System.out.println("...:: " + ObterNomeMenu(menu) + " - " + ObterNomeOpcao(opcao) + " ::...");

				ServicoBancoDados ServicoPessoa = new ServicoBancoDados();

				Scanner teclado = new Scanner(System.in);
				int entrada = 0;
				int pessoaid = 0;

				System.out.println("Informe id da pessoa: ");
				pessoaid = teclado.nextInt();

				pessoasId.add(pessoaid);

				System.out.println("-------");
				System.out.println("1 - Voltar");
				System.out.println("2 - Salvar e voltar");
				System.out.println("3 - Excluir outro cadastro");

				System.out.print(">> ");
				entrada = teclado.nextInt();

				if (entrada == 1) {
					break;
				} else if (entrada == 2) {
					for (Integer _pessoaId : pessoasId) {
						ServicoPessoa.deletar(_pessoaId);
					}

					System.out.println("Cadastro excluido com sucesso. ");

					break;
				}

			} while (true);
		}

	}

	public static String ObterNomeMenu(int valor) {
		if (valor == 1)
			return "CIDADES";
		else if (valor == 2)
			return "PESSOAS";
		else if (valor == 3)
			return "TELEFONE";
		else if (valor == 4)
			return "UNIDADE DE SAUDE";
		else if (valor == 5)
			return "VACINACÕES";
		else if (valor == 6)
			return "VACINAS";
		else
			return "";
	}

	public static String ObterNomeOpcao(int valor) {
		if (valor == 1)
			return "EXIBIR TODOS";
		else if (valor == 2)
			return "CADASTRAR";

		else if (valor == 3)
			return "DELETAR";
		else
			return "";
	}

	private static String DataAtual() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
