package com.dentolize.associates.suppliers.api;

public class SuppliersSchema {
    private static SuppliersSchema supplierInstance;

    private SuppliersSchema() {
        // Private constructor to prevent instantiation
    }

    public static synchronized SuppliersSchema getInstance() {
        if (supplierInstance == null) {
            supplierInstance = new SuppliersSchema();
        }
        return supplierInstance;
    }

    public final String QUERY_TOTAL_SUPPLIERS = """
            query TOTAL_SUPPLIERS($searchTerm: String) {
              totalSuppliers(searchTerm: $searchTerm)
            }
            """;
    public final String QUERY_GET_SUPPLIERS = """
            query GET_SUPPLIERS($orderBy: String!, $skip: Int!, $take: Int!, $searchTerm: String) {
              suppliers(orderBy: $orderBy, skip: $skip, take: $take, searchTerm: $searchTerm) {
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
                  expenses
                  __typename
                }
                __typename
              }
            }
            """;
    public final String MUTATION_ADD_NEW_SUPPLIER = """
            mutation ADD_NEW_SUPPLIER($name: String!, $number: String, $email: String, $details: String) {
              addNewSupplier(name: $name, number: $number, email: $email, details: $details) {
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
    public final String MUTATION_EDIT_SUPPLIER = """
            mutation EDIT_SUPPLIER($supplier: ID!, $name: String!, $number: String, $email: String, $details: String) {
              editSupplier(
                supplier: $supplier
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
    public final String MUTATION_DELETE_SUPPLIER = """
            mutation DELETE_SUPPLIER($supplier: ID!) {
              deleteSupplier(supplier: $supplier) {
                id
                __typename
              }
            }
            """;
}