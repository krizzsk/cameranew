package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class QZ {
    public static byte[] A0G;
    public static String[] A0H = {"4lWoymCKcFFqvR4KGqpukkAdeBkDHFLG", "4SfXhahvn2cvHTwc", "1H78NFRDPNrHyZuRtW6OfnE16", "5zR7eGXCNOES3F", "tNutlosLurIud7dAWRzPLPvdzTHVgEY0", "XrTXE7Mp98Q", "ALMz8CaD4gcY6rgjWR0f79B0Q", "oMfYSWXrIKFBNYq7bMfMNj8ewYt05Dn"};
    public static final String A0I;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public AbstractRunnableC0981Kv A04;
    public C1111Qa A05;
    public Map<String, Integer> A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final Handler A0B;
    public final View A0C;
    public final XT A0D;
    public final WeakReference<QY> A0E;
    public final boolean A0F;

    public static String A0H(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 88);
        }
        return new String(copyOfRange);
    }

    public static void A0M() {
        A0G = new byte[]{-40, -32, -35, -26, -23, 30, -35, -35, -31, -28, 45, 55, -28, -60, 27, Draft_75.CR, 24, 12, -60, 22, 9, 5, 23, 19, 18, -34, -60, -79, -91, -19, -62, -89, -54, -122, -49, -39, -122, -43, -44, -122, -38, -43, -42, -122, -43, -52, -122, -38, -50, -53, -122, -78, -43, -55, -47, -39, -55, -40, -53, -53, -44, -108, -58, -28, -15, -15, -14, -9, -93, -22, -24, -9, -93, -17, -14, -26, -28, -9, -20, -14, -15, -93, -14, -15, -93, -10, -26, -11, -24, -24, -15, -79, -86, -43, -53, -39, -44, -115, -38, -122, -45, -57, -47, -53, -122, -39, -53, -44, -39, -53, -122, -38, -43, -122, -39, -53, -38, -122, -55, -50, -53, -55, -47, -122, -49, -44, -38, -53, -40, -36, -57, -46, -122, -52, -43, -40, -122, -44, -43, -44, -109, -40, -53, -42, -53, -57, -38, -122, -55, -50, -53, -55, -47, -53, -40, -108, -16, 10, 30, 12, 26, 6, 23, 9, -59, 14, 24, -59, 20, 7, 24, 25, 23, 26, 8, 25, 14, 19, 12, -59, 27, 14, 10, 28, -45, -23, -7, 8, -5, -5, 4, -74, -1, 9, -74, 4, 5, 10, -74, -1, 4, 10, -5, 8, -9, -7, 10, -1, 12, -5, -60, -64, -44, -47, -116, -32, -43, -49, -41, -47, -34, -116, -49, -51, -38, -38, -37, -32, -116, -50, -47, -116, -38, -47, -45, -51, -32, -43, -30, -47, 28, 47, 43, 61, -26, -31, -19, -21, -84, -28, -33, -31, -29, -32, -19, -19, -23, -84, -33, -30, -15, -84, -25, -20, -14, -29, -16, -20, -33, -22, -84, -12, -25, -29, -11, -84, -60, -13, -22, -22, -47, -31, -16, -29, -29, -20, -65, -30, -46, -19, -19, -22, -32, -33, -16, -2, -46, -11, -25, -6, -10, 8, -79, -7, -14, 4, -79, -6, -1, 7, -6, 4, -6, -13, -3, -10, -79, -11, -6, -2, -10, -1, 4, -6, 0, -1, 4, -79, -71, 8, -50, 40, -4, 31, 17, 36, 32, 50, -37, 35, 28, 46, -37, 41, 42, -37, 43, 28, 45, 32, 41, 47, -23, -28, -72, -37, -51, -32, -36, -18, -105, -32, -22, -105, -27, -26, -21, -105, -35, -20, -29, -29, -16, -105, -26, -27, -105, -22, -38, -23, -36, -36, -27, -105, -33, -26, -23, -32, -15, -26, -27, -21, -40, -29, -29, -16, -91, -29, -73, -38, -52, -33, -37, -19, -106, -33, -23, -106, -28, -27, -22, -106, -20, -33, -23, -33, -40, -30, -37, -106, -36, -24, -27, -29, -106, -22, -34, -37, -106, -40, -27, -22, -22, -27, -29, -92, 4, -40, -5, -19, 0, -4, 14, -73, 0, 10, -73, 5, 6, 11, -73, Draft_75.CR, 0, 10, 0, -7, 3, -4, -73, -3, 9, 6, 4, -73, 11, -1, -4, -73, 11, 6, 7, -59, 54, 10, 45, 31, 50, 46, 64, -23, 50, 60, -23, 55, 62, 53, 53, -9, -17, -61, -26, -40, -21, -25, -7, -94, -21, -11, -94, -10, -15, -15, -94, -10, -12, -29, -16, -11, -14, -29, -12, -25, -16, -10, -80, 40, -4, 31, 17, 36, 32, 50, -37, 36, 46, -37, 49, 36, 46, 36, 29, 39, 32, -23, 62, 18, 53, 39, 58, 54, 72, -15, 65, 50, 67, 54, 63, 69, -15, 58, 68, -15, 63, 64, 69, -15, 68, 54, 69, -15, 69, 64, -15, 39, 26, 36, 26, 19, 29, 22, -1, 64, 20, 55, 41, 60, 56, 74, -13, 73, 60, 70, 60, 53, 63, 56, -13, 52, 69, 56, 52, -13, 60, 70, -13, 71, 66, 66, -13, 70, 64, 52, 63, 63, -13, 46, -8, 1, 5, 57, -8, -8, -13, 73, 60, 70, 60, 53, 63, 56, -1, -13, 54, 72, 69, 69, 56, 65, 71, -13, 71, 59, 69, 56, 70, 59, 66, 63, 55, -13, -8, 1, 5, 57, -8, -8, 48, 22, -22, Draft_75.CR, -1, 18, 14, 32, -55, 32, 18, 23, Draft_75.CR, 24, 32, -55, 18, 28, -55, 23, 24, 29, -55, 28, 14, 29, -55, 29, 24, -55, -1, -14, -4, -14, -21, -11, -18, -41, 39, 40, 45, -39, 47, 34, 30, 48, 26, 27, 37, 30, 34, 20, 18, 5, 1, 19, -3, -2, 8, 1, 59, 53, 9, 5, -10, 19, 17, -19, -33, -28, -38, -27, -19};
    }

    static {
        A0M();
        A0I = QZ.class.getSimpleName();
    }

    public QZ(View view, int i2, int i3, boolean z, WeakReference<QY> weakReference, XT xt) {
        this.A0B = new Handler();
        this.A01 = 0;
        this.A02 = 1000;
        this.A08 = true;
        this.A05 = new C1111Qa(C0Q.A0M);
        this.A06 = new HashMap();
        this.A03 = 0L;
        this.A00 = 0;
        this.A07 = true;
        this.A0D = xt;
        this.A0C = view;
        if (this.A0C.getId() == -1) {
            M5.A0K(this.A0C);
        }
        this.A0A = i2;
        this.A0E = weakReference;
        this.A0F = z;
        if (i3 < 0) {
            if (BuildConfigApi.isDebug()) {
                Log.w(A0I, A0H(211, 29, 20));
            }
            i3 = 0;
        }
        this.A09 = i3;
    }

    public QZ(View view, int i2, WeakReference<QY> weakReference, XT xt) {
        this(view, i2, 0, false, weakReference, xt);
    }

    public QZ(View view, int i2, boolean z, WeakReference<QY> weakReference, XT xt) {
        this(view, i2, 0, z, weakReference, xt);
    }

    @VisibleForTesting
    public static float A00(View view) {
        float alpha = view.getAlpha();
        while (view.getParent() instanceof ViewGroup) {
            view = (View) view.getParent();
            float alpha2 = view.getAlpha();
            if (alpha2 < 0.0f) {
                alpha2 = 0.0f;
            }
            if (alpha2 > 1.0f) {
                alpha2 = 1.0f;
            }
            alpha *= alpha2;
        }
        return alpha;
    }

    @VisibleForTesting
    public static int A01(int viewArea, View view) {
        int width = view.getWidth() * view.getHeight();
        return (int) Math.max(viewArea, Math.ceil(width > 0 ? 100.0f / width : 100.0f));
    }

    public static /* synthetic */ int A05(QZ qz) {
        int i2 = qz.A00;
        qz.A00 = i2 + 1;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0102, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Incorrect condition in loop: B:20:0x009f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A08(java.util.Vector<android.graphics.Rect> r13) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.QZ.A08(java.util.Vector):int");
    }

    public static int A09(int[] iArr, int high) {
        int mid = 0;
        int length = iArr.length;
        while (mid < length) {
            int i2 = ((length - mid) / 2) + mid;
            if (iArr[i2] == high) {
                return i2;
            }
            int i3 = iArr[i2];
            String[] strArr = A0H;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A0H[0] = "QqEyOv5K4c2a7TamOIPTrCyFewVDGSxi";
            if (i3 > high) {
                length = i2;
            } else {
                mid = i2 + 1;
            }
        }
        return -1;
    }

    public static C1111Qa A0E(View view, int i2, XT xt) {
        DisplayMetrics displayMetrics;
        if (view == null) {
            A0N(null, false, A0H(472, 16, 113));
            return new C1111Qa(C0Q.A08);
        }
        boolean A1o = JD.A1o(xt);
        String A0H2 = A0H(534, 37, 121);
        String A0H3 = A0H(331, 22, 99);
        if (A1o) {
            if (view.getParent() == null) {
                A0N(view, false, A0H3);
                return new C1111Qa(C0Q.A0K);
            } else if (!view.isShown()) {
                A0N(view, false, A0H2);
                return new C1111Qa(C0Q.A0N);
            }
        } else if (view.getParent() == null) {
            A0N(view, false, A0H3);
            return new C1111Qa(C0Q.A0H);
        } else if (!view.isShown()) {
            A0N(view, false, A0H2);
            return new C1111Qa(C0Q.A0H);
        }
        if (view.getWindowVisibility() != 0) {
            A0N(view, false, A0H(647, 37, 81));
            return new C1111Qa(C0Q.A0I);
        } else if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            A0N(view, false, A0H(295, 36, 57) + view.getMeasuredWidth() + A0H(27, 4, 45) + view.getMeasuredHeight());
            return new C1111Qa(C0Q.A0G);
        } else if (A00(view) < 0.9f) {
            A0N(view, false, A0H(488, 27, 42));
            return new C1111Qa(C0Q.A0B);
        } else {
            int targetVisibleAreaSize = view.getWidth();
            int height = view.getHeight();
            if (A0H[4].charAt(15) == 'A') {
                A0H[4] = "6urEtCeD4ew6lB3ALfyGXwnH3LBfrVYN";
                int[] iArr = new int[2];
                try {
                    view.getLocationOnScreen(iArr);
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect)) {
                        return new C1111Qa(C0Q.A07);
                    }
                    int heightPixels = Build.VERSION.SDK_INT;
                    if (A0H[1].length() == 16) {
                        A0H[1] = "Od97VXu84qI514kY";
                        if (heightPixels >= 17) {
                            Display display = ((WindowManager) xt.getSystemService(A0H(713, 6, 30))).getDefaultDisplay();
                            displayMetrics = new DisplayMetrics();
                            display.getRealMetrics(displayMetrics);
                        } else {
                            displayMetrics = xt.getResources().getDisplayMetrics();
                        }
                        Vector<Rect> rectVector = A0K(view);
                        int areaSize = A08(rectVector);
                        rectVector.add(rect);
                        int targetAreaSize = A08(rectVector) - areaSize;
                        int measuredHeight = view.getMeasuredHeight();
                        int areaSize2 = view.getMeasuredWidth();
                        float f2 = (targetAreaSize * 1.0f) / (measuredHeight * areaSize2);
                        boolean A1f = JD.A1f(xt);
                        int heightPixels2 = A01(i2, view);
                        float f3 = heightPixels2 / 100.0f;
                        if (A1f) {
                            int mViewabilityThreshold = (f2 > f3 ? 1 : (f2 == f3 ? 0 : -1));
                            if (mViewabilityThreshold < 0) {
                                A0N(view, false, String.format(Locale.US, A0H(571, 76, 123), Float.valueOf(f2), Float.valueOf(f3)));
                                return new C1111Qa(C0Q.A04, f2);
                            }
                        } else {
                            int mViewabilityThreshold2 = iArr[0];
                            if (mViewabilityThreshold2 < 0 || displayMetrics.widthPixels - iArr[0] < targetVisibleAreaSize) {
                                A0N(view, false, A0H(353, 44, 31));
                                return new C1111Qa(C0Q.A0D, f2);
                            }
                            int widthPixels = (int) ((height * (100.0d - heightPixels2)) / 100.0d);
                            if (rect.top - iArr[1] > widthPixels) {
                                A0N(view, false, A0H(436, 36, 63));
                                return new C1111Qa(C0Q.A0E, f2);
                            } else if ((iArr[1] + height) - rect.bottom > widthPixels) {
                                A0N(view, false, A0H(397, 39, 30));
                                return new C1111Qa(C0Q.A0C, f2);
                            }
                        }
                        if (!MM.A03(xt)) {
                            A0N(view, false, A0H(185, 26, 62));
                            return new C1111Qa(C0Q.A0L, f2);
                        }
                        Map<String, String> A01 = MN.A01(xt);
                        if (M6.A04(A01)) {
                            A0N(view, false, A0H(156, 29, 77));
                            return new C1111Qa(C0Q.A0A, f2);
                        } else if (JD.A1H(xt) && M6.A03(A01)) {
                            A0N(view, false, A0H(31, 31, 14));
                            return new C1111Qa(C0Q.A05, f2, A01);
                        } else {
                            A0N(view, true, A0H(515, 19, 99));
                            return new C1111Qa(C0Q.A0J, f2, A01);
                        }
                    }
                } catch (NullPointerException unused) {
                    A0N(view, false, A0H(62, 30, 43));
                    return new C1111Qa(C0Q.A0G);
                }
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x001e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Vector<android.graphics.Rect> A0K(android.view.View r7) {
        /*
            java.util.Vector r6 = new java.util.Vector
            r6.<init>()
            android.view.ViewParent r0 = r7.getParent()
            boolean r0 = r0 instanceof android.view.ViewGroup
            if (r0 != 0) goto Le
            return r6
        Le:
            android.view.ViewParent r5 = r7.getParent()
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            int r0 = r5.indexOfChild(r7)
            int r4 = r0 + 1
        L1a:
            int r0 = r5.getChildCount()
            if (r4 >= r0) goto L45
            android.view.View r3 = r5.getChildAt(r4)
            boolean r0 = r3 instanceof com.facebook.ads.redexgen.X.PM
            r2 = 0
            if (r0 != 0) goto L43
            r1 = 1
        L2a:
            boolean r0 = r3 instanceof com.facebook.ads.redexgen.X.S4
            if (r0 == 0) goto L34
            boolean r0 = com.facebook.ads.redexgen.X.C1112Qb.A00(r3)
            if (r0 != 0) goto L35
        L34:
            r2 = 1
        L35:
            if (r1 == 0) goto L40
            if (r2 == 0) goto L40
            java.util.Vector r0 = A0L(r3)
            r6.addAll(r0)
        L40:
            int r4 = r4 + 1
            goto L1a
        L43:
            r1 = 0
            goto L2a
        L45:
            java.util.Vector r0 = A0K(r5)
            r6.addAll(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.QZ.A0K(android.view.View):java.util.Vector");
    }

    public static Vector<Rect> A0L(View view) {
        Vector<Rect> vector = new Vector<>();
        if (!view.isShown() || (Build.VERSION.SDK_INT >= 11 && view.getAlpha() <= 0.0f)) {
            return vector;
        }
        int i2 = (view.getClass().getName().equals(A0H(245, 50, 38)) && view.getBackground() != null && (view.getBackground() instanceof GradientDrawable)) ? 1 : 0;
        if ((view instanceof ViewGroup) && (C1112Qb.A00(view) || i2 != 0)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                vector.addAll(A0L(viewGroup.getChildAt(i3)));
            }
            return vector;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            vector.add(rect);
        }
        return vector;
    }

    public static void A0N(View view, boolean z, String str) {
        if (BuildConfigApi.isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append(A0H(240, 5, 110));
            sb.append(view);
            sb.append(A0H(9, 4, 108));
            sb.append(z ? A0H(698, 8, 68) : A0H(684, 12, 97));
            sb.append(A0H(13, 14, 76));
            sb.append(str);
            sb.toString();
        }
    }

    public final synchronized String A0R() {
        String str;
        C0Q c0q = C0Q.valuesCustom()[this.A05.A01()];
        str = c0q.toString() + String.format(Locale.US, A0H(0, 9, 96), Float.valueOf(this.A05.A00() * 100.0f));
        String[] strArr = A0H;
        if (strArr[2].length() != strArr[7].length()) {
            String[] strArr2 = A0H;
            strArr2[3] = "JOA7A9ZNQCl2Un";
            strArr2[6] = "QxqmxS0D1VLzWHVOZgw4LxCbp";
            return str;
        }
        throw new RuntimeException();
    }

    public final synchronized Map<String, String> A0S() {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.put(A0H(708, 3, 59), String.valueOf(this.A05.A01()));
        hashMap.put(A0H(TypedValues.TransitionType.TYPE_STAGGERED, 2, 109), String.valueOf(this.A05.A00()));
        hashMap.put(A0H(696, 2, 84), new JSONObject(this.A06).toString());
        hashMap.put(A0H(711, 2, 69), C1008Ly.A05(this.A03));
        hashMap.putAll(this.A05.A03());
        return hashMap;
    }

    public final synchronized void A0T() {
        this.A05 = new C1111Qa(C0Q.A0M);
    }

    public final synchronized void A0U() {
        if (this.A04 != null) {
            A0V();
        }
        if (this.A07) {
            this.A0D.A0D().A34();
        }
        this.A04 = new C4L(this, this.A0D);
        this.A0B.postDelayed(this.A04, this.A01);
        this.A08 = false;
        this.A00 = 0;
        this.A05 = new C1111Qa(C0Q.A0M);
        this.A06 = new HashMap();
    }

    public final synchronized void A0V() {
        if (this.A07) {
            this.A0D.A0D().A35();
        }
        this.A0B.removeCallbacks(this.A04);
        this.A04 = null;
        this.A08 = true;
        this.A00 = 0;
    }

    public final void A0W(int i2) {
        this.A01 = i2;
    }

    public final void A0X(int i2) {
        if (BuildConfigApi.isDebug() && !this.A0F) {
            Log.w(A0I, A0H(92, 64, 14));
        }
        this.A02 = i2;
    }

    public final void A0Y(boolean z) {
        this.A07 = z;
    }

    public final synchronized boolean A0Z() {
        return this.A08;
    }
}
