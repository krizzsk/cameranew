package com.bytedance.sdk.openadsdk.core.video.f;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.o;
/* compiled from: VideoPreloadUtils.java */
/* loaded from: classes.dex */
public class c {
    public static void a(com.bytedance.sdk.openadsdk.h.f.b bVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            new com.bytedance.sdk.openadsdk.core.video.a.b.a(o.a(), bVar.a, bVar.c, bVar.b).b();
        } else {
            com.bytedance.sdk.openadsdk.h.f.a.a().a(bVar);
        }
    }
}
