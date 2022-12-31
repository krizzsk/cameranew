package us.pinguo.ad;

import android.content.Context;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import kotlin.jvm.internal.s;
import us.pinguo.advsdk.a.l;
import us.pinguo.advsdk.manager.f;
import us.pinguo.foundation.statistics.h;
/* compiled from: RewardVideoManager.kt */
/* loaded from: classes3.dex */
public final class b implements l {
    public static final b a = new b();
    private static final HashMap<String, us.pinguo.advsdk.a.b> b = new HashMap<>();
    private static InterfaceC0350b c;

    /* renamed from: d  reason: collision with root package name */
    private static a f8995d;

    /* compiled from: RewardVideoManager.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void onLoadFailed(int i2, String str);

        void onLoadSuccess(us.pinguo.advsdk.a.b bVar);
    }

    /* compiled from: RewardVideoManager.kt */
    /* renamed from: us.pinguo.ad.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0350b {
        void onPlayRewardVideoFailed(us.pinguo.advsdk.a.b bVar);

        void onPlayRewardVideoSuccess(us.pinguo.advsdk.a.b bVar);

        void onRewardVideoClose(us.pinguo.advsdk.a.b bVar);
    }

    private b() {
    }

    public final boolean a(String unitId) {
        s.h(unitId, "unitId");
        return b.containsKey(unitId);
    }

    public final void b(Context context, String unitID, a aVar) {
        s.h(context, "context");
        s.h(unitID, "unitID");
        HashMap hashMap = new HashMap();
        hashMap.put("cache_num", "1");
        hashMap.put("pg_unit_id", unitID);
        f fVar = new f(context, hashMap);
        fVar.B(this);
        f8995d = aVar;
        HashMap<String, us.pinguo.advsdk.a.b> hashMap2 = b;
        if (hashMap2.containsKey(unitID)) {
            a aVar2 = f8995d;
            if (aVar2 == null) {
                return;
            }
            aVar2.onLoadSuccess(hashMap2.get(unitID));
            return;
        }
        fVar.B(this);
        fVar.r(context, false);
        h.b.f0("", "rewarded_ads", SocialConstants.TYPE_REQUEST);
    }

    public final boolean c(Context context, String unitId, InterfaceC0350b interfaceC0350b) {
        s.h(context, "context");
        s.h(unitId, "unitId");
        HashMap<String, us.pinguo.advsdk.a.b> hashMap = b;
        if (!hashMap.containsKey(unitId)) {
            us.pinguo.advsdk.utils.b.a("RewardVideo cache not ready");
            return false;
        }
        c = interfaceC0350b;
        us.pinguo.advsdk.a.b bVar = hashMap.get(unitId);
        if (bVar != null) {
            bVar.r(context, null);
        }
        hashMap.remove(unitId);
        h.b.f0("", "rewarded_ads", "play");
        return true;
    }

    @Override // us.pinguo.advsdk.a.l
    public void onAdDestroy(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeClick(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeFailed(int i2, String str) {
        us.pinguo.common.log.a.k("=================RewardVideoManager onPGNativeFailed", new Object[0]);
        a aVar = f8995d;
        if (aVar != null) {
            aVar.onLoadFailed(i2, str);
        }
        h.b.f0("", "rewarded_ads", "fail_to_load");
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeSuccess(us.pinguo.advsdk.a.b ipgadNative) {
        s.h(ipgadNative, "ipgadNative");
        us.pinguo.common.log.a.k("=================RewardVideoManager onPGNativeSuccess", new Object[0]);
        String unitId = ipgadNative.m();
        HashMap<String, us.pinguo.advsdk.a.b> hashMap = b;
        s.g(unitId, "unitId");
        hashMap.put(unitId, ipgadNative);
        a aVar = f8995d;
        if (aVar != null) {
            aVar.onLoadSuccess(ipgadNative);
        }
        h.b.f0("", "rewarded_ads", "success_loaded");
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.common.log.a.k("=================RewardVideoManager onPGRewardVideoClose", new Object[0]);
        InterfaceC0350b interfaceC0350b = c;
        if (interfaceC0350b == null) {
            return;
        }
        interfaceC0350b.onRewardVideoClose(bVar);
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoFailed(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.common.log.a.k("=================RewardVideoManager onPGRewardVideoFailed", new Object[0]);
        InterfaceC0350b interfaceC0350b = c;
        if (interfaceC0350b == null) {
            return;
        }
        interfaceC0350b.onPlayRewardVideoFailed(bVar);
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoSuccess(us.pinguo.advsdk.a.b bVar) {
        us.pinguo.common.log.a.k("=================RewardVideoManager onPGRewardVideoSuccess", new Object[0]);
        InterfaceC0350b interfaceC0350b = c;
        if (interfaceC0350b == null) {
            return;
        }
        interfaceC0350b.onPlayRewardVideoSuccess(bVar);
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadFailed(int i2, String str) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadSuccess(us.pinguo.advsdk.a.b bVar) {
    }
}
