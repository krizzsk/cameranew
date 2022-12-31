package com.bytedance.sdk.openadsdk.dislike;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.List;
/* compiled from: DislikeDispatcher.java */
/* loaded from: classes.dex */
public class a {
    private static volatile a a;
    private final p<com.bytedance.sdk.openadsdk.c.a> b = o.f();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(@NonNull h hVar, List<FilterWord> list) {
        this.b.a(hVar, list);
    }
}
