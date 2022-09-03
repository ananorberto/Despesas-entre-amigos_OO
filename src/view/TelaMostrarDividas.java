package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ControleGrupo;
import model.model_database.*;

public class TelaMostrarDividas extends JFrame implements ActionListener, ListSelectionListener {

    private  final JLabel titulo = new JLabel("Cadastre as seguintes informações");
    private  final JLabel labelId = new JLabel("ID do grupo: ");
    private  final JButton consultar = new JButton("Consultar");
    private JList<String> listaDividas;
    
   

    private JTextField id_grupo = new JTextField();
    private  final  JButton voltar = new JButton("Voltar");


    public TelaMostrarDividas(){
        super("Mostrar dividas");

        titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
        titulo.setBounds(90, 10, 400, 40);


        labelId.setBounds(40, 70, 420, 30);
        id_grupo.setBounds(130, 70, 360, 30);


        voltar.setBounds(60, 290, 180, 30);
        voltar.setBackground(new Color(108, 112, 139));
        voltar.setForeground(new Color(222, 222, 245));
        voltar.addActionListener(this);
        
        consultar.setBounds(250, 290, 180, 30);
        consultar.setBackground(new Color(108, 112, 139));
        consultar.setForeground(new Color(222, 222, 245));
        consultar.addActionListener(this);


        setLayout(null);
        add(titulo);
        add(labelId);
        add(id_grupo);
        add(voltar);
        add(consultar);

        setSize(520, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));

    }

    public void mostrarDados(int i, String dividas[]) {		
		
		listaDividas = new JList<>(dividas);
		listaDividas.setBounds(17, 150, 350, 170);
		listaDividas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaDividas.addListSelectionListener(this);
		add(listaDividas);

	}
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voltar) {
            TelaMenu menu = new TelaMenu();
            dispose();
        }
        else if(e.getSource() == consultar) {
	        String id_grupoString = id_grupo.getText();
	        	
	        try {
	        	int id_grupoInt = Integer.parseInt(id_grupoString);
	    
	        	for(int i = 0; i < Database.getQtde_grupos(); i++) {
	        		if((Database.getGrupos().get(i).getId() == id_grupoInt) && (Database.getGrupos().get(i).getQtde_pessoas() > 0)) {
	        			Database.getGrupos().get(i).dividir_despesas();
	        			Database.getGrupos().get(i).definir_saldos();
	        			String dividas[] = new String[Database.getGrupos().get(i).getQtde_pessoas()];
	        			dividas = Database.getGrupos().get(i).mostrar_dividas();
	        			new TelaMostrarDividas().mostrarDados(i, dividas);
	        			System.out.println("Foi");
	        			dispose();
	        			break;
	        		}
	        		else if(i == (Database.getQtde_grupos() - 1)) {
	        			JOptionPane.showMessageDialog(null, "Nao encontramos um grupo com o ID inserido ou o grupo esta vazio", 
								"Ops!", JOptionPane.PLAIN_MESSAGE);
	        		}
	        	}
	        	
	    	   
	        } 
	        catch(NumberFormatException exception){
	        	JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", 
	            								"Erro", JOptionPane.PLAIN_MESSAGE);
	        }
        }

    }
    
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	}

}
