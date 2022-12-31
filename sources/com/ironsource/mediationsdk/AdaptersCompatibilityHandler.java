package com.ironsource.mediationsdk;

import com.adjust.sdk.AdjustConfig;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class AdaptersCompatibilityHandler {
    private static final AdaptersCompatibilityHandler c = new AdaptersCompatibilityHandler();
    private final ConcurrentHashMap<String, String> a;
    private final ConcurrentHashMap<String, String> b;

    private AdaptersCompatibilityHandler() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        this.a = concurrentHashMap;
        concurrentHashMap.put("adcolony", "4.1.6");
        concurrentHashMap.put("vungle", "4.1.5");
        concurrentHashMap.put("applovin", "4.3.3");
        concurrentHashMap.put(AdjustConfig.AD_REVENUE_ADMOB, "4.3.2");
        ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.b = concurrentHashMap2;
        concurrentHashMap2.put("adcolony", "4.1.6");
        concurrentHashMap2.put(AdjustConfig.AD_REVENUE_ADMOB, "4.3.2");
        concurrentHashMap2.put("applovin", "4.3.3");
        concurrentHashMap2.put("chartboost", "4.1.9");
        concurrentHashMap2.put(AdjustConfig.AD_REVENUE_FYBER, "4.1.0");
        concurrentHashMap2.put("hyprmx", "4.1.2");
        concurrentHashMap2.put("inmobi", "4.3.1");
        concurrentHashMap2.put("maio", "4.1.3");
        concurrentHashMap2.put("tapjoy", "4.0.0");
        concurrentHashMap2.put(AdjustConfig.AD_REVENUE_UNITYADS, "4.1.4");
        concurrentHashMap2.put("vungle", "4.1.5");
    }

    private boolean a(b bVar, Map<String, String> map, String str) {
        if (bVar == null) {
            return false;
        }
        String a = com.ironsource.environment.j.a(bVar.getProviderName());
        if (map.containsKey(a)) {
            String version = bVar.getVersion();
            boolean e2 = e(map.get(a), version);
            if (!e2) {
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.API, bVar.getProviderName() + " adapter " + version + " is incompatible with SDK version " + IronSourceUtils.I() + " for " + str + " ad unit, please update your adapter to the latest version", 3);
            }
            return e2;
        }
        return true;
    }

    private boolean e(String str, String str2) {
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        for (int i2 = 0; i2 < 3; i2++) {
            int parseInt = Integer.parseInt(split[i2]);
            int parseInt2 = Integer.parseInt(split2[i2]);
            if (parseInt2 < parseInt) {
                return false;
            }
            if (parseInt2 > parseInt) {
                return true;
            }
        }
        return true;
    }

    public static AdaptersCompatibilityHandler getInstance() {
        return c;
    }

    public boolean b(b bVar) {
        return a(bVar, this.a, "interstitial");
    }

    public boolean c(b bVar) {
        return a(bVar, this.b, "rewarded video");
    }

    public boolean d(b bVar) {
        if (bVar == null) {
            return false;
        }
        String version = bVar.getVersion();
        boolean e2 = e("4.3.0", version);
        if (!e2) {
            com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.API, bVar.getProviderName() + " adapter " + version + " is incompatible with SDK version " + IronSourceUtils.I() + ", please update your adapter to the latest version", 3);
        }
        return e2;
    }
}
