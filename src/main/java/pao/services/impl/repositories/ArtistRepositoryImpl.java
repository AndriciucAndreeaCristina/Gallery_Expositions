package pao.services.impl.repositories;

import pao.model.artworks.Artist;
import pao.services.interfaces.repositories.ArtistRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ArtistRepositoryImpl implements ArtistRepository {
    @Override
    public List<Artist> getArtistsByMovement(String movement) {
        return null;
    }

    @Override
    public Optional<Artist> getArtistByFirstName(String firstName) {
        return Optional.empty();
    }

    @Override
    public Optional<Artist> getArtistByLastName(String lastName) {
        return Optional.empty();
    }

    @Override
    public Optional<Artist> getArtistById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Artist> getAllArtistsFromList() {
        return null;
    }

    @Override
    public void addAllArtists(List<Artist> artistsList) {

    }

    @Override
    public void addArtist(Artist artist) {

    }

    @Override
    public void removeArtistById(UUID id) {

    }

    @Override
    public void removeArtistByFirstNameLastName(String firstName, String lastName) {

    }

    @Override
    public void modifyArtistById(UUID id, Artist newArtist) {

    }
}
