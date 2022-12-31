package us.pinguo.advsdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import us.pinguo.advsdk.a.b;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: BaseNativeRequest.java */
/* loaded from: classes3.dex */
public abstract class d<T extends b> extends a<T> {

    /* renamed from: g  reason: collision with root package name */
    protected long f9039g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected us.pinguo.advsdk.bean.b f9040h;

    /* renamed from: i  reason: collision with root package name */
    private h f9041i;

    public d(AdsItem adsItem) {
        this.f9034e = adsItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(long j2) {
        if (this.f9041i == null) {
            return;
        }
        AdsItem adsItem = this.f9034e;
        us.pinguo.advsdk.statistic.a.a.b(adsItem.source, !adsItem.f(), j2);
        if (TextUtils.isEmpty(this.f9041i.d())) {
            return;
        }
        String d2 = this.f9041i.d();
        us.pinguo.advsdk.statistic.b.a.a(d2, "" + (j2 / 1000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(String str) {
        h hVar = this.f9041i;
        if (hVar == null || TextUtils.isEmpty(hVar.b())) {
            return;
        }
        us.pinguo.advsdk.statistic.b.a.a(this.f9041i.b(), this.f9040h.c);
        us.pinguo.advsdk.statistic.b.a.b(this.f9040h.c + ":" + this.f9041i.e(), str);
        us.pinguo.advsdk.statistic.a.a.c("third_req_failed", this.f9034e.source, this.f9040h.c);
        AdsItem adsItem = this.f9034e;
        us.pinguo.advsdk.statistic.a.a.d(adsItem.source, adsItem.f(), this.f9040h.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        h hVar = this.f9041i;
        if (hVar == null || TextUtils.isEmpty(hVar.a())) {
            return;
        }
        us.pinguo.advsdk.statistic.b.a.a(this.f9041i.a(), this.f9040h.c);
        us.pinguo.advsdk.statistic.a.a.c("third_req_show", this.f9034e.source, this.f9040h.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
        h hVar = this.f9041i;
        if (hVar == null || TextUtils.isEmpty(hVar.f())) {
            return;
        }
        us.pinguo.advsdk.statistic.b.a.a(this.f9041i.f(), this.f9040h.c);
        us.pinguo.advsdk.statistic.a.a.c("third_req_count", this.f9034e.source, this.f9040h.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        h hVar = this.f9041i;
        if (hVar == null || TextUtils.isEmpty(hVar.c())) {
            return;
        }
        us.pinguo.advsdk.statistic.b.a.a(this.f9041i.c(), this.f9040h.c);
        us.pinguo.advsdk.statistic.a.a.c("third_req_success", this.f9034e.source, this.f9040h.c);
    }

    @Override // us.pinguo.advsdk.a.a
    public int h() {
        return m();
    }

    @Override // us.pinguo.advsdk.a.a
    public boolean i() {
        if (this.a.size() > 0 && this.c != null) {
            x(o());
            return true;
        }
        if (this.b) {
            if (System.currentTimeMillis() - this.f9039g >= p()) {
                this.b = false;
            } else {
                us.pinguo.advsdk.utils.b.a(q() + ":is requesting");
                return true;
            }
        }
        if (System.currentTimeMillis() - this.f9039g <= p()) {
            t(q() + ": request space must bigger than 30s");
            us.pinguo.advsdk.utils.b.a(q() + ": request space must bigger than 30s");
            return true;
        }
        WeakReference<Context> weakReference = this.f9033d;
        if (weakReference != null && weakReference.get() != null) {
            if (r()) {
                t("mAdsitem is null placementid is null");
                us.pinguo.advsdk.utils.b.a(q() + "mAdsitem is null placementid is null");
                return true;
            }
            this.f9039g = System.currentTimeMillis();
            this.b = true;
            us.pinguo.advsdk.utils.b.a(q() + ":start load");
            return false;
        }
        us.pinguo.advsdk.utils.b.a(q() + " request context is null");
        t(q() + " request context is null");
        return true;
    }

    @Override // us.pinguo.advsdk.a.a
    public void k(Context context, k kVar, us.pinguo.advsdk.bean.b bVar, AdsItem adsItem) {
        this.f9034e = adsItem;
        this.f9033d = new WeakReference<>(context);
        this.f9040h = bVar;
        this.c = kVar;
        this.f9039g = 0L;
        z(false);
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(T t) {
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.a.add(t);
    }

    public abstract int m();

    protected String n() {
        AdsItem adsItem = this.f9034e;
        return adsItem == null ? "" : "interstitial".equals(adsItem.displayFormat) ? "interstitial" : "interstitial_appwall".equalsIgnoreCase(this.f9034e.displayFormat) ? "interstitial_appwall" : "interstitial_video".equalsIgnoreCase(this.f9034e.displayFormat) ? "interstitial_video" : "";
    }

    public b o() {
        if (this.a.size() <= 0) {
            return null;
        }
        return this.a.remove(0);
    }

    public int p() {
        return BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String q() {
        if (this.f9040h == null || this.f9034e == null) {
            return null;
        }
        return this.f9040h.c + ":" + this.f9034e.source + n() + ":";
    }

    protected boolean r() {
        AdsItem adsItem = this.f9034e;
        if (adsItem == null) {
            return true;
        }
        if (adsItem.c()) {
            return false;
        }
        return TextUtils.isEmpty(this.f9034e.placementId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(b bVar) {
        k kVar = this.c;
        if (kVar == null) {
            return;
        }
        kVar.d(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(String str) {
        k kVar = this.c;
        if (kVar == null) {
            return;
        }
        kVar.e(this.f9034e, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u(b bVar) {
        k kVar = this.c;
        if (kVar != null) {
            kVar.onRewardVideoClose(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(b bVar) {
        k kVar = this.c;
        if (kVar != null) {
            kVar.f(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(b bVar) {
        k kVar = this.c;
        if (kVar != null) {
            kVar.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(b bVar) {
        k kVar = this.c;
        if (kVar == null) {
            return;
        }
        kVar.b(this.f9034e, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(h hVar) {
        this.f9041i = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(boolean z) {
        this.b = z;
    }
}
