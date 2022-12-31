package us.pinguo.advsdk.manager;

import android.content.Context;
import android.text.TextUtils;
import us.pinguo.advsdk.utils.AdvPrefUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PgAdvAppRunParamsManager.java */
/* loaded from: classes3.dex */
public class e implements us.pinguo.advsdk.a.e {
    private Context a;
    private int b = 0;
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f9065d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context) {
        if (this.a != null || context == null) {
            return;
        }
        this.a = context;
        AdvPrefUtil.getInstance().f(context);
        o();
    }

    private void o() {
        p();
        q();
        String d2 = AdvPrefUtil.getInstance().d("show_num");
        String d3 = AdvPrefUtil.getInstance().d("click_num");
        int i2 = 0;
        try {
            this.b = TextUtils.isEmpty(d2) ? 0 : Integer.valueOf(d2).intValue();
        } catch (Exception unused) {
        }
        try {
            if (!TextUtils.isEmpty(d3)) {
                i2 = Integer.valueOf(d3).intValue();
            }
            this.c = i2;
        } catch (Exception unused2) {
        }
    }

    private synchronized void p() {
        if (TextUtils.isEmpty(AdvPrefUtil.getInstance().d("installtime"))) {
            AdvPrefUtil.getInstance().h("installtime", String.valueOf(System.currentTimeMillis() / 1000));
        }
    }

    private synchronized void q() {
        String d2 = AdvPrefUtil.getInstance().d("lastversion");
        String h2 = us.pinguo.advsdk.utils.d.h(this.a);
        if (TextUtils.isEmpty(h2)) {
            return;
        }
        if (TextUtils.isEmpty(d2) || !h2.equals(d2)) {
            AdvPrefUtil.getInstance().h("lastversion", h2);
            AdvPrefUtil.getInstance().h("upgrade_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
    }

    @Override // us.pinguo.advsdk.a.e
    public String a() {
        if (TextUtils.isEmpty(AdvPrefUtil.getInstance().d("installtime"))) {
            p();
        }
        return AdvPrefUtil.getInstance().d("installtime");
    }

    @Override // us.pinguo.advsdk.a.e
    public int b() {
        return this.c;
    }

    @Override // us.pinguo.advsdk.a.e
    public void c(String str, long j2) {
        AdvPrefUtil.getInstance().g(str, j2);
    }

    @Override // us.pinguo.advsdk.a.e
    public synchronized int d() {
        this.b++;
        AdvPrefUtil.getInstance().h("show_num", String.valueOf(this.b));
        return this.b;
    }

    @Override // us.pinguo.advsdk.a.e
    public int e() {
        if (this.f9065d == 0) {
            this.f9065d = AdvPrefUtil.getInstance().a("start_app_num", 0);
        }
        return this.f9065d;
    }

    @Override // us.pinguo.advsdk.a.e
    public synchronized int f() {
        this.c++;
        AdvPrefUtil.getInstance().h("click_num", String.valueOf(this.c));
        return this.c;
    }

    @Override // us.pinguo.advsdk.a.e
    public int g() {
        return this.b;
    }

    @Override // us.pinguo.advsdk.a.e
    public String getUserAgent() {
        return AdvPrefUtil.getInstance().d("UserAgent");
    }

    @Override // us.pinguo.advsdk.a.e
    public long h() {
        return AdvPrefUtil.getInstance().c("key_call_time", 0L);
    }

    @Override // us.pinguo.advsdk.a.e
    public long i(String str) {
        return AdvPrefUtil.getInstance().c(str, 0L);
    }

    @Override // us.pinguo.advsdk.a.e
    public String j() {
        return AdvPrefUtil.getInstance().d("upgrade_time");
    }

    @Override // us.pinguo.advsdk.a.e
    public synchronized void k(String str) {
        us.pinguo.advsdk.utils.b.a("writeUserAgent mUserAgent =" + str);
        AdvPrefUtil.getInstance().h("UserAgent", str);
    }

    @Override // us.pinguo.advsdk.a.e
    public String l() {
        return AdvPrefUtil.getInstance().d("advertisementid");
    }

    @Override // us.pinguo.advsdk.a.e
    public synchronized void m(String str) {
        us.pinguo.advsdk.utils.b.a("writeUserAgent mUserAgent =" + str);
        AdvPrefUtil.getInstance().h("advertisementid", str);
    }

    @Override // us.pinguo.advsdk.a.e
    public void n(long j2) {
        if (j2 <= 1000) {
            return;
        }
        String a = a();
        if (TextUtils.isEmpty(a)) {
            AdvPrefUtil.getInstance().h("installtime", String.valueOf(j2));
            return;
        }
        long j3 = 0;
        try {
            j3 = Long.parseLong(a);
        } catch (NumberFormatException unused) {
        }
        if (j2 < j3) {
            AdvPrefUtil.getInstance().h("installtime", String.valueOf(j2));
        }
    }
}
