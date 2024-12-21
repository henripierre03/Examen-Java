package gestion_commercial.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_cmde")
    private Date dateCmde;

    private double total;

    @Column(length = 50, nullable = false)
    private String statut;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Detail> details;

    public Commande() {
        // Constructeur par défaut
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCmde() {
        return dateCmde;
    }

    public void setDateCmde(Date dateCmde) {
        this.dateCmde = dateCmde;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String g
