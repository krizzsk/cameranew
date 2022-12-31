package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class MagicIndicator extends FrameLayout {
    private net.lucode.hackware.magicindicator.c.a a;

    public MagicIndicator(Context context) {
        super(context);
    }

    public void a(int i2) {
        net.lucode.hackware.magicindicator.c.a aVar = this.a;
        if (aVar != null) {
            aVar.onPageScrollStateChanged(i2);
        }
    }

    public void b(int i2, float f2, int i3) {
        net.lucode.hackware.magicindicator.c.a aVar = this.a;
        if (aVar != null) {
            aVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void c(int i2) {
        net.lucode.hackware.magicindicator.c.a aVar = this.a;
        if (aVar != null) {
            aVar.onPageSelected(i2);
        }
    }

    public void setNavigator(net.lucode.hackware.magicindicator.c.a aVar) {
        net.lucode.hackware.magicindicator.c.a aVar2 = this.a;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.f();
        }
        this.a = aVar;
        removeAllViews();
        if (this.a instanceof View) {
            addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
            this.a.e();
        }
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
