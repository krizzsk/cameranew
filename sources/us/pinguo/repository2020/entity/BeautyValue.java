package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BeautyParam.kt */
/* loaded from: classes6.dex */
public final class BeautyValue implements NoProguard {
    private String value;

    public BeautyValue(String value) {
        s.h(value, "value");
        this.value = value;
    }

    public static /* synthetic */ BeautyValue copy$default(BeautyValue beautyValue, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = beautyValue.value;
        }
        return beautyValue.copy(str);
    }

    public final String component1() {
        return this.value;
    }

    public final BeautyValue copy(String value) {
        s.h(value, "value");
        return new BeautyValue(value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BeautyValue) && s.c(this.value, ((BeautyValue) obj).value);
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public final void setValue(String str) {
        s.h(str, "<set-?>");
        this.value = str;
    }

    public String toString() {
        return "BeautyValue(value=" + this.value + ')';
    }
}
