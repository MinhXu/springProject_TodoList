package com.example.dao;

import java.util.*;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import model.Job;
import repository.JobRepositoryInterface;

@Configuration
public class jobDao {
	//Hashtable<String, Job> jobs = new Hashtable<String, Job>();
	/*@Autowired
	DataSource dataSource;*/
	@Autowired
	JobRepositoryInterface jobRepository;
	
	public jobDao()
	{
		
	}
	public List<Job> getJob(Integer id)
	{
		return jobRepository.findByjobId(id);
	}

	public List<Job> getAll()
	{
		return (ArrayList<Job>) jobRepository.findAll();
	}
	
	public List<Job> getStatus(String status)
	{
		return (ArrayList<Job>) jobRepository.findByjobStatus(status);
	}
	public void deleteJob(Job job)
	{
		jobRepository.delete(job);
	}
	public void deleteJob(int id)
	{
		jobRepository.deleteByjobId(id);
	}
	public void saveJob(int id, String descript, Date date,String status, String rate)
	{
		System.out.println("1111 ");
		jobRepository.updatejob(id, descript,date,status,rate);
		return ;
	}
	
	public void createJob(String description, Date creationDate, String status, String rate)
	{
		
				jobRepository.createjob(description,creationDate,status,rate);
				return ;
	}
	
//	
//	
//	List<Job> jobs = new ArrayList<Job>();
//	
//	
//	public Job find() {
//		return (new Job(1, "Clean the kitchen", new Date(), 0, 1) );
//	}
//	
//	
//	public List<Job> findAll()
//	{
//		//List<Job> jobs = new ArrayList<Job>();
//		jobs.add(new Job(1, "Clean the kitchen", new Date(), 0, 1));
//		jobs.add(new Job(2, "Do exercise", new Date(), 0, 0));
//		jobs.add(new Job(3, "Go to supermarket", new Date(), 1, 2));
//		jobs.add(new Job(4, "Go out with my friends", new Date(), 0, 1));
//		return jobs;
//	}
////	public jobDao()
////	{
////		jobs.put("1",new Job(1, "Clean the kitchen", new Date(), 0, 1));
////		jobs.put("2",new Job(2, "Do exercise", new Date(), 0, 0));
////		jobs.put("3",new Job(3, "Go to supermarket", new Date(), 0, 2));
////		jobs.put("4",new Job(4, "Go out with my friends", new Date(), 0, 1));
////		
////	}
//	
//	public Job getJob(Number _id)
//	{
//		for (Job job : jobs) {
//			if(job.getJobId() ==_id)
//				return job;
//		}
//		
//		return null;
//	}
//	public List<Job> getAll()
//	{
//		return jobs;
//		
//	}
//	public List<Job> getNotFinishJob()
//	{
//		List<Job> unfinishJobs = new ArrayList<>();
//		for (Job job : jobs) {
//			if(job.getJobStatus()==0)
//				unfinishJobs.add(job);
//		}
//		
//		return unfinishJobs;
//	}

}
