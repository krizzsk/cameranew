package us.pinguo.widget.common.guide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.e;
import com.airbnb.lottie.o;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.widget.common.R;
import us.pinguo.widget.common.widget.AutofitTextView;
/* loaded from: classes6.dex */
public class GuideHandler {
    private View c;

    /* renamed from: e  reason: collision with root package name */
    private String f12508e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f12509f;
    private Drawable m;
    private String n;
    private int o;
    protected FrameLayout p;
    private Activity q;
    private boolean r;
    private boolean a = true;
    private int b = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f12507d = Color.parseColor("#00000000");

    /* renamed from: g  reason: collision with root package name */
    private int f12510g = R.drawable.guide_toast_center;

    /* renamed from: h  reason: collision with root package name */
    private int f12511h = Color.parseColor("#ffffffff");

    /* renamed from: i  reason: collision with root package name */
    private int f12512i = 0;

    /* renamed from: j  reason: collision with root package name */
    private Gravity f12513j = Gravity.CENTER;

    /* renamed from: k  reason: collision with root package name */
    private int f12514k = 10;

    /* renamed from: l  reason: collision with root package name */
    private int f12515l = 10;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private VGravity w = VGravity.UP;
    private boolean x = false;
    private int y = -199;
    private boolean z = false;
    private boolean A = false;
    private View.OnTouchListener B = null;
    private int C = -1;
    private boolean D = false;
    private int E = 0;
    private int F = 0;
    private int G = 0;

    /* loaded from: classes6.dex */
    public enum Gravity {
        LEFT,
        CENTER,
        RIGHT,
        CENTER_IN_VIEW
    }

