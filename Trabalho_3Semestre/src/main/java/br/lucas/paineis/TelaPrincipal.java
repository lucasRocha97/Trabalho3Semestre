package br.lucas.paineis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.lucas.cliente.PainelCliente;
import br.lucas.produto.BuscaProdutoUrl;
import br.lucas.produto.PainelProduto;
import br.lucas.produto.Produto;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JButton btnCliente = new JButton("Cadastrar cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarAbaCliente();
			}
		});
		panel.add(btnCliente);
		
		JButton btnProdutos = new JButton("Lista de produtos");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarAbaProduto();
			}
		});
		panel.add(btnProdutos);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	protected void adicionarAbaCliente(){
		JPanel painelCliente = new PainelCliente();
		
		final PainelWrapper wrapper = new PainelWrapper();
		
		wrapper.setConteudo(painelCliente);
		wrapper.setTitulo("Cadastro de clientes");
		
		wrapper.setAcaoFechar(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(wrapper);
			}
		});
		
		tabbedPane.addTab("Cadastro", wrapper);
	}
	
	protected void adicionarAbaProduto(){
		JPanel painelProduto = new PainelProduto();
		
		final PainelWrapper wrapper = new PainelWrapper();
		
		wrapper.setConteudo(painelProduto);
		wrapper.setTitulo("Lista de produtos");
		
		wrapper.setAcaoFechar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(wrapper);
			}
		});
		
		tabbedPane.addTab("Produto", wrapper);
	}

}
