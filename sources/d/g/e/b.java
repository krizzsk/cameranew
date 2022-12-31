package d.g.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import us.pinguo.advsdk.a.d;
import us.pinguo.advsdk.a.h;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.f;
/* compiled from: PGGoogleLaunchRequest.java */
/* loaded from: classes3.dex */
public class b extends d<d.g.e.a> {

    /* renamed from: j  reason: collision with root package name */
    AppOpenAd f8605j;

    /* renamed from: k  reason: collision with root package name */
    long f8606k;

    /* renamed from: l  reason: collision with root package name */
    AppOpenAd.AppOpenAdLoadCallback f8607l;

    /* compiled from: PGGoogleLaunchRequest.java */
    /* loaded from: classes3.dex */
    class a extends AppOpenAd.AppOpenAdLoadCallback {
        a() {
        }

        @Override // com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
        public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
            super.onAppOpenAdFailedToLoad(loadAdError);
            b.this.z(false);
            b.this.t(loadAdError.toString());
            us.pinguo.advsdk.utils.b.a(b.this.q() + "GOOGLE error:" + loadAdError.toString());
            b.this.B(loadAdError.toString());
            f fVar = new f((Context) ((us.pinguo.advsdk.a.a) b.this).f9033d.get(), ((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h);
            fVar.e("0", "errorcode:");
            fVar.execute();
        }

        @Override // com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback
        public void onAppOpenAdLoaded(AppOpenAd appOpenAd) {
            super.onAppOpenAdLoaded(appOpenAd);
            b bVar = b.this;
            bVar.f8605j = appOpenAd;
            bVar.z(false);
            b.this.A(System.currentTimeMillis() - b.this.f8606k);
            d.g.e.a aVar = new d.g.e.a(((us.pinguo.advsdk.a.a) b.this).f9034e, ((d) b.this).f9040h, b.this.f8605j);
            us.pinguo.advsdk.utils.b.a("PGGoogleAppOpenAd onContentAdLoaded success:");
            b.this.l(aVar);
            b bVar2 = b.this;
            bVar2.x(bVar2.o());
            b.this.E();
        }
    }

    /* compiled from: PGGoogleLaunchRequest.java */
    /* renamed from: d.g.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class RunnableC0304b implements Runnable {
        RunnableC0304b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.U();
        }
    }

    public b(AdsItem adsItem, h hVar) {
        super(adsItem);
        this.f8606k = 0L;
        this.f8607l = new a();
        y(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        AdRequest build = new AdRequest.Builder().build();
        D();
        this.f8606k = System.currentTimeMillis();
        AppOpenAd.load(this.f9033d.get(), this.f9034e.placementId, build, 1, this.f8607l);
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        new Handler(Looper.getMainLooper()).post(new RunnableC0304b());
        return false;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        return 2;
    }
}
