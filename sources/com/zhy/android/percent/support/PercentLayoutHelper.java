package com.zhy.android.percent.support;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class PercentLayoutHelper {
    private static int b;
    private static int c;
    private final ViewGroup a;

    /* loaded from: classes3.dex */
    public static class PercentLayoutInfo {
        public a a;
        public a b;
        public a c;

        /* renamed from: d  reason: collision with root package name */
        public a f8488d;

        /* renamed from: e  reason: collision with root package name */
        public a f8489e;

        /* renamed from: f  reason: collision with root package name */
        public a f8490f;

        /* renamed from: g  reason: collision with root package name */
        public a f8491g;

        /* renamed from: h  reason: collision with root package name */
        public a f8492h;

        /* renamed from: i  reason: collision with root package name */
        public a f8493i;

        /* renamed from: j  reason: collision with root package name */
        public a f8494j;

        /* renamed from: k  reason: collision with root package name */
        public a f8495k;

        /* renamed from: l  reason: collision with root package name */
        public a f8496l;
        public a m;
        public a n;
        public a o;
        public a p;
        public a q;
        final ViewGroup.MarginLayoutParams r = new ViewGroup.MarginLayoutParams(0, 0);

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public enum BASEMODE {
            BASE_WIDTH,
            BASE_HEIGHT,
            BASE_SCREEN_WIDTH,
            BASE_SCREEN_HEIGHT;
            
            public static final String H = "h";
            public static final String PERCENT = "%";
            public static final String SH = "sh";
            public static final String SW = "sw";
            public static final String W = "w";
        }

        /* loaded from: classes3.dex */
        public static class a {
            public float a = -1.0f;
            public BASEMODE b;

            public String toString() {
                return "PercentVal{percent=" + this.a + ", basemode=" + this.b.name() + '}';
            }
        }

        public void a(ViewGroup.LayoutParams layoutParams, int i2, int i3) {
            ViewGroup.MarginLayoutParams marginLayoutParams = this.r;
            marginLayoutParams.width = layoutParams.width;
            marginLayoutParams.height = layoutParams.height;
            a aVar = this.a;
            if (aVar != null) {
                layoutParams.width = (int) (PercentLayoutHelper.e(i2, i3, aVar.b) * this.a.a);
            }
            a aVar2 = this.b;
            if (aVar2 != null) {
                layoutParams.height = (int) (PercentLayoutHelper.e(i2, i3, aVar2.b) * this.b.a);
            }
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "after fillLayoutParams: (" + layoutParams.width + ", " + layoutParams.height + ")");
            }
        }

        public void b(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3) {
            a(marginLayoutParams, i2, i3);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = this.r;
            marginLayoutParams2.leftMargin = marginLayoutParams.leftMargin;
            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
            marginLayoutParams2.rightMargin = marginLayoutParams.rightMargin;
            marginLayoutParams2.bottomMargin = marginLayoutParams.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams2, MarginLayoutParamsCompat.getMarginStart(marginLayoutParams));
            MarginLayoutParamsCompat.setMarginEnd(this.r, MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams));
            a aVar = this.c;
            if (aVar != null) {
                marginLayoutParams.leftMargin = (int) (PercentLayoutHelper.e(i2, i3, aVar.b) * this.c.a);
            }
            a aVar2 = this.f8488d;
            if (aVar2 != null) {
                marginLayoutParams.topMargin = (int) (PercentLayoutHelper.e(i2, i3, aVar2.b) * this.f8488d.a);
            }
            a aVar3 = this.f8489e;
            if (aVar3 != null) {
                marginLayoutParams.rightMargin = (int) (PercentLayoutHelper.e(i2, i3, aVar3.b) * this.f8489e.a);
            }
            a aVar4 = this.f8490f;
            if (aVar4 != null) {
                marginLayoutParams.bottomMargin = (int) (PercentLayoutHelper.e(i2, i3, aVar4.b) * this.f8490f.a);
            }
            a aVar5 = this.f8491g;
            if (aVar5 != null) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, (int) (PercentLayoutHelper.e(i2, i3, aVar5.b) * this.f8491g.a));
            }
            a aVar6 = this.f8492h;
            if (aVar6 != null) {
                MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, (int) (PercentLayoutHelper.e(i2, i3, aVar6.b) * this.f8492h.a));
            }
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "after fillMarginLayoutParams: (" + marginLayoutParams.width + ", " + marginLayoutParams.height + ")");
            }
        }

        public void c(ViewGroup.LayoutParams layoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = this.r;
            layoutParams.width = marginLayoutParams.width;
            layoutParams.height = marginLayoutParams.height;
        }

        public void d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            c(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = this.r;
            marginLayoutParams.leftMargin = marginLayoutParams2.leftMargin;
            marginLayoutParams.topMargin = marginLayoutParams2.topMargin;
            marginLayoutParams.rightMargin = marginLayoutParams2.rightMargin;
            marginLayoutParams.bottomMargin = marginLayoutParams2.bottomMargin;
            MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, MarginLayoutParamsCompat.getMarginStart(marginLayoutParams2));
            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, MarginLayoutParamsCompat.getMarginEnd(this.r));
        }

        public String toString() {
            return "PercentLayoutInfo{widthPercent=" + this.a + ", heightPercent=" + this.b + ", leftMarginPercent=" + this.c + ", topMarginPercent=" + this.f8488d + ", rightMarginPercent=" + this.f8489e + ", bottomMarginPercent=" + this.f8490f + ", startMarginPercent=" + this.f8491g + ", endMarginPercent=" + this.f8492h + ", textSizePercent=" + this.f8493i + ", maxWidthPercent=" + this.f8494j + ", maxHeightPercent=" + this.f8495k + ", minWidthPercent=" + this.f8496l + ", minHeightPercent=" + this.m + ", paddingLeftPercent=" + this.n + ", paddingRightPercent=" + this.o + ", paddingTopPercent=" + this.p + ", paddingBottomPercent=" + this.q + ", mPreservedParams=" + this.r + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PercentLayoutInfo.BASEMODE.values().length];
            a = iArr;
            try {
                iArr[PercentLayoutInfo.BASEMODE.BASE_HEIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PercentLayoutInfo.BASEMODE.BASE_WIDTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PercentLayoutInfo.BASEMODE.BASE_SCREEN_WIDTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PercentLayoutInfo.BASEMODE.BASE_SCREEN_HEIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        PercentLayoutInfo a();
    }

    public PercentLayoutHelper(ViewGroup viewGroup) {
        this.a = viewGroup;
        i();
    }

    @NonNull
    private static PercentLayoutInfo c(PercentLayoutInfo percentLayoutInfo) {
        return percentLayoutInfo != null ? percentLayoutInfo : new PercentLayoutInfo();
    }

    public static void d(ViewGroup.LayoutParams layoutParams, TypedArray typedArray, int i2, int i3) {
        layoutParams.width = typedArray.getLayoutDimension(i2, 0);
        layoutParams.height = typedArray.getLayoutDimension(i3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(int i2, int i3, PercentLayoutInfo.BASEMODE basemode) {
        int i4 = a.a[basemode.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return 0;
                    }
                    return c;
                }
                return b;
            }
            return i2;
        }
        return i3;
    }

    public static PercentLayoutInfo f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PercentLayout_Layout);
        PercentLayoutInfo o = o(obtainStyledAttributes, n(obtainStyledAttributes, p(obtainStyledAttributes, m(obtainStyledAttributes, q(obtainStyledAttributes, null)))));
        obtainStyledAttributes.recycle();
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "constructed: " + o);
        }
        return o;
    }

    private static PercentLayoutInfo.a g(TypedArray typedArray, int i2, boolean z) {
        return h(typedArray.getString(i2), z);
    }

    private static PercentLayoutInfo.a h(String str, boolean z) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("^(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)%([s]?[wh]?)$").matcher(str);
        if (matcher.matches()) {
            int length = str.length();
            String group = matcher.group(1);
            str.substring(length - 1);
            PercentLayoutInfo.a aVar = new PercentLayoutInfo.a();
            aVar.a = Float.parseFloat(group) / 100.0f;
            if (str.endsWith(PercentLayoutInfo.BASEMODE.SW)) {
                aVar.b = PercentLayoutInfo.BASEMODE.BASE_SCREEN_WIDTH;
            } else if (str.endsWith(PercentLayoutInfo.BASEMODE.SH)) {
                aVar.b = PercentLayoutInfo.BASEMODE.BASE_SCREEN_HEIGHT;
            } else if (str.endsWith(PercentLayoutInfo.BASEMODE.PERCENT)) {
                if (z) {
                    aVar.b = PercentLayoutInfo.BASEMODE.BASE_WIDTH;
                } else {
                    aVar.b = PercentLayoutInfo.BASEMODE.BASE_HEIGHT;
                }
            } else if (str.endsWith(PercentLayoutInfo.BASEMODE.W)) {
                aVar.b = PercentLayoutInfo.BASEMODE.BASE_WIDTH;
            } else if (str.endsWith(PercentLayoutInfo.BASEMODE.H)) {
                aVar.b = PercentLayoutInfo.BASEMODE.BASE_HEIGHT;
            } else {
                throw new IllegalArgumentException("the " + str + " must be endWith [%|w|h|sw|sh]");
            }
            return aVar;
        }
        throw new RuntimeException("the value of layout_xxxPercent invalid! ==>" + str);
    }

    private void i() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.a.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        b = displayMetrics.widthPixels;
        c = displayMetrics.heightPixels;
    }

    private void k(String str, int i2, int i3, View view, Class cls, PercentLayoutInfo.a aVar) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", str + " ==> " + aVar);
        }
        if (aVar != null) {
            Method method = cls.getMethod(str, Integer.TYPE);
            method.setAccessible(true);
            method.invoke(view, Integer.valueOf((int) (e(i2, i3, aVar.b) * aVar.a)));
        }
    }

    private static PercentLayoutInfo m(TypedArray typedArray, PercentLayoutInfo percentLayoutInfo) {
        PercentLayoutInfo.a g2 = g(typedArray, R.styleable.PercentLayout_Layout_layout_marginPercent, true);
        if (g2 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent margin: " + g2.a);
            }
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.c = g2;
            percentLayoutInfo.f8488d = g2;
            percentLayoutInfo.f8489e = g2;
            percentLayoutInfo.f8490f = g2;
        }
        PercentLayoutInfo.a g3 = g(typedArray, R.styleable.PercentLayout_Layout_layout_marginLeftPercent, true);
        if (g3 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent left margin: " + g3.a);
            }
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.c = g3;
        }
        PercentLayoutInfo.a g4 = g(typedArray, R.styleable.PercentLayout_Layout_layout_marginTopPercent, false);
        if (g4 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent top margin: " + g4.a);
            }
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.f8488d = g4;
        }
        PercentLayoutInfo.a g5 = g(typedArray, R.styleable.PercentLayout_Layout_layout_marginRightPercent, true);
        if (g5 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent right margin: " + g5.a);
            }
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.f8489e = g5;
        }
        PercentLayoutInfo.a g6 = g(typedArray, R.styleable.PercentLayout_Layout_layout_marginBottomPercent, false);
        if (g6 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent bottom margin: " + g6.a);
            }
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.f8490f = g6;
        }
        PercentLayoutInfo.a g7 = g(typedArray, R.styleable.PercentLayout_Layout_layout_marginStartPercent, true);
        if (g7 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent start margin: " + g7.a);
            }
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.f8491g = g7;
        }
        PercentLayoutInfo.a g8 = g(typedArray, R.styleable.PercentLayout_Layout_layout_marginEndPercent, true);
        if (g8 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent end margin: " + g8.a);
            }
            PercentLayoutInfo c2 = c(percentLayoutInfo);
            c2.f8492h = g8;
            return c2;
        }
        return percentLayoutInfo;
    }

    private static PercentLayoutInfo n(TypedArray typedArray, PercentLayoutInfo percentLayoutInfo) {
        PercentLayoutInfo.a g2 = g(typedArray, R.styleable.PercentLayout_Layout_layout_maxWidthPercent, true);
        if (g2 != null) {
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.f8494j = g2;
        }
        PercentLayoutInfo.a g3 = g(typedArray, R.styleable.PercentLayout_Layout_layout_maxHeightPercent, false);
        if (g3 != null) {
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.f8495k = g3;
        }
        PercentLayoutInfo.a g4 = g(typedArray, R.styleable.PercentLayout_Layout_layout_minWidthPercent, true);
        if (g4 != null) {
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.f8496l = g4;
        }
        PercentLayoutInfo.a g5 = g(typedArray, R.styleable.PercentLayout_Layout_layout_minHeightPercent, false);
        if (g5 != null) {
            PercentLayoutInfo c2 = c(percentLayoutInfo);
            c2.m = g5;
            return c2;
        }
        return percentLayoutInfo;
    }

    private static PercentLayoutInfo o(TypedArray typedArray, PercentLayoutInfo percentLayoutInfo) {
        PercentLayoutInfo.a g2 = g(typedArray, R.styleable.PercentLayout_Layout_layout_paddingPercent, true);
        if (g2 != null) {
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.n = g2;
            percentLayoutInfo.o = g2;
            percentLayoutInfo.q = g2;
            percentLayoutInfo.p = g2;
        }
        PercentLayoutInfo.a g3 = g(typedArray, R.styleable.PercentLayout_Layout_layout_paddingLeftPercent, true);
        if (g3 != null) {
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.n = g3;
        }
        PercentLayoutInfo.a g4 = g(typedArray, R.styleable.PercentLayout_Layout_layout_paddingRightPercent, true);
        if (g4 != null) {
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.o = g4;
        }
        PercentLayoutInfo.a g5 = g(typedArray, R.styleable.PercentLayout_Layout_layout_paddingTopPercent, true);
        if (g5 != null) {
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.p = g5;
        }
        PercentLayoutInfo.a g6 = g(typedArray, R.styleable.PercentLayout_Layout_layout_paddingBottomPercent, true);
        if (g6 != null) {
            PercentLayoutInfo c2 = c(percentLayoutInfo);
            c2.q = g6;
            return c2;
        }
        return percentLayoutInfo;
    }

    private static PercentLayoutInfo p(TypedArray typedArray, PercentLayoutInfo percentLayoutInfo) {
        PercentLayoutInfo.a g2 = g(typedArray, R.styleable.PercentLayout_Layout_layout_textSizePercent, false);
        if (g2 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent text size: " + g2.a);
            }
            PercentLayoutInfo c2 = c(percentLayoutInfo);
            c2.f8493i = g2;
            return c2;
        }
        return percentLayoutInfo;
    }

    private static PercentLayoutInfo q(TypedArray typedArray, PercentLayoutInfo percentLayoutInfo) {
        PercentLayoutInfo.a g2 = g(typedArray, R.styleable.PercentLayout_Layout_layout_widthPercent, true);
        if (g2 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent width: " + g2.a);
            }
            percentLayoutInfo = c(percentLayoutInfo);
            percentLayoutInfo.a = g2;
        }
        PercentLayoutInfo.a g3 = g(typedArray, R.styleable.PercentLayout_Layout_layout_heightPercent, false);
        if (g3 != null) {
            if (Log.isLoggable("PercentLayout", 2)) {
                Log.v("PercentLayout", "percent height: " + g3.a);
            }
            PercentLayoutInfo c2 = c(percentLayoutInfo);
            c2.b = g3;
            return c2;
        }
        return percentLayoutInfo;
    }

    private static boolean r(View view, PercentLayoutInfo percentLayoutInfo) {
        PercentLayoutInfo.a aVar;
        return percentLayoutInfo != null && (aVar = percentLayoutInfo.b) != null && (ViewCompat.getMeasuredHeightAndState(view) & ViewCompat.MEASURED_STATE_MASK) == 16777216 && aVar.a >= 0.0f && percentLayoutInfo.r.height == -2;
    }

    private static boolean s(View view, PercentLayoutInfo percentLayoutInfo) {
        PercentLayoutInfo.a aVar;
        return percentLayoutInfo != null && (aVar = percentLayoutInfo.a) != null && (ViewCompat.getMeasuredWidthAndState(view) & ViewCompat.MEASURED_STATE_MASK) == 16777216 && aVar.a >= 0.0f && percentLayoutInfo.r.width == -2;
    }

    private void t(int i2, int i3, View view, PercentLayoutInfo percentLayoutInfo) {
        try {
            Class<?> cls = view.getClass();
            k("setMaxWidth", i2, i3, view, cls, percentLayoutInfo.f8494j);
            k("setMaxHeight", i2, i3, view, cls, percentLayoutInfo.f8495k);
            k("setMinWidth", i2, i3, view, cls, percentLayoutInfo.f8496l);
            k("setMinHeight", i2, i3, view, cls, percentLayoutInfo.m);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    private void u(int i2, int i3, View view, PercentLayoutInfo percentLayoutInfo) {
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        PercentLayoutInfo.a aVar = percentLayoutInfo.n;
        if (aVar != null) {
            paddingLeft = (int) (e(i2, i3, aVar.b) * aVar.a);
        }
        PercentLayoutInfo.a aVar2 = percentLayoutInfo.o;
        if (aVar2 != null) {
            paddingRight = (int) (e(i2, i3, aVar2.b) * aVar2.a);
        }
        PercentLayoutInfo.a aVar3 = percentLayoutInfo.p;
        if (aVar3 != null) {
            paddingTop = (int) (e(i2, i3, aVar3.b) * aVar3.a);
        }
        PercentLayoutInfo.a aVar4 = percentLayoutInfo.q;
        if (aVar4 != null) {
            paddingBottom = (int) (e(i2, i3, aVar4.b) * aVar4.a);
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private void v(int i2, int i3, View view, PercentLayoutInfo percentLayoutInfo) {
        PercentLayoutInfo.a aVar = percentLayoutInfo.f8493i;
        if (aVar == null) {
            return;
        }
        float e2 = (int) (e(i2, i3, aVar.b) * aVar.a);
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, e2);
        }
    }

    public void b(int i2, int i3) {
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "adjustChildren: " + this.a + " widthMeasureSpec: " + View.MeasureSpec.toString(i2) + " heightMeasureSpec: " + View.MeasureSpec.toString(i3));
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "widthHint = " + size + " , heightHint = " + size2);
        }
        int childCount = this.a.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = this.a.getChildAt(i4);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should adjust " + childAt + " " + layoutParams);
            }
            if (layoutParams instanceof b) {
                PercentLayoutInfo a2 = ((b) layoutParams).a();
                if (Log.isLoggable("PercentLayout", 3)) {
                    Log.d("PercentLayout", "using " + a2);
                }
                if (a2 != null) {
                    v(size, size2, childAt, a2);
                    u(size, size2, childAt, a2);
                    t(size, size2, childAt, a2);
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        a2.b((ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                    } else {
                        a2.a(layoutParams, size, size2);
                    }
                }
            }
        }
    }

    public boolean j() {
        PercentLayoutInfo a2;
        int childCount = this.a.getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.a.getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should handle measured state too small " + childAt + " " + layoutParams);
            }
            if ((layoutParams instanceof b) && (a2 = ((b) layoutParams).a()) != null) {
                if (s(childAt, a2)) {
                    layoutParams.width = -2;
                    z = true;
                }
                if (r(childAt, a2)) {
                    layoutParams.height = -2;
                    z = true;
                }
            }
        }
        if (Log.isLoggable("PercentLayout", 3)) {
            Log.d("PercentLayout", "should trigger second measure pass: " + z);
        }
        return z;
    }

    public void l() {
        int childCount = this.a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.a.getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (Log.isLoggable("PercentLayout", 3)) {
                Log.d("PercentLayout", "should restore " + childAt + " " + layoutParams);
            }
            if (layoutParams instanceof b) {
                PercentLayoutInfo a2 = ((b) layoutParams).a();
                if (Log.isLoggable("PercentLayout", 3)) {
                    Log.d("PercentLayout", "using " + a2);
                }
                if (a2 != null) {
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        a2.d((ViewGroup.MarginLayoutParams) layoutParams);
                    } else {
                        a2.c(layoutParams);
                    }
                }
            }
        }
    }
}
