package us.pinguo.user.util;

import com.tapjoy.TJAdUnitConstants;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: VerifyResponse.kt */
/* loaded from: classes6.dex */
public final class BaseInfoResult implements NoProguard {
    private BaseInfoGEO geo;
    private String shareSwitch;

    public BaseInfoResult(String str, BaseInfoGEO baseInfoGEO) {
        this.shareSwitch = str;
        this.geo = baseInfoGEO;
    }

    public final BaseInfoGEO getGeo() {
        return this.geo;
    }

    public final String getShareSwitch() {
        return this.shareSwitch;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r2 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isChina() {
        /*
            r3 = this;
            boolean r0 = us.pinguo.foundation.utils.i.c()
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            us.pinguo.user.util.BaseInfoGEO r0 = r3.geo
            if (r0 != 0) goto Le
            r0 = 0
            goto L12
        Le:
            java.lang.String r0 = r0.getCode()
        L12:
            if (r0 == 0) goto L1a
            boolean r2 = kotlin.text.l.p(r0)
            if (r2 == 0) goto L22
        L1a:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.getCountry()
        L22:
            java.lang.String r2 = "CN"
            boolean r2 = kotlin.jvm.internal.s.c(r2, r0)
            if (r2 != 0) goto L42
            java.lang.String r2 = "HK"
            boolean r2 = kotlin.jvm.internal.s.c(r2, r0)
            if (r2 != 0) goto L42
            java.lang.String r2 = "TW"
            boolean r2 = kotlin.jvm.internal.s.c(r2, r0)
            if (r2 != 0) goto L42
            java.lang.String r2 = "MO"
            boolean r0 = kotlin.jvm.internal.s.c(r2, r0)
            if (r0 == 0) goto L43
        L42:
            r1 = 1
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.user.util.BaseInfoResult.isChina():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
        if (r1 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isMainlandChina() {
        /*
            r2 = this;
            boolean r0 = us.pinguo.foundation.utils.i.c()
            if (r0 == 0) goto L8
            r0 = 0
            return r0
        L8:
            us.pinguo.user.util.BaseInfoGEO r0 = r2.geo
            if (r0 != 0) goto Le
            r0 = 0
            goto L12
        Le:
            java.lang.String r0 = r0.getCode()
        L12:
            if (r0 == 0) goto L1a
            boolean r1 = kotlin.text.l.p(r0)
            if (r1 == 0) goto L22
        L1a:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.getCountry()
        L22:
            java.lang.String r1 = "CN"
            boolean r0 = kotlin.jvm.internal.s.c(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.user.util.BaseInfoResult.isMainlandChina():boolean");
    }

    public final boolean isShareOn() {
        return s.c(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON, this.shareSwitch);
    }

    public final void setGeo(BaseInfoGEO baseInfoGEO) {
        this.geo = baseInfoGEO;
    }

    public final void setShareSwitch(String str) {
        this.shareSwitch = str;
    }
}
