package com.bytedance.sdk.openadsdk.h.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.h.e;
import com.bytedance.sdk.openadsdk.h.g.d;
import java.io.File;
/* compiled from: DiskCache.java */
/* loaded from: classes.dex */
public class b extends a {
    public final File a;

    public void a() {
        d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b();
            }
        });
    }

    public void b() {
        com.bytedance.sdk.openadsdk.h.d.c().d();
        Context a = e.a();
        if (a != null) {
            com.bytedance.sdk.openadsdk.h.b.c.a(a).a(1);
        }
        for (File file : this.a.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public File c(String str) {
        return e(str);
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public File d(String str) {
        return e(str);
    }

    File e(String str) {
        return new File(this.a, str);
    }
}
