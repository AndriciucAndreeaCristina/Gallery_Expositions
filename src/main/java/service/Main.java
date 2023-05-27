package service;

import pao.application.Gallery;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, SQLException {
        Scanner scanner = new Scanner(System.in);
        Gallery gallery = Gallery.getInstance();
        gallery.intro(scanner);

       // Connection conn = DatabaseConfiguration.getDatabaseConnection();
        // The newInstance() call is a work around for some
        // broken Java implementations
    }
}
