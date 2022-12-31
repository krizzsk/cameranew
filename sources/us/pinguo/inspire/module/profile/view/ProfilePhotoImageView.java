package us.pinguo.inspire.module.profile.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.foundation.t.b.a;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ProfilePhotoImageView extends PhotoImageView {
    private final int[] RES;
    private Bitmap mAwardIcon;
    private int mHeight;
    private int mIconHeight;
    private int mIconWidth;
    private Bitmap mMultiPhotoIcon;
    private int mPaddingRight;
    private int mPaddingTop;
    private Paint mPaint;
    private TYPE mType;
    private Bitmap mVideoIcon;
    private int mWidth;

    /* renamed from: us.pinguo.inspire.module.profile.view.ProfilePhotoImageView$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$us$pinguo$inspire$module$profile$view$ProfilePhotoImageView$TYPE;

        static {
            int[] iArr = new int[TYPE.values().length];
            $SwitchMap$us$pinguo$inspire$module$profile$view$ProfilePhotoImageView$TYPE = iArr;
            try {
                iArr[TYPE.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$us$pinguo$inspire$module$profile$view$ProfilePhotoImageView$TYPE[TYPE.MUTIL_PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$us$pinguo$inspire$module$profile$view$ProfilePhotoImageView$TYPE[TYPE.VIDEO_AWARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$us$pinguo$inspire$module$profile$view$ProfilePhotoImageView$TYPE[TYPE.MUTIL_PHOTO_AWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$us$pinguo$inspire$module$profile$view$ProfilePhotoImageView$TYPE[TYPE.TASK_WORK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$us$pinguo$inspire$module$profile$view$ProfilePhotoImageView$TYPE[TYPE.NONE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public enum TYPE {
        VIDEO,
        MUTIL_PHOTO,
        VIDEO_AWARD,
        MUTIL_PHOTO_AWARD,
        TASK_WORK,
        NONE
    }

    public ProfilePhotoImageView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mType = TYPE.NONE;
        this.RES = new int[]{R.drawable.muilt_photo2, R.drawable.muilt_photo3, R.drawable.muilt_photo4, R.drawable.muilt_photo5, R.drawable.muilt_photo6, R.drawable.muilt_photo7, R.drawable.muilt_photo8, R.drawable.muilt_photo9};
        init();
    }

    private void drawAward(Bitmap bitmap, Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(-1);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Rect rect = new Rect();
        int a = a.a(getContext(), 3.0f);
        rect.left = a;
        rect.right = width + a;
        rect.top = a;
        rect.bottom = a + height;
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.mPaint);
    }

    private void drawIcon(Bitmap bitmap, Canvas canvas) {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(-1);
        Rect rect = new Rect();
        int i2 = this.mWidth;
        int i3 = this.mPaddingRight;
        rect.left = (i2 - this.mIconWidth) - i3;
        int i4 = this.mPaddingTop;
        rect.top = i4;
        rect.right = i2 - i3;
        rect.bottom = i4 + this.mIconHeight;
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.mPaint);
    }

    private void init() {
        this.mPaint.setColor(getContext().getResources().getColor(us.pinguo.ui.R.color.black_90));
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.mPaddingRight = a.a(getContext(), 4.0f);
        this.mPaddingTop = a.a(getContext(), 4.0f);
        this.mVideoIcon = BitmapFactory.decodeResource(getResources(), R.drawable.profile_video_icon);
        this.mMultiPhotoIcon = BitmapFactory.decodeResource(getResources(), R.drawable.profile_mutil_photo_icon);
        this.mAwardIcon = BitmapFactory.decodeResource(getResources(), R.drawable.profile_award_icon);
        setImgCenterCrop(false);
    }

    private void initAndDraw(Bitmap bitmap, Canvas canvas) {
        this.mIconWidth = bitmap.getWidth();
        this.mIconHeight = bitmap.getHeight();
        drawIcon(bitmap, canvas);
    }

    private Bitmap loadBitmap(int i2) {
        return BitmapFactory.decodeResource(getResources(), i2);
    }

    private void loadIcon(int i2) {
        if (i2 > 9 || i2 < 2) {
            return;
        }
        this.mMultiPhotoIcon = loadBitmap(this.RES[i2 - 2]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = AnonymousClass1.$SwitchMap$us$pinguo$inspire$module$profile$view$ProfilePhotoImageView$TYPE[this.mType.ordinal()];
        if (i2 == 1) {
            initAndDraw(this.mVideoIcon, canvas);
        } else if (i2 == 2) {
            initAndDraw(this.mMultiPhotoIcon, canvas);
        } else if (i2 == 3) {
            initAndDraw(this.mVideoIcon, canvas);
        } else if (i2 != 4) {
        } else {
            initAndDraw(this.mMultiPhotoIcon, canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.PhotoImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        this.mWidth = View.MeasureSpec.getSize(i2);
        this.mHeight = View.MeasureSpec.getSize(i3);
        super.onMeasure(i2, i3);
    }

    public void setShowType(TYPE type) {
        this.mType = type;
    }

    public void setShowType(TYPE type, int i2) {
        loadIcon(i2);
        setShowType(type);
    }

    public ProfilePhotoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.mType = TYPE.NONE;
        this.RES = new int[]{R.drawable.muilt_photo2, R.drawable.muilt_photo3, R.drawable.muilt_photo4, R.drawable.muilt_photo5, R.drawable.muilt_photo6, R.drawable.muilt_photo7, R.drawable.muilt_photo8, R.drawable.muilt_photo9};
        init();
    }

    public ProfilePhotoImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint = new Paint();
        this.mType = TYPE.NONE;
        this.RES = new int[]{R.drawable.muilt_photo2, R.drawable.muilt_photo3, R.drawable.muilt_photo4, R.drawable.muilt_photo5, R.drawable.muilt_photo6, R.drawable.muilt_photo7, R.drawable.muilt_photo8, R.drawable.muilt_photo9};
        init();
    }
}
