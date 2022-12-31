package us.pinguo.camera2020.widget.multitheme.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.common.utils.j;
import us.pinguo.common.widget.f;
/* loaded from: classes3.dex */
public class ColorView extends View implements f {
    private int a;

    public ColorView(Context context) {
        super(context);
        this.a = -1;
    }

    @Override // us.pinguo.common.widget.f
    public View getView() {
        return this;
    }

    @Override // us.pinguo.common.widget.f
    public void setTheme(Resources.Theme theme) {
        int i2 = this.a;
        if (i2 != -1) {
            j.a(this, theme, i2);
        }
    }

    public ColorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        if (isInEditMode()) {
            return;
        }
        this.a = j.e(attributeSet);
    }

    public ColorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = -1;
        if (isInEditMode()) {
            return;
        }
        this.a = j.e(attributeSet);
    }
}
