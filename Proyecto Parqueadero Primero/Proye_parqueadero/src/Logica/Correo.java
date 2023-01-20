package Logica;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane; 

public class Correo {

    private String correo = null;
    private String contrasena = null;

    public Correo(String correo, String contrasena) {

        this.correo = correo;
        this.contrasena = contrasena;
        enviar_Correo();
    }

    private void enviar_Correo() {

        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "ronny.leo2011@gmail.com";
            String passwordRemitente = "losmaspepas2018";
            String correoReceptor = correo;
            String asunto = "Sistema de Parqueo " + "\n\n Recuperar Contraseña";
            //String mensaje = "Hola<br>Este es el contenido de mi primer correo desde <b>java</b><br><br>Por <b>Códigos de Programación</b>";

            String mensaje = "Tu contraseña es : " + contrasena;

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            /// message.setText(mensaje, "ISO-8859-1", "html");
            message.setText(mensaje);

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            //JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
        } catch (AddressException ex) {

            JOptionPane.showMessageDialog(null, "Surgio un problema , intenta mas tarde ");
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Surgio un problema , intenta mas tarde  " );
        }

    }

}
