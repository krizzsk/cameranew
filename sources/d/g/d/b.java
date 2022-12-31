package d.g.d;

import android.content.Context;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FaceBookInsertUtils.java */
/* loaded from: classes3.dex */
public class b {
    private InterstitialAd a;
    private WeakReference<Context> b;
    d.g.d.a c;

    /* renamed from: d  reason: collision with root package name */
    private InterstitialAdListener f8599d = new a();

    /* compiled from: FaceBookInsertUtils.java */
    /* loaded from: classes3.dex */
    class a implements InterstitialAdListener {
        a() {
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            d.g.d.a aVar = b.this.c;
            if (aVar != null) {
                aVar.onAdClicked();
            }
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            us.pinguo.advsdk.utils.b.a("FaceBookInsertUtils onAdLoaded ad =" + ad);
            b.this.d();
            InterstitialAd unused = b.this.a;
            d.g.d.a aVar = b.this.c;
            if (aVar != null) {
                aVar.onAdLoaded();
            }
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            us.pinguo.advsdk.utils.b.a("FaceBookInsertUtils onError = " + adError.getErrorMessage());
            us.pinguo.advsdk.utils.b.a("FaceBookInsertUtils getErrorCode = " + adError.getErrorCode());
            InterstitialAd unused = b.this.a;
            d.g.d.a aVar = b.this.c;
            if (aVar != null) {
                aVar.onError(adError.getErrorMessage());
            }
        }

        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDismissed(Ad ad) {
            b.this.a.destroy();
            b.this.a = null;
            b.this.c.a();
        }

        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDisplayed(Ad ad) {
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
            us.pinguo.advsdk.utils.b.a("FaceBookInsertUtils onLoggingImpression");
            d.g.d.a aVar = b.this.c;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public InterstitialAd c() {
        return this.a;
    }

    public boolean d() {
        if (this.a != null) {
            us.pinguo.advsdk.utils.b.a("FaceBookInsertUtils interstitialAd.isAdLoaded()11 = " + this.a.isAdLoaded());
        }
        InterstitialAd interstitialAd = this.a;
        return interstitialAd != null && interstitialAd.isAdLoaded();
    }

    public void e() {
        InterstitialAd interstitialAd = this.a;
        if (interstitialAd == null || !interstitialAd.isAdLoaded()) {
            return;
        }
        this.a.show();
    }

    public void f(Context context, String str, d.g.d.a aVar) {
        if (this.a != null) {
            us.pinguo.advsdk.utils.b.a("FaceBookInsertUtils interstitialAd.isAdLoaded()000000 = " + this.a.isAdLoaded());
        }
        InterstitialAd interstitialAd = this.a;
        if (interstitialAd != null && interstitialAd.isAdLoaded()) {
            d.g.d.a aVar2 = this.c;
            if (aVar2 != null) {
                aVar2.onAdLoaded();
                return;
            }
            return;
        }
        this.c = aVar;
        this.b = new WeakReference<>(context);
        InterstitialAd interstitialAd2 = this.a;
        if (interstitialAd2 != null) {
            interstitialAd2.destroy();
            this.a = null;
        }
        InterstitialAd interstitialAd3 = new InterstitialAd(this.b.get(), str);
        this.a = interstitialAd3;
        interstitialAd3.loadAd(interstitialAd3.buildLoadAdConfig().withAdListener(this.f8599d).build());
        us.pinguo.advsdk.utils.b.a("FaceBookInsertUtils interstitialAd.loadAd()");
    }
}
