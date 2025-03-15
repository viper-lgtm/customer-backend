package cz.martinvedra.backend.impl.service;

import cz.martinvedra.backend.impl.dto.CustomerDto;
import cz.martinvedra.backend.impl.dto.LoginCustomerBody;
import cz.martinvedra.backend.impl.dto.SaveCustomerBody;
import cz.martinvedra.backend.impl.entity.CustomerEntity;
import cz.martinvedra.backend.impl.repo.CustomerRepository;
import cz.martinvedra.backend.impl.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

//    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Override
    public CustomerDto save(SaveCustomerBody customerBody) {
        CustomerEntity customerEntity = customerMapper.mapToCustomerEntity(customerBody);
        CustomerEntity customerEntitySaved = customerRepository.save(customerEntity);
        CustomerDto customerDto = customerMapper.mapToCustomerDto(customerEntitySaved);
        return customerDto;
    }

    @Override
    public CustomerDto login(LoginCustomerBody loginCustomerBody) {
        val username = loginCustomerBody.username();
        val password = loginCustomerBody.password();

        CustomerEntity customerEntity = customerRepository.findByUsername(username).orElse(null);
        if (customerEntity == null) {
            return null;
        }

        if (passwordEncoder.matches(password, customerEntity.getPassword())) {
            return customerMapper.mapToCustomerDto(customerEntity);
        }
        return null;
    }

    @Override
    public List<CustomerDto> findAll() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = customerMapper.mapToCustomerDtoList(customerEntityList);
        return customerDtoList;
    }

    @Override
    public CustomerDto findById(Integer id) {
        return customerRepository.findById(Long.valueOf(id))
                .map(customerMapper::mapToCustomerDto)
                .orElse(null);
    }

    @Override
    public List<CustomerDto> findByEmail(String email) {
        List<CustomerEntity> customerEntityListByEmail = customerRepository.findByEmailContaining(email);
        List<CustomerDto> customerDtoList = customerMapper.mapToCustomerDtoList(customerEntityListByEmail);
        return customerDtoList;
    }
}
