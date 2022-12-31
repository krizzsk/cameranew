package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.measurement.zzkw;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.internal.measurement.zzs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class n9 extends j5 {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f3883g = {"firebase_", "google_", "ga_"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f3884h = {"_err"};

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ int f3885i = 0;
    private SecureRandom c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f3886d;

    /* renamed from: e  reason: collision with root package name */
    private int f3887e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f3888f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n9(o4 o4Var) {
        super(o4Var);
        this.f3888f = null;
        this.f3886d = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long A(byte[] bArr) {
        com.google.android.gms.common.internal.q.j(bArr);
        int length = bArr.length;
        int i2 = 0;
        com.google.android.gms.common.internal.q.m(length > 0);
        long j2 = 0;
        for (int i3 = length - 1; i3 >= 0 && i3 >= bArr.length - 8; i3--) {
            j2 += (bArr[i3] & 255) << i2;
            i2 += 8;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B(Context context, boolean z) {
        com.google.android.gms.common.internal.q.j(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return c0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return c0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean D(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean E(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean K(String str) {
        return !f3884h[0].equals(str);
    }

    public static ArrayList<Bundle> W(List<zzaa> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzaa zzaaVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString(TapjoyConstants.TJC_APP_ID, zzaaVar.zza);
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, zzaaVar.zzb);
            bundle.putLong("creation_timestamp", zzaaVar.zzd);
            bundle.putString("name", zzaaVar.zzc.zzb);
            l5.a(bundle, zzaaVar.zzc.Q());
            bundle.putBoolean("active", zzaaVar.zze);
            String str = zzaaVar.zzf;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzas zzasVar = zzaaVar.zzg;
            if (zzasVar != null) {
                bundle.putString("timed_out_event_name", zzasVar.zza);
                zzaq zzaqVar = zzaaVar.zzg.zzb;
                if (zzaqVar != null) {
                    bundle.putBundle("timed_out_event_params", zzaqVar.R());
                }
            }
            bundle.putLong("trigger_timeout", zzaaVar.zzh);
            zzas zzasVar2 = zzaaVar.zzi;
            if (zzasVar2 != null) {
                bundle.putString("triggered_event_name", zzasVar2.zza);
                zzaq zzaqVar2 = zzaaVar.zzi.zzb;
                if (zzaqVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzaqVar2.R());
                }
            }
            bundle.putLong("triggered_timestamp", zzaaVar.zzc.zzc);
            bundle.putLong("time_to_live", zzaaVar.zzj);
            zzas zzasVar3 = zzaaVar.zzk;
            if (zzasVar3 != null) {
                bundle.putString("expired_event_name", zzasVar3.zza);
                zzaq zzaqVar3 = zzaaVar.zzk.zzb;
                if (zzaqVar3 != null) {
                    bundle.putBundle("expired_event_params", zzaqVar3.R());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static final boolean Y(Bundle bundle, int i2) {
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", i2);
            return true;
        }
        return false;
    }

    static final boolean Z(String str) {
        com.google.android.gms.common.internal.q.j(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final Object a0(int i2, Object obj, boolean z, boolean z2) {
        Parcelable[] parcelableArr;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                if (z2 && ((obj instanceof Bundle[]) || (obj instanceof Parcelable[]))) {
                    ArrayList arrayList = new ArrayList();
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (parcelable instanceof Bundle) {
                            Bundle G = G((Bundle) parcelable);
                            if (!G.isEmpty()) {
                                arrayList.add(G);
                            }
                        }
                    }
                    return arrayList.toArray(new Bundle[arrayList.size()]);
                }
                return null;
            }
            return o(String.valueOf(obj), i2, z);
        }
    }

    private final int b0(String str) {
        if ("_ldl".equals(str)) {
            this.a.x();
            return 2048;
        } else if (!"_id".equals(str)) {
            if (this.a.x().u(null, x2.g0) && "_lgclid".equals(str)) {
                this.a.x();
                return 100;
            }
            this.a.x();
            return 36;
        } else {
            this.a.x();
            return 256;
        }
    }

    private static boolean c0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private static boolean d0(String str, String[] strArr) {
        com.google.android.gms.common.internal.q.j(strArr);
        for (String str2 : strArr) {
            if (E(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g0(String str) {
        com.google.android.gms.common.internal.q.f(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest z() {
        MessageDigest messageDigest;
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                messageDigest = MessageDigest.getInstance(Constants.MD5);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean C(String str) {
        f();
        if (com.google.android.gms.common.wrappers.b.a(this.a.zzaw()).a(str) == 0) {
            return true;
        }
        this.a.a().t().b("Permission not granted", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean F(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String B = this.a.x().B();
        this.a.d();
        return B.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle G(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object q = q(str, bundle.get(str));
                if (q == null) {
                    this.a.a().r().b("Param value can't be null", this.a.F().o(str));
                } else {
                    x(bundle2, str, q);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzas H(String str, String str2, Bundle bundle, String str3, long j2, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (m0(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            Bundle r = r(str, str2, bundle3, com.google.android.gms.common.util.f.b("_o"), false);
            if (z) {
                r = G(r);
            }
            com.google.android.gms.common.internal.q.j(r);
            return new zzas(str2, new zzaq(r), str3, j2);
        }
        this.a.a().m().b("Invalid conditional property event name", this.a.F().p(str2));
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean I(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo e2 = com.google.android.gms.common.wrappers.b.a(context).e(str, 64);
            if (e2 == null || (signatureArr = e2.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e3) {
            this.a.a().m().b("Package name not found", e3);
            return true;
        } catch (CertificateException e4) {
            this.a.a().m().b("Error obtaining certificate", e4);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] J(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int L() {
        if (this.f3888f == null) {
            this.f3888f = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().a(this.a.zzaw()) / 1000);
        }
        return this.f3888f.intValue();
    }

    public final int M(int i2) {
        return GoogleApiAvailabilityLight.getInstance().g(this.a.zzaw(), com.google.android.gms.common.c.a);
    }

    public final long N(long j2, long j3) {
        return (j2 + (j3 * 60000)) / AdvTimeUtils.MILLIS_OF_A_DAY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void O(Bundle bundle, long j2) {
        long j3 = bundle.getLong("_et");
        if (j3 != 0) {
            this.a.a().p().b("Params already contained engagement", Long.valueOf(j3));
        }
        bundle.putLong("_et", j2 + j3);
    }

    public final void P(zzs zzsVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.a.a().p().b("Error returning string value to wrapper", e2);
        }
    }

    public final void Q(zzs zzsVar, long j2) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j2);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.a.a().p().b("Error returning long value to wrapper", e2);
        }
    }

    public final void R(zzs zzsVar, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i2);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.a.a().p().b("Error returning int value to wrapper", e2);
        }
    }

    public final void S(zzs zzsVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.a.a().p().b("Error returning byte array to wrapper", e2);
        }
    }

    public final void T(zzs zzsVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.a.a().p().b("Error returning boolean value to wrapper", e2);
        }
    }

    public final void U(zzs zzsVar, Bundle bundle) {
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.a.a().p().b("Error returning bundle value to wrapper", e2);
        }
    }

    public final void V(zzs zzsVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzsVar.zzb(bundle);
        } catch (RemoteException e2) {
            this.a.a().p().b("Error returning bundle list to wrapper", e2);
        }
    }

    public final URL X(long j2, String str, String str2, long j3) {
        try {
            com.google.android.gms.common.internal.q.f(str2);
            com.google.android.gms.common.internal.q.f(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 39000L, Integer.valueOf(L())), str2, str, Long.valueOf(j3));
            if (str.equals(this.a.x().C())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            this.a.a().m().b("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            return null;
        }
    }

    public final long e0() {
        long andIncrement;
        long j2;
        if (this.f3886d.get() == 0) {
            synchronized (this.f3886d) {
                long nextLong = new Random(System.nanoTime() ^ this.a.zzax().currentTimeMillis()).nextLong();
                int i2 = this.f3887e + 1;
                this.f3887e = i2;
                j2 = nextLong + i2;
            }
            return j2;
        }
        synchronized (this.f3886d) {
            this.f3886d.compareAndSet(-1L, 1L);
            andIncrement = this.f3886d.getAndIncrement();
        }
        return andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    @WorkerThread
    public final SecureRandom f0() {
        f();
        if (this.c == null) {
            this.c = new SecureRandom();
        }
        return this.c;
    }

    @Override // com.google.android.gms.measurement.internal.j5
    protected final boolean g() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.j5
    @WorkerThread
    protected final void h() {
        f();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.a.a().p().a("Utils falling back to Random for random id");
            }
        }
        this.f3886d.set(nextLong);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle h0(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    str = uri.getQueryParameter("utm_campaign");
                    str2 = uri.getQueryParameter("utm_source");
                    str3 = uri.getQueryParameter("utm_medium");
                    str4 = uri.getQueryParameter("gclid");
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("campaign", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("source", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("medium", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("gclid", str4);
                }
                String queryParameter = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
                }
                String queryParameter2 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter2);
                }
                String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
                }
                String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
                }
                String queryParameter5 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("anid", queryParameter5);
                }
                return bundle;
            } catch (UnsupportedOperationException e2) {
                this.a.a().p().b("Install referrer url isn't a hierarchical URI", e2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i0(String str, String str2) {
        if (str2 == null) {
            this.a.a().o().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.a.a().o().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.a.a().o().c("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                    this.a.a().o().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
                charCount += Character.charCount(codePointAt2);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j0(String str, String str2) {
        if (str2 == null) {
            this.a.a().o().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.a.a().o().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt != 95) {
                    this.a.a().o().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
                codePointAt = 95;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                    this.a.a().o().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
                charCount += Character.charCount(codePointAt2);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k0(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.a.a().o().b("Name is required and can't be null. Type", str);
            return false;
        }
        com.google.android.gms.common.internal.q.j(str2);
        String[] strArr3 = f3883g;
        for (int i2 = 0; i2 < 3; i2++) {
            if (str2.startsWith(strArr3[i2])) {
                this.a.a().o().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !d0(str2, strArr)) {
            return true;
        }
        if (strArr2 == null || !d0(str2, strArr2)) {
            this.a.a().o().c("Name is reserved. Type, name", str, str2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean l0(String str, int i2, String str2) {
        if (str2 == null) {
            this.a.a().o().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) > i2) {
            this.a.a().o().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i2), str2);
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (Z(str)) {
                return true;
            }
            if (this.a.I()) {
                this.a.a().o().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", k3.v(str));
            }
            return false;
        }
        zzmg.zzb();
        if (!this.a.x().u(null, x2.i0) || TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str2)) {
                if (Z(str2)) {
                    return true;
                }
                this.a.a().o().b("Invalid admob_app_id. Analytics disabled.", k3.v(str2));
                return false;
            }
            if (this.a.I()) {
                this.a.a().o().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int m0(String str) {
        if (j0("event", str)) {
            if (k0("event", m5.a, m5.b, str)) {
                this.a.x();
                return !l0("event", 40, str) ? 2 : 0;
            }
            return 13;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean n(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            com.google.android.gms.common.internal.q.j(str);
            return !str.equals(str2);
        } else if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        } else if (isEmpty) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        } else if (TextUtils.isEmpty(str4)) {
            return false;
        } else {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int n0(String str) {
        if (j0("user property", str)) {
            if (k0("user property", o5.a, null, str)) {
                this.a.x();
                return !l0("user property", 24, str) ? 6 : 0;
            }
            return 15;
        }
        return 6;
    }

    public final String o(String str, int i2, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) > i2) {
            if (z) {
                return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i2))).concat("...");
            }
            return null;
        }
        return str;
    }

    final int o0(String str) {
        if (i0("event param", str)) {
            if (k0("event param", null, null, str)) {
                this.a.x();
                return !l0("event param", 40, str) ? 3 : 0;
            }
            return 14;
        }
        return 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int p(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Object r18, android.os.Bundle r19, java.util.List<java.lang.String> r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n9.p(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    final int p0(String str) {
        if (j0("event param", str)) {
            if (k0("event param", null, null, str)) {
                this.a.x();
                return !l0("event param", 40, str) ? 3 : 0;
            }
            return 14;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object q(String str, Object obj) {
        int i2 = 256;
        if ("_ev".equals(str)) {
            this.a.x();
            return a0(256, obj, true, true);
        }
        if (D(str)) {
            this.a.x();
        } else {
            this.a.x();
            i2 = 100;
        }
        return a0(i2, obj, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean q0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle r(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List<java.lang.String> r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n9.r(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean r0(String str, String str2, int i2, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i2) {
                this.a.a().r().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void s(l3 l3Var, int i2) {
        int i3 = 0;
        for (String str : new TreeSet(l3Var.f3857d.keySet())) {
            if (g0(str) && (i3 = i3 + 1) > i2) {
                StringBuilder sb = new StringBuilder(48);
                sb.append("Event can't contain more than ");
                sb.append(i2);
                sb.append(" params");
                this.a.a().o().c(sb.toString(), this.a.F().n(l3Var.a), this.a.F().q(l3Var.f3857d));
                Y(l3Var.f3857d, 5);
                l3Var.f3857d.remove(str);
            }
        }
    }

    final void s0(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int i2;
        String str4;
        int p;
        if (bundle == null) {
            return;
        }
        this.a.x();
        int i3 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                int o0 = z ? o0(str5) : 0;
                if (o0 == 0) {
                    o0 = p0(str5);
                }
                i2 = o0;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                u(bundle, i2, str5, str5, i2 == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (q0(bundle.get(str5))) {
                    this.a.a().r().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    str4 = str5;
                    p = 22;
                } else {
                    str4 = str5;
                    p = p(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (p != 0 && !"_ev".equals(str4)) {
                    u(bundle, p, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (g0(str4) && !d0(str4, n5.f3880d) && (i3 = i3 + 1) > 0) {
                    this.a.a().o().c("Item cannot contain custom parameters", this.a.F().n(str2), this.a.F().q(bundle));
                    Y(bundle, 23);
                    bundle.remove(str4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void t(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.a.E().x(bundle, str, bundle2.get(str));
            }
        }
    }

    final void u(Bundle bundle, int i2, String str, String str2, Object obj) {
        if (Y(bundle, i2)) {
            this.a.x();
            bundle.putString("_ev", o(str, 40, true));
            if (obj != null) {
                com.google.android.gms.common.internal.q.j(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int v(String str, Object obj) {
        boolean r0;
        if ("_ldl".equals(str)) {
            r0 = r0("user property referrer", str, b0(str), obj);
        } else {
            r0 = r0("user property", str, b0(str), obj);
        }
        return r0 ? 0 : 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object w(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return a0(b0(str), obj, true, false);
        }
        return a0(b0(str), obj, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void x(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            this.a.a().r().c("Not putting event parameter. Invalid value type. name, type", this.a.F().o(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void y(m9 m9Var, String str, int i2, String str2, String str3, int i3) {
        Bundle bundle = new Bundle();
        Y(bundle, i2);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i2 == 6 || i2 == 7 || i2 == 2) {
            bundle.putLong("_el", i3);
        }
        zzkw.zzb();
        if (this.a.x().u(null, x2.A0)) {
            m9Var.zza(str, bundle);
            return;
        }
        this.a.d();
        this.a.D().V("auto", "_err", bundle);
    }
}
