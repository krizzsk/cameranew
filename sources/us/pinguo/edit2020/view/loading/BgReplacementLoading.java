package us.pinguo.edit2020.view.loading;

import android.animation.Animator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
/* compiled from: BgReplacementLoadingControl.kt */
/* loaded from: classes4.dex */
public final class BgReplacementLoading {
    private boolean a;
    private boolean b;
    private BgReplacementLoadingView c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<Activity> f10775d;

    /* renamed from: e  reason: collision with root package name */
    private a f10776e;

    /* compiled from: BgReplacementLoadingControl.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BgReplacementLoading.this.c();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public BgReplacementLoading() {
        this(null, 1, null);
    }

    public BgReplacementLoading(Activity activity) {
        this.f10775d = new WeakReference<>(activity);
        this.f10776e = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        BgReplacementLoadingView bgReplacementLoadingView = this.c;
        if (bgReplacementLoadingView == null) {
            return;
        }
        bgReplacementLoadingView.p();
        this.a = false;
        ViewGroup viewGroup = (ViewGroup) bgReplacementLoadingView.getParent();
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(bgReplacementLoadingView);
    }

    private final Activity e() {
        return this.f10775d.get();
    }

    private final void h() {
        Activity e2 = e();
        if (e2 == null || e2.isFinishing()) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) e2.getWindow().getDecorView();
        View inflate = e2.getLayoutInflater().inflate(R.layout.layout_new_loading, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.edit2020.view.loading.BgReplacementLoadingView");
        BgReplacementLoadingView bgReplacementLoadingView = (BgReplacementLoadingView) inflate;
        this.c = bgReplacementLoadingView;
        s.e(bgReplacementLoadingView);
        bgReplacementLoadingView.setFullScreen(this.b);
        viewGroup.addView(this.c, new ViewGroup.MarginLayoutParams(-1, -1));
    }

    public final void d(boolean z) {
        if (z) {
            c();
            return;
        }
        BgReplacementLoadingView bgReplacementLoadingView = this.c;
        if (bgReplacementLoadingView == null) {
            return;
        }
        bgReplacementLoadingView.k();
        bgReplacementLoadingView.setOnFinish(new BgReplacementLoading$dismiss$1$1(bgReplacementLoadingView, this));
    }

    public final boolean f() {
        return this.a;
    }

    public final void g(boolean z) {
        this.b = z;
    }

    public final void i() {
        if (e() == null || this.a) {
            return;
        }
        h();
        this.a = true;
    }

    public /* synthetic */ BgReplacementLoading(Activity activity, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : activity);
    }
}
