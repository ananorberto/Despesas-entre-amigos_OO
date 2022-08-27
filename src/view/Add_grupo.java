package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import model_database.*;

public class Add_grupo extends JFrame implements ActionListener {

    private final  JLabel labelNome = new JLabel("Nome: ");
    private final JTextField nome = new JTextField();
    private final  JLabel labelId = new JLabel("ID: ");
    private final JTextField id = new JTextField();
    private final  JLabel labelQtde = new JLabel("Quantidade de pessoas: ");
    private final JTextField qtde_pessoas = new JTextField();
    private final  JButton Button_cadastrar = new JButton("Cadastrar");
    private final  JButton Button_voltar = new JButton("Voltar");

    public Add_grupo(){
        super("Cadastrar grupo");
        JLabel label_titulo = new JLabel("Cadastre as seguintes informações");
        label_titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
        label_titulo.setBounds(90, 10, 400, 40);


        labelNome.setBounds(50, 70, 420, 30);
        nome.setBounds(100, 70, 400, 30);

        labelId.setBounds(50, 110, 420, 30);
        id.setBounds(80, 110, 420, 30);

        labelQtde.setBounds(50, 150, 420, 30);
        qtde_pessoas.setBounds(230, 150, 270, 30);

        Button_voltar.setBounds(70, 220, 180, 30);
        Button_voltar.setBackground(new Color(108, 112, 139));
        Button_voltar.setForeground(new Color(222, 222, 245));
        Button_voltar.addActionListener(this);

        Button_cadastrar.setBounds(260, 220, 180, 30);
        Button_cadastrar.setBackground(new Color(108, 112, 139));
        Button_cadastrar.setForeground(new Color(222, 222, 245));
        Button_cadastrar.addActionListener(this);

        setLayout(null);
        add(label_titulo);
        add(labelNome);
        add(nome);
        add(labelId);
        add(id);
        add(labelQtde);
        add(qtde_pessoas);
        add(Button_cadastrar);
        add(Button_voltar);

        setSize(520, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Button_voltar) {
            Menu menu = new Menu();
            dispose();
        }
        else if(e.getSource() == Button_cadastrar){
            String nomeString = nome.getText();
            String idString = id.getText();
            String qtde_pessoasString = qtde_pessoas.getText();
            try {
                int id = Integer.parseInt(idString);
                int qtde_pessoas = Integer.parseInt(qtde_pessoasString);

                Grupo novo_grupo = new Grupo(qtde_pessoas, id, nomeString);
                Database.getGrupos().add(novo_grupo);

                JOptionPane.showMessageDialog(null, "Seu Cadastro foi salvo com sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);
            } catch(NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
