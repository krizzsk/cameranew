package us.pinguo.camera2020.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.module.frame.FrameRatioModule;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.common.EventType;
import us.pinguo.common.recycler.layoutmanager.SmoothScrollLayoutManager;
/* compiled from: FrameMenuController.kt */
/* loaded from: classes3.dex */
public final class p2 implements us.pinguo.camera2020.view.t2.b, us.pinguo.common.g {
    private final View a;
    private final FrameRatioModule b;
    private final us.pinguo.common.recycler.a.b<us.pinguo.camera2020.view.s2.a, us.pinguo.camera2020.view.s2.b, us.pinguo.common.recycler.a.d> c;

    /* renamed from: d  reason: collision with root package name */
    private Set<? extends CameraFrame> f9446d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f9447e;

    public p2(View frameView, FrameRatioModule frameRatioModule) {
        kotlin.jvm.internal.s.h(frameView, "frameView");
        kotlin.jvm.internal.s.h(frameRatioModule, "frameRatioModule");
        this.a = frameView;
        this.b = frameRatioModule;
        this.c = new us.pinguo.common.recycler.a.b<>();
        Context context = frameView.getContext();
        kotlin.jvm.internal.s.g(context, "frameView.context");
        SmoothScrollLayoutManager smoothScrollLayoutManager = new SmoothScrollLayoutManager(context, 0, false);
        smoothScrollLayoutManager.a(false);
        int i2 = R.id.rvFrames;
        RecyclerView recyclerView = (RecyclerView) frameView.findViewById(i2);
        kotlin.jvm.internal.s.g(recyclerView, "frameView.rvFrames");
        Context context2 = frameView.getContext();
        kotlin.jvm.internal.s.g(context2, "frameView.context");
        smoothScrollLayoutManager.b(new SmoothScrollLayoutManager.a(recyclerView, context2));
        RecyclerView recyclerView2 = (RecyclerView) frameView.findViewById(i2);
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setLayoutManager(smoothScrollLayoutManager);
    }

