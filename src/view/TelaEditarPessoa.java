package view;

import static java.lang.String.format;

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
 * Classe TelaEditarPessoa edita as informaçoes de uma pessoa cadastrada.
 * 
 * @author Leonardo, Ana Beatriz
 * @since 2022
 * @version 1.0
 *
 */
public class TelaEditarPessoa extends JFrame implements ActionListener {

	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelCpf = new JLabel("CPF: ");
	private JTextField valorCpf;
	private JLabel labelTotalDespesa = new JLabel("Valor total em despesas: ");
	private JTextField valorTotalDespesa;
	private JButton excluir = new JButton("Excluir");
	private JButton salvar = new JButton("Salvar");
	private JButton voltar = new JButton("Voltar");
	private int posicaoGrupo;
	private int posicaoPessoa;

	/**
	 * Construtor responsavel por determinar a posição do JFrame, do botao, as cores
	 * dos botoes e torna-los visiveis para o usuario.
	 * 
	 * @param pos_grupo  int Seleciona determinada posiçao de um grupo.
	 * @param pos_pessoa int Seleciona determinada posiçao de uma pessoa.
	 */
	public TelaEditarPessoa(int pos_grupo, int pos_pessoa) {
		super("Detalhe Pessoa: ");

		posicaoGrupo = pos_grupo;
		posicaoPessoa = pos_pessoa;

		valorNome = new JTextField(Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).getNome(),
				200);
		valorCpf = new JTextField(
				String.valueOf(Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).getCpf()));
		valorTotalDespesa = new JTextField(
				String.valueOf(format("%.2f",
						Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).getTotalDespesa())),
				200);

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(80, 20, 280, 25);

		labelCpf.setBounds(30, 50, 180, 25);
		valorCpf.setBounds(70, 50, 290, 25);

		labelTotalDespesa.setBounds(40, 80, 190, 25);
		valorTotalDespesa.setBounds(220, 80, 140, 25);

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
		add(labelCpf);
		add(valorCpf);
		add(labelTotalDespesa);
		add(valorTotalDespesa);

		setLayout(null);

		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));

		salvar.addActionListener(this);
		excluir.addActionListener(this);
		voltar.addActionListener(this);

	}

	/**
	 * Metodo responsavel por dar funcionalidade aos botoes voltar (voltando para a
	 * tela de listagem de pessoas), salvar (salvando os novos valores atribuidos a
	 * pessoa) e excluir (excluindo a pessoa consultada).
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			// volta para a lista de pessoas
			new TelaListagemPessoas(0);
			dispose();
		} else if (e.getSource() == salvar) {
			// Tenta salvar as novas informacoes
			String valorNomeString = valorNome.getText();
			String valorCpfString = valorCpf.getText();
			String valorTotalDespesaString = valorTotalDespesa.getText();
			boolean cpfCerto = false;
			boolean naoRepete = true;

			try {
				double valorTotalDespesaDouble = Double.parseDouble(valorTotalDespesaString);

				if (valorCpfString.matches("^[0-9]*$") && valorCpfString.length() == 11) {
					// Verifica se o cpf possui apenas numeros e 11 digitos
					cpfCerto = true;
				}

				for (int i = 0; i < Database.getGrupos().get(posicaoGrupo).getQtdeDespesas(); i++) {
					if (i == posicaoPessoa) {
						continue;
					} else if (valorCpfString
							.equals(Database.getGrupos().get(posicaoGrupo).getPessoas().get(i).getCpf())) {

						// Verifica se o cpf repete neste grupo
						naoRepete = false;
					}
				}

				if (cpfCerto == true && naoRepete == true) {
					// Cadastra se o cpf estiver correto e não repete
					Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).setNome(valorNomeString);
					Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).setCpf(valorCpfString);
					Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa)
							.somarTotalDespesa(valorTotalDespesaDouble);

					JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Editar", JOptionPane.PLAIN_MESSAGE);
				} else if (cpfCerto == false) {
					JOptionPane.showMessageDialog(null, "O CPF inserido é invalido", "Erro", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Já existe uma pessoa com esse CPF nesse grupo", "Erro",
							JOptionPane.PLAIN_MESSAGE);
				}
			} catch (NumberFormatException exception) {
				// Verifica se o novo total de despesas é um double
				JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro", JOptionPane.PLAIN_MESSAGE);
			}

		} else if (e.getSource() == excluir) {
			// Exclui a pessoa
			Database.getGrupos().get(posicaoGrupo).getPessoas().remove(posicaoPessoa);
			Database.getGrupos().get(posicaoGrupo).diminuirQtdePessoas();
			JOptionPane.showMessageDialog(null, "Pessoa removida", "Deletar", JOptionPane.PLAIN_MESSAGE);
			new TelaListagemPessoas(0);
			dispose();

		}

	}

}
