package cz.martinvedra.backend.impl.service;

import cz.martinvedra.backend.impl.dto.CustomerDto;
import cz.martinvedra.backend.impl.dto.LoginCustomerBody;
import cz.martinvedra.backend.impl.dto.SaveCustomerBody;
import cz.martinvedra.backend.impl.entity.CustomerEntity;

import java.util.List;

/**
 * Service interface managing manipulation between {@link CustomerEntity and DTOs}
 */
public interface CustomerService {

    /**
     * Saves a new customer based on the provided {@link SaveCustomerBody}.
     * This method performs any necessary business logic validation and
     * transforms the input data into a {@link CustomerDto} before persisting
     * it to the database.
     *
     * @param customerBody The data for the new customer.
     * @return The {@link CustomerDto} representing the saved customer.
     * @throws IllegalArgumentException If the provided {@code customerBody} is invalid or violates business rules. (Add specific exceptions)
     */
    CustomerDto save(SaveCustomerBody customerBody);

    /**
     * Retrieves a list of all customer entities.
     * This method returns a list of {@link CustomerDto} objects, representing
     * all customers stored in the database.  The list may be empty if no
     * customers exist.
     *
     * @return A list of {@link CustomerDto} objects, or an empty list if no customers are found.
     */
    List<CustomerDto> findAll();

    CustomerDto findById(Integer id);

    List<CustomerDto> findByEmail(String email);

    /**
     * Logs in a customer.
     *
     * @param loginCustomerBody The login request body containing the customer's credentials.
     *                          This object should contain the customer's email (or username) and password.
     *                          It may be validated using Javax Validation annotations (e.g., @NotBlank, @Email).
     *                          See {@link LoginCustomerBody} for details on the expected fields.
     * @return A {@link CustomerDto} representing the logged-in customer, or null if login fails.
     *         The returned DTO may contain information about the customer, such as their ID, name, email, etc.
     */
    CustomerDto login(LoginCustomerBody loginCustomerBody);
}
