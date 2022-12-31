package us.pinguo.inspire.widget.progress;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
/* loaded from: classes9.dex */
public class RotateView extends ImageView {
    private ObjectAnimator a;

    public RotateView(Context context) {
        super(context);
    }

    private void a() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, Key.ROTATION, 0.0f, 1800.0f).setDuration(3400L);
        this.a = duration;
        duration.setRepeatCount(-1);
        this.a.setRepeatMode(1);
        this.a.setInterpolator(new LinearInterpolator());
    }

    public RotateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public RotateView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
