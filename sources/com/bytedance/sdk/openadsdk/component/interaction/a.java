package com.bytedance.sdk.openadsdk.component.interaction;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
/* compiled from: InteractionAdManager.java */
/* loaded from: classes.dex */
public class a {
    private final p a = o.f();

    private a() {
    }

    public static a a() {
        return new a();
    }

    public void a(final Context context, AdSlot adSlot, final TTAdNative.InteractionAdListener interactionAdListener) {
        this.a.a(adSlot, null, 2, new p.a() { // from class: com.bytedance.sdk.openadsdk.component.interaction.a.1
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i2, String str) {
                interactionAdListener.onError(i2, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    h hVar = aVar.c().get(0);
                    if (hVar.W()) {
                        final b bVar = new b(context, hVar);
                        bVar.a(new k() { // from class: com.bytedance.sdk.openadsdk.component.interaction.a.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.k
                            public void a() {
                                interactionAdListener.onInteractionAdLoad(bVar);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.k
                            public void b() {
                                interactionAdListener.onError(-6, g.a(-6));
                            }
                        });
                        return;
                    }
                    interactionAdListener.onError(-4, g.a(-4));
                    return;
                }
                interactionAdListener.onError(-3, g.a(-3));
            }
        });
    }
}
