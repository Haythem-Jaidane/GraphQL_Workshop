package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Mutation implements GraphQLRootResolver {

    private LogementRepository repoLogement;
    private RendezVousRepository repoRendezVous;

    public Mutation(LogementRepository repoLogement,RendezVousRepository repoRendezVous){
        this.repoLogement = repoLogement;
        this.repoRendezVous = repoRendezVous;
    }

    public RendezVous CreateRendezVous(int id, String date, String heure, int refLog, String num){
        Logement l = repoLogement.getLogementsByReference(refLog);
        RendezVous r = new RendezVous(id,date,heure,l,num);
        repoRendezVous.addRendezVous(r);
        return r;
    }

    public Boolean UpdateRendezVous(int id,String date,String heure,String num){
        Logement l = repoRendezVous.getLogementByRDV(id);
        RendezVous r = new RendezVous(id,date,heure,l,num);
        return repoRendezVous.updateRendezVous(r);
    }

    public Boolean DelateRendezVous(int id){
        return repoRendezVous.deleteRendezVous(id);
    }
}
