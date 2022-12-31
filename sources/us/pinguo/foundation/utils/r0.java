package us.pinguo.foundation.utils;

import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: ViewUtils.java */
/* loaded from: classes4.dex */
public class r0 {

    /* compiled from: ViewUtils.java */
    /* loaded from: classes4.dex */
    class a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ boolean b;

        a(View view, boolean z) {
            this.a = view;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setClickable(this.b);
        }
    }

    static {
        Color.rgb(171, 178, 186);
        Color.rgb(112, 125, 120);
    }

    public static void a(View view) {
        b(view, 0.0f, 1.0f, 400L, null);
    }

    public static void b(View view, float f2, float f3, long j2, Animation.AnimationListener animationListener) {
        if (view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        if (animationListener != null) {
            alphaAnimation.setAnimationListener(animationListener);
        }
        alphaAnimation.setDuration(j2);
        view.startAnimation(alphaAnimation);
    }

    public static void c(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400L);
        view.startAnimation(alphaAnimation);
        view.setVisibility(4);
        VdsAgent.onSetViewVisibility(view, 4);
    }

    public static void d(View view, boolean z, int i2) {
        new Handler().postDelayed(new a(view, z), i2);
    }
}
