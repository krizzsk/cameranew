package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.h;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class RoundingParams {
    private RoundingMethod a = RoundingMethod.BITMAP_ONLY;
    private boolean b = false;
    @Nullable
    private float[] c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f2580d = 0;

    /* renamed from: e  reason: collision with root package name */
    private float f2581e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private int f2582f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f2583g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2584h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2585i = false;

    /* loaded from: classes.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public static RoundingParams a(float f2) {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.o(f2);
        return roundingParams;
    }

    private float[] e() {
        if (this.c == null) {
            this.c = new float[8];
        }
        return this.c;
    }

    public int b() {
        return this.f2582f;
    }

    public float c() {
        return this.f2581e;
    }

    @Nullable
    public float[] d() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RoundingParams.class != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.b == roundingParams.b && this.f2580d == roundingParams.f2580d && Float.compare(roundingParams.f2581e, this.f2581e) == 0 && this.f2582f == roundingParams.f2582f && Float.compare(roundingParams.f2583g, this.f2583g) == 0 && this.a == roundingParams.a && this.f2584h == roundingParams.f2584h && this.f2585i == roundingParams.f2585i) {
            return Arrays.equals(this.c, roundingParams.c);
        }
        return false;
    }

    public int f() {
        return this.f2580d;
    }

    public float g() {
        return this.f2583g;
    }

    public boolean h() {
        return this.f2585i;
    }

    public int hashCode() {
        RoundingMethod roundingMethod = this.a;
        int hashCode = (((roundingMethod != null ? roundingMethod.hashCode() : 0) * 31) + (this.b ? 1 : 0)) * 31;
        float[] fArr = this.c;
        int hashCode2 = (((hashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.f2580d) * 31;
        float f2 = this.f2581e;
        int floatToIntBits = (((hashCode2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.f2582f) * 31;
        float f3 = this.f2583g;
        return ((((floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31) + (this.f2584h ? 1 : 0)) * 31) + (this.f2585i ? 1 : 0);
    }

    public boolean i() {
        return this.b;
    }

    public RoundingMethod j() {
        return this.a;
    }

    public boolean k() {
        return this.f2584h;
    }

    public RoundingParams l(@ColorInt int i2) {
        this.f2582f = i2;
        return this;
    }

    public RoundingParams m(float f2) {
        h.c(f2 >= 0.0f, "the border width cannot be < 0");
        this.f2581e = f2;
        return this;
    }

    public RoundingParams n(float f2, float f3, float f4, float f5) {
        float[] e2 = e();
        e2[1] = f2;
        e2[0] = f2;
        e2[3] = f3;
        e2[2] = f3;
        e2[5] = f4;
        e2[4] = f4;
        e2[7] = f5;
        e2[6] = f5;
        return this;
    }

    public RoundingParams o(float f2) {
        Arrays.fill(e(), f2);
        return this;
    }

    public RoundingParams p(@ColorInt int i2) {
        this.f2580d = i2;
        this.a = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public RoundingParams q(float f2) {
        h.c(f2 >= 0.0f, "the padding cannot be < 0");
        this.f2583g = f2;
        return this;
    }

    public RoundingParams r(boolean z) {
        this.b = z;
        return this;
    }
}
