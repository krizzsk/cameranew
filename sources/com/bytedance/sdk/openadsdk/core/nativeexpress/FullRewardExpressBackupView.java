package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.t;
/* loaded from: classes.dex */
public class FullRewardExpressBackupView extends BackupView {

    /* renamed from: h  reason: collision with root package name */
    private View f1693h;

    /* renamed from: i  reason: collision with root package name */
    private NativeExpressView f1694i;

    /* renamed from: j  reason: collision with root package name */
    private FrameLayout f1695j;

    /* renamed from: k  reason: collision with root package name */
    private d.a.a.a.a.a.b f1696k;

    public FullRewardExpressBackupView(@NonNull Context context) {
        super(context);
        this.a = context;
    }

    private void b() {
        this.f1691f = ac.c(this.a, this.f1694i.getExpectExpressWidth());
        this.f1692g = ac.c(this.a, this.f1694i.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f1691f, this.f1692g);
        }
        layoutParams.width = this.f1691f;
        layoutParams.height = this.f1692g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.b.i();
        c();
    }

    private void c() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_backup_full_reward"), (ViewGroup) this, true);
        this.f1693h = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(t.e(this.a, "tt_bu_video_container"));
        this.f1695j = frameLayout;
        frameLayout.removeAllViews();
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar, NativeExpressView nativeExpressView, d.a.a.a.a.a.b bVar) {
        o.b("FullRewardExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.b = hVar;
        this.f1694i = nativeExpressView;
        this.f1696k = bVar;
        if (ab.c(hVar.M()) == 7) {
            this.f1690e = "rewarded_video";
        } else {
            this.f1690e = "fullscreen_interstitial_ad";
        }
        b();
        this.f1694i.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    public FrameLayout getVideoContainer() {
        return this.f1695j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i2, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        NativeExpressView nativeExpressView = this.f1694i;
        if (nativeExpressView != null) {
            nativeExpressView.a(i2, fVar);
        }
    }
}
