package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public class FT implements Runnable {
    public static String[] A06 = {"MFzmm2XpKtQDQZ1nrLFzIVLfypAdXqn0", "St6NP3oa8jPcs9ySqX58Qb7cq6M0Lslj", "FY6GSV0T1DmbxtheDZWAefy5bW4XMUrK", "e7zVVEHUrXPHmOTr9XrOqtCewhDOezV9", "rRe4XoYawEGGgKvf4FFgivRzu7z94IPy", "2sUcpRkbdiQEA9XQnsePPVJ2ZVsexJIi", "YygzZHUIY4dTUEusYM1qdSBaSuhDwAUc", "5Y8Iu0wedn9Jl3yvaaWMiUkpwoVz8Vqp"};
    public final /* synthetic */ FY A00;
    public final /* synthetic */ FZ A01;
    public final /* synthetic */ C0836Fa A02;
    public final /* synthetic */ InterfaceC0837Fb A03;
    public final /* synthetic */ IOException A04;
    public final /* synthetic */ boolean A05;

    public FT(FY fy, InterfaceC0837Fb interfaceC0837Fb, FZ fz, C0836Fa c0836Fa, IOException iOException, boolean z) {
        this.A00 = fy;
        this.A03 = interfaceC0837Fb;
        this.A01 = fz;
        this.A02 = c0836Fa;
        this.A04 = iOException;
        this.A05 = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A03.AB4(this.A00.A00, this.A00.A01, this.A01, this.A02, this.A04, this.A05);
        } catch (Throwable th) {
            String[] strArr = A06;
            if (strArr[7].charAt(1) != strArr[2].charAt(1)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[7] = "5YuzUPqIN2qUpgzcgBPCGBub3XZtkUQJ";
            strArr2[2] = "DYAXZKj6jF9OEHVnXiKZJEzpdMmcnACr";
            C0974Kn.A00(th, this);
        }
    }
}
