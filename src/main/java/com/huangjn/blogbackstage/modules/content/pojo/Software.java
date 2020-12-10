package com.huangjn.blogbackstage.modules.content.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Software {
    private int softwareId;
    private String softwareName;
    private String softwareLabel;
    private String softwarePhoto;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //软件包的内容，代码里是存放在一起，数据库分开

    private SoftwareContent softwareContent;

    public int getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(int softwareId) {
        this.softwareId = softwareId;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getSoftwareLabel() {
        return softwareLabel;
    }

    public void setSoftwareLabel(String softwareLabel) {
        this.softwareLabel = softwareLabel;
    }

    public String getSoftwarePhoto() {
        return softwarePhoto;
    }

    public void setSoftwarePhoto(String softwarePhoto) {
        this.softwarePhoto = softwarePhoto;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SoftwareContent getSoftwareContent() {
        return softwareContent;
    }

    public void setSoftwareContent(SoftwareContent softwareContent) {
        this.softwareContent = softwareContent;
    }
}
