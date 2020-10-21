package com.example.lms.model;

import javax.persistence.*;

@Table
@Entity
public class IssuedBook {

   @Id
   @Column
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
   private  int id;

    @Column
    private String ibname;
    private String ibauthor;

    public String getIbauthor() {
        return ibauthor;
    }

    public void setIbauthor(String ibauthor) {
        this.ibauthor = ibauthor;
    }

    public String getIbname() {
        return ibname;
    }

    public IssuedBook(int id, String ibname, String ibauthor) {
        this.id = id;
        this.ibname = ibname;
        this.ibauthor = ibauthor;
    }

    public void setIbname(String ibname) {
        this.ibname = ibname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IssuedBook(String ibname) {

        this.ibname = ibname;
    }

    public IssuedBook() {
    }
}
