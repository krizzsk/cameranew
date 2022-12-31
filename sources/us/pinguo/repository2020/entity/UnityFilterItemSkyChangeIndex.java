package us.pinguo.repository2020.entity;

import java.util.Arrays;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: UnityFilterItemSkyChangeIndex.kt */
/* loaded from: classes6.dex */
public final class UnityFilterItemSkyChangeIndex implements NoProguard {
    private final SkyEffect[] effectList;
    private final Integer renderOrder;
    private final Integer skyAlignment;

    public UnityFilterItemSkyChangeIndex(Integer num, Integer num2, SkyEffect[] skyEffectArr) {
        this.renderOrder = num;
        this.skyAlignment = num2;
        this.effectList = skyEffectArr;
    }

    public static /* synthetic */ UnityFilterItemSkyChangeIndex copy$default(UnityFilterItemSkyChangeIndex unityFilterItemSkyChangeIndex, Integer num, Integer num2, SkyEffect[] skyEffectArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = unityFilterItemSkyChangeIndex.renderOrder;
        }
        if ((i2 & 2) != 0) {
            num2 = unityFilterItemSkyChangeIndex.skyAlignment;
        }
        if ((i2 & 4) != 0) {
            skyEffectArr = unityFilterItemSkyChangeIndex.effectList;
        }
        return unityFilterItemSkyChangeIndex.copy(num, num2, skyEffectArr);
    }

    public final Integer component1() {
        return this.renderOrder;
    }

    public final Integer component2() {
        return this.skyAlignment;
    }

    public final SkyEffect[] component3() {
        return this.effectList;
    }

    public final UnityFilterItemSkyChangeIndex copy(Integer num, Integer num2, SkyEffect[] skyEffectArr) {
        return new UnityFilterItemSkyChangeIndex(num, num2, skyEffectArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnityFilterItemSkyChangeIndex) {
            UnityFilterItemSkyChangeIndex unityFilterItemSkyChangeIndex = (UnityFilterItemSkyChangeIndex) obj;
            return s.c(this.renderOrder, unityFilterItemSkyChangeIndex.renderOrder) && s.c(this.skyAlignment, unityFilterItemSkyChangeIndex.skyAlignment) && s.c(this.effectList, unityFilterItemSkyChangeIndex.effectList);
        }
        return false;
    }

    public final SkyEffect[] getEffectList() {
        return this.effectList;
    }

    public final Integer getRenderOrder() {
        return this.renderOrder;
    }

    public final Integer getSkyAlignment() {
        return this.skyAlignment;
    }

    public int hashCode() {
        Integer num = this.renderOrder;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.skyAlignment;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        SkyEffect[] skyEffectArr = this.effectList;
        return hashCode2 + (skyEffectArr != null ? Arrays.hashCode(skyEffectArr) : 0);
    }

    public String toString() {
        return "UnityFilterItemSkyChangeIndex(renderOrder=" + this.renderOrder + ", skyAlignment=" + this.skyAlignment + ", effectList=" + Arrays.toString(this.effectList) + ')';
    }
}
