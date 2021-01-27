package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class JFListarFilme extends JFrame {

	private JPanel contentPane;
	private JTable JTFilmes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilme frame = new JFListarFilme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFListarFilme() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				readJTable();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 758, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Filmes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(15, 16, 143, 20);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 52, 706, 289);
		contentPane.add(scrollPane);
		
		JTFilmes = new JTable();
		JTFilmes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"IDFilme", "T\u00EDtulo", "Tempo em min", "Classifica\u00E7\u00E3o", "Categoria"
			}
		));
		JTFilmes.getColumnModel().getColumn(2).setPreferredWidth(127);
		JTFilmes.getColumnModel().getColumn(3).setPreferredWidth(109);
		JTFilmes.getColumnModel().getColumn(4).setPreferredWidth(85);
		scrollPane.setViewportView(JTFilmes);
		
		JButton btnCadastrar = new JButton("Cadastrar Filme");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarFilme cf = new JFCadastrarFilme();
				cf.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.setBounds(15, 366, 173, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnEditar = new JButton("Editar Filme");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// verificar se uma linha foi selecionada
				if(JTFilmes.getSelectedRow() != -1) {
					JFAtualizarFilme af = new JFAtualizarFilme(
					(int)JTFilmes.getValueAt(JTFilmes.getSelectedRow(), 0)); 
					// passo o id do filme que quero editar
					af.setVisible(true); // deixa a tela de edição visível
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable(); // dá um refresh na tabela com os dados atualizados
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditar.setBounds(222, 366, 143, 29);
		contentPane.add(btnEditar);
		
		JButton btnNewButton_1 = new JButton("Excluir Filme");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JTFilmes.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Você deseja excluir o filme selecionado?", "Exclusão", JOptionPane.YES_NO_OPTION); // janela de confirmação de exclusão
				
					if(opcao == 0) { // 0 = Sim, 1 = Não
						FilmeDAO dao = new FilmeDAO(); // chama a classe FilmeDAO();
						Filme f = new Filme(); // cria o objeto filme
						f.setIdFilme((int) JTFilmes.getValueAt(JTFilmes.getSelectedRow(),0));
						dao.delete(f);
					}
					// operacao do botao
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(399, 366, 153, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelar.setBounds(578, 366, 143, 29);
		contentPane.add(btnCancelar);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTFilmes.getModel(); // pega o modelo da tabela
		modelo.setNumRows(0); // número inicial de linhas
		FilmeDAO fdao = new FilmeDAO();	
		for(Filme f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getTempo(),
					//f.getImagem3d(),
					//f.getDublado(),
					f.getClassificacao(),
					//f.getStatus_filme(),
					f.getCategoria()
					
			});
		}
		
	}
}
