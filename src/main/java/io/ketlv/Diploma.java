package io.ketlv;

import com.owlike.genson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import java.util.Date;

/*
 * @author: levanket
 * @since: 29/04/2023 10:25
 * @description: Entity Diploma save into ledger blockchain
 * @update:
 **/
@DataType
public class Diploma {
    @Property
    private final String majorId;
    @Property
    private final String studentId;
    @Property
    private final String fullName;
    private final boolean sex; /* Male = 1 | FerMale = 0 */
    @Property
    private final Date dateOfBirth;
    @Property
    private final String placeOfOrigin;
    @Property
    private final String placeOfResidence;
    @Property
    private final int maDanToc;
    @Property
    private final int nationalityId;
    @Property
    private final int rankingId;
    @Property
    private final String modeTraining;
    @Property
    private final String schoolId;
    @Property
    private final String serialNumber;
    @Property
    private final String referenceNumber;
    @Property
    private final String trainingCourse;
    @Property
    private final Date dateOfGraduation;
    @Property
    private final String signer;
    @Property
    private final String identitySigner; /*Chuc danh nguoi ky*/
    @Property
    private final String decisionNumber; /* QĐ/ĐH/2019-123456 */
    @Property
    private final int requestTypeId;
    @Property
    private final Double gpa;
    @Property
    private final String graduation;
    @Property
    private final String level;
    @Property
    private final int status;
    @Property
    private final String trainingPeriodSemester;
    @Property
    private final int totalCredits;
    @Property
    private final String trainingLanguage;
    @Property
    private final String note;
    @Property
    private final String universitySignature;
    @Property
    private final String studentSignature;

    public Diploma(@JsonProperty("majorId") String majorId, @JsonProperty("studentId") String studentId, @JsonProperty("fullName") String fullName,
                   @JsonProperty("sex") boolean sex, @JsonProperty("dateOfBirth") Date dateOfBirth, @JsonProperty("placeOfOrigin") String placeOfOrigin,
                   @JsonProperty("placeOfResidence") String placeOfResidence, @JsonProperty("maDanToc") int maDanToc,
                   @JsonProperty("nationalityId") int nationalityId, @JsonProperty("rankingId") int rankingId,
                   @JsonProperty("modeTraining") String modeTraining, @JsonProperty("schoolId") String schoolId,
                   @JsonProperty("serialNumber") String serialNumber, @JsonProperty("referenceNumber") String referenceNumber,
                   @JsonProperty("trainingCourse") String trainingCourse, @JsonProperty("dateOfGraduation") Date dateOfGraduation,
                   @JsonProperty("signer") String signer, @JsonProperty("identitySigner") String identitySigner,
                   @JsonProperty("decisionNumber") String decisionNumber, @JsonProperty("requestTypeId") int requestTypeId,
                   @JsonProperty("gpa") Double gpa, @JsonProperty("graduation") String graduation, @JsonProperty("level") String level,
                   @JsonProperty("status") int status, @JsonProperty("trainingPeriodSemester") String trainingPeriodSemester,
                   @JsonProperty("totalCredits") int totalCredits, @JsonProperty("trainingLanguage") String trainingLanguage,
                   @JsonProperty("note") String note, @JsonProperty("universitySignature") String universitySignature,
                   @JsonProperty("studentSignature") String studentSignature) {
        this.majorId = majorId;
        this.studentId = studentId;
        this.fullName = fullName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.placeOfOrigin = placeOfOrigin;
        this.placeOfResidence = placeOfResidence;
        this.maDanToc = maDanToc;
        this.nationalityId = nationalityId;
        this.rankingId = rankingId;
        this.modeTraining = modeTraining;
        this.schoolId = schoolId;
        this.serialNumber = serialNumber;
        this.referenceNumber = referenceNumber;
        this.trainingCourse = trainingCourse;
        this.dateOfGraduation = dateOfGraduation;
        this.signer = signer;
        this.identitySigner = identitySigner;
        this.decisionNumber = decisionNumber;
        this.requestTypeId = requestTypeId;
        this.gpa = gpa;
        this.graduation = graduation;
        this.level = level;
        this.status = status;
        this.trainingPeriodSemester = trainingPeriodSemester;
        this.totalCredits = totalCredits;
        this.trainingLanguage = trainingLanguage;
        this.note = note;
        this.universitySignature = universitySignature;
        this.studentSignature = studentSignature;
    }

    public String getUniversitySignature() {
        return universitySignature;
    }

    public String getStudentSignature() {
        return studentSignature;
    }

    public String getMajorId() {
        return majorId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isSex() {
        return sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public int getMaDanToc() {
        return maDanToc;
    }

    public int getNationalityId() {
        return nationalityId;
    }

    public int getRankingId() {
        return rankingId;
    }

    public String getModeTraining() {
        return modeTraining;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getTrainingCourse() {
        return trainingCourse;
    }

    public Date getDateOfGraduation() {
        return dateOfGraduation;
    }

    public String getSigner() {
        return signer;
    }

    public String getIdentitySigner() {
        return identitySigner;
    }

    public String getDecisionNumber() {
        return decisionNumber;
    }

    public int getRequestTypeId() {
        return requestTypeId;
    }

    public Double getGpa() {
        return gpa;
    }

    public String getGraduation() {
        return graduation;
    }

    public String getLevel() {
        return level;
    }

    public int getStatus() {
        return status;
    }

    public String getTrainingPeriodSemester() {
        return trainingPeriodSemester;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public String getTrainingLanguage() {
        return trainingLanguage;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Diploma diploma = (Diploma) o;

        return new EqualsBuilder().append(sex, diploma.sex).append(maDanToc, diploma.maDanToc).append(nationalityId, diploma.nationalityId).append(rankingId, diploma.rankingId).append(requestTypeId, diploma.requestTypeId).append(status, diploma.status).append(totalCredits, diploma.totalCredits).append(majorId, diploma.majorId).append(studentId, diploma.studentId).append(fullName, diploma.fullName).append(dateOfBirth, diploma.dateOfBirth).append(placeOfOrigin, diploma.placeOfOrigin).append(placeOfResidence, diploma.placeOfResidence).append(modeTraining, diploma.modeTraining).append(schoolId, diploma.schoolId).append(serialNumber, diploma.serialNumber).append(referenceNumber, diploma.referenceNumber).append(trainingCourse, diploma.trainingCourse).append(dateOfGraduation, diploma.dateOfGraduation).append(signer, diploma.signer).append(identitySigner, diploma.identitySigner).append(decisionNumber, diploma.decisionNumber).append(gpa, diploma.gpa).append(graduation, diploma.graduation).append(level, diploma.level).append(trainingPeriodSemester, diploma.trainingPeriodSemester).append(trainingLanguage, diploma.trainingLanguage).append(note, diploma.note).append(universitySignature, diploma.universitySignature).append(studentSignature, diploma.studentSignature).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(majorId).append(studentId).append(fullName).append(sex).append(dateOfBirth).append(placeOfOrigin).append(placeOfResidence).append(maDanToc).append(nationalityId).append(rankingId).append(modeTraining).append(schoolId).append(serialNumber).append(referenceNumber).append(trainingCourse).append(dateOfGraduation).append(signer).append(identitySigner).append(decisionNumber).append(requestTypeId).append(gpa).append(graduation).append(level).append(status).append(trainingPeriodSemester).append(totalCredits).append(trainingLanguage).append(note).append(universitySignature).append(studentSignature).toHashCode();
    }
}
