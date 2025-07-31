package com.rmndls.SPBootH2.repo;

import com.rmndls.SPBootH2.model.chemistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class chemistryRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(chemistry c){
        String sql="insert into chemistry (cno, marks) values (?,?)";
        int rows = jdbc.update(sql, c.getCno(), c.getMarks());
    }

    public List<chemistry> findAll() {
        String sql = "select * from chemistry";

        RowMapper<chemistry> rowMapper = new RowMapper<chemistry>() {
            @Override
            public chemistry mapRow(ResultSet rs, int rowNum) throws SQLException {

                chemistry c = new chemistry();
                c.setCno(rs.getInt("cno"));
                c.setMarks(rs.getInt("marks"));
                return c;
            }
        };

        return jdbc.query(sql, rowMapper);
    }
}
