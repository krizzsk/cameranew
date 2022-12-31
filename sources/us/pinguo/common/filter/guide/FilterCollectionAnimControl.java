package us.pinguo.common.filter.guide;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.OneShotPreDrawListener;
import kotlin.Pair;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.j;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import us.pinguo.common.utils.k;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.utils.o;
/* compiled from: FilterCollectionAnimControl.kt */
/* loaded from: classes4.dex */
public final class FilterCollectionAnimControl {
    private final Activity a;
    private boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9858d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9859e;

    /* renamed from: f  reason: collision with root package name */
    private int f9860f;

    /* renamed from: g  reason: collision with root package name */
    private int f9861g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f9862h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f9863i;

    /* renamed from: j  reason: collision with root package name */
    private FrameLayout f9864j;

    /* renamed from: k  reason: collision with root package name */
    private FrameLayout f9865k;

    /* renamed from: l  reason: collision with root package name */
    private v1 f9866l;
    private boolean m;
    private l<? super Boolean, u> n;

    /* compiled from: View.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ FilterCollectionAnimControl b;
        final /* synthetic */ FrameLayout c;

        public a(View view, FilterCollectionAnimControl filterCollectionAnimControl, FrameLayout frameLayout) {
            this.a = view;
            this.b = filterCollectionAnimControl;
            this.c = frameLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.i(this.a, this.c);
        }
    }

    /* compiled from: View.kt */
    /* loaded from: classes4.dex */
    public static final class b implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ FilterCollectionAnimControl b;

        public b(View view, FilterCollectionAnimControl filterCollectionAnimControl) {
            this.a = view;
            this.b = filterCollectionAnimControl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getGlobalVisibleRect(this.b.f9863i);
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class c implements Animator.AnimatorListener {
        final /* synthetic */ View a;
        final /* synthetic */ float b;
        final /* synthetic */ long c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FilterCollectionAnimControl f9867d;

        public c(View view, float f2, long j2, FilterCollectionAnimControl filterCollectionAnimControl) {
            this.a = view;
            this.b = f2;
            this.c = j2;
            this.f9867d = filterCollectionAnimControl;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            ObjectAnimator translationY2 = ObjectAnimator.ofFloat(this.a, "translationY", this.b, 0.0f);
            translationY2.setDuration(this.c);
            translationY2.start();
            s.g(translationY2, "translationY2");
            translationY2.addListener(new d(this.a));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            s.h(animator, "animator");
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ View b;

        public d(View view) {
            this.b = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            FilterCollectionAnimControl.this.j(this.b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            s.h(animator, "animator");
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class e implements Animator.AnimatorListener {
        final /* synthetic */ kotlin.jvm.b.a a;

        public e(kotlin.jvm.b.a aVar) {
            this.a = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            s.h(animator, "animator");
            kotlin.jvm.b.a aVar = this.a;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            s.h(animator, "animator");
        }
    }

    public FilterCollectionAnimControl(Activity activity) {
        s.h(activity, "activity");
        this.a = activity;
        this.f9862h = new Rect();
        this.f9863i = new Rect();
        this.m = true;
    }

    private final void e(Context context, FrameLayout frameLayout, Rect rect) {
        FrameLayout frameLayout2 = new FrameLayout(context);
        int a2 = us.pinguo.common.widget.i.a.a(18);
        int a3 = us.pinguo.common.widget.i.a.a(21);
        ImageView imageView = new ImageView(context);
        int i2 = R.drawable.ic_filter_guide_arrow;
        imageView.setImageResource(i2);
        imageView.setAlpha(0.3f);
        frameLayout2.addView(imageView, new FrameLayout.LayoutParams(a2, a3));
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(i2);
        imageView2.setAlpha(0.6f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a3);
        layoutParams.topMargin = us.pinguo.common.widget.i.a.a(6);
        u uVar = u.a;
        frameLayout2.addView(imageView2, layoutParams);
        ImageView imageView3 = new ImageView(context);
        imageView3.setImageResource(i2);
        imageView3.setAlpha(1.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a2, a3);
        layoutParams2.topMargin = us.pinguo.common.widget.i.a.a(12);
        frameLayout2.addView(imageView3, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a2, a3);
        int i3 = rect.left;
        layoutParams3.leftMargin = i3 + (((rect.right - i3) - us.pinguo.common.widget.i.a.a(18)) / 2);
        layoutParams3.topMargin = rect.top - us.pinguo.common.widget.i.a.a(4);
        frameLayout.addView(frameLayout2, layoutParams3);
        s.g(OneShotPreDrawListener.add(frameLayout2, new a(frameLayout2, this, frameLayout2)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        this.f9865k = frameLayout2;
    }

    private final void f(FrameLayout frameLayout, View view, View view2, Rect rect) {
        Context context = view.getContext();
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect2);
        view2.getGlobalVisibleRect(rect);
        rect.top -= rect2.top;
        rect.bottom -= rect2.top;
        int a2 = us.pinguo.common.widget.i.a.a(56);
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setTag("flContainer");
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ic_filter_guide_bubble);
        us.pinguo.common.filter.guide.d.a(imageView, k.b(R.color.filter_bubble_grey));
        imageView.setTag("bubble");
        frameLayout2.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        int a3 = us.pinguo.common.widget.i.a.a(32);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(R.drawable.icon_filter_package_collect_start);
        imageView2.setTag("star");
        if (this.f9858d) {
            us.pinguo.common.filter.guide.d.a(imageView2, k.b(R.color.filter_star_yellow));
        } else {
            us.pinguo.common.filter.guide.d.a(imageView2, k.b(R.color.beauty_text_color_dark));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a3, a3);
        layoutParams.topMargin = us.pinguo.common.widget.i.a.a(10);
        boolean z = true;
        layoutParams.gravity = 1;
        u uVar = u.a;
        frameLayout2.addView(imageView2, layoutParams);
        s.g(OneShotPreDrawListener.add(frameLayout2, new b(frameLayout2, this)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a2, a2);
        int i2 = rect.left;
        layoutParams2.leftMargin = i2 + (((rect.right - i2) - a2) / 2);
        layoutParams2.topMargin = (rect.top - a2) - us.pinguo.common.widget.i.a.a(8);
        frameLayout.addView(frameLayout2, layoutParams2);
        if (!this.m ? o.b(o.a, "key_arrow_cancel", false, null, 4, null) : o.b(o.a, "key_arrow_guide", false, null, 4, null)) {
            z = false;
        }
        if (z) {
            s.g(context, "context");
            e(context, frameLayout, rect);
        }
    }

    private final void g() {
        FrameLayout frameLayout = this.f9864j;
        if (frameLayout == null) {
            return;
        }
        FrameLayout flContainer = (FrameLayout) ((FrameLayout) frameLayout.findViewWithTag("guide")).findViewWithTag("flContainer");
        ImageView bubbleView = (ImageView) flContainer.findViewWithTag("bubble");
        ImageView starView = (ImageView) flContainer.findViewWithTag("star");
        s.g(flContainer, "flContainer");
        m(flContainer, 1.4f, 1.0f, -us.pinguo.common.widget.i.a.a(16), 0.0f, new FilterCollectionAnimControl$cancelCollection$1(this));
        s.g(bubbleView, "bubbleView");
        us.pinguo.common.filter.guide.d.c(bubbleView, k.b(R.color.filter_bubble_white), k.b(R.color.filter_bubble_grey), 300L, (r18 & 16) != 0 ? 0L : 0L, (r18 & 32) != 0 ? null : null);
        s.g(starView, "starView");
        k(starView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(View view, FrameLayout frameLayout) {
        j(view);
        this.f9866l = j.d(n0.a(z0.c()), null, null, new FilterCollectionAnimControl$doArrowAnim$1(frameLayout, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(View view) {
        float f2 = -us.pinguo.common.widget.i.a.b(24);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(view, "translationY", 0.0f, f2);
        translationY.setDuration(600L);
        translationY.start();
        s.g(translationY, "translationY");
        translationY.addListener(new c(view, f2, 600L, this));
    }

    private final void k(ImageView imageView) {
        Pair pair;
        if (this.f9858d) {
            pair = new Pair(Integer.valueOf(k.b(R.color.filter_star_grey)), Integer.valueOf(k.b(R.color.filter_star_yellow)));
        } else {
            pair = new Pair(Integer.valueOf(k.b(R.color.filter_star_yellow)), Integer.valueOf(k.b(R.color.filter_star_grey)));
        }
        us.pinguo.common.filter.guide.d.c(imageView, ((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue(), 200L, (r18 & 16) != 0 ? 0L : 0L, (r18 & 32) != 0 ? null : null);
    }

    private final void l() {
        FrameLayout frameLayout = this.f9864j;
        if (frameLayout == null) {
            return;
        }
        FrameLayout flContainer = (FrameLayout) ((FrameLayout) frameLayout.findViewWithTag("guide")).findViewWithTag("flContainer");
        ImageView bubbleView = (ImageView) flContainer.findViewWithTag("bubble");
        ImageView starView = (ImageView) flContainer.findViewWithTag("star");
        s.g(flContainer, "flContainer");
        m(flContainer, 1.0f, 1.4f, 0.0f, -us.pinguo.common.widget.i.a.a(16), new FilterCollectionAnimControl$doCollection$1(this));
        s.g(bubbleView, "bubbleView");
        us.pinguo.common.filter.guide.d.c(bubbleView, k.b(R.color.filter_bubble_grey), k.b(R.color.filter_bubble_white), 300L, (r18 & 16) != 0 ? 0L : 0L, (r18 & 32) != 0 ? null : null);
        s.g(starView, "starView");
        k(starView);
        frameLayout.performHapticFeedback(0, 2);
    }

    private final void m(View view, float f2, float f3, float f4, float f5, kotlin.jvm.b.a<u> aVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f2, f3);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", f2, f3);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", f4, f5);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(300L);
        animatorSet.start();
        animatorSet.addListener(new e(aVar));
    }

    private final void t(View view) {
        if (this.a.isFinishing()) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.a.getWindow().getDecorView();
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setTag("guide");
        f(frameLayout, viewGroup, view, this.f9862h);
        viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        this.f9864j = frameLayout;
    }

    public final void h() {
        FrameLayout frameLayout = this.f9864j;
        if (frameLayout == null) {
            return;
        }
        if (q()) {
            if (this.m) {
                if (this.f9858d) {
                    o.n(o.a, "key_arrow_guide", true, null, 4, null);
                }
            } else if (!this.f9858d) {
                o.n(o.a, "key_arrow_cancel", true, null, 4, null);
            }
            l<Boolean, u> o = o();
            if (o != null) {
                o.invoke(Boolean.valueOf(this.f9858d));
            }
        }
        ViewParent parent = frameLayout.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(frameLayout);
        }
        v1 v1Var = this.f9866l;
        if (v1Var != null) {
            v1.a.a(v1Var, null, 1, null);
        }
        this.b = false;
        r(false);
        this.f9859e = false;
        this.f9860f = 0;
        this.f9861g = 0;
    }

    public final void n(float f2, float f3) {
        Rect rect = this.f9862h;
        boolean contains = this.f9863i.contains((int) (rect.left + f2), (int) (rect.top + f3));
        if (this.f9859e) {
            return;
        }
        int i2 = this.f9861g;
        this.f9860f = i2;
        int i3 = contains ? 1 : 2;
        this.f9861g = i3;
        if (i3 != 1) {
            if (i3 != 2 || i2 == 2 || i2 == 0) {
                return;
            }
            this.f9858d = !this.f9858d;
            g();
        } else if (i2 == 1) {
        } else {
            FrameLayout frameLayout = this.f9865k;
            if (frameLayout != null) {
                v1 v1Var = this.f9866l;
                if (v1Var != null) {
                    v1.a.a(v1Var, null, 1, null);
                }
                ViewParent parent = frameLayout.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(frameLayout);
                }
                this.f9865k = null;
            }
            this.f9858d = !this.f9858d;
            l();
        }
    }

    public final l<Boolean, u> o() {
        return this.n;
    }

    public final boolean p() {
        return this.c;
    }

    public final boolean q() {
        return this.b;
    }

    public final void r(boolean z) {
        this.c = z;
    }

    public final void s(l<? super Boolean, u> lVar) {
        this.n = lVar;
    }

    public final void u(View anchorView, boolean z) {
        s.h(anchorView, "anchorView");
        if (this.b) {
            return;
        }
        this.b = true;
        this.c = true;
        this.f9858d = z;
        this.m = !z;
        t(anchorView);
    }
}
