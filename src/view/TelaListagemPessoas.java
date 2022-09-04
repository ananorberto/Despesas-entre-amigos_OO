package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.*;
import database.Database;


public class TelaListagemPessoas extends JFrame implements ActionListener, ListSelectionListener {
    /**
     * @param e the event to be processed
     */
    private JList<String> listaPessoasCadastradas;
    private JLabel labelIdGrupo = new JLabel("ID do Grupo: ");
    private JTextField idGrupo = new JTextField();
    private String listaNomes[];
    private JButton voltar = new JButton("Voltar");
    private JButton buscar = new JButton("Buscar");
    private int posicaoGrupo;
    

    public TelaListagemPessoas(int pos){
        super("Mostrar Pessoas Cadastradas");
        
        this.posicaoGrupo = pos;
        
        labelIdGrupo.setBounds(30, 20, 150, 25);
        add(labelIdGrupo);
        
        idGrupo.setBounds(180, 20, 180, 25);
        add(idGrupo);
        
        buscar.setBounds(200, 290, 180, 30);
        buscar.setBackground(new Color(108, 112, 139));
        buscar.setForeground(new Color(222, 222, 245));
        buscar.addActionListener(this);
        add(buscar);
        
        voltar.setBounds(10, 290, 180, 30);
        voltar.setBackground(new Color(108, 112, 139));
        voltar.setForeground(new Color(222, 222, 245));
        voltar.addActionListener(this);
        add(voltar);


        setSize(400, 390);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(187, 190, 210, 215));
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    public void mostrarDados(String[] getNomePessoa){
        listaPessoasCadastradas = new JList<>(getNomePessoa);
        listaPessoasCadastradas.setBounds(17, 60, 350, 170);
        listaPessoasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaPessoasCadastradas.addListSelectionListener(this);
        add(listaPessoasCadastradas);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltar) {
            new TelaMenu();
            dispose();
        }
        else if(e.getSource() == buscar) {
        	String id_grupoString = idGrupo.getText();
        	try {
        		int id_grupoInt = Integer.parseInt(id_grupoString);
        		for(int i = 0; i < Database.getQtdeGrupos(); i++) {
        			if(Database.getGrupos().get(i).getId() == id_grupoInt) {
        				
        				this.posicaoGrupo = Database.getGrupos().indexOf(Database.getGrupos().get(i));
        				listaNomes = ControlePessoas.getNomePessoas(this.posicaoGrupo);
        				new TelaListagemPessoas(this.posicaoGrupo).mostrarDados(listaNomes);
        				dispose();
        				break;
        			}
        			else if(i ==  (Database.getQtdeGrupos() - 1)) {
        				JOptionPane.showMessageDialog(null, "Nao encontramos um grupo com o ID inserido", 
        						"ID nao encontrado", JOptionPane.PLAIN_MESSAGE);
        			}
        		}
        		
        		
        	}
        	catch(NumberFormatException exception) {
        		JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
						"Erro", JOptionPane.PLAIN_MESSAGE);
        	}
        }
    }

    /**
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
        
        if(e.getValueIsAdjusting() && src == listaPessoasCadastradas) {
			new TelaEditarPessoa(this.posicaoGrupo, listaPessoasCadastradas.getSelectedIndex());
			dispose();
		}
        
    }

}
