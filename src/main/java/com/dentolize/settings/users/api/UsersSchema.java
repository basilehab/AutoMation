package com.dentolize.settings.users.api;

public class UsersSchema {
    private static UsersSchema userInstance;

    private UsersSchema() {
        // Private constructor to prevent instantiation
    }

    public static synchronized UsersSchema getInstance() {
        if (userInstance == null) {
            userInstance = new UsersSchema();
        }
        return userInstance;
    }

    public final String QUERY_TOTAL_USERS = """
            query TOTAL_USERS($searchTerm: String, $id: ID) {
              totalUsers(searchTerm: $searchTerm, company: $id)
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

    public final String MUTATION_ADD_NEW_USER = """
            mutation ADD_NEW_USER($name: String!, $email: String, $username: String, $password: String, $phoneNumber: String, $phoneNumber2: String, $group: ID!, $address: String, $branches: [ID!]!, $isDoctor: Boolean!, $customFields: [CustomFieldInput!]!, $currentPassword: String, $dentalNotation: DentalNotationType, $salary: Float, $job: String, $doctorPercentage: Float, $automatic: Boolean, $showAttendance: Boolean, $requireScreenshot: Boolean, $automaticExpenses: Boolean, $expensesFrom: String, $images: [String]) {
              addNewUser(
                name: $name
                email: $email
                username: $username
                password: $password
                phoneNumber: $phoneNumber
                phoneNumber2: $phoneNumber2
                group: $group
                address: $address
                branches: $branches
                isDoctor: $isDoctor
                showAttendance: $showAttendance
                requireScreenshot: $requireScreenshot
                customFields: $customFields
                currentPassword: $currentPassword
                dentalNotation: $dentalNotation
                salary: $salary
                job: $job
                doctorPercentage: $doctorPercentage
                automatic: $automatic
                automaticExpenses: $automaticExpenses
                expensesFrom: $expensesFrom
                images: $images
              ) {
                id
                email
                name
                username
                group {
                  id
                  name
                  color
                  __typename
                }
                disabled
                phoneNumber
                phoneNumber2
                hasValidNumber
                dentalNotation
                doctorPercentage
                address
                isDoctor
                showAttendance
                requireScreenshot
                isOwner
                salary
                job
                automatic
                automaticExpenses
                expensesFrom
                images
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
                __typename
              }
            }
            """;

    public final String QUERY_CURRENT_USER = """
            query CURRENT_USER_QUERY {
              me {
                id
                email
                username
                name
                phoneNumber
                hasValidNumber
                twoFactorAuth
                language
                isDoctor
                showAttendance
                requireScreenshot
                isOwner
                showOverdue
                dentalNotation
                doctorPercentage
                automatic
                automaticExpenses
                autoAppointmentStatus
                expensesFrom
                images
                alertSettings {
                  id
                  inventory
                  masterInventory
                  invoice
                  reminder
                  appointmentQrCode
                  pendingPatients
                  onlineAppointment
                  orders
                  operations
                  calendar
                  __typename
                }
                group {
                  id
                  permissions
                  __typename
                }
                branches {
                  id
                  name
                  diagnosticFee
                  disabled
                  __typename
                }
                assignedInvoices {
                  id
                  __typename
                }
                company {
                  id
                  companyName
                  companyLoginName
                  tierExpiry
                  country
                  currency
                  code
                  timeZone
                  messagesLeft
                  messagesLimit
                  sizeLeft
                  sizeLimit
                  companyLogo
                  tax
                  requiredToPay
                  allowPrescriptionQR
                  allowInvoiceQR
                  allowChartQR
                  confirmInventory
                  askBeforeSms
                  referralSources
                  patientTags
                  maxUsers
                  maxBranches
                  subscriptionPrice
                  whatsappEnabled
                  analyticsEnabled
                  inventoryEnabled
                  mobileAppEnabled
                  inventoryLocations
                  alertBeforeInventory
                  alertBeforeMaster
                  branches {
                    id
                    __typename
                  }
                  users {
                    id
                    __typename
                  }
                  __typename
                }
                __typename
              }
            }
            """;


    public final String MUTATION_EDIT_USER = """
            mutation EDIT_USER($user: ID!, $name: String!, $email: String, $username: String, $password: String, $phoneNumber: String, $phoneNumber2: String, $group: ID!, $address: String, $branches: [ID!]!, $isDoctor: Boolean!, $customFields: [CustomFieldInput!]!, $currentPassword: String, $salary: Float, $job: String, $dentalNotation: DentalNotationType, $doctorPercentage: Float, $automatic: Boolean, $showAttendance: Boolean, $requireScreenshot: Boolean, $automaticExpenses: Boolean, $expensesFrom: String, $images: [String]) {
              editUser(
                user: $user
                name: $name
                email: $email
                username: $username
                password: $password
                phoneNumber: $phoneNumber
                phoneNumber2: $phoneNumber2
                group: $group
                address: $address
                branches: $branches
                isDoctor: $isDoctor
                customFields: $customFields
                currentPassword: $currentPassword
                salary: $salary
                dentalNotation: $dentalNotation
                job: $job
                doctorPercentage: $doctorPercentage
                automatic: $automatic
                showAttendance: $showAttendance
                requireScreenshot: $requireScreenshot
                automaticExpenses: $automaticExpenses
                expensesFrom: $expensesFrom
                images: $images
              ) {
                id
                email
                name
                username
                group {
                  id
                  name
                  color
                  __typename
                }
                disabled
                phoneNumber
                phoneNumber2
                hasValidNumber
                dentalNotation
                doctorPercentage
                address
                isDoctor
                showAttendance
                requireScreenshot
                isOwner
                salary
                job
                automatic
                automaticExpenses
                expensesFrom
                images
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
                __typename
              }
            }
            """;
    public final String MUTATION_UPDATE_USER = """
            mutation ($name: String!, $phoneNumber: String, $language: String!, $isDoctor: Boolean, $showOverdue: Boolean!, $doctorPercentage: Float, $dentalNotation: DentalNotationType!, $alertSettings: AlertSettingsInput!, $autoAppointmentStatus: [AppointmentStatus!]!, $automatic: Boolean, $showAttendance: Boolean, $requireScreenshot: Boolean, $automaticExpenses: Boolean, $expensesFrom: String, $images: [String]) {
              updateUserDetails(
                name: $name
                phoneNumber: $phoneNumber
                language: $language
                isDoctor: $isDoctor
                showOverdue: $showOverdue
                dentalNotation: $dentalNotation
                alertSettings: $alertSettings
                doctorPercentage: $doctorPercentage
                autoAppointmentStatus: $autoAppointmentStatus
                automatic: $automatic
                showAttendance: $showAttendance
                requireScreenshot: $requireScreenshot
                automaticExpenses: $automaticExpenses
                expensesFrom: $expensesFrom
                images: $images
              ) {
                id
                name
                phoneNumber
                language
                isDoctor
                showOverdue
                dentalNotation
                hasValidNumber
                doctorPercentage
                automatic
                showAttendance
                requireScreenshot
                images
                automaticExpenses
                expensesFrom
                alertSettings {
                  id
                  inventory
                  masterInventory
                  invoice
                  reminder
                  pendingPatients
                  appointmentQrCode
                  onlineAppointment
                  operations
                  orders
                  calendar
                  __typename
                }
                autoAppointmentStatus
                __typename
              }
            }
            """;
    public final String MUTATION_DISABLE_USER = """
            mutation DISABLE_USER($user: ID!, $disabled: Boolean!) {
              disableUser(user: $user, disabled: $disabled) {
                id
                disabled
                __typename
              }
            }
            """;

}