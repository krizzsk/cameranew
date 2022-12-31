package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.aI  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1386aI implements InterfaceC06356k {
    public static String[] A01 = {"hvm87xlnXDULJgpudJIAxjipYcLfVpPe", "aPn41y0iNcbQ3vA5A69njqeDstAsTpsV", "WXmwgMFdLW61FUxTxJC7XlBGpuRVL7Wu", "ePkGYIfh56SCQIxOGTOw2FZrMqM6oOvD", "H4G3VitdwZHOwCvFNAwNX1rKXwUNte3T", "QqBVensdyxYwCHnIBjshd9TsYmlVQcVc", "Npnx1Hqps9YG5SIKMksWN5UpsP86zlug", "K4PmfDIjqE3AfePNsovy4"};
    public final /* synthetic */ C1371a3 A00;

    public C1386aI(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() throws Exception {
        AnonymousClass74 anonymousClass74;
        anonymousClass74 = this.A00.A03;
        String A06 = anonymousClass74.A06(10005);
        if (A06 != null) {
            C1371a3 c1371a3 = this.A00;
            if (A01[7].length() != 21) {
                throw new RuntimeException();
            }
            A01[7] = "XG8OcIRWX82QEKbSmFw2M";
            return c1371a3.A08(A06);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
