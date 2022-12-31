package d.g.f;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import us.pinguo.advsdk.a.d;
import us.pinguo.advsdk.a.h;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.network.e;
/* compiled from: PGAdmobRewardInterstitialRequest.java */
/* loaded from: classes3.dex */
public class b extends d<d.g.f.a> {

    /* renamed from: j  reason: collision with root package name */
    private RewardedInterstitialAdLoadCallback f8608j;

    /* renamed from: k  reason: collision with root package name */
    private FullScreenContentCallback f8609k;

    /* compiled from: PGAdmobRewardInterstitialRequest.java */
    /* loaded from: classes3.dex */
    class a extends RewardedInterstitialAdLoadCallback {
        a() {
        }

        @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
        public void onRewardedInterstitialAdFailedToLoad(LoadAdError loadAdError) {
            b.this.t(loadAdError.getMessage());
        }

        @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
        public void onRewardedInterstitialAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
            rewardedInterstitialAd.setFullScreenContentCallback(b.this.f8609k);
            b bVar = b.this;
            bVar.x(new d.g.f.a(((d) bVar).f9040h, rewardedInterstitialAd, ((us.pinguo.advsdk.a.a) b.this).c));
        }
    }

    /* compiled from: PGAdmobRewardInterstitialRequest.java */
    /* renamed from: d.g.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0305b extends FullScreenContentCallback {
        C0305b() {
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdDismissedFullScreenContent() {
            ((us.pinguo.advsdk.a.a) b.this).c.onRewardVideoClose(null);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            ((us.pinguo.advsdk.a.a) b.this).c.f(null);
        }

        @Override // com.google.android.gms.ads.FullScreenContentCallback
        public void onAdShowedFullScreenContent() {
            PgAdvManager.getInstance().i().d();
            b.this.C();
            new e((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, new d.g.f.a(((d) b.this).f9040h, null, ((us.pinguo.advsdk.a.a) b.this).c)).execute();
        }
    }

    public b(AdsItem adsItem, h hVar) {
        super(adsItem);
        this.f8608j = new a();
        this.f8609k = new C0305b();
        y(hVar);
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        Context context = this.f9033d.get();
        if (context == null) {
            return false;
        }
        RewardedInterstitialAd.load(context, this.f9034e.placementId, new AdRequest.Builder().build(), this.f8608j);
        return true;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        return 2;
    }
}
