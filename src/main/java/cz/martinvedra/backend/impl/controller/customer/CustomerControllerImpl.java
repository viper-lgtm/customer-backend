package cz.martinvedra.backend.impl.controller.customer;

import cz.martinvedra.backend.impl.dto.CustomerDto;
import cz.martinvedra.backend.impl.dto.LoginCustomerBody;
import cz.martinvedra.backend.impl.dto.SaveCustomerBody;
import cz.martinvedra.backend.impl.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public CustomerDto save(@RequestBody SaveCustomerBody customerBody) {
        return customerService.save(customerBody);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public CustomerDto login(@RequestBody LoginCustomerBody loginCustomerBody) {
        return customerService.login(loginCustomerBody);
    }

    @GetMapping
    @Override
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public CustomerDto findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    @GetMapping("/email")
    @Override
    public List<CustomerDto> findByEmail(@RequestParam String email) {
        return customerService.findByEmail(email);
    }

    //TODO succesfful controller from postman, try autowiring and mapstruct manipulation in pom and class, try combination spring, mappers
    //TODO and try other properties settings
}
