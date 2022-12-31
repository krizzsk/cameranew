package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;
/* renamed from: com.facebook.ads.redexgen.X.Tj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1198Tj implements com.facebook.ads.Ad, NativeAdBaseApi, Repairable, InterfaceC0961Jz {
    public static C7J A0j;
    public static byte[] A0k;
    public static String[] A0l = {"Bl7Z7O36thNMsAQG86cT5hXAswukL2TU", "w0l3kgVUfrf8f1EzcfbBJ9JqF1JIQyF1", "3FYeVZ4P9Hva0brxRfDXnSutu97odoaf", "TkemScCQ72wM3yeu7V5OcaIZTlgQuG0T", "aV5nfdXEnoj7uvLi", "brDFWAS69jf159nGVdOYVvf", "WGIwYSb5Wjcv", "W7skGFSknqdZoaqu210O1mF"};
    public static final String A0m;
    public static final WeakHashMap<View, WeakReference<C1198Tj>> A0n;
    public long A00;
    @Nullable
    public Drawable A01;
    public View.OnTouchListener A02;
    @Nullable
    public View A03;
    @Nullable
    public View A04;
    public View A05;
    @Nullable
    public View A06;
    @Nullable
    public NativeAdLayout A07;
    public EnumC04960z A08;
    @Nullable
    public C1534cp A09;
    public F6 A0A;
    @Nullable
    public C1505cM A0B;
    @Nullable
    public C7O A0C;
    public XT A0D;
    @Nullable
    public AnonymousClass95 A0E;
    public EnumC0947Jl A0F;
    public View$OnClickListenerC1200Tl A0G;
    @Nullable
    public InterfaceC1197Ti A0H;
    public C0955Jt A0I;
    public EnumC0956Ju A0J;
    public K9 A0K;
    public C1030Mv A0L;
    @Nullable
    public C1053Ns A0M;
    @Nullable
    public PM A0N;
    @Nullable
    @DoNotStrip
    public QY A0O;
    @Nullable
    @DoNotStrip
    public QY A0P;
    @Nullable
    public QZ A0Q;
    public QZ A0R;
    public String A0S;
    @Nullable
    public String A0T;
    public WeakReference<C1452bM> A0U;
    public WeakReference<QY> A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    @Nullable
    public C1543cy A0a;
    public final C7J A0b;
    public final InterfaceC0952Jq A0c;
    public final K1 A0d;
    public final C1009Lz A0e;
    public final String A0f;
    public final String A0g;
    public final List<View> A0h;
    public volatile boolean A0i;

    public static String A0T(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0k, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 40);
        }
        return new String(copyOfRange);
    }

    public static void A0a() {
        A0k = new byte[]{92, 97, 97, 93, 91, 91, 96, 89, -87, -87, -85, -86, -86, -87, -42, -90, -72, -75, -79, -26, -27, -77, -77, -79, -25, 10, -58, 20, 21, 26, -58, 18, 21, 7, 10, 11, 10, 125, -96, -112, -95, -87, -84, -88, -99, -80, -95, 92, 99, 97, -81, 99, 92, -91, -81, 92, -86, -85, -80, 92, -99, 92, -86, -99, -80, -91, -78, -95, 92, -99, -96, -62, -66, -67, -15, -32, -27, -31, -22, -33, -31, -54, -31, -16, -13, -21, -18, -25, -105, -78, -70, -67, -74, -75, 113, -59, -64, 113, -67, -64, -78, -75, 113, -98, -74, -75, -70, -78, Byte.MAX_VALUE, -83, -56, -48, -45, -52, -53, -121, -37, -42, -121, -42, -55, -37, -56, -48, -43, -121, -37, -52, -44, -41, -45, -56, -37, -52, -121, -80, -85, -121, -51, -39, -42, -44, -121, -55, -48, -53, -121, -41, -56, -32, -45, -42, -56, -53, -121, -114, -116, -38, -114, -93, -56, -50, -65, -52, -56, -69, -58, 122, -65, -52, -52, -55, -52, -120, 100, -79, -42, -34, -55, -44, -47, -52, -120, -37, -51, -36, -120, -41, -50, -120, -53, -44, -47, -53, -45, -55, -54, -44, -51, -120, -34, -47, -51, -33, -37, -43, -19, -20, -15, -23, -34, -15, -19, -1, -88, -18, -9, -6, -88, -15, -21, -9, -10, -88, -15, -5, -88, -15, -5, -88, -11, -15, -5, -5, -15, -10, -17, -74, -73, -49, -50, -45, -53, -64, -45, -49, -31, -118, -45, -35, -118, -41, -45, -35, -35, -45, -40, -47, -104, -71, -31, -33, -32, -116, -36, -34, -37, -30, -43, -48, -47, -116, -51, -116, -62, -43, -47, -29, -116, -97, -78, -89, -76, -93, 94, Byte.MAX_VALUE, -94, 94, -75, -97, -79, 94, -97, -86, -80, -93, -97, -94, -73, 94, -80, -93, -91, -89, -79, -78, -93, -80, -93, -94, 94, -75, -89, -78, -90, 94, -97, 94, -108, -89, -93, -75, 108, 94, Byte.MAX_VALUE, -77, -78, -83, 94, -77, -84, -80, -93, -91, -89, -79, -78, -93, -80, -89, -84, -91, 94, -97, -84, -94, 94, -82, -80, -83, -95, -93, -93, -94, -89, -84, -91, 108, -49, -30, -11, -22, -9, -26, -95, -30, -27, -95, -27, -26, -12, -11, -13, -16, -6, -26, -27, -115, -96, -77, -88, -75, -92, 95, -96, -93, 95, -85, -82, -96, -93, 95, -79, -92, -80, -76, -92, -78, -77, -92, -93, -32, -13, -17, 1, -86, -21, -10, -4, -17, -21, -18, 3, -86, -4, -17, -15, -13, -3, -2, -17, -4, -17, -18, -86, 1, -13, -2, -14, -86, -21, -86, -40, -21, -2, -13, 0, -17, -53, -18, -72, -86, -53, -1, -2, -7, -86, -1, -8, -4, -17, -15, -13, -3, -2, -17, -4, -13, -8, -15, -86, -21, -8, -18, -86, -6, -4, -7, -19, -17, -17, -18, -13, -8, -15, -72, -115, -96, -100, -82, 87, -91, -90, -85, 87, -87, -100, -98, -96, -86, -85, -100, -87, -100, -101, 87, -82, -96, -85, -97, 87, -85, -97, -96, -86, 87, -123, -104, -85, -96, -83, -100, 120, -101, -47, -44, -112, -35, -43, -44, -39, -47, -112, -28, -23, -32, -43, -112, -39, -29, -112, -34, -33, -28, -112, -29, -27, -32, -32, -33, -30, -28, -43, -44, -98, -104, -101, -106, -85, -87, -104, -91, -86, -93, -104, -85, -96, -90, -91, -116, -113, -95, -112, -99, -97, -108, -98, -112, -99, -118, -103, -116, -104, -112, -112, -97, -104, -104, -91, -102, -81, -2, -4, 7, 7, -6, 15, 10, -6, -4, -2, 15, 4, 10, 9, -27, -26, -12, -11, -13, -16, -6, -63, -66, -70, -67, -59, -62, -57, -66, -63, -66, -61, -64, -76, -71, -70, -56, -72, -57, -66, -59, -55, -66, -60, -61, 4, 7, -7, -4, -39, -4, -86, -83, -97, -94, Byte.MAX_VALUE, -94, 102, 103, 94, -95, -97, -86, -86, -93, -94, 94, -85, -83, -80, -93, 94, -78, -90, -97, -84, 94, -83, -84, -95, -93, -52, -65, -46, -57, -44, -61, -71, -86, -66, -68, -82, -88, -67, -69, -86, -73, -68, -75, -86, -67, -78, -72, -73, -87, -91, -102, -78, -104, -83, -85, -102, -89, -84, -91, -102, -83, -94, -88, -89, -90, -88, -91, -93, -91, -86, -101, -102, -107, -86, -88, -105, -92, -87, -94, -105, -86, -97, -91, -92, -23, -27, -39, -33, -41, -30, -43, -39, -27, -28, -22, -37, -18, -22, -41, -44, -45, -46, -41, -45, -42, -55, -56, -61, -40, -42, -59, -46, -41, -48, -59, -40, -51, -45, -46};
    }

    static {
        A0a();
        A0m = C1198Tj.class.getSimpleName();
        A0n = new WeakHashMap<>();
    }

    public C1198Tj(Context context, String str, InterfaceC0952Jq interfaceC0952Jq, boolean z) {
        this.A0g = UUID.randomUUID().toString();
        this.A0K = K9.A05;
        this.A0U = new WeakReference<>(null);
        this.A0h = new ArrayList();
        this.A0e = new C1009Lz();
        this.A0Z = false;
        this.A0Y = false;
        this.A0F = EnumC0947Jl.A04;
        this.A08 = EnumC04960z.A03;
        this.A00 = -1L;
        if (!z) {
            this.A0D = AnonymousClass59.A04(context);
        } else {
            this.A0D = AnonymousClass59.A02(context);
        }
        this.A0D.A0G(this);
        this.A0f = str;
        this.A0c = interfaceC0952Jq;
        C7J c7j = A0j;
        if (c7j != null) {
            this.A0b = c7j;
        } else {
            this.A0b = new C7J(this.A0D);
        }
        this.A05 = new View(context);
        this.A0d = new K1(this.A0D, this);
    }

    public C1198Tj(C1198Tj c1198Tj) {
        this((Context) c1198Tj.A0D, (String) null, c1198Tj.A0c, true);
        this.A0E = c1198Tj.A0E;
        this.A0a = c1198Tj.A0a;
        this.A0B = c1198Tj.A0B;
        this.A0i = true;
        this.A05 = new View(this.A0D);
    }

    public C1198Tj(XT xt, C1543cy c1543cy, @Nullable AnonymousClass95 anonymousClass95, InterfaceC0952Jq interfaceC0952Jq) {
        this((Context) xt, (String) null, interfaceC0952Jq, true);
        this.A0a = c1543cy;
        this.A0E = anonymousClass95;
        this.A0i = true;
        this.A05 = new View(xt);
    }

    public C1198Tj(XT xt, C1543cy c1543cy, @Nullable AnonymousClass95 anonymousClass95, InterfaceC0952Jq interfaceC0952Jq, @Nullable C1505cM c1505cM) {
        this(xt, c1543cy, anonymousClass95, interfaceC0952Jq);
        this.A0B = c1505cM;
    }

    private int A00() {
        AnonymousClass95 anonymousClass95 = this.A0E;
        if (anonymousClass95 != null) {
            return anonymousClass95.A04();
        }
        F6 f6 = this.A0A;
        if (f6 == null || f6.A0D() == null) {
            return 1;
        }
        return this.A0A.A0D().A04();
    }

    private int A01() {
        AnonymousClass95 anonymousClass95 = this.A0E;
        if (anonymousClass95 != null) {
            return anonymousClass95.A07();
        }
        C1543cy c1543cy = this.A0a;
        if (c1543cy != null) {
            int A0G = c1543cy.A0G();
            String[] strArr = A0l;
            if (strArr[1].charAt(16) != strArr[3].charAt(16)) {
                String[] strArr2 = A0l;
                strArr2[7] = "EUscbuPuA5cZxxPx7y6ncGc";
                strArr2[5] = "07NrZ6juCFttxvE5hiFlF8c";
                return A0G;
            }
            throw new RuntimeException();
        }
        F6 f6 = this.A0A;
        if (f6 != null && f6.A0D() != null) {
            return this.A0A.A0D().A07();
        }
        return 0;
    }

    private int A02() {
        AnonymousClass95 anonymousClass95 = this.A0E;
        if (anonymousClass95 != null) {
            return anonymousClass95.A08();
        }
        C1543cy c1543cy = this.A0a;
        if (c1543cy != null) {
            int A0H = c1543cy.A0H();
            String[] strArr = A0l;
            if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
                String[] strArr2 = A0l;
                strArr2[1] = "wlXrbCoONy6aNPfJSLZ4JGG9g8lWOQWJ";
                strArr2[3] = "zMDzXw8vWIk5v34E7N5RdIcOKoPIh5je";
                return A0H;
            }
            throw new RuntimeException();
        }
        F6 f6 = this.A0A;
        String[] strArr3 = A0l;
        if (strArr3[4].length() != strArr3[6].length()) {
            String[] strArr4 = A0l;
            strArr4[7] = "IJhE7OuQr9AUmHg0gZAU0NE";
            strArr4[5] = "Tpbr9nnLmrgR8Cas3OKWnYo";
            if (f6 == null) {
                return 1000;
            }
        } else {
            String[] strArr5 = A0l;
            strArr5[0] = "x7i9CQzVOJPdqJX1dHOWNRL80PPtBuUS";
            strArr5[2] = "xh5QtfSCbDAINUU48h4MV8p0ljd4aaCa";
            if (f6 == null) {
                return 1000;
            }
        }
        if (f6.A0D() != null) {
            return this.A0A.A0D().A08();
        }
        return 1000;
    }

    private int A03() {
        AnonymousClass95 anonymousClass95 = this.A0E;
        if (anonymousClass95 != null) {
            return anonymousClass95.A09();
        }
        F6 f6 = this.A0A;
        if (f6 == null || f6.A0D() == null) {
            return 0;
        }
        return this.A0A.A0D().A09();
    }

    public static Drawable A05(XT xt, Bitmap bitmap, boolean z, @Nullable String str) {
        BitmapDrawable A00;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(xt.getResources(), bitmap);
        return (!z || (A00 = PL.A00(xt, str)) == null) ? bitmapDrawable : new LayerDrawable(new Drawable[]{bitmapDrawable, A00});
    }

    public static NativeAdBase A0A(Context context, String str, String str2) throws K4 {
        K9 A00 = KE.A00(str2);
        if (A00 != null) {
            K9 k9 = K9.A04;
            String[] strArr = A0l;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[0] = "9sjWaS9CbZxjWOFrlYfgckD2h0ahWze6";
            strArr2[2] = "CgLfFBC4KJYZcdRIWMiGUMQeYT9XpqO1";
            if (A00 == k9) {
                return new NativeBannerAd(context, str);
            }
            if (A00 == K9.A05) {
                return new NativeAd(context, str);
            }
            throw new K4(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0T(37, 34, 20), A00));
        }
        throw new K4(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0T(109, 50, 63), str2));
    }

    @Nullable
    private final C1543cy A0C() {
        C1543cy c1543cy = this.A0a;
        if (c1543cy != null && c1543cy.A0h()) {
            return c1543cy;
        }
        return null;
    }

    public static InterfaceC0952Jq A0I() {
        return new C1201Tm();
    }

    public static C1198Tj A0J(NativeAdBaseApi nativeAdBaseApi) {
        if (nativeAdBaseApi instanceof Proxy) {
            return (C1198Tj) ((C05934t) Proxy.getInvocationHandler(nativeAdBaseApi)).A04();
        }
        return (C1198Tj) nativeAdBaseApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    /* renamed from: A0K */
    public final C0953Jr getAdChoicesIcon() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A0J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    /* renamed from: A0M */
    public final C0954Js getAdStarRating() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A0M();
    }

    private AdPlacementType A0P() {
        if (this.A0K == K9.A05) {
            return AdPlacementType.NATIVE;
        }
        return AdPlacementType.NATIVE_BANNER;
    }

    private void A0W() {
        for (View view : this.A0h) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
            view.setOnLongClickListener(null);
        }
        this.A0h.clear();
    }

    private void A0X() {
        if (!TextUtils.isEmpty(getAdChoicesLinkUrl())) {
            LI.A08(new LI(), this.A0D, Uri.parse(getAdChoicesLinkUrl()), A19());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0Y() {
        this.A0e.A05();
        this.A0d.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0Z() {
        QZ qz = this.A0Q;
        if (qz != null) {
            qz.A0V();
            this.A0D.A0D().A9U();
            this.A0Q = null;
        }
    }

    public static void A0b(@Nullable Drawable drawable, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(null);
        } else {
            imageView.setBackgroundDrawable(null);
        }
    }

    private void A0c(View view, View view2, List<View> list, boolean z) {
        InterfaceC1197Ti interfaceC1197Ti;
        if (!A0p()) {
            this.A0D.A0D().ADR();
        }
        if (view == null) {
            String A0T = A0T(259, 19, 68);
            if (!A0p()) {
                this.A0D.A0D().ADQ(A0T);
            }
            throw new IllegalArgumentException(A0T);
        } else if (list == null || list.size() == 0) {
            String A0T2 = A0T(175, 30, 64);
            if (!A0p()) {
                this.A0D.A0D().ADQ(A0T2);
            }
            throw new IllegalArgumentException(A0T2);
        } else {
            C1543cy A0C = A0C();
            if (A0C == null) {
                String A0T3 = A0T(24, 13, 126);
                if (!A0p()) {
                    this.A0D.A0D().ADQ(A0T3);
                }
                Log.e(A0m, A0T3);
                K3 k3 = new K3(AdErrorType.NATIVE_AD_IS_NOT_LOADED, A0T3);
                A10().A0D().A2a(C1008Ly.A01(this.A00), k3.A03().getErrorCode(), k3.A04());
                if (JD.A1m(this.A0D) && (interfaceC1197Ti = this.A0H) != null) {
                    interfaceC1197Ti.AAW(k3);
                    return;
                }
                return;
            }
            String str = this.A0T;
            boolean z2 = view instanceof FrameLayout;
            String[] strArr = A0l;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[0] = "EctJGKY0XxsuqG0UQd3u1zsk6i1LiKEB";
            strArr2[2] = "xfmrtxxFdZMJNwdY4ICwqytBKlocc6OO";
            if (z2 && str != null) {
                A0d((FrameLayout) view, str);
            }
            NativeAdLayout nativeAdLayout = this.A07;
            if (nativeAdLayout != null) {
                ((C1437b7) nativeAdLayout.getNativeAdLayoutApi()).A02();
            }
            C1452bM c1452bM = this.A0U.get();
            if (c1452bM != null && A0C.A0A() == 1) {
                c1452bM.A03(MD.AN_INFO_ICON);
            }
            if (view2 == null) {
                if (this.A0K == K9.A05) {
                    AdErrorType adErrorType = AdErrorType.NO_MEDIAVIEW_IN_NATIVEAD;
                    String A0T4 = A0T(238, 21, 66);
                    K3 k32 = new K3(adErrorType, A0T4);
                    A10().A0D().A2a(C1008Ly.A01(this.A00), k32.A03().getErrorCode(), k32.A04());
                    InterfaceC1197Ti interfaceC1197Ti2 = this.A0H;
                    if (interfaceC1197Ti2 != null) {
                        interfaceC1197Ti2.AAW(k32);
                    }
                    if (AdInternalSettings.isDebugBuild()) {
                        Log.e(A0m, A0T4);
                        return;
                    }
                    return;
                }
                AdErrorType adErrorType2 = AdErrorType.NO_MEDIAVIEW_IN_NATIVEBANNERAD;
                String A0T5 = A0T(205, 33, 96);
                K3 k33 = new K3(adErrorType2, A0T5);
                A10().A0D().A2a(C1008Ly.A01(this.A00), k33.A03().getErrorCode(), k33.A04());
                InterfaceC1197Ti interfaceC1197Ti3 = this.A0H;
                if (interfaceC1197Ti3 != null) {
                    interfaceC1197Ti3.AAW(k33);
                }
                if (!AdInternalSettings.isDebugBuild()) {
                    return;
                }
                Log.e(A0m, A0T5);
                return;
            }
            boolean z3 = (view2 instanceof AdNativeComponentView) && ((AdNativeComponentView) view2).getAdContentsView() != null;
            boolean z4 = z && (view2 instanceof ImageView);
            if (!z3 && !z4) {
                if (this.A0H != null) {
                    K3 k34 = new K3(AdErrorType.UNSUPPORTED_AD_ASSET_NATIVEAD, A0T(514, 31, 72));
                    A10().A0D().A2a(C1008Ly.A01(this.A00), k34.A03().getErrorCode(), k34.A04());
                    this.A0H.AAW(k34);
                    return;
                }
                return;
            }
            if (this.A04 != null) {
                Log.w(A0m, A0T(278, 80, 22));
                String[] strArr3 = A0l;
                if (strArr3[7].length() != strArr3[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0l;
                strArr4[7] = "Yitqb4l5O5wHhToyiUZG328";
                strArr4[5] = "n4uNZUYEyoiQJdMJgH58rRy";
                unregisterView();
            }
            boolean nativeAdBannerViewIsImageView = A0n.containsKey(view);
            if (nativeAdBannerViewIsImageView && A0n.get(view).get() != null) {
                Log.w(A0m, A0T(401, 75, 98));
                A0n.get(view).get().unregisterView();
            }
            this.A0G = new View$OnClickListenerC1200Tl(this, this.A0D, null);
            this.A04 = view;
            this.A06 = view2;
            boolean nativeAdBannerViewIsImageView2 = view instanceof ViewGroup;
            if (nativeAdBannerViewIsImageView2) {
                this.A0L = new C1030Mv(this.A0D, new C1204Tp(this));
                ((ViewGroup) view).addView(this.A0L);
            }
            boolean nativeAdBannerViewIsImageView3 = A0C.A0i();
            if (nativeAdBannerViewIsImageView3) {
                this.A0O = new C1203To(this);
                this.A0Q = new QZ(view, 1, new WeakReference(this.A0O), this.A0D);
                this.A0Q.A0Y(false);
                this.A0Q.A0X(A0C.A0D());
                this.A0Q.A0U();
                this.A0D.A0D().A9T();
            }
            ArrayList<View> arrayList = new ArrayList(list);
            View view3 = this.A05;
            if (view3 != null) {
                arrayList.add(view3);
            }
            for (View view4 : arrayList) {
                A1J(view4);
            }
            int A00 = A00();
            this.A0P = new C1202Tn(this, view2, z4, A0C);
            if (view2 instanceof AdNativeComponentView) {
                this.A03 = ((AdNativeComponentView) view2).getAdContentsView();
            } else {
                this.A03 = view2;
            }
            if (JD.A1D(this.A0D)) {
                String clientToken = A19();
                InterfaceC0941Jf A09 = A10().A09();
                View view5 = this.A03;
                if (clientToken == null) {
                    clientToken = A0T(0, 0, 21);
                }
                A09.AFD(view5, clientToken, this.A03 instanceof C1092Ph, true);
            }
            this.A0R = new QZ(this.A03, A00, A03(), true, new WeakReference(this.A0P), this.A0D);
            this.A0R.A0Y(!A0p());
            QZ qz = this.A0R;
            int viewabilityThreshold = A01();
            qz.A0W(viewabilityThreshold);
            QZ qz2 = this.A0R;
            int viewabilityThreshold2 = A02();
            qz2.A0X(viewabilityThreshold2);
            View view6 = this.A03;
            if (view6 instanceof C1043Ni) {
                ((C1043Ni) view6).A06(this.A0R);
            }
            this.A09 = new C1534cp(this.A0D, new C1199Tk(this, null), this.A0R, this.A0a);
            this.A09.A0D(arrayList);
            A0n.put(view, new WeakReference<>(this));
            if (Build.VERSION.SDK_INT >= 18 && JD.A0u(this.A0D)) {
                this.A0M = new C1053Ns();
                this.A0M.A0C(this.A0f);
                this.A0M.A0B(this.A0D.getPackageName());
                this.A0M.A0A(this.A0R);
                int viewabilityThreshold3 = this.A0a.A0B();
                if (viewabilityThreshold3 > 0) {
                    C1053Ns c1053Ns = this.A0M;
                    int A0B = this.A0a.A0B();
                    int viewabilityThreshold4 = this.A0a.A0C();
                    c1053Ns.A08(A0B, viewabilityThreshold4);
                }
                AnonymousClass95 anonymousClass95 = this.A0E;
                if (anonymousClass95 != null) {
                    this.A0M.A09(anonymousClass95.A0C());
                } else {
                    F6 f6 = this.A0A;
                    if (f6 != null && f6.A0D() != null) {
                        this.A0M.A09(this.A0A.A0D().A0C());
                    }
                }
                this.A04.getOverlay().add(this.A0M);
            }
        }
    }

    private void A0d(FrameLayout frameLayout, String str) {
        PM pm = this.A0N;
        if (pm != null) {
            frameLayout.removeView(pm);
        }
        this.A0N = PL.A01(AnonymousClass59.A02(this.A0D), str);
        PM pm2 = this.A0N;
        if (pm2 != null) {
            frameLayout.addView(pm2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(this.A0N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0e(@Nullable C1543cy c1543cy, boolean z) {
        if (c1543cy == null) {
            return;
        }
        if (this.A0F.equals(EnumC0947Jl.A04)) {
            String A61 = c1543cy.A61();
            if (!TextUtils.isEmpty(A61)) {
                this.A0b.A0b(new C0937Jb(A61, this.A0D.A08()));
            }
            if (c1543cy.A0L() != null) {
                C7G c7g = new C7G(c1543cy.A0L().getUrl(), c1543cy.A0L().getHeight(), c1543cy.A0L().getWidth(), c1543cy.A0S(), A0T(662, 6, 54));
                c7g.A00 = this.A0C;
                this.A0b.A0T();
                this.A0b.A0V(c7g);
            }
            if (!this.A0K.equals(K9.A04)) {
                if (c1543cy.A0K() != null) {
                    this.A0b.A0V(new C7G(c1543cy.A0K().getUrl(), c1543cy.A0K().getHeight(), c1543cy.A0K().getWidth(), c1543cy.A0S(), A0T(662, 6, 54)));
                }
                List<C1198Tj> A0W = c1543cy.A0W();
                String[] strArr = A0l;
                if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0l;
                strArr2[1] = "BiVeVWtUTguxpSjeMqAkCwQXeKWOVTz4";
                strArr2[3] = "8sdR9nWPZ664Gt9BvBocaDJi5It1hBkX";
                if (A0W != null) {
                    for (C1198Tj c1198Tj : c1543cy.A0W()) {
                        if (c1198Tj.getAdCoverImage() != null) {
                            this.A0b.A0V(new C7G(c1198Tj.getAdCoverImage().getUrl(), c1198Tj.getAdCoverImage().getHeight(), c1198Tj.getAdCoverImage().getWidth(), c1543cy.A0S(), A0T(662, 6, 54)));
                        }
                    }
                }
                String A0U = c1543cy.A0U();
                if (!TextUtils.isEmpty(A0U)) {
                    this.A0b.A0a(new C7I(A0U, c1543cy.A0S(), A0T(662, 6, 54), c1543cy.A0O().longValue()));
                }
            }
        }
        this.A0b.A0U(new C1205Tq(this, c1543cy, z), new C7C(c1543cy.A0S(), A0T(662, 6, 54)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0f(AnonymousClass11 anonymousClass11) {
        C1543cy c1543cy = this.A0a;
        if (c1543cy == null) {
            return;
        }
        c1543cy.A0Y(anonymousClass11);
    }

    public static void A0g(NativeAdImageApi nativeAdImageApi, ImageView imageView, XT xt) {
        if (nativeAdImageApi != null && imageView != null) {
            new AsyncTaskC1164Sb(imageView, xt).A05(nativeAdImageApi.getHeight(), nativeAdImageApi.getWidth()).A07(nativeAdImageApi.getUrl());
        }
    }

    private final void A0l(InterfaceC1197Ti interfaceC1197Ti) {
        this.A0H = interfaceC1197Ti;
    }

    private final void A0m(String str) {
        this.A0S = str;
    }

    private void A0n(List<View> list, View view) {
        InterfaceC0952Jq interfaceC0952Jq = this.A0c;
        if (interfaceC0952Jq != null && interfaceC0952Jq.AEb(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                String[] strArr = A0l;
                if (strArr[7].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0l;
                strArr2[1] = "SQxDsveS3BVeMl0nUnJayKxDlwKiSRwM";
                strArr2[3] = "CPUPH8uU8pe6dd8URnD7AGDEQ4lKFlLs";
                A0n(list, childAt);
            }
            return;
        }
        list.add(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0o() {
        return A16() == EnumC0958Jw.A05 || A16() == EnumC0958Jw.A03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0p() {
        C1543cy c1543cy = this.A0a;
        return c1543cy != null && c1543cy.A0j();
    }

    public final long A0w() {
        return this.A00;
    }

    @Nullable
    public final C1543cy A0x() {
        return this.A0a;
    }

    public final AnonymousClass16 A0y() {
        return A0x().A0I();
    }

    public final C7J A0z() {
        return this.A0b;
    }

    public final XT A10() {
        return this.A0D;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    /* renamed from: A11 */
    public final C0953Jr getAdCoverImage() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A0K();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    /* renamed from: A12 */
    public final C0953Jr getAdIcon() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A0L();
    }

    @Nullable
    public final InterfaceC1197Ti A13() {
        return this.A0H;
    }

    public final C0955Jt A14() {
        return this.A0I;
    }

    public final EnumC0956Ju A15() {
        return this.A0J;
    }

    public final EnumC0958Jw A16() {
        if (!isAdLoaded()) {
            return EnumC0958Jw.A03;
        }
        return this.A0a.A0N();
    }

    public final C1009Lz A17() {
        return this.A0e;
    }

    public final QZ A18() {
        return this.A0R;
    }

    @Nullable
    public final String A19() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A61();
    }

    @Nullable
    public final String A1A() {
        return this.A0T;
    }

    @Nullable
    public final String A1B() {
        return A1F(A0T(668, 17, 33));
    }

    @Nullable
    public final String A1C() {
        return A1F(A0T(685, 16, 17));
    }

    @Nullable
    public final String A1D() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A0T();
    }

    @Nullable
    public final String A1E() {
        if (!isAdLoaded() || TextUtils.isEmpty(this.A0a.A0U())) {
            return null;
        }
        return this.A0b.A0Q(this.A0a.A0U());
    }

    @Nullable
    public final String A1F(String str) {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A0V(str);
    }

    @Nullable
    public final List<C1198Tj> A1G() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A0W();
    }

    public final void A1H() {
        if (!C2A.A0P(this.A0D.A00(), false)) {
            A0X();
            return;
        }
        XT xt = this.A0D;
        N1 A01 = N2.A01(xt, xt.A08(), A19(), this.A07);
        if (A01 == null) {
            A0X();
            return;
        }
        ((C1437b7) this.A07.getNativeAdLayoutApi()).A03(A01);
        A01.A0J();
    }

    public final void A1I(@Nullable Drawable drawable) {
        this.A01 = drawable;
        A1a(drawable != null, true);
        String[] strArr = A0l;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0l;
        strArr2[4] = "Q96JEqttX0oIb74l";
        strArr2[6] = "mqYIcYUMJzEb";
    }

    public final void A1J(View view) {
        this.A0h.add(view);
        view.setOnClickListener(this.A0G);
        view.setOnTouchListener(this.A0G);
        if (Build.VERSION.SDK_INT >= 18) {
            boolean A0u = JD.A0u(view.getContext());
            String[] strArr = A0l;
            if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[4] = "GeTsVetQiODT9yUx";
            strArr2[6] = "UPeG8QvAHkrx";
            if (A0u) {
                view.setOnLongClickListener(this.A0G);
            }
        }
    }

    public final void A1K(View view, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        A0n(arrayList, view);
        A0c(view, imageView, arrayList, true);
    }

    public final void A1L(View view, ImageView imageView, List<View> list) {
        A0c(view, imageView, list, true);
    }

    public final void A1M(View view, AdNativeComponentView adNativeComponentView) {
        ArrayList arrayList = new ArrayList();
        A0n(arrayList, view);
        A0c(view, adNativeComponentView, arrayList, false);
    }

    public final void A1N(View view, AdNativeComponentView adNativeComponentView, List<View> list) {
        A0c(view, adNativeComponentView, list, false);
    }

    public final void A1O(MediaView mediaView) {
        if (mediaView != null) {
            this.A0Y = true;
        }
    }

    public final void A1P(MediaView mediaView) {
        if (mediaView != null) {
            this.A0Z = true;
        }
    }

    public final void A1Q(@Nullable NativeAdLayout nativeAdLayout) {
        this.A07 = nativeAdLayout;
    }

    public final void A1R(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        if (nativeAdListener == null) {
            return;
        }
        A0l(new C0740Av(nativeAdListener, nativeAdBase));
    }

    public final void A1S(@Nullable C1452bM c1452bM) {
        this.A0U = new WeakReference<>(c1452bM);
    }

    public final void A1T(EnumC0947Jl enumC0947Jl, @Nullable String str, C7O c7o) {
        if (str == null) {
            this.A0D.A0D().A2d();
        } else {
            this.A0D.A0D().A2c();
        }
        this.A00 = System.currentTimeMillis();
        if (this.A0i) {
            AdSettings.IntegrationErrorMode A00 = C05131q.A00(this.A0D);
            String A0T = A0T(632, 30, 22);
            if (!AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE.equals(A00)) {
                K3 k3 = new K3(AdErrorType.LOAD_AD_CALLED_MORE_THAN_ONCE, A0T(632, 30, 22));
                A10().A0D().A2a(C1008Ly.A01(this.A00), k3.A03().getErrorCode(), k3.A04());
                InterfaceC1197Ti interfaceC1197Ti = this.A0H;
                if (interfaceC1197Ti != null) {
                    interfaceC1197Ti.AAW(k3);
                } else {
                    Log.e(A0T(71, 17, 84), A0T);
                }
                C06818n c06818n = new C06818n(A0T);
                A10().A06().A8q(A0T(574, 3, 7), C06808m.A0U, c06818n);
            } else {
                throw new C05181v(A0T);
            }
        }
        this.A0i = true;
        this.A0F = enumC0947Jl;
        if (enumC0947Jl.equals(EnumC0947Jl.A05)) {
            this.A08 = EnumC04960z.A05;
        }
        this.A0C = c7o;
        C05111o c05111o = new C05111o(this.A0f, this.A0K, A0P(), null, 1);
        c05111o.A04(enumC0947Jl);
        c05111o.A05(this.A0S);
        c05111o.A06(this.A0T);
        this.A0A = new F6(this.A0D, c05111o);
        this.A0A.A0M(new C1206Tr(this));
        this.A0A.A0P(str);
    }

    public final void A1U(C0955Jt c0955Jt) {
        this.A0I = c0955Jt;
    }

    public final void A1V(EnumC0956Ju enumC0956Ju) {
        this.A0J = enumC0956Ju;
    }

    public final void A1W(K9 k9) {
        if (!A0p()) {
            if (K9.A04.equals(k9)) {
                XT xt = this.A0D;
                String[] strArr = A0l;
                if (strArr[7].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0l;
                strArr2[7] = "er71GFUENUkH6mVEmd80tsw";
                strArr2[5] = "eRFgtOOg0hnVr16Te1PNaNs";
                xt.A0D().A2g(AdPlacementType.NATIVE_BANNER.toString(), this.A0f);
            } else {
                this.A0D.A0D().A2g(AdPlacementType.NATIVE.toString(), this.A0f);
            }
        }
        this.A0K = k9;
    }

    public final void A1X(QY qy) {
        this.A0V = new WeakReference<>(qy);
    }

    public final void A1Y(boolean z) {
        this.A0W = z;
    }

    public final void A1Z(boolean z) {
        this.A0X = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
        if (r3 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
        r2 = r3.A0S();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e4, code lost:
        if (r3 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e7, code lost:
        r2 = A0T(0, 0, 21);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A1a(boolean r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1198Tj.A1a(boolean, boolean):void");
    }

    public final boolean A1b() {
        return this.A07 == null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0961Jz
    public final int A6A() {
        View view = this.A06;
        if (view instanceof AdNativeComponentView) {
            View videoView = ((AdNativeComponentView) view).getAdContentsView();
            if (videoView instanceof C1092Ph) {
                return ((C1092Ph) videoView).getCurrentPosition();
            }
            return -1;
        }
        return -1;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase) {
        return new C0959Jx(this, nativeAdBase);
    }

    @Override // com.facebook.ads.Ad
    public final void destroy() {
        KI.A05(A0T(595, 7, 89), A0T(358, 19, 89), A0T(0, 8, 0));
        if (JD.A1D(this.A0D)) {
            A10().A09().AF3(this.A03);
        }
        if (!A0p()) {
            this.A0D.A0D().A2h();
        }
        F6 f6 = this.A0A;
        if (f6 != null) {
            f6.A0R(true);
            this.A0A = null;
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void downloadMedia() {
        if (this.A0F.equals(EnumC0947Jl.A05)) {
            this.A08 = EnumC04960z.A04;
        }
        this.A0F = EnumC0947Jl.A04;
        A0e(this.A0a, false);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdBodyText() {
        if (isAdLoaded()) {
            return this.A0a.A0P();
        }
        String[] strArr = A0l;
        if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
            String[] strArr2 = A0l;
            strArr2[0] = "hTgZwGr1QjZPArcNv2XISvdh6HkvBsNu";
            strArr2[2] = "WdfIathAKVLlC1caO5TsuRke00xxoQup";
            return null;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdCallToAction() {
        return A1F(A0T(581, 14, 115));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdChoicesImageUrl() {
        if (getAdChoicesIcon() == null) {
            return null;
        }
        C0953Jr adChoicesIcon = getAdChoicesIcon();
        String[] strArr = A0l;
        if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
            String[] strArr2 = A0l;
            strArr2[7] = "MRTmAh7YnfwjJHGdoro5GGF";
            strArr2[5] = "5NAjexdbITBZf7E7VHPXfXw";
            return adChoicesIcon.getUrl();
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdChoicesLinkUrl() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A0Q();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdChoicesText() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0a.A0R();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdHeadline() {
        return A1F(A0T(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, 8, 49));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdLinkDescription() {
        return A1F(A0T(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 16, 45));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdSocialContext() {
        return A1F(A0T(721, 14, 78));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdTranslation() {
        return A1F(A0T(545, 14, 15));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdUntrimmedBodyText() {
        return A1F(A0T(577, 4, 14));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdvertiserName() {
        return A1F(A0T(559, 15, 3));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final float getAspectRatio() {
        C1543cy c1543cy = this.A0a;
        if (c1543cy != null) {
            C0953Jr A0K = c1543cy.A0K();
            int width = A0K.getWidth();
            String[] strArr = A0l;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[1] = "Gk0JtmCCXYpL8dPDyrRdSPBqQO7pSw2M";
            strArr2[3] = "hZFl2ZrFl9W40ZKmdwMt57qcTxbjzHrP";
            int height = A0K.getHeight();
            if (height > 0) {
                return width / height;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getId() {
        if (!isAdLoaded()) {
            return null;
        }
        String str = this.A0g;
        String[] strArr = A0l;
        if (strArr[4].length() != strArr[6].length()) {
            String[] strArr2 = A0l;
            strArr2[7] = "iawtn5ImZtHDfKUJHK1ePg9";
            strArr2[5] = "61vZsTsWUXSHOR043CjOsZn";
            return str;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A0f;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final Drawable getPreloadedIconViewDrawable() {
        C0953Jr adIcon;
        Bitmap A0K;
        C1543cy c1543cy = this.A0a;
        if (c1543cy != null && (adIcon = c1543cy.A0L()) != null && (A0K = this.A0b.A0K(adIcon.getUrl())) != null) {
            XT A10 = A10();
            boolean A1b = A1b();
            String[] strArr = A0l;
            if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
                String[] strArr2 = A0l;
                strArr2[4] = "5rXv1LFjMRKkpcU7";
                strArr2[6] = "SFgDKFOuseBk";
                return A05(A10, A0K, A1b, A1A());
            }
            throw new RuntimeException();
        }
        return null;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getPromotedTranslation() {
        return A1F(A0T(701, 20, 14));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getSponsoredTranslation() {
        return A1F(A0T(735, 21, 60));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean hasCallToAction() {
        C1543cy c1543cy = this.A0a;
        return c1543cy != null && c1543cy.A0g();
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean z = true;
        F6 f6 = this.A0A;
        if (f6 != null) {
            z = f6.A0S();
        } else {
            C1505cM c1505cM = this.A0B;
            String[] strArr = A0l;
            if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0l;
            strArr2[7] = "v5uFzvuQ32LyebguaenlI2Y";
            strArr2[5] = "nsJGpwd0QPZOfVeZMyNRGWR";
            if (c1505cM != null) {
                z = c1505cM.A0A();
            }
        }
        this.A0D.A0D().A4W(z);
        return z;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean isAdLoaded() {
        C1543cy c1543cy = this.A0a;
        return c1543cy != null && c1543cy.A0h();
    }

    @Override // com.facebook.ads.Ad
    public final void loadAd() {
        KI.A05(A0T(626, 6, 112), A0T(377, 24, 23), A0T(8, 8, 76));
        A1T(EnumC0947Jl.A00(NativeAdBase.MediaCacheFlag.ALL), null, new C7O(false, -1, -1));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAd(NativeAdBase.NativeLoadAdConfig nativeLoadAdConfig) {
        KI.A05(A0T(626, 6, 112), A0T(377, 24, 23), A0T(16, 8, 89));
        ((C0959Jx) nativeLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void onCtaBroadcast() {
        this.A05.performClick();
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        View view = this.A04;
        if (view != null) {
            view.post(new C1208Tt(this));
        }
        String str = A0T(159, 16, 50) + C0999Lp.A03(this.A0D, th);
        A10().A0D().A2a(C1008Ly.A01(this.A00), AdError.INTERNAL_ERROR_CODE, str);
        InterfaceC1197Ti interfaceC1197Ti = this.A0H;
        if (interfaceC1197Ti != null) {
            interfaceC1197Ti.AAW(new K3((int) AdError.INTERNAL_ERROR_CODE, str));
        }
    }

    @Override // com.facebook.ads.Ad
    public final void setExtraHints(ExtraHints extraHints) {
        if (extraHints == null) {
            return;
        }
        A0m(extraHints.getHints());
        this.A0T = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A02 = onTouchListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
        if (com.facebook.ads.redexgen.X.JD.A1D(r4) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0072, code lost:
        A10().A09().AF3(r6.A03);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0087, code lost:
        if (com.facebook.ads.redexgen.X.C1198Tj.A0n.containsKey(r6.A04) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0097, code lost:
        if (com.facebook.ads.redexgen.X.C1198Tj.A0n.get(r6.A04).get() != r6) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0099, code lost:
        r4 = r6.A04;
        r5 = r4 instanceof android.view.ViewGroup;
        r3 = com.facebook.ads.redexgen.X.C1198Tj.A0l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ad, code lost:
        if (r3[4].length() == r3[6].length()) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00af, code lost:
        r3 = com.facebook.ads.redexgen.X.C1198Tj.A0l;
        r3[0] = "lVWmVGygxw0UbRbggHe19cSptvLLteak";
        r3[2] = "yD1YSLWVotW9RM3Ng5RpEu8J61bKeSm7";
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bb, code lost:
        if (r5 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bd, code lost:
        r0 = r6.A0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bf, code lost:
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c1, code lost:
        ((android.view.ViewGroup) r4).removeView(r0);
        r6.A0L = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c8, code lost:
        r0 = r6.A0a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ca, code lost:
        if (r0 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cc, code lost:
        r0.A0X();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
        if (android.os.Build.VERSION.SDK_INT < 18) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d7, code lost:
        if (r6.A0M == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00df, code lost:
        if (com.facebook.ads.redexgen.X.JD.A0u(r6.A0D) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e1, code lost:
        r6.A0M.A07();
        r6.A04.getOverlay().remove(r6.A0M);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f1, code lost:
        com.facebook.ads.redexgen.X.C1198Tj.A0n.remove(r6.A04);
        A0W();
        r6.A04 = null;
        r6.A06 = null;
        r0 = r6.A0R;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0101, code lost:
        if (r0 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0103, code lost:
        r0.A0V();
        r6.A0R = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0108, code lost:
        A0Z();
        r6.A09 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x010d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (r5 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0115, code lost:
        if (com.facebook.ads.redexgen.X.JD.A1D(r4) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0128, code lost:
        throw new java.lang.IllegalStateException(A0T(476, 38, 15));
     */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void unregisterView() {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1198Tj.unregisterView():void");
    }
}
