package chapter10;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CharGame extends Frame implements Runnable,KeyListener{
    char origChar[];
    int x[];
    int y[];
    int sum;
    public CharGame(){
        origChar=new char[15];
        x=new int[15];
        y=new int[15];
        for (int i = 0; i < origChar.length; i++) {
            origChar[i]=(char)((int)(Math.random()*26+65));
            x[i]=(int)(Math.random()*360+21);
            y[i]=(int)(Math.random()*290+11);
        }
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        Thread t=new Thread(this);
        t.start();
        this.addKeyListener(this);
        setSize(400,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CharGame();
    }
    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < origChar.length; i++) {
            g.drawString(origChar[i]+"", x[i], y[i]);
        }
        g.drawString("���������ȷ�ַ�����Ϊ��"+sum,50,560);
    }
    @Override
    public void run() {
        while(true){
            for (int i = 0; i < origChar.length; i++) {
                y[i]++;
                if(y[i]>=580){
                    origChar[i]=(char)((int)(Math.random()*26+65));
                    y[i]=10;
                }
                repaint();
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        char c=e.getKeyChar();
        for (int i = 0; i < origChar.length; i++) {
            if(c==origChar[i]){
                sum++;
                origChar[i]=(char)((int)(Math.random()*26+65));
                y[i]=10;
                break;
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

