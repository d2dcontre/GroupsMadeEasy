import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintStream;
import javax.swing.*;

public class StartGUI implements WindowListener {

    private MySQL my;
    private JFrame frame;
    PrintStream out = System.out;
    private boolean retrieved = false;

    public StartGUI(MySQL my) {
        System.out.println("GUI constructor");
        this.my = my;
        login();
    }

    public void login() {
        frame = new JFrame();
        frame.addWindowListener(this);
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        final JTextField textField = new JTextField();
        textField.setBounds(164, 88, 182, 20);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(77, 91, 77, 14);
        panel.add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(77, 122, 77, 14);
        panel.add(lblPassword);

        JButton btnLogin = new JButton("Login");
        //btnLogin.setAction(action);
        btnLogin.setBounds(164, 180, 89, 23);
        panel.add(btnLogin);
        final JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(164, 119, 182, 20);
        panel.add(passwordField);

        JButton btnRegister = new JButton("Register");
        //btnRegister.setAction(action_1);
        btnLogin.addActionListener(null);
        btnRegister.setBounds(257, 180, 89, 23);
        panel.add(btnRegister);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                String user = textField.getText();
                String p = "";
                char[] pass = passwordField.getPassword();
                for(int i = 0; i < pass.length; i++){
                    p = p + pass[i];
                }
                out.println("user: " + user + ", pass: " + p);
                TransferStuff ts = my.loginQuery(user, p);
                if(ts != null /*&& ts.groupID != null && ts.groupName != null*/) {
                    Runner.groupIDs = ts.groupID;
                    Runner.groupNames = ts.groupName;
                    Runner.idNo = ts.id;
                    
                    out.println("No issues with setting values");
                    System.out.print("GroupID ");
                    Runner.printer(Runner.groupIDs);
                    System.out.print("GroupNames ");
                    Runner.printer(Runner.groupNames);
                    out.println("ID: " + Runner.idNo);
                    
                    frame.dispose();
                    frame.setVisible(false);
                    GroupSelection gs = new GroupSelection(my);
                }
            } 
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                /*WindowEvent wev = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);*/
                //SOURCE: http://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
                frame.dispose();
                frame.setVisible(false);
                // SOURCE: http://www.dreamincode.net/forums/topic/164349-clicking-a-button-to-open-a-new-jframe-and-then-close-the-recent-jfram/
                register();
            }
        });
        
        frame.setTitle("Welcome - Login");
        frame.setVisible(true);
    }
    
    public void register() {
        frame = new JFrame();
        frame.addWindowListener(this);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        JButton retScreen = new JButton();
        retScreen.setText("Return");
        retScreen.setBounds(0,5,80,20);
        panel.add(retScreen);

        JLabel lblID = new JLabel("ID No.");
        lblID.setBounds(51, 70, 92, 14);
        panel.add(lblID);

        JLabel lblFName = new JLabel("Name");
        lblFName.setBounds(51, 95, 92, 14);
        panel.add(lblFName);

        JLabel lblName = new JLabel("Username");
        lblName.setBounds(51, 120, 92, 14);
        panel.add(lblName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(51, 145, 92, 14);
        panel.add(lblPassword);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(51, 170, 92, 14);
        panel.add(lblEmail);

        JLabel lblMobileNumber = new JLabel("Mobile Number");
        lblMobileNumber.setBounds(51, 195, 92, 14);
        panel.add(lblMobileNumber);

        JLabel lblHomeNumber = new JLabel("Home Number");
        lblHomeNumber.setBounds(51, 220, 92, 14);
        panel.add(lblHomeNumber);

        JLabel lblHomeAddress = new JLabel("Home Address");
        lblHomeAddress.setBounds(51, 245, 92, 14);
        panel.add(lblHomeAddress);
        
        final JTextField textField_5 = new JTextField();
        textField_5.setBounds(153, 67, 210, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);
        
        final JTextField textField_6 = new JTextField();
        textField_6.setBounds(153, 92, 210, 20);
        panel.add(textField_6);
        textField_6.setColumns(10);
        
        final JTextField textField = new JTextField();
        textField.setBounds(153, 117, 210, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        final JTextField textField_2 = new JTextField();
        textField_2.setBounds(153, 167, 212, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        final JTextField textField_3 = new JTextField();
        textField_3.setBounds(153, 192, 86, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);

        final JTextField textField_4 = new JTextField();
        textField_4.setBounds(153, 217, 86, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);

        final JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(153, 145, 210, 14);
        panel.add(passwordField);

        final JEditorPane dtrpnBLB = new JEditorPane();
        dtrpnBLB.setBounds(153, 245, 188, 118);
        panel.add(dtrpnBLB);

        JButton btnSaveChanges = new JButton("Register");
        btnSaveChanges.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                //int id = Integer.parseInt(textField_5.getText() );
                String id = textField_5.getText();
                String u = textField.getText();
                String p = "";
                char[] pass = passwordField.getPassword();
                for(int i = 0; i < pass.length; i++){
                    p = p + pass[i];
                }
                String em = textField_2.getText();
                String m = textField_3.getText();
                String h = textField_4.getText();
                String a = dtrpnBLB.getText();
                
                if(retrieved) {
                    int execUp = my.registerExecute(id, u, p, em, m, h, a);
                    if(execUp > 0) {
                        frame.dispose();
                        frame.setVisible(false);
                        //SOURCE: http://www.dreamincode.net/forums/topic/164349-clicking-a-button-to-open-a-new-jframe-and-then-close-the-recent-jfram/
                        login();
                    }
                    else {
                        System.out.println("Nothing modified. Error. regExec value is: " + execUp);
                    }
                }
                else
                    out.println("Have not retrieved a valied user using ID");
            }
        });
        //btnSaveChanges.setAction(action);
        btnSaveChanges.setBounds(153, 398, 117, 23);
        panel.add(btnSaveChanges);

        JButton btnRetrieve = new JButton("Retrieve");
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String find = textField_5.getText();
                String get = my.registerQuery(Integer.parseInt(find) );
                if(get != null) {
                    textField_6.setText(get);
                    retrieved = true;
                }
                else {
                    out.println("Did not find that person");
                    retrieved = false;
                }
            }
        });
        btnRetrieve.setBounds(373, 66, 86, 23);
        panel.add(btnRetrieve);
        
        retScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet.");
                /*WindowEvent wev = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);*/
                //SOURCE: http://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe
                frame.dispose();
                frame.setVisible(false);
                //SOURCE: http://www.dreamincode.net/forums/topic/164349-clicking-a-button-to-open-a-new-jframe-and-then-close-the-recent-jfram/
                login();
            }
        });
        
        frame.setTitle("Register Now - Groups Made Easy");
        frame.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        my.close();
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
}