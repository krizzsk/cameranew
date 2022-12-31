package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.utils.BitmapHelper;
/* loaded from: classes2.dex */
public class ScaledImageView extends ImageView implements View.OnTouchListener {
    private static final int DRAG_1 = 1;
    private static final int DRAG_2 = 2;
    private static final int NONE = 0;
    private static final int ZOOM = 3;
    private Bitmap bitmap;
    private float distSquare;
    private float[] downPoint;
    private int dragScrollMinDistSquare;
    private OnMatrixChangedListener listener;
    private Matrix matrix;
    private int mode;
    private Matrix savedMatrix;

    /* loaded from: classes2.dex */
    public interface OnMatrixChangedListener {
        void onMactrixChage(Matrix matrix);
    }

    public ScaledImageView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dragScrollMinDistSquare = scaledTouchSlop;
        this.dragScrollMinDistSquare = scaledTouchSlop * scaledTouchSlop;
        setOnTouchListener(this);
    }

    public Bitmap getCropedBitmap(Rect rect) {
        try {
            Bitmap captureView = BitmapHelper.captureView(this, getWidth(), getHeight());
            if (captureView == null) {
                MobLog.getInstance().w("ivPhoto.getDrawingCache() returns null");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(captureView, rect.left, rect.top, rect.width(), rect.height());
            captureView.recycle();
            return createBitmap;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                Matrix matrix = new Matrix();
                this.matrix = matrix;
                matrix.set(getImageMatrix());
                Matrix matrix2 = new Matrix();
                this.savedMatrix = matrix2;
                matrix2.set(this.matrix);
                this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                this.mode = 1;
            } else if (action == 1) {
                OnMatrixChangedListener onMatrixChangedListener = this.listener;
                if (onMatrixChangedListener != null) {
                    onMatrixChangedListener.onMactrixChage(this.matrix);
                }
                float x = motionEvent.getX(0) - this.downPoint[0];
                float y = motionEvent.getY(0) - this.downPoint[1];
                if (this.mode == 1 && (x * x) + (y * y) <= this.dragScrollMinDistSquare) {
                    performClick();
                }
                this.mode = 0;
            } else if (action == 2) {
                int i2 = this.mode;
                if (i2 == 1) {
                    float[] fArr = {motionEvent.getX(0), motionEvent.getY(0)};
                    this.matrix.set(this.savedMatrix);
                    Matrix matrix3 = this.matrix;
                    float f2 = fArr[0];
                    float[] fArr2 = this.downPoint;
                    matrix3.postTranslate(f2 - fArr2[0], fArr[1] - fArr2[1]);
                } else if (i2 == 2) {
                    float[] fArr3 = {motionEvent.getX(1), motionEvent.getY(1)};
                    this.matrix.set(this.savedMatrix);
                    Matrix matrix4 = this.matrix;
                    float f3 = fArr3[0];
                    float[] fArr4 = this.downPoint;
                    matrix4.postTranslate(f3 - fArr4[0], fArr3[1] - fArr4[1]);
                } else if (i2 == 3) {
                    float[] fArr5 = {motionEvent.getX(0), motionEvent.getY(0)};
                    float[] fArr6 = {motionEvent.getX(1), motionEvent.getY(1)};
                    float f4 = fArr5[0] - fArr6[0];
                    float f5 = fArr5[1] - fArr6[1];
                    this.matrix.set(this.savedMatrix);
                    float sqrt = (float) Math.sqrt(((f4 * f4) + (f5 * f5)) / this.distSquare);
                    float[] fArr7 = {(fArr5[0] + fArr6[0]) / 2.0f, (fArr5[1] + fArr6[1]) / 2.0f};
                    this.matrix.postScale(sqrt, sqrt, fArr7[0], fArr7[1]);
                }
            } else if (action == 5) {
                float[] fArr8 = {motionEvent.getX(0), motionEvent.getY(0)};
                float[] fArr9 = {motionEvent.getX(1), motionEvent.getY(1)};
                float f6 = fArr8[0] - fArr9[0];
                float f7 = fArr8[1] - fArr9[1];
                this.distSquare = (f6 * f6) + (f7 * f7);
                this.mode = 3;
            } else if (action == 6) {
                this.downPoint = new float[]{motionEvent.getX(1), motionEvent.getY(1)};
                this.savedMatrix.set(this.matrix);
                this.mode = 2;
            } else if (action == 261) {
                float[] fArr10 = {motionEvent.getX(0), motionEvent.getY(0)};
                float[] fArr11 = {motionEvent.getX(1), motionEvent.getY(1)};
                float f8 = fArr10[0] - fArr11[0];
                float f9 = fArr10[1] - fArr11[1];
                this.distSquare = (f8 * f8) + (f9 * f9);
                this.mode = 3;
            } else if (action != 262) {
                return false;
            } else {
                this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                this.savedMatrix.set(this.matrix);
                this.mode = 1;
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return true;
    }

    public void rotateLeft() {
        try {
            Matrix matrix = new Matrix();
            this.matrix = matrix;
            float[] fArr = {0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            matrix.setValues(fArr);
            Bitmap bitmap = this.bitmap;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (createBitmap != null && !createBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = createBitmap;
            }
            setImageBitmap(this.bitmap);
            Matrix matrix2 = new Matrix();
            this.matrix = matrix2;
            matrix2.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float[] fArr2 = {fArr[0] * this.bitmap.getWidth(), fArr[4] * this.bitmap.getHeight()};
            float[] fArr3 = {(iArr[0] - fArr2[0]) / 2.0f, (iArr[1] - fArr2[1]) / 2.0f};
            fArr[2] = fArr3[0];
            fArr[5] = fArr3[1];
            this.matrix.setValues(fArr);
            OnMatrixChangedListener onMatrixChangedListener = this.listener;
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public void rotateRight() {
        try {
            Matrix matrix = new Matrix();
            this.matrix = matrix;
            float[] fArr = {0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            matrix.setValues(fArr);
            Bitmap bitmap = this.bitmap;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (createBitmap != null && !createBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = createBitmap;
            }
            setImageBitmap(this.bitmap);
            Matrix matrix2 = new Matrix();
            this.matrix = matrix2;
            matrix2.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float[] fArr2 = {fArr[0] * this.bitmap.getWidth(), fArr[4] * this.bitmap.getHeight()};
            float[] fArr3 = {(iArr[0] - fArr2[0]) / 2.0f, (iArr[1] - fArr2[1]) / 2.0f};
            fArr[2] = fArr3[0];
            fArr[5] = fArr3[1];
            this.matrix.setValues(fArr);
            OnMatrixChangedListener onMatrixChangedListener = this.listener;
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        setImageBitmap(bitmap);
        int[] iArr = {getWidth(), getHeight()};
        int[] iArr2 = {this.bitmap.getWidth(), this.bitmap.getHeight()};
        int[] fixRect = BitmapHelper.fixRect(iArr2, iArr);
        int[] iArr3 = {(iArr[0] - fixRect[0]) / 2, (iArr[1] - fixRect[1]) / 2};
        float[] fArr = {fixRect[0] / iArr2[0], fixRect[1] / iArr2[1]};
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        matrix.set(getImageMatrix());
        this.matrix.postScale(fArr[0], fArr[1]);
        this.matrix.postTranslate(iArr3[0], iArr3[1]);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void setOnMatrixChangedListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.listener = onMatrixChangedListener;
        Matrix matrix = this.matrix;
        if (matrix != null) {
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(matrix);
            }
            setImageMatrix(this.matrix);
        }
    }

    public void zoomIn() {
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        matrix.set(getImageMatrix());
        this.matrix.postScale(1.072f, 1.072f);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void zoomOut() {
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        matrix.set(getImageMatrix());
        this.matrix.postScale(0.933f, 0.933f);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }
}
