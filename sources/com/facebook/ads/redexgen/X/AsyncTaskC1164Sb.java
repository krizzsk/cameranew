package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Sb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class AsyncTaskC1164Sb extends AsyncTask<String, Void, Bitmap[]> implements C8H {
    public static byte[] A0A;
    public static String[] A0B = {"Y", "r8ye64eLoQHeOJVpmB1uxWw1zCCHhuzX", "pvZIfONmKv3cVbimQPa9", "RLgA2SApOIsDDawooMs2KL5D8ZiCWoW1", "kM6akDIqkvY", "0vJdyNO9qrz2JF8Kt31GcmRDql8haFQB", "b8N1ZLVb0I2QrMIKflin5UtA7D7V4D", "X"};
    public int A00;
    public int A01;
    public InterfaceC1054Nt A02;
    public boolean A03;
    public final int A04;
    public final int A05;
    @Nullable
    public final WeakReference<C1052Nr> A06;
    public final WeakReference<XT> A07;
    @Nullable
    public final WeakReference<ImageView> A08;
    @Nullable
    public final WeakReference<ViewGroup> A09;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 48);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{-89, -91, -82, -91, -78, -87, -93};
    }

    static {
        A01();
    }

    public AsyncTaskC1164Sb(ViewGroup viewGroup, int i2, int i3, XT xt) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(xt);
        this.A06 = null;
        this.A08 = null;
        this.A09 = new WeakReference<>(viewGroup);
        this.A04 = i2;
        this.A05 = i3;
    }

    public AsyncTaskC1164Sb(ViewGroup viewGroup, XT xt) {
        this(viewGroup, 12, 16, xt);
    }

    public AsyncTaskC1164Sb(ImageView imageView, XT xt) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(xt);
        this.A06 = null;
        this.A08 = new WeakReference<>(imageView);
        this.A09 = null;
        this.A04 = 0;
        this.A05 = 1;
    }

    public AsyncTaskC1164Sb(C1052Nr c1052Nr, XT xt) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(xt);
        this.A06 = new WeakReference<>(c1052Nr);
        this.A08 = null;
        this.A09 = null;
        this.A04 = 12;
        this.A05 = 16;
    }

    private final void A02(Bitmap[] bitmapArr) {
        C1052Nr c1052Nr;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            if (this.A08 != null) {
                ImageView imageView = this.A08.get();
                if (bitmapArr[1] != null && !this.A03 && this.A04 != 0 && imageView != null) {
                    imageView.setImageBitmap(bitmapArr[1]);
                    return;
                } else if (imageView != null) {
                    imageView.setImageBitmap(bitmapArr[0]);
                }
            }
            if (this.A06 != null && (c1052Nr = this.A06.get()) != null) {
                c1052Nr.setImage(bitmapArr[0], bitmapArr[1]);
            }
            if (this.A09 != null && this.A09.get() != null && bitmapArr[1] != null) {
                M5.A0S(this.A09.get(), new BitmapDrawable(this.A07.get().getResources(), bitmapArr[1]));
            }
            if (this.A02 != null) {
                this.A02.AAi(bitmapArr[0] != null);
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    private final Bitmap[] A03(String... strArr) {
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            Bitmap bitmap = null;
            XT xt = this.A07.get();
            if (xt == null) {
                return new Bitmap[]{null, null};
            }
            Bitmap A0L = new C7J(xt).A0L(str, this.A00, this.A01);
            if (A0L != null && !this.A03) {
                bitmap = MC.A01(xt, A0L, this.A04, this.A05);
            }
            return new Bitmap[]{A0L, bitmap};
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            return null;
        }
    }

    public final AsyncTaskC1164Sb A04() {
        this.A00 = -1;
        this.A01 = -1;
        return this;
    }

    public final AsyncTaskC1164Sb A05(int i2, int i3) {
        this.A00 = i2;
        this.A01 = i3;
        return this;
    }

    public final AsyncTaskC1164Sb A06(InterfaceC1054Nt interfaceC1054Nt) {
        this.A02 = interfaceC1054Nt;
        return this;
    }

    public final void A07(String str) {
        if (TextUtils.isEmpty(str)) {
            InterfaceC1054Nt interfaceC1054Nt = this.A02;
            if (interfaceC1054Nt != null) {
                interfaceC1054Nt.AAi(false);
                return;
            }
            return;
        }
        executeOnExecutor(MA.A06, str);
    }

    @Override // com.facebook.ads.redexgen.X.C8H
    @Nullable
    public final XT A5Y() {
        return this.A07.get();
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Bitmap[] doInBackground(String[] strArr) {
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            return A03(strArr);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Bitmap[] bitmapArr) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A02(bitmapArr);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            String[] strArr = A0B;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[0] = "X";
            strArr2[7] = "y";
        }
    }
}
