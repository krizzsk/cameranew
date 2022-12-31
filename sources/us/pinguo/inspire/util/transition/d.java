package us.pinguo.inspire.util.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import vStudio.Android.Camera360.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RotationChangeBounds.java */
@TargetApi(21)
/* loaded from: classes9.dex */
public class d extends ChangeBounds {
    public boolean a;

    public d(boolean z) {
        this.a = z;
    }

    private void a(TransitionValues transitionValues) {
        Rect rect = (Rect) transitionValues.values.get("android:changeBounds:bounds");
        int width = rect.width();
        int height = rect.height();
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        int i2 = height / 2;
        int i3 = width / 2;
        rect.set(centerX - i2, centerY - i3, centerX + i2, centerY + i3);
    }

    @Override // android.transition.ChangeBounds, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        if (this.a || !h.a.g(transitionValues.view)) {
            return;
        }
        Object tag = transitionValues.view.getTag(R.id.tag_rotated);
        if ((tag instanceof Float) && ((Float) tag).floatValue() == 90.0f) {
            a(transitionValues);
        }
    }

    @Override // android.transition.ChangeBounds, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        if (this.a && h.a.g(transitionValues.view)) {
            Object tag = transitionValues.view.getTag(R.id.tag_rotated);
            if ((tag instanceof Float) && ((Float) tag).floatValue() == 90.0f) {
                a(transitionValues);
            }
        }
    }

    @Override // android.transition.ChangeBounds, android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float width;
        Animator createAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
        Rect rect = (Rect) transitionValues.values.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) transitionValues2.values.get("android:changeBounds:bounds");
        if (transitionValues.view.getId() != R.id.video_info_content || rect.equals(rect2)) {
            return createAnimator;
        }
        Object tag = transitionValues.view.getTag(R.id.tag_rotated);
        boolean z = (tag instanceof Float) && ((Float) tag).floatValue() == 90.0f;
        float f2 = 1.0f;
        if (this.a) {
            f2 = rect.width() / (z ? rect2.height() : rect2.width());
            width = 1.0f;
        } else {
            width = rect2.width() / (z ? rect.height() : rect.width());
        }
        View findViewById = transitionValues.view.findViewById(R.id.wdvv_video_video_view);
        View findViewById2 = transitionValues.view.findViewById(R.id.piv_photo_video_view);
        findViewById.setPivotX(0.0f);
        findViewById.setPivotY(0.0f);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", f2, width);
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", f2, width);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(findViewById, ofFloat, ofFloat2);
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(findViewById, ofFloat, ofFloat2);
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(findViewById2, ofFloat, ofFloat2);
        ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(findViewById2, ofFloat, ofFloat2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(createAnimator).with(ofPropertyValuesHolder).with(ofPropertyValuesHolder2).with(ofPropertyValuesHolder3).with(ofPropertyValuesHolder4);
        return animatorSet;
    }
}
