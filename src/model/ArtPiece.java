package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "artpieces")
public class ArtPiece {
    @Id
    @Column(name = "artpiece_id")
    private int artpieceId;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @Column(name = "creationdate")
    private LocalDate creationdate;

    // The bidirectional link back to the parent Building.
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "artPiece")
    private Set<Viewing> viewings;

    public ArtPiece() {
    }

    public ArtPiece(int artpieceId, String title, Building building) {
        this.artpieceId = artpieceId;
        this.title = title;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Art Piece " + title + " (ID " + artpieceId + ")";
    }

    public int getArtpieceId() {
        return artpieceId;
    }

    public void setArtpieceId(int artpieceId) {
        this.artpieceId = artpieceId;
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<Viewing> getViewings() {
        return viewings;
    }

    public void setViewings(Set<Viewing> viewings) {
        this.viewings = viewings;
    }
}
