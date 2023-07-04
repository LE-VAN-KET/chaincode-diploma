package io.ketlv;

import com.owlike.genson.Genson;
import com.owlike.genson.annotation.JsonProperty;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.*;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.hyperledger.fabric.shim.ledger.KeyValue;
import org.hyperledger.fabric.shim.ledger.QueryResultsIterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Contract(name = "chaincode",
        info = @Info(
                title = "Diploma contract",
                description = "The hyper legendary diploma contract",
                version = "0.0.1-SNAPSHOT",
                contact = @Contact(
                        email = "anhle1512001@gmail.com"
                )))
@Default
public class EducertContract implements ContractInterface {
    private final Genson genson = new Genson();

    /**
     * Creates a new diploma on the ledger
     */
    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public Diploma issueDiploma(final Context ctx, final String graduationCatalogId, String majorId, final  String studentId,
                                final String fullName, final String dateOfBirth,
                                final String placeOfOrigin, final String sex, final String indigenousId,
                                final String nationalityId, final String rankingId,
                                final String yearGraduation, final String modeOfStudy, final String donviSymbol,
                                final String serialNumber, final String referenceNumber,
                                final String signer, final String signerTitle, String foreignLanguage,
                                String levelForeignLanguage, String dateOfEnrollment,
                                String dateOfGraduation, final String trainingCourse, String dateOfDefend,
                                String hoiDongThi, String decisionNumber,
                                String decisionEstablishingCouncil, final String reqTypeId, String gpa,
                                final String diplomaTypeSymbol,
                                String trainingPeriodSemester, String totalCredits, String diplomaLink, String note,
                                final String status, String createdBy, final String createdDate, final String lastModifiedDate) {
        ChaincodeStub stub = ctx.getStub();

        if (isExistDiploma(ctx, serialNumber, referenceNumber)) {
            String errorMessage = String.format("Diploma %s already exists by serial number % and reference number %s",
                    serialNumber, referenceNumber);
            throw new ChaincodeException(errorMessage, DiplomaErrors.DIPLOMA_ALREADY_EXISTS.toString());
        }

        if (foreignLanguage == null) foreignLanguage = "";
        if (levelForeignLanguage == null) levelForeignLanguage = "";
        if (dateOfEnrollment == null) dateOfEnrollment = "";
        if (dateOfGraduation == null) dateOfGraduation = "";
        if (dateOfDefend == null) dateOfDefend = "";
        if (hoiDongThi == null) hoiDongThi = "";
        if (decisionNumber == null) decisionNumber = "";
        if (decisionEstablishingCouncil == null) decisionEstablishingCouncil  = "";
        if (gpa == null) gpa = "";
        if (trainingPeriodSemester == null) trainingPeriodSemester = "";
        if (totalCredits == null) totalCredits = "";
        if (diplomaLink == null) diplomaLink = "";
        if (note == null) note = "";
        if (createdBy == null) createdBy = "";

        Diploma diploma = new Diploma(graduationCatalogId, majorId, studentId, fullName, dateOfBirth, placeOfOrigin, sex, indigenousId,
                nationalityId, rankingId, yearGraduation, modeOfStudy, donviSymbol, serialNumber, referenceNumber, signer, signerTitle, foreignLanguage,
                levelForeignLanguage, dateOfEnrollment, dateOfGraduation, trainingCourse, dateOfDefend, hoiDongThi, decisionNumber, decisionEstablishingCouncil,
                reqTypeId, gpa, diplomaTypeSymbol, trainingPeriodSemester, totalCredits, diplomaLink, note, status, createdBy, createdDate, lastModifiedDate);
        String diplomaData = genson.serialize(diploma);
        stub.putStringState(serialNumber, diplomaData);
        return diploma;
    }

    /*
     * Get a diploma based on its serial number
     * */
    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public String queryDiplomaBySerialNumber(Context ctx, final String serialNumber) {
        ChaincodeStub stub = ctx.getStub();
        String diploma = stub.getStringState(serialNumber);

        if (diploma == null || diploma.isEmpty()) {
            String errorMessage = String.format("Diploma %s does not exist", serialNumber);
            throw new ChaincodeException(errorMessage, DiplomaErrors.DIPLOMA_NOT_FOUND.toString());
        }
        DiplomaQueryRes res = new DiplomaQueryRes(stub.getTxId(), genson.deserialize(diploma, Diploma.class));
        return genson.serialize(res);
    }

    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public Diploma updateDiploma(final Context ctx, final String serialNumber, final String status, final String diplomaLink) {
        ChaincodeStub stub = ctx.getStub();
        if (!isExistSerialNumber(ctx, serialNumber)) {
            String errorMessage = String.format("Diploma %s does not exist", serialNumber);
            throw new ChaincodeException(errorMessage, DiplomaErrors.DIPLOMA_NOT_FOUND.toString());
        }
        String diploma = stub.getStringState(serialNumber);
        Diploma dip = genson.deserialize(diploma, Diploma.class);
        if (!"".equals(status)) {
            dip.setStatus(status);
        }
        if (!"".equals(diplomaLink)) {
            dip.setDiplomaLink(diplomaLink);
        }
        stub.putStringState(serialNumber, genson.serialize(dip));
        return dip;
    }

    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public String queryAllDiplomas(Context ctx) {
        ChaincodeStub stub = ctx.getStub();

        List<Diploma> resultList = new ArrayList<>();
        QueryResultsIterator<KeyValue> results = stub.getStateByRange("", "");
        for (KeyValue key : results) {
            Diploma diploma = genson.deserialize(key.getStringValue(), Diploma.class);
            resultList.add(diploma);
        }

        return genson.serialize(resultList);
    }

    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public String searchByPersonalInfo(Context ctx, String schoolId, String studentId) {
        ChaincodeStub stub = ctx.getStub();
        byte[] res = stub.getPrivateData("PDC_" + schoolId, studentId);
        return genson.serialize(res);
    }

    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public boolean isExistSerialNumber(Context ctx, final String serialNumber) {
        String diploma = ctx.getStub().getStringState(serialNumber);
        return diploma != null && !diploma.isEmpty();
    }

    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public boolean isExistReferenceNumber(Context ctx, final String referenceNumber) {
        String diploma = ctx.getStub().getStringState(referenceNumber);
        return diploma != null && !diploma.isEmpty();
    }

    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public boolean isExistDiploma(Context ctx, final String serialNumber, final String referenceNumber) {
        return isExistSerialNumber(ctx, serialNumber) && isExistReferenceNumber(ctx, referenceNumber);
    }

    @Transaction(intent = Transaction.TYPE.SUBMIT)
    public void deleteDiploma(final Context ctx, String serialNumber) {
        ChaincodeStub stub = ctx.getStub();

        if (!isExistSerialNumber(ctx, serialNumber)) {
            String errorMsg = String.format("Diploma %s does not exists", serialNumber);
            throw new ChaincodeException(errorMsg, DiplomaErrors.DIPLOMA_NOT_FOUND.toString());
        }

        stub.delState(serialNumber);
    }

    public boolean checkIsNullFields(String... args) {
        for (String field : args) {
            if (field == null) {
                return false;
            }
        }
        return true;
    }

}
