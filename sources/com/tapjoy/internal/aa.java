package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum e uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class aa {
    public static final aa a;
    public static final aa b;
    public static final aa c;

    /* renamed from: d  reason: collision with root package name */
    public static final aa f7286d;

    /* renamed from: e  reason: collision with root package name */
    public static final aa f7287e;

    /* renamed from: f  reason: collision with root package name */
    public static final aa f7288f;

    /* renamed from: g  reason: collision with root package name */
    public static final aa f7289g;

    /* renamed from: h  reason: collision with root package name */
    public static final aa f7290h;

    /* renamed from: i  reason: collision with root package name */
    public static final aa f7291i;

    /* renamed from: j  reason: collision with root package name */
    public static final aa f7292j;

    /* renamed from: k  reason: collision with root package name */
    public static final aa f7293k;

    /* renamed from: l  reason: collision with root package name */
    public static final aa f7294l;
    public static final aa m;
    public static final aa n;
    public static final aa o;
    public static final aa p;
    private static final /* synthetic */ aa[] s;
    private final aa q;
    private final aa r;

    static {
        aa aaVar = new aa("UNSPECIFIED", 0);
        a = aaVar;
        aa aaVar2 = new aa("PORTRAIT", 1);
        b = aaVar2;
        aa aaVar3 = new aa("LANDSCAPE", 2);
        c = aaVar3;
        aa aaVar4 = new aa("SQUARE", 3);
        f7286d = aaVar4;
        aa aaVar5 = new aa("NATURAL_PORTRAIT", 4, aaVar2);
        f7287e = aaVar5;
        aa aaVar6 = new aa("RIGHT_LANDSCAPE", 5, aaVar3, aaVar5);
        f7288f = aaVar6;
        aa aaVar7 = new aa("REVERSE_PORTRAIT", 6, aaVar2, aaVar5);
        f7289g = aaVar7;
        aa aaVar8 = new aa("LEFT_LANDSCAPE", 7, aaVar3, aaVar5);
        f7290h = aaVar8;
        aa aaVar9 = new aa("NATURAL_LANDSCAPE", 8, aaVar3);
        f7291i = aaVar9;
        aa aaVar10 = new aa("RIGHT_PORTRAIT", 9, aaVar2, aaVar9);
        f7292j = aaVar10;
        aa aaVar11 = new aa("REVERSE_LANDSCAPE", 10, aaVar3, aaVar9);
        f7293k = aaVar11;
        aa aaVar12 = new aa("LEFT_PORTRAIT", 11, aaVar2, aaVar9);
        f7294l = aaVar12;
        aa aaVar13 = new aa("NATURAL_SQUARE", 12, aaVar4);
        m = aaVar13;
        aa aaVar14 = new aa("RIGHT_SQUARE", 13, aaVar4, aaVar13);
        n = aaVar14;
        aa aaVar15 = new aa("REVERSE_SQUARE", 14, aaVar4, aaVar13);
        o = aaVar15;
        aa aaVar16 = new aa("LEFT_SQUARE", 15, aaVar4, aaVar13);
        p = aaVar16;
        s = new aa[]{aaVar, aaVar2, aaVar3, aaVar4, aaVar5, aaVar6, aaVar7, aaVar8, aaVar9, aaVar10, aaVar11, aaVar12, aaVar13, aaVar14, aaVar15, aaVar16};
    }

    private aa(String str, int i2) {
        this.q = this;
        this.r = null;
    }

    public static aa valueOf(String str) {
        return (aa) Enum.valueOf(aa.class, str);
    }

    public static aa[] values() {
        return (aa[]) s.clone();
    }

    public final boolean a() {
        aa aaVar = b;
        return this == aaVar || this.q == aaVar;
    }

    public final boolean b() {
        aa aaVar = c;
        return this == aaVar || this.q == aaVar;
    }

    public final int c() {
        if (this.r != null) {
            return ordinal() - this.r.ordinal();
        }
        return 0;
    }

    public static aa a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.x = defaultDisplay.getWidth();
            point.y = defaultDisplay.getHeight();
        }
        int i2 = point.x;
        int i3 = point.y;
        if (i2 < i3) {
            int i4 = rotation & 3;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return f7287e;
                    }
                    return f7294l;
                }
                return f7289g;
            }
            return f7292j;
        } else if (i2 > i3) {
            int i5 = rotation & 3;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        return f7291i;
                    }
                    return f7290h;
                }
                return f7293k;
            }
            return f7288f;
        } else {
            int i6 = rotation & 3;
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        return m;
                    }
                    return p;
                }
                return o;
            }
            return n;
        }
    }

    public static aa b(Context context) {
        int i2 = context.getResources().getConfiguration().orientation;
        if (i2 != 1) {
            if (i2 != 2) {
                return a;
            }
            return c;
        }
        return b;
    }

    private aa(String str, int i2, aa aaVar) {
        this.q = aaVar;
        this.r = this;
    }

    private aa(String str, int i2, aa aaVar, aa aaVar2) {
        this.q = aaVar;
        this.r = aaVar2;
    }
}
