package com.telefonica.p7.service.implementation;

import com.telefonica.p7.repository.ApplicationRepository;
import com.telefonica.p7.service.ApplicationsService;
import com.telefonica.p7.model.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationsServiceImplementation implements ApplicationsService{
    @Autowired
    private ApplicationRepository ApplicationRepository;

    @Override
    public Iterable<Application> getApplications(){
        return ApplicationRepository.findAll();
    }

    @Override
    public Application getApplication(String id){
        Application response = null;
        if(ApplicationRepository.existsById(id)){
            Iterable<Application> Applications = ApplicationRepository.getApplicationByID(id);
            for(Application Application : Applications){
                response = Application;
            }
            return response;            
        }
        return response;
    }

    @Override
    public void deleteApplication(String id){
        ApplicationRepository.deleteById(id);
    }

    @Override
    public Application insertApplication(Application Application){
        return ApplicationRepository.save(Application);
    }

    @Override
    public Application updateApplication(String id, Application Application){
        if(ApplicationRepository.existsById(id)){
            return ApplicationRepository.save(Application);
        } else {
            return null;
        }
        
    }
    
}
