package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Eq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0828Eq extends ViewGroup implements InterfaceC1483bt {
    public static byte[] A18;
    public static String[] A19 = {"EzQ8zede2M", "Jhjgeach8ubRdn89CHbftPIFCkhy8Cmz", "AI0RoC", "LwFgY3t3Qwi2PJUU36Pvm2", "gOCwMU1oDfpLVyXTNaTi7eQdHjis00sx", "GZYggCcl1OWg4VOzBYKk2kBvqjxmktta", "Te26Sy6xLG0KtVPzJaOHws0Kts3F9NRb", "K773CdyIAwEU"};
    public static final Interpolator A1A;
    public static final boolean A1B;
    public static final boolean A1C;
    public static final boolean A1D;
    public static final boolean A1E;
    public static final boolean A1F;
    public static final boolean A1G;
    public static final int[] A1H;
    public static final int[] A1I;
    public static final Class<?>[] A1J;
    public C1471bg A00;
    public C05583k A01;
    public C1470bf A02;
    public RunnableC05713x A03;
    public C4A A04;
    public C4I A05;
    @VisibleForTesting
    public C4M A06;
    public C4V A07;
    public RunnableC05774d A08;
    public C1457bR A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    @VisibleForTesting
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public float A0L;
    public float A0M;
    public int A0N;
    public int A0O;
    public int A0P;
    public int A0Q;
    public int A0R;
    public int A0S;
    public int A0T;
    public int A0U;
    public int A0V;
    public int A0W;
    public int A0X;
    public VelocityTracker A0Y;
    public EdgeEffect A0Z;
    public EdgeEffect A0a;
    public EdgeEffect A0b;
    public EdgeEffect A0c;
    public C05312j A0d;
    public C4D A0e;
    public C4G A0f;
    public C4P A0g;
    public C4Q A0h;
    public C4R A0i;
    public RecyclerView$SavedState A0j;
    public Runnable A0k;
    public List<RecyclerView.OnChildAttachStateChangeListener> A0l;
    public List<C4R> A0m;
    public boolean A0n;
    public boolean A0o;
    public final Rect A0p;
    public final RectF A0q;
    public final C4U A0r;
    public final C05754b A0s;
    public final C05864m A0t;
    public final Runnable A0u;
    public final ArrayList<C4J> A0v;
    @VisibleForTesting
    public final List<AbstractC05784e> A0w;
    public final int A0x;
    public final int A0y;
    public final Rect A0z;
    public final AccessibilityManager A10;
    public final C1459bU A11;
    public final InterfaceC05854l A12;
    public final ArrayList<C4Q> A13;
    public final int[] A14;
    public final int[] A15;
    public final int[] A16;
    public final int[] A17;

    public static String A0J(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A18, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 85);
        }
        return new String(copyOfRange);
    }

    public static void A0X() {
        A18 = new byte[]{-74, -74, -96, -74, -20, -1, -5, Draft_75.CR, -74, -34, 5, 2, -6, -5, 8, -74, -56, -48, -100, -33, -35, -22, -22, -21, -16, -100, -34, -31, -100, -30, -21, -15, -22, -32, -100, -34, -15, -16, -100, -27, -16, -100, -27, -17, -100, -22, -31, -33, -31, -17, -17, -35, -18, -11, -100, -30, -21, -18, -100, 126, -57, -47, 126, -65, -54, -48, -61, -65, -62, -41, 126, -65, -46, -46, -65, -63, -58, -61, -62, 126, -46, -51, 126, -65, 126, -80, -61, -63, -41, -63, -54, -61, -48, -76, -57, -61, -43, -104, -12, 61, 71, -12, 66, 67, 72, -12, 53, -12, 56, 61, 70, 57, 55, 72, -12, 55, 60, 61, 64, 56, -12, 67, 58, -12, -93, -15, -14, -9, -93, -23, -14, -8, -15, -25, -79, -93, -57, -20, -25, -93, -28, -15, -4, -93, -48, -14, -9, -20, -14, -15, -56, -7, -24, -15, -9, -10, -93, -22, -24, -9, -93, -10, -18, -20, -13, -13, -24, -25, -62, -45, -57, 8, 11, 8, 23, 27, 12, 25, -31, -117, Byte.MAX_VALUE, -62, -50, -51, -45, -60, -41, -45, -103, -56, -68, 8, -3, 21, 11, 17, 16, -42, 9, -18, 67, 65, 55, 60, 53, -18, 50, 51, 52, 47, 67, 58, 66, -18, 68, 47, 58, 67, 51, -67, -37, -26, -26, -33, -34, -102, -20, -33, -25, -23, -16, -33, -66, -33, -18, -37, -35, -30, -33, -34, -48, -29, -33, -15, -102, -15, -29, -18, -30, -102, -37, -102, -16, -29, -33, -15, -102, -15, -30, -29, -35, -30, -102, -29, -19, -102, -24, -23, -18, -102, -32, -26, -37, -31, -31, -33, -34, -102, -37, -19, -102, -18, -25, -22, -102, -34, -33, -18, -37, -35, -30, -33, -34, -88, -80, -50, -37, -37, -36, -31, -115, -48, -50, -39, -39, -115, -31, -43, -42, -32, -115, -38, -46, -31, -43, -36, -47, -115, -42, -37, -115, -50, -115, -32, -48, -33, -36, -39, -39, -115, -48, -50, -39, -39, -49, -50, -48, -40, -101, -115, -64, -48, -33, -36, -39, -39, -115, -48, -50, -39, -39, -49, -50, -48, -40, -32, -115, -38, -42, -44, -43, -31, -49, -46, -115, -33, -30, -37, -115, -47, -30, -33, -42, -37, -44, -115, -50, -115, -38, -46, -50, -32, -30, -33, -46, -115, -109, -115, -39, -50, -26, -36, -30, -31, -115, -35, -50, -32, -32, -115, -28, -43, -46, -33, -46, -115, -26, -36, -30, -115, -48, -50, -37, -37, -36, -31, -115, -48, -43, -50, -37, -44, -46, -115, -31, -43, -46, -65, -46, -48, -26, -48, -39, -46, -33, -61, -42, -46, -28, -115, -47, -50, -31, -50, -101, -115, -82, -37, -26, -115, -38, -46, -31, -43, -36, -47, -115, -48, -50, -39, -39, -115, -31, -43, -50, -31, -115, -38, -42, -44, -43, -31, -115, -48, -43, -50, -37, -44, -46, -115, -31, -43, -46, -115, -32, -31, -33, -30, -48, -31, -30, -33, -46, -36, -45, -115, -31, -43, -46, -115, -65, -46, -48, -26, -48, -39, -46, -33, -61, -42, -46, -28, -115, -36, -33, -115, -31, -43, -46, -115, -50, -47, -50, -35, -31, -46, -33, -115, -48, -36, -37, -31, -46, -37, -31, -32, -115, -32, -43, -36, -30, -39, -47, -115, -49, -46, -115, -35, -36, -32, -31, -35, -36, -37, -46, -47, -115, -31, -36, -31, -43, -46, -115, -37, -46, -27, -31, -115, -45, -33, -50, -38, -46, -101, -55, -25, -12, -12, -11, -6, -90, -23, -25, -14, -14, -90, -6, -18, -17, -7, -90, -13, -21, -6, -18, -11, -22, -90, -3, -18, -17, -14, -21, -90, -40, -21, -23, -1, -23, -14, -21, -8, -36, -17, -21, -3, -90, -17, -7, -90, -23, -11, -13, -10, -5, -6, -17, -12, -19, -90, -25, -90, -14, -25, -1, -11, -5, -6, -90, -11, -8, -90, -7, -23, -8, -11, -14, -14, -17, -12, -19, -28, 2, 15, 15, 16, 21, -63, 7, Draft_75.CR, 10, 15, 8, -63, 24, 10, 21, 9, 16, 22, 21, -63, 2, -63, -19, 2, 26, 16, 22, 21, -18, 2, 15, 2, 8, 6, 19, -63, 20, 6, 21, -49, -63, -28, 2, Draft_75.CR, Draft_75.CR, -63, 20, 6, 21, -19, 2, 26, 16, 22, 21, -18, 2, 15, 2, 8, 6, 19, -63, 24, 10, 21, 9, -63, 2, -63, 15, 16, 15, -50, 15, 22, Draft_75.CR, Draft_75.CR, -63, 2, 19, 8, 22, 14, 6, 15, 21, -49, -35, -5, 8, 8, 9, 14, -70, Draft_75.CR, -3, 12, 9, 6, 6, -70, 14, 9, -70, 10, 9, Draft_75.CR, 3, 14, 3, 9, 8, -70, -5, -70, -26, -5, 19, 9, 15, 14, -25, -5, 8, -5, 1, -1, 12, -70, Draft_75.CR, -1, 14, -56, -70, -35, -5, 6, 6, -70, Draft_75.CR, -1, 14, -26, -5, 19, 9, 15, 14, -25, -5, 8, -5, 1, -1, 12, -70, 17, 3, 14, 2, -70, -5, -70, 8, 9, 8, -57, 8, 15, 6, 6, -70, -5, 12, 1, 15, 7, -1, 8, 14, -56, -33, -3, 10, 10, 11, 16, -68, 15, -1, 14, 11, 8, 8, -68, 19, 5, 16, 4, 11, 17, 16, -68, -3, -68, -24, -3, 21, 11, 17, 16, -23, -3, 10, -3, 3, 1, 14, -68, 15, 1, 16, -54, -68, -33, -3, 8, 8, -68, 15, 1, 16, -24, -3, 21, 11, 17, 16, -23, -3, 10, -3, 3, 1, 14, -68, 19, 5, 16, 4, -68, -3, -68, 10, 11, 10, -55, 10, 17, 8, 8, -68, -3, 14, 3, 17, 9, 1, 10, 16, -54, -29, 1, 14, 14, 15, 20, -64, 19, Draft_75.CR, 15, 15, 20, 8, -64, 19, 3, 18, 15, 12, 12, -64, 23, 9, 20, 8, 15, 21, 20, -64, 1, -64, -20, 1, 25, 15, 21, 20, -19, 1, 14, 1, 7, 5, 18, -64, 19, 5, 20, -50, -64, -29, 1, 12, 12, -64, 19, 5, 20, -20, 1, 25, 15, 21, 20, -19, 1, 14, 1, 7, 5, 18, -64, 23, 9, 20, 8, 
        -64, 1, -64, 14, 15, 14, -51, 14, 21, 12, 12, -64, 1, 18, 7, 21, Draft_75.CR, 5, 14, 20, -50, -18, 25, -54, 24, 25, 30, -54, 29, 15, 30, -10, 11, 35, 25, 31, 30, -16, 28, 25, 36, 15, 24, -54, 19, 24, -54, 22, 11, 35, 25, 31, 30, -54, 25, 28, -54, 29, Draft_75.CR, 28, 25, 22, 22, -52, -7, -7, -10, -7, -89, -9, -7, -10, -22, -20, -6, -6, -16, -11, -18, -89, -6, -22, -7, -10, -13, -13, -62, -89, -9, -10, -16, -11, -5, -20, -7, -89, -16, -11, -21, -20, -1, -89, -19, -10, -7, -89, -16, -21, -89, -7, 14, 38, 28, 34, 33, -6, 14, 27, 14, 20, 18, 31, -51, -53, -20, -99, -34, -31, -34, -19, -15, -30, -17, -99, -34, -15, -15, -34, -32, -27, -30, -31, -72, -99, -16, -24, -26, -19, -19, -26, -21, -28, -99, -23, -34, -10, -20, -14, -15, -52, -19, -98, -22, -33, -9, -19, -13, -14, -98, -21, -33, -20, -33, -27, -29, -16, -98, -33, -14, -14, -33, -31, -26, -29, -30, -71, -98, -15, -23, -25, -18, -18, -25, -20, -27, -98, -22, -33, -9, -19, -13, -14, -1, 33, 30, 17, 27, 20, 28, -49, 38, 23, 24, 27, 20, -49, 28, 16, 35, 18, 23, 24, 29, 22, -49, 18, 23, 16, 29, 22, 20, 19, -49, 37, 24, 20, 38, -49, 23, 30, 27, 19, 20, 33, 34, -49, 38, 24, 35, 23, -49, 35, 23, 20, -49, 29, 20, 38, 30, 29, 20, 34, -35, -49, 3, 23, 20, -49, 31, 33, 20, -36, 27, 16, 40, 30, 36, 35, -49, 24, 29, 21, 30, 33, 28, 16, 35, 24, 30, 29, -49, 21, 30, 33, -49, 35, 23, 20, -49, 18, 23, 16, 29, 22, 20, -49, 23, 30, 27, 19, 20, 33, -49, 5, 9, -45, -7, 40, 31, 31, -4, 33, 41, 20, 31, 28, 23, 20, 39, 24, -3, 1, -53, -6, 25, -9, 12, 36, 26, 32, 31, -7, -3, -57, -9, 8, 25, 27, 16, 8, 19, -16, 21, 29, 8, 19, 16, 11, 8, 27, 12, -14, -10, -64, -13, 3, 18, 15, 12, 12, -10, 9, 7, 29, 7, 16, 9, 22, -6, Draft_75.CR, 9, 27, 1, 20, 18, 40, 18, 27, 20, 33, 5, 24, 20, 38, -49, 19, 30, 20, 34, -49, 29, 30, 35, -49, 34, 36, 31, 31, 30, 33, 35, -49, 34, 18, 33, 30, 27, 27, 24, 29, 22, -49, 35, 30, -49, 16, 29, -49, 16, 17, 34, 30, 27, 36, 35, 20, -49, 31, 30, 34, 24, 35, 24, 30, 29, -35, -49, 4, 34, 20, -49, 34, 18, 33, 30, 27, 27, 3, 30, -1, 30, 34, 24, 35, 24, 30, 29, -49, 24, 29, 34, 35, 20, 16, 19, -72, -53, -55, -33, -55, -46, -53, -40, -68, -49, -53, -35, -122, -50, -57, -39, -122, -44, -43, -122, -78, -57, -33, -43, -37, -38, -77, -57, -44, -57, -51, -53, -40, 29, 64, 56, -23, 45, 50, 47, 47, 46, 59, 46, 55, 61, -23, 31, 50, 46, 64, 17, 56, 53, 45, 46, 59, 60, -23, 49, 42, 63, 46, -23, 61, 49, 46, -23, 60, 42, 54, 46, -23, 44, 49, 42, 55, 48, 46, -23, 18, Draft_75.CR, -9, -23, 29, 49, 50, 60, -23, 54, 50, 48, 49, 61, -23, 49, 42, 57, 57, 46, 55, -23, 45, 62, 46, -23, 61, 56, -23, 50, 55, 44, 56, 55, 60, 50, 60, 61, 46, 55, 61, -23, 10, 45, 42, 57, 61, 46, 59, -23, 62, 57, 45, 42, 61, 46, -23, 46, 63, 46, 55, 61, 60, -23, 56, 59, -23, 50, 47, -23, 61, 49, 46, -23, 21, 42, 66, 56, 62, 61, 22, 42, 55, 42, 48, 46, 59, -23, 53, 42, 66, 60, -23, 56, 62, 61, -23, 61, 49, 46, -23, 60, 42, 54, 46, -23, 31, 50, 46, 64, -23, 54, 62, 53, 61, 50, 57, 53, 46, -23, 61, 50, 54, 46, 60, -9, -45, -23, 31, 50, 46, 64, 17, 56, 53, 45, 46, 59, -23, -6, 3, -10, 25, 17, -62, 6, 11, 8, 8, 7, 20, 7, 16, 22, -62, -8, 11, 7, 25, -22, 17, 14, 6, 7, 20, 21, -62, 10, 3, 24, 7, -62, 22, 10, 7, -62, 21, 3, 15, 7, -62, 21, 22, 3, 4, 14, 7, -62, -21, -26, -48, -62, -11, 22, 3, 4, 14, 7, -62, -21, -26, 21, -62, 11, 16, -62, 27, 17, 23, 20, -62, 3, 6, 3, 18, 22, 7, 20, -62, -17, -9, -11, -10, -62, -28, -25, -62, 23, 16, 11, 19, 23, 7, -62, 3, 16, 6, -62, -11, -22, -15, -9, -18, -26, -62, -16, -15, -10, -62, 5, 10, 3, 16, 9, 7, -48, -84, -62, -8, 11, 7, 25, -22, 17, 14, 6, 7, 20, -62, -45, -36, -29, -10, -14, 4, -83, 7, 9, 9, 11, 25, 25, 15, 8, 15, 18, 15, 26, 31, 31, 36, 45, 32, 30, 47, 36, 42, 41, -37, 40, 48, 46, 47, -37, 29, 32, -37, 28, 29, 46, 42, 39, 48, 47, 32, -23, -37, 45, 32, 30, 32, 36, 49, 32, 31, -11, -42, -43, -86, -49, -48, -45, -53, -67, -48, -52, -34, -88, -37, -37, -56, -54, -49, -52, -53, -69, -42, -66, -48, -43, -53, -42, -34, -40, -41, -84, -47, -46, -43, -51, -65, -46, -50, -32, -83, -50, -35, -54, -52, -47, -50, -51, -81, -37, -40, -42, -64, -46, -41, -51, -40, -32, -30, -44, -29, -62, -46, -31, -34, -37, -37, -40, -35, -42, -61, -34, -28, -46, -41, -62, -37, -34, -33, -105, -104, -87, -113, -47, -48, -45, -113, -48, -31, -42, -28, -36, -44, -35, -29, -113, -46, -34, -35, -30, -29, -48, -35, -29, -113};
    }

    static {
        A0X();
        A1I = new int[]{16843830};
        A1H = new int[]{16842987};
        A1C = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        A1B = Build.VERSION.SDK_INT >= 23;
        A1D = Build.VERSION.SDK_INT >= 16;
        A1E = Build.VERSION.SDK_INT >= 21;
        A1F = Build.VERSION.SDK_INT <= 15;
        A1G = Build.VERSION.SDK_INT <= 15;
        A1J = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        A1A = new Interpolator() { // from class: com.facebook.ads.redexgen.X.49
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public C0828Eq(Context context) {
        this(context, null);
    }

    public C0828Eq(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0828Eq(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A11 = new C1459bU(this);
        this.A0r = new C4U(this);
        this.A0t = new C05864m();
        this.A0u = new Runnable() { // from class: com.facebook.ads.redexgen.X.47
            @Override // java.lang.Runnable
            public final void run() {
                if (!C0828Eq.this.A0D || C0828Eq.this.isLayoutRequested()) {
                    return;
                }
                if (!C0828Eq.this.A0F) {
                    C0828Eq.this.requestLayout();
                } else if (C0828Eq.this.A0I) {
                    C0828Eq.this.A0J = true;
                } else {
                    C0828Eq.this.A1J();
                }
            }
        };
        this.A0p = new Rect();
        this.A0z = new Rect();
        this.A0q = new RectF();
        this.A0v = new ArrayList<>();
        this.A13 = new ArrayList<>();
        this.A0O = 0;
        this.A0C = false;
        this.A0U = 0;
        this.A0N = 0;
        this.A05 = new Ev();
        this.A0W = 0;
        this.A0V = -1;
        this.A0L = Float.MIN_VALUE;
        this.A0M = Float.MIN_VALUE;
        this.A0o = true;
        this.A08 = new RunnableC05774d(this);
        this.A02 = A1E ? new C1470bf() : null;
        this.A0s = new C05754b();
        this.A0G = false;
        this.A0H = false;
        this.A0f = new C1462bX(this);
        this.A0K = false;
        this.A14 = new int[2];
        this.A17 = new int[2];
        this.A16 = new int[2];
        this.A15 = new int[2];
        this.A0w = new ArrayList();
        this.A0k = new Runnable() { // from class: com.facebook.ads.redexgen.X.48
            @Override // java.lang.Runnable
            public final void run() {
                if (C0828Eq.this.A05 != null) {
                    C0828Eq.this.A05.A0J();
                }
                C0828Eq.this.A0K = false;
            }
        };
        this.A12 = new C1465ba(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, A1H, i2, 0);
            this.A0B = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.A0B = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.A0X = viewConfiguration.getScaledTouchSlop();
        this.A0L = AnonymousClass32.A00(viewConfiguration, context);
        this.A0M = AnonymousClass32.A01(viewConfiguration, context);
        this.A0y = viewConfiguration.getScaledMinimumFlingVelocity();
        this.A0x = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.A05.A0B(this.A0f);
        A0f();
        A0P();
        if (AnonymousClass31.A00(this) == 0) {
            AnonymousClass31.A09(this, 1);
        }
        this.A10 = (AccessibilityManager) getContext().getSystemService(A0J(1831, 13, 81));
        setAccessibilityDelegateCompat(new C1457bR(this));
        setDescendantFocusability(262144);
        setNestedScrollingEnabled(true);
    }

    private int A0B(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private final long A0C(AbstractC05784e abstractC05784e) {
        return this.A04.A0A() ? abstractC05784e.A0K() : abstractC05784e.A03;
    }

    @Nullable
    private View A0D() {
        AbstractC05784e A0E;
        int i2 = this.A0s.A01 != -1 ? this.A0s.A01 : 0;
        int A03 = this.A0s.A03();
        for (int i3 = i2; i3 < A03; i3++) {
            AbstractC05784e A0E2 = A0E(i3);
            if (A0E2 == null) {
                break;
            } else if (A0E2.A0H.hasFocusable()) {
                return A0E2.A0H;
            }
        }
        for (int min = Math.min(A03, i2) - 1; min >= 0 && (A0E = A0E(min)) != null; min--) {
            if (A0E.A0H.hasFocusable()) {
                return A0E.A0H;
            }
        }
        return null;
    }

    private final AbstractC05784e A0E(int i2) {
        if (this.A0C) {
            return null;
        }
        int A06 = this.A01.A06();
        AbstractC05784e abstractC05784e = null;
        for (int i3 = 0; i3 < A06; i3++) {
            AbstractC05784e A0G = A0G(this.A01.A0A(i3));
            if (A0G != null && !A0G.A0c() && A1D(A0G) == i2) {
                if (this.A01.A0K(A0G.A0H)) {
                    abstractC05784e = A0G;
                } else {
                    return A0G;
                }
            }
        }
        return abstractC05784e;
    }

    private final AbstractC05784e A0F(long j2) {
        C4A c4a = this.A04;
        if (c4a == null || !c4a.A0A()) {
            return null;
        }
        int A06 = this.A01.A06();
        AbstractC05784e abstractC05784e = null;
        for (int i2 = 0; i2 < A06; i2++) {
            AbstractC05784e A0G = A0G(this.A01.A0A(i2));
            if (A0G != null && !A0G.A0c()) {
                long A0K = A0G.A0K();
                String[] strArr = A19;
                if (strArr[3].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A19;
                strArr2[2] = "zZZE93";
                strArr2[7] = "VhF552wVYFMR";
                if (A0K != j2) {
                    continue;
                } else if (this.A01.A0K(A0G.A0H)) {
                    abstractC05784e = A0G;
                } else {
                    return A0G;
                }
            }
        }
        return abstractC05784e;
    }

    public static AbstractC05784e A0G(View view) {
        if (view == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[6] = "BAOGG7B6SgQWpjs0haC4kmkQlPV7A4k9";
        strArr[4] = "PAhaNRNZ3VZ1U75Bha3wwWQKZTmx8jYI";
        return ((C4N) layoutParams).A00;
    }

    @Nullable
    private final AbstractC05784e A0H(View view) {
        View A1F2 = A1F(view);
        if (A1F2 == null) {
            return null;
        }
        return A1H(A1F2);
    }

    @Nullable
    public static C0828Eq A0I(@NonNull View view) {
        if (view instanceof ViewGroup) {
            boolean z = view instanceof C0828Eq;
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            A19[1] = "St3OXKQiThZ0lO5vTnfaG6NXMltPJG5W";
            if (z) {
                return (C0828Eq) view;
            }
            ViewGroup parent = (ViewGroup) view;
            int childCount = parent.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                C0828Eq descendant = A0I(parent.getChildAt(i2));
                if (descendant != null) {
                    return descendant;
                }
            }
            return null;
        }
        return null;
    }

    private void A0K() {
        A0U();
        setScrollState(0);
    }

    private void A0L() {
        int i2 = this.A0P;
        this.A0P = 0;
        if (i2 != 0) {
            boolean A1s = A1s();
            String[] strArr = A19;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[3] = "eU2cwXbbXfV7oR8qPBCYPw";
            strArr2[0] = "cj1lHsGs8Y";
            if (A1s) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(2048);
                C3K.A01(obtain, i2);
                sendAccessibilityEventUnchecked(obtain);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0182 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0M() {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.A0M():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0N() {
        /*
            r6 = this;
            r6.A1K()
            r6.A1L()
            com.facebook.ads.redexgen.X.4b r1 = r6.A0s
            r0 = 6
            r1.A04(r0)
            com.facebook.ads.redexgen.X.bg r0 = r6.A00
            r0.A0G()
            com.facebook.ads.redexgen.X.4b r1 = r6.A0s
            com.facebook.ads.redexgen.X.4A r0 = r6.A04
            int r0 = r0.A0D()
            r1.A03 = r0
            com.facebook.ads.redexgen.X.4b r2 = r6.A0s
            r4 = 0
            r2.A00 = r4
            r2.A09 = r4
            com.facebook.ads.redexgen.X.4M r1 = r6.A06
            com.facebook.ads.redexgen.X.4U r0 = r6.A0r
            r1.A1y(r0, r2)
            com.facebook.ads.redexgen.X.4b r3 = r6.A0s
            r3.A0D = r4
            r0 = 0
            r6.A0j = r0
            boolean r0 = r3.A0C
            if (r0 == 0) goto L72
            com.facebook.ads.redexgen.X.4I r5 = r6.A05
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 3
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L85
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "QyMu0uKDVMcIUQ2WaaKkjpUJvINNzfF4"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "jnZHkwnP1Z9tC9uQsacmbdRp3FaoK01F"
            r0 = 4
            r2[r0] = r1
            if (r5 == 0) goto L72
            r0 = 1
        L57:
            r3.A0C = r0
            com.facebook.ads.redexgen.X.4b r3 = r6.A0s
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 32
            if (r1 == r0) goto L74
            r0 = 4
            r3.A04 = r0
            r6.A1M()
            r6.A1r(r4)
            return
        L72:
            r0 = 0
            goto L57
        L74:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "3IsVIAoReRfPbfS1EeUcjIwVgXkj1JVv"
            r0 = 1
            r2[r0] = r1
            r0 = 4
            r3.A04 = r0
            r6.A1M()
            r6.A1r(r4)
            return
        L85:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.A0N():void");
    }

    private void A0O() {
        this.A0s.A04(4);
        A1K();
        A1L();
        C05754b c05754b = this.A0s;
        c05754b.A04 = 1;
        if (c05754b.A0C) {
            for (int i2 = this.A01.A05() - 1; i2 >= 0; i2--) {
                AbstractC05784e A0G = A0G(this.A01.A09(i2));
                if (!A0G.A0h()) {
                    long key = A0C(A0G);
                    C4H A08 = this.A05.A08(this.A0s, A0G);
                    AbstractC05784e A05 = this.A0t.A05(key);
                    if (A05 != null && !A05.A0h()) {
                        boolean A0H = this.A0t.A0H(A05);
                        C05864m c05864m = this.A0t;
                        if (A19[5].charAt(2) != 'Y') {
                            break;
                        }
                        A19[1] = "oIS3LUWJBkP0D1bim3OID749wsN9UxnV";
                        boolean A0H2 = c05864m.A0H(A0G);
                        if (A0H && A05 == A0G) {
                            this.A0t.A0E(A0G, A08);
                        } else {
                            C4H A04 = this.A0t.A04(A05);
                            this.A0t.A0E(A0G, A08);
                            C4H A03 = this.A0t.A03(A0G);
                            if (A04 == null) {
                                A0n(key, A0G, A05);
                            } else {
                                A0u(A05, A0G, A04, A03, A0H, A0H2);
                            }
                        }
                    } else {
                        this.A0t.A0E(A0G, A08);
                    }
                }
            }
            this.A0t.A0G(this.A12);
        }
        this.A06.A1G(this.A0r);
        C05754b c05754b2 = this.A0s;
        c05754b2.A05 = c05754b2.A03;
        this.A0C = false;
        C05754b c05754b3 = this.A0s;
        c05754b3.A0C = false;
        c05754b3.A0B = false;
        this.A06.A09 = false;
        if (this.A0r.A02 != null) {
            ArrayList<AbstractC05784e> arrayList = this.A0r.A02;
            String[] strArr = A19;
            if (strArr[3].length() != strArr[0].length()) {
                A19[1] = "DxhhwSm2KO29M0snTVs4N8QFyNW6c8YZ";
                arrayList.clear();
            }
            throw new RuntimeException();
        }
        if (this.A06.A08) {
            C4M c4m = this.A06;
            c4m.A00 = 0;
            c4m.A08 = false;
            this.A0r.A0O();
        }
        this.A06.A1z(this.A0s);
        A1M();
        A1r(false);
        this.A0t.A06();
        int[] iArr = this.A14;
        if (A12(iArr[0], iArr[1])) {
            A1b(0, 0);
        }
        A0R();
        A0T();
    }

    private void A0P() {
        this.A01 = new C05583k(new C1464bZ(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0Q() {
        /*
            r7 = this;
            boolean r0 = r7.A0C
            if (r0 == 0) goto Le
            com.facebook.ads.redexgen.X.bg r0 = r7.A00
            r0.A0I()
            com.facebook.ads.redexgen.X.4M r0 = r7.A06
            r0.A1M(r7)
        Le:
            boolean r0 = r7.A10()
            if (r0 == 0) goto L51
            com.facebook.ads.redexgen.X.bg r0 = r7.A00
            r0.A0H()
        L19:
            boolean r0 = r7.A0G
            r3 = 0
            if (r0 != 0) goto L22
            boolean r0 = r7.A0H
            if (r0 == 0) goto L4f
        L22:
            r6 = 1
        L23:
            com.facebook.ads.redexgen.X.4b r4 = r7.A0s
            boolean r0 = r7.A0D
            if (r0 == 0) goto L6f
            com.facebook.ads.redexgen.X.4I r0 = r7.A05
            if (r0 == 0) goto L6f
            boolean r0 = r7.A0C
            if (r0 != 0) goto L39
            if (r6 != 0) goto L39
            com.facebook.ads.redexgen.X.4M r0 = r7.A06
            boolean r0 = r0.A09
            if (r0 == 0) goto L6f
        L39:
            boolean r5 = r7.A0C
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 5
            r1 = r1[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L57
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L4f:
            r6 = 0
            goto L23
        L51:
            com.facebook.ads.redexgen.X.bg r0 = r7.A00
            r0.A0G()
            goto L19
        L57:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "q3lLGfTGOOnJqHZydaTklLew08TAvgTY"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "cayAc0YyiA2wrQyaXaOul4VyYlz5tKdZ"
            r0 = 4
            r2[r0] = r1
            if (r5 == 0) goto L6d
            com.facebook.ads.redexgen.X.4A r0 = r7.A04
            boolean r0 = r0.A0A()
            if (r0 == 0) goto L6f
        L6d:
            r0 = 1
            goto L70
        L6f:
            r0 = 0
        L70:
            r4.A0C = r0
            com.facebook.ads.redexgen.X.4b r1 = r7.A0s
            boolean r0 = r1.A0C
            if (r0 == 0) goto L85
            if (r6 == 0) goto L85
            boolean r0 = r7.A0C
            if (r0 != 0) goto L85
            boolean r0 = r7.A10()
            if (r0 == 0) goto L85
            r3 = 1
        L85:
            r1.A0B = r3
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 32
            if (r1 == r0) goto La1
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "gWU7AH"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "O2IXTNL1mXfE"
            r0 = 7
            r2[r0] = r1
            return
        La1:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "vAY5NMbknnGVxibfJ54Fdf4KbFDo9MxQ"
            r0 = 5
            r2[r0] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.A0Q():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0R() {
        /*
            r7 = this;
            boolean r0 = r7.A0o
            if (r0 == 0) goto L24
            com.facebook.ads.redexgen.X.4A r0 = r7.A04
            if (r0 == 0) goto L24
            boolean r0 = r7.hasFocus()
            if (r0 == 0) goto L24
            int r1 = r7.getDescendantFocusability()
            r0 = 393216(0x60000, float:5.51013E-40)
            if (r1 == r0) goto L24
            int r1 = r7.getDescendantFocusability()
            r0 = 131072(0x20000, float:1.83671E-40)
            if (r1 != r0) goto L25
            boolean r0 = r7.isFocused()
            if (r0 == 0) goto L25
        L24:
            return
        L25:
            boolean r3 = r7.isFocused()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 5
            r1 = r1[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L3d
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3d:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "GSYhD7ljhsNq0QcPBhSV8ATJlhol3xt1"
            r0 = 5
            r2[r0] = r1
            if (r3 != 0) goto L6f
            android.view.View r1 = r7.getFocusedChild()
            boolean r0 = com.facebook.ads.redexgen.X.C0828Eq.A1G
            if (r0 == 0) goto L66
            android.view.ViewParent r0 = r1.getParent()
            if (r0 == 0) goto L5a
            boolean r0 = r1.hasFocus()
            if (r0 != 0) goto L66
        L5a:
            com.facebook.ads.redexgen.X.3k r0 = r7.A01
            int r0 = r0.A05()
            if (r0 != 0) goto L6f
            r7.requestFocus()
            return
        L66:
            com.facebook.ads.redexgen.X.3k r0 = r7.A01
            boolean r0 = r0.A0K(r1)
            if (r0 != 0) goto L6f
            return
        L6f:
            r6 = 0
            com.facebook.ads.redexgen.X.4b r0 = r7.A0s
            long r1 = r0.A08
            r4 = -1
            int r0 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r0 == 0) goto L8a
            com.facebook.ads.redexgen.X.4A r0 = r7.A04
            boolean r0 = r0.A0A()
            if (r0 == 0) goto L8a
            com.facebook.ads.redexgen.X.4b r0 = r7.A0s
            long r0 = r0.A08
            com.facebook.ads.redexgen.X.4e r6 = r7.A0F(r0)
        L8a:
            r3 = 0
            if (r6 == 0) goto L9f
            com.facebook.ads.redexgen.X.3k r1 = r7.A01
            android.view.View r0 = r6.A0H
            boolean r0 = r1.A0K(r0)
            if (r0 != 0) goto L9f
            android.view.View r0 = r6.A0H
            boolean r0 = r0.hasFocusable()
            if (r0 != 0) goto Lcb
        L9f:
            com.facebook.ads.redexgen.X.3k r0 = r7.A01
            int r0 = r0.A05()
            if (r0 <= 0) goto Lab
            android.view.View r3 = r7.A0D()
        Lab:
            if (r3 == 0) goto Lca
            com.facebook.ads.redexgen.X.4b r0 = r7.A0s
            int r0 = r0.A02
            long r1 = (long) r0
            int r0 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r0 == 0) goto Lc7
            com.facebook.ads.redexgen.X.4b r0 = r7.A0s
            int r0 = r0.A02
            android.view.View r1 = r3.findViewById(r0)
            if (r1 == 0) goto Lc7
            boolean r0 = r1.isFocusable()
            if (r0 == 0) goto Lc7
            r3 = r1
        Lc7:
            r3.requestFocus()
        Lca:
            return
        Lcb:
            android.view.View r3 = r6.A0H
            goto Lab
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.A0R():void");
    }

    private void A0S() {
        boolean z = false;
        EdgeEffect edgeEffect = this.A0a;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.A0a.isFinished();
        }
        EdgeEffect edgeEffect2 = this.A0c;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.A0c.isFinished();
        }
        EdgeEffect edgeEffect3 = this.A0b;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.A0b.isFinished();
        }
        EdgeEffect edgeEffect4 = this.A0Z;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.A0Z.isFinished();
        }
        if (z) {
            AnonymousClass31.A07(this);
        }
    }

    private void A0T() {
        C05754b c05754b = this.A0s;
        c05754b.A08 = -1L;
        c05754b.A01 = -1;
        c05754b.A02 = -1;
    }

    private void A0U() {
        VelocityTracker velocityTracker = this.A0Y;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        A1X(0);
        A0S();
    }

    private void A0V() {
        int A0G;
        View view = null;
        if (this.A0o && hasFocus() && this.A04 != null) {
            view = getFocusedChild();
        }
        AbstractC05784e A0H = view == null ? null : A0H(view);
        if (A0H == null) {
            A0T();
            return;
        }
        this.A0s.A08 = this.A04.A0A() ? A0H.A0K() : -1L;
        C05754b c05754b = this.A0s;
        if (this.A0C) {
            A0G = -1;
        } else {
            A0G = A0H.A0c() ? A0H.A01 : A0H.A0G();
        }
        c05754b.A01 = A0G;
        this.A0s.A02 = A0B(A0H.A0H);
    }

    private void A0W() {
        this.A08.A08();
        C4M c4m = this.A06;
        if (c4m != null) {
            c4m.A0x();
        }
    }

    private final void A0Y() {
        int A06 = this.A01.A06();
        for (int i2 = 0; i2 < A06; i2++) {
            C05583k c05583k = this.A01;
            String[] strArr = A19;
            String str = strArr[3];
            String str2 = strArr[0];
            int length = str.length();
            int i3 = str2.length();
            if (length == i3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[3] = "VFyFJGthyduvDNyVUqu48D";
            strArr2[0] = "uBjdUWzzez";
            AbstractC05784e A0G = A0G(c05583k.A0A(i2));
            if (!A0G.A0h()) {
                A0G.A0M();
            }
        }
        this.A0r.A0K();
    }

    private final void A0Z() {
        C4A c4a = this.A04;
        String A0J = A0J(1370, 12, 79);
        if (c4a == null) {
            Log.e(A0J, A0J(1123, 36, 40));
        } else if (this.A06 == null) {
            Log.e(A0J, A0J(1159, 43, 41));
        } else {
            C05754b c05754b = this.A0s;
            c05754b.A0A = false;
            if (c05754b.A04 == 1) {
                A0M();
                this.A06.A1O(this);
                A0N();
            } else if (this.A00.A0K() || this.A06.A0h() != getWidth() || this.A06.A0X() != getHeight()) {
                this.A06.A1O(this);
                A0N();
            } else {
                this.A06.A1O(this);
            }
            A0O();
        }
    }

    private final void A0a() {
        int i2;
        for (int size = this.A0w.size() - 1; size >= 0; size--) {
            AbstractC05784e abstractC05784e = this.A0w.get(size);
            if (abstractC05784e.A0H.getParent() == this && !abstractC05784e.A0h() && (i2 = abstractC05784e.A02) != -1) {
                AnonymousClass31.A09(abstractC05784e.A0H, i2);
                abstractC05784e.A02 = -1;
            }
        }
        this.A0w.clear();
    }

    private final void A0b() {
        if (this.A0Z != null) {
            return;
        }
        this.A0Z = new EdgeEffect(getContext());
        if (this.A0B) {
            this.A0Z.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.A0Z.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    private final void A0c() {
        if (this.A0a != null) {
            return;
        }
        this.A0a = new EdgeEffect(getContext());
        if (this.A0B) {
            EdgeEffect edgeEffect = this.A0a;
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int measuredWidth = getMeasuredWidth() - getPaddingLeft();
            String[] strArr = A19;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[6] = "GMHrLIeJxdXYoHZyaa7kSwSfzExGbrBL";
            strArr2[4] = "0YT1HYXH3vPYSlLI8aOL6WZeFeHH6VHe";
            edgeEffect.setSize(measuredHeight, measuredWidth - getPaddingRight());
            return;
        }
        this.A0a.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    private final void A0d() {
        if (this.A0b != null) {
            return;
        }
        this.A0b = new EdgeEffect(getContext());
        if (this.A0B) {
            this.A0b.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.A0b.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    private final void A0e() {
        if (this.A0c != null) {
            return;
        }
        this.A0c = new EdgeEffect(getContext());
        if (this.A0B) {
            this.A0c.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            return;
        }
        EdgeEffect edgeEffect = this.A0c;
        int measuredWidth = getMeasuredWidth();
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[2] = "10JS50";
        strArr[7] = "NY78MD5eAiV9";
        edgeEffect.setSize(measuredWidth, getMeasuredHeight());
    }

    private final void A0f() {
        this.A00 = new C1471bg(new C1463bY(this));
    }

    private final void A0g() {
        this.A0Z = null;
        this.A0c = null;
        this.A0b = null;
        this.A0a = null;
    }

    private final void A0h() {
        int A06 = this.A01.A06();
        for (int i2 = 0; i2 < A06; i2++) {
            ((C4N) this.A01.A0A(i2).getLayoutParams()).A01 = true;
        }
        this.A0r.A0M();
    }

    private final void A0i() {
        int A06 = this.A01.A06();
        for (int i2 = 0; i2 < A06; i2++) {
            AbstractC05784e A0G = A0G(this.A01.A0A(i2));
            if (A0G != null && !A0G.A0h()) {
                A0G.A0T(6);
            }
        }
        A0h();
        this.A0r.A0N();
    }

    private final void A0j() {
        int A06 = this.A01.A06();
        for (int i2 = 0; i2 < A06; i2++) {
            AbstractC05784e A0G = A0G(this.A01.A0A(i2));
            if (!A0G.A0h()) {
                A0G.A0R();
            }
        }
    }

    private void A0k(float f2, float f3, float f4, float f5) {
        boolean z = false;
        if (f3 < 0.0f) {
            A0c();
            C05493b.A00(this.A0a, (-f3) / getWidth(), 1.0f - (f4 / getHeight()));
            z = true;
        } else if (f3 > 0.0f) {
            A0d();
            C05493b.A00(this.A0b, f3 / getWidth(), f4 / getHeight());
            z = true;
        }
        if (f5 < 0.0f) {
            A0e();
            C05493b.A00(this.A0c, (-f5) / getHeight(), f2 / getWidth());
            z = true;
        } else if (f5 > 0.0f) {
            A0b();
            C05493b.A00(this.A0Z, f5 / getHeight(), 1.0f - (f2 / getWidth()));
            z = true;
        }
        if (z || f3 != 0.0f || f5 != 0.0f) {
            AnonymousClass31.A07(this);
        }
    }

    private final void A0l(int i2) {
        C4M c4m = this.A06;
        C4R c4r = this.A0i;
        if (c4r != null) {
            c4r.A0L(this, i2);
        }
        List<C4R> list = this.A0m;
        String[] strArr = A19;
        if (strArr[2].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A19;
        strArr2[2] = "mB2qLC";
        strArr2[7] = "mQXIqdAaLius";
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.A0m.get(size).A0L(this, i2);
            }
        }
    }

    private final void A0m(int i2, int i3, Interpolator interpolator) {
        C4M c4m = this.A06;
        if (c4m == null) {
            Log.e(A0J(1370, 12, 79), A0J(924, 97, 75));
            return;
        }
        boolean z = this.A0I;
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[2] = "pqK8Y9";
        strArr[7] = "UiASdGbGWO9v";
        if (z) {
            return;
        }
        if (!c4m.A24()) {
            i2 = 0;
        }
        if (!this.A06.A25()) {
            i3 = 0;
        }
        if (i2 != 0 || i3 != 0) {
            this.A08.A0D(i2, i3, interpolator);
        }
    }

    private void A0n(long j2, AbstractC05784e other, AbstractC05784e abstractC05784e) {
        int A05 = this.A01.A05();
        for (int i2 = 0; i2 < A05; i2++) {
            AbstractC05784e A0G = A0G(this.A01.A09(i2));
            if (A0G != other && A0C(A0G) == j2) {
                C4A c4a = this.A04;
                String A0J = A0J(1, 17, 65);
                if (c4a != null && c4a.A0A()) {
                    throw new IllegalStateException(A0J(1696, 130, 77) + A0G + A0J + other + A1I());
                }
                throw new IllegalStateException(A0J(1508, 188, 116) + A0G + A0J + other + A1I());
            }
        }
        Log.e(A0J(1370, 12, 79), A0J(1202, 111, 90) + abstractC05784e + A0J(18, 41, 39) + other + A1I());
    }

    private void A0o(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) != this.A0V) {
            return;
        }
        int i2 = actionIndex == 0 ? 1 : 0;
        this.A0V = motionEvent.getPointerId(i2);
        int x = (int) (motionEvent.getX(i2) + 0.5f);
        this.A0S = x;
        this.A0Q = x;
        int y = (int) (motionEvent.getY(i2) + 0.5f);
        this.A0T = y;
        this.A0R = y;
    }

    public static void A0p(View view, Rect insets) {
        C4N c4n = (C4N) view.getLayoutParams();
        Rect rect = c4n.A03;
        insets.set((view.getLeft() - rect.left) - c4n.leftMargin, (view.getTop() - rect.top) - c4n.topMargin, view.getRight() + rect.right + c4n.rightMargin, view.getBottom() + rect.bottom + c4n.bottomMargin);
    }

    private void A0q(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.A0p.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof C4N) {
            C4N c4n = (C4N) layoutParams;
            if (!c4n.A01) {
                Rect rect = c4n.A03;
                this.A0p.left -= rect.left;
                this.A0p.right += rect.right;
                this.A0p.top -= rect.top;
                this.A0p.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.A0p);
            offsetRectIntoDescendantCoords(view, this.A0p);
        }
        this.A06.A1e(this, view, this.A0p, !this.A0D, view2 == null);
    }

    private void A0r(C4A c4a, boolean z, boolean z2) {
        C4A c4a2 = this.A04;
        if (c4a2 != null) {
            C1459bU c1459bU = this.A11;
            String[] strArr = A19;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[6] = "W0We85FJJqvSsXa60a6gd4EA7hDdiGkp";
            strArr2[4] = "7sp9VzUFxAlBM78ItapDbGKr6NkpOVCZ";
            c4a2.A08(c1459bU);
        }
        if (!z || z2) {
            A1O();
        }
        this.A00.A0I();
        C4A c4a3 = this.A04;
        this.A04 = c4a;
        if (c4a != null) {
            c4a.A07(this.A11);
        }
        C4M c4m = this.A06;
        this.A0r.A0Y(c4a3, this.A04, z);
        this.A0s.A0D = true;
        A1Q();
    }

    private void A0s(AbstractC05784e abstractC05784e) {
        View view = abstractC05784e.A0H;
        boolean z = view.getParent() == this;
        this.A0r.A0c(A1H(view));
        if (abstractC05784e.A0e()) {
            C05583k c05583k = this.A01;
            String[] strArr = A19;
            if (strArr[3].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[6] = "yAMck033yUmsKAwrNaBuaPdrYuAtD8a4";
            strArr2[4] = "2F1g5meBaFaT8Ughfaz4Efd5BOFwzFG2";
            c05583k.A0H(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.A01.A0J(view, true);
        } else {
            this.A01.A0E(view);
        }
    }

    public static void A0t(@NonNull AbstractC05784e abstractC05784e) {
        if (abstractC05784e.A09 != null) {
            WeakReference<C0828Eq> weakReference = abstractC05784e.A09;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[6] = "Lp0Vudgnjyr9htx58aJuOXSG6zR0Rms0";
            strArr[4] = "QnOoNSP4qihOpTYseackLt73SA9jbFjz";
            C0828Eq c0828Eq = weakReference.get();
            while (c0828Eq != null) {
                if (c0828Eq == abstractC05784e.A0H) {
                    return;
                }
                ViewParent parent = c0828Eq.getParent();
                if (parent instanceof View) {
                    c0828Eq = (View) parent;
                } else {
                    c0828Eq = null;
                }
            }
            abstractC05784e.A09 = null;
        }
    }

    private void A0u(@NonNull AbstractC05784e abstractC05784e, @NonNull AbstractC05784e abstractC05784e2, @NonNull C4H c4h, @NonNull C4H c4h2, boolean z, boolean z2) {
        abstractC05784e.A0Z(false);
        if (z) {
            A0s(abstractC05784e);
        }
        if (abstractC05784e != abstractC05784e2) {
            if (z2) {
                A0s(abstractC05784e2);
            }
            abstractC05784e.A06 = abstractC05784e2;
            A0s(abstractC05784e);
            this.A0r.A0c(abstractC05784e);
            abstractC05784e2.A0Z(false);
            abstractC05784e2.A07 = abstractC05784e;
        }
        if (this.A05.A0H(abstractC05784e, abstractC05784e2, c4h, c4h2)) {
            A1N();
        }
    }

    private void A0y(int[] iArr) {
        int minPositionPreLayout = this.A01.A05();
        if (minPositionPreLayout == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int pos = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < minPositionPreLayout; i3++) {
            AbstractC05784e A0G = A0G(this.A01.A09(i3));
            if (!A0G.A0h()) {
                int A0I = A0G.A0I();
                if (A0I < pos) {
                    pos = A0I;
                }
                if (A0I > i2) {
                    i2 = A0I;
                }
            }
        }
        iArr[0] = pos;
        iArr[1] = i2;
    }

    private boolean A0z() {
        int A05 = this.A01.A05();
        for (int i2 = 0; i2 < A05; i2++) {
            AbstractC05784e A0G = A0G(this.A01.A09(i2));
            if (A0G != null && !A0G.A0h() && A0G.A0f()) {
                return true;
            }
        }
        return false;
    }

    private boolean A10() {
        return this.A05 != null && this.A06.A26();
    }

    private boolean A12(int i2, int i3) {
        A0y(this.A14);
        int[] iArr = this.A14;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private final boolean A13(int nestedScrollAxis, int i2) {
        C4M c4m = this.A06;
        if (c4m == null) {
            Log.e(A0J(1370, 12, 79), A0J(651, 89, 76));
            return false;
        } else if (this.A0I) {
            return false;
        } else {
            boolean A24 = c4m.A24();
            boolean A25 = this.A06.A25();
            nestedScrollAxis = (!A24 || Math.abs(nestedScrollAxis) < this.A0y) ? 0 : 0;
            i2 = (!A25 || Math.abs(i2) < this.A0y) ? 0 : 0;
            if ((nestedScrollAxis != 0 || i2 != 0) && !dispatchNestedPreFling(nestedScrollAxis, i2)) {
                boolean z = A24 || A25;
                dispatchNestedFling(nestedScrollAxis, i2, z);
                C4P c4p = this.A0g;
                if (c4p != null && c4p.A0B(nestedScrollAxis, i2)) {
                    return true;
                }
                if (z) {
                    int i3 = 0;
                    if (A24) {
                        i3 = 0 | 1;
                    }
                    if (A25) {
                        i3 |= 2;
                    }
                    A1w(i3, 1);
                    int i4 = this.A0x;
                    int max = Math.max(-i4, Math.min(nestedScrollAxis, i4));
                    int i5 = this.A0x;
                    this.A08.A09(max, Math.max(-i5, Math.min(i2, i5)));
                    return true;
                }
            }
            return false;
        }
    }

    private final boolean A14(int unconsumedY, int consumedX, MotionEvent motionEvent) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        A1J();
        if (this.A04 != null) {
            A1K();
            A1L();
            C2O.A01(A0J(1361, 9, 75));
            A1l(this.A0s);
            if (unconsumedY != 0) {
                i4 = this.A06.A1h(unconsumedY, this.A0r, this.A0s);
                i2 = unconsumedY - i4;
            }
            if (consumedX != 0) {
                i5 = this.A06.A1i(consumedX, this.A0r, this.A0s);
                i3 = consumedX - i5;
            }
            C2O.A00();
            A1P();
            A1M();
            A1r(false);
        }
        if (!this.A0v.isEmpty()) {
            invalidate();
        }
        if (A1x(i4, i5, i2, i3, this.A17, 0)) {
            int consumedY = this.A0S;
            int[] iArr = this.A17;
            int unconsumedX = iArr[0];
            this.A0S = consumedY - unconsumedX;
            int consumedY2 = this.A0T;
            int unconsumedX2 = iArr[1];
            this.A0T = consumedY2 - unconsumedX2;
            if (motionEvent != null) {
                int unconsumedX3 = iArr[0];
                float f2 = unconsumedX3;
                int unconsumedX4 = iArr[1];
                motionEvent.offsetLocation(f2, unconsumedX4);
            }
            int[] iArr2 = this.A15;
            int i6 = iArr2[0];
            int[] iArr3 = this.A17;
            int unconsumedX5 = iArr3[0];
            int i7 = i6 + unconsumedX5;
            String[] strArr = A19;
            String str = strArr[6];
            String str2 = strArr[4];
            int consumedY3 = str.charAt(17);
            int unconsumedX6 = str2.charAt(17);
            if (consumedY3 != unconsumedX6) {
                throw new RuntimeException();
            }
            A19[1] = "TzjapWGLjdNwrlMHhQTvw0KTjubTnl9R";
            iArr2[0] = i7;
            int consumedY4 = iArr2[1];
            int unconsumedX7 = iArr3[1];
            iArr2[1] = consumedY4 + unconsumedX7;
        } else {
            int consumedY5 = getOverScrollMode();
            if (consumedY5 != 2) {
                if (motionEvent != null && !C05292h.A00(motionEvent, 8194)) {
                    float x = motionEvent.getX();
                    float f3 = i2;
                    float y = motionEvent.getY();
                    float f4 = i3;
                    int consumedY6 = A19[1].length();
                    if (consumedY6 != 32) {
                        throw new RuntimeException();
                    }
                    A19[1] = "Rb7Wd2rB1Bk4FJnk1H23iqiZozoKDKpI";
                    A0k(x, f3, y, f4);
                }
                A1Z(unconsumedY, consumedX);
            }
        }
        if (i4 != 0 || i5 != 0) {
            A1b(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && i5 == 0) ? false : true;
    }

    private boolean A15(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.A0h != null) {
            if (action == 0) {
                this.A0h = null;
            } else {
                if (action == 3 || action == 1) {
                    this.A0h = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.A13.size();
            for (int i2 = 0; i2 < size; i2++) {
                C4Q c4q = this.A13.get(i2);
                if (c4q.onInterceptTouchEvent(this, motionEvent)) {
                    this.A0h = c4q;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean A16(MotionEvent motionEvent) {
        int listenerCount = motionEvent.getAction();
        if (listenerCount == 3 || listenerCount == 0) {
            this.A0h = null;
        }
        int size = this.A13.size();
        for (int i2 = 0; i2 < size; i2++) {
            C4Q c4q = this.A13.get(i2);
            if (c4q.onInterceptTouchEvent(this, motionEvent) && listenerCount != 3) {
                this.A0h = c4q;
                return true;
            }
        }
        return false;
    }

    private boolean A17(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (view == null) {
            return true;
        }
        if (i2 == 2 || i2 == 1) {
            if ((i2 == 2) ^ (this.A06.A0a() == 1)) {
                i3 = 66;
            } else {
                i3 = 17;
            }
            if (A18(view, view2, i3)) {
                return true;
            }
            if (i2 == 2) {
                return A18(view, view2, 130);
            }
            return A18(view, view2, 33);
        }
        return A18(view, view2, i2);
    }

    private boolean A18(View view, View view2, int i2) {
        this.A0p.set(0, 0, view.getWidth(), view.getHeight());
        this.A0z.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.A0p);
        offsetDescendantRectToMyCoords(view2, this.A0z);
        if (i2 == 17) {
            return (this.A0p.right > this.A0z.right || this.A0p.left >= this.A0z.right) && this.A0p.left > this.A0z.left;
        }
        String[] strArr = A19;
        if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
            throw new RuntimeException();
        }
        A19[1] = "Yc6OUsH3chOpt4vkJfacRirYduge3wUm";
        if (i2 == 33) {
            return (this.A0p.bottom > this.A0z.bottom || this.A0p.top >= this.A0z.bottom) && this.A0p.top > this.A0z.top;
        } else if (i2 == 66) {
            return (this.A0p.left < this.A0z.left || this.A0p.right <= this.A0z.left) && this.A0p.right < this.A0z.right;
        } else if (i2 == 130) {
            return (this.A0p.top < this.A0z.top || this.A0p.bottom <= this.A0z.top) && this.A0p.bottom < this.A0z.bottom;
        } else {
            throw new IllegalArgumentException(A0J(1844, 37, 102) + i2 + A1I());
        }
    }

    private final boolean A19(AccessibilityEvent accessibilityEvent) {
        if (A1u()) {
            int i2 = 0;
            if (accessibilityEvent != null) {
                i2 = C3K.A00(accessibilityEvent);
            }
            if (i2 == 0) {
                i2 = 0;
            }
            this.A0P |= i2;
            return true;
        }
        return false;
    }

    public final int A1C(View view) {
        AbstractC05784e A0G = A0G(view);
        if (A0G != null) {
            return A0G.A0I();
        }
        return -1;
    }

    public final int A1D(AbstractC05784e abstractC05784e) {
        if (abstractC05784e.A0k(524) || !abstractC05784e.A0a()) {
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[2] = "S0wUd1";
            strArr[7] = "zF1SY7WsjbFG";
            return -1;
        }
        return this.A00.A0E(abstractC05784e.A03);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r3 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Rect A1E(android.view.View r9) {
        /*
            r8 = this;
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            com.facebook.ads.redexgen.X.4N r6 = (com.facebook.ads.redexgen.X.C4N) r6
            boolean r0 = r6.A01
            if (r0 != 0) goto Ld
            android.graphics.Rect r0 = r6.A03
            return r0
        Ld:
            com.facebook.ads.redexgen.X.4b r0 = r8.A0s
            boolean r0 = r0.A07()
            if (r0 == 0) goto L44
            boolean r0 = r6.A01()
            if (r0 != 0) goto L41
            boolean r3 = r6.A03()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 5
            r1 = r1[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L33
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L33:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "R8RZJpxNRYJLmE7KdaIYiTLeL7r3Y7bS"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "BRrnvNJfpVwihHaR5a5gEdBxu0vp26qH"
            r0 = 4
            r2[r0] = r1
            if (r3 == 0) goto L44
        L41:
            android.graphics.Rect r0 = r6.A03
            return r0
        L44:
            android.graphics.Rect r5 = r6.A03
            r4 = 0
            r5.set(r4, r4, r4, r4)
            java.util.ArrayList<com.facebook.ads.redexgen.X.4J> r0 = r8.A0v
            int r3 = r0.size()
            r2 = 0
        L51:
            if (r2 >= r3) goto L8e
            android.graphics.Rect r0 = r8.A0p
            r0.set(r4, r4, r4, r4)
            java.util.ArrayList<com.facebook.ads.redexgen.X.4J> r0 = r8.A0v
            java.lang.Object r7 = r0.get(r2)
            com.facebook.ads.redexgen.X.4J r7 = (com.facebook.ads.redexgen.X.C4J) r7
            android.graphics.Rect r1 = r8.A0p
            com.facebook.ads.redexgen.X.4b r0 = r8.A0s
            r7.A01(r1, r9, r8, r0)
            int r1 = r5.left
            android.graphics.Rect r0 = r8.A0p
            int r0 = r0.left
            int r1 = r1 + r0
            r5.left = r1
            int r1 = r5.top
            android.graphics.Rect r0 = r8.A0p
            int r0 = r0.top
            int r1 = r1 + r0
            r5.top = r1
            int r1 = r5.right
            android.graphics.Rect r0 = r8.A0p
            int r0 = r0.right
            int r1 = r1 + r0
            r5.right = r1
            int r1 = r5.bottom
            android.graphics.Rect r0 = r8.A0p
            int r0 = r0.bottom
            int r1 = r1 + r0
            r5.bottom = r1
            int r2 = r2 + 1
            goto L51
        L8e:
            r6.A01 = r4
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.A1E(android.view.View):android.graphics.Rect");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        return r3;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View A1F(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r1 = r3.getParent()
        L4:
            if (r1 == 0) goto L14
            if (r1 == r2) goto L14
            boolean r0 = r1 instanceof android.view.View
            if (r0 == 0) goto L14
            r3 = r1
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r1 = r3.getParent()
            goto L4
        L14:
            if (r1 != r2) goto L17
        L16:
            return r3
        L17:
            r3 = 0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.A1F(android.view.View):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.ads.redexgen.X.AbstractC05784e A1G(int r9, boolean r10) {
        /*
            r8 = this;
            com.facebook.ads.redexgen.X.3k r0 = r8.A01
            int r6 = r0.A06()
            r1 = 0
            r5 = 0
        L8:
            if (r5 >= r6) goto L5f
            com.facebook.ads.redexgen.X.3k r0 = r8.A01
            android.view.View r0 = r0.A0A(r5)
            com.facebook.ads.redexgen.X.4e r4 = A0G(r0)
            if (r4 == 0) goto L22
            boolean r0 = r4.A0c()
            if (r0 != 0) goto L22
            if (r10 == 0) goto L25
            int r0 = r4.A03
            if (r0 == r9) goto L2c
        L22:
            int r5 = r5 + 1
            goto L8
        L25:
            int r0 = r4.A0I()
            if (r0 == r9) goto L2c
            goto L22
        L2c:
            com.facebook.ads.redexgen.X.3k r7 = r8.A01
            android.view.View r3 = r4.A0H
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 6
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 17
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L4a
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L4a:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "j0pgcyCAMmCuelBFBaEKhw82BLWYdvOX"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "bxiKg4TrHtXBSvyNTaSo7IOhyUGlGIW4"
            r0 = 4
            r2[r0] = r1
            boolean r0 = r7.A0K(r3)
            if (r0 == 0) goto L5e
            r1 = r4
            goto L22
        L5e:
            return r4
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.A1G(int, boolean):com.facebook.ads.redexgen.X.4e");
    }

    public final AbstractC05784e A1H(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return A0G(view);
        }
        throw new IllegalArgumentException(A0J(1826, 5, 56) + view + A0J(98, 26, 127) + this);
    }

    public final String A1I() {
        return A0J(0, 1, 65) + super.toString() + A0J(169, 10, 82) + this.A04 + A0J(189, 9, 71) + this.A06 + A0J(179, 10, 10) + getContext();
    }

    public final void A1J() {
        boolean z = this.A0D;
        String A0J = A0J(1313, 17, 94);
        if (!z || this.A0C) {
            C2O.A01(A0J);
            A0Z();
            C2O.A00();
        } else if (!this.A00.A0J()) {
        } else {
            if (this.A00.A0L(4)) {
                boolean A0L = this.A00.A0L(11);
                if (A19[5].charAt(2) != 'Y') {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[6] = "e84NaKOnn7I9zpRn8aasqpcOMtbsg9mo";
                strArr[4] = "iuEMZhfSQYSf3gJ7Ya7A7FZe771rQXKi";
                if (!A0L) {
                    C2O.A01(A0J(1341, 20, 82));
                    A1K();
                    A1L();
                    this.A00.A0H();
                    if (!this.A0J) {
                        if (A0z()) {
                            A0Z();
                        } else {
                            this.A00.A0F();
                        }
                    }
                    A1r(true);
                    A1M();
                    C2O.A00();
                    return;
                }
            }
            if (this.A00.A0J()) {
                C2O.A01(A0J);
                A0Z();
                C2O.A00();
            }
        }
    }

    public final void A1K() {
        this.A0O++;
        if (this.A0O == 1 && !this.A0I) {
            this.A0J = false;
        }
    }

    public final void A1L() {
        this.A0U++;
    }

    public final void A1M() {
        A1q(true);
    }

    public final void A1N() {
        if (!this.A0K && this.A0F) {
            AnonymousClass31.A0D(this, this.A0k);
            this.A0K = true;
        }
    }

    public final void A1O() {
        C4I c4i = this.A05;
        if (c4i != null) {
            c4i.A0I();
        }
        C4M c4m = this.A06;
        if (c4m != null) {
            c4m.A1I(this.A0r);
            this.A06.A1G(this.A0r);
        }
        this.A0r.A0P();
    }

    public final void A1P() {
        int A05 = this.A01.A05();
        for (int i2 = 0; i2 < A05; i2++) {
            View A09 = this.A01.A09(i2);
            AbstractC05784e A1H2 = A1H(A09);
            if (A1H2 != null && A1H2.A07 != null) {
                View view = A1H2.A07.A0H;
                int left = A09.getLeft();
                int top = A09.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    int width = view.getWidth();
                    String[] strArr = A19;
                    String str = strArr[2];
                    String str2 = strArr[7];
                    int top2 = str.length();
                    if (top2 == str2.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A19;
                    strArr2[3] = "Uubm7UlJXcXPQblsDCbwus";
                    strArr2[0] = "kvvVMTFBun";
                    view.layout(left, top, width + left, view.getHeight() + top);
                }
            }
        }
    }

    public final void A1Q() {
        this.A0C = true;
        A0i();
    }

    public final void A1R() {
        setScrollState(0);
        A0W();
    }

    public final void A1S(int i2) {
        C4M c4m = this.A06;
        if (c4m == null) {
            return;
        }
        c4m.A1t(i2);
        awakenScrollBars();
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[2] = "0QEBPr";
        strArr[7] = "MYIDRbA0xlXg";
    }

    public final void A1T(int i2) {
        int A05 = this.A01.A05();
        for (int i3 = 0; i3 < A05; i3++) {
            this.A01.A09(i3).offsetLeftAndRight(i2);
        }
    }

    public final void A1U(int i2) {
        int A05 = this.A01.A05();
        for (int i3 = 0; i3 < A05; i3++) {
            this.A01.A09(i3).offsetTopAndBottom(i2);
        }
    }

    public final void A1V(int i2) {
        if (this.A0I) {
            return;
        }
        A1R();
        C4M c4m = this.A06;
        if (c4m == null) {
            String A0J = A0J(1370, 12, 79);
            String[] strArr = A19;
            if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A19;
            strArr2[6] = "bKq2dxkRCeugdKx9Xa6GvrcP2g1fh08B";
            strArr2[4] = "kU2aPHyT0THRQATybaGwdbwAtHBBu9qc";
            Log.e(A0J, A0J(740, 94, 69));
            return;
        }
        c4m.A1t(i2);
        awakenScrollBars();
    }

    public final void A1W(int i2) {
        if (this.A0I) {
            return;
        }
        C4M c4m = this.A06;
        String[] strArr = A19;
        if (strArr[3].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A19;
        strArr2[6] = "WdHf0lV4QkHUB6jMNa4hJVyYAF4qnaeC";
        strArr2[4] = "5gGhKJie0DBDDFfkhapEv4fZOrT4upMj";
        if (c4m != null) {
            c4m.A21(this, this.A0s, i2);
            return;
        }
        String[] strArr3 = A19;
        if (strArr3[6].charAt(17) != strArr3[4].charAt(17)) {
            String[] strArr4 = A19;
            strArr4[6] = "tnW8WJDd0hyAXA7zkanproBVQy0r1bMC";
            strArr4[4] = "4Fp0w8uFB0Hn5lDXLaIQvmhL07bdVyXH";
            Log.e(A0J(1370, 10, 13), A0J(858, 46, 16));
            return;
        }
        String[] strArr5 = A19;
        strArr5[3] = "z3A7CLBHtBtrAEYqxn9jPo";
        strArr5[0] = "loKczzo2gT";
        Log.e(A0J(1370, 12, 79), A0J(924, 97, 75));
    }

    public final void A1X(int i2) {
        getScrollingChildHelper().A03(i2);
    }

    public final void A1Y(int i2, int i3) {
        if (i2 < 0) {
            A0c();
            this.A0a.onAbsorb(-i2);
        } else if (i2 > 0) {
            A0d();
            this.A0b.onAbsorb(i2);
        }
        if (i3 < 0) {
            A0e();
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            A19[1] = "gyhAwDIMjNJoK3bJ2ki6wxmL7XFPannX";
            this.A0c.onAbsorb(-i3);
        } else if (i3 > 0) {
            A0b();
            this.A0Z.onAbsorb(i3);
        }
        if (i2 != 0 || i3 != 0) {
            AnonymousClass31.A07(this);
        }
    }

    public final void A1Z(int i2, int i3) {
        boolean z = false;
        EdgeEffect edgeEffect = this.A0a;
        if (edgeEffect != null && !edgeEffect.isFinished() && i2 > 0) {
            this.A0a.onRelease();
            z = this.A0a.isFinished();
        }
        EdgeEffect edgeEffect2 = this.A0b;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.A0b.onRelease();
            z |= this.A0b.isFinished();
        }
        EdgeEffect edgeEffect3 = this.A0c;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            EdgeEffect edgeEffect4 = this.A0c;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[3] = "CkvbraPTkuNHVjG6c5toq1";
            strArr[0] = "anwNoWvWLV";
            edgeEffect4.onRelease();
            z |= this.A0c.isFinished();
        }
        EdgeEffect edgeEffect5 = this.A0Z;
        if (edgeEffect5 != null && !edgeEffect5.isFinished() && i3 < 0) {
            this.A0Z.onRelease();
            z |= this.A0Z.isFinished();
        }
        if (z) {
            AnonymousClass31.A07(this);
        }
    }

    public final void A1a(int i2, int i3) {
        setMeasuredDimension(C4M.A00(i2, getPaddingLeft() + getPaddingRight(), AnonymousClass31.A03(this)), C4M.A00(i3, getPaddingTop() + getPaddingBottom(), AnonymousClass31.A02(this)));
    }

    public final void A1b(int scrollY, int i2) {
        this.A0N++;
        int scrollX = getScrollX();
        int scrollY2 = getScrollY();
        onScrollChanged(scrollX, scrollY2, scrollX, scrollY2);
        C4R c4r = this.A0i;
        if (c4r != null) {
            c4r.A0M(this, scrollY, i2);
        }
        List<C4R> list = this.A0m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.A0m.get(size).A0M(this, scrollY, i2);
            }
        }
        this.A0N--;
    }

    public final void A1c(int i2, int i3) {
        int A06 = this.A01.A06();
        for (int i4 = 0; i4 < A06; i4++) {
            AbstractC05784e A0G = A0G(this.A01.A0A(i4));
            if (A0G != null && !A0G.A0h()) {
                int i5 = A0G.A03;
                if (A19[5].charAt(2) != 'Y') {
                    throw new RuntimeException();
                }
                A19[1] = "WfIl2QLxhpsV1cZ5bwDa0wyCBTSIuEWm";
                if (i5 >= i2) {
                    A0G.A0W(i3, false);
                    this.A0s.A0D = true;
                }
            }
        }
        this.A0r.A0R(i2, i3);
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r10 == r12) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        r0 = r13 - r12;
        r9.A0W(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (r10 == r12) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
        r9.A0W(r4, false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A1d(int r12, int r13) {
        /*
            r11 = this;
            com.facebook.ads.redexgen.X.3k r0 = r11.A01
            int r7 = r0.A06()
            if (r12 >= r13) goto L7c
            r6 = r12
            r5 = r13
            r4 = -1
        Lb:
            r3 = 0
        Lc:
            if (r3 >= r7) goto L80
            com.facebook.ads.redexgen.X.3k r0 = r11.A01
            android.view.View r0 = r0.A0A(r3)
            com.facebook.ads.redexgen.X.4e r9 = A0G(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 5
            r1 = r1[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L2c
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2c:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "SA2Eyd"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "XMtlHmP9rGs3"
            r0 = 7
            r2[r0] = r1
            if (r9 == 0) goto L42
            int r0 = r9.A03
            if (r0 < r6) goto L42
            int r0 = r9.A03
            if (r0 <= r5) goto L45
        L42:
            int r3 = r3 + 1
            goto Lc
        L45:
            int r10 = r9.A03
            r8 = 0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 6
            r1 = r2[r0]
            r0 = 4
            r2 = r2[r0]
            r0 = 17
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L69
            if (r10 != r12) goto L78
        L5e:
            int r0 = r13 - r12
            r9.A0W(r0, r8)
        L63:
            com.facebook.ads.redexgen.X.4b r1 = r11.A0s
            r0 = 1
            r1.A0D = r0
            goto L42
        L69:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "BcaezuMb6aDfAWKozakh45MfYrs0kuIc"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "5erwLY6dW1OUzDMynaZgWLcHWlHtC3ze"
            r0 = 4
            r2[r0] = r1
            if (r10 != r12) goto L78
            goto L5e
        L78:
            r9.A0W(r4, r8)
            goto L63
        L7c:
            r6 = r13
            r5 = r12
            r4 = 1
            goto Lb
        L80:
            com.facebook.ads.redexgen.X.4U r0 = r11.A0r
            r0.A0S(r12, r13)
            r11.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.A1d(int, int):void");
    }

    public final void A1e(int i2, int i3) {
        A0m(i2, i3, null);
    }

    public final void A1f(int positionEnd, int i2, Object obj) {
        int A06 = this.A01.A06();
        int i3 = positionEnd + i2;
        for (int i4 = 0; i4 < A06; i4++) {
            View A0A = this.A01.A0A(i4);
            AbstractC05784e A0G = A0G(A0A);
            if (A0G != null && !A0G.A0h()) {
                int i5 = A0G.A03;
                if (A19[1].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[2] = "87XYbE";
                strArr[7] = "GV1T0vfadOcw";
                if (i5 >= positionEnd && A0G.A03 < i3) {
                    A0G.A0T(2);
                    A0G.A0Y(obj);
                    ((C4N) A0A.getLayoutParams()).A01 = true;
                }
            }
        }
        this.A0r.A0T(positionEnd, i2);
    }

    public final void A1g(int childCount, int i2, boolean z) {
        int i3 = childCount + i2;
        int A06 = this.A01.A06();
        for (int i4 = 0; i4 < A06; i4++) {
            AbstractC05784e A0G = A0G(this.A01.A0A(i4));
            if (A0G != null && !A0G.A0h()) {
                if (A0G.A03 >= i3) {
                    A0G.A0W(-i2, z);
                    this.A0s.A0D = true;
                } else if (A0G.A03 >= childCount) {
                    A0G.A0V(childCount - 1, -i2, z);
                    if (A19[1].length() != 32) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A19;
                    strArr[2] = "dcjb0S";
                    strArr[7] = "CcIDXd599Ygw";
                    this.A0s.A0D = true;
                } else {
                    continue;
                }
            }
        }
        this.A0r.A0U(childCount, i2, z);
        requestLayout();
    }

    public final void A1h(View view) {
        int i2;
        A0G(view);
        C4A c4a = this.A04;
        List<RecyclerView.OnChildAttachStateChangeListener> list = this.A0l;
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        A19[5] = "qDYnzfveQxKkK3O0opuqDthRtcgsED9a";
        if (list != null && list.size() - 1 >= 0) {
            this.A0l.get(i2);
            throw new NullPointerException(A0J(1881, 27, 18));
        }
    }

    public final void A1i(View view) {
        int i2;
        A0G(view);
        C4A c4a = this.A04;
        List<RecyclerView.OnChildAttachStateChangeListener> list = this.A0l;
        if (list != null && list.size() - 1 >= 0) {
            this.A0l.get(i2);
            throw new NullPointerException(A0J(1908, 29, 20));
        }
    }

    public final void A1j(C4R c4r) {
        if (this.A0m == null) {
            this.A0m = new ArrayList();
        }
        this.A0m.add(c4r);
    }

    public final void A1k(C4R c4r) {
        List<C4R> list = this.A0m;
        if (list != null) {
            list.remove(c4r);
        }
    }

    public final void A1l(C05754b c05754b) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.A08.A01;
            c05754b.A06 = overScroller.getFinalX() - overScroller.getCurrX();
            c05754b.A07 = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        c05754b.A06 = 0;
        c05754b.A07 = 0;
    }

    public final void A1m(AbstractC05784e abstractC05784e, C4H c4h) {
        abstractC05784e.A0U(0, 8192);
        if (this.A0s.A0E && abstractC05784e.A0f() && !abstractC05784e.A0c() && !abstractC05784e.A0h()) {
            this.A0t.A08(A0C(abstractC05784e), abstractC05784e);
        }
        this.A0t.A0F(abstractC05784e, c4h);
    }

    public final void A1n(@NonNull AbstractC05784e abstractC05784e, @Nullable C4H c4h, @NonNull C4H c4h2) {
        abstractC05784e.A0Z(false);
        if (this.A05.A0E(abstractC05784e, c4h, c4h2)) {
            A1N();
        }
    }

    public final void A1o(@NonNull AbstractC05784e abstractC05784e, @NonNull C4H c4h, @Nullable C4H c4h2) {
        A0s(abstractC05784e);
        abstractC05784e.A0Z(false);
        if (this.A05.A0F(abstractC05784e, c4h, c4h2)) {
            A1N();
        }
    }

    public final void A1p(String str) {
        if (A1u()) {
            if (str == null) {
                throw new IllegalStateException(A0J(574, 77, 49) + A1I());
            }
            throw new IllegalStateException(str);
        } else if (this.A0N > 0) {
            Log.w(A0J(1370, 12, 79), A0J(294, 280, 24), new IllegalStateException(A0J(0, 0, 62) + A1I()));
        }
    }

    public final void A1q(boolean z) {
        this.A0U--;
        if (this.A0U < 1) {
            this.A0U = 0;
            if (z) {
                A0L();
                if (A19[1].length() != 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A19;
                strArr[6] = "clcdgLago0QzUCUQna9RqUvMnx3zufId";
                strArr[4] = "dGTmnJIudyc2xKqsUaVYnInX4VXDIHXZ";
                A0a();
            }
        }
    }

    public final void A1r(boolean z) {
        if (this.A0O < 1) {
            this.A0O = 1;
        }
        if (!z) {
            this.A0J = false;
        }
        if (this.A0O == 1) {
            if (z && this.A0J && !this.A0I && this.A06 != null && this.A04 != null) {
                A0Z();
            }
            if (!this.A0I) {
                this.A0J = false;
            }
        }
        this.A0O--;
    }

    public final boolean A1s() {
        AccessibilityManager accessibilityManager = this.A10;
        if (accessibilityManager != null) {
            boolean isEnabled = accessibilityManager.isEnabled();
            String[] strArr = A19;
            if (strArr[6].charAt(17) != strArr[4].charAt(17)) {
                throw new RuntimeException();
            }
            A19[5] = "qqYNnQooq1iBe19qNxONRBmcR9jcXf5d";
            if (isEnabled) {
                return true;
            }
        }
        return false;
    }

    public final boolean A1t() {
        return !this.A0D || this.A0C || this.A00.A0J();
    }

    public final boolean A1u() {
        return this.A0U > 0;
    }

    public final boolean A1v(int i2) {
        return getScrollingChildHelper().A09(i2);
    }

    public final boolean A1w(int i2, int i3) {
        return getScrollingChildHelper().A0B(i2, i3);
    }

    public final boolean A1x(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().A0D(i2, i3, i4, i5, iArr, i6);
    }

    public final boolean A1y(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().A0F(i2, i3, iArr, iArr2, i4);
    }

    public final boolean A1z(View view) {
        A1K();
        boolean A0L = this.A01.A0L(view);
        if (A0L) {
            AbstractC05784e A0G = A0G(view);
            this.A0r.A0c(A0G);
            this.A0r.A0b(A0G);
        }
        A1r(!A0L);
        if (A19[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A19;
        strArr[3] = "2BT72D7B0XXfHPWJs3DbS8";
        strArr[0] = "RgGvPpmRJD";
        return A0L;
    }

    public final boolean A20(AbstractC05784e abstractC05784e) {
        C4I c4i = this.A05;
        return c4i == null || c4i.A0M(abstractC05784e, abstractC05784e.A0L());
    }

    @VisibleForTesting
    public final boolean A21(AbstractC05784e abstractC05784e, int i2) {
        if (A1u()) {
            abstractC05784e.A02 = i2;
            this.A0w.add(abstractC05784e);
            return false;
        }
        AnonymousClass31.A09(abstractC05784e.A0H, i2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        C4M c4m = this.A06;
        if (c4m != null) {
            boolean A1g = c4m.A1g(this, arrayList, i2, i3);
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[2] = "qzNrCd";
            strArr[7] = "bMAkXN6Kp1Dd";
            if (A1g) {
                return;
            }
        }
        super.addFocusables(arrayList, i2, i3);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C4N) && this.A06.A1c((C4N) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        C4M c4m = this.A06;
        if (c4m != null && c4m.A24()) {
            return this.A06.A1j(this.A0s);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        C4M c4m = this.A06;
        if (c4m != null && c4m.A24()) {
            return this.A06.A1k(this.A0s);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        C4M c4m = this.A06;
        if (c4m == null) {
            return 0;
        }
        boolean A24 = c4m.A24();
        if (A19[5].charAt(2) != 'Y') {
            throw new RuntimeException();
        }
        A19[1] = "GzwOa56ahdwGOmec9vc3XIggLcxaXOnz";
        if (A24) {
            return this.A06.A1l(this.A0s);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        C4M c4m = this.A06;
        if (c4m == null) {
            return 0;
        }
        boolean A25 = c4m.A25();
        String[] strArr = A19;
        if (strArr[3].length() != strArr[0].length()) {
            String[] strArr2 = A19;
            strArr2[2] = "Wsbuah";
            strArr2[7] = "lDl9g1VSjrmk";
            if (!A25) {
                return 0;
            }
            C4M c4m2 = this.A06;
            String[] strArr3 = A19;
            if (strArr3[3].length() != strArr3[0].length()) {
                A19[5] = "sfYwg45p3roym5legx720iFNlg07mmUN";
                return c4m2.A1m(this.A0s);
            }
        }
        throw new RuntimeException();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        C4M c4m = this.A06;
        if (c4m != null && c4m.A25()) {
            return this.A06.A1n(this.A0s);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        C4M c4m = this.A06;
        if (c4m != null && c4m.A25()) {
            C4M c4m2 = this.A06;
            if (A19[5].charAt(2) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[6] = "NPPquBudgt65Kfhzva46C14iIBYgw5ng";
            strArr[4] = "gzaMlk0wrsXS1BjbnaI8sjsGlzE0u55w";
            return c4m2.A1o(this.A0s);
        }
        return 0;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().A08(f2, f3, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().A07(f2, f3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().A0E(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().A0C(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0126, code lost:
        if (r3.A0L() != false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0128, code lost:
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x013a, code lost:
        if (r3.A0L() != false) goto L77;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r8) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.draw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f8  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r9, int r10) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.focusSearch(android.view.View, int):android.view.View");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        C4M c4m = this.A06;
        if (c4m != null) {
            return c4m.A1s();
        }
        throw new IllegalStateException(A0J(1475, 33, 17) + A1I());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        C4M c4m = this.A06;
        if (c4m != null) {
            return c4m.A0v(getContext(), attributeSet);
        }
        throw new IllegalStateException(A0J(1475, 33, 17) + A1I());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        C4M c4m = this.A06;
        if (c4m != null) {
            C4N A0w = c4m.A0w(layoutParams);
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[3] = "4uZ9QAUZcjEo06EXHPHPN1";
            strArr[0] = "ePNmh1lbEA";
            return A0w;
        }
        throw new IllegalStateException(A0J(1475, 33, 17) + A1I());
    }

    public C4A getAdapter() {
        return this.A04;
    }

    @Override // android.view.View
    public int getBaseline() {
        C4M c4m = this.A06;
        if (c4m != null) {
            int A0V = c4m.A0V();
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            A19[1] = "WUntfQVcja1qFzj09nDprclvV6sI7lKs";
            return A0V;
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        C4D c4d = this.A0e;
        if (c4d == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return c4d.onGetChildDrawingOrder(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.A0B;
    }

    public C1457bR getCompatAccessibilityDelegate() {
        return this.A09;
    }

    public C4I getItemAnimator() {
        return this.A05;
    }

    public C4M getLayoutManager() {
        return this.A06;
    }

    public int getMaxFlingVelocity() {
        return this.A0x;
    }

    public int getMinFlingVelocity() {
        return this.A0y;
    }

    public long getNanoTime() {
        if (A1E) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public C4P getOnFlingListener() {
        return this.A0g;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.A0o;
    }

    public C4T getRecycledViewPool() {
        return this.A0r.A0H();
    }

    public int getScrollState() {
        return this.A0W;
    }

    private C05312j getScrollingChildHelper() {
        if (this.A0d == null) {
            this.A0d = new C05312j(this);
        }
        return this.A0d;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().A05();
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.A0F;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().A06();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0U = 0;
        boolean z = true;
        this.A0F = true;
        this.A0D = (!this.A0D || isLayoutRequested()) ? false : false;
        C4M c4m = this.A06;
        if (c4m != null) {
            c4m.A1N(this);
        }
        this.A0K = false;
        if (A1E) {
            this.A03 = RunnableC05713x.A07.get();
            if (this.A03 == null) {
                this.A03 = new RunnableC05713x();
                Display A04 = AnonymousClass31.A04(this);
                float f2 = 60.0f;
                if (!isInEditMode() && A04 != null) {
                    float refreshRate = A04.getRefreshRate();
                    String[] strArr = A19;
                    if (strArr[2].length() == strArr[7].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A19;
                    strArr2[3] = "HPKMSTrO6rgllPECADdom7";
                    strArr2[0] = "yPSN9KqlOS";
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                this.A03.A00 = 1.0E9f / f2;
                RunnableC05713x.A07.set(this.A03);
            }
            this.A03.A09(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        RunnableC05713x runnableC05713x;
        super.onDetachedFromWindow();
        C4I c4i = this.A05;
        if (c4i != null) {
            c4i.A0I();
        }
        A1R();
        this.A0F = false;
        C4M c4m = this.A06;
        if (c4m != null) {
            c4m.A1U(this, this.A0r);
        }
        this.A0w.clear();
        removeCallbacks(this.A0k);
        this.A0t.A07();
        if (A1E && (runnableC05713x = this.A03) != null) {
            runnableC05713x.A0A(this);
            this.A03 = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.A0v.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.A0v.get(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
        if ((r4 & 4194304) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
        r1 = r7.getAxisValue(26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0093, code lost:
        if (r6.A06.A25() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
        r0 = -r1;
        r1 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a0, code lost:
        if ((r4 & 4194304) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a9, code lost:
        if (r6.A06.A24() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ab, code lost:
        r0 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ad, code lost:
        r0 = 0.0f;
        r1 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b0, code lost:
        r0 = 0.0f;
        r1 = 0.0f;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.facebook.ads.redexgen.X.4M r0 = r6.A06
            r5 = 0
            if (r0 != 0) goto L6
            return r5
        L6:
            boolean r3 = r6.A0I
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 32
            if (r1 == r0) goto L1b
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1b:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "hfCCVZ"
            r0 = 2
            r2[r0] = r1
            java.lang.String r1 = "6Rxn0wTGDCgs"
            r0 = 7
            r2[r0] = r1
            if (r3 == 0) goto L2a
            return r5
        L2a:
            int r1 = r7.getAction()
            r0 = 8
            if (r1 != r0) goto L6b
            int r0 = r7.getSource()
            r0 = r0 & 2
            if (r0 == 0) goto L70
            com.facebook.ads.redexgen.X.4M r0 = r6.A06
            boolean r0 = r0.A25()
            if (r0 == 0) goto L6e
            r0 = 9
            float r0 = r7.getAxisValue(r0)
            float r0 = -r0
        L49:
            com.facebook.ads.redexgen.X.4M r1 = r6.A06
            boolean r1 = r1.A24()
            if (r1 == 0) goto L6c
            r1 = 10
            float r1 = r7.getAxisValue(r1)
        L57:
            r3 = 0
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 != 0) goto L60
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 == 0) goto L6b
        L60:
            float r2 = r6.A0L
            float r2 = r2 * r1
            int r2 = (int) r2
            float r1 = r6.A0M
            float r1 = r1 * r0
            int r0 = (int) r1
            r6.A14(r2, r0, r7)
        L6b:
            return r5
        L6c:
            r1 = 0
            goto L57
        L6e:
            r0 = 0
            goto L49
        L70:
            int r4 = r7.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0828Eq.A19
            r0 = 5
            r1 = r1[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            r0 = 89
            if (r1 == r0) goto L98
            r4 = r4 & r3
            if (r4 == 0) goto Lb0
        L87:
            r0 = 26
            float r1 = r7.getAxisValue(r0)
            com.facebook.ads.redexgen.X.4M r0 = r6.A06
            boolean r0 = r0.A25()
            if (r0 == 0) goto La3
            float r0 = -r1
            r1 = 0
            goto L57
        L98:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0828Eq.A19
            java.lang.String r1 = "SrYzqcFycO4E61WX0CCI79FBiQDWLxq8"
            r0 = 5
            r2[r0] = r1
            r4 = r4 & r3
            if (r4 == 0) goto Lb0
            goto L87
        La3:
            com.facebook.ads.redexgen.X.4M r0 = r6.A06
            boolean r0 = r0.A24()
            if (r0 == 0) goto Lad
            r0 = 0
            goto L57
        Lad:
            r0 = 0
            r1 = 0
            goto L57
        Lb0:
            r0 = 0
            r1 = 0
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.A0I) {
            return false;
        }
        if (A16(motionEvent)) {
            A0K();
            return true;
        }
        C4M c4m = this.A06;
        if (c4m == null) {
            return false;
        }
        boolean A24 = c4m.A24();
        boolean A25 = this.A06.A25();
        if (this.A0Y == null) {
            this.A0Y = VelocityTracker.obtain();
        }
        this.A0Y.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        String[] strArr = A19;
        String str = strArr[2];
        String str2 = strArr[7];
        int length = str.length();
        int action = str2.length();
        if (length != action) {
            String[] strArr2 = A19;
            strArr2[3] = "Oz3Y31ex0QABqFtFM6aXix";
            strArr2[0] = "OpGO9pAa6R";
            if (actionMasked == 0) {
                boolean startScroll = this.A0n;
                if (startScroll) {
                    this.A0n = false;
                }
                this.A0V = motionEvent.getPointerId(0);
                int x = (int) (motionEvent.getX() + 0.5f);
                this.A0S = x;
                this.A0Q = x;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.A0T = y;
                this.A0R = y;
                if (this.A0W == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                }
                int[] iArr = this.A15;
                iArr[1] = 0;
                iArr[0] = 0;
                int nestedScrollAxis = 0;
                if (A24) {
                    nestedScrollAxis = 0 | 1;
                }
                if (A25) {
                    nestedScrollAxis |= 2;
                }
                A1w(nestedScrollAxis, 0);
            } else if (actionMasked == 1) {
                this.A0Y.clear();
                A1X(0);
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.A0V);
                if (findPointerIndex < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(A0J(1063, 46, 50));
                    int index = this.A0V;
                    sb.append(index);
                    sb.append(A0J(124, 45, 46));
                    Log.e(A0J(1370, 12, 79), sb.toString());
                    return false;
                }
                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                int x3 = this.A0W;
                if (x3 != 1) {
                    int x4 = this.A0Q;
                    int i2 = x2 - x4;
                    int x5 = this.A0R;
                    int i3 = y2 - x5;
                    boolean z = false;
                    if (A24 && Math.abs(i2) > this.A0X) {
                        this.A0S = x2;
                        z = true;
                    }
                    if (A25 && Math.abs(i3) > this.A0X) {
                        this.A0T = y2;
                        z = true;
                    }
                    if (z) {
                        setScrollState(1);
                    }
                }
            } else if (actionMasked == 3) {
                A0K();
            } else if (actionMasked == 5) {
                this.A0V = motionEvent.getPointerId(actionIndex);
                int x6 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.A0S = x6;
                this.A0Q = x6;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.A0T = y3;
                this.A0R = y3;
            } else if (actionMasked == 6) {
                A0o(motionEvent);
            }
            int action2 = this.A0W;
            return action2 == 1;
        }
        throw new RuntimeException();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        C2O.A01(A0J(1330, 11, 86));
        A0Z();
        C2O.A00();
        this.A0D = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
        if (r3 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c7, code lost:
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d2, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00df, code lost:
        if (r3 != false) goto L49;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (A1u()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WrappedParcelable)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            classLoader = getContext().getClassLoader();
        }
        Parcelable unwrap = ((WrappedParcelable) parcelable).unwrap(classLoader);
        if (!(unwrap instanceof RecyclerView$SavedState)) {
            super.onRestoreInstanceState(unwrap);
            return;
        }
        this.A0j = (RecyclerView$SavedState) unwrap;
        super.onRestoreInstanceState(this.A0j.A02());
        if (this.A06 != null && this.A0j.A00 != null) {
            this.A06.A1w(this.A0j.A00);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        RecyclerView$SavedState recyclerView$SavedState = new RecyclerView$SavedState(super.onSaveInstanceState());
        RecyclerView$SavedState recyclerView$SavedState2 = this.A0j;
        if (recyclerView$SavedState2 != null) {
            recyclerView$SavedState.A03(recyclerView$SavedState2);
        } else {
            C4M c4m = this.A06;
            if (c4m != null) {
                recyclerView$SavedState.A00 = c4m.A1p();
            } else {
                recyclerView$SavedState.A00 = null;
            }
        }
        return new WrappedParcelable(recyclerView$SavedState);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            A0g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x020f, code lost:
        if (A13((int) r7, (int) r2) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0211, code lost:
        setScrollState(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0214, code lost:
        A0U();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0207, code lost:
        if (r2 != 0.0f) goto L101;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r21) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0828Eq.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        AbstractC05784e A0G = A0G(view);
        if (A0G != null) {
            if (A0G.A0e()) {
                A0G.A0P();
            } else if (!A0G.A0h()) {
                throw new IllegalArgumentException(A0J(219, 75, 37) + A0G + A1I());
            }
        }
        view.clearAnimation();
        A1i(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (!this.A06.A1f(this, this.A0s, view, view2) && view2 != null) {
            A0q(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.A06.A1d(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.A13.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.A13.get(i2);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.A0O == 0 && !this.A0I) {
            super.requestLayout();
        } else {
            this.A0J = true;
        }
    }

    @Override // android.view.View
    public final void scrollBy(int i2, int i3) {
        C4M c4m = this.A06;
        if (c4m == null) {
            Log.e(A0J(1370, 12, 79), A0J(834, 90, 71));
        } else if (this.A0I) {
        } else {
            boolean A24 = c4m.A24();
            boolean A25 = this.A06.A25();
            if (A24 || A25) {
                if (!A24) {
                    i2 = 0;
                }
                A14(i2, A25 ? i3 : 0, null);
            }
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i3) {
        Log.w(A0J(1370, 12, 79), A0J(1382, 93, 90));
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (A19(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(C1457bR c1457bR) {
        this.A09 = c1457bR;
        AnonymousClass31.A0B(this, this.A09);
    }

    public void setAdapter(C4A c4a) {
        setLayoutFrozen(false);
        A0r(c4a, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C4D c4d) {
        if (c4d == this.A0e) {
            return;
        }
        this.A0e = c4d;
        setChildrenDrawingOrderEnabled(this.A0e != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.A0B) {
            A0g();
        }
        this.A0B = z;
        super.setClipToPadding(z);
        if (this.A0D) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.A0E = z;
    }

    public void setItemAnimator(C4I c4i) {
        C4I c4i2 = this.A05;
        if (c4i2 != null) {
            c4i2.A0I();
            this.A05.A0B(null);
        }
        this.A05 = c4i;
        C4I c4i3 = this.A05;
        if (c4i3 != null) {
            C4G c4g = this.A0f;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[3] = "lbql160khUomfa8gG92Y7q";
            strArr[0] = "AtGY6u7EZb";
            c4i3.A0B(c4g);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.A0r.A0Q(i2);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.A0I) {
            A1p(A0J(PointerIconCompat.TYPE_GRABBING, 42, 85));
            if (!z) {
                this.A0I = false;
                if (this.A0J && this.A06 != null && this.A04 != null) {
                    requestLayout();
                }
                this.A0J = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent cancelEvent = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            onTouchEvent(cancelEvent);
            this.A0I = true;
            this.A0n = true;
            A1R();
        }
    }

    public void setLayoutManager(C4M c4m) {
        if (c4m == this.A06) {
            return;
        }
        A1R();
        if (this.A06 != null) {
            C4I c4i = this.A05;
            if (c4i != null) {
                c4i.A0I();
            }
            this.A06.A1I(this.A0r);
            this.A06.A1G(this.A0r);
            this.A0r.A0P();
            if (this.A0F) {
                this.A06.A1U(this, this.A0r);
            }
            this.A06.A1P(null);
            this.A06 = null;
        } else {
            this.A0r.A0P();
        }
        this.A01.A0B();
        this.A06 = c4m;
        if (c4m != null) {
            C0828Eq c0828Eq = c4m.A03;
            if (A19[1].length() != 32) {
                throw new RuntimeException();
            }
            String[] strArr = A19;
            strArr[6] = "5zwSvF43vthb6lIFeaOoDRJ244Dq07FI";
            strArr[4] = "COyIsU8he0MLuT7wFa9x9SZ5A7LzgdfA";
            if (c0828Eq == null) {
                this.A06.A1P(this);
                if (this.A0F) {
                    this.A06.A1N(this);
                }
            } else {
                throw new IllegalArgumentException(A0J(1109, 14, 88) + c4m + A0J(59, 39, 9) + c4m.A03.A1I());
            }
        }
        this.A0r.A0O();
        requestLayout();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().A04(z);
    }

    public void setOnFlingListener(@Nullable C4P c4p) {
        this.A0g = c4p;
    }

    @Deprecated
    public void setOnScrollListener(C4R c4r) {
        this.A0i = c4r;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.A0o = z;
    }

    public void setRecycledViewPool(C4T c4t) {
        this.A0r.A0Z(c4t);
    }

    public void setRecyclerListener(C4V c4v) {
        this.A07 = c4v;
    }

    public void setScrollState(int i2) {
        if (i2 == this.A0W) {
            return;
        }
        this.A0W = i2;
        if (i2 != 2) {
            A0W();
        }
        A0l(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w(A0J(1370, 12, 79), A0J(1937, 47, 26) + i2 + A0J(198, 21, 121));
            } else {
                this.A0X = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.A0X = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AbstractC05764c abstractC05764c) {
        this.A0r.A0a(abstractC05764c);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().A0A(i2);
    }

    @Override // android.view.View, com.facebook.ads.redexgen.X.InterfaceC05302i
    public final void stopNestedScroll() {
        getScrollingChildHelper().A02();
    }
}
