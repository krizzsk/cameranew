package us.pinguo.edit2020.viewmodel.module;

import android.content.Context;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum SMALL uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: EditBodyShapeModule.kt */
/* loaded from: classes4.dex */
public final class BoldType {
    private static final /* synthetic */ BoldType[] $VALUES;
    public static final BoldType BOLD;
    public static final BoldType BOLD2;
    public static final BoldType BOLD3;
    public static final BoldType BOLD_NARROW;
    public static final BoldType BOLD_PUSH_BOLD;
    public static final BoldType BOLD_PUSH_BOLD2;
    public static final BoldType BOLD_PUSH_BOLD3;
    public static final BoldType BOLD_PUSH_NORMAL;
    public static final BoldType BOLD_PUSH_SMALL;
    public static final BoldType BOLD_SWELL;
    public static final BoldType NORMAL;
    public static final BoldType SMALL;
    private float brushSize;
    private float indicatorSize;
    private float scaleFactor;

    private static final /* synthetic */ BoldType[] $values() {
        return new BoldType[]{SMALL, NORMAL, BOLD, BOLD2, BOLD3, BOLD_SWELL, BOLD_NARROW, BOLD_PUSH_SMALL, BOLD_PUSH_NORMAL, BOLD_PUSH_BOLD, BOLD_PUSH_BOLD2, BOLD_PUSH_BOLD3};
    }

    static {
        Context b = us.pinguo.foundation.e.b();
        s.g(b, "getAppContext()");
        SMALL = new BoldType("SMALL", 0, 0.1f, 0.2564f, us.pinguo.util.g.b(b, 20.0f));
        Context b2 = us.pinguo.foundation.e.b();
        s.g(b2, "getAppContext()");
        NORMAL = new BoldType("NORMAL", 1, 0.1f, 0.4103f, us.pinguo.util.g.b(b2, 32.0f));
        Context b3 = us.pinguo.foundation.e.b();
        s.g(b3, "getAppContext()");
        BOLD = new BoldType("BOLD", 2, 0.1f, 0.6153f, us.pinguo.util.g.b(b3, 48.0f));
        Context b4 = us.pinguo.foundation.e.b();
        s.g(b4, "getAppContext()");
        BOLD2 = new BoldType("BOLD2", 3, 0.1f, 0.8205f, us.pinguo.util.g.b(b4, 64.0f));
        BOLD3 = new BoldType("BOLD3", 4, 0.1f, 1.0f, us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.bold_tip_size_max_in_discrete_mode));
        BOLD_SWELL = new BoldType("BOLD_SWELL", 5, 1.0f, 0.0f, 0.0f);
        BOLD_NARROW = new BoldType("BOLD_NARROW", 6, 1.0f, 0.0f, 0.0f);
        Context b5 = us.pinguo.foundation.e.b();
        s.g(b5, "getAppContext()");
        BOLD_PUSH_SMALL = new BoldType("BOLD_PUSH_SMALL", 7, 0.1f, 0.3212f, us.pinguo.util.g.b(b5, 44.0f));
        Context b6 = us.pinguo.foundation.e.b();
        s.g(b6, "getAppContext()");
        BOLD_PUSH_NORMAL = new BoldType("BOLD_PUSH_NORMAL", 8, 0.1f, 0.5547f, us.pinguo.util.g.b(b6, 76.0f));
        Context b7 = us.pinguo.foundation.e.b();
        s.g(b7, "getAppContext()");
        BOLD_PUSH_BOLD = new BoldType("BOLD_PUSH_BOLD", 9, 0.1f, 0.6569f, us.pinguo.util.g.b(b7, 90.0f));
        Context b8 = us.pinguo.foundation.e.b();
        s.g(b8, "getAppContext()");
        BOLD_PUSH_BOLD2 = new BoldType("BOLD_PUSH_BOLD2", 10, 0.1f, 0.7445f, us.pinguo.util.g.b(b8, 102.0f));
        BOLD_PUSH_BOLD3 = new BoldType("BOLD_PUSH_BOLD3", 11, 0.1f, 1.0f, us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.bold_tip_size_max_in_push_mode));
        $VALUES = $values();
    }

    private BoldType(String str, int i2, float f2, float f3, float f4) {
        this.brushSize = f2;
        this.scaleFactor = f3;
        this.indicatorSize = f4;
    }

    public static BoldType valueOf(String str) {
        return (BoldType) Enum.valueOf(BoldType.class, str);
    }

    public static BoldType[] values() {
        return (BoldType[]) $VALUES.clone();
    }

    public final float getBrushSize() {
        return this.brushSize;
    }

    public final float getIndicatorSize() {
        return this.indicatorSize;
    }

    public final float getScaleFactor() {
        return this.scaleFactor;
    }

    public final void setBrushSize(float f2) {
        this.brushSize = f2;
    }

    public final void setIndicatorSize(float f2) {
        this.indicatorSize = f2;
    }

    public final void setScaleFactor(float f2) {
        this.scaleFactor = f2;
    }
}
