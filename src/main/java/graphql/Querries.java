package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Querries implements GraphQLRootResolver {

    public LogementRepository repoLogement ;
    public RendezVousRepository rendezVousRepo;
    public Querries(LogementRepository repoLogement, RendezVousRepository rendezVousrepo) {
        this.repoLogement = repoLogement;
        this.rendezVousRepo = rendezVousrepo;
    }

    public List<Logement> allLogements() {
        return repoLogement.getAllLogements();
    }
    public List<RendezVous> allRendezVous() {
        return rendezVousRepo.getListeRendezVous();
    }
}
