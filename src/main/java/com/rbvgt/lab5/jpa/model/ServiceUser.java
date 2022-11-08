package com.rbvgt.lab5.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ServiceUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "nameOfProfile", length = 25)
    private String nameOfProfile;
    @Basic
    @Column(name = "user_card_id")
    private Integer userCardId;
    @ManyToOne
    @JoinColumn(name = "download_id", referencedColumnName = "id")
    private ServiceUser serviceUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getNameOfProfile() {
        return nameOfProfile;
    }

    public void setNameOfProfile(String nameOfProfile) {
        this.nameOfProfile = nameOfProfile;
    }

    public Integer getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(Integer userCardId) {
        this.userCardId = userCardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceUser serviceUser = (ServiceUser) o;
        return Objects.equals(id, serviceUser.id) && Objects.equals(nameOfProfile, serviceUser.nameOfProfile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfProfile);
    }

    public ServiceUser getServiceUser() {
        return serviceUser;
    }

    public void setServiceUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }
}
