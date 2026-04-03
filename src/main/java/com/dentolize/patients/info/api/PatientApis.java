package com.dentolize.patients.info.api;

import com.dentolize.search.SearchApis;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import engine.CustomReporter;
import engine.Verifications;
import engine.dataDriven.FakerData;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import engine.Helper;
import engine.actions.GraphQlActions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static engine.Helper.setVariable;
import static engine.Verifications.*;

public class PatientApis {
    private final SHAFT.API restActions;
    protected SearchApis searchApis;

    public PatientApis(SHAFT.API restActions) {
        this.restActions = restActions;
        searchApis = new SearchApis(restActions);
    }

    @Step("Create New Patient")
    public Response createPatient(String cookie, JSONFileManager patientData, String objectNameTestData) {
        Map<String, Object> addNewPatientVariables = preparePatientVariables(cookie, patientData, objectNameTestData);
        addNewPatientVariables.put("generatedID", Helper.generateUuid());
        Response response = GraphQlActions.sendGraphQlRequest(PatientSchema.getInstance().ADD_NEW_PATIENT_MUTATION, addNewPatientVariables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    public Map<String, Object> addPatient(String cookie, JSONFileManager jsonData, String objName, Map<String, Object> variables) {
        String patientName = jsonData.getTestData(objName + ".patient");
        String patientId;
        if (!patientName.isEmpty()) {
            patientId = searchApis.getPatientId(cookie, jsonData.getTestData(objName + ".patient"));
        } else {
            PatientApis patientApis = new PatientApis(restActions);
            Response patientCreated = patientApis.createPatient(cookie);
            patientId = RestActions.getResponseJSONValue(patientCreated, "data.addNewPatient.id");
        }
        CustomReporter.getInstance().logInfoStep("Patient id is : [ " + patientId + " ]");
        setVariable(variables, "patient", patientId);
        return variables;
    }

    @Step("Read Patient details [ {patientId} ]")
    public Response readPatientDetails(String cookie, String patientId) {
        Response response = GraphQlActions.sendGraphQlRequest(PatientSchema.getInstance().QUERY_PATIENT_DETAILS, Map.of("patient", patientId), cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }


    @Step("Update Patient [ {patientId} ]")
    public Response updatePatient(String cookie, String patientId, JSONFileManager patientData, String objectNameTestData) {
        Map<String, Object> editPatientVariables = preparePatientVariables(cookie, patientData, objectNameTestData);
        editPatientVariables.put("patient", patientId);
        Response response = GraphQlActions.sendGraphQlRequest(PatientSchema.getInstance().EDIT_PATIENT_MUTATION, editPatientVariables, cookie);
        Verifications.verifyResponseTimeAndStatusCode(response);
        return response;
    }

    @Step("Disable/Delete Patient [ {patientId} ]")
    public Response disablePatient(String cookie, String patientId, Boolean disabled) {
        return GraphQlActions.sendGraphQlRequest(PatientSchema.getInstance().DISABLE_PATIENT_MUTATION, Map.of("patient", patientId, "disabled", disabled), cookie);
    }

    @Step("Get All Patients")
    public Response getPatients(String cookie, int skip, int take, String orderBy, String searchTerm, String branchId, List<String> rangeDate, String priceList, String filters) {
        Map<String, Object> getPatientsVariables = Map.of(
                "skip", skip,
                "take", take,
                "orderBy", orderBy,
                "searchTerm", searchTerm,
                "branchId", branchId,
                "rangeDate", rangeDate,
                "priceList", priceList,
                "filters", filters
        );
        return GraphQlActions.sendGraphQlRequest(PatientSchema.getInstance().QUERY_GET_PATIENTS, getPatientsVariables, cookie);
    }


    @Step("Search for the patient's name")
    public Response totalPatients(String cookie, String searchTerm, String branchId, List<String> rangeDate, String priceList, String filters) {
        Map<String, Object> totalVariables = Map.of(
                "searchTerm", searchTerm,
                "branchId", branchId,
                "rangeDate", rangeDate,
                "priceList", priceList,
                "filters", filters
        );
        return GraphQlActions.sendGraphQlRequest(PatientSchema.getInstance().QUERY_TOTAL_PATIENTS, totalVariables, cookie);
    }


    @Step("Validate Patient details data is [ {patientId} ]")
    public void validatePatientDetailsData(String cookie, String patientId, JSONFileManager patientData, String objectNameTestData) {
        Response response = readPatientDetails(cookie, patientId);
        Verifications.verifyResponseTimeAndStatusCode(response);
        validateResponseListIsEqual(response, "data.patientDetails.tags", patientData.getTestDataAsList(objectNameTestData + ".tags"));
        verifyResponseIsEqual(response, "data.patientDetails.patientId", patientData.getTestData(objectNameTestData + ".patientId"));
        validateResponseContains(response, "data.patientDetails.firstName", patientData.getTestData(objectNameTestData + ".firstName"));
        verifyResponseIsEqual(response, "data.patientDetails.lastName", patientData.getTestData(objectNameTestData + ".lastName"));
        verifyResponseIsEqual(response, "data.patientDetails.phoneNumber", patientData.getTestData(objectNameTestData + ".phoneNumber"));
        verifyResponseIsEqual(response, "data.patientDetails.phoneNumber2", patientData.getTestData(objectNameTestData + ".phoneNumber2"));
        verifyResponseIsEqual(response, "data.patientDetails.gender", patientData.getTestData(objectNameTestData + ".gender"));
        verifyResponseIsEqual(response, "data.patientDetails.email", patientData.getTestData(objectNameTestData + ".email"));
        verifyResponseIsEqual(response, "data.patientDetails.country", patientData.getTestData(objectNameTestData + ".country"));
        verifyResponseIsEqual(response, "data.patientDetails.insuranceCompany.name", patientData.getTestData(objectNameTestData + ".insuranceCompany"));
        verifyResponseIsEqual(response, "data.patientDetails.details", patientData.getTestData(objectNameTestData + ".details"));
        verifyResponseIsEqual(response, "data.patientDetails.firstNameE", patientData.getTestData(objectNameTestData + ".firstNameE"));
        verifyResponseIsEqual(response, "data.patientDetails.lastNameE", patientData.getTestData(objectNameTestData + ".lastNameE"));
        verifyResponseIsEqual(response, "data.patientDetails.addressE", patientData.getTestData(objectNameTestData + ".addressE"));
        verifyResponseIsEqual(response, "data.patientDetails.relationE", patientData.getTestData(objectNameTestData + ".relationE"));
        verifyResponseIsEqual(response, "data.patientDetails.address", patientData.getTestData(objectNameTestData + ".address"));
        verifyResponseIsEqual(response, "data.patientDetails.title", patientData.getTestData(objectNameTestData + ".title"));
        verifyResponseIsEqual(response, "data.patientDetails.birthDate", patientData.getTestData(objectNameTestData + ".birthDate"));
        verifyResponseIsEqual(response, "data.patientDetails.job", patientData.getTestData(objectNameTestData + ".job"));
        verifyResponseIsEqual(response, "data.patientDetails.priceList.name", patientData.getTestData(objectNameTestData + ".priceList"));
        verifyResponseIsEqual(response, "data.patientDetails.referral", patientData.getTestData(objectNameTestData + ".referral"));
        verifyResponseIsEqual(response, "data.patientDetails.referralDetails", patientData.getTestData(objectNameTestData + ".referralDetails"));
        verifyResponseIsEqual(response, "data.patientDetails.insure", patientData.getTestData(objectNameTestData + ".insure"));
        verifyResponseIsEqual(response, "data.patientDetails.insuranceLimit", patientData.getTestData(objectNameTestData + ".insuranceLimit"));
        verifyResponseIsEqual(response, "data.patientDetails.insurancePercentage", patientData.getTestData(objectNameTestData + ".insurancePercentage"));
        verifyResponseIsEqual(response, "data.patientDetails.insuranceEndDate", patientData.getTestData(objectNameTestData + ".insuranceEndDate"));
        verifyResponseIsEqual(response, "data.patientDetails.insuranceUnlimited", patientData.getTestData(objectNameTestData + ".insuranceUnlimited"));
        verifyResponseIsEqual(response, "data.patientDetails.approvalRequired", patientData.getTestData(objectNameTestData + ".approvalRequired"));
        verifyResponseIsEqual(response, "data.patientDetails.longitude", patientData.getTestData(objectNameTestData + ".longitude"));
        verifyResponseIsEqual(response, "data.patientDetails.latitude", patientData.getTestData(objectNameTestData + ".latitude"));
    }

    private Map<String, Object> preparePatientVariables(String cookie, JSONFileManager jsonData, String objName) {
        Map<String, Object> variables = new HashMap<>();
        setVariable(variables, "patientId", jsonData.getTestData(objName + ".patientId"));
        setVariable(variables, "branch", searchApis.getBranchId(cookie, jsonData.getTestData(objName + ".branch")));
        setVariable(variables, "priceList", searchApis.getPriceListId(cookie, jsonData.getTestData(objName + ".priceList")));
        setVariable(variables, "insurance", searchApis.getInsuranceId(cookie, jsonData.getTestData(objName + ".insuranceCompany")));
        setVariable(variables, "assignedPractitioner", searchApis.getUserId(cookie, jsonData.getTestData(objName + ".assignedPractitioner")));
        setVariable(variables, "firstName", jsonData.getTestData(objName + ".firstName") + Helper.getTimestamp());
        setVariable(variables, "lastName", jsonData.getTestData(objName + ".lastName"));
        setVariable(variables, "phoneNumber", jsonData.getTestData(objName + ".phoneNumber"));
        setVariable(variables, "phoneNumber2", jsonData.getTestData(objName + ".phoneNumber2"));
        setVariable(variables, "email", jsonData.getTestData(objName + ".email"));
        setVariable(variables, "gender", jsonData.getTestData(objName + ".gender"));
        setVariable(variables, "birthDate", jsonData.getTestData(objName + ".birthDate"));
        setVariable(variables, "birthDay", jsonData.getTestData(objName + ".birthDay"));
        setVariable(variables, "isTempPatient", jsonData.getTestData(objName + ".isTempPatient"), Boolean.class);
        setVariable(variables, "patientTitle", jsonData.getTestData(objName + ".title"));
        setVariable(variables, "job", jsonData.getTestData(objName + ".job"));
        variables.put("tags", jsonData.getTestDataAsList(objName + ".tags"));
        setVariable(variables, "country", jsonData.getTestData(objName + ".country"));
        setVariable(variables, "address", jsonData.getTestData(objName + ".address"));
        setVariable(variables, "longitude", jsonData.getTestData(objName + ".longitude"), Float.class);
        setVariable(variables, "latitude", jsonData.getTestData(objName + ".latitude"), Float.class);
        setVariable(variables, "patientDetails", jsonData.getTestData(objName + ".details"));
        setVariable(variables, "createdAt", jsonData.getTestData(objName + ".createdAt"));
        setVariable(variables, "insuranceLimit", jsonData.getTestData(objName + ".insuranceLimit"));
        setVariable(variables, "insuranceUnlimited", jsonData.getTestData(objName + ".insuranceUnlimited"), Boolean.class);
        setVariable(variables, "insurancePercentage", jsonData.getTestData(objName + ".insurancePercentage"), Float.class);
        setVariable(variables, "insuranceEndDate", jsonData.getTestData(objName + ".insuranceEndDate"));
        setVariable(variables, "insuranceStartMonth", jsonData.getTestData(objName + ".insuranceStartMonth"), Integer.class);
        setVariable(variables, "approvalRequired", jsonData.getTestData(objName + ".approvalRequired"), Boolean.class);
        setVariable(variables, "referral", jsonData.getTestData(objName + ".referral"));
        setVariable(variables, "referralDetails", jsonData.getTestData(objName + ".referralDetails"));
        setVariable(variables, "firstNameE", jsonData.getTestData(objName + ".firstNameE"));
        setVariable(variables, "lastNameE", jsonData.getTestData(objName + ".lastNameE"));
        setVariable(variables, "phoneNumberE", jsonData.getTestData(objName + ".phoneNumberE"));
        setVariable(variables, "phoneNumber2E", jsonData.getTestData(objName + ".phoneNumber2E"));
        setVariable(variables, "addressE", jsonData.getTestData(objName + ".addressE"));
        setVariable(variables, "relationE", jsonData.getTestData(objName + ".relationE"));
        setVariable(variables, "sms", jsonData.getTestData(objName + ".sms"), Boolean.class);
        variables.put("customFields", jsonData.getTestDataAsList(objName + ".customFields"));
        setVariable(variables, "tax", jsonData.getTestData(objName + ".tax"), Float.class);
        return variables;
    }

    //TODO: Add default data branch, doctor
    @Step("Create New Patient")
    private Response createPatient(String cookie) {
        Map<String, Object> addNewPatientVariables = new HashMap<>();
        addNewPatientVariables.put("generatedID", Helper.generateUuid());
        addNewPatientVariables.put("branch", searchApis.getBranchId(cookie, "Branch_1"));
        addNewPatientVariables.put("firstName", FakerData.getInstance().getFirstName());
        addNewPatientVariables.put("lastName", FakerData.getInstance().getLastName());
        addNewPatientVariables.put("phoneNumber", FakerData.getInstance().getPhoneNumber());
        addNewPatientVariables.put("phoneNumber2", FakerData.getInstance().getPhoneNumber());
        addNewPatientVariables.put("customFields", List.of());
        return GraphQlActions.sendGraphQlRequest(PatientSchema.getInstance().ADD_NEW_PATIENT_MUTATION, addNewPatientVariables, cookie);
    }
}