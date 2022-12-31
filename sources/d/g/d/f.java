package d.g.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.h;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
/* compiled from: PGGoogleInterstialRequest.java */
/* loaded from: classes3.dex */
public class f extends us.pinguo.advsdk.a.d<e> {

    /* renamed from: j  reason: collision with root package name */
    InterstitialAd f8603j;

    /* renamed from: k  reason: collision with root package name */
    long f8604k;

    /* compiled from: PGGoogleInterstialRequest.java */
    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PGGoogleInterstialRequest.java */
    /* loaded from: classes3.dex */
    public class b extends AdListener {
        InterstitialAd a;

        public b(InterstitialAd interstitialAd) {
            this.a = interstitialAd;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvc
        public void onAdClicked() {
            super.onAdClicked();
            us.pinguo.advsdk.utils.b.a("GOOGLE onAdClicked:");
            e eVar = new e(((us.pinguo.advsdk.a.a) f.this).f9034e, this.a, ((us.pinguo.advsdk.a.d) f.this).f9040h);
            new us.pinguo.advsdk.network.c((Context) ((us.pinguo.advsdk.a.a) f.this).f9033d.get(), ((us.pinguo.advsdk.a.a) f.this).f9034e, eVar, PgAdvConstants$CountMode.NORMAL).execute();
            f.this.s(eVar);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(int i2) {
            super.onAdFailedToLoad(i2);
            f.this.z(false);
            f fVar = f.this;
            StringBuilder sb = new StringBuilder();
            String str = "";
            sb.append("");
            sb.append(i2);
            fVar.t(sb.toString());
            if (i2 == 0) {
                str = "GOOGLE error:内部出现问题。例如，从广告服务器中收到无效响应";
            } else if (i2 == 1) {
                str = "GOOGLE error:广告请求无效。例如，广告单元 ID 不正确";
            } else if (i2 == 2) {
                str = "GOOGLE error:广告请求因网络连接而未成功";
            } else if (i2 == 3) {
                str = "GOOGLE error:广告请求已成功，但因缺少广告库存而未返回广告";
            } else {
                us.pinguo.advsdk.utils.b.a(f.this.q() + "GOOGLE error:" + i2);
            }
            f fVar2 = f.this;
            fVar2.B(i2 + ":" + str);
            us.pinguo.advsdk.network.f fVar3 = new us.pinguo.advsdk.network.f((Context) ((us.pinguo.advsdk.a.a) f.this).f9033d.get(), ((us.pinguo.advsdk.a.a) f.this).f9034e, ((us.pinguo.advsdk.a.d) f.this).f9040h);
            fVar3.e("0", "errorcode:" + i2);
            fVar3.execute();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            super.onAdLoaded();
            f.this.z(false);
            f.this.A(System.currentTimeMillis() - f.this.f8604k);
            e eVar = new e(((us.pinguo.advsdk.a.a) f.this).f9034e, this.a, ((us.pinguo.advsdk.a.d) f.this).f9040h);
            us.pinguo.advsdk.utils.b.a("PGGoogleInterstialNative onContentAdLoaded success:");
            f.this.l(eVar);
            f fVar = f.this;
            fVar.x(fVar.o());
            f.this.E();
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            super.onAdOpened();
            us.pinguo.advsdk.utils.b.a("GOOGLE onAdOpened:");
            PgAdvManager.getInstance().i().d();
            f.this.C();
            new us.pinguo.advsdk.network.e((Context) ((us.pinguo.advsdk.a.a) f.this).f9033d.get(), ((us.pinguo.advsdk.a.a) f.this).f9034e, new e(((us.pinguo.advsdk.a.a) f.this).f9034e, this.a, ((us.pinguo.advsdk.a.d) f.this).f9040h)).execute();
        }
    }

    public f(AdsItem adsItem, h hVar) {
        super(adsItem);
        this.f8604k = 0L;
        y(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        if (this.f8603j == null) {
            InterstitialAd interstitialAd = new InterstitialAd(this.f9033d.get());
            this.f8603j = interstitialAd;
            interstitialAd.setAdListener(new b(interstitialAd));
            this.f8603j.setAdUnitId(this.f9034e.placementId);
        }
        D();
        this.f8604k = System.currentTimeMillis();
        this.f8603j.loadAd(new AdRequest.Builder().build());
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        new Handler(Looper.getMainLooper()).post(new a());
        return false;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        return 2;
    }
}
