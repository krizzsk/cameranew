package com.tapjoy.internal;

import com.tapjoy.internal.gj;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* loaded from: classes3.dex */
public final class fy extends gj {
    static final Map a = Collections.unmodifiableMap(new HashMap());
    private final gj.a c = a("BuildConfig");

    /* renamed from: d  reason: collision with root package name */
    private final gj.a f7548d = a("ServerFinal");

    /* renamed from: e  reason: collision with root package name */
    private final gj.a f7549e;

    /* renamed from: f  reason: collision with root package name */
    private final gj.a f7550f;

    /* renamed from: g  reason: collision with root package name */
    private final gj.a f7551g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fy() {
        gj.a a2 = a("AppRuntime");
        this.f7549e = a2;
        a2.b = new ConcurrentHashMap();
        this.f7550f = a("ConnectFlags");
        this.f7551g = a("ServerDefault");
        gj.a a3 = a("SDKDefault");
        HashMap hashMap = new HashMap();
        hashMap.put("placement_request_content_retry_timeout", -1);
        hashMap.put("placement_request_content_retry_backoff", Arrays.asList(0L, 500L, 10000L, Double.valueOf(2.0d)));
        a3.b = hashMap;
    }

    public final void a(@Nullable Map map) {
        Map map2;
        Map map3 = null;
        if (map != null) {
            map3 = (Map) map.get("final");
            map2 = (Map) map.get(IADStatisticBase.VARCHAR_DEFALUT_VALUE);
        } else {
            map2 = null;
        }
        this.f7548d.b = map3;
        this.f7551g.b = map2;
        setChanged();
    }

    public final void a(Hashtable hashtable) {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : hashtable.entrySet()) {
            String str = (String) a.get(entry.getKey());
            if (str == null) {
                str = (String) entry.getKey();
            }
            this.f7549e.b.remove(str);
            hashMap.put(str, entry.getValue());
        }
        this.f7550f.b = hashMap;
        setChanged();
    }
}
