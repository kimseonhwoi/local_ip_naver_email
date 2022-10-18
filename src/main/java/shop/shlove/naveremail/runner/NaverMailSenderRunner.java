package shop.shlove.naveremail.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

@Component
public class NaverMailSenderRunner {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.to}")
    private String[] toList;

    public void sand() throws Exception {
        MimeMessage m = mailSender.createMimeMessage();
        MimeMessageHelper h = new MimeMessageHelper(m,"UTF-8");
        h.setFrom(username);
        h.setTo(toList);
        h.setSubject("[SERVER IP]");
        h.setText("SERVER IP LIST" + getAddress());
        mailSender.send(m);
    }

    private String getAddress() throws Exception{
        String address = "";
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while(e.hasMoreElements())
        {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements())
            {
                InetAddress i = (InetAddress) ee.nextElement();
                address += "\n["+i.getHostAddress()+"]\n";
            }
        }
        return address;
    }
}
