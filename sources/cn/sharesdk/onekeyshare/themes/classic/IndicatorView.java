package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public class IndicatorView extends View {
    private static final int DESIGN_BOTTOM_HEIGHT = 52;
    private static final int DESIGN_INDICATOR_DISTANCE = 14;
    private static final int DESIGN_INDICATOR_RADIUS = 6;
    private int count;
    private int current;

    public IndicatorView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        if (this.count <= 1) {
            setVisibility(8);
            VdsAgent.onSetViewVisibility(this, 8);
            return;
        }
        float height = getHeight();
        float f2 = (6.0f * height) / 52.0f;
        float f3 = (14.0f * height) / 52.0f;
        float f4 = f2 * 2.0f;
        float width = (getWidth() - ((this.count * f4) + ((i2 - 1) * f3))) / 2.0f;
        float f5 = height / 2.0f;
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        for (int i3 = 0; i3 < this.count; i3++) {
            if (i3 == this.current) {
                paint.setColor(-10653280);
            } else {
                paint.setColor(-5262921);
            }
            canvas.drawCircle(((f4 + f3) * i3) + width, f5, f2, paint);
        }
    }

    public void onScreenChange(int i2, int i3) {
        if (i2 != this.current) {
            this.current = i2;
            postInvalidate();
        }
    }

    public void setScreenCount(int i2) {
        this.count = i2;
    }
}
