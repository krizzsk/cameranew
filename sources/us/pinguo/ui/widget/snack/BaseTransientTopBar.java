package us.pinguo.ui.widget.snack;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.List;
import us.pinguo.ui.R;
import us.pinguo.ui.widget.snack.BaseTransientTopBar;
import us.pinguo.ui.widget.snack.a;
/* loaded from: classes6.dex */
public abstract class BaseTransientTopBar<B extends BaseTransientTopBar<B>> {

    /* renamed from: i  reason: collision with root package name */
    static final Interpolator f12314i = new FastOutSlowInInterpolator();

    /* renamed from: j  reason: collision with root package name */
    static final Handler f12315j = new Handler(Looper.getMainLooper(), new a());
    private final ViewGroup a;
    private final Context b;
    final SnackbarBaseLayout c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.snackbar.a f12316d;

    /* renamed from: e  reason: collision with root package name */
    private int f12317e;

    /* renamed from: f  reason: collision with root package name */
    private List<i<B>> f12318f;

    /* renamed from: g  reason: collision with root package name */
    private final AccessibilityManager f12319g;

    /* renamed from: h  reason: collision with root package name */
    final a.b f12320h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes6.dex */
    public static class SnackbarBaseLayout extends FrameLayout {
        private l a;
        private k b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        void a(k kVar) {
            this.b = kVar;
        }

        void b(l lVar) {
            this.a = lVar;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            k kVar = this.b;
            if (kVar != null) {
                kVar.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            k kVar = this.b;
            if (kVar != null) {
                kVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            l lVar = this.a;
            if (lVar != null) {
                lVar.a(this, i2, i3, i4, i5);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            int i2 = R.styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i2)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
        }
    }

    /* loaded from: classes6.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientTopBar) message.obj).n();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((BaseTransientTopBar) message.obj).f(message.arg1);
                return true;
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements OnApplyWindowInsetsListener {
        b(BaseTransientTopBar baseTransientTopBar) {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes6.dex */
    class c implements a.b {
        c() {
        }

        @Override // us.pinguo.ui.widget.snack.a.b
        public void a(int i2) {
            Handler handler = BaseTransientTopBar.f12315j;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientTopBar.this));
        }

