package us.pinguo.inspire.util.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.widget.photopager.InfoTouchImageView;
import us.pinguo.ui.widget.j;
import vStudio.Android.Camera360.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TouchScaleTransition.java */
@TargetApi(19)
/* loaded from: classes9.dex */
public class g extends Transition {
    private boolean a;

    /* compiled from: TouchScaleTransition.java */
    /* loaded from: classes9.dex */
    class a extends j {
        final /* synthetic */ InfoTouchImageView a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;

        a(g gVar, InfoTouchImageView infoTouchImageView, float f2, float f3) {
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

    public g(boolean z) {
        this.a = z;
    }

    private void a(InspireWork inspireWork, TransitionValues transitionValues) {
        if (inspireWork == null) {
            return;
        }
        if (inspireWork.getWidth() > inspireWork.getHeight()) {
            float width = inspireWork.getWidth() / inspireWork.getHeight();
            if (width > 1.3333334f) {
                transitionValues.values.put("scale", Float.valueOf(width / 1.3333334f));
                return;
            } else {
                transitionValues.values.put("scale", Float.valueOf(1.3333334f / width));
                return;
            }
        }
        float width2 = inspireWork.getWidth() / inspireWork.getHeight();
        if (width2 > 0.75f) {
            transitionValues.values.put("scale", Float.valueOf(width2 / 0.75f));
        }
    }

    @Override // android.transition.Transition
    @SuppressLint({"NewApi"})
    public void captureEndValues(TransitionValues transitionValues) {
        if (transitionValues.view.getTag(R.id.tag_inspire_work) == null) {
            return;
        }
        InspireWork inspireWork = (InspireWork) transitionValues.view.getTag(R.id.tag_inspire_work);
        if (!this.a) {
            a(inspireWork, transitionValues);
        } else {
            transitionValues.values.put("scale", Float.valueOf(1.0f));
        }
    }

    @Override // android.transition.Transition
    @SuppressLint({"NewApi"})
    public void captureStartValues(TransitionValues transitionValues) {
        if (transitionValues.view.getTag(R.id.tag_inspire_work) == null) {
            return;
        }
        InspireWork inspireWork = (InspireWork) transitionValues.view.getTag(R.id.tag_inspire_work);
        if (this.a) {
            a(inspireWork, transitionValues);
        } else {
            transitionValues.values.put("scale", Float.valueOf(1.0f));
        }
    }

    @Override // android.transition.Transition
    @SuppressLint({"NewApi"})
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues != null && transitionValues2 != null && (transitionValues.view instanceof InfoTouchImageView) && transitionValues.values.containsKey("scale") && transitionValues2.values.containsKey("scale")) {
            float floatValue = ((Float) transitionValues.values.get("scale")).floatValue();
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
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.util.transition.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    InfoTouchImageView infoTouchImageView2 = InfoTouchImageView.this;
                    infoTouchImageView2.setScale(((Float) valueAnimator.getAnimatedValue()).floatValue(), infoTouchImageView2.getWidth() / 2, infoTouchImageView2.getHeight() / 2, false);
                }
            });
            ofFloat.addListener(new a(this, infoTouchImageView, d2, c));
            return ofFloat;
        }
        return null;
    }
}
