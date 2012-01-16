package com.rickdane.springmodularizedproject.module.userdata.domain;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Website;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 1/15/12
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class SessionValues {
    
    Website currentWebsite;

    public Website getCurrentWebsite() {
        return currentWebsite;
    }

    public void setCurrentWebsite(Website currentWebsite) {
        this.currentWebsite = currentWebsite;
    }
}
