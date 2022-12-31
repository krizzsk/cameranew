package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.NavigableSet;
/* renamed from: com.facebook.ads.redexgen.X.Hq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public interface InterfaceC0902Hq {
    void A3N(String str, I2 i2) throws C0900Ho;

    void A42(File file) throws C0900Ho;

    long A5r();

    long A5s(String str, long j2, long j3);

    @NonNull
    NavigableSet<C0906Hu> A5t(String str);

    long A64(String str);

    I0 A65(String str);

    void ADW(C0906Hu c0906Hu);

    void ADd(C0906Hu c0906Hu) throws C0900Ho;

    void AEK(String str, long j2) throws C0900Ho;

    File AEl(String str, long j2, long j3) throws C0900Ho;

    C0906Hu AEn(String str, long j2) throws InterruptedException, C0900Ho;

    @Nullable
    C0906Hu AEo(String str, long j2) throws C0900Ho;
}
