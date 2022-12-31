package d.g.g;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.lang.ref.WeakReference;
/* compiled from: PGAdmobRewardVideoUtil.java */
/* loaded from: classes3.dex */
public class c {
    private RewardedVideoAd a;
    private WeakReference<Context> b;
    private RewardedVideoAdListener c;

    public RewardedVideoAd a() {
        return this.a;
    }

    public boolean b() {
        RewardedVideoAd rewardedVideoAd = this.a;
        if (rewardedVideoAd != null && rewardedVideoAd.isLoaded()) {
            us.pinguo.advsdk.utils.b.a("PGAdmobRewardVideoUtil rewardVideoAd.isAdLoaded() = true");
            return true;
        }
        us.pinguo.advsdk.utils.b.a("PGAdmobRewardVideoUtil rewardVideoAd.isAdLoaded() = false");
        return false;
    }

    public void c() {
        if (b()) {
            us.pinguo.advsdk.utils.b.a("PGAdmobRewardVideoUtil rewardedVideoAd.show()");
            this.a.show();
        }
    }

    public void d(Context context, String str, RewardedVideoAdListener rewardedVideoAdListener) {
        this.c = rewardedVideoAdListener;
        if (b()) {
            RewardedVideoAdListener rewardedVideoAdListener2 = this.c;
            if (rewardedVideoAdListener2 != null) {
                rewardedVideoAdListener2.onRewardedVideoAdLoaded();
                return;
            }
            return;
        }
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.b = weakReference;
        RewardedVideoAd rewardedVideoAd = this.a;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy(weakReference.get());
            this.a = null;
        }
        RewardedVideoAd rewardedVideoAdInstance = MobileAds.getRewardedVideoAdInstance(this.b.get());
        this.a = rewardedVideoAdInstance;
        rewardedVideoAdInstance.setRewardedVideoAdListener(this.c);
        this.a.loadAd(str, new AdRequest.Builder().build());
    }
}
