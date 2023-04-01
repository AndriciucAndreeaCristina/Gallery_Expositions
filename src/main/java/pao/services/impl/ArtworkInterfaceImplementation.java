package pao.services.impl;

import pao.model.artworks.Artist;
import pao.model.artworks.Artwork;
import pao.services.interfaces.artworks.ArtworkInterface;

import java.util.*;
import java.util.stream.Collectors;

public class ArtworkInterfaceImplementation implements ArtworkInterface {

    private static Set<Artwork> artworksSet = new HashSet<>();
    @Override
    public Optional<Artwork> getArtworkById(UUID id) {
        return artworksSet.stream()
                .filter(artwork -> artwork.getId().equals(id))
                .findAny();
    }

    @Override
    public Optional<Artwork> getArtworkByCreator(Artist creator) {
        return artworksSet.stream()
                .filter(artwork -> artwork.getCreator().equals(creator))
                .findAny();
    }

    @Override
    public Optional<Artwork> getArtworkByTitle(String title) {
        return artworksSet.stream()
                .filter(artwork -> artwork.getTitle().equals(title))
                .findAny();
    }

    @Override
    public Set<Artwork> getAllArtworksFromSet() {
        return artworksSet;
    }

    @Override
    public void addAllArtworks(Set artworksList) {
        artworksSet.addAll(artworksList);
    }

    @Override
    public void addArtwork(Artwork artwork) {
        artworksSet.add(artwork);
    }

    @Override
    public void removeArtworkById(UUID id) {
        artworksSet = artworksSet.stream()
                                 .filter(element -> !id.equals(element.getId()))
                                 .collect(Collectors.toSet());
    }

    @Override
    public void removeArtworkByTitle(String title) {
        artworksSet = artworksSet.stream()
                .filter(element -> !title.equals(element.getTitle()))
                .collect(Collectors.toSet());
    }

    @Override
    public void removeArtworkByCreator(Artist creator) {
        artworksSet = artworksSet.stream()
                .filter(element -> !creator.equals(element.getCreator()))
                .collect(Collectors.toSet());
    }

    @Override
    public void modifyArtworkById(UUID id, Artwork newArtwork) {
        removeArtworkById(id);
        addArtwork(newArtwork);
    }
}
