package com.adjust.sdk;

import com.tapjoy.TJAdUnitConstants;
/* loaded from: classes.dex */
public enum ActivityKind {
    UNKNOWN,
    SESSION,
    EVENT,
    CLICK,
    ATTRIBUTION,
    REVENUE,
    REATTRIBUTION,
    INFO,
    GDPR,
    AD_REVENUE,
    DISABLE_THIRD_PARTY_SHARING,
    SUBSCRIPTION,
    THIRD_PARTY_SHARING,
    MEASUREMENT_CONSENT;

    /* renamed from: com.adjust.sdk.ActivityKind$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$adjust$sdk$ActivityKind;

        static {
            int[] iArr = new int[ActivityKind.values().length];
            $SwitchMap$com$adjust$sdk$ActivityKind = iArr;
            try {
                iArr[ActivityKind.SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.EVENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.ATTRIBUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.GDPR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.DISABLE_THIRD_PARTY_SHARING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.AD_REVENUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.SUBSCRIPTION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.THIRD_PARTY_SHARING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.MEASUREMENT_CONSENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static ActivityKind fromString(String str) {
        if ("session".equals(str)) {
            return SESSION;
        }
        if ("event".equals(str)) {
            return EVENT;
        }
        if ("click".equals(str)) {
            return CLICK;
        }
        if ("attribution".equals(str)) {
            return ATTRIBUTION;
        }
        if (TJAdUnitConstants.String.VIDEO_INFO.equals(str)) {
            return INFO;
        }
        if ("gdpr".equals(str)) {
            return GDPR;
        }
        if ("disable_third_party_sharing".equals(str)) {
            return DISABLE_THIRD_PARTY_SHARING;
        }
        if ("ad_revenue".equals(str)) {
            return AD_REVENUE;
        }
        if ("subscription".equals(str)) {
            return SUBSCRIPTION;
        }
        if ("third_party_sharing".equals(str)) {
            return THIRD_PARTY_SHARING;
        }
        if ("measurement_consent".equals(str)) {
            return MEASUREMENT_CONSENT;
        }
        return UNKNOWN;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$adjust$sdk$ActivityKind[ordinal()]) {
            case 1:
                return "session";
            case 2:
                return "event";
            case 3:
                return "click";
            case 4:
                return "attribution";
            case 5:
                return TJAdUnitConstants.String.VIDEO_INFO;
            case 6:
                return "gdpr";
            case 7:
                return "disable_third_party_sharing";
            case 8:
                return "ad_revenue";
            case 9:
                return "subscription";
            case 10:
                return "third_party_sharing";
            case 11:
                return "measurement_consent";
            default:
                return "unknown";
        }
    }
}
