package pl.wp.owndbasegameofthrone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wp.owndbasegameofthrone.model.Book;
import pl.wp.owndbasegameofthrone.model.CharacterGoT;
import pl.wp.owndbasegameofthrone.repository.BookRepository;
import pl.wp.owndbasegameofthrone.repository.CharacterRepository;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Transactional
    public void saveCharacters(List<CharacterGoT>characters) {
        characterRepository.saveAll(characters);
    }
    @Transactional
    public List<CharacterGoT>getAllCharacters(){
        return characterRepository.findAll();
    }
}
