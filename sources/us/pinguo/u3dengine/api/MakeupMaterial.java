package us.pinguo.u3dengine.api;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: UnityMethodData.kt */
/* loaded from: classes6.dex */
public final class MakeupMaterial {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_COLOR = "#FFFFFF";
    private final String bundlePathWithType;
    private final String colorHex;
    private String deformation;
    private float value;

    /* compiled from: UnityMethodData.kt */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public MakeupMaterial(String bundlePathWithType, String colorHex, float f2, String str) {
        s.h(bundlePathWithType, "bundlePathWithType");
        s.h(colorHex, "colorHex");
        this.bundlePathWithType = bundlePathWithType;
        this.colorHex = colorHex;
        this.value = f2;
        this.deformation = str;
    }

    public final String getDeformation() {
        return this.deformation;
    }

    public final float getValue() {
        return this.value;
    }

    public final void setDeformation(String str) {
        this.deformation = str;
    }

    public final void setValue(float f2) {
        this.value = f2;
    }

    public final String toUnityParam$u3dengine_release() {
        String str = this.deformation;
        String q = str == null ? "" : s.q(";", str);
        return this.bundlePathWithType + ',' + this.colorHex + ',' + this.value + q;
    }

    public /* synthetic */ MakeupMaterial(String str, String str2, float f2, String str3, int i2, o oVar) {
        this(str, str2, (i2 & 4) != 0 ? 1.0f : f2, (i2 & 8) != 0 ? null : str3);
    }
}
