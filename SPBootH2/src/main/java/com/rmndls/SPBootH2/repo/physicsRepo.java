package com.rmndls.SPBootH2.repo;

import com.rmndls.SPBootH2.model.physics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class physicsRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(physics p){
        String sql="insert into physics (pno, marks) values (?,?)";
        int rows = jdbc.update(sql, p.getPno(), p.getMarks());
        System.out.println(rows + " affected. Physics marks added for each.");
    }

    public List<physics> findAll() {
        String sql = "select * from physics";

        RowMapper<physics> rowMapper = new RowMapper<physics>() {
            @Override
            public physics mapRow(ResultSet rs, int rowNum) throws SQLException {

                physics p = new physics();
                p.setPno(rs.getInt("pno"));
                p.setMarks(rs.getInt("marks"));
                return p;
            }
        };

        return jdbc.query(sql, rowMapper);
    }
}
