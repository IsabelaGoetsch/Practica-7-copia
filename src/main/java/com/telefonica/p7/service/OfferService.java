package com.telefonica.p7.service;

import com.telefonica.p7.model.Offer;

public interface OfferService {
    Iterable<Offer> getOffers(String offerAvailable);
    Iterable<Offer> getOffersWithApplication();
    Iterable<Offer> getAllOffers();
    Iterable<Offer> getEmptyOffers();
    Offer getOffer(String id);
    void deleteOffer(String id); 
    Offer insertOffer(Offer offer);
    Offer updateOffer(String id, Offer offer);   
}
