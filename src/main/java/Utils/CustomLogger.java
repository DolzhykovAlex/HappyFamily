package Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogger {
  static   public void info(String s) {
        saveLog("\n[DEBUG] " + getDate() + s);

    }

   static public void error(String s) {
        saveLog("\n[ERROR] " + getDate() + s);

    }

 static    public void saveLog(String string) {
        try {
            FileWriter writer = new FileWriter("src/main/java/baseClasses/files/application.log", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(string);
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println("Error in save log:\n" + string + e);
        }
    }

  static   public String getDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return  formatForDateNow.format(dateNow);
    }

}
