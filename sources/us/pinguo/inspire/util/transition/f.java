package us.pinguo.inspire.util.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import us.pinguo.inspire.widget.photopager.InfoTouchImageView;
import us.pinguo.ui.widget.j;
import vStudio.Android.Camera360.R;
/* compiled from: TouchScaleFollowTransition.java */
@TargetApi(19)
/* loaded from: classes9.dex */
class f extends Transition {
    private boolean a;

    /* compiled from: TouchScaleFollowTransition.java */
    /* loaded from: classes9.dex */
    class a extends j {
        final /* synthetic */ InfoTouchImageView a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;

        a(f fVar, InfoTouchImageView infoTouchImageView, float f2, float f3) {
            this.a = infoTouchImageView;
            this.b = f2;
            this.c = f3;
        }

        @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setMinimumScale(this.b);
            this.a.setMaximumScale(this.c);
        }
    }

    public f(boolean z) {
        this.a = z;
    }

    private void a(TouchScaleInfo touchScaleInfo, TransitionValues transitionValues) {
        if (touchScaleInfo == null) {
            return;
        }
        float width = touchScaleInfo.bounds.width() / touchScaleInfo.bounds.height();
        int i2 = touchScaleInfo.workWidth;
        int i3 = touchScaleInfo.workHeight;
        float f2 = i2 / i3;
        if (f2 > 1.7777778f) {
            f2 = 1.7777778f;
        }
        if (i2 >= i3) {
            transitionValues.values.put("scale", Float.valueOf(f2 / width));
        } else {
            transitionValues.values.put("scale", Float.valueOf(1.0f));
        }
    }

    @Override // android.transition.Transition
    @SuppressLint({"NewApi"})
    public void captureEndValues(TransitionValues transitionValues) {
        if (transitionValues.view.getTag(R.id.tag_element_info) == null) {
            return;
        }
        TouchScaleInfo touchScaleInfo = (TouchScaleInfo) transitionValues.view.getTag(R.id.tag_element_info);
        if (!this.a) {
            a(touchScaleInfo, transitionValues);
        } else {
            transitionValues.values.put("scale", Float.valueOf(1.0f));
        }
    }

    @Override // android.transition.Transition
    @SuppressLint({"NewApi"})
    public void captureStartValues(TransitionValues transitionValues) {
        if (transitionValues.view.getTag(R.id.tag_element_info) == null) {
            return;
        }
        TouchScaleInfo touchScaleInfo = (TouchScaleInfo) transitionValues.view.getTag(R.id.tag_element_info);
        if (this.a) {
            a(touchScaleInfo, transitionValues);
        } else {
            transitionValues.values.put("scale", Float.valueOf(1.0f));
        }
    }

    @Override // android.transition.Transition
    @SuppressLint({"NewApi"})
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof InfoTouchImageView) || !transitionValues2.values.containsKey("scale")) {
            return null;
        }
        float floatValue = ((Float) (transitionValues.values.containsKey("scale") ? transitionValues.values.get("scale") : Float.valueOf(1.0f))).floatValue();
        float floatValue2 = ((Float) transitionValues2.values.get("scale")).floatValue();
        final InfoTouchImageView infoTouchImageView = (InfoTouchImageView) transitionValues2.view;
        float c = infoTouchImageView.c();
        float d2 = infoTouchImageView.d();
        float min = Math.min(floatValue, floatValue2);
        float max = Math.max(floatValue, floatValue2);
        if (min < d2) {
            infoTouchImageView.setMinimumScale(min - 0.01f);
        }
        if (max > max) {
            infoTouchImageView.setMaximumScale(max + 0.01f);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.util.transition.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                InfoTouchImageView infoTouchImageView2 = InfoTouchImageView.this;
                infoTouchImageView2.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue(), infoTouchImageView2.getWidth() / 2, infoTouchImageView2.getHeight() / 2, false);
            }
        });
        ofFloat.addListener(new a(this, infoTouchImageView, d2, c));
        return ofFloat;
    }
}
