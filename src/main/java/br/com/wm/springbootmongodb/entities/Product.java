package br.com.wm.springbootmongodb.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document
public class Product {

    @Id
    private ObjectId _id;
    private String code;
    private String description;
    private LocalDate dtcad;
    private BigDecimal price;

    public Product(){}

    public Product(ObjectId _id, String code, String description, LocalDate dtcad, BigDecimal price) {
        this._id = _id;
        this.code = code;
        this.description = description;
        this.dtcad = dtcad;
        this.price = price;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDtcad() {
        return dtcad;
    }

    public void setDtcad(LocalDate dtcad) {
        this.dtcad = dtcad;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
