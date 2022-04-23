package com.telefonica.p7.controller;

import com.telefonica.p7.model.Offer;
import com.telefonica.p7.service.OfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OfferController {
    @Autowired
    private OfferService offerService;
    
    //SELECT
    @GetMapping("/offers")
    public ResponseEntity<Iterable<Offer>> getOffers(@RequestParam(required=false) String offerAvailable) {

        Iterable<Offer> response = offerService.getOffers(offerAvailable);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/offers/with-application")
    public ResponseEntity<Iterable<Offer>> getOffersWithApplication() {

        Iterable<Offer> response = offerService.getOffersWithApplication();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/offers/and-applications")
    public ResponseEntity<Iterable<Offer>> getAllOffers() {

        Iterable<Offer> response = offerService.getAllOffers();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/offers/without-application")
    public ResponseEntity<Iterable<Offer>> getEmtpyOffers() {

        Iterable<Offer> response = offerService.getEmptyOffers();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<Offer> getOffer(@PathVariable String id){
        Offer respuesta = offerService.getOffer(id);
        return ResponseEntity.ok().body(respuesta);
    }


    //DELETE
    @DeleteMapping("/offers/{id}")
    public ResponseEntity<Offer> deleteOffer(@PathVariable String id) {
        offerService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }

    //INSERT
    @PostMapping("/offers")
    public ResponseEntity<Offer> createOffer(@RequestBody Offer offer) {
        Offer newOffer = offerService.insertOffer(offer);
        return ResponseEntity.ok().body(newOffer);
    }

    //UPDATE
    @PutMapping("/offers/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable String id, @RequestBody Offer offer){
        Offer update = offerService.updateOffer(id, offer);
        return ResponseEntity.ok().body(update);
    }

}
