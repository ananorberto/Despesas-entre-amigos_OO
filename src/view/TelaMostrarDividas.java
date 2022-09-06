package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import database.Database;

/**
 * Classe TelaMostrarDividas calcula as dividas de um grupo e mostra para o
 * usuario.
 * 
 * @author Leonardo, Ana Beatriz
 * @since 2022
 * @version 1.0
 *
 */
public class TelaMostrarDividas extends JFrame implements ActionListener, ListSelectionListener {

	private final JLabel titulo = new JLabel("Cadastre as seguintes informações");
	private final JLabel labelId = new JLabel("ID do grupo: ");
	private final JButton consultar = new JButton("Consultar");
	private final JButton voltar = new JButton("Voltar");
	private JList<String> listaDividas;
	private JTextField idGrupo = new JTextField();

	/**
	 * Construtor responsavel por determinar a posição de cada botao da tela, as
	 * cores dos botoes e torna-los visiveis para o usuario.
	 */
	public TelaMostrarDividas() {
		super("Mostrar dividas");

		titulo.setFont(new Font(("Verdana"), Font.PLAIN, 20));
		titulo.setBounds(90, 10, 400, 40);

		labelId.setBounds(40, 70, 420, 30);
		idGrupo.setBounds(130, 70, 360, 30);

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
		add(idGrupo);
		add(voltar);
		add(consultar);

		setSize(520, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255, 255, 255));

	}

	/**
	 * Metodo responsavel por fazer uma lista de dados que representam as dividas e
	 * despesas do grupo.
	 * 
	 * @param i       int Responsavel por localizar a divida.
	 * @param dividas String Recebe uma listagem de dividas do grupo em questao.
	 */

	public void mostrarDados(int i, String dividas[]) {

		listaDividas = new JList<>(dividas);
		listaDividas.setBounds(17, 150, 350, 170);
		listaDividas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaDividas.addListSelectionListener(this);
		add(listaDividas);

	}

	/**
	 * Metodo responsavel por dar funcionalidade ao botao voltar (voltando para a
	 * tela de Menu) e consultar (consulta as dividas e divide as despesas).
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar) {
			TelaMenu menu = new TelaMenu();
			dispose();
		} else if (e.getSource() == consultar) {
			String idGrupoString = idGrupo.getText();

			try {
				int idGrupoInt = Integer.parseInt(idGrupoString);

				for (int i = 0; i < Database.getQtdeGrupos(); i++) {
					if ((Database.getGrupos().get(i).getId() == idGrupoInt)
							&& (Database.getGrupos().get(i).getQtdePessoas() > 0)) {

						Database.getGrupos().get(i).dividirDespesas();
						Database.getGrupos().get(i).definirSaldos();
						String dividas[] = new String[Database.getGrupos().get(i).getQtdePessoas() + 1];
						dividas = Database.getGrupos().get(i).mostrarDividas();
						new TelaMostrarDividas().mostrarDados(i, dividas);
						System.out.println("Foi");
						dispose();
						break;

					} else if (i == (Database.getQtdeGrupos() - 1)) {
						JOptionPane.showMessageDialog(null,
								"Nao encontramos um grupo com o ID inserido ou o grupo esta vazio", "Ops!",
								JOptionPane.PLAIN_MESSAGE);
					}
				}

			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(null, "Algo de errado nao esta certo", "Erro", JOptionPane.PLAIN_MESSAGE);
			}
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

	}

}
