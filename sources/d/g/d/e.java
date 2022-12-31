package d.g.d;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.ads.InterstitialAd;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGGoogleInterstialNative.java */
/* loaded from: classes3.dex */
public class e extends us.pinguo.advsdk.a.b {
    AdsItem a;
    private us.pinguo.advsdk.bean.b b;
    InterstitialAd c;

    /* compiled from: PGGoogleInterstialNative.java */
    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.c.show();
        }
    }

    public e(AdsItem adsItem, InterstitialAd interstitialAd, us.pinguo.advsdk.bean.b bVar) {
        this.a = adsItem;
        this.b = bVar;
        this.c = interstitialAd;
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
    public void s(Activity activity) {
        super.s(activity);
        InterstitialAd interstitialAd = this.c;
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }
}
