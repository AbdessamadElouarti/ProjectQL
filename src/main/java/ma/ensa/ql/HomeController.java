package ma.ensa.ql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import ma.ensa.dao.*;
import ma.ensa.model.*;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
 {
	Idao dao;
	 private @Autowired ServletContext servletContext;
	@Autowired
	public void setDao(Idao dao) 
	{
		this.dao = dao;
	}
	
	@RequestMapping(value ={"/","/home"})
	public ModelAndView home() 
	{
		ModelAndView modelview=new ModelAndView();
		modelview.setViewName("home");
		return modelview;
	}  
	@RequestMapping("/listUsers")
	public ModelAndView lisUsers()
	{
		ModelAndView modelview=new ModelAndView();
		modelview.addObject("list",dao.findAll());
		modelview.setViewName("listUsers");
		return modelview;
	}
	@RequestMapping("/admin")
	public ModelAndView admin() 
	{
		ModelAndView modelview=new ModelAndView();
		User userDetails = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ma.ensa.model.User user=dao.getUserByLogin(userDetails.getUsername());
		String nom_prenom=user.getNom()+"  "+user.getPrenom();
		modelview.addObject("nom_prenom", nom_prenom);
		modelview.setViewName("admin");
		return modelview;
	}  
	@RequestMapping("/executeBatch")
	public void executeBatch() throws Exception
	{
		//ModelAndView modelview=new ModelAndView();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ma/ensa/ql/spring-batch.xml");
		//JobLauncher jobLauncher=(JobLauncher)context.getBean("jobLauncher");
		//Job job=(Job)context.getBean("importTransaction");
		//jobLauncher.run(job, new JobParameters());
	}
	@RequestMapping("/client")
	public ModelAndView client()
	{	
		ModelAndView modelview=new ModelAndView();
		User userDetails = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ma.ensa.model.User user=dao.getUserByLogin(userDetails.getUsername());
		float montantT =user.getMontantTotale();
		String nom_prenom=user.getNom()+"  "+user.getPrenom();
		modelview.addObject("nom_prenom", nom_prenom);
		modelview.addObject("montant", montantT);
		modelview.setViewName("client");
		return modelview;
	}
	@RequestMapping("/Alltransaction")
	public ModelAndView getTransactions() throws IOException
	{
		ModelAndView modelview=new ModelAndView();		
	//	File file=new File("transaction.csv");
		final DefaultResourceLoader loader = new DefaultResourceLoader();
	    Resource resource = loader.getResource("classpath:transaction.csv");
	    File myFile = resource.getFile();
		//InputStream in=servletContext.getResourceAsStream("classpath://transaction.csv");
		FileInputStream in=new FileInputStream(myFile);
	    Scanner sc=new Scanner(in);	
		List<Transaction> list=new ArrayList<Transaction>();
		//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			//(line=bufferedReader.readLine())!= null
			while(sc.hasNext())
			{
				String tab[];
				//tab=line.split(";");
				tab=sc.nextLine().split(";");
				Transaction transaction=new Transaction();
				transaction.setId(Integer.parseInt(tab[0]));
				transaction.setUserLogin(tab[1]);
				transaction.setMontant(Integer.parseInt(tab[2]));
				list.add(transaction);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelview.addObject("transactions",list);
		modelview.addObject("size",list.size());
		modelview.setViewName("Alltransaction");
			return modelview;
	}
	@RequestMapping("/reglerCA")
	public ModelAndView reglerCA() throws IOException
	{
			ModelAndView modelview=new ModelAndView();
			final DefaultResourceLoader loader = new DefaultResourceLoader();
		    Resource resource = loader.getResource("classpath:transaction.csv");
		    File myFile = resource.getFile();
			FileInputStream in=new FileInputStream(myFile);
		    Scanner sc=new Scanner(in);	
			List<Transaction> list=new ArrayList<Transaction>();
			String line;
			try {
				while(sc.hasNext())
				{
					String tab[];
					tab=sc.nextLine().split(";");
					Transaction transaction=new Transaction();
					transaction.setId(Integer.parseInt(tab[0]));
					transaction.setUserLogin(tab[1]);
					transaction.setMontant(Integer.parseInt(tab[2]));
					dao.persist(transaction);
					ma.ensa.model.User user=dao.getUserByLogin(transaction.getUserLogin());
					int rest=user.getMontantTotale()-transaction.getMontant();
					user.setMontantTotale(rest);	
					dao.updateRecord(user);
				}
				final DefaultResourceLoader load = new DefaultResourceLoader();
			    Resource res = load.getResource("classpath:transaction.csv");
			    File file = res.getFile();
				FileOutputStream out=new FileOutputStream(file);
				
			    PrintWriter pw=null;
				pw = new PrintWriter(out);
				pw.print("");
				pw.close();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			modelview.addObject("done","les transactions sont bien reglés");
			modelview.setViewName("reglerCA");
			return modelview;
	}
	@RequestMapping("/login")
	public ModelAndView login()
	{
		ModelAndView modelview=new ModelAndView();
		modelview.setViewName("login");
		return modelview;
	}
}
