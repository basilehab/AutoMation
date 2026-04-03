package com.dentolize.patients.invoice.api;

public class InvoiceSchema {
    private static InvoiceSchema invoiceSchema;

    private InvoiceSchema() {
    }

    public static InvoiceSchema getInstance() {
        if (invoiceSchema == null) {
            invoiceSchema = new InvoiceSchema();
        }
        return invoiceSchema;
    }

    /**
     * GraphQL mutation for creating a new invoice.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li>generatedID (ID!)</li>
     *   <li>pendingPaymentPercent (Float!)</li>
     *   <li>operations ([ID!]!)</li>
     *   <li>patient (ID!)</li>
     *   <li>branch (ID!)</li>
     *   <li>doctor (ID!)</li>
     *   <li>lineItems ([InvoiceLineItem!]!)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b></p>
     * <ul>
     *   <li>users ([ID])</li>
     *   <li>markAppointmentsCompleted (Boolean)</li>
     *   <li>createdAt (DateTime)</li>
     *   <li>sms (Boolean)</li>
     *   <li>invoiceId (String)</li>
     *   <li>details (String)</li>
     *   <li>referenceId (Float)</li>
     *   <li>treasury (ID)</li>
     *   <li>appointment (ID)</li>
     *   <li>patientPartAlertShown (Boolean)</li>
     *   <li>preAuth (String)</li>
     *   <li>patientTaxPercent (Float)</li>
     *   <li>insuranceTaxPercent (Float)</li>
     * </ul>
     */
    public final String CREATE_NEW_INVOICE_MUTATION = """
            mutation CREATE_NEW_INVOICE($generatedID: ID!, $pendingPaymentPercent: Float!, $operations: [ID!]!, $patient: ID!, $users: [ID], $markAppointmentsCompleted: Boolean, $createdAt: DateTime, $sms: Boolean, $branch: ID!, $doctor: ID!, $invoiceId: String, $details: String, $referenceId: Float, $treasury: ID, $appointment: ID, $lineItems: [InvoiceLineItem!]!, $patientPartAlertShown: Boolean, $preAuth: String, $patientTaxPercent: Float, $insuranceTaxPercent: Float) {
              createNewInvoice(
                generatedID: $generatedID
                pendingPaymentPercent: $pendingPaymentPercent
                operations: $operations
                patient: $patient
                users: $users
                markAppointmentsCompleted: $markAppointmentsCompleted
                createdAt: $createdAt
                sms: $sms
                branch: $branch
                doctor: $doctor
                invoiceId: $invoiceId
                details: $details
                referenceId: $referenceId
                treasury: $treasury
                appointment: $appointment
                lineItems: $lineItems
                patientPartAlertShown: $patientPartAlertShown
                preAuth: $preAuth
                patientTaxPercent: $patientTaxPercent
                insuranceTaxPercent: $insuranceTaxPercent
              ) {
                id
                total
                tax
                diagnosticFee
                discount
                subtotal
                pendingPayment
                taxPercent
                discountPercent
                insurance
                pendingPaymentPercent
                patientPart
                invoiceId
                referenceId
                preAuth
                details
                operationInsurance
                operations {
                  id
                  amount
                  tooth
                  price
                  child
                  status
                  approved
                  approvalRequired
                  toothPart
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
                    __typename
                  }
                  procedure {
                    id
                    name
                    code
                    insuranceDiscount
                    toothEffect
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
                  __typename
                }
                patient {
                  id
                  firstName
                  lastName
                  birthDate
                  balance
                  patientId
                  referenceId
                  phoneNumber
                  tags
                  insuranceCompany {
                    id
                    name
                    __typename
                  }
                  insuranceLimit
                  insuranceNumber
                  insuranceCRT
                  insuranceGroup
                  insurancePercentage
                  insuranceEndDate
                  insuranceUnlimited
                  insured
                  approvalRequired
                  firstPaymentDate
                  lastPaymentDate
                  dailyAmountPaid
                  insurancePaymentDate
                  dailyInsurancePaid
                  totalRemaining
                  totalInsurance
                  totalPaid
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
                branch {
                  id
                  name
                  __typename
                }
                doctor {
                  id
                  name
                  __typename
                }
                users {
                  id
                  name
                  __typename
                }
                released
                releasedAt
                releasedBy {
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

    /**
     * GraphQL mutation for editing an existing invoice.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li>invoice (ID!)</li>
     *   <li>pendingPaymentPercent (Float!)</li>
     *   <li>branch (ID!)</li>
     *   <li>doctor (ID!)</li>
     *   <li>lineItems ([InvoiceLineItem!]!)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b></p>
     * <ul>
     *   <li>users ([ID])</li>
     *   <li>createdAt (DateTime)</li>
     *   <li>invoiceId (String)</li>
     *   <li>details (String)</li>
     *   <li>treasury (ID)</li>
     *   <li>patientPartAlertShown (Boolean)</li>
     *   <li>preAuth (String)</li>
     *   <li>patientTaxPercent (Float)</li>
     *   <li>insuranceTaxPercent (Float)</li>
     * </ul>
     */
    public final String EDIT_INVOICE_MUTATION = """
            mutation EDIT_INVOICE($invoice: ID!, $pendingPaymentPercent: Float!, $users: [ID], $createdAt: DateTime, $branch: ID!, $doctor: ID!, $invoiceId: String, $details: String, $treasury: ID, $lineItems: [InvoiceLineItem!]!, $patientPartAlertShown: Boolean, $preAuth: String, $patientTaxPercent: Float, $insuranceTaxPercent: Float) {
              editInvoice(
                invoice: $invoice
                pendingPaymentPercent: $pendingPaymentPercent
                users: $users
                createdAt: $createdAt
                branch: $branch
                doctor: $doctor
                invoiceId: $invoiceId
                details: $details
                treasury: $treasury
                lineItems: $lineItems
                patientPartAlertShown: $patientPartAlertShown
                preAuth: $preAuth
                patientTaxPercent: $patientTaxPercent
                insuranceTaxPercent: $insuranceTaxPercent
              ) {
                id
                total
                tax
                diagnosticFee
                discount
                subtotal
                pendingPayment
                taxPercent
                discountPercent
                dfInsurance
                dfDiscount
                dfTax
                patientTaxPercent
                insuranceTaxPercent
                dfDiscountPercent
                dfInsurancePercent
                dfTaxApplied
                pendingPaymentPercent
                patientPart
                paid
                insurance
                invoiceId
                preAuth
                referenceId
                details
                operationInsurance
                patient {
                  id
                  firstName
                  lastName
                  birthDate
                  balance
                  patientId
                  referenceId
                  phoneNumber
                  insuranceCompany {
                    id
                    name
                    __typename
                  }
                  insuranceLimit
                  insurancePercentage
                  insuranceEndDate
                  insuranceUnlimited
                  insured
                  firstPaymentDate
                  lastPaymentDate
                  dailyAmountPaid
                  insurancePaymentDate
                  dailyInsurancePaid
                  totalRemaining
                  totalInsurance
                  totalPaid
                  __typename
                }
                operations {
                  id
                  name
                  code
                  amount
                  price
                  status
                  approved
                  discount
                  details
                  tax
                  discountPercent
                  approvalRequired
                  insuranceDiscount
                  insuranceValue
                  insurance
                  taxApplied
                  __typename
                }
                branch {
                  id
                  name
                  __typename
                }
                doctor {
                  id
                  name
                  __typename
                }
                users {
                  id
                  name
                  __typename
                }
                released
                releasedAt
                releasedBy {
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
    public final String INVOICE_DETAILS_QUERY = """
            query INVOICE_DETAILS($invoice: ID!, $token: String) {
              invoiceDetails(invoice: $invoice, token: $token) {
                id
                preAuth
                patientTaxPercent
                insuranceTaxPercent
                dfDiscountPercent
                dfInsurancePercent
                dfTaxApplied
                patientPart
                patient {
                  id
                  firstName
                  lastName
                  birthDate
                  balance
                  patientId
                  referenceId
                  phoneNumber
                  tags
                  title
                  insuranceNumber
                  insuranceGroup
                  insuranceCRT
                  referral
                  nationalId
                  nationality
                  referralDetails
                  insuranceCompany {
                    id
                    name
                    taxPercent
                    __typename
                  }
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
                  insuranceLimit
                  insurancePercentage
                  insuranceEndDate
                  insuranceUnlimited
                  approvalRequired
                  insured
                  dailyInsurancePaid
                  dailyAmountPaid
                  lastPaymentDate
                  maxInsuranceLimit
                  points {
                    id
                    remaining
                    firstToExpire
                    __typename
                  }
                  __typename
                }
                total
                tax
                dfDiscount
                dfInsurance
                dfTax
                chart
                taxPercent
                discount
                discountPercent
                diagnosticFee
                insurance
                subtotal
                pointsDiscount
                pointsValue
                pendingPayment
                pendingPaymentPercent
                paid
                invoiceId
                referenceId
                paidInFull
                details
                operationInsurance
                released
                releasedAt
                balanceInvoice
                signed
                signedAt
                signature
                insurancePolicy {
                  id
                  policyNumber
                  holderName
                  __typename
                }
                policyClass {
                  id
                  name
                  __typename
                }
                insuranceCompany {
                  id
                  name
                  __typename
                }
                salaryAdjustment {
                  id
                  __typename
                }
                signedBy {
                  id
                  name
                  __typename
                }
                releasedBy {
                  id
                  name
                  __typename
                }
                payments {
                  id
                  amount
                  type
                  other
                  claimed
                  details
                  refunded
                  refundedAt
                  signed
                  signedAt
                  signature
                  signedBy {
                    id
                    name
                    __typename
                  }
                  refundedBy {
                    id
                    name
                    __typename
                  }
                  insuranceCompany {
                    id
                    name
                    __typename
                  }
                  transaction {
                    treasury {
                      id
                      publicName
                      __typename
                    }
                    __typename
                  }
                  patientPointsTxs {
                    id
                    __typename
                  }
                  refPatientPointsTxs {
                    id
                    __typename
                  }
                  balance
                  createdAt
                  amount
                  images
                  branch {
                    id
                    name
                    __typename
                  }
                  doctor {
                    id
                    name
                    __typename
                  }
                  createdBy {
                    id
                    name
                    __typename
                  }
                  updatedAt
                  updatedBy {
                    id
                    name
                    __typename
                  }
                  __typename
                }
                operations {
                  id
                  name
                  code
                  amount
                  tooth
                  missing
                  price
                  child
                  status
                  approved
                  discountPercent
                  insurancePercent
                  discount
                  details
                  tax
                  taxApplied
                  initialDiscount
                  approvalRequired
                  insuranceDiscount
                  insuranceValue
                  insurance
                  toothPart
                  doctor {
                    id
                    name
                    medicalNumber
                    __typename
                  }
                  __typename
                }
                users {
                  id
                  name
                  __typename
                }
                branch {
                  id
                  name
                  __typename
                }
                doctor {
                  id
                  name
                  dentalNotation
                  medicalNumber
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
                eInvoiceIntegration {
                  id
                  status
                  __typename
                }
                __typename
              }
            }
            """;
}