        @Override // us.pinguo.ui.widget.snack.a.b
        public void show() {
            Handler handler = BaseTransientTopBar.f12315j;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientTopBar.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements SwipeDismissBehavior.c {
        d() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
            BaseTransientTopBar.this.e(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i2) {
            if (i2 == 0) {
                us.pinguo.ui.widget.snack.a.c().l(BaseTransientTopBar.this.f12320h);
            } else if (i2 == 1 || i2 == 2) {
                us.pinguo.ui.widget.snack.a.c().k(BaseTransientTopBar.this.f12320h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements k {

        /* loaded from: classes6.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientTopBar.this.i(3);
            }
        }

        e() {
        }

        @Override // us.pinguo.ui.widget.snack.BaseTransientTopBar.k
        public void onViewAttachedToWindow(View view) {
        }

        @Override // us.pinguo.ui.widget.snack.BaseTransientTopBar.k
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientTopBar.this.h()) {
                BaseTransientTopBar.f12315j.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f implements l {
        f() {
        }

        @Override // us.pinguo.ui.widget.snack.BaseTransientTopBar.l
        public void a(View view, int i2, int i3, int i4, int i5) {
            BaseTransientTopBar.this.c.b(null);
            if (BaseTransientTopBar.this.l()) {
                BaseTransientTopBar.this.b();
            } else {
                BaseTransientTopBar.this.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class g extends ViewPropertyAnimatorListenerAdapter {
        g() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            BaseTransientTopBar.this.j();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            BaseTransientTopBar.this.f12316d.a(70, BaseBlurEffect.ROTATION_180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ int a;

        h(int i2) {
            this.a = i2;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            BaseTransientTopBar.this.i(this.a);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            BaseTransientTopBar.this.f12316d.b(0, BaseBlurEffect.ROTATION_180);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class i<B> {
        public void a(B b, int i2) {
        }

        public void b(B b) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class j extends SwipeDismissBehavior<SnackbarBaseLayout> {
        j() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: k */
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, SnackbarBaseLayout snackbarBaseLayout, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    us.pinguo.ui.widget.snack.a.c().l(BaseTransientTopBar.this.f12320h);
                }
            } else if (coordinatorLayout.isPointInChildBounds(snackbarBaseLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                us.pinguo.ui.widget.snack.a.c().k(BaseTransientTopBar.this.f12320h);
            }
            return super.onInterceptTouchEvent(coordinatorLayout, snackbarBaseLayout, motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes6.dex */
    public interface k {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes6.dex */
    public interface l {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    protected BaseTransientTopBar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.a aVar) {
        this.f12320h = new c();
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar != null) {
            this.a = viewGroup;
            this.f12316d = aVar;
            Context context = viewGroup.getContext();
            this.b = context;
            us.pinguo.ui.widget.snack.b.a(context);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(R.layout.design_layout_snacktop, viewGroup, false);
            this.c = snackbarBaseLayout;
            snackbarBaseLayout.addView(view);
            ViewCompat.setAccessibilityLiveRegion(snackbarBaseLayout, 1);
            ViewCompat.setImportantForAccessibility(snackbarBaseLayout, 1);
            ViewCompat.setFitsSystemWindows(snackbarBaseLayout, true);
            ViewCompat.setOnApplyWindowInsetsListener(snackbarBaseLayout, new b(this));
            this.f12319g = (AccessibilityManager) context.getSystemService("accessibility");
            return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    }

    private void c(int i2) {
        ViewCompat.animate(this.c).translationY(-this.c.getHeight()).setInterpolator(f12314i).setDuration(250L).setListener(new h(i2)).start();
    }

    void b() {
        SnackbarBaseLayout snackbarBaseLayout = this.c;
        ViewCompat.setTranslationY(snackbarBaseLayout, -snackbarBaseLayout.getHeight());
        ViewCompat.animate(this.c).translationY(0.0f).setInterpolator(f12314i).setDuration(250L).setListener(new g()).start();
    }

    public void d() {
        e(3);
    }

    void e(int i2) {
        us.pinguo.ui.widget.snack.a.c().b(this.f12320h, i2);
    }

    final void f(int i2) {
        if (l() && this.c.getVisibility() == 0) {
            c(i2);
        } else {
            i(i2);
        }
    }

    public boolean g() {
        return us.pinguo.ui.widget.snack.a.c().e(this.f12320h);
    }

    public boolean h() {
        return us.pinguo.ui.widget.snack.a.c().f(this.f12320h);
    }

    void i(int i2) {
        us.pinguo.ui.widget.snack.a.c().i(this.f12320h);
        List<i<B>> list = this.f12318f;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f12318f.get(size).a(this, i2);
            }
        }
        if (Build.VERSION.SDK_INT < 11) {
            SnackbarBaseLayout snackbarBaseLayout = this.c;
            snackbarBaseLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(snackbarBaseLayout, 8);
        }
        ViewParent parent = this.c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.c);
        }
    }

    void j() {
        us.pinguo.ui.widget.snack.a.c().j(this.f12320h);
        List<i<B>> list = this.f12318f;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f12318f.get(size).b(this);
            }
        }
    }

    @NonNull
    public B k(int i2) {
        this.f12317e = i2;
        return this;
    }

    boolean l() {
        return !this.f12319g.isEnabled();
    }

    public void m() {
        us.pinguo.ui.widget.snack.a.c().n(this.f12317e, this.f12320h);
    }

    final void n() {
        if (this.c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                j jVar = new j();
                jVar.h(0.1f);
                jVar.f(0.6f);
                jVar.i(0);
                jVar.g(new d());
                layoutParams2.setBehavior(jVar);
                layoutParams2.insetEdge = 48;
            }
            this.a.addView(this.c);
        }
        this.c.a(new e());
        if (ViewCompat.isLaidOut(this.c)) {
            if (l()) {
                b();
                return;
            } else {
                j();
                return;
            }
        }
        this.c.b(new f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientTopBar(@NonNull ViewGroup viewGroup, @NonNull View view, int i2, @NonNull com.google.android.material.snackbar.a aVar) {
        this(viewGroup, view, aVar);
        this.c.setBackgroundColor(i2);
    }
}
