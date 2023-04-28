package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository {

    @Autowired
    private DataSource dataSource;
    private List<Dog> dogs = new ArrayList<>();

    public DogRepository () {

    }

    public Dog getDog(int id) {
        Dog dog = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM dog WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                dog = rsDog(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dog;
    }

    private Dog rsDog(ResultSet rs) throws SQLException {
        return new Dog (rs.getString("name"),
                rs.getString("age"),
                rs.getString("color"),
                AdoptionStatus.valueOf(rs.getString("adoption_status").toUpperCase()),
                AgeCategory.valueOf(rs.getString("age_category").toUpperCase()),
                rs.getInt("id"),
                Breed.valueOf(rs.getString("breed").toUpperCase()),
                rs.getString("image_url"),
                rs.getString("description"));
    }

    public List<Dog> getAllDogs() {
        List<Dog> dogs = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM dog");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                dogs.add(rsDog(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dogs;
    }

    public List<Dog> getPage(int page, int pageSize) {
        dogs = getAllDogs();
        int from = Math.max(0, page * pageSize);
        int to = Math.min(dogs.size(), (page + 1) * pageSize);

        return dogs.subList(from, to);
    }

    public int numberOfPages(int pageSize) {
        return (int) Math.ceil((double) dogs.size() / pageSize);
    }
}
