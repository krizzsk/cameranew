package com.google.android.gms.location.places;

import com.facebook.ads.AdError;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
@Deprecated
/* loaded from: classes2.dex */
public class d extends com.google.android.gms.common.api.b {
    public static String a(int i2) {
        if (i2 != 9051) {
            if (i2 != 9150) {
                if (i2 != 9101) {
                    if (i2 != 9102) {
                        if (i2 != 9201) {
                            if (i2 != 9202) {
                                switch (i2) {
                                    case 9000:
                                        return "PLACES_API_QUOTA_FAILED";
                                    case AdError.AD_PRESENTATION_ERROR_CODE /* 9001 */:
                                        return "PLACES_API_USAGE_LIMIT_EXCEEDED";
                                    case 9002:
                                        return "PLACES_API_KEY_INVALID";
                                    case 9003:
                                        return "PLACES_API_ACCESS_NOT_CONFIGURED";
                                    case 9004:
                                        return "PLACES_API_INVALID_ARGUMENT";
                                    case 9005:
                                        return "PLACES_API_RATE_LIMIT_EXCEEDED";
                                    case 9006:
                                        return "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
                                    case 9007:
                                        return "PLACES_API_KEY_EXPIRED";
                                    case 9008:
                                        return "PLACES_API_INVALID_APP";
                                    case 9009:
                                        return "INSUFFICIENT_LOCATION_PERMISSION_FOR_BACKGROUND_PLACES";
                                    default:
                                        return com.google.android.gms.common.api.b.a(i2);
                                }
                            }
                            return "PLACES_API_PERSONALIZED_DATA_ACCESS_REJECTED";
                        }
                        return "PLACES_API_PERSONALIZED_DATA_ACCESS_APPROVED";
                    }
                    return "NEARBY_ALERTS_NOT_AVAILABLE";
                }
                return "PLACE_PROXIMITY_UNKNOWN";
            }
            return "PLACEFENCING_NOT_AVAILABLE";
        }
        return "PLACE_ALIAS_NOT_FOUND";
    }

    public static Status b(int i2) {
        String a = a(i2);
        q.j(a);
        return new Status(i2, a);
    }
}
