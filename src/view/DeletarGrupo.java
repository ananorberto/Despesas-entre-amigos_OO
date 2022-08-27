package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeletarGrupo extends JFrame implements ActionListener {

    private  final  JLabel titulo = new JLabel("Cadastre as seguintes informações");
    private  final  JLabel labelId = new JLabel("ID do grupo: ");
    private JTextField id = new JTextField();
    private  final  JButton voltar = new JButton("Voltar");
    private  final  JButton del = new JButton("Deletar");



    public DeletarGrupo(){
        super("Deletar Grupo");

        titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
        titulo.setBounds(90, 10, 400, 40);


        labelId.setBounds(40, 70, 420, 30);
        id.setBounds(130, 70, 360, 30);


        voltar.setBounds(70, 130, 180, 30);
        voltar.setBackground(new Color(108, 112, 139));
        voltar.setForeground(new Color(222, 222, 245));
        voltar.addActionListener(this);

        del.setBounds(260, 130, 180, 30);
        del.setBackground(new Color(108, 112, 139));
        del.setForeground(new Color(222, 222, 245));


        setLayout(null);
        add(titulo);
        add(labelId);
        add(id);
        add(voltar);
        add(del);

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
}
