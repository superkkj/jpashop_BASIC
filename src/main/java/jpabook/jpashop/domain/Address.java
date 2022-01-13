package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    @Column(length = 10)
    private String city;

    @Column(length = 20)
    private String street;

    @Column(length = 5)
    private String zipcods;


    public String fullAddress(){
        return getCity() + " " + getStreet() + " " + getZipcods();
    }


    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcods() {
        return zipcods;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setZipcods(String zipcods) {
        this.zipcods = zipcods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getZipcods(), address.getZipcods());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcods());
    }
}
