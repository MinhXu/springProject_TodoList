package controller;

import java.lang.reflect.Member;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;
import javax.validation.Valid;

import org.apache.el.parser.JJTELParserState;
import org.assertj.core.internal.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.jobDao;

import form.JobForm;
import model.Job;
///Moi mot project chi co mot file controller
@Controller
@RequestMapping(value="/") //can pai co dong nay

public class todoListController {
	
	@Autowired
	jobDao jDao;
	
	
//	@RequestMapping("/todoList/listView")  //> no se pai di theo duong dan nay\\\
//	public String job(Model model)
//	{
//		Job j= new Job();
//		j.setJobId(1);
//		j.setJobDescription("Clean the kitchen");
//		j.setJobCreateDate(new Date());
//		j.setJobStatus(0);
//		j.setJobRate(1);
//		model.addAttribute("job",j);
//		return "todoList/listView";
//	}
//	@ResponseBody

	
	@RequestMapping(method = RequestMethod.GET)
	public String index()
	{
		return "todoList/listView";
	}
//	@RequestMapping(value ="jobInfo",method = RequestMethod.GET)  //> no se pai di theo duong dan nay\\\
//	public String jobInfo(ModelMap modelMap)
//	{
//		//jobDao jDao = new jobDao();
//		modelMap.put("job", jDao.find());
//		return "todoList/jobInfo";
//	}
	@RequestMapping(value ="todoList/jobList",method = RequestMethod.GET)  //> no se pai di theo duong dan nay\\\
	//@RequestMapping("{/all}")
	public String jobList(ModelMap modelMap)
	{
		//jobDao jDao = new jobDao();
		modelMap.put("jobList", jDao.getAll());
		return "todoList/jobList";
	}
	//@RequestMapping(value ="unfinishjobList",method = RequestMethod.GET)  //> no se pai di theo duong dan nay\\\
	@RequestMapping(value ="todoList/unfinishjobList",method = RequestMethod.GET)
	public String unfinishjobList(ModelMap modelMap)
	{
		modelMap.put("unfinishjobList", jDao.getStatus("unfinished"));
		return "todoList/unfinishjobList";	
	}
	

	
	@RequestMapping(value = "todoList/jobInfo/{id}",method = RequestMethod.GET)
    public String doActions(@PathVariable Integer id,  ModelMap modelMap) {
        // logic to process input data
		System.out.println("aaa "+ jDao.getJob(id).get(0).getJobId());
		modelMap.put("jobForm", jDao.getJob(id).get(0));
		return "todoList/jobInfo";	
		
    }
 @RequestMapping(value="todoList/jobList/{id}",method = RequestMethod.GET)
public String delete(@PathVariable Integer id,  ModelMap modelMap){
	jDao.deleteJob(id);
	modelMap.put("jobList", jDao.getAll());
	return "redirect:/todoList/jobList";
}
	
 @RequestMapping(value = "todoList/jobInfo", method = RequestMethod.POST)
public String saveProduct(@ModelAttribute("jobForm") @Valid JobForm jobForm, BindingResult userloginResult, Model model){
	
	System.out.println("aaabbbbbbbbbbbbbb " + jobForm.getJobRate());
	
	jDao.saveJob(jobForm.getJobId(), jobForm.getJobDescription(), jobForm.getJobCreateDate(), jobForm.getJobStatus(), jobForm.getJobRate());
	//System.out.println("cccc " + j.getJobDescription());
	return "redirect:/todoList/jobList";
   // return "redirect:/todoList/jobInfo/" + j.getJobId();
} 

    @RequestMapping(value = "todoList/newJob", method = RequestMethod.POST)
    public String newProduct(@ModelAttribute("jobForm") @DateTimeFormat(pattern="dd-MMM-yyyy") @Valid JobForm job, BindingResult userloginResult,Model model){
    	System.out.println(job.getJobId()+ " cccc " + job.getJobRate());
    	Date d= job.getJobCreateDate();
        if (job.getJobDescription() != null && d !=null) {
        	jDao.createJob(job.getJobDescription(), d, job.getJobStatus(), job.getJobRate());
            return "redirect:/todoList/jobList";
        }
 
        model.addAttribute("errorMessage", "Please complete all fields");
        return "todoList/newJob";      
    }
    
    @RequestMapping(value ="todoList/newJob", method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
        model.addAttribute("errorMessage", "");
        model.addAttribute("jobForm", new JobForm());
        return "todoList/newJob"; 
    }
    
    
    
    
    
//    //set date format
//    @ModelAttribute("dateFormat")
//    public String dateFormat() {
//        return ja;
//    }


//	@InitBinder
//    private void dateBinder(WebDataBinder binder) {
//        //The date format to parse or output your dates
//    	
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-----yyyy");
//        //Create a new CustomDateEditor
//        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
//        //Register it as custom editor for the Date type
//        binder.registerCustomEditor(Date.class, editor);
//        
//    }

}
