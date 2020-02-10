import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class TicTacToe extends JFrame{
	JPanel p=new JPanel();
	XOButton[] buttons = new XOButton[9];
	XBoard board;
	ImageIcon icon;
	
	public static void main(String args[]){
		new TicTacToe();
	}
	
	public TicTacToe(){
		super("TicTacToe");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("icon.png"));
		setIconImage(icon.getImage());

		p.setLayout(new GridLayout(3,3));
		board = new XBoard();

		for(int i=0;i<9;i++){
			buttons[i]=new XOButton(board);
			p.add(buttons[i]);
		}

		board.setBoard(buttons);

		add(p);


		setVisible(true);
	}

}