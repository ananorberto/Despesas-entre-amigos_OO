package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.*;

public class TelaAddImovel extends JFrame implements ActionListener {

	private final JLabel titulo = new JLabel("Cadastre as seguintes informações");
	private final JLabel labelIdGrupo = new JLabel("ID do Grupo: ");
	private final JTextField idGrupo = new JTextField();
	private final JLabel labelId = new JLabel("ID do Pagador: ");
	private JTextField idPagador = new JTextField();
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

	public TelaAddImovel() {
		titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
		titulo.setBounds(90, 10, 400, 40);

		// CONFIGURAÇÃO PENDENTE
		labelContaLuz.setBounds(50, 70, 420, 30);
		contaLuz.setBounds(220, 70, 270, 30);

		labelContaAgua.setBounds(50, 110, 420, 30);
		contaAgua.setBounds(225, 110, 265, 30);

		labelAluguel.setBounds(50, 150, 420, 30);
		aluguel.setBounds(230, 150, 260, 30);

		labelId.setBounds(50, 190, 420, 30);
		idPagador.setBounds(160, 190, 330, 30);

		labelIdGrupo.setBounds(50, 230, 420, 30);
		idGrupo.setBounds(160, 230, 330, 30);

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
		add(labelId);
		add(idPagador);
		add(labelIdGrupo);
		add(idGrupo);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			TelaMenu menu = new TelaMenu();
			dispose();
		}
		else if(e.getSource() == cadastrar) {
			 
			String enderecoString = endereco.getText(); 
			String contaLuzString = contaLuz.getText(); 
			String contaAguaString = contaAgua.getText();
			String aluguelString = aluguel.getText();
			String dataString = data.getText();
			String idPagadorString = idPagador.getText();
			String idGrupoString = idGrupo.getText();
			
			ControleDespesa.cadastrarImovel(enderecoString, contaLuzString, contaAguaString, aluguelString, 
											dataString, idPagadorString, idGrupoString);
			
			
		}
	}
}