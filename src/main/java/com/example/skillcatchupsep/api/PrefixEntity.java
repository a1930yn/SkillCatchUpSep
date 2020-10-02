package com.example.skillcatchupsep.api;

import jp.ac.aiit.pbl.disaster.prefix.Prefix;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(naming = NamingType.LOWER_CASE)
@Table(name = "prefix")
public class PrefixEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prefixid")
    private Integer prefixId;
    
    @Column(name="preamble")
    private String preamble;
    
    @Column(name="messagetype")
    private String messageType;
    
    @Column(name="disastercategory")
    private String disasterCategory;
    
    @Column(name="reporttime")
    private LocalDateTime reportTime;
    
    @Column(name="informationtype")
    private String informationType;
    
    @Column(name="spare1")
    private String spare1;
    
    public PrefixEntity(){}
    
    public PrefixEntity(Prefix prefix){
        this.preamble = prefix.getPreamble().getId();
        this.messageType = prefix.getMessageType().getMessageTypeString();
        this.disasterCategory = prefix.getDisasterCategory().name();
        this.reportTime = prefix.getReportTime();
        this.informationType = prefix.getInformationType().getInformationType();
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
