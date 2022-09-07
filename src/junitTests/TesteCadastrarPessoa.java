package junitTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import database.Database;
import model.Grupo;
import model.Pessoa;
import controller.ControlePessoas;

public class TesteCadastrarPessoa {

	public void cadastrarInfo() {
		// Cadastra as informacoes de teste
		Grupo grupoTeste = new Grupo(3, 100, "grupo teste");
		Pessoa pessoa1 = new Pessoa("00000000000", "Mario", 111);
		Pessoa pessoa2 = new Pessoa("11111111111", "Andre", 222);

		Database.getGrupos().add(grupoTeste);
		Database.aumentarQtdeGrupos();
		Database.getGrupos().get(0).setNovaPessoa(pessoa1);
		Database.getGrupos().get(0).addPessoa();
		Database.getGrupos().get(0).setNovaPessoa(pessoa2);
		Database.getGrupos().get(0).addPessoa();

	}
	
	@Test
	public void testeCadastro() {
		cadastrarInfo();
		String nomeNovaPessoa = "Ana";
		String idPessoaString = "999";
		String cpfString = "22222222222";
		String nomeGrupoString = "grupo teste";
		
		boolean resultado = ControlePessoas.cadastrarPessoa(nomeNovaPessoa, idPessoaString, cpfString, nomeGrupoString);
		
		assertTrue(resultado);
		
	}
	
}
