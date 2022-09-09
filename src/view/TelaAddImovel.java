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
 * Classe TelaAddImovel faz com que o usuario cadastre as despesas de um imovel
 * por meio da interface grafica.
 * 
 * @author Ana Beatriz, Leonardo
 * @since 2022
 * @version 1.0
 *
 */
public class TelaAddImovel extends JFrame implements ActionListener {

	private final JLabel titulo = new JLabel("Cadastre as seguintes informações");
	private final JLabel labelNomeGrupo = new JLabel("Nome do Grupo: ");
	private final JTextField nomeGrupo = new JTextField();
	private final JLabel labelCpf = new JLabel("CPF do Pagador: ");
	private JTextField cpfPagador = new JTextField();
	private final JLabel labelContaLuz = new JLabel("Valor da Conta de Luz: ");
	private JTextField contaLuz = new JTextField();
	private final JLabel labelContaAgua = new JLabel("Valor da Conta de Agua: ");
	private JTextField contaAgua = new JTextField();
	private final JLabel labelAluguel = new JLabel("Digite o valor do aluguel: ");
	private JTextField aluguel = new JTextField();
	private final JLabel labelEndereco = new JLabel("Endereço: ");
	private JTextField endereco = new JTextField();
	private final JLabel labelData = new JLabel("Data: ");
	private JTextField data = new JTextField();
	private final JButton cadastrar = new JButton("Cadastrar");
	private final JButton voltar = new JButton("Voltar");

	/**
	 * Construtor responsavel por determinar a posição de cada botao, da tela, as
	 * cores dos botoes e torna-los visiveis para o usuario.
	 */
	public TelaAddImovel() {
		super("Cadastrar despesas do Imovel");

		titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
		titulo.setBounds(90, 10, 400, 40);

		// CONFIGURAÇÃO PENDENTE
		labelContaLuz.setBounds(50, 70, 420, 30);
		contaLuz.setBounds(220, 70, 270, 30);

		labelContaAgua.setBounds(50, 110, 420, 30);
		contaAgua.setBounds(225, 110, 265, 30);

		labelAluguel.setBounds(50, 150, 420, 30);
		aluguel.setBounds(230, 150, 260, 30);

		labelCpf.setBounds(50, 190, 420, 30);
		cpfPagador.setBounds(170, 190, 320, 30);

		labelNomeGrupo.setBounds(50, 230, 420, 30);
		nomeGrupo.setBounds(170, 230, 320, 30);

		labelEndereco.setBounds(50, 270, 420, 30);
		endereco.setBounds(130, 270, 360, 30);

		labelData.setBounds(50, 310, 420, 30);
		data.setBounds(100, 310, 390, 30);

		voltar.setBounds(70, 370, 180, 30);
		voltar.setBackground(new Color(108, 112, 139));
		voltar.setForeground(new Color(222, 222, 245));
		voltar.addActionListener(this);

		cadastrar.setBounds(260, 370, 180, 30);
		cadastrar.setBackground(new Color(108, 112, 139));
		cadastrar.setForeground(new Color(222, 222, 245));
		cadastrar.addActionListener(this);

		setLayout(null);
		add(titulo);
		add(labelContaLuz);
		add(contaLuz);
		add(labelContaAgua);
		add(contaAgua);
		add(labelCpf);
		add(cpfPagador);
		add(labelNomeGrupo);
		add(nomeGrupo);
		add(labelEndereco);
		add(endereco);
		add(cadastrar);
		add(voltar);
		add(labelData);
		add(data);
		add(labelAluguel);
		add(aluguel);

		setSize(520, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));

	}

	/**
	 * Metodo que da funcionalidade aos botoes voltar (voltando para a tela de Menu)
	 * e cadastrar (identificando as informacoes digitadas pelo usuario e
	 * cadastrando as despesas de um imovel em um grupo).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			// Volta para o menu
			TelaMenu menu = new TelaMenu();
			dispose();
		} else if (e.getSource() == cadastrar) {
			// Tenta cadastrar um imovel
			String enderecoString = endereco.getText();
			String contaLuzString = contaLuz.getText();
			String contaAguaString = contaAgua.getText();
			String aluguelString = aluguel.getText();
			String dataString = data.getText();
			String cpfPagadorString = cpfPagador.getText();
			String nomeGrupoString = nomeGrupo.getText();

			ControleDespesa.cadastrarImovel(enderecoString, contaLuzString, contaAguaString, aluguelString, dataString,
					cpfPagadorString, nomeGrupoString);

		}
	}
}