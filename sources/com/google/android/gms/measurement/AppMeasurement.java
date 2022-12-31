package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.measurement.internal.l5;
import com.google.android.gms.measurement.internal.o4;
import com.google.android.gms.measurement.internal.s6;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
@Deprecated
/* loaded from: classes2.dex */
public class AppMeasurement {
    private static volatile AppMeasurement c;
    private final o4 a;
    private final s6 b;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
    /* loaded from: classes2.dex */
    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @RecentlyNonNull
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @RecentlyNonNull
        @Keep
        public String mExpiredEventName;
        @RecentlyNonNull
        @Keep
        public Bundle mExpiredEventParams;
        @RecentlyNonNull
        @Keep
        public String mName;
        @RecentlyNonNull
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @RecentlyNonNull
        @Keep
        public String mTimedOutEventName;
        @RecentlyNonNull
        @Keep
        public Bundle mTimedOutEventParams;
        @RecentlyNonNull
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @RecentlyNonNull
        @Keep
        public String mTriggeredEventName;
        @RecentlyNonNull
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @RecentlyNonNull
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        ConditionalUserProperty(@NonNull Bundle bundle) {
            q.j(bundle);
            this.mAppId = (String) l5.b(bundle, TapjoyConstants.TJC_APP_ID, String.class, null);
            this.mOrigin = (String) l5.b(bundle, FirebaseAnalytics.Param.ORIGIN, String.class, null);
            this.mName = (String) l5.b(bundle, "name", String.class, null);
            this.mValue = l5.b(bundle, FirebaseAnalytics.Param.VALUE, Object.class, null);
            this.mTriggerEventName = (String) l5.b(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) l5.b(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) l5.b(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) l5.b(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) l5.b(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) l5.b(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) l5.b(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) l5.b(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) l5.b(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) l5.b(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) l5.b(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) l5.b(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }

        final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString(TapjoyConstants.TJC_APP_ID, str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString(FirebaseAnalytics.Param.ORIGIN, str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString("name", str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                l5.a(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }
    }

    public AppMeasurement(o4 o4Var) {
        q.j(o4Var);
        this.a = o4Var;
        this.b = null;
    }

    @RecentlyNonNull
    @Keep
    @Deprecated
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    public static AppMeasurement getInstance(@RecentlyNonNull Context context) {
        s6 s6Var;
        if (c == null) {
            synchronized (AppMeasurement.class) {
                if (c == null) {
                    try {
                        s6Var = (s6) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    } catch (ClassNotFoundException | Exception unused) {
                        s6Var = null;
                    }
                    if (s6Var != null) {
                        c = new AppMeasurement(s6Var);
                    } else {
                        c = new AppMeasurement(o4.f(context, new zzy(0L, 0L, true, null, null, null, null, null), null));
                    }
                }
            }
        }
        return c;
    }

    @Keep
    public void beginAdUnitExposure(@RecentlyNonNull @Size(min = 1) String str) {
        s6 s6Var = this.b;
        if (s6Var != null) {
            s6Var.zzl(str);
            return;
        }
        q.j(this.a);
        this.a.e().g(str, this.a.zzax().a());
    }

    @Keep
    public void clearConditionalUserProperty(@RecentlyNonNull @Size(max = 24, min = 1) String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        s6 s6Var = this.b;
        if (s6Var != null) {
            s6Var.zzo(str, str2, bundle);
            return;
        }
        q.j(this.a);
        this.a.D().z(str, str2, bundle);
    }

    @Keep
    public void endAdUnitExposure(@RecentlyNonNull @Size(min = 1) String str) {
        s6 s6Var = this.b;
        if (s6Var != null) {
            s6Var.zzm(str);
            return;
        }
        q.j(this.a);
        this.a.e().h(str, this.a.zzax().a());
    }

    @Keep
    public long generateEventId() {
        s6 s6Var = this.b;
        if (s6Var != null) {
            return s6Var.zzk();
        }
        q.j(this.a);
        return this.a.E().e0();
    }

    @RecentlyNonNull
    @Keep
    public String getAppInstanceId() {
        s6 s6Var = this.b;
        if (s6Var != null) {
            return s6Var.zzi();
        }
        q.j(this.a);
        return this.a.D().o();
    }

    @RecentlyNonNull
    @Keep
    @WorkerThread
    public List<ConditionalUserProperty> getConditionalUserProperties(@RecentlyNonNull String str, @RecentlyNonNull @Size(max = 23, min = 1) String str2) {
        List<Bundle> A;
        s6 s6Var = this.b;
        if (s6Var != null) {
            A = s6Var.zzp(str, str2);
        } else {
            q.j(this.a);
            A = this.a.D().A(str, str2);
        }
        ArrayList arrayList = new ArrayList(A == null ? 0 : A.size());
        for (Bundle bundle : A) {
            arrayList.add(new ConditionalUserProperty(bundle));
        }
        return arrayList;
    }

    @RecentlyNonNull
    @Keep
    public String getCurrentScreenClass() {
        s6 s6Var = this.b;
        if (s6Var != null) {
            return s6Var.zzh();
        }
        q.j(this.a);
        return this.a.D().D();
    }

    @RecentlyNonNull
    @Keep
    public String getCurrentScreenName() {
        s6 s6Var = this.b;
        if (s6Var != null) {
            return s6Var.zzg();
        }
        q.j(this.a);
        return this.a.D().C();
    }

    @RecentlyNonNull
    @Keep
    public String getGmpAppId() {
        s6 s6Var = this.b;
        if (s6Var != null) {
            return s6Var.zzj();
        }
        q.j(this.a);
        return this.a.D().E();
    }

    @Keep
    @WorkerThread
    public int getMaxUserProperties(@RecentlyNonNull @Size(min = 1) String str) {
        s6 s6Var = this.b;
        if (s6Var != null) {
            return s6Var.zzq(str);
        }
        q.j(this.a);
        this.a.D().w(str);
        return 25;
    }

    @RecentlyNonNull
    @Keep
    @WorkerThread
    protected Map<String, Object> getUserProperties(@RecentlyNonNull String str, @RecentlyNonNull @Size(max = 24, min = 1) String str2, boolean z) {
        s6 s6Var = this.b;
        if (s6Var != null) {
            return s6Var.zzc(str, str2, z);
        }
        q.j(this.a);
        return this.a.D().B(str, str2, z);
    }

    @Keep
    public void logEventInternal(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull Bundle bundle) {
        s6 s6Var = this.b;
        if (s6Var != null) {
            s6Var.zza(str, str2, bundle);
            return;
        }
        q.j(this.a);
        this.a.D().V(str, str2, bundle);
    }

    @Keep
    public void setConditionalUserProperty(@RecentlyNonNull ConditionalUserProperty conditionalUserProperty) {
        q.j(conditionalUserProperty);
        s6 s6Var = this.b;
        if (s6Var != null) {
            s6Var.zzn(conditionalUserProperty.a());
            return;
        }
        q.j(this.a);
        this.a.D().x(conditionalUserProperty.a());
    }

    public AppMeasurement(s6 s6Var) {
        q.j(s6Var);
        this.b = s6Var;
        this.a = null;
    }
}
