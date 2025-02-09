package cz.martinvedra.backend.impl.controller.customer;

import cz.martinvedra.backend.impl.dto.CustomerDto;
import cz.martinvedra.backend.impl.dto.LoginCustomerBody;
import cz.martinvedra.backend.impl.dto.SaveCustomerBody;

import java.util.List;

public interface CustomerController {

    CustomerDto save(SaveCustomerBody customerBody);

    CustomerDto login(LoginCustomerBody loginCustomerBody);

    List<CustomerDto> findAll();

    CustomerDto findById(Integer id);

    List<CustomerDto> findByEmail(String email);
}
