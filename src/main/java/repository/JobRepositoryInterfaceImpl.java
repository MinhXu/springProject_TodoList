package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import model.Job;
@Repository
public class JobRepositoryInterfaceImpl implements JobRepositoryInterface {

	
	@Autowired
	private JdbcOperations jdbc;
	
	private static final String SQL_INSERT = "insert into job (job_Description, job_Create_Date, job_Status, job_Rate) values (?,?,?,?)";
	private static final String SQL_UPDATE = "update job set job_Description =?, job_Create_Date =?,job_Status =?,job_Rate =? where job_Id =?";
	private static final String SQL_FIND_ONE ="select DISTINCT * from job where job_Id =?"; 
	private static final String SQL_FIND_ALL ="select * from job order by job_Status";
	//private static final String SQL_FIND_ALL ="SELECT * FROM JOB";
	private static final String SQL_DELETE_ONE = "delete from job where job_Id=?";
	private static final String SQL_FIND_STATUS = "select * from job where job_Status =?";  
	private static final String SQL_FIND_DATE = "select * from job where job_Create_Date =?"; 
	private static final String SQL_UPDATE_STATUS = "update job set job_Status =? where job_Id=?";
	
	@Override
	public <S extends Job> S save(S entity) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public <S extends Job> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Job> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Job> findAll() {
		return jdbc.query(SQL_FIND_ALL, new JobRowMapper());
	}

	@Override
	public Iterable<Job> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		jdbc.update(SQL_DELETE_ONE, id);
		return;
	}

	@Override
	public void delete(Job entity) {
		// TODO Auto-generated method stub
		
		jdbc.update(SQL_DELETE_ONE, entity.getJobId());
		return;

	}
	@Override
	public void deleteByjobId(int id) {
		// TODO Auto-generated method stub
		
		jdbc.update(SQL_DELETE_ONE, id);
		return;

	}

	@Override
	public void deleteAll(Iterable<? extends Job> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Job> findByjobId(int id) {
		return jdbc.query(SQL_FIND_ONE, new JobRowMapper() ,id);
	}

	@Override
	public List<Job> findByjobCreateDate(Date date) {
		return jdbc.query(SQL_FIND_DATE, new JobRowMapper() ,date);
	}

	@Override
	public Iterable<Job> findByjobStatus(String status) {
		
		return jdbc.query(SQL_FIND_STATUS, new JobRowMapper() ,status);
	}


	@Override
	public void updatejob(int id, String description, Date creationDate, String status, String rate) {
		System.out.println("2222 ");
		jdbc.update(SQL_UPDATE, description,creationDate,status,rate,id);
		return;
	}
	
	@Override
	public void createjob(String description, Date creationDate, String status, String rate)
	{
		//return jdbc.query(SQL_INSERT, new JobRowMapper(), description,creationDate,status,rate); 

		jdbc.update(SQL_INSERT, description,creationDate,status,rate);
		return;
		
		
	}
	
	private static final class JobRowMapper implements RowMapper<Job>
	{
		//@Override
		public Job mapRow(ResultSet rs, int row) throws SQLException
		{
			
			return new Job(rs.getInt("job_Id"),rs.getString("job_Description"),rs.getDate("job_Create_Date"),rs.getString("job_Status"),rs.getString("job_Rate"));
		}
	}



}
