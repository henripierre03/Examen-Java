import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DetailService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public DetailService() {
        emf = Persistence.createEntityManagerFactory("gestion_commercial");
        em = emf.createEntityManager();
    }

    public void addDetail(int produitId, int commandeId, double qteCom) {
        Detail detail = new Detail();
        detail.setProduitId(produitId);
        detail.setCommandeId(commandeId);
        detail.setQteCom(qteCom);

        // Début de la transaction
        em.getTransaction().begin();
        em.persist(detail);
        em.getTr
