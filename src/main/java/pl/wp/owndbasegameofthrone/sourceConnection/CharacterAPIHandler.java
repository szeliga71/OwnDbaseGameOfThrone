package pl.wp.owndbasegameofthrone.sourceConnection;



import pl.wp.owndbasegameofthrone.mapper.CharacterMapper;
import pl.wp.owndbasegameofthrone.model.CharacterGoT;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CharacterAPIHandler {
    private final HttpClient client = HttpClient.newHttpClient();
    private final String CHARACTER_API_URI = "https://www.anapioficeandfire.com/api/characters/";


    public List<CharacterGoT> getAllCharacters(){
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(CHARACTER_API_URI)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return CharacterMapper.jsonToCharacterList(response.body());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CharacterGoT> getAllCharactersLoop()  {

        List<CharacterGoT> allCharacters = new ArrayList<>();
        String nextPageUrl = CHARACTER_API_URI; // start with the initial page

        while (nextPageUrl != null) {
            try{
            HttpRequest request = HttpRequest.newBuilder(new URI(nextPageUrl)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            allCharacters.addAll(CharacterMapper.jsonToCharacterList(response.body()));
            nextPageUrl = getNextPageUrl(response);
        }catch (URISyntaxException | InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return allCharacters;
    }

    private String getNextPageUrl(HttpResponse<String> response) {
        // Parse the 'Link' header to find the URL for the next page
        String linkHeader = response.headers().firstValue("Link").orElse(null);
        if (linkHeader != null) {
            for (String part : linkHeader.split(", ")) {
                if (part.contains("rel=\"next\"")) {
                    return part.substring(part.indexOf("<") + 1, part.indexOf(">"));
                }
            }
        }
        return null; // no more pages
    }

    //===============================================================================================================
    public CharacterGoT getCharacterById(String id){
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(CHARACTER_API_URI+id)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return CharacterMapper.jsonToCharacter(response.body());
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CharacterGoT getCharacterByName(String characterName){
        String encodeCharacterName= URLEncoder.encode(characterName, StandardCharsets.UTF_8);
        try{
            HttpRequest request=HttpRequest.newBuilder(new URI(CHARACTER_API_URI+"?name="+encodeCharacterName)).GET().build();
            HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
            return CharacterMapper.jsonToCharacter(response.body());
        }catch(IOException|InterruptedException|URISyntaxException e){
            throw new RuntimeException(e);
        }
    }

}
