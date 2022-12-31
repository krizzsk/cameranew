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
import com.bytedance.sdk.openadsdk.component.reward.e;
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
/* compiled from: RewardVideoLoadManager.java */
/* loaded from: classes.dex */
public class g {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile g a;
    private Context b;

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f1458d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private List<a> f1459e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f  reason: collision with root package name */
    private final BroadcastReceiver f1460f = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || q.c(g.this.b) == 0) {
                return;
            }
            Iterator it = g.this.f1459e.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.i.a.a().b((Runnable) it.next(), 1);
                it.remove();
            }
        }
    };
    private final p c = o.f();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RewardVideoLoadManager.java */
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
            e.a(g.this.b).a(this.a, new e.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.a.1
                @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                public void a(boolean z, Object obj) {
                    if (z) {
                        e a = e.a(g.this.b);
                        a aVar = a.this;
                        a.a(aVar.b, aVar.a);
                    }
                }
            });
        }
    }

    private g(Context context) {
        this.b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        if (this.f1458d.get()) {
            return;
        }
        this.f1458d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.b.registerReceiver(this.f1460f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        if (this.f1458d.get()) {
            this.f1458d.set(false);
            try {
                this.b.unregisterReceiver(this.f1460f);
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        d();
    }

    public void b() {
        try {
            e.a(this.b).a();
        } catch (Throwable unused) {
        }
    }

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
                }
            }
        }
        return a;
    }

    public void b(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "preload reward video: " + String.valueOf(adSlot));
        a(adSlot, true, null);
    }

    private void b(final AdSlot adSlot, final boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        com.bytedance.sdk.openadsdk.core.d.i iVar = new com.bytedance.sdk.openadsdk.core.d.i();
        iVar.b = z ? 2 : 1;
        if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            iVar.f1602e = 2;
        }
        this.c.a(adSlot, iVar, 7, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i2, String str) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                if (z || (rewardVideoAdListener2 = rewardVideoAdListener) == null) {
                    return;
                }
                rewardVideoAdListener2.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener3;
                TTAdNative.RewardVideoAdListener rewardVideoAdListener4;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "get material data success isPreload=" + z);
                    final com.bytedance.sdk.openadsdk.core.d.h hVar = aVar.c().get(0);
                    try {
                        if (hVar.y() != null && !TextUtils.isEmpty(hVar.y().a())) {
                            String a2 = hVar.y().a();
                            com.bytedance.sdk.openadsdk.g.b bVar = new com.bytedance.sdk.openadsdk.g.b(true);
                            bVar.a(adSlot.getCodeId());
                            bVar.a(7);
                            bVar.c(hVar.J());
                            bVar.d(hVar.M());
                            bVar.b(ab.h(hVar.M()));
                            com.bytedance.sdk.openadsdk.g.d.a(g.this.b).g().a(a2, bVar);
                        }
                    } catch (Throwable unused) {
                    }
                    final j jVar = new j(g.this.b, hVar, adSlot);
                    if (!z && (rewardVideoAdListener4 = rewardVideoAdListener) != null) {
                        rewardVideoAdListener4.onRewardVideoAdLoad(jVar);
                    }
                    com.bytedance.sdk.openadsdk.core.video.c.a.a().a(hVar, new a.InterfaceC0053a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2.1
                        @Override // com.bytedance.sdk.openadsdk.core.video.c.a.InterfaceC0053a
                        public void a(boolean z2) {
                            com.bytedance.sdk.openadsdk.core.d.h hVar2;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            if (z || rewardVideoAdListener == null || (hVar2 = hVar) == null || !hVar2.s()) {
                                return;
                            }
                            rewardVideoAdListener.onRewardVideoCached();
                        }
                    });
                    if (hVar.W()) {
                        if (z && !hVar.s() && o.h().r(adSlot.getCodeId()).f1635d == 1) {
                            if (q.d(g.this.b)) {
                                return;
                            }
                            g gVar = g.this;
                            gVar.a(new a(hVar, adSlot));
                        } else if (!hVar.s()) {
                            e.a(g.this.b).a(hVar, new e.a<Object>() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.2.2
                                @Override // com.bytedance.sdk.openadsdk.component.reward.e.a
                                public void a(boolean z2, Object obj) {
                                    TTAdNative.RewardVideoAdListener rewardVideoAdListener5;
                                    com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "download video file: " + z2 + ", preload: " + z);
                                    if (z2) {
                                        jVar.a(e.a(g.this.b).a(hVar));
                                    }
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (z) {
                                        if (z2) {
                                            e.a(g.this.b).a(adSlot, hVar);
                                            return;
                                        }
                                        return;
                                    }
                                    com.bytedance.sdk.openadsdk.c.d.a(hVar);
                                    if (!z2 || (rewardVideoAdListener5 = rewardVideoAdListener) == null) {
                                        return;
                                    }
                                    rewardVideoAdListener5.onRewardVideoCached();
                                }
                            });
                        } else {
                            e.a(g.this.b).a(adSlot, hVar);
                        }
                    } else if (z || (rewardVideoAdListener3 = rewardVideoAdListener) == null) {
                    } else {
                        rewardVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                    }
                } else if (z || (rewardVideoAdListener2 = rewardVideoAdListener) == null) {
                } else {
                    rewardVideoAdListener2.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                }
            }
        });
    }

    public void a() {
        AdSlot b = e.a(this.b).b();
        if (b == null || TextUtils.isEmpty(b.getCodeId()) || e.a(this.b).c(b.getCodeId()) != null) {
            return;
        }
        b(b);
    }

    @Nullable
    public AdSlot b(String str) {
        return e.a(this.b).b(str);
    }

    public void a(AdSlot adSlot) {
        e.a(this.b).b(adSlot);
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
        e.a(this.b).a(adSlot);
        a(adSlot, false, rewardVideoAdListener);
    }

    private void a(AdSlot adSlot, boolean z, final TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (z) {
            b(adSlot, true, rewardVideoAdListener);
            return;
        }
        final com.bytedance.sdk.openadsdk.core.d.h c = e.a(this.b).c(adSlot.getCodeId());
        if (c != null) {
            j jVar = new j(this.b, c, adSlot);
            if (!c.s()) {
                jVar.a(e.a(this.b).a(c));
            }
            com.bytedance.sdk.openadsdk.c.d.a(c);
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onRewardVideoAdLoad(jVar);
                if (!c.s()) {
                    rewardVideoAdListener.onRewardVideoCached();
                }
            }
            com.bytedance.sdk.openadsdk.core.video.c.a.a().a(c, new a.InterfaceC0053a() { // from class: com.bytedance.sdk.openadsdk.component.reward.g.1
                @Override // com.bytedance.sdk.openadsdk.core.video.c.a.InterfaceC0053a
                public void a(boolean z2) {
                    if (rewardVideoAdListener == null || !c.s()) {
                        return;
                    }
                    rewardVideoAdListener.onRewardVideoCached();
                }
            });
            com.bytedance.sdk.openadsdk.utils.o.b("RewardVideoLoadManager", "get cache data success");
            return;
        }
        b(adSlot, false, rewardVideoAdListener);
    }

    public void a(String str) {
        e.a(this.b).a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f1459e.size() >= 1) {
            this.f1459e.remove(0);
        }
        this.f1459e.add(aVar);
    }
}
