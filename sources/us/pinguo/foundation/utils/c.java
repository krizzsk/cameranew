package us.pinguo.foundation.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: AnimUtils.java */
/* loaded from: classes4.dex */
public final class c {

    /* compiled from: AnimUtils.java */
    /* loaded from: classes4.dex */
    class a extends us.pinguo.foundation.ui.b {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // us.pinguo.foundation.ui.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.a;
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
        }
    }

    public static void a(View view, float f2, float f3, long j2, Animation.AnimationListener animationListener) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setDuration(j2);
        alphaAnimation.setAnimationListener(animationListener);
        view.startAnimation(alphaAnimation);
    }

    public static void b(View view) {
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        a(view, 0.0f, 1.0f, 200L, new us.pinguo.foundation.ui.b());
    }

    public static void c(View view) {
        a(view, 1.0f, 0.0f, 200L, new a(view));
    }
}
