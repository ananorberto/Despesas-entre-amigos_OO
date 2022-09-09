package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControleGrupo;
import database.Database;

/**
 * Classe TelaListagemGrupo gera uma lista de grupos cadastrados.
 * 
 * @author Leonardo, Ana Beatriz
 * @since 2022
 * @version 1.0
 *
 */
public class TelaListagemGrupos extends JFrame implements ActionListener, ListSelectionListener {

	private JList<String> listaGruposCadastrados;
	private String[] listaNomes = new String[Database.getQtdeGrupos()];
	private JButton voltar = new JButton("Voltar");

	/**
	 * Construtor da lista é responsavel por determinar a posição de cada botao, da
	 * tela, as cores dos botoes e torna-los visiveis para o usuario.
	 * 
	 */
	public TelaListagemGrupos() {
		super("Mostrar Grupos Cadastrados");

		voltar.setBounds(120, 290, 180, 30);
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
	 * Metodo responsavel por mostrar os nomes dos grupos e inserir na lista.
	 */

	public void mostrarDados() {
		listaNomes = ControleGrupo.pegarNomeGrupo();
		listaGruposCadastrados = new JList<>(listaNomes);
		listaGruposCadastrados.setBounds(17, 40, 350, 170);
		listaGruposCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaGruposCadastrados.addListSelectionListener(this);
		add(listaGruposCadastrados);

	}

	/**
	 * Metodo responsavel por dar funcionalidade ao botao voltar (voltando para a
	 * tela de Menu).
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			TelaMenu menu = new TelaMenu();
			dispose();
		}

	}

	/**
	 * Metodo responsavel por alterar os valores da Lista de Grupos Cadastrados.
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if (e.getValueIsAdjusting() && src == listaGruposCadastrados) {
			// Mostra as informacoes do grupo selecionado
			new TelaEditarGrupo(listaGruposCadastrados.getSelectedIndex());
			dispose();
		}
	}

}
