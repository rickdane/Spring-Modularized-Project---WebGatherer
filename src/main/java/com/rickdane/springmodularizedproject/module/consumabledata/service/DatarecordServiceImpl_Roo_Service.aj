// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.rickdane.springmodularizedproject.module.consumabledata.service;

import com.rickdane.springmodularizedproject.module.consumabledata.domain.Datarecord;
import com.rickdane.springmodularizedproject.module.consumabledata.repository.DatarecordRepository;
import com.rickdane.springmodularizedproject.module.consumabledata.service.DatarecordServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect DatarecordServiceImpl_Roo_Service {
    
    declare @type: DatarecordServiceImpl: @Service;
    
    declare @type: DatarecordServiceImpl: @Transactional;
    
    @Autowired
    DatarecordRepository DatarecordServiceImpl.datarecordRepository;
    
    public long DatarecordServiceImpl.countAllDatarecords() {
        return datarecordRepository.count();
    }
    
    public void DatarecordServiceImpl.deleteDatarecord(Datarecord datarecord) {
        datarecordRepository.delete(datarecord);
    }
    
    public Datarecord DatarecordServiceImpl.findDatarecord(Long id) {
        return datarecordRepository.findOne(id);
    }
    
    public List<Datarecord> DatarecordServiceImpl.findAllDatarecords() {
        return datarecordRepository.findAll();
    }
    
    public List<Datarecord> DatarecordServiceImpl.findDatarecordEntries(int firstResult, int maxResults) {
        return datarecordRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void DatarecordServiceImpl.saveDatarecord(Datarecord datarecord) {
        datarecordRepository.save(datarecord);
    }
    
    public Datarecord DatarecordServiceImpl.updateDatarecord(Datarecord datarecord) {
        return datarecordRepository.save(datarecord);
    }
    
}
