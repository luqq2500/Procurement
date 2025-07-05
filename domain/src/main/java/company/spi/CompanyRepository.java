package company.spi;

import company.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository {
    void add(Company company);
    Optional<Company> findById(UUID id);
    Optional<Company> findByBusinessId(int businessId);
    Optional<Company> findByTaxId(int taxId);
}
