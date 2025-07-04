package company;

import company.api.CompanyRegistrator;
import company.spi.CompanyRepository;

import java.util.UUID;

public class RegisterACompany implements CompanyRegistrator {
    private final CompanyRepository companyRepository;

    public RegisterACompany(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company register(String name, int registrationId) {
        Company company = new Company(UUID.randomUUID(), name, registrationId);
        this.companyRepository.add(company);
        return this.companyRepository.findById(company.id()).orElse(null);
    }
}
