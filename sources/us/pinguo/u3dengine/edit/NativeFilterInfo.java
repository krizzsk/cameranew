package us.pinguo.u3dengine.edit;

import kotlin.jvm.internal.s;
/* compiled from: UnityEditData.kt */
/* loaded from: classes6.dex */
public final class NativeFilterInfo {
    private String effectPath;
    private String paramPath;
    private String shaderPath;

    public NativeFilterInfo(String effectPath, String paramPath, String shaderPath) {
        s.h(effectPath, "effectPath");
        s.h(paramPath, "paramPath");
        s.h(shaderPath, "shaderPath");
        this.effectPath = effectPath;
        this.paramPath = paramPath;
        this.shaderPath = shaderPath;
    }

    public static /* synthetic */ NativeFilterInfo copy$default(NativeFilterInfo nativeFilterInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = nativeFilterInfo.effectPath;
        }
        if ((i2 & 2) != 0) {
            str2 = nativeFilterInfo.paramPath;
        }
        if ((i2 & 4) != 0) {
            str3 = nativeFilterInfo.shaderPath;
        }
        return nativeFilterInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.effectPath;
    }

    public final String component2() {
        return this.paramPath;
    }

    public final String component3() {
        return this.shaderPath;
    }

    public final NativeFilterInfo copy(String effectPath, String paramPath, String shaderPath) {
        s.h(effectPath, "effectPath");
        s.h(paramPath, "paramPath");
        s.h(shaderPath, "shaderPath");
        return new NativeFilterInfo(effectPath, paramPath, shaderPath);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NativeFilterInfo) {
            NativeFilterInfo nativeFilterInfo = (NativeFilterInfo) obj;
            return s.c(this.effectPath, nativeFilterInfo.effectPath) && s.c(this.paramPath, nativeFilterInfo.paramPath) && s.c(this.shaderPath, nativeFilterInfo.shaderPath);
        }
        return false;
    }

    public final String getEffectPath() {
        return this.effectPath;
    }

    public final String getParamPath() {
        return this.paramPath;
    }

    public final String getShaderPath() {
        return this.shaderPath;
    }

    public int hashCode() {
        return (((this.effectPath.hashCode() * 31) + this.paramPath.hashCode()) * 31) + this.shaderPath.hashCode();
    }

    public final void setEffectPath(String str) {
        s.h(str, "<set-?>");
        this.effectPath = str;
    }

    public final void setParamPath(String str) {
        s.h(str, "<set-?>");
        this.paramPath = str;
    }

    public final void setShaderPath(String str) {
        s.h(str, "<set-?>");
        this.shaderPath = str;
    }

    public String toString() {
        return "NativeFilterInfo(effectPath=" + this.effectPath + ", paramPath=" + this.paramPath + ", shaderPath=" + this.shaderPath + ')';
    }
}
