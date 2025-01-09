package shpagintp.pkmn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shpagintp.pkmn.models.Card;
import shpagintp.pkmn.service.CardService;
import shpagintp.pkmn.service.PokemonTCGService;
import shpagintp.pkmn.models.Student;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private PokemonTCGService pokemonTCGService;

    @GetMapping("")
    public List<Card> getAllCards() {
        System.out.println("getAllCards");
        return cardService.getAllCards();
    }

    @GetMapping("/{name}")
    public Card getCardByName(@PathVariable String name) {
        return cardService.getCardByName(name);
    }

    @GetMapping("/owner")
    public Card getCardByOwner(@RequestBody Student student) {
        return cardService.getCardByOwner(student.getFirstName(), student.getSurName(), student.getFamilyName());
    }

    @GetMapping("/id/{id}")
    public Card getCardById(@PathVariable UUID id) {
        return cardService.getCardById(id);
    }

    @PostMapping("")
    public Card saveCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @GetMapping("/image/{cardName}")
    public String getCardImage(@PathVariable String cardName) {
        return pokemonTCGService.getCardImageByName(cardName);
    }
}
