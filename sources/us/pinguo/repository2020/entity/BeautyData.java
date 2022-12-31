package us.pinguo.repository2020.entity;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import java.util.List;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: BeautyData.kt */
/* loaded from: classes6.dex */
public final class BeautyData implements NoProguard {
    public static final int MAKEUP = 1;
    public static final int MEIYAN = 2;
    public static final int SHAPE = 0;
    private final int beautyIcon;
    private final String beautyKey;
    private final int beautyName;
    private final int beautyType;
    private final String bundlePath;
    private int colorIndex;
    private List<String> colorList;
    private ObservableInt currentValue;
    private final int defaultValue;
    private int groupId;
    private final boolean hasDefaultValue;
    private ObservableBoolean hasModify;
    private ObservableBoolean isDark;
    private ObservableBoolean isExtended;
    private boolean isGroup;
    private ObservableBoolean isSelected;
    private boolean isVip;
    private final int maxValue;
    private final int minValue;
    private final BeautyUnityEnumData unityEnumData;
    public static final BeautyType BeautyType = new BeautyType(null);
    private static final BeautyData NoneBeauty = new BeautyData(PortalFollowFeeds.TYPE_NONE, 0, 0, 1, new BeautyUnityEnumData(null, null, null, null, 8, null), "", 0, 0, false, 0, false, false, new ObservableInt(0), null, 0, 0, null, null, null, null, 1040384, null);

    /* compiled from: BeautyData.kt */
    /* loaded from: classes6.dex */
    public static final class BeautyType {
        private BeautyType() {
        }

        public /* synthetic */ BeautyType(o oVar) {
            this();
        }

        public final BeautyData getNoneBeauty() {
            return BeautyData.NoneBeauty;
        }
    }

    public BeautyData(String beautyKey, int i2, int i3, int i4, BeautyUnityEnumData unityEnumData, String bundlePath, int i5, int i6, boolean z, int i7, boolean z2, boolean z3, ObservableInt currentValue, List<String> list, int i8, int i9, ObservableBoolean isExtended, ObservableBoolean isSelected, ObservableBoolean isDark, ObservableBoolean hasModify) {
        s.h(beautyKey, "beautyKey");
        s.h(unityEnumData, "unityEnumData");
        s.h(bundlePath, "bundlePath");
        s.h(currentValue, "currentValue");
        s.h(isExtended, "isExtended");
        s.h(isSelected, "isSelected");
        s.h(isDark, "isDark");
        s.h(hasModify, "hasModify");
        this.beautyKey = beautyKey;
        this.beautyName = i2;
        this.beautyIcon = i3;
        this.beautyType = i4;
        this.unityEnumData = unityEnumData;
        this.bundlePath = bundlePath;
        this.minValue = i5;
        this.maxValue = i6;
        this.hasDefaultValue = z;
        this.defaultValue = i7;
        this.isGroup = z2;
        this.isVip = z3;
        this.currentValue = currentValue;
        this.colorList = list;
        this.groupId = i8;
        this.colorIndex = i9;
        this.isExtended = isExtended;
        this.isSelected = isSelected;
        this.isDark = isDark;
        this.hasModify = hasModify;
    }

    public final String component1() {
        return this.beautyKey;
    }

    public final int component10() {
        return this.defaultValue;
    }

    public final boolean component11() {
        return this.isGroup;
    }

    public final boolean component12() {
        return this.isVip;
    }

    public final ObservableInt component13() {
        return this.currentValue;
    }

    public final List<String> component14() {
        return this.colorList;
    }

    public final int component15() {
        return this.groupId;
    }

    public final int component16() {
        return this.colorIndex;
    }

    public final ObservableBoolean component17() {
        return this.isExtended;
    }

    public final ObservableBoolean component18() {
        return this.isSelected;
    }

    public final ObservableBoolean component19() {
        return this.isDark;
    }

    public final int component2() {
        return this.beautyName;
    }

    public final ObservableBoolean component20() {
        return this.hasModify;
    }

    public final int component3() {
        return this.beautyIcon;
    }

    public final int component4() {
        return this.beautyType;
    }

