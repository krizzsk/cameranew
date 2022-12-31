package us.pinguo.widget.discreteseekbar.internal.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.TextView;
/* compiled from: SeekBarCompatDontCrash.java */
@TargetApi(21)
/* loaded from: classes6.dex */
class d {

    /* compiled from: SeekBarCompatDontCrash.java */
    /* loaded from: classes6.dex */
    static class a extends ViewOutlineProvider {
        final /* synthetic */ us.pinguo.widget.discreteseekbar.internal.b.b a;

        a(us.pinguo.widget.discreteseekbar.internal.b.b bVar) {
            this.a = bVar;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            try {
                outline.setConvexPath(this.a.q());
            } catch (Exception unused) {
            }
        }
    }

    public static Drawable a(ColorStateList colorStateList) {
        return new RippleDrawable(colorStateList, null, null);
    }

    public static boolean b(View view) {
        return view.isHardwareAccelerated();
    }

    public static boolean c(ViewParent viewParent) {
        while (viewParent != null && (viewParent instanceof ViewGroup)) {
            if (((ViewGroup) viewParent).shouldDelayChildPressedState()) {
                return true;
            }
            viewParent = viewParent.getParent();
        }
        return false;
    }

    public static void d(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void e(View view, us.pinguo.widget.discreteseekbar.internal.b.b bVar) {
        view.setOutlineProvider(new a(bVar));
    }

    public static void f(TextView textView, int i2) {
        textView.setTextDirection(i2);
    }
}
