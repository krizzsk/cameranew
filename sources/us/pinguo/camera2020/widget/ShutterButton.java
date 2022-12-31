package us.pinguo.camera2020.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;
import com.airbnb.lottie.LottieAnimationView;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.widget.ShutterButtonDrawable;
/* compiled from: ShutterButton.kt */
/* loaded from: classes3.dex */
public final class ShutterButton extends LottieAnimationView {
    private GestureDetectorCompat u;
    private int v;
    private boolean w;

    /* compiled from: ShutterButton.kt */
    /* loaded from: classes3.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e2) {
            s.h(e2, "e");
            us.pinguo.common.log.a.c("onDown", new Object[0]);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e2) {
            s.h(e2, "e");
            us.pinguo.common.log.a.c("onSingleTapConfirmed", new Object[0]);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e2) {
            s.h(e2, "e");
            us.pinguo.common.log.a.c("onSingleTapUp", new Object[0]);
            return true;
        }
    }

    /* compiled from: ShutterButton.kt */
    /* loaded from: classes3.dex */
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatorListenerAdapter b;

        b(AnimatorListenerAdapter animatorListenerAdapter) {
            this.b = animatorListenerAdapter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (ShutterButton.this.m()) {
                ShutterButton.this.f();
            }
            ShutterButton.this.setBackgroundResource(0);
            this.b.onAnimationEnd(animator);
            ShutterButton.this.q();
            if (ShutterButton.this.m()) {
                ShutterButton.this.f();
            }
        }
    }

    /* compiled from: ShutterButton.kt */
    /* loaded from: classes3.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (ShutterButton.this.w) {
                ShutterButton.this.setAnimation("lottie/shutter_save_loading_light.json");
            } else {
                ShutterButton.this.setAnimation("lottie/shutter_save_loading_dark.json");
            }
            ShutterButton.this.p();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutterButton(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.v = 100;
        setLayerType(1, null);
        this.u = new GestureDetectorCompat(getContext(), new a());
        setState(ShutterButtonDrawable.State.CAMERA);
    }

    private final ShutterButtonDrawable y() {
        Drawable drawable = getDrawable();
        if (drawable != null && (drawable instanceof ShutterButtonDrawable)) {
            return (ShutterButtonDrawable) drawable;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        return null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        s.h(event, "event");
        boolean z = this.u.onTouchEvent(event) && super.onTouchEvent(event);
        if (event.getAction() == 1) {
            setPressed(false);
        }
        return z;
    }

    public final void setIsDark(boolean z) {
        this.w = z;
    }

    public final void setMax(int i2) {
        this.v = i2;
        ShutterButtonDrawable y = y();
        if (y == null) {
            return;
        }
        y.r(i2);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setProgress(float f2) {
        ShutterButtonDrawable y = y();
        if (y == null) {
            return;
        }
        y.s((int) (y.i() * f2));
    }

    public final void setState(ShutterButtonDrawable.State state) {
        s.h(state, "state");
        f();
        ShutterButtonDrawable y = y();
        if (y == null) {
            ShutterButtonDrawable shutterButtonDrawable = new ShutterButtonDrawable(state);
            shutterButtonDrawable.r(this.v);
            setImageDrawable(shutterButtonDrawable);
            return;
        }
        y.t(state);
    }

    public final void setTransparentMode(boolean z) {
        ShutterButtonDrawable y = y();
        if (y == null) {
            return;
        }
        y.v(z);
    }

    public final ShutterButtonDrawable.State v() {
        ShutterButtonDrawable y = y();
        if (y == null) {
            return null;
        }
        return y.h();
    }

    public final void w(AnimatorListenerAdapter listenerAdapter) {
        s.h(listenerAdapter, "listenerAdapter");
        if (m()) {
            f();
        }
        if (this.w) {
            setBackgroundResource(R.drawable.shutter_solid_bg_dark);
            setAnimation("lottie/shutter_save_complete_light.json");
        } else {
            setBackgroundResource(R.drawable.shutter_solid_bg_light);
            setAnimation("lottie/shutter_save_complete_dark.json");
        }
        d(new b(listenerAdapter));
        p();
    }

    public final void x() {
        if (m()) {
            f();
        }
        if (this.w) {
            setBackgroundResource(R.drawable.shutter_solid_bg_dark);
        } else {
            setBackgroundResource(R.drawable.shutter_solid_bg_light);
        }
        if (this.w) {
            setAnimation("lottie/shutter_save_disappear_light.json");
        } else {
            setAnimation("lottie/shutter_save_disappear_dark.json");
        }
        d(new c());
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutterButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.v = 100;
        setLayerType(1, null);
        this.u = new GestureDetectorCompat(getContext(), new a());
        setState(ShutterButtonDrawable.State.CAMERA);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutterButton(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.v = 100;
        setLayerType(1, null);
        this.u = new GestureDetectorCompat(getContext(), new a());
        setState(ShutterButtonDrawable.State.CAMERA);
    }
}
