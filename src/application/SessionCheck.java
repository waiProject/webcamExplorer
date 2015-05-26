package application;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SessionCheck implements Job{

	private static Logger jlog = Logger.getLogger(SessionCheck.class);
	
	public SessionCheck(){
		
	}
	
	public void test() throws Exception{
		jlog.info("SESSION LOG TEST QQUARTZ");
	}

	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		try {
//			SessionCheck core = new SessionCheck();
//			core.test();
			this.test();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
