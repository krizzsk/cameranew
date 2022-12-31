package d.g;

import us.pinguo.advsdk.a.h;
/* compiled from: GIOAdmobStatistic.java */
/* loaded from: classes3.dex */
public class a implements h {
    private boolean a;

    public a(boolean z) {
        this.a = z;
    }

    @Override // us.pinguo.advsdk.a.h
    public String a() {
        return this.a ? "google_native_show_count" : "google_interstial_show_count";
    }

    @Override // us.pinguo.advsdk.a.h
    public String b() {
        return this.a ? "google_native_request_failed" : "google_interstial_request_failed";
    }

    @Override // us.pinguo.advsdk.a.h
    public String c() {
        return this.a ? "google_native_request_success" : "google_interstial_request_success";
    }

    @Override // us.pinguo.advsdk.a.h
    public String d() {
        return this.a ? "google_native_request_consume" : "google_interstial_request_consume";
    }

    @Override // us.pinguo.advsdk.a.h
    public String e() {
        return this.a ? "google_native_request_errormsg" : "google_interstial_request_errormsg";
    }

    @Override // us.pinguo.advsdk.a.h
    public String f() {
        return this.a ? "google_native_request_count" : "google_interstial_request_count";
    }
}
