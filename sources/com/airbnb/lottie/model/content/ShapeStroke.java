package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.t.b.r;
import java.util.List;
/* loaded from: classes.dex */
public class ShapeStroke implements b {
    private final String a;
    @Nullable
    private final com.airbnb.lottie.model.h.b b;
    private final List<com.airbnb.lottie.model.h.b> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.a f390d;

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.d f391e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f392f;

    /* renamed from: g  reason: collision with root package name */
    private final LineCapType f393g;

    /* renamed from: h  reason: collision with root package name */
    private final LineJoinType f394h;

    /* renamed from: i  reason: collision with root package name */
    private final float f395i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f396j;

    /* loaded from: classes.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i2 = a.a[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i2 = a.b[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable com.airbnb.lottie.model.h.b bVar, List<com.airbnb.lottie.model.h.b> list, com.airbnb.lottie.model.h.a aVar, com.airbnb.lottie.model.h.d dVar, com.airbnb.lottie.model.h.b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f2, boolean z) {
        this.a = str;
        this.b = bVar;
        this.c = list;
        this.f390d = aVar;
        this.f391e = dVar;
        this.f392f = bVar2;
        this.f393g = lineCapType;
        this.f394h = lineJoinType;
        this.f395i = f2;
        this.f396j = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(gVar, aVar, this);
    }

    public LineCapType b() {
        return this.f393g;
    }

    public com.airbnb.lottie.model.h.a c() {
        return this.f390d;
    }

    public com.airbnb.lottie.model.h.b d() {
        return this.b;
    }

    public LineJoinType e() {
        return this.f394h;
    }

    public List<com.airbnb.lottie.model.h.b> f() {
        return this.c;
    }

    public float g() {
        return this.f395i;
    }

    public String h() {
        return this.a;
    }

    public com.airbnb.lottie.model.h.d i() {
        return this.f391e;
    }

    public com.airbnb.lottie.model.h.b j() {
        return this.f392f;
    }

    public boolean k() {
        return this.f396j;
    }
}
