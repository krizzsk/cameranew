package com.google.android.play.core.common;

import android.os.Bundle;
import com.google.android.play.core.internal.j;
import com.growingio.android.sdk.monitor.event.EventBuilder;
import com.tapjoy.TapjoyConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static final Map<String, Map<String, Integer>> a;

    static {
        new HashSet(Arrays.asList("review"));
        new HashSet(Arrays.asList(TapjoyConstants.TJC_PLUGIN_NATIVE, TapjoyConstants.TJC_PLUGIN_UNITY));
        a = new HashMap();
        new j("PlayCoreVersion");
    }

    public static Bundle a() {
        Bundle bundle = new Bundle();
        Map<String, Integer> b = b("review");
        bundle.putInt("playcore_version_code", b.get(EventBuilder.DEFAULT_PLATFORM).intValue());
        if (b.containsKey(TapjoyConstants.TJC_PLUGIN_NATIVE)) {
            bundle.putInt("playcore_native_version", b.get(TapjoyConstants.TJC_PLUGIN_NATIVE).intValue());
        }
        if (b.containsKey(TapjoyConstants.TJC_PLUGIN_UNITY)) {
            bundle.putInt("playcore_unity_version", b.get(TapjoyConstants.TJC_PLUGIN_UNITY).intValue());
        }
        return bundle;
    }

    public static synchronized Map<String, Integer> b(String str) {
        Map<String, Integer> map;
        synchronized (a.class) {
            Map<String, Map<String, Integer>> map2 = a;
            if (!map2.containsKey(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(EventBuilder.DEFAULT_PLATFORM, 10800);
                map2.put(str, hashMap);
            }
            map = map2.get(str);
        }
        return map;
    }
}
