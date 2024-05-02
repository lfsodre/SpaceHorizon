package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import meujogo.Container;

public class JMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenu frame = new JMenu();
					frame.setLocationRelativeTo(null);
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
	public JMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Container Container = new Container();
				Container.setLocationRelativeTo(null);								// AO CENTRO
				Container.setVisible(true);	
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\DEV\\eclipse\\Space_Horizon\\img\\btnNew.png"));
		btnNewButton.setFont(new Font("Agency FB", Font.BOLD, 25));
		btnNewButton.setBounds(266, 228, 135, 55);
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);
		
		JButton btnRank = new JButton("");
		btnRank.setIcon(new ImageIcon("C:\\DEV\\eclipse\\Space_Horizon\\img\\btnRank.png"));
		btnRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JRank JRank = new JRank();										// ABRE A JANELA PRINCIPAL
				JRank.setLocationRelativeTo(null);								// AO CENTRO
				JRank.setVisible(true);	
			}
		});
		btnRank.setFont(new Font("Agency FB", Font.BOLD, 25));
		btnRank.setBounds(450, 227, 135, 55);
		btnRank.setBorder(null);
		contentPane.add(btnRank);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon("C:\\DEV\\eclipse\\Space_Horizon\\img\\btnExit.png"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Agency FB", Font.BOLD, 25));
		btnExit.setBounds(629, 227, 129, 55);
		btnExit.setBorder(null);
		contentPane.add(btnExit);	
		
		JLabel lblNewLabel = new JLabel("_");
		lblNewLabel.setIcon(new ImageIcon("C:\\DEV\\eclipse\\Space_Horizon\\img\\BK_MENU_499.png"));
		lblNewLabel.setBounds(10, 11, 934, 499);
		contentPane.add(lblNewLabel);
	}
}
