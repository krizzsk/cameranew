package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.dislike.c;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.r;
/* compiled from: TTAdDislikeImpl.java */
/* loaded from: classes.dex */
public class b implements TTAdDislike {
    private final Context a;
    private h b;
    private c c;

    /* renamed from: d  reason: collision with root package name */
    private TTAdDislike.DislikeInteractionCallback f1947d;

    public b(Context context, h hVar) {
        r.a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.a = context;
        this.b = hVar;
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f1947d = dislikeInteractionCallback;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        Context context = this.a;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            this.c.show();
        }
    }

    private void a() {
        c cVar = new c(this.a, this.b);
        this.c = cVar;
        cVar.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.dislike.b.1
            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a() {
                o.b("TTAdDislikeImpl", "onDislikeShow: ");
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void b() {
                o.e("TTAdDislikeImpl", "onDislikeDismiss: ");
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void c() {
                o.e("TTAdDislikeImpl", "onDislikeOptionBack: ");
            }

            @Override // com.bytedance.sdk.openadsdk.dislike.c.a
            public void a(int i2, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions() && b.this.f1947d != null) {
                        b.this.f1947d.onSelected(i2, filterWord.getName());
                    }
                    o.e("TTAdDislikeImpl", "onDislikeSelected: " + i2 + ", " + String.valueOf(filterWord.getName()));
                } catch (Throwable th) {
                    o.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }
        });
    }

    public void a(h hVar) {
        this.c.a(hVar);
    }
}
