package view;

import controller.ControleGrupo;
import model.model_database.Database;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class CadastrosPessoa extends JFrame implements ActionListener, ListSelectionListener {
    /**
     * @param e the event to be processed
     */
    private JList<String> listaPessoasCadastradas;
    private String[] listaNomes = new String[Database.getQtde_grupos()];
    private JButton Button_voltar = new JButton("Voltar");

    public CadastrosPessoa(){
        super("Mostrar Pessoas Cadastradas");

        Button_voltar.setBounds(120, 290, 180, 30);
        Button_voltar.setBackground(new Color(108, 112, 139));
        Button_voltar.setForeground(new Color(222, 222, 245));
        Button_voltar.addActionListener(this);
        add(Button_voltar);


        setSize(400, 390);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    public void mostrarDados(){
        listaNomes = ControleGrupo.getNomeGrupo();
        listaPessoasCadastradas = new JList<>(listaNomes);
        listaPessoasCadastradas.setBounds(17, 40, 350, 170);
        listaPessoasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listaPessoasCadastradas.addListSelectionListener(this);
        add(listaPessoasCadastradas);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== Button_voltar){
            Menu menu = new Menu();
            dispose();
        }
    }

    /**
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
    }
    public static void main(String[] args) {
        Database.pre_cadastrar_grupos();
        CadastrosPessoa mostrarCadastros = new CadastrosPessoa();
    }
}
