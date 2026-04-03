package com.dentolize.patients.info.api;

public class PatientSchema {

    private static PatientSchema patientSchemaInstance;

    private PatientSchema() {
    }

    public static PatientSchema getInstance() {
        if (patientSchemaInstance == null) {
            patientSchemaInstance = new PatientSchema();
        }
        return patientSchemaInstance;
    }

    public final String QUERY_TOTAL_PATIENTS = """
            query TOTAL_PATIENTS($searchTerm: String, $disabled: Boolean, $rangeDate: [DateTime!]!, $insuranceCompany: ID, $priceList: ID, $branchId: ID, $filters: Filter, $doctor: ID) {
              totalPatients(
                searchTerm: $searchTerm
                disabled: $disabled
                branchId: $branchId
                rangeDate: $rangeDate
                insuranceCompanies: insuranceCompanies
                priceList: $priceList
                filters: $filters
                doctor: $doctor
              )
            }
            """;

    public final String QUERY_GET_PATIENTS = """
            query GET_PATIENTS($orderBy: String!, $skip: Int!, $take: Int!, $searchTerm: String, $disabled: Boolean, $rangeDate: [DateTime!]!, $insuranceCompany: ID, $priceList: ID, $branchId: ID, $filters: Filter, $doctor: ID) {
              patients(
                orderBy: $orderBy
                branchId: $branchId
                skip: $skip
                take: $take
                searchTerm: $searchTerm
                disabled: $disabled
                rangeDate: $rangeDate
                insuranceCompanies: insuranceCompanies
                priceList: $priceList
                filters: $filters
                doctor: $doctor
              ) {
                id
                firstName
                lastName
                patientId
                referenceId
                phoneNumber
                hasValidNumber
                phoneNumber2
                gender
                email
                insuranceCompany {
                  id
                  name
                  __typename
                }
                insured
                insuranceLimit
                insuranceUnlimited
                approvalRequired
                insurancePercentage
                insuranceEndDate
                disabled
                pending
                details
                phoneNumber
                firstNameE
                lastNameE
                phoneNumberE
                phoneNumber2E
                addressE
                relationE
                country
                address
                longitude
                latitude
                title
                balance
                totalInsurance
                totalPaid
                birthDate
                birthDay
                job
                tags
                images
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
                customFields {
                  id
                  value
                  field {
                    id
                    __typename
                  }
                  __typename
                }
                referral
                referralDetails
                referralUser {
                  id
                  name
                  __typename
                }
                referralPatient {
                  id
                  firstName
                  lastName
                  __typename
                }
                _count {
                  history
                  appointments
                  referrals
                  __typename
                }
                __typename
              }
            }""";
    /**
     * GraphQL mutation for adding a new patient.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li>generatedID (ID!)</li>
     *   <li>branch (ID!)</li>
     *   <li>firstName (String!)</li>
     *   <li>lastName (String!)</li>
     *   <li>phoneNumber (String!)</li>
     *   <li>phoneNumber2 (String!)</li>
     *   <li>customFields ([CustomFieldInput!]!)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b></p>
     * <ul>
     *   <li>address (String)</li>
     *   <li>email (String)</li>
     *   <li>birthDate (DateTime)</li>
     *   <li>birthDay (String)</li>
     *   <li>patientDetails (String)</li>
     *   <li>gender (String)</li>
     *   <li>marital (String)</li>
     *   <li>nationalId (String)</li>
     *   <li>nationality (String)</li>
     *   <li>patientTitle (String)</li>
     *   <li>assignedPractitioner (ID)</li>
     *   <li>patientId (String)</li>
     *   <li>referenceId (Float)</li>
     *   <li>firstNameE (String)</li>
     *   <li>lastNameE (String)</li>
     *   <li>phoneNumberE (String)</li>
     *   <li>phoneNumber2E (String)</li>
     *   <li>addressE (String)</li>
     *   <li>relationE (String)</li>
     *   <li>country (String)</li>
     *   <li>state (String)</li>
     *   <li>longitude (Float)</li>
     *   <li>latitude (Float)</li>
     *   <li>insurance (ID)</li>
     *   <li>insuranceLimit (Float)</li>
     *   <li>insurancePercentage (Float)</li>
     *   <li>insuranceEndDate (DateTime)</li>
     *   <li>insuranceStartMonth (Int)</li>
     *   <li>insuranceUnlimited (Boolean)</li>
     *   <li>approvalRequired (Boolean)</li>
     *   <li>isTempPatient (Boolean)</li>
     *   <li>priceList (ID)</li>
     *   <li>sms (Boolean)</li>
     *   <li>referral (String)</li>
     *   <li>referralDetails (String)</li>
     *   <li>referralUser (ID)</li>
     *   <li>referralPatient (ID)</li>
     *   <li>createdAt (DateTime)</li>
     *   <li>job (String)</li>
     *   <li>tags ([String])</li>
     *   <li>images ([String])</li>
     *   <li>tax (Float)</li>
     *   <li>insuranceNumber (String)</li>
     *   <li>insuranceGroup (String)</li>
     *   <li>insuranceCRT (String)</li>
     *   <li>family ([PatientFamilyInput])</li>
     *   <li>conversation (ID)</li>
     *   <li>lead (ID)</li>
     *   <li>insurancePolicy (ID)</li>
     *   <li>maxInsuranceLimit (Float)</li>
     *   <li>identifierType (String)</li>
     *   <li>policyClass (ID)</li>
     * </ul>
     */
    public final String ADD_NEW_PATIENT_MUTATION = """
            mutation ADD_NEW_PATIENT($generatedID: ID!, $branch: ID!, $firstName: String!, $lastName: String!, $address: String, $email: String, $birthDate: DateTime, $birthDay: String, $patientDetails: String, $gender: String, $marital: String, $nationalId: String, $nationality: String, $patientTitle: String, $assignedPractitioner: ID, $patientId: String, $referenceId: Float, $phoneNumber: String!, $phoneNumber2: String!, $firstNameE: String, $lastNameE: String, $phoneNumberE: String, $phoneNumber2E: String, $addressE: String, $relationE: String, $country: String, $state: String, $longitude: Float, $latitude: Float, $insurance: ID, $insuranceLimit: Float, $insurancePercentage: Float, $insuranceEndDate: DateTime, $insuranceStartMonth: Int, $insuranceUnlimited: Boolean, $approvalRequired: Boolean, $isTempPatient: Boolean, $priceList: ID, $sms: Boolean, $customFields: [CustomFieldInput!]!, $referral: String, $referralDetails: String, $referralUser: ID, $referralPatient: ID, $createdAt: DateTime, $job: String, $tags: [String], $images: [String], $tax: Float, $insuranceNumber: String, $insuranceGroup: String, $insuranceCRT: String, $family: [PatientFamilyInput], $conversation: ID, $lead: ID, $insurancePolicy: ID, $maxInsuranceLimit: Float, $identifierType: String, $policyClass: ID) {
                 addNewPatient(
                   generatedID: $generatedID
                   branch: $branch
                   firstName: $firstName
                   lastName: $lastName
                   address: $address
                   email: $email
                   birthDate: $birthDate
                   birthDay: $birthDay
                   patientDetails: $patientDetails
                   gender: $gender
                   marital: $marital
                   nationalId: $nationalId
                   nationality: $nationality
                   patientTitle: $patientTitle
                   assignedPractitioner: $assignedPractitioner
                   patientId: $patientId
                   referenceId: $referenceId
                   phoneNumber: $phoneNumber
                   phoneNumber2: $phoneNumber2
                   firstNameE: $firstNameE
                   lastNameE: $lastNameE
                   phoneNumberE: $phoneNumberE
                   phoneNumber2E: $phoneNumber2E
                   addressE: $addressE
                   relationE: $relationE
                   country: $country
                   state: $state
                   longitude: $longitude
                   latitude: $latitude
                   insurance: $insurance
                   insuranceLimit: $insuranceLimit
                   insurancePercentage: $insurancePercentage
                   insuranceEndDate: $insuranceEndDate
                   insuranceStartMonth: $insuranceStartMonth
                   insuranceUnlimited: $insuranceUnlimited
                   approvalRequired: $approvalRequired
                   isTempPatient: $isTempPatient
                   priceList: $priceList
                   sms: $sms
                   customFields: $customFields
                   referral: $referral
                   referralDetails: $referralDetails
                   referralUser: $referralUser
                   referralPatient: $referralPatient
                   createdAt: $createdAt
                   job: $job
                   tags: $tags
                   images: $images
                   tax: $tax
                   insuranceNumber: $insuranceNumber
                   insuranceGroup: $insuranceGroup
                   insuranceCRT: $insuranceCRT
                   family: $family
                   conversation: $conversation
                   lead: $lead
                   insurancePolicy: $insurancePolicy
                   maxInsuranceLimit: $maxInsuranceLimit
                   identifierType: $identifierType
                   policyClass: $policyClass
                 ) {
                   id
                   firstName
                   lastName
                   patientId
                   referenceId
                   phoneNumber
                   country
                   hasValidNumber
                   gender
                   marital
                   nationalId
                   nationality
                   email
                   insuranceCompany {
                     id
                     name
                     __typename
                   }
                   insured
                   insuranceLimit
                   insuranceUnlimited
                   insurancePercentage
                   insuranceEndDate
                   insuranceStartMonth
                   approvalRequired
                   details
                   phoneNumber
                   firstNameE
                   lastNameE
                   phoneNumberE
                   phoneNumber2E
                   addressE
                   relationE
                   address
                   title
                   birthDate
                   birthDay
                   job
                   tags
                   images
                   tax
                   insuranceNumber
                   insuranceGroup
                   insuranceCRT
                   doctor {
                     id
                     name
                     __typename
                   }
                   priceList {
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
                   customFields {
                     id
                     value
                     field {
                       id
                       __typename
                     }
                     __typename
                   }
                   __typename
                 }
            }""";

