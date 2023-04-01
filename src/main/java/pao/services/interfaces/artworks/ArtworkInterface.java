package pao.services.interfaces.artworks;

import pao.model.artworks.Artist;
import pao.model.artworks.Artwork;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface ArtworkInterface {
    Optional<Artwork> getArtworkById(UUID id);
    Optional<Artwork> getArtworkByCreator(Artist creator);
    Optional<Artwork> getArtworkByTitle(String title);
    Set<Artwork> getAllArtworksFromSet();
    void addAllArtworks(Set artworksList);
    void addArtwork(Artwork artwork);
    void removeArtworkById(UUID id);
    void removeArtworkByTitle(String title);
    void removeArtworkByCreator(Artist creator);
    void modifyArtworkById(UUID id, Artwork newArtwork);
}
