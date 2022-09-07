package junitTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.Database;
import model.Compra;
import model.Grupo;
import model.Imovel;
import model.Pessoa;

public class TestesUnitarios {

	public void cadastrarInfo() {
		// Cadastra as informacoes de teste
		Grupo grupoTeste = new Grupo(3, 100, "grupo teste");
		Pessoa pessoa1 = new Pessoa(000000000, "Mario", 111);
		Pessoa pessoa2 = new Pessoa(111111111, "Andre", 222);
		Compra compra = new Compra("Atacadao da massa", 50.30, "15/02/2022", 111, "grupo1", "pao, ovo");
		Imovel imovel = new Imovel("Brasilia", 15.30, 25.80, 32.40, "03/03/2022", 222, "grupo1");

		Database.getGrupos().add(grupoTeste);
		Database.getGrupos().get(0).setNovaPessoa(pessoa1);
		Database.getGrupos().get(0).addPessoa();
		Database.getGrupos().get(0).setNovaPessoa(pessoa2);
		Database.getGrupos().get(0).addPessoa();

		Database.getGrupos().get(0).getDespesas().add(compra);
		Database.getGrupos().get(0).getPessoas().get(0).somarTotalDespesa(compra.getValor());
		Database.getGrupos().get(0).aumentarQtdeDespesas();
		imovel.somar_gastos();
		Database.getGrupos().get(0).getDespesas().add(imovel);
		Database.getGrupos().get(0).getPessoas().get(1).somarTotalDespesa(imovel.getValor());
		Database.getGrupos().get(0).aumentarQtdeDespesas();
	}

	@BeforeEach
	public void limparGrupos() {
		Database.getGrupos().clear();
	}

	@Test
	public void testeDespesaDividida() {
		cadastrarInfo();

		// Calcula a despesa dividida do grupo teste
		Database.getGrupos().get(0).dividirDespesas();
		// Verifica a despesa dividida do grupo teste
		assertEquals("grupo teste", Database.getGrupos().get(0).getNome());
		assertEquals(61.90, Database.getGrupos().get(0).getDespesaDividida(), 0.01);
	}

	@Test
	public void testeSaldo() {
		cadastrarInfo();

		// Calcula a despesa dividida do grupo teste
		Database.getGrupos().get(0).dividirDespesas();
		// Define o saldo dos membros do grupo teste
		Database.getGrupos().get(0).definirSaldos();
		// Verifica o saldo de Mario e Andre
		assertEquals((-11.60), Database.getGrupos().get(0).getPessoas().get(0).getSaldo(), 0.01);
		assertEquals(11.60, Database.getGrupos().get(0).getPessoas().get(1).getSaldo(), 0.01);

	}

	@Test
	public void testeMostrarDividas() {
		cadastrarInfo();

		// Calcula a despesa dividida do grupo teste
		Database.getGrupos().get(0).dividirDespesas();
		// Define o saldo dos membros do grupo teste
		Database.getGrupos().get(0).definirSaldos();
		String dividas[] = new String[Database.getGrupos().get(0).getQtdePessoas() + 1];

		dividas[0] = ("A despesa dividida é de R$ 61,90");
		dividas[1] = ("Mario deve ao grupo R$ 11,60");
		dividas[2] = ("O grupo deve Andre R$ 11,60");

		assertArrayEquals(dividas, Database.getGrupos().get(0).mostrarDividas());

	}

}
