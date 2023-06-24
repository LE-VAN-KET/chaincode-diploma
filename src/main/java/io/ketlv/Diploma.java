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
    private final String graduationCatalogId;
    @Property
    private final String majorId;
    @Property
    private final String studentId;
    @Property
    private final String fullName;
    @Property
    private final String dateOfBirth;
    @Property
    private final String placeOfOrigin;
    @Property
    private final String sex; /* Male = 1 | FerMale = 0 */
    @Property
    private final String indigenousId;
    @Property
    private final String nationalityId;
    @Property
    private final String rankingId;
    @Property
    private final String yearGraduation;
    @Property
    private final String modeOfStudy;
    @Property
    private final String donviSymbol;
    @Property
    private final String serialNumber;
    @Property
    private final String referenceNumber;
    @Property
    private final String signer;
    @Property
    private final String signerTitle;
    @Property
    private final String foreignLanguage;
    @Property
    private final String levelForeignLanguage;
    @Property
    private final String dateOfEnrollment;
    @Property
    private final String dateOfGraduation;
    @Property
    private final String trainingCourse;
    @Property
    private final String dateOfDefend;
    @Property
    private final String hoiDongThi;
    @Property
    private final String decisionNumber; /* QĐ/ĐH/2019-123456 */
    @Property
    private final String decisionEstablishingCouncil;
    @Property
    private final String reqTypeId;
    @Property
    private final String gpa;
    @Property
    private final String diplomaTypeSymbol;
    @Property
    private final String trainingPeriodSemester;
    @Property
    private final String totalCredits;
    @Property
    private final String diplomaLink;
    @Property
    private final String note;
    @Property
    private final String status;
    @Property
    private final String createdBy;
    @Property
    private final String createdDate;
    @Property
    private final String lastModifiedDate;


    public Diploma(@JsonProperty("graduationCatalogId") String graduationCatalogId, @JsonProperty("majorId") String majorId,@JsonProperty("studentId")  String studentId,
                   @JsonProperty("fullName")String fullName, @JsonProperty("dateOfBirth")String dateOfBirth,
                   @JsonProperty("placeOfOrigin")String placeOfOrigin,@JsonProperty("sex") String sex, @JsonProperty("indigenousId")String indigenousId,
                   @JsonProperty("nationalityId")String nationalityId, @JsonProperty("rankingId")String rankingId,
                   @JsonProperty("yearGraduation")String yearGraduation, @JsonProperty("modeOfStudy")String modeOfStudy, @JsonProperty("donviSymbol")String donviSymbol,
                   @JsonProperty("serialNumber")String serialNumber, @JsonProperty("referenceNumber")String referenceNumber,
                   @JsonProperty("signer")String signer, @JsonProperty("signerTitle")String signerTitle, @JsonProperty("foreignLanguage")String foreignLanguage,
                   @JsonProperty("levelForeignLanguage")String levelForeignLanguage, @JsonProperty("dateOfEnrollment")String dateOfEnrollment,
                   @JsonProperty("dateOfGraduation")String dateOfGraduation, @JsonProperty("trainingCourse")String trainingCourse, @JsonProperty("dateOfDefend")String dateOfDefend,
                   @JsonProperty("hoiDongThi")String hoiDongThi, @JsonProperty("decisionNumber")String decisionNumber,
                   @JsonProperty("decisionEstablishingCouncil")String decisionEstablishingCouncil, @JsonProperty("reqTypeId")String reqTypeId, @JsonProperty("gpa")String gpa,
                   @JsonProperty("diplomaTypeSymbol")String diplomaTypeSymbol,
                   @JsonProperty("trainingPeriodSemester")String trainingPeriodSemester, @JsonProperty("totalCredits")String totalCredits, @JsonProperty("diplomaLink")String diplomaLink,
                   @JsonProperty("note")String note,
                   @JsonProperty("status")String status, @JsonProperty("createdBy")String createdBy, @JsonProperty("createdDate")String createdDate,
                   @JsonProperty("lastModifiedDate")String lastModifiedDate) {
        this.graduationCatalogId = graduationCatalogId;
        this.majorId = majorId;
        this.studentId = studentId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfOrigin = placeOfOrigin;
        this.sex = sex;
        this.indigenousId = indigenousId;
        this.nationalityId = nationalityId;
        this.rankingId = rankingId;
        this.yearGraduation = yearGraduation;
        this.modeOfStudy = modeOfStudy;
        this.donviSymbol = donviSymbol;
        this.serialNumber = serialNumber;
        this.referenceNumber = referenceNumber;
        this.signer = signer;
        this.signerTitle = signerTitle;
        this.foreignLanguage = foreignLanguage;
        this.levelForeignLanguage = levelForeignLanguage;
        this.dateOfEnrollment = dateOfEnrollment;
        this.dateOfGraduation = dateOfGraduation;
        this.trainingCourse = trainingCourse;
        this.dateOfDefend = dateOfDefend;
        this.hoiDongThi = hoiDongThi;
        this.decisionNumber = decisionNumber;
        this.decisionEstablishingCouncil = decisionEstablishingCouncil;
        this.reqTypeId = reqTypeId;
        this.gpa = gpa;
        this.diplomaTypeSymbol = diplomaTypeSymbol;
        this.trainingPeriodSemester = trainingPeriodSemester;
        this.totalCredits = totalCredits;
        this.note = note;
        this.status = status;
        this.diplomaLink = diplomaLink;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getGraduationCatalogId() {
        return graduationCatalogId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public String isSex() {
        return sex;
    }

    public String getIndigenousId() {
        return indigenousId;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public String getRankingId() {
        return rankingId;
    }

    public String getYearGraduation() {
        return yearGraduation;
    }

    public String getModeOfStudy() {
        return modeOfStudy;
    }

    public String getDonviSymbol() {
        return donviSymbol;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getSigner() {
        return signer;
    }

    public String getSignerTitle() {
        return signerTitle;
    }

    public String getForeignLanguage() {
        return foreignLanguage;
    }

    public String getLevelForeignLanguage() {
        return levelForeignLanguage;
    }

    public String getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public String getDateOfGraduation() {
        return dateOfGraduation;
    }

    public String getTrainingCourse() {
        return trainingCourse;
    }

    public String getDateOfDefend() {
        return dateOfDefend;
    }

    public String getHoiDongThi() {
        return hoiDongThi;
    }

    public String getDecisionNumber() {
        return decisionNumber;
    }

    public String getDecisionEstablishingCouncil() {
        return decisionEstablishingCouncil;
    }

    public String getreqTypeId() {
        return reqTypeId;
    }

    public String getGpa() {
        return gpa;
    }

    public String getDiplomaTypeSymbol() {
        return diplomaTypeSymbol;
    }

    public String getTrainingPeriodSemester() {
        return trainingPeriodSemester;
    }

    public String getTotalCredits() {
        return totalCredits;
    }

    public String getNote() {
        return note;
    }

    public String getStatus() {
        return status;
    }

    public String getSex() {
        return sex;
    }

    public String getReqTypeId() {
        return reqTypeId;
    }

    public String getDiplomaLink() {
        return diplomaLink;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        Diploma diploma = (Diploma) object;

        return new org.apache.commons.lang3.builder.EqualsBuilder().appendSuper(super.equals(object)).append(graduationCatalogId, diploma.graduationCatalogId).append(majorId, diploma.majorId).append(studentId, diploma.studentId).append(fullName, diploma.fullName).append(dateOfBirth, diploma.dateOfBirth).append(placeOfOrigin, diploma.placeOfOrigin).append(sex, diploma.sex).append(indigenousId, diploma.indigenousId).append(nationalityId, diploma.nationalityId).append(rankingId, diploma.rankingId).append(yearGraduation, diploma.yearGraduation).append(modeOfStudy, diploma.modeOfStudy).append(donviSymbol, diploma.donviSymbol).append(serialNumber, diploma.serialNumber).append(referenceNumber, diploma.referenceNumber).append(signer, diploma.signer).append(signerTitle, diploma.signerTitle).append(foreignLanguage, diploma.foreignLanguage).append(levelForeignLanguage, diploma.levelForeignLanguage).append(dateOfEnrollment, diploma.dateOfEnrollment).append(dateOfGraduation, diploma.dateOfGraduation).append(trainingCourse, diploma.trainingCourse).append(dateOfDefend, diploma.dateOfDefend).append(hoiDongThi, diploma.hoiDongThi).append(decisionNumber, diploma.decisionNumber).append(decisionEstablishingCouncil, diploma.decisionEstablishingCouncil).append(reqTypeId, diploma.reqTypeId).append(gpa, diploma.gpa).append(diplomaTypeSymbol, diploma.diplomaTypeSymbol).append(trainingPeriodSemester, diploma.trainingPeriodSemester).append(totalCredits, diploma.totalCredits).append(diplomaLink, diploma.diplomaLink).append(note, diploma.note).append(status, diploma.status).append(createdBy, diploma.createdBy).append(createdDate, diploma.createdDate).append(lastModifiedDate, diploma.lastModifiedDate).isEquals();
    }

    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(graduationCatalogId).append(majorId).append(studentId).append(fullName).append(dateOfBirth).append(placeOfOrigin).append(sex).append(indigenousId).append(nationalityId).append(rankingId).append(yearGraduation).append(modeOfStudy).append(donviSymbol).append(serialNumber).append(referenceNumber).append(signer).append(signerTitle).append(foreignLanguage).append(levelForeignLanguage).append(dateOfEnrollment).append(dateOfGraduation).append(trainingCourse).append(dateOfDefend).append(hoiDongThi).append(decisionNumber).append(decisionEstablishingCouncil).append(reqTypeId).append(gpa).append(diplomaTypeSymbol).append(trainingPeriodSemester).append(totalCredits).append(diplomaLink).append(note).append(status).append(createdBy).append(createdDate).append(lastModifiedDate).toHashCode();
    }
}
