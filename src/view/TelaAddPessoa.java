package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControlePessoas;

/**
 * Classe TelaAddPessoa cadastra uma nova pessoa em um grupo por meio da
 * interface grafica.
 * 
 * @author Ana Beatriz, Leonardo
 * @since 2022
 * @version 1.0
 *
 */
public class TelaAddPessoa extends JFrame implements ActionListener {

	private final JLabel titulo = new JLabel("Cadastre as seguintes informações");
	private final JLabel labelNome = new JLabel("Nome: ");
	private final JTextField nome = new JTextField();
	private final JLabel labelId = new JLabel("ID: ");
	private final JTextField idPessoa = new JTextField();
	private final JLabel labelNomeGrupo = new JLabel("Nome do Grupo: ");
	private final JTextField nomeGrupo = new JTextField();
	private final JLabel labelCPF = new JLabel("CPF: ");
	private final JTextField cpf = new JTextField();
	private final JButton cadastrar = new JButton("Cadastrar");
	private final JButton voltar = new JButton("Voltar");

	/**
	 * Construtor responsavel por determinar a posição do JFrame,do botao, as cores
	 * dos botoes e torna-los visiveis para o usuario.
	 */
	public TelaAddPessoa() {
		super("Cadastrar usuario");

		titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
		titulo.setBounds(90, 10, 400, 40);

		labelNome.setBounds(50, 70, 420, 30);
		nome.setBounds(100, 70, 400, 30);

		labelId.setBounds(50, 110, 420, 30);
		idPessoa.setBounds(80, 110, 420, 30);

		labelNomeGrupo.setBounds(50, 150, 420, 30);
		nomeGrupo.setBounds(170, 150, 330, 30);

		labelCPF.setBounds(50, 190, 420, 30);
		cpf.setBounds(90, 190, 410, 30);

		voltar.setBounds(70, 250, 180, 30);
		voltar.setBackground(new Color(108, 112, 139));
		voltar.setForeground(new Color(222, 222, 245));
		voltar.addActionListener(this);

		cadastrar.setBounds(260, 250, 180, 30);
		cadastrar.setBackground(new Color(108, 112, 139));
		cadastrar.setForeground(new Color(222, 222, 245));
		cadastrar.addActionListener(this);

		setLayout(null);
		add(titulo);
		add(labelNome);
		add(nome);
		add(labelId);
		add(idPessoa);
		add(labelCPF);
		add(cpf);
		add(cadastrar);
		add(voltar);
		add(labelNomeGrupo);
		add(nomeGrupo);

		setSize(530, 340);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));

	}

	/**
	 * Metodo que da funcionalidade aos botoes voltar (voltando para a tela de Menu)
	 * e cadastrar (identificando as informacoes digitadas e cadastrando a pessoa em
	 * um grupo).
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			TelaMenu menu = new TelaMenu();
			dispose();
		} else if (e.getSource() == cadastrar) {
			
			String nomeString = nome.getText();
			String idPessoaString = idPessoa.getText();
			String cpfString = cpf.getText();
			String nomeGrupoString = nomeGrupo.getText();

			ControlePessoas.cadastrarPessoa(nomeString, idPessoaString, cpfString, nomeGrupoString);

		}
	}

}
