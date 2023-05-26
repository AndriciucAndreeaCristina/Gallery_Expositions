package pao.services.interfaces.repositories;

import pao.model.artworks.Artist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArtistRepository {
    List<Artist> getArtistsByMovement(String movement);
    Optional<Artist> getArtistByFirstName(String firstName);
    Optional<Object> getArtistByLastName(String lastName);
    Optional<Artist> getArtistById(UUID id);

    void addArtist(Artist artist);
    void removeArtistById(UUID id);
    void removeArtistByFirstNameLastName(String firstName, String lastName);
    void modifyArtistById(UUID id, Artist newArtist);
}
