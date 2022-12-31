package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setAlpha(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            this.mCurveFit.getPos(f2, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j3 = j2 - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                float floatValue = keyCache.getFloatValue(view, this.mAttributeName, 0);
                this.last_cycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.last_cycle = 0.0f;
                }
            }
            float f5 = (float) ((this.last_cycle + ((j3 * 1.0E-9d) * f3)) % 1.0d);
            this.last_cycle = f5;
            this.last_time = j2;
            float calcWave = calcWave(f5);
            this.mContinue = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z = this.mContinue;
                float[] fArr3 = this.mTempValues;
                this.mContinue = z | (((double) fArr3[i2]) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                fArr2[i2] = (fArr3[i2] * calcWave) + f4;
                i2++;
            }
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mCache);
            if (f3 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i2) {
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i3 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i3];
            this.mCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i3);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i4);
                float[] valueAt = this.mWaveProperties.valueAt(i4);
                dArr[i4] = keyAt * 0.01d;
                this.mConstraintAttributeList.valueAt(i4).getValuesToInterpolate(this.mTempValues);
                int i5 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i5 < fArr.length) {
                        dArr2[i4][i5] = fArr[i5];
                        i5++;
                    }
                }
                dArr2[i4][numberOfInterpolatedValues] = valueAt[0];
                dArr2[i4][numberOfInterpolatedValues + 1] = valueAt[1];
            }
            this.mCurveFit = CurveFit.get(i2, dArr, dArr2);
        }

        public void setPoint(int i2, ConstraintAttribute constraintAttribute, float f2, int i3, float f3) {
            this.mConstraintAttributeList.append(i2, constraintAttribute);
            this.mWaveProperties.append(i2, new float[]{f2, f3});
            this.mWaveShape = Math.max(this.mWaveShape, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f2, j2, view, keyCache));
            }
            return this.mContinue;
        }
    }

    /* loaded from: classes.dex */
    public static class PathRotate extends ViewTimeCycle {
        public boolean setPathRotate(View view, KeyCache keyCache, float f2, long j2, double d2, double d3) {
            view.setRotation(get(f2, j2, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ProgressSet extends ViewTimeCycle {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f2, j2, view, keyCache));
            } else if (this.mNoMethod) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(get(f2, j2, view, keyCache)));
                    } catch (IllegalAccessException e2) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e2);
                    } catch (InvocationTargetException e3) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e3);
                    }
                }
            }
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setRotation(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setRotationX(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setRotationY(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setScaleX(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setScaleY(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setTranslationX(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            view.setTranslationY(get(f2, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f2, long j2, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f2, j2, view, keyCache));
            }
            return this.mContinue;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle makeSpline(String str, long j2) {
        ViewTimeCycle rotationXset;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                rotationXset = new RotationXset();
                break;
            case 1:
                rotationXset = new RotationYset();
                break;
            case 2:
                rotationXset = new TranslationXset();
                break;
            case 3:
                rotationXset = new TranslationYset();
                break;
            case 4:
                rotationXset = new TranslationZset();
                break;
            case 5:
                rotationXset = new ProgressSet();
                break;
            case 6:
                rotationXset = new ScaleXset();
                break;
            case 7:
                rotationXset = new ScaleYset();
                break;
            case '\b':
                rotationXset = new RotationSet();
                break;
            case '\t':
                rotationXset = new ElevationSet();
                break;
            case '\n':
                rotationXset = new PathRotate();
                break;
            case 11:
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(j2);
        return rotationXset;
    }

    public float get(float f2, long j2, View view, KeyCache keyCache) {
        this.mCurveFit.getPos(f2, this.mCache);
        float[] fArr = this.mCache;
        float f3 = fArr[1];
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i2 == 0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f4 = (float) ((this.last_cycle + (((j2 - this.last_time) * 1.0E-9d) * f3)) % 1.0d);
        this.last_cycle = f4;
        keyCache.setFloatValue(view, this.mType, 0, f4);
        this.last_time = j2;
        float f5 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f5) + this.mCache[2];
        this.mContinue = (f5 == 0.0f && i2 == 0) ? false : true;
        return calcWave;
    }

    public abstract boolean setProperty(View view, float f2, long j2, KeyCache keyCache);
}
