package in.irctc.service;

import java.util.ArrayList;
import java.util.List;

import in.irctc.model.Tourist;

public interface TouristService {
   public Tourist registerTourist(Tourist tourist);
   public ArrayList<Tourist> fetchingTouristbyId();
   public Tourist findById(int id); 
   public Tourist updateTourist(int id,Tourist tourist);
   public Tourist deleteTourist(int id);
}
