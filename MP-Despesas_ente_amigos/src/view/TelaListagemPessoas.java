package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControlePessoas;
import database.Database;

/**
 * Classe TelaListagemPessoas gera uma lista de pessoas cadastradas.
 * 
 * @author Leonardo, Ana Beatriz
 * @since 2022
 * @version 1.0
 *
 */
public class TelaListagemPessoas extends JFrame implements ActionListener, ListSelectionListener {

	private JList<String> listaPessoasCadastradas;
	private JLabel labelNomeGrupo = new JLabel("Nome do Grupo: ");
	private JTextField nomeGrupo = new JTextField();
	private String listaNomes[];
	private JButton voltar = new JButton("Voltar");
	private JButton buscar = new JButton("Buscar");
	private int posicaoGrupo;

	/**
	 * Construtor da lista é responsavel por determinar a posição de cada botao, da
	 * tela, as cores dos botoes e torna-los visiveis para o usuario.
	 * 
	 * @param pos int Seleciona dados de determinada posiçao.
	 */

	public TelaListagemPessoas(int pos) {
		super("Mostrar Pessoas Cadastradas");

		this.posicaoGrupo = pos;

		labelNomeGrupo.setBounds(30, 20, 150, 25);
		add(labelNomeGrupo);

		nomeGrupo.setBounds(180, 20, 180, 25);
		add(nomeGrupo);

		buscar.setBounds(200, 290, 180, 30);
		buscar.setBackground(new Color(108, 112, 139));
		buscar.setForeground(new Color(222, 222, 245));
		buscar.addActionListener(this);
		add(buscar);

		voltar.setBounds(10, 290, 180, 30);
		voltar.setBackground(new Color(108, 112, 139));
		voltar.setForeground(new Color(222, 222, 245));
		voltar.addActionListener(this);
		add(voltar);

		setSize(400, 390);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(187, 190, 210, 215));
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}

	/**
	 * Metodo responsavel por mostrar os nomes das pessoas e inserir na lista.
	 * 
	 * @param getNomePessoa String[] Pega o nome da pessoa cadastrada.
	 */

	public void mostrarDados(String[] getNomePessoa) {
		listaPessoasCadastradas = new JList<>(getNomePessoa);
		listaPessoasCadastradas.setBounds(17, 60, 350, 170);
		listaPessoasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaPessoasCadastradas.addListSelectionListener(this);
		add(listaPessoasCadastradas);
	}

	/**
	 * Metodo responsavel por dar funcionalidade ao botao voltar (voltando para a
	 * tela de Menu) e buscar (busca o grupo na qual as pessoas estajam inseridas).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			// Volta para a tela de menu
			new TelaMenu();
			dispose();
		} else if (e.getSource() == buscar) {
			// Busca o nome do grupo digitado
			String nomeString = nomeGrupo.getText();

			for (int i = 0; i < Database.getQtdeGrupos(); i++) {
				if (nomeString.equals(Database.getGrupos().get(i).getNome())) {
					// Achou o nome do grupo digitado
					this.posicaoGrupo = Database.getGrupos().indexOf(Database.getGrupos().get(i));
					listaNomes = ControlePessoas.pegarNomePessoas(this.posicaoGrupo);
					// Pega o nome das pessoas cadastradas nesse grupo
					new TelaListagemPessoas(this.posicaoGrupo).mostrarDados(listaNomes);
					// Recarrega a tela com a lista de pessoas cadastradas
					dispose();
					break;
				} else if (i == (Database.getQtdeGrupos() - 1)) {
					JOptionPane.showMessageDialog(null, "Nao encontramos um grupo com o Nome inserido",
							"Nome nao encontrado", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
	}

	/**
	 * Metodo responsavel por alterar os valores da Lista de Cadastrados.
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if (e.getValueIsAdjusting() && src == listaPessoasCadastradas) {
			// Mostra as informacoes da pessoa selecionada
			new TelaEditarPessoa(this.posicaoGrupo, listaPessoasCadastradas.getSelectedIndex());
			dispose();
		}

	}

}
