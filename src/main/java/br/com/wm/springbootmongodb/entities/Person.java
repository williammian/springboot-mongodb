package br.com.wm.springbootmongodb.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {

    @Id
    private ObjectId _id;
    private String firstname;
    private String lastname;
    private String email;

    public Person() {}

    public Person(ObjectId _id, String firstname, String lastname, String email) {
        this._id = _id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
