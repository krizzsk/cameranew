package us.pinguo.advsdk.manager;

import android.text.TextUtils;
import java.util.List;
import us.pinguo.advsdk.bean.AdsItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestOrderControl.java */
/* loaded from: classes3.dex */
public class j {
    private List<AdsItem> a;
    private long b;
    private us.pinguo.advsdk.a.b c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.advsdk.a.b f9077d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9078e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9079f = false;

    /* renamed from: g  reason: collision with root package name */
    private long f9080g = 0;

    public List<AdsItem> a() {
        return this.a;
    }

    public us.pinguo.advsdk.a.b b() {
        k(this.c);
        this.c = null;
        return this.f9077d;
    }

    public String c() {
        String str = "";
        for (AdsItem adsItem : this.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("_");
            sb.append(adsItem.c() ? adsItem.offerId : adsItem.placementId);
            String sb2 = sb.toString();
            str = TextUtils.isEmpty(str) ? adsItem.source + sb2 : ((str + "/") + adsItem.source) + sb2;
        }
        return str;
    }

    public String d() {
        String str = "";
        for (AdsItem adsItem : this.a) {
            if (PgAdvManager.getInstance().q().c(adsItem.b())) {
                String str2 = adsItem.source + ":";
                String str3 = adsItem.c() ? str2 + adsItem.offerId : str2 + adsItem.placementId;
                str = TextUtils.isEmpty(str) ? str3 : (str + ",") + str3;
            }
        }
        return str;
    }

    public boolean e() {
        List<AdsItem> list = this.a;
        return list == null || list.size() == 0;
    }

    public boolean f() {
        return this.f9079f;
    }

    public boolean g() {
        return System.currentTimeMillis() - this.f9080g <= 3600000 && this.c != null;
    }

    public boolean h() {
        return this.f9078e;
    }

    public boolean i() {
        return System.currentTimeMillis() - this.b > 60000;
    }

    public void j(List<AdsItem> list) {
        this.a = list;
    }

    public void k(us.pinguo.advsdk.a.b bVar) {
        this.f9077d = bVar;
    }

    public void l(us.pinguo.advsdk.a.b bVar) {
        this.f9080g = System.currentTimeMillis();
        this.c = bVar;
    }

    public void m(boolean z) {
        this.f9078e = z;
    }

    public void n(long j2) {
        this.b = j2;
    }

    public void o() {
        this.f9079f = true;
    }

    public void p() {
        this.f9079f = false;
    }
}
