package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controller.ControleGrupo;
import model.model_database.Database;

public class DetalheGrupo extends JFrame implements ActionListener {

	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelMaxPessoas = new JLabel("Máximo de Pessoas: ");
	private JTextField valorMaxPessoas;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoVoltar = new JButton("Voltar");
	private int posicao;
	
	public DetalheGrupo(int pos) {
		super("Detalhes do Grupo");
		
		posicao = pos;
		
		valorNome = new JTextField(Database.getGrupos().get(posicao).getNome(), 200);
		valorMaxPessoas = new JTextField(String.valueOf(Database.getGrupos().get(posicao).getMax_pessoas()),200);
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelMaxPessoas.setBounds(30, 50, 150, 25);
		valorMaxPessoas.setBounds(180, 50, 180, 25);
		
		botaoSalvar.setBounds(130, 175, 115, 30);
		botaoExcluir.setBounds(255, 175, 115, 30);
		botaoVoltar.setBounds(10, 175, 115, 30);
		
		add(botaoExcluir);
		add(botaoVoltar);
		add(botaoSalvar);
		add(labelNome);
		add(valorNome);
		add(labelMaxPessoas);
		add(valorMaxPessoas);
		
		setLayout(null);
		setSize(400, 250);
		setVisible(true);
		setLocationRelativeTo(null);
		
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoVoltar.addActionListener(this);
		
	}
	
	

	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoVoltar) {
			new CadastrosGrupo().mostrarDados();
			dispose();
		}
		else if(src == botaoSalvar) {
			try {
				String nomeString = valorNome.getText();
				String maxPessoasString = valorMaxPessoas.getText();
				
				int maxPessoasInt = Integer.parseInt(maxPessoasString);
				
				if(maxPessoasInt >= Database.getGrupos().get(posicao).getMax_pessoas()) {
					Database.getGrupos().get(posicao).setNome(nomeString);
					Database.getGrupos().get(posicao).setMax_pessoas(maxPessoasInt);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Editar",
													JOptionPane.PLAIN_MESSAGE);
				
				}
				else {
					JOptionPane.showMessageDialog(null, " Nao foi possivel salvar,"
													+ " pois o maximo de pessoas so pode ser maior "
													+ "ou igual ao valor anterior", 
													"Erro",
													JOptionPane.PLAIN_MESSAGE);
				}
				
			}
			catch(NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo",  "Erro",
												JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if(src == botaoExcluir) {
			Database.getGrupos().remove(posicao);
			Database.diminuir_Qtde_grupos();
			JOptionPane.showMessageDialog(null, "Grupo removido",  "Deletar",
					JOptionPane.PLAIN_MESSAGE);
			new CadastrosGrupo().mostrarDados();
			dispose();
			
			
		}
		
	}

	
	
}
