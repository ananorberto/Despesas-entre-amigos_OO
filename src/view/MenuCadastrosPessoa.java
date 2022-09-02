package view;

import controller.ControleGrupo;
import model.Pessoa;
import model.model_database.Database;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MenuCadastrosPessoa extends JFrame implements ActionListener {

	private final JLabel titulo = new JLabel("Insira o ID do grupo para ver as pessoas cadastradas");
	private final JLabel labelId = new JLabel("ID do grupo: ");
	private JTextField id_grupo = new JTextField();
	private final JButton voltar = new JButton("Voltar");
	private final JButton ok = new JButton("OK");

	public MenuCadastrosPessoa() {
		super("Deletar Grupo");

		titulo.setFont(new Font(("Verdana"), Font.PLAIN, 17));
		titulo.setBounds(40, 10, 500, 40);

		labelId.setBounds(40, 70, 420, 30);
		id_grupo.setBounds(130, 70, 360, 30);

		voltar.setBounds(70, 130, 180, 30);
		voltar.setBackground(new Color(108, 112, 139));
		voltar.setForeground(new Color(222, 222, 245));
		voltar.addActionListener(this);

		ok.setBounds(260, 130, 180, 30);
		ok.setBackground(new Color(108, 112, 139));
		ok.setForeground(new Color(222, 222, 245));
		ok.addActionListener(this);

		setLayout(null);
		add(titulo);
		add(labelId);
		add(id_grupo);
		add(voltar);
		add(ok);

		setSize(520, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			Menu menu = new Menu();
			dispose();
		}
		else if (e.getSource() == ok) {
			String id_grupoString = id_grupo.getText();

			try {
				int id_grupoInt = Integer.parseInt(id_grupoString);

				String[] getNomePessoa = new String[Database.getQtde_grupos()];

				for (int i = 0; i < Database.getQtde_grupos(); i++) {
					if (Database.getGrupos().get(i).getId() == id_grupoInt) {
						getNomePessoa[i] = Database.getGrupos().get(i).getNova_pessoa().getNome();

						new CadastrosPessoa().mostrarDados(getNomePessoa);
						dispose();
						break;
					}
					else if(i == (Database.getQtde_grupos() - 1)){
						JOptionPane.showMessageDialog(null, "Nao encontramos um grupo com o ID inserido ou o grupo esta vazio",
								"Ops!", JOptionPane.PLAIN_MESSAGE);
						dispose();
						new MenuCadastrosPessoa();
					}
				}
			}catch (NumberFormatException exception){
				JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo",
					"Erro", JOptionPane.PLAIN_MESSAGE);
				dispose();
				new MenuCadastrosPessoa();
			}
		}
	}

	public static void main(String[] args) {
		Database.pre_cadastrar_grupos();
		new MenuCadastrosPessoa();
	}
}
