import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="Calculator" width=300 height=300></applet>*/
public class Calculator extends Applet implements ActionListener
{
  TextField t;
  Button b[]=new Button[10];
  Button b1[]=new Button[7];
  String op2[]={"+","-","*","/","%","=","C"};
  String str1=" ";
  int p=0,q=0;
  String oper;
  public void init()
  {
    setLayout(new GridLayout(5,4));
    t=new TextField(20);
    t.setEditable(false);
    t.setBackground(Color.white);
    t.setText("0");
    add(t);
    for(int i=0;i<10;i++)
    {
      b[i]=new Button(""+i);
      add(b[i]);
      b[i].setBackground(Color.pink);
      b[i].addActionListener(this);
    }
    for(int i=0;i<7;i++)
    {
      b1[i]=new Button(""+op2[i]);
      add(b1[i]);
      b1[i].setBackground(Color.pink);
      b1[i].addActionListener(this);
    }
  }
  public void add()
  {
    t.setText(String.valueOf(p+q));
  }
  public void sub()
  {
    t.setText(String.valueOf(p-q));
  }
  public void mult()
  {
    t.setText(String.valueOf(p*q));
  }
  public void div()
  {
    t.setText(String.valueOf(p/q));
  }
  public void modu()
  {
    t.setText(String.valueOf(p%q));
  }
  public void actionPerformed(ActionEvent ae)
  {
    String str = ae.getActionCommand();
    if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")||str.equals("%"))
    {
      p=Integer.parseInt(t.getText());
      oper=str;
      t.setText(str1="");
    }
    else if(str.equals("="))
    {
      str1="";
      if(oper.equals("+"))
      {
        q=Integer.parseInt(t.getText());
        add();
      }
      else if(oper.equals("-")) 
      {
        q=Integer.parseInt(t.getText());
        sub();
      }
      else if(oper.equals("*"))
      {
        q=Integer.parseInt(t.getText());
        mult();
      }
      else if(oper.equals("/"))
      {
        q=Integer.parseInt(t.getText());
        div();
      }
      else if(oper.equals("%"))
      {
        q=Integer.parseInt(t.getText());
        modu();
      }
    }
    else if(str.equals("C"))
    {
      p=0;q=0;
      t.setText("");
      str1=""; 
      t.setText("0");
    }
    else
    {
      t.setText(str1.concat(str));
      str1=t.getText();
    }
  }
}