package com.spider.saliya.highwaypractice.Bean.RoadKeyId.RoadKeyId;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("ROAD_KEY_ID")
    @Expose
    private String rOADKEYID;
    @SerializedName("ROAD_CLASS_ID")
    @Expose
    private String rOADCLASSID;
    @SerializedName("ROAD_INT")
    @Expose
    private String rOADINT;
    @SerializedName("ROAD_NAME")
    @Expose
    private String rOADNAME;
    @SerializedName("ROAD_NUMBER")
    @Expose
    private String rOADNUMBER;
    @SerializedName("START_PLACE")
    @Expose
    private Object sTARTPLACE;
    @SerializedName("END_PLACE")
    @Expose
    private Object eNDPLACE;
    @SerializedName("START_KM")
    @Expose
    private String sTARTKM;
    @SerializedName("END_KM")
    @Expose
    private String eNDKM;
    @SerializedName("CREATED_DATE")
    @Expose
    private Object cREATEDDATE;
    @SerializedName("CLOSED_DATE")
    @Expose
    private Object cLOSEDDATE;
    @SerializedName("WORKFLOW_STATUS")
    @Expose
    private String wORKFLOWSTATUS;
    @SerializedName("SESSION_ID")
    @Expose
    private String sESSIONID;
    @SerializedName("CREATED_USER_ID")
    @Expose
    private Object cREATEDUSERID;
    @SerializedName("MODIFIED_USER_ID")
    @Expose
    private Object mODIFIEDUSERID;
    @SerializedName("REC_CREATED_DATE")
    @Expose
    private Object rECCREATEDDATE;
    @SerializedName("REC_MODIFIED_DATE")
    @Expose
    private Object rECMODIFIEDDATE;
    @SerializedName("ROAD_NAME_T")
    @Expose
    private String rOADNAMET;
    @SerializedName("START_PLACE_T")
    @Expose
    private Object sTARTPLACET;
    @SerializedName("END_PLACE_T")
    @Expose
    private Object eNDPLACET;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param cREATEDUSERID
     * @param rOADKEYID
     * @param rOADCLASSID
     * @param rOADINT
     * @param eNDPLACE
     * @param rOADNAMET
     * @param cLOSEDDATE
     * @param sTARTPLACE
     * @param eNDKM
     * @param rECCREATEDDATE
     * @param mODIFIEDUSERID
     * @param rOADNUMBER
     * @param sTARTPLACET
     * @param rOADNAME
     * @param sTARTKM
     * @param eNDPLACET
     * @param rECMODIFIEDDATE
     * @param cREATEDDATE
     * @param wORKFLOWSTATUS
     * @param sESSIONID
     */
    public Datum(String rOADKEYID, String rOADCLASSID, String rOADINT, String rOADNAME, String rOADNUMBER, Object sTARTPLACE, Object eNDPLACE, String sTARTKM, String eNDKM, Object cREATEDDATE, Object cLOSEDDATE, String wORKFLOWSTATUS, String sESSIONID, Object cREATEDUSERID, Object mODIFIEDUSERID, Object rECCREATEDDATE, Object rECMODIFIEDDATE, String rOADNAMET, Object sTARTPLACET, Object eNDPLACET) {
        super();
        this.rOADKEYID = rOADKEYID;
        this.rOADCLASSID = rOADCLASSID;
        this.rOADINT = rOADINT;
        this.rOADNAME = rOADNAME;
        this.rOADNUMBER = rOADNUMBER;
        this.sTARTPLACE = sTARTPLACE;
        this.eNDPLACE = eNDPLACE;
        this.sTARTKM = sTARTKM;
        this.eNDKM = eNDKM;
        this.cREATEDDATE = cREATEDDATE;
        this.cLOSEDDATE = cLOSEDDATE;
        this.wORKFLOWSTATUS = wORKFLOWSTATUS;
        this.sESSIONID = sESSIONID;
        this.cREATEDUSERID = cREATEDUSERID;
        this.mODIFIEDUSERID = mODIFIEDUSERID;
        this.rECCREATEDDATE = rECCREATEDDATE;
        this.rECMODIFIEDDATE = rECMODIFIEDDATE;
        this.rOADNAMET = rOADNAMET;
        this.sTARTPLACET = sTARTPLACET;
        this.eNDPLACET = eNDPLACET;
    }

    public String getROADKEYID() {
        return rOADKEYID;
    }

    public void setROADKEYID(String rOADKEYID) {
        this.rOADKEYID = rOADKEYID;
    }

    public String getROADCLASSID() {
        return rOADCLASSID;
    }

    public void setROADCLASSID(String rOADCLASSID) {
        this.rOADCLASSID = rOADCLASSID;
    }

    public String getROADINT() {
        return rOADINT;
    }

    public void setROADINT(String rOADINT) {
        this.rOADINT = rOADINT;
    }

    public String getROADNAME() {
        return rOADNAME;
    }

    public void setROADNAME(String rOADNAME) {
        this.rOADNAME = rOADNAME;
    }

    public String getROADNUMBER() {
        return rOADNUMBER;
    }

    public void setROADNUMBER(String rOADNUMBER) {
        this.rOADNUMBER = rOADNUMBER;
    }

    public Object getSTARTPLACE() {
        return sTARTPLACE;
    }

    public void setSTARTPLACE(Object sTARTPLACE) {
        this.sTARTPLACE = sTARTPLACE;
    }

    public Object getENDPLACE() {
        return eNDPLACE;
    }

    public void setENDPLACE(Object eNDPLACE) {
        this.eNDPLACE = eNDPLACE;
    }

    public String getSTARTKM() {
        return sTARTKM;
    }

    public void setSTARTKM(String sTARTKM) {
        this.sTARTKM = sTARTKM;
    }

    public String getENDKM() {
        return eNDKM;
    }

    public void setENDKM(String eNDKM) {
        this.eNDKM = eNDKM;
    }

    public Object getCREATEDDATE() {
        return cREATEDDATE;
    }

    public void setCREATEDDATE(Object cREATEDDATE) {
        this.cREATEDDATE = cREATEDDATE;
    }

    public Object getCLOSEDDATE() {
        return cLOSEDDATE;
    }

    public void setCLOSEDDATE(Object cLOSEDDATE) {
        this.cLOSEDDATE = cLOSEDDATE;
    }

    public String getWORKFLOWSTATUS() {
        return wORKFLOWSTATUS;
    }

    public void setWORKFLOWSTATUS(String wORKFLOWSTATUS) {
        this.wORKFLOWSTATUS = wORKFLOWSTATUS;
    }

    public String getSESSIONID() {
        return sESSIONID;
    }

    public void setSESSIONID(String sESSIONID) {
        this.sESSIONID = sESSIONID;
    }

    public Object getCREATEDUSERID() {
        return cREATEDUSERID;
    }

    public void setCREATEDUSERID(Object cREATEDUSERID) {
        this.cREATEDUSERID = cREATEDUSERID;
    }

    public Object getMODIFIEDUSERID() {
        return mODIFIEDUSERID;
    }

    public void setMODIFIEDUSERID(Object mODIFIEDUSERID) {
        this.mODIFIEDUSERID = mODIFIEDUSERID;
    }

    public Object getRECCREATEDDATE() {
        return rECCREATEDDATE;
    }

    public void setRECCREATEDDATE(Object rECCREATEDDATE) {
        this.rECCREATEDDATE = rECCREATEDDATE;
    }

    public Object getRECMODIFIEDDATE() {
        return rECMODIFIEDDATE;
    }

    public void setRECMODIFIEDDATE(Object rECMODIFIEDDATE) {
        this.rECMODIFIEDDATE = rECMODIFIEDDATE;
    }

    public String getROADNAMET() {
        return rOADNAMET;
    }

    public void setROADNAMET(String rOADNAMET) {
        this.rOADNAMET = rOADNAMET;
    }

    public Object getSTARTPLACET() {
        return sTARTPLACET;
    }

    public void setSTARTPLACET(Object sTARTPLACET) {
        this.sTARTPLACET = sTARTPLACET;
    }

    public Object getENDPLACET() {
        return eNDPLACET;
    }

    public void setENDPLACET(Object eNDPLACET) {
        this.eNDPLACET = eNDPLACET;
    }
}
