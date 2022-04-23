package com.telefonica.p7.service;

import com.telefonica.p7.model.Application;

public interface ApplicationsService {
    Iterable<Application> getApplications();
    Application getApplication(String id);
    void deleteApplication(String id); 
    Application insertApplication(Application Application);
    Application updateApplication(String id, Application Application);   
}
