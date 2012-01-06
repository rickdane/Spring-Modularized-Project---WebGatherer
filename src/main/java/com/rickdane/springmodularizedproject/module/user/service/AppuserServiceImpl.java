package com.rickdane.springmodularizedproject.module.user.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.rickdane.springmodularizedproject.module.user.domain.Appuser;
import com.rickdane.springmodularizedproject.module.user.domain.Authority;
import com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin;
import com.rickdane.springmodularizedproject.module.user.repository.AppuserRepository;


public class AppuserServiceImpl implements AppuserService {
	
    @Autowired
    AppuserRepository appuserRepository;
	
    public void saveAppuser(Appuser appuser) {
    	if (appuser.getId()== null) {
    		
    		//TODO, make this part of a transaction
    		Authority authority = new Authority();
    		authority.setUsername(appuser.getUsername());
    		authority.setAuthority("webgatherer");
    		authority.persist();
    		
    		Calendar calendar = Calendar.getInstance();
    		
    		PersistentLogin persistentLogin = new PersistentLogin();
    		persistentLogin.setSeries("1");
    		persistentLogin.setUsername(appuser.getUsername());
    		persistentLogin.setToken("2309fjksa");
    		persistentLogin.setSeries("series2903");
    		persistentLogin.setLast_used(calendar);
    		persistentLogin.persist();
    	}
    	appuserRepository.save(appuser);
    }
    
}
