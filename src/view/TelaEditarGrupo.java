package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.Database;

/**
 * Classe TelaEditarGrupo edita as informaçoes de um grupo ja cadastrado.
 * 
 * @author Ana Beatriz, Leonardo
 * @since 2022
 * @version 1.0
 *
 */
public class TelaEditarGrupo extends JFrame implements ActionListener {

	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelMaxPessoas = new JLabel("Máximo de Pessoas: ");
	private JTextField valorMaxPessoas;
	private JButton excluir = new JButton("Excluir");
	private JButton salvar = new JButton("Salvar");
	private JButton voltar = new JButton("Voltar");
	private int posicao;

	/**
	 * Construtor responsavel por determinar a posição do JFrame, do botao, as cores
	 * dos botoes e torna-los visiveis para o usuario.
	 * 
	 * @param pos int Seleciona dados de determinada posiçao.
	 */
	public TelaEditarGrupo(int pos) {
		super("Detalhes do Grupo");

		posicao = pos;

		valorNome = new JTextField(Database.getGrupos().get(posicao).getNome(), 200);
		valorMaxPessoas = new JTextField(String.valueOf(Database.getGrupos().get(posicao).getMaxPessoas()), 200);

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(80, 20, 280, 25);
		labelMaxPessoas.setBounds(30, 50, 150, 25);
		valorMaxPessoas.setBounds(180, 50, 180, 25);

		salvar.setBounds(130, 175, 115, 30);
		salvar.setBackground(new Color(108, 112, 139));
		salvar.setForeground(new Color(222, 222, 245));

		excluir.setBounds(255, 175, 115, 30);
		excluir.setBackground(new Color(108, 112, 139));
		excluir.setForeground(new Color(222, 222, 245));

		voltar.setBounds(10, 175, 115, 30);
		voltar.setBackground(new Color(108, 112, 139));
		voltar.setForeground(new Color(222, 222, 245));

		add(excluir);
		add(voltar);
		add(salvar);
		add(labelNome);
		add(valorNome);
		add(labelMaxPessoas);
		add(valorMaxPessoas);

		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 250);
		setVisible(true);
		setLocationRelativeTo(null);

		salvar.addActionListener(this);
		excluir.addActionListener(this);
		voltar.addActionListener(this);

	}

	/**
	 * Metodo responsavel por dar funcionalidade aos botoes voltar (voltando para a
	 * tela de listagem dos grupos), salvar (salvando os novos valores atribuidos ao
	 * grupo) e excluir.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == voltar) {
			// Volta para a lista de Grupos
			new TelaListagemGrupos().mostrarDados();
			dispose();
		} else if (src == salvar) {
			try {
				// Tenta salvar as novas informacoes do grupo
				String nomeString = valorNome.getText();
				String maxPessoasString = valorMaxPessoas.getText();
				boolean naoRepete = true;

				for (int i = 0; i < Database.getQtdeGrupos(); i++) {
					if (i == posicao) {
						continue;
					} else if (nomeString.equals(Database.getGrupos().get(i).getNome())) {
						// Verifica se ja existe um grupo com esse nome
						naoRepete = false;
					}
				}

				int maxPessoasInt = Integer.parseInt(maxPessoasString);

				if ((maxPessoasInt >= Database.getGrupos().get(posicao).getMaxPessoas()) && (naoRepete == true)) {
					// Se o maximo de pessoas nao é menor que o anterior e nao repete o nome do
					// grupo
					Database.getGrupos().get(posicao).setNome(nomeString);
					Database.getGrupos().get(posicao).setMaxPessoas(maxPessoasInt);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Editar", JOptionPane.PLAIN_MESSAGE);
					new TelaListagemGrupos().mostrarDados();
					dispose();

				} else if (naoRepete == false) {
					JOptionPane.showMessageDialog(null, "Ja existe um grupo com esse nome", "Erro",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, " Nao foi possivel salvar,"
							+ " pois o maximo de pessoas so pode ser maior " + "ou igual ao valor anterior", "Erro",
							JOptionPane.PLAIN_MESSAGE);
				}

			} catch (NumberFormatException exception) {
				// Se o maximo de pessoas nao for inteiro, ocorre um erro
				JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro", JOptionPane.PLAIN_MESSAGE);
			}
		} else if (src == excluir) {
			// Exclui o grupo
			Database.getGrupos().remove(posicao);
			Database.diminuirQtdeGrupos();
			JOptionPane.showMessageDialog(null, "Grupo removido", "Deletar", JOptionPane.PLAIN_MESSAGE);
			new TelaListagemGrupos().mostrarDados();
			dispose();

		}

	}

}
