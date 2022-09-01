package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.model_database.Database;


public class MenuCadastrosPessoa extends JFrame implements ActionListener {

    private  final  JLabel titulo = new JLabel("Insira o ID do grupo para ver as pessoas cadastradas");
    private  final  JLabel labelId = new JLabel("ID do grupo: ");
    private JTextField id_grupo = new JTextField();
    private  final  JButton voltar = new JButton("Voltar");
    private  final  JButton ok = new JButton("OK");



    public MenuCadastrosPessoa(){
        super("Deletar Grupo");

        titulo.setFont(new Font(("Verdana"), Font.PLAIN, 17));
        titulo.setBounds(40, 10, 500, 40);


        labelId.setBounds(40, 70, 420, 30);
        id_grupo.setBounds(130, 70, 360, 30);


        voltar.setBounds(70, 130, 180, 30);
        voltar.setBackground(new Color(108, 112, 139));
        voltar.setForeground(new Color(222, 222, 245));
        voltar.addActionListener(this);

        ok.setBounds(260, 130, 180, 30);
        ok.setBackground(new Color(108, 112, 139));
        ok.setForeground(new Color(222, 222, 245));


        setLayout(null);
        add(titulo);
        add(labelId);
        add(id_grupo);
        add(voltar);
        add(ok);

        setSize(520, 220);
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

    }

    public static void main(String[] args) {
        new MenuCadastrosPessoa();
    }
}
