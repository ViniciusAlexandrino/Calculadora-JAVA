import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener {
	
	//Declarações de Componentes.
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton;
	JPanel panel;

	//Fonte do Texto
	Font myFont = new Font("Ink Free", Font.BOLD,30);
	
	//Variaveis para guardar operadores e resultados.
	double num1=0, num2=0, result =0;
	char operator;

	Calculadora() {
		
		//Ajuste de frames.
		frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		//Ajustes do campo de texto.
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		//Botões
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Excluir");
		clrButton = new JButton("Limpar");
		
		//Add funções para os botões.
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		
		for(int i =0;i<8;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			//Add action listeners e fonte para os números
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		//Ajuste de tamanho dos botões excluir e limpar.
		delButton.setBounds(50, 430, 145, 50);
		clrButton.setBounds(205, 430, 145, 50);
		
		//Ajuste de tamanho do painel.
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		//Adicionar componentes para o painel.
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		//Adicionar componentes.
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
	}
	
	public void actionPerformed(ActionEvent e) {
		//Botão de números.
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		//Botão de decimal.
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		//Botão de Soma.
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		//Botão de Subtração.
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		//Botão de Multiplicação
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		//Botão de Divisão
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		//Botão de Resultado.
		if(e.getSource() ==equButton) {
			num2=Double.parseDouble(textfield.getText());
		
			switch(operator) {
			case '+':
				result=num1+num2;
				break;
			case '-':
				result=num1-num2;
				break;
			case '*':
				result=num1*num2;
				break;
			case '/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		//Botão de Limpar.
		if(e.getSource()==clrButton) {
		      textfield.setText("");
		    }
		//Botão de Excluir.
		if(e.getSource()==delButton) {
		      String string = textfield.getText();
		      textfield.setText("");
		      for(int i=0;i<string.length()-1;i++) {
		    	  textfield.setText(textfield.getText()+string.charAt(i));
		      }
		    }
	}
		
}