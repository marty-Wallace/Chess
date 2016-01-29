package visualizer;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import board.Board;
import player.Player;

public class Visualizer extends Canvas implements Runnable, MouseListener{

	private JFrame frame;
	private final int HEIGHT = 700, WIDTH = 700;
	private Image background;
	private Image[]whitePieces, blackPieces;
	private boolean running;
	private int[][] board;
	public Visualizer(){
		frame = new JFrame("Marty's Chess Game");
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(this);
		frame.setVisible(true);
		this.start();
	}

	public void start(){
		Thread t = new Thread(this);
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
	}


	public void init() {
		this.running = true;
		requestFocus();

		frame.addMouseListener(this);

	}


	@Override
	public void run() {
		while(running){

			BufferStrategy buf = getBufferStrategy();
			if(buf == null){
				createBufferStrategy(3);
				continue;
			}
			Graphics2D g = (Graphics2D) buf.getDrawGraphics();
			render(g);
			buf.show();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
			
		
	}

	public void update(Board boardObject){
		this.board = boardObject.getBoardAsIntArray();
		
	}

	public void render(Graphics2D g){
		g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public void displayWinner(Player p){
		
	}
	
	public void finish(){
		this.running = false;
	}
}
