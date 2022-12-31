package d.g.g;

import android.content.Context;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import us.pinguo.advsdk.a.d;
import us.pinguo.advsdk.a.h;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.network.e;
import us.pinguo.advsdk.network.f;
/* compiled from: PGAdmobRewardVideoRequest.java */
/* loaded from: classes3.dex */
public class b extends d<d.g.g.a> {

    /* renamed from: j  reason: collision with root package name */
    private c f8610j;

    /* renamed from: k  reason: collision with root package name */
    private long f8611k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8612l;
    private RewardedVideoAdListener m;

    /* compiled from: PGAdmobRewardVideoRequest.java */
    /* loaded from: classes3.dex */
    class a implements RewardedVideoAdListener {
        a() {
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewarded(RewardItem rewardItem) {
            us.pinguo.advsdk.utils.b.a("AdmobRewardVideo Request onRewarded");
            b.this.w(new d.g.g.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h, b.this.f8610j));
            b.this.f8612l = true;
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdClosed() {
            us.pinguo.advsdk.utils.b.a("AdmobRewardVideo Request onRewardedVideoAdClosed");
            d.g.g.a aVar = new d.g.g.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h, b.this.f8610j);
            if (!b.this.f8612l) {
                b.this.v(aVar);
            }
            b.this.f8612l = false;
            b.this.u(aVar);
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdFailedToLoad(int i2) {
            us.pinguo.advsdk.utils.b.a("AdmobRewardVideo Request onRewardedVideoAdFailedToLoad " + i2);
            b.this.z(false);
            b bVar = b.this;
            bVar.t("admob onRewardedVideoAdFailedToLoad " + i2);
            b.this.A(System.currentTimeMillis() - b.this.f8611k);
            f fVar = new f((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h);
            fVar.e("0", "errorcode:" + i2);
            fVar.execute();
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdLeftApplication() {
            us.pinguo.advsdk.utils.b.a("AdmobRewardVideo Request onRewardedVideoAdLeftApplication");
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdLoaded() {
            us.pinguo.advsdk.utils.b.a("AdmobRewardVideo Request onRewardedVideoAdLoaded");
            b.this.z(false);
            b.this.E();
            b.this.A(System.currentTimeMillis() - b.this.f8611k);
            b bVar = b.this;
            bVar.x(new d.g.g.a(((us.pinguo.advsdk.a.a) bVar).f9034e, ((d) b.this).f9040h, b.this.f8610j));
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoAdOpened() {
            us.pinguo.advsdk.utils.b.a("AdmobRewardVideo Request onRewardedVideoAdOpened");
            PgAdvManager.getInstance().i().d();
            b.this.C();
            new e((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, new d.g.g.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h, b.this.f8610j)).execute();
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoCompleted() {
            us.pinguo.advsdk.utils.b.a("AdmobRewardVideo Request onRewardedVideoCompleted");
        }

        @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
        public void onRewardedVideoStarted() {
            us.pinguo.advsdk.utils.b.a("AdmobRewardVideo Request onRewardedVideoStarted");
        }
    }

    public b(AdsItem adsItem, h hVar) {
        super(adsItem);
        this.f8612l = false;
        this.m = new a();
        this.f8610j = new c();
        y(hVar);
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        this.f8611k = System.currentTimeMillis();
        D();
        this.f8610j.d(this.f9033d.get(), this.f9034e.placementId, this.m);
        return false;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        AdsItem adsItem = this.f9034e;
        if (adsItem == null) {
            return 2;
        }
        return adsItem.loadSDK;
    }
}
