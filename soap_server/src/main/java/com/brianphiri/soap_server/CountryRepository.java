package com.brianphiri.soap_server;

import localhost._8080.webservice.Country;
import localhost._8080.webservice.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData(){
        Country kenya = new Country();
        kenya.setName("Kenya");
        kenya.setCapital("Nairobi");
        kenya.setCurrency(Currency.KES);
        kenya.setPopulation(46704314);

        countries.put(kenya.getName(), kenya);

        Country zambia = new Country();
        zambia.setName("Zambia");
        zambia.setCapital("Lusaka");
        zambia.setCurrency(Currency.ZMW);
        zambia.setPopulation(2000010);

        countries.put(zambia.getName(), zambia);

        Country def = new Country();
        def.setName("Empty");
        def.setCapital("Blank");
        def.setCurrency(Currency.BZD);
        def.setPopulation(0);

        countries.put(def.getName(), def);
    }

    public Country findCountry(String name){
        Assert.notEmpty(new String[]{name},"This country must not be null");
        return countries.get(name);
    }
}
