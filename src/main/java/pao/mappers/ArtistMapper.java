package pao.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pao.model.artworks.Artist;

public class ArtistMapper {
    public Artist artistMapper(ObjectMapper objectMapper, String body) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(body);

        Artist artist = new Artist();

        //artist.setId(jsonNode.get("id"));
        artist.setDescription(String.valueOf(jsonNode.get("biography")));
        artist.setLastName(String.valueOf(jsonNode.get("name")));
        //artist.setBirthDate(LocalDate.parse(jsonNode.get("birth_year").asText()));

        return artist;
    }
}
