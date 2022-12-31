package d.g.e;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.appopen.AppOpenAd;
import us.pinguo.advsdk.a.b;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGGoogleLaunchNative.java */
/* loaded from: classes3.dex */
public class a extends us.pinguo.advsdk.a.b {
    AdsItem a;
    us.pinguo.advsdk.bean.b b;
    AppOpenAd c;

    /* compiled from: PGGoogleLaunchNative.java */
    /* renamed from: d.g.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0303a extends FullScreenContentCallback {
        final /* synthetic */ b.InterfaceC0356b a;

        C0303a(a aVar, b.InterfaceC0356b interfaceC0356b) {
            this.a = interfaceC0356b;
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            this.a.a();
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            this.a.b(adError.toString());
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            this.a.c();
        }
    }

    public a(AdsItem adsItem, us.pinguo.advsdk.bean.b bVar, AppOpenAd appOpenAd) {
        this.a = adsItem;
        this.b = bVar;
        this.c = appOpenAd;
    }

    @Override // us.pinguo.advsdk.a.b
    public AdsItem a() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String b() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String c() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String d() {
        AdsItem adsItem = this.a;
        return adsItem != null ? adsItem.displayFormat : "";
    }

    @Override // us.pinguo.advsdk.a.b
    public String e() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String f() {
        return String.valueOf(System.currentTimeMillis());
    }

    @Override // us.pinguo.advsdk.a.b
    public String g() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public Object h() {
        return this.c;
    }

    @Override // us.pinguo.advsdk.a.b
    public String j() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String k() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public int l() {
        return 2;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        us.pinguo.advsdk.bean.b bVar = this.b;
        if (bVar == null) {
            return null;
        }
        return bVar.c;
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }

    @Override // us.pinguo.advsdk.a.b
    public void t(Activity activity, b.InterfaceC0356b interfaceC0356b) {
        super.t(activity, interfaceC0356b);
        this.c.show(activity, new C0303a(this, interfaceC0356b));
    }
}
