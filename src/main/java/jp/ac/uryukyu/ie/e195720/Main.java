package jp.ac.uryukyu.ie.e195720;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        // タイトルを設定
        setTitle("ワンワン戦線");
        // メインパネルを作成してフレームに追加
        Paint panel = new Paint();
        Container contentPane = getContentPane();
        contentPane.add(panel);

        // パネルサイズに合わせてフレームサイズを自動設定
        pack();
    }
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}