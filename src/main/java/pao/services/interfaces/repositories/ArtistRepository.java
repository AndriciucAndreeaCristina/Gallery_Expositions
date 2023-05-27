package pao.services.interfaces.repositories;

import pao.model.abstracts.Artist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArtistRepository {
    List<Artist> getArtistsByMovement(String movement);
    Optional<Artist> getArtistByFirstName(String firstName) throws Exception;
    Optional<Object> getArtistByLastName(String lastName) throws Exception;
    Optional<Artist> getArtistById(UUID id) throws Exception;

    void addArtist(Artist artist) throws Exception;
    void removeArtistById(UUID id) throws Exception;
    void removeArtistByFirstNameLastName(String firstName, String lastName) throws Exception;
    void modifyArtistById(UUID id, Artist newArtist);
}
