package us.pinguo.inspire.widget.quicksidebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
import java.util.List;
import us.pinguo.inspire.widget.quicksidebar.a.a;
import us.pinguo.user.R;
/* loaded from: classes4.dex */
public class QuickSideBarView extends View {
    private a a;
    private List<String> b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f11439d;

    /* renamed from: e  reason: collision with root package name */
    private float f11440e;

    /* renamed from: f  reason: collision with root package name */
    private float f11441f;

    /* renamed from: g  reason: collision with root package name */
    private int f11442g;

    /* renamed from: h  reason: collision with root package name */
    private int f11443h;

    /* renamed from: i  reason: collision with root package name */
    private int f11444i;

    /* renamed from: j  reason: collision with root package name */
    private int f11445j;

    /* renamed from: k  reason: collision with root package name */
    private float f11446k;

    /* renamed from: l  reason: collision with root package name */
    private float f11447l;

    public QuickSideBarView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.b = Arrays.asList(context.getResources().getStringArray(R.array.quickSideBarLetters));
        this.f11442g = context.getResources().getColor(17170444);
        this.f11443h = context.getResources().getColor(17170444);
        this.f11440e = context.getResources().getDimensionPixelSize(R.dimen.textSize_quicksidebar);
        this.f11441f = context.getResources().getDimensionPixelSize(R.dimen.textSize_quicksidebar_choose);
        this.f11446k = context.getResources().getDimension(R.dimen.height_quicksidebaritem);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QuickSideBarView);
            this.f11442g = obtainStyledAttributes.getColor(R.styleable.QuickSideBarView_sidebarTextColor, this.f11442g);
            this.f11443h = obtainStyledAttributes.getColor(R.styleable.QuickSideBarView_sidebarTextColorChoose, this.f11443h);
            this.f11440e = obtainStyledAttributes.getDimension(R.styleable.QuickSideBarView_sidebarTextSize, this.f11440e);
            this.f11441f = obtainStyledAttributes.getDimension(R.styleable.QuickSideBarView_sidebarTextSizeChoose, this.f11441f);
            this.f11446k = obtainStyledAttributes.getDimension(R.styleable.QuickSideBarView_sidebarItemHeight, this.f11446k);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar;
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i2 = this.c;
        int i3 = (int) ((y - this.f11447l) / this.f11446k);
        if (action != 1) {
            if (i2 != i3) {
                if (i3 >= 0 && i3 < this.b.size()) {
                    this.c = i3;
                    if (this.a != null) {
                        Rect rect = new Rect();
                        this.f11439d.getTextBounds(this.b.get(this.c), 0, this.b.get(this.c).length(), rect);
                        float f2 = this.f11446k;
                        this.a.V(this.b.get(i3), this.c, (this.c * f2) + ((int) ((f2 - rect.height()) * 0.5d)) + this.f11447l);
                    }
                }
                invalidate();
            }
            if (motionEvent.getAction() == 3) {
                a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.e(false);
                }
            } else if (motionEvent.getAction() == 0 && (aVar = this.a) != null) {
                aVar.e(true);
            }
        } else {
            this.c = -1;
            a aVar3 = this.a;
            if (aVar3 != null) {
                aVar3.e(false);
            }
            invalidate();
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            this.f11439d.setColor(this.f11442g);
            this.f11439d.setAntiAlias(true);
            this.f11439d.setTextSize(this.f11440e);
            if (i2 == this.c) {
                this.f11439d.setColor(this.f11443h);
                this.f11439d.setFakeBoldText(true);
                this.f11439d.setTypeface(Typeface.DEFAULT_BOLD);
                this.f11439d.setTextSize(this.f11441f);
            }
            Rect rect = new Rect();
            this.f11439d.getTextBounds(this.b.get(i2), 0, this.b.get(i2).length(), rect);
            float f2 = this.f11446k;
            float height = (i2 * f2) + ((int) ((f2 - rect.height()) * 0.5d)) + this.f11447l;
            canvas.drawText(this.b.get(i2), (int) ((this.f11444i - rect.width()) * 0.5d), height, this.f11439d);
            this.f11439d.reset();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f11445j = getMeasuredHeight();
        this.f11444i = getMeasuredWidth();
        this.f11447l = (this.f11445j - (this.b.size() * this.f11446k)) / 2.0f;
    }

    public void setLetters(List<String> list) {
        this.b = list;
        invalidate();
    }

    public void setOnQuickSideBarTouchListener(a aVar) {
        this.a = aVar;
    }

    public QuickSideBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuickSideBarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = -1;
        this.f11439d = new Paint();
        a(context, attributeSet);
    }
}
