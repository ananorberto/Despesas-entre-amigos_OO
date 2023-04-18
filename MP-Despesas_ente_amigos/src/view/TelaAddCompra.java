package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControleDespesa;

/**
 * Classe TelaAddCompra faz com que o usuario cadastre uma nova compra por meio
 * da interface grafica.
 * 
 * @author Ana Beatriz, Leonardo
 * @since 2022
 * @version 1.0
 *
 */
public class TelaAddCompra extends JFrame implements ActionListener {

	private final JLabel titulo = new JLabel("Cadastre as seguintes informações");
	private final JLabel labelNomeGrupo = new JLabel("Nome do Grupo: ");
	private final JTextField nomeGrupo = new JTextField();
	private final JLabel labelCpf = new JLabel("CPF do Pagador: ");
	private final JTextField cpfPagador = new JTextField();
	private final JLabel labelMercado = new JLabel("Nome do Mercado: ");
	private final JTextField nomeMercado = new JTextField();
	private final JLabel labelItens = new JLabel("Itens da compra: ");
	private final JTextField itens = new JTextField();
	private final JLabel labelValor = new JLabel("Valor da compra: ");
	private final JTextField valor = new JTextField();
	private final JLabel labelData = new JLabel("Data da compra: ");
	private final JTextField data = new JTextField();
	private final JButton cadastrar = new JButton("Cadastrar");
	private final JButton voltar = new JButton("Voltar");

	/**
	 * Construtor responsavel por determinar a posição de cada botao, da tela, as
	 * cores dos botoes e torna-los visiveis para o usuario.
	 */
	public TelaAddCompra() {
		super("Cadastrar compra");
		titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
		titulo.setBounds(90, 10, 400, 40);

		labelMercado.setBounds(50, 70, 420, 30);
		nomeMercado.setBounds(190, 70, 300, 30);

		labelCpf.setBounds(50, 110, 420, 30);
		cpfPagador.setBounds(170, 110, 320, 30);

		labelNomeGrupo.setBounds(50, 150, 420, 30);
		nomeGrupo.setBounds(170, 150, 320, 30);

		labelItens.setBounds(50, 190, 420, 30);
		itens.setBounds(175, 190, 315, 30);

		labelValor.setBounds(50, 230, 420, 30);
		valor.setBounds(175, 230, 315, 30);

		labelData.setBounds(50, 270, 420, 30);
		data.setBounds(170, 270, 320, 30);

		voltar.setBounds(70, 330, 180, 30);
		voltar.setBackground(new Color(108, 112, 139));
		voltar.setForeground(new Color(222, 222, 245));
		voltar.addActionListener(this);

		cadastrar.setBounds(260, 330, 180, 30);
		cadastrar.setBackground(new Color(108, 112, 139));
		cadastrar.setForeground(new Color(222, 222, 245));
		cadastrar.addActionListener(this);

		setLayout(null);
		add(titulo);
		add(labelMercado);
		add(nomeMercado);
		add(labelCpf);
		add(cpfPagador);
		add(labelNomeGrupo);
		add(nomeGrupo);
		add(labelItens);
		add(itens);
		add(labelValor);
		add(valor);
		add(cadastrar);
		add(voltar);
		add(labelData);
		add(data);

		setSize(520, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));

	}

	/**
	 * Metodo que da funcionalidade aos botoes voltar (voltando para a tela de Menu)
	 * e cadastrar (identificando as informacoes digitadas pelo usuario e
	 * cadastrando em um grupo).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			// Volta para o menu
			TelaMenu menu = new TelaMenu();
			dispose();
		} else if (e.getSource() == cadastrar) {
			// Tenta cadastrar a compra
			String nomeMercadoString = nomeMercado.getText();
			String cpfPagadorString = cpfPagador.getText();
			String idGrupoString = nomeGrupo.getText();
			String itensString = itens.getText();
			String valorString = valor.getText();
			String dataString = data.getText();

			ControleDespesa.cadastrarCompra(nomeMercadoString, cpfPagadorString, idGrupoString, itensString,
					valorString, dataString);

		}
	}

}
