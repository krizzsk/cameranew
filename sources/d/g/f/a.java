package d.g.f;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import us.pinguo.advsdk.a.k;
import us.pinguo.advsdk.bean.AdsItem;
/* compiled from: PGAdmobRewardInterstitialNative.java */
/* loaded from: classes3.dex */
public class a extends us.pinguo.advsdk.a.b implements OnUserEarnedRewardListener {
    private RewardedInterstitialAd a;
    private k b;
    private us.pinguo.advsdk.bean.b c;

    public a(us.pinguo.advsdk.bean.b bVar, RewardedInterstitialAd rewardedInterstitialAd, k kVar) {
        this.a = rewardedInterstitialAd;
        this.b = kVar;
        this.c = bVar;
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
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String e() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String f() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public String g() {
        return null;
    }

    @Override // us.pinguo.advsdk.a.b
    public Object h() {
        return null;
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
        return 0;
    }

    @Override // us.pinguo.advsdk.a.b
    public String m() {
        return this.c.c;
    }

    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
        k kVar = this.b;
        if (kVar != null) {
            kVar.a(this);
        }
    }

    @Override // us.pinguo.advsdk.a.b
    public void q(View view) {
    }

    @Override // us.pinguo.advsdk.a.b
    public void s(Activity activity) {
        this.a.show(activity, this);
    }
}
