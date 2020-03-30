import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.MathContext;
class CalculatorEx extends Frame implements ActionListener {
	private Panel left, right, p1, p2, south  ;
	private Button plus, minus, multiply, divide, 
		zero, one, two, three, four, five, six, seven, eight, nine,
		dot, equal, 
		c, ce, backspace, plusminus;
	private TextArea ta;
	private String operator = new String(" ");
	private String str = "";
	//private int oldnum, delete;
	BigDecimal a = new BigDecimal( 0.0 );
	BigDecimal b = new BigDecimal( 0.0 );
	BigDecimal result = new BigDecimal( 0.0 );
	

	public CalculatorEx()  {
		//colors for font are the darkest grey r165/ g120/ b115
		Font f = new Font( Font.SERIF, Font.BOLD,20 );

		
		//spaces for the both sides
		//colors for the spaces r240/ g236/ b221
		Panel left = new Panel();
		Panel right = new Panel();
		left.setBackground( new Color( 240, 236, 221 ) );
		right.setBackground( new Color( 240, 236, 221 ) );
		left.add( new Label ( "" ) );
		right.add( new Label ( "" ) );
		
		add( left, "West" );
		add( right, "East" );
		

		//south(space)
		south = new Panel();
		south.setBackground( new Color( 240, 236, 221 ) );
		south.add( new Label( "                 " ) );

		add( south, "South" );

		//Middle:the arithmetic calculation and the numbers
		p1 = new Panel();
		//bg is the darkest grey ȸ r91 /g88/ b83
		//middle pink 219 / g175/ b173
		p1.setBackground( new Color( 91, 88, 83 ) );
		p1.setLayout( new GridLayout( 5,4,15,15 ) ); 
		plus = new Button( "+" );
		minus = new Button( "-" );
		multiply = new Button( "*" );
		divide = new Button( "/" );
		zero = new Button( "0" );
		one = new Button( "1" );
		two = new Button( "2" );
		three = new Button( "3" );
		four = new Button( "4" );
		five = new Button( "5" );
		six = new Button( "6" );
		seven = new Button( "7" );
		eight = new Button( "8" );
		nine = new Button( "9" );
		dot = new Button( "." );
		equal = new Button( "=" );
		c = new Button( "C" );
		ce = new Button( "CE" );
		backspace = new Button( "◀" );
		plusminus = new Button( "±" );


		p1.setForeground( new Color( 165, 120, 115 ) );
		p1.setFont( f );
		p1.add( ce );
		p1.add( c );
		p1.add( backspace );
		p1.add( equal );
		p1.add( one );
		p1.add( two );
		p1.add( three );
		p1.add( plus );
		p1.add( four );
		p1.add( five );
		p1.add( six );
		p1.add( minus );	
		p1.add( seven );
		p1.add( eight );
		p1.add( nine );
		p1.add( multiply );
		p1.add( plusminus );
		p1.add( zero );
		p1.add( dot );
		p1.add( divide );
		
		add( p1, "Center" );

		
		//spaces for the both side bars(on the panel as well)
		left.add( new Label ( "" ) );
		right.add( new Label ( "" ) );
		
		add( left, "West" );
		add( right, "East" );

		//Upper part: calculation part
		p2 = new Panel();
		p2.setBackground( new Color( 240, 236, 221 ) );
		ta = new TextArea( "", 2, 28, TextArea.SCROLLBARS_NONE  );
		//����â�� bg�� �߰� ȸ r 190/ g183/ b 167
		ta.setBackground( new Color( 190, 183, 167 ) );
		ta.setForeground( new Color( 91, 88, 83 ) );
		ta.setFont( f );
		ta.setEditable( false );
		p2.add( ta );

		add( p2, "North" );
		
		
		
		//I put this in here, in order to show the piture and set it as visible
		setResizable( false );
		setBounds( 1500, 200, 400, 500 );
		setVisible( true );
		//setDefaultCloseOperation( Frame.EXIT_ON_CLOSE );
			//--> b/c this is not Swing

		//WindowEvent (showing the window)
		addWindowListener( //turns off when clicking X button
			new WindowAdapter(){
				public void windowClosing( WindowEvent e ){
					System.exit(0); 
				}
			}
		);

		
		//CalculateEvent : putting a sensor and a handler
		plus.addActionListener( this ); //
		minus.addActionListener( this );
		multiply.addActionListener( this );
		divide.addActionListener( this );
		zero.addActionListener( this );
		one.addActionListener( this );
		two.addActionListener( this );
		three.addActionListener( this );
		four.addActionListener( this );
		five.addActionListener( this );
		six.addActionListener( this );
		seven.addActionListener( this );
		eight.addActionListener( this );
		nine.addActionListener( this );
		dot.addActionListener( this );
		equal.addActionListener( this );
		c.addActionListener( this );
		ce.addActionListener( this );
		backspace.addActionListener( this );
		plusminus.addActionListener( this );	

	}//producer

