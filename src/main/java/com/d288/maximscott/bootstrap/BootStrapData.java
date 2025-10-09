package com.d288.maximscott.bootstrap;

import com.d288.maximscott.dao.CartRepository;
import com.d288.maximscott.dao.CustomerRepository;
import com.d288.maximscott.dao.DivisionRepository;
import com.d288.maximscott.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

//runs the run() method after the app starts
@Component
public class BootStrapData implements CommandLineRunner {


    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    //dependency injection so to save to the database
    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
        this.customerRepository = customerRepository;
    }

    //creating 5 pre-made customers for testing
    @Override
    public void run(String... args) throws Exception {
        //already one customer in the DB so condition set to 1, also so it doesn't create multiples after each time app runs.
        if (customerRepository.count() == 1) {

            Customer max = new Customer();
            max.setFirstName("Max");
            max.setLastName("Scott");
            max.setAddress("3450 Potato Land");
            max.setPhone("111-867-8309");
            max.setPostal_code("11122");
            max.setDivision(divisionRepository.getReferenceById(45L));
            max.setCreate_date(new Date());
            max.setLast_update(new Date());
            customerRepository.save(max);

            Customer connor = new Customer();
            connor.setFirstName("Connor");
            connor.setLastName("Toop");
            connor.setAddress("87 Cucumber Road");
            connor.setPhone("112-867-8308");
            connor.setPostal_code("11232");
            connor.setDivision(divisionRepository.getReferenceById(30L));
            connor.setCreate_date(new Date());
            connor.setLast_update(new Date());
            customerRepository.save(connor);

            Customer sydney = new Customer();
            sydney.setFirstName("Sydney");
            sydney.setLastName("Slum");
            sydney.setAddress("343 Bungie Blvd");
            sydney.setPhone("113-867-8309");
            sydney.setPostal_code("11122");
            sydney.setDivision(divisionRepository.getReferenceById(22L));
            sydney.setCreate_date(new Date());
            sydney.setLast_update(new Date());
            customerRepository.save(sydney);

            Customer lu = new Customer();
            lu.setFirstName("Lu");
            lu.setLastName("Scott");
            lu.setAddress("3450 Potato Land");
            lu.setPhone("111-867-8380");
            lu.setPostal_code("11122");
            lu.setDivision(divisionRepository.getReferenceById(45L));
            lu.setCreate_date(new Date());
            lu.setLast_update(new Date());
            customerRepository.save(lu);

            Customer dom = new Customer();
            dom.setFirstName("Dom");
            dom.setLastName("Moore");
            dom.setAddress("903 Fried Chicken Lane");
            dom.setPhone("221-867-8939");
            dom.setPostal_code("41122");
            dom.setDivision(divisionRepository.getReferenceById(4L));
            dom.setCreate_date(new Date());
            dom.setLast_update(new Date());
            customerRepository.save(dom);
        }
    }
}
