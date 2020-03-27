package com.example.ringersschool.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("card_id")
    @Expose
    private String cardId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("fathers_name")
    @Expose
    private String fathersName;
    @SerializedName("mothers_name")
    @Expose
    private String mothersName;
    @SerializedName("guardian_name")
    @Expose
    private String guardianName;
    @SerializedName("religion")
    @Expose
    private String religion;
    @SerializedName("pickup")
    @Expose
    private Object pickup;
    @SerializedName("transport")
    @Expose
    private Object transport;
    @SerializedName("class_roll")
    @Expose
    private String classRoll;
    @SerializedName("cabinet_house")
    @Expose
    private String cabinetHouse;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("exam_class_id")
    @Expose
    private String examClassId;
    @SerializedName("class_group_id")
    @Expose
    private Object classGroupId;
    @SerializedName("section_id")
    @Expose
    private String sectionId;
    @SerializedName("session_id")
    @Expose
    private String sessionId;
    @SerializedName("prev_id")
    @Expose
    private Object prevId;
    @SerializedName("p_status")
    @Expose
    private String pStatus;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Object getPickup() {
        return pickup;
    }

    public void setPickup(Object pickup) {
        this.pickup = pickup;
    }

    public Object getTransport() {
        return transport;
    }

    public void setTransport(Object transport) {
        this.transport = transport;
    }

    public String getClassRoll() {
        return classRoll;
    }

    public void setClassRoll(String classRoll) {
        this.classRoll = classRoll;
    }

    public String getCabinetHouse() {
        return cabinetHouse;
    }

    public void setCabinetHouse(String cabinetHouse) {
        this.cabinetHouse = cabinetHouse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExamClassId() {
        return examClassId;
    }

    public void setExamClassId(String examClassId) {
        this.examClassId = examClassId;
    }

    public Object getClassGroupId() {
        return classGroupId;
    }

    public void setClassGroupId(Object classGroupId) {
        this.classGroupId = classGroupId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Object getPrevId() {
        return prevId;
    }

    public void setPrevId(Object prevId) {
        this.prevId = prevId;
    }

    public String getPStatus() {
        return pStatus;
    }

    public void setPStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}