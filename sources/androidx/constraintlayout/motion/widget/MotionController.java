package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class MotionController {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, ViewOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    View mView;
    Rect mTempRect = new Rect();
    boolean mForceMeasure = false;
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<Key> mKeyList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionController(View view) {
        int i2 = Key.UNSET;
        this.mPathMotionArc = i2;
        this.mTransformPivotTarget = i2;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i2;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
    }

    private float getAdjustedPosition(float f2, float[] fArr) {
        float f3 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.mStaggerScale;
            if (f4 != 1.0d) {
                float f5 = this.mStaggerOffset;
                if (f2 < f5) {
                    f2 = 0.0f;
                }
                if (f2 > f5 && f2 < 1.0d) {
                    f2 = Math.min((f2 - f5) * f4, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        float f6 = Float.NaN;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.mKeyFrameEasing;
            if (easing2 != null) {
                float f7 = next.time;
                if (f7 < f2) {
                    easing = easing2;
                    f3 = f7;
                } else if (Float.isNaN(f6)) {
                    f6 = next.time;
                }
            }
        }
        if (easing != null) {
            float f8 = (Float.isNaN(f6) ? 1.0f : f6) - f3;
            double d2 = (f2 - f3) / f8;
            f2 = (((float) easing.get(d2)) * f8) + f3;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d2);
            }
        }
        return f2;
    }

    private static Interpolator getInterpolator(Context context, int i2, String str, int i3) {
        if (i2 != -2) {
            if (i2 == -1) {
                final Easing interpolator = Easing.getInterpolator(str);
                return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f2) {
                        return (float) Easing.this.get(f2);
                    }
                };
            } else if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return null;
                            }
                            return new OvershootInterpolator();
                        }
                        return new BounceInterpolator();
                    }
                    return new DecelerateInterpolator();
                }
                return new AccelerateInterpolator();
            } else {
                return new AccelerateDecelerateInterpolator();
            }
        }
        return AnimationUtils.loadInterpolator(context, i3);
    }

    private float getPreCycleDistance() {
        char c;
        float f2;
        float f3;
        float[] fArr = new float[2];
        float f4 = 1.0f / 99;
        double d2 = 0.0d;
        double d3 = 0.0d;
        float f5 = 0.0f;
        int i2 = 0;
        while (i2 < 100) {
            float f6 = i2 * f4;
            double d4 = f6;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f7 = Float.NaN;
            float f8 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f9 = next.time;
                    if (f9 < f6) {
                        easing = easing2;
                        f8 = f9;
                    } else if (Float.isNaN(f7)) {
                        f7 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                d4 = (((float) easing.get((f6 - f8) / f3)) * (f7 - f8)) + f8;
            }
            this.mSpline[0].getPos(d4, this.mInterpolateData);
            float f10 = f5;
            int i3 = i2;
            this.mStartMotionPath.getCenter(d4, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i3 > 0) {
                c = 0;
                f2 = (float) (f10 + Math.hypot(d3 - fArr[1], d2 - fArr[0]));
            } else {
                c = 0;
                f2 = f10;
            }
            d2 = fArr[c];
            i2 = i3 + 1;
            f5 = f2;
            d3 = fArr[1];
        }
        return f5;
    }

    private void insertKey(MotionPaths motionPaths) {
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Log.e(TAG, " KeyPath position \"" + motionPaths.position + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    void buildBounds(float[] fArr, int i2) {
        float f2;
        float f3 = 1.0f / (i2 - 1);
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            hashMap.get("translationX");
        }
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            hashMap2.get("translationY");
        }
        HashMap<String, ViewOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            hashMap3.get("translationX");
        }
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            hashMap4.get("translationY");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            float f4 = i3 * f3;
            float f5 = this.mStaggerScale;
            float f6 = 0.0f;
            if (f5 != 1.0f) {
                float f7 = this.mStaggerOffset;
                if (f4 < f7) {
                    f4 = 0.0f;
                }
                if (f4 > f7 && f4 < 1.0d) {
                    f4 = Math.min((f4 - f7) * f5, 1.0f);
                }
            }
            double d2 = f4;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f8 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f9 = next.time;
                    if (f9 < f4) {
                        easing = easing2;
                        f6 = f9;
                    } else if (Float.isNaN(f8)) {
                        f8 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                d2 = (((float) easing.get((f4 - f6) / f2)) * (f8 - f6)) + f6;
            }
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 2);
        }
    }

    int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr != null) {
            double[] timePoints = this.mSpline[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    iArr[i2] = it.next().mMode;
                    i2++;
                }
            }
            int i3 = 0;
            for (double d2 : timePoints) {
                this.mSpline[0].getPos(d2, this.mInterpolateData);
                this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
                i3 += 2;
            }
            return i3 / 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr != null) {
            double[] timePoints = this.mSpline[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    iArr[i2] = it.next().mMode;
                    i2++;
                }
            }
            int i3 = 0;
            for (int i4 = 0; i4 < timePoints.length; i4++) {
                this.mSpline[0].getPos(timePoints[i4], this.mInterpolateData);
                this.mStartMotionPath.getCenter(timePoints[i4], this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
                i3 += 2;
            }
            return i3 / 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildPath(float[] fArr, int i2) {
        double d2;
        float f2;
        float f3 = 1.0f;
        float f4 = 1.0f / (i2 - 1);
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewSpline viewSpline = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        ViewSpline viewSpline2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewOscillator> hashMap3 = this.mCycleMap;
        ViewOscillator viewOscillator = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        ViewOscillator viewOscillator2 = hashMap4 != null ? hashMap4.get("translationY") : null;
        int i3 = 0;
        while (i3 < i2) {
            float f5 = i3 * f4;
            float f6 = this.mStaggerScale;
            if (f6 != f3) {
                float f7 = this.mStaggerOffset;
                if (f5 < f7) {
                    f5 = 0.0f;
                }
                if (f5 > f7 && f5 < 1.0d) {
                    f5 = Math.min((f5 - f7) * f6, f3);
                }
            }
            float f8 = f5;
            double d3 = f8;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f9 = Float.NaN;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f10 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                double d4 = d3;
                if (easing2 != null) {
                    float f11 = next.time;
                    if (f11 < f8) {
                        f10 = f11;
                        easing = easing2;
                    } else if (Float.isNaN(f9)) {
                        f9 = next.time;
                    }
                }
                d3 = d4;
            }
            double d5 = d3;
            if (easing != null) {
                if (Float.isNaN(f9)) {
                    f9 = 1.0f;
                }
                d2 = (((float) easing.get((f8 - f10) / f2)) * (f9 - f10)) + f10;
            } else {
                d2 = d5;
            }
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                }
            }
            int i4 = i3 * 2;
            int i5 = i3;
            this.mStartMotionPath.getCenter(d2, this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
            if (viewOscillator != null) {
                fArr[i4] = fArr[i4] + viewOscillator.get(f8);
            } else if (viewSpline != null) {
                fArr[i4] = fArr[i4] + viewSpline.get(f8);
            }
            if (viewOscillator2 != null) {
                int i6 = i4 + 1;
                fArr[i6] = fArr[i6] + viewOscillator2.get(f8);
            } else if (viewSpline2 != null) {
                int i7 = i4 + 1;
                fArr[i7] = fArr[i7] + viewSpline2.get(f8);
            }
            i3 = i5 + 1;
            f3 = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildRect(float f2, float[] fArr, int i2) {
        this.mSpline[0].getPos(getAdjustedPosition(f2, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void buildRectangles(float[] fArr, int i2) {
        float f2 = 1.0f / (i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            this.mSpline[0].getPos(getAdjustedPosition(i3 * f2, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endTrigger(boolean z) {
        if (!"button".equals(Debug.getName(this.mView)) || this.mKeyTriggers == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
            if (i2 >= keyTriggerArr.length) {
                return;
            }
            keyTriggerArr[i2].conditionallyFire(z ? -100.0f : 100.0f, this.mView);
            i2++;
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAttributeValues(String str, float[] fArr, int i2) {
        ViewSpline viewSpline = this.mAttributesMap.get(str);
        if (viewSpline == null) {
            return -1;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = viewSpline.get(i3 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d2, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d2, dArr);
        this.mSpline[0].getSlope(d2, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d2, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getDpDt(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i2 = 0;
        if (curveFitArr != null) {
            double d2 = adjustedPosition;
            curveFitArr[0].getSlope(d2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            float f5 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] * f5;
                i2++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d2, dArr2);
                    this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        float f6 = motionPaths.x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f7 = f6 - motionPaths2.x;
        float f8 = motionPaths.y - motionPaths2.y;
        float f9 = (motionPaths.width - motionPaths2.width) + f7;
        float f10 = (motionPaths.height - motionPaths2.height) + f8;
        fArr[0] = (f7 * (1.0f - f3)) + (f9 * f3);
        fArr[1] = (f8 * (1.0f - f4)) + (f10 * f4);
    }

    public int getDrawPath() {
        int i2 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i2 = Math.max(i2, it.next().mDrawPath);
        }
        return Math.max(i2, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.height;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.width;
    }

    public float getFinalX() {
        return this.mEndMotionPath.x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionPaths getKeyFrame(int i2) {
        return this.mMotionPaths.get(i2);
    }

    public int getKeyFrameInfo(int i2, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i5 = next.mType;
            if (i5 == i2 || i2 != -1) {
                iArr[i4] = 0;
                int i6 = i4 + 1;
                iArr[i6] = i5;
                int i7 = i6 + 1;
                int i8 = next.mFramePosition;
                iArr[i7] = i8;
                double d2 = i8 / 100.0f;
                this.mSpline[0].getPos(d2, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d2, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                int i9 = i7 + 1;
                iArr[i9] = Float.floatToIntBits(fArr[0]);
                int i10 = i9 + 1;
                iArr[i10] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    int i11 = i10 + 1;
                    iArr[i11] = keyPosition.mPositionType;
                    int i12 = i11 + 1;
                    iArr[i12] = Float.floatToIntBits(keyPosition.mPercentX);
                    i10 = i12 + 1;
                    iArr[i10] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i13 = i10 + 1;
                iArr[i4] = i13 - i4;
                i3++;
                i4 = i13;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getKeyFrameParameter(int i2, float f2, float f3) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f4 = motionPaths.x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f5 = motionPaths2.x;
        float f6 = f4 - f5;
        float f7 = motionPaths.y;
        float f8 = motionPaths2.y;
        float f9 = f7 - f8;
        float f10 = f5 + (motionPaths2.width / 2.0f);
        float f11 = f8 + (motionPaths2.height / 2.0f);
        float hypot = (float) Math.hypot(f6, f9);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f12 = f2 - f10;
        float f13 = f3 - f11;
        if (((float) Math.hypot(f12, f13)) == 0.0f) {
            return 0.0f;
        }
        float f14 = (f12 * f6) + (f13 * f9);
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return 0.0f;
                            }
                            return f13 / f9;
                        }
                        return f12 / f9;
                    }
                    return f13 / f6;
                }
                return f12 / f6;
            }
            return (float) Math.sqrt((hypot * hypot) - (f14 * f14));
        }
        return f14 / hypot;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.mKeyList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i4 = next.mFramePosition;
            iArr[i2] = (next.mType * 1000) + i4;
            double d2 = i4 / 100.0f;
            this.mSpline[0].getPos(d2, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d2, this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            i3 += 2;
            i2++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double[] getPos(double d2) {
        this.mSpline[0].getPos(d2, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d2, dArr);
            }
        }
        return this.mInterpolateData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyPositionBase getPositionKeyframe(int i2, int i3, float f2, float f3) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f4 = motionPaths.x;
        rectF.left = f4;
        float f5 = motionPaths.y;
        rectF.top = f5;
        rectF.right = f4 + motionPaths.width;
        rectF.bottom = f5 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f6 = motionPaths2.x;
        rectF2.left = f6;
        float f7 = motionPaths2.y;
        rectF2.top = f7;
        rectF2.right = f6 + motionPaths2.width;
        rectF2.bottom = f7 + motionPaths2.height;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                if (keyPositionBase.intersects(i2, i3, rectF, rectF2, f2, f3)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getPostLayoutDvDp(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        ViewSpline viewSpline = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.mAttributesMap;
        ViewSpline viewSpline2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewSpline> hashMap3 = this.mAttributesMap;
        ViewSpline viewSpline3 = hashMap3 == null ? null : hashMap3.get(Key.ROTATION);
        HashMap<String, ViewSpline> hashMap4 = this.mAttributesMap;
        ViewSpline viewSpline4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, ViewSpline> hashMap5 = this.mAttributesMap;
        ViewSpline viewSpline5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, ViewOscillator> hashMap6 = this.mCycleMap;
        ViewOscillator viewOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, ViewOscillator> hashMap7 = this.mCycleMap;
        ViewOscillator viewOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, ViewOscillator> hashMap8 = this.mCycleMap;
        ViewOscillator viewOscillator3 = hashMap8 == null ? null : hashMap8.get(Key.ROTATION);
        HashMap<String, ViewOscillator> hashMap9 = this.mCycleMap;
        ViewOscillator viewOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, ViewOscillator> hashMap10 = this.mCycleMap;
        ViewOscillator viewOscillator5 = hashMap10 != null ? hashMap10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
        velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d2 = adjustedPosition;
                curveFit.getPos(d2, dArr);
                this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f5 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i4 < dArr2.length) {
                    dArr2[i4] = dArr2[i4] * f5;
                    i4++;
                } else {
                    this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f6 = motionPaths.x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f7 = f6 - motionPaths2.x;
            float f8 = motionPaths.y - motionPaths2.y;
            ViewOscillator viewOscillator6 = viewOscillator4;
            float f9 = (motionPaths.height - motionPaths2.height) + f8;
            fArr[0] = (f7 * (1.0f - f3)) + (((motionPaths.width - motionPaths2.width) + f7) * f3);
            fArr[1] = (f8 * (1.0f - f4)) + (f9 * f4);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
            velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewOscillator6, viewOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.height;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.width;
    }

    public float getStartX() {
        return this.mStartMotionPath.x;
    }

    public float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public View getView() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean interpolate(View view, float f2, long j2, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean z;
        char c;
        double d2;
        View view2;
        float f3;
        float adjustedPosition = getAdjustedPosition(f2, null);
        int i2 = this.mQuantizeMotionSteps;
        if (i2 != Key.UNSET) {
            float f4 = 1.0f / i2;
            float floor = ((float) Math.floor(adjustedPosition / f4)) * f4;
            float f5 = (adjustedPosition % f4) / f4;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f5 = (f5 + this.mQuantizeMotionPhase) % 1.0f;
            }
            Interpolator interpolator = this.mQuantizeMotionInterpolator;
            if (interpolator != null) {
                f3 = interpolator.getInterpolation(f5);
            } else {
                f3 = ((double) f5) > 0.5d ? 1.0f : 0.0f;
            }
            adjustedPosition = (f3 * f4) + floor;
        }
        float f6 = adjustedPosition;
        HashMap<String, ViewSpline> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            for (ViewSpline viewSpline : hashMap.values()) {
                viewSpline.setProperty(view, f6);
            }
        }
        HashMap<String, ViewTimeCycle> hashMap2 = this.mTimeCycleAttributesMap;
        if (hashMap2 != null) {
            ViewTimeCycle.PathRotate pathRotate2 = null;
            boolean z2 = false;
            for (ViewTimeCycle viewTimeCycle : hashMap2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate2 = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    z2 |= viewTimeCycle.setProperty(view, f6, j2, keyCache);
                }
            }
            z = z2;
            pathRotate = pathRotate2;
        } else {
            pathRotate = null;
            z = false;
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d3 = f6;
            curveFitArr[0].getPos(d3, this.mInterpolateData);
            this.mSpline[0].getSlope(d3, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d3, dArr);
                    this.mArcSpline.getSlope(d3, this.mInterpolateVelocity);
                }
            }
            if (this.mNoMovement) {
                d2 = d3;
            } else {
                d2 = d3;
                this.mStartMotionPath.setView(f6, view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
                this.mForceMeasure = false;
            }
            if (this.mTransformPivotTarget != Key.UNSET) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = ((View) view.getParent()).findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float top = (view2.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
                    float left = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(left - view.getLeft());
                        view.setPivotY(top - view.getTop());
                    }
                }
            }
            HashMap<String, ViewSpline> hashMap3 = this.mAttributesMap;
            if (hashMap3 != null) {
                for (ViewSpline viewSpline2 : hashMap3.values()) {
                    if (viewSpline2 instanceof ViewSpline.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        if (dArr2.length > 1) {
                            ((ViewSpline.PathRotate) viewSpline2).setPathRotate(view, f6, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                c = 1;
                z |= pathRotate.setPathRotate(view, keyCache, f6, j2, dArr3[0], dArr3[1]);
            } else {
                c = 1;
            }
            int i3 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i3 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i3].getPos(d2, this.mValuesBuff);
                CustomSupport.setInterpolatedValue(this.mStartMotionPath.attributes.get(this.mAttributeNames[i3 - 1]), view, this.mValuesBuff);
                i3++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f6 <= 0.0f) {
                    int i4 = motionConstrainedPoint.visibility;
                    view.setVisibility(i4);
                    VdsAgent.onSetViewVisibility(view, i4);
                } else if (f6 >= 1.0f) {
                    int i5 = this.mEndPoint.visibility;
                    view.setVisibility(i5);
                    VdsAgent.onSetViewVisibility(view, i5);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    view.setVisibility(0);
                    VdsAgent.onSetViewVisibility(view, 0);
                }
            }
            if (this.mKeyTriggers != null) {
                int i6 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i6 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i6].conditionallyFire(f6, view);
                    i6++;
                }
            }
        } else {
            c = 1;
            MotionPaths motionPaths = this.mStartMotionPath;
            float f7 = motionPaths.x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float f8 = f7 + ((motionPaths2.x - f7) * f6);
            float f9 = motionPaths.y;
            float f10 = f9 + ((motionPaths2.y - f9) * f6);
            float f11 = motionPaths.width;
            float f12 = motionPaths2.width;
            float f13 = motionPaths.height;
            float f14 = motionPaths2.height;
            float f15 = f8 + 0.5f;
            int i7 = (int) f15;
            float f16 = f10 + 0.5f;
            int i8 = (int) f16;
            int i9 = (int) (f15 + ((f12 - f11) * f6) + f11);
            int i10 = (int) (f16 + ((f14 - f13) * f6) + f13);
            int i11 = i9 - i7;
            int i12 = i10 - i8;
            if (f12 != f11 || f14 != f13 || this.mForceMeasure) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
                this.mForceMeasure = false;
            }
            view.layout(i7, i8, i9, i10);
        }
        HashMap<String, ViewOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            for (ViewOscillator viewOscillator : hashMap4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((ViewOscillator.PathRotateSet) viewOscillator).setPathRotate(view, f6, dArr4[0], dArr4[c]);
                } else {
                    viewOscillator.setProperty(view, f6);
                }
            }
        }
        return z;
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f2, float f3, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f4 = motionPaths.x;
        rectF.left = f4;
        float f5 = motionPaths.y;
        rectF.top = f5;
        rectF.right = f4 + motionPaths.width;
        rectF.bottom = f5 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f6 = motionPaths2.x;
        rectF2.left = f6;
        float f7 = motionPaths2.y;
        rectF2.top = f7;
        rectF2.right = f6 + motionPaths2.width;
        rectF2.bottom = f7 + motionPaths2.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f2, f3, strArr, fArr);
    }

    public void remeasure() {
        this.mForceMeasure = true;
    }

    void rotate(Rect rect, Rect rect2, int i2, int i3, int i4) {
        if (i2 == 1) {
            int i5 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i4 - ((i5 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i2 == 2) {
            int i6 = rect.left + rect.right;
            rect2.left = i3 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i6 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            int i7 = rect.left + rect.right;
            rect2.left = i3 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = (i7 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else {
            int i8 = rect.left + rect.right;
            int i9 = rect.top;
            int i10 = rect.bottom;
            rect2.left = ((rect.height() / 2) + rect.top) - (i8 / 2);
            rect2.top = i4 - ((i8 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBothStates(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i2) {
        this.mStartMotionPath.mDrawPath = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEndState(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        int i4 = constraintSet.mRotate;
        if (i4 != 0) {
            rotate(rect, this.mTempRect, i4, i2, i3);
            rect = this.mTempRect;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(rect, constraintSet, i4, this.mId);
    }

    public void setPathMotionArc(int i2) {
        this.mPathMotionArc = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ViewState viewState, View view, int i2, int i3, int i4) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        Rect rect = new Rect();
        if (i2 == 1) {
            int i5 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i3 - ((i5 + viewState.height()) / 2);
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        } else if (i2 == 2) {
            int i6 = viewState.left + viewState.right;
            rect.left = i4 - (((viewState.top + viewState.bottom) + viewState.width()) / 2);
            rect.top = (i6 - viewState.height()) / 2;
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, view, i2, viewState.rotation);
    }

    public void setTransformPivotTarget(int i2) {
        this.mTransformPivotTarget = i2;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i2, int i3, float f2, long j2) {
        ArrayList arrayList;
        String[] strArr;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle makeSpline;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        ViewSpline makeSpline2;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i4 = this.mPathMotionArc;
        if (i4 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i4;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    insertKey(new MotionPaths(i2, i3, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i5 = keyPosition.mCurveFit;
                    if (i5 != Key.UNSET) {
                        this.mCurveFitType = i5;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        char c = 0;
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c2 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(",")[c2];
                    Iterator<Key> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        Key next3 = it3.next();
                        HashMap<String, ConstraintAttribute> hashMap2 = next3.mCustomConstraints;
                        if (hashMap2 != null && (constraintAttribute3 = hashMap2.get(str)) != null) {
                            sparseArray.append(next3.mFramePosition, constraintAttribute3);
                        }
                    }
                    makeSpline2 = ViewSpline.makeCustomSpline(next2, sparseArray);
                } else {
                    makeSpline2 = ViewSpline.makeSpline(next2);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next2);
                    this.mAttributesMap.put(next2, makeSpline2);
                }
                c2 = 1;
            }
            ArrayList<Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<Key> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    Key next4 = it4.next();
                    if (next4 instanceof KeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int intValue = (!hashMap.containsKey(str2) || (num = hashMap.get(str2)) == null) ? 0 : num.intValue();
                ViewSpline viewSpline = this.mAttributesMap.get(str2);
                if (viewSpline != null) {
                    viewSpline.setup(intValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(",")[1];
                        Iterator<Key> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            Key next6 = it6.next();
                            HashMap<String, ConstraintAttribute> hashMap3 = next6.mCustomConstraints;
                            if (hashMap3 != null && (constraintAttribute2 = hashMap3.get(str3)) != null) {
                                sparseArray2.append(next6.mFramePosition, constraintAttribute2);
                            }
                        }
                        makeSpline = ViewTimeCycle.makeCustomSpline(next5, sparseArray2);
                    } else {
                        makeSpline = ViewTimeCycle.makeSpline(next5, j2);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next5);
                        this.mTimeCycleAttributesMap.put(next5, makeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<Key> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    Key next7 = it7.next();
                    if (next7 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int i6 = 2;
        int size = this.mMotionPaths.size() + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[size];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
        int i7 = 1;
        while (it8.hasNext()) {
            motionPathsArr[i7] = it8.next();
            i7++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i8 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i8 >= strArr.length) {
                break;
            }
            String str6 = strArr[i8];
            this.mAttributeInterpolatorCount[i8] = 0;
            int i9 = 0;
            while (true) {
                if (i9 >= size) {
                    break;
                }
                if (motionPathsArr[i9].attributes.containsKey(str6) && (constraintAttribute = motionPathsArr[i9].attributes.get(str6)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i8] = iArr[i8] + constraintAttribute.numberOfInterpolatedValues();
                    break;
                }
                i9++;
            }
            i8++;
        }
        boolean z = motionPathsArr[0].mPathMotionArc != Key.UNSET;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 1; i10 < size; i10++) {
            motionPathsArr[i10].different(motionPathsArr[i10 - 1], zArr, this.mAttributeNames, z);
        }
        int i11 = 0;
        for (int i12 = 1; i12 < length; i12++) {
            if (zArr[i12]) {
                i11++;
            }
        }
        this.mInterpolateVariables = new int[i11];
        int max = Math.max(2, i11);
        this.mInterpolateData = new double[max];
        this.mInterpolateVelocity = new double[max];
        int i13 = 0;
        for (int i14 = 1; i14 < length; i14++) {
            if (zArr[i14]) {
                this.mInterpolateVariables[i13] = i14;
                i13++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance(double.class, size, this.mInterpolateVariables.length);
        double[] dArr2 = new double[size];
        for (int i15 = 0; i15 < size; i15++) {
            motionPathsArr[i15].fillStandard(dArr[i15], this.mInterpolateVariables);
            dArr2[i15] = motionPathsArr[i15].time;
        }
        int i16 = 0;
        while (true) {
            int[] iArr2 = this.mInterpolateVariables;
            if (i16 >= iArr2.length) {
                break;
            }
            if (iArr2[i16] < MotionPaths.names.length) {
                String str7 = MotionPaths.names[this.mInterpolateVariables[i16]] + " [";
                for (int i17 = 0; i17 < size; i17++) {
                    str7 = str7 + dArr[i17][i16];
                }
            }
            i16++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i18 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i18 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i18];
            int i19 = 0;
            double[] dArr3 = null;
            int i20 = 0;
            double[][] dArr4 = null;
            while (i19 < size) {
                if (motionPathsArr[i19].hasCustomData(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr3 = new int[i6];
                        iArr3[1] = motionPathsArr[i19].getCustomDataCount(str8);
                        iArr3[c] = size;
                        dArr4 = (double[][]) Array.newInstance(double.class, iArr3);
                    }
                    dArr3[i20] = motionPathsArr[i19].time;
                    motionPathsArr[i19].getCustomData(str8, dArr4[i20], 0);
                    i20++;
                }
                i19++;
                i6 = 2;
                c = 0;
            }
            i18++;
            this.mSpline[i18] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i20), (double[][]) Arrays.copyOf(dArr4, i20));
            i6 = 2;
            c = 0;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr4 = new int[size];
            double[] dArr5 = new double[size];
            double[][] dArr6 = (double[][]) Array.newInstance(double.class, size, 2);
            for (int i21 = 0; i21 < size; i21++) {
                iArr4[i21] = motionPathsArr[i21].mPathMotionArc;
                dArr5[i21] = motionPathsArr[i21].time;
                dArr6[i21][0] = motionPathsArr[i21].x;
                dArr6[i21][1] = motionPathsArr[i21].y;
            }
            this.mArcSpline = CurveFit.getArc(iArr4, dArr5, dArr6);
        }
        float f3 = Float.NaN;
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it9 = hashSet3.iterator();
            while (it9.hasNext()) {
                String next8 = it9.next();
                ViewOscillator makeSpline3 = ViewOscillator.makeSpline(next8);
                if (makeSpline3 != null) {
                    if (makeSpline3.variesByPath() && Float.isNaN(f3)) {
                        f3 = getPreCycleDistance();
                    }
                    makeSpline3.setType(next8);
                    this.mCycleMap.put(next8, makeSpline3);
                }
            }
            Iterator<Key> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                Key next9 = it10.next();
                if (next9 instanceof KeyCycle) {
                    ((KeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            for (ViewOscillator viewOscillator : this.mCycleMap.values()) {
                viewOscillator.setup(f3);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartState(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        int i4 = constraintSet.mRotate;
        if (i4 != 0) {
            rotate(rect, this.mTempRect, i4, i2, i3);
        }
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        readView(motionPaths);
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(rect, constraintSet, i4, this.mId);
        this.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        ConstraintSet.Motion motion = parameters.motion;
        this.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
        this.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
        Context context = this.mView.getContext();
        ConstraintSet.Motion motion2 = parameters.motion;
        this.mQuantizeMotionInterpolator = getInterpolator(context, motion2.mQuantizeInterpolatorType, motion2.mQuantizeInterpolatorString, motion2.mQuantizeInterpolatorID);
    }
}
