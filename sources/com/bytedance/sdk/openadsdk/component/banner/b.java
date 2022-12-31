package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.ref.WeakReference;
/* compiled from: BannerAdManager.java */
/* loaded from: classes.dex */
public class b {
    private static volatile b a;
    private WeakReference<Context> b;
    private final p c = o.f();

    /* compiled from: BannerAdManager.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(@NonNull com.bytedance.sdk.openadsdk.component.banner.a aVar);
    }

    private b(Context context) {
        this.b = new WeakReference<>(context);
    }

    private void b(Context context) {
        this.b = new WeakReference<>(context);
    }

    public static b a(@NonNull Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        } else {
            a.b(context);
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull AdSlot adSlot, final a aVar) {
        this.c.a(adSlot, null, 1, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.1
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i2, String str) {
                com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", str + "  " + i2);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar2) {
                if (aVar2.c() == null || aVar2.c().isEmpty()) {
                    return;
                }
                h hVar = aVar2.c().get(0);
                if (hVar.W()) {
                    b.this.a(hVar, aVar);
                    return;
                }
                com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", "Banner广告解析失败/广告为空");
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }
        });
    }

    public void a(@NonNull final AdSlot adSlot, @NonNull final TTAdNative.BannerAdListener bannerAdListener) {
        this.c.a(adSlot, null, 1, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.2
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i2, String str) {
                bannerAdListener.onError(i2, str);
                com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", str + " " + i2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    h hVar = aVar.c().get(0);
                    if (hVar.W()) {
                        b.this.a(hVar, new a() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.2.1
                            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
                            public void a(@NonNull com.bytedance.sdk.openadsdk.component.banner.a aVar2) {
                                if (b.this.b.get() != null) {
                                    bannerAdListener.onBannerAdLoad(new e((Context) b.this.b.get(), aVar2, adSlot));
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
                            public void a() {
                                bannerAdListener.onError(-5, g.a(-5));
                            }
                        });
                        return;
                    }
                    com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", "Banner广告解析失败");
                    bannerAdListener.onError(-4, g.a(-4));
                    return;
                }
                com.bytedance.sdk.openadsdk.utils.o.b("BannerAdManager", "Banner广告解析失败/广告为空");
                bannerAdListener.onError(-4, g.a(-4));
            }
        });
    }

    private Context a() {
        WeakReference<Context> weakReference = this.b;
        return (weakReference == null || weakReference.get() == null) ? o.a() : this.b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final h hVar, @Nullable final a aVar) {
        com.bytedance.sdk.openadsdk.g.d.a(a()).g().a(hVar.B().get(0).a(), new d.InterfaceC0041d() { // from class: com.bytedance.sdk.openadsdk.component.banner.b.3
            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
            public void a() {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
            public void a(d.c cVar, boolean z) {
                if (cVar != null && cVar.a() != null) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(new com.bytedance.sdk.openadsdk.component.banner.a(cVar.a(), hVar));
                        return;
                    }
                    return;
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void a(m<Bitmap> mVar) {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0041d
            public void b() {
            }

            @Override // com.bytedance.sdk.adnet.core.m.a
            public void b(m<Bitmap> mVar) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        });
    }
}