	//Before the main metho, I was to make the method that acutually make event enable
	//ActionEvent Sensor
	public void actionPerformed( ActionEvent e ){
		//Object source = e.getSource();
		String com = e.getActionCommand();
		String temp = ta.getText();
		String tempInput = "";

		//String tempInput = ta.getText();
		if( com.equals ("+") ){
			a = new BigDecimal(ta.getText());
			operator = "+";
			ta.setText("");
			System.out.println(a);
		} else if ( com.equals("-") ){
			a = new BigDecimal(ta.getText());
			operator = "-";
			ta.setText("");
			System.out.println(a);
		} else if ( com.equals("*") ){
			a = new BigDecimal(ta.getText());
			operator = "*";
			ta.setText("");
			System.out.println(a);
		} else if ( com.equals("/") ){
			a = new BigDecimal(ta.getText());
			operator = "/";
			ta.setText( "" );
			System.out.println(a);
		} else if (com.equals( "0" ) ){
			ta.append("0");
		} else if (com.equals( "1" ) ){
			ta.append("1");
		} else if (com.equals( "2" ) ){
			ta.append("2");
		} else if (com.equals( "3" ) ){
			ta.append("3");
		} else if (com.equals( "4" ) ){
			ta.append("4");
		} else if (com.equals( "5" ) ){
			ta.append("5");
		} else if (com.equals( "6" ) ){
			ta.append("6");
		} else if (com.equals( "7" ) ){
			ta.append("7");
		} else if (com.equals( "8" ) ){
			ta.append("8");
		} else if (com.equals( "9" ) ){
			ta.append("9");
		} else if (com.equals( "." ) ){
			ta.append(".");
			
		} else if (com.equals( "=" ) ){ 
			b = new BigDecimal(ta.getText());
			if (operator.equals("+")){
				result = a.add(b, MathContext.DECIMAL32);
			ta.setText(result.toString());
			} else if (operator.equals("-")){
				result = a.subtract(b, MathContext.DECIMAL32);
			ta.setText(result.toString());
			} else if (operator.equals("*")){
				result = a.multiply(b, MathContext.DECIMAL32);
			ta.setText(result.toString());
			} else if (operator.equals("/")){
				result = a.divide(b, MathContext.DECIMAL32);
			ta.setText(result.toString());
			}
		} else if (com.equals( "C" ) ){
			tempInput = "";
			a = new BigDecimal(0.0);
			b = new BigDecimal(0.0);
			ta.setText("");
		} else if (com.equals( "CE" ) ){
			tempInput = "";
			ta.setText("0");

		} else if (com.equals( "◀" ) ){
			temp = temp.substring(0, temp.length()-1);
			ta.setText( temp );
		} else if (com.equals( "±" ) ){
			ta.append("±");
		}
		ta.requestFocus();
	}


	public static void main(String[] args) {
		new CalculatorEx();
		
	}
}
