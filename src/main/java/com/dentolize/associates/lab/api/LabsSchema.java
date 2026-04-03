package com.dentolize.associates.lab.api;

public class LabsSchema {
    private static LabsSchema labsInstance;

    private LabsSchema() {
        // Private constructor to prevent instantiation
    }

    public static synchronized LabsSchema getInstance() {
        if (labsInstance == null) {
            labsInstance = new LabsSchema();
        }
        return labsInstance;
    }

    public final String QUERY_TOTAL_LABS = """
            query TOTAL_LABS($searchTerm: String) {
              totalLabs(searchTerm: $searchTerm)
            }
            """;

    public final String QUERY_GET_LABS = """
            query GET_LABS($orderBy: String!, $skip: Int!, $take: Int!, $searchTerm: String) {
              labs(orderBy: $orderBy, skip: $skip, take: $take, searchTerm: $searchTerm) {
                id
                name
                number
                email
                details
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
                  claimedPayments
                  unClaimedPayments
                  orders
                  __typename
                }
                __typename
              }
            }
            """;

    public final String QUERY_SEARCH_LAB = """
            query SEARCH_LABS_QUERY($searchTerm: String!) {
              searchLabs(searchTerm: $searchTerm) {
                id
                name
                __typename
              }
            }
            """;

    public final String MUTATION_ADD_NEW_LAB = """
            mutation ADD_NEW_LAB($name: String!, $number: String, $email: String, $details: String) {
              addNewLab(name: $name, number: $number, email: $email, details: $details) {
                id
                name
                number
                email
                details
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
                __typename
              }
            }
            """;

    public final String MUTATION_LAB_DETAILS = """
            query LAB_DETAILS($lab: ID!) {
              labDetails(lab: $lab) {
                id
                name
                number
                email
                details
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
                __typename
              }
            }
            """;

    public final String MUTATION_EDIT_LAB = """
            mutation EDIT_LAB($lab: ID!, $name: String!, $number: String, $email: String, $details: String) {
              editLab(
                lab: $lab
                name: $name
                number: $number
                email: $email
                details: $details
              ) {
                id
                name
                number
                email
                details
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
                __typename
              }
            }
            """;

    public final String MUTATION_DELETE_LAB = """
            mutation DELETE_LAB($lab: ID!) {
              deleteLab(lab: $lab) {
                id
                __typename
              }
            }
            """;
}