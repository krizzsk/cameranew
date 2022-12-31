package us.pinguo.inspire.widget.quicksidebar.tipsview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.user.R;
/* loaded from: classes4.dex */
public class QuickSideBarTipsItemView extends View {
    private int a;
    private Path b;
    private RectF c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f11448d;

    /* renamed from: e  reason: collision with root package name */
    private String f11449e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f11450f;

    /* renamed from: g  reason: collision with root package name */
    private int f11451g;

    /* renamed from: h  reason: collision with root package name */
    private int f11452h;

    /* renamed from: i  reason: collision with root package name */
    private float f11453i;

    /* renamed from: j  reason: collision with root package name */
    private int f11454j;

    /* renamed from: k  reason: collision with root package name */
    private int f11455k;

    /* renamed from: l  reason: collision with root package name */
    private int f11456l;
    private int m;

    public QuickSideBarTipsItemView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f11454j = context.getResources().getColor(17170444);
        this.f11455k = context.getResources().getColor(17170432);
        this.f11453i = context.getResources().getDimension(R.dimen.textSize_quicksidebartips);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QuickSideBarView);
            this.f11454j = obtainStyledAttributes.getColor(R.styleable.QuickSideBarView_sidebarTextColor, this.f11454j);
            this.f11455k = obtainStyledAttributes.getColor(R.styleable.QuickSideBarView_sidebarBackgroundColor, this.f11455k);
            this.f11453i = obtainStyledAttributes.getDimension(R.styleable.QuickSideBarView_sidebarTextSize, this.f11453i);
            obtainStyledAttributes.recycle();
        }
        this.f11448d = new Paint(1);
        this.f11450f = new Paint(1);
        this.f11448d.setColor(this.f11455k);
        this.f11450f.setColor(this.f11454j);
        this.f11450f.setTextSize(this.f11453i);
    }

    @TargetApi(17)
    public boolean b() {
        return Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float[] fArr;
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.f11449e)) {
            return;
        }
        canvas.drawColor(getResources().getColor(17170445));
        this.c.set(0.0f, 0.0f, this.f11451g, this.f11452h);
        if (b()) {
            int i2 = this.a;
            fArr = new float[]{i2, i2, i2, i2, i2, i2, 0.0f, 0.0f};
        } else {
            int i3 = this.a;
            fArr = new float[]{i3, i3, i3, i3, 0.0f, 0.0f, i3, i3};
        }
        this.b.addRoundRect(this.c, fArr, Path.Direction.CW);
        canvas.drawPath(this.b, this.f11448d);
        canvas.drawText(this.f11449e, this.f11456l, this.m, this.f11450f);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int width = getWidth();
        this.f11451g = width;
        this.f11452h = width;
        this.a = (int) (width * 0.5d);
    }

    public void setText(String str) {
        this.f11449e = str;
        Rect rect = new Rect();
        Paint paint = this.f11450f;
        String str2 = this.f11449e;
        paint.getTextBounds(str2, 0, str2.length(), rect);
        this.f11456l = (int) ((this.f11451g - rect.width()) * 0.5d);
        this.m = this.f11452h - rect.height();
        invalidate();
    }

    public QuickSideBarTipsItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuickSideBarTipsItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new Path();
        this.c = new RectF();
        this.f11449e = "";
        a(context, attributeSet);
    }
}
