package us.pinguo.user.util;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: VerifyResponse.kt */
/* loaded from: classes6.dex */
public final class BaseInfoGEO implements NoProguard {
    private String city;
    private String code;
    private String country;
    private String province;

    public BaseInfoGEO(String str, String str2, String str3, String str4) {
        this.code = str;
        this.country = str2;
        this.province = str3;
        this.city = str4;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getProvince() {
        return this.province;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setProvince(String str) {
        this.province = str;
    }
}
