package us.pinguo.widget.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import us.pinguo.widget.common.widget.a;
/* loaded from: classes6.dex */
public class AutofitTextView extends AppCompatTextView implements a.d {
    private a a;

    public AutofitTextView(Context context) {
        super(context);
        c(context, null, 0);
    }

    private void c(Context context, AttributeSet attributeSet, int i2) {
        a e2 = a.e(this, attributeSet, i2);
        e2.b(this);
        this.a = e2;
    }

    @Override // us.pinguo.widget.common.widget.a.d
    public void a(float f2, float f3) {
    }

    public a b() {
        return this.a;
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        super.setLines(i2);
        a aVar = this.a;
        if (aVar != null) {
            aVar.m(i2);
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        super.setMaxLines(i2);
        a aVar = this.a;
        if (aVar != null) {
            aVar.m(i2);
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
        a aVar = this.a;
        if (aVar != null) {
            aVar.u(i2, f2);
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
        c(context, attributeSet, 0);
    }

    public AutofitTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet, i2);
    }
}
