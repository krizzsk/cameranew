package us.pinguo.inspire.util.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import vStudio.Android.Camera360.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RotationTransform.java */
@TargetApi(21)
/* loaded from: classes9.dex */
public class e extends Transition {
    public boolean a;

    public e(boolean z) {
        this.a = z;
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        if (h.a.g(transitionValues.view)) {
            transitionValues.values.put("video:rotation", Float.valueOf(0.0f));
        }
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        if (h.a.g(transitionValues.view)) {
            Object tag = transitionValues.view.getTag(R.id.tag_rotated);
            if (tag instanceof Float) {
                transitionValues.values.put("video:rotation", Float.valueOf(((Float) tag).floatValue()));
            }
        }
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues != null && h.a.g(transitionValues.view) && transitionValues.values.containsKey("video:rotation")) {
            float floatValue = ((Float) transitionValues.values.get("video:rotation")).floatValue();
            float floatValue2 = ((Float) transitionValues2.values.get("video:rotation")).floatValue();
            if (!this.a) {
                floatValue2 = floatValue;
                floatValue = floatValue2;
            }
            if (floatValue > 0.0f || floatValue2 > 0.0f) {
                return ObjectAnimator.ofFloat(transitionValues.view, Key.ROTATION, floatValue, floatValue2);
            }
            return null;
        }
        return null;
    }
}
