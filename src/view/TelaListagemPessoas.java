package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.*;
import model.model_database.Database;


public class TelaListagemPessoas extends JFrame implements ActionListener, ListSelectionListener {
    /**
     * @param e the event to be processed
     */
    private JList<String> listaPessoasCadastradas;
    private JLabel label_id_grupo = new JLabel("ID do Grupo: ");
    private JTextField id_grupo = new JTextField();
    private String listaNomes[];
    private JButton button_voltar = new JButton("Voltar");
    private JButton button_procurar = new JButton("Procurar");
    private int posicao_grupo;
    

    public TelaListagemPessoas(int pos){
        super("Mostrar Pessoas Cadastradas");
        
        this.posicao_grupo = pos;
        
        label_id_grupo.setBounds(30, 20, 150, 25);
        add(label_id_grupo);
        
        id_grupo.setBounds(180, 20, 180, 25);
        add(id_grupo);
        
        button_procurar.setBounds(200, 290, 180, 30);
        button_procurar.setBackground(new Color(108, 112, 139));
        button_procurar.setForeground(new Color(222, 222, 245));
        button_procurar.addActionListener(this);
        add(button_procurar);
        
        button_voltar.setBounds(10, 290, 180, 30);
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
    public void mostrarDados(String[] getNomePessoa){
        listaPessoasCadastradas = new JList<>(getNomePessoa);
        listaPessoasCadastradas.setBounds(17, 60, 350, 170);
        listaPessoasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaPessoasCadastradas.addListSelectionListener(this);
        add(listaPessoasCadastradas);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_voltar) {
            new TelaMenu();
            dispose();
        }
        else if(e.getSource() == button_procurar) {
        	String id_grupoString = id_grupo.getText();
        	try {
        		int id_grupoInt = Integer.parseInt(id_grupoString);
        		for(int i = 0; i < Database.getQtde_grupos(); i++) {
        			if(Database.getGrupos().get(i).getId() == id_grupoInt) {
        				
        				this.posicao_grupo = Database.getGrupos().indexOf(Database.getGrupos().get(i));
        				listaNomes = ControlePessoas.getNomePessoas(this.posicao_grupo);
        				new TelaListagemPessoas(this.posicao_grupo).mostrarDados(listaNomes);
        				dispose();
        				break;
        			}
        			else if(i ==  (Database.getQtde_grupos() - 1)) {
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
			new TelaEditarPessoa(this.posicao_grupo, listaPessoasCadastradas.getSelectedIndex());
			dispose();
		}
        
    }

}
