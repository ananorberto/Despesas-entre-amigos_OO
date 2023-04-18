package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControleGrupo;

/**
 * Classe TelaAddGrupo faz com que o usuario cadastre um novo grupo por meio da
 * interface grafica.
 * 
 * @author Ana Beatriz, Leonardo
 * @since 2022
 * @version 1.0
 * 
 * 
 *
 */
public class TelaAddGrupo extends JFrame implements ActionListener {

	private final JLabel labelNome = new JLabel("Nome: ");
	private final JTextField nome = new JTextField();
	private final JLabel labelId = new JLabel("ID: ");
	private final JTextField idGrupo = new JTextField();
	private final JLabel labelQtde = new JLabel("Máximo de pessoas: ");
	private final JTextField maxPessoas = new JTextField();
	private final JButton cadastrar = new JButton("Cadastrar");
	private final JButton voltar = new JButton("Voltar");

	/**
	 * Construtor responsavel por determinar a posição de cada botao da tela, as
	 * cores dos botoes e torna-los visiveis para o usuario.
	 */
	public TelaAddGrupo() {
		super("Cadastrar grupo");
		JLabel label_titulo = new JLabel("Cadastre as seguintes informações");
		label_titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
		label_titulo.setBounds(90, 10, 400, 40);

		labelNome.setBounds(50, 70, 420, 30);
		nome.setBounds(100, 70, 400, 30);

		labelId.setBounds(50, 110, 420, 30);
		idGrupo.setBounds(80, 110, 420, 30);

		labelQtde.setBounds(50, 150, 420, 30);
		maxPessoas.setBounds(230, 150, 270, 30);

		voltar.setBounds(70, 220, 180, 30);
		voltar.setBackground(new Color(108, 112, 139));
		voltar.setForeground(new Color(222, 222, 245));
		voltar.addActionListener(this);

		cadastrar.setBounds(260, 220, 180, 30);
		cadastrar.setBackground(new Color(108, 112, 139));
		cadastrar.setForeground(new Color(222, 222, 245));
		cadastrar.addActionListener(this);

		setLayout(null);
		add(label_titulo);
		add(labelNome);
		add(nome);
		add(labelId);
		add(idGrupo);
		add(labelQtde);
		add(maxPessoas);
		add(cadastrar);
		add(voltar);

		setSize(520, 340);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));

	}

	/**
	 * Metodo que da funcionalidade aos botoes voltar (voltando para a tela de Menu)
	 * e cadastrar (identificando as informacoes digitadas pelo usuario e
	 * cadastrando um novo grupo).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			// Volta para o menu
			TelaMenu menu = new TelaMenu();
			dispose();
		} else if (e.getSource() == cadastrar) {
			// Tenta cadastrar um grupo
			String nomeString = nome.getText();
			String idString = idGrupo.getText();
			String maxPessoasString = maxPessoas.getText();

			ControleGrupo.cadastrarGrupo(nomeString, idString, maxPessoasString);

		}
	}
}
