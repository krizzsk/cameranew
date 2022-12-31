package d.g;

import us.pinguo.advsdk.a.h;
/* compiled from: IGIOFaceBookStatistic.java */
/* loaded from: classes3.dex */
public class b implements h {
    private boolean a;

    public b(boolean z) {
        this.a = z;
    }

    @Override // us.pinguo.advsdk.a.h
    public String a() {
        return this.a ? "facebook_native_show_count" : "facebook_interstial_show_count";
    }

    @Override // us.pinguo.advsdk.a.h
    public String b() {
        return this.a ? "facebook_native_request_failed" : "facebook_interstial_request_failed";
    }

    @Override // us.pinguo.advsdk.a.h
    public String c() {
        return this.a ? "facebook_native_request_success" : "facebook_interstial_request_success";
    }

    @Override // us.pinguo.advsdk.a.h
    public String d() {
        return this.a ? "facebook_native_request_consume" : "facebook_interstial_request_consume";
    }

    @Override // us.pinguo.advsdk.a.h
    public String e() {
        return this.a ? "facebook_native_request_errormsg" : "facebook_interstial_request_errormsg";
    }

    @Override // us.pinguo.advsdk.a.h
    public String f() {
        return this.a ? "facebook_native_request_count" : "facebook_interstial_request_count";
    }
}
