package com.example.Service;

import com.example.Entity.Employee;
import com.example.Sentry.SentryDBUtils;
import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Repository;

/**
 * Created by sudip sarker on 4/9/2017.
 */
@Service
@Repository
public class EmployeeService {

    public Object create(Employee employee) throws Exception {
        SentryDBUtils.getMongoOperation().insert(employee);

        return employee;
    }
}
