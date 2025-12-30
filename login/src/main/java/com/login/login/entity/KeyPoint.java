package com.login.login.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "keypoints")
public class KeyPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kp_id")
    private Integer id;

    // FOREIGN KEY → users.id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Column(name = "points", nullable = false, length = 100)
    private String points;

    public KeyPoint() {}

    public KeyPoint(User user, String points) {
        this.user = user;
        this.points = points;
    }

    // ===== GETTERS =====

    public Integer getId() {
        return id;
    }

    public String getPoints() {
        return points;
    }

    public User getUser() {
        return user;
    }

    // ===== SETTERS =====

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
