package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$DecorView;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* renamed from: com.facebook.ads.redexgen.X.3F  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C3F extends ViewGroup {
    public static byte[] A0u;
    public static String[] A0v = {"Pb5dMBpLoD8olSqqN3M1wt71s6WfJWWx", "mawes8eGWKEfT5kg0DwbKE", "yCX0UAcI", "nBGVAWTalDrx8Q3Q0HTp4hPpqgaJoZ5h", "", "", "gKpLqM1fc4CgqUT7jB7tIrf4xsKdVFyY", "wKHjR3FqXT8StRIGs0zAAfuJmbbhub4H"};
    public static final int[] A0w;
    public static final Interpolator A0x;
    public static final C3E A0y;
    public static final Comparator<AnonymousClass37> A0z;
    public int A00;
    public AbstractC05342m A01;
    public float A02;
    public float A03;
    public float A04;
    public float A05;
    public float A06;
    public float A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public int A0H;
    public int A0I;
    public int A0J;
    public int A0K;
    public int A0L;
    public int A0M;
    public int A0N;
    public int A0O;
    public int A0P;
    public int A0Q;
    public int A0R;
    public Drawable A0S;
    public Parcelable A0T;
    public VelocityTracker A0U;
    public EdgeEffect A0V;
    public EdgeEffect A0W;
    public Scroller A0X;
    public C3A A0Y;
    public C3A A0Z;
    public C3B A0a;
    public C3C A0b;
    public ClassLoader A0c;
    public ArrayList<View> A0d;
    public List<ViewPager.OnAdapterChangeListener> A0e;
    public List<C3A> A0f;
    public boolean A0g;
    public boolean A0h;
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public boolean A0l;
    public boolean A0m;
    public boolean A0n;
    public boolean A0o;
    public boolean A0p;
    public final Rect A0q;
    public final AnonymousClass37 A0r;
    public final Runnable A0s;
    public final ArrayList<AnonymousClass37> A0t;

    public static String A08(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0u, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 104);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A0u = new byte[]{-99, -70, -69, -99, -62, -14, 3, 9, 7, 20, -62, 5, 14, 3, 21, 21, -36, -62, -48, 0, 17, 23, 21, 34, -48, 25, 20, -22, -48, -34, 14, 48, 45, 32, 42, 35, 43, 31, 50, 39, 33, -34, 31, 34, 31, 46, 50, 35, 48, -8, -34, -30, 54, 49, 49, -30, 53, 47, 35, 46, 46, -3, -30, 38, 39, 40, 35, 55, 46, 54, 43, 48, 41, -30, 54, 49, -30, -66, -78, -8, 1, 7, 0, -10, -52, -78, -69, -39, -26, -26, -25, -20, -104, -39, -36, -36, -104, -24, -39, -33, -35, -22, -104, -36, -35, -37, -25, -22, -104, -18, -31, -35, -17, -104, -36, -19, -22, -31, -26, -33, -104, -28, -39, -15, -25, -19, -20, -10, 9, 21, 25, 9, 23, 24, 9, 8, -60, 19, 10, 10, 23, 7, 22, 9, 9, 18, -60, 20, 5, 11, 9, -60, 16, Draft_75.CR, 17, Draft_75.CR, 24, -60, -10, 10, 7, -62, 3, 18, 18, 14, 11, 5, 3, 22, 11, 17, 16, -55, 21, -62, -14, 3, 9, 7, 20, -29, 6, 3, 18, 22, 7, 20, -62, 5, 10, 3, 16, 9, 7, 6, -62, 22, 10, 7, -62, 3, 6, 3, 18, 22, 7, 20, -55, 21, -62, 5, 17, 16, 22, 7, 16, 22, 21, -62, 25, 11, 22, 10, 17, 23, 22, -62, 5, 3, 14, 14, 11, 16, 9, -62, -14, 3, 9, 7, 20, -29, 6, 3, 18, 22, 7, 20, -59, 16, 17, 22, 11, 8, 27, -26, 3, 22, 3, -11, 7, 22, -27, 10, 3, 16, 9, 7, 6, -61, -62, -25, 26, 18, 7, 5, 22, 7, 6, -62, 3, 6, 3, 18, 22, 7, 20, -62, 11, 22, 7, 15, -62, 5, 17, 23, 16, 22, -36, -62, -19, 0, -4, 14, -25, -8, -2, -4, 9, 25, 42, 42, 39, 47, 11, 27, 42, 39, 36, 36, -40, 44, 42, 33, 29, 28, -40, 44, 39, -40, 30, 33, 38, 28, -40, 30, 39, 27, 45, 43, -40, 26, 25, 43, 29, 28, -40, 39, 38, -40, 38, 39, 38, -27, 27, 32, 33, 36, 28, -40, 27, 45, 42, 42, 29, 38, 44, -40, 30, 39, 27, 45, 43, 29, 28, -40, 46, 33, 29, 47, -40, 76, 75, 30, 65, 62, 77, 81, 66, 79, 32, 69, 62, 75, 68, 66, 65, 19, 18, -12, 5, 11, 9, -9, 7, 22, 19, 16, 16, 9, 8, -60, 8, Draft_75.CR, 8, -60, 18, 19, 24, -60, 7, 5, 16, 16, -60, 23, 25, 20, 9, 22, 7, 16, 5, 23, 23, -60, Draft_75.CR, 17, 20, 16, 9, 17, 9, 18, 24, 5, 24, Draft_75.CR, 19, 18, 85, 83, 66, 79, 84, 71, 80, 83, 78, 49, 66, 72, 70};
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.facebook.ads.redexgen.X.3E] */
    static {
        A0C();
        A0w = new int[]{16842931};
        A0z = new Comparator<AnonymousClass37>() { // from class: com.facebook.ads.redexgen.X.33
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* renamed from: A00 */
            public final int compare(AnonymousClass37 anonymousClass37, AnonymousClass37 anonymousClass372) {
                return anonymousClass37.A02 - anonymousClass372.A02;
            }
        };
        A0x = new Interpolator() { // from class: com.facebook.ads.redexgen.X.34
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
        A0y = new Comparator<View>() { // from class: com.facebook.ads.redexgen.X.3E
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* renamed from: A00 */
            public final int compare(View view, View view2) {
                AnonymousClass38 anonymousClass38 = (AnonymousClass38) view.getLayoutParams();
                AnonymousClass38 anonymousClass382 = (AnonymousClass38) view2.getLayoutParams();
                if (anonymousClass38.A05 != anonymousClass382.A05) {
                    return anonymousClass38.A05 ? 1 : -1;
                }
                return anonymousClass38.A02 - anonymousClass382.A02;
            }
        };
    }

    public C3F(Context context) {
        super(context);
        this.A0t = new ArrayList<>();
        this.A0r = new AnonymousClass37();
        this.A0q = new Rect();
        this.A0O = -1;
        this.A0T = null;
        this.A0c = null;
        this.A02 = -3.4028235E38f;
        this.A07 = Float.MAX_VALUE;
        this.A0L = 1;
        this.A08 = -1;
        this.A0i = true;
        this.A0n = false;
        this.A0s = new Runnable() { // from class: com.facebook.ads.redexgen.X.35
            @Override // java.lang.Runnable
            public final void run() {
                C3F.this.setScrollState(0);
                C3F.this.A0f();
            }
        };
        this.A0P = 0;
        A0D();
    }

    private final float A00(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private int A01(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) > this.A0H && Math.abs(i3) > this.A0K) {
            if (i3 <= 0) {
                i2++;
            }
        } else {
            i2 += (int) (f2 + (i2 >= this.A00 ? 0.4f : 0.6f));
        }
        if (this.A0t.size() > 0) {
            ArrayList<AnonymousClass37> arrayList = this.A0t;
            return Math.max(this.A0t.get(0).A02, Math.min(i2, arrayList.get(arrayList.size() - 1).A02));
        }
        return i2;
    }

    private Rect A02(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private AnonymousClass37 A03() {
        int clientWidth = getClientWidth();
        float scrollOffset = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        if (clientWidth > 0) {
            float scrollOffset2 = this.A0M;
            scrollOffset = scrollOffset2 / clientWidth;
        }
        int i2 = -1;
        float leftBound = 0.0f;
        float rightBound = 0.0f;
        boolean z = true;
        AnonymousClass37 anonymousClass37 = null;
        int i3 = 0;
        while (i3 < this.A0t.size()) {
            AnonymousClass37 anonymousClass372 = this.A0t.get(i3);
            if (!z && anonymousClass372.A02 != i2 + 1) {
                anonymousClass372 = this.A0r;
                anonymousClass372.A00 = leftBound + rightBound + scrollOffset;
                anonymousClass372.A02 = i2 + 1;
                anonymousClass372.A01 = this.A01.A04(anonymousClass372.A02);
                i3--;
            }
            leftBound = anonymousClass372.A00;
            float rightBound2 = anonymousClass372.A01 + leftBound + scrollOffset;
            if (!z) {
                int i4 = (scrollX > leftBound ? 1 : (scrollX == leftBound ? 0 : -1));
                String[] strArr = A0v;
                if (strArr[4].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0v;
                strArr2[3] = "VrUwTTzuyHD2SkMMCenWDHvarMqbXCCI";
                strArr2[6] = "LX2NnyEsDXWEx3dFbPH8p7fzI1U1dTZ8";
                if (i4 < 0) {
                    return anonymousClass37;
                }
            }
            if (scrollX >= rightBound2) {
                int size = this.A0t.size() - 1;
                String[] strArr3 = A0v;
                if (strArr3[3].charAt(15) != strArr3[6].charAt(15)) {
                    A0v[2] = "sbP3P6ChvdnfvWI";
                    if (i3 != size) {
                        z = false;
                        i2 = anonymousClass372.A02;
                        rightBound = anonymousClass372.A01;
                        anonymousClass37 = anonymousClass372;
                        i3++;
                    }
                } else {
                    A0v[1] = "kvGf4Zg53U8bz7GLeUNnCLzy4o";
                    if (i3 != size) {
                        z = false;
                        i2 = anonymousClass372.A02;
                        rightBound = anonymousClass372.A01;
                        anonymousClass37 = anonymousClass372;
                        i3++;
                    }
                }
            }
            return anonymousClass372;
        }
        return anonymousClass37;
    }

    private final AnonymousClass37 A04(int i2) {
        for (int i3 = 0; i3 < this.A0t.size(); i3++) {
            AnonymousClass37 anonymousClass37 = this.A0t.get(i3);
            if (anonymousClass37.A02 == i2) {
                return anonymousClass37;
            }
        }
        return null;
    }

    private final AnonymousClass37 A05(int i2, int i3) {
        AnonymousClass37 anonymousClass37 = new AnonymousClass37();
        anonymousClass37.A02 = i2;
        anonymousClass37.A03 = this.A01.A08(this, i2);
        anonymousClass37.A01 = this.A01.A04(i2);
        if (i3 < 0 || i3 >= this.A0t.size()) {
            this.A0t.add(anonymousClass37);
        } else {
            this.A0t.add(i3, anonymousClass37);
        }
        return anonymousClass37;
    }

    private final AnonymousClass37 A06(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return A07(view);
            }
        }
    }

    private final AnonymousClass37 A07(View view) {
        for (int i2 = 0; i2 < this.A0t.size(); i2++) {
            AnonymousClass37 anonymousClass37 = this.A0t.get(i2);
            if (this.A01.A0C(view, anonymousClass37.A03)) {
                return anonymousClass37;
            }
        }
        String[] strArr = A0v;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A0v[1] = "T6ty";
        return null;
    }

    private void A09() {
        this.A0k = false;
        this.A0m = false;
        VelocityTracker velocityTracker = this.A0U;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            String[] strArr = A0v;
            if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            A0v[1] = "yoRarqzFlsm2scdQtgnfRphmjo";
            this.A0U = null;
        }
    }

    private void A0A() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            AnonymousClass38 lp = (AnonymousClass38) getChildAt(i2).getLayoutParams();
            if (!lp.A05) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void A0B() {
        if (this.A0F != 0) {
            ArrayList<View> arrayList = this.A0d;
            if (arrayList == null) {
                this.A0d = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.A0d.add(getChildAt(i2));
            }
            Collections.sort(this.A0d, A0y);
        }
    }

    private final void A0D() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.A0X = new Scroller(context, A0x);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.A0R = viewConfiguration.getScaledPagingTouchSlop();
        this.A0K = (int) (400.0f * f2);
        this.A0J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.A0V = new EdgeEffect(context);
        this.A0W = new EdgeEffect(context);
        this.A0H = (int) (25.0f * f2);
        this.A0C = (int) (2.0f * f2);
        this.A0E = (int) (16.0f * f2);
        AnonymousClass31.A0B(this, new C1479bp(this));
        if (AnonymousClass31.A00(this) == 0) {
            AnonymousClass31.A09(this, 1);
        }
        AnonymousClass31.A0C(this, new C1480bq(this));
    }

    private void A0E(int i2) {
        C3A c3a = this.A0Z;
        List<C3A> list = this.A0f;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.A0f.get(i3);
            }
        }
        C3A c3a2 = this.A0Y;
    }

    private void A0F(int i2) {
        C3A c3a = this.A0Z;
        List<C3A> list = this.A0f;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.A0f.get(i3);
            }
        }
        C3A c3a2 = this.A0Y;
    }

    /* JADX WARN: Incorrect condition in loop: B:152:0x0381 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void A0G(int r16) {
        /*
            Method dump skipped, instructions count: 934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3F.A0G(int):void");
    }

    private void A0H(int i2, float f2, int i3) {
        C3A c3a = this.A0Z;
        List<C3A> list = this.A0f;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.A0f.get(i4);
            }
        }
        C3A c3a2 = this.A0Y;
    }

    @CallSuper
    private final void A0I(int scrollX, float f2, int paddingLeft) {
        int max;
        if (this.A0D > 0) {
            int i2 = getScrollX();
            int paddingLeft2 = getPaddingLeft();
            int paddingRight = getPaddingRight();
            if (A0v[1].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0v;
            strArr[3] = "hSwONVQ9BwzgmNPK4tziO3X6uj4eQvsQ";
            strArr[6] = "gKhZoL4mhYlFRC9fFMXnjqdiW6EOuKfZ";
            int width = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                AnonymousClass38 anonymousClass38 = (AnonymousClass38) childAt.getLayoutParams();
                if (anonymousClass38.A05) {
                    int i4 = anonymousClass38.A04 & 7;
                    if (i4 == 1) {
                        int childOffset = childAt.getMeasuredWidth();
                        max = Math.max((width - childOffset) / 2, paddingLeft2);
                    } else if (i4 == 3) {
                        max = paddingLeft2;
                        int childOffset2 = childAt.getWidth();
                        paddingLeft2 += childOffset2;
                    } else if (i4 != 5) {
                        max = paddingLeft2;
                    } else {
                        int childOffset3 = childAt.getMeasuredWidth();
                        max = (width - paddingRight) - childOffset3;
                        int childOffset4 = childAt.getMeasuredWidth();
                        paddingRight += childOffset4;
                    }
                    int childLeft = childAt.getLeft();
                    int i5 = (max + i2) - childLeft;
                    if (i5 != 0) {
                        childAt.offsetLeftAndRight(i5);
                    }
                }
            }
        }
        A0H(scrollX, f2, paddingLeft);
        if (this.A0a != null) {
            getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((AnonymousClass38) childAt2.getLayoutParams()).A05) {
                    childAt2.getLeft();
                    getClientWidth();
                    throw new NullPointerException(A08(450, 13, 121));
                }
            }
        }
        this.A0g = true;
    }

    private final void A0J(int i2, int i3, int width) {
        int dy;
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.A0X;
        int dx = (scroller == null || scroller.isFinished()) ? 0 : 1;
        if (dx != 0) {
            if (this.A0l) {
                dy = this.A0X.getCurrX();
            } else {
                dy = this.A0X.getStartX();
            }
            this.A0X.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            dy = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i2 - dy;
        int velocity = i3 - scrollY;
        if (i5 == 0 && velocity == 0) {
            A0R(false);
            A0f();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float A00 = i6 + (i6 * A00(Math.min(1.0f, (Math.abs(i5) * 1.0f) / clientWidth)));
        int halfWidth = Math.abs(width);
        if (halfWidth > 0) {
            float f2 = halfWidth;
            if (A0v[1].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0v;
            strArr[4] = "";
            strArr[5] = "";
            i4 = Math.round(Math.abs(A00 / f2) * 1000.0f) * 4;
        } else {
            float A04 = clientWidth * this.A01.A04(this.A00);
            float abs = Math.abs(i5);
            float pageWidth = this.A0M;
            i4 = (int) ((1.0f + (abs / (pageWidth + A04))) * 100.0f);
        }
        int min = Math.min(i4, 600);
        this.A0l = false;
        this.A0X.startScroll(dy, scrollY, i5, velocity, min);
        AnonymousClass31.A07(this);
    }

    private void A0K(int i2, int i3, int i4, int i5) {
        if (i3 > 0) {
            ArrayList<AnonymousClass37> arrayList = this.A0t;
            String[] strArr = A0v;
            if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            A0v[1] = "xS6wP2kv8Ukjp2mlI4OFB7EI";
            if (!arrayList.isEmpty()) {
                boolean isFinished = this.A0X.isFinished();
                if (A0v[1].length() == 12) {
                    throw new RuntimeException();
                }
                A0v[2] = "M3IvNYMGgF0qb538wmgDMK0nNkgqAt";
                if (!isFinished) {
                    this.A0X.setFinalX(getCurrentItem() * getClientWidth());
                    return;
                }
                int oldWidthWithMargin = ((i2 - getPaddingLeft()) - getPaddingRight()) + i4;
                int xpos = ((i3 - getPaddingLeft()) - getPaddingRight()) + i5;
                scrollTo((int) (oldWidthWithMargin * (getScrollX() / xpos)), getScrollY());
                return;
            }
        }
        AnonymousClass37 A04 = A04(this.A00);
        int paddingLeft = (int) (((i2 - getPaddingLeft()) - getPaddingRight()) * (A04 != null ? Math.min(A04.A00, this.A07) : 0.0f));
        if (paddingLeft != getScrollX()) {
            A0R(false);
            scrollTo(paddingLeft, getScrollY());
        }
    }

    private final void A0L(int i2, boolean z) {
        this.A0o = false;
        A0N(i2, z, false);
    }

    private void A0M(int destX, boolean z, int i2, boolean z2) {
        AnonymousClass37 A04 = A04(destX);
        int i3 = 0;
        if (A04 != null) {
            i3 = (int) (getClientWidth() * Math.max(this.A02, Math.min(A04.A00, this.A07)));
        }
        if (A0v[2].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr = A0v;
        strArr[3] = "qWyJthdIKprwmupmlWytZXkwKuTz6nwm";
        strArr[6] = "fDmSwMvEmt93O90vXMKXMmFP8biUMO95";
        if (z) {
            A0J(i3, 0, i2);
            if (z2) {
                A0E(destX);
                return;
            }
            return;
        }
        if (z2) {
            A0E(destX);
        }
        A0R(false);
        scrollTo(i3, 0);
        A0Z(i3);
    }

    private final void A0N(int i2, boolean z, boolean z2) {
        A0O(i2, z, z2, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (r6 < r4) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void A0O(int r6, boolean r7, boolean r8, int r9) {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.2m r0 = r5.A01
            r1 = 0
            if (r0 == 0) goto Lb
            int r0 = r0.A05()
            if (r0 > 0) goto Lf
        Lb:
            r5.setScrollingCacheEnabled(r1)
            return
        Lf:
            if (r8 != 0) goto L21
            int r0 = r5.A00
            if (r0 != r6) goto L21
            java.util.ArrayList<com.facebook.ads.redexgen.X.37> r0 = r5.A0t
            int r0 = r0.size()
            if (r0 == 0) goto L21
            r5.setScrollingCacheEnabled(r1)
            return
        L21:
            r2 = 1
            if (r6 >= 0) goto L48
            r6 = 0
        L25:
            int r1 = r5.A0L
            int r4 = r5.A00
            int r0 = r4 + r1
            if (r6 > r0) goto L67
            int r4 = r4 - r1
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.C3F.A0v
            r0 = 7
            r1 = r3[r0]
            r0 = 0
            r3 = r3[r0]
            r0 = 10
            char r1 = r1.charAt(r0)
            char r0 = r3.charAt(r0)
            if (r1 == r0) goto L59
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L48:
            com.facebook.ads.redexgen.X.2m r0 = r5.A01
            int r0 = r0.A05()
            if (r6 < r0) goto L25
            com.facebook.ads.redexgen.X.2m r0 = r5.A01
            int r0 = r0.A05()
            int r6 = r0 + (-1)
            goto L25
        L59:
            java.lang.String[] r3 = com.facebook.ads.redexgen.X.C3F.A0v
            java.lang.String r1 = "HdD8kb8A1NTv0LjA3C8pNf8B8Uhf5Rjf"
            r0 = 3
            r3[r0] = r1
            java.lang.String r1 = "hEPxY7plOgAB5ujpSYVhyDABeqG0KedF"
            r0 = 6
            r3[r0] = r1
            if (r6 >= r4) goto L7d
        L67:
            r1 = 0
        L68:
            java.util.ArrayList<com.facebook.ads.redexgen.X.37> r0 = r5.A0t
            int r0 = r0.size()
            if (r1 >= r0) goto L7d
            java.util.ArrayList<com.facebook.ads.redexgen.X.37> r0 = r5.A0t
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.37 r0 = (com.facebook.ads.redexgen.X.AnonymousClass37) r0
            r0.A04 = r2
            int r1 = r1 + 1
            goto L68
        L7d:
            int r0 = r5.A00
            if (r0 == r6) goto L97
        L81:
            boolean r0 = r5.A0i
            if (r0 == 0) goto L90
            r5.A00 = r6
            if (r2 == 0) goto L8c
            r5.A0E(r6)
        L8c:
            r5.requestLayout()
        L8f:
            return
        L90:
            r5.A0G(r6)
            r5.A0M(r6, r7, r9, r2)
            goto L8f
        L97:
            r2 = 0
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3F.A0O(int, boolean, boolean, int):void");
    }

    private void A0P(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.A08) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.A05 = motionEvent.getX(i2);
            String[] strArr = A0v;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0v;
            strArr2[4] = "";
            strArr2[5] = "";
            this.A08 = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.A0U;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void A0Q(AnonymousClass37 anonymousClass37, int i2, AnonymousClass37 anonymousClass372) {
        float f2;
        AnonymousClass37 anonymousClass373;
        AnonymousClass37 anonymousClass374;
        int pos = this.A01.A05();
        int clientWidth = getClientWidth();
        float f3 = clientWidth > 0 ? this.A0M / clientWidth : 0.0f;
        if (anonymousClass372 != null) {
            int i3 = anonymousClass372.A02;
            if (i3 < anonymousClass37.A02) {
                int i4 = 0;
                float f4 = anonymousClass372.A00 + anonymousClass372.A01 + f3;
                int i5 = i3 + 1;
                while (i5 <= anonymousClass37.A02 && i4 < this.A0t.size()) {
                    AnonymousClass37 anonymousClass375 = this.A0t.get(i4);
                    while (true) {
                        anonymousClass374 = anonymousClass375;
                        if (i5 <= anonymousClass374.A02 || i4 >= this.A0t.size() - 1) {
                            break;
                        }
                        i4++;
                        anonymousClass375 = this.A0t.get(i4);
                    }
                    while (i5 < anonymousClass374.A02) {
                        AbstractC05342m abstractC05342m = this.A01;
                        if (A0v[2].length() == 14) {
                            throw new RuntimeException();
                        }
                        A0v[2] = "unjnr1JPHveRA3A";
                        f4 += abstractC05342m.A04(i5) + f3;
                        i5++;
                    }
                    anonymousClass374.A00 = f4;
                    f4 += anonymousClass374.A01 + f3;
                    i5++;
                }
            } else if (i3 > anonymousClass37.A02) {
                int size = this.A0t.size() - 1;
                float f5 = anonymousClass372.A00;
                int i6 = i3 - 1;
                while (i6 >= anonymousClass37.A02 && size >= 0) {
                    AnonymousClass37 anonymousClass376 = this.A0t.get(size);
                    while (true) {
                        anonymousClass373 = anonymousClass376;
                        if (i6 >= anonymousClass373.A02 || size <= 0) {
                            break;
                        }
                        size--;
                        anonymousClass376 = this.A0t.get(size);
                    }
                    while (true) {
                        int i7 = anonymousClass373.A02;
                        String[] strArr = A0v;
                        if (strArr[4].length() != strArr[5].length()) {
                            A0v[1] = "tUoZSKhLB59JJ";
                            if (i6 > i7) {
                                f5 -= this.A01.A04(i6) + f3;
                                i6--;
                            }
                        } else {
                            A0v[2] = "eK1wjFwqyv9CJUk";
                            if (i6 > i7) {
                                f5 -= this.A01.A04(i6) + f3;
                                i6--;
                            }
                        }
                    }
                    f5 -= anonymousClass373.A01 + f3;
                    anonymousClass373.A00 = f5;
                    i6--;
                }
            }
        }
        int size2 = this.A0t.size();
        float f6 = anonymousClass37.A00;
        int i8 = anonymousClass37.A02 - 1;
        float offset = anonymousClass37.A02 == 0 ? anonymousClass37.A00 : -3.4028235E38f;
        this.A02 = offset;
        if (anonymousClass37.A02 == pos - 1) {
            float f7 = anonymousClass37.A00;
            float offset2 = anonymousClass37.A01;
            f2 = (f7 + offset2) - 1.0f;
        } else {
            f2 = Float.MAX_VALUE;
        }
        this.A07 = f2;
        int i9 = i2 - 1;
        while (i9 >= 0) {
            AnonymousClass37 anonymousClass377 = this.A0t.get(i9);
            while (i8 > anonymousClass377.A02) {
                int i10 = i8 - 1;
                f6 -= this.A01.A04(i8) + f3;
                i8 = i10;
            }
            f6 -= anonymousClass377.A01 + f3;
            anonymousClass377.A00 = f6;
            if (anonymousClass377.A02 == 0) {
                this.A02 = f6;
            }
            i9--;
            i8--;
        }
        float f8 = anonymousClass37.A00 + anonymousClass37.A01 + f3;
        int i11 = anonymousClass37.A02 + 1;
        int i12 = i2 + 1;
        while (i12 < size2) {
            AnonymousClass37 anonymousClass378 = this.A0t.get(i12);
            while (i11 < anonymousClass378.A02) {
                f8 += this.A01.A04(i11) + f3;
                i11++;
            }
            int i13 = anonymousClass378.A02;
            if (A0v[2].length() != 14) {
                String[] strArr2 = A0v;
                strArr2[3] = "LKMrFShf3NXE5XfaxsCGHUW3hns0S8Wh";
                strArr2[6] = "xptjAJKkekqR5TDnJjimQZvUd22mQJJ9";
                if (i13 != pos - 1) {
                    anonymousClass378.A00 = f8;
                    f8 += anonymousClass378.A01 + f3;
                    i12++;
                    i11++;
                }
                this.A07 = (anonymousClass378.A01 + f8) - 1.0f;
                anonymousClass378.A00 = f8;
                f8 += anonymousClass378.A01 + f3;
                i12++;
                i11++;
            } else {
                if (i13 != pos - 1) {
                    anonymousClass378.A00 = f8;
                    f8 += anonymousClass378.A01 + f3;
                    i12++;
                    i11++;
                }
                this.A07 = (anonymousClass378.A01 + f8) - 1.0f;
                anonymousClass378.A00 = f8;
                f8 += anonymousClass378.A01 + f3;
                i12++;
                i11++;
            }
        }
        this.A0n = false;
    }

    private void A0R(boolean z) {
        boolean z2 = this.A0P == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (true ^ this.A0X.isFinished()) {
                this.A0X.abortAnimation();
                if (A0v[1].length() == 12) {
                    throw new RuntimeException();
                }
                A0v[1] = "La7";
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int oldX = this.A0X.getCurrX();
                int x = this.A0X.getCurrY();
                if (scrollX != oldX || scrollY != x) {
                    scrollTo(oldX, x);
                    if (oldX != scrollX) {
                        A0Z(oldX);
                    }
                }
            }
        }
        this.A0o = false;
        for (int i2 = 0; i2 < this.A0t.size(); i2++) {
            AnonymousClass37 ii = this.A0t.get(i2);
            if (ii.A04) {
                z2 = true;
                ii.A04 = false;
            }
        }
        if (z2) {
            if (z) {
                AnonymousClass31.A0D(this, this.A0s);
            } else {
                this.A0s.run();
            }
        }
    }

    private void A0S(boolean z) {
        int i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (z) {
                i2 = this.A0N;
            } else {
                i2 = 0;
            }
            getChildAt(i3).setLayerType(i2, null);
        }
    }

    private void A0T(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean A0U() {
        this.A08 = -1;
        A09();
        this.A0V.onRelease();
        this.A0W.onRelease();
        return this.A0V.isFinished() || this.A0W.isFinished();
    }

    private final boolean A0V() {
        int i2 = this.A00;
        if (i2 > 0) {
            A0L(i2 - 1, true);
            return true;
        }
        return false;
    }

    private final boolean A0W() {
        AbstractC05342m abstractC05342m = this.A01;
        if (abstractC05342m != null && this.A00 < abstractC05342m.A05() - 1) {
            A0L(this.A00 + 1, true);
            return true;
        } else if (A0v[2].length() != 14) {
            String[] strArr = A0v;
            strArr[7] = "AXA5EDUbYu85ntxkUdYhY3hIIlQIUQar";
            strArr[0] = "7HhQN1X94o8BEMOAnE9vO9t08zapWTmy";
            return false;
        } else {
            throw new RuntimeException();
        }
    }

    private boolean A0X(float deltaX) {
        ArrayList<AnonymousClass37> arrayList;
        boolean z = false;
        this.A05 = deltaX;
        float scrollX = getScrollX() + (this.A05 - deltaX);
        int clientWidth = getClientWidth();
        float over = clientWidth * this.A02;
        float leftBound = this.A07;
        float f2 = clientWidth * leftBound;
        boolean z2 = true;
        boolean z3 = true;
        AnonymousClass37 anonymousClass37 = this.A0t.get(0);
        AnonymousClass37 anonymousClass372 = this.A0t.get(arrayList.size() - 1);
        if (anonymousClass37.A02 != 0) {
            z2 = false;
            float f3 = anonymousClass37.A00;
            int width = A0v[1].length();
            if (width == 12) {
                throw new RuntimeException();
            }
            A0v[1] = "a";
            over = f3 * clientWidth;
        }
        int width2 = anonymousClass372.A02;
        if (width2 != this.A01.A05() - 1) {
            z3 = false;
            f2 = anonymousClass372.A00 * clientWidth;
        }
        if (scrollX < over) {
            if (z2) {
                this.A0V.onPull(Math.abs(over - scrollX) / clientWidth);
                z = true;
            }
            scrollX = over;
        } else if (scrollX > f2) {
            if (z3) {
                EdgeEffect edgeEffect = this.A0W;
                float abs = Math.abs(scrollX - f2);
                float f4 = clientWidth;
                String[] strArr = A0v;
                String str = strArr[4];
                String str2 = strArr[5];
                int width3 = str.length();
                if (width3 != str2.length()) {
                    edgeEffect.onPull(abs / f4);
                    z = true;
                } else {
                    A0v[1] = "TwKB2lBmR";
                    edgeEffect.onPull(abs / f4);
                    z = true;
                }
            }
            scrollX = f2;
        }
        this.A05 += scrollX - ((int) scrollX);
        int width4 = (int) scrollX;
        scrollTo(width4, getScrollY());
        A0Z((int) scrollX);
        return z;
    }

    private final boolean A0Y(float f2, float f3) {
        if (f2 >= this.A0I || f3 <= 0.0f) {
            if (f2 > getWidth() - this.A0I) {
                int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                if (A0v[2].length() == 14) {
                    throw new RuntimeException();
                }
                String[] strArr = A0v;
                strArr[3] = "LoLbwLodEQ0RZhoADzk4YxqyeMxGbPNe";
                strArr[6] = "uXFtlpuRRgamX4n9Zkql1HjWorEkSQ7b";
                if (i2 < 0) {
                }
            }
            return false;
        }
        return true;
    }

    private boolean A0Z(int i2) {
        int size = this.A0t.size();
        String A08 = A08(397, 53, 60);
        if (size == 0) {
            if (this.A0i) {
                return false;
            }
            this.A0g = false;
            A0I(0, 0.0f, 0);
            String[] strArr = A0v;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A0v[2] = "c3ramapljB1reDSufYjA";
            if (this.A0g) {
                return false;
            }
            throw new IllegalStateException(A08);
        }
        AnonymousClass37 A03 = A03();
        int clientWidth = getClientWidth();
        int i3 = this.A0M;
        int i4 = A03.A02;
        float f2 = ((i2 / clientWidth) - A03.A00) / (A03.A01 + (i3 / clientWidth));
        int currentPage = (int) ((clientWidth + i3) * f2);
        this.A0g = false;
        A0I(i4, f2, currentPage);
        if (this.A0g) {
            return true;
        }
        throw new IllegalStateException(A08);
    }

    private final boolean A0a(int i2) {
        View nextFocused = findFocus();
        if (nextFocused == this) {
            nextFocused = null;
        } else if (nextFocused != null) {
            boolean z = false;
            ViewParent parent = nextFocused.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    break;
                } else if (parent == this) {
                    z = true;
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(nextFocused.getClass().getSimpleName());
                for (ViewParent parent2 = nextFocused.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(A08(0, 4, 21));
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e(A08(IjkMediaCodecInfo.RANK_SECURE, 9, 47), A08(309, 72, 80) + sb.toString());
                nextFocused = null;
            }
        }
        boolean z2 = false;
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, nextFocused, i2);
        if (findNextFocus != null && findNextFocus != nextFocused) {
            if (i2 == 17) {
                int i3 = A02(this.A0q, findNextFocus).left;
                int currLeft = A02(this.A0q, nextFocused).left;
                z2 = (nextFocused == null || i3 < currLeft) ? findNextFocus.requestFocus() : A0V();
            } else if (i2 == 66) {
                int i4 = A02(this.A0q, findNextFocus).left;
                int currLeft2 = A02(this.A0q, nextFocused).left;
                z2 = (nextFocused == null || i4 > currLeft2) ? findNextFocus.requestFocus() : A0W();
            }
        } else if (i2 == 17 || i2 == 1) {
            z2 = A0V();
        } else if (i2 == 66 || i2 == 2) {
            z2 = A0W();
        }
        if (z2) {
            int currLeft3 = SoundEffectConstants.getContantForFocusDirection(i2);
            playSoundEffect(currLeft3);
        }
        return z2;
    }

    private final boolean A0b(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 21) {
            if (keyEvent.hasModifiers(2)) {
                return A0V();
            }
            return A0a(17);
        } else if (keyCode == 22) {
            if (keyEvent.hasModifiers(2)) {
                return A0W();
            }
            return A0a(66);
        } else if (keyCode != 61) {
            return false;
        } else {
            if (keyEvent.hasNoModifiers()) {
                return A0a(2);
            }
            boolean hasModifiers = keyEvent.hasModifiers(1);
            String[] strArr = A0v;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A0v[1] = "lC1XoLB2bpdljamdt6Vm";
            if (!hasModifiers) {
                return false;
            }
            return A0a(1);
        }
    }

    public static boolean A0c(@NonNull View view) {
        Class<?> clazz = view.getClass();
        return clazz.getAnnotation(ViewPager$DecorView.class) != null;
    }

    private final boolean A0d(View view, boolean z, int scrollX, int scrollY, int count) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX2 = view.getScrollX();
            int scrollY2 = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (scrollY + scrollX2 >= childAt.getLeft() && scrollY + scrollX2 < childAt.getRight() && count + scrollY2 >= childAt.getTop() && count + scrollY2 < childAt.getBottom()) {
                    int left = (scrollY + scrollX2) - childAt.getLeft();
                    int i2 = count + scrollY2;
                    if (A0v[1].length() == 12) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0v;
                    strArr[4] = "";
                    strArr[5] = "";
                    if (A0d(childAt, true, scrollX, left, i2 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && view.canScrollHorizontally(-scrollX);
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x002a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0e() {
        /*
            r11 = this;
            com.facebook.ads.redexgen.X.2m r0 = r11.A01
            int r3 = r0.A05()
            r11.A0G = r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.37> r0 = r11.A0t
            int r1 = r0.size()
            int r0 = r11.A0L
            int r0 = r0 * 2
            r5 = 1
            int r0 = r0 + r5
            r4 = 0
            if (r1 >= r0) goto L7b
            java.util.ArrayList<com.facebook.ads.redexgen.X.37> r0 = r11.A0t
            int r0 = r0.size()
            if (r0 >= r3) goto L7b
            r10 = 1
        L20:
            int r6 = r11.A00
            r9 = 0
            r2 = 0
        L24:
            java.util.ArrayList<com.facebook.ads.redexgen.X.37> r0 = r11.A0t
            int r0 = r0.size()
            if (r2 >= r0) goto L7d
            java.util.ArrayList<com.facebook.ads.redexgen.X.37> r0 = r11.A0t
            java.lang.Object r8 = r0.get(r2)
            com.facebook.ads.redexgen.X.37 r8 = (com.facebook.ads.redexgen.X.AnonymousClass37) r8
            com.facebook.ads.redexgen.X.2m r1 = r11.A01
            java.lang.Object r0 = r8.A03
            int r7 = r1.A06(r0)
            r0 = -1
            if (r7 != r0) goto L41
        L3f:
            int r2 = r2 + r5
            goto L24
        L41:
            r0 = -2
            if (r7 != r0) goto L6c
            java.util.ArrayList<com.facebook.ads.redexgen.X.37> r0 = r11.A0t
            r0.remove(r2)
            int r2 = r2 + (-1)
            if (r9 != 0) goto L4e
            r9 = 1
        L4e:
            com.facebook.ads.redexgen.X.2m r7 = r11.A01
            int r1 = r8.A02
            java.lang.Object r0 = r8.A03
            r7.A0B(r11, r1, r0)
            r10 = 1
            int r1 = r11.A00
            int r0 = r8.A02
            if (r1 != r0) goto L3f
            int r1 = r11.A00
            int r0 = r3 + (-1)
            int r0 = java.lang.Math.min(r1, r0)
            int r6 = java.lang.Math.max(r4, r0)
            r10 = 1
            goto L3f
        L6c:
            int r0 = r8.A02
            if (r0 == r7) goto L3f
            int r1 = r8.A02
            int r0 = r11.A00
            if (r1 != r0) goto L77
            r6 = r7
        L77:
            r8.A02 = r7
            r10 = 1
            goto L3f
        L7b:
            r10 = 0
            goto L20
        L7d:
            java.util.ArrayList<com.facebook.ads.redexgen.X.37> r1 = r11.A0t
            java.util.Comparator<com.facebook.ads.redexgen.X.37> r0 = com.facebook.ads.redexgen.X.C3F.A0z
            java.util.Collections.sort(r1, r0)
            if (r10 == 0) goto Lbb
            int r3 = r11.getChildCount()
            r2 = 0
        L8b:
            if (r2 >= r3) goto La1
            android.view.View r0 = r11.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            com.facebook.ads.redexgen.X.38 r1 = (com.facebook.ads.redexgen.X.AnonymousClass38) r1
            boolean r0 = r1.A05
            if (r0 != 0) goto L9e
            r0 = 0
            r1.A00 = r0
        L9e:
            int r2 = r2 + 1
            goto L8b
        La1:
            r11.A0N(r6, r4, r5)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C3F.A0v
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 14
            if (r1 == r0) goto Lbc
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C3F.A0v
            java.lang.String r1 = "iBz2AIJ6C"
            r0 = 2
            r2[r0] = r1
            r11.requestLayout()
        Lbb:
            return
        Lbc:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3F.A0e():void");
    }

    public final void A0f() {
        A0G(this.A00);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        AnonymousClass37 A07;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (A07 = A07(childAt)) != null && A07.A02 == this.A00) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
            return;
        }
        arrayList.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> arrayList) {
        AnonymousClass37 A07;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (A07 = A07(childAt)) != null && A07.A02 == this.A00) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        AnonymousClass38 anonymousClass38 = (AnonymousClass38) layoutParams;
        anonymousClass38.A05 |= A0c(view);
        if (this.A0j) {
            if (!anonymousClass38.A05) {
                anonymousClass38.A03 = true;
                addViewInLayout(view, i2, layoutParams);
                return;
            }
            throw new IllegalStateException(A08(86, 41, 16));
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i2) {
        if (this.A01 == null) {
            return false;
        }
        int scrollX = getClientWidth();
        int scrollX2 = getScrollX();
        return i2 < 0 ? scrollX2 > ((int) (((float) scrollX) * this.A02)) : i2 > 0 && scrollX2 < ((int) (((float) scrollX) * this.A07));
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof AnonymousClass38) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.A0l = true;
        if (!this.A0X.isFinished() && this.A0X.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.A0X.getCurrX();
            int oldY = this.A0X.getCurrY();
            if (scrollX != currX || scrollY != oldY) {
                scrollTo(currX, oldY);
                if (!A0Z(currX)) {
                    this.A0X.abortAnimation();
                    scrollTo(0, oldY);
                }
            }
            AnonymousClass31.A07(this);
            return;
        }
        A0R(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || A0b(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AnonymousClass37 ii;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (ii = A07(childAt)) != null) {
                int i3 = ii.A02;
                String[] strArr = A0v;
                if (strArr[7].charAt(10) != strArr[0].charAt(10)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0v;
                strArr2[4] = "";
                strArr2[5] = "";
                if (i3 == this.A00 && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r3.A05() > 1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r3 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        r5 = r8.save();
        r4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        r3 = getWidth();
        r8.rotate(270.0f);
        r0 = getPaddingTop();
        r8.translate((-r4) + r0, r7.A02 * r3);
        r7.A0V.setSize(r4, r3);
        r6 = 0 | r7.A0V.draw(r8);
        r8.restoreToCount(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
        if (r7.A0W.isFinished() != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0094, code lost:
        r3 = r8.save();
        r5 = getWidth();
        r4 = getHeight();
        r0 = getPaddingTop();
        r4 = r4 - r0;
        r0 = getPaddingBottom();
        r4 = r4 - r0;
        r8.rotate(90.0f);
        r0 = getPaddingTop();
        r8.translate(-r0, (-(r7.A07 + 1.0f)) * r5);
        r7.A0W.setSize(r4, r5);
        r6 = r6 | r7.A0W.draw(r8);
        r8.restoreToCount(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e1, code lost:
        if (r3 == false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r8) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3F.draw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.A0S;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new AnonymousClass38();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new AnonymousClass38(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public AbstractC05342m getAdapter() {
        return this.A01;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        return ((AnonymousClass38) this.A0d.get(this.A0F == 2 ? (i2 - 1) - i3 : i3).getLayoutParams()).A01;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public int getCurrentItem() {
        return this.A00;
    }

    public int getOffscreenPageLimit() {
        return this.A0L;
    }

    public int getPageMargin() {
        return this.A0M;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.A0s);
        Scroller scroller = this.A0X;
        if (scroller != null && !scroller.isFinished()) {
            this.A0X.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Incorrect condition in loop: B:14:0x0051 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3F.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f2;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            A0U();
            String[] strArr = A0v;
            if (strArr[4].length() == strArr[5].length()) {
                A0v[2] = "iW5W";
                return false;
            }
        } else {
            if (action != 0) {
                if (this.A0k) {
                    return true;
                }
                if (this.A0m) {
                    return false;
                }
            }
            if (action != 0) {
                if (action == 2) {
                    int i2 = this.A08;
                    if (i2 != -1) {
                        int pointerIndex = motionEvent.findPointerIndex(i2);
                        float x = motionEvent.getX(pointerIndex);
                        float x2 = this.A05;
                        float f3 = x - x2;
                        float abs = Math.abs(f3);
                        float y = motionEvent.getY(pointerIndex);
                        float dx = this.A04;
                        float abs2 = Math.abs(y - dx);
                        if (f3 != 0.0f && !A0Y(this.A05, f3) && A0d(this, false, (int) f3, (int) x, (int) y)) {
                            this.A05 = x;
                            this.A06 = y;
                            this.A0m = true;
                            return false;
                        }
                        float f4 = this.A0R;
                        if (A0v[1].length() != 12) {
                            String[] strArr2 = A0v;
                            strArr2[7] = "NnThZj9Wv9885vPNkfCF8DoAZte0LwUX";
                            strArr2[0] = "g2aolHvSBW8By3vUeqDyYWaFAgdqNGTo";
                            if (abs > f4 && 0.5f * abs > abs2) {
                                this.A0k = true;
                                A0T(true);
                                setScrollState(1);
                                if (f3 <= 0.0f) {
                                    f2 = this.A03 - this.A0R;
                                } else {
                                    float f5 = this.A03;
                                    int i3 = this.A0R;
                                    String[] strArr3 = A0v;
                                    if (strArr3[7].charAt(10) != strArr3[0].charAt(10)) {
                                        f2 = f5 + i3;
                                    } else {
                                        String[] strArr4 = A0v;
                                        strArr4[7] = "WpQimEPBWZ8vG05HKhTxshBMY3NNEur0";
                                        strArr4[0] = "BEtp4ufX6D8x3OZlDxdpMoFh1oKQqP0t";
                                        f2 = f5 + i3;
                                    }
                                }
                                this.A05 = f2;
                                this.A06 = y;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > this.A0R) {
                                this.A0m = true;
                            }
                            if (this.A0k && A0X(x)) {
                                AnonymousClass31.A07(this);
                            }
                        }
                    }
                } else if (action == 6) {
                    A0P(motionEvent);
                }
            } else {
                float yDiff = motionEvent.getX();
                this.A03 = yDiff;
                this.A05 = yDiff;
                float y2 = motionEvent.getY();
                this.A04 = y2;
                this.A06 = y2;
                this.A08 = motionEvent.getPointerId(0);
                this.A0m = false;
                this.A0l = true;
                this.A0X.computeScrollOffset();
                if (this.A0P != 2 || Math.abs(this.A0X.getFinalX() - this.A0X.getCurrX()) <= this.A0C) {
                    A0R(false);
                    this.A0k = false;
                } else {
                    this.A0X.abortAnimation();
                    this.A0o = false;
                    A0f();
                    this.A0k = true;
                    A0T(true);
                    setScrollState(1);
                }
            }
            if (this.A0U == null) {
                this.A0U = VelocityTracker.obtain();
            }
            this.A0U.addMovement(motionEvent);
            return this.A0k;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
        if (r3 != 48) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
        r14 = com.facebook.ads.redexgen.X.C3F.A0v;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009b, code lost:
        if (r14[7].charAt(10) == r14[0].charAt(10)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009d, code lost:
        com.facebook.ads.redexgen.X.C3F.A0v[2] = "D8xV1TWmEwTp2AdSb5ATv3";
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
        if (r3 == 80) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a6, code lost:
        r2 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bb, code lost:
        r14 = com.facebook.ads.redexgen.X.C3F.A0v;
        r14[3] = "1ewPUp1k8Pl5lyl6fUi6LymHiaJ9xmay";
        r14[6] = "wiWTa2PhZxJDNWnFVxR2jmvUAFeWjohE";
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c7, code lost:
        if (r3 == 80) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ca, code lost:
        r0 = r4.getMeasuredHeight();
        r2 = (r8 - r16) - r0;
        r0 = r4.getMeasuredHeight();
        r16 = r16 + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e4, code lost:
        if (r3 != 48) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e7, code lost:
        r2 = r12;
        r0 = r4.getMeasuredHeight();
        r12 = r12 + r0;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3F.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        AnonymousClass38 anonymousClass38;
        int i4;
        int i5;
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        int maxGutterSize = measuredWidth / 10;
        this.A0I = Math.min(maxGutterSize, this.A0E);
        int maxGutterSize2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredWidth2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 < childCount) {
                View childAt = getChildAt(i6);
                int size = childAt.getVisibility();
                if (size != 8) {
                    AnonymousClass38 anonymousClass382 = (AnonymousClass38) childAt.getLayoutParams();
                    int childWidthSize = A0v[1].length();
                    if (childWidthSize == 12) {
                        break;
                    }
                    String[] strArr = A0v;
                    strArr[4] = "";
                    strArr[5] = "";
                    if (anonymousClass382 != null && anonymousClass382.A05) {
                        int i7 = anonymousClass382.A04 & 7;
                        int hgrav = anonymousClass382.A04;
                        int i8 = hgrav & 112;
                        int i9 = Integer.MIN_VALUE;
                        int i10 = Integer.MIN_VALUE;
                        boolean z = i8 == 48 || i8 == 80;
                        boolean z2 = i7 == 3 || i7 == 5;
                        if (z) {
                            i9 = 1073741824;
                        } else if (z2) {
                            i10 = 1073741824;
                        }
                        if (anonymousClass382.width != -2) {
                            i9 = 1073741824;
                            if (anonymousClass382.width != -1) {
                                i4 = anonymousClass382.width;
                            } else {
                                i4 = maxGutterSize2;
                            }
                        } else {
                            i4 = maxGutterSize2;
                        }
                        if (anonymousClass382.height != -2) {
                            i10 = 1073741824;
                            if (anonymousClass382.height != -1) {
                                i5 = anonymousClass382.height;
                                if (A0v[1].length() != 12) {
                                    A0v[1] = "VKsSzAx6pk9J5wmYrW5ACp";
                                }
                            } else {
                                i5 = measuredWidth2;
                            }
                        } else {
                            i5 = measuredWidth2;
                        }
                        int widthSpec = View.MeasureSpec.makeMeasureSpec(i4, i9);
                        int heightMode = View.MeasureSpec.makeMeasureSpec(i5, i10);
                        childAt.measure(widthSpec, heightMode);
                        if (z) {
                            int heightMode2 = childAt.getMeasuredHeight();
                            measuredWidth2 -= heightMode2;
                        } else if (z2) {
                            maxGutterSize2 -= childAt.getMeasuredWidth();
                        }
                    }
                }
                i6++;
            } else {
                int heightMode3 = View.MeasureSpec.makeMeasureSpec(maxGutterSize2, 1073741824);
                this.A0B = heightMode3;
                int heightMode4 = View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
                this.A0A = heightMode4;
                this.A0j = true;
                A0f();
                this.A0j = false;
                int childCount2 = getChildCount();
                for (int i11 = 0; i11 < childCount2; i11++) {
                    View childAt2 = getChildAt(i11);
                    if (childAt2.getVisibility() != 8 && ((anonymousClass38 = (AnonymousClass38) childAt2.getLayoutParams()) == null || !anonymousClass38.A05)) {
                        float f2 = maxGutterSize2;
                        String[] strArr2 = A0v;
                        if (strArr2[4].length() == strArr2[5].length()) {
                            A0v[1] = "11cm9STM7FlxGR3";
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (f2 * anonymousClass38.A00), 1073741824);
                            int widthSpec2 = this.A0A;
                            childAt2.measure(makeMeasureSpec, widthSpec2);
                        }
                    }
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int index, Rect rect) {
        int i2;
        int i3;
        AnonymousClass37 A07;
        int end = getChildCount();
        if ((index & 2) != 0) {
            i2 = 0;
            i3 = 1;
        } else {
            i2 = end - 1;
            i3 = -1;
            end = -1;
        }
        while (i2 != end) {
            View childAt = getChildAt(i2);
            if (A0v[2].length() == 14) {
                throw new RuntimeException();
            }
            String[] strArr = A0v;
            strArr[3] = "wvs0VrXDMEHK1ZrgMliCmQkmYIqFRPYZ";
            strArr[6] = "yeuyy9yC0QSIfk9tyj8D1No5khczL5F7";
            int i4 = childAt.getVisibility();
            if (i4 == 0 && (A07 = A07(childAt)) != null) {
                int i5 = A07.A02;
                int i6 = this.A00;
                if (i5 == i6 && childAt.requestFocus(index, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WrappedParcelable)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            Context context = getContext();
            String[] strArr = A0v;
            if (strArr[3].charAt(15) == strArr[6].charAt(15)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0v;
            strArr2[7] = "Ly8LvMv3iU8o2fiJAVqvd6K7Aqz3gZKY";
            strArr2[0] = "HcNmsPXina8Ul250FP3kUGj1pgK53N1r";
            classLoader = context.getClassLoader();
        }
        Parcelable unwrap = ((WrappedParcelable) parcelable).unwrap(classLoader);
        if (!(unwrap instanceof ViewPager$SavedState)) {
            super.onRestoreInstanceState(unwrap);
            return;
        }
        ViewPager$SavedState viewPager$SavedState = (ViewPager$SavedState) unwrap;
        super.onRestoreInstanceState(viewPager$SavedState.A02());
        if (this.A01 != null) {
            A0N(viewPager$SavedState.A00, false, true);
            return;
        }
        this.A0O = viewPager$SavedState.A00;
        this.A0T = viewPager$SavedState.A01;
        this.A0c = viewPager$SavedState.A02;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState(super.onSaveInstanceState());
        viewPager$SavedState.A00 = this.A00;
        AbstractC05342m abstractC05342m = this.A01;
        if (abstractC05342m != null) {
            viewPager$SavedState.A01 = abstractC05342m.A07();
        }
        return new WrappedParcelable(viewPager$SavedState);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.A0M;
            A0K(i2, i4, i6, i6);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractC05342m abstractC05342m;
        float f2;
        if (this.A0h) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (abstractC05342m = this.A01) == null || abstractC05342m.A05() == 0) {
            return false;
        }
        if (this.A0U == null) {
            this.A0U = VelocityTracker.obtain();
        }
        this.A0U.addMovement(motionEvent);
        boolean z = false;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.A0X.abortAnimation();
            this.A0o = false;
            A0f();
            float x = motionEvent.getX();
            this.A03 = x;
            this.A05 = x;
            float y = motionEvent.getY();
            this.A04 = y;
            this.A06 = y;
            this.A08 = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.A0k) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.A08);
                    if (findPointerIndex == -1) {
                        z = A0U();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.A05);
                        float xDiff = motionEvent.getY(findPointerIndex);
                        float y2 = this.A06;
                        float abs2 = Math.abs(xDiff - y2);
                        float yDiff = this.A0R;
                        if (abs > yDiff && abs > abs2) {
                            this.A0k = true;
                            A0T(true);
                            float f3 = this.A03;
                            if (x2 - f3 > 0.0f) {
                                float yDiff2 = this.A0R;
                                f2 = f3 + yDiff2;
                            } else {
                                f2 = f3 - this.A0R;
                            }
                            this.A05 = f2;
                            this.A06 = xDiff;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.A0k) {
                    int activePointerIndex = motionEvent.findPointerIndex(this.A08);
                    z = false | A0X(motionEvent.getX(activePointerIndex));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    float x3 = motionEvent.getX(actionIndex);
                    this.A05 = x3;
                    this.A08 = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    A0P(motionEvent);
                    this.A05 = motionEvent.getX(motionEvent.findPointerIndex(this.A08));
                }
            } else if (this.A0k) {
                A0M(this.A00, true, 0, false);
                z = A0U();
            }
        } else if (this.A0k) {
            VelocityTracker velocityTracker = this.A0U;
            velocityTracker.computeCurrentVelocity(1000, this.A0J);
            int xVelocity = (int) velocityTracker.getXVelocity(this.A08);
            this.A0o = true;
            int clientWidth = getClientWidth();
            int width = getScrollX();
            AnonymousClass37 A03 = A03();
            int scrollX = this.A0M;
            int i2 = A03.A02;
            float f4 = ((width / clientWidth) - A03.A00) / (A03.A01 + (scrollX / clientWidth));
            int currentPage = this.A08;
            int activePointerIndex2 = motionEvent.findPointerIndex(currentPage);
            float x4 = motionEvent.getX(activePointerIndex2);
            float x5 = this.A03;
            A0O(A01(i2, f4, xVelocity, (int) (x4 - x5)), true, true, xVelocity);
            z = A0U();
        }
        if (z) {
            AnonymousClass31.A07(this);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.A0j) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.facebook.ads.redexgen.X.3C] */
    public void setAdapter(AbstractC05342m abstractC05342m) {
        AbstractC05342m abstractC05342m2 = this.A01;
        if (abstractC05342m2 != null) {
            abstractC05342m2.A0A(null);
            for (int i2 = 0; i2 < this.A0t.size(); i2++) {
                AnonymousClass37 anonymousClass37 = this.A0t.get(i2);
                this.A01.A0B(this, anonymousClass37.A02, anonymousClass37.A03);
            }
            this.A0t.clear();
            A0A();
            this.A00 = 0;
            scrollTo(0, 0);
        }
        this.A01 = abstractC05342m;
        this.A0G = 0;
        if (this.A01 != null) {
            if (this.A0b == null) {
                this.A0b = new DataSetObserver() { // from class: com.facebook.ads.redexgen.X.3C
                    @Override // android.database.DataSetObserver
                    public final void onChanged() {
                        C3F.this.A0e();
                    }

                    @Override // android.database.DataSetObserver
                    public final void onInvalidated() {
                        C3F.this.A0e();
                    }
                };
            }
            this.A01.A0A(this.A0b);
            this.A0o = false;
            boolean z = this.A0i;
            this.A0i = true;
            this.A0G = this.A01.A05();
            if (this.A0O >= 0) {
                A0N(this.A0O, false, true);
                this.A0O = -1;
                this.A0T = null;
                this.A0c = null;
            } else if (!z) {
                A0f();
            } else {
                requestLayout();
            }
        }
        List<ViewPager.OnAdapterChangeListener> list = this.A0e;
        if (list != null && !list.isEmpty()) {
            int count = this.A0e.size();
            if (0 < count) {
                this.A0e.get(0);
                throw new NullPointerException(A08(381, 16, 117));
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.A0o = false;
        A0N(i2, !this.A0i, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w(A08(IjkMediaCodecInfo.RANK_SECURE, 9, 47), A08(127, 31, 60) + i2 + A08(51, 26, 90) + 1);
            i2 = 1;
        }
        if (i2 != this.A0L) {
            this.A0L = i2;
            A0f();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(C3A c3a) {
        this.A0Z = c3a;
    }

    public void setPageMargin(int width) {
        int i2 = this.A0M;
        this.A0M = width;
        int width2 = getWidth();
        A0K(width2, width2, width, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(@DrawableRes int i2) {
        setPageMarginDrawable(C2I.A00(getContext(), i2));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.A0S = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i2) {
        if (this.A0P == i2) {
            return;
        }
        this.A0P = i2;
        if (this.A0a != null) {
            A0S(i2 != 0);
        }
        A0F(i2);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.A0p != z) {
            this.A0p = z;
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.A0S;
    }
}
