package dynamic_beat_16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image noteRouteLineImage=new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage=new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage=new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	
	private Image noteRouteSImage=new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage=new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage=new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image=new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image=new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage=new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage=new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage=new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image judgeImage;
	private Image BlueflareImage;
	public int Score=0;
	public int Combo=0;
	
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList=new ArrayList<Note>();
	
	public Game(String titleName,String difficulty,String musicTitle) {
		this.titleName=titleName;
		this.difficulty=difficulty;
		this.musicTitle=musicTitle;
		gameMusic=new Music(this.musicTitle,false);
		
		
	}
	
	public void screenDraw(Graphics2D g) 
	{
		g.drawImage(noteRouteSImage,228,30,null);
		g.drawImage(noteRouteDImage,332,30,null);
		g.drawImage(noteRouteFImage,436,30,null);
		g.drawImage(noteRouteSpace1Image,540,30,null);
		g.drawImage(noteRouteSpace2Image,640,30,null);
		g.drawImage(noteRouteJImage,744,30,null);
		g.drawImage(noteRouteKImage,848,30,null);
		g.drawImage(noteRouteLImage,952,30,null);
		
		g.drawImage(noteRouteLineImage,224,30,null);
		g.drawImage(noteRouteLineImage,328,30,null);
		g.drawImage(noteRouteLineImage,432,30,null);
		g.drawImage(noteRouteLineImage,536,30,null);
		g.drawImage(noteRouteLineImage,740,30,null);
		g.drawImage(noteRouteLineImage,844,30,null);
		g.drawImage(noteRouteLineImage,948,30,null);
		g.drawImage(noteRouteLineImage,1052,30,null);
		
		
	
		g.drawImage(gameInfoImage,0,660,null);
		g.drawImage(judgementLineImage,0,580,null);
		
		for(int i=0;i<noteList.size();i++)
		{
			Note note = noteList.get(i);
			if(note.getY()>620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/Miss.png")).getImage();	
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
			note.screenDraw(g);
		}
		
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant",Font.BOLD,30));
		g.drawString(String.valueOf(Score),565,702);
		g.drawImage(BlueflareImage,320,430,null);
		g.drawImage(judgeImage,460,420,null);
		g.setColor(Color.RED);
		g.drawString(String.valueOf(Combo),640,400);
		
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage =new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
    public void releaseS() {
		noteRouteSImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
    }
    public void pressD() {
    	judge("D");
		noteRouteDImage =new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
    public void releaseD() {
		noteRouteDImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
    }
    public void pressF() {
    	judge("F");
		noteRouteFImage =new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
    public void releaseF() {
		noteRouteFImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
    }
    public void pressSpace() {
    	judge("Space");
		noteRouteSpace1Image =new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
		noteRouteSpace2Image =new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
		
    }
    public void releaseSpace() {
		noteRouteSpace1Image =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
		noteRouteSpace2Image =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
    }
   
    public void pressJ() {
    	judge("J");
		noteRouteJImage =new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
    public void releaseJ() {
		noteRouteJImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
    }
    public void pressK() {
    	judge("K");
		noteRouteKImage =new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
    public void releaseK() {
		noteRouteKImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
    }
    public void pressL() {
    	judge("L");
		noteRouteLImage =new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
    public void releaseL() {
		noteRouteLImage =new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();	
    }
	@Override
	
	public void run() {
		dropNotes(this.titleName);
	}
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("Joakim Karud - Mighty Love")&& difficulty.equals("EASY")) 
		{
			int startTime=4460-Main.REACH_TIME*1000;
			int gap=125;
			beats = new Beat[] {
					new Beat(startTime+gap*6,"Space"),
					new Beat(startTime+gap*8,"D"),
					new Beat(startTime+gap*10,"S"),
					new Beat(startTime+gap*12,"F"),
					new Beat(startTime+gap*14,"Space"),
					new Beat(startTime+gap*16,"K"),
					new Beat(startTime+gap*18,"L"),
					new Beat(startTime+gap*20,"K"),
					new Beat(startTime+gap*22,"J"),
					new Beat(startTime+gap*24,"D"),
					new Beat(startTime+gap*26,"Space"),
					new Beat(startTime+gap*28,"S"),
					new Beat(startTime+gap*30,"D"),
					new Beat(startTime+gap*32,"S"),
					new Beat(startTime+gap*34,"J"),
					new Beat(startTime+gap*36,"Space"),
					new Beat(startTime+gap*38,"D"),
					new Beat(startTime+gap*40,"J"),
					new Beat(startTime+gap*42,"K"),
					new Beat(startTime+gap*44,"L"),
					new Beat(startTime+gap*46,"K"),
					new Beat(startTime+gap*48,"S"),
					new Beat(startTime+gap*50,"F"),
					new Beat(startTime+gap*52,"Space"),
					new Beat(startTime+gap*52,"J"),
					new Beat(startTime+gap*57,"K"),
					new Beat(startTime+gap*60,"S"),
					new Beat(startTime+gap*61,"D"),
					new Beat(startTime+gap*63,"F"),
					new Beat(startTime+gap*65,"D"),
					new Beat(startTime+gap*68,"S"),
					new Beat(startTime+gap*70,"Space"),
					new Beat(startTime+gap*72,"J"),
					new Beat(startTime+gap*73,"K"),
					new Beat(startTime+gap*74,"J"),
					new Beat(startTime+gap*75,"L"),
					new Beat(startTime+gap*77,"D"),
					new Beat(startTime+gap*80,"Space"),
					new Beat(startTime+gap*84,"Space"),
					new Beat(startTime+gap*85,"D"),
					new Beat(startTime+gap*87,"J"),
					new Beat(startTime+gap*90,"K"),
					new Beat(startTime+gap*95,"L"),
					new Beat(startTime+gap*97,"D"),
					new Beat(startTime+gap*100,"S"),
					new Beat(startTime+gap*102,"F"),
					new Beat(startTime+gap*104,"Space"),
					new Beat(startTime+gap*106,"L"),
					new Beat(startTime+gap*109,"J"),
					new Beat(startTime+gap*111,"S"),
					new Beat(startTime+gap*114,"J"),
					new Beat(startTime+gap*118,"S"),
					new Beat(startTime+gap*118,"D"),
					new Beat(startTime+gap*118,"F"),
					new Beat(startTime+gap*118,"Space"),
					new Beat(startTime+gap*118,"J"),
					new Beat(startTime+gap*118,"K"),
					new Beat(startTime+gap*120,"F"),
					new Beat(startTime+gap*122,"D"),
					new Beat(startTime+gap*124,"J"),
					new Beat(startTime+gap*125,"J"),
					new Beat(startTime+gap*128,"K"),
					new Beat(startTime+gap*130,"J"),
					new Beat(startTime+gap*132,"K"),
					new Beat(startTime+gap*137,"L"),
					new Beat(startTime+gap*140,"Space"),
					new Beat(startTime+gap*142,"D"),
					new Beat(startTime+gap*146,"L"),
					new Beat(startTime+gap*147,"S"),
					new Beat(startTime+gap*149,"Space"),
					new Beat(startTime+gap*151,"L"),
					new Beat(startTime+gap*152,"K"),
					new Beat(startTime+gap*156,"L"),
					new Beat(startTime+gap*158,"J"),
					new Beat(startTime+gap*160,"F"),
					new Beat(startTime+gap*162,"D"),
					new Beat(startTime+gap*163,"L"),
			};
		}
		if(titleName.equals("Joakim Karud - Mighty Love")&& difficulty.equals("HARD")) 
		{
			int startTime=4460-Main.REACH_TIME*1000;
			int gap=125;
			beats = new Beat[] {
					new Beat(startTime+gap*6,"Space"),
					
			};
		}
		else if(titleName.equals("Alan Walker - Force")&& difficulty.equals("EASY")) {
			int startTime=1000-Main.REACH_TIME*1000;;
			beats = new Beat[] {
					new Beat(startTime,"Space")
		    };
		}
		else if(titleName.equals("Alan Walker - Force")&& difficulty.equals("HARD")) {
			int startTime=1000-Main.REACH_TIME*1000;;
			beats = new Beat[] {
					new Beat(startTime,"Space")
		    };
		}
		else if(titleName.equals("Tobu - Mesmerize")&& difficulty.equals("EASY")) {
			int startTime=1000-Main.REACH_TIME*1000;;
			beats = new Beat[] {
					new Beat(startTime,"Space")
		    };
		}
		else if(titleName.equals("Tobu - Mesmerize")&& difficulty.equals("HARD")) {
			int startTime=1000-Main.REACH_TIME*1000;;
			beats = new Beat[] {
					new Beat(startTime,"Space")
		    };
		}
		int i=0;
		gameMusic.start();
		while(i<beats.length&&!isInterrupted()) {
			boolean dropped=false;
			if(beats[i].getTime()<=gameMusic.getTime()) {
				Note note=new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped=true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void judge(String input) {
		for(int i=0;i<noteList.size();i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			BlueflareImage = new ImageIcon(Main.class.getResource("../images/BlueflareImage.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Miss.png")).getImage();
		Combo-=1;
		}
		else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Late.png")).getImage();
			Score+=100;
			Combo+=1;
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Good.png")).getImage();
			Score+=200;
			Combo+=1;
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Great.png")).getImage();
			Score+=300;
			Combo+=1;
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Perfect.png")).getImage();
			Score+=500;
			Combo+=1;
		}
		else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/Early.png")).getImage();
		Score+=100;
		Combo+=1;
		}
	}

}
