// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.module.webgatherer.domain;

import com.rickdane.springmodularizedproject.module.webgatherer.domain.Rawscrapeddata;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Rawscrapeddata_Roo_Json {
    
    public String Rawscrapeddata.toJson() {
        return new JSONSerializer().exclude("*.class").deepSerialize(this);
    }
    
    public static Rawscrapeddata Rawscrapeddata.fromJsonToRawscrapeddata(String json) {
        return new JSONDeserializer<Rawscrapeddata>().use(null, Rawscrapeddata.class).deserialize(json);
    }
    
    public static String Rawscrapeddata.toJsonArray(Collection<Rawscrapeddata> collection) {
        return new JSONSerializer().exclude("*.class").deepSerialize(collection);
    }
    
    public static Collection<Rawscrapeddata> Rawscrapeddata.fromJsonArrayToRawscrapeddatas(String json) {
        return new JSONDeserializer<List<Rawscrapeddata>>().use(null, ArrayList.class).use("values", Rawscrapeddata.class).deserialize(json);
    }
    
}
