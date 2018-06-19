package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement
@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_SEQ")
	@SequenceGenerator(name= "JOB_SEQ",sequenceName ="job_sequence", allocationSize =1)
	Integer jobId;
	String jobDescription;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date jobCreateDate;
	String jobStatus; // = 0, if not finish. =1 if finish.
	String jobRate;//=0 if low, =1 if normal, =2 if high
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public Date getJobCreateDate() {
		return jobCreateDate;
	}
	public void setJobCreateDate(Date jobCreateDate) {
		this.jobCreateDate = jobCreateDate;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getJobRate() {
		return jobRate;
	}
	public void setJobRate(String jobRate) {
		this.jobRate = jobRate;
	}
	public Job(Integer jobId, String jobDescription, Date jobCreateDate, String jobStatus, String jobRate) {
		super();
		this.jobId = jobId;
		this.jobDescription = jobDescription;
		this.jobCreateDate = jobCreateDate;
		this.jobStatus = jobStatus;
		this.jobRate = jobRate;
	}
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
