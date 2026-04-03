package com.dentolize.settings.monthlyExpenses.api;

public class MonthlyExpensesSchema {
    public final static String QUERY_TOTAL_MONTHLY_EXPENSES = """
            query TOTAL_MONTHLY_EXPENSES($searchTerm: String, $filters: Filter) {
              totalMonthlyExpenses(searchTerm: $searchTerm, filters: $filters)
            }
            """;
    public final static String QUERY_GET_MONTHLY_EXPENSES = """
            query GET_MONTHLY_EXPENSES($orderBy: String!, $skip: Int!, $take: Int!, $searchTerm: String, $filters: Filter) {
              monthlyExpenses(
                orderBy: $orderBy
                skip: $skip
                take: $take
                searchTerm: $searchTerm
                filters: $filters
              ) {
                id
                name
                type
                details
                amount
                other
                automatic
                branch {
                  id
                  name
                  __typename
                }
                user {
                  id
                  name
                  group {
                    id
                    color
                    __typename
                  }
                  __typename
                }
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
                createdAt
                updatedAt
                __typename
              }
            }
            """;


    public final static String MUTATION_ADD_NEW_MONTHLY_EXPENSE = """
            mutation ADD_NEW_MONTHLY_EXPENSE($name: String, $details: String, $type: ExpenseType!, $amount: Float!, $user: ID, $branch: ID!, $other: String, $automatic: Boolean) {
              addNewMonthlyExpense(
                name: $name
                details: $details
                type: $type
                amount: $amount
                user: $user
                branch: $branch
                other: $other
                automatic: $automatic
              ) {
                id
                name
                type
                details
                amount
                other
                automatic
                branch {
                  id
                  name
                  __typename
                }
                user {
                  id
                  name
                  group {
                    id
                    color
                    __typename
                  }
                  __typename
                }
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
                createdAt
                updatedAt
                __typename
              }
            }
            """;

    public final static String MUTATION_EDIT_MONTHLY_EXPENSE = """
            mutation EDIT_MONTHLY_EXPENSE($monthlyExpense: ID!, $name: String, $details: String, $type: ExpenseType!, $amount: Float!, $user: ID, $branch: ID!, $other: String, $automatic: Boolean) {
              editMonthlyExpense(
                monthlyExpense: $monthlyExpense
                name: $name
                details: $details
                type: $type
                amount: $amount
                user: $user
                branch: $branch
                other: $other
                automatic: $automatic
              ) {
                id
                name
                type
                details
                amount
                other
                automatic
                branch {
                  id
                  name
                  __typename
                }
                user {
                  id
                  name
                  group {
                    id
                    color
                    __typename
                  }
                  __typename
                }
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
                createdAt
                updatedAt
                __typename
              }
            }
            """;
    public final static String MUTATION_DELETE_MONTHLY_EXPENSE = """
            mutation DELETE_MONTHLY_EXPENSE($monthlyExpense: ID!) {
              deleteMonthlyExpense(monthlyExpense: $monthlyExpense) {
                id
                __typename
              }
            }
            """;

}
