package com.dentolize.patients.operation.api;

public class OperationStepsSchema {
    private static OperationStepsSchema operationStepsSchema;

    private OperationStepsSchema() {
    }

    public static OperationStepsSchema getInstance() {
        if (operationStepsSchema == null) {
            operationStepsSchema = new OperationStepsSchema();
        }
        return operationStepsSchema;
    }

    /**
     * GraphQL query to fetch created operation steps.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li><code>orderBy</code> (String!)</li>
     *   <li><code>skip</code> (Int!)</li>
     *   <li><code>take</code> (Int!)</li>
     *   <li><code>rangeDate</code> ([DateTime!]!)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b></p>
     * <ul>
     *   <li><code>branchId</code> (ID)</li>
     *   <li><code>userId</code> (ID)</li>
     *   <li><code>doctor</code> (ID)</li>
     *   <li><code>patient</code> (ID)</li>
     *   <li><code>insuranceCompanies</code> ([ID])</li>
     *   <li><code>insurancePolicy</code> (ID)</li>
     *   <li><code>filters</code> (Filter)</li>
     *   <li><code>appointment</code> (ID)</li>
     *   <li><code>searchTerm</code> (String)</li>
     *   <li><code>priceList</code> (ID)</li>
     *   <li><code>operation</code> (ID)</li>
     *   <li><code>chart</code> (ChartTypes)</li>
     *   <li><code>procedure</code> (ID)</li>
     *   <li><code>procedureGroup</code> (ID)</li>
     * </ul>
     */
    public final String CREATED_OPERATION_STEPS_QUERY = """
            query CREATED_OPERATION_STEPS($branchId: ID, $userId: ID, $orderBy: String!, $skip: Int!, $take: Int!, $doctor: ID, $patient: ID, $rangeDate: [DateTime!]!, $insuranceCompanies: [ID], $insurancePolicy: ID, $filters: Filter, $appointment: ID, $searchTerm: String, $priceList: ID, $operation: ID, $chart: ChartTypes, $procedure: ID, $procedureGroup: ID) {
              createdOperationSteps(
                branchId: $branchId
                userId: $userId
                orderBy: $orderBy
                skip: $skip
                take: $take
                doctor: $doctor
                patient: $patient
                rangeDate: $rangeDate
                filters: $filters
                insuranceCompanies: $insuranceCompanies
                insurancePolicy: $insurancePolicy
                appointment: $appointment
                searchTerm: $searchTerm
                priceList: $priceList
                operation: $operation
                chart: $chart
                procedure: $procedure
                procedureGroup: $procedureGroup
              ) {
                id
                name
                status
                details
                end
                start
                paidAt
                order
                total
                paid
                chart
                paidInFull
                actionsCreated
                forOperator
                forLab
                discount
                tax
                package
                operation {
                  id
                  name
                  code
                  invoice {
                    id
                    __typename
                  }
                  __typename
                }
                salaryAdjustment {
                  id
                  __typename
                }
                procedure {
                  id
                  name
                  __typename
                }
                patient {
                  id
                  firstName
                  lastName
                  tags
                  phoneNumber
                  title
                  patientId
                  referenceId
                  referral
                  referralDetails
                  __typename
                }
                appointment {
                  id
                  start
                  status
                  room
                  __typename
                }
                doctor {
                  id
                  name
                  __typename
                }
                branch {
                  id
                  name
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
    public final String OPERATION_STEP_DETAILS = """
            query OPERATION_STEP_DETAILS($operationStep: ID!) {
              operationStepDetails(operationStep: $operationStep) {
                id
                name
                details
                end
                start
                paidAt
                total
                paid
                paidInFull
                actionsCreated
                forOperator
                forLab
                discount
                tax
                isAutomatic
                status
                package
                salaryAdjustment {
                  id
                  __typename
                }
                operation {
                  id
                  name
                  code
                  tooth
                  child
                  actionsCreated
                  invoice {
                    id
                    __typename
                  }
                  __typename
                }
                patient {
                  id
                  firstName
                  lastName
                  tags
                  phoneNumber
                  title
                  patientId
                  referenceId
                  referral
                  referralDetails
                  __typename
                }
                procedureStep {
                  id
                  createForm
                  createLabOrder
                  createPrescription
                  freeForms {
                    id
                    name
                    signRequired
                    __typename
                  }
                  labItems {
                    id
                    name
                    __typename
                  }
                  prescriptions {
                    id
                    name
                    __typename
                  }
                  __typename
                }
                formInstances {
                  id
                  name
                  signed
                  signRequired
                  __typename
                }
                appointment {
                  id
                  start
                  status
                  room
                  __typename
                }
                doctor {
                  id
                  name
                  __typename
                }
                branch {
                  id
                  name
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


    /**
     * GraphQL mutation to edit an operation step.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li><code>operationStep</code> (ID!)</li>
     *   <li><code>branch</code> (ID!)</li>
     *   <li><code>forOperator</code> (Float!)</li>
     *   <li><code>forLab</code> (Float!)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b></p>
     * <ul>
     *   <li><code>details</code> (String)</li>
     *   <li><code>appointment</code> (ID)</li>
     *   <li><code>doctor</code> (ID)</li>
     *   <li><code>createdAt</code> (DateTime)</li>
     *   <li><code>start</code> (DateTime)</li>
     *   <li><code>end</code> (DateTime)</li>
     *   <li><code>status</code> (OperationStatusType)</li>
     * </ul>
     */
    public final String EDIT_OPERATION_STEP_MUTATION = """
            mutation EDIT_OPERATION_STEP($operationStep: ID!, $details: String, $appointment: ID, $doctor: ID, $branch: ID!, $forOperator: Float!, $forLab: Float!, $createdAt: DateTime, $start: DateTime, $end: DateTime, $status: OperationStatusType) {
              editOperationStep(
                operationStep: $operationStep
                details: $details
                appointment: $appointment
                doctor: $doctor
                branch: $branch
                forOperator: $forOperator
                forLab: $forLab
                createdAt: $createdAt
                start: $start
                end: $end
                status: $status
              ) {
                id
                details
                status
                forOperator
                forLab
                discount
                start
                end
                appointment {
                  id
                  status
                  start
                  __typename
                }
                doctor {
                  id
                  name
                  __typename
                }
                branch {
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
                createdAt
                __typename
              }
            }
            """;
}
