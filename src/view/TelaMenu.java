package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import database.Database;

public class TelaMenu extends JFrame implements ActionListener {

	private final JLabel labelTitulo = new JLabel("Despesas entre amigos");
	private final JButton addGrupo = new JButton("Cadastrar Grupo");
	private final JButton addPessoa = new JButton("Cadastrar Pessoa");
	private final JButton addCompra = new JButton("Adicionar Compra");
	private final JButton addImovel = new JButton("Adicionar Imovel");
	private final JButton mostrarDivida = new JButton("Mostrar Dividas");
	private final JButton listagemGrupos = new JButton("Grupos cadastrados");
	private final JButton listagemPessoas = new JButton("Pessoas cadastradas");

	public TelaMenu() {
		super("Divisão de Despesas entre amigos");

		labelTitulo.setFont(new Font(("Verdana"), Font.PLAIN, 25));
		labelTitulo.setBounds(120, 10, 300, 40);

		addGrupo.setBounds(160, 70, 180, 30);
		addGrupo.setBackground(new Color(108, 112, 139, 255));
		addGrupo.setForeground(new Color(222, 222, 245));
		addGrupo.addActionListener(this);

		addPessoa.setBounds(160, 110, 180, 30);
		addPessoa.setBackground(new Color(108, 112, 139));
		addPessoa.setForeground(new Color(222, 222, 245));
		addPessoa.addActionListener(this);

		addCompra.setBounds(160, 150, 180, 30);
		addCompra.setBackground(new Color(108, 112, 139));
		addCompra.setForeground(new Color(222, 222, 245));
		addCompra.addActionListener(this);

		addImovel.setBounds(160, 190, 180, 30);
		addImovel.setBackground(new Color(108, 112, 139));
		addImovel.setForeground(new Color(222, 222, 245));
		addImovel.addActionListener(this);

		mostrarDivida.setBounds(160, 230, 180, 30);
		mostrarDivida.setBackground(new Color(108, 112, 139));
		mostrarDivida.setForeground(new Color(222, 222, 245));
		mostrarDivida.addActionListener(this);

		listagemGrupos.setBounds(160, 270, 180, 30);
		listagemGrupos.setBackground(new Color(108, 112, 139));
		listagemGrupos.setForeground(new Color(222, 222, 245));
		listagemGrupos.addActionListener(this);

		listagemPessoas.setBounds(160, 310, 180, 30);
		listagemPessoas.setBackground(new Color(108, 112, 139));
		listagemPessoas.setForeground(new Color(222, 222, 245));
		listagemPessoas.addActionListener(this);

		setLayout(null);

		add(labelTitulo);
		add(addGrupo);
		add(addPessoa);
		add(addCompra);
		add(addImovel);
		add(mostrarDivida);
		add(listagemPessoas);
		add(listagemGrupos);

		setSize(520, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);
		setLocationRelativeTo(null);// Centraliza o JFrame
		getContentPane().setBackground(new Color(227, 227, 236));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addGrupo) {
			new TelaAddGrupo();
		}
		if (e.getSource() == addPessoa) {
			new TelaAddPessoa();
		}
		if (e.getSource() == addCompra) {
			new TelaAddCompra();
		}
		if (e.getSource() == addImovel) {
			new TelaAddImovel();
		}
		if (e.getSource() == mostrarDivida) {
			new TelaMostrarDividas();
		}
		if (e.getSource() == listagemGrupos) {
			new TelaListagemGrupos().mostrarDados();
		}
		if (e.getSource() == listagemPessoas){
			new TelaListagemPessoas(0);
		}
		dispose();
	}

	public static void main(String[] args) {
		Database.preCadastrarGrupos();
		new TelaMenu();
	}
}