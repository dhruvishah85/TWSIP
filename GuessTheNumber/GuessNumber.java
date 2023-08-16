//Guess game using GUI
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class GuessNumber
{
    public static void main(String[] args)
    {
        JFrame f=new JFrame("GuessNumber");
        JPanel p=new JPanel();
        JLabel l1=new JLabel("WELCOME TO GUESS GAME");
        JLabel l2=new JLabel("Instructions:");
        JLabel l3=new JLabel("->You will be asked to guess the number");
        JLabel l4=new JLabel("->You will be given 5 chances");
        JButton b=new JButton("Start");
        Font fs=new Font("ALGERIAN",Font.PLAIN,30);
        Font fs1=new Font("TIMES NEW ROMAN",Font.PLAIN,20);
        Image icon=Toolkit.getDefaultToolkit().getImage("icon.png");

        p.setLayout(null);
        l1.setBounds(100,0,1000,100);
        l1.setFont(fs);
        l2.setBounds(100,30,1000,100);
        l2.setFont(fs1);
        l3.setBounds(100,50,1000,100);
        l3.setFont(fs1);
        l4.setBounds(100,70,1000,100);
        l4.setFont(fs1);
        b.setBounds(200,150,100,50);
        b.setBackground(Color.WHITE);
        b.setFont(fs1);
        b.setPreferredSize(new Dimension(4,4));
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(b);
        p.setBackground(Color.PINK);
        b.addMouseListener(
                new MouseListener()
                {
                    public void mouseEntered(MouseEvent e){}
                    public void mouseExited(MouseEvent e){}
                    public void mousePressed(MouseEvent e){}
                    public void mouseReleased(MouseEvent e){}
                    public void mouseClicked(MouseEvent e){
                        GuessUser gu=new GuessUser();
                        gu.make();
                        f.dispose();
                    }
                }
        );

        f.add(p);
        f.setIconImage(icon);
        f.setSize(550,300);
        f.setLocation(300,80);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}
class GuessUser
{
    int j=0,i,user;
    void make()
    {
        Random r=new Random();
        JFrame frm=new JFrame("GuessNumber");
        JPanel p=new JPanel();
        JPanel gp=new JPanel();
        Image icon=Toolkit.getDefaultToolkit().getImage("icon.png");
        ImageIcon icon1=new ImageIcon("back.jpg");
        JTextField tf=new JTextField();
        JLabel l1=new JLabel(" Guess the correct number");
        JLabel l2=new JLabel();
        JLabel back=new JLabel(icon1);
        Button b1=new Button("Check");
        Button b2=new Button("Try again");
        Font fs=new Font("CASTELLAR",Font.PLAIN,20);


        p.setLayout(null);
        back.setBounds(0,0,800,500);
        tf.setBounds(40,120,300,50);
        tf.setForeground(Color.PINK);
        tf.setFont(fs);
        l1.setBounds(0,0,1000,50);
        l1.setFont(fs);
        l2.setBounds(0,50,1000,50);
        l2.setFont(fs);
        b1.setBounds(60,200,100,50);
        b1.setPreferredSize(new Dimension(15,15));
        b1.setFont(fs);
        b2.setBounds(210,200,100,50);
        b2.setPreferredSize(new Dimension(15,15));
        b2.setFont(fs);
        p.add(tf);
        p.add(b1);
        p.add(b2);

        if(j==0)
        {i = r.nextInt(100);}

        b1.addMouseListener(
                new MouseListener() {
                    public void mouseEntered(MouseEvent e) {}
                    public void mouseExited(MouseEvent e) {}
                    public void mousePressed(MouseEvent e) {}
                    public void mouseReleased(MouseEvent e) {}
                    public void mouseClicked(MouseEvent e) {
                        String s1 = tf.getText();
                        user = Integer.parseInt(s1);
                        if(j<5){
                            if (user == i) {
                                l1.setText("Wooho!!You guessed the");
                                l2.setText("correct number!! You won!!");
                            } else if (user < i) {
                                l1.setText(" Guess a bigger number");
                                j++;
                            } else if (user > i) {
                                l1.setText(" Guess a smaller number");
                                j++;
                            } else {
                                l1.setText("Invalid input");
                            }
                            tf.setText("");}
                        if(j==5)
                        {
                            l1.setText("No more Guesses available!!");
                            l2.setText("Correct number:"+i);
                            JOptionPane.showMessageDialog(new JFrame(),"You may try again");
                        }
                        //System.out.println(s1+" "+i);
                    }
                }
        );
        b2.addMouseListener(
                new MouseListener() {
                    public void mouseEntered(MouseEvent e) {}
                    public void mouseExited(MouseEvent e) {}
                    public void mousePressed(MouseEvent e) {}
                    public void mouseReleased(MouseEvent e) {}
                    public void mouseClicked(MouseEvent e) {
                        if(j==5 || user==i)
                        {
                            j=0;
                            l1.setText(" Guess the correct number");
                            l2.setText("");
                            i = r.nextInt(100);
                        }
                    }
                });
        gp.setLayout(null);
        gp.setBounds(20,10,350,100);
        gp.setVisible(true);
        gp.setBackground(Color.YELLOW);
        gp.add(l1);
        gp.add(l2);
        p.add(gp);
        p.add(back);
        frm.add(p);
        frm.setSize(400,450);
        frm.setMinimumSize(new Dimension(400,450));
        frm.setLocation(300,80);
        frm.setIconImage(icon);
        frm.setVisible(true);
        frm.setResizable(false);
        frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
    }
}