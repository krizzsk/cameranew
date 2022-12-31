package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: ExpressAdLoadManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: j  reason: collision with root package name */
    private static Set<b> f1709j = Collections.synchronizedSet(new HashSet());
    private AdSlot a;
    private Context c;

    /* renamed from: d  reason: collision with root package name */
    private TTAdNative.NativeExpressAdListener f1710d;

    /* renamed from: f  reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.core.d.h> f1712f;

    /* renamed from: g  reason: collision with root package name */
    private List<com.bytedance.sdk.openadsdk.core.d.h> f1713g;

    /* renamed from: h  reason: collision with root package name */
    private a f1714h;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f1711e = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private int f1715i = 5;

    /* renamed from: k  reason: collision with root package name */
    private ScheduledFuture<?> f1716k = null;

    /* renamed from: l  reason: collision with root package name */
    private ScheduledFuture<?> f1717l = null;
    private final p b = o.f();

    /* compiled from: ExpressAdLoadManager.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(List<com.bytedance.sdk.openadsdk.core.d.h> list);
    }

    private b(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        } else {
            this.c = o.a();
        }
        f1709j.add(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        List<com.bytedance.sdk.openadsdk.core.d.h> list = this.f1712f;
        if (list != null) {
            list.clear();
        }
        List<com.bytedance.sdk.openadsdk.core.d.h> list2 = this.f1713g;
        if (list2 != null) {
            list2.clear();
        }
        a(true);
        b(true);
        d();
    }

    private void d() {
        f1709j.remove(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f1711e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f1713g == null || b.this.f1713g.size() <= 0) {
                        if (b.this.f1710d != null) {
                            b.this.f1710d.onError(108, com.bytedance.sdk.openadsdk.core.g.a(108));
                            b.this.a(108);
                        }
                        if (b.this.f1714h != null) {
                            b.this.f1714h.a();
                        }
                    } else {
                        if (b.this.f1710d != null) {
                            ArrayList arrayList = new ArrayList(b.this.f1713g.size());
                            for (com.bytedance.sdk.openadsdk.core.d.h hVar : b.this.f1713g) {
                                arrayList.add(b.this.a(hVar));
                            }
                            if (!arrayList.isEmpty()) {
                                b.this.f1710d.onNativeExpressAdLoad(arrayList);
                            } else {
                                b.this.f1710d.onError(103, com.bytedance.sdk.openadsdk.core.g.a(103));
                                b.this.a(103);
                            }
                        }
                        if (b.this.f1714h != null) {
                            b.this.f1714h.a(b.this.f1713g);
                        }
                    }
                    b.this.c();
                }
            });
        }
    }

    public static b a(Context context) {
        return new b(context);
    }

    private void b(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.f1717l;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            boolean cancel = this.f1717l.cancel(z);
            com.bytedance.sdk.openadsdk.utils.o.b("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + cancel);
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot, int i2, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener, int i3) {
        a(adSlot, i2, nativeExpressAdListener, null, i3);
    }

    public void a(AdSlot adSlot, int i2, @Nullable TTAdNative.NativeExpressAdListener nativeExpressAdListener, @Nullable a aVar, int i3) {
        if (this.f1711e.get()) {
            com.bytedance.sdk.openadsdk.utils.o.e("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.f1715i = i2;
        this.f1711e.set(true);
        this.a = adSlot;
        this.f1710d = nativeExpressAdListener;
        this.f1714h = aVar;
        a(adSlot, nativeExpressAdListener);
    }

    private void a(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (adSlot == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.i iVar = new com.bytedance.sdk.openadsdk.core.d.i();
        iVar.f1602e = 2;
        this.b.a(adSlot, iVar, this.f1715i, new p.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.1
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i2, String str) {
                b.this.a(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    b.this.f1712f = aVar.c();
                    b.this.f1713g = aVar.c();
                    b.this.a();
                    b.this.b();
                    return;
                }
                b.this.a(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        List<com.bytedance.sdk.openadsdk.core.d.h> list = this.f1712f;
        if (list == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.d.h hVar : list) {
            if (hVar.W() && hVar.B() != null && !hVar.B().isEmpty()) {
                for (com.bytedance.sdk.openadsdk.core.d.g gVar : hVar.B()) {
                    if (!TextUtils.isEmpty(gVar.a())) {
                        com.bytedance.sdk.openadsdk.g.d.a(this.c).f().a(gVar.a(), com.bytedance.sdk.openadsdk.g.a.b.a(), gVar.b(), gVar.c());
                    }
                }
            }
            if (hVar.N() == 5 || hVar.N() == 15) {
                if (hVar.v() != null && hVar.v().h() != null) {
                    int d2 = ab.d(hVar.M());
                    if (o.h().b(String.valueOf(d2)) && o.h().q(String.valueOf(d2))) {
                        com.bytedance.sdk.openadsdk.core.video.f.c.a(new com.bytedance.sdk.openadsdk.h.f.b().a(hVar.v().h()).a(204800).b(hVar.v().k()));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        List<com.bytedance.sdk.openadsdk.core.d.h> list = this.f1712f;
        com.bytedance.sdk.openadsdk.f.a.c e2 = com.bytedance.sdk.openadsdk.f.a.c.b().a(this.f1715i).c(this.a.getCodeId()).e((list == null || list.size() <= 0) ? "" : ab.h(this.f1712f.get(0).M()));
        e2.b(i2).f(com.bytedance.sdk.openadsdk.core.g.a(i2));
        com.bytedance.sdk.openadsdk.f.a.a().c(e2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.f1711e.getAndSet(false)) {
            TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.f1710d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i2, str);
            }
            a aVar = this.f1714h;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTNativeExpressAd a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        int i2 = this.f1715i;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 5) {
                    if (i2 != 9) {
                        return null;
                    }
                    return new m(this.c, hVar, this.a);
                } else if (hVar.v() != null) {
                    return new n(this.c, hVar, this.a);
                } else {
                    return new k(this.c, hVar, this.a);
                }
            }
            return new com.bytedance.sdk.openadsdk.core.c.b(this.c, hVar, this.a);
        }
        return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.c, hVar, this.a);
    }

    private void a(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.f1716k;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            boolean cancel = this.f1716k.cancel(z);
            com.bytedance.sdk.openadsdk.utils.o.e("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + cancel);
        } catch (Throwable unused) {
        }
    }
}
