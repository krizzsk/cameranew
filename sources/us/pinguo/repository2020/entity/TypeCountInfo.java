package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
/* compiled from: TypeCountInfo.kt */
/* loaded from: classes6.dex */
public final class TypeCountInfo {
    private final Integer gif;
    private final Integer st;

    public TypeCountInfo(Integer num, Integer num2) {
        this.st = num;
        this.gif = num2;
    }

    public static /* synthetic */ TypeCountInfo copy$default(TypeCountInfo typeCountInfo, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = typeCountInfo.st;
        }
        if ((i2 & 2) != 0) {
            num2 = typeCountInfo.gif;
        }
        return typeCountInfo.copy(num, num2);
    }

    public final Integer component1() {
        return this.st;
    }

    public final Integer component2() {
        return this.gif;
    }

    public final TypeCountInfo copy(Integer num, Integer num2) {
        return new TypeCountInfo(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TypeCountInfo) {
            TypeCountInfo typeCountInfo = (TypeCountInfo) obj;
            return s.c(this.st, typeCountInfo.st) && s.c(this.gif, typeCountInfo.gif);
        }
        return false;
    }

    public final Integer getGif() {
        return this.gif;
    }

    public final Integer getSt() {
        return this.st;
    }

    public int hashCode() {
        Integer num = this.st;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.gif;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "TypeCountInfo(st=" + this.st + ", gif=" + this.gif + ')';
    }
}
