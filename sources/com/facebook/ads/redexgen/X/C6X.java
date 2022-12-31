package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.6X  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C6X {
    public static String[] A02 = {"HSkcF60AiAyYJizD2I8vIjqhfibhLk4F", "vdkNajAjw36u5RvY9xFki59AuKhwr3og", "", "sseZ8EdYk7i", "1PxOfa9BsFlCUZKt15VhEMgvVyvUPrjN", "QpqokUuVk7nKJb7TmK", "vU9iDbhGXBQk4voVJMEMlbxkWIFvNann", "KoP5O6PQnxDmDbSqeBv0xhaZ"};
    public final Context A00;
    public final AnonymousClass61 A01;

    public C6X(Context context, AnonymousClass61 anonymousClass61) {
        this.A00 = context;
        this.A01 = anonymousClass61;
    }

    private int A00(AnonymousClass61 anonymousClass61, C06326h c06326h) {
        if (anonymousClass61.A0e(c06326h.A00()) != null) {
            return anonymousClass61.A0e(c06326h.A00()).intValue();
        }
        if (c06326h.A03().contains(EnumC06396o.A0B)) {
            return anonymousClass61.A0S();
        }
        if (c06326h.A03().contains(EnumC06396o.A08)) {
            return anonymousClass61.A0R();
        }
        return anonymousClass61.A0V();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.66 != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    @SuppressLint({"CatchGeneralException"})
    public final synchronized void A01(EnumC06366l enumC06366l, List<C06326h> list) {
        AbstractC06506z A5G;
        AbstractC06506z abstractC06506z;
        Map<Integer, AnonymousClass66<AbstractC06506z>> A03 = C06376m.A01().A03();
        for (C06326h c06326h : list) {
            InterfaceC06356k signalExecutor = c06326h.A02(enumC06366l);
            if (signalExecutor != null && (A5G = signalExecutor.A5G()) != null && A5G.A07() != null) {
                if (c06326h.A03().contains(EnumC06396o.A0B) && A03.containsKey(Integer.valueOf(c06326h.A00()))) {
                    AnonymousClass66<AbstractC06506z> anonymousClass66 = A03.get(Integer.valueOf(c06326h.A00()));
                    if (anonymousClass66 != null) {
                        abstractC06506z = anonymousClass66.A02();
                    } else {
                        abstractC06506z = null;
                    }
                    if (anonymousClass66 == null) {
                        anonymousClass66 = new AnonymousClass66<>(A00(this.A01, c06326h));
                    }
                    if (abstractC06506z == null || !A5G.A0B(abstractC06506z, c06326h.A03())) {
                        anonymousClass66.A04(A5G);
                        C06376m.A01().A04(c06326h.A00(), anonymousClass66, A5G.A05());
                    }
                } else {
                    AnonymousClass66<AbstractC06506z> anonymousClass662 = new AnonymousClass66<>(A00(this.A01, c06326h));
                    anonymousClass662.A04(A5G);
                    C06376m.A01().A04(c06326h.A00(), anonymousClass662, A5G.A05());
                }
            }
        }
        String[] strArr = A02;
        if (strArr[0].charAt(9) == strArr[1].charAt(9)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[5] = "mCdjiAVU6tB7YULC7P";
        strArr2[2] = "";
    }
}
