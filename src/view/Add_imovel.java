package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Add_imovel extends JFrame implements ActionListener {

    private  final  JLabel titulo = new JLabel("Cadastre as seguintes informações");
    private  final  JLabel labelId = new JLabel("ID do Pagador: ");
    private JTextField id = new JTextField();
    private  final  JLabel labelContaLuz = new JLabel("Valor da Conta de Luz: ");
    private JTextField conta_luz = new JTextField();
    private  final  JLabel labelContaAgua = new JLabel("Valor da Conta de Agua: ");
    private JTextField conta_agua = new JTextField();
    private  final  JLabel labelAluguel = new JLabel("Digite o valor do aluguel: ");
    private JTextField aluguel = new JTextField();
    private  final  JLabel labelEndereco= new JLabel("Endereço: ");
    private JTextField endereco = new JTextField();
    private  final  JLabel labelData= new JLabel("Data da compra: ");
    private JTextField data = new JTextField();
    private  final  JButton Button_cadastrar = new JButton("Cadastrar");
    private  final  JButton Button_voltar = new JButton("Voltar");


    public Add_imovel(){
        titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
        titulo.setBounds(90, 10, 400, 40);


        //CONFIGURAÇÃO PENDENTE
        labelContaLuz.setBounds(50, 70, 420, 30);
        conta_luz.setBounds(220, 70, 270, 30);

        labelContaAgua.setBounds(50, 110, 420, 30);
        conta_agua.setBounds(225, 110, 265, 30);

        labelAluguel.setBounds(50, 150, 420, 30);
        aluguel.setBounds(230, 150, 260, 30);

        labelId.setBounds(50, 190, 420, 30);
        id.setBounds(160, 190, 330, 30);

        labelEndereco.setBounds(50, 230, 420, 30);
        endereco.setBounds(130, 230, 360, 30);

        labelData.setBounds(50, 270, 420, 30);
        data.setBounds(170, 270, 320, 30);

        Button_voltar.setBounds(70, 340, 180, 30);
        Button_voltar.setBackground(new Color(108, 112, 139));
        Button_voltar.setForeground(new Color(222, 222, 245));
        Button_voltar.addActionListener(this);

        Button_cadastrar.setBounds(260, 340, 180, 30);
        Button_cadastrar.setBackground(new Color(108, 112, 139));
        Button_cadastrar.setForeground(new Color(222, 222, 245));

        setLayout(null);
        add(titulo);
        add(labelContaLuz);
        add(conta_luz);
        add(labelContaAgua);
        add(conta_agua);
        add(labelId);
        add(id);
        add(labelEndereco);
        add(endereco);
        add(Button_cadastrar);
        add(Button_voltar);
        add(labelData);
        add(data);
        add(labelAluguel);
        add(aluguel);

        setSize(520, 440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255));

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Button_voltar) {
            Menu menu = new Menu();
            dispose();
        }
    }
}
