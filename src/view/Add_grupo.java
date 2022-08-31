package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.*;
import model.model_database.Database;

public class Add_grupo extends JFrame implements ActionListener {

	private final JLabel labelNome = new JLabel("Nome: ");
	private final JTextField nome = new JTextField();
	private final JLabel labelId = new JLabel("ID: ");
	private final JTextField id = new JTextField();
	private final JLabel labelQtde = new JLabel("Máximo de pessoas: ");
	private final JTextField max_pessoas = new JTextField();
	private final JButton Button_cadastrar = new JButton("Cadastrar");
	private final JButton Button_voltar = new JButton("Voltar");

	public Add_grupo() {
		super("Cadastrar grupo");
		JLabel label_titulo = new JLabel("Cadastre as seguintes informações");
		label_titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
		label_titulo.setBounds(90, 10, 400, 40);

		labelNome.setBounds(50, 70, 420, 30);
		nome.setBounds(100, 70, 400, 30);

		labelId.setBounds(50, 110, 420, 30);
		id.setBounds(80, 110, 420, 30);

		labelQtde.setBounds(50, 150, 420, 30);
		max_pessoas.setBounds(230, 150, 270, 30);

		Button_voltar.setBounds(70, 220, 180, 30);
		Button_voltar.setBackground(new Color(108, 112, 139));
		Button_voltar.setForeground(new Color(222, 222, 245));
		Button_voltar.addActionListener(this);

		Button_cadastrar.setBounds(260, 220, 180, 30);
		Button_cadastrar.setBackground(new Color(108, 112, 139));
		Button_cadastrar.setForeground(new Color(222, 222, 245));
		Button_cadastrar.addActionListener(this);

		setLayout(null);
		add(label_titulo);
		add(labelNome);
		add(nome);
		add(labelId);
		add(id);
		add(labelQtde);
		add(max_pessoas);
		add(Button_cadastrar);
		add(Button_voltar);

		setSize(520, 340);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Button_voltar) {
			Menu menu = new Menu();
			dispose();
		} else if (e.getSource() == Button_cadastrar) {
			String nomeString = nome.getText();
			String idString = id.getText();
			String max_pessoasString = max_pessoas.getText();
			boolean nao_repete = true;
			try {
				int idInt = Integer.parseInt(idString);
				int max_pessoasInt = Integer.parseInt(max_pessoasString);

				for(int i = 0; i < Database.getQtde_grupos(); i++) {
					if(Database.getGrupos().get(i).getId() == idInt) {
						nao_repete = false;
						break;
					}
				}
				
				
				if(nao_repete == true) {
					Grupo novo_grupo = new Grupo(max_pessoasInt, idInt, nomeString);
					
					Database.getGrupos().add(novo_grupo);
					Database.aumentar_contador_grupos();
	
					JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro",
							JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Ja existe um grupo com esse ID",
													"ID repetido", JOptionPane.PLAIN_MESSAGE);
				}
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
												"Erro", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	public static void main(String[] args) {
		Add_grupo tela = new Add_grupo();
	}

}
