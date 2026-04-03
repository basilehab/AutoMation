package com.dentolize.patients.operation.api;

public class OperationsActionsSchema {
    private static OperationsActionsSchema operationsActionsSchema;

    private OperationsActionsSchema() {
    }

    public static OperationsActionsSchema getInstance() {
        if (operationsActionsSchema == null) {
            operationsActionsSchema = new OperationsActionsSchema();
        }
        return operationsActionsSchema;
    }

    /**
     * GraphQL mutation for updating the status of operations.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li><b>operations</b> ([ID!]!) - List of operation IDs to update (required)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b></p>
     * <ul>
     *   <li>status (OperationStatusType) - New status for the operations</li>
     *   <li>appointment (ID) - Associated appointment ID</li>
     *   <li>approved (Boolean) - Approval status</li>
     *   <li>createdAt (DateTime) - Creation date</li>
     *   <li>doctor (ID) - Doctor ID</li>
     *   <li>sms (Boolean) - Whether to send SMS</li>
     *   <li>createItems (Boolean) - Whether to create items</li>
     * </ul>
     */
    public final String UPDATE_OPERATIONS_STATUS_MUTATION = """
            mutation UPDATE_OPERATIONS_STATUS($status: OperationStatusType, $operations: [ID!]!, $appointment: ID, $approved: Boolean, $createdAt: DateTime, $doctor: ID, $sms: Boolean, $createItems: Boolean) {
              updateOperationsStatus(
                status: $status
                operations: $operations
                appointment: $appointment
                approved: $approved
                createdAt: $createdAt
                doctor: $doctor
                sms: $sms
                createItems: $createItems
              ) {
                id
                start
                end
                status
                approved
                tooth
                actionsCreated
                labOrders {
                  id
                  name
                  createdAt
                  __typename
                }
                formInstances {
                  id
                  name
                  createdAt
                  __typename
                }
                prescriptions {
                  id
                  name
                  createdAt
                  __typename
                }
                procedure {
                  id
                  openLab
                  __typename
                }
                patient {
                  id
                  __typename
                }
                appointment {
                  id
                  start
                  status
                  createdBy {
                    id
                    name
                    __typename
                  }
                  __typename
                }
                inventoryTransactions {
                  id
                  amount
                  operationId
                  operationStepId
                  patientId
                  appointmentId
                  inventoryItem {
                    id
                    name
                    images
                    defaultSubItem {
                      id
                      name
                      price
                      box
                      images
                      __typename
                    }
                    __typename
                  }
                  __typename
                }
                steps {
                  id
                  name
                  order
                  status
                  __typename
                }
                updatedBy {
                  id
                  name
                  __typename
                }
                doctor {
                  id
                  name
                  __typename
                }
                updatedAt
                createdAt
                __typename
              }
            }
            """;

    public final String EDIT_OPERATION_MUTATION = """
            mutation EDIT_OPERATION($operation: ID!, $details: String) {
              editOperation(operation: $operation, details: $details) {
                id
                details
                __typename
              }
            }
            """;
    /**
     * GraphQL mutation for updating the price and amount of operations.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li><b>operations</b> ([EditOperationsInput]) - List of operations to update (required)</li>
     * </ul>
     */
    public final String UPDATE_OPERATION_PRICE_AMOUNT_MUTATION = """
            mutation SAVE_OPERATIONS($operations: [EditOperationsInput]) {
              saveOperations(operations: $operations) {
                id
                price
                amount
                remaining
                updatedBy {
                  id
                  name
                  __typename
                }
                updatedAt
                __typename
              }
            }
            """;
    public final String UNGROUP_OPERATIONS_MUTATION = """
            mutation UNGROUP_OPERATION($operation: ID!) {
              ungroupOperation(operation: $operation)
            }
            """;
}
