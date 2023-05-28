package service;

import pao.gateways.Requests;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, SQLException {
//        Scanner scanner = new Scanner(System.in);
//        Gallery gallery = Gallery.getInstance();
//        gallery.intro(scanner);
        Requests req = new Requests();
        req.saveNewArtistInfo();
       // Connection conn = DatabaseConfiguration.getDatabaseConnection();
        // The newInstance() call is a work around for some
        // broken Java implementations
    }
}
