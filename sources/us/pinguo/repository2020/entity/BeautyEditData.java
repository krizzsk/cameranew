package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BeautyEditData.kt */
/* loaded from: classes6.dex */
public final class BeautyEditData implements NoProguard {
    private int backupValue;
    private int beautyIcon;
    private final String beautyKey;
    private int beautyName;
    private int currentValue;
    private final int defaultValue;
    private final boolean isVip;
    private final int maxValue;
    private final int minValue;
    private final boolean needFace;
    private final BeautyUnityEnumData unityEnumData;

    public BeautyEditData(String beautyKey, int i2, int i3, int i4, int i5, int i6, int i7, BeautyUnityEnumData unityEnumData, boolean z, boolean z2, int i8) {
        s.h(beautyKey, "beautyKey");
        s.h(unityEnumData, "unityEnumData");
        this.beautyKey = beautyKey;
        this.beautyName = i2;
        this.beautyIcon = i3;
        this.minValue = i4;
        this.maxValue = i5;
        this.defaultValue = i6;
        this.currentValue = i7;
        this.unityEnumData = unityEnumData;
        this.isVip = z;
        this.needFace = z2;
        this.backupValue = i8;
    }

    public final String component1() {
        return this.beautyKey;
    }

    public final boolean component10() {
        return this.needFace;
    }

    public final int component11() {
        return this.backupValue;
    }

    public final int component2() {
        return this.beautyName;
    }

    public final int component3() {
        return this.beautyIcon;
    }

    public final int component4() {
        return this.minValue;
    }

    public final int component5() {
        return this.maxValue;
    }

    public final int component6() {
        return this.defaultValue;
    }

    public final int component7() {
        return this.currentValue;
    }

    public final BeautyUnityEnumData component8() {
        return this.unityEnumData;
    }

    public final boolean component9() {
        return this.isVip;
    }

    public final BeautyEditData copy(String beautyKey, int i2, int i3, int i4, int i5, int i6, int i7, BeautyUnityEnumData unityEnumData, boolean z, boolean z2, int i8) {
        s.h(beautyKey, "beautyKey");
        s.h(unityEnumData, "unityEnumData");
        return new BeautyEditData(beautyKey, i2, i3, i4, i5, i6, i7, unityEnumData, z, z2, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BeautyEditData) {
            BeautyEditData beautyEditData = (BeautyEditData) obj;
            return s.c(this.beautyKey, beautyEditData.beautyKey) && this.beautyName == beautyEditData.beautyName && this.beautyIcon == beautyEditData.beautyIcon && this.minValue == beautyEditData.minValue && this.maxValue == beautyEditData.maxValue && this.defaultValue == beautyEditData.defaultValue && this.currentValue == beautyEditData.currentValue && s.c(this.unityEnumData, beautyEditData.unityEnumData) && this.isVip == beautyEditData.isVip && this.needFace == beautyEditData.needFace && this.backupValue == beautyEditData.backupValue;
        }
        return false;
    }

    public final int getBackupValue() {
        return this.backupValue;
    }

    public final int getBeautyIcon() {
        return this.beautyIcon;
    }

    public final String getBeautyKey() {
        return this.beautyKey;
    }

    public final int getBeautyName() {
        return this.beautyName;
    }

    public final int getCurrentValue() {
        return this.currentValue;
    }

    public final int getDefaultValue() {
        return this.defaultValue;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final int getMinValue() {
        return this.minValue;
    }

    public final boolean getNeedFace() {
        return this.needFace;
    }

    public final BeautyUnityEnumData getUnityEnumData() {
        return this.unityEnumData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((this.beautyKey.hashCode() * 31) + this.beautyName) * 31) + this.beautyIcon) * 31) + this.minValue) * 31) + this.maxValue) * 31) + this.defaultValue) * 31) + this.currentValue) * 31) + this.unityEnumData.hashCode()) * 31;
        boolean z = this.isVip;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode + i2) * 31;
        boolean z2 = this.needFace;
        return ((i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.backupValue;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setBackupValue(int i2) {
        this.backupValue = i2;
    }

    public final void setBeautyIcon(int i2) {
        this.beautyIcon = i2;
    }

    public final void setBeautyName(int i2) {
        this.beautyName = i2;
    }

    public final void setCurrentValue(int i2) {
        this.currentValue = i2;
    }

    public String toString() {
        return "BeautyEditData(beautyKey=" + this.beautyKey + ", beautyName=" + this.beautyName + ", beautyIcon=" + this.beautyIcon + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", defaultValue=" + this.defaultValue + ", currentValue=" + this.currentValue + ", unityEnumData=" + this.unityEnumData + ", isVip=" + this.isVip + ", needFace=" + this.needFace + ", backupValue=" + this.backupValue + ')';
    }

    public /* synthetic */ BeautyEditData(String str, int i2, int i3, int i4, int i5, int i6, int i7, BeautyUnityEnumData beautyUnityEnumData, boolean z, boolean z2, int i8, int i9, o oVar) {
        this(str, i2, i3, i4, i5, i6, i7, beautyUnityEnumData, (i9 & 256) != 0 ? false : z, (i9 & 512) != 0 ? true : z2, (i9 & 1024) != 0 ? -1 : i8);
    }
}
