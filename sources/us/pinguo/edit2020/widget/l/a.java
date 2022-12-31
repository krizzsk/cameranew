package us.pinguo.edit2020.widget.l;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
/* compiled from: RoundOutlineProvider.kt */
/* loaded from: classes4.dex */
public final class a extends ViewOutlineProvider {
    private final float a;

    public a(float f2) {
        this.a = f2;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Rect rect = new Rect();
        if (view != null) {
            view.getGlobalVisibleRect(rect);
        }
        Rect rect2 = new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0);
        if (outline == null) {
            return;
        }
        outline.setRoundRect(rect2, this.a);
    }
}
