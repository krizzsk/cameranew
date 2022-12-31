package com.bytedance.sdk.openadsdk.core.video.a;

import java.util.concurrent.ConcurrentHashMap;
/* compiled from: DownloadingSourceManager.java */
/* loaded from: classes.dex */
public class a {
    private static final ConcurrentHashMap<String, b> a = new ConcurrentHashMap<>();

    public static void a(String str, b bVar) {
        a.put(str, bVar);
    }

    public static void b(String str) {
        a.remove(str);
    }

    public static b a(String str) {
        return a.get(str);
    }
}
