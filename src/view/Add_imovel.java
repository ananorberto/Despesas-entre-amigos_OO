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

public class Add_imovel extends JFrame implements ActionListener {

	private final JLabel titulo = new JLabel("Cadastre as seguintes informações");
	private final JLabel labelIdGrupo = new JLabel("ID do Grupo: ");
	private final JTextField id_grupo = new JTextField();
	private final JLabel labelId = new JLabel("ID do Pagador: ");
	private JTextField id_pagador = new JTextField();
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
		id_pagador.setBounds(160, 190, 330, 30);

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
		Button_cadastrar.addActionListener(this);

		setLayout(null);
		add(titulo);
		add(labelContaLuz);
		add(conta_luz);
		add(labelContaAgua);
		add(conta_agua);
		add(labelId);
		add(id_pagador);
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
		else if(e.getSource() == Button_cadastrar) {
			 
			String enderecoString = endereco.getText(); 
			String conta_luzString = conta_luz.getText(); 
			String conta_aguaString = conta_agua.getText();
			String aluguelString = aluguel.getText();
			String dataString = data.getText();
			String id_pagadorString = id_pagador.getText();
			String id_grupoString = id_grupo.getText();
			boolean acabou = false;
			
			 try {
	                int id_pagadorInt = Integer.parseInt(id_pagadorString);
	                int id_grupoInt = Integer.parseInt(id_grupoString);
	                double conta_luzDouble = Double.parseDouble(conta_luzString);
	                double conta_aguaDouble = Double.parseDouble(conta_aguaString);
	                double aluguelDouble = Double.parseDouble(aluguelString);

	                for(int i = 0; i < Database.getQtde_grupos(); i++) {
	                	if( Database.getGrupos().get(i).getId() == id_grupoInt) {
	                		//Achou o grupo
	                		for(int j = 0; j < Database.getGrupos().get(i).getQtde_pessoas(); j++) {
	                			if(Database.getGrupos().get(i).getPessoas().get(j).getId() == id_pagadorInt) {
	                				//Achou a pessoa
	                				acabou = true;
		                			Imovel novo_imovel = new Imovel(enderecoString, conta_luzDouble, conta_aguaDouble, 
		                											aluguelDouble, dataString, id_pagadorInt, id_grupoInt);
		                			
			                		novo_imovel.somar_gastos();
		                			
		                			Database.getGrupos().get(i).getDespesas().add(novo_imovel);
			                		Database.getGrupos().get(i).aumentar_qtde_despesas();
			                		Database.getGrupos().get(i).getPessoas().get(j).setTotal_despesa(novo_imovel.getValor());
			                		
			                		JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", 
			 														"Cadastro", JOptionPane.PLAIN_MESSAGE);
			                		
			                		break;
		                		}
	                			else if(j == (Database.getGrupos().get(i).getQtde_despesas() - 1)){
	                				//Nao achou a pessoa
	                				JOptionPane.showMessageDialog(null, "Nao encontramos uma pessoa ou um grupo com os IDs inseridos", 
	                						"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
		                			acabou = true;
		                		}
		  
	                		}
	                		if(acabou == true) {
	                			//Parar de procurar os grupos assim que encontrar a pessoa
	                			break;
	                		}
	                	
	                	}
	                	else if(i == (Database.getQtde_grupos() - 1)) {
	                		//Nao achou o grupo
	                		JOptionPane.showMessageDialog(null, "Nao encontramos uma pessoa ou um grupo com os IDs inseridos", 
	                											"Grupo ou pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
	                	}
	                }

	            }
	            catch(NumberFormatException exception){
	            	JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
	                								"Erro", JOptionPane.PLAIN_MESSAGE);
	            }
		}
	}
}