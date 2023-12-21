package in.irctc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/*import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;*/
import jakarta.persistence.Id;

@Entity(name="Tourist")
public class Tourist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String pickingup;
	String droping;
	String durationTime;
	int cost;
	public Tourist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tourist(String name, String pickup, String drop, String duration, int cost) {
		super();
		this.name = name;
		this.pickingup = pickup;
		this.droping = drop;
		this.durationTime = duration;
		this.cost = cost;
	}
	public Tourist(int id, String name, String pickingup, String droping, String durationTime, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.pickingup = pickingup;
		this.droping = droping;
		this.durationTime = durationTime;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPickingup() {
		return pickingup;
	}
	public void setPickingup(String pickingup) {
		this.pickingup = pickingup;
	}
	public String getDroping() {
		return droping;
	}
	public void setDroping(String droping) {
		this.droping = droping;
	}
	public String getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Tourist [id=" + id + ", name=" + name + ", pickup=" + pickingup + ", drop=" + droping + ", duration="
				+ durationTime + ", cost=" + cost + "]";
	}
	

}
