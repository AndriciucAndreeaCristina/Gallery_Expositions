package service;

import pao.gateways.Requests;
import pao.services.impl.artworks.ArtistInterfaceImplementation;
import pao.services.interfaces.artworks.ArtistInterface;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//        Gallery gallery = Gallery.getInstance();
//        gallery.intro(scanner);
        Requests requests = new Requests();
        requests.saveNewArtistInfo();

        ArtistInterface artist = new ArtistInterfaceImplementation();

        System.out.println(artist.getAllArtistsFromList());
    }
}