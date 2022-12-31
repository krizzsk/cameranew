package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.performance.entity.GpuLadderInfo;
/* compiled from: ServiceControlSwitch.kt */
/* loaded from: classes6.dex */
public final class ServiceControlSwitch implements NoProguard {
    private final Integer coupon_on;
    private GpuLadderInfo gpuLadderData;
    private final Integer login_on;
    private final Long privacyUpdateDate;
    private final Integer recommendSwitchOn;
    private final Long serviceUpdateDate;

    public ServiceControlSwitch(Integer num, Integer num2, Long l2, Long l3, GpuLadderInfo gpuLadderInfo, Integer num3) {
        this.coupon_on = num;
        this.login_on = num2;
        this.privacyUpdateDate = l2;
        this.serviceUpdateDate = l3;
        this.gpuLadderData = gpuLadderInfo;
        this.recommendSwitchOn = num3;
    }

    public static /* synthetic */ ServiceControlSwitch copy$default(ServiceControlSwitch serviceControlSwitch, Integer num, Integer num2, Long l2, Long l3, GpuLadderInfo gpuLadderInfo, Integer num3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = serviceControlSwitch.coupon_on;
        }
        if ((i2 & 2) != 0) {
            num2 = serviceControlSwitch.login_on;
        }
        Integer num4 = num2;
        if ((i2 & 4) != 0) {
            l2 = serviceControlSwitch.privacyUpdateDate;
        }
        Long l4 = l2;
        if ((i2 & 8) != 0) {
            l3 = serviceControlSwitch.serviceUpdateDate;
        }
        Long l5 = l3;
        if ((i2 & 16) != 0) {
            gpuLadderInfo = serviceControlSwitch.gpuLadderData;
        }
        GpuLadderInfo gpuLadderInfo2 = gpuLadderInfo;
        if ((i2 & 32) != 0) {
            num3 = serviceControlSwitch.recommendSwitchOn;
        }
        return serviceControlSwitch.copy(num, num4, l4, l5, gpuLadderInfo2, num3);
    }

    public final Integer component1() {
        return this.coupon_on;
    }

    public final Integer component2() {
        return this.login_on;
    }

    public final Long component3() {
        return this.privacyUpdateDate;
    }

    public final Long component4() {
        return this.serviceUpdateDate;
    }

    public final GpuLadderInfo component5() {
        return this.gpuLadderData;
    }

    public final Integer component6() {
        return this.recommendSwitchOn;
    }

    public final ServiceControlSwitch copy(Integer num, Integer num2, Long l2, Long l3, GpuLadderInfo gpuLadderInfo, Integer num3) {
        return new ServiceControlSwitch(num, num2, l2, l3, gpuLadderInfo, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServiceControlSwitch) {
            ServiceControlSwitch serviceControlSwitch = (ServiceControlSwitch) obj;
            return s.c(this.coupon_on, serviceControlSwitch.coupon_on) && s.c(this.login_on, serviceControlSwitch.login_on) && s.c(this.privacyUpdateDate, serviceControlSwitch.privacyUpdateDate) && s.c(this.serviceUpdateDate, serviceControlSwitch.serviceUpdateDate) && s.c(this.gpuLadderData, serviceControlSwitch.gpuLadderData) && s.c(this.recommendSwitchOn, serviceControlSwitch.recommendSwitchOn);
        }
        return false;
    }

    public final Integer getCoupon_on() {
        return this.coupon_on;
    }

    public final GpuLadderInfo getGpuLadderData() {
        return this.gpuLadderData;
    }

    public final Integer getLogin_on() {
        return this.login_on;
    }

    public final Long getPrivacyUpdateDate() {
        return this.privacyUpdateDate;
    }

    public final Integer getRecommendSwitchOn() {
        return this.recommendSwitchOn;
    }

    public final Long getServiceUpdateDate() {
        return this.serviceUpdateDate;
    }

    public int hashCode() {
        Integer num = this.coupon_on;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.login_on;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l2 = this.privacyUpdateDate;
        int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.serviceUpdateDate;
        int hashCode4 = (hashCode3 + (l3 == null ? 0 : l3.hashCode())) * 31;
        GpuLadderInfo gpuLadderInfo = this.gpuLadderData;
        int hashCode5 = (hashCode4 + (gpuLadderInfo == null ? 0 : gpuLadderInfo.hashCode())) * 31;
        Integer num3 = this.recommendSwitchOn;
        return hashCode5 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setGpuLadderData(GpuLadderInfo gpuLadderInfo) {
        this.gpuLadderData = gpuLadderInfo;
    }

    public String toString() {
        return "ServiceControlSwitch(coupon_on=" + this.coupon_on + ", login_on=" + this.login_on + ", privacyUpdateDate=" + this.privacyUpdateDate + ", serviceUpdateDate=" + this.serviceUpdateDate + ", gpuLadderData=" + this.gpuLadderData + ", recommendSwitchOn=" + this.recommendSwitchOn + ')';
    }
}
