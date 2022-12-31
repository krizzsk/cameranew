package us.pinguo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import us.pinguo.ui.widget.e;
/* loaded from: classes6.dex */
public class AutofitTextView extends AppCompatTextView implements e.d {
    private e a;

    public AutofitTextView(Context context) {
        super(context);
        b(context, null, 0);
    }

    private void b(Context context, AttributeSet attributeSet, int i2) {
        e e2 = e.e(this, attributeSet, i2);
        e2.b(this);
        this.a = e2;
    }

    @Override // us.pinguo.ui.widget.e.d
    public void a(float f2, float f3) {
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        super.setLines(i2);
        e eVar = this.a;
        if (eVar != null) {
            eVar.m(i2);
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        super.setMaxLines(i2);
        e eVar = this.a;
        if (eVar != null) {
            eVar.m(i2);
        }
    }

    public void setMaxTextSize(float f2) {
        this.a.n(f2);
    }

    public void setMinTextSize(int i2) {
        this.a.p(2, i2);
    }

    public void setPrecision(float f2) {
        this.a.q(f2);
    }

    public void setSizeToFit() {
        setSizeToFit(true);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i2, float f2) {
        super.setTextSize(i2, f2);
        e eVar = this.a;
        if (eVar != null) {
            eVar.u(i2, f2);
        }
    }

    public void setMaxTextSize(int i2, float f2) {
        this.a.o(i2, f2);
    }

    public void setMinTextSize(int i2, float f2) {
        this.a.p(i2, f2);
    }

    public void setSizeToFit(boolean z) {
        this.a.l(z);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet, i2);
    }
}
