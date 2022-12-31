package us.pinguo.inspire.module.publish;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class PublishDrawable extends us.pinguo.ui.uilview.b {
    private Bitmap close_icon;
    private Context mContext;
    private int mPhotoCount;
    private int mWorkType;
    private int mPressColor = -3355444;
    private int mBackgroundColor = -1118482;
    private boolean isShowClose = false;

    public PublishDrawable(Context context) {
        this.mContext = context;
        this.close_icon = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.public_delete_icon)).getBitmap();
    }

    private void drawMediaType(Canvas canvas) {
        int i2;
        Bitmap decodeResource;
        if (this.mWorkType == 1) {
            return;
        }
        Rect rect = new Rect();
        double d2 = getBounds().bottom - getBounds().top;
        double d3 = 0.05d * d2;
        rect.top = (int) (getBounds().top + d3);
        int i3 = (int) (getBounds().right - d3);
        rect.right = i3;
        double d4 = d2 * 0.15d;
        rect.left = (int) (i3 - d4);
        rect.bottom = (int) (rect.top + d4);
        int i4 = 0;
        int i5 = this.mWorkType;
        if (i5 == 2) {
            i4 = R.drawable.video_icon;
        } else if (i5 == 3 && (i2 = this.mPhotoCount) > 1) {
            i4 = us.pinguo.inspire.util.s.a(i2);
        }
        if (i4 == 0 || (decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), i4)) == null) {
            return;
        }
        canvas.drawBitmap(decodeResource, (Rect) null, rect, (Paint) null);
    }

    @Override // us.pinguo.ui.uilview.b, us.pinguo.foundation.t.a.b, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPaint.setColor(this.mBackgroundColor);
        canvas.drawRect(getBounds(), this.mPaint);
        Rect bounds = getBounds();
        if (isPressed()) {
            this.mPaint.setColor(this.mPressColor);
            canvas.drawRect(bounds, this.mPaint);
        }
        if (this.mBitmap != null) {
            super.draw(canvas);
        }
        drawMediaType(canvas);
        if (this.isShowClose) {
            Bitmap bitmap = this.close_icon;
            canvas.drawBitmap(bitmap, bounds.right - bitmap.getWidth(), bounds.top, (Paint) null);
        }
    }

    public Bitmap getCloseIcon() {
        return this.close_icon;
    }

    public int getPhotoCount() {
        return this.mPhotoCount;
    }

    public int getPressColor() {
        return this.mPressColor;
    }

    public int getWorkType() {
        return this.mWorkType;
    }

    protected boolean isPressed() {
        int[] state = getState();
        if (state != null && state.length != 0) {
            for (int i2 : state) {
                if (i2 == 16842919) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        invalidateSelf();
        return true;
    }

    @Override // us.pinguo.foundation.t.a.b
    public void setBitmap(Bitmap bitmap) {
        super.setBitmap(bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
    }

    public void setPhotoCount(int i2) {
        this.mPhotoCount = i2;
    }

    public void setPressColor(int i2) {
        this.mPressColor = i2;
    }

    public void setShowClose(boolean z) {
        this.isShowClose = z;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setWorkType(int i2) {
        this.mWorkType = i2;
    }
}
