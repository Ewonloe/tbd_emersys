package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class GooseRepositoryImp implements GooseRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countGoose() {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM goose";
        try(Connection conn = sql2o.open()){
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }

        return total;
    }

}
