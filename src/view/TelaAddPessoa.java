package view;

import controller.ControlePessoas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaAddPessoa extends JFrame implements ActionListener {

    private final JLabel titulo = new JLabel("Cadastre as seguintes informações");
    private final JLabel labelNome = new JLabel("Nome: ");
    private final JTextField nome = new JTextField();
    private final JLabel labelId = new JLabel("ID: ");
    private final JTextField id = new JTextField();
    private final JLabel labelId_grupo = new JLabel("ID Grupo: ");
    private final JTextField id_grupo = new JTextField();
    private final JLabel labelCPF = new JLabel("CPF: ");
    private final JTextField cpf = new JTextField();
    private final JButton Button_cadastrar = new JButton("Cadastrar");
    private final JButton Button_voltar = new JButton("Voltar");


    public TelaAddPessoa() {
        super("Cadastrar usuario");

        titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
        titulo.setBounds(90, 10, 400, 40);


        labelNome.setBounds(50, 70, 420, 30);
        nome.setBounds(100, 70, 400, 30);

        labelId.setBounds(50, 110, 420, 30);
        id.setBounds(80, 110, 420, 30);

        labelId_grupo.setBounds(50, 150, 420, 30);
        id_grupo.setBounds(120, 150, 380, 30);

        labelCPF.setBounds(50, 190, 420, 30);
        cpf.setBounds(90, 190, 410, 30);

        Button_voltar.setBounds(70, 250, 180, 30);
        Button_voltar.setBackground(new Color(108, 112, 139));
        Button_voltar.setForeground(new Color(222, 222, 245));
        Button_voltar.addActionListener(this);

        Button_cadastrar.setBounds(260, 250, 180, 30);
        Button_cadastrar.setBackground(new Color(108, 112, 139));
        Button_cadastrar.setForeground(new Color(222, 222, 245));
        Button_cadastrar.addActionListener(this);
        
        
        setLayout(null);
        add(titulo);
        add(labelNome);
        add(nome);
        add(labelId);
        add(id);
        add(labelCPF);
        add(cpf);
        add(Button_cadastrar);
        add(Button_voltar);
        add(labelId_grupo);
        add(id_grupo);

        setSize(530, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Button_voltar) {
            TelaMenu menu = new TelaMenu();
            dispose();
        }
        else if(e.getSource() == Button_cadastrar) {
        	String nomeString = nome.getText();
            String id_userString = id.getText();
            String cpfString = cpf.getText();
            String id_grupoString = id_grupo.getText();

            ControlePessoas.cadastrarPessoa(nomeString, id_userString, cpfString, id_grupoString);
            
        }
    }
 
}
