package pao.services.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pao.model.artworks.Artist;
import pao.services.interfaces.artworks.ArtistInterface;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class ArtistInterfaceImplementation implements ArtistInterface {
    private static SortedSet<Artist> artistsList = new TreeSet<>(new Comparator<Artist>() {
        @Override
        public int compare(Artist o1, Artist o2) {
            int result = o1.getFirstName().compareTo(o2.getFirstName());
            if (result == 0)
            {
                result = o1.getLastName().compareTo(o2.getFirstName());
            }
            if (result == 0)
            {
                result = o1.getBirthDate().compareTo(o2.getBirthDate());
            }
            return result;
        }
    });

    @Override
    public Optional<Artist> getArtistsByMovement(String movement) {
        return artistsList.stream()
                .filter(artist -> artist.getMovement().equals(movement))
                .findAny();
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
    public SortedSet<Artist> getAllArtistsFromList() {
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
        artistsList = (SortedSet<Artist>) artistsList.stream()
                                                     .filter(element -> !id.equals(element.getId()))
                                                     .collect(Collectors.toSet());
    }

    @Override
    public void removeArtistByFirstNameLastName(String firstName, String lastName)
    {
        artistsList = (SortedSet<Artist>) artistsList.stream()
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
