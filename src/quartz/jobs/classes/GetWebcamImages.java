package quartz.jobs.classes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import model.Cam;
import model.Image;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.CamDao;
import dao.DaoFactory;
import utils.JNDIFactory;

public class GetWebcamImages implements Job {

	private static Logger jlog = Logger.getLogger(GetWebcamImages.class);
	final CamDao camDao = DaoFactory.getInstance().getCamDao();

	JNDIFactory jndiFactory = JNDIFactory.getInstance();

	public GetWebcamImages() {
	}

	private void process() throws IOException {
    	List<Cam> camliste = camDao.camList();
    	
    	for(Cam cam : camliste)
    	{
    		try
    		{
				String urlString = cam.getUrl();
				
    			BufferedImage image = ImageIO.read(new URL(urlString));
    			
    			Date now = new Date();
    			SimpleDateFormat date = new SimpleDateFormat("dd_MM_yyyy");
    			String dateString = date.format(now);
    			SimpleDateFormat time = new SimpleDateFormat("HH_mm_ss");
    			String timeString = time.format(now);
    			
    			String camName = cam.getName();
    			
    			String sep = File.separator;
    			//For DB user Windows Path
    			String folderPath = "C:"+ sep +"Java" + sep + camName + sep + dateString;
    			String filePath = folderPath + sep + timeString + ".jpg";
    			String thumbFilePath = folderPath + sep + timeString + "_thumb.jpg";
    			    			
    			(new File(folderPath)).mkdirs(); //Ordner anlegen falls nicht vorhanden		    	        			
    			File outputfile = new File(filePath);
    		    ImageIO.write(image, "jpg", outputfile);
    		    jlog.info("New picture saved");
    		    
    		    int thumbWidth = 100;
                int thumbHeight = 75;
                java.awt.Image imageThumb = image.getScaledInstance(thumbWidth, thumbHeight,java.awt.Image.SCALE_AREA_AVERAGING);                        
                File thumbOutputfile = new File(thumbFilePath);                     
                BufferedImage bufferedThumb = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
                bufferedThumb.getGraphics().drawImage(imageThumb, 0, 0 , null);
                ImageIO.write(bufferedThumb, "jpg", thumbOutputfile);
                jlog.info("New small picture saved");    		    
    		    
    		    Image imagePBO = new Image();
    		    imagePBO.setCamId(cam.getId());
    		    imagePBO.setlocalPath(filePath);
    		    imagePBO.setlocalPathThumb(thumbFilePath);    		    

    		    camDao.saveImage(imagePBO);

    		    jlog.info("Local path saved in database "+thumbFilePath);
    		}catch(IOException e){
    			jlog.error(e.getMessage());
    			e.printStackTrace();
    		}    		
		}   
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		try {
			GetWebcamImages core = new GetWebcamImages();
			core.process();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
