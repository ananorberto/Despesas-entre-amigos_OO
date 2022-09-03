package view;

import model.model_database.Database;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TelaEditarPessoa extends JFrame implements ActionListener {

	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelCpf = new JLabel("CPF: ");
	private JTextField valorCpf;
	private JLabel labelTotalDespesa = new JLabel("Valor total em despesas: ");
	private JTextField valorTotalDespesa;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoVoltar = new JButton("Voltar");
	private int posicao_grupo;
	private int posicao_pessoa;

	public TelaEditarPessoa(int pos_grupo, int pos_pessoa) {
		super("Detalhe Pessoa: ");
		
		posicao_grupo = pos_grupo;
		posicao_pessoa = pos_pessoa;
		
		valorNome = new JTextField(Database.getGrupos().get(posicao_grupo).getPessoas().get(posicao_pessoa).getNome(), 200);
		valorCpf = new JTextField(Database.getGrupos().get(posicao_grupo).getPessoas().get(posicao_pessoa).getCpf(), 200);
		valorTotalDespesa = new JTextField(String.valueOf(Database.getGrupos().get(posicao_grupo).getPessoas().get(posicao_pessoa).getTotal_despesa()), 200);
		
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		
		labelCpf.setBounds(30, 50, 180, 25);
		valorCpf.setBounds(180, 50, 180, 25);
		
		labelTotalDespesa.setBounds(30, 80, 180, 25);
		valorTotalDespesa.setBounds(180, 80, 180, 25);
		
		botaoSalvar.setBounds(130, 175, 115, 30);
		botaoExcluir.setBounds(255, 175, 115, 30);
		botaoVoltar.setBounds(10, 175, 115, 30);
		
		add(botaoExcluir);
		add(botaoVoltar);
		add(botaoSalvar);
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

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoVoltar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoVoltar) {
			new TelaListagemPessoas(0);
			dispose();
		}
		else if(e.getSource() == botaoSalvar) {
			String valorNomeString = valorNome.getText();
			String valorCpfString = valorCpf.getText();
			String valorTotalDespesaString = valorTotalDespesa.getText();
			
			try {
				double valorTotalDespesaDouble = Double.parseDouble(valorTotalDespesaString);
				
				Database.getGrupos().get(posicao_grupo).getPessoas().get(posicao_pessoa).setNome(valorNomeString);
				Database.getGrupos().get(posicao_grupo).getPessoas().get(posicao_pessoa).setCpf(valorCpfString);
				Database.getGrupos().get(posicao_grupo).getPessoas().get(posicao_pessoa).setTotal_despesa(valorTotalDespesaDouble);
				JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Editar",
						JOptionPane.PLAIN_MESSAGE);
				
			}
			catch(NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro",
						JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		else if(e.getSource() == botaoExcluir) {
			Database.getGrupos().get(posicao_grupo).getPessoas().remove(posicao_pessoa);
			Database.getGrupos().get(posicao_grupo).diminuir_qtde_pessoas();
			JOptionPane.showMessageDialog(null, "Pessoa removida",  "Deletar",
					JOptionPane.PLAIN_MESSAGE);
			new TelaListagemPessoas(0);
			dispose();
			
		}
		
	}

}
