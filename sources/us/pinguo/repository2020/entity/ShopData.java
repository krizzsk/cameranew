package us.pinguo.repository2020.entity;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ShopData.kt */
/* loaded from: classes6.dex */
public final class ShopData implements NoProguard {
    private final Integer interval;
    private final Package[] packages;
    private final Scene[] scenes;
    private final Integer version;

    public ShopData(Package[] packageArr, Scene[] sceneArr, Integer num, Integer num2) {
        this.packages = packageArr;
        this.scenes = sceneArr;
        this.version = num;
        this.interval = num2;
    }

    public static /* synthetic */ ShopData copy$default(ShopData shopData, Package[] packageArr, Scene[] sceneArr, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            packageArr = shopData.packages;
        }
        if ((i2 & 2) != 0) {
            sceneArr = shopData.scenes;
        }
        if ((i2 & 4) != 0) {
            num = shopData.version;
        }
        if ((i2 & 8) != 0) {
            num2 = shopData.interval;
        }
        return shopData.copy(packageArr, sceneArr, num, num2);
    }

    public final Package[] component1() {
        return this.packages;
    }

    public final Scene[] component2() {
        return this.scenes;
    }

    public final Integer component3() {
        return this.version;
    }

    public final Integer component4() {
        return this.interval;
    }

    public final ShopData copy(Package[] packageArr, Scene[] sceneArr, Integer num, Integer num2) {
        return new ShopData(packageArr, sceneArr, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(ShopData.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.entity.ShopData");
            ShopData shopData = (ShopData) obj;
            Package[] packageArr = this.packages;
            if (packageArr != null) {
                Package[] packageArr2 = shopData.packages;
                if (packageArr2 == null || !Arrays.equals(packageArr, packageArr2)) {
                    return false;
                }
            } else if (shopData.packages != null) {
                return false;
            }
            Scene[] sceneArr = this.scenes;
            if (sceneArr != null) {
                Scene[] sceneArr2 = shopData.scenes;
                if (sceneArr2 == null || !Arrays.equals(sceneArr, sceneArr2)) {
                    return false;
                }
            } else if (shopData.scenes != null) {
                return false;
            }
            return s.c(this.version, shopData.version) && s.c(this.interval, shopData.interval);
        }
        return false;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final Package[] getPackages() {
        return this.packages;
    }

    public final Scene[] getScenes() {
        return this.scenes;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        Package[] packageArr = this.packages;
        int hashCode = (packageArr == null ? 0 : Arrays.hashCode(packageArr)) * 31;
        Scene[] sceneArr = this.scenes;
        int hashCode2 = (hashCode + (sceneArr == null ? 0 : Arrays.hashCode(sceneArr))) * 31;
        Integer num = this.version;
        int intValue = (hashCode2 + (num == null ? 0 : num.intValue())) * 31;
        Integer num2 = this.interval;
        return intValue + (num2 != null ? num2.intValue() : 0);
    }

    public String toString() {
        return "ShopData(packages=" + Arrays.toString(this.packages) + ", scenes=" + Arrays.toString(this.scenes) + ", version=" + this.version + ", interval=" + this.interval + ')';
    }
}
