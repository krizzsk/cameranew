package com.facebook.internal;

import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.facebook.internal.k;
import java.util.HashMap;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class FeatureManager {
    private static final Map<Feature, String[]> a = new HashMap();

    /* loaded from: classes.dex */
    public enum Feature {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        Monitoring(196608),
        Login(16777216),
        ChromeCustomTabsPrefetching(16842752),
        IgnoreAppSwitchToLoggedOut(16908288),
        Share(33554432),
        Places(50331648);
        
        private final int code;

        Feature(int i2) {
            this.code = i2;
        }

        static Feature fromInt(int i2) {
            Feature[] values;
            for (Feature feature : values()) {
                if (feature.code == i2) {
                    return feature;
                }
            }
            return Unknown;
        }

        public Feature getParent() {
            int i2 = this.code;
            if ((i2 & 255) > 0) {
                return fromInt(i2 & InputDeviceCompat.SOURCE_ANY);
            }
            if ((65280 & i2) > 0) {
                return fromInt(i2 & SupportMenu.CATEGORY_MASK);
            }
            if ((16711680 & i2) > 0) {
                return fromInt(i2 & ViewCompat.MEASURED_STATE_MASK);
            }
            return fromInt(0);
        }

        String toKey() {
            return "FBSDKFeature" + toString();
        }

        @Override // java.lang.Enum
        public String toString() {
            switch (b.a[ordinal()]) {
                case 1:
                    return "RestrictiveDataFiltering";
                case 2:
                    return "Instrument";
                case 3:
                    return "CrashReport";
                case 4:
                    return "CrashShield";
                case 5:
                    return "ThreadCheck";
                case 6:
                    return "ErrorReport";
                case 7:
                    return "AAM";
                case 8:
                    return "PrivacyProtection";
                case 9:
                    return "SuggestedEvents";
                case 10:
                    return "IntelligentIntegrity";
                case 11:
                    return "ModelRequest";
                case 12:
                    return "EventDeactivation";
                case 13:
                    return "OnDeviceEventProcessing";
                case 14:
                    return "OnDevicePostInstallEventProcessing";
                case 15:
                    return "ChromeCustomTabsPrefetching";
                case 16:
                    return "Monitoring";
                case 17:
                    return "IgnoreAppSwitchToLoggedOut";
                case 18:
                    return "CoreKit";
                case 19:
                    return "AppEvents";
                case 20:
                    return "CodelessEvents";
                case 21:
                    return "LoginKit";
                case 22:
                    return "ShareKit";
                case 23:
                    return "PlacesKit";
                default:
                    return "unknown";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements k.c {
        final /* synthetic */ c a;
        final /* synthetic */ Feature b;

        a(c cVar, Feature feature) {
            this.a = cVar;
            this.b = feature;
        }

        @Override // com.facebook.internal.k.c
        public void onCompleted() {
            this.a.a(FeatureManager.g(this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Feature.values().length];
            a = iArr;
            try {
                iArr[Feature.RestrictiveDataFiltering.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Feature.Instrument.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Feature.CrashReport.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Feature.CrashShield.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Feature.ThreadCheck.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Feature.ErrorReport.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Feature.AAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Feature.PrivacyProtection.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Feature.SuggestedEvents.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Feature.IntelligentIntegrity.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[Feature.ModelRequest.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[Feature.EventDeactivation.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[Feature.OnDeviceEventProcessing.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[Feature.OnDevicePostInstallEventProcessing.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[Feature.ChromeCustomTabsPrefetching.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[Feature.Monitoring.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[Feature.IgnoreAppSwitchToLoggedOut.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[Feature.Core.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                a[Feature.AppEvents.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[Feature.CodelessEvents.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[Feature.Login.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[Feature.Share.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[Feature.Places.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(boolean z);
    }

    public static void a(Feature feature, c cVar) {
        k.j(new a(cVar, feature));
    }

    private static boolean b(Feature feature) {
        switch (b.a[feature.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                return false;
            default:
                return true;
        }
    }

    public static void c(Feature feature) {
        com.facebook.f.f().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).edit().putString(feature.toKey(), com.facebook.f.w()).apply();
    }

    public static Feature d(String str) {
        f();
        for (Map.Entry<Feature, String[]> entry : a.entrySet()) {
            for (String str2 : entry.getValue()) {
                if (str.startsWith(str2)) {
                    return entry.getKey();
                }
            }
        }
        return Feature.Unknown;
    }

    private static boolean e(Feature feature) {
        return k.f(feature.toKey(), com.facebook.f.g(), b(feature));
    }

    private static synchronized void f() {
        synchronized (FeatureManager.class) {
            Map<Feature, String[]> map = a;
            if (map.isEmpty()) {
                map.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
                map.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
                map.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
                map.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
                map.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
                map.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
                map.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
                map.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
                map.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
                map.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
            }
        }
    }

    public static boolean g(Feature feature) {
        if (Feature.Unknown == feature) {
            return false;
        }
        if (Feature.Core == feature) {
            return true;
        }
        String string = com.facebook.f.f().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).getString(feature.toKey(), null);
        if (string == null || !string.equals(com.facebook.f.w())) {
            Feature parent = feature.getParent();
            if (parent == feature) {
                return e(feature);
            }
            return g(parent) && e(feature);
        }
        return false;
    }
}
