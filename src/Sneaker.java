
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
    public static String url = "";

    public Sneaker(){

        final JTextField txt = new JTextField("");
        txt.setBounds(1, 1, 300, 30);

        JButton button = new JButton(" >> CLICK ME <<");
        button.setBounds(40, 40, 200, 40);

        setLayout(null);
        add(txt);
        add(button);

        // Add action listener to button[/B]
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Execute when button is pressed
                //System.out.println("You clicked the button");

                String getTxt = txt.getText();
                url = getTxt;
                System.out.println(url);
                System.out.println(getTxt);

                int messageType = JOptionPane.PLAIN_MESSAGE;

                JOptionPane.showMessageDialog(null, getTxt, "Michel Sneaker App", messageType);
            }
        });

    }

    public static void main(String[] args) {

        JFrame frame1 = new JFrame("");
        frame1.getContentPane().add(new Sneaker());

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(310, 130);
        frame1.setVisible(true);


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