package com.dentolize.associates.insuranceCompanies.api;

public class InsuranceCompaniesSchema {
    private static InsuranceCompaniesSchema insuranceInstance;

    private InsuranceCompaniesSchema() {
        // Private constructor to prevent instantiation
    }

    public static synchronized InsuranceCompaniesSchema getInstance() {
        if (insuranceInstance == null) {
            insuranceInstance = new InsuranceCompaniesSchema();
        }
        return insuranceInstance;
    }

    public final String QUERY_TOTAL_INSURANCE_COMPANIES = """
            query TOTAL_INSURANCE_COMPANIES($searchTerm: String, $filters: Filter) {
              totalInsuranceCompanies(searchTerm: $searchTerm, filters: $filters)
            }
            """;

    public final String QUERY_GET_INSURANCE_COMPANIES = """
            query GET_INSURANCE_COMPANIES($orderBy: String!, $skip: Int!, $take: Int!, $searchTerm: String, $filters: Filter) {
              insuranceCompanies(
                orderBy: $orderBy
                skip: $skip
                take: $take
                searchTerm: $searchTerm
                filters: $filters
              ) {
                id
                name
                number
                email
                details
                createdAt
                updatedAt
                insuranceLimit
                insurancePercentage
                insuranceUnlimited
                approvalRequired
                createdBy {
                  id
                  name
                  __typename
                }
                updatedBy {
                  id
                  name
                  __typename
                }
                _count {
                  patients
                  payments
                  claimedPayments
                  unClaimedPayments
                  __typename
                }
                __typename
              }
            }
            """;

    public final String MUTATION_ADD_NEW_INSURANCE_COMPANY = """
            mutation ADD_NEW_INSURANCE_COMPANY($name: String!, $number: String, $email: String, $details: String, $insurancePercentage: Float, $insuranceLimit: Float, $insuranceUnlimited: Boolean, $approvalRequired: Boolean) {
              addNewInsuranceCompany(
                name: $name
                number: $number
                email: $email
                details: $details
                insuranceLimit: $insuranceLimit
                insurancePercentage: $insurancePercentage
                insuranceUnlimited: $insuranceUnlimited
                approvalRequired: $approvalRequired
              ) {
                id
                name
                number
                email
                details
                createdAt
                updatedAt
                insurancePercentage
                insuranceUnlimited
                insuranceLimit
                approvalRequired
                createdBy {
                  id
                  name
                  __typename
                }
                updatedBy {
                  id
                  name
                  __typename
                }
                __typename
              }
            }
            """;

    public final String Query_INSURANCE_COMPANY_DETAILS = """
            query INSURANCE_COMPANY_DETAILS($insuranceCompany: ID!) {
              insuranceCompanyDetails(insuranceCompany: $insuranceCompany) {
                id
                name
                number
                email
                details
                createdAt
                updatedAt
                insuranceLimit
                insurancePercentage
                insuranceUnlimited
                approvalRequired
                createdBy {
                  id
                  name
                  __typename
                }
                updatedBy {
                  id
                  name
                  __typename
                }
                __typename
              }
            }
            """;

    public final String MUTATION_EDIT_INSURANCE_COMPANY = """
            mutation EDIT_INSURANCE_COMPANY($insuranceCompany: ID!, $name: String!, $number: String, $email: String, $details: String, $insurancePercentage: Float, $insuranceLimit: Float, $insuranceUnlimited: Boolean, $approvalRequired: Boolean) {
              editInsuranceCompany(
                insuranceCompany: $insuranceCompany
                name: $name
                number: $number
                email: $email
                details: $details
                insuranceLimit: $insuranceLimit
                insurancePercentage: $insurancePercentage
                insuranceUnlimited: $insuranceUnlimited
                approvalRequired: $approvalRequired
              ) {
                id
                name
                number
                email
                details
                createdAt
                updatedAt
                insurancePercentage
                insuranceUnlimited
                insuranceLimit
                approvalRequired
                createdBy {
                  id
                  name
                  __typename
                }
                updatedBy {
                  id
                  name
                  __typename
                }
                __typename
              }
            }
            """;

    public final String MUTATION_DELETE_INSURANCE_COMPANY = """
            mutation DELETE_INSURANCE_COMPANY($insuranceCompany: ID!) {
              deleteInsuranceCompany(insuranceCompany: $insuranceCompany) {
                id
                __typename
              }
            }
            """;
}