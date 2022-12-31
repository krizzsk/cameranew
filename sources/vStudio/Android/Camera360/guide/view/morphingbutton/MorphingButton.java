package vStudio.Android.Camera360.guide.view.morphingbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.widget.Button;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import vStudio.Android.Camera360.R;
/* loaded from: classes7.dex */
public class MorphingButton extends Button {
    private b a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f12640d;

    /* renamed from: e  reason: collision with root package name */
    private StrokeGradientDrawable f12641e;

    /* renamed from: f  reason: collision with root package name */
    private StrokeGradientDrawable f12642f;

    /* loaded from: classes7.dex */
    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = (MorphingButton.this.getWidth() / 2) - (MorphingButton.this.getResources().getDrawable(this.a).getIntrinsicWidth() / 2);
            MorphingButton.this.setCompoundDrawablesWithIntrinsicBounds(this.a, 0, 0, 0);
            MorphingButton.this.setPadding(width, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b {
        public int a;
        public int b;
        public int c;

        private b(MorphingButton morphingButton) {
        }

        /* synthetic */ b(MorphingButton morphingButton, vStudio.Android.Camera360.guide.view.morphingbutton.a aVar) {
            this(morphingButton);
        }
    }

    public MorphingButton(Context context) {
        super(context);
        b();
    }

    private StrokeGradientDrawable a(int i2, int i3, int i4) {
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(new GradientDrawable());
        strokeGradientDrawable.getGradientDrawable().setShape(0);
        strokeGradientDrawable.setColor(i2);
        strokeGradientDrawable.setCornerRadius(i3);
        strokeGradientDrawable.setStrokeColor(i2);
        strokeGradientDrawable.setStrokeWidth(i4);
        return strokeGradientDrawable;
    }

    private void b() {
        this.a = new b(this, null);
        getPaddingLeft();
        this.a.a = getPaddingRight();
        this.a.b = getPaddingTop();
        this.a.c = getPaddingBottom();
        Resources resources = getResources();
        int dimension = (int) resources.getDimension(R.dimen.mb_corner_radius_2);
        int color = resources.getColor(R.color.mb_blue);
        int color2 = resources.getColor(R.color.mb_blue_dark);
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f12641e = a(color, dimension, 0);
        StrokeGradientDrawable a2 = a(color2, dimension, 0);
        this.f12642f = a2;
        stateListDrawable.addState(new int[]{16842919}, a2.getGradientDrawable());
        stateListDrawable.addState(StateSet.WILD_CARD, this.f12641e.getGradientDrawable());
        c(stateListDrawable);
    }

    private void c(@Nullable Drawable drawable) {
        if (Build.VERSION.SDK_INT <= 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.b != 0 || this.c != 0 || i2 == 0 || i3 == 0) {
            return;
        }
        this.b = getHeight();
        this.c = getWidth();
    }

    public void setIcon(@DrawableRes int i2) {
        post(new a(i2));
    }

    public void setIconLeft(@DrawableRes int i2) {
        setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
    }

    public MorphingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public MorphingButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
