package com.rickdane.springmodularizedproject.module.consumabledata.domain.constraint;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;

/**
 * @author Rick Dane
 */
public class MultiEntryDatarecordValidator {

      public void initialize(Datarecord constraintAnnotation) {
    // initialize the zipcode/city/country correlation service
    }

    /**
     * Validate zipcode and city depending on the country
     */
//    public boolean isValid(Object object) {
//        if (!(object instanceof Datarecord)) {
//            throw new IllegalArgumentException("@Datarecord only applies to Datarecord");
//        }
//        Datarecord datarecord = (Datarecord) object;
//        Country country = address.getCountry();
//        if (country.getISO2() == "FR") {
//            // check address.getZipCode() structure for France (5 numbers)
//            // check zipcode and city correlation (calling an external service?)
//            return isValid;
//        } else if (country.getISO2() == "GR") {
//            // check address.getZipCode() structure for Greece
//            // no zipcode / city correlation available at the moment
//            return isValid;
//        }
//    }
}
