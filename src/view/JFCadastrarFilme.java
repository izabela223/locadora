package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;
	private JTextField txtClassificacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
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
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(15, 16, 171, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(15, 52, 61, 20);
		contentPane.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(15, 83, 752, 26);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sinopse");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(15, 125, 69, 20);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 150, 752, 104);
		contentPane.add(scrollPane);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(15, 270, 80, 20);
		contentPane.add(lblNewLabel_3);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(15, 295, 752, 26);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Classifica\u00E7\u00E3o");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(15, 329, 127, 20);
		contentPane.add(lblNewLabel_4);
		
		txtClassificacao = new JTextField();
		txtClassificacao.setBounds(15, 354, 752, 26);
		contentPane.add(txtClassificacao);
		txtClassificacao.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tempo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(15, 390, 69, 20);
		contentPane.add(lblNewLabel_5);
		
		JSpinner spTempo = new JSpinner();
		spTempo.setBounds(15, 414, 54, 26);
		contentPane.add(spTempo);
		
		JLabel lblNewLabel_6 = new JLabel("Imagem");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(123, 390, 69, 20);
		contentPane.add(lblNewLabel_6);
		
		JRadioButton rdbtn2D = new JRadioButton("2D");
		rdbtn2D.setBounds(119, 413, 54, 29);
		contentPane.add(rdbtn2D);
		
		JRadioButton rdbtn3D = new JRadioButton("3D");
		rdbtn3D.setBounds(178, 413, 61, 29);
		contentPane.add(rdbtn3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2D);
		imagem.add(rdbtn3D);
		
		JLabel lblNewLabel_7 = new JLabel("\u00C1udio");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(286, 390, 69, 20);
		contentPane.add(lblNewLabel_7);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setBounds(280, 413, 91, 29);
		contentPane.add(rdbtnDublado);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setBounds(378, 413, 109, 29);
		contentPane.add(rdbtnLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnDublado);
		audio.add(rdbtnLegendado);
		
		JLabel lblNewLabel_8 = new JLabel("Status");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(541, 390, 69, 20);
		contentPane.add(lblNewLabel_8);
		
		JRadioButton rdbtnDisponivel = new JRadioButton("Dispon\u00EDvel");
		rdbtnDisponivel.setBounds(535, 413, 109, 29);
		contentPane.add(rdbtnDisponivel);
		
		JRadioButton rdbtnIndisponivel = new JRadioButton("Indispon\u00EDvel");
		rdbtnIndisponivel.setBounds(651, 413, 127, 29);
		contentPane.add(rdbtnIndisponivel);
		
		ButtonGroup status_filme = new ButtonGroup();
		status_filme.add(rdbtnDisponivel);
		status_filme.add(rdbtnIndisponivel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filme f = new Filme(); // cria um objeto da classe filme
				FilmeDAO dao = new FilmeDAO(); // cria um objeto da classe FilmeDAO para inserir os dados no Banco
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
				dao.create(f);
			}
		});
		
		btnCadastrar.setBounds(10, 400, 89, 23);
		contentPane.add(btnCadastrar);
	
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCadastrar.setBounds(15, 477, 115, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLimpar.setBounds(333, 477, 115, 29);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancelar.setBounds(637, 477, 115, 29);
		contentPane.add(btnCancelar);
	}
  }
