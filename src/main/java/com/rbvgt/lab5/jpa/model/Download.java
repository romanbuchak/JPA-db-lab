package com.rbvgt.lab5.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Download {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "price", length = 25)
    private Float price;
    @Basic
    @Column(name = "quantity", length = 30)
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private Download download;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Download download = (Download) o;
        return Objects.equals(id, download.id) && Objects.equals(price, download.price) && Objects.equals(quantity, download.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity);
    }

    public Download getDownload() {
        return download;
    }

    public void setDownload(Download download) {
        this.download = download;
    }
}
