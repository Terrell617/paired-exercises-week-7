package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public CatCard randomCard() {
        //CatFact fact = catFactService.getFact();
        CatPic picture = catPicService.getPic();
        CatCard card = new CatCard();
        card.setCatFact("This is a cat");
        card.setImgUrl(picture.getFile());
        return card;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CatCard> collectAllCards() {
        return catCardDao.list();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard getCard(@PathVariable int id) {
        return catCardDao.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void keepCard(@RequestBody CatCard card) {
        catCardDao.save(card);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateCaption(@RequestBody CatCard card, @PathVariable int id) {
        catCardDao.update(id, card);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        catCardDao.delete(id);
    }
}

