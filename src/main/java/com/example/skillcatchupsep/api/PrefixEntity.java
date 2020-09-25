package com.example.skillcatchupsep.api;

import jp.ac.aiit.pbl.disaster.prefix.Prefix;
import org.seasar.doma.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "prefix")
public class PrefixEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prefixId;
    
    private String preamble;
    
    private String messageType;
    
    private String disasterCategory;
    
    private LocalDateTime reportTime;
    
    private String informationType;
    
    private String spare1;
    
    public PrefixEntity(){}
    
    public PrefixEntity(Prefix prefix){
        this.preamble = prefix.getPreamble().getId();
        this.messageType = prefix.getMessageType().getMessageTypeString();
        this.disasterCategory = prefix.getDisasterCategory().name();
        this.reportTime = prefix.getReportTime();
        this.informationType = prefix.getInformationType().name();
        this.spare1 = prefix.getSpare1().substring(0,8);
    }
    
    public Integer getPrefixId() {
        return prefixId;
    }
    
    public void setPrefixId(Integer prefixId) {
        this.prefixId = prefixId;
    }
    
    public String getPreamble() {
        return preamble;
    }
    
    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }
    
    public String getMessageType() {
        return messageType;
    }
    
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    
    
    public String getDisasterCategory() {
        return disasterCategory;
    }
    
    public void setDisasterCategory(String disasterCategory) {
        this.disasterCategory = disasterCategory;
    }
    
    public LocalDateTime getReportTime() {
        return reportTime;
    }
    
    public void setReportTime(LocalDateTime reportTime) {
        this.reportTime = reportTime;
    }
    
    public String getInformationType() {
        return informationType;
    }
    
    public void setInformationType(String informationType) {
        this.informationType = informationType;
    }
    
    public String getSpare1() {
        return spare1;
    }
    
    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }
}
