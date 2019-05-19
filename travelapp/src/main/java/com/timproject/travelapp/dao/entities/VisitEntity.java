package com.timproject.travelapp.dao.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp date;
    private Boolean visited;
    private Boolean visible;
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Column(name = "place_id", nullable = false)
    private long placeId;
    @OneToMany(mappedBy = "visitByVisitEntityId")
    private Collection<CommentEntity> commentsById;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private UserEntity userByUserEntityId;
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private PlaceEntity placeByPlaceEntityId;

    public VisitEntity(){

    }

    public VisitEntity(Timestamp date, Boolean visited, Boolean visible, long userId, long placeId, Collection<CommentEntity> commentsById, UserEntity userByUserEntityId, PlaceEntity placeByPlaceEntityId){
        this.date = date;
        this.visited = visited;
        this.visible = visible;
        this.userId = userId;
        this.placeId = placeId;
        this.commentsById = commentsById;
        this.userByUserEntityId = userByUserEntityId;
        this.placeByPlaceEntityId = placeByPlaceEntityId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public Collection<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }


    public UserEntity getUserByUserEntityId() {
        return userByUserEntityId;
    }

    public void setUserByUserEntityId(UserEntity userByUserEntityId) {
        this.userByUserEntityId = userByUserEntityId;
    }


    public PlaceEntity getPlaceByPlaceEntityId() {
        return placeByPlaceEntityId;
    }

    public void setPlaceByPlaceEntityId(PlaceEntity placeByPlaceEntityId) {
        this.placeByPlaceEntityId = placeByPlaceEntityId;
    }
}
