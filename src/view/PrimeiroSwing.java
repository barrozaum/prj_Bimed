package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrimeiroSwing implements ActionListener {

	// criamos um JFrame chamado 'janela'
	JFrame janela = new JFrame();
	// criamos um JPanel chamado painel
	JPanel painel = new JPanel();
	// criamos um JLabel chamado rotulo e com o texto "Seu nome: "
	JLabel rotulo = new JLabel("Seu nome: ");
	// criamos um JTextField chamado texto com o tamanho 5
	JTextField texto = new JTextField(5);
	// criamos e instaciamos um JButton chamado 'botao' e com o texto "OK"

	JButton botao = new JButton("OK");

	public static void main(String arg[]) {
		new PrimeiroSwing();
	}

	private PrimeiroSwing() {
		// definimos o título da janela
		janela.setTitle("Exemplo de um FlowLayout");
		// definimos a largura e a altura da janela
		janela.setSize(300, 100);
		// define a posição da janela na tela
		janela.setLocation(50, 50);
		// define que ao fechar a janela, encerre a aplicação
		// janela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		// definimos o layout do painel
		painel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		// adicionamos o rotulo ao painel
		painel.add(rotulo);
		// adicionamos o texto ao painel
		painel.add(texto);
		// adicionamos o botao ao painel
		painel.add(botao);
		// adicionamos o painel à janela
		janela.add(painel);
		// mostramos a janela
		janela.setVisible(true);
		// registramos o botao ao Listener
		botao.addActionListener(this);
	}

	// construimos o metodo exigido pela interface
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botao) {
			JOptionPane.showMessageDialog(null, texto.getText());
		}
	}

}
