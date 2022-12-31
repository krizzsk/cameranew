package com.camera360.dynamic_feature_splice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.LinkedHashMap;
import java.util.Objects;
/* compiled from: LongImageView.kt */
/* loaded from: classes8.dex */
public final class LongImageView extends FrameLayout {
    private final Point a;
    private final DisplayMetrics b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2135d;

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f2136e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2137f;

    /* renamed from: g  reason: collision with root package name */
    private AnimatorSet f2138g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f2139h;

    /* renamed from: i  reason: collision with root package name */
    private kotlin.jvm.b.a<kotlin.u> f2140i;

    /* renamed from: j  reason: collision with root package name */
    private ScrollView f2141j;

    /* compiled from: LongImageView.kt */
    /* loaded from: classes8.dex */
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ kotlin.jvm.b.a<kotlin.u> a;
        final /* synthetic */ LongImageView b;

        a(kotlin.jvm.b.a<kotlin.u> aVar, LongImageView longImageView) {
            this.a = aVar;
            this.b = longImageView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.invoke();
            this.b.n();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongImageView(Context ctx, Bitmap smallbitmap) {
        super(ctx);
        int b;
        kotlin.jvm.internal.s.h(ctx, "ctx");
        kotlin.jvm.internal.s.h(smallbitmap, "smallbitmap");
        new LinkedHashMap();
        Point point = new Point(smallbitmap.getWidth(), smallbitmap.getHeight());
        this.a = point;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.b = displayMetrics;
        int i2 = displayMetrics.widthPixels;
        this.c = i2;
        this.f2137f = true;
        this.f2140i = LongImageView$hideCallback$1.INSTANCE;
        this.f2141j = new ScrollView(ctx);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        addView(this.f2141j, layoutParams);
        b = kotlin.y.c.b(i2 / (point.x / point.y));
        this.f2135d = b;
        LongLinearLayout longLinearLayout = new LongLinearLayout(ctx, point);
        this.f2136e = longLinearLayout;
        longLinearLayout.setOrientation(1);
        longLinearLayout.setBackgroundDrawable(new BitmapDrawable(smallbitmap));
        this.f2141j.setVerticalScrollBarEnabled(false);
        this.f2141j.addView(longLinearLayout, -1, -2);
        setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongImageView.a(LongImageView.this, view);
            }
        });
        longLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongImageView.b(LongImageView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LongImageView this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f2140i.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LongImageView this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f2140i.invoke();
    }

    private final AnimatorSet h(Rect rect, boolean z) {
        float f2;
        float f3;
        ObjectAnimator objectAnimator;
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        Rect rect2 = new Rect();
        this.f2141j.getGlobalVisibleRect(rect2);
        float width = rect.width() / this.c;
        float height = rect.height() / this.f2135d;
        if (z) {
            this.f2136e.setScaleX(width);
            this.f2136e.setScaleY(height);
            this.f2136e.setPivotX(this.c / 2.0f);
        }
        int i2 = rect2.top;
        int i3 = rect.top;
        if (i2 > i3 || rect2.bottom < rect.bottom) {
            f2 = i2 - i3;
            f3 = 0.0f;
        } else {
            f3 = height >= 0.0f ? 0.0f : ((this.f2141j.getScrollY() + rect.top) - rect2.top) / (1 - width);
            f2 = 0.0f;
        }
        this.f2136e.setPivotY(f3);
        if (f2 == 0.0f) {
            this.f2141j.setTranslationY(0.0f);
            objectAnimator = null;
        } else if (z) {
            float f4 = -f2;
            this.f2141j.setTranslationY(f4);
            objectAnimator = ObjectAnimator.ofFloat(this.f2141j, "translationY", f4, 0.0f);
        } else {
            ScrollView scrollView = this.f2141j;
            objectAnimator = ObjectAnimator.ofFloat(scrollView, "translationY", scrollView.getTranslationY(), -f2);
        }
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(this.f2136e, "scaleX", width, 1.0f);
        } else {
            LinearLayout linearLayout = this.f2136e;
            ofFloat = ObjectAnimator.ofFloat(linearLayout, "scaleX", linearLayout.getScaleX(), width);
        }
        if (z) {
            ofFloat2 = ObjectAnimator.ofFloat(this.f2136e, "scaleY", height, 1.0f);
        } else {
            LinearLayout linearLayout2 = this.f2136e;
            ofFloat2 = ObjectAnimator.ofFloat(linearLayout2, "scaleY", linearLayout2.getScaleY(), height);
        }
        ValueAnimator ofInt = z ? ValueAnimator.ofInt(0, 255) : ValueAnimator.ofInt(255, 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LongImageView.i(LongImageView.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        if (objectAnimator != null) {
            animatorSet.play(ofFloat).with(ofFloat2).with(ofInt).with(objectAnimator);
        } else {
            animatorSet.play(ofFloat).with(ofFloat2).with(ofInt);
        }
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LongImageView this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.setBackgroundColor(((Integer) animatedValue).intValue() << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r17, kotlin.coroutines.Continuation<? super java.util.ArrayList<android.graphics.Bitmap>> r18) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.camera360.dynamic_feature_splice.LongImageView.p(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void f(kotlin.jvm.b.a<kotlin.u> animEnd) {
        kotlin.jvm.internal.s.h(animEnd, "animEnd");
        AnimatorSet animatorSet = this.f2138g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        Rect rect = this.f2139h;
        if (rect == null) {
            animEnd.invoke();
            n();
            return;
        }
        AnimatorSet h2 = h(rect, false);
        h2.addListener(new a(animEnd, this));
        this.f2138g = h2;
        h2.start();
    }

    public final void g(Rect viewRect) {
        kotlin.jvm.internal.s.h(viewRect, "viewRect");
        this.f2139h = viewRect;
        AnimatorSet animatorSet = this.f2138g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet h2 = h(viewRect, true);
        this.f2138g = h2;
        h2.start();
    }

    public final void j(kotlin.jvm.b.a<kotlin.u> hide) {
        kotlin.jvm.internal.s.h(hide, "hide");
        this.f2140i = hide;
    }

    public final void n() {
        this.f2136e.removeAllViews();
        this.f2136e.setOnClickListener(null);
        setOnClickListener(null);
        this.f2137f = true;
    }

    public final void o(String path) {
        kotlin.jvm.internal.s.h(path, "path");
        this.f2137f = false;
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new LongImageView$showBigImage$1(this, path, null), 3, null);
    }
}
