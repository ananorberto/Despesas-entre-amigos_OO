package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.model_database.Database;

public class TelaMenu extends JFrame implements ActionListener {

	private final JLabel label_titulo = new JLabel("Despesas entre amigos");
	private final JButton add_grupo = new JButton("Cadastrar Grupo");
	private final JButton add_pessoa = new JButton("Cadastrar Pessoa");
	private final JButton add_compra = new JButton("Adicionar Compra");
	private final JButton add_imovel = new JButton("Adicionar Imovel");
	private final JButton mostrar_divida = new JButton("Mostrar Divida");
	private final JButton mostrar_grupos_cadastros = new JButton("Grupos cadastrados");
	private final JButton mostrar_pessoas_cadastradas = new JButton("Pessoas cadastradas");

	public TelaMenu() {
		super("Divisão de Despesas entre amigos");

		label_titulo.setFont(new Font(("Verdana"), Font.PLAIN, 25));
		label_titulo.setBounds(120, 10, 300, 40);

		add_grupo.setBounds(160, 70, 180, 30);
		add_grupo.setBackground(new Color(108, 112, 139, 255));
		add_grupo.setForeground(new Color(222, 222, 245));
		add_grupo.addActionListener(this);

		add_pessoa.setBounds(160, 110, 180, 30);
		add_pessoa.setBackground(new Color(108, 112, 139));
		add_pessoa.setForeground(new Color(222, 222, 245));
		add_pessoa.addActionListener(this);

		add_compra.setBounds(160, 150, 180, 30);
		add_compra.setBackground(new Color(108, 112, 139));
		add_compra.setForeground(new Color(222, 222, 245));
		add_compra.addActionListener(this);

		add_imovel.setBounds(160, 190, 180, 30);
		add_imovel.setBackground(new Color(108, 112, 139));
		add_imovel.setForeground(new Color(222, 222, 245));
		add_imovel.addActionListener(this);

		mostrar_divida.setBounds(160, 230, 180, 30);
		mostrar_divida.setBackground(new Color(108, 112, 139));
		mostrar_divida.setForeground(new Color(222, 222, 245));
		mostrar_divida.addActionListener(this);

		mostrar_grupos_cadastros.setBounds(160, 270, 180, 30);
		mostrar_grupos_cadastros.setBackground(new Color(108, 112, 139));
		mostrar_grupos_cadastros.setForeground(new Color(222, 222, 245));
		mostrar_grupos_cadastros.addActionListener(this);

		mostrar_pessoas_cadastradas.setBounds(160, 310, 180, 30);
		mostrar_pessoas_cadastradas.setBackground(new Color(108, 112, 139));
		mostrar_pessoas_cadastradas.setForeground(new Color(222, 222, 245));
		mostrar_pessoas_cadastradas.addActionListener(this);

		setLayout(null);

		add(label_titulo);
		add(add_grupo);
		add(add_pessoa);
		add(add_compra);
		add(add_imovel);
		add(mostrar_divida);
		add(mostrar_pessoas_cadastradas);
		add(mostrar_grupos_cadastros);

		setSize(520, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(true);
		setLocationRelativeTo(null);// Centraliza o JFrame
		getContentPane().setBackground(new Color(227, 227, 236));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add_grupo) {
			new TelaAddGrupo();
		}
		if (e.getSource() == add_pessoa) {
			new TelaAddPessoa();
		}
		if (e.getSource() == add_compra) {
			new TelaAddCompra();
		}
		if (e.getSource() == add_imovel) {
			new TelaAddImovel();
		}
		if (e.getSource() == mostrar_divida) {
			new TelaMostrarDividas();
		}
		if (e.getSource() == mostrar_grupos_cadastros) {
			new TelaListagemGrupos().mostrarDados();
		}
		if (e.getSource() == mostrar_pessoas_cadastradas){
			new TelaListagemPessoas(0);
		}
		dispose();
	}

	public static void main(String[] args) {
		Database.pre_cadastrar_grupos();
		new TelaMenu();
	}
}