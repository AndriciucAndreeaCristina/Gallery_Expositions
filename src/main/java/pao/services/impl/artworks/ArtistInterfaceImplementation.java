package pao.services.impl.artworks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pao.model.abstracts.Artist;
import pao.services.interfaces.artworks.ArtistInterface;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class ArtistInterfaceImplementation implements ArtistInterface {
    private static List<Artist> artistsList = new ArrayList<Artist>();

    @Override
    public SortedSet<Artist> getArtistsByMovement(String movement) {
        return (SortedSet<Artist>) artistsList.stream()
                .filter(artist -> artist.getMovement().equals(movement));
    }

    @Override
    public Optional<Artist> getArtistByFirstName(String firstName) {
        return artistsList.stream()
                .filter(artist -> artist.getFirstName().equals(firstName))
                .findAny();
    }

    @Override
    public Optional<Artist> getArtistByLastName(String lastName) {
        return artistsList.stream()
                .filter(artist -> artist.getLastName().equals(lastName))
                .findAny();
    }

    @Override
    public Optional<Artist> getArtistById(UUID id) {
        return artistsList.stream()
                .filter(artist -> artist.getId().equals(id))
                .findAny();
    }

    @Override
    public List<Artist> getAllArtistsFromList() {
        return artistsList;
    }

    @Override
    public void addAllArtists(SortedSet<Artist> artistsList) {
        artistsList.addAll(artistsList);
    }

    @Override
    public void addArtist(Artist artist) {
        artistsList.add(artist);
    }

    @Override
    public void removeArtistById(UUID id) {
        artistsList = (ArrayList<Artist>) artistsList.stream()
                                                     .filter(element -> !id.equals(element.getId()))
                                                     .collect(Collectors.toSet());
    }

    @Override
    public void removeArtistByFirstNameLastName(String firstName, String lastName)
    {
        artistsList = (ArrayList<Artist>) artistsList.stream()
                .filter(element -> !(firstName.equals(element.getFirstName())
                                     && lastName.equals(element.getLastName())))
                .collect(Collectors.toSet());
    }
    @Override
    public void modifyArtistById(UUID id, Artist newArtist) {
        removeArtistById(id);
        addArtist(newArtist);
    }
}
