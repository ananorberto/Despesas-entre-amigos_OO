package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;
import model_database.Database;

public class Add_compra extends JFrame implements ActionListener {

    private final  JLabel titulo = new JLabel("Cadastre as seguintes informações");
    private final JLabel labelIdGrupo = new JLabel("ID do Grupo: ");
	private final JTextField id_grupo = new JTextField();
    private final JLabel labelId = new JLabel("ID do Pagador: ");
    private final JTextField id_pagador = new JTextField();
    private final JLabel labelMercado = new JLabel("Nome do Mercado: ");
    private final JTextField nome_mercado = new JTextField();
    private final JLabel labelItens = new JLabel("Itens da compra: ");
	private final JTextField itens = new JTextField();
    private final JLabel labelValor= new JLabel("Valor da compra: ");
    private final JTextField valor = new JTextField();
    private final JLabel labelData= new JLabel("Data da compra: ");
    private final JTextField data = new JTextField();
    private final JButton cadastrar = new JButton("Cadastrar");
    private final JButton voltar = new JButton("Voltar");


    public Add_compra(){
    	super("cadastrar compra");
		titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
		titulo.setBounds(90, 10, 400, 40);

		labelMercado.setBounds(50, 70, 420, 30);
		nome_mercado.setBounds(190, 70, 300, 30);

		labelId.setBounds(50, 110, 420, 30);
		id_pagador.setBounds(160, 110, 330, 30);

		labelIdGrupo.setBounds(50, 150, 420, 30);
		id_grupo.setBounds(160, 150, 330, 30);

		labelItens.setBounds(50, 190, 420, 30);
		itens.setBounds(175, 190, 315, 30);

		labelValor.setBounds(50, 230, 420, 30);
		valor.setBounds(175, 230, 315, 30);

		labelData.setBounds(50, 270, 420, 30);
		data.setBounds(170, 270, 320, 30);

		voltar.setBounds(70, 330, 180, 30);
		voltar.setBackground(new Color(108, 112, 139));
		voltar.setForeground(new Color(222, 222, 245));
		voltar.addActionListener(this);

		cadastrar.setBounds(260, 330, 180, 30);
		cadastrar.setBackground(new Color(108, 112, 139));
		cadastrar.setForeground(new Color(222, 222, 245));
        cadastrar.addActionListener(this);
        
        setLayout(null);
        add(titulo);
        add(labelMercado);
        add(nome_mercado);
        add(labelId);
        add(id_pagador);
        add(labelIdGrupo);
		add(id_grupo);
		add(labelItens);
		add(itens);
        add(labelValor);
        add(valor);
        add(cadastrar);
        add(voltar);
        add(labelData);
        add(data);

        setSize(520, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltar) {
            Menu menu = new Menu();
            dispose();
        }
        else if(e.getSource() == cadastrar) {
        	Database.pre_cadastrar_grupos();
        	
        	String nome_mercadoString = nome_mercado.getText();
            String id_pagadorString = id_pagador.getText();
            String id_grupoString = id_grupo.getText();
            String itensString = itens.getText();
            String valorString = valor.getText();
            String dataString = data.getText();
            boolean acabou = false;
            int qtde_grupos = Database.getQtde_grupos();
            int id_g1 = Database.getGrupos().get(0).getId();
            
            try {
                int id_pagadorInt = Integer.parseInt(id_pagadorString);
                int id_grupoInt = Integer.parseInt(id_grupoString);
                double valorDouble = Double.parseDouble(valorString);
                
                for(int i = 0; i < Database.getQtde_grupos(); i++) {
                	if( Database.getGrupos().get(i).getId() == id_grupoInt) {
                		//Achou o grupo
                		for(int j = 0; j < Database.getGrupos().get(i).getQtde_pessoas(); j++) {
                			if(Database.getGrupos().get(i).getPessoas().get(j).getId() == id_pagadorInt) {
                				//Achou a pessoa
                				acabou = true;
	                			Compra nova_compra = new Compra(nome_mercadoString, valorDouble, dataString, 
		                											id_pagadorInt, id_grupoInt, itensString);
		                		Database.getGrupos().get(i).getDespesas().add(nova_compra);
		                		Database.getGrupos().get(i).aumentar_qtde_despesas();
		                		
		                		Database.getGrupos().get(i).getPessoas().get(j).setTotal_despesa(valorDouble);
		                		
		                		JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", 
		 														"Cadastro", JOptionPane.PLAIN_MESSAGE);
		                		
		                		break;
	                		}
                			else if(j == (Database.getGrupos().get(i).getQtde_despesas() - 1)){
                				//Nao achou a pessoa
                				JOptionPane.showMessageDialog(null, "Nao encontramos uma pessoa com o ID inserido", 
         								"Pessoa nao encontrada", JOptionPane.PLAIN_MESSAGE);
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
                		JOptionPane.showMessageDialog(null, "Nao encontramos um grupo com o ID inserido", 
                        								"Grupo nao encontrado", JOptionPane.PLAIN_MESSAGE);
                	}
                }

            }
            catch(NumberFormatException exception){
            	JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
                								"Erro", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    public static void main(String[] args) {
    	Add_compra tela = new Add_compra();
    }

}
