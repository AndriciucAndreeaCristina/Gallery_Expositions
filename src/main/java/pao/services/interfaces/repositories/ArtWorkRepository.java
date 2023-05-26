package pao.services.interfaces.repositories;

import pao.model.artworks.Artist;
import pao.model.artworks.Artwork;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArtWorkRepository {
    Optional<Artwork> getArtworkById(UUID id);
    List<Artwork> getArtworkByCreator(Artist creator);
    Optional<Artwork> getArtworkByTitle(String title);
    List<Artwork> getAllArtworksFromSet();
    void addAllArtworks(List artworksList);
    void addArtwork(Artwork artwork);
    void removeArtworkById(UUID id);
    void removeArtworkByTitle(String title);
    void removeArtworkByCreator(Artist creator);
    void modifyArtworkById(UUID id, Artwork newArtwork);
}
