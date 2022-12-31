package us.pinguo.common.filter.guide;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import java.util.Objects;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: GuideUtil.kt */
/* loaded from: classes4.dex */
public final class d {
    public static final void a(ImageView imageView, @ColorInt int i2) {
        Drawable drawable = imageView == null ? null : imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        if (i2 != 0) {
            drawable.setTintList(null);
            drawable.setTint(i2);
            return;
        }
        drawable.setTintList(null);
    }

    public static final void c(final ImageView imageView, int i2, int i3, long j2, long j3, final l<? super Float, u> lVar) {
        s.h(imageView, "imageView");
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.common.filter.guide.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.e(l.this, imageView, valueAnimator);
            }
        });
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setDuration(j2);
        ofInt.setStartDelay(j3);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(l lVar, ImageView imageView, ValueAnimator valueAnimator) {
        s.h(imageView, "$imageView");
        if (lVar != null) {
            lVar.invoke(Float.valueOf(valueAnimator.getAnimatedFraction()));
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        a(imageView, ((Integer) animatedValue).intValue());
    }
}
