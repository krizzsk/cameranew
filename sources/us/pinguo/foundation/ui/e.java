package us.pinguo.foundation.ui;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.R;
/* compiled from: RotateTextToast.java */
/* loaded from: classes4.dex */
public class e implements d {
    ViewGroup a;
    RotateLayout b;
    Handler c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11077d;

    /* renamed from: e  reason: collision with root package name */
    private View f11078e;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f11079f = new a();

    /* compiled from: RotateTextToast.java */
    /* loaded from: classes4.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RotateLayout rotateLayout;
            if (e.this.f11077d || (rotateLayout = e.this.b) == null) {
                return;
            }
            us.pinguo.foundation.utils.c.c(rotateLayout);
            e eVar = e.this;
            eVar.a.removeView(eVar.f11078e);
            e.this.b = null;
        }
    }

    public e(Activity activity, int i2, int i3) {
        c(activity, activity.getResources().getText(i2), i3);
    }

    private void c(Activity activity, CharSequence charSequence, int i2) {
        this.a = (ViewGroup) activity.getWindow().getDecorView();
        View inflate = activity.getLayoutInflater().inflate(R.layout.rotate_text_toast, this.a);
        this.f11078e = inflate;
        inflate.bringToFront();
        this.a.requestLayout();
        this.a.invalidate();
        RotateLayout rotateLayout = (RotateLayout) inflate.findViewById(R.id.rotate_toast);
        this.b = rotateLayout;
        ((TextView) rotateLayout.findViewById(R.id.message)).setText(charSequence);
        this.b.setOrientation(i2, false);
        this.c = new Handler();
    }

    public void d() {
        e(PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    public void e(int i2) {
        RotateLayout rotateLayout = this.b;
        rotateLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(rotateLayout, 0);
        this.f11077d = false;
        this.c.removeCallbacks(this.f11079f);
        this.c.postDelayed(this.f11079f, i2);
    }

    @Override // us.pinguo.foundation.ui.d
    public void setOrientation(int i2, boolean z) {
        RotateLayout rotateLayout = this.b;
        if (rotateLayout != null) {
            rotateLayout.setOrientation(i2, z);
        }
    }

    public e(Activity activity, CharSequence charSequence, int i2) {
        c(activity, charSequence, i2);
    }
}
