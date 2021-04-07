package other;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Lambdas {
	public static void main(String[] args) {

		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ola");
			}
		});
		
		button.addActionListener(e -> System.out.println("Olá"));
	}
}
