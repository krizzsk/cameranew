package com.facebook.appevents.l;

import com.facebook.appevents.ml.ModelManager;
import com.facebook.f;
import com.facebook.internal.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: IntegrityManager.java */
/* loaded from: classes.dex */
public final class a {
    private static boolean a = false;
    private static boolean b = false;

    public static void a() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            a = true;
            b = k.f("FBSDKFeatureIntegritySample", f.g(), false);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    private static String b(String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            Arrays.fill(fArr, 0.0f);
            String[] o = ModelManager.o(ModelManager.Task.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
            return o == null ? PortalFollowFeeds.TYPE_NONE : o[0];
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    public static void c(Map<String, String> map) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            if (a && map.size() != 0) {
                try {
                    ArrayList<String> arrayList = new ArrayList(map.keySet());
                    JSONObject jSONObject = new JSONObject();
                    for (String str : arrayList) {
                        String str2 = map.get(str);
                        if (d(str) || d(str2)) {
                            map.remove(str);
                            if (!b) {
                                str2 = "";
                            }
                            jSONObject.put(str, str2);
                        }
                    }
                    if (jSONObject.length() == 0) {
                        return;
                    }
                    map.put("_onDeviceParams", jSONObject.toString());
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    private static boolean d(String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            return !PortalFollowFeeds.TYPE_NONE.equals(b(str));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }
}
