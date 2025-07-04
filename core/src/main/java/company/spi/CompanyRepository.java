package company.spi;

import company.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository {
    List<Company> companies();
    void add(Company company);
    Optional<Company> findById(UUID id);
}
