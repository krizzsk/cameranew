package vStudio.Android.Camera360.home.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import us.pinguo.common.imageloader.widget.ImageLoaderView;
import vStudio.Android.Camera360.R;
/* loaded from: classes7.dex */
public class RoundedImageViewAdv extends ImageLoaderView {
    private static final ImageView.ScaleType[] n = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: d  reason: collision with root package name */
    private float f12655d;

    /* renamed from: e  reason: collision with root package name */
    private float f12656e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f12657f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12658g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12659h;

    /* renamed from: i  reason: collision with root package name */
    private int f12660i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f12661j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f12662k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView.ScaleType f12663l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageViewAdv(Context context) {
        super(context);
        this.f12655d = 0.0f;
        this.f12656e = 0.0f;
        this.f12657f = ColorStateList.valueOf(-1);
        this.f12658g = false;
        this.f12659h = false;
        this.m = true;
    }

    private Drawable b() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.f12660i;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w("RoundedImageViewAdv", "Unable to find resource: " + this.f12660i, e2);
                this.f12660i = 0;
            }
        }
        return b.c(drawable);
    }

    private void c(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof b) {
            b bVar = (b) drawable;
            bVar.h(this.f12663l);
            bVar.f(this.f12655d);
            bVar.e(this.f12656e);
            bVar.d(this.f12657f);
            bVar.g(this.f12658g);
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                c(layerDrawable.getDrawable(i2));
            }
        }
    }

    private void d(boolean z) {
        if (this.f12659h) {
            if (z) {
                this.f12662k = b.c(this.f12662k);
            }
            c(this.f12662k);
        }
    }

    private void e() {
        c(this.f12661j);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f12663l;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.m) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
            super.onMeasure(makeMeasureSpec, makeMeasureSpec);
            return;
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f12662k = drawable;
        d(true);
        super.setBackgroundDrawable(this.f12662k);
    }

    public void setBorderColor(int i2) {
        setBorderColor(ColorStateList.valueOf(i2));
    }

    public void setBorderWidth(int i2) {
        setBorderWidth(getResources().getDimension(i2));
    }

    public void setCornerRadius(int i2) {
        setCornerRadius(getResources().getDimension(i2));
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f12660i = 0;
        this.f12661j = b.b(bitmap);
        e();
        super.setImageDrawable(this.f12661j);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f12660i = 0;
        this.f12661j = b.c(drawable);
        e();
        super.setImageDrawable(this.f12661j);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        if (this.f12660i != i2) {
            this.f12660i = i2;
            this.f12661j = b();
            e();
            super.setImageDrawable(this.f12661j);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setMutateBackground(boolean z) {
        if (this.f12659h == z) {
            return;
        }
        this.f12659h = z;
        d(true);
        invalidate();
    }

    public void setOval(boolean z) {
        this.f12658g = z;
        e();
        d(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.f12663l != scaleType) {
            this.f12663l = scaleType;
            switch (a.a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            e();
            d(false);
            invalidate();
        }
    }

    public void setText(String str) {
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f12657f.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-1);
        }
        this.f12657f = colorStateList;
        e();
        d(false);
        if (this.f12656e > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f2) {
        if (this.f12656e == f2) {
            return;
        }
        this.f12656e = f2;
        e();
        d(false);
        invalidate();
    }

    public void setCornerRadius(float f2) {
        if (this.f12655d == f2) {
            return;
        }
        this.f12655d = f2;
        e();
        d(false);
    }

    public RoundedImageViewAdv(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageViewAdv(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12655d = 0.0f;
        this.f12656e = 0.0f;
        this.f12657f = ColorStateList.valueOf(-1);
        this.f12658g = false;
        this.f12659h = false;
        this.m = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedImageViewAdv, i2, 0);
        int i3 = obtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0) {
            setScaleType(n[i3]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.f12655d = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        this.f12656e = obtainStyledAttributes.getDimensionPixelSize(5, -1);
        this.m = obtainStyledAttributes.getBoolean(6, true);
        if (this.f12655d < 0.0f) {
            this.f12655d = 0.0f;
        }
        if (this.f12656e < 0.0f) {
            this.f12656e = 0.0f;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(4);
        this.f12657f = colorStateList;
        if (colorStateList == null) {
            this.f12657f = ColorStateList.valueOf(-1);
        }
        this.f12659h = obtainStyledAttributes.getBoolean(2, false);
        this.f12658g = obtainStyledAttributes.getBoolean(3, false);
        e();
        d(true);
        obtainStyledAttributes.recycle();
    }
}
