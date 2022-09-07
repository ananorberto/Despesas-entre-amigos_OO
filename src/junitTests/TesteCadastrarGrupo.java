package junitTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import database.Database;
import model.Grupo;
import controller.ControleGrupo;

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
		
		String nomeGrupoString = "grupo teste2"; 
		String idString = "200";
		String maxPessoasString = "5";
		
		boolean resultado = ControleGrupo.cadastrarGrupo(nomeGrupoString, idString, maxPessoasString);
		
		assertTrue(resultado);
		
	}
	
}
