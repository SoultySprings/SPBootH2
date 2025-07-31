package com.rmndls.SPBootH2.repo;

import com.rmndls.SPBootH2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class studentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(student s){
        String sql="insert into student (rollno, fullname, city) values (?,?,?)";
        int rows = jdbc.update(sql, s.getRollno(), s.getFullname(), s.getCity());
    }

    public List<student> findAll() {
        String sql = "select * from student";

        RowMapper<student> rowMapper = new RowMapper<student>() {
            @Override
            public student mapRow(ResultSet rs, int rowNum) throws SQLException {

                student s = new student();
                s.setRollno(rs.getInt("rollno"));
                s.setFullname(rs.getString("fullname"));
                s.setCity(rs.getString("city"));
                return s;
            }
        };

        return jdbc.query(sql, rowMapper);
    }
}
