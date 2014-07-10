import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;




import javax.swing.*;
/**
 * ������ ���������:
 * �������� ���� - �������
 * �������� ��������� - ��������� ����
 * ������ ������ - ��������������� ����, �������
 */
/**
 * �������� ������������ ����������. 
 */
public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jButton1; //���������� ����������
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel lgroup;
    private JLabel lname;
    private JLabel mark;
    private JButton next;
    private JLabel question;
    private JRadioButton first_answ;
    private JRadioButton second_answ;
    private JRadioButton third_answ;
    private JRadioButton fourth_answ;
    private JTextField tgroup;
    private JTextField tname;
    private JPanel jPanel3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private long start = 0;
    private long stop = 0;
    private ButtonGroup answers;
    Question[] qst = new Question[10];
    List<Integer> rand = RandQst();		//���� ��������� ��������
    String[] studentsAnswers = new String[rand.size()];
    String[] isTrue = new String[rand.size()];
    //private Student st = null;
    private String st = "";
    private boolean isReady = false;
    ObjectOutputStream dataOut;
    int count;
    
    /**
     * ����������� ������.
     * @throws SQLException 
     */
	public MyFrame(Question[] qst, ObjectOutputStream soc) {
		this.qst = qst;
		dataOut = soc;
		initComponents();
	}
	
	/**
	 * ������������� ��������� �����.
	 * @throws SQLException 
	 */
	private void initComponents() {
		count = 1;
		jPanel3 = new JPanel(); //�������� ������, ������������ � ���� ���������� ������������
        jPanel1 = new JPanel();
        lgroup = new JLabel();
        lname = new JLabel();
        tname = new JTextField(); //���� ��� ����� ��� ��������
        tname.setPreferredSize(new Dimension(150,20)); //������� ������� ����
        tgroup = new JTextField(); //���� ��� ����� ������ ������
        tgroup.setPreferredSize(new Dimension(59,20)); //������� ������� ����
        jPanel2 = new JPanel();
        question = new JLabel(); 
        first_answ = new JRadioButton(); //�������� ������ ������ �������� ������
        second_answ = new JRadioButton();
        third_answ = new JRadioButton();
        fourth_answ = new JRadioButton();
        next = new JButton(); //������ ��� ����������� �� �������� ������������
        mark = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton(); //������ ��� ������ ������������
        answers = new ButtonGroup();
        String[] answ = qst[rand.get(0)].GetAnswers();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); //����������� ������ ���������� ��� �������� ����
        lgroup.setText("����� ������");

        lname.setText("���");

        tname.setText("");

        tgroup.setText("");
        
        jButton1.setText("������������");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout); //���������� ��������� �� ������
        jPanel1Layout.setHorizontalGroup( //�������������� ����������
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap() //���������� �������� ����� ����������
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING) //������� ������������ ���������
                    .addComponent(lname) //���������� �������� "���" �  "����� ������"
                    .addComponent(lgroup))
                .addGap(40, 40, 40) //������� ������� ������������ ����� ����������
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tgroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)) //���������� ������
                    .addComponent(tname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup( //�������� ����������� �� ���������
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING) //�������� ����������� �����������
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE) //���������� ������ ���������
                    .addComponent(lname) //���������� �������
                    .addComponent(tname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13) //������� ������� ������������ ����� ����������
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lgroup)
                    .addComponent(tgroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        answers.add(first_answ);
        answers.add(second_answ);
        answers.add(third_answ);
        answers.add(fourth_answ);
        question.setText(qst[rand.get(0)].GetQuestion());

        first_answ.setText(answ[0]);

        second_answ.setText(answ[1]);

        third_answ.setText(answ[2]);

        fourth_answ.setText(answ[3]);
        
        
        next.setText("���������");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout); //���������� ��������� �� ������ ������
        jPanel2Layout.setHorizontalGroup( //�������� ����������� �� �����������
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING) //�������� ����������� ����������� ���� �����
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20) //������� ������� ������������ ����� ����������
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(next)
                        .addGap(20, 20, 20)) //������� ������� ������������ ����� ����������
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(third_answ) //���������� ��������� �� ������
                            .addComponent(second_answ)
                            .addComponent(first_answ)
                            .addComponent(question)
                            .addComponent(fourth_answ))
                        .addContainerGap(138, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup( //�������� ����������� �� ��������� 
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING) //�������� ����������� ����������� ���� �����
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(question) //���������� ��������
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(first_answ)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(second_answ)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(third_answ)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fourth_answ)
                .addGap(22, 22, 22) //������� ������� ������������ ����� ����������
                .addComponent(next)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mark.setText("������: ");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");
        
        jLabel14.setText("jLabel14");
        
        jLabel15.setText("jLabel15");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup( //���������� ��������� �� ����������� 
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING) //�������� ����������� �����������
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap() //��������� ��������
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(mark) //���������� �������� 
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel1)
                            .addComponent(jLabel14))
                        .addGap(27, 27, 27) //������� ������� ������������
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup( //���������� ��������� �� ��������� 
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup() //���������������� ���������� ���������
                .addContainerGap() //������ ������������
                .addComponent(mark) //������� "������"
                .addGap(1, 1, 1) //������ ������������
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane()); //������� ���������� ������� �� �����
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) //���������� ������ ������ � ��������� ������ ������ ��������
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) //���������� ������ � ��������� � �������� �� ���
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE) //���������� ������ � ������� � ������������
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setVisible(false); //������� ������ � �����
        jPanel2.setVisible(false);
        ActionListener actionListener = new NextActionListener();
        next.addActionListener(actionListener);
        actionListener = new TestActionListener();
        jButton1.addActionListener(actionListener);
        pack();
    } 
	
	/**
	 * ���������� ��������� ����� ������������.
	 */
	public class NextActionListener implements ActionListener {
		/**
		 * ������� � ������ ������� � ��������� �����������. 
		 */
		     public void actionPerformed(ActionEvent e) {    
			//studentsAnswers.add(getSelectedButtonNumber()); //��������� ������ ������
		    studentsAnswers[count-1] = getSelectedButtonNumber();
		    //System.out.println(count);
	        if(count < 5) //������� �������� �� ���� ��������
	        {
	        	if(count == 4)
	        		next.setText("����������");
	        	 question.setText(qst[rand.get(count)].GetQuestion()); //��������� �������
	        	 String[] answ = qst[rand.get(count)].GetAnswers(); //��������� ������
	             first_answ.setText(answ[0]); 
	             second_answ.setText(answ[1]);
	             third_answ.setText(answ[2]);
	             fourth_answ.setText(answ[3]);
	             count++;
	        }
	        else {
	        	stop = System.currentTimeMillis();
	        	int st_mark = 0;
	        	st += tname.getText() + ";" + tgroup.getText() +";";
	        	for(int i = 0; i < studentsAnswers.length; i++) { 
	        		//����������� ������
	        		st += studentsAnswers[i] +";";
	        		if(studentsAnswers[i].equals(qst[rand.get(i)].GetRightAnswer())) {
	        			st_mark++;
	        			isTrue[i] = "True";
	        		}
	        		else
	        			isTrue[i] = "False";
	        		st += isTrue[i] + ";";
	        	}
	        	st += Integer.toString(st_mark) +";" + Integer.toString((int)(stop - start)/1000);
	        	//st = new Student(tname.getText(), tgroup.getText(), studentsAnswers, isTrue, st_mark,(int)(stop - start)/1000);
	        	isReady = true;
	        	// + studentsAnswers. +";" + isTrue
	        	mark.setText("������: " + Integer.toString(st_mark));
	        	jLabel1.setText("������ ��������");
	        	jLabel2.setText("���������� ������");
	        	jLabel6.setText(studentsAnswers[0]); //����� ������� ��������
	        	jLabel7.setText(qst[rand.get(0)].GetRightAnswer()); //� ���������� �������
	        	jLabel8.setText(studentsAnswers[1]);
	        	jLabel9.setText(qst[rand.get(1)].GetRightAnswer());
	        	jLabel10.setText(studentsAnswers[2]);
	        	jLabel11.setText(qst[rand.get(2)].GetRightAnswer());
	        	jLabel12.setText(studentsAnswers[3]);
	        	jLabel13.setText(qst[rand.get(3)].GetRightAnswer());
	        	jLabel14.setText(studentsAnswers[4]);
	        	jLabel15.setText(qst[rand.get(4)].GetRightAnswer());
	        	setMySize(1033,350); //������� ������� �����
	        	jPanel3.setVisible(true);
	        }	        	
	    } 
	}
	/**
	 * 	��������� ������ ������ ��������. 
	 */
	public class TestActionListener implements ActionListener {
		/**
		 * ��������� � ��������� ������ ������ ��������.
		 */
	     public void actionPerformed(ActionEvent e) {    
	    	 start = System.currentTimeMillis(); 
	    	 jPanel2.setVisible(true);
	    	 setMySize(933,350); //������� ������� �����
	     }
	}
	/**
	 * ��� ��������� ������ ��������� ������.
	 * @return ����� ������
	 */
	private String getSelectedButtonNumber() {
		int i = 1;
        for (Enumeration<AbstractButton> buttons = answers.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return Integer.toString(i);
            }
            i++;
        }
        return null;
    }
	/**
	 * ��������� ������ �������� ��� ������������.
	 * @return ���� ��������� ��������� ��������
	 */
	private List<Integer> RandQst() {
		List<Integer> rand = new ArrayList<Integer>();	
		while(rand.size() < 5){  
			int n = (int)(Math.random()*10); //��������� ����� �� ��������� [0;9]
			if(!rand.contains(n))
				rand.add(n);
		}
		return rand;
	}
	/**
	 * ������� ������� �����.
	 * @param width - �������� ������
	 * @param height - �������� ������
	 */
	private void setMySize(int width, int height) {
		this.setSize(new Dimension(width, height));
	}
	public String getStudentInfo() {
		return st;
	}
	public boolean isReady() {
		return isReady;
	}
	/**
	 * ��������� ���������� ������������.
	 * @return ������ � ������������ ����������� � ���� ������������ ��������.
	 */
	
}