    private final void h() {
        if (this.a.getVisibility() == 0) {
            this.a.animate().alpha(0.0f).translationY(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.r0
                @Override // java.lang.Runnable
                public final void run() {
                    p2.i(p2.this);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(p2 this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        View view = this$0.a;
        view.setVisibility(4);
        VdsAgent.onSetViewVisibility(view, 4);
    }

    private final void j(final View view) {
        final View view2 = this.a;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(view.getWidth(), -2);
        Context context = view2.getContext();
        kotlin.jvm.internal.s.g(context, "context");
        if (us.pinguo.edit2020.utils.d.f(context)) {
            layoutParams.addRule(21);
            layoutParams.setMarginEnd((int) view.getX());
        } else {
            layoutParams.setMarginStart((int) view.getX());
        }
        int i2 = R.id.ivArrow;
        ImageView imageView = (ImageView) view2.findViewById(i2);
        if (imageView != null) {
            imageView.setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        int i3 = R.id.rlFrames;
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(i3);
        if (relativeLayout != null) {
            relativeLayout.setLayoutParams(layoutParams2);
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(i3);
        if (relativeLayout2 != null) {
            relativeLayout2.measure(-2, -2);
        }
        ImageView ivArrow = (ImageView) view2.findViewById(i2);
        kotlin.jvm.internal.s.g(ivArrow, "ivArrow");
        us.pinguo.foundation.ui.c.b(ivArrow, new Runnable() { // from class: us.pinguo.camera2020.view.q0
            @Override // java.lang.Runnable
            public final void run() {
                p2.k(view2, view);
            }
        });
        ValueAnimator valueAnimator = this.f9447e;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            ValueAnimator valueAnimator2 = this.f9447e;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
        } else {
            view2.setTranslationY(this.a.getHeight());
            view2.setAlpha(0.0f);
        }
        view2.setVisibility(0);
        VdsAgent.onSetViewVisibility(view2, 0);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 0.0f, 0.0f));
        this.f9447e = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setDuration(200L);
        }
        ValueAnimator valueAnimator3 = this.f9447e;
        if (valueAnimator3 != null) {
            valueAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ValueAnimator valueAnimator4 = this.f9447e;
        if (valueAnimator4 == null) {
            return;
        }
        valueAnimator4.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(View this_apply, View view) {
        kotlin.jvm.internal.s.h(this_apply, "$this_apply");
        kotlin.jvm.internal.s.h(view, "$view");
        Context context = this_apply.getContext();
        kotlin.jvm.internal.s.g(context, "context");
        if (us.pinguo.edit2020.utils.d.f(context)) {
            int x = ((int) view.getX()) + (view.getWidth() / 2);
            int i2 = R.id.rlFrames;
            if (x + (((RelativeLayout) this_apply.findViewById(i2)).getWidth() / 2) > us.pinguo.foundation.t.b.a.f().x - us.pinguo.foundation.utils.n0.c(8)) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                ImageView imageView = (ImageView) this_apply.findViewById(R.id.ivArrow);
                kotlin.jvm.internal.s.e(imageView);
                layoutParams.addRule(3, imageView.getId());
                layoutParams.setMarginStart((((int) view.getX()) - (((RelativeLayout) this_apply.findViewById(i2)).getWidth() / 2)) + (view.getWidth() / 2));
                RelativeLayout relativeLayout = (RelativeLayout) this_apply.findViewById(i2);
                if (relativeLayout == null) {
                    return;
                }
                relativeLayout.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(21);
            ImageView imageView2 = (ImageView) this_apply.findViewById(R.id.ivArrow);
            kotlin.jvm.internal.s.e(imageView2);
            layoutParams2.addRule(3, imageView2.getId());
            if (layoutParams2.getMarginStart() <= us.pinguo.foundation.utils.n0.c(8)) {
                layoutParams2.setMarginStart(us.pinguo.foundation.utils.n0.c(8));
            }
            layoutParams2.setMarginEnd(us.pinguo.foundation.utils.n0.c(8));
            RelativeLayout relativeLayout2 = (RelativeLayout) this_apply.findViewById(i2);
            if (relativeLayout2 == null) {
                return;
            }
            relativeLayout2.setLayoutParams(layoutParams2);
            return;
        }
        int x2 = ((int) view.getX()) + (view.getWidth() / 2);
        int i3 = R.id.rlFrames;
        if (x2 + (((RelativeLayout) this_apply.findViewById(i3)).getWidth() / 2) <= us.pinguo.foundation.t.b.a.f().x - us.pinguo.foundation.utils.n0.c(8)) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            ImageView imageView3 = (ImageView) this_apply.findViewById(R.id.ivArrow);
            kotlin.jvm.internal.s.e(imageView3);
            layoutParams3.addRule(3, imageView3.getId());
            layoutParams3.setMarginStart((((int) view.getX()) - (((RelativeLayout) this_apply.findViewById(i3)).getWidth() / 2)) + (view.getWidth() / 2));
            RelativeLayout relativeLayout3 = (RelativeLayout) this_apply.findViewById(i3);
            if (relativeLayout3 == null) {
                return;
            }
            relativeLayout3.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(21);
        ImageView imageView4 = (ImageView) this_apply.findViewById(R.id.ivArrow);
        kotlin.jvm.internal.s.e(imageView4);
        layoutParams4.addRule(3, imageView4.getId());
        if (layoutParams4.getMarginStart() <= us.pinguo.foundation.utils.n0.c(8)) {
            layoutParams4.setMarginStart(us.pinguo.foundation.utils.n0.c(8));
        }
        layoutParams4.setMarginEnd(us.pinguo.foundation.utils.n0.c(8));
        RelativeLayout relativeLayout4 = (RelativeLayout) this_apply.findViewById(i3);
        if (relativeLayout4 == null) {
            return;
        }
        relativeLayout4.setLayoutParams(layoutParams4);
    }

    @Override // us.pinguo.common.g
    public boolean E(us.pinguo.common.d event) {
        kotlin.jvm.internal.s.h(event, "event");
        if ((this.a.getVisibility() == 0) && (event.c() == EventType.BACK_PRESS || event.c() == EventType.TOUCH_UP || event.c() == EventType.DOUBLE_CLICK || event.c() == EventType.FLING)) {
            b();
            return true;
        }
        return false;
    }

    @Override // us.pinguo.camera2020.view.t2.b
    public void a(CameraFrame frameRatio) {
        kotlin.jvm.internal.s.h(frameRatio, "frameRatio");
        this.b.a(frameRatio, false);
        b();
    }

    public final void b() {
        h();
    }

    public final void c() {
        if (this.a.getVisibility() != 4) {
            View view = this.a;
            view.setVisibility(4);
            VdsAgent.onSetViewVisibility(view, 4);
        }
    }

    public final void d() {
        Map<CameraFrame, Size> e2 = this.b.e();
        this.f9446d = e2 == null ? null : e2.keySet();
        ArrayList arrayList = new ArrayList();
        Set<? extends CameraFrame> set = this.f9446d;
        if (set != null) {
            for (CameraFrame cameraFrame : set) {
                arrayList.add(new us.pinguo.camera2020.view.s2.b(new us.pinguo.camera2020.view.s2.a(new ObservableBoolean(cameraFrame == this.b.d().getValue()), cameraFrame), this));
            }
        }
        this.c.setCells(arrayList);
        RecyclerView recyclerView = (RecyclerView) this.a.findViewById(R.id.rvFrames);
        if (recyclerView != null) {
            recyclerView.setAdapter(this.c);
        }
        this.c.notifyDataSetChanged();
    }

    public final boolean e() {
        return this.a.isShown();
    }

    public final void l(View view) {
        kotlin.jvm.internal.s.h(view, "view");
        j(view);
    }
}
