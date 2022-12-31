package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.dk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1590dk<ModelType, StateType> {
    public final ModelType A02;
    public final StateType A03;
    public final String A04;
    @Nullable
    public List<InterfaceC1592dm<ModelType, StateType>> A01 = null;
    public C1589dj A00 = C1589dj.A06;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dk != com.instagram.common.viewpoint.core.ViewpointData$Builder<ModelType, StateType> */
    public C1590dk(ModelType modeltype, StateType statetype, String str) {
        this.A02 = modeltype;
        this.A03 = statetype;
        this.A04 = str;
    }

    public static /* synthetic */ C1589dj A00(C1590dk c1590dk) {
        return c1590dk.A00;
    }

    public static /* synthetic */ Object A01(C1590dk c1590dk) {
        return c1590dk.A02;
    }

    public static /* synthetic */ Object A02(C1590dk c1590dk) {
        return c1590dk.A03;
    }

    public static /* synthetic */ String A03(C1590dk c1590dk) {
        return c1590dk.A04;
    }

    public static /* synthetic */ List A04(C1590dk c1590dk) {
        return c1590dk.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dk != com.instagram.common.viewpoint.core.ViewpointData$Builder<ModelType, StateType> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dm != com.instagram.common.viewpoint.core.ViewpointAction<ModelType, StateType> */
    public final C1590dk<ModelType, StateType> A05(InterfaceC1592dm<ModelType, StateType> interfaceC1592dm) {
        if (this.A01 == null) {
            this.A01 = new ArrayList();
        }
        this.A01.add(interfaceC1592dm);
        return this;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dk != com.instagram.common.viewpoint.core.ViewpointData$Builder<ModelType, StateType> */
    public final C1589dj<ModelType, StateType> A06() {
        return new C1589dj<>(this);
    }
}
