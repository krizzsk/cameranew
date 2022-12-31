package us.pinguo.foundation.ui.mddialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes4.dex */
public class CustomView extends RelativeLayout {
    final int a;
    int b;
    boolean c;

    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = Color.parseColor("#E2E2E2");
        this.c = false;
    }

    @Override // android.view.View
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        this.c = false;
    }

    @Override // android.view.View
    protected void onAnimationStart() {
        super.onAnimationStart();
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setBackgroundColor(this.b);
        } else {
            setBackgroundColor(this.a);
        }
        invalidate();
    }
}
