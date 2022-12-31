package us.pinguo.user.model;
/* loaded from: classes6.dex */
public class CityZones {
    private String cc;
    private String code;
    private String zone;

    public CityZones(String str, String str2, String str3) {
        this.zone = str;
        this.cc = str3;
        this.code = str2;
    }

    public String getCc() {
        return this.cc;
    }

    public String getCode() {
        return this.code;
    }

    public String getZone() {
        return this.zone;
    }

    public void setCc(String str) {
        this.cc = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setZone(String str) {
        this.zone = str;
    }
}