    public final BeautyUnityEnumData component5() {
        return this.unityEnumData;
    }

    public final String component6() {
        return this.bundlePath;
    }

    public final int component7() {
        return this.minValue;
    }

    public final int component8() {
        return this.maxValue;
    }

    public final boolean component9() {
        return this.hasDefaultValue;
    }

    public final BeautyData copy(String beautyKey, int i2, int i3, int i4, BeautyUnityEnumData unityEnumData, String bundlePath, int i5, int i6, boolean z, int i7, boolean z2, boolean z3, ObservableInt currentValue, List<String> list, int i8, int i9, ObservableBoolean isExtended, ObservableBoolean isSelected, ObservableBoolean isDark, ObservableBoolean hasModify) {
        s.h(beautyKey, "beautyKey");
        s.h(unityEnumData, "unityEnumData");
        s.h(bundlePath, "bundlePath");
        s.h(currentValue, "currentValue");
        s.h(isExtended, "isExtended");
        s.h(isSelected, "isSelected");
        s.h(isDark, "isDark");
        s.h(hasModify, "hasModify");
        return new BeautyData(beautyKey, i2, i3, i4, unityEnumData, bundlePath, i5, i6, z, i7, z2, z3, currentValue, list, i8, i9, isExtended, isSelected, isDark, hasModify);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BeautyData) {
            BeautyData beautyData = (BeautyData) obj;
            return s.c(this.beautyKey, beautyData.beautyKey) && this.beautyName == beautyData.beautyName && this.beautyIcon == beautyData.beautyIcon && this.beautyType == beautyData.beautyType && s.c(this.unityEnumData, beautyData.unityEnumData) && s.c(this.bundlePath, beautyData.bundlePath) && this.minValue == beautyData.minValue && this.maxValue == beautyData.maxValue && this.hasDefaultValue == beautyData.hasDefaultValue && this.defaultValue == beautyData.defaultValue && this.isGroup == beautyData.isGroup && this.isVip == beautyData.isVip && s.c(this.currentValue, beautyData.currentValue) && s.c(this.colorList, beautyData.colorList) && this.groupId == beautyData.groupId && this.colorIndex == beautyData.colorIndex && s.c(this.isExtended, beautyData.isExtended) && s.c(this.isSelected, beautyData.isSelected) && s.c(this.isDark, beautyData.isDark) && s.c(this.hasModify, beautyData.hasModify);
        }
        return false;
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

    public final int getBeautyType() {
        return this.beautyType;
    }

    public final String getBundlePath() {
        return this.bundlePath;
    }

    public final int getColorIndex() {
        return this.colorIndex;
    }

    public final List<String> getColorList() {
        return this.colorList;
    }

    public final ObservableInt getCurrentValue() {
        return this.currentValue;
    }

