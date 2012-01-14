package com.rickdane.springmodularizedproject.module.consumabledata.domain;

import com.rickdane.springmodularizedproject.module.userdata.domain.EmailTemplateBody;
import com.rickdane.springmodularizedproject.module.userdata.domain.EmailTemplateCategory;
import com.rickdane.springmodularizedproject.module.userdata.domain.EmailTemplateSubject;
import com.rickdane.utility.RandomSelector;

import javax.persistence.TypedQuery;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Rick Dane
 */
@RooJavaBean
@RooJson(deepSerialize = true)
public class EmailTransport {

    private String toEmail;

    private String body;

    private String fromAddress;

    private String subject;

    private long fkEmailaddressID;

    public long getFkEmailaddressID() {
        return fkEmailaddressID;
    }

    public void setFkEmailaddressID(long fkEmailaddressID) {
        this.fkEmailaddressID = fkEmailaddressID;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * this method affects state of multiple records, make sure it is appropriate to use
     *
     * @return
     */
    public static EmailTransport getPreparedEmailTransport() {
        EmailTransport emailTransport = new EmailTransport();

        TypedQuery<Website> queryW = Website.findWebsitesByDateLastSentEmailIsNullAndWebsiteEmailSendStatus(WebsiteEmailSendStatus.NOT_IN_PROGRESS);
        List<Website> websiteList = queryW.getResultList();

        Website website = null;
        if (!websiteList.isEmpty()) {
            website = websiteList.get(0);
        }

        if (website == null) {
            //do another type of query to see if there are other websites with emails that need to be sent
        }

        if (website != null) {

            Emailaddress emailaddress = websiteTypeWorkflow(website);

            if (emailaddress != null) {

                EmailTemplateCategory emailTemplateCategory = website.getEmailTemplateCategories();

                EmailTemplateBody emailTemplateBody = getRandomResult(EmailTemplateBody.findEmailTemplateBodysByEmailTemplateCategory(emailTemplateCategory));
                EmailTemplateSubject emailTemplateSubject = getRandomResult(EmailTemplateSubject.findEmailTemplateSubjectsByEmailTemplateCategory(emailTemplateCategory));

                emailTransport.setBody(emailTemplateBody.getBody());
                emailTransport.setSubject(emailTemplateSubject.getSubject());

                emailTransport.setFkEmailaddressID(emailaddress.getId());
                emailTransport.setToEmail(emailaddress.getEmail());

                emailTransport.setFkEmailaddressID(emailaddress.getId());

                //TODO: evaluate whether using this status is a good idea as it creates more complexity by relying on an update from the client webgatherer app to be set back
                //website.setWebsiteEmailSendStatus(WebsiteEmailSendStatus.IN_PROGRESS);

                website.updateDateLastSentToNow();

                website.persist();

                emailaddress.setDateLastSent(new GregorianCalendar());
                emailaddress.persist();
            }
        }

        return emailTransport;
    }


    private static Emailaddress websiteTypeWorkflow(Website website) {

        Emailaddress emailaddress = null;

        if (website.getType() == WebsiteType.SEARCH_ENGINE) {
            TypedQuery<Emailaddress> queryE = Emailaddress.findEmailaddressesByWebsiteAndDateLastSentIsNull(website);
            List<Emailaddress> emailaddressList = queryE.getResultList();
            if (!emailaddressList.isEmpty()) {
                emailaddress = emailaddressList.get(0);
            }

        } else if (website.getType() == WebsiteType.COMPANY_SITE) {
            emailaddress = website.getEmailPrimary();
        }

        return emailaddress;
    }

    private static <T> T getRandomResult(TypedQuery<T> query) {
        List<T> list = query.getResultList();
        int index = RandomSelector.randomListIndex(list);
        T entry = list.get(index);
        return entry;
    }

}
