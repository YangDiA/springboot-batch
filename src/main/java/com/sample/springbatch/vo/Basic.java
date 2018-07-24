package com.sample.springbatch.vo;


public class Basic {

    /** ID */
    Long id ;
    
    Long notiId;

    String firstInputDt;

    String firstInptps;

    String lastUpdtDt;

    String lastAmndr;

    String useYn = "Y";


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNotiId() {
        return notiId;
    }

    public void setNotiId(Long notiId) {
        this.notiId = notiId;
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
}
