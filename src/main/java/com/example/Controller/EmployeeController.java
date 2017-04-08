package com.example.Controller;

import com.example.Entity.Employee;
import com.example.Service.EmployeeService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by sudip sarker on 4/9/2017.
 */
@Path("/employees")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Autowired
    private EmployeeService employeeService;

    Gson gson = new Gson();


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Employee employee) {

        Map<Object, Object> apiResponse = new HashMap<Object, Object>();

        try {
            Set<ConstraintViolation<Employee>> validateErrors = validator.validate(employee);

            if (validateErrors.isEmpty()) {

                logger.debug("Calling employee service: " + employee.getEmail());

                employee = (Employee) employeeService.create(employee);

                if (employee != null) {

                    logger.debug("creating employee with email :" + employee.getEmail());
                    apiResponse.put("apiresponse", employee);

                    return Response.ok(apiResponse).build();
                }

            } else {
                for (ConstraintViolation<Employee> error : validateErrors) {
                    apiResponse.put(error.getPropertyPath().toString(),
                            error.getMessage());
                }
                return Response.status(400).entity(apiResponse).build();
            }
        }
        catch (Exception e) {

            logger.error("Error occured creating employee:", e);
            apiResponse.put("error", e.getMessage());
        }
        return Response.status(500).entity(apiResponse).build();

    }


}
