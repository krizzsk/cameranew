package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemTempleIndex.kt */
/* loaded from: classes6.dex */
public final class TemplateConfig {
    private final String backgroundColor;
    private final Boolean isEnableGesture;

    public TemplateConfig(Boolean bool, String str) {
        this.isEnableGesture = bool;
        this.backgroundColor = str;
    }

    public static /* synthetic */ TemplateConfig copy$default(TemplateConfig templateConfig, Boolean bool, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = templateConfig.isEnableGesture;
        }
        if ((i2 & 2) != 0) {
            str = templateConfig.backgroundColor;
        }
        return templateConfig.copy(bool, str);
    }

    public final Boolean component1() {
        return this.isEnableGesture;
    }

    public final String component2() {
        return this.backgroundColor;
    }

    public final TemplateConfig copy(Boolean bool, String str) {
        return new TemplateConfig(bool, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TemplateConfig) {
            TemplateConfig templateConfig = (TemplateConfig) obj;
            return s.c(this.isEnableGesture, templateConfig.isEnableGesture) && s.c(this.backgroundColor, templateConfig.backgroundColor);
        }
        return false;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public int hashCode() {
        Boolean bool = this.isEnableGesture;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.backgroundColor;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final Boolean isEnableGesture() {
        return this.isEnableGesture;
    }

    public String toString() {
        return "TemplateConfig(isEnableGesture=" + this.isEnableGesture + ", backgroundColor=" + ((Object) this.backgroundColor) + ')';
    }
}
