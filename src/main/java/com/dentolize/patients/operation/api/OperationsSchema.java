package com.dentolize.patients.operation.api;

import com.dentolize.patients.appointments.api.AppointmentsSchema;

public class OperationsSchema {
    private static OperationsSchema operationInstance;

    private OperationsSchema() {
    }

    public static synchronized OperationsSchema getInstance() {
        if (operationInstance == null) {
            operationInstance = new OperationsSchema();
        }
        return operationInstance;
    }

    /**
     * GraphQL mutation for creating new operations.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li>generatedID (String!)</li>
     *   <li>status (OperationStatusType!)</li>
     *   <li>tooth ([Int!]!)</li>
     *   <li>patient (String!)</li>
     *   <li>doctor (String!)</li>
     *   <li>branch (String!)</li>
     *   <li>child (Boolean!)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b></p>
     * <ul>
     *   <li>name (String)</li>
     *   <li>code (String)</li>
     *   <li>price (Float)</li>
     *   <li>cost (Float)</li>
     *   <li>procedure (String)</li>
     *   <li>condition (String)</li>
     *   <li>toothPart ([String])</li>
     *   <li>appointment (String)</li>
     *   <li>priceList (String)</li>
     *   <li>insuranceDiscount (Boolean)</li>
     *   <li>insuranceValue (Int)</li>
     *   <li>details (String)</li>
     *   <li>productPriceId (String)</li>
     *   <li>sms (Boolean)</li>
     *   <li>createItems (Boolean)</li>
     *   <li>counter (ID)</li>
     *   <li>globalCondition (ID)</li>
     *   <li>manualPrice (Boolean)</li>
     *   <li>chart (ChartTypes)</li>
     * </ul>
     */
    public final String CREATE_NEW_OPERATIONS_MUTATION = """
            mutation CREATE_NEW_OPERATIONS($generatedID: String!, $name: String, $code: String, $price: Float, $cost: Float, $status: OperationStatusType!, $procedure: String, $condition: String, $tooth: [Int!]!, $toothPart: [String], $appointment: String, $patient: String!, $doctor: String!, $branch: String!, $priceList: String, $child: Boolean!, $insuranceDiscount: Boolean, $insuranceValue: Int, $details: String, $productPriceId: String, $sms: Boolean, $createItems: Boolean, $counter: ID, $globalCondition: ID, $manualPrice: Boolean, $chart: ChartTypes) {
              createNewOperations(
                generatedID: $generatedID
                name: $name
                code: $code
                price: $price
                cost: $cost
                status: $status
                procedure: $procedure
                condition: $condition
                tooth: $tooth
                toothPart: $toothPart
                appointment: $appointment
                patient: $patient
                doctor: $doctor
                branch: $branch
                priceList: $priceList
                child: $child
                insuranceDiscount: $insuranceDiscount
                insuranceValue: $insuranceValue
                details: $details
                productPriceId: $productPriceId
                sms: $sms
                createItems: $createItems
                counter: $counter
                globalCondition: $globalCondition
                manualPrice: $manualPrice
                chart: $chart
              ) {
                id
                amount
                tooth
                toothPart
                price
                cost
                forOperator
                child
                status
                approved
                approvalRequired
                insuranceDiscount
                insuranceValue
                start
                end
                details
                initialDiscount
                taxApplied
                actionsCreated
                name
                code
                missing
                remaining
                actionsCreated
                hasSteps
                expires
                priceList {
                  id
                  name
                  syncTo
                  __typename
                }
                procedure {
                  id
                  name
                  code
                  insuranceDiscount
                  toothEffect
                  ageGroup
                  requireCounter
                  openLab
                  __typename
                }
                condition {
                  id
                  name
                  code
                  toothEffect
                  __typename
                }
                doctor {
                  id
                  name
                  __typename
                }
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
                patient {
                  id
                  firstName
                  lastName
                  patientId
                  referenceId
                  phoneNumber
                  insuranceLimit
                  insurancePercentage
                  insuranceEndDate
                  insuranceUnlimited
                  maxInsuranceLimit
                  dailyInsurancePaid
                  lastPaymentDate
                  dailyAmountPaid
                  approvalRequired
                  policyClass {
                    id
                    name
                    maxLimit
                    insuranceLimit
                    insuranceUnlimited
                    insurancePercentage
                    approvalRequired
                    __typename
                  }
                  insured
                  tax
                  insuranceCompany {
                    id
                    name
                    number
                    __typename
                  }
                  __typename
                }
                inventoryTransactions {
                  id
                  amount
                  patientId
                  appointmentId
                  operationId
                  operationStepId
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
                  status
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
                  __typename
                }
                insuranceCompany {
                  id
                  name
                  __typename
                }
                appointment {
                  id
                  status
                  urgent
                  start
                  end
                  title
                  details
                  alert
                  room
                  diagnosticFee
                  type
                  createdAt
                  diagnosticFeeInvoice {
                    id
                    diagnosticFee
                    __typename
                  }
                  createdBy {
                    id
                    name
                    __typename
                  }
                  doctor {
                    id
                    name
                    __typename
                  }
                  __typename
                }
                quotations {
                  id
                  __typename
                }
                branch {
                  id
                  name
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
            }
            """;
    public final String OPERATION_DETAILS_QUERY = """
            query OPERATION_DETAILS($operation: ID!) {
              operationDetails(operation: $operation) {
                id
                name
                code
                price
                status
                total
                child
                updated
                cost
                forOperator
                completedPercent
                paid
                tax
                discount
                paidInFull
                paidAt
                end
                start
                approved
                approvalRequired
                details
                actionsCreated
                paid
                remaining
                remainingCost
                paidInFull
                chart
                expires
                insuranceCompany {
                  id
                  name
                  __typename
                }
                insurancePolicy {
                  id
                  holderName
                  policyNumber
                  __typename
                }
                steps {
                  id
                  name
                  status
                  isAutomatic
                  details
                  order
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
                  mixedDentition
                  __typename
                }
                procedure {
                  id
                  name
                  code
                  __typename
                }
                condition {
                  id
                  name
                  code
                  __typename
                }
                tooth
                missing
                toothPart
                amount
                invoice {
                  id
                  paid
                  subtotal
                  paidInFull
                  pendingPayment
                  discount
                  tax
                  diagnosticFee
                  insurance
                  total
                  taxPercent
                  discountPercent
                  pendingPaymentPercent
                  details
                  invoiceId
                  referenceId
                  eInvoiceIntegration {
                    id
                    status
                    __typename
                  }
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
                priceList {
                  id
                  name
                  syncTo
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
         * GraphQL mutation for editing an operation without invoice.
         *
         * <p><b>Required variables:</b></p>
         * <ul>
         *   <li>operation (ID!)</li>
         *   <li>cost (Float!)</li>
         *   <li>tooth ([Int!]!)</li>
         *   <li>branch (ID!)</li>
         *   <li>forOperator (Float!)</li>
         *   <li>child (Boolean!)</li>
         * </ul>
         *
         * <p><b>Optional variables:</b></p>
         * <ul>
         *   <li>details (String)</li>
         *   <li>appointment (ID)</li>
         *   <li>doctor (ID)</li>
         *   <li>createdAt (DateTime)</li>
         *   <li>status (OperationStatusType)</li>
         *   <li>expires (DateTime)</li>
         *   <li>start (DateTime)</li>
         *   <li>end (DateTime)</li>
         * </ul>
         */
        public final String EDIT_NEW_OPERATIONS_MUTATION = """
            mutation EDIT_OPERATION_WITHOUT_INVOICE($operation: ID!, $details: String, $cost: Float!, $tooth: [Int!]!, $appointment: ID, $doctor: ID, $branch: ID!, $forOperator: Float!, $createdAt: DateTime, $child: Boolean!, $status: OperationStatusType, $expires: DateTime, $start: DateTime, $end: DateTime) {
              editOperationWithoutInvoice(
                operation: $operation
                details: $details
                cost: $cost
                tooth: $tooth
                appointment: $appointment
                doctor: $doctor
                branch: $branch
                forOperator: $forOperator
                createdAt: $createdAt
                child: $child
                status: $status
                expires: $expires
                start: $start
                end: $end
              ) {
                id
                name
                code
                details
                cost
                status
                forOperator
                child
                expires
                start
                end
                procedure {
                  id
                  name
                  __typename
                }
                condition {
                  id
                  name
                  __typename
                }
                tooth
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
                createdAt
                __typename
              }
            }
            """;
    public final String DELETE_OPERATIONS_MUTATION = """
            mutation DELETE_OPERATIONS($operations: [ID!]!) {
              deleteOperations(operations: $operations)
            }
            """;

    public final String GET_PATIENT_OPERATIONS_QUERY = """
            query GET_PATIENT_OPERATIONS($patient: ID!, $chart: ChartTypes) {
              getPatientOperations(patient: $patient, chart: $chart) {
                id
                name
                code
                price
                status
                child
                approved
                cost
                start
                end
                forOperator
                details
                remaining
                actionsCreated
                hasSteps
                taxApplied
                initialDiscount
                priceList {
                  id
                  name
                  syncTo
                  __typename
                }
                approvalRequired
                insuranceDiscount
                insuranceValue
                expires
                insuranceCompany {
                  id
                  name
                  __typename
                }
                procedure {
                  id
                  name
                  code
                  toothEffect
                  insuranceDiscount
                  openLab
                  ageGroup
                  requireCounter
                  __typename
                }
                condition {
                  id
                  name
                  code
                  toothEffect
                  __typename
                }
                tooth
                missing
                toothPart
                amount
                appointment {
                  id
                  status
                  start
                  diagnosticFee
                  createdBy {
                    id
                    name
                    __typename
                  }
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
                invoice {
                  id
                  paid
                  subtotal
                  paidInFull
                  pendingPayment
                  discount
                  tax
                  invoiceId
                  referenceId
                  diagnosticFee
                  insurance
                  total
                  taxPercent
                  discountPercent
                  pendingPaymentPercent
                  balance
                  details
                  eInvoiceIntegration {
                    id
                    status
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
                __typename
              }
            }
            """;
}
