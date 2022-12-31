package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: UnityFilterItemSkyChangeIndex.kt */
/* loaded from: classes6.dex */
public final class SkyEffect {
    private final Integer defaultValue;
    private final String key;
    private final Integer max;
    private final Integer min;
    private final String type;
    private final Integer value;

    public SkyEffect(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4) {
        this.type = str;
        this.key = str2;
        this.min = num;
        this.max = num2;
        this.defaultValue = num3;
        this.value = num4;
    }

    public static /* synthetic */ SkyEffect copy$default(SkyEffect skyEffect, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = skyEffect.type;
        }
        if ((i2 & 2) != 0) {
            str2 = skyEffect.key;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            num = skyEffect.min;
        }
        Integer num5 = num;
        if ((i2 & 8) != 0) {
            num2 = skyEffect.max;
        }
        Integer num6 = num2;
        if ((i2 & 16) != 0) {
            num3 = skyEffect.defaultValue;
        }
        Integer num7 = num3;
        if ((i2 & 32) != 0) {
            num4 = skyEffect.value;
        }
        return skyEffect.copy(str, str3, num5, num6, num7, num4);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.key;
    }

    public final Integer component3() {
        return this.min;
    }

    public final Integer component4() {
        return this.max;
    }

    public final Integer component5() {
        return this.defaultValue;
    }

    public final Integer component6() {
        return this.value;
    }

    public final SkyEffect copy(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4) {
        return new SkyEffect(str, str2, num, num2, num3, num4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkyEffect) {
            SkyEffect skyEffect = (SkyEffect) obj;
            return s.c(this.type, skyEffect.type) && s.c(this.key, skyEffect.key) && s.c(this.min, skyEffect.min) && s.c(this.max, skyEffect.max) && s.c(this.defaultValue, skyEffect.defaultValue) && s.c(this.value, skyEffect.value);
        }
        return false;
    }

    public final Integer getDefaultValue() {
        return this.defaultValue;
    }

    public final String getKey() {
        return this.key;
    }

    public final Integer getMax() {
        return this.max;
    }

    public final Integer getMin() {
        return this.min;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.key;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.min;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.max;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.defaultValue;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.value;
        return hashCode5 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        return "SkyEffect(type=" + ((Object) this.type) + ", key=" + ((Object) this.key) + ", min=" + this.min + ", max=" + this.max + ", defaultValue=" + this.defaultValue + ", value=" + this.value + ')';
    }
}
