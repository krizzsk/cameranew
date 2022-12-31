package com.bytedance.sdk.openadsdk.core.video.c;

import android.content.Context;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.h;
import java.util.HashMap;
/* compiled from: PlayableEvent.java */
/* loaded from: classes.dex */
public class b {
    public static void a(Context context, h hVar) {
        d.g(context, hVar, "playable_preload", "preload_start", null);
    }

    public static void a(Context context, h hVar, long j2, long j3) {
        HashMap hashMap = new HashMap();
        hashMap.put("loadzip_success_time", Long.valueOf(j2));
        hashMap.put("unzip_success_time", Long.valueOf(j3));
        d.g(context, hVar, "playable_preload", "preload_success", hashMap);
    }

    public static void a(Context context, h hVar, int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", Integer.valueOf(i2));
        hashMap.put("error_reason", str);
        d.g(context, hVar, "playable_preload", "preload_fail", hashMap);
    }
}
