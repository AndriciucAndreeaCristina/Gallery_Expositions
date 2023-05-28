package pao.model.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pao.model.artworks.Artwork;
import pao.services.impl.repositories.ArtWorkRepositoryImpl;
import pao.services.interfaces.repositories.ArtWorkRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {
    @Mock
    private Connection mockConnection;
    @Mock
    private List<Artwork> artworkList;
    @Mock
    private ArtWorkRepository artworkMapper = new ArtWorkRepositoryImpl();
    @Test
    public void testConnectionNotNull() {
        Assert.assertNotNull(mockConnection);
    }
    @Test
    public void testArtwork() throws SQLException {
        artworkList = artworkMapper.getAllArtworksFromSet();
        assertEquals(0, artworkList.size());
        Mockito.when(artworkList.size()).thenReturn(10);
        assertEquals(10, artworkList.size());
    }
}
