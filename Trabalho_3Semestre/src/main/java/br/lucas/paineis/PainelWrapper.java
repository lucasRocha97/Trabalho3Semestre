package br.lucas.paineis;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class PainelWrapper extends JPanel {
	
	private JLabel labelTitulo;
	private JButton btnX;

	public PainelWrapper() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setMinimumSize(new Dimension(100, 100));
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{75, 0, 0};
		gbl_panel.rowHeights = new int[]{19, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		labelTitulo = new JLabel("New label");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_labelTitulo = new GridBagConstraints();
		gbc_labelTitulo.insets = new Insets(0, 0, 0, 5);
		gbc_labelTitulo.gridx = 0;
		gbc_labelTitulo.gridy = 0;
		panel.add(labelTitulo, gbc_labelTitulo);
		
		btnX = new JButton("X");
		GridBagConstraints gbc_btnX = new GridBagConstraints();
		gbc_btnX.anchor = GridBagConstraints.EAST;
		gbc_btnX.gridx = 1;
		gbc_btnX.gridy = 0;
		panel.add(btnX, gbc_btnX);

	}
	
	public void setConteudo(JPanel painel){
		add(painel, BorderLayout.CENTER);
	}
	
	public void setAcaoFechar(ActionListener action){
		btnX.addActionListener(action);
	}
	
	public void setTitulo(String titulo){
		labelTitulo.setText(titulo);
	}

}
