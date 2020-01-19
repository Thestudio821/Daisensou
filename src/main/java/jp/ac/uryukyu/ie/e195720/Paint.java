package jp.ac.uryukyu.ie.e195720;

import javax.swing.JPanel;
import java.awt.*;

public class Paint extends JPanel {
    //画像のパス
    String pass = "/Users/e195720/Image/";
    Image slime = Toolkit.getDefaultToolkit().getImage(pass + "boss.png");
    Image dog = Toolkit.getDefaultToolkit().getImage(pass + "kerube.png");
    Image win = Toolkit.getDefaultToolkit().getImage(pass + "omedetou.png");

    // パネルサイズ
    private static final int WIDTH = 800;
    private static final int HEIGHT = 240;
    //画像の座標
    int M = 780;  //Mの初期座標
    int E = 20;   //Eの初期座標
    int Ew = 780; //Mの勝利条件
    int Mw = 20;  //Eの勝利条件

    public Paint() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(M != Mw){
            g.drawImage(slime,E,50,100,100,this);
            g.drawImage(dog,M,50,-100,100,this);
            run();
        }else{
            g.drawImage(win,300,50,300,100,this);


        }
    }
    public void run() {
        repaint();
        E = E + 1;
        M = M -1;
        try {
            Thread.sleep(10); //　アニメーションらしくするため
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}