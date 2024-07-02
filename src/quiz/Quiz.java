package quiz;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{

	String[] questions = {
		"Kto stworzyl Microsoft?",
		"Kto stworzyl Apple?",
		"Jaki energetyk jest najlepszy?",
		"Jaki silnik jest niezniszczalny?"
			
	};
	
	String[][] options = {
			              {"Ja", "Steve Jobs", "Bill Gates", "Johnny Sins"},
			              {"Steve Jobs", "Pawel Antoszczuk", "EA Sports", "Skoda Company"},
	                      {"Redbull", "Monster", "Black", "TIGER"},
			              {"2.5D", "Parowy", "Elektryczny", "1.9TDI"}
			
	};
	
	char [] answers = {
	                    'C',
	                    'A',
	                    'B',
	                    'D'
			
	                  };
	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
    int total_questions = questions.length;
	int result;
	int seconds = 15;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA =  new JButton();
	JButton buttonB =  new JButton();
	JButton buttonC =  new JButton();
	JButton buttonD =  new JButton();

	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0, 0, 650, 50);
		textfield.setBackground(Color.RED);
		textfield.setForeground(Color.ORANGE);
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setFont(new Font(null, Font.ITALIC, 40));
		textfield.setEditable(false);
		
		textarea.setBounds(0, 50, 650, 50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(Color.RED);
		textarea.setForeground(Color.ORANGE);
		textarea.setFont(new Font(null, Font.ITALIC, 25));
		textarea.setEditable(false);
		textarea.setText("Quiz");
		
		buttonA.setBounds(0, 100, 100, 100);
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 39));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0, 200, 100, 100);
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 39));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0, 300, 100, 100);
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 39));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0, 400, 100, 100);
		buttonD.setFont(new Font("MV Boli", Font.BOLD, 39));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(Color.MAGENTA);
		answer_labelA.setForeground(Color.GREEN);
		answer_labelA.setFont(new Font("MV Boli", Font.BOLD, 35));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(Color.MAGENTA);
		answer_labelB.setForeground(Color.GREEN);
		answer_labelB.setFont(new Font("MV Boli", Font.BOLD, 35));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(Color.MAGENTA);
		answer_labelC.setForeground(Color.GREEN);
		answer_labelC.setFont(new Font("MV Boli", Font.BOLD, 35));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(Color.MAGENTA);
		answer_labelD.setForeground(Color.GREEN);
		answer_labelD.setFont(new Font("MV Boli", Font.BOLD, 35));
		
		seconds_left.setBounds(535,500,100,100);
		seconds_left.setBackground(Color.DARK_GRAY);
		seconds_left.setForeground(Color.MAGENTA);
		seconds_left.setFont(new Font("MV Boli", Font.BOLD, 55));
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setOpaque(true);
		seconds_left.setText(String.valueOf(seconds));
	
		number_right.setBounds(225, 225, 200, 100); 
		number_right.setBackground(Color.DARK_GRAY);
		number_right.setForeground(Color.green);
		number_right.setFont(new Font("MV Boli", Font.BOLD, 55));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);
        
      
		
		
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);

		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);

		frame.add(seconds_left);
		
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		
		NextQuestion();
		
		
		
		
		
		
		
		
	}
	
	
	public void NextQuestion()
	{
		if(index>=total_questions)
		{
			results();
		}
		else
		{
			textfield.setText("Pytanie "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

		if(e.getSource()==buttonA)
		{
			answer='A';
			if(answer==answers[index])
			{
				correct_guesses++;
			}
		}
		if(e.getSource()==buttonB)
		{
			answer='B';
			if(answer==answers[index])
			{
				correct_guesses++;
			}
		}if(e.getSource()==buttonC)
		{
			answer='C';
			if(answer==answers[index])
			{
				correct_guesses++;
			}
		}if(e.getSource()==buttonD)
		{
			answer='D';
			if(answer==answers[index])
			{
				correct_guesses++;
			}
			
		}
		displayAnswer();
	}
	
public void displayAnswer() {
		
		
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				NextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	
	
	public void results()
	{
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int) ((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("WYNIK!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		
		number_right.setText(result +"%");
		frame.add(number_right);
	}
	
}
