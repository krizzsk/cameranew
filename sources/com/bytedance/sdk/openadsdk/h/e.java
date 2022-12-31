package com.bytedance.sdk.openadsdk.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.Set;
/* compiled from: Proxy.java */
/* loaded from: classes.dex */
public class e {
    static volatile com.bytedance.sdk.openadsdk.h.a.b a;
    static volatile com.bytedance.sdk.openadsdk.h.a.c b;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f2034d;

    /* renamed from: f  reason: collision with root package name */
    static volatile boolean f2036f;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Integer f2039i;

    /* renamed from: j  reason: collision with root package name */
    private static volatile com.bytedance.sdk.openadsdk.h.b.c f2040j;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: k  reason: collision with root package name */
    private static volatile Context f2041k;
    public static final boolean c = o.c();

    /* renamed from: e  reason: collision with root package name */
    static volatile boolean f2035e = true;

    /* renamed from: g  reason: collision with root package name */
    static volatile int f2037g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static volatile int f2038h = 3;

    public static Context a() {
        return f2041k;
    }

    public static void b(boolean z) {
        f2036f = z;
    }

    public static com.bytedance.sdk.openadsdk.h.a.b c() {
        return a;
    }

    public static void a(boolean z) {
        f2035e = z;
    }

    public static com.bytedance.sdk.openadsdk.h.a.c b() {
        return b;
    }

    public static void a(int i2) {
        f2037g = i2;
    }

    public static void a(com.bytedance.sdk.openadsdk.h.a.c cVar, Context context) {
        if (cVar != null && context != null) {
            f2041k = context.getApplicationContext();
            if (b != null) {
                return;
            }
            com.bytedance.sdk.openadsdk.h.a.b bVar = a;
            if (bVar != null && bVar.a.getAbsolutePath().equals(cVar.a.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
            }
            b = cVar;
            f2040j = com.bytedance.sdk.openadsdk.h.b.c.a(context);
            b.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.h.e.1
                @Override // com.bytedance.sdk.openadsdk.h.a.c.a
                public void a(String str) {
                    if (e.c) {
                        Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.h.a.c.a
                public void a(Set<String> set) {
                    e.f2040j.a(set, 0);
                    if (e.c) {
                        Log.i("TAG_PROXY_DiskLruCache", "cache file removed, " + set);
                    }
                }
            });
            f a2 = f.a();
            a2.a(cVar);
            a2.a(f2040j);
            d c2 = d.c();
            c2.a(cVar);
            c2.a(f2040j);
            return;
        }
        throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
    }
}
