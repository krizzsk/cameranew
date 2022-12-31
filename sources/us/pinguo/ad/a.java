package us.pinguo.ad;

import android.app.Activity;
import android.content.Context;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import kotlin.jvm.internal.s;
import us.pinguo.advsdk.a.l;
import us.pinguo.advsdk.manager.f;
import us.pinguo.foundation.statistics.h;
import us.pinguo.repository2020.utils.o;
/* compiled from: RewardInterstitialManager.kt */
/* loaded from: classes3.dex */
public final class a implements l {
    public static final a a = new a();
    private static final HashMap<String, us.pinguo.advsdk.a.b> b = new HashMap<>();
    private static long c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static InterfaceC0349a f8992d;

    /* renamed from: e  reason: collision with root package name */
    private static b f8993e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f8994f;

    /* compiled from: RewardInterstitialManager.kt */
    /* renamed from: us.pinguo.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0349a {
        void a(boolean z);
    }

    /* compiled from: RewardInterstitialManager.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);
    }

    private a() {
    }

    private final boolean b() {
        if (c == -1) {
            c = o.h(o.a, "reward_last_show_time", 0L, null, 4, null);
        }
        return System.currentTimeMillis() - c < 28800000;
    }

    public static /* synthetic */ void g(a aVar, Activity activity, String str, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        aVar.f(activity, str, z);
    }

    public final boolean a(String unitId) {
        s.h(unitId, "unitId");
        return b.containsKey(unitId);
    }

    public final void c(Context context, String unitId, boolean z) {
        s.h(context, "context");
        s.h(unitId, "unitId");
        if (b.containsKey(unitId)) {
            return;
        }
        if (z || !b()) {
            HashMap hashMap = new HashMap();
            hashMap.put("cache_num", "1");
            hashMap.put("pg_unit_id", unitId);
            f fVar = new f(context, hashMap);
            fVar.B(this);
            fVar.r(context, false);
            h.b.f0("home_page", "inter_rewarded_ads", SocialConstants.TYPE_REQUEST);
        }
    }

    public final void d(b bVar) {
        f8993e = bVar;
    }

    public final void e(InterfaceC0349a interfaceC0349a) {
        f8992d = interfaceC0349a;
    }

    public final void f(Activity activity, String unitId, boolean z) {
        s.h(activity, "activity");
        s.h(unitId, "unitId");
        HashMap<String, us.pinguo.advsdk.a.b> hashMap = b;
        us.pinguo.advsdk.a.b bVar = hashMap.get(unitId);
        if (bVar == null) {
            return;
        }
        if (z || !b()) {
            hashMap.remove(unitId);
            bVar.s(activity);
            c = System.currentTimeMillis();
            o.t(o.a, "reward_last_show_time", c, null, 4, null);
            h.b.f0("home_page", "inter_rewarded_ads", "play");
        }
    }

    @Override // us.pinguo.advsdk.a.l
    public void onAdDestroy(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeClick(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeFailed(int i2, String str) {
        h.b.f0("home_page", "inter_rewarded_ads", "fail_to_load");
        InterfaceC0349a interfaceC0349a = f8992d;
        if (interfaceC0349a == null) {
            return;
        }
        interfaceC0349a.a(false);
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeSuccess(us.pinguo.advsdk.a.b bVar) {
        if (bVar != null) {
            String unitId = bVar.m();
            HashMap<String, us.pinguo.advsdk.a.b> hashMap = b;
            s.g(unitId, "unitId");
            hashMap.put(unitId, bVar);
            h.b.f0("home_page", "inter_rewarded_ads", "success_loaded");
        }
        InterfaceC0349a interfaceC0349a = f8992d;
        if (interfaceC0349a == null) {
            return;
        }
        interfaceC0349a.a(true);
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
        if (!f8994f) {
            h.b.f0("home_page", "inter_rewarded_ads", "exit");
        }
        b bVar2 = f8993e;
        if (bVar2 != null) {
            bVar2.a(f8994f);
        }
        f8994f = false;
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoFailed(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoSuccess(us.pinguo.advsdk.a.b bVar) {
        f8994f = true;
        h.b.f0("home_page", "inter_rewarded_ads", TJAdUnitConstants.String.VIDEO_COMPLETE);
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadFailed(int i2, String str) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadSuccess(us.pinguo.advsdk.a.b bVar) {
    }
}
