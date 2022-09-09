package junitTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controller.ControleGrupo;
import database.Database;
import model.Grupo;

public class TesteCadastrarGrupo {

	public void cadastrarInfo() {
		// Cadastra as informacoes de teste
		Grupo grupoTeste = new Grupo(3, 100, "grupo teste");

		Database.getGrupos().add(grupoTeste);
		Database.aumentarQtdeGrupos();

	}

	@Test
	public void testeCadastro() {
		cadastrarInfo();
		// Verifica se é possivel cadastrar um grupo inserindo as informacoes abaixo
		String nomeGrupoString = "grupo teste2";
		String idString = "200";
		String maxPessoasString = "5";

		// retorna true se o cadastro é possivel e false se nao foi possivel
		boolean resultado = ControleGrupo.cadastrarGrupo(nomeGrupoString, idString, maxPessoasString);

		assertTrue(resultado);

	}

}
