package com.rmndls.SPBootH2.repo;

import com.rmndls.SPBootH2.model.mathematics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class mathematicsRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(mathematics m){
        String sql="insert into mathematics (mno, marks) values (?,?)";
        int rows = jdbc.update(sql, m.getMno(), m.getMarks());
        System.out.println(rows + " affected. Mathematics marks added for each.");
    }

    public List<mathematics> findAll() {
        String sql = "select * from mathematics";

        RowMapper<mathematics> rowMapper = new RowMapper<mathematics>() {
            @Override
            public mathematics mapRow(ResultSet rs, int rowNum) throws SQLException {

                mathematics m = new mathematics();
                m.setMno(rs.getInt("mno"));
                m.setMarks(rs.getInt("marks"));
                return m;
            }
        };

        return jdbc.query(sql, rowMapper);
    }
}
