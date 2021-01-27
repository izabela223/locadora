package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

public class JFAtualizarFilme extends JFrame {

	private JPanel JPAlterarFilme;
	private JTextField txtTitulo;
	private JTextField txtCategoria;
	private JTextField txtClassificacao;
	private static int id; // id que eu vou receber pra atualizar os dados


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarFilme frame = new JFAtualizarFilme(id);
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
	public JFAtualizarFilme(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 802, 578);
		JPAlterarFilme = new JPanel();
		JPAlterarFilme.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPAlterarFilme);
		JPAlterarFilme.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Atualizar Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(15, 16, 171, 20);
		JPAlterarFilme.add(lblNewLabel);
		
		FilmeDAO fdao = new FilmeDAO(); 
		Filme f = fdao.read(id); // chama o metódo read que vai setar todos os atributos do objeto f com esse id
		
		JLabel lblNewLabel_9 = new JLabel("ID do filme");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(178, 18, 91, 20);
		JPAlterarFilme.add(lblNewLabel_9);
		
		JLabel lblIdFilme = new JLabel("New label");
		lblIdFilme.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIdFilme.setBounds(286, 18, 85, 20);
		JPAlterarFilme.add(lblIdFilme);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(15, 62, 61, 20);
		JPAlterarFilme.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(15, 88, 752, 26);
		JPAlterarFilme.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sinopse");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(15, 125, 69, 20);
		JPAlterarFilme.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 150, 752, 104);
		JPAlterarFilme.add(scrollPane);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(15, 270, 80, 20);
		JPAlterarFilme.add(lblNewLabel_3);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(15, 295, 752, 26);
		JPAlterarFilme.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Classifica\u00E7\u00E3o");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(15, 329, 127, 20);
		JPAlterarFilme.add(lblNewLabel_4);
		
		txtClassificacao = new JTextField();
		txtClassificacao.setBounds(15, 354, 752, 26);
		JPAlterarFilme.add(txtClassificacao);
		txtClassificacao.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tempo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(15, 390, 69, 20);
		JPAlterarFilme.add(lblNewLabel_5);
		
		JSpinner spTempo = new JSpinner();
		spTempo.setBounds(15, 414, 54, 26);
		JPAlterarFilme.add(spTempo);
		
		JLabel lblNewLabel_6 = new JLabel("Imagem");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(123, 390, 69, 20);
		JPAlterarFilme.add(lblNewLabel_6);
		
		JRadioButton rdbtn2D = new JRadioButton("2D");
		rdbtn2D.setBounds(119, 413, 54, 29);
		JPAlterarFilme.add(rdbtn2D);
		
		JRadioButton rdbtn3D = new JRadioButton("3D");
		rdbtn3D.setBounds(178, 413, 61, 29);
		JPAlterarFilme.add(rdbtn3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2D);
		imagem.add(rdbtn3D);
		
		JLabel lblNewLabel_7 = new JLabel("\u00C1udio");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(286, 390, 69, 20);
		JPAlterarFilme.add(lblNewLabel_7);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setBounds(280, 413, 91, 29);
		JPAlterarFilme.add(rdbtnDublado);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setBounds(378, 413, 109, 29);
		JPAlterarFilme.add(rdbtnLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnDublado);
		audio.add(rdbtnLegendado);
		
		JLabel lblNewLabel_8 = new JLabel("Status");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(541, 390, 69, 20);
		JPAlterarFilme.add(lblNewLabel_8);
		
		JRadioButton rdbtnDisponivel = new JRadioButton("Dispon\u00EDvel");
		rdbtnDisponivel.setBounds(535, 413, 109, 29);
		JPAlterarFilme.add(rdbtnDisponivel);
		
		JRadioButton rdbtnIndisponivel = new JRadioButton("Indispon\u00EDvel");
		rdbtnIndisponivel.setBounds(651, 413, 127, 29);
		JPAlterarFilme.add(rdbtnIndisponivel);
		
		ButtonGroup status_filme = new ButtonGroup();
		status_filme.add(rdbtnDisponivel);
		status_filme.add(rdbtnIndisponivel);
		
		// coloca os dados na tela
		lblIdFilme.setText(String.valueOf(f.getIdFilme()));
		txtTitulo.setText(f.getTitulo());
		txtSinopse.setText(f.getSinopse());
		txtCategoria.setText(f.getCategoria());
		txtClassificacao.setText(f.getClassificacao());
		spTempo.setValue(f.getTempo());
		
		if(f.isImagem3d() == true) {
			rdbtn3D.setSelected(true);
		}else if (f.isImagem3d() == false) {
			rdbtn2D.setSelected(true);
		}
		if(f.isDublado() == true) {
			rdbtnDublado.setSelected(true);
		}else if (f.isDublado() == false) {
			rdbtnLegendado.setSelected(true);
		}
		if(f.isStatus_filme() == true) {
			rdbtnDisponivel.setSelected(true);
		} else if (f.isStatus_filme() == false) {
			rdbtnIndisponivel.setSelected(true);
		}
		
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filme f = new Filme(); // cria um objeto da classe filme
				FilmeDAO dao = new FilmeDAO(); // cria um objeto da classe FilmeDAO para inserir os dados no Banco
				
				f.setIdFilme(Integer.parseInt(lblIdFilme.getText()));
				f.setTitulo(txtTitulo.getText());
				f.setSinopse(txtSinopse.getText());
				f.setCategoria(txtCategoria.getText());
				f.setClassificacao(txtClassificacao.getText());
				f.setTempo(Integer.parseInt(spTempo.getValue().toString()));
				if(rdbtn2D.isSelected()) {
					f.setImagem3d(false);
				}else if (rdbtn3D.isSelected()) {
					f.setImagem3d(true);
				}
				if(rdbtnDublado.isSelected()) {
					f.setDublado(true);
				}else if (rdbtnLegendado.isSelected()) {
					f.setDublado(false);
				}
				if(rdbtnDisponivel.isSelected()) {
					f.setDublado(true);
				}else if (rdbtnIndisponivel.isSelected()) {
					f.setDublado(false);
				}
				dao.update(f);
				dispose();
			}
		});
		
		btnAlterar.setBounds(10, 400, 89, 23);
		JPAlterarFilme.add(btnAlterar);
	
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAlterar.setBounds(15, 477, 115, 29);
		JPAlterarFilme.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCategoria.setText(null);
				txtClassificacao.setText(null);
				txtTitulo.setText(null);
				txtSinopse.setText(null);
				spTempo.setValue(0);
				status_filme.clearSelection();
				imagem.clearSelection();
				audio.clearSelection();		
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLimpar.setBounds(178, 477, 115, 29);
		JPAlterarFilme.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelar.setBounds(345, 477, 115, 29);
		JPAlterarFilme.add(btnCancelar);
		
	}
}
