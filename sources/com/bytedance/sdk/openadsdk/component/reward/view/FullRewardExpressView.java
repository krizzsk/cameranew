package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
/* loaded from: classes.dex */
public class FullRewardExpressView extends NativeExpressView implements g {
    g a;
    FullRewardExpressBackupView b;

    public FullRewardExpressView(@NonNull Context context, h hVar, AdSlot adSlot, String str) {
        super(context, hVar, adSlot, str);
    }

    private void c() {
        setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i2) {
                nativeExpressView.l();
                FullRewardExpressView.this.b = new FullRewardExpressBackupView(nativeExpressView.getContext());
                FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                fullRewardExpressView.b.a(((NativeExpressView) fullRewardExpressView).f1705k, nativeExpressView, null);
                return true;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void K() {
        o.b("FullRewardExpressView", "onSkipVideo");
        g gVar = this.a;
        if (gVar != null) {
            gVar.K();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long L() {
        o.b("FullRewardExpressView", "onGetCurrentPlayTime");
        g gVar = this.a;
        if (gVar != null) {
            return gVar.L();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int M() {
        o.b("FullRewardExpressView", "onGetVideoState");
        g gVar = this.a;
        if (gVar != null) {
            return gVar.M();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void N() {
        g gVar = this.a;
        if (gVar != null) {
            gVar.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void b() {
        super.b();
        this.f1702h.a((g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e(boolean z) {
        o.b("FullRewardExpressView", "onMuteVideo,mute:" + z);
        g gVar = this.a;
        if (gVar != null) {
            gVar.e(z);
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (m()) {
            return this.b.getVideoContainer();
        }
        return this.m;
    }

    public void setExpressVideoListenerProxy(g gVar) {
        this.a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
        if (jVar == null) {
            return;
        }
        double d2 = jVar.d();
        double e2 = jVar.e();
        double f2 = jVar.f();
        double g2 = jVar.g();
        int a = (int) ac.a(this.f1700f, (float) d2);
        int a2 = (int) ac.a(this.f1700f, (float) e2);
        int a3 = (int) ac.a(this.f1700f, (float) f2);
        int a4 = (int) ac.a(this.f1700f, (float) g2);
        o.b("ExpressView", "videoWidth:" + f2);
        o.b("ExpressView", "videoHeight:" + g2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(a3, a4);
        }
        layoutParams.width = a3;
        layoutParams.height = a4;
        layoutParams.topMargin = a2;
        layoutParams.leftMargin = a;
        this.m.setLayoutParams(layoutParams);
        this.m.removeAllViews();
    }

    private void b(final j jVar) {
        if (jVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(jVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.c(jVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void a() {
        this.o = true;
        FrameLayout frameLayout = new FrameLayout(this.f1700f);
        this.m = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(j jVar) {
        if (jVar != null && jVar.a()) {
            b(jVar);
        }
        super.a(jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, f fVar) {
        if (i2 != -1 && fVar != null && i2 == 3) {
            N();
        }
        super.a(i2, fVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void c(int i2) {
        o.b("FullRewardExpressView", "onChangeVideoState,stateType:" + i2);
        g gVar = this.a;
        if (gVar != null) {
            gVar.c(i2);
        }
    }
}
