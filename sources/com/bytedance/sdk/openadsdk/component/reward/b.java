package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.Map;
/* compiled from: FullScreenVideoController.java */
/* loaded from: classes.dex */
public class b extends com.bytedance.sdk.openadsdk.core.video.d.a {
    public b(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        super(context, viewGroup, hVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected int a() {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void a(int i2, int i3) {
        if (this.b == null) {
            return;
        }
        boolean z = z();
        String str = z ? "play_error" : "play_start_error";
        Map<String, Object> a = ab.a(this.b, i2, i3, t());
        a.put("play_type", Integer.valueOf(ab.a(this, this.f1796g)));
        if (z) {
            a.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(o()));
            a.put("percent", Integer.valueOf(q()));
            a.put("buffers_time", Long.valueOf(n()));
        }
        com.bytedance.sdk.openadsdk.c.d.c(this.a.get(), this.b, "fullscreen_interstitial_ad", str, a);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void b() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(ab.a(this, this.f1796g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.a.get(), this.b, "fullscreen_interstitial_ad", "feed_over", this.c, 100, B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void c() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(ab.a(this, this.f1796g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.a.get(), this.b, "fullscreen_interstitial_ad", "play_pause", o(), q(), B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void d() {
        Map<String, Object> B = B();
        B.put("play_type", Integer.valueOf(ab.a(this, this.f1796g)));
        com.bytedance.sdk.openadsdk.c.d.a(this.a.get(), this.b, "fullscreen_interstitial_ad", "continue_play", this.f1797h, q(), B);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void e() {
        Map<String, Object> A = A();
        A.put("play_type", Integer.valueOf(ab.a(this, this.f1796g)));
        com.bytedance.sdk.openadsdk.c.d.b(this.a.get(), this.b, "fullscreen_interstitial_ad", "feed_play", A);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.a
    protected void f() {
        Map<String, Object> A = A();
        A.put("play_type", Integer.valueOf(ab.a(this, this.f1796g)));
        com.bytedance.sdk.openadsdk.c.d.b(this.a.get(), this.b, "fullscreen_interstitial_ad", "feed_play", A);
    }
}
