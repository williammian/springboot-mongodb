package br.com.wm.springbootmongodb.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(_id, person._id) &&
                Objects.equals(firstname, person.firstname) &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, firstname, lastname, email);
    }
}
