package com.dentolize.patients.appointments.api;

public class AppointmentsSchema {

    private static AppointmentsSchema appointmentInstance;

    private AppointmentsSchema() {
    }

    public static synchronized AppointmentsSchema getInstance() {
        if (appointmentInstance == null) {
            appointmentInstance = new AppointmentsSchema();
        }
        return appointmentInstance;
    }

    public final String Query_GET_CALENDAR_QUERY = """
             query GET_CALENDAR_QUERY($branch: ID!, $start: DateTime!, $end: DateTime!, $doctor: ID, $rooms: [String], $forNewAppointment: Boolean) {
                  calendar(
                    branch: $branch
                    start: $start
                    end: $end
                    doctor: $doctor
                    rooms: $rooms
                    forNewAppointment: $forNewAppointment
                  ) {
                    id
                    status
                    urgent
                    pending
                    whatsapp
                    start
                    end
                    title
                    details
                    alert
                    room
                    diagnosticFee
                    type
                    createdAt
                    after
                    interval
                    waitingDuration
                    checked
                    other
                    diagnosticFeeInvoice {
                      id
                      diagnosticFee
                      branch {
                        id
                        __typename
                      }
                      payments {
                        id
                        amount
                        type
                        __typename
                      }
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
                    doctor {
                      id
                      name
                      phoneNumber
                      __typename
                    }
                    createdBy {
                      id
                      name
                      __typename
                    }
                    patient {
                      id
                      firstName
                      lastName
                      phoneNumber
                      hasValidNumber
                      email
                      pending
                      patientId
                      referenceId
                      gender
                      title
                      birthDate
                      tags
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
                      insuranceCompany {
                        id
                        name
                        number
                        __typename
                      }
                      birthDay
                      longitude
                      firstNameE
                      lastNameE
                      addressE
                      phoneNumberE
                      phoneNumber2E
                      relationE
                      details
                      invoices {
                        id
                        __typename
                      }
                      medicalHistory {
                        id
                        status
                        details
                        options
                        checkboxes
                        medicalItem {
                          id
                          name
                          options
                          type
                          group {
                            id
                            showAlert
                            __typename
                          }
                          __typename
                        }
                        __typename
                      }
                      pendingMedical {
                        id
                        status
                        details
                        options
                        checkboxes
                        medicalItem {
                          id
                          name
                          options
                          type
                          group {
                            id
                            showAlert
                            __typename
                          }
                          __typename
                        }
                        __typename
                      }
                      labOrders {
                        id
                        name
                        details
                        due
                        lab {
                          id
                          name
                          __typename
                        }
                        __typename
                      }
                      __typename
                    }
                    __typename
                  }
                }
            """;

    public final String Query_TOTAL_CREATED_APPOINTMENTS = """
            query TOTAL_CREATED_APPOINTMENTS($doctor: ID, $branchId: ID, $userId: ID, $id: ID, $searchTerm: String, $rangeDate: [DateTime!]!, $filters: Filter, $forDashboard: Boolean, $currentUserTime: Boolean) {
              totalCreatedAppointments(
                doctor: $doctor
                branchId: $branchId
                userId: $userId
                patient: $id
                searchTerm: $searchTerm
                rangeDate: $rangeDate
                filters: $filters
                forDashboard: $forDashboard
                currentUserTime: $currentUserTime
              )
            }
            """;

