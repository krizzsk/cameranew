package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class VJ implements E3 {
    @Override // com.facebook.ads.redexgen.X.E3
    public final Metadata A4f(C0775Cp c0775Cp) {
        ByteBuffer buffer = c0775Cp.A01;
        byte[] array = buffer.array();
        int size = buffer.limit();
        IV iv = new IV(array, size);
        String A0Q = iv.A0Q();
        String A0Q2 = iv.A0Q();
        long A0M = iv.A0M();
        long timescale = C0923Il.A0F(iv.A0M(), 1000000L, A0M);
        long presentationTimeUs = iv.A0M();
        long id = C0923Il.A0F(presentationTimeUs, 1000L, A0M);
        return new Metadata(new EventMessage(A0Q, A0Q2, id, iv.A0M(), Arrays.copyOfRange(array, iv.A06(), size), timescale));
    }
}
