package com.dentolize.settings.branch.api;

public class BranchesSchema {
    public final static String QUERY_TOTAL_BRANCHES = """
            query TOTAL_BRANCHES($searchTerm: String, $id: ID) {
              totalBranches(searchTerm: $searchTerm, company: $id)
            }
            """;


    public final static String QUERY_GET_BRANCHES = """
            query GET_BRANCHES($orderBy: String!, $skip: Int!, $take: Int!, $searchTerm: String, $id: ID) {
              branches(
                orderBy: $orderBy
                skip: $skip
                take: $take
                searchTerm: $searchTerm
                company: $id
              ) {
                id
                name
                opens
                closes
                openDays
                viewClosedTimes
                rooms
                disabled
                address
                phones
                users {
                  id
                  name
                  isDoctor
                  group {
                    id
                    name
                    color
                    permissions
                    __typename
                  }
                  __typename
                }
                diagnosticFee
                defaultPriceList {
                  id
                  name
                  __typename
                }
                availablePriceLists {
                  id
                  name
                  __typename
                }
                updatedAt
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
                company {
                  id
                  disabled
                  companyName
                  __typename
                }
                _count {
                  appointments
                  operations
                  patients
                  invoices
                  availablePriceLists
                  __typename
                }
                __typename
              }
            }
            """;

    public final static String QUERY_BRANCH_DETAILS = """
            query BRANCH_DETAILS($branch: ID!, $token: String) {
                 branchDetails(branch: $branch, token: $token) {
                   id
                   name
                   opens
                   closes
                   openDays
                   viewClosedTimes
                   rooms
                   disabled
                   address
                   phones
                   users {
                     id
                     name
                     isDoctor
                     disabled
                     group {
                       id
                       name
                       color
                       permissions
                       __typename
                     }
                     __typename
                   }
                   diagnosticFee
                   defaultPriceList {
                     id
                     name
                     __typename
                   }
                   availablePriceLists {
                     id
                     name
                     __typename
                   }
                   prescriptionJsonForm
                   invoiceJsonForm
                   chartJsonForm
                   expensesJsonForm
                   updatedAt
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
                   __typename
                 }
               }
            """;
    public final static String MUTATION_ADD_NEW_BRANCH = """
                   mutation ADD_NEW_BRANCH($name: String!, $users: [ID!]!, $opens: [DateTime!]!, $closes: [DateTime!]!, $viewClosedTimes: Boolean!, $openDays: [Int!]!, $phones: [String!]!, $diagnosticFee: Float, $address: String!, $rooms: [String!]!, $defaultPriceList: ID, $availablePriceLists: [ID!]!, $branchTreasuries: [BranchTreasuryInput], $firstDay: Int) {
                       addNewBranch(
                         name: $name
                         users: $users
                         opens: $opens
                         closes: $closes
                         viewClosedTimes: $viewClosedTimes
                         openDays: $openDays
                         phones: $phones
                         diagnosticFee: $diagnosticFee
                         address: $address
                         rooms: $rooms
                         defaultPriceList: $defaultPriceList
                         availablePriceLists: $availablePriceLists
                         branchTreasuries: $branchTreasuries
                         firstDay: $firstDay
                       ) {
                         id
                         name
                         opens
                         closes
                         openDays
                         viewClosedTimes
                         rooms
                         disabled
                         diagnosticFee
                         address
                         phones
                         firstDay
                         branchTreasuries {
                           id
                           type
                           defaultTreasury {
                             id
                             name
                             __typename
                           }
                           availableTreasuries {
                             id
                             name
                             __typename
                           }
                           allowPending
                           __typename
                         }
                         users {
                           id
                           name
                           group {
                             id
                             name
                             color
                             __typename
                           }
                           __typename
                         }
                         defaultPriceList {
                           id
                           name
                           __typename
                         }
                         availablePriceLists {
                           id
                           name
                           __typename
                         }
                         updatedAt
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
                         __typename
                       }
                     }
            """;


    public final static String MUTATION_EDIT_BRANCH = """
            mutation EDIT_BRANCH($name: String!, $users: [ID!]!, $opens: [DateTime!]!, $closes: [DateTime!]!, $viewClosedTimes: Boolean!, $openDays: [Int!]!, $branch: ID!, $phones: [String!]!, $diagnosticFee: Float, $address: String!, $rooms: [String!]!, $defaultPriceList: ID, $availablePriceLists: [ID!]!, $branchTreasuries: [BranchTreasuryInput], $firstDay: Int) {
               editBranch(
                 branch: $branch
                 name: $name
                 users: $users
                 opens: $opens
                 closes: $closes
                 viewClosedTimes: $viewClosedTimes
                 openDays: $openDays
                 phones: $phones
                 diagnosticFee: $diagnosticFee
                 address: $address
                 rooms: $rooms
                 defaultPriceList: $defaultPriceList
                 availablePriceLists: $availablePriceLists
                 branchTreasuries: $branchTreasuries
                 firstDay: $firstDay
               ) {
                 id
                 name
                 opens
                 closes
                 openDays
                 viewClosedTimes
                 rooms
                 disabled
                 diagnosticFee
                 address
                 phones
                 firstDay
                 branchTreasuries {
                   id
                   type
                   defaultTreasury {
                     id
                     name
                     __typename
                   }
                   availableTreasuries {
                     id
                     name
                     __typename
                   }
                   allowPending
                   __typename
                 }
                 users {
                   id
                   name
                   group {
                     id
                     name
                     color
                     __typename
                   }
                   __typename
                 }
                 defaultPriceList {
                   id
                   name
                   __typename
                 }
                 availablePriceLists {
                   id
                   name
                   __typename
                 }
                 updatedAt
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
                 __typename
               }
             }
            """;


    public final static String MUTATION_DISABLE_BRANCH = """
            mutation DISABLE_BRANCH($branch: ID!, $disabled: Boolean!) {
              disableBranch(branch: $branch, disabled: $disabled) {
                id
                disabled
                __typename
              }
            }
            """;


}
