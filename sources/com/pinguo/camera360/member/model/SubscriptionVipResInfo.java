package com.pinguo.camera360.member.model;

import kotlin.jvm.internal.s;
/* compiled from: SubscriptionInfo.kt */
/* loaded from: classes3.dex */
public final class SubscriptionVipResInfo {
    private final int imgIntroId;
    private final String resUrl;
    private final String textIntro;
    private final String textIntroDesc;
    private final String viewType;

    public SubscriptionVipResInfo(String viewType, String resUrl, int i2, String textIntro, String textIntroDesc) {
        s.h(viewType, "viewType");
        s.h(resUrl, "resUrl");
        s.h(textIntro, "textIntro");
        s.h(textIntroDesc, "textIntroDesc");
        this.viewType = viewType;
        this.resUrl = resUrl;
        this.imgIntroId = i2;
        this.textIntro = textIntro;
        this.textIntroDesc = textIntroDesc;
    }

    public static /* synthetic */ SubscriptionVipResInfo copy$default(SubscriptionVipResInfo subscriptionVipResInfo, String str, String str2, int i2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = subscriptionVipResInfo.viewType;
        }
        if ((i3 & 2) != 0) {
            str2 = subscriptionVipResInfo.resUrl;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            i2 = subscriptionVipResInfo.imgIntroId;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str3 = subscriptionVipResInfo.textIntro;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            str4 = subscriptionVipResInfo.textIntroDesc;
        }
        return subscriptionVipResInfo.copy(str, str5, i4, str6, str4);
    }

    public final String component1() {
        return this.viewType;
    }

    public final String component2() {
        return this.resUrl;
    }

    public final int component3() {
        return this.imgIntroId;
    }

    public final String component4() {
        return this.textIntro;
    }

    public final String component5() {
        return this.textIntroDesc;
    }

    public final SubscriptionVipResInfo copy(String viewType, String resUrl, int i2, String textIntro, String textIntroDesc) {
        s.h(viewType, "viewType");
        s.h(resUrl, "resUrl");
        s.h(textIntro, "textIntro");
        s.h(textIntroDesc, "textIntroDesc");
        return new SubscriptionVipResInfo(viewType, resUrl, i2, textIntro, textIntroDesc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubscriptionVipResInfo) {
            SubscriptionVipResInfo subscriptionVipResInfo = (SubscriptionVipResInfo) obj;
            return s.c(this.viewType, subscriptionVipResInfo.viewType) && s.c(this.resUrl, subscriptionVipResInfo.resUrl) && this.imgIntroId == subscriptionVipResInfo.imgIntroId && s.c(this.textIntro, subscriptionVipResInfo.textIntro) && s.c(this.textIntroDesc, subscriptionVipResInfo.textIntroDesc);
        }
        return false;
    }

    public final int getImgIntroId() {
        return this.imgIntroId;
    }

    public final String getResUrl() {
        return this.resUrl;
    }

    public final String getTextIntro() {
        return this.textIntro;
    }

    public final String getTextIntroDesc() {
        return this.textIntroDesc;
    }

    public final String getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        return (((((((this.viewType.hashCode() * 31) + this.resUrl.hashCode()) * 31) + this.imgIntroId) * 31) + this.textIntro.hashCode()) * 31) + this.textIntroDesc.hashCode();
    }

    public String toString() {
        return "SubscriptionVipResInfo(viewType=" + this.viewType + ", resUrl=" + this.resUrl + ", imgIntroId=" + this.imgIntroId + ", textIntro=" + this.textIntro + ", textIntroDesc=" + this.textIntroDesc + ')';
    }
}
