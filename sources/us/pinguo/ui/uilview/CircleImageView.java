package us.pinguo.ui.uilview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.c;
import us.pinguo.foundation.t.a.c;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class CircleImageView extends PhotoImageView {
    private int a;
    private int b;
    private Rect c;

    /* renamed from: d  reason: collision with root package name */
    private int f12097d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f12098e;

    /* renamed from: f  reason: collision with root package name */
    private int f12099f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12100g;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.foundation.t.a.c f12101h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12102i;

    public CircleImageView(Context context) {
        super(context);
        this.c = new Rect();
        this.f12097d = 0;
        this.f12100g = false;
    }

    private void b(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        if (this.mImageViewAware == null) {
            this.mImageViewAware = new com.nostra13.universalimageloader.core.j.b(this);
        }
        this.f12097d = 0;
        us.pinguo.foundation.t.a.c.d(bitmap, this.mImageViewAware, this.a, this.b);
    }

    private void c(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        if (this.mImageViewAware == null) {
            this.mImageViewAware = new com.nostra13.universalimageloader.core.j.b(this);
        }
        this.f12097d = 0;
        us.pinguo.foundation.t.a.c.e(bitmap, this.mImageViewAware, this.a, this.b);
    }

    @Override // us.pinguo.ui.uilview.UilImageView
    protected void defaultDrawableLoaded(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            this.f12101h.display(((BitmapDrawable) drawable).getBitmap(), this.mImageViewAware, LoadedFrom.DISC_CACHE);
        }
    }

    @Override // android.view.View
    protected void dispatchSetPressed(boolean z) {
        super.dispatchSetPressed(z);
        invalidate();
    }

    public Bitmap getBitmap() {
        us.pinguo.foundation.t.a.c cVar = this.f12101h;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, us.pinguo.ui.uilview.UilImageView
    public void init(AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.f12098e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f12098e.setAntiAlias(true);
        this.mImageViewAware = new com.nostra13.universalimageloader.core.j.b(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.civ);
            this.a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.civ_civ_border_width, us.pinguo.foundation.t.b.a.a(getContext(), 2.0f));
            this.b = obtainStyledAttributes.getColor(R.styleable.civ_civ_border_color, -1);
            this.f12099f = obtainStyledAttributes.getColor(R.styleable.civ_press_cover_color, 1711276032);
            obtainStyledAttributes.recycle();
        } else {
            this.a = us.pinguo.foundation.t.b.a.a(getContext(), 2.0f);
            this.b = -1;
            this.f12099f = 1711276032;
        }
        this.f12101h = new us.pinguo.foundation.t.a.c(this.a, this.b);
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        bVar.y(this.f12101h);
        this.mDisplayImageOptions = bVar.t();
        Bitmap bitmap = getDrawable() instanceof BitmapDrawable ? ((BitmapDrawable) getDrawable()).getBitmap() : null;
        this.f12102i = true;
        setImageBitmap(null);
        this.f12101h.display(bitmap, this.mImageViewAware, LoadedFrom.DISC_CACHE);
        b(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        if (getDrawable() instanceof c.a) {
            this.c.set(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
            ((c.a) getDrawable()).onBoundsChange(this.c);
        }
        super.onDraw(canvas);
        if (isPressed() && this.f12100g) {
            int i3 = this.a;
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth > measuredHeight) {
                i2 = (measuredHeight - (i3 * 2)) / 2;
            } else {
                i2 = (measuredWidth - (i3 * 2)) / 2;
            }
            this.f12098e.setColor(this.f12099f);
            canvas.drawCircle(measuredWidth / 2, measuredHeight / 2, i2 + (i3 / 2), this.f12098e);
        }
    }

    public void setBorderColor(int i2) {
        this.b = i2;
        us.pinguo.foundation.t.a.c cVar = this.f12101h;
        if (cVar != null) {
            cVar.b(i2);
        }
    }

    public void setBorderWidth(int i2) {
        this.a = i2;
        us.pinguo.foundation.t.a.c cVar = this.f12101h;
        if (cVar != null) {
            cVar.c(i2);
        }
    }

    public void setDefaultImageView(Boolean bool) {
        if (bool == null) {
            this.f12097d = 2;
        } else if (bool.booleanValue()) {
            this.f12097d = 1;
        } else {
            this.f12097d = 0;
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.f12097d == 0) {
            b(bitmap);
        } else {
            super.setImageBitmap(bitmap);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        int i2 = this.f12097d;
        if (i2 == 0 && (drawable instanceof BitmapDrawable) && this.f12102i) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null) {
                b(bitmap);
            }
        } else if (i2 == 2 && (drawable instanceof BitmapDrawable) && this.f12102i) {
            Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap2 != null) {
                c(bitmap2);
            }
        } else {
            super.setImageDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        setImageDrawable(getResources().getDrawable(i2));
    }

    public void setPressedCoverColor(int i2) {
        this.f12099f = i2;
        this.f12100g = true;
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Rect();
        this.f12097d = 0;
        this.f12100g = false;
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = new Rect();
        this.f12097d = 0;
        this.f12100g = false;
    }
}