    public final int getDefaultValue() {
        return this.defaultValue;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final boolean getHasDefaultValue() {
        return this.hasDefaultValue;
    }

    public final ObservableBoolean getHasModify() {
        return this.hasModify;
    }

    public final String getKey() {
        boolean C;
        boolean C2;
        boolean C3;
        C = StringsKt__StringsKt.C(this.beautyKey, Material.MATERIAL_SELECT_NONE_FLAG, false, 2, null);
        if (C) {
            return "non_use";
        }
        C2 = StringsKt__StringsKt.C(this.beautyKey, "natural", false, 2, null);
        if (C2) {
            return "natural";
        }
        C3 = StringsKt__StringsKt.C(this.beautyKey, "°", false, 2, null);
        if (C3) {
            String str = this.beautyKey;
            String substring = str.substring(str.length() - 3, this.beautyKey.length());
            s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return this.beautyKey;
    }

    public final int getMaxValue() {
        return this.maxValue;
    }

    public final int getMinValue() {
        return this.minValue;
    }

    public final BeautyUnityEnumData getUnityEnumData() {
        return this.unityEnumData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((this.beautyKey.hashCode() * 31) + this.beautyName) * 31) + this.beautyIcon) * 31) + this.beautyType) * 31) + this.unityEnumData.hashCode()) * 31) + this.bundlePath.hashCode()) * 31) + this.minValue) * 31) + this.maxValue) * 31;
        boolean z = this.hasDefaultValue;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (((hashCode + i2) * 31) + this.defaultValue) * 31;
        boolean z2 = this.isGroup;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.isVip;
        int hashCode2 = (((i5 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.currentValue.hashCode()) * 31;
        List<String> list = this.colorList;
        return ((((((((((((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.groupId) * 31) + this.colorIndex) * 31) + this.isExtended.hashCode()) * 31) + this.isSelected.hashCode()) * 31) + this.isDark.hashCode()) * 31) + this.hasModify.hashCode();
    }

    public final ObservableBoolean isDark() {
        return this.isDark;
    }

    public final ObservableBoolean isExtended() {
        return this.isExtended;
    }

    public final boolean isGroup() {
        return this.isGroup;
    }

    public final ObservableBoolean isSelected() {
        return this.isSelected;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setColorIndex(int i2) {
        this.colorIndex = i2;
    }

    public final void setColorList(List<String> list) {
        this.colorList = list;
    }

    public final void setCurrentValue(ObservableInt observableInt) {
        s.h(observableInt, "<set-?>");
        this.currentValue = observableInt;
    }

    public final void setDark(ObservableBoolean observableBoolean) {
        s.h(observableBoolean, "<set-?>");
        this.isDark = observableBoolean;
    }

    public final void setExtended(ObservableBoolean observableBoolean) {
        s.h(observableBoolean, "<set-?>");
        this.isExtended = observableBoolean;
    }

    public final void setGroup(boolean z) {
        this.isGroup = z;
    }

    public final void setGroupId(int i2) {
        this.groupId = i2;
    }

    public final void setHasModify(ObservableBoolean observableBoolean) {
        s.h(observableBoolean, "<set-?>");
        this.hasModify = observableBoolean;
    }

    public final void setSelected(ObservableBoolean observableBoolean) {
        s.h(observableBoolean, "<set-?>");
        this.isSelected = observableBoolean;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    public String toString() {
        return "BeautyData(beautyKey=" + this.beautyKey + ", beautyName=" + this.beautyName + ", beautyIcon=" + this.beautyIcon + ", beautyType=" + this.beautyType + ", unityEnumData=" + this.unityEnumData + ", bundlePath=" + this.bundlePath + ", minValue=" + this.minValue + ", maxValue=" + this.maxValue + ", hasDefaultValue=" + this.hasDefaultValue + ", defaultValue=" + this.defaultValue + ", isGroup=" + this.isGroup + ", isVip=" + this.isVip + ", currentValue=" + this.currentValue + ", colorList=" + this.colorList + ", groupId=" + this.groupId + ", colorIndex=" + this.colorIndex + ", isExtended=" + this.isExtended + ", isSelected=" + this.isSelected + ", isDark=" + this.isDark + ", hasModify=" + this.hasModify + ')';
    }

    public /* synthetic */ BeautyData(String str, int i2, int i3, int i4, BeautyUnityEnumData beautyUnityEnumData, String str2, int i5, int i6, boolean z, int i7, boolean z2, boolean z3, ObservableInt observableInt, List list, int i8, int i9, ObservableBoolean observableBoolean, ObservableBoolean observableBoolean2, ObservableBoolean observableBoolean3, ObservableBoolean observableBoolean4, int i10, o oVar) {
        this(str, i2, i3, i4, beautyUnityEnumData, str2, i5, i6, z, i7, (i10 & 1024) != 0 ? false : z2, (i10 & 2048) != 0 ? false : z3, observableInt, (i10 & 8192) != 0 ? null : list, (i10 & 16384) != 0 ? -1 : i8, (32768 & i10) != 0 ? 0 : i9, (65536 & i10) != 0 ? new ObservableBoolean(false) : observableBoolean, (131072 & i10) != 0 ? new ObservableBoolean(false) : observableBoolean2, (262144 & i10) != 0 ? new ObservableBoolean(false) : observableBoolean3, (i10 & 524288) != 0 ? new ObservableBoolean(false) : observableBoolean4);
    }
}
