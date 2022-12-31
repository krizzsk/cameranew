package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.an  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1417an implements InterfaceC06165r {
    public static String[] A01 = {"00MHKwkDmYoCx2OGjgEThOFtXdhQRjTN", "7Ria84C0K", "Ef46Z6TVH4NcbkjVvmEOqYFgRFOKpwYs", "vDkYYDvZcNCUpf8elhY6lCtHoiks0igx", "DcHCx27DST8xJ8i8V4O5Sgcxtk3BoSo4", "aRh12LJ8xJf1WwvMgk22O9V5avURmtja", "8W8Gty0itChe2KZHdRNz96726BmzX04b", "FJvJLlvq782Xeh3qU1n4ZIKrAnM2Vabf"};
    public final Map<String, C06145p> A00 = new HashMap();

    @Override // com.facebook.ads.redexgen.X.InterfaceC06165r
    public final synchronized String ADi() {
        StringBuilder sb;
        sb = new StringBuilder();
        for (C06145p stat : this.A00.values()) {
            sb.append(stat.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06165r
    public final synchronized void reset() {
        this.A00.clear();
        if (A01[6].charAt(31) == 'v') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[0] = "pUfrmNlD3Jjwd3BaOF4VLqTdMmEyzhLC";
        strArr[5] = "lXluT4ZzsD6fM7rO3zGi3X1PCHmREvtS";
    }
}
