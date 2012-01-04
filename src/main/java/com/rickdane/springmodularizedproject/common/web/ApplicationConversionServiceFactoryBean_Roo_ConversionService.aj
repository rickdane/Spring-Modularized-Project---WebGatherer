// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.common.web;

import com.rickdane.springmodularizedproject.common.web.ApplicationConversionServiceFactoryBean;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;
import com.rickdane.springmodularizedproject.module.consumabledata.service.DatarecordService;
import com.rickdane.springmodularizedproject.module.user.domain.Appuser;
import com.rickdane.springmodularizedproject.module.user.domain.Authority;
import com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin;
import com.rickdane.springmodularizedproject.module.user.service.AppuserService;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;
import com.rickdane.springmodularizedproject.module.webgatherer.service.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    @Autowired
    DatarecordService ApplicationConversionServiceFactoryBean.datarecordService;
    
    @Autowired
    AppuserService ApplicationConversionServiceFactoryBean.appuserService;
    
    @Autowired
    ScraperService ApplicationConversionServiceFactoryBean.scraperService;
    
    public Converter<Datarecord, String> ApplicationConversionServiceFactoryBean.getDatarecordToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord, java.lang.String>() {
            public String convert(Datarecord datarecord) {
                return new StringBuilder().append(datarecord.getEntry()).toString();
            }
        };
    }
    
    public Converter<Long, Datarecord> ApplicationConversionServiceFactoryBean.getIdToDatarecordConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord>() {
            public com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord convert(java.lang.Long id) {
                return datarecordService.findDatarecord(id);
            }
        };
    }
    
    public Converter<String, Datarecord> ApplicationConversionServiceFactoryBean.getStringToDatarecordConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord>() {
            public com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Datarecord.class);
            }
        };
    }
    
    public Converter<Appuser, String> ApplicationConversionServiceFactoryBean.getAppuserToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.user.domain.Appuser, java.lang.String>() {
            public String convert(Appuser appuser) {
                return new StringBuilder().append(appuser.getUsername()).append(" ").append(appuser.getPassword()).toString();
            }
        };
    }
    
    public Converter<Long, Appuser> ApplicationConversionServiceFactoryBean.getIdToAppuserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.user.domain.Appuser>() {
            public com.rickdane.springmodularizedproject.module.user.domain.Appuser convert(java.lang.Long id) {
                return appuserService.findAppuser(id);
            }
        };
    }
    
    public Converter<String, Appuser> ApplicationConversionServiceFactoryBean.getStringToAppuserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.module.user.domain.Appuser>() {
            public com.rickdane.springmodularizedproject.module.user.domain.Appuser convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Appuser.class);
            }
        };
    }
    
    public Converter<Authority, String> ApplicationConversionServiceFactoryBean.getAuthorityToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.user.domain.Authority, java.lang.String>() {
            public String convert(Authority authority) {
                return new StringBuilder().append(authority.getUsername()).append(" ").append(authority.getAuthority()).toString();
            }
        };
    }
    
    public Converter<Long, Authority> ApplicationConversionServiceFactoryBean.getIdToAuthorityConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.user.domain.Authority>() {
            public com.rickdane.springmodularizedproject.module.user.domain.Authority convert(java.lang.Long id) {
                return Authority.findAuthority(id);
            }
        };
    }
    
    public Converter<String, Authority> ApplicationConversionServiceFactoryBean.getStringToAuthorityConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.module.user.domain.Authority>() {
            public com.rickdane.springmodularizedproject.module.user.domain.Authority convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Authority.class);
            }
        };
    }
    
    public Converter<PersistentLogin, String> ApplicationConversionServiceFactoryBean.getPersistentLoginToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin, java.lang.String>() {
            public String convert(PersistentLogin persistentLogin) {
                return new StringBuilder().append(persistentLogin.getUsername()).append(" ").append(persistentLogin.getSeries()).append(" ").append(persistentLogin.getToken()).append(" ").append(persistentLogin.getLast_used()).toString();
            }
        };
    }
    
    public Converter<Long, PersistentLogin> ApplicationConversionServiceFactoryBean.getIdToPersistentLoginConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin>() {
            public com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin convert(java.lang.Long id) {
                return PersistentLogin.findPersistentLogin(id);
            }
        };
    }
    
    public Converter<String, PersistentLogin> ApplicationConversionServiceFactoryBean.getStringToPersistentLoginConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin>() {
            public com.rickdane.springmodularizedproject.module.user.domain.PersistentLogin convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), PersistentLogin.class);
            }
        };
    }
    
    public Converter<Scraper, String> ApplicationConversionServiceFactoryBean.getScraperToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper, java.lang.String>() {
            public String convert(Scraper scraper) {
                return new StringBuilder().append(scraper.getName()).toString();
            }
        };
    }
    
    public Converter<Long, Scraper> ApplicationConversionServiceFactoryBean.getIdToScraperConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper>() {
            public com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper convert(java.lang.Long id) {
                return scraperService.findScraper(id);
            }
        };
    }
    
    public Converter<String, Scraper> ApplicationConversionServiceFactoryBean.getStringToScraperConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper>() {
            public com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Scraper.class);
            }
        };
    }
    
    public void ApplicationConversionServiceFactoryBean.installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getDatarecordToStringConverter());
        registry.addConverter(getIdToDatarecordConverter());
        registry.addConverter(getStringToDatarecordConverter());
        registry.addConverter(getAppuserToStringConverter());
        registry.addConverter(getIdToAppuserConverter());
        registry.addConverter(getStringToAppuserConverter());
        registry.addConverter(getAuthorityToStringConverter());
        registry.addConverter(getIdToAuthorityConverter());
        registry.addConverter(getStringToAuthorityConverter());
        registry.addConverter(getPersistentLoginToStringConverter());
        registry.addConverter(getIdToPersistentLoginConverter());
        registry.addConverter(getStringToPersistentLoginConverter());
        registry.addConverter(getScraperToStringConverter());
        registry.addConverter(getIdToScraperConverter());
        registry.addConverter(getStringToScraperConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
