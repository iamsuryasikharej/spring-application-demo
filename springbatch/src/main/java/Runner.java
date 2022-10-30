import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("./applicationContext.xml");
		JobLauncher jobLauncher=(JobLauncher)applicationContext.getBean("jobLauncher");
		Job job=(Job)applicationContext.getBean("helloWorldJob");
		JobExecution jobExecution=jobLauncher.run(job, new JobParameters());
		System.out.println(jobExecution.getStatus());
	}
}
