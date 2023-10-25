package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private RendezVousRepository repoRendezVous ;
    private LogementRepository repoLogement ;

    public Query(RendezVousRepository repoRendezVous,LogementRepository repoLogement){
        this.repoRendezVous = repoRendezVous;
        this.repoLogement = repoLogement;
    }
    public List<RendezVous> getALLrdv(){
        return repoRendezVous.getListeRendezVous();
    }

    public List<RendezVous> getRenderVousByLog(int refLog){
        return repoRendezVous.getListeRendezVousByLogementRef(refLog);
    }

    public RendezVous getRenderVousById(int id){
        return repoRendezVous.getRenderVousById(id);
    }

    public List<Logement> getALLlogement(){
        return repoLogement.getAllLogements();
    }

    public Logement getLogementByRef(int refLog){
        return repoLogement.getLogementsByReference(refLog);
    }

    public List<Logement> getLogementByType(String type){
        return repoLogement.getLogementsByType(type);
    }
}
