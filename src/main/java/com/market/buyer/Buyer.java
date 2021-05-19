package com.market.buyer;

import javax.persistence.*;

@Entity
@Table
public class Buyer {
    @Id
    @SequenceGenerator(
            name="buyer_sequence",
            sequenceName="buyer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "buyer_sequence"
    )

    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String address;
    private String pnone;

    public Buyer() {
    }

    public Buyer(Long id, String email, String firstname, String lastname, String address, String pnone) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.pnone = pnone;
    }

    public Buyer(String email, String firstname, String lastname, String address, String pnone) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.pnone = pnone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPnone() {
        return pnone;
    }

    public void setPnone(String pnone) {
        this.pnone = pnone;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", pnone='" + pnone + '\'' +
                '}';
    }
}
