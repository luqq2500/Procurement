package company.api;

import company.Company;

public interface CompanyRegistrator {
    Company register(String name, int businessId, int taxId);
}
