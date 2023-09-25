package model;

import jakarta.persistence.*;
import java.time.*;

//"Viewing" is the junction table for the many-to-many between Visitor and ArtPiece
@Entity(name = "viewings")
public class Viewing {
    @Id
    @JoinColumn(name = "artpiece_id")
    @ManyToOne
    private ArtPiece artPiece;

    @Id
    @JoinColumn(name = "visitor_id")
    @ManyToOne
    private Visitor visitor;

    @Id
    @Column(name = "view_date")
    private LocalDate viewDate;

    @Column(name = "score")
    private int score;

    public Viewing() {
    }

    public Viewing(ArtPiece artPiece, Visitor visitor, LocalDate viewDate) {
        this.artPiece = artPiece;
        this.visitor = visitor;
        this.viewDate = viewDate;
    }

    public LocalDate getViewDate() {
        return viewDate;
    }

    public void setViewDate(LocalDate viewDate) {
        this.viewDate = viewDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArtPiece getArtPiece() {
        return artPiece;
    }

    public void setMuseum(ArtPiece artPiece) {
        this.artPiece = artPiece;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
