package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    private boolean n;

    public ExpressVideoView(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        super(context, hVar, false, str);
        this.n = false;
        if ("draw_ad".equals(str)) {
            this.n = true;
        }
        setOnClickListener(this);
    }

    private void j() {
        ac.a((View) this.f1819e, 0);
        ac.a((View) this.f1820f, 0);
        ac.a((View) this.f1822h, 8);
    }

    private void k() {
        g();
        RelativeLayout relativeLayout = this.f1819e;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.g.d.a(getContext()).a(this.a.v().g(), this.f1820f);
        }
        j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void a(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        this.f1818d = false;
        o.h().s(String.valueOf(ab.d(this.a.M())));
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void d() {
        if (this.n) {
            super.d();
        }
    }

    public void e() {
        ImageView imageView = this.f1822h;
        if (imageView != null) {
            ac.a((View) imageView, 8);
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        ImageView imageView = this.f1821g;
        if (imageView != null && imageView.getVisibility() == 0) {
            ac.f(this.f1819e);
        }
        d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ImageView imageView = this.f1821g;
        if (imageView != null && imageView.getVisibility() == 0) {
            k();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        ImageView imageView = this.f1821g;
        if (imageView != null && imageView.getVisibility() == 0) {
            k();
        } else {
            super.onWindowVisibilityChanged(i2);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.n = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.b;
        if (cVar != null) {
            cVar.f(z);
        }
    }

    public void setShowAdInteractionView(boolean z) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h u;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.b;
        if (cVar == null || (u = cVar.u()) == null) {
            return;
        }
        u.d(z);
    }
}
