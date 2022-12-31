package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BannerExpressView.java */
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private final Context a;
    private NativeExpressView b;
    private NativeExpressView c;

    /* renamed from: d  reason: collision with root package name */
    private h f1520d;

    /* renamed from: e  reason: collision with root package name */
    private AdSlot f1521e;

    /* renamed from: f  reason: collision with root package name */
    private TTNativeExpressAd.ExpressAdInteractionListener f1522f;

    /* renamed from: g  reason: collision with root package name */
    private int f1523g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1524h;

    /* renamed from: i  reason: collision with root package name */
    private String f1525i;

    public a(@NonNull Context context, h hVar, AdSlot adSlot) {
        super(context);
        this.f1525i = "banner_ad";
        this.a = context;
        this.f1520d = hVar;
        this.f1521e = adSlot;
        g();
    }

    private void g() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.a, this.f1520d, this.f1521e, this.f1525i);
        this.b = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f1524h || this.c == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a(this.b)).with(b(this.c));
        animatorSet.setDuration(this.f1523g).start();
        ac.a((View) this.c, 0);
        this.f1524h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        NativeExpressView nativeExpressView = this.b;
        this.b = this.c;
        this.c = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.c.k();
            this.c = null;
        }
    }

    public NativeExpressView d() {
        return this.c;
    }

    public void e() {
        NativeExpressView nativeExpressView = this.c;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public boolean f() {
        return this.c != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void b() {
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.b.k();
            this.b = null;
        }
        NativeExpressView nativeExpressView2 = this.c;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.c.k();
            this.c = null;
        }
    }

    public NativeExpressView c() {
        return this.b;
    }

    public void a(h hVar, AdSlot adSlot) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.a, hVar, adSlot, this.f1525i);
        this.c = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i2) {
                if (a.this.f1522f != null) {
                    a.this.f1522f.onAdClicked(a.this, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                a.this.a(f2, f3);
                a.this.h();
            }
        });
        ac.a((View) this.c, 8);
        addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f1522f = expressAdInteractionListener;
        this.b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i2) {
                if (a.this.f1522f != null) {
                    a.this.f1522f.onAdClicked(a.this, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
                if (a.this.f1522f != null) {
                    a.this.f1522f.onRenderFail(a.this, str, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).m()) {
                    a.this.a(f2, f3);
                }
                if (a.this.f1522f != null) {
                    a.this.f1522f.onRenderSuccess(a.this, f2, f3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, float f3) {
        int a = (int) ac.a(this.a, f2);
        int a2 = (int) ac.a(this.a, f3);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(a, a2);
        }
        layoutParams.width = a;
        layoutParams.height = a2;
        setLayoutParams(layoutParams);
    }

    private ObjectAnimator b(NativeExpressView nativeExpressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f1524h = false;
                a.this.i();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        return ofFloat;
    }

    public void a() {
        NativeExpressView nativeExpressView = this.b;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public void a(int i2) {
        this.f1523g = i2;
    }

    private ObjectAnimator a(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }
}
