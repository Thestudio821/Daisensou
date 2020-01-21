package jp.ac.uryukyu.ie.e195720;

import javax.swing.JPanel;
import java.awt.*;

public class Paint extends JPanel {
    //画像のパス
    private String pass = "/Users/e195720/IdeaProjects/Daisensou/src/Image/";
    private Image slime = Toolkit.getDefaultToolkit().getImage(pass + "boss.png");
    private Image dog = Toolkit.getDefaultToolkit().getImage(pass + "kerube.png");
    private Image win = Toolkit.getDefaultToolkit().getImage(pass + "omedetou.png");

    // パネルサイズ
    private static final int WIDTH = 800;
    private static final int HEIGHT = 180;
    //画像の座標
    private int M = 780;  //Mの初期座標
    private int Mw = 20;  //Mの勝利条件
    private int E = 20;
    private int My = 50;
    private int Ey = 50;



    Hero hero = new Hero("dog", 10, 5);
    Enemy enemy = new Enemy("slime", 6, 3);


    public Paint() { setPreferredSize(new Dimension(WIDTH, HEIGHT)); }

    /**
     * 画像表示のメソッド
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(M != Mw){
            g.drawImage(slime,E,Ey,100,100,this);
            g.drawImage(dog,M,My,-100,100,this);
            if(E == M - 150){
                battle();
            }
            run();
        }else{
            g.drawImage(win,250,50,300,100,this);
        }
    }

    /**
     * 画像のx座標をずらして再描写する
     * 動いているように見える
     */
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

    /**
     * 接触した時に戦っている感を出させる
     */
    public void battle(){
        repaint();
        while( hero.getDead() && enemy.getDead()) {
            hero.attack(enemy);
            enemy.attack(hero);
            down();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void down(){
        int HeroHP = hero.getHitPoint();
        int EnemyHP = enemy.getHitPoint();
        if(HeroHP <= 0){
            My = My + 400;
        }
        if(EnemyHP <= 0){
            Ey = Ey + 400;
        }
    }
}