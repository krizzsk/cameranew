package us.pinguo.camera360.shop.cardsviewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import java.text.MessageFormat;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class StoreIndicatorTextView extends SimplePagerTitleView {
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private int f9570d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f9571e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f9572f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f9573g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9574h;

    /* renamed from: i  reason: collision with root package name */
    private RectF f9575i;

    public StoreIndicatorTextView(Context context) {
        super(context);
        this.c = false;
        this.f9573g = new Rect();
        this.f9574h = false;
        this.f9575i = new RectF();
        j();
    }

    private void j() {
        this.f9570d = n0.c(3);
        Paint paint = new Paint();
        this.f9571e = paint;
        paint.setColor(-635856);
        this.f9571e.setStyle(Paint.Style.FILL);
        this.f9571e.setAntiAlias(true);
        setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.store_scene_tab_text_size));
        Paint paint2 = new Paint();
        this.f9572f = paint2;
        paint2.setColor(-3789);
        this.f9572f.setStyle(Paint.Style.FILL);
        this.f9572f.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        canvas.getClipBounds(this.f9573g);
        if (this.f9574h) {
            float d2 = n0.d(8.0f);
            float d3 = n0.d(3.0f);
            float d4 = n0.d(6.0f);
            RectF rectF = this.f9575i;
            Rect rect = this.f9573g;
            rectF.set(rect.left + d3, rect.top + d4, rect.right - d3, rect.bottom - d4);
            canvas.drawRoundRect(this.f9575i, d2, d2, this.f9572f);
            getPaint().setFakeBoldText(this.f9574h);
        }
        if (this.c) {
            int e2 = e();
            int width = this.f9573g.left + getWidth();
            canvas.drawCircle(width - i2, e2 + i2, this.f9570d, this.f9571e);
        }
        super.onDraw(canvas);
    }

    public void setHasRedPoint(boolean z) {
        boolean z2 = this.c != z;
        this.c = z;
        us.pinguo.common.log.a.m("StoreIndicatorTextView", MessageFormat.format("redPoint mHasRedPoint={0},name={1}", Boolean.valueOf(z), getText()), new Object[0]);
        if (z2) {
            invalidate();
        }
    }

    public void setVipBackground(boolean z) {
        if (this.f9574h == z) {
            return;
        }
        this.f9574h = z;
        invalidate();
    }
}
