package in.irctc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.irctc.model.Tourist;

public interface TouristRepo extends JpaRepository<Tourist, Integer> {

}
