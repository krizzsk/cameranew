package com.growingio.android.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.growingio.android.sdk.circle.HybridEventEditDialog;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.view.FloatViewContainer;
import java.io.ByteArrayOutputStream;
/* loaded from: classes2.dex */
public class ScreenshotHelper {
    private static String TAG = "GIO.ScreenshotHelper";
    private static boolean hasInitial = false;
    private static Bitmap sErrorBitmap = null;
    private static double sScaledFactor = -1.0d;
    private static int sScaledLong = -1;
    private static int sScaledShort = -1;
    private static int sScreenLong = -1;
    private static int sScreenShort = -1;

    public static byte[] captureAllWindows(View[] viewArr, RectF rectF) {
        byte[] compressViewsCapture = compressViewsCapture(viewArr, rectF);
        return compressViewsCapture == null ? new byte[0] : compressViewsCapture;
    }

    private static void checkAndInvalidate(View view) {
        if (view.getLayerType() != 0) {
            view.invalidate();
        }
    }

    private static byte[] compressViewsCapture(View[] viewArr, RectF rectF) {
        byte[] bArr = null;
        try {
            Bitmap mergeViewLayers = mergeViewLayers(viewArr);
            if (rectF != null) {
                Canvas canvas = new Canvas(mergeViewLayers);
                Context globalContext = CoreInitialize.coreAppState().getGlobalContext();
                Paint paint = new Paint();
                float dp2Px = Util.dp2Px(globalContext, 3.0f);
                paint.setColor(Constants.GROWINGIO_COLOR_LIGHT_RED);
                canvas.drawRoundRect(rectF, dp2Px, dp2Px, paint);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(Util.dp2Px(globalContext, 1.0f));
                paint.setColor(Constants.GROWINGIO_COLOR_RED);
                canvas.drawRoundRect(rectF, dp2Px, dp2Px, paint);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            mergeViewLayers.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
            mergeViewLayers.recycle();
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr;
        } catch (Exception unused) {
            if (sErrorBitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                sErrorBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream2);
                return byteArrayOutputStream2.toByteArray();
            }
            return bArr;
        }
    }

    public static double getScaledFactor() {
        return sScaledFactor;
    }

    public static int getScaledLong() {
        return sScaledLong;
    }

    public static int getScaledShort() {
        return sScaledShort;
    }

    public static int getScreenLong() {
        return sScreenLong;
    }

    public static int getScreenShort() {
        return sScreenShort;
    }

    public static void initial() {
        CoreAppState coreAppState;
        Context globalContext;
        if (hasInitial || (coreAppState = CoreInitialize.coreAppState()) == null || (globalContext = coreAppState.getGlobalContext()) == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) globalContext.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        if (i2 < i3) {
            sScreenShort = i2;
            sScreenLong = i3;
        } else {
            sScreenLong = i2;
            sScreenShort = i3;
        }
        double d2 = 720.0d / sScreenShort;
        sScaledFactor = d2;
        sScaledShort = 720;
        sScaledLong = (int) (d2 * sScreenLong);
        hasInitial = true;
        TextPaint textPaint = new TextPaint();
        int i4 = (int) (displayMetrics.density * 2.0f);
        Rect rect = new Rect();
        textPaint.setAntiAlias(true);
        textPaint.setColor(-13421773);
        textPaint.setTextSize(displayMetrics.density * 14.0f);
        textPaint.getTextBounds("截图失败", 0, 4, rect);
        int i5 = i4 * 2;
        sErrorBitmap = Bitmap.createBitmap(rect.width() + i5, rect.height() + i5, Bitmap.Config.ALPHA_8);
        new Canvas(sErrorBitmap).drawText("截图失败", i4, rect.height(), textPaint);
    }

    private static void invalidateLayerTypeView(View[] viewArr) {
        for (View view : viewArr) {
            if (ViewHelper.viewVisibilityInParents(view) && view.isHardwareAccelerated()) {
                checkAndInvalidate(view);
                if (view instanceof ViewGroup) {
                    invalidateViewGroup((ViewGroup) view);
                }
            }
        }
    }

    private static void invalidateViewGroup(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (ViewHelper.isViewSelfVisible(childAt)) {
                checkAndInvalidate(childAt);
                if (childAt instanceof ViewGroup) {
                    invalidateViewGroup((ViewGroup) childAt);
                }
            }
        }
    }

    static Bitmap mergeViewLayers(View[] viewArr) {
        Activity foregroundActivity = CoreInitialize.coreAppState().getForegroundActivity();
        boolean z = foregroundActivity == null || foregroundActivity.getResources().getConfiguration().orientation != 2;
        Bitmap createBitmap = Bitmap.createBitmap(z ? getScaledShort() : getScaledLong(), z ? getScaledLong() : getScaledShort(), Bitmap.Config.RGB_565);
        int[] iArr = new int[2];
        boolean z2 = ViewHelper.getMainWindowCount(viewArr) > 1;
        WindowHelper.init();
        invalidateLayerTypeView(viewArr);
        SoftWareCanvas softWareCanvas = new SoftWareCanvas(createBitmap);
        softWareCanvas.scale((float) getScaledFactor(), (float) getScaledFactor());
        for (View view : viewArr) {
            if (!(view instanceof FloatViewContainer) && view.getVisibility() == 0 && view.getWidth() != 0 && view.getHeight() != 0 && ViewHelper.isWindowNeedTraverse(view, WindowHelper.getWindowPrefix(view), z2) && !HybridEventEditDialog.DO_NOT_DRAW.equals(view.getTag())) {
                view.getLocationOnScreen(iArr);
                softWareCanvas.save();
                softWareCanvas.translate(iArr[0], iArr[1]);
                view.draw(softWareCanvas);
                softWareCanvas.restore();
                softWareCanvas.destroy();
            }
        }
        return createBitmap;
    }
}
