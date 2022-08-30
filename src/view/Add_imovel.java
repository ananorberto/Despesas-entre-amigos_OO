package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add_imovel extends JFrame implements ActionListener {

	private final JLabel titulo = new JLabel("Cadastre as seguintes informações");
	private final JLabel labelIdGrupo = new JLabel("ID do Grupo: ");
	private final JTextField id_grupo = new JTextField();
	private final JLabel labelId = new JLabel("ID do Pagador: ");
	private JTextField id = new JTextField();
	private final JLabel labelContaLuz = new JLabel("Valor da Conta de Luz: ");
	private JTextField conta_luz = new JTextField();
	private final JLabel labelContaAgua = new JLabel("Valor da Conta de Agua: ");
	private JTextField conta_agua = new JTextField();
	private final JLabel labelAluguel = new JLabel("Digite o valor do aluguel: ");
	private JTextField aluguel = new JTextField();
	private final JLabel labelEndereco = new JLabel("Endereço: ");
	private JTextField endereco = new JTextField();
	private final JLabel labelData = new JLabel("Data: ");
	private JTextField data = new JTextField();
	private final JButton Button_cadastrar = new JButton("Cadastrar");
	private final JButton Button_voltar = new JButton("Voltar");

	public Add_imovel() {
		titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
		titulo.setBounds(90, 10, 400, 40);

		// CONFIGURAÇÃO PENDENTE
		labelContaLuz.setBounds(50, 70, 420, 30);
		conta_luz.setBounds(220, 70, 270, 30);

		labelContaAgua.setBounds(50, 110, 420, 30);
		conta_agua.setBounds(225, 110, 265, 30);

		labelAluguel.setBounds(50, 150, 420, 30);
		aluguel.setBounds(230, 150, 260, 30);

		labelId.setBounds(50, 190, 420, 30);
		id.setBounds(160, 190, 330, 30);

		labelIdGrupo.setBounds(50, 230, 420, 30);
		id_grupo.setBounds(160, 230, 330, 30);

		labelEndereco.setBounds(50, 270, 420, 30);
		endereco.setBounds(130, 270, 360, 30);

		labelData.setBounds(50, 310, 420, 30);
		data.setBounds(100, 310, 390, 30);

		Button_voltar.setBounds(70, 370, 180, 30);
		Button_voltar.setBackground(new Color(108, 112, 139));
		Button_voltar.setForeground(new Color(222, 222, 245));
		Button_voltar.addActionListener(this);

		Button_cadastrar.setBounds(260, 370, 180, 30);
		Button_cadastrar.setBackground(new Color(108, 112, 139));
		Button_cadastrar.setForeground(new Color(222, 222, 245));

		setLayout(null);
		add(titulo);
		add(labelContaLuz);
		add(conta_luz);
		add(labelContaAgua);
		add(conta_agua);
		add(labelId);
		add(id);
		add(labelIdGrupo);
		add(id_grupo);
		add(labelEndereco);
		add(endereco);
		add(Button_cadastrar);
		add(Button_voltar);
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
		if (e.getSource() == Button_voltar) {
			Menu menu = new Menu();
			dispose();
		}
	}
}
