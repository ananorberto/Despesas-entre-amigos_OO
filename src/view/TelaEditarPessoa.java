package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import database.Database;

public class TelaEditarPessoa extends JFrame implements ActionListener {

	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelCpf = new JLabel("CPF: ");
	private JTextField valorCpf;
	private JLabel labelTotalDespesa = new JLabel("Valor total em despesas: ");
	private JTextField valorTotalDespesa;
	private JButton excluir = new JButton("Excluir");
	private JButton salvar = new JButton("Salvar");
	private JButton voltar = new JButton("Voltar");
	private int posicaoGrupo;
	private int posicaoPessoa;

	public TelaEditarPessoa(int pos_grupo, int pos_pessoa) {
		super("Detalhe Pessoa: ");
		
		posicaoGrupo = pos_grupo;
		posicaoPessoa = pos_pessoa;
		
		valorNome = new JTextField(Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).getNome(), 200);
		valorCpf = new JTextField(Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).getCpf(), 200);
		valorTotalDespesa = new JTextField(String.valueOf(Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).getTotalDespesa()), 200);
		
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		
		labelCpf.setBounds(30, 50, 180, 25);
		valorCpf.setBounds(180, 50, 180, 25);
		
		labelTotalDespesa.setBounds(30, 80, 180, 25);
		valorTotalDespesa.setBounds(180, 80, 180, 25);
		
		salvar.setBounds(130, 175, 115, 30);
		excluir.setBounds(255, 175, 115, 30);
		voltar.setBounds(10, 175, 115, 30);
		
		add(excluir);
		add(voltar);
		add(salvar);
		add(labelNome);
		add(valorNome);
		add(labelCpf);
		add(valorCpf);
		add(labelTotalDespesa);
		add(valorTotalDespesa);

		setLayout(null);


		setSize(520, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));

		salvar.addActionListener(this);
		excluir.addActionListener(this);
		voltar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			new TelaListagemPessoas(0);
			dispose();
		}
		else if(e.getSource() == salvar) {
			String valorNomeString = valorNome.getText();
			String valorCpfString = valorCpf.getText();
			String valorTotalDespesaString = valorTotalDespesa.getText();
			
			try {
				double valorTotalDespesaDouble = Double.parseDouble(valorTotalDespesaString);
				
				Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).setNome(valorNomeString);
				Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).setCpf(valorCpfString);
				Database.getGrupos().get(posicaoGrupo).getPessoas().get(posicaoPessoa).setTotalDespesa(valorTotalDespesaDouble);
				JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Editar",
											  JOptionPane.PLAIN_MESSAGE);
				
			}
			catch(NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro",
											  JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		else if(e.getSource() == excluir) {
			Database.getGrupos().get(posicaoGrupo).getPessoas().remove(posicaoPessoa);
			Database.getGrupos().get(posicaoGrupo).diminuirQtdePessoas();
			JOptionPane.showMessageDialog(null, "Pessoa removida",  "Deletar",
					JOptionPane.PLAIN_MESSAGE);
			new TelaListagemPessoas(0);
			dispose();
			
		}
		
	}

}
