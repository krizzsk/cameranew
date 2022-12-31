package us.pinguo.inspire.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import us.pinguo.inspire.module.feeds.view.PhotoTagDrawable;
import us.pinguo.ui.R;
import us.pinguo.ui.a;
import us.pinguo.user.util.f;
/* loaded from: classes9.dex */
public class PhotoGridView extends View implements View.OnClickListener, f.b {
    private static final int DEFAULT_COLUMN = 3;
    public static final int MAX_DRAW_COUNT = 9;
    public static final int MODE_1_AD = 10;
    public static final int MODE_1_DETAIL = 0;
    public static final int MODE_1_FEEDS = 1;
    public static final int MODE_2 = 2;
    public static final int MODE_3 = 3;
    public static final int MODE_4 = 4;
    public static final int MODE_5 = 5;
    public static final int MODE_6 = 6;
    public static final int MODE_7 = 7;
    public static final int MODE_8 = 8;
    public static final int MODE_9 = 9;
    public static final int MODE_AUTO = -1;
    public static final int MODE_GRID = 100;
    private static final float RATE_DEVIATION = 0.02f;
    private static final float WH_169 = 1.7777778f;
    private static final float WH_34 = 0.75f;
    private static final float WH_43 = 1.3333334f;
    private static final float WH_916 = 0.5625f;
    protected int mColumn;
    private us.pinguo.user.util.f mDoubleClickDetector;
    protected int mDrawCount;
    private boolean mDrawFrameLines;
    protected us.pinguo.ui.uilview.b[] mDrawables;
    private boolean mEnableLongPicTag;
    protected int mGridMargin;
    private Paint mLinePaint;
    protected int mMode;
    private View.OnClickListener mOnClickListener;
    private f.b mOnDoubleClickListener;
    private a mOnItemClick;
    protected b[] mPhotos;
    private List<d> mPushPhotos;
    protected PointF mTouchPoint;

