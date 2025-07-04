package issuer.api;

import issuer.Issuer;

import java.util.UUID;

public interface IssuerRegistrator {
    Issuer register(String name, UUID companyId);
}
