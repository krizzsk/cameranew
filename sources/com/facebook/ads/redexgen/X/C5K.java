package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5K  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C5K extends AsyncTask<C5M, Void, Drawable> {
    public static byte[] A03;
    public static String[] A04 = {"1BJo9noXfKND6AuvSNdcB1V3GCwIAiOG", "Zj7TA2K", "dGMOiNue98uIHvh7voSV0LAZFWXYzfEv", "CcnxrNYo5kyWzKS3XGCDqe4PQiCtH", "knheqnusZFI0swerek9wKwEDBcdWqhKt", "XjDOSOe9Ixcmw73z7hfuGI1aFjWKj", "M2ugdIZCKbhB2vBaVocVLhBvD0BsDTY5", "metH7Y2aXkNKgtpuuGKiPWqQd6SU"};
    public final C5L A00;
    public final XT A01;
    public final boolean A02;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 118);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{59, 57, 50, 57, 46, 53, 63};
    }

    static {
        A02();
    }

    public C5K(XT xt, C5L c5l, boolean z) {
        this.A01 = xt;
        this.A00 = c5l;
        this.A02 = z;
    }

    public /* synthetic */ C5K(XT xt, C5L c5l, boolean z, C1430b0 c1430b0) {
        this(xt, c5l, z);
    }

    @SuppressLint({"CatchGeneralException"})
    private final Drawable A00(C5M... c5mArr) {
        if (!C0974Kn.A02(this) && c5mArr != null) {
            try {
                if (c5mArr.length >= 1) {
                    String str = c5mArr[0].A01;
                    String str2 = c5mArr[0].A00;
                    Bitmap A0L = new C7J(this.A01).A0L(str, -1, -1);
                    if (A0L != null) {
                        return C1198Tj.A05(this.A01, A0L, this.A02, str2);
                    }
                    return null;
                }
            } catch (Throwable th) {
                C0974Kn.A00(th, this);
                return null;
            }
        }
        return null;
    }

    private final void A03(Drawable drawable) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.AAj(drawable);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    @Override // android.os.AsyncTask
    @SuppressLint({"CatchGeneralException"})
    public final /* bridge */ /* synthetic */ Drawable doInBackground(C5M[] c5mArr) {
        if (C0974Kn.A02(this)) {
            return null;
        }
        try {
            return A00(c5mArr);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Drawable drawable) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            A03(drawable);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            String[] strArr = A04;
            if (strArr[0].charAt(5) != strArr[4].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[1] = "H4qVqfS";
            strArr2[7] = "3NPSPTmKkS9byZNXvPXu57LevjUG";
        }
    }
}
