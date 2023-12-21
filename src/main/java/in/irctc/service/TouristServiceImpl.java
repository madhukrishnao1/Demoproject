package in.irctc.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.irctc.dao.TouristRepo;
import in.irctc.exception.TouristNotFoundException;
import in.irctc.model.Tourist;

@Service
public class TouristServiceImpl implements TouristService {

	@Autowired
	TouristRepo repo;

	public TouristServiceImpl(TouristRepo repo) {
		this.repo=repo;
	}

	@Override
	public Tourist registerTourist(Tourist tourist) {

		return repo.save(tourist);
	}

	@Override
	public ArrayList<Tourist> fetchingTouristbyId() {

		List<Tourist> list = repo.findAll();

	

		return (ArrayList<Tourist>) list;

	}

	@Override
	public Tourist findById(int id) {
		Tourist tourist= repo.findById(id).orElseThrow(()->new TouristNotFoundException(id+"record not found") );
		return tourist;
		
	}

	@Override
	public Tourist updateTourist(int id,Tourist tourist) {
		
		Tourist t= repo.findById(id).orElseThrow(()->new TouristNotFoundException(id +" " +"record not found") );
		System.out.println("update method");
		t.setName(tourist.getName());
		t.setDroping(tourist.getDroping());
		t.setDurationTime(tourist.getDurationTime());
		t.setCost(tourist.getCost());
		t.setPickingup(tourist.getPickingup());
		repo.save(t);
		return t;
	}

	@Override
	public Tourist deleteTourist(int id) {
		Tourist t= repo.findById(id).orElseThrow(()->new TouristNotFoundException(id+ "record not found") );
		repo.deleteById(t.getId());
		
		return t;
	}

}
