package com.timproject.travelapp.dao.entities;

import javax.persistence.*;

@Entity
public class CommentEntity {

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
    private VisitEntity visitByVisitEntityId;

    public CommentEntity(){

    }

    public CommentEntity(String text, Boolean recommended, Boolean active, Long visitId, VisitEntity visitByVisitEntityId){
        this.text = text;
        this.recommended = recommended;
        this.active = active;
        this.visitId = visitId;
        this.visitByVisitEntityId = visitByVisitEntityId;
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

    public VisitEntity getVisitByVisitEntityId() {
        return visitByVisitEntityId;
    }

    public void setVisitByVisitEntityId(VisitEntity visitByVisitEntityId) {
        this.visitByVisitEntityId = visitByVisitEntityId;
    }
}
