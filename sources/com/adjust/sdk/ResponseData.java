package com.adjust.sdk;

import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseData {
    public ActivityKind activityKind;
    public ActivityPackage activityPackage;
    public String adid;
    public Long askIn;
    public AdjustAttribution attribution;
    public Long continueIn;
    public JSONObject jsonResponse;
    public String message;
    public Long retryIn;
    public Map<String, String> sendingParameters;
    public String timestamp;
    public TrackingState trackingState;
    public boolean success = false;
    public boolean willRetry = false;

    /* renamed from: com.adjust.sdk.ResponseData$1  reason: invalid class name */
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
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.ATTRIBUTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$adjust$sdk$ActivityKind[ActivityKind.EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static ResponseData buildResponseData(ActivityPackage activityPackage, Map<String, String> map) {
        ResponseData sessionResponseData;
        ActivityKind activityKind = activityPackage.getActivityKind();
        int i2 = AnonymousClass1.$SwitchMap$com$adjust$sdk$ActivityKind[activityKind.ordinal()];
        if (i2 == 1) {
            sessionResponseData = new SessionResponseData(activityPackage);
        } else if (i2 == 2) {
            sessionResponseData = new SdkClickResponseData();
        } else if (i2 == 3) {
            sessionResponseData = new AttributionResponseData();
        } else if (i2 != 4) {
            sessionResponseData = new ResponseData();
        } else {
            sessionResponseData = new EventResponseData(activityPackage);
        }
        sessionResponseData.activityKind = activityKind;
        sessionResponseData.activityPackage = activityPackage;
        sessionResponseData.sendingParameters = map;
        return sessionResponseData;
    }

    public String toString() {
        return Util.formatString("message:%s timestamp:%s json:%s", this.message, this.timestamp, this.jsonResponse);
    }
}
