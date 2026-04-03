package com.dentolize.settings.procedures.api;

public class ProceduresSchema {
    private static ProceduresSchema proceduresInstance;

    private ProceduresSchema() {
        // Private constructor to prevent instantiation
    }

    public static synchronized ProceduresSchema getInstance() {

        if (proceduresInstance == null) {
            proceduresInstance = new ProceduresSchema();
        }
        return proceduresInstance;
    }

    public final String MUTATION_ADD_PROCEDURE_GROUP = """
            mutation ADD_PROCEDURE_GROUP($name: String!, $order: Int!, $code: String!, $image: String) {
              addNewProcedureGroup(name: $name, order: $order, code: $code, image: $image) {
                id
                name
                order
                code
                image
                __typename
              }
            }
            """;

    public final String MUTATION_EDIT_PROCEDURE_GROUP = """
            mutation EDIT_PROCEDURE_GROUP($procedureGroup: ID!, $name: String!, $code: String!, $image: String) {
              editProcedureGroup(
                procedureGroup: $procedureGroup
                name: $name
                code: $code
                image: $image
              ) {
                id
                name
                order
                code
                image
                __typename
              }
            }
            """;

    public final String MUTATION_DELETE_PROCEDURE_GROUP = """
            mutation DELETE_PROCEDURE_GROUP($procedureGroup: ID!) {
              deleteProcedureGroup(procedureGroup: $procedureGroup) {
                id
                __typename
              }
            }
            """;

    public final String Query_GET_PROCEDURES = """
            query GET_PROCEDURES {
              procedures {
                id
                name
                order
                code
                image
                items {
                  id
                  name
                  code
                  order
                  defaultPrice
                  toothEffect
                  openLab
                  ageGroup
                  insuranceDiscount
                  cost
                  prices {
                    id
                    value
                    insuranceDiscount
                    parent {
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
                  __typename
                }
                __typename
              }
            }
            """;

    public final String MUTATION_SAVE_PROCEDURES = """
            mutation SAVE_PROCEDURES($procedures: [NewProcedureInput!]!, $priceList: ID, $childPriceList: ID) {
              saveProcedures(
                procedures: $procedures
                priceList: $priceList
                childPriceList: $childPriceList
              )
            }
            """;

    public final String MUTATION_DELETE_PROCEDURE = """
            mutation DELETE_PROCEDURE($procedure: ID!) {
              deleteProcedure(procedure: $procedure) {
                id
                __typename
              }
            }
            """;
}