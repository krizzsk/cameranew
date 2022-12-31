package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.reward.a;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.c.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: FullScreenVideoLoadManager.java */
/* loaded from: classes.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile c a;
    private Context b;

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f1451d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private List<a> f1452e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f  reason: collision with root package name */
    private final BroadcastReceiver f1453f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || q.c(c.this.b) == 0) {
                return;
            }
            Iterator it = c.this.f1452e.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.i.a.a().b((Runnable) it.next(), 1);
                it.remove();
            }
        }
    };
    private final p c = o.f();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FullScreenVideoLoadManager.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        com.bytedance.sdk.openadsdk.core.d.h a;
        AdSlot b;

        a(com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot) {
            this.a = hVar;
            this.b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(this.a, new a.InterfaceC0048a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0048a
                public void a(boolean z, Object obj) {
                    if (z) {
                        com.bytedance.sdk.openadsdk.component.reward.a a = com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b);
                        a aVar = a.this;
                        a.a(aVar.b, aVar.a);
                    }
                }
            });
        }
    }

    private c(Context context) {
        this.b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        if (this.f1451d.get()) {
            return;
        }
        this.f1451d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.b.registerReceiver(this.f1453f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        if (this.f1451d.get()) {
            this.f1451d.set(false);
            try {
                this.b.unregisterReceiver(this.f1453f);
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        d();
    }

    public void b() {
        AdSlot b = com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).b();
        if (b == null || TextUtils.isEmpty(b.getCodeId()) || com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).c(b.getCodeId()) != null) {
            return;
        }
        b(b);
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    public void b(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "preload full screen video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.bytedance.sdk.openadsdk.core.d.i iVar = new com.bytedance.sdk.openadsdk.core.d.i();
        iVar.c = z ? 2 : 1;
        if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            iVar.f1602e = 2;
        }
        this.c.a(adSlot, iVar, 8, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i2, String str) {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                if (z || (fullScreenVideoAdListener2 = fullScreenVideoAdListener) == null) {
                    return;
                }
                fullScreenVideoAdListener2.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener3;
                TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener4;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "get material data success isPreload=" + z);
                    final com.bytedance.sdk.openadsdk.core.d.h hVar = aVar.c().get(0);
                    try {
                        if (hVar.y() != null && !TextUtils.isEmpty(hVar.y().a())) {
                            String a2 = hVar.y().a();
                            com.bytedance.sdk.openadsdk.g.b bVar = new com.bytedance.sdk.openadsdk.g.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(8);
                            bVar.c(hVar.J());
                            bVar.d(hVar.M());
                            bVar.b(ab.h(hVar.M()));
                            com.bytedance.sdk.openadsdk.g.d.a(c.this.b).g().a(a2, bVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final i iVar2 = new i(c.this.b, hVar, adSlot);
                    if (!z && (fullScreenVideoAdListener4 = fullScreenVideoAdListener) != null) {
                        fullScreenVideoAdListener4.onFullScreenVideoAdLoad(iVar2);
                    }
                    com.bytedance.sdk.openadsdk.core.video.c.a.a().a(hVar, new a.InterfaceC0053a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.video.c.a.InterfaceC0053a
                        public void a(boolean z2) {
                            com.bytedance.sdk.openadsdk.core.d.h hVar2;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z || fullScreenVideoAdListener == null || (hVar2 = hVar) == null || !hVar2.s()) {
                                return;
                            }
                            fullScreenVideoAdListener.onFullScreenVideoCached();
                        }
                    });
                    if (hVar.W()) {
                        if (z && !hVar.s() && o.h().r(adSlot.getCodeId()).f1635d == 1) {
                            if (q.d(c.this.b)) {
                                return;
                            }
                            c cVar = c.this;
                            cVar.a(new a(hVar, adSlot));
                        } else if (!hVar.s()) {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(hVar, new a.InterfaceC0048a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0048a
                                public void a(boolean z2, Object obj) {
                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener5;
                                    com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        iVar2.a(com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(hVar));
                                    }
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (z) {
                                        if (z2) {
                                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(adSlot, hVar);
                                            return;
                                        }
                                        return;
                                    }
                                    com.bytedance.sdk.openadsdk.c.d.a(hVar);
                                    if (!z2 || (fullScreenVideoAdListener5 = fullScreenVideoAdListener) == null) {
                                        return;
                                    }
                                    fullScreenVideoAdListener5.onFullScreenVideoCached();
                                }
                            });
                        } else {
                            com.bytedance.sdk.openadsdk.component.reward.a.a(c.this.b).a(adSlot, hVar);
                        }
                    } else if (z || (fullScreenVideoAdListener3 = fullScreenVideoAdListener) == null) {
                    } else {
                        fullScreenVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                    }
                } else if (z || (fullScreenVideoAdListener2 = fullScreenVideoAdListener) == null) {
                } else {
                    fullScreenVideoAdListener2.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                }
            }
        });
    }

    public void a() {
        try {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).a();
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).b(adSlot);
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).a(adSlot);
        a(adSlot, false, fullScreenVideoAdListener);
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        if (z) {
            b(adSlot, true, fullScreenVideoAdListener);
            return;
        }
        final com.bytedance.sdk.openadsdk.core.d.h c = com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).c(adSlot.getCodeId());
        if (c != null) {
            i iVar = new i(this.b, c, adSlot);
            if (!c.s()) {
                iVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).a(c));
            }
            com.bytedance.sdk.openadsdk.c.d.a(c);
            if (fullScreenVideoAdListener != null) {
                fullScreenVideoAdListener.onFullScreenVideoAdLoad(iVar);
                if (!c.s()) {
                    fullScreenVideoAdListener.onFullScreenVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.video.c.a.a().a(c, new a.InterfaceC0053a() { // from class: com.bytedance.sdk.openadsdk.component.reward.c.1
                @Override // com.bytedance.sdk.openadsdk.core.video.c.a.InterfaceC0053a
                public void a(boolean z2) {
                    if (fullScreenVideoAdListener == null || !c.s()) {
                        return;
                    }
                    fullScreenVideoAdListener.onFullScreenVideoCached();
                }
            });
            com.bytedance.sdk.openadsdk.utils.o.b("FullScreenVideoLoadManager", "get cache data success");
            return;
        }
        b(adSlot, false, fullScreenVideoAdListener);
    }

    @Nullable
    public AdSlot b(String str) {
        return com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).b(str);
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.component.reward.a.a(this.b).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f1452e.size() >= 1) {
            this.f1452e.remove(0);
        }
        this.f1452e.add(aVar);
    }
}
