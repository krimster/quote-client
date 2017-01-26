package com.erickrim.backend.persistence.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by krime on 1/25/17.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "quote_value")
public class QuoteLine implements Serializable{

    /** The Serial Version UID for Serializable classes */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "value_id", unique = true, nullable = false)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String quote;

    public QuoteLine() {} // jpa

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Value{");
        sb.append("id=").append(id);
        sb.append(", quote='").append(quote).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuoteLine value = (QuoteLine) o;

        return id == value.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
