package com.pinguo.camera360.gallery.ui.toolbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.widget.Toolbar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PgToolBar extends Toolbar {
    protected View a;
    protected View b;
    private List<View> c;

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f6646d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f6647e;

    /* renamed from: f  reason: collision with root package name */
    private TranslateAnimation f6648f;

    /* renamed from: g  reason: collision with root package name */
    private TranslateAnimation f6649g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends us.pinguo.foundation.ui.b {
        a() {
        }

        @Override // us.pinguo.foundation.ui.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PgToolBar.this.setVisibility(4);
        }
    }

    public PgToolBar(Context context) {
        super(context);
        this.c = new ArrayList(2);
    }

    public View a() {
        return this.a;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        this.c.add(view);
    }

    public void b() {
        for (View view : this.c) {
            super.removeView(view);
        }
        this.c.clear();
    }

    public void c() {
        int k2 = us.pinguo.foundation.utils.o.b(getContext()) ? us.pinguo.foundation.t.b.a.k() : 0;
        if (getTranslationY() == 0.0f || getTranslationY() == (-getHeight()) + k2) {
            return;
        }
        setToolbarPropertyAnimVisibility(0);
    }

    @Override // android.view.View
    public void clearAnimation() {
        super.clearAnimation();
        ObjectAnimator objectAnimator = this.f6646d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f6647e;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        this.c.remove(view);
    }

    public void setBelowToolbarLayout(View view) {
        this.b = view;
    }

    public void setShaderView(View view) {
        this.a = view;
    }

    public void setToolbarPropertyAnimVisibility(int i2) {
        int i3;
        if (i2 == 0) {
            if (getTranslationY() != 0.0f) {
                i3 = (int) getTranslationY();
            } else {
                i3 = -getHeight();
            }
            us.pinguo.common.log.a.k("setToolbarAnimVisibility fromYDelta = " + i3 + " toYDelta = 0", new Object[0]);
            ObjectAnimator objectAnimator = this.f6647e;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", i3, 0);
            this.f6646d = ofFloat;
            ofFloat.setDuration(150L);
            if (!this.f6646d.isRunning() && getTranslationY() != 0.0f) {
                this.f6646d.start();
            } else {
                us.pinguo.common.log.a.k("return by mShowAnimation", new Object[0]);
                return;
            }
        }
        if (i2 != 0) {
            int translationY = getTranslationY() != 0.0f ? (int) getTranslationY() : 0;
            int i4 = -getHeight();
            ObjectAnimator objectAnimator2 = this.f6646d;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            if (this.f6647e == null) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "translationY", translationY, i4);
                this.f6647e = ofFloat2;
                ofFloat2.setDuration(150L);
            }
            us.pinguo.common.log.a.k("return by mHideAnimation.isRunning() = " + getTranslationY(), new Object[0]);
            if (this.f6647e.isRunning() || getTranslationY() == getHeight()) {
                return;
            }
            this.f6647e.start();
        }
    }

    public void setTopBarAnimVisibility(int i2) {
        if (i2 == 0) {
            int i3 = -getHeight();
            if (this.f6649g != null) {
                clearAnimation();
                this.f6649g.cancel();
            }
            if (this.f6648f == null) {
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i3, 0);
                this.f6648f = translateAnimation;
                translateAnimation.setDuration(150L);
                this.f6648f.setFillEnabled(true);
                this.f6648f.setFillAfter(true);
            }
            setVisibility(0);
            startAnimation(this.f6648f);
        }
        if (i2 != 0) {
            if (this.f6648f != null) {
                clearAnimation();
            }
            int i4 = -getHeight();
            if (this.f6649g == null) {
                TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0, i4);
                this.f6649g = translateAnimation2;
                translateAnimation2.setDuration(150L);
                this.f6649g.setFillEnabled(true);
                this.f6649g.setFillAfter(true);
                this.f6649g.setAnimationListener(new a());
            }
            startAnimation(this.f6649g);
        }
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        us.pinguo.common.log.a.k("FUCK setTranslationY = " + f2 + " height = " + getHeight(), new Object[0]);
        View view = this.b;
        if (view != null) {
            view.setTranslationY(f2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        VdsAgent.onSetViewVisibility(this, i2);
    }

    public PgToolBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList(2);
    }

    public PgToolBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new ArrayList(2);
    }
}
