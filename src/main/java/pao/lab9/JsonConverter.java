package pao.lab9;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        // JSON string to deserialize
        String jsonString = "{\"id\": 1, \"name\": \"John\"}";

        try {
            // Deserialize JSON string to Java object
            Object myObject = objectMapper.readValue(jsonString, Object.class);
            System.out.println("Deserialized object: " + myObject);

            // Serialize Java object back to JSON string
            String serializedJson = objectMapper.writeValueAsString(myObject);
            System.out.println("Serialized JSON: " + serializedJson);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
