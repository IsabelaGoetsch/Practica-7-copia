package com.telefonica.p7.service.implementation;

import com.telefonica.p7.repository.OfferRepository;
import com.telefonica.p7.service.OfferService;
import com.telefonica.p7.model.Offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImplementation implements OfferService{
    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Iterable<Offer> getOffers(String offerAvailable){
        if(offerAvailable == null){
            return offerRepository.findAll();
        } else {
            return offerRepository.getOffersAvailable(offerAvailable);
        }
        
    }

    @Override
    public Iterable<Offer> getOffersWithApplication(){
        return offerRepository.getOffersWithApplication();
    }

    @Override
    public Iterable<Offer> getAllOffers(){
        return offerRepository.getAllOffers();
    }
    
    @Override
    public Iterable<Offer> getEmptyOffers(){
        return offerRepository.getEmptyOffers();
    }

    @Override
    public Offer getOffer(String id){
        Offer response = null;
        if(offerRepository.existsById(id)){
            Iterable<Offer> offers = offerRepository.getOfferByID(id);
            for(Offer offer : offers){
                response = offer;
            }
            return response;            
        }
        return response;
    }

    @Override
    public void deleteOffer(String id){
        offerRepository.deleteById(id);
    }

    @Override
    public Offer insertOffer(Offer offer){
        return offerRepository.save(offer);
    }

    @Override
    public Offer updateOffer(String id, Offer offer){
        if(offerRepository.existsById(id)){
            return offerRepository.save(offer);
        } else {
            return null;
        }
        
    }
    
}
