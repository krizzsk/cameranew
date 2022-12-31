package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.ArrayList;
import java.util.List;
/* compiled from: FeedAdManager.java */
/* loaded from: classes.dex */
public class a {
    private static volatile a a;
    private final p b = o.f();

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

    public void a(final Context context, final AdSlot adSlot, final TTAdNative.FeedAdListener feedAdListener) {
        this.b.a(adSlot, null, 5, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.a.a.1
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i2, String str) {
                feedAdListener.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    List<h> c = aVar.c();
                    ArrayList arrayList = new ArrayList(c.size());
                    for (h hVar : c) {
                        if (hVar.W()) {
                            arrayList.add(new c(context, hVar, 5, adSlot));
                        }
                        int N = hVar.N();
                        if (N == 5 || N == 15 || N == 50) {
                            if (hVar.v() != null && hVar.v().h() != null) {
                                int d2 = ab.d(hVar.M());
                                if (o.h().b(String.valueOf(d2)) && o.h().q(String.valueOf(d2))) {
                                    com.bytedance.sdk.openadsdk.core.video.f.c.a(new com.bytedance.sdk.openadsdk.h.f.b().a(hVar.v().h()).a(204800).b(hVar.v().k()));
                                }
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        feedAdListener.onFeedAdLoad(arrayList);
                        return;
                    } else {
                        feedAdListener.onError(-4, g.a(-4));
                        return;
                    }
                }
                feedAdListener.onError(-3, g.a(-3));
            }
        });
    }

    public void a(final Context context, AdSlot adSlot, final TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        this.b.a(adSlot, null, 9, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.a.a.2
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i2, String str) {
                drawFeedAdListener.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    List<h> c = aVar.c();
                    ArrayList arrayList = new ArrayList(c.size());
                    for (h hVar : c) {
                        if (hVar.W()) {
                            arrayList.add(new b(context, hVar, 9));
                        }
                        int N = hVar.N();
                        if (N == 5 || N == 15 || N == 50) {
                            if (hVar.v() != null && hVar.v().h() != null) {
                                int d2 = ab.d(hVar.M());
                                if (o.h().b(String.valueOf(d2)) && o.h().q(String.valueOf(d2))) {
                                    com.bytedance.sdk.openadsdk.core.video.f.c.a(new com.bytedance.sdk.openadsdk.h.f.b().a(hVar.v().h()).a(512000).b(hVar.v().k()));
                                }
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        drawFeedAdListener.onDrawFeedAdLoad(arrayList);
                        return;
                    } else {
                        drawFeedAdListener.onError(-4, g.a(-4));
                        return;
                    }
                }
                drawFeedAdListener.onError(-3, g.a(-3));
            }
        });
    }
}
