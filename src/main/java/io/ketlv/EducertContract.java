package io.ketlv;

import com.owlike.genson.Genson;
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
    public Diploma issueDiploma(final Context ctx, final String majorId, final String studentId, final String fullName,
                                final boolean sex, final Date dateOfBirth, final String placeOfOrigin, final String placeOfResidence,
                                final int maDanToc, final int nationalityId, final int rankingId,
                                final String modeTraining, final String schoolId, final String serialNumber, final String referenceNumber,
                                final String trainingCourse, final Date dateOfGraduation,
                                final String signer, final String identitySigner,
                                final String decisionNumber, int requestTypeId,
                                final Double gpa, final String graduation, final String level,
                                final int status, final String trainingPeriodSemester,
                                final int totalCredits, final String trainingLanguage,
                                final String note, final String universitySignature, final String studentSignature) {
        ChaincodeStub stub = ctx.getStub();

        if (isExistDiploma(ctx, serialNumber, referenceNumber)) {
            String errorMessage = String.format("Diploma %s already exists by serial number % and reference number %s",
                    serialNumber, referenceNumber);
            throw new ChaincodeException(errorMessage, DiplomaErrors.DIPLOMA_ALREADY_EXISTS.toString());
        }

        Diploma diploma = new Diploma(majorId, studentId, fullName, sex, dateOfBirth, placeOfOrigin, placeOfResidence,
                maDanToc, nationalityId, rankingId, modeTraining, schoolId, serialNumber, referenceNumber, trainingCourse,
                dateOfGraduation, signer, identitySigner, decisionNumber, requestTypeId, gpa, graduation, level,
                status, trainingPeriodSemester, totalCredits, trainingLanguage, note, universitySignature,
                studentSignature);
        String diplomaData = genson.serialize(diploma);
        stub.putPrivateData("PDC_" + schoolId, serialNumber, diplomaData);
        return diploma;
    }

    /*
     * Get a diploma based on its serial number
     * */
    @Transaction(intent = Transaction.TYPE.EVALUATE)
    public String queryDiplomaBySerialNumber(Context ctx, final String serialNumber, final String schoolId) {
        ChaincodeStub stub = ctx.getStub();
        String diploma = stub.getPrivateDataUTF8("PDC_" + schoolId, serialNumber);

        if (diploma == null || diploma.isEmpty()) {
            String errorMessage = String.format("Diploma %s does not exist", serialNumber);
            throw new ChaincodeException(errorMessage, DiplomaErrors.DIPLOMA_NOT_FOUND.toString());
        }
        DiplomaQueryRes res = new DiplomaQueryRes(stub.getTxId(), genson.deserialize(diploma, Diploma.class));
        return genson.serialize(res);
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
