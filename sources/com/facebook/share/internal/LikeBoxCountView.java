package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.R;
@Deprecated
/* loaded from: classes.dex */
public class LikeBoxCountView extends FrameLayout {
    private TextView a;
    private LikeBoxCountViewCaretPosition b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f3194d;

    /* renamed from: e  reason: collision with root package name */
    private float f3195e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f3196f;

    /* renamed from: g  reason: collision with root package name */
    private int f3197g;

    /* renamed from: h  reason: collision with root package name */
    private int f3198h;

    /* loaded from: classes.dex */
    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LikeBoxCountViewCaretPosition.values().length];
            a = iArr;
            try {
                iArr[LikeBoxCountViewCaretPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LikeBoxCountViewCaretPosition.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[LikeBoxCountViewCaretPosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[LikeBoxCountViewCaretPosition.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        this.b = LikeBoxCountViewCaretPosition.LEFT;
        b(context);
    }

    private void a(Canvas canvas, float f2, float f3, float f4, float f5) {
        Path path = new Path();
        float f6 = this.f3195e * 2.0f;
        float f7 = f2 + f6;
        float f8 = f3 + f6;
        path.addArc(new RectF(f2, f3, f7, f8), -180.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.TOP) {
            float f9 = f4 - f2;
            path.lineTo(((f9 - this.f3194d) / 2.0f) + f2, f3);
            path.lineTo((f9 / 2.0f) + f2, f3 - this.c);
            path.lineTo(((f9 + this.f3194d) / 2.0f) + f2, f3);
        }
        path.lineTo(f4 - this.f3195e, f3);
        float f10 = f4 - f6;
        path.addArc(new RectF(f10, f3, f4, f8), -90.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.RIGHT) {
            float f11 = f5 - f3;
            path.lineTo(f4, ((f11 - this.f3194d) / 2.0f) + f3);
            path.lineTo(this.c + f4, (f11 / 2.0f) + f3);
            path.lineTo(f4, ((f11 + this.f3194d) / 2.0f) + f3);
        }
        path.lineTo(f4, f5 - this.f3195e);
        float f12 = f5 - f6;
        path.addArc(new RectF(f10, f12, f4, f5), 0.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.BOTTOM) {
            float f13 = f4 - f2;
            path.lineTo(((this.f3194d + f13) / 2.0f) + f2, f5);
            path.lineTo((f13 / 2.0f) + f2, this.c + f5);
            path.lineTo(((f13 - this.f3194d) / 2.0f) + f2, f5);
        }
        path.lineTo(this.f3195e + f2, f5);
        path.addArc(new RectF(f2, f12, f7, f5), 90.0f, 90.0f);
        if (this.b == LikeBoxCountViewCaretPosition.LEFT) {
            float f14 = f5 - f3;
            path.lineTo(f2, ((this.f3194d + f14) / 2.0f) + f3);
            path.lineTo(f2 - this.c, (f14 / 2.0f) + f3);
            path.lineTo(f2, ((f14 - this.f3194d) / 2.0f) + f3);
        }
        path.lineTo(f2, f3 + this.f3195e);
        canvas.drawPath(path, this.f3196f);
    }

    private void b(Context context) {
        setWillNotDraw(false);
        this.c = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_height);
        this.f3194d = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_caret_width);
        this.f3195e = getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_radius);
        Paint paint = new Paint();
        this.f3196f = paint;
        paint.setColor(getResources().getColor(R.color.com_facebook_likeboxcountview_border_color));
        this.f3196f.setStrokeWidth(getResources().getDimension(R.dimen.com_facebook_likeboxcountview_border_width));
        this.f3196f.setStyle(Paint.Style.STROKE);
        c(context);
        addView(this.a);
        setCaretPosition(this.b);
    }

    private void c(Context context) {
        this.a = new TextView(context);
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.a.setGravity(17);
        this.a.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeboxcountview_text_size));
        this.a.setTextColor(getResources().getColor(R.color.com_facebook_likeboxcountview_text_color));
        this.f3197g = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_text_padding);
        this.f3198h = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeboxcountview_caret_height);
    }

    private void d(int i2, int i3, int i4, int i5) {
        TextView textView = this.a;
        int i6 = this.f3197g;
        textView.setPadding(i2 + i6, i3 + i6, i4 + i6, i6 + i5);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int i2 = a.a[this.b.ordinal()];
        if (i2 == 1) {
            paddingLeft = (int) (paddingLeft + this.c);
        } else if (i2 == 2) {
            paddingTop = (int) (paddingTop + this.c);
        } else if (i2 == 3) {
            width = (int) (width - this.c);
        } else if (i2 == 4) {
            height = (int) (height - this.c);
        }
        a(canvas, paddingLeft, paddingTop, width, height);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.b = likeBoxCountViewCaretPosition;
        int i2 = a.a[likeBoxCountViewCaretPosition.ordinal()];
        if (i2 == 1) {
            d(this.f3198h, 0, 0, 0);
        } else if (i2 == 2) {
            d(0, this.f3198h, 0, 0);
        } else if (i2 == 3) {
            d(0, 0, this.f3198h, 0);
        } else if (i2 != 4) {
        } else {
            d(0, 0, 0, this.f3198h);
        }
    }

    @Deprecated
    public void setText(String str) {
        this.a.setText(str);
    }
}
