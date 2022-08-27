package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add_compra extends JFrame implements ActionListener {

    private final  JLabel titulo = new JLabel("Cadastre as seguintes informações");
    private final JLabel labelId = new JLabel("ID do Pagador: ");
    private final JTextField id = new JTextField();
    private final JLabel labelMercado = new JLabel("Nome do Mercado: ");
    private final JTextField nome_mercado = new JTextField();
    private final JLabel labelValor= new JLabel("Valor da compra: ");
    private final JTextField valor = new JTextField();
    private final JLabel labelData= new JLabel("Data da compra: ");
    private final JTextField data = new JTextField();
    private final JButton cadastrar = new JButton("Cadastrar");
    private final JButton voltar = new JButton("Voltar");


    public Add_compra(){super("cadastrar compra");
        titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
        titulo.setBounds(90, 10, 400, 40);

        labelMercado.setBounds(50, 70, 420, 30);
        nome_mercado.setBounds(190, 70, 300, 30);

        labelId.setBounds(50, 110, 420, 30);
        id.setBounds(160, 110, 330, 30);

        labelValor.setBounds(50, 150, 420, 30);
        valor.setBounds(175, 150, 315, 30);

        labelData.setBounds(50, 190, 420, 30);
        data.setBounds(170, 190, 320, 30);

        voltar.setBounds(70, 270, 180, 30);
        voltar.setBackground(new Color(108, 112, 139));
        voltar.setForeground(new Color(222, 222, 245));
        voltar.addActionListener(this);

        cadastrar.setBounds(260, 270, 180, 30);
        cadastrar.setBackground(new Color(108, 112, 139));
        cadastrar.setForeground(new Color(222, 222, 245));

        setLayout(null);
        add(titulo);
        add(labelMercado);
        add(nome_mercado);
        add(labelId);
        add(id);
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
    }
}