    public final String Query_CREATED_APPOINTMENTS = """
            query CREATED_APPOINTMENTS($doctor: ID, $branchId: ID, $userId: ID, $id: ID, $orderBy: String!, $skip: Int!, $take: Int!, $searchTerm: String, $rangeDate: [DateTime!]!, $filters: Filter, $forDashboard: Boolean, $currentUserTime: Boolean) {
              createdAppointments(
                doctor: $doctor
                branchId: $branchId
                userId: $userId
                patient: $id
                orderBy: $orderBy
                skip: $skip
                take: $take
                searchTerm: $searchTerm
                rangeDate: $rangeDate
                filters: $filters
                forDashboard: $forDashboard
                currentUserTime: $currentUserTime
              ) {
                id
                start
                end
                diagnosticFee
                urgent
                pending
                whatsapp
                alert
                duration
                waitingDuration
                started
                checked
                feedback
                feedbackRating
                feedbackIP
                feedbackAt
                room
                diagnosticFeeInvoice {
                  id
                  diagnosticFee
                  branch {
                    id
                    __typename
                  }
                  payments {
                    id
                    amount
                    type
                    __typename
                  }
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
                patient {
                  id
                  firstName
                  lastName
                  phoneNumber
                  phoneNumber2
                  email
                  pending
                  details
                  tags
                  patientId
                  referenceId
                  invoices {
                    id
                    __typename
                  }
                  medicalHistory {
                    id
                    status
                    details
                    options
                    checkboxes
                    medicalItem {
                      id
                      name
                      options
                      type
                      group {
                        showAlert
                        __typename
                      }
                      __typename
                    }
                    __typename
                  }
                  labOrders {
                    id
                    name
                    details
                    due
                    lab {
                      id
                      name
                      __typename
                    }
                    __typename
                  }
                  __typename
                }
                status
                details
                title
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
                _count {
                  canals
                  notes
                  operations
                  xrays
                  prescriptions
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
                __typename
              }
            }
            """;

    public final String Query_GET_PATIENT_LAST_APPOINTMENT = """
            query GET_PATIENT_LAST_APPOINTMENT($patient: ID!) {
              patientLastAppointment(patient: $patient) {
                id
                start
                status
                diagnosticFee
                diagnosticFeeInvoice {
                  id
                  __typename
                }
                __typename
              }
            }
            """;

