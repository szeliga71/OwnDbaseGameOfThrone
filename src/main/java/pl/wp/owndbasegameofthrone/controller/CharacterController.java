package pl.wp.owndbasegameofthrone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wp.owndbasegameofthrone.model.Book;
import pl.wp.owndbasegameofthrone.model.CharacterGoT;
import pl.wp.owndbasegameofthrone.service.CharacterService;

import java.util.List;

@Controller
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @RequestMapping("/characters")
    public String getAllCharacters(Model model){
        List<CharacterGoT> characters=characterService.getAllCharacters();
        model.addAttribute("characterList", characters);
        return "characters";
    }
}
