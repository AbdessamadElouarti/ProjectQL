package ma.ensa.ql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class JobListenerImpl implements JobExecutionListener 
{
	//SimpleJobOperator jobExp;
	
	/*@Autowired
	public void setJobExp(SimpleJobOperator jobExp) {
		this.jobExp = jobExp;
	}
*/
	@Override
	public void afterJob(JobExecution jobExecution) 
	{
		if(jobExecution.getStatus()==BatchStatus.COMPLETED)
		{
					PrintWriter pw=null;
					try {
						pw = new PrintWriter("src/main/java/transaction.csv");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pw.print("");
					pw.close();
		}
	}

	@Override
	public void beforeJob(JobExecution jobExecution)
	{
			
			File file=new File("src/main/java/transaction.csv");
			if(file.length()==0)
			{
					System.exit(-1);
			}
	}

}