    public final String QUERY_PATIENT_DETAILS = """
            query PATIENT_DETAILS($patient: ID!) {
              patientDetails(patient: $patient) {
                __typename
               disabled
                id
                referenceId
                patientId
                firstName
                lastName
                phoneNumber
                hasValidNumber
                phoneNumber2
                country
                birthDate
                birthDay
                title
                gender
                email
                address
                latitude
                longitude
                doctor {
                  __typename
                  id
                  name
                }
                priceList {
                  __typename
                  difference
                  id
                  name
                  percentage
                  syncTo
                }
                tags
                marital
                job
                nationality
                tax
                nationalId
                details
                images
                insured
                insuranceCRT
                insuranceEndDate
                insuranceGroup
                insuranceLimit
                insuranceNumber
                insurancePercentage
                insuranceStartMonth
                insuranceUnlimited
                insuranceCompany {
                  __typename
                  id
                  name
                  number
                }
                phoneNumber
                primaryFamily {
                  __typename
                  id
                  relation
                  secondary {
                    __typename
                    firstName
                    id
                    lastName
                  }
                }
                relationE
                referral
                referralDetails
                referralPatient {
                  __typename
                  firstName
                  id
                  lastName
                }
                referralUser {
                  __typename
                  id
                  name
                }
                firstNameE
                lastNameE
                addressE
                phoneNumber2E
                phoneNumberE
                branch {
                  __typename
                  id
                  name
                }
            
                customFields {
                  __typename
                  field {
                    __typename
                    id
                  }
                  id
                  value
                }
                medicalHistory {
                  __typename
                  checkboxes
                  details
                  id
                  medicalItemId
                  options
                  status
                }
                medicalUpdatedAt
                medicalUpdater {
                  __typename
                  id
                  name
                }
                patientLastAppointment {
                  __typename
                  id
                  lastAppointment
                  lastAppointmentStatus
                }
                points {
                  __typename
                  expired
                  firstToExpire
                  id
                  remaining
                  total
                  used
                }
                approvalRequired
                balance
                pending
                firstPaymentDate
                formsSigned
                hasMedicalAlerts
                hasPendingMedical
                mixedDentition
                remainingPackage
                totalInsurance
                totalPaid
                totalRemaining
                signature
                signatureID
                signatureName
                signed
                signedAt
                signedBy {
                  __typename
                  id
                  name
                }
                witnessID
                witnessName
                witnessSign
                witnessSignAt
                createdAt
                createdBy {
                  __typename
                  id
                  name
                }
                updatedAt
                updatedBy {
                  __typename
                  id
                  name
                }
              }
            }""";

