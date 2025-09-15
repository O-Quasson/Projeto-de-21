import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class vinteum{
    public static void main(String[] args) {
        JFrame frame = new JFrame("21");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);

        Random random = new Random();
        int[] qtcartas = new int[2];
        qtcartas[0] = 2;
        int[] total = new int[2];

        JLabel[] cartas = new JLabel[10];

        JButton pedir = new JButton("Pedir mais cartas");

        int[] cartapedida = new int[2];
        cartapedida[0] = random.nextInt(11) + 1;

        for(int x = 0; x < 2; x++){
            cartapedida[0] = random.nextInt(11) + 1;
            total[0] = total[0] + cartapedida[0];
            cartas[x] = new JLabel();
            cartas[x].setOpaque(true);
            cartas[x].setBackground(Color.LIGHT_GRAY);
            cartas[x].setText("" + cartapedida[0]);
            cartas[x].setBounds(x*50+50, 100, 25, 100);
            frame.add(cartas[x]);
        }

        pedir.setBounds(125,50,250,50);
        pedir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(total[0]<21){
                    cartapedida[0] = random.nextInt(11) + 1;
                    total[0] = total[0] + cartapedida[0];
                    if(total[0]>21){
                        JOptionPane.showMessageDialog(null, "Que pena, você estourou!");
                    }
                    cartas[qtcartas[0]] = new JLabel();
                    cartas[qtcartas[0]].setText("" + cartapedida[0]);
                    qtcartas[0]++;

                    for(int i = 0; i < qtcartas[0]; i++){
                        cartas[i].setOpaque(true);
                        cartas[i].setBackground(Color.LIGHT_GRAY);
                        cartas[i].setBounds(i* 50 + 50, 100, 25, 100);
                        frame.add(cartas[i]);
                        frame.repaint();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Tu estourou, parceiro!");
                }
               
            }
        });

        frame.add(pedir);
        frame.setVisible(true);
    }
}