    /**
     * GraphQL mutation for adding a new appointment.
     *
     * <p><b>Required variables:</b>
     * <ul>
     *   <li><b>generatedID</b> (ID!)</li>
     *   <li><b>branch</b> (ID!)</li>
     *   <li><b>room</b> (String!)</li>
     *   <li><b>start</b> (DateTime!)</li>
     *   <li><b>end</b> (DateTime!)</li>
     *   <li><b>status</b> (AppointmentStatus!)</li>
     *   <li><b>urgent</b> (Boolean!)</li>
     *   <li><b>customFields</b> ([CustomFieldInput!]!)</li>
     *   <li><b>appointmentType</b> (AppointmentType!)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b>
     * <ul>
     *   <li>generatedPatientID (ID)</li>
     *   <li>generatedInvoiceID (ID)</li>
     *   <li>generatedPaymentID (ID)</li>
     *   <li>doctor (ID)</li>
     *   <li>alert (String)</li>
     *   <li>title (String)</li>
     *   <li>details (String)</li>
     *   <li>patient (ID)</li>
     *   <li>firstName (String)</li>
     *   <li>lastName (String)</li>
     *   <li>address (String)</li>
     *   <li>birthDate (DateTime)</li>
     *   <li>birthDay (String)</li>
     *   <li>patientDetails (String)</li>
     *   <li>country (String)</li>
     *   <li>state (String)</li>
     *   <li>nationality (String)</li>
     *   <li>longitude (Float)</li>
     *   <li>latitude (Float)</li>
     *   <li>gender (String)</li>
     *   <li>marital (String)</li>
     *   <li>nationalId (String)</li>
     *   <li>patientTitle (String)</li>
     *   <li>email (String)</li>
     *   <li>assignedPractitioner (ID)</li>
     *   <li>patientId (String)</li>
     *   <li>referenceId (Float)</li>
     *   <li>phoneNumber (String)</li>
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
     *   <li>insuranceStartMonth (Int)</li>
     *   <li>insuranceUnlimited (Boolean)</li>
     *   <li>approvalRequired (Boolean)</li>
     *   <li>isTempPatient (Boolean)</li>
     *   <li>diagnosticFee (Float)</li>
     *   <li>diagnosticFeeInvoice (Float)</li>
     *   <li>diagnosticFeeOnline (Float)</li>
     *   <li>type (PaymentType)</li>
     *   <li>isOnline (Boolean)</li>
     *   <li>priceList (ID)</li>
     *   <li>sms (Boolean)</li>
     *   <li>patientCustomFields ([CustomFieldInput!])</li>
     *   <li>referral (String)</li>
     *   <li>referralDetails (String)</li>
     *   <li>referralUser (ID)</li>
     *   <li>referralPatient (ID)</li>
     *   <li>createdAt (DateTime)</li>
     *   <li>after (Int)</li>
     *   <li>interval (String)</li>
     *   <li>job (String)</li>
     *   <li>tags ([String])</li>
     *   <li>images ([String])</li>
     *   <li>treasury (ID)</li>
     *   <li>paymentOption (ID)</li>
     *   <li>tax (Float)</li>
     *   <li>insuranceNumber (String)</li>
     *   <li>insuranceGroup (String)</li>
     *   <li>insuranceCRT (String)</li>
     *   <li>cancelReason (String)</li>
     *   <li>other (String)</li>
     *   <li>paymentOther (String)</li>
     *   <li>users ([ID])</li>
     *   <li>repeatDays ([DateTime])</li>
     *   <li>family ([PatientFamilyInput])</li>
     *   <li>chart (ChartTypes)</li>
     *   <li>insurancePolicy (ID)</li>
     *   <li>maxInsuranceLimit (Float)</li>
     *   <li>identifierType (String)</li>
     * </ul>
     */
    public final String ADD_NEW_APPOINTMENT_MUTATION = """   
            mutation ADD_NEW_APPOINTMENT($generatedID: ID!, $generatedPatientID: ID, $generatedInvoiceID: ID, $generatedPaymentID: ID, $doctor: ID, $branch: ID!, $room: String!, $start: DateTime!, $end: DateTime!, $alert: String, $title: String, $details: String, $patient: ID, $firstName: String, $lastName: String, $address: String, $birthDate: DateTime, $birthDay: String, $patientDetails: String, $country: String, $state: String, $nationality: String, $longitude: Float, $latitude: Float, $gender: String, $marital: String, $nationalId: String, $patientTitle: String, $email: String, $assignedPractitioner: ID, $patientId: String, $referenceId: Float, $phoneNumber: String, $phoneNumber2: String, $firstNameE: String, $lastNameE: String, $phoneNumberE: String, $phoneNumber2E: String, $addressE: String, $relationE: String, $insurance: ID, $insuranceLimit: Float, $insurancePercentage: Float, $insuranceEndDate: DateTime, $insuranceStartMonth: Int, $insuranceUnlimited: Boolean, $approvalRequired: Boolean, $isTempPatient: Boolean, $diagnosticFee: Float, $diagnosticFeeInvoice: Float, $diagnosticFeeOnline: Float, $type: PaymentType, $status: AppointmentStatus!, $urgent: Boolean!, $isOnline: Boolean, $priceList: ID, $sms: Boolean, $customFields: [CustomFieldInput!]!, $patientCustomFields: [CustomFieldInput!]!, $referral: String, $referralDetails: String, $referralUser: ID, $referralPatient: ID, $createdAt: DateTime, $after: Int, $interval: String, $job: String, $tags: [String], $images: [String], $appointmentType: AppointmentType!, $treasury: ID, $paymentOption: ID, $tax: Float, $insuranceNumber: String, $insuranceGroup: String, $insuranceCRT: String, $cancelReason: String, $other: String, $paymentOther: String, $users: [ID], $repeatDays: [DateTime], $family: [PatientFamilyInput], $chart: ChartTypes, $insurancePolicy: ID, $maxInsuranceLimit: Float, $identifierType: String) {
                    addNewAppointment(
                      generatedID: $generatedID
                      generatedPatientID: $generatedPatientID
                      generatedInvoiceID: $generatedInvoiceID
                      generatedPaymentID: $generatedPaymentID
                      branch: $branch
                      doctor: $doctor
                      room: $room
                      start: $start
                      end: $end
                      alert: $alert
                      title: $title
                      details: $details
                      patient: $patient
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
                      country: $country
                      state: $state
                      longitude: $longitude
                      latitude: $latitude
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
                      insuranceStartMonth: $insuranceStartMonth
                      insuranceUnlimited: $insuranceUnlimited
                      approvalRequired: $approvalRequired
                      isTempPatient: $isTempPatient
                      diagnosticFee: $diagnosticFee
                      diagnosticFeeInvoice: $diagnosticFeeInvoice
                      diagnosticFeeOnline: $diagnosticFeeOnline
                      type: $type
                      status: $status
                      urgent: $urgent
                      isOnline: $isOnline
                      priceList: $priceList
                      sms: $sms
                      customFields: $customFields
                      patientCustomFields: $patientCustomFields
                      referral: $referral
                      referralDetails: $referralDetails
                      referralUser: $referralUser
                      referralPatient: $referralPatient
                      createdAt: $createdAt
                      after: $after
                      interval: $interval
                      job: $job
                      tags: $tags
                      images: $images
                      appointmentType: $appointmentType
                      treasury: $treasury
                      paymentOption: $paymentOption
                      tax: $tax
                      insuranceNumber: $insuranceNumber
                      insuranceGroup: $insuranceGroup
                      insuranceCRT: $insuranceCRT
                      cancelReason: $cancelReason
                      other: $other
                      users: $users
                      paymentOther: $paymentOther
                      repeatDays: $repeatDays
                      family: $family
                      chart: $chart
                      insurancePolicy: $insurancePolicy
                      maxInsuranceLimit: $maxInsuranceLimit
                      identifierType: $identifierType
                    ) {
                      id
                      status
                      urgent
                      isOnline
                      pending
                      whatsapp
                      start
                      end
                      title
                      details
                      alert
                      room
                      diagnosticFee
                      createdAt
                      type
                      after
                      interval
                      other
                      paymentLink
                      cancelReason
                      onlinePayment
                      waitingDuration
                      checked
                      provider
                      repeat
                      reschedule
                      patientConfirm
                      diagnosticFeeInvoice {
                        id
                        paidInFull
                        diagnosticFee
                        __typename
                      }
                      assistants {
                        id
                        name
                        color
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
                      doctor {
                        id
                        name
                        phoneNumber
                        color
                        __typename
                      }
                      createdBy {
                        id
                        name
                        __typename
                      }
                      patient {
                        id
                        firstName
                        lastName
                        phoneNumber
                        phoneNumber2
                        hasValidNumber
                        email
                        pending
                        patientId
                        referenceId
                        title
                        birthDate
                        tags
                        insuranceCompany {
                          id
                          name
                          number
                          __typename
                        }
                        birthDay
                        createdAt
                        details
                        totalRemaining
                        totalPaid
                        hasMedicalAlerts
                        hasPendingMedical
                        remainingPackage
                        tax
                        labOrders {
                          id
                          name
                          details
                          due
                          lab {
                            id
                            name
                            __typename
                          }
                          __typename
                        }
                        __typename
                      }
                      __typename
                    }
                  }
            """;
    public final String APPOINTMENTS_DETAILS_QUERY = """
            query APPOINTMENTS_DETAILS($appointment: ID!) {
              appointmentDetails(appointment: $appointment) {
                id
                start
                end
                status
                room
                type
                other
                diagnosticFee
                diagnosticFeeInvoice {
                  id
                  paidInFull
                  diagnosticFee
                  __typename
                }
                pending
                repeat
                duration
                waitingDuration
                reschedule
                patientConfirm
                started
                ended
                checked
                onlinePayment
                title
                details
                createdAt
                after
                interval
                cancelReason
                urgent
                isOnline
                whatsapp
                alert
                customFields {
                  id
                  value
                  field {
                    id
                    __typename
                  }
                  __typename
                }
                appointmentFeedback {
                  id
                  rating
                  feedback
                  __typename
                }
                assistants {
                  id
                  name
                  color
                  __typename
                }
                patient {
                  id
                  firstName
                  lastName
                  phoneNumber
                  phoneNumber2
                  email
                  pending
                  details
                  tags
                  title
                  referral
                  referralDetails
                  patientLastAppointment {
                    id
                    lastAppointment
                    lastAppointmentStatus
                    __typename
                  }
                  birthDate
                  patientId
                  referenceId
                  totalRemaining
                  totalPaid
                  insuranceCompany {
                    id
                    name
                    number
                    __typename
                  }
                  hasMedicalAlerts
                  hasPendingMedical
                  remainingPackage
                  tax
                  labOrders {
                    id
                    name
                    details
                    due
                    lab {
                      id
                      name
                      __typename
                    }
                    __typename
                  }
                  __typename
                }
                doctor {
                  id
                  name
                  color
                  __typename
                }
                branch {
                  id
                  name
                  __typename
                }
                _count {
                  canals
                  notes
                  operations
                  xrays
                  prescriptions
                  freeForms
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
                updatedAt
                __typename
              }
            }
            """;


    /**
     * GraphQL mutation for editing an appointment.
     *
     * <p><b>Required variables:</b>
     * <ul>
     *   <li><b>branch</b> (ID!)</li>
     *   <li><b>room</b> (String!)</li>
     *   <li><b>start</b> (DateTime!)</li>
     *   <li><b>end</b> (DateTime!)</li>
     *   <li><b>status</b> (AppointmentStatus!)</li>
     *   <li><b>urgent</b> (Boolean!)</li>
     *   <li><b>customFields</b> ([CustomFieldInput!]!)</li>
     *   <li><b>appointmentType</b> (AppointmentType!)</li>
     * </ul>
     *
     * <p><b>Optional variables:</b>
     * <ul>
     *   <li>doctor (ID)</li>
     *   <li>appointment (ID)</li>
     *   <li>alert (String)</li>
     *   <li>title (String)</li>
     *   <li>details (String)</li>
     *   <li>isOnline (Boolean)</li>
     *   <li>sms (Boolean)</li>
     *   <li>createdAt (DateTime)</li>
     *   <li>after (Int)</li>
     *   <li>interval (String)</li>
     *   <li>other (String)</li>
     *   <li>cancelReason (String)</li>
     *   <li>users ([ID])</li>
     * </ul>
     */
    public final String EDIT_APPOINTMENT_MUTATION = """
            mutation EDIT_APPOINTMENT($doctor: ID, $branch: ID!, $appointment: ID, $room: String!, $start: DateTime!, $end: DateTime!, $alert: String, $title: String, $details: String, $status: AppointmentStatus!, $urgent: Boolean!, $isOnline: Boolean, $sms: Boolean, $customFields: [CustomFieldInput!]!, $createdAt: DateTime, $after: Int, $interval: String, $appointmentType: AppointmentType!, $other: String, $cancelReason: String, $users: [ID]) {
                editAppointment(
                  appointment: $appointment
                  branch: $branch
                  doctor: $doctor
                  room: $room
                  start: $start
                  end: $end
                  alert: $alert
                  title: $title
                  details: $details
                  status: $status
                  urgent: $urgent
                  isOnline: $isOnline
                  sms: $sms
                  customFields: $customFields
                  createdAt: $createdAt
                  after: $after
                  interval: $interval
                  appointmentType: $appointmentType
                  other: $other
                  cancelReason: $cancelReason
                  users: $users
                ) {
                  id
                  status
                  urgent
                  isOnline
                  start
                  end
                  title
                  details
                  alert
                  room
                  createdAt
                  after
                  interval
                  reschedule
                  type
                  other
                  cancelReason
                  assistants {
                    id
                    name
                    color
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
                  doctor {
                    id
                    name
                    phoneNumber
                    color
                    __typename
                  }
                  patient {
                    id
                    firstName
                    lastName
                    phoneNumber
                    hasValidNumber
                    insuranceCompany {
                      id
                      name
                      number
                      __typename
                    }
                    hasMedicalAlerts
                    __typename
                  }
                  __typename
                }
              }
            """;
    public final String DELETE_APPOINTMENT_MUTATION = """
            mutation DELETE_APPOINTMENT($appointment: ID!, $branch: ID!) {
              deleteAppointment(appointment: $appointment, branch: $branch) {
                id
                __typename
              }
            }
            """;
    public final String COLLECT_DIAGNOSTIC_FEES_MUTATION = """
            mutation COLLECT_DIAGNOSTIC_FEES($generatedID: ID!, $generatedPaymentID: ID!, $appointment: ID!, $amount: Float!, $taxPercent: Float, $tax: Float, $type: PaymentType!, $other: String, $treasury: ID, $paymentOption: ID, $onlinePayment: Boolean, $chart: ChartTypes) {
              collectDiagnosticFees(
                generatedID: $generatedID
                generatedPaymentID: $generatedPaymentID
                appointment: $appointment
                amount: $amount
                taxPercent: $taxPercent
                tax: $tax
                type: $type
                other: $other
                treasury: $treasury
                paymentOption: $paymentOption
                onlinePayment: $onlinePayment
                chart: $chart
              ) {
                id
                diagnosticFee
                paymentLink
                provider
                diagnosticFeeInvoice {
                  id
                  diagnosticFee
                  __typename
                }
                __typename
              }
            }
            """;
}