package service;

<<<<<<< Updated upstream
import pao.application.Gallery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gallery gallery = Gallery.getInstance();
        gallery.intro(scanner);
=======
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//        Gallery gallery = Gallery.getInstance();
//        gallery.intro(scanner);

        Connection conn = null;
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/" +
                            "user=root&password=4863");

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }


>>>>>>> Stashed changes
    }
}