package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {

    public RendezVousRepository  rendezVousRepository;
    public LogementRepository logementRepository;
    public Mutation() {

    }

    public Mutation(RendezVousRepository rendezVousRepository,LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;
    } // pour faire les option de ajout et de modification et suppression et querrie pour le get

    public boolean CreateRendezVous(int id , String date , String heure , int referenceLogement,String numTel){
        Logement logement = logementRepository.getLogementsByReference(referenceLogement);
        RendezVous rendezVous = new RendezVous(id , date, heure,logement,numTel);
       return rendezVousRepository.addRendezVous(rendezVous);

    }
    public boolean updateRendezVous(int id,String date, String heure , String numTel){
           Logement logement = rendezVousRepository.getLogementByRDV(id);
           RendezVous rendezVous = new RendezVous(id,date,heure, logement , numTel);

        return rendezVousRepository.updateRendezVous(rendezVous);

    }
}
