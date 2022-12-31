package com.ironsource.mediationsdk.model;
/* compiled from: PlacementAvailabilitySettings.java */
/* loaded from: classes2.dex */
public class p {
    private boolean a;
    private boolean b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private PlacementCappingType f5623d;

    /* renamed from: e  reason: collision with root package name */
    private int f5624e;

    /* renamed from: f  reason: collision with root package name */
    private int f5625f;

    /* compiled from: PlacementAvailabilitySettings.java */
    /* loaded from: classes2.dex */
    public static class b {
        private boolean a = true;
        private boolean b = false;
        private boolean c = false;

        /* renamed from: d  reason: collision with root package name */
        private PlacementCappingType f5626d = null;

        /* renamed from: e  reason: collision with root package name */
        private int f5627e = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f5628f = 0;

        public p a() {
            return new p(this.a, this.b, this.c, this.f5626d, this.f5627e, this.f5628f);
        }

        public b b(boolean z, PlacementCappingType placementCappingType, int i2) {
            this.b = z;
            if (placementCappingType == null) {
                placementCappingType = PlacementCappingType.PER_DAY;
            }
            this.f5626d = placementCappingType;
            this.f5627e = i2;
            return this;
        }

        public b c(boolean z) {
            this.a = z;
            return this;
        }

        public b d(boolean z, int i2) {
            this.c = z;
            this.f5628f = i2;
            return this;
        }
    }

    public PlacementCappingType a() {
        return this.f5623d;
    }

    public int b() {
        return this.f5624e;
    }

    public int c() {
        return this.f5625f;
    }

    public boolean d() {
        return this.b;
    }

    public boolean e() {
        return this.a;
    }

    public boolean f() {
        return this.c;
    }

    private p(boolean z, boolean z2, boolean z3, PlacementCappingType placementCappingType, int i2, int i3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.f5623d = placementCappingType;
        this.f5624e = i2;
        this.f5625f = i3;
    }
}
