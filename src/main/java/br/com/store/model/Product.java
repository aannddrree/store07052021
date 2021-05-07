package br.com.store.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document
public class Product implements Serializable {

    @Id
    private int _id;
    private String name;

    public Product(){}

    public Product(int id, String name){
        this.name = name; this._id = id;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
