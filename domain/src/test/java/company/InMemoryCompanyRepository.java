package company;

import company.spi.CompanyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InMemoryCompanyRepository implements CompanyRepository {
    List<Company> companies = new ArrayList<>();

    @Override
    public void add(Company company) {
        this.companies.add(company);
    }

    @Override
    public Optional<Company> findById(UUID id) {
        return this.companies.stream()
                .filter(company -> company.id().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Company> findByBusinessId(int businessId) {
        return this.companies.stream()
                .filter(company -> company.businessId() == businessId)
                .findFirst();
    }

    @Override
    public Optional<Company> findByTaxId(int taxId) {
        return this.companies.stream()
                .filter(company -> company.taxId() == taxId)
                .findFirst();
    }
}
