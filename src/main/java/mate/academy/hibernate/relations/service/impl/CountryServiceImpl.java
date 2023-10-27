package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.exceptions.DataProcessingException;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.service.CountryService;

public class CountryServiceImpl implements CountryService {
    private final CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public Country add(Country country) {
        try {
            return countryDao.add(country);
        } catch (DataProcessingException e) {
            throw new DataProcessingException("Error while adding a country" + country, e);
        }
    }

    @Override
    public Country get(Long id) {
        try {
            return countryDao.get(id)
                    .orElseThrow(() -> new DataProcessingException("Country with ID: " + id
                            + " not found"));
        } catch (DataProcessingException e) {
            throw new DataProcessingException("Error while getting country", e);
        }
    }
}
