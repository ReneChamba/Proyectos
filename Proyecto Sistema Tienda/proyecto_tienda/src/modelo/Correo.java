package modelo;

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

    public Correo() {

    }

    public boolean enviar_Correo(String correo, String usuario, String contrasena) {

        boolean retorno = false;

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
            String asunto = "Sistema de Ventas " + "\n\n Recuperar Contraseña";
            //String mensaje = "Hola<br>Este es el contenido de mi primer correo desde <b>java</b><br><br>Por <b>Códigos de Programación</b>";

            String mensaje = "Tu usuario es : " + usuario + " ;  Contraseña: " + contrasena;

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
            retorno = true;

            //JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");
        } catch (AddressException ex) {

            JOptionPane.showMessageDialog(null, "Surgio un problema , intenta mas tarde " + ex);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Surgio un problema , intenta mas tarde + " + ex);
        }
        return retorno;

    }

}
