package com.bhawani;

import java.util.HashMap;
import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iptv.programme.pojo.Programme;


/**
 * 
 * @author bhawani.singh
 *
 */
@RestController
@RequestMapping(value = "programme")
public class ProgrammeREST {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(ProgrammeREST.class.getName());
	
private static HashMap<String,Programme> programmes = new HashMap<String,Programme>();	
	
	static {
		int progDuration=0;
		for(int i=0; i<=100; i++){
			int val = i%4;			
			switch(val){
			case 0:
				progDuration = 5;
				break;
			case 1:
				progDuration = 10;
				break;
			case 2:
				progDuration = 20;
				break;
			case 3:
				progDuration = 30;
			}
			programmes.put(""+i, new Programme(""+i, "PROGRAMME"+i, progDuration));
		}
		
	}	
	

		
	@RequestMapping(value = "/{id}",
	method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)	
	@ResponseBody	
    public Programme find(@PathVariable("id") String id) {
		LOGGER.info("ProgramREST.record() id = " + id);
		return programmes.get(id);
	}
	
	
	
	@RequestMapping(value = "/hi",
	method = RequestMethod.GET)	
	@ResponseBody	
    public String hi() {
		LOGGER.info("ProgramREST.hi()");
		return "Welcome to RSystems !!!";
	}
}
