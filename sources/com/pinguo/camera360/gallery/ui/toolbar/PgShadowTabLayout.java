package com.pinguo.camera360.gallery.ui.toolbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.tabs.TabLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class PgShadowTabLayout extends TabLayout {
    protected View Q;
    private ObjectAnimator R;
    private ObjectAnimator S;

    public PgShadowTabLayout(Context context) {
        super(context);
    }

    public void U() {
        if (getTranslationY() == 0.0f || getTranslationY() == getHeight()) {
            return;
        }
        setBottomBarAnimVisibility(0);
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        ObjectAnimator objectAnimator = this.R;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.S;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    @Override // android.view.View
    public void setAlpha(float f2) {
        super.setAlpha(f2);
        View view = this.Q;
        if (view != null) {
            view.setAlpha(f2);
        }
    }

    public void setBottomBarAnimVisibility(int i2) {
        if (i2 == 0) {
            ObjectAnimator objectAnimator = this.S;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", getAlpha(), 1.0f);
            this.R = ofFloat;
            ofFloat.setInterpolator(new FastOutSlowInInterpolator());
            this.R.setDuration(375L);
            if (!this.R.isRunning() && getAlpha() != 1.0f) {
                this.R.start();
            } else {
                us.pinguo.common.log.a.k("return by mBottomBarShowAnimation", new Object[0]);
                return;
            }
        }
        if (i2 != 0) {
            ObjectAnimator objectAnimator2 = this.R;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            if (this.S == null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "alpha", getAlpha(), 0.0f);
                this.S = ofFloat2;
                ofFloat2.setInterpolator(new FastOutSlowInInterpolator());
                this.S.setDuration(375L);
            }
            if (this.S.isRunning() || getAlpha() == 0.0f) {
                return;
            }
            this.S.start();
        }
    }

    public void setShaderView(View view) {
        this.Q = view;
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        View view = this.Q;
        if (view != null) {
            view.setTranslationY(f2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        if (i2 == 0) {
            setEnabled(true);
        } else {
            setEnabled(false);
        }
        super.setVisibility(i2);
        VdsAgent.onSetViewVisibility(this, i2);
        View view = this.Q;
        if (view != null) {
            view.setVisibility(i2);
            VdsAgent.onSetViewVisibility(view, i2);
        }
    }

    @Override // android.view.View
    public void startAnimation(Animation animation) {
        ((RelativeLayout) getParent()).startAnimation(animation);
    }

    public PgShadowTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PgShadowTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
