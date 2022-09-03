package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.*;

public class TelaAddCompra extends JFrame implements ActionListener {

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


    public TelaAddCompra(){
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
            TelaMenu menu = new TelaMenu();
            dispose();
        }
        else if(e.getSource() == cadastrar) {
        	
        	String nome_mercadoString = nome_mercado.getText();
            String id_pagadorString = id_pagador.getText();
            String id_grupoString = id_grupo.getText();
            String itensString = itens.getText();
            String valorString = valor.getText();
            String dataString = data.getText();            
            
            ControleDespesa.cadastrarCompra(nome_mercadoString, id_pagadorString, id_grupoString, itensString, valorString, dataString);
           
        }
    }

}
