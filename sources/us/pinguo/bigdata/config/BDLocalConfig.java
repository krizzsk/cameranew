package us.pinguo.bigdata.config;

import java.io.Serializable;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* loaded from: classes3.dex */
public class BDLocalConfig implements Serializable {
    private static final String BD_URL = "https://applog.camera360.com";
    private static final String DEBUG_BD_URL = "https://bdsdktest.camera360.com";
    private static final long serialVersionUID = 7652761246717375624L;
    private int newUser;
    private String cuid = "";
    private boolean debug = false;
    private String appId = "";
    private String secret = "";
    private String cclient = "";
    private String channel = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    private String uid = "";
    private String eid = "";
    private String imei = "";
    private String aid = "";
    private String cid = "";
    private String c360PicCount = "0";
    private String sysPicCount = "0";
    private String screenWidth = "";
    private String screenHeight = "";
    private String newUserTime = "0";
    private String clatitude = "";
    private String clongitude = "";
    private String sdkver = "1.2";
    private String logsource = "mobilelog";
    private String cnetProvider = "";
    private String imsi = "";
    private String advertiserId = "";
    private String androidId = "";

    public String getAndroidId() {
        return this.androidId;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getBdUrl() {
        return BD_URL;
    }

    public String getC360PicCount() {
        return this.c360PicCount;
    }

    public String getCclient() {
        return this.cclient;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getCid() {
        return this.cid;
    }

    public String getCnetProvider() {
        return this.cnetProvider;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public String getDebugBdUrl() {
        return DEBUG_BD_URL;
    }

    public String getEid() {
        return this.eid;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getLogsource() {
        return this.logsource;
    }

    public int getNewUser() {
        return this.newUser;
    }

    public String getNewUserTime() {
        return this.newUserTime;
    }

    public String getScreenHeight() {
        return this.screenHeight;
    }

    public String getSdkVer() {
        return this.sdkver;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getSysPicCount() {
        return this.sysPicCount;
    }

    public void setAdvertiserId(String str) {
        this.advertiserId = str;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public void setAndroidId(String str) {
        this.androidId = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setC360Num(String str) {
        this.c360PicCount = str;
    }

    public void setCclient(String str) {
        this.cclient = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setClatitude(String str) {
        this.clatitude = str;
    }

    public void setClongitude(String str) {
        this.clongitude = str;
    }

    public void setCnetProvider(String str) {
        this.cnetProvider = str;
    }

    public void setCuid(String str) {
        this.cuid = str;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setEid(String str) {
        this.eid = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setNewUserTime(String str) {
        this.newUserTime = str;
    }

    public void setScreenHeight(String str) {
        this.screenHeight = str;
    }

    public void setScreenWidth(String str) {
        this.screenWidth = str;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public void setSysNum(String str) {
        this.sysPicCount = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
