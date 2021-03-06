package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Launcher extends JFrame implements ActionListener {
	
	private static boolean launched = false;
	private JButton play, exit;
	static AppGameContainer app;
	URL url = Launcher.class.getResource("/launcher.png");
	URL url1 = Launcher.class.getResource("/title.png");
	private JLabel icon = new JLabel(new ImageIcon(url));
	private JLabel infoImage = new JLabel(new ImageIcon(url1));
	private JPanel south = new JPanel();
	private JLabel henning = new JLabel("A Game By Henning Tonko");
	
	public Launcher() {
		this.setSize(new Dimension(640, 480));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setTitle("Twisted Stunt Farmer Launcher");
		
		play = new JButton("Play");
		play.addActionListener(this);
		south.add(play);
		south.add(henning);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		south.add(exit);
		
		this.add(south, BorderLayout.SOUTH);
		this.add(icon, BorderLayout.NORTH);
		this.add(infoImage, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) throws SlickException {
		new Launcher();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == play) {
			this.setVisible(false);
			try {
				app = new AppGameContainer(new Game("Twisted Stunt Farmer"));
				app.setDisplayMode(1280, 720, false);
				app.setTargetFrameRate(60);
			    app.setVSync(true);
			    app.setShowFPS(false);
			    app.start();
			} catch (SlickException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == exit) {
			System.exit(0);
		}
	}
}