    /* loaded from: classes9.dex */
    public interface a {
        void onItemClick(PhotoGridView photoGridView, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c extends us.pinguo.foundation.t.a.a {
        d a;
        int b;
        int c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ int a;

            a(int i2) {
                this.a = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d dVar;
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                c cVar = c.this;
                int i2 = cVar.b;
                if ((intValue - i2 < cVar.c && i2 != 0 && i2 != cVar.a.b.width()) || (dVar = c.this.a) == null || dVar.a == null || dVar.b == null) {
                    return;
                }
                Rect rect = new Rect(c.this.a.b);
                Rect rect2 = c.this.a.b;
                Rect rect3 = new Rect(c.this.a.b);
                int i3 = this.a;
                if (i3 == 0) {
                    int i4 = rect2.right - intValue;
                    rect.left = i4;
                    rect.right = i4 + rect2.width();
                    rect3.left = rect2.left - intValue;
                    rect3.right = rect2.right - intValue;
                } else if (i3 == 1) {
                    int i5 = rect2.left + intValue;
                    rect.right = i5;
                    rect.left = i5 - rect2.width();
                    rect3.left = rect2.left + intValue;
                    rect3.right = rect2.right + intValue;
                } else if (i3 == 2) {
                    int i6 = rect2.bottom - intValue;
                    rect.top = i6;
                    rect.bottom = i6 + rect2.height();
                    rect3.top = rect2.top - intValue;
                    rect3.bottom = rect2.right - intValue;
                } else if (i3 != 3) {
                    int i7 = rect2.right - intValue;
                    rect.left = i7;
                    rect.right = i7 + rect2.width();
                    rect3.left = rect2.left - intValue;
                    rect3.right = rect2.right - intValue;
                } else {
                    int i8 = rect2.top + intValue;
                    rect.bottom = i8;
                    rect.top = i8 - rect2.width();
                    rect3.top = rect2.top + intValue;
                    rect3.bottom = rect2.right + intValue;
                }
                c.this.a.a.setBounds(rect);
                c cVar2 = c.this;
                cVar2.a.f11339e = rect3;
                PhotoGridView.this.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes9.dex */
        public class b implements Animator.AnimatorListener {
            b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b[] bVarArr;
                int i2;
                c cVar = c.this;
                d dVar = cVar.a;
                if (dVar != null) {
                    int i3 = dVar.c;
                    us.pinguo.ui.uilview.b[] bVarArr2 = PhotoGridView.this.mDrawables;
                    if (i3 < bVarArr2.length) {
                        bVarArr2[i3] = dVar.a;
                        bVarArr2[i3].resetDisplayImageOptions();
                    }
                }
                c cVar2 = c.this;
                d dVar2 = cVar2.a;
                if (dVar2 != null && (bVarArr = PhotoGridView.this.mPhotos) != null && (i2 = dVar2.c) < bVarArr.length) {
                    bVarArr[i2] = dVar2.f11338d;
                }
                PhotoGridView.this.mPushPhotos.remove(c.this.a);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public c(int i2, d dVar) {
            super(i2, true, true, true);
            this.a = dVar;
            this.c = (int) ((dVar.b.width() * 1.0d) / 12.0d);
        }

        private Animator a(int i2, int i3) {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, this.a.b.width());
            ofInt.addUpdateListener(new a(i3));
            ofInt.addListener(new b());
            ofInt.setDuration(i2);
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.start();
            return ofInt;
        }

        @Override // us.pinguo.foundation.t.a.a, com.nostra13.universalimageloader.core.i.a
        public void display(Bitmap bitmap, com.nostra13.universalimageloader.core.j.a aVar, LoadedFrom loadedFrom) {
            us.pinguo.ui.uilview.b bVar;
            d dVar = this.a;
            if (dVar == null || (bVar = dVar.a) == null) {
                return;
            }
            bVar.setBitmap(bitmap);
            this.a.f11340f = a(this.durationMillis, new Random().nextInt(4));
        }
    }

    /* loaded from: classes9.dex */
    public class d {
        us.pinguo.ui.uilview.b a;
        Rect b;
        int c;

        /* renamed from: d  reason: collision with root package name */
        public b f11338d;

        /* renamed from: e  reason: collision with root package name */
        Rect f11339e;

        /* renamed from: f  reason: collision with root package name */
        Animator f11340f;

        public d(PhotoGridView photoGridView) {
        }
    }

    public PhotoGridView(Context context) {
        super(context);
        this.mDrawables = new PhotoTagDrawable[9];
        this.mColumn = 3;
        this.mTouchPoint = new PointF();
        this.mEnableLongPicTag = false;
        this.mDoubleClickDetector = new us.pinguo.user.util.f();
        this.mPushPhotos = new ArrayList();
        init();
    }

    private void checkShowTag(b[] bVarArr) {
        us.pinguo.ui.uilview.b[] bVarArr2 = this.mDrawables;
        if (bVarArr2 == null || !(bVarArr2[0] instanceof PhotoTagDrawable)) {
            return;
        }
        if (this.mDrawCount == 1) {
            float f2 = bVarArr[0].a / bVarArr[0].b;
            if (f2 > 1.7977778f || f2 < 0.5425f) {
                ((PhotoTagDrawable) bVarArr2[0]).setShowTag(this.mEnableLongPicTag);
                return;
            }
        }
        ((PhotoTagDrawable) bVarArr2[0]).setShowTag(false);
    }

    private void drawFrameLines(Canvas canvas) {
        if (this.mLinePaint == null) {
            Paint paint = new Paint();
            this.mLinePaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.mLinePaint.setColor(-723724);
            this.mLinePaint.setStrokeWidth(us.pinguo.foundation.t.b.a.a(getContext(), 1.0f));
        }
        canvas.drawLine(0.0f, 0.0f, getWidth(), 0.0f, this.mLinePaint);
        canvas.drawLine(0.0f, getHeight(), getWidth(), getHeight(), this.mLinePaint);
    }

    private Pair<Integer, Integer> fixVideoSize(b bVar, Pair<Integer, Integer> pair) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (bVar.f11336d && (i2 = bVar.a) != (i3 = bVar.b)) {
            if (i2 > i3) {
                i4 = ((Integer) pair.second).intValue();
                i5 = (int) (i4 * (bVar.a / bVar.b));
            } else {
                int intValue = ((Integer) pair.first).intValue();
                i4 = (int) (intValue / (bVar.a / bVar.b));
                i5 = intValue;
            }
            return new Pair<>(Integer.valueOf(i5), Integer.valueOf(i4));
        }
        return new Pair<>((Integer) pair.first, (Integer) pair.second);
    }

    private com.nostra13.universalimageloader.core.c getPushDisplayOption(d dVar) {
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        bVar.A(ImageScaleType.EXACTLY);
        a.C0453a c0453a = new a.C0453a();
        c0453a.b(false);
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        bVar.y(new c(600, dVar));
        bVar.D(true);
        return bVar.t();
    }

    private void init() {
        this.mGridMargin = us.pinguo.foundation.t.b.a.a(getContext(), 3.0f);
        initDrawables();
        super.setOnClickListener(this);
    }

    private void makeChildCountOK(int i2) {
        int i3 = 0;
        while (true) {
            us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
            if (i3 >= bVarArr.length) {
                return;
            }
            us.pinguo.ui.uilview.b bVar = bVarArr[i3];
            if (i3 < i2) {
                bVar.setCallback(this);
            } else {
                bVar.setCallback(null);
                bVar.cancelTask();
                bVar.release();
            }
            i3++;
        }
    }

    private int measuerGrid(int i2, int i3, int i4, int i5, int i6, int i7) {
        for (int i8 = i2; i8 < i2 + i4; i8++) {
            us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
            if (i8 >= bVarArr.length) {
                break;
            }
            bVarArr[i8].setBounds(i6, i7, i6 + i3, i7 + i3);
            if ((i8 - i2) % i5 == i5 - 1) {
                i6 = 0;
                i7 += this.mGridMargin + i3;
            } else {
                i6 += this.mGridMargin + i3;
            }
        }
        int i9 = i4 / i5;
        if (i4 % i5 != 0) {
            i9++;
        }
        return (i3 * i9) + ((i9 - 1) * this.mGridMargin);
    }

    private void measureMode2(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(null, size);
        if (childSize.size() < 2) {
            us.pinguo.common.log.a.e("measureMode8,sizeList.size:" + childSize.size(), new Object[0]);
            return;
        }
        setMeasuredDimension(size, measuerGrid(0, ((Integer) childSize.get(0).first).intValue(), 2, 2, 0, 0));
    }

    private int measureMode3(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(null, size);
        if (childSize.size() < 3) {
            us.pinguo.common.log.a.e("measureMode3,sizeList.size:" + childSize.size(), new Object[0]);
            return 0;
        }
        int intValue = ((Integer) childSize.get(0).first).intValue();
        int intValue2 = ((Integer) childSize.get(1).first).intValue();
        us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
        us.pinguo.ui.uilview.b bVar = bVarArr[0];
        us.pinguo.ui.uilview.b bVar2 = bVarArr[1];
        us.pinguo.ui.uilview.b bVar3 = bVarArr[2];
        bVar.setBounds(0, 0, intValue, intValue);
        int i4 = this.mGridMargin;
        bVar2.setBounds(intValue + i4, 0, i4 + intValue + intValue2, intValue2);
        int i5 = this.mGridMargin;
        bVar3.setBounds(intValue + i5, intValue2 + i5, intValue + i5 + intValue2, i5 + intValue2 + intValue2);
        setMeasuredDimension(size, intValue);
        return intValue;
    }

    private void measureMode4(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(null, size);
        if (childSize.size() < 4) {
            us.pinguo.common.log.a.e("measureMode8,sizeList.size:" + childSize.size(), new Object[0]);
            return;
        }
        setMeasuredDimension(size, measuerGrid(0, ((Integer) childSize.get(0).first).intValue(), 4, 2, 0, 0));
    }

    private void measureMode5(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(null, size);
        if (childSize.size() < 5) {
            us.pinguo.common.log.a.e("measureMode8,sizeList.size:" + childSize.size(), new Object[0]);
            return;
        }
        int intValue = ((Integer) childSize.get(0).first).intValue();
        int intValue2 = ((Integer) childSize.get(4).first).intValue();
        int measuerGrid = measuerGrid(0, intValue, 2, 2, 0, 0);
        setMeasuredDimension(size, measuerGrid + measuerGrid(2, intValue2, 3, 3, 0, measuerGrid + this.mGridMargin) + this.mGridMargin);
    }

    private void measureMode6(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(null, size);
        if (childSize.size() < 6) {
            us.pinguo.common.log.a.e("measureMode8,sizeList.size:" + childSize.size(), new Object[0]);
            return;
        }
        int intValue = ((Integer) childSize.get(5).first).intValue();
        int measureMode3 = measureMode3(i2, i3);
        setMeasuredDimension(size, measureMode3 + measuerGrid(3, intValue, 3, 3, 0, measureMode3 + this.mGridMargin) + this.mGridMargin);
    }

    private void measureMode7(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(null, size);
        if (childSize.size() < 7) {
            us.pinguo.common.log.a.e("measureMode8,sizeList.size:" + childSize.size(), new Object[0]);
            return;
        }
        int intValue = ((Integer) childSize.get(6).first).intValue();
        int measureMode3 = measureMode3(i2, i3);
        setMeasuredDimension(size, measureMode3 + measuerGrid(3, intValue, 4, 4, 0, measureMode3 + this.mGridMargin) + this.mGridMargin);
    }

    private void measureMode8(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(null, size);
        if (childSize.size() < 8) {
            us.pinguo.common.log.a.e("measureMode8,sizeList.size:" + childSize.size(), new Object[0]);
            return;
        }
        int intValue = ((Integer) childSize.get(0).first).intValue();
        int intValue2 = ((Integer) childSize.get(3).first).intValue();
        int measuerGrid = measuerGrid(0, intValue, 2, 2, 0, 0);
        setMeasuredDimension(size, measuerGrid + measuerGrid(2, intValue2, 6, 3, 0, measuerGrid + this.mGridMargin) + this.mGridMargin);
    }

    private void measureMode9(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(null, size);
        int intValue = ((Integer) (childSize.size() > 0 ? childSize.get(0) : new Pair<>(1, 1)).first).intValue();
        b[] bVarArr = this.mPhotos;
        int length = bVarArr != null ? bVarArr.length : 0;
        setMeasuredDimension(size, measuerGrid(0, intValue, length > 9 ? 9 : length, this.mColumn, 0, 0));
    }

    private void releaseDrawables() {
        us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
        if (bVarArr == null || bVarArr.length == 0) {
            return;
        }
        for (us.pinguo.ui.uilview.b bVar : bVarArr) {
            bVar.setBitmap(null);
        }
    }

    public void addPushPhoto(b bVar, int i2) {
        d dVar = new d(this);
        dVar.f11338d = bVar;
        dVar.c = i2;
        PhotoTagDrawable photoTagDrawable = new PhotoTagDrawable(null, 0, 0);
        dVar.a = photoTagDrawable;
        Rect rect = new Rect(this.mDrawables[i2].getBounds());
        dVar.b = rect;
        this.mPushPhotos.add(dVar);
        if (bVar.f11336d) {
            fixVideoSize(bVar, new Pair<>(Integer.valueOf(rect.width()), Integer.valueOf(rect.height())));
        } else {
            photoTagDrawable.setSize(rect.width(), rect.width());
        }
        photoTagDrawable.setDisplayImageOptions(getPushDisplayOption(dVar));
        photoTagDrawable.setImageUri(bVar.c, bVar.f11336d);
    }

    public void clearPushPhotos() {
        List<d> list = this.mPushPhotos;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void forceShowTag(boolean z) {
        us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
        if (bVarArr == null || !(bVarArr[0] instanceof PhotoTagDrawable)) {
            return;
        }
        ((PhotoTagDrawable) bVarArr[0]).setShowTag(z);
    }

    public Bitmap getBitmap() {
        us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
        if (bVarArr == null || bVarArr.length <= 0) {
            return null;
        }
        return bVarArr[0].getBitmap();
    }

    public Bitmap[] getBitmaps() {
        int i2;
        us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
        int i3 = 0;
        if (bVarArr == null || bVarArr.length == 0 || (i2 = this.mDrawCount) == 0) {
            return new Bitmap[0];
        }
        Bitmap[] bitmapArr = new Bitmap[i2];
        while (i3 < this.mDrawCount) {
            us.pinguo.ui.uilview.b[] bVarArr2 = this.mDrawables;
            us.pinguo.ui.uilview.b bVar = i3 < bVarArr2.length ? bVarArr2[i3] : null;
            if (bVar == null) {
                break;
            }
            bitmapArr[i3] = bVar.getBitmap();
            i3++;
        }
        return bitmapArr;
    }

    protected List<Pair<Integer, Integer>> getChildSize(b bVar, int i2) {
        return getChildSize(bVar, i2, this.mColumn, this.mGridMargin);
    }

    public Rect getItemBoundsInWindow(int i2) {
        us.pinguo.ui.uilview.b[] bVarArr;
        Rect rect = new Rect();
        if (i2 >= 0 && i2 < this.mDrawCount && (bVarArr = this.mDrawables) != null && i2 < bVarArr.length) {
            rect.set(bVarArr[i2].getBounds());
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            rect.offset(iArr[0], iArr[1]);
        }
        return rect;
    }

    protected int getModeFromPhotos(b[] bVarArr) {
        if (bVarArr.length > 9) {
            return 9;
        }
        switch (bVarArr.length) {
            case 1:
            default:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
        }
    }

    public b[] getPhotos() {
        return this.mPhotos;
    }

    public List<d> getPushPhotos() {
        return this.mPushPhotos;
    }

    protected int getTouchIndex() {
        for (int i2 = 0; i2 < this.mDrawCount; i2++) {
            us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
            if (i2 >= bVarArr.length) {
                return -1;
            }
            us.pinguo.ui.uilview.b bVar = bVarArr[i2];
            if (bVar != null) {
                Rect bounds = bVar.getBounds();
                PointF pointF = this.mTouchPoint;
                if (isInRect(pointF.x, pointF.y, bounds)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initDrawables() {
        int i2 = 0;
        while (true) {
            us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
            if (i2 >= bVarArr.length) {
                return;
            }
            bVarArr[i2] = new PhotoTagDrawable(null, 0, 0);
            this.mDrawables[i2].setLoadingColor(getResources().getColor(R.color.inspire_loading_color));
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isInRect(float f2, float f3, Rect rect) {
        return rect != null && f2 > ((float) rect.left) && f2 < ((float) rect.right) && f3 > ((float) rect.top) && f3 < ((float) rect.bottom);
    }

    public boolean isMultiMode() {
        int i2 = this.mMode;
        return i2 >= 2 && i2 <= 9;
    }

    protected void measureMode1_AD(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(this.mPhotos[0], size);
        Pair<Integer, Integer> pair = childSize.size() > 0 ? childSize.get(0) : new Pair<>(1, 1);
        int intValue = ((Integer) pair.first).intValue();
        int intValue2 = ((Integer) pair.second).intValue();
        us.pinguo.ui.uilview.b bVar = this.mDrawables[0];
        if (bVar == null) {
            return;
        }
        float f2 = intValue;
        float f3 = f2 / intValue2;
        if (intValue > intValue2 && f3 > WH_169) {
            intValue2 = (int) (f2 / WH_169);
            bVar.setBounds(0, 0, intValue, intValue2);
        } else if (intValue < intValue2 && f3 < WH_916) {
            intValue2 = (int) (size / WH_916);
            int i4 = size / 2;
            int i5 = ((int) (intValue2 * f3)) / 2;
            bVar.setBounds(i4 - i5, 0, i4 + i5, intValue2);
            this.mDrawFrameLines = true;
        } else {
            bVar.setBounds(0, 0, intValue, intValue2);
        }
        setMeasuredDimension(size, intValue2);
    }

    protected void measureMode1_Feeds(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        List<Pair<Integer, Integer>> childSize = getChildSize(this.mPhotos[0], size);
        Pair<Integer, Integer> pair = childSize.size() > 0 ? childSize.get(0) : new Pair<>(1, 1);
        int intValue = ((Integer) pair.first).intValue();
        int intValue2 = ((Integer) pair.second).intValue();
        us.pinguo.ui.uilview.b bVar = this.mDrawables[0];
        if (bVar == null) {
            return;
        }
        float f2 = intValue;
        float f3 = f2 / intValue2;
        if (intValue > intValue2 && f3 > WH_43) {
            intValue2 = (int) (f2 / WH_43);
            bVar.setBounds(0, 0, intValue, intValue2);
        } else if (intValue < intValue2 && f3 < 0.75f) {
            intValue2 = (int) (size / 0.75f);
            int i4 = size / 2;
            int i5 = ((int) (intValue2 * f3)) / 2;
            bVar.setBounds(i4 - i5, 0, i4 + i5, intValue2);
            this.mDrawFrameLines = true;
        } else {
            bVar.setBounds(0, 0, intValue, intValue2);
        }
        setMeasuredDimension(size, intValue2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.mDoubleClickDetector.d(view, this);
    }

    @Override // us.pinguo.user.util.f.b
    public void onDoubleClick(View view) {
        f.b bVar = this.mOnDoubleClickListener;
        if (bVar != null) {
            bVar.onDoubleClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        List<d> list = this.mPushPhotos;
        if (list != null && !list.isEmpty()) {
            canvas.drawColor(-2236963);
        }
        for (int i2 = 0; i2 < this.mDrawCount; i2++) {
            us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
            if (i2 >= bVarArr.length) {
                break;
            }
            bVarArr[i2].draw(canvas);
        }
        List<d> list2 = this.mPushPhotos;
        if (list2 != null && !list2.isEmpty()) {
            for (d dVar : this.mPushPhotos) {
                if (dVar.a != null && dVar.b != null && dVar.f11339e != null) {
                    canvas.save();
                    canvas.clipRect(dVar.b);
                    int i3 = dVar.c;
                    us.pinguo.ui.uilview.b[] bVarArr2 = this.mDrawables;
                    if (i3 < bVarArr2.length && bVarArr2[i3] != null) {
                        bVarArr2[i3].setBounds(dVar.f11339e);
                        this.mDrawables[dVar.c].draw(canvas);
                        this.mDrawables[dVar.c].setBounds(dVar.b);
                    }
                    dVar.a.draw(canvas);
                    canvas.restore();
                }
            }
        }
        if (this.mDrawFrameLines) {
            drawFrameLines(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        this.mDrawFrameLines = false;
        b[] bVarArr = this.mPhotos;
        if ((bVarArr != null ? bVarArr.length : 0) == 0) {
            super.onMeasure(i2, i3);
            return;
        }
        switch (this.mMode) {
            case 0:
            case 1:
                measureMode1_Feeds(i2, i3);
                return;
            case 2:
                measureMode2(i2, i3);
                return;
            case 3:
                measureMode3(i2, i3);
                return;
            case 4:
                measureMode4(i2, i3);
                return;
            case 5:
                measureMode5(i2, i3);
                return;
            case 6:
                measureMode6(i2, i3);
                return;
            case 7:
                measureMode7(i2, i3);
                return;
            case 8:
                measureMode8(i2, i3);
                return;
            case 9:
            default:
                measureMode9(i2, i3);
                return;
            case 10:
                measureMode1_AD(i2, i3);
                return;
        }
    }

    @Override // us.pinguo.user.util.f.b
    public void onSingleClick(View view) {
        a aVar;
        int i2 = this.mDrawCount;
        if (i2 > 1) {
            int touchIndex = getTouchIndex();
            if (touchIndex >= 0 && touchIndex < this.mDrawCount && (aVar = this.mOnItemClick) != null) {
                aVar.onItemClick(this, touchIndex);
                return;
            }
            View.OnClickListener onClickListener = this.mOnClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        } else if (i2 < 1) {
            View.OnClickListener onClickListener2 = this.mOnClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else {
            us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
            if (bVarArr != null && bVarArr.length >= 1 && bVarArr[0] != null) {
                us.pinguo.ui.uilview.b bVar = bVarArr[0];
                PointF pointF = this.mTouchPoint;
                if (isInRect(pointF.x, pointF.y, bVar.getBounds())) {
                    a aVar2 = this.mOnItemClick;
                    if (aVar2 != null) {
                        aVar2.onItemClick(this, 0);
                        return;
                    }
                    return;
                }
            }
            View.OnClickListener onClickListener3 = this.mOnClickListener;
            if (onClickListener3 != null) {
                onClickListener3.onClick(view);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mTouchPoint.set(motionEvent.getX(), motionEvent.getY());
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
    }

    public void setColumn(int i2) {
        this.mColumn = i2;
    }

    public void setEnableLongPicTag(boolean z) {
        this.mEnableLongPicTag = z;
        checkShowTag(this.mPhotos);
    }

    public void setGridMarginPx(int i2) {
        this.mGridMargin = i2;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnDoubleClickListener(f.b bVar) {
        this.mOnDoubleClickListener = bVar;
    }

    public void setOnItemClick(a aVar) {
        this.mOnItemClick = aVar;
    }

    public void setPhotos(b[] bVarArr) {
        setPhotos(bVarArr, -1);
    }

    public void setTagText(String str, int i2) {
        us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
        if (bVarArr == null || i2 < 0 || i2 >= bVarArr.length || !(bVarArr[i2] instanceof PhotoTagDrawable)) {
            return;
        }
        ((PhotoTagDrawable) bVarArr[i2]).setTagText(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        us.pinguo.ui.uilview.b[] bVarArr = this.mDrawables;
        if (bVarArr == null || bVarArr.length == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            us.pinguo.ui.uilview.b[] bVarArr2 = this.mDrawables;
            if (i2 < bVarArr2.length) {
                if (bVarArr2[i2] == drawable) {
                    return i2 < this.mDrawCount;
                }
                i2++;
            } else {
                return super.verifyDrawable(drawable);
            }
        }
    }

    protected List<Pair<Integer, Integer>> getChildSize(b bVar, int i2, int i3, int i4) {
        float f2;
        ArrayList arrayList = new ArrayList();
        if (bVar != null) {
            int i5 = bVar.a;
            if (i5 <= 0) {
                i5 = 1;
            }
            bVar.a = i5;
            int i6 = bVar.b;
            int i7 = i6 > 0 ? i6 : 1;
            bVar.b = i7;
            f2 = i5 / i7;
            if (f2 > WH_169) {
                f2 = WH_169;
            }
            if (f2 < WH_916) {
                f2 = WH_916;
            }
        } else {
            f2 = 1.0f;
        }
        int i8 = 0;
        switch (this.mMode) {
            case 0:
                arrayList.add(new Pair(Integer.valueOf(i2), Integer.valueOf((int) Math.ceil(i2 / f2))));
                break;
            case 1:
            case 10:
                arrayList.add(new Pair(Integer.valueOf(i2), Integer.valueOf((int) Math.ceil(i2 / f2))));
                break;
            case 2:
                int i9 = (i2 - i4) / 2;
                Pair pair = new Pair(Integer.valueOf(i9), Integer.valueOf(i9));
                while (i8 < 2) {
                    arrayList.add(pair);
                    i8++;
                }
                break;
            case 3:
                int ceil = (int) Math.ceil((i2 - (this.mGridMargin * 2)) / 3.0f);
                int i10 = (ceil * 2) + this.mGridMargin;
                Pair pair2 = new Pair(Integer.valueOf(i10), Integer.valueOf(i10));
                Pair pair3 = new Pair(Integer.valueOf(ceil), Integer.valueOf(ceil));
                arrayList.add(pair2);
                arrayList.add(pair3);
                arrayList.add(pair3);
                break;
            case 4:
                int ceil2 = (int) Math.ceil((i2 - this.mGridMargin) / 2.0f);
                Pair pair4 = new Pair(Integer.valueOf(ceil2), Integer.valueOf(ceil2));
                while (i8 < 4) {
                    arrayList.add(pair4);
                    i8++;
                }
                break;
            case 5:
                int ceil3 = (int) Math.ceil((i2 - this.mGridMargin) / 2.0f);
                int ceil4 = (int) Math.ceil((i2 - (this.mGridMargin * 2)) / 3.0f);
                Pair pair5 = new Pair(Integer.valueOf(ceil3), Integer.valueOf(ceil3));
                Pair pair6 = new Pair(Integer.valueOf(ceil4), Integer.valueOf(ceil4));
                arrayList.add(pair5);
                arrayList.add(pair5);
                arrayList.add(pair6);
                arrayList.add(pair6);
                arrayList.add(pair6);
                break;
            case 6:
                int ceil5 = (int) Math.ceil((i2 - (this.mGridMargin * 2)) / 3.0f);
                int ceil6 = (int) Math.ceil((ceil5 * 2) + this.mGridMargin);
                Pair pair7 = new Pair(Integer.valueOf(ceil6), Integer.valueOf(ceil6));
                Pair pair8 = new Pair(Integer.valueOf(ceil5), Integer.valueOf(ceil5));
                arrayList.add(pair7);
                arrayList.add(pair8);
                arrayList.add(pair8);
                arrayList.add(pair8);
                arrayList.add(pair8);
                arrayList.add(pair8);
                break;
            case 7:
                int ceil7 = (int) Math.ceil((i2 - (this.mGridMargin * 2)) / 3);
                int ceil8 = (int) Math.ceil((ceil7 * 2) + this.mGridMargin);
                Pair pair9 = new Pair(Integer.valueOf(ceil8), Integer.valueOf(ceil8));
                Pair pair10 = new Pair(Integer.valueOf(ceil7), Integer.valueOf(ceil7));
                arrayList.add(pair9);
                arrayList.add(pair10);
                arrayList.add(pair10);
                int ceil9 = (int) Math.ceil((i2 - (this.mGridMargin * 2)) / 4);
                Pair pair11 = new Pair(Integer.valueOf(ceil9), Integer.valueOf(ceil9));
                arrayList.add(pair11);
                arrayList.add(pair11);
                arrayList.add(pair11);
                arrayList.add(pair11);
                break;
            case 8:
                int ceil10 = (int) Math.ceil((i2 - this.mGridMargin) / 2.0f);
                Pair pair12 = new Pair(Integer.valueOf(ceil10), Integer.valueOf(ceil10));
                for (int i11 = 0; i11 < 2; i11++) {
                    arrayList.add(pair12);
                }
                int ceil11 = (int) Math.ceil((i2 - (this.mGridMargin * 2)) / 3.0f);
                Pair pair13 = new Pair(Integer.valueOf(ceil11), Integer.valueOf(ceil11));
                while (i8 < 6) {
                    arrayList.add(pair13);
                    i8++;
                }
                break;
            case 9:
            default:
                int ceil12 = (int) Math.ceil((i2 - ((i3 - 1) * this.mGridMargin)) / i3);
                Pair pair14 = new Pair(Integer.valueOf(ceil12), Integer.valueOf(ceil12));
                while (i8 < 9) {
                    arrayList.add(pair14);
                    i8++;
                }
                break;
        }
        return arrayList;
    }

    public void setPhotos(b[] bVarArr, int i2) {
        if (bVarArr != null && bVarArr.length != 0) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            this.mPhotos = bVarArr;
            this.mMode = i2;
            if (i2 == -1) {
                this.mMode = getModeFromPhotos(bVarArr);
            }
            int i3 = this.mMode;
            if (i3 != 0 && i3 != 1 && i3 != 10) {
                b[] bVarArr2 = this.mPhotos;
                this.mDrawCount = bVarArr2.length <= 9 ? bVarArr2.length : 9;
            } else {
                this.mDrawCount = 1;
            }
            makeChildCountOK(this.mDrawCount);
            List<Pair<Integer, Integer>> childSize = getChildSize(this.mPhotos[0], getMeasuredWidth() <= 0 ? us.pinguo.foundation.t.b.a.j(getContext()) : getMeasuredWidth());
            int i4 = 0;
            while (i4 < bVarArr.length && i4 < this.mDrawables.length) {
                Pair<Integer, Integer> pair = i4 < childSize.size() ? childSize.get(i4) : null;
                if (pair == null) {
                    pair = new Pair<>(1, 1);
                }
                us.pinguo.common.log.a.k("预估Size:" + pair.first + "X" + pair.second, new Object[0]);
                us.pinguo.ui.uilview.b bVar = this.mDrawables[i4];
                if (bVarArr[i4] != null && bVarArr[i4].f11336d) {
                    Pair<Integer, Integer> fixVideoSize = fixVideoSize(bVarArr[i4], pair);
                    bVar.setSize(((Integer) fixVideoSize.first).intValue(), ((Integer) fixVideoSize.second).intValue());
                } else {
                    bVar.setSize(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
                }
                if (bVar.getUri() != null && !bVar.getUri().equals(bVarArr[i4].c)) {
                    bVar.setBitmap(null);
                }
                bVar.setImageUri(bVarArr[i4].c, bVarArr[i4].f11336d);
                i4++;
            }
            checkShowTag(bVarArr);
            requestLayout();
            return;
        }
        releaseDrawables();
        us.pinguo.common.log.a.e("photos is null or empty", new Object[0]);
        setVisibility(4);
    }

    /* loaded from: classes9.dex */
    public static class b {
        public int a;
        public int b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11336d;

        public b(int i2, int i3, String str) {
            this.a = i2;
            this.b = i3;
            this.c = str;
        }

        public b(int i2, int i3, String str, boolean z) {
            this.a = i2;
            this.b = i3;
            this.c = str;
            this.f11336d = z;
        }
    }

    public PhotoGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawables = new PhotoTagDrawable[9];
        this.mColumn = 3;
        this.mTouchPoint = new PointF();
        this.mEnableLongPicTag = false;
        this.mDoubleClickDetector = new us.pinguo.user.util.f();
        this.mPushPhotos = new ArrayList();
        init();
    }

    public PhotoGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mDrawables = new PhotoTagDrawable[9];
        this.mColumn = 3;
        this.mTouchPoint = new PointF();
        this.mEnableLongPicTag = false;
        this.mDoubleClickDetector = new us.pinguo.user.util.f();
        this.mPushPhotos = new ArrayList();
        init();
    }
}