    /* loaded from: classes6.dex */
    public enum VGravity {
        UP,
        DOWN,
        CENTER
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 16) {
                GuideHandler.this.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                GuideHandler.this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            GuideHandler.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            GuideHandler.this.l();
            if (GuideHandler.this.B != null) {
                GuideHandler.this.B.onTouch(view, motionEvent);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (GuideHandler.this.A && GuideHandler.this.c != null) {
                GuideHandler.this.c.performClick();
            }
            GuideHandler.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ AutofitTextView a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f12516d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f12517e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Point f12518f;

        d(AutofitTextView autofitTextView, int i2, int i3, float f2, int i4, Point point) {
            this.a = autofitTextView;
            this.b = i2;
            this.c = i3;
            this.f12516d = f2;
            this.f12517e = i4;
            this.f12518f = point;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 16) {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            int height = this.a.getHeight();
            GuideHandler guideHandler = GuideHandler.this;
            int q = guideHandler.q(guideHandler.w, height, this.b, this.c, this.f12516d * GuideHandler.this.f12515l);
            GuideHandler guideHandler2 = GuideHandler.this;
            int p = guideHandler2.p(guideHandler2.f12513j, this.a.getWidth(), this.f12517e, GuideHandler.this.f12514k * this.f12516d);
            if (GuideHandler.this.f12513j == Gravity.CENTER_IN_VIEW) {
                int intValue = Float.valueOf(this.f12516d * 20.0f).intValue();
                int i2 = this.f12518f.y;
                if (i2 - intValue > q + height) {
                    q = (i2 - intValue) - height;
                }
            }
            this.a.setTranslationX(p);
            this.a.setTranslationY(q);
        }
    }

    static {
        Color.parseColor("#80000000");
    }

    private GuideHandler(Activity activity) {
        this.q = activity;
    }

    public static GuideHandler k(Activity activity) {
        return new GuideHandler(activity);
    }

    private static int n(Context context, String str) {
        return context.getSharedPreferences("guide_handler_count", 0).getInt(str, 0);
    }

    public static SharedPreferences o(Context context) {
        return context.getSharedPreferences("guide_handler_count", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p(Gravity gravity, int i2, int i3, float f2) {
        View view = this.c;
        int width = view != null ? view.getWidth() : 0;
        if (gravity != Gravity.LEFT) {
            if (gravity == Gravity.RIGHT) {
                return (i3 + width) - ((int) f2);
            }
            i3 += width / 2;
            i2 /= 2;
        }
        return (i3 - i2) + ((int) f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q(VGravity vGravity, int i2, int i3, int i4, float f2) {
        int i5;
        if (vGravity == VGravity.UP) {
            i5 = i4 - i2;
        } else {
            i5 = vGravity == VGravity.CENTER ? i4 + (i3 / 2) + i2 : i4 + i3;
        }
        return i5 - ((int) f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void s(LottieAnimationView lottieAnimationView, e eVar) {
        if (lottieAnimationView != null) {
            lottieAnimationView.setComposition(eVar);
            lottieAnimationView.n(true);
            lottieAnimationView.p();
            lottieAnimationView.setVisibility(0);
        }
    }

    private static void t(Context context, String str, int i2) {
        context.getSharedPreferences("guide_handler_count", 0).edit().putInt(str, i2).apply();
    }

    private void v() {
        View view = this.c;
        if (view != null && (!ViewCompat.isAttachedToWindow(view) || this.c.getWidth() == 0)) {
            this.c.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        } else {
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void y() {
        float f2;
        int i2;
        float f3 = this.q.getResources().getDisplayMetrics().density;
        ViewGroup viewGroup = (ViewGroup) this.q.getWindow().getDecorView();
        ViewGroup viewGroup2 = this.f12509f;
        ViewGroup viewGroup3 = viewGroup2 != null ? viewGroup2 : viewGroup;
        FrameLayout frameLayout = (FrameLayout) this.q.getLayoutInflater().inflate(R.layout.vw_guide_layout, viewGroup3, false);
        this.p = frameLayout;
        frameLayout.setBackgroundColor(this.f12507d);
        ImageView imageView = (ImageView) this.p.findViewById(R.id.instruction);
        final LottieAnimationView lottieAnimationView = (LottieAnimationView) this.p.findViewById(R.id.lottie);
        if (this.z) {
            this.p.setOnTouchListener(new b());
        } else {
            this.p.setOnClickListener(new c());
        }
        int i3 = this.G;
        if (((-16777216) & i3) != 0) {
            this.p.setBackgroundColor(i3);
        }
        if (!this.a) {
            imageView.setVisibility(8);
        }
        AutofitTextView autofitTextView = (AutofitTextView) this.p.findViewById(R.id.tip);
        int i4 = this.D ? 8 : 0;
        autofitTextView.setVisibility(i4);
        VdsAgent.onSetViewVisibility(autofitTextView, i4);
        imageView.setBackgroundDrawable(this.m);
        Drawable drawable = this.m;
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
        int i5 = this.f12510g;
        if (i5 != 0) {
            autofitTextView.setBackgroundResource(i5);
        }
        autofitTextView.setTextColor(this.f12511h);
        int i6 = this.C;
        if (i6 != -1) {
            autofitTextView.setMaxWidth(i6);
        }
        autofitTextView.setSingleLine(this.x);
        int i7 = this.y;
        if (i7 != -199) {
            autofitTextView.setGravity(i7);
        }
        autofitTextView.setTextSize(1, 12.0f);
        autofitTextView.setText(this.f12508e);
        if (this.f12512i > 0) {
            autofitTextView.setCompoundDrawablePadding((int) ((Resources.getSystem().getDisplayMetrics().density * 2.0f) + 0.5f));
            autofitTextView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this.q, this.f12512i), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        View view = this.c;
        int width = view != null ? view.getWidth() : 0;
        View view2 = this.c;
        int height = view2 != null ? view2.getHeight() : 0;
        int[] iArr = new int[2];
        View view3 = this.c;
        if (view3 != null) {
            view3.getLocationOnScreen(iArr);
        }
        int i8 = iArr[0];
        int i9 = iArr[1];
        Point point = new Point();
        imageView.measure(-2, -2);
        int measuredWidth = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        int i10 = ((i8 + (width / 2)) - (measuredWidth / 2)) + this.E;
        point.x = i10;
        point.y = ((i9 + (height / 2)) - (measuredHeight / 2)) + this.F;
        imageView.setTranslationX(i10);
        imageView.setTranslationY(point.y);
        if (this.b != 0) {
            if (this.c != null) {
                f2 = f3;
                lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams((int) (width * 1.2d), (int) (height * 1.2d)));
                lottieAnimationView.setTranslationX(i8 - (width * 0.1f));
                lottieAnimationView.setTranslationY(i9 - (height * 0.1f));
            } else {
                f2 = f3;
                lottieAnimationView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            }
            int i11 = this.b;
            e.b.a(this.q, i11 != 1 ? i11 != 2 ? i11 != 3 ? "" : "lottie/portrait.json" : "lottie/hand_faceshape.json" : "lottie/wave.json", new o() { // from class: us.pinguo.widget.common.guide.a
                @Override // com.airbnb.lottie.o
                public final void a(e eVar) {
                    GuideHandler.s(LottieAnimationView.this, eVar);
                }
            });
        } else {
            f2 = f3;
            lottieAnimationView.setVisibility(8);
        }
        Point point2 = new Point();
        autofitTextView.measure(-2, -2);
        if (this.f12510g == 0 && ((i2 = this.s) != 0 || this.t != 0 || this.u != 0 || this.v != 0)) {
            autofitTextView.setPadding(i2, this.t, this.u, this.v);
        }
        int measuredWidth2 = autofitTextView.getMeasuredWidth();
        int measuredHeight2 = autofitTextView.getMeasuredHeight();
        if (measuredWidth2 > viewGroup3.getWidth()) {
            point2.x = p(this.f12513j, viewGroup3.getWidth(), i8, this.f12514k * f2);
        } else {
            point2.x = p(this.f12513j, measuredWidth2, i8, this.f12514k * f2);
        }
        point2.y = q(this.w, measuredHeight2, height, i9, this.f12515l * f2);
        if (this.f12513j == Gravity.CENTER_IN_VIEW) {
            int intValue = Float.valueOf(15.0f * f2).intValue();
            int i12 = point.y;
            if (i12 - intValue > point2.y + measuredHeight2) {
                point2.y = (i12 - intValue) - measuredHeight2;
            }
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) autofitTextView.getLayoutParams();
        if (measuredWidth2 > viewGroup3.getWidth()) {
            layoutParams.width = viewGroup3.getWidth();
            measuredWidth2 = viewGroup3.getWidth();
        }
        int i13 = point2.x;
        if (i13 < 0) {
            layoutParams.width = i13 + measuredWidth2;
            point2.x = 0;
        }
        if (point2.x + measuredWidth2 > viewGroup3.getWidth()) {
            layoutParams.width = viewGroup3.getWidth() - point2.x;
        }
        autofitTextView.getViewTreeObserver().addOnGlobalLayoutListener(new d(autofitTextView, height, i9, f2, i8, point));
        autofitTextView.setTranslationX(point2.x);
        autofitTextView.setTranslationY(point2.y);
        viewGroup3.addView(this.p, new ViewGroup.MarginLayoutParams(-1, -1));
    }

    public GuideHandler A(int i2) {
        this.f12510g = i2;
        return this;
    }

    public GuideHandler B(Gravity gravity) {
        this.f12513j = gravity;
        int i2 = this.f12510g;
        if (i2 == R.drawable.guide_toast_center || i2 == R.drawable.guide_toast_left || i2 == R.drawable.guide_toast_right) {
            if (gravity != Gravity.CENTER && gravity != Gravity.CENTER_IN_VIEW) {
                if (gravity == Gravity.LEFT) {
                    this.f12510g = R.drawable.guide_toast_left;
                } else if (gravity == Gravity.RIGHT) {
                    this.f12510g = R.drawable.guide_toast_right;
                }
            } else {
                this.f12510g = R.drawable.guide_toast_center2;
            }
        }
        return this;
    }

    public GuideHandler C(int i2) {
        this.f12512i = i2;
        return this;
    }

    public GuideHandler D(int i2, int i3, int i4, int i5) {
        this.s = i2;
        this.u = i4;
        this.t = i3;
        this.v = i5;
        return this;
    }

    public GuideHandler E(boolean z) {
        this.x = z;
        return this;
    }

    public GuideHandler F(String str) {
        this.f12508e = str;
        return this;
    }

    public GuideHandler G(VGravity vGravity) {
        this.w = vGravity;
        return this;
    }

    public GuideHandler H(String str, int i2) {
        this.n = str;
        this.o = i2;
        return this;
    }

    public void l() {
        this.r = false;
        FrameLayout frameLayout = this.p;
        if (frameLayout != null && frameLayout.getParent() != null) {
            ((ViewGroup) this.p.getParent()).removeView(this.p);
        }
        this.p = null;
    }

    public GuideHandler m() {
        this.z = true;
        return this;
    }

    public boolean r() {
        return this.r;
    }

    public void u(String str, int i2) {
        Activity activity = this.q;
        if (activity != null) {
            activity.getSharedPreferences("guide_handler_count", 0).edit().putInt(str, i2).apply();
        }
    }

    public GuideHandler w(boolean z) {
        this.a = z;
        return this;
    }

    public boolean x(View view) {
        if (!TextUtils.isEmpty(this.n) && this.o > 0) {
            int n = n(this.q, this.n) + 1;
            if (n > this.o) {
                return false;
            }
            t(this.q, this.n, n);
        }
        this.c = view;
        if (this.m == null) {
            this.m = this.q.getResources().getDrawable(R.drawable.anim_instruction_guide_tap);
        }
        v();
        this.r = true;
        return true;
    }

    public GuideHandler z(int i2, int i3) {
        this.f12514k = i2;
        this.f12515l = i3;
        return this;
    }
}
