package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Menu extends JFrame implements ActionListener {

    private  final JLabel label_titulo = new JLabel("Despesas entre amigos");
    private  final JButton add_grupo = new JButton("Grupo");
    private  final JButton add_usuario = new JButton("Pessoa");
    private  final JButton add_compra = new JButton("Compra");
    private  final JButton add_imovel = new JButton("Imovel");
    private  final JButton mostrar_divida = new JButton("Mostrar Divida");
    private  final JButton deletar_grupo = new JButton("Deletar Grupo");
   

    public Menu() {
        super("Divisão de Despesas entre amigos");

        label_titulo.setFont(new Font(("Verdana"), Font.PLAIN, 25));
        label_titulo.setBounds(120, 10, 300, 40);

        add_grupo.setBounds(160, 70, 180, 30);
        add_grupo.setBackground(new Color(108, 112, 139, 255));
        add_grupo.setForeground(new Color(222, 222, 245));
        add_grupo.addActionListener(this);

        add_usuario.setBounds(160, 110, 180, 30);
        add_usuario.setBackground(new Color(108, 112, 139));
        add_usuario.setForeground(new Color(222, 222, 245));
        add_usuario.addActionListener(this);

        add_compra.setBounds(160, 150, 180, 30);
        add_compra.setBackground(new Color(108, 112, 139));
        add_compra.setForeground(new Color(222, 222, 245));
        add_compra.addActionListener(this);

        add_imovel.setBounds(160, 190, 180, 30);
        add_imovel.setBackground(new Color(108, 112, 139));
        add_imovel.setForeground(new Color(222, 222, 245));
        add_imovel.addActionListener(this);

        mostrar_divida.setBounds(160, 230, 180, 30);
        mostrar_divida.setBackground(new Color(108, 112, 139));
        mostrar_divida.setForeground(new Color(222, 222, 245));
        mostrar_divida.addActionListener(this);

        deletar_grupo.setBounds(160, 270, 180, 30);
        deletar_grupo.setBackground(new Color(108, 112, 139));
        deletar_grupo.setForeground(new Color(222, 222, 245));
        deletar_grupo.addActionListener(this);

        setLayout(null);

        add(label_titulo);
        add(add_grupo);
        add(add_usuario);
        add(add_compra);
        add(add_imovel);
        add(mostrar_divida);
        add(deletar_grupo);

        setSize(520, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true); //Centraliza
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_grupo) {
            Add_grupo add_grupo = new Add_grupo();
        }
        if (e.getSource() == add_usuario) {
            Add_usuario add_usuario = new Add_usuario();
        }
        if (e.getSource() == add_compra) {
            Add_compra add_compra = new Add_compra();
        }
        if (e.getSource() == add_imovel) {
            Add_imovel add_imovel = new Add_imovel();
        }
        if (e.getSource() == mostrar_divida) {
            MostrarDividas mostrarDividas = new MostrarDividas();
        }
        if (e.getSource() == deletar_grupo) {
            DeletarGrupo deletarGrupo = new DeletarGrupo();
        }
        dispose();
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
    }
}