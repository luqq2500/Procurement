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
    public Company register(String name, int businessId, int taxId) {
        checkInformationIsValid(businessId, taxId);
        Company company = new Company(UUID.randomUUID(), name, businessId, taxId);
        this.companyRepository.add(company);
        return company;
    }

    private void checkInformationIsValid(int businessId, int taxId) {
        if (businessId == taxId){
            throw new RegisterInvalidCompanyInformationException("Business ID and Tax ID cannot be the same.");
        }
        if (businessId<0){
            throw new RegisterInvalidCompanyInformationException("Business ID must be greater than 0.");
        }
        if (taxId<0){
            throw new RegisterInvalidCompanyInformationException("Tax ID must be greater than 0.");
        }
        if (this.companyRepository.findByBusinessId(businessId).isPresent()) {
            throw new RegisterInvalidCompanyInformationException("Business id " + businessId + " already exists");
        }
        if (this.companyRepository.findByTaxId(taxId).isPresent()) {
            throw new RegisterInvalidCompanyInformationException("Tax id " + taxId + " already exists");
        }
    }
}
