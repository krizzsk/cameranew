package us.pinguo.camera2020.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Objects;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.v1;
import us.pinguo.cameramanger.info.CameraFrame;
/* compiled from: TimerCountDownController.kt */
/* loaded from: classes3.dex */
public final class TimerCountDownController {
    private final LifecycleOwner a;
    private final TextView b;
    private kotlinx.coroutines.v1 c;

    /* renamed from: d */
    private AnimatorSet f9316d;

    /* renamed from: e */
    private kotlin.jvm.b.l<? super Integer, kotlin.u> f9317e;

    /* compiled from: TimerCountDownController.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CameraFrame.values().length];
            iArr[CameraFrame.FRAME_1_1.ordinal()] = 1;
            iArr[CameraFrame.FRAME_4_3.ordinal()] = 2;
            iArr[CameraFrame.FRAME_16_9.ordinal()] = 3;
            iArr[CameraFrame.FRAME_FULL.ordinal()] = 4;
            a = iArr;
        }
    }

    /* compiled from: TimerCountDownController.kt */
    /* loaded from: classes3.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
            TimerCountDownController.this = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView e2 = TimerCountDownController.this.e();
            e2.setVisibility(4);
            VdsAgent.onSetViewVisibility(e2, 4);
        }
    }

    public TimerCountDownController(LifecycleOwner lifecycleOwner, TextView textView) {
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(textView, "textView");
        this.a = lifecycleOwner;
        this.b = textView;
    }

    public final void b(int i2) {
        AnimatorSet animatorSet = this.f9316d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        TextView textView = this.b;
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        this.b.setText(String.valueOf(i2));
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1.0f));
        kotlin.jvm.internal.s.g(ofPropertyValuesHolder, "ofPropertyValuesHolder(t…aleXHolder, scaleYHolder)");
        ofPropertyValuesHolder.setDuration(100L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "alpha", 1.0f, 0.0f);
        ofFloat.setStartDelay(600L);
        ofFloat.setDuration(300L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.play(ofPropertyValuesHolder).with(ofFloat);
        animatorSet2.addListener(new b());
        animatorSet2.start();
        this.f9316d = animatorSet2;
        kotlin.jvm.b.l<? super Integer, kotlin.u> lVar = this.f9317e;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Integer.valueOf(i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(TimerCountDownController timerCountDownController, kotlin.jvm.b.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = null;
        }
        timerCountDownController.c(aVar);
    }

    public static final void j(TimerCountDownController this$0, CameraFrame cameraFrame) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        int i2 = cameraFrame == null ? -1 : a.a[cameraFrame.ordinal()];
        if (i2 == 1 || i2 == 2) {
            ViewGroup.LayoutParams layoutParams = this$0.b.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.verticalBias = 0.5f;
            this$0.b.setLayoutParams(layoutParams2);
        } else if (i2 == 3 || i2 == 4) {
            ViewGroup.LayoutParams layoutParams3 = this$0.b.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            layoutParams4.verticalBias = 0.4f;
            this$0.b.setLayoutParams(layoutParams4);
        }
    }

    public final void c(kotlin.jvm.b.a<kotlin.u> aVar) {
        kotlinx.coroutines.v1 v1Var = this.c;
        if (v1Var != null) {
            v1.a.a(v1Var, null, 1, null);
        }
        this.c = null;
        AnimatorSet animatorSet = this.f9316d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (aVar != null) {
            aVar.invoke();
        }
        TextView textView = this.b;
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
    }

    public final TextView e() {
        return this.b;
    }

    public final boolean f() {
        kotlinx.coroutines.v1 v1Var = this.c;
        if (v1Var == null) {
            return false;
        }
        return v1Var.isActive();
    }

    public final void h(kotlin.jvm.b.l<? super Integer, kotlin.u> lVar) {
        this.f9317e = lVar;
    }

    public final void i(LifecycleOwner owner, us.pinguo.repository2020.u<CameraFrame> frameLiveData) {
        kotlin.jvm.internal.s.h(owner, "owner");
        kotlin.jvm.internal.s.h(frameLiveData, "frameLiveData");
        frameLiveData.observe(owner, new Observer() { // from class: us.pinguo.camera2020.view.k1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TimerCountDownController.j(TimerCountDownController.this, (CameraFrame) obj);
            }
        });
    }

    public final void k(int i2, kotlin.jvm.b.a<kotlin.u> endBlock) {
        kotlinx.coroutines.v1 d2;
        kotlin.jvm.internal.s.h(endBlock, "endBlock");
        if (i2 <= 0) {
            endBlock.invoke();
            return;
        }
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = i2;
        d2 = kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.c(), null, new TimerCountDownController$startTimer$1(ref$IntRef, this, endBlock, null), 2, null);
        this.c = d2;
    }
}
