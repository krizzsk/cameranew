package com.bytedance.sdk.openadsdk.component.banner;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BannerView.java */
/* loaded from: classes.dex */
public class d extends FrameLayout {
    private final Context a;
    private c b;
    private c c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f1426d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f1427e;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dislike.b f1428f;

    /* renamed from: g  reason: collision with root package name */
    private int f1429g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1430h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1431i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1432j;

    public d(@NonNull Context context) {
        super(context);
        this.f1431i = false;
        this.f1432j = false;
        this.a = context;
        g();
    }

    private void g() {
        c cVar = new c(this.a);
        this.b = cVar;
        addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        i();
        h();
    }

    private void h() {
        if (this.f1432j) {
            return;
        }
        this.f1432j = true;
        ImageView imageView = new ImageView(this.a);
        this.f1426d = imageView;
        imageView.setImageResource(t.d(o.a(), "tt_dislike_icon"));
        this.f1426d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1426d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.banner.d.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                if (d.this.f1428f != null) {
                    d.this.f1428f.showDislikeDialog();
                }
            }
        });
        int a = (int) ac.a(this.a, 15.0f);
        int a2 = (int) ac.a(this.a, 10.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a, a);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = a2;
        layoutParams.rightMargin = a2;
        addView(this.f1426d, layoutParams);
        ac.a(this.f1426d, a, a, a, a);
    }

    private void i() {
        if (this.f1431i) {
            return;
        }
        this.f1431i = true;
        ImageView imageView = new ImageView(this.a);
        this.f1427e = imageView;
        imageView.setImageResource(t.d(o.a(), "tt_ad_logo_small"));
        this.f1427e.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(20, 20);
        layoutParams.gravity = 8388693;
        addView(this.f1427e, layoutParams);
    }

    private void j() {
        ImageView imageView = this.f1427e;
        if (imageView != null) {
            bringChildToFront(imageView);
        }
        ImageView imageView2 = this.f1426d;
        if (imageView2 != null) {
            bringChildToFront(imageView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        c cVar = this.b;
        this.b = this.c;
        this.c = cVar;
        cVar.b();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        j();
    }

    public c c() {
        return this.c;
    }

    public View d() {
        return this.f1426d;
    }

    public void e() {
        if (this.f1430h) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a(this.b)).with(b(this.c));
        animatorSet.setDuration(this.f1429g).start();
        c cVar = this.c;
        cVar.setVisibility(0);
        VdsAgent.onSetViewVisibility(cVar, 0);
        this.f1430h = true;
    }

    public boolean f() {
        c cVar = this.c;
        return (cVar == null || cVar.a() == null) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1431i = false;
        this.f1432j = false;
    }

    public c b() {
        return this.b;
    }

    private ObjectAnimator b(final c cVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.component.banner.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.f1430h = false;
                d.this.k();
                c cVar2 = cVar;
                if (cVar2 != null) {
                    d.this.a(cVar2.a());
                }
                com.bytedance.sdk.openadsdk.utils.o.b("TTBannerAd", "SLIDE END");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                com.bytedance.sdk.openadsdk.utils.o.b("TTBannerAd", "SLIDE START");
            }
        });
        return ofFloat;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        j();
    }

    public void a() {
        c cVar = new c(this.a);
        this.c = cVar;
        cVar.setVisibility(8);
        VdsAgent.onSetViewVisibility(cVar, 8);
        addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        super.addView(view, i2);
        j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        this.f1428f = bVar;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, int i3) {
        super.addView(view, i2, i3);
        j();
    }

    public void a(int i2) {
        this.f1429g = i2;
    }

    private ObjectAnimator a(c cVar) {
        return ObjectAnimator.ofFloat(cVar, "translationX", 0.0f, -getWidth());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar) {
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.f1428f;
        if (bVar == null || hVar == null) {
            return;
        }
        bVar.a(hVar);
    }
}
