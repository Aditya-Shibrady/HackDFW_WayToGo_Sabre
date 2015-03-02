package com.waytogo.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/dest", method = RequestMethod.GET)
	public String dest(Locale locale, Model model) {
		
		// TODO Auto-generated method stub
				//
				//Request authentication
				//
				final String clientId = "V1:xmf6pn67fr1i87f8:DEVCENTER:EXT";//Put Your Client Id Here
				final String clientSecret= "i6eRL0Hm";//Put Your Secret Id Here
				
				//base64 encode clientId and clientSecret
		        String encodedClientId = "VjE6eG1mNnBuNjdmcjFpODdmODpERVZDRU5URVI6RVhU";
		        String encodedClientSecret = "aTZlUkwwSG0=";

		        //Concatenate encoded client and secret strings, separated with colon
		        String encodedClientIdSecret = encodedClientId+":"+encodedClientSecret;

		        //Convert the encoded concatenated string to a single base64 encoded string.
		        encodedClientIdSecret ="VmpFNmVHMW1ObkJ1TmpkbWNqRnBPRGRtT0RwRVJWWkRSVTVVUlZJNlJWaFU6YVRabFVrd3dTRzA9";
				
				DSCommHandler dsC = new DSCommHandler();
				String token = dsC.getAuthToken("https://api.test.sabre.com",encodedClientIdSecret);
				
				
				String urldest = DSApiCalls.getDest();
				// for dest
				String response = dsC.sendRequest(urldest, token);
						
				//Display the response String
				//System.out.println(response);
				model.addAttribute("da", response );
			
		return "destj";
	}
	
	
	
	@RequestMapping(value = "/settheme", method = RequestMethod.GET)
	public @ResponseBody void practice4(@RequestParam("id1") String id1, @RequestParam("id2") String id2) {
		
		System.out.println(id1 + id2);
		DSApiCalls.setTheme(id1,id2);
		
	
	}
	
	
	@RequestMapping(value = "/theme", method = RequestMethod.GET)
	public ModelAndView theme() {
		
		// TODO Auto-generated method stub
				//
				//Request authentication
				//
				final String clientId = "V1:xmf6pn67fr1i87f8:DEVCENTER:EXT";//Put Your Client Id Here
				final String clientSecret= "i6eRL0Hm";//Put Your Secret Id Here
				
				//base64 encode clientId and clientSecret
		        String encodedClientId = "VjE6eG1mNnBuNjdmcjFpODdmODpERVZDRU5URVI6RVhU";
		        String encodedClientSecret = "aTZlUkwwSG0=";

		        //Concatenate encoded client and secret strings, separated with colon
		        String encodedClientIdSecret = encodedClientId+":"+encodedClientSecret;

		        //Convert the encoded concatenated string to a single base64 encoded string.
		        encodedClientIdSecret ="VmpFNmVHMW1ObkJ1TmpkbWNqRnBPRGRtT0RwRVJWWkRSVTVVUlZJNlJWaFU6YVRabFVrd3dTRzA9";
				
				DSCommHandler dsC = new DSCommHandler();
				String token = dsC.getAuthToken("https://api.test.sabre.com",encodedClientIdSecret);
				
				String urltheme = DSApiCalls.getTheme();
				
				String response = dsC.sendRequest(urltheme, token);
				
				ModelAndView mt = new ModelAndView("themej");
				//Display the response String
				//System.out.println(response);
				mt.addObject("th", response);
				//mo.setViewName("farej.jsp");
		
		
					return mt;
				
	}
	
	
	@RequestMapping(value = "/setprice", method = RequestMethod.GET)
	public @ResponseBody void practice3(@RequestParam("id1") String id1, @RequestParam("id2") String id2, @RequestParam("id3") String id3, @RequestParam("id4") String id4) {
		
		//System.out.println(id1 + id2 + id3 + id4);
		DSApiCalls.setFares(id1,id2,id3,id4);
		
		fare();
	}
	
	
	
	
	@RequestMapping(value = "/fare", method = RequestMethod.GET)
	public ModelAndView fare() {
		
		// TODO Auto-generated method stub
				//
				//Request authentication
				//
				final String clientId = "V1:xmf6pn67fr1i87f8:DEVCENTER:EXT";//Put Your Client Id Here
				final String clientSecret= "i6eRL0Hm";//Put Your Secret Id Here
				
				//base64 encode clientId and clientSecret
		        String encodedClientId = "VjE6eG1mNnBuNjdmcjFpODdmODpERVZDRU5URVI6RVhU";
		        String encodedClientSecret = "aTZlUkwwSG0=";

		        //Concatenate encoded client and secret strings, separated with colon
		        String encodedClientIdSecret = encodedClientId+":"+encodedClientSecret;

		        //Convert the encoded concatenated string to a single base64 encoded string.
		        encodedClientIdSecret ="VmpFNmVHMW1ObkJ1TmpkbWNqRnBPRGRtT0RwRVJWWkRSVTVVUlZJNlJWaFU6YVRabFVrd3dTRzA9";
				
				DSCommHandler dsC = new DSCommHandler();
				String token = dsC.getAuthToken("https://api.test.sabre.com",encodedClientIdSecret);
				
				String urlfare = DSApiCalls.getFares();
				
				// for theme
				String response = dsC.sendRequest(urlfare, token);
				//System.out.println("Hi Man");
				//System.out.println(response);
				//System.out.println("SDS Response: "+response);
				//String res = response.substring(63,706);
				System.out.println(response);
				ModelAndView mo = new ModelAndView("farej");
						//Display the response String
						//System.out.println(response);
						mo.addObject("fa", response);
						//mo.setViewName("farej.jsp");
				
				
		return mo;
				
	}
	

	
	

	/*@RequestMapping(value = "/setprice/{id1}/{id2}/{id3}/{id4}", method = RequestMethod.GET)
	public @ResponseBody void practice3(@PathVariable("id1") String id1, @PathVariable("id2") String id2, @PathVariable("id3") String id3, @PathVariable("id4") String id4) {
		
		//return id1 + id2 + id3 + id4 ;
		DSApiCalls.setFares(id1,id2,id3,id4);
		fare();
		
		
	}*/

	

	@RequestMapping(value = "/setnoidea", method = RequestMethod.GET)
	public @ResponseBody void practice2(@RequestParam("id1") String id1) {
		System.out.println(id1);
		DSApiCalls.setNoidea(id1);
		//return "The value of id1 is "+id_wateva+" and the value of id2 is "+id2;
		noidea();
		
	}
	
	@RequestMapping(value = "/noidea", method = RequestMethod.GET)
	public ModelAndView noidea() {
		
		// TODO Auto-generated method stub
				//
				//Request authentication
				//
				final String clientId = "V1:xmf6pn67fr1i87f8:DEVCENTER:EXT";//Put Your Client Id Here
				final String clientSecret= "i6eRL0Hm";//Put Your Secret Id Here
				
				//base64 encode clientId and clientSecret
		        String encodedClientId = "VjE6eG1mNnBuNjdmcjFpODdmODpERVZDRU5URVI6RVhU";
		        String encodedClientSecret = "aTZlUkwwSG0=";

		        //Concatenate encoded client and secret strings, separated with colon
		        String encodedClientIdSecret = encodedClientId+":"+encodedClientSecret;

		        //Convert the encoded concatenated string to a single base64 encoded string.
		        encodedClientIdSecret ="VmpFNmVHMW1ObkJ1TmpkbWNqRnBPRGRtT0RwRVJWWkRSVTVVUlZJNlJWaFU6YVRabFVrd3dTRzA9";
				
				DSCommHandler dsC = new DSCommHandler();
				String token = dsC.getAuthToken("https://api.test.sabre.com",encodedClientIdSecret);
				
				String urlnoidea = DSApiCalls.getNoIdea();
				
				// for theme
				String response1= dsC.sendRequest(urlnoidea, token);
				System.out.println(response1);
				
				ModelAndView mp = new ModelAndView("noideaj");
				//Display the response String
				//System.out.println(response);
				
				mp.addObject("noidj", response1);
				//mo.setViewName("farej.jsp");
		
		
				return mp;
	}
	
	
	
}
