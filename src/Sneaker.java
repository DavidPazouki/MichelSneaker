
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class Sneaker extends JPanel {
    public static WebDriver driver = null;
    public static String url;
    public static String firstName;
    public static String lastName;
    public static String cardNumber;
    public static String my;
    public static String cvc;
    public static String address;
    public static String size;

    public Sneaker() {

        final JTextField txt1 = new JTextField("url");
        txt1.setBounds(1, 1, 300, 30);

        final JTextField txt2 = new JTextField("FirstName");
        txt2.setBounds(1, 40, 300, 30);

        final JTextField txt3 = new JTextField("LastName");
        txt3.setBounds(1, 80, 300, 30);

        final JTextField txt4 = new JTextField("CardNumber");
        txt4.setBounds(1, 120, 300, 30);

        final JTextField txt5 = new JTextField("Month/Year");
        txt5.setBounds(1, 160, 300, 30);

        final JTextField txt6 = new JTextField("CVC");
        txt6.setBounds(1, 200, 300, 30);

        final JTextField txt7 = new JTextField("Address");
        txt7.setBounds(1, 240, 300, 30);

        final JTextField txt8 = new JTextField("Size");
        txt8.setBounds(1, 280, 300, 30);


        JButton button = new JButton(" >> CLICK ME <<");
        button.setBounds(40, 400, 200, 40);

        setLayout(null);
        add(txt1);
        add(txt2);
        add(txt3);
        add(txt4);
        add(txt5);
        add(txt6);
        add(txt7);
        add(txt8);
        add(button);

        // Add action listener to button[/B]
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Execute when button is pressed
                //System.out.println("You clicked the button");

                url = txt1.getText();
                firstName = txt2.getText();
                lastName = txt3.getText();
                cardNumber = txt4.getText();
                my = txt5.getText();
                cvc = txt6.getText();
                address = txt7.getText();
                size = txt8.getText();


                System.out.println(url);
                System.out.println(url);

                int messageType = JOptionPane.PLAIN_MESSAGE;

                JOptionPane.showMessageDialog(null, url, "Michel Sneaker App", messageType);


                //michel Code
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (url != "") {
                    //michel code
                    //System.setProperty("webdriver.chrome.driver", "\\driver\\chromedriver_75.exe");
                    System.setProperty("webdriver.chrome.driver", "\\driver\\chromedriver_75.exe");

                    driver = new ChromeDriver();
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    driver.navigate().to(url);
                    driver.manage().window();
                    String title = driver.getTitle();

                    driver.findElement(By.id("417")).click();
                    driver.findElement(By.id("addtocart_button")).click();

                    driver.findElement(By.className("btn-cart")).click();
                    driver.findElement(By.className("btn-proceed-checkout")).click();

                    System.out.print(title);
                }
            }
        });

    }

    public static void main(String[] args) {

        JFrame frame1 = new JFrame("");
        frame1.getContentPane().add(new Sneaker());

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(310, 130);
        frame1.setVisible(true);

    }
}