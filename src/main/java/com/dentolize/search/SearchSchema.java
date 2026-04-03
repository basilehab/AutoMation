package com.dentolize.search;

public class SearchSchema {
    private static SearchSchema searchInstance;

    // Private constructor to prevent instantiation
    private SearchSchema() {
    }

    // Public method to provide access to the single instance
    public static synchronized SearchSchema getInstance() {
        if (searchInstance == null) {
            searchInstance = new SearchSchema();
        }
        return searchInstance;
    }

    public final String BRANCHES_QUERY_SEARCH = """
            query SEARCH_BRANCHES_QUERY($searchTerm: String!) {
              searchBranches(searchTerm: $searchTerm) {
                id
                name
                disabled
                __typename
              }
            }
            """;

    public final String QUERY_GET_USERS = """
            query GET_USERS($orderBy: String!, $skip: Int!, $take: Int!, $searchTerm: String, $rangeDate: [DateTime!]!, $id: ID) {
              users(
                orderBy: $orderBy
                skip: $skip
                take: $take
                searchTerm: $searchTerm
                rangeDate: $rangeDate
                company: $id
              ) {
                id
                email
                name
                username
                company {
                  id
                  companyName
                  __typename
                }
                group {
                  id
                  name
                  color
                  __typename
                }
                automatic
                automaticExpenses
                expensesFrom
                validated
                disabled
                dentalNotation
                doctorPercentage
                phoneNumber
                phoneNumber2
                hasValidNumber
                address
                isDoctor
                isOwner
                salary
                job
                images
                twoFactorAuth
                showAttendance
                requireScreenshot
                branches {
                  id
                  name
                  __typename
                }
                customFields {
                  id
                  value
                  field {
                    id
                    __typename
                  }
                  __typename
                }
                createdAt
                updatedAt
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
                  appointments
                  operations
                  deletedItems
                  patients
                  userSalaries
                  assignedInvoices
                  createdUsers
                  createdPatients
                  createdBranches
                  createdGroups
                  createdAppointments
                  createdInsurance
                  createdMedications
                  createdClinicalTests
                  createdMessages
                  createdEmails
                  createdInventories
                  createdInventoryTopUps
                  createdInventoryUsages
                  createdCommunications
                  createdPatientReminders
                  createdOperations
                  createdNotes
                  createdPayments
                  createdReminderInstances
                  createdPrescriptions
                  prescriptions
                  createdInvoices
                  createdMonthlyExpenses
                  createdExpenses
                  createdFiles
                  createdXrays
                  referrals
                  __typename
                }
                invoicesSum {
                  _sum {
                    paid
                    total
                    discount
                    diagnosticFee
                    __typename
                  }
                  __typename
                }
                operationsSum {
                  _sum {
                    total
                    __typename
                  }
                  __typename
                }
                paymentsSum {
                  _sum {
                    amount
                    __typename
                  }
                  __typename
                }
                __typename
              }
            }
            """;

    public final String USERS_QUERY_SEARCH = """
            query SEARCH_USERS_QUERY($searchTerm: String!) {
              searchUsers(searchTerm: $searchTerm) {
                id
                name
                phoneNumber
                isDoctor
                color
                disabled
                doctorPercentage
                expensesFrom
                 __typename
              }
            }
            """;

    public final String PRICE_LIST_QUERY_SEARCH = """
            query SEARCH_PRICE_LISTS_QUERY($searchTerm: String!) {
              searchPriceLists(searchTerm: $searchTerm) {
                id
                name
                syncTo
                percentage
                difference
                __typename
              }
            }
            """;

    public final String INSURANCE_QUERY_SEARCH = """
            query SEARCH_INSURANCE_QUERY($searchTerm: String!) {
              searchInsuranceCompanies(searchTerm: $searchTerm) {
                id
                name
                number
                insurancePercentage
                insuranceLimit
                insuranceUnlimited
                approvalRequired
                __typename
              }
            }
            """;

    public final String PATIENT_QUERY_SEARCH = """
            query SEARCH_PATIENT_QUERY($searchTerm: String!) {
              searchPatients(searchTerm: $searchTerm) {
                id
                firstName
                lastName
                title
                phoneNumber
                patientId
                referenceId
                insuranceCompany {
                  id
                  name
                  __typename
                }
                insuranceEndDate
                doctor {
                  id
                  name
                  __typename
                }
                __typename
              }
            }
            """;

    public final String PROCEDURES_QUERY_SEARCH = """
            query SEARCH_PROCEDURES($chart: ChartTypes, $searchTerm: String!){
              searchProcedures(chart: $chart, searchTerm: $searchTerm) {
                id
                name
                code
                active
                __typename
                group {
                  id
                  name
                  __typename
                }
              }
            }
            """;

    public final String QUERY_SEARCH_MASTER_INVENTORIES = """
            query SEARCH_MASTER_INVENTORIES_QUERY($searchTerm: String!, $location: String) {
              searchMasterInventories(searchTerm: $searchTerm, location: $location) {
                id
                name
                price
                images
                sku
                __typename
              }
            }
            """;

    public final String QUERY_SEARCH_INVENTORIES = """
            query SEARCH_INVENTORIES_QUERY($searchTerm: String!, $branchId: ID!, $room: String) {
              searchInventories(searchTerm: $searchTerm, branchId: $branchId, room: $room) {
                id
                name
                price
                images
                room
                sku
                __typename
              }
            }
            """;

    public final String LABS_QUERY_SEARCH = """
            query SEARCH_LABS_QUERY($searchTerm: String!) {
              searchLabs(searchTerm: $searchTerm) {
                id
                name
                __typename
              }
            }
            """;

    public final String LABS_ITEM_QUERY_SEARCH = """
            query SEARCH_LAB_ITEMS_QUERY($lab: ID!, $searchTerm: String!) {
              searchLabItems(lab: $lab, searchTerm: $searchTerm) {
                id
                name
                images
                price
                __typename
              }
            }
            """;

    public final String PROCEDURES_GROUP_QUERY_SEARCH = """
            query PROCEDURES($userId: ID, $orderBy: String!, $skip: Int!, $take: Int!, $rangeDate: [DateTime!]!, $filters: Filter, $searchTerm: String) {
              getProcedures(
                userId: $userId
                orderBy: $orderBy
                skip: $skip
                take: $take
                rangeDate: $rangeDate
                filters: $filters
                searchTerm: $searchTerm
              ) {
                id
                code
                name
                group {
                  id
                  name
                  __typename
                }
                toothEffect
                insuranceDiscount
                openLab
                ageGroup
                defaultPrice
                cost
                procedureUsage {
                  id
                  amount
                  inventory {
                    id
                    name
                    __typename
                  }
                  __typename
                }
                createdAt
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
                updatedAt
                _count {
                  operations
                  __typename
                }
                __typename
              }
            }
            """;

    public final String PERMISSION_GROUP_QUERY_SEARCH = """
            query SEARCH_GROUPS_QUERY($searchTerm: String!) {
              searchGroups(searchTerm: $searchTerm) {
                id
                name
                permissions
                color
                __typename
              }
            }
            """;
}