package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.b;
import com.google.android.gms.measurement.internal.l5;
import com.google.android.gms.measurement.internal.m5;
import com.google.android.gms.measurement.internal.o5;
import com.google.android.gms.measurement.internal.x6;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzc {
    private static final Set<String> zza = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", FirebaseAnalytics.Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));
    private static final List<String> zzb = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    private static final List<String> zzc = Arrays.asList("auto", "app", "am");
    private static final List<String> zzd = Arrays.asList("_r", "_dbg");
    private static final List<String> zze = Arrays.asList((String[]) b.a(o5.a, o5.b));
    private static final List<String> zzf = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static boolean zza(String str) {
        return !zzc.contains(str);
    }

    public static boolean zzb(String str, Bundle bundle) {
        if (zzb.contains(str)) {
            return false;
        }
        if (bundle != null) {
            for (String str2 : zzd) {
                if (bundle.containsKey(str2)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean zzc(String str) {
        return !zza.contains(str);
    }

    public static boolean zzd(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals(Constants.ScionAnalytics.ORIGIN_FCM) || str.equals(FirebaseABTesting.OriginService.REMOTE_CONFIG);
        } else if (Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION.equals(str2)) {
            return str.equals(Constants.ScionAnalytics.ORIGIN_FCM) || str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING);
        } else if (zze.contains(str2)) {
            return false;
        } else {
            for (String str3 : zzf) {
                if (str2.matches(str3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean zze(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        if (conditionalUserProperty == null || (str = conditionalUserProperty.origin) == null || str.isEmpty()) {
            return false;
        }
        Object obj = conditionalUserProperty.value;
        if ((obj == null || x6.c(obj) != null) && zza(str) && zzd(str, conditionalUserProperty.name)) {
            String str2 = conditionalUserProperty.expiredEventName;
            if (str2 == null || (zzb(str2, conditionalUserProperty.expiredEventParams) && zzf(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
                String str3 = conditionalUserProperty.triggeredEventName;
                if (str3 == null || (zzb(str3, conditionalUserProperty.triggeredEventParams) && zzf(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
                    String str4 = conditionalUserProperty.timedOutEventName;
                    if (str4 != null) {
                        return zzb(str4, conditionalUserProperty.timedOutEventParams) && zzf(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean zzf(String str, String str2, Bundle bundle) {
        char c;
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2)) {
            if (zza(str) && bundle != null) {
                for (String str3 : zzd) {
                    if (bundle.containsKey(str3)) {
                        return false;
                    }
                }
                int hashCode = str.hashCode();
                if (hashCode == 101200) {
                    if (str.equals(Constants.ScionAnalytics.ORIGIN_FCM)) {
                        c = 0;
                    }
                    c = 65535;
                } else if (hashCode != 101230) {
                    if (hashCode == 3142703 && str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING)) {
                        c = 2;
                    }
                    c = 65535;
                } else {
                    if (str.equals("fdl")) {
                        c = 1;
                    }
                    c = 65535;
                }
                if (c == 0) {
                    bundle.putString("_cis", "fcm_integration");
                    return true;
                } else if (c == 1) {
                    bundle.putString("_cis", "fdl_integration");
                    return true;
                } else if (c != 2) {
                    return false;
                } else {
                    bundle.putString("_cis", "fiam_integration");
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static Bundle zzg(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.origin;
        if (str != null) {
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, str);
        }
        String str2 = conditionalUserProperty.name;
        if (str2 != null) {
            bundle.putString("name", str2);
        }
        Object obj = conditionalUserProperty.value;
        if (obj != null) {
            l5.a(bundle, obj);
        }
        String str3 = conditionalUserProperty.triggerEventName;
        if (str3 != null) {
            bundle.putString("trigger_event_name", str3);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.triggerTimeout);
        String str4 = conditionalUserProperty.timedOutEventName;
        if (str4 != null) {
            bundle.putString("timed_out_event_name", str4);
        }
        Bundle bundle2 = conditionalUserProperty.timedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str5 = conditionalUserProperty.triggeredEventName;
        if (str5 != null) {
            bundle.putString("triggered_event_name", str5);
        }
        Bundle bundle3 = conditionalUserProperty.triggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.timeToLive);
        String str6 = conditionalUserProperty.expiredEventName;
        if (str6 != null) {
            bundle.putString("expired_event_name", str6);
        }
        Bundle bundle4 = conditionalUserProperty.expiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.creationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.active);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.triggeredTimestamp);
        return bundle;
    }

    public static AnalyticsConnector.ConditionalUserProperty zzh(Bundle bundle) {
        q.j(bundle);
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        String str = (String) l5.b(bundle, FirebaseAnalytics.Param.ORIGIN, String.class, null);
        q.j(str);
        conditionalUserProperty.origin = str;
        String str2 = (String) l5.b(bundle, "name", String.class, null);
        q.j(str2);
        conditionalUserProperty.name = str2;
        conditionalUserProperty.value = l5.b(bundle, FirebaseAnalytics.Param.VALUE, Object.class, null);
        conditionalUserProperty.triggerEventName = (String) l5.b(bundle, "trigger_event_name", String.class, null);
        conditionalUserProperty.triggerTimeout = ((Long) l5.b(bundle, "trigger_timeout", Long.class, 0L)).longValue();
        conditionalUserProperty.timedOutEventName = (String) l5.b(bundle, "timed_out_event_name", String.class, null);
        conditionalUserProperty.timedOutEventParams = (Bundle) l5.b(bundle, "timed_out_event_params", Bundle.class, null);
        conditionalUserProperty.triggeredEventName = (String) l5.b(bundle, "triggered_event_name", String.class, null);
        conditionalUserProperty.triggeredEventParams = (Bundle) l5.b(bundle, "triggered_event_params", Bundle.class, null);
        conditionalUserProperty.timeToLive = ((Long) l5.b(bundle, "time_to_live", Long.class, 0L)).longValue();
        conditionalUserProperty.expiredEventName = (String) l5.b(bundle, "expired_event_name", String.class, null);
        conditionalUserProperty.expiredEventParams = (Bundle) l5.b(bundle, "expired_event_params", Bundle.class, null);
        conditionalUserProperty.active = ((Boolean) l5.b(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
        conditionalUserProperty.creationTimestamp = ((Long) l5.b(bundle, "creation_timestamp", Long.class, 0L)).longValue();
        conditionalUserProperty.triggeredTimestamp = ((Long) l5.b(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        return conditionalUserProperty;
    }

    public static boolean zzi(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int codePointAt = str.codePointAt(0);
        if (Character.isLetter(codePointAt)) {
            int length = str.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str.codePointAt(charCount);
                if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                    return false;
                }
                charCount += Character.charCount(codePointAt2);
            }
            return true;
        }
        return false;
    }

    public static boolean zzj(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int codePointAt = str.codePointAt(0);
        if (Character.isLetter(codePointAt) || codePointAt == 95) {
            int length = str.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str.codePointAt(charCount);
                if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                    return false;
                }
                charCount += Character.charCount(codePointAt2);
            }
            return true;
        }
        return false;
    }

    public static String zzk(String str) {
        String a = m5.a(str);
        return a != null ? a : str;
    }

    public static String zzl(String str) {
        String b = m5.b(str);
        return b != null ? b : str;
    }

    public static void zzm(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }
}
