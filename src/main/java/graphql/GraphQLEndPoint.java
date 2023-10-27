package graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import entity.RendezVous;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;

@WebServlet("/graphql")
public class GraphQLEndPoint extends SimpleGraphQLServlet {

    public GraphQLEndPoint(){
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() {
        LogementRepository repoLog = new LogementRepository();
        RendezVousRepository rendezVousrepo = new RendezVousRepository();
        return SchemaParser.newParser()
                .file("schema.graphql")
                .resolvers(new Querries(repoLog , rendezVousrepo),new  Mutation(rendezVousrepo,repoLog))
                .build()
                .makeExecutableSchema();
    }
}
