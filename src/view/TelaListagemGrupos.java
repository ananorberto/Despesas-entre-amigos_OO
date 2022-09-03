package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controller.ControleGrupo;
import model.model_database.Database;

public class TelaListagemGrupos extends JFrame implements ActionListener, ListSelectionListener{

	private JList<String> listaGruposCadastrados;
	private String[] listaNomes = new String[Database.getQtde_grupos()];
	private JButton button_voltar = new JButton("Voltar");

	public TelaListagemGrupos() {
		super("Mostrar Grupos Cadastrados");

		button_voltar.setBounds(120, 290, 180, 30);
		button_voltar.setBackground(new Color(108, 112, 139));
		button_voltar.setForeground(new Color(222, 222, 245));
		button_voltar.addActionListener(this);
		add(button_voltar);


		setSize(400, 390);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(187, 190, 210, 215));
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);

	}

	public void mostrarDados() {		
		listaNomes = ControleGrupo.getNomeGrupo();
		listaGruposCadastrados = new JList<>(listaNomes);
		listaGruposCadastrados.setBounds(17, 40, 350, 170);
		listaGruposCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaGruposCadastrados.addListSelectionListener(this);
		add(listaGruposCadastrados);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_voltar){
			TelaMenu menu = new TelaMenu();
			dispose();
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaGruposCadastrados) {
			new TelaEditarGrupo(listaGruposCadastrados.getSelectedIndex());
			dispose();
		}
	}

}
