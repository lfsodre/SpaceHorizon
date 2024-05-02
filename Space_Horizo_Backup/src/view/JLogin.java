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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Criptografia;

public class JLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogin frame = new JLogin();										// ABRE A JANELA LOGIN
					frame.setLocationRelativeTo(null);									// AO CENTRO
					frame.setVisible(true);												// EXIBE A JANELA
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBorder(new LineBorder(new Color(6, 4, 29), 1));
		MainPanel.setBounds(25, 11, 422, 499);
		MainPanel.setBackground(new Color(6, 4, 29));
		contentPane.setBackground(new Color(6, 4, 29));
		contentPane.add(MainPanel);
		MainPanel.setLayout(null);
		
		JLabel lblUser = new JLabel("Login:");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblUser.setForeground(new Color(6, 4, 29)); 							//SERVE PARA TROCAR A COR DO TEXTO
		lblUser.setBounds(32, 153, 40, 31);
		MainPanel.add(lblUser);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBorder(null);
		textFieldUsuario.setFont(new Font("Agency FB", Font.BOLD, 18));
		textFieldUsuario.setBounds(82, 151, 304, 35);
		textFieldUsuario.setBackground(new Color(237, 236, 216)); 	
		MainPanel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha:");
		lblPassword.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblPassword.setForeground(new Color(6, 4, 29)); 
		lblPassword.setBounds(32, 227, 40, 31); 
		MainPanel.add(lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setToolTipText("");
		pwdPassword.setBorder(null);
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pwdPassword.setBounds(77, 224, 309, 39);
		pwdPassword.setBackground(new Color(237, 236, 216));
		MainPanel.add(pwdPassword);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				Criptografia criptografia = new Criptografia(pwdPassword.getText(), Criptografia.MD5);
				System.out.println(criptografia.criptografar());
				if (textFieldUsuario.getText()!=null &&									// TEXTO DIFERENTE DE NULO OU VAZIO
						!textFieldUsuario.getText().isEmpty() &&
						pwdPassword.getText()!=null &&
						!pwdPassword.getText().isEmpty()){
					if(criptografia.criptografar().equals("E10ADC3949BA59ABBE56E057F20F883E"))
					JOptionPane.showMessageDialog(btnNewButton, "Informações válidas");
					dispose(); 															// FECHA A JANELA DE LOGIN
					JMenu JMenu = new JMenu();											// ABRE O MENU
					JMenu.setLocationRelativeTo(null);									// AO CENTRO
					JMenu.setVisible(true);												// EXIBE A JANELA
		
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Verifique as informações", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(194, 53, 110));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(110, 302, 193, 33);
		MainPanel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 0, 433, 499);
		MainPanel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\DEV\\eclipse\\Space_Horizon\\img\\login_650.png"));
		
		JLabel lblNewLabel_1 = new JLabel("_");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\DEV\\eclipse\\Space_Horizon\\img\\BK_500.jpeg"));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(444, 11, 500, 500);
		contentPane.add(lblNewLabel_1);
	}
}
//(ALT + SHIFT + R = RENOMEIA TODOS)
