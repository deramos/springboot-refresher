package io.kairos.application.repository;


import io.kairos.application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OldStudentRepository {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student) {
        String sql = "insert into student (rollno, name, marks) values(?, ?, ?)";
        int rows = jdbc.update(sql, student.getRollNo(), student.getName(), student.getMarks());
        System.out.println(rows + " affected");

    }

    public List<Student> findAll() {
        String sql = "select * from student";

        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student student = new Student();
            student.setRollNo(rs.getInt("rollno"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        };

        return jdbc.query(sql, mapper);
    }
}
