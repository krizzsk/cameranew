package us.pinguo.ad;

import android.app.Activity;
import android.content.Context;
import kotlin.jvm.internal.s;
import us.pinguo.ad.a;
import us.pinguo.ad.b;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.repository2020.abtest.i;
/* compiled from: RewardVipAdManager.kt */
/* loaded from: classes3.dex */
public final class c {
    private static a b;
    private static b c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8996d;
    public static final c a = new c();

    /* renamed from: e  reason: collision with root package name */
    private static final e f8997e = new e();

    /* renamed from: f  reason: collision with root package name */
    private static final C0351c f8998f = new C0351c();

    /* renamed from: g  reason: collision with root package name */
    private static final f f8999g = new f();

    /* renamed from: h  reason: collision with root package name */
    private static final d f9000h = new d();

    /* compiled from: RewardVipAdManager.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: RewardVipAdManager.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);
    }

    /* compiled from: RewardVipAdManager.kt */
    /* renamed from: us.pinguo.ad.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0351c implements a.InterfaceC0349a {
        C0351c() {
        }

        @Override // us.pinguo.ad.a.InterfaceC0349a
        public void a(boolean z) {
            if (z) {
                a aVar = c.b;
                if (aVar == null) {
                    return;
                }
                aVar.a();
                return;
            }
            a aVar2 = c.b;
            if (aVar2 == null) {
                return;
            }
            aVar2.b();
        }
    }

    /* compiled from: RewardVipAdManager.kt */
    /* loaded from: classes3.dex */
    public static final class d implements a.b {
        d() {
        }

        @Override // us.pinguo.ad.a.b
        public void a(boolean z) {
            b bVar = c.c;
            if (bVar == null) {
                return;
            }
            bVar.a(z);
        }
    }

    /* compiled from: RewardVipAdManager.kt */
    /* loaded from: classes3.dex */
    public static final class e implements b.a {
        e() {
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadFailed(int i2, String str) {
            a aVar = c.b;
            if (aVar == null) {
                return;
            }
            aVar.b();
        }

        @Override // us.pinguo.ad.b.a
        public void onLoadSuccess(us.pinguo.advsdk.a.b bVar) {
            a aVar = c.b;
            if (aVar == null) {
                return;
            }
            aVar.a();
        }
    }

    /* compiled from: RewardVipAdManager.kt */
    /* loaded from: classes3.dex */
    public static final class f implements b.InterfaceC0350b {
        f() {
        }

        @Override // us.pinguo.ad.b.InterfaceC0350b
        public void onPlayRewardVideoFailed(us.pinguo.advsdk.a.b bVar) {
            c cVar = c.a;
            c.f8996d = false;
        }

        @Override // us.pinguo.ad.b.InterfaceC0350b
        public void onPlayRewardVideoSuccess(us.pinguo.advsdk.a.b bVar) {
            c cVar = c.a;
            c.f8996d = true;
        }

        @Override // us.pinguo.ad.b.InterfaceC0350b
        public void onRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
            b bVar2 = c.c;
            if (bVar2 != null) {
                bVar2.a(c.f8996d);
            }
            c cVar = c.a;
            c.f8996d = false;
        }
    }

    private c() {
    }

    public final boolean e() {
        String a2 = i.a.a();
        if (s.c(a2, "reward")) {
            us.pinguo.ad.b bVar = us.pinguo.ad.b.a;
            String UNIT_ID_REWARD_VIDEO = IADStatisticBase.UNIT_ID_REWARD_VIDEO;
            s.g(UNIT_ID_REWARD_VIDEO, "UNIT_ID_REWARD_VIDEO");
            return bVar.a(UNIT_ID_REWARD_VIDEO);
        } else if (s.c(a2, "inter_reward")) {
            us.pinguo.ad.a aVar = us.pinguo.ad.a.a;
            String UNIT_ID_INTERSTITIAL_REWARD = IADStatisticBase.UNIT_ID_INTERSTITIAL_REWARD;
            s.g(UNIT_ID_INTERSTITIAL_REWARD, "UNIT_ID_INTERSTITIAL_REWARD");
            return aVar.a(UNIT_ID_INTERSTITIAL_REWARD);
        } else {
            return false;
        }
    }

    public final void f(a aVar) {
        b = aVar;
        String a2 = i.a.a();
        if (s.c(a2, "reward")) {
            us.pinguo.ad.b bVar = us.pinguo.ad.b.a;
            Context b2 = us.pinguo.foundation.e.b();
            s.g(b2, "getAppContext()");
            String UNIT_ID_REWARD_VIDEO = IADStatisticBase.UNIT_ID_REWARD_VIDEO;
            s.g(UNIT_ID_REWARD_VIDEO, "UNIT_ID_REWARD_VIDEO");
            bVar.b(b2, UNIT_ID_REWARD_VIDEO, f8997e);
        } else if (s.c(a2, "inter_reward")) {
            us.pinguo.ad.a aVar2 = us.pinguo.ad.a.a;
            aVar2.e(f8998f);
            Context b3 = us.pinguo.foundation.e.b();
            s.g(b3, "getAppContext()");
            String UNIT_ID_INTERSTITIAL_REWARD = IADStatisticBase.UNIT_ID_INTERSTITIAL_REWARD;
            s.g(UNIT_ID_INTERSTITIAL_REWARD, "UNIT_ID_INTERSTITIAL_REWARD");
            aVar2.c(b3, UNIT_ID_INTERSTITIAL_REWARD, true);
        }
    }

    public final void g() {
        b = null;
    }

    public final void h(Activity activity, b listener) {
        s.h(activity, "activity");
        s.h(listener, "listener");
        c = listener;
        String a2 = i.a.a();
        if (s.c(a2, "reward")) {
            us.pinguo.ad.b bVar = us.pinguo.ad.b.a;
            String UNIT_ID_REWARD_VIDEO = IADStatisticBase.UNIT_ID_REWARD_VIDEO;
            s.g(UNIT_ID_REWARD_VIDEO, "UNIT_ID_REWARD_VIDEO");
            bVar.c(activity, UNIT_ID_REWARD_VIDEO, f8999g);
        } else if (s.c(a2, "inter_reward")) {
            us.pinguo.ad.a aVar = us.pinguo.ad.a.a;
            aVar.d(f9000h);
            String UNIT_ID_INTERSTITIAL_REWARD = IADStatisticBase.UNIT_ID_INTERSTITIAL_REWARD;
            s.g(UNIT_ID_INTERSTITIAL_REWARD, "UNIT_ID_INTERSTITIAL_REWARD");
            aVar.f(activity, UNIT_ID_INTERSTITIAL_REWARD, true);
        }
    }
}
