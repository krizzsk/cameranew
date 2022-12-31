package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import com.google.android.material.R;
/* loaded from: classes2.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int o = R.style.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    private void w() {
        setIndeterminateDrawable(i.q(getContext(), (CircularProgressIndicatorSpec) this.a));
        setProgressDrawable(e.s(getContext(), (CircularProgressIndicatorSpec) this.a));
    }

    public void setIndicatorDirection(int i2) {
        ((CircularProgressIndicatorSpec) this.a).f4427i = i2;
        invalidate();
    }

    public void setIndicatorInset(@Px int i2) {
        S s = this.a;
        if (((CircularProgressIndicatorSpec) s).f4426h != i2) {
            ((CircularProgressIndicatorSpec) s).f4426h = i2;
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i2) {
        int max = Math.max(i2, n() * 2);
        S s = this.a;
        if (((CircularProgressIndicatorSpec) s).f4425g != max) {
            ((CircularProgressIndicatorSpec) s).f4425g = max;
            ((CircularProgressIndicatorSpec) s).e();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i2) {
        super.setTrackThickness(i2);
        ((CircularProgressIndicatorSpec) this.a).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: v */
    public CircularProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, o);
        w();
    }
}
