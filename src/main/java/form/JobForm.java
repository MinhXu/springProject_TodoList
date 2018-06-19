package form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class JobForm {
	int jobId;
	String jobDescription;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date jobCreateDate;
	String jobStatus; // = 0, if not finish. =1 if finish.
	String jobRate;//=0 if low, =1 if normal, =2 if high
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
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
	public JobForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
