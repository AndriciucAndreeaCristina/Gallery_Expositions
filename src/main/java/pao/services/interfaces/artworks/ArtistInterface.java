package pao.services.interfaces.artworks;

import pao.model.artworks.Artist;

import java.util.Optional;
import java.util.SortedSet;
import java.util.UUID;

public interface ArtistInterface {
    SortedSet<Artist> getArtistsByMovement(String movement);
    Optional<Artist> getArtistByFirstName(String firstName);
    Optional<Artist> getArtistByLastName(String lastName);
    Optional<Artist> getArtistById(UUID id);

    SortedSet<Artist> getAllArtistsFromList();
    void addAllArtists(SortedSet<Artist> artistsList);
    void addArtist(Artist artist);
    void removeArtistById(UUID id);
    void removeArtistByFirstNameLastName(String firstName, String lastName);
    void modifyArtistById(UUID id, Artist newArtist);
}
