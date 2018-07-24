package com.sample.springbatch.vo;


public class Sample extends Basic{

    /** ID */
    private Long id;

    private String firstInputDt;

    private String firstInptps;

    private String lastUpdtDt;

    private String lastAmndr;

    private String useYn = "Y";
    
    private String prfId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstInputDt() {
        return firstInputDt;
    }

    public void setFirstInputDt(String firstInputDt) {
        this.firstInputDt = firstInputDt;
    }

    public String getFirstInptps() {
        return firstInptps;
    }

    public void setFirstInptps(String firstInptps) {
        this.firstInptps = firstInptps;
    }

    public String getLastUpdtDt() {
        return lastUpdtDt;
    }

    public void setLastUpdtDt(String lastUpdtDt) {
        this.lastUpdtDt = lastUpdtDt;
    }

    public String getLastAmndr() {
        return lastAmndr;
    }

    public void setLastAmndr(String lastAmndr) {
        this.lastAmndr = lastAmndr;
    }

    public String getUseYn() {
        return useYn;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public String getPrfId() {
        return prfId;
    }

    public void setPrfId(String prfId) {
        this.prfId = prfId;
    }
}