    /**
     * GraphQL mutation for editing an existing patient.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li>patient (ID!)</li>
     *   <li>firstName (String!)</li>
     *   <li>lastName (String!)</li>
     *   <li>phoneNumber (String!)</li>
     *   <li>branch (ID!)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b></p>
     * <ul>
     *   <li>address (String)</li>
     *   <li>email (String)</li>
     *   <li>birthDate (DateTime)</li>
     *   <li>birthDay (String)</li>
     *   <li>patientDetails (String)</li>
     *   <li>gender (String)</li>
     *   <li>patientTitle (String)</li>
     *   <li>assignedPractitioner (ID)</li>
     *   <li>patientId (String)</li>
     *   <li>phoneNumber2 (String)</li>
     *   <li>firstNameE (String)</li>
     *   <li>lastNameE (String)</li>
     *   <li>phoneNumberE (String)</li>
     *   <li>phoneNumber2E (String)</li>
     *   <li>addressE (String)</li>
     *   <li>relationE (String)</li>
     *   <li>insurance (ID)</li>
     *   <li>insuranceLimit (Float)</li>
     *   <li>insurancePercentage (Float)</li>
     *   <li>insuranceEndDate (DateTime)</li>
     *   <li>insuranceUnlimited (Boolean)</li>
     *   <li>approvalRequired (Boolean)</li>
     *   <li>companyName (String)</li>
     *   <li>companyNumber (String)</li>
     *   <li>priceList (ID)</li>
     *   <li>customFields ([CustomFieldInput!])</li>
     *   <li>referral (String)</li>
     *   <li>referralDetails (String)</li>
     *   <li>referralUser (ID)</li>
     *   <li>referralPatient (ID)</li>
     *   <li>country (String)</li>
     *   <li>state (String)</li>
     *   <li>longitude (Float)</li>
     *   <li>latitude (Float)</li>
     *   <li>createdAt (DateTime)</li>
     *   <li>job (String)</li>
     *   <li>tags ([String])</li>
     *   <li>images ([String])</li>
     *   <li>tax (Float)</li>
     *   <li>insuranceNumber (String)</li>
     *   <li>insuranceGroup (String)</li>
     *   <li>insuranceCRT (String)</li>
     * </ul>
     */
    public final String EDIT_PATIENT_MUTATION = """
            mutation EDIT_PATIENT($patient: ID!, $firstName: String!, $lastName: String!, $address: String, $email: String, $birthDate: DateTime, $birthDay: String, $patientDetails: String, $gender: String, $patientTitle: String, $assignedPractitioner: ID, $patientId: String, $phoneNumber: String!, $phoneNumber2: String, $firstNameE: String, $lastNameE: String, $phoneNumberE: String, $phoneNumber2E: String, $addressE: String, $relationE: String, $insurance: ID, $insuranceLimit: Float, $insurancePercentage: Float, $insuranceEndDate: DateTime, $insuranceUnlimited: Boolean, $approvalRequired: Boolean, $companyName: String, $companyNumber: String, $priceList: ID, $customFields: [CustomFieldInput!], $referral: String, $referralDetails: String, $referralUser: ID, $referralPatient: ID, $country: String, $state: String, $longitude: Float, $latitude: Float, $createdAt: DateTime, $job: String, $tags: [String], $images: [String], $tax: Float, $insuranceNumber: String, $insuranceGroup: String, $insuranceCRT: String, $branch: ID!) {
                    editPatient(
                      patient: $patient
                      firstName: $firstName
                      lastName: $lastName
                      address: $address
                      email: $email
                      birthDate: $birthDate
                      birthDay: $birthDay
                      patientDetails: $patientDetails
                      gender: $gender
                      patientTitle: $patientTitle
                      assignedPractitioner: $assignedPractitioner
                      patientId: $patientId
                      phoneNumber: $phoneNumber
                      phoneNumber2: $phoneNumber2
                      firstNameE: $firstNameE
                      lastNameE: $lastNameE
                      phoneNumberE: $phoneNumberE
                      phoneNumber2E: $phoneNumber2E
                      addressE: $addressE
                      relationE: $relationE
                      insurance: $insurance
                      insuranceLimit: $insuranceLimit
                      insurancePercentage: $insurancePercentage
                      insuranceEndDate: $insuranceEndDate
                      insuranceUnlimited: $insuranceUnlimited
                      approvalRequired: $approvalRequired
                      companyName: $companyName
                      companyNumber: $companyNumber
                      priceList: $priceList
                      customFields: $customFields
                      referral: $referral
                      referralDetails: $referralDetails
                      referralUser: $referralUser
                      referralPatient: $referralPatient
                      country: $country
                      state: $state
                      longitude: $longitude
                      latitude: $latitude
                      createdAt: $createdAt
                      job: $job
                      tags: $tags
                      images: $images
                      tax: $tax
                      insuranceNumber: $insuranceNumber
                      insuranceGroup: $insuranceGroup
                      insuranceCRT: $insuranceCRT
                      branch: $branch
                    ) {
                      id
                      firstName
                      lastName
                      patientId
                      referenceId
                      phoneNumber
                      hasValidNumber
                      gender
                      email
                      insuranceCompany {
                        id
                        name
                        __typename
                      }
                      insured
                      insuranceLimit
                      insuranceUnlimited
                      approvalRequired
                      insurancePercentage
                      insuranceEndDate
                      details
                      phoneNumber2
                      country
                      longitude
                      latitude
                      firstNameE
                      lastNameE
                      phoneNumberE
                      phoneNumber2E
                      addressE
                      relationE
                      address
                      title
                      birthDate
                      birthDay
                      job
                      tags
                      images
                      tax
                      insuranceNumber
                      insuranceGroup
                      insuranceCRT
                      doctor {
                        id
                        name
                        __typename
                      }
                      priceList {
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
                      customFields {
                        id
                        value
                        field {
                          id
                          __typename
                        }
                        __typename
                      }
                      referral
                      referralDetails
                      referralUser {
                        id
                        name
                        __typename
                      }
                      branch {
                        id
                        name
                        __typename
                      }
                      referralPatient {
                        id
                        firstName
                        lastName
                        __typename
                      }
                      __typename
                    }
            }""";

    /**
     * GraphQL mutation for disabling or enabling a patient.
     *
     * <p><b>Required variables:</b></p>
     * <ul>
     *   <li>patient (ID!)</li>
     *   <li>disabled (Boolean!)</li>
     * </ul>
     *
     * <p>There are no optional variables for this mutation.</p>
     */

    public final String DISABLE_PATIENT_MUTATION = """
            mutation DISABLE_PATIENT($patient: ID!, $disabled: Boolean!) {
              disablePatient(patient: $patient, disabled: $disabled) {
                id
                disabled
                __typename
              }
            }""";

}