package com.example.skillcatchupsep.api;

import jp.ac.aiit.pbl.disaster.prefix.Prefix;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(naming = NamingType.LOWER_CASE)
@Table(name = "sse")
public class SseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prefixid")
    private Integer prefixId;

    @Column(name="messagetype")
    private String messageType;

    @Column(name="disastercategory")
    private String disasterCategory;

    @Column(name="originaldata")
    private String originaldata;

    public SseEntity(){}

    public SseEntity(Prefix prefix , String originaldata){
        this.messageType = prefix.getMessageType().getMessageTypeString();
        this.disasterCategory = prefix.getDisasterCategory().name();
        this.originaldata = originaldata;
    }

    public Integer getPrefixId() {
        return prefixId;
    }

    public void setPrefixId(Integer prefixId) {
        this.prefixId = prefixId;
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

    public String getOriginaldata() {
        return originaldata;
    }

    public void setOriginaldata(String originaldata) {
        this.originaldata = originaldata;
    }
}

