package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    private boolean n;

    public NativeDrawVideoTsView(@NonNull Context context, @NonNull com.bytedance.sdk.openadsdk.core.d.h hVar) {
        super(context, hVar);
        this.n = false;
        setOnClickListener(this);
    }

    private void e() {
        ac.a((View) this.f1819e, 0);
        ac.a((View) this.f1820f, 0);
        ac.a((View) this.f1822h, 8);
    }

    private void j() {
        g();
        RelativeLayout relativeLayout = this.f1819e;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.g.d.a(getContext()).a(this.a.v().g(), this.f1820f);
        }
        e();
    }

    public void a(Bitmap bitmap, int i2) {
        com.bytedance.sdk.openadsdk.core.h.b().a(bitmap);
        this.f1824j = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        this.f1818d = false;
        this.f1823i = "draw_ad";
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
            j();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i2) {
        ImageView imageView = this.f1821g;
        if (imageView != null && imageView.getVisibility() == 0) {
            j();
        } else {
            super.onWindowVisibilityChanged(i2);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.n = z;
    }
}
