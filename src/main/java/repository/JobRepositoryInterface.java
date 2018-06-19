package repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Job;

@Repository
public interface JobRepositoryInterface extends  CrudRepository<Job, Integer>{
	
	List<Job> findByjobId (int id);
	
	List<Job> findByjobCreateDate(Date date);
	
	Iterable<Job> findByjobStatus(String status);
	
	void deleteByjobId(int id);
	
	public void updatejob(int id, String description, Date creationDate, String status, String rate);
	
	public void createjob(String description, Date creationDate, String status, String rate);
	
	//Job updatejobStatus (Long id);

}
