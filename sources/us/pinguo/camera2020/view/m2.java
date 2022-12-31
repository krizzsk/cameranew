package us.pinguo.camera2020.view;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Objects;
import us.pinguo.camera2020.R;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.common.EventType;
import us.pinguo.common.h;
import us.pinguo.ui.widget.AutofitTextView;
/* compiled from: CameraTopBarController.kt */
/* loaded from: classes3.dex */
public final class m2 implements View.OnClickListener, us.pinguo.common.h, us.pinguo.common.g {
    private final View a;
    private final boolean b;
    private final LifecycleOwner c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9439d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9440e;

    /* renamed from: f  reason: collision with root package name */
    private CameraFrame f9441f;

    /* renamed from: g  reason: collision with root package name */
    private int f9442g;

    /* renamed from: h  reason: collision with root package name */
    private final int f9443h;

    /* renamed from: i  reason: collision with root package name */
    private a f9444i;

    /* renamed from: j  reason: collision with root package name */
    private kotlin.jvm.b.l<? super View, kotlin.u> f9445j;

    /* compiled from: CameraTopBarController.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void F(int i2);

        void K();

        void L();

        void U();

        void f();

        void o();
    }

    public m2(View cameraTopBar, boolean z, LifecycleOwner lifecycleOwner) {
        kotlin.jvm.internal.s.h(cameraTopBar, "cameraTopBar");
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        this.a = cameraTopBar;
        this.b = z;
        this.c = lifecycleOwner;
        this.f9441f = CameraFrame.FRAME_4_3;
        this.f9443h = Color.parseColor("#FF000000");
        View.inflate(cameraTopBar.getContext(), R.layout.camera_top_bar_layout, null);
        ((AppCompatImageView) cameraTopBar.findViewById(R.id.btBack)).setOnClickListener(this);
        ((AppCompatImageView) cameraTopBar.findViewById(R.id.btMore)).setOnClickListener(this);
        ((AppCompatImageView) cameraTopBar.findViewById(R.id.btTimer)).setOnClickListener(this);
        ((AppCompatImageView) cameraTopBar.findViewById(R.id.btAdvancedSettings)).setOnClickListener(this);
        ((AppCompatImageView) cameraTopBar.findViewById(R.id.btFrameRatio)).setOnClickListener(this);
        ((AppCompatImageView) cameraTopBar.findViewById(R.id.btSwitchCamera)).setOnClickListener(this);
        us.pinguo.repository2020.m mVar = us.pinguo.repository2020.m.a;
        mVar.D().observe(lifecycleOwner, new Observer() { // from class: us.pinguo.camera2020.view.o0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                m2.a(m2.this, (Boolean) obj);
            }
        });
        Integer value = mVar.g().getValue();
        q(value == null ? 0 : value.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(m2 this$0, Boolean bool) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        AppCompatImageView appCompatImageView = (AppCompatImageView) this$0.a.findViewById(R.id.btAdvancedSettings);
        kotlin.jvm.internal.s.g(appCompatImageView, "cameraTopBar.btAdvancedSettings");
        int i2 = kotlin.jvm.internal.s.c(bool, Boolean.TRUE) ? 0 : 8;
        appCompatImageView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(appCompatImageView, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(m2 this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        View view = this$0.a;
        view.setVisibility(8);
        VdsAgent.onSetViewVisibility(view, 8);
    }

    private final void q(int i2) {
        this.f9442g = i2;
        if (i2 == 0) {
            ((AppCompatImageView) this.a.findViewById(R.id.btTimer)).setImageResource(this.f9440e ? R.drawable.ic_timer_off_dark : R.drawable.ic_timer_off_light);
        } else if (i2 == 3) {
            ((AppCompatImageView) this.a.findViewById(R.id.btTimer)).setImageResource(this.f9440e ? R.drawable.ic_timer_3s_dark : R.drawable.ic_timer_3s_light);
        } else if (i2 != 7) {
        } else {
            ((AppCompatImageView) this.a.findViewById(R.id.btTimer)).setImageResource(this.f9440e ? R.drawable.ic_timer_7s_dark : R.drawable.ic_timer_7s_light);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(m2 this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        View view = this$0.a;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(kotlin.jvm.b.l lVar, View view) {
        VdsAgent.lambdaOnClick(view);
        lVar.invoke(view);
    }

    @Override // us.pinguo.common.h
    public int D() {
        return h.a.f(this);
    }

    @Override // us.pinguo.common.g
    public boolean E(us.pinguo.common.d event) {
        kotlin.jvm.internal.s.h(event, "event");
        if ((this.a.getVisibility() == 0) || !(event.c() == EventType.TOUCH_UP || event.c() == EventType.DOUBLE_CLICK || event.c() == EventType.BACK_PRESS)) {
            return false;
        }
        r();
        return true;
    }

    @Override // us.pinguo.common.h
    public int G() {
        return h.a.h(this);
    }

    @Override // us.pinguo.common.h
    public void J(boolean z) {
        h.a.b(this, z);
    }

    @Override // us.pinguo.common.h
    public int O() {
        return h.a.i(this);
    }

    public final void b() {
        this.f9439d = false;
        r();
        View view = this.a;
        int i2 = R.id.btBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(i2);
        kotlin.jvm.internal.s.g(appCompatImageView, "cameraTopBar.btBack");
        appCompatImageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatImageView, 0);
        ((AppCompatImageView) this.a.findViewById(i2)).setImageResource(this.f9440e ? R.drawable.ic_close_dark : R.drawable.ic_close_light);
        View view2 = this.a;
        int i3 = R.id.btMore;
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) view2.findViewById(i3);
        kotlin.jvm.internal.s.g(appCompatImageView2, "cameraTopBar.btMore");
        appCompatImageView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatImageView2, 0);
        ((AppCompatImageView) this.a.findViewById(i3)).setImageResource(this.f9440e ? R.drawable.ic_more_dark : R.drawable.ic_more_light);
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) this.a.findViewById(R.id.btTimer);
        kotlin.jvm.internal.s.g(appCompatImageView3, "cameraTopBar.btTimer");
        appCompatImageView3.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatImageView3, 0);
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) this.a.findViewById(R.id.btAdvancedSettings);
        kotlin.jvm.internal.s.g(appCompatImageView4, "cameraTopBar.btAdvancedSettings");
        int i4 = kotlin.jvm.internal.s.c(us.pinguo.repository2020.m.a.D().getValue(), Boolean.TRUE) ? 0 : 8;
        appCompatImageView4.setVisibility(i4);
        VdsAgent.onSetViewVisibility(appCompatImageView4, i4);
        AppCompatImageView appCompatImageView5 = (AppCompatImageView) this.a.findViewById(R.id.btFrameRatio);
        kotlin.jvm.internal.s.g(appCompatImageView5, "cameraTopBar.btFrameRatio");
        appCompatImageView5.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatImageView5, 0);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.a.findViewById(R.id.editGroup);
        kotlin.jvm.internal.s.g(constraintLayout, "cameraTopBar.editGroup");
        constraintLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(constraintLayout, 8);
        View view3 = this.a;
        int i5 = R.id.btSwitchCamera;
        AppCompatImageView appCompatImageView6 = (AppCompatImageView) view3.findViewById(i5);
        kotlin.jvm.internal.s.g(appCompatImageView6, "cameraTopBar.btSwitchCamera");
        appCompatImageView6.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatImageView6, 0);
        ((AppCompatImageView) this.a.findViewById(i5)).setImageResource(this.f9440e ? R.drawable.ic_switch_face_dark : R.drawable.ic_switch_face_light);
        ((AppCompatImageView) this.a.findViewById(i5)).setOnClickListener(this);
    }

    public final void c(CameraFrame frameRatio) {
        kotlin.jvm.internal.s.h(frameRatio, "frameRatio");
        this.f9441f = frameRatio;
        us.pinguo.camera2020.view.s2.a aVar = new us.pinguo.camera2020.view.s2.a(new ObservableBoolean(false), this.f9441f);
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.a.findViewById(R.id.btFrameRatio);
        kotlin.jvm.internal.s.g(appCompatImageView, "cameraTopBar.btFrameRatio");
        us.pinguo.camera2020.f.b.b(appCompatImageView, aVar, this.f9440e);
    }

    public final View d() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.a.findViewById(R.id.btFrameRatio);
        kotlin.jvm.internal.s.g(appCompatImageView, "cameraTopBar.btFrameRatio");
        return appCompatImageView;
    }

    public final View e() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.a.findViewById(R.id.btMore);
        kotlin.jvm.internal.s.g(appCompatImageView, "cameraTopBar.btMore");
        return appCompatImageView;
    }

    public final void f() {
        if (this.a.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            this.a.animate().translationY(-(((ViewGroup.MarginLayoutParams) layoutParams2).height + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin)).setDuration(200L).withEndAction(new Runnable() { // from class: us.pinguo.camera2020.view.p0
                @Override // java.lang.Runnable
                public final void run() {
                    m2.g(m2.this);
                }
            }).start();
        }
    }

    @Override // us.pinguo.common.h
    public void h(boolean z) {
        h.a.d(this, z);
    }

    @Override // us.pinguo.common.h
    public void i(boolean z) {
        this.f9440e = z;
        if (this.f9439d) {
            ((AppCompatImageView) this.a.findViewById(R.id.btEdit)).setImageResource(z ? R.drawable.ic_edit_dark : R.drawable.ic_edit_light);
            View view = this.a;
            int i2 = R.id.editText;
            ((AutofitTextView) view.findViewById(i2)).setTextColor(z ? ContextCompat.getColor(((AutofitTextView) this.a.findViewById(i2)).getContext(), R.color.sticker_tab_indicator_color_dark) : ContextCompat.getColor(((AutofitTextView) this.a.findViewById(i2)).getContext(), R.color.white));
            if (z) {
                ((AutofitTextView) this.a.findViewById(i2)).setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                return;
            } else {
                ((AutofitTextView) this.a.findViewById(i2)).setShadowLayer(1.0f, 0.0f, 0.0f, this.f9443h);
                return;
            }
        }
        int i3 = this.f9442g;
        if (i3 == 0) {
            ((AppCompatImageView) this.a.findViewById(R.id.btTimer)).setImageResource(z ? R.drawable.ic_timer_off_dark : R.drawable.ic_timer_off_light);
        } else if (i3 == 3) {
            ((AppCompatImageView) this.a.findViewById(R.id.btTimer)).setImageResource(z ? R.drawable.ic_timer_3s_dark : R.drawable.ic_timer_3s_light);
        } else if (i3 == 7) {
            ((AppCompatImageView) this.a.findViewById(R.id.btTimer)).setImageResource(z ? R.drawable.ic_timer_7s_dark : R.drawable.ic_timer_7s_light);
        }
        us.pinguo.camera2020.view.s2.a aVar = new us.pinguo.camera2020.view.s2.a(new ObservableBoolean(false), this.f9441f);
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.a.findViewById(R.id.btFrameRatio);
        kotlin.jvm.internal.s.g(appCompatImageView, "cameraTopBar.btFrameRatio");
        us.pinguo.camera2020.f.b.b(appCompatImageView, aVar, this.f9440e);
        if (z) {
            ((AppCompatImageView) this.a.findViewById(R.id.btBack)).setImageResource(R.drawable.ic_close_dark);
            ((AppCompatImageView) this.a.findViewById(R.id.btSwitchCamera)).setImageResource(R.drawable.ic_switch_face_dark);
            ((AppCompatImageView) this.a.findViewById(R.id.btMore)).setImageResource(R.drawable.ic_more_dark);
            ((AppCompatImageView) this.a.findViewById(R.id.btAdvancedSettings)).setImageResource(R.drawable.ic_advanced_settings_dark);
            if (this.f9442g == 0) {
                ((AppCompatImageView) this.a.findViewById(R.id.btTimer)).setImageResource(R.drawable.ic_timer_off_dark);
                return;
            }
            return;
        }
        ((AppCompatImageView) this.a.findViewById(R.id.btBack)).setImageResource(R.drawable.ic_close_light);
        ((AppCompatImageView) this.a.findViewById(R.id.btSwitchCamera)).setImageResource(R.drawable.ic_switch_face_light);
        ((AppCompatImageView) this.a.findViewById(R.id.btMore)).setImageResource(R.drawable.ic_more_light);
        ((AppCompatImageView) this.a.findViewById(R.id.btAdvancedSettings)).setImageResource(R.drawable.ic_advanced_settings_light);
        if (this.f9442g == 0) {
            ((AppCompatImageView) this.a.findViewById(R.id.btTimer)).setImageResource(R.drawable.ic_timer_off_light);
        }
    }

    public final void n(a aVar) {
        this.f9444i = aVar;
    }

    public final void o(kotlin.jvm.b.l<? super View, kotlin.u> lVar) {
        this.f9445j = lVar;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        a aVar;
        VdsAgent.onClick(this, view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i2 = R.id.btBack;
        if (valueOf != null && valueOf.intValue() == i2) {
            a aVar2 = this.f9444i;
            if (aVar2 == null) {
                return;
            }
            aVar2.f();
            return;
        }
        int i3 = R.id.btMore;
        if (valueOf != null && valueOf.intValue() == i3) {
            a aVar3 = this.f9444i;
            if (aVar3 == null) {
                return;
            }
            aVar3.K();
            return;
        }
        int i4 = R.id.btFrameRatio;
        if (valueOf != null && valueOf.intValue() == i4) {
            a aVar4 = this.f9444i;
            if (aVar4 == null) {
                return;
            }
            aVar4.o();
            return;
        }
        int i5 = R.id.btSwitchCamera;
        if (valueOf != null && valueOf.intValue() == i5) {
            a aVar5 = this.f9444i;
            if (aVar5 == null) {
                return;
            }
            aVar5.U();
            return;
        }
        int i6 = R.id.btTimer;
        if (valueOf != null && valueOf.intValue() == i6) {
            int i7 = this.f9442g;
            int i8 = 0;
            if (i7 == 0) {
                i8 = 3;
            } else if (i7 == 3) {
                i8 = 7;
            }
            q(i8);
            a aVar6 = this.f9444i;
            if (aVar6 == null) {
                return;
            }
            aVar6.F(this.f9442g);
            return;
        }
        int i9 = R.id.btAdvancedSettings;
        if (valueOf == null || valueOf.intValue() != i9 || (aVar = this.f9444i) == null) {
            return;
        }
        aVar.L();
    }

    @Override // us.pinguo.common.h
    public void p(boolean z) {
        h.a.c(this, z);
    }

    public final void r() {
        if (this.a.getVisibility() == 0) {
            return;
        }
        this.a.animate().translationY(0.0f).setDuration(200L).withStartAction(new Runnable() { // from class: us.pinguo.camera2020.view.n0
            @Override // java.lang.Runnable
            public final void run() {
                m2.t(m2.this);
            }
        }).start();
    }

    @Override // us.pinguo.common.h
    public boolean s() {
        return true;
    }

    public final void u(boolean z) {
        this.f9439d = true;
        r();
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.a.findViewById(R.id.btBack);
        kotlin.jvm.internal.s.g(appCompatImageView, "cameraTopBar.btBack");
        appCompatImageView.setVisibility(4);
        VdsAgent.onSetViewVisibility(appCompatImageView, 4);
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.a.findViewById(R.id.btMore);
        kotlin.jvm.internal.s.g(appCompatImageView2, "cameraTopBar.btMore");
        appCompatImageView2.setVisibility(4);
        VdsAgent.onSetViewVisibility(appCompatImageView2, 4);
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) this.a.findViewById(R.id.btTimer);
        kotlin.jvm.internal.s.g(appCompatImageView3, "cameraTopBar.btTimer");
        appCompatImageView3.setVisibility(4);
        VdsAgent.onSetViewVisibility(appCompatImageView3, 4);
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) this.a.findViewById(R.id.btFrameRatio);
        kotlin.jvm.internal.s.g(appCompatImageView4, "cameraTopBar.btFrameRatio");
        appCompatImageView4.setVisibility(4);
        VdsAgent.onSetViewVisibility(appCompatImageView4, 4);
        AppCompatImageView appCompatImageView5 = (AppCompatImageView) this.a.findViewById(R.id.btAdvancedSettings);
        kotlin.jvm.internal.s.g(appCompatImageView5, "cameraTopBar.btAdvancedSettings");
        appCompatImageView5.setVisibility(4);
        VdsAgent.onSetViewVisibility(appCompatImageView5, 4);
        if (!z && !this.b) {
            AppCompatImageView appCompatImageView6 = (AppCompatImageView) this.a.findViewById(R.id.btSwitchCamera);
            kotlin.jvm.internal.s.g(appCompatImageView6, "cameraTopBar.btSwitchCamera");
            appCompatImageView6.setVisibility(8);
            VdsAgent.onSetViewVisibility(appCompatImageView6, 8);
            View view = this.a;
            int i2 = R.id.editGroup;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i2);
            kotlin.jvm.internal.s.g(constraintLayout, "cameraTopBar.editGroup");
            constraintLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(constraintLayout, 0);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.a.findViewById(i2);
            final kotlin.jvm.b.l<? super View, kotlin.u> lVar = this.f9445j;
            constraintLayout2.setOnClickListener(lVar == null ? null : new View.OnClickListener() { // from class: us.pinguo.camera2020.view.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m2.v(kotlin.jvm.b.l.this, view2);
                }
            });
            ((AppCompatImageView) this.a.findViewById(R.id.btEdit)).setImageResource(this.f9440e ? R.drawable.ic_edit_dark : R.drawable.ic_edit_light);
            View view2 = this.a;
            int i3 = R.id.editText;
            ((AutofitTextView) view2.findViewById(i3)).setTextColor(this.f9440e ? ContextCompat.getColor(((AutofitTextView) this.a.findViewById(i3)).getContext(), R.color.sticker_tab_indicator_color_dark) : ContextCompat.getColor(((AutofitTextView) this.a.findViewById(i3)).getContext(), R.color.white));
            if (this.f9440e) {
                ((AutofitTextView) this.a.findViewById(i3)).setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                return;
            } else {
                ((AutofitTextView) this.a.findViewById(i3)).setShadowLayer(1.0f, 0.0f, 0.0f, this.f9443h);
                return;
            }
        }
        AppCompatImageView appCompatImageView7 = (AppCompatImageView) this.a.findViewById(R.id.btSwitchCamera);
        kotlin.jvm.internal.s.g(appCompatImageView7, "cameraTopBar.btSwitchCamera");
        appCompatImageView7.setVisibility(4);
        VdsAgent.onSetViewVisibility(appCompatImageView7, 4);
    }

    @Override // us.pinguo.common.h
    public void w(int i2) {
        h.a.a(this, i2);
    }

    @Override // us.pinguo.common.h
    public int x() {
        return h.a.g(this);
    }
}
