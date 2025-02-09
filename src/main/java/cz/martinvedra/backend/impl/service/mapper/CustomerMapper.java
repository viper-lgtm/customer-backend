package cz.martinvedra.backend.impl.service.mapper;

import cz.martinvedra.backend.impl.dto.CustomerDto;
import cz.martinvedra.backend.impl.dto.SaveCustomerBody;
import cz.martinvedra.backend.impl.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
//@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    CustomerEntity mapToCustomerEntity(SaveCustomerBody saveCustomerBody);

    CustomerDto mapToCustomerDto(CustomerEntity customerEntity);

    List<CustomerDto> mapToCustomerDtoList(List<CustomerEntity> allCustomerEntitiesList);
}
