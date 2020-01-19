package jp.ac.uryukyu.ie.e195720;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;

class PaintTest {
    int M = 7;  //Mの初期座標
    int Mw = 2;  //Mの勝利条件
    @Test
    void paintComponent() {
        /**
         * 勝利確認の簡略化
         */
        while (true){
            if(M != Mw){
                System.out.println("頑張れー");
                run();
            }else{
                System.out.println("勝利しました");
                break;
            }
        }
    }

    private void run() {
        M = M - 1;
        try {
            Thread.sleep(10); //　アニメーションらしくするため
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}