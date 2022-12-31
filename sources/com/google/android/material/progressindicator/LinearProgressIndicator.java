package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
/* loaded from: classes2.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int o = R.style.Widget_MaterialComponents_LinearProgressIndicator;

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    private void w() {
        setIndeterminateDrawable(i.r(getContext(), (LinearProgressIndicatorSpec) this.a));
        setProgressDrawable(e.t(getContext(), (LinearProgressIndicatorSpec) this.a));
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        S s = this.a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s;
        boolean z2 = true;
        if (((LinearProgressIndicatorSpec) s).f4429h != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((LinearProgressIndicatorSpec) this.a).f4429h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || ((LinearProgressIndicatorSpec) this.a).f4429h != 3))) {
            z2 = false;
        }
        linearProgressIndicatorSpec.f4430i = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        int paddingLeft = i2 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i3 - (getPaddingTop() + getPaddingBottom());
        i<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        e<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    public void setIndeterminateAnimationType(int i2) {
        if (((LinearProgressIndicatorSpec) this.a).f4428g == i2) {
            return;
        }
        if (u() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s = this.a;
        ((LinearProgressIndicatorSpec) s).f4428g = i2;
        ((LinearProgressIndicatorSpec) s).e();
        if (i2 == 0) {
            getIndeterminateDrawable().u(new k((LinearProgressIndicatorSpec) this.a));
        } else {
            getIndeterminateDrawable().u(new l(getContext(), (LinearProgressIndicatorSpec) this.a));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.a).e();
    }

    public void setIndicatorDirection(int i2) {
        S s = this.a;
        ((LinearProgressIndicatorSpec) s).f4429h = i2;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s;
        boolean z = true;
        if (i2 != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((LinearProgressIndicatorSpec) this.a).f4429h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || i2 != 3))) {
            z = false;
        }
        linearProgressIndicatorSpec.f4430i = z;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int i2, boolean z) {
        S s = this.a;
        if (s != 0 && ((LinearProgressIndicatorSpec) s).f4428g == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i2, z);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i2) {
        super.setTrackCornerRadius(i2);
        ((LinearProgressIndicatorSpec) this.a).e();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: v */
    public LinearProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, o);
        w();
    }
}
