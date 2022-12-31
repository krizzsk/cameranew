package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: UnityFilterItemTempleIndex.kt */
/* loaded from: classes6.dex */
public final class UnityFilterItemTemplateIndex implements NoProguard {
    private final TemplateConfig config;
    private final Template template;

    public UnityFilterItemTemplateIndex(TemplateConfig templateConfig, Template template) {
        this.config = templateConfig;
        this.template = template;
    }

    public static /* synthetic */ UnityFilterItemTemplateIndex copy$default(UnityFilterItemTemplateIndex unityFilterItemTemplateIndex, TemplateConfig templateConfig, Template template, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            templateConfig = unityFilterItemTemplateIndex.config;
        }
        if ((i2 & 2) != 0) {
            template = unityFilterItemTemplateIndex.template;
        }
        return unityFilterItemTemplateIndex.copy(templateConfig, template);
    }

    public final TemplateConfig component1() {
        return this.config;
    }

    public final Template component2() {
        return this.template;
    }

    public final UnityFilterItemTemplateIndex copy(TemplateConfig templateConfig, Template template) {
        return new UnityFilterItemTemplateIndex(templateConfig, template);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnityFilterItemTemplateIndex) {
            UnityFilterItemTemplateIndex unityFilterItemTemplateIndex = (UnityFilterItemTemplateIndex) obj;
            return s.c(this.config, unityFilterItemTemplateIndex.config) && s.c(this.template, unityFilterItemTemplateIndex.template);
        }
        return false;
    }

    public final TemplateConfig getConfig() {
        return this.config;
    }

    public final Template getTemplate() {
        return this.template;
    }

    public int hashCode() {
        TemplateConfig templateConfig = this.config;
        int hashCode = (templateConfig == null ? 0 : templateConfig.hashCode()) * 31;
        Template template = this.template;
        return hashCode + (template != null ? template.hashCode() : 0);
    }

    public String toString() {
        return "UnityFilterItemTemplateIndex(config=" + this.config + ", template=" + this.template + ')';
    }
}
