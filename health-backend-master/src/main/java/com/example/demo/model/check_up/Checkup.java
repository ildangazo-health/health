package com.example.demo.model.check_up;

import  jakarta.persistence.Entity;
import  jakarta.persistence.Id;

@Entity

public class Checkup {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // 여기서는 increasing key로 primary key를 자동생성해주지만, 나는 id를 primary key로 생성해줬기 때문에 필요없다
    private String date; // 이게 id
    private String hospital;
    private int height;
    private int weight;
    private int bodyMass;//체질량지수
    private int waist;//허리둘레
    private int sight;
    private int hearing;
    private int pressure;//고혈압
    private int hemoglobin;//혈색소
    private int bloodsugar;//공복혈당
    private int cholesterol;//총 콜레스테롤
    private int fat;//중성지방
    private int high_cholesterol;//고밀도 콜레스테롤
    private int low_cholesterol;
    private int creatinine;
    private int gfr;//신사구체여과율
    private int ast;
    private int alt;
    private int gpt;
    private String yoprotein;
    private String chest;
    private String medicalHistory;
    private String medicine;//약물치료
    private String smoking;//금연필요
    private String drinking;//절주필요
    private String physicalActivity;
    private String muscularExercise;




    public String getDate(){
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital){
        this.hospital =hospital;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }
    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getBodyMass(){
        return bodyMass;
    }

    public void setBodyMass(int bodyMass){
        this.bodyMass=bodyMass;
    }

    public int getWaist(){
        return waist;
    }
    public void setWaist(int waist){
        this.waist=waist;
    }
    public int getSight(){
        return sight;
    }
    public void setSight(int sight){
        this.sight=sight;
    }
    public int getHearing(){
        return hearing;
    }
    public void setHearing(int hearing){
        this.hearing=hearing;
    }
    public int getPressure(){
        return pressure;
    }
    public void setPressure(int pressure){
        this.pressure=pressure;
    }
    public int getHemoglobin(){
        return hemoglobin;
    }
    public void setHemoglobin(int hemoglobin){
        this.hemoglobin = hemoglobin;
    }
    public int getBloodsugar(){
        return bloodsugar;
    }
    public void setBloodsugar(int bloodsugar){
        this.bloodsugar= bloodsugar;
    }
    public int getCholesterol(){
        return cholesterol;
    }
    public void setCholesterol(int cholesterol){
        this.cholesterol=cholesterol;
    }
    public int getFat(){
        return fat;
    }
    public void setFat(int fat){
        this.fat=fat;
    }

    public int getHigh_cholesterol(){
        return high_cholesterol;
    }

    public void setHigh_cholesterol(int high_cholesterol){
        this.high_cholesterol=high_cholesterol;
    }

    public int getLow_cholesterol(){
        return low_cholesterol;
    }

    public void setLow_cholesterol(int low_cholesterol){
        this.low_cholesterol = low_cholesterol;
    }

    public int getCreatinine(){
        return creatinine;
    }

    public void setCreatinine(int creatinine){
        this.creatinine=creatinine;

    }

    public int getGfr(){
        return gfr;
    }

    public void setGfr(int gfr){
        this.gfr=gfr;
    }
    public int getAst(){
        return ast;
    }
    public void setAst(int ast){
        this.ast=ast;
    }

    public int getAlt(){
        return alt;
    }

    public void setAlt(int alt){
        this.alt=alt;
    }

    public int getGpt(){
        return gpt;
    }
    public void setGpt(int gpt){
        this.gpt=gpt;
    }

    public String getYoprotein() {
        return yoprotein;
    }

    public void setYoprotein(String yoprotein) {
        this.yoprotein = yoprotein;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getDrinking() {
        return drinking;
    }

    public void setDrinking(String drinking) {
        this.drinking = drinking;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getMuscularExercise() {
        return muscularExercise;
    }

    public void setMuscularExercise(String muscularExercise) {
        this.muscularExercise = muscularExercise;
    }

    public String getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(String physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }
}
