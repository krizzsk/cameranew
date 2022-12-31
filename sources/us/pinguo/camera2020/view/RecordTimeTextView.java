package us.pinguo.camera2020.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
/* loaded from: classes3.dex */
public class RecordTimeTextView extends AppCompatTextView implements us.pinguo.common.widget.f {
    private int a;
    private int b;

    public RecordTimeTextView(Context context) {
        super(context);
        this.a = -1;
        this.b = -1;
    }

    @Override // us.pinguo.common.widget.f
    public View getView() {
        return this;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        float b = us.pinguo.foundation.t.b.a.b(getResources(), 2.0f);
        int i2 = this.b;
        if (i2 == -1 || !us.pinguo.foundation.utils.l.c(i2)) {
            return;
        }
        setShadowLayer(b, 0.0f, 0.0f, -1627389952);
    }

    @Override // us.pinguo.common.widget.f
    public void setTheme(Resources.Theme theme) {
        Log.d("肤色", "id = " + getId());
        int i2 = this.a;
        if (i2 != -1) {
            us.pinguo.common.utils.j.a(this, theme, i2);
        }
        int i3 = this.b;
        if (i3 != -1) {
            us.pinguo.common.utils.j.c(this, theme, i3);
        }
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(new int[]{this.b});
        if (us.pinguo.foundation.utils.l.c(obtainStyledAttributes.getColorStateList(0).getDefaultColor())) {
            setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        } else {
            setShadowLayer(us.pinguo.foundation.t.b.a.b(getResources(), 2.0f), 0.0f, 0.0f, -1627389952);
        }
        obtainStyledAttributes.recycle();
    }

    public RecordTimeTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
        this.a = us.pinguo.common.utils.j.e(attributeSet);
        this.b = us.pinguo.common.utils.j.g(attributeSet);
    }

    public RecordTimeTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = -1;
        this.b = -1;
        this.a = us.pinguo.common.utils.j.e(attributeSet);
        this.b = us.pinguo.common.utils.j.g(attributeSet);
    }
}
