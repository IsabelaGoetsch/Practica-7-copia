package com.telefonica.p7.repository;

import com.telefonica.p7.model.Offer;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer,String> {
    @Query("SELECT * FROM OFFER WHERE OFFER_AVAILABLE= :offerAvailable")
    public Iterable<Offer> getOffersAvailable(String offerAvailable);

    @Query("SELECT * FROM OFFER WHERE OFFER.ID= :id")
    public Iterable<Offer> getOfferByID(String id);

    @Query("SELECT DISTINCT OFFER.ID, OFFER_NAME, DATE_BEGINING, DATE_END, OFFER_DESCRIPTION, OFFER_AVAILABLE FROM OFFER INNER JOIN APPLICATIONS ON OFFER.ID=APPLICATIONS.OFFER_ID")
    public Iterable<Offer> getOffersWithApplication();

    @Query("SELECT * FROM OFFER LEFT OUTER JOIN APPLICATIONS ON OFFER.ID=APPLICATIONS.OFFER_ID")
    public Iterable<Offer> getAllOffers();

    @Query("SELECT * FROM OFFER LEFT OUTER JOIN APPLICATIONS ON OFFER.ID=APPLICATIONS.OFFER_ID WHERE APPLICATIONS.OFFER_ID IS NULL")
    public Iterable<Offer> getEmptyOffers();
}

