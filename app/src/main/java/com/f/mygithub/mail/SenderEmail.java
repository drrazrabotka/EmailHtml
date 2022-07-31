package com.f.mygithub.mail;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.f.mygithub.R;
import com.f.mygithub.fragments.ListShablonFragment;
import com.f.mygithub.fragments.LoginFragment;

import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SenderEmail {
    private Context context;
    private String login;
    private String password;
    private String to_email;
    private ProgressBar progressBar;
    private boolean error = true;


    public SenderEmail(ProgressBar progressBar){
        this.progressBar = progressBar;

    }

    public SenderEmail(ProgressBar progressBar, String to_email) {
        this.progressBar = progressBar;
        login = LoginFragment.l;
        password = LoginFragment.p;
        this.to_email = to_email;
    }

    public void senderAuthor(Fragment fragment, String login, String password){
        this.context = fragment.getContext();
        this.login = login;
        this.password = password;
        new Thread(() -> {
            try {
                MimeMessage message = new MimeMessage(getSession());
                DataHandler content = new DataHandler(new ByteArrayDataSource("произведен вход с приложения".getBytes(), "text/html"));
                message.setFrom(new InternetAddress(login));
                message.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(login)));
                message.setSubject("EmailHtml");
                message.setDataHandler(content);
                Transport.send(message);
            } catch (MessagingException e) {
                error = false;
                e.printStackTrace();
            }


            progressBar.post(() -> {
                if (error == true) {
                    progressBar.setVisibility(View.INVISIBLE);
                    FragmentTransaction fragmentTransaction = fragment
                            .getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction();

                    fragmentTransaction.replace(R.id.container, ListShablonFragment.class, null);
                    fragmentTransaction.commit();

                }else {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(context, "ошибка", Toast.LENGTH_LONG).show();
                }
            });
        }).start();

    }



    private  Properties getStmProperies(){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.yandex.ru");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.quitwait", "false");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        return properties;
    }

    private  Session getSession() {
        Session session = Session.getInstance(getStmProperies(),
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(login, password);
                    }
                });

        return session;
    }

    public  void sender(byte[] body) {
            new Thread(() -> {
                try {
                    error = true;
                    MimeMessage message = new MimeMessage(getSession());
                    DataHandler content = new DataHandler(new ByteArrayDataSource(body, "text/html"));
                    message.setFrom(new InternetAddress(to_email));
                    message.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(login)));
                    message.setSubject("EmailHtml");
                    message.setDataHandler(content);
                    Transport.send(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                    error = false;
                }

                progressBar.post(() -> {
                    if (error == true){
                        progressBar.setVisibility(View.INVISIBLE);

                    }

                });

            }).start();

        }



}
