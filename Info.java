package proj;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.*;

public class Info {
	public static String values[];
	//This function is used to search csv file for USN and it stores the particular row in an array
	public static String searchCsvLine(int searchColumnIndex, String searchString) throws IOException {
	    String resultRow = "not_found";
	    BufferedReader br = new BufferedReader(new FileReader("java.csv"));
	    String line;
	    while ( (line = br.readLine()) != null ) {
	        values = line.split(",");
	        if(values[searchColumnIndex].equals(searchString)) {
	            resultRow = "found";
	            break;
	        }
	    }
	    br.close();
	    return resultRow;
	}

	public static void main(String[] args) {
		//Creating 1st frame and swing component and adding these components to the Frame.
    	JFrame f = new JFrame();
		f.setVisible(true);
		f.setSize(800,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pn=new JPanel(new GridBagLayout());
		JLabel l11 = new JLabel("STUDENT INFORMATION SYSTEM");
		JButton b11 = new JButton("Enter details");
		JButton b12= new JButton("View Details");
		JButton b13= new JButton("QUIT");
		JLabel l12= new JLabel("Enter Student USN to View");
		JTextField t11 = new JTextField(30);
		JButton b14= new JButton("Search");	
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;c.gridy=0;
		pn.add(l11,c);
		c.gridx=0;c.gridy=1;
		pn.add(b11,c);
		c.gridx=0;c.gridy=2;
		pn.add(b12,c);
		c.gridx=0;c.gridy=3;
		pn.add(b13,c);
		f.add(pn);
		
		JFrame f2 = new JFrame();
		f2.setVisible(false);
		f2.setSize(1000,1000);
		JPanel pn1=new JPanel(new GridBagLayout());
		JLabel l21 = new JLabel("Enter the details\n");
		JLabel l22 = new JLabel("Name");
		JTextField t21 = new JTextField(30);
		JLabel l23 = new JLabel("College");
		JTextField t22 = new JTextField(30);
		JLabel l24 = new JLabel("USN");
		JTextField t23 = new JTextField(30);
		JLabel l25 = new JLabel("Address");
		JTextField t24 = new JTextField(30);
		JLabel l26 = new JLabel("10th Percentage");
		JTextField t25 = new JTextField(30);
		JLabel l27 = new JLabel("12th Percentage");
		JTextField t26 = new JTextField(30);
		JLabel l28 = new JLabel("Engineering CGPA");
		JTextField t27 = new JTextField(30);
		JLabel l29 = new JLabel("Successfully Saved");
		JButton b21 = new JButton("Submit");
		JButton b22 = new JButton("go to SIS");
		c.gridx=0;c.gridy=1;
		pn1.add(l21,c);
		c.gridx=0;c.gridy=2;
		pn1.add(l22,c);
		c.gridx=0;c.gridy=3;
		pn1.add(t21,c);
		c.gridx=0;c.gridy=4;
		pn1.add(l23,c);
		c.gridx=0;c.gridy=5;
		pn1.add(t22,c);
		c.gridx=0;c.gridy=6;
		pn1.add(l24,c);
		c.gridx=0;c.gridy=7;
		pn1.add(t23,c);
		c.gridx=0;c.gridy=8;
		pn1.add(l25,c);
		c.gridx=0;c.gridy=9;
		pn1.add(t24,c);
		c.gridx=0;c.gridy=10;
		pn1.add(l26,c);
		c.gridx=0;c.gridy=11;
		pn1.add(t25,c);
		c.gridx=0;c.gridy=12;
		pn1.add(l27,c);
		c.gridx=0;c.gridy=13;
		pn1.add(t26,c);
		c.gridx=0;c.gridy=14;
		pn1.add(l28,c);
		c.gridx=0;c.gridy=15;
		pn1.add(t27,c);
		c.gridx=0;c.gridy=16;
		pn1.add(b21,c);
		f2.add(pn1,BorderLayout.NORTH);
		
		JFrame f3 = new JFrame();
		f3.setVisible(false);
		f3.setSize(1000,1000);
		JLabel err = new JLabel("No data found");
		JButton b31 = new JButton("go to SIS");
		JPanel pn3=new JPanel(new GridBagLayout());
		
		//if you click Enter details
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				if(l29.isVisible())
				{
					pn1.remove(l29);
					pn1.remove(b22);
				}
				if(!l21.isEnabled())
				{
					l21.setEnabled(true);	t21.setEnabled(true);
					l22.setEnabled(true);	t22.setEnabled(true);
					l23.setEnabled(true);	t23.setEnabled(true);
					l24.setEnabled(true);	t24.setEnabled(true);
					l25.setEnabled(true);	t25.setEnabled(true);
					l26.setEnabled(true);	t26.setEnabled(true);
					l27.setEnabled(true);	t27.setEnabled(true);
					l28.setEnabled(true);	b21.setEnabled(true);
				}
				f2.setVisible(true);
				
			}
	});
		//Submit button
		b21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.gridx=0;c.gridy=17;
				pn1.add(l29,c);
				c.gridx=0;c.gridy=18;
				pn1.add(b22,c);
				f2.add(pn1,BorderLayout.NORTH);
				f2.setVisible(true);
				String Name = t21.getText();
				String College = t22.getText();
				String USN = t23.getText();
				String Address = t24.getText();
				String Sslc = t25.getText();
				String Pu= t26.getText();
				String Engg= t27.getText();
				try {
					
				FileWriter writer = new FileWriter("java.csv",true);
				
				writer.append(Name);
				writer.append(',');
				writer.append(College);
				writer.append(',');
				writer.append(USN);
				writer.append(',');
				writer.append(Address);
				writer.append(',');
				writer.append(Sslc);
				writer.append(',');
				writer.append(Pu);
				writer.append(',');
				writer.append(Engg);
				writer.append('\n');
				writer.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				t21.setText("");t22.setText("");t23.setText("");t24.setText("");t25.setText("");t26.setText("");t27.setText("");
				l21.setEnabled(false);	t21.setEnabled(false);
				l22.setEnabled(false);	t22.setEnabled(false);
				l23.setEnabled(false);	t23.setEnabled(false);
				l24.setEnabled(false);	t24.setEnabled(false);
				l25.setEnabled(false);	t25.setEnabled(false);
				l26.setEnabled(false);	t26.setEnabled(false);
				l27.setEnabled(false);	t27.setEnabled(false);
				l28.setEnabled(false);	b21.setEnabled(false);
			}


		});
		//View details button
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			c.gridx=0;c.gridy=4;	
			pn.add(l12,c);
			c.gridx=1;c.gridy=4;
			pn.add(t11,c);
			c.gridx=0;c.gridy=5;
			pn.add(b14,c);
			f.add(pn);
			f.setVisible(true);
			
			}
			
		});
		//quit
		b13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		//search
		b14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=t11.getText();
				f.dispose();
				try {
				String res=searchCsvLine(2,s);
				if(res.equals("not_found"))
				{
					c.gridx=0;c.gridy=0;
					pn3.add(err,c);
					c.gridx=0;c.gridy=1;
					pn3.add(b31,c);
					f3.add(pn3,BorderLayout.CENTER);
					f3.setVisible(true);
					
				}
				
				else
				{
					String name,col,usn,city,ten,pu,en;
					name=values[0];
					col=values[1];
					usn=values[2];
					city=values[3];
					ten=values[4];
					pu=values[5];
					en=values[6];
					JLabel l31 = new JLabel("Name :");
					JLabel l38= new JLabel(name);
					JLabel l32 = new JLabel("College :");
					JLabel l39= new JLabel(col);
					JLabel l33 = new JLabel("USN :");
					JLabel l40 = new JLabel(usn);
					JLabel l34 = new JLabel("Address :");
					JLabel l41 = new JLabel(city);
					JLabel l35 = new JLabel("SSLC Prcentage :");
					JLabel l42 = new JLabel(ten);
					JLabel l36 = new JLabel("PU Percentage :");
					JLabel l43 = new JLabel(pu);
					JLabel l37 = new JLabel("Engineering CGPA :");
					JLabel l44 = new JLabel(en);
					c.gridx=0;c.gridy=0;
					pn3.add(l31,c);
					c.gridx=1;c.gridy=0;
					pn3.add(l38,c);
					c.gridx=0;c.gridy=1;
					pn3.add(l32,c);
					c.gridx=1;c.gridy=1;
					pn3.add(l39,c);
					c.gridx=0;c.gridy=2;
					pn3.add(l33,c);
					c.gridx=1;c.gridy=2;
					pn3.add(l40,c);
					c.gridx=0;c.gridy=3;
					pn3.add(l34,c);
					c.gridx=1;c.gridy=3;
					pn3.add(l41,c);
					c.gridx=0;c.gridy=4;
					pn3.add(l35,c);
					c.gridx=1;c.gridy=4;
					pn3.add(l42,c);
					c.gridx=0;c.gridy=5;
					pn3.add(l36,c);
					c.gridx=1;c.gridy=5;
					pn3.add(l43,c);
					c.gridx=0;c.gridy=6;
					pn3.add(l37,c);
					c.gridx=1;c.gridy=6;
					pn3.add(l44,c);
					c.gridx=2;c.gridy=7;
					pn3.add(b31,c);
					f3.add(pn3,BorderLayout.NORTH);
					f3.setVisible(true);
				}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		//goto menu
		b22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				f.setVisible(true);
			}
		});
		//goto menu
		b31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f3.revalidate();
				f3.dispose();
				t11.setText("");
				pn.remove(b14);
				pn.remove(l12);
				pn.remove(t11);
				f.add(pn);
				f.setVisible(true);
			}
		});

	}
}