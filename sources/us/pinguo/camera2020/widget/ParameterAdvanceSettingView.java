package us.pinguo.camera2020.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar;
import us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar2;
import us.pinguo.camera2020.widget.bubbleSeekbar.a;
import us.pinguo.camera2020.widget.g.a;
import us.pinguo.cameramanger.info.WhiteBalance;
import us.pinguo.common.EventType;
/* compiled from: ParameterAdvanceSettingView.kt */
/* loaded from: classes3.dex */
public final class ParameterAdvanceSettingView extends RelativeLayout implements BubbleSeekBar.g, us.pinguo.common.g {
    private static final us.pinguo.camera2020.widget.bubbleSeekbar.c m = new us.pinguo.camera2020.widget.bubbleSeekbar.c(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(16.0f), us.pinguo.camera2020.widget.bubbleSeekbar.b.a(16.0f));
    private static final us.pinguo.camera2020.widget.bubbleSeekbar.c n = new us.pinguo.camera2020.widget.bubbleSeekbar.c(0, 0);
    public Map<Integer, View> a;
    private ObjectAnimator b;
    private us.pinguo.camera2020.widget.g.a c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.camera2020.widget.g.a f9481d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.camera2020.widget.g.a f9482e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.camera2020.widget.g.a f9483f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.camera2020.widget.g.a f9484g;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.camera2020.widget.g.a f9485h;

    /* renamed from: i  reason: collision with root package name */
    private BubbleSeekBar f9486i;

    /* renamed from: j  reason: collision with root package name */
    private a f9487j;

    /* renamed from: k  reason: collision with root package name */
    private c f9488k;

    /* renamed from: l  reason: collision with root package name */
    private final int f9489l;

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public interface a {
        us.pinguo.camera2020.widget.g.a a();

        us.pinguo.camera2020.widget.g.a b();

        us.pinguo.camera2020.widget.g.a c();

        us.pinguo.camera2020.widget.g.a d();

        us.pinguo.camera2020.widget.g.a e();

        us.pinguo.camera2020.widget.g.a f();

        us.pinguo.camera2020.widget.g.a g();
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class b implements a.b {
        private us.pinguo.camera2020.widget.g.a a;
        private boolean b;
        private boolean c;

        public b(us.pinguo.camera2020.widget.g.a adapter) {
            s.h(adapter, "adapter");
            this.a = adapter;
            int b = adapter.b();
            int i2 = 0;
            while (i2 < b) {
                int i3 = i2 + 1;
                a.InterfaceC0368a a = adapter.a(i2);
                if (a.b() > 0) {
                    this.b = true;
                }
                if (a.getText() != null) {
                    String text = a.getText();
                    s.g(text, "scale.text");
                    if (text.length() > 0) {
                        this.c = true;
                    }
                }
                i2 = i3;
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.a.b
        public int a() {
            return -1;
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.a.b
        public us.pinguo.camera2020.widget.bubbleSeekbar.c b() {
            return this.b ? ParameterAdvanceSettingView.m : ParameterAdvanceSettingView.n;
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.a.b
        public int c() {
            if (this.c) {
                return us.pinguo.camera2020.widget.bubbleSeekbar.b.e(10.5f);
            }
            return 0;
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.a.b
        public a.b.C0367a d(int i2) {
            us.pinguo.camera2020.widget.g.a aVar = this.a;
            s.e(aVar);
            int b = aVar.a(i2).b();
            us.pinguo.camera2020.widget.g.a aVar2 = this.a;
            s.e(aVar2);
            return new a.b.C0367a(b, aVar2.a(i2).getText());
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public interface c {
        void B(int i2, int i3, int i4, boolean z);
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            s.h(animation, "animation");
            ParameterAdvanceSettingView parameterAdvanceSettingView = ParameterAdvanceSettingView.this;
            parameterAdvanceSettingView.setVisibility(4);
            VdsAgent.onSetViewVisibility(parameterAdvanceSettingView, 4);
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class e implements BubbleSeekBar.g {
        e() {
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void a(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(5, i2, (int) (view.v() + 1), false);
                ParameterAdvanceSettingView.this.D(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void b(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(5, i2, (int) (view.v() + 1), true);
                ParameterAdvanceSettingView.this.C(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void c(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class f implements BubbleSeekBar.g {
        final /* synthetic */ us.pinguo.camera2020.widget.g.a b;

        f(us.pinguo.camera2020.widget.g.a aVar) {
            this.b = aVar;
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void a(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(0, i2, this.b.b(), false);
                ParameterAdvanceSettingView.this.D(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void b(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(0, i2, this.b.b(), true);
                ParameterAdvanceSettingView.this.C(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void c(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class g implements BubbleSeekBar.g {
        final /* synthetic */ us.pinguo.camera2020.widget.g.a b;

        g(us.pinguo.camera2020.widget.g.a aVar) {
            this.b = aVar;
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void a(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(1, i2, this.b.b(), false);
                ParameterAdvanceSettingView.this.D(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void b(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(1, i2, this.b.b(), true);
                ParameterAdvanceSettingView.this.C(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void c(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class h implements BubbleSeekBar.g {
        final /* synthetic */ us.pinguo.camera2020.widget.g.a b;

        h(us.pinguo.camera2020.widget.g.a aVar) {
            this.b = aVar;
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void a(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (i2 != 0) {
                ParameterAdvanceSettingView.this.I(false, false);
            } else {
                ParameterAdvanceSettingView.this.I(true, false);
            }
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(3, i2, this.b.b(), false);
                ParameterAdvanceSettingView.this.D(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void b(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(3, i2, this.b.b(), true);
                ParameterAdvanceSettingView.this.C(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void c(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class i implements BubbleSeekBar.g {
        i() {
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void a(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                us.pinguo.camera2020.widget.g.a c = ParameterAdvanceSettingView.this.f9487j.c();
                s.e(c);
                int b = i2 + (c.b() / 2);
                BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) ParameterAdvanceSettingView.this.d(R.id.camera_adv_exposure);
                s.e(bubbleSeekBar2);
                cVar.B(2, b, bubbleSeekBar2.s().h() + 1, false);
                ParameterAdvanceSettingView.this.D(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void b(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                us.pinguo.camera2020.widget.g.a c = ParameterAdvanceSettingView.this.f9487j.c();
                s.e(c);
                int b = i2 + (c.b() / 2);
                BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) ParameterAdvanceSettingView.this.d(R.id.camera_adv_exposure);
                s.e(bubbleSeekBar2);
                cVar.B(2, b, bubbleSeekBar2.s().h() + 1, true);
                ParameterAdvanceSettingView.this.C(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void c(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class j implements BubbleSeekBar.g {
        final /* synthetic */ us.pinguo.camera2020.widget.g.a b;

        j(us.pinguo.camera2020.widget.g.a aVar) {
            this.b = aVar;
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void a(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (i2 != 0) {
                ParameterAdvanceSettingView.this.H(false, false);
            } else {
                ParameterAdvanceSettingView.this.H(true, false);
            }
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(6, i2, this.b.b(), false);
                ParameterAdvanceSettingView.this.D(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void b(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(6, i2, this.b.b(), true);
                ParameterAdvanceSettingView.this.C(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void c(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class k implements BubbleSeekBar.g {
        final /* synthetic */ us.pinguo.camera2020.widget.g.a b;

        k(us.pinguo.camera2020.widget.g.a aVar) {
            this.b = aVar;
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void a(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(4, i2, this.b.b(), false);
                ParameterAdvanceSettingView.this.D(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void b(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
            if (ParameterAdvanceSettingView.this.f9488k != null) {
                c cVar = ParameterAdvanceSettingView.this.f9488k;
                s.e(cVar);
                cVar.B(4, i2, this.b.b(), true);
                ParameterAdvanceSettingView.this.C(view);
            }
        }

        @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
        public void c(BubbleSeekBar view, int i2, float f2) {
            s.h(view, "view");
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class l implements us.pinguo.camera2020.widget.g.a {
        final /* synthetic */ us.pinguo.camera2020.h.a a;
        final /* synthetic */ ParameterAdvanceSettingView b;

        /* compiled from: ParameterAdvanceSettingView.kt */
        /* loaded from: classes3.dex */
        public static final class a implements a.InterfaceC0368a {
            final /* synthetic */ us.pinguo.camera2020.h.a a;
            final /* synthetic */ int b;

            a(us.pinguo.camera2020.h.a aVar, int i2) {
                this.a = aVar;
                this.b = i2;
            }

            @Override // us.pinguo.camera2020.widget.g.a.InterfaceC0368a
            public int b() {
                return this.a.p()[this.b];
            }

            @Override // us.pinguo.camera2020.widget.g.a.InterfaceC0368a
            public String getText() {
                return this.a.c()[this.b].toString();
            }
        }

        l(us.pinguo.camera2020.h.a aVar, ParameterAdvanceSettingView parameterAdvanceSettingView) {
            this.a = aVar;
            this.b = parameterAdvanceSettingView;
        }

        @Override // us.pinguo.camera2020.widget.g.a
        public a.InterfaceC0368a a(int i2) {
            return new a(this.a, i2);
        }

        @Override // us.pinguo.camera2020.widget.g.a
        public int b() {
            int length = this.a.c().length;
            return length <= this.b.f9489l ? length : this.b.f9489l;
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class m implements us.pinguo.camera2020.widget.g.a {
        final /* synthetic */ us.pinguo.camera2020.h.a a;

        /* compiled from: ParameterAdvanceSettingView.kt */
        /* loaded from: classes3.dex */
        public static final class a implements a.InterfaceC0368a {
            final /* synthetic */ us.pinguo.camera2020.h.a a;
            final /* synthetic */ int b;

            a(us.pinguo.camera2020.h.a aVar, int i2) {
                this.a = aVar;
                this.b = i2;
            }

            @Override // us.pinguo.camera2020.widget.g.a.InterfaceC0368a
            public int b() {
                return this.a.p()[this.b];
            }

            @Override // us.pinguo.camera2020.widget.g.a.InterfaceC0368a
            public String getText() {
                return null;
            }
        }

        m(us.pinguo.camera2020.h.a aVar) {
            this.a = aVar;
        }

        @Override // us.pinguo.camera2020.widget.g.a
        public a.InterfaceC0368a a(int i2) {
            return new a(this.a, i2);
        }

        @Override // us.pinguo.camera2020.widget.g.a
        public int b() {
            return this.a.c().length;
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class n implements us.pinguo.camera2020.widget.g.a {
        final /* synthetic */ us.pinguo.foundation.h a;

        /* compiled from: ParameterAdvanceSettingView.kt */
        /* loaded from: classes3.dex */
        public static final class a implements a.InterfaceC0368a {
            final /* synthetic */ us.pinguo.foundation.h a;
            final /* synthetic */ int b;

            a(us.pinguo.foundation.h hVar, int i2) {
                this.a = hVar;
                this.b = i2;
            }

            @Override // us.pinguo.camera2020.widget.g.a.InterfaceC0368a
            public int b() {
                return 0;
            }

            @Override // us.pinguo.camera2020.widget.g.a.InterfaceC0368a
            public String getText() {
                return this.a.c()[this.b].toString();
            }
        }

        n(us.pinguo.foundation.h hVar) {
            this.a = hVar;
        }

        @Override // us.pinguo.camera2020.widget.g.a
        public a.InterfaceC0368a a(int i2) {
            return new a(this.a, i2);
        }

        @Override // us.pinguo.camera2020.widget.g.a
        public int b() {
            return this.a.c().length;
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class o implements a {
        o() {
        }

        @Override // us.pinguo.camera2020.widget.ParameterAdvanceSettingView.a
        public us.pinguo.camera2020.widget.g.a a() {
            return ParameterAdvanceSettingView.this.f9481d;
        }

        @Override // us.pinguo.camera2020.widget.ParameterAdvanceSettingView.a
        public us.pinguo.camera2020.widget.g.a b() {
            return ParameterAdvanceSettingView.this.f9485h;
        }

        @Override // us.pinguo.camera2020.widget.ParameterAdvanceSettingView.a
        public us.pinguo.camera2020.widget.g.a c() {
            return ParameterAdvanceSettingView.this.f9483f;
        }

        @Override // us.pinguo.camera2020.widget.ParameterAdvanceSettingView.a
        public us.pinguo.camera2020.widget.g.a d() {
            return ParameterAdvanceSettingView.this.f9482e;
        }

        @Override // us.pinguo.camera2020.widget.ParameterAdvanceSettingView.a
        public us.pinguo.camera2020.widget.g.a e() {
            return null;
        }

        @Override // us.pinguo.camera2020.widget.ParameterAdvanceSettingView.a
        public us.pinguo.camera2020.widget.g.a f() {
            return ParameterAdvanceSettingView.this.f9484g;
        }

        @Override // us.pinguo.camera2020.widget.ParameterAdvanceSettingView.a
        public us.pinguo.camera2020.widget.g.a g() {
            return ParameterAdvanceSettingView.this.c;
        }
    }

    /* compiled from: ParameterAdvanceSettingView.kt */
    /* loaded from: classes3.dex */
    public static final class p extends AnimatorListenerAdapter {
        p() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            s.h(animation, "animation");
            BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) ParameterAdvanceSettingView.this.d(R.id.contrastRatio);
            s.e(bubbleSeekBar2);
            bubbleSeekBar2.l();
            BubbleSeekBar2 bubbleSeekBar22 = (BubbleSeekBar2) ParameterAdvanceSettingView.this.d(R.id.saturability);
            s.e(bubbleSeekBar22);
            bubbleSeekBar22.l();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ParameterAdvanceSettingView.this.setAlpha(1.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParameterAdvanceSettingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        this.f9487j = new o();
        this.f9489l = 7;
        y(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(BubbleSeekBar bubbleSeekBar) {
        BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) d(R.id.contrastRatio);
        s.e(bubbleSeekBar2);
        s(bubbleSeekBar2);
        BubbleSeekBar2 bubbleSeekBar22 = (BubbleSeekBar2) d(R.id.saturability);
        s.e(bubbleSeekBar22);
        s(bubbleSeekBar22);
        BubbleSeekBar2 bubbleSeekBar23 = (BubbleSeekBar2) d(R.id.camera_adv_exposure);
        s.e(bubbleSeekBar23);
        s(bubbleSeekBar23);
        BubbleSeekBar2 bubbleSeekBar24 = (BubbleSeekBar2) d(R.id.camera_adv_iso);
        s.e(bubbleSeekBar24);
        s(bubbleSeekBar24);
        BubbleSeekBar2 bubbleSeekBar25 = (BubbleSeekBar2) d(R.id.camera_adv_sharpness);
        s.e(bubbleSeekBar25);
        s(bubbleSeekBar25);
        BubbleSeekBar2 bubbleSeekBar26 = (BubbleSeekBar2) d(R.id.camera_adv_white_balance);
        s.e(bubbleSeekBar26);
        s(bubbleSeekBar26);
        BubbleSeekBar2 bubbleSeekBar27 = (BubbleSeekBar2) d(R.id.camera_adv_focus_mode);
        s.e(bubbleSeekBar27);
        s(bubbleSeekBar27);
        TextView textView = (TextView) d(R.id.advanceText);
        s.e(textView);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        LinearLayout linearLayout = (LinearLayout) d(R.id.camera_adv_tip_layout);
        s.e(linearLayout);
        linearLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(linearLayout, 4);
        this.f9486i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(BubbleSeekBar bubbleSeekBar) {
        if (bubbleSeekBar == this.f9486i) {
            return;
        }
        r((BubbleSeekBar2) d(R.id.contrastRatio), bubbleSeekBar);
        r((BubbleSeekBar2) d(R.id.saturability), bubbleSeekBar);
        r((BubbleSeekBar2) d(R.id.camera_adv_exposure), bubbleSeekBar);
        r((BubbleSeekBar2) d(R.id.camera_adv_iso), bubbleSeekBar);
        r((BubbleSeekBar2) d(R.id.camera_adv_sharpness), bubbleSeekBar);
        r((BubbleSeekBar2) d(R.id.camera_adv_white_balance), bubbleSeekBar);
        r((BubbleSeekBar2) d(R.id.camera_adv_focus_mode), bubbleSeekBar);
        int i2 = R.id.camera_adv_tip_layout;
        LinearLayout linearLayout = (LinearLayout) d(i2);
        s.e(linearLayout);
        linearLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(linearLayout, 0);
        TextView textView = (TextView) d(R.id.advanceText);
        s.e(textView);
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
        this.f9486i = bubbleSeekBar;
        int top = bubbleSeekBar.getTop();
        LinearLayout linearLayout2 = (LinearLayout) d(R.id.arc_container);
        s.e(linearLayout2);
        int top2 = top + linearLayout2.getTop();
        LinearLayout linearLayout3 = (LinearLayout) d(i2);
        s.e(linearLayout3);
        int measuredHeight = top2 - linearLayout3.getMeasuredHeight();
        LinearLayout linearLayout4 = (LinearLayout) d(i2);
        s.e(linearLayout4);
        ViewGroup.LayoutParams layoutParams = linearLayout4.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = measuredHeight;
        LinearLayout linearLayout5 = (LinearLayout) d(i2);
        s.e(linearLayout5);
        linearLayout5.setLayoutParams(layoutParams2);
    }

    private final ObjectAnimator F(View view, float f2, float f3, float f4) {
        long abs;
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "y", f2, f3);
        float abs2 = Math.abs(f3 - f2);
        float measuredHeight = abs2 / getMeasuredHeight();
        if (f4 == 0.0f) {
            abs = ((float) IjkMediaCodecInfo.RANK_SECURE) * measuredHeight;
            if (abs < 200) {
                abs = 200;
            }
            anim.setInterpolator(new AccelerateInterpolator());
        } else {
            abs = Math.abs(abs2 / (f4 / 1000));
            if (abs > 300) {
                abs = 300;
            } else if (abs < 150) {
                abs = 150;
            }
            anim.setInterpolator(new DecelerateInterpolator());
        }
        anim.setDuration(abs);
        s.g(anim, "anim");
        return anim;
    }

    private final void r(BubbleSeekBar bubbleSeekBar, BubbleSeekBar bubbleSeekBar2) {
        if (bubbleSeekBar != bubbleSeekBar2) {
            s.e(bubbleSeekBar);
            Object tag = bubbleSeekBar.getTag(R.id.can_show);
            Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) tag).booleanValue()) {
                bubbleSeekBar.setVisibility(4);
                VdsAgent.onSetViewVisibility(bubbleSeekBar, 4);
            }
        }
    }

    private final void s(BubbleSeekBar bubbleSeekBar) {
        Object tag = bubbleSeekBar.getTag(R.id.can_show);
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) tag).booleanValue()) {
            bubbleSeekBar.setVisibility(0);
            VdsAgent.onSetViewVisibility(bubbleSeekBar, 0);
        }
    }

    private final void t(BubbleSeekBar bubbleSeekBar, boolean z) {
        int i2 = z ? 0 : 8;
        bubbleSeekBar.setVisibility(i2);
        VdsAgent.onSetViewVisibility(bubbleSeekBar, i2);
        bubbleSeekBar.setTag(R.id.can_show, Boolean.valueOf(z));
    }

    private final a.C0366a u(@DrawableRes int i2) {
        return new a.C0366a(i2, new us.pinguo.camera2020.widget.bubbleSeekbar.c(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(24.0f), us.pinguo.camera2020.widget.bubbleSeekbar.b.a(24.0f)), null, 0, 0, us.pinguo.camera2020.widget.bubbleSeekbar.b.a(15.0f));
    }

    private final void y(Context context) {
        LayoutInflater.from(context).inflate(R.layout.camera_advanced_settings, (ViewGroup) this, true);
        int i2 = R.id.contrastRatio;
        BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) d(i2);
        s.e(bubbleSeekBar2);
        bubbleSeekBar2.setOnProgressListener(this);
        int i3 = R.id.saturability;
        BubbleSeekBar2 bubbleSeekBar22 = (BubbleSeekBar2) d(i3);
        s.e(bubbleSeekBar22);
        bubbleSeekBar22.setOnProgressListener(this);
        BubbleSeekBar2 bubbleSeekBar23 = (BubbleSeekBar2) d(i2);
        s.e(bubbleSeekBar23);
        us.pinguo.camera2020.widget.bubbleSeekbar.a s = bubbleSeekBar23.s();
        s.o(-100.0f);
        s.n(100.0f);
        s.t(2);
        s.w();
        s.f(u(R.drawable.ic_camera_advance_contras));
        s.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
        s.r(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
        Resources resources = getResources();
        int i4 = R.color.color_camera_theme_80_light;
        s.E(resources.getColor(i4));
        s.D();
        Resources resources2 = getResources();
        int i5 = R.color.color_camera_theme_light;
        s.q(resources2.getColor(i5));
        s.A(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(9.0f));
        s.u(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
        s.y(false);
        s.p(0.0f);
        s.e();
        BubbleSeekBar2 bubbleSeekBar24 = (BubbleSeekBar2) d(i3);
        s.e(bubbleSeekBar24);
        us.pinguo.camera2020.widget.bubbleSeekbar.a s2 = bubbleSeekBar24.s();
        s2.o(-100.0f);
        s2.n(100.0f);
        s2.t(2);
        s2.w();
        s2.D();
        s2.f(u(R.drawable.ic_camera_advance_saturation));
        s2.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
        s2.r(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
        s2.E(getResources().getColor(i4));
        s2.q(getResources().getColor(i5));
        s2.A(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(9.0f));
        s2.u(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
        s2.y(false);
        s2.p(0.0f);
        s2.e();
        LinearLayout linearLayout = (LinearLayout) d(R.id.arc_container);
        s.e(linearLayout);
        linearLayout.setOnTouchListener(us.pinguo.camera2020.widget.c.a);
        BubbleSeekBar2 bubbleSeekBar25 = (BubbleSeekBar2) d(i2);
        s.e(bubbleSeekBar25);
        t(bubbleSeekBar25, true);
        BubbleSeekBar2 bubbleSeekBar26 = (BubbleSeekBar2) d(i3);
        s.e(bubbleSeekBar26);
        t(bubbleSeekBar26, true);
        BubbleSeekBar2 bubbleSeekBar27 = (BubbleSeekBar2) d(R.id.camera_adv_exposure);
        s.e(bubbleSeekBar27);
        t(bubbleSeekBar27, true);
        BubbleSeekBar2 bubbleSeekBar28 = (BubbleSeekBar2) d(R.id.camera_adv_iso);
        s.e(bubbleSeekBar28);
        t(bubbleSeekBar28, true);
        BubbleSeekBar2 bubbleSeekBar29 = (BubbleSeekBar2) d(R.id.camera_adv_sharpness);
        s.e(bubbleSeekBar29);
        t(bubbleSeekBar29, true);
        BubbleSeekBar2 bubbleSeekBar210 = (BubbleSeekBar2) d(R.id.camera_adv_white_balance);
        s.e(bubbleSeekBar210);
        t(bubbleSeekBar210, true);
        BubbleSeekBar2 bubbleSeekBar211 = (BubbleSeekBar2) d(R.id.camera_adv_focus_mode);
        s.e(bubbleSeekBar211);
        t(bubbleSeekBar211, true);
        TextView textView = (TextView) d(R.id.advanceText);
        s.e(textView);
        x xVar = x.a;
        String format = String.format("- %s -", Arrays.copyOf(new Object[]{getResources().getString(R.string.preview_setting_adjust)}, 1));
        s.g(format, "format(format, *args)");
        textView.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(View view, MotionEvent motionEvent) {
        return true;
    }

    public final void A(CameraViewModel cameraViewModel) {
        int v;
        int v2;
        int v3;
        s.h(cameraViewModel, "cameraViewModel");
        List<WhiteBalance> supportedWhiteBalance = cameraViewModel.getSupportedWhiteBalance();
        us.pinguo.camera2020.h.a aVar = (us.pinguo.camera2020.h.a) us.pinguo.camera2020.h.b.b().a("key_camera_whitebalance");
        s.e(aVar);
        us.pinguo.camera2020.h.a aVar2 = new us.pinguo.camera2020.h.a(aVar.g(), aVar.h());
        boolean z = false;
        if (!(supportedWhiteBalance == null || supportedWhiteBalance.isEmpty())) {
            int size = supportedWhiteBalance.size();
            Object[] objArr = new Object[size];
            for (int i2 = 0; i2 < size; i2++) {
                Object[] c2 = aVar.c();
                String[] f2 = aVar.f();
                s.g(f2, "wbPrefConfit.entryValues");
                v3 = kotlin.collections.n.v(f2, supportedWhiteBalance.get(i2).name());
                objArr[i2] = c2[v3];
            }
            aVar2.l(objArr);
            int size2 = supportedWhiteBalance.size();
            String[] strArr = new String[size2];
            for (int i3 = 0; i3 < size2; i3++) {
                String[] f3 = aVar.f();
                String[] f4 = aVar.f();
                s.g(f4, "wbPrefConfit.entryValues");
                v2 = kotlin.collections.n.v(f4, supportedWhiteBalance.get(i3).name());
                strArr[i3] = f3[v2];
            }
            aVar2.m(strArr);
            int size3 = supportedWhiteBalance.size();
            int[] iArr = new int[size3];
            for (int i4 = 0; i4 < size3; i4++) {
                int[] p2 = aVar.p();
                String[] f5 = aVar.f();
                s.g(f5, "wbPrefConfit.entryValues");
                v = kotlin.collections.n.v(f5, supportedWhiteBalance.get(i4).name());
                iArr[i4] = p2[v];
            }
            aVar2.q(iArr);
        }
        if (!((supportedWhiteBalance == null || supportedWhiteBalance.isEmpty()) ? true : true)) {
            this.c = new l(aVar2, this);
        } else {
            this.c = null;
        }
        if (cameraViewModel.isFocusOrMeteringSupport()) {
            us.pinguo.camera2020.h.a aVar3 = (us.pinguo.camera2020.h.a) us.pinguo.camera2020.h.b.b().a("key_camera_focusmode");
            if (aVar3 == null) {
                this.f9481d = null;
            } else {
                this.f9481d = new m(aVar3);
            }
        } else {
            this.f9481d = null;
        }
        this.f9482e = null;
        if (cameraViewModel.isExposureSupport()) {
            us.pinguo.foundation.h a2 = us.pinguo.camera2020.h.b.b().a("key_camera_exposure");
            if (a2 == null) {
                this.f9483f = null;
            } else {
                this.f9483f = new n(a2);
            }
        } else {
            this.f9483f = null;
        }
        this.f9484g = null;
        this.f9485h = null;
    }

    @Override // us.pinguo.common.g
    public boolean E(us.pinguo.common.d event) {
        s.h(event, "event");
        if ((getVisibility() == 0) && (event.c() == EventType.DOUBLE_CLICK || event.c() == EventType.TOUCH_UP || event.c() == EventType.BACK_PRESS)) {
            v(0.0f);
            return true;
        }
        return false;
    }

    public final void G(int i2, float f2) {
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            objectAnimator.cancel();
        }
        ObjectAnimator F = F(this, getY(), 0.0f, f2);
        F.addListener(new p());
        this.b = F;
        F.start();
    }

    public final void H(boolean z, boolean z2) {
        if (this.f9487j.d() == null) {
            return;
        }
        if (z) {
            int i2 = R.id.camera_adv_iso;
            BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) d(i2);
            s.e(bubbleSeekBar2);
            if (bubbleSeekBar2.x() != 0) {
                BubbleSeekBar2 bubbleSeekBar22 = (BubbleSeekBar2) d(i2);
                s.e(bubbleSeekBar22);
                bubbleSeekBar22.setProgress(0);
                c cVar = this.f9488k;
                if (cVar != null) {
                    s.e(cVar);
                    us.pinguo.camera2020.widget.g.a d2 = this.f9487j.d();
                    s.e(d2);
                    cVar.B(3, 0, d2.b(), z2);
                    return;
                }
                return;
            }
        }
        if (z) {
            return;
        }
        int i3 = R.id.camera_adv_iso;
        BubbleSeekBar2 bubbleSeekBar23 = (BubbleSeekBar2) d(i3);
        s.e(bubbleSeekBar23);
        if (bubbleSeekBar23.v() == 0.0f) {
            BubbleSeekBar2 bubbleSeekBar24 = (BubbleSeekBar2) d(i3);
            s.e(bubbleSeekBar24);
            int v = (int) (bubbleSeekBar24.v() / 2);
            BubbleSeekBar2 bubbleSeekBar25 = (BubbleSeekBar2) d(i3);
            s.e(bubbleSeekBar25);
            bubbleSeekBar25.setProgress(v);
            c cVar2 = this.f9488k;
            if (cVar2 != null) {
                s.e(cVar2);
                BubbleSeekBar2 bubbleSeekBar26 = (BubbleSeekBar2) d(i3);
                s.e(bubbleSeekBar26);
                cVar2.B(3, v, (int) bubbleSeekBar26.v(), z2);
            }
        }
    }

    public final void I(boolean z, boolean z2) {
        if (this.f9487j.b() == null) {
            return;
        }
        if (z) {
            int i2 = R.id.camera_adv_sharpness;
            BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) d(i2);
            s.e(bubbleSeekBar2);
            if (bubbleSeekBar2.x() != 0) {
                BubbleSeekBar2 bubbleSeekBar22 = (BubbleSeekBar2) d(i2);
                s.e(bubbleSeekBar22);
                bubbleSeekBar22.setProgress(0);
                c cVar = this.f9488k;
                if (cVar != null) {
                    s.e(cVar);
                    BubbleSeekBar2 bubbleSeekBar23 = (BubbleSeekBar2) d(i2);
                    s.e(bubbleSeekBar23);
                    cVar.B(6, 0, bubbleSeekBar23.s().h() + 1, false);
                    return;
                }
                return;
            }
        }
        if (z) {
            return;
        }
        int i3 = R.id.camera_adv_sharpness;
        BubbleSeekBar2 bubbleSeekBar24 = (BubbleSeekBar2) d(i3);
        s.e(bubbleSeekBar24);
        if (bubbleSeekBar24.x() == 0) {
            BubbleSeekBar2 bubbleSeekBar25 = (BubbleSeekBar2) d(i3);
            s.e(bubbleSeekBar25);
            int v = (int) (bubbleSeekBar25.v() / 2);
            BubbleSeekBar2 bubbleSeekBar26 = (BubbleSeekBar2) d(i3);
            s.e(bubbleSeekBar26);
            bubbleSeekBar26.setProgress(v);
            c cVar2 = this.f9488k;
            if (cVar2 != null) {
                s.e(cVar2);
                BubbleSeekBar2 bubbleSeekBar27 = (BubbleSeekBar2) d(i3);
                s.e(bubbleSeekBar27);
                cVar2.B(6, v, bubbleSeekBar27.s().h() + 1, false);
            }
        }
    }

    public final void J(String title, String value) {
        s.h(title, "title");
        s.h(value, "value");
        TextView textView = (TextView) d(R.id.camera_adv_tips_1);
        s.e(textView);
        textView.setText(title);
        TextView textView2 = (TextView) d(R.id.camera_adv_tips_2);
        s.e(textView2);
        textView2.setText(value);
    }

    @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
    public void a(BubbleSeekBar view, int i2, float f2) {
        s.h(view, "view");
        if (this.f9488k == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.contrastRatio) {
            c cVar = this.f9488k;
            s.e(cVar);
            cVar.B(7, i2, 0, false);
        } else if (id == R.id.saturability) {
            c cVar2 = this.f9488k;
            s.e(cVar2);
            cVar2.B(8, i2, 0, false);
        }
        D(view);
    }

    @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
    public void b(BubbleSeekBar view, int i2, float f2) {
        s.h(view, "view");
        if (this.f9488k == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.contrastRatio) {
            c cVar = this.f9488k;
            s.e(cVar);
            cVar.B(7, i2, 0, true);
        } else if (id == R.id.saturability) {
            c cVar2 = this.f9488k;
            s.e(cVar2);
            cVar2.B(8, i2, 0, true);
        }
        C(view);
    }

    @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar.g
    public void c(BubbleSeekBar view, int i2, float f2) {
        s.h(view, "view");
    }

    public View d(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void setExposureValue(float f2) {
        int i2 = R.id.camera_adv_exposure;
        if (((BubbleSeekBar2) d(i2)) == null || this.f9487j.c() == null) {
            return;
        }
        BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) d(i2);
        s.e(bubbleSeekBar2);
        bubbleSeekBar2.setProgress(f2);
    }

    public final void setFocusValue(float f2) {
        int i2 = R.id.camera_adv_focus_mode;
        if (((BubbleSeekBar2) d(i2)) != null) {
            BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) d(i2);
            s.e(bubbleSeekBar2);
            if (bubbleSeekBar2.s().h() > 0) {
                BubbleSeekBar2 bubbleSeekBar22 = (BubbleSeekBar2) d(i2);
                s.e(bubbleSeekBar22);
                BubbleSeekBar2 bubbleSeekBar23 = (BubbleSeekBar2) d(i2);
                s.e(bubbleSeekBar23);
                bubbleSeekBar23.setProgress((int) ((bubbleSeekBar22.s().h() + 1) * f2));
            }
        }
    }

    public final void setISO(float f2) {
        if (this.f9487j.d() != null) {
            us.pinguo.camera2020.widget.g.a d2 = this.f9487j.d();
            s.e(d2);
            if (d2.b() > 0) {
                us.pinguo.camera2020.widget.g.a d3 = this.f9487j.d();
                s.e(d3);
                BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) d(R.id.camera_adv_iso);
                s.e(bubbleSeekBar2);
                bubbleSeekBar2.setProgress(((int) ((d3.b() - 2) * f2)) + 1);
            }
        }
    }

    public final void setMCurAnimator$camera2020_release(ObjectAnimator objectAnimator) {
        this.b = objectAnimator;
    }

    public final void setMMaxScrollHeight$camera2020_release(float f2) {
    }

    public final void setMOriginContainerY$camera2020_release(float f2) {
    }

    public final void setMOriginSectorY$camera2020_release(float f2) {
    }

    public final void setOnParamScaleChangedListener(c listener) {
        s.h(listener, "listener");
        this.f9488k = listener;
    }

    public final void v(float f2) {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            objectAnimator.cancel();
        }
        ObjectAnimator F = F(this, getY(), getMeasuredHeight() - getY(), f2);
        F.addListener(new d());
        this.b = F;
        F.start();
    }

    public final void w() {
        setVisibility(8);
        VdsAgent.onSetViewVisibility(this, 8);
    }

    public final void x() {
        a aVar = this.f9487j;
        if (aVar.f() != null) {
            us.pinguo.camera2020.widget.g.a f2 = aVar.f();
            int i2 = R.id.camera_adv_focus_mode;
            BubbleSeekBar2 bubbleSeekBar2 = (BubbleSeekBar2) d(i2);
            s.e(bubbleSeekBar2);
            us.pinguo.camera2020.widget.bubbleSeekbar.a s = bubbleSeekBar2.s();
            s.p(0.0f);
            s.f(u(R.drawable.ic_camera_thumb_focus));
            s.e(f2);
            s.t(f2.b() - 1);
            s.w();
            s.a();
            s.o(0.0f);
            s.n(f2.b() - 1);
            s.D();
            s.v();
            s.x();
            s.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s.r(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s.E(getResources().getColor(R.color.color_camera_theme_80_light));
            s.q(getResources().getColor(R.color.color_camera_theme_light));
            s.A(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(9.0f));
            s.u(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s.s(new b(f2));
            s.e();
            BubbleSeekBar2 bubbleSeekBar22 = (BubbleSeekBar2) d(i2);
            s.e(bubbleSeekBar22);
            bubbleSeekBar22.setOnProgressListener(new e());
            BubbleSeekBar2 bubbleSeekBar23 = (BubbleSeekBar2) d(i2);
            s.e(bubbleSeekBar23);
            t(bubbleSeekBar23, true);
        } else if (aVar.a() != null) {
            us.pinguo.camera2020.widget.g.a a2 = aVar.a();
            int i3 = R.id.camera_adv_focus_mode;
            BubbleSeekBar2 bubbleSeekBar24 = (BubbleSeekBar2) d(i3);
            s.e(bubbleSeekBar24);
            us.pinguo.camera2020.widget.bubbleSeekbar.a s2 = bubbleSeekBar24.s();
            s2.f(u(R.drawable.ic_camera_thumb_focus));
            s.e(a2);
            s2.t(a2.b() - 1);
            s2.w();
            s2.a();
            s2.o(0.0f);
            s2.n(a2.b() - 1);
            s2.D();
            s2.p(0.0f);
            s2.x();
            s2.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s2.r(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s2.E(getResources().getColor(R.color.color_camera_theme_80_light));
            s2.q(getResources().getColor(R.color.color_camera_theme_light));
            s2.A(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(9.0f));
            s2.u(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s2.s(new b(a2));
            s2.v();
            s2.e();
            BubbleSeekBar2 bubbleSeekBar25 = (BubbleSeekBar2) d(i3);
            s.e(bubbleSeekBar25);
            bubbleSeekBar25.setOnProgressListener(new f(a2));
            BubbleSeekBar2 bubbleSeekBar26 = (BubbleSeekBar2) d(i3);
            s.e(bubbleSeekBar26);
            t(bubbleSeekBar26, true);
        } else {
            BubbleSeekBar2 bubbleSeekBar27 = (BubbleSeekBar2) d(R.id.camera_adv_focus_mode);
            s.e(bubbleSeekBar27);
            t(bubbleSeekBar27, false);
        }
        if (aVar.g() != null) {
            us.pinguo.camera2020.widget.g.a g2 = aVar.g();
            int i4 = R.id.camera_adv_white_balance;
            BubbleSeekBar2 bubbleSeekBar28 = (BubbleSeekBar2) d(i4);
            s.e(bubbleSeekBar28);
            us.pinguo.camera2020.widget.bubbleSeekbar.a s3 = bubbleSeekBar28.s();
            s3.f(u(R.drawable.ic_camera_thumb_wb));
            s.e(g2);
            s3.t(g2.b() - 1);
            s3.w();
            s3.D();
            s3.x();
            s3.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s3.r(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s3.E(getResources().getColor(R.color.color_camera_theme_80_light));
            s3.q(getResources().getColor(R.color.color_camera_theme_light));
            s3.A(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(9.0f));
            s3.u(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s3.a();
            s3.o(0.0f);
            s3.n(g2.b() - 1);
            s3.s(new b(g2));
            s3.v();
            s3.e();
            BubbleSeekBar2 bubbleSeekBar29 = (BubbleSeekBar2) d(i4);
            s.e(bubbleSeekBar29);
            bubbleSeekBar29.setOnProgressListener(new g(g2));
            BubbleSeekBar2 bubbleSeekBar210 = (BubbleSeekBar2) d(i4);
            s.e(bubbleSeekBar210);
            t(bubbleSeekBar210, true);
        } else {
            BubbleSeekBar2 bubbleSeekBar211 = (BubbleSeekBar2) d(R.id.camera_adv_white_balance);
            s.e(bubbleSeekBar211);
            t(bubbleSeekBar211, false);
        }
        if (this.f9487j.d() != null) {
            us.pinguo.camera2020.widget.g.a d2 = this.f9487j.d();
            int i5 = R.id.camera_adv_iso;
            BubbleSeekBar2 bubbleSeekBar212 = (BubbleSeekBar2) d(i5);
            s.e(bubbleSeekBar212);
            us.pinguo.camera2020.widget.bubbleSeekbar.a s4 = bubbleSeekBar212.s();
            s4.f(u(R.drawable.ic_camera_thumb_iso));
            s.e(d2);
            s4.t(d2.b() - 1);
            s4.w();
            s4.x();
            s4.s(new b(d2));
            s4.a();
            s4.o(0.0f);
            s4.n(d2.b() - 1);
            s4.D();
            s4.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s4.r(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s4.E(getResources().getColor(R.color.color_camera_theme_80_light));
            s4.q(getResources().getColor(R.color.color_camera_theme_light));
            s4.A(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(9.0f));
            s4.u(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s4.p(0.0f);
            s4.v();
            s4.e();
            BubbleSeekBar2 bubbleSeekBar213 = (BubbleSeekBar2) d(i5);
            s.e(bubbleSeekBar213);
            bubbleSeekBar213.setOnProgressListener(new h(d2));
            BubbleSeekBar2 bubbleSeekBar214 = (BubbleSeekBar2) d(i5);
            s.e(bubbleSeekBar214);
            t(bubbleSeekBar214, true);
        } else {
            BubbleSeekBar2 bubbleSeekBar215 = (BubbleSeekBar2) d(R.id.camera_adv_iso);
            s.e(bubbleSeekBar215);
            t(bubbleSeekBar215, false);
        }
        if (this.f9487j.c() != null) {
            us.pinguo.camera2020.widget.g.a c2 = this.f9487j.c();
            int i6 = R.id.camera_adv_exposure;
            BubbleSeekBar2 bubbleSeekBar216 = (BubbleSeekBar2) d(i6);
            s.e(bubbleSeekBar216);
            us.pinguo.camera2020.widget.bubbleSeekbar.a s5 = bubbleSeekBar216.s();
            s5.f(u(R.drawable.ic_camera_thumb_exposure));
            s.e(c2);
            s5.t(c2.b() - 1);
            s5.w();
            s5.x();
            s5.a();
            us.pinguo.camera2020.widget.g.a c3 = this.f9487j.c();
            s.e(c3);
            s5.o((-c3.b()) / 2);
            us.pinguo.camera2020.widget.g.a c4 = this.f9487j.c();
            s.e(c4);
            s5.n(c4.b() / 2);
            s5.D();
            s5.p(0.0f);
            s5.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s5.r(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s5.E(getResources().getColor(R.color.color_camera_theme_80_light));
            s5.q(getResources().getColor(R.color.color_camera_theme_light));
            s5.A(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(9.0f));
            s5.u(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s5.s(new b(c2));
            s5.v();
            s5.e();
            BubbleSeekBar2 bubbleSeekBar217 = (BubbleSeekBar2) d(i6);
            s.e(bubbleSeekBar217);
            bubbleSeekBar217.setOnProgressListener(new i());
            BubbleSeekBar2 bubbleSeekBar218 = (BubbleSeekBar2) d(i6);
            s.e(bubbleSeekBar218);
            t(bubbleSeekBar218, true);
        } else {
            BubbleSeekBar2 bubbleSeekBar219 = (BubbleSeekBar2) d(R.id.camera_adv_exposure);
            s.e(bubbleSeekBar219);
            t(bubbleSeekBar219, false);
        }
        if (this.f9487j.b() != null) {
            us.pinguo.camera2020.widget.g.a b2 = this.f9487j.b();
            int i7 = R.id.camera_adv_sharpness;
            BubbleSeekBar2 bubbleSeekBar220 = (BubbleSeekBar2) d(i7);
            s.e(bubbleSeekBar220);
            us.pinguo.camera2020.widget.bubbleSeekbar.a s6 = bubbleSeekBar220.s();
            s6.p(0.0f);
            s6.f(u(R.drawable.ic_camera_thumb_shutter));
            s.e(b2);
            s6.t(b2.b() - 1);
            s6.w();
            s6.x();
            s6.a();
            s6.o(0.0f);
            s6.n(b2.b() - 1);
            s6.D();
            s6.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s6.r(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s6.E(getResources().getColor(R.color.color_camera_theme_80_light));
            s6.q(getResources().getColor(R.color.color_camera_theme_light));
            s6.A(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(9.0f));
            s6.u(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s6.s(new b(b2));
            s6.v();
            s6.e();
            BubbleSeekBar2 bubbleSeekBar221 = (BubbleSeekBar2) d(i7);
            s.e(bubbleSeekBar221);
            bubbleSeekBar221.setOnProgressListener(new j(b2));
            BubbleSeekBar2 bubbleSeekBar222 = (BubbleSeekBar2) d(i7);
            s.e(bubbleSeekBar222);
            bubbleSeekBar222.setVisibility(0);
            VdsAgent.onSetViewVisibility(bubbleSeekBar222, 0);
        } else if (this.f9487j.e() != null) {
            us.pinguo.camera2020.widget.g.a e2 = this.f9487j.e();
            int i8 = R.id.camera_adv_sharpness;
            BubbleSeekBar2 bubbleSeekBar223 = (BubbleSeekBar2) d(i8);
            s.e(bubbleSeekBar223);
            us.pinguo.camera2020.widget.bubbleSeekbar.a s7 = bubbleSeekBar223.s();
            s7.p(0.0f);
            s7.f(u(R.drawable.ic_camera_thumb_sharpness));
            s.e(e2);
            s7.t(e2.b() - 1);
            s7.s(new b(e2));
            s7.w();
            s7.x();
            s7.a();
            s7.o(0.0f);
            s7.n(e2.b() - 1);
            s7.D();
            s7.F(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s7.r(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s7.E(getResources().getColor(R.color.color_camera_theme_80_light));
            s7.A(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(9.0f));
            s7.u(us.pinguo.camera2020.widget.bubbleSeekbar.b.a(3.0f));
            s7.q(getResources().getColor(R.color.color_camera_theme_light));
            s7.v();
            s7.e();
            BubbleSeekBar2 bubbleSeekBar224 = (BubbleSeekBar2) d(i8);
            s.e(bubbleSeekBar224);
            bubbleSeekBar224.setOnProgressListener(new k(e2));
            BubbleSeekBar2 bubbleSeekBar225 = (BubbleSeekBar2) d(i8);
            s.e(bubbleSeekBar225);
            t(bubbleSeekBar225, true);
        } else {
            BubbleSeekBar2 bubbleSeekBar226 = (BubbleSeekBar2) d(R.id.camera_adv_sharpness);
            s.e(bubbleSeekBar226);
            t(bubbleSeekBar226, false);
        }
        BubbleSeekBar2 bubbleSeekBar227 = (BubbleSeekBar2) d(R.id.contrastRatio);
        s.e(bubbleSeekBar227);
        bubbleSeekBar227.setProgress(0.0f);
        BubbleSeekBar2 bubbleSeekBar228 = (BubbleSeekBar2) d(R.id.saturability);
        s.e(bubbleSeekBar228);
        bubbleSeekBar228.setProgress(0.0f);
    }
}
