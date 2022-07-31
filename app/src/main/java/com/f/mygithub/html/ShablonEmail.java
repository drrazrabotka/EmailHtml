package com.f.mygithub.html;

public class ShablonEmail {
    public static byte[] getShablonOne() {
        String h1 = "Вы вошли в программу email html";
        String body = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" >\n" +
                "<title>Happy happy</title>\n" +
                "<style type=\"text/css\">\n" +
                "\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "      <b>hell</b>\n" +
                "</body>\n" +
                "</html>";

        return body.getBytes();
    }

    public static byte[] getShablonTwo(){
        String body = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" >\n" +
                "<title>Happy happy</title>\n" +
                "<style type=\"text/css\">\n" +
                "\n" +
                "</style>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; padding: 0;\">\n" +
                "<table align=\"center\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"\600\" style=\"border-collapse: collapse;\">\n"+
                "<tr>\n"+
                    "<td align=\"center\" bgcolor=\"#70bbd9\" style=\"padding: 40px 0 30px 0;\">Hello!\n"+
                "</td>\n"+
                "<td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\n"+
                "<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"+
                     "<tr>\n"+
                         "<td> привет ребята\n"+"</td>\n"+
                     "</tr>\n"+
                "<tr>\n"+
                     "<td style=\"padding: 20px 0 30px 0;\"> Привет ребята трынь тыдынь</td>\n"+
                 "</tr>\n"+
                "<tr>\n"+
                      "<td> Row3\n"+"</td>\n"+
                 "</tr>\n"+
                 "</table>\n"+
                "</td>\n"+
                "</table>\n"+
                "</body>\n" +
                "</html>";

        return body.getBytes();
    }

}
