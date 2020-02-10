import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class XOButton extends JButton implements ActionListener{
	private ImageIcon X,O;
	private XBoard board;
	private String player;


	public XOButton(XBoard board){
		this.board = board;
		X=new ImageIcon(this.getClass().getResource("X.png"));
		O=new ImageIcon(this.getClass().getResource("O.png"));
		player = "#";

		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(player.equals("#")){

			if(board.getPlayer()){
				setIcon(X);
				player = "X";
			} else {
				setIcon(O);
				player = "O";
			}
			board.evaluateBoard();
			board.updatePlayer();
		}
	}

	public String getPlayer(){
		return player;
	}

	public void reset() {
		player = "#";
		setIcon(null);
	}


}