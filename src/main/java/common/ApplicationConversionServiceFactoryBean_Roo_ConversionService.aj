// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package common;

import com.rickdane.springmodularizedproject.domain.Role;
import com.rickdane.springmodularizedproject.domain.User;
import com.rickdane.springmodularizedproject.domain.UserRole;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Emailaddress;
import com.rickdane.springmodularizedproject.module.consumabledata.domain.Website;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Rawscrapeddata;
import com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper;
import common.ApplicationConversionServiceFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

privileged aspect ApplicationConversionServiceFactoryBean_Roo_ConversionService {
    
    declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
    
    public Converter<Role, String> ApplicationConversionServiceFactoryBean.getRoleToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.domain.Role, java.lang.String>() {
            public String convert(Role role) {
                return new StringBuilder().append(role.getRoleName()).append(" ").append(role.getRoleDescription()).toString();
            }
        };
    }
    
    public Converter<Long, Role> ApplicationConversionServiceFactoryBean.getIdToRoleConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.domain.Role>() {
            public com.rickdane.springmodularizedproject.domain.Role convert(java.lang.Long id) {
                return Role.findRole(id);
            }
        };
    }
    
    public Converter<String, Role> ApplicationConversionServiceFactoryBean.getStringToRoleConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.domain.Role>() {
            public com.rickdane.springmodularizedproject.domain.Role convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Role.class);
            }
        };
    }
    
    public Converter<User, String> ApplicationConversionServiceFactoryBean.getUserToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.domain.User, java.lang.String>() {
            public String convert(User user) {
                return new StringBuilder().append(user.getFirstName()).append(" ").append(user.getLastName()).append(" ").append(user.getEmailAddress()).append(" ").append(user.getPassword()).toString();
            }
        };
    }
    
    public Converter<Long, User> ApplicationConversionServiceFactoryBean.getIdToUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.domain.User>() {
            public com.rickdane.springmodularizedproject.domain.User convert(java.lang.Long id) {
                return User.findUser(id);
            }
        };
    }
    
    public Converter<String, User> ApplicationConversionServiceFactoryBean.getStringToUserConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.domain.User>() {
            public com.rickdane.springmodularizedproject.domain.User convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), User.class);
            }
        };
    }
    
    public Converter<UserRole, String> ApplicationConversionServiceFactoryBean.getUserRoleToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.domain.UserRole, java.lang.String>() {
            public String convert(UserRole userRole) {
                return new StringBuilder().toString();
            }
        };
    }
    
    public Converter<Long, UserRole> ApplicationConversionServiceFactoryBean.getIdToUserRoleConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.domain.UserRole>() {
            public com.rickdane.springmodularizedproject.domain.UserRole convert(java.lang.Long id) {
                return UserRole.findUserRole(id);
            }
        };
    }
    
    public Converter<String, UserRole> ApplicationConversionServiceFactoryBean.getStringToUserRoleConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.domain.UserRole>() {
            public com.rickdane.springmodularizedproject.domain.UserRole convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), UserRole.class);
            }
        };
    }
    
    public Converter<Campaign, String> ApplicationConversionServiceFactoryBean.getCampaignToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign, java.lang.String>() {
            public String convert(Campaign campaign) {
                return new StringBuilder().append(campaign.getName()).toString();
            }
        };
    }
    
    public Converter<Long, Campaign> ApplicationConversionServiceFactoryBean.getIdToCampaignConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign>() {
            public com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign convert(java.lang.Long id) {
                return Campaign.findCampaign(id);
            }
        };
    }
    
    public Converter<String, Campaign> ApplicationConversionServiceFactoryBean.getStringToCampaignConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign>() {
            public com.rickdane.springmodularizedproject.module.consumabledata.domain.Campaign convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Campaign.class);
            }
        };
    }
    
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
                return Datarecord.findDatarecord(id);
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
    
    public Converter<Emailaddress, String> ApplicationConversionServiceFactoryBean.getEmailaddressToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.consumabledata.domain.Emailaddress, java.lang.String>() {
            public String convert(Emailaddress emailaddress) {
                return new StringBuilder().append(emailaddress.getEmail()).toString();
            }
        };
    }
    
    public Converter<Long, Emailaddress> ApplicationConversionServiceFactoryBean.getIdToEmailaddressConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.consumabledata.domain.Emailaddress>() {
            public com.rickdane.springmodularizedproject.module.consumabledata.domain.Emailaddress convert(java.lang.Long id) {
                return Emailaddress.findEmailaddress(id);
            }
        };
    }
    
    public Converter<String, Emailaddress> ApplicationConversionServiceFactoryBean.getStringToEmailaddressConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.module.consumabledata.domain.Emailaddress>() {
            public com.rickdane.springmodularizedproject.module.consumabledata.domain.Emailaddress convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Emailaddress.class);
            }
        };
    }
    
    public Converter<Website, String> ApplicationConversionServiceFactoryBean.getWebsiteToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.consumabledata.domain.Website, java.lang.String>() {
            public String convert(Website website) {
                return new StringBuilder().append(website.getDomainName()).append(" ").append(website.getContactName()).append(" ").append(website.getDateLastSentEmail()).append(" ").append(website.getType()).toString();
            }
        };
    }
    
    public Converter<Long, Website> ApplicationConversionServiceFactoryBean.getIdToWebsiteConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.consumabledata.domain.Website>() {
            public com.rickdane.springmodularizedproject.module.consumabledata.domain.Website convert(java.lang.Long id) {
                return Website.findWebsite(id);
            }
        };
    }
    
    public Converter<String, Website> ApplicationConversionServiceFactoryBean.getStringToWebsiteConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.module.consumabledata.domain.Website>() {
            public com.rickdane.springmodularizedproject.module.consumabledata.domain.Website convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Website.class);
            }
        };
    }
    
    public Converter<Rawscrapeddata, String> ApplicationConversionServiceFactoryBean.getRawscrapeddataToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.webgatherer.domain.Rawscrapeddata, java.lang.String>() {
            public String convert(Rawscrapeddata rawscrapeddata) {
                return new StringBuilder().append(rawscrapeddata.getUrl()).append(" ").append(rawscrapeddata.getEmailAddress()).append(" ").append(rawscrapeddata.getText()).toString();
            }
        };
    }
    
    public Converter<Long, Rawscrapeddata> ApplicationConversionServiceFactoryBean.getIdToRawscrapeddataConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.webgatherer.domain.Rawscrapeddata>() {
            public com.rickdane.springmodularizedproject.module.webgatherer.domain.Rawscrapeddata convert(java.lang.Long id) {
                return Rawscrapeddata.findRawscrapeddata(id);
            }
        };
    }
    
    public Converter<String, Rawscrapeddata> ApplicationConversionServiceFactoryBean.getStringToRawscrapeddataConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.rickdane.springmodularizedproject.module.webgatherer.domain.Rawscrapeddata>() {
            public com.rickdane.springmodularizedproject.module.webgatherer.domain.Rawscrapeddata convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Rawscrapeddata.class);
            }
        };
    }
    
    public Converter<Scraper, String> ApplicationConversionServiceFactoryBean.getScraperToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper, java.lang.String>() {
            public String convert(Scraper scraper) {
                return new StringBuilder().append(scraper.getName()).append(" ").append(scraper.getType()).toString();
            }
        };
    }
    
    public Converter<Long, Scraper> ApplicationConversionServiceFactoryBean.getIdToScraperConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper>() {
            public com.rickdane.springmodularizedproject.module.webgatherer.domain.Scraper convert(java.lang.Long id) {
                return Scraper.findScraper(id);
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
        registry.addConverter(getRoleToStringConverter());
        registry.addConverter(getIdToRoleConverter());
        registry.addConverter(getStringToRoleConverter());
        registry.addConverter(getUserToStringConverter());
        registry.addConverter(getIdToUserConverter());
        registry.addConverter(getStringToUserConverter());
        registry.addConverter(getUserRoleToStringConverter());
        registry.addConverter(getIdToUserRoleConverter());
        registry.addConverter(getStringToUserRoleConverter());
        registry.addConverter(getCampaignToStringConverter());
        registry.addConverter(getIdToCampaignConverter());
        registry.addConverter(getStringToCampaignConverter());
        registry.addConverter(getDatarecordToStringConverter());
        registry.addConverter(getIdToDatarecordConverter());
        registry.addConverter(getStringToDatarecordConverter());
        registry.addConverter(getEmailaddressToStringConverter());
        registry.addConverter(getIdToEmailaddressConverter());
        registry.addConverter(getStringToEmailaddressConverter());
        registry.addConverter(getWebsiteToStringConverter());
        registry.addConverter(getIdToWebsiteConverter());
        registry.addConverter(getStringToWebsiteConverter());
        registry.addConverter(getRawscrapeddataToStringConverter());
        registry.addConverter(getIdToRawscrapeddataConverter());
        registry.addConverter(getStringToRawscrapeddataConverter());
        registry.addConverter(getScraperToStringConverter());
        registry.addConverter(getIdToScraperConverter());
        registry.addConverter(getStringToScraperConverter());
    }
    
    public void ApplicationConversionServiceFactoryBean.afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
    
}
