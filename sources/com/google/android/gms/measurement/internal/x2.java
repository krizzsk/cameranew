package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.internal.measurement.zzen;
import com.google.android.gms.internal.measurement.zzex;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class x2 {
    public static final w2<Long> A;
    public static final w2<Boolean> A0;
    public static final w2<Long> B;
    public static final w2<Boolean> B0;
    public static final w2<Integer> C;
    public static final w2<Long> D;
    public static final w2<Integer> E;
    public static final w2<Integer> F;
    public static final w2<Integer> G;
    public static final w2<Integer> H;
    public static final w2<Integer> I;
    public static final w2<Long> J;
    public static final w2<Boolean> K;
    public static final w2<String> L;
    public static final w2<Long> M;
    public static final w2<Integer> N;
    public static final w2<Double> O;
    public static final w2<Integer> P;
    public static final w2<Integer> Q;
    public static final w2<Long> R;
    public static final w2<Boolean> S;
    public static final w2<Boolean> T;
    public static final w2<Boolean> U;
    public static final w2<Boolean> V;
    public static final w2<Boolean> W;
    public static final w2<Boolean> X;
    public static final w2<Boolean> Y;
    public static final w2<Boolean> Z;
    private static final List<w2<?>> a = Collections.synchronizedList(new ArrayList());
    public static final w2<Boolean> a0;
    public static final w2<Long> b;
    public static final w2<Boolean> b0;
    public static final w2<Long> c;
    public static final w2<Boolean> c0;

    /* renamed from: d */
    public static final w2<Long> f3964d;
    public static final w2<Boolean> d0;

    /* renamed from: e */
    public static final w2<String> f3965e;
    public static final w2<Boolean> e0;

    /* renamed from: f */
    public static final w2<String> f3966f;
    public static final w2<Boolean> f0;

    /* renamed from: g */
    public static final w2<Integer> f3967g;
    public static final w2<Boolean> g0;

    /* renamed from: h */
    public static final w2<Integer> f3968h;
    public static final w2<Boolean> h0;

    /* renamed from: i */
    public static final w2<Integer> f3969i;
    public static final w2<Boolean> i0;

    /* renamed from: j */
    public static final w2<Integer> f3970j;
    public static final w2<Boolean> j0;

    /* renamed from: k */
    public static final w2<Integer> f3971k;
    public static final w2<Boolean> k0;

    /* renamed from: l */
    public static final w2<Integer> f3972l;
    public static final w2<Boolean> l0;
    public static final w2<Integer> m;
    public static final w2<Boolean> m0;
    public static final w2<Integer> n;
    public static final w2<Boolean> n0;
    public static final w2<Integer> o;
    public static final w2<Boolean> o0;
    public static final w2<Integer> p;
    public static final w2<Boolean> p0;
    public static final w2<String> q;
    public static final w2<Boolean> q0;
    public static final w2<Long> r;
    public static final w2<Boolean> r0;
    public static final w2<Long> s;
    public static final w2<Boolean> s0;
    public static final w2<Long> t;
    public static final w2<Boolean> t0;
    public static final w2<Long> u;
    public static final w2<Boolean> u0;
    public static final w2<Long> v;
    public static final w2<Boolean> v0;
    public static final w2<Long> w;
    public static final w2<Boolean> w0;
    public static final w2<Long> x;
    public static final w2<Boolean> x0;
    public static final w2<Long> y;
    public static final w2<Boolean> y0;
    public static final w2<Long> z;
    public static final w2<Integer> z0;

    static {
        Collections.synchronizedSet(new HashSet());
        b = b("measurement.ad_id_cache_time", 10000L, 10000L, s.a);
        Long valueOf = Long.valueOf((long) AdvTimeUtils.MILLIS_OF_A_DAY);
        c = b("measurement.monitoring.sample_period_millis", valueOf, valueOf, e0.a);
        f3964d = b("measurement.config.cache_time", valueOf, 3600000L, p0.a);
        f3965e = b("measurement.config.url_scheme", "https", "https", b1.a);
        f3966f = b("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", m1.a);
        f3967g = b("measurement.upload.max_bundles", 100, 100, x1.a);
        f3968h = b("measurement.upload.max_batch_size", 65536, 65536, j2.a);
        f3969i = b("measurement.upload.max_bundle_size", 65536, 65536, q2.a);
        f3970j = b("measurement.upload.max_events_per_bundle", 1000, 1000, r2.a);
        f3971k = b("measurement.upload.max_events_per_day", 100000, 100000, s2.a);
        f3972l = b("measurement.upload.max_error_events_per_day", 1000, 1000, t.a);
        m = b("measurement.upload.max_public_events_per_day", 50000, 50000, u.a);
        n = b("measurement.upload.max_conversions_per_day", 10000, 10000, v.a);
        o = b("measurement.upload.max_realtime_events_per_day", 10, 10, w.a);
        p = b("measurement.store.max_stored_events_per_app", 100000, 100000, x.a);
        q = b("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", z.a);
        r = b("measurement.upload.backoff_period", 43200000L, 43200000L, a0.a);
        s = b("measurement.upload.window_interval", 3600000L, 3600000L, b0.a);
        t = b("measurement.upload.interval", 3600000L, 3600000L, c0.a);
        u = b("measurement.upload.realtime_upload_interval", 10000L, 10000L, d0.a);
        v = b("measurement.upload.debug_upload_interval", 1000L, 1000L, f0.a);
        w = b("measurement.upload.minimum_delay", 500L, 500L, g0.a);
        x = b("measurement.alarm_manager.minimum_interval", 60000L, 60000L, h0.a);
        y = b("measurement.upload.stale_data_deletion_interval", valueOf, valueOf, i0.a);
        z = b("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, j0.a);
        A = b("measurement.upload.initial_upload_delay_time", 15000L, 15000L, k0.a);
        Long valueOf2 = Long.valueOf((long) TapjoyConstants.SESSION_ID_INACTIVITY_TIME);
        B = b("measurement.upload.retry_time", valueOf2, valueOf2, l0.a);
        C = b("measurement.upload.retry_count", 6, 6, m0.a);
        D = b("measurement.upload.max_queue_time", 2419200000L, 2419200000L, n0.a);
        E = b("measurement.lifetimevalue.max_currency_tracked", 4, 4, o0.a);
        F = b("measurement.audience.filter_result_max_count", 200, 200, q0.a);
        G = b("measurement.upload.max_public_user_properties", 25, 25, null);
        H = b("measurement.upload.max_event_name_cardinality", 500, 500, null);
        I = b("measurement.upload.max_public_event_params", 25, 25, null);
        J = b("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, r0.a);
        Boolean bool = Boolean.FALSE;
        K = b("measurement.test.boolean_flag", bool, bool, s0.a);
        L = b("measurement.test.string_flag", "---", "---", t0.a);
        M = b("measurement.test.long_flag", -1L, -1L, u0.a);
        N = b("measurement.test.int_flag", -2, -2, v0.a);
        Double valueOf3 = Double.valueOf(-3.0d);
        O = b("measurement.test.double_flag", valueOf3, valueOf3, w0.a);
        P = b("measurement.experiment.max_ids", 50, 50, x0.a);
        Q = b("measurement.max_bundles_per_iteration", 100, 100, y0.a);
        R = b("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, a1.a);
        S = b("measurement.validation.internal_limits_internal_event_params", bool, bool, c1.a);
        Boolean bool2 = Boolean.TRUE;
        T = b("measurement.collection.firebase_global_collection_flag_enabled", bool2, bool2, d1.a);
        U = b("measurement.collection.redundant_engagement_removal_enabled", bool, bool, e1.a);
        V = b("measurement.collection.log_event_and_bundle_v2", bool2, bool2, f1.a);
        W = b("measurement.quality.checksum", bool, bool, null);
        X = b("measurement.sdk.dynamite.allow_remote_dynamite3", bool2, bool2, g1.a);
        Y = b("measurement.sdk.collection.validate_param_names_alphabetical", bool2, bool2, h1.a);
        Z = b("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, i1.a);
        a0 = b("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, j1.a);
        b0 = b("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, k1.a);
        c0 = b("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, l1.a);
        d0 = b("measurement.sdk.collection.last_deep_link_referrer2", bool2, bool2, n1.a);
        e0 = b("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, o1.a);
        f0 = b("measurement.sdk.collection.last_gclid_from_referrer2", bool, bool, p1.a);
        g0 = b("measurement.sdk.collection.enable_extend_user_property_size", bool2, bool2, q1.a);
        h0 = b("measurement.upload.file_lock_state_check", bool, bool, r1.a);
        i0 = b("measurement.ga.ga_app_id", bool, bool, s1.a);
        j0 = b("measurement.lifecycle.app_in_background_parameter", bool, bool, t1.a);
        k0 = b("measurement.integration.disable_firebase_instance_id", bool, bool, u1.a);
        l0 = b("measurement.lifecycle.app_backgrounded_engagement", bool, bool, v1.a);
        m0 = b("measurement.collection.service.update_with_analytics_fix", bool, bool, w1.a);
        n0 = b("measurement.service.use_appinfo_modified", bool, bool, y1.a);
        o0 = b("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, z1.a);
        p0 = b("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, b2.a);
        q0 = b("measurement.scheduler.task_thread.cleanup_on_exit", bool, bool, c2.a);
        r0 = b("measurement.upload.file_truncate_fix", bool, bool, d2.a);
        s0 = b("measurement.sdk.referrer.delayed_install_referrer_api", bool, bool, e2.a);
        t0 = b("measurement.sdk.screen.disabling_automatic_reporting", bool2, bool2, f2.a);
        u0 = b("measurement.sdk.screen.manual_screen_view_logging", bool2, bool2, g2.a);
        b("measurement.collection.synthetic_data_mitigation", bool, bool, h2.a);
        v0 = b("measurement.androidId.delete_feature", bool2, bool2, i2.a);
        w0 = b("measurement.client.consent_state_v1", bool2, bool2, k2.a);
        x0 = b("measurement.client.3p_consent_state_v1", bool2, bool2, l2.a);
        y0 = b("measurement.service.consent_state_v1_W36", bool2, bool2, m2.a);
        z0 = b("measurement.service.storage_consent_support_version", 203590, 203590, n2.a);
        A0 = b("measurement.service.directly_maybe_log_error_events", bool, bool, o2.a);
        B0 = b("measurement.client.safer_resources", bool2, bool2, p2.a);
    }

    public static Map<String, String> a(Context context) {
        zzen zza = zzen.zza(context.getContentResolver(), zzex.zza("com.google.android.gms.measurement"));
        return zza == null ? Collections.emptyMap() : zza.zzb();
    }

    static <V> w2<V> b(String str, V v2, V v3, u2<V> u2Var) {
        w2<V> w2Var = new w2<>(str, v2, v3, u2Var, null);
        a.add(w2Var);
        return w2Var;
    }
}
