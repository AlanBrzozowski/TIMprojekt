package com.timproject.travelapp.dao.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Boolean recommended;
    private Boolean active;
    @Column(name = "visit_id", nullable = false)
    private Long visitId;
    @ManyToOne
    @JoinColumn(name = "visit_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Visit visitByVisitId;

    public Comment(){

    }

    public Comment(String text, Boolean recommended, Boolean active, Long visitId, Visit visitByVisitId){
        this.text = text;
        this.recommended = recommended;
        this.active = active;
        this.visitId = visitId;
        this.visitByVisitId = visitByVisitId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getRecommended() {
        return recommended;
    }

    public void setRecommended(Boolean recommended) {
        this.recommended = recommended;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Visit getVisitByVisitId() {
        return visitByVisitId;
    }

    public void setVisitByVisitId(Visit visitByVisitId) {
        this.visitByVisitId = visitByVisitId;
    }
}
