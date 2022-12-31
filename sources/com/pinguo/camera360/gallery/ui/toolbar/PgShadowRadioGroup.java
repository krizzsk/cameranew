package com.pinguo.camera360.gallery.ui.toolbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class PgShadowRadioGroup extends RadioGroup {
    protected View a;
    private ObjectAnimator b;
    private ObjectAnimator c;

    public PgShadowRadioGroup(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.c;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    @Override // android.view.View
    public void setAlpha(float f2) {
        super.setAlpha(f2);
        this.a.setAlpha(f2);
    }

    public void setBottomBarAnimVisibility(int i2) {
        if (i2 == 0) {
            ObjectAnimator objectAnimator = this.c;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
            this.b = ofFloat;
            ofFloat.setInterpolator(new FastOutSlowInInterpolator());
            this.b.setDuration(375L);
            if (!this.b.isRunning() && getAlpha() != 1.0f) {
                this.b.start();
            } else {
                us.pinguo.common.log.a.k("return by mBottomBarShowAnimation", new Object[0]);
                return;
            }
        }
        if (i2 != 0) {
            ObjectAnimator objectAnimator2 = this.b;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            if (this.c == null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
                this.c = ofFloat2;
                ofFloat2.setInterpolator(new FastOutSlowInInterpolator());
                this.c.setDuration(375L);
            }
            if (this.c.isRunning() || getAlpha() == 0.0f) {
                return;
            }
            this.c.start();
        }
    }

    public void setShaderView(View view) {
        this.a = view;
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        this.a.setTranslationY(f2);
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
        View view = this.a;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    @Override // android.view.View
    public void startAnimation(Animation animation) {
        ((RelativeLayout) getParent()).startAnimation(animation);
    }

    public PgShadowRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
