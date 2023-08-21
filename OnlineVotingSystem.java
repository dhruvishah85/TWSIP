import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
class OnlineVotingSystem
{
    static HashMap<String,String> map=new HashMap<>();
    static int A=0;
    static int B=0;
    static int C=0;
    static String out;
    public static void main(String[] args)
    {
        JFrame f=new JFrame("Online Voting System");
        JPanel p=new JPanel();
        JLabel head=new JLabel("ONLINE VOTING SYSTEM");
        JLabel l1=new JLabel("Enter name");
        JLabel l2=new JLabel("Enter phone no");
        JLabel l3=new JLabel("Vote Here");
        JTextField tf1=new JTextField();
        JTextField tf2=new JTextField();
        JRadioButton r1=new JRadioButton("Party A");
        JRadioButton r2=new JRadioButton("Party B");
        JRadioButton r3=new JRadioButton("Party C");
        JButton b1=new JButton("Submit Your vote");
        JButton b2=new JButton("Check results");
        ButtonGroup bg=new ButtonGroup();
        Font fs1=new Font("TIMES NEW ROMAN",Font.BOLD,30);
        Font fs=new Font("CASTELLAR",Font.PLAIN,20);
        Font fs2=new Font("SERIF",Font.PLAIN,20);

        p.setLayout(null);
        head.setBounds(60,0,400,50);
        l1.setBounds(0,40,220,50);
        l2.setBounds(0,90,220,50);
        l3.setBounds(0,140,220,100);
        tf1.setBounds(210,50,300,30);
        tf2.setBounds(210,100,300,30);
        r1.setBounds(0,220,150,50);
        r2.setBounds(0,270,150,50);
        r3.setBounds(0,320,150,50);
        b1.setBounds(170,230,150,50);
        b2.setBounds(170,310,150,50);
        head.setFont(fs1);
        l1.setFont(fs);
        l2.setFont(fs);
        l3.setFont(fs);
        l3.setFont(fs);
        r1.setFont(fs);
        r2.setFont(fs);
        r3.setFont(fs);
        tf1.setFont(fs2);
        tf2.setFont(fs2);
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        p.add(head);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(tf1);
        p.add(tf2);
        p.add(r1);
        p.add(r2);
        p.add(r3);
        p.add(b1);
        p.add(b2);
        b1.addMouseListener(
                new MouseListener()
                {
                    public void mouseEntered(MouseEvent e){}
                    public void mouseExited(MouseEvent e){}
                    public void mousePressed(MouseEvent e){}
                    public void mouseReleased(MouseEvent e){}
                    public void mouseClicked(MouseEvent e){
                        String s1=tf1.getText();
                        String s2=tf2.getText();
                        if(s1.isEmpty())
                        {JOptionPane.showMessageDialog(new JFrame(),"Please Enter name");}
                        else if(s2.isEmpty())
                        {JOptionPane.showMessageDialog(new JFrame(),"Please Enter phone no");}
                        else if(map.containsKey(s1) || map.containsValue(s2))
                        {JOptionPane.showMessageDialog(new JFrame(),"You have already voted!!");}
                        else
                        {
                            int i=JOptionPane.showConfirmDialog(new JFrame(),"Do you want to confirm your vote?");
                            if(i==0){
                            if(r1.isSelected()){A+=1;}
                            else if(r2.isSelected()){B+=1;}
                            else if(r3.isSelected()){C+=1;}
                            map.put(s1,s2);
                            tf1.setText("");
                            tf2.setText("");
                            bg.clearSelection();
                            }
                        }

                    }
                }
        );
        b2.addMouseListener(
                new MouseListener()
                {
                    public void mouseEntered(MouseEvent e){}
                    public void mouseExited(MouseEvent e){}
                    public void mousePressed(MouseEvent e){}
                    public void mouseReleased(MouseEvent e){}
                    public void mouseClicked(MouseEvent e){
                        if(A>B && A>C){out="Party A wins";}
                        else if(B>A && B>C){out="Party B wins";}
                        else if(C>A && C>B){out="Party C wins";}
                        else{out="No party wins";}
                        JOptionPane.showMessageDialog(new JFrame(),"Party A gets "+A+" votes\nParty B gets "+B+" votes\nParty C gets "+C+"votes\n\n"+out);
                    }
                }
        );
        f.add(p);
        f.setSize(580,600);
        f.setLocation(300,80);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    }
}
