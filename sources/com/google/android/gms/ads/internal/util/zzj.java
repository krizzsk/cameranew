package com.google.android.gms.ads.internal.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.internal.ads.zzaaw;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzacr;
import com.google.android.gms.internal.ads.zzadr;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzaze;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzdvl;
import com.google.android.gms.internal.ads.zzdzk;
import com.google.android.gms.internal.ads.zzdzw;
import com.google.android.gms.internal.ads.zzeqn;
import com.google.android.gms.internal.ads.zzwr;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.common.network.HttpRequest;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzj {
    public static final zzdvl zzeen = new zzg(Looper.getMainLooper());
    @GuardedBy("userAgentLock")

    /* renamed from: e  reason: collision with root package name */
    private String f3496e;
    private AtomicReference<Pattern> a = new AtomicReference<>(null);
    private AtomicReference<Pattern> b = new AtomicReference<>(null);
    private boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    private final Object f3495d = new Object();

    /* renamed from: f  reason: collision with root package name */
    private boolean f3497f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3498g = false;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f3499h = Executors.newSingleThreadExecutor();

    private static Bundle a(Context context) {
        try {
            return com.google.android.gms.common.wrappers.b.a(context).c(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            zzd.zza("Error getting metadata", e2);
            return null;
        }
    }

    private final JSONArray d(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            e(jSONArray, it.next());
        }
        return jSONArray;
    }

    private final void e(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(zzj((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(d((Collection) obj));
        } else if (obj instanceof Object[]) {
            JSONArray jSONArray2 = new JSONArray();
            for (Object obj2 : (Object[]) obj) {
                e(jSONArray2, obj2);
            }
            jSONArray.put(jSONArray2);
        } else {
            jSONArray.put(obj);
        }
    }

    private final void f(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzc((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, zzj((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, d((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, d(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    private static boolean h(String str, AtomicReference<Pattern> atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String i(Context context) {
        try {
            return new WebView(context).getSettings().getUserAgentString();
        } catch (Throwable unused) {
            return o();
        }
    }

    @Nullable
    private static KeyguardManager j(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    private static String k(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        return TextUtils.isEmpty(string) ? "" : (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) ? string : "";
    }

    private static Bitmap m(@NonNull View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width != 0 && height != 0) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(createBitmap);
                view.layout(0, 0, width, height);
                view.draw(canvas);
                return createBitmap;
            }
            zzazk.zzex("Width or height of view is zero");
            return null;
        } catch (RuntimeException e2) {
            zzazk.zzc("Fail to capture the webview", e2);
            return null;
        }
    }

    private static Bitmap n(@NonNull View view) {
        try {
            boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            r0 = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
            view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        } catch (RuntimeException e2) {
            zzazk.zzc("Fail to capture the web view", e2);
        }
        return r0;
    }

    private static String o() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb.append("; ");
            sb.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb.append(" Build/");
                sb.append(str3);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    private static int[] p() {
        return new int[]{0, 0};
    }

    public static AlertDialog.Builder zzan(Context context) {
        return new AlertDialog.Builder(context);
    }

    public static zzaaw zzao(Context context) {
        return new zzaaw(context);
    }

    @SuppressLint({"NewApi"})
    public static String zzap(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        ComponentName componentName;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && (runningTaskInfo = runningTasks.get(0)) != null && (componentName = runningTaskInfo.topActivity) != null) {
                return componentName.getClassName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean zzaq(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Process.myPid() == runningAppProcessInfo.pid) {
                    if (runningAppProcessInfo.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return true;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return !(powerManager == null ? false : powerManager.isScreenOn());
                }
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int zzar(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return 0;
        }
        return applicationInfo.targetSdkVersion;
    }

    @TargetApi(16)
    public static boolean zzat(Context context) {
        KeyguardManager j2;
        return context != null && com.google.android.gms.common.util.o.c() && (j2 = j(context)) != null && j2.isKeyguardLocked();
    }

    public static boolean zzau(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzazk.zzc("Error loading class.", th);
            com.google.android.gms.ads.internal.zzr.zzkv().zza(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static String zzav(Context context) {
        return !((Boolean) zzwr.zzqr().zzd(zzabp.zzcxr)).booleanValue() ? "" : context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
    }

    public static Bundle zzaw(Context context) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxs)).booleanValue()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Bundle bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i2 = 0; i2 < 4; i2++) {
                String str = strArr[i2];
                if (defaultSharedPreferences.contains(str)) {
                    bundle.putString(str, defaultSharedPreferences.getString(str, null));
                }
            }
            return bundle;
        }
        return null;
    }

    public static boolean zzax(Context context) {
        Window window;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null && window.getDecorView() != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom != 0 && rect2.bottom != 0 && rect.top == rect2.top) {
                return true;
            }
        }
        return false;
    }

    public static String zzay(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return k(a(context));
    }

    public static boolean zzaz(Context context) {
        Bundle a = a(context);
        return TextUtils.isEmpty(k(a)) && !TextUtils.isEmpty(a.getString("com.google.android.gms.ads.INTEGRATION_MANAGER"));
    }

    public static void zzb(Context context, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            new zzbq(context, str, (String) obj).zzye();
        }
    }

    public static boolean zzba(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @TargetApi(26)
    public static void zzbb(Context context) {
        if (com.google.android.gms.common.util.o.k()) {
            NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    public static boolean zzbc(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static zzbg zzbd(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzazk.zzev("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            if (queryLocalInterface instanceof zzbg) {
                return (zzbg) queryLocalInterface;
            }
            return new zzbi(iBinder);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    @Nullable
    public static WebResourceResponse zzd(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(HttpRequest.HEADER_USER_AGENT, com.google.android.gms.ads.internal.zzr.zzkr().zzq(context, str));
            hashMap.put(HttpRequest.HEADER_CACHE_CONTROL, "max-stale=3600");
            String str3 = new zzay(context).zzb(str2, hashMap).get(60L, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
            return null;
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e2) {
            zzazk.zzd("Could not fetch MRAID JS.", e2);
            return null;
        }
    }

    public static int zzdf(int i2) {
        if (i2 >= 5000) {
            return i2;
        }
        if (i2 > 0) {
            StringBuilder sb = new StringBuilder(97);
            sb.append("HTTP timeout too low: ");
            sb.append(i2);
            sb.append(" milliseconds. Reverting to default timeout: 60000 milliseconds.");
            zzazk.zzex(sb.toString());
            return 60000;
        }
        return 60000;
    }

    public static int zzeg(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
            sb.append("Could not parse value:");
            sb.append(valueOf);
            zzazk.zzex(sb.toString());
            return 0;
        }
    }

    public static boolean zzeh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)");
    }

    public static boolean zzek(String str) {
        if (zzaze.isEnabled()) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvi)).booleanValue()) {
                String str2 = (String) zzwr.zzqr().zzd(zzabp.zzcvk);
                if (!str2.isEmpty()) {
                    for (String str3 : str2.split(";")) {
                        if (str3.equals(str)) {
                            return false;
                        }
                    }
                }
                String str4 = (String) zzwr.zzqr().zzd(zzabp.zzcvj);
                if (str4.isEmpty()) {
                    return true;
                }
                for (String str5 : str4.split(";")) {
                    if (str5.equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static int[] zzf(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        return (window == null || (findViewById = window.findViewById(16908290)) == null) ? p() : new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    public static Map<String, String> zzg(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str, uri.getQueryParameter(str));
            }
        }
        return hashMap;
    }

    public static Bitmap zzm(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap zzn(View view) {
        if (view == null) {
            return null;
        }
        Bitmap n = n(view);
        return n == null ? m(view) : n;
    }

    public static boolean zzp(Context context, String str) {
        Context zzx = zzaul.zzx(context);
        return com.google.android.gms.common.wrappers.b.a(zzx).b(str, zzx.getPackageName()) == 0;
    }

    public static int zzr(@Nullable View view) {
        if (view == null) {
            return -1;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof AdapterView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            return -1;
        }
        return ((AdapterView) parent).getPositionForView(view);
    }

    public static boolean zzs(@Nullable View view) {
        if (view == null) {
            return false;
        }
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof ScrollView)) {
            parent = parent.getParent();
        }
        return parent != null;
    }

    public static String zzyy() {
        return UUID.randomUUID().toString();
    }

    public static String zzyz() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    public static String zzzb() {
        Resources resources = com.google.android.gms.ads.internal.zzr.zzkv().getResources();
        return resources != null ? resources.getString(R.string.s7) : "Test Ad";
    }

    public final void zza(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2, int i2) {
        int zzdf = zzdf(i2);
        StringBuilder sb = new StringBuilder(39);
        sb.append("HTTP timeout: ");
        sb.append(zzdf);
        sb.append(" milliseconds.");
        zzazk.zzew(sb.toString());
        httpURLConnection.setConnectTimeout(zzdf);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(zzdf);
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_USER_AGENT, zzq(context, str));
        httpURLConnection.setUseCaches(false);
    }

    public final boolean zzak(Context context) {
        if (this.f3497f) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver(new c0(this, null), intentFilter);
        this.f3497f = true;
        return true;
    }

    public final boolean zzal(Context context) {
        if (this.f3498g) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        context.getApplicationContext().registerReceiver(new a0(this, null), intentFilter);
        this.f3498g = true;
        return true;
    }

    public final JSONObject zzc(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            f(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public final boolean zzei(String str) {
        return h(str, this.a, (String) zzwr.zzqr().zzd(zzabp.zzcoe));
    }

    public final boolean zzej(String str) {
        return h(str, this.b, (String) zzwr.zzqr().zzd(zzabp.zzcof));
    }

    public final zzdzw<Map<String, String>> zzh(final Uri uri) {
        return zzdzk.zza(new Callable(uri) { // from class: com.google.android.gms.ads.internal.util.x
            private final Uri a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = uri;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Uri uri2 = this.a;
                return com.google.android.gms.ads.internal.zzr.zzkr();
            }
        }, this.f3499h);
    }

    public final JSONObject zzj(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                f(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            throw new JSONException(valueOf.length() != 0 ? "Could not convert map to JSON: ".concat(valueOf) : new String("Could not convert map to JSON: "));
        }
    }

    public final String zzq(Context context, String str) {
        synchronized (this.f3495d) {
            String str2 = this.f3496e;
            if (str2 != null) {
                return str2;
            }
            if (str == null) {
                return o();
            }
            try {
                this.f3496e = com.google.android.gms.ads.internal.zzr.zzkt().getDefaultUserAgent(context);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(this.f3496e)) {
                zzwr.zzqn();
                if (!zzaza.zzzx()) {
                    this.f3496e = null;
                    zzeen.post(new y(this, context));
                    while (this.f3496e == null) {
                        try {
                            this.f3495d.wait();
                        } catch (InterruptedException unused2) {
                            String o = o();
                            this.f3496e = o;
                            String valueOf = String.valueOf(o);
                            zzazk.zzex(valueOf.length() != 0 ? "Interrupted, use default user agent: ".concat(valueOf) : new String("Interrupted, use default user agent: "));
                        }
                    }
                } else {
                    this.f3496e = i(context);
                }
            }
            String valueOf2 = String.valueOf(this.f3496e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 10 + String.valueOf(str).length());
            sb.append(valueOf2);
            sb.append(" (Mobile; ");
            sb.append(str);
            this.f3496e = sb.toString();
            try {
                if (com.google.android.gms.common.wrappers.b.a(context).f()) {
                    this.f3496e = String.valueOf(this.f3496e).concat(";aia");
                }
            } catch (Exception e2) {
                com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "AdUtil.getUserAgent");
            }
            String concat = String.valueOf(this.f3496e).concat(")");
            this.f3496e = concat;
            return concat;
        }
    }

    public static int[] zzh(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        int[] p = (window == null || (findViewById = window.findViewById(16908290)) == null) ? p() : new int[]{findViewById.getTop(), findViewById.getBottom()};
        return new int[]{zzwr.zzqn().zzd(activity, p[0]), zzwr.zzqn().zzd(activity, p[1])};
    }

    public static AlertDialog.Builder zzc(Context context, int i2) {
        return new AlertDialog.Builder(context, i2);
    }

    @TargetApi(18)
    public static void zzb(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzb(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(uri2).length() + 26);
            sb.append("Opening ");
            sb.append(uri2);
            sb.append(" in a new browser.");
            zzazk.zzdy(sb.toString());
        } catch (ActivityNotFoundException e2) {
            zzazk.zzc("No browser is found.", e2);
        }
    }

    public static void zzc(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            runnable.run();
        } else {
            zzazp.zzeic.execute(runnable);
        }
    }

    public static String zzr(Context context, String str) {
        try {
            return new String(com.google.android.gms.common.util.k.d(context.openFileInput(str), true), "UTF-8");
        } catch (IOException unused) {
            zzazk.zzdy("Error reading from internal storage.");
            return "";
        }
    }

    public static int[] zzg(Activity activity) {
        int[] zzf = zzf(activity);
        return new int[]{zzwr.zzqn().zzd(activity, zzf[0]), zzwr.zzqn().zzd(activity, zzf[1])};
    }

    public static void zzc(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes("UTF-8"));
            openFileOutput.close();
        } catch (Exception e2) {
            zzazk.zzc("Error writing to file in internal storage.", e2);
        }
    }

    @TargetApi(18)
    public final zzacr zza(Context context, Uri uri) {
        zzacr zzacrVar;
        if (!com.google.android.gms.common.util.o.e()) {
            zzd.zzeb("Chrome Custom Tabs can only work with version Jellybean onwards.");
            zzacrVar = zzacr.PLATFORM_VERSION_TOO_LOW;
        } else if (context == null) {
            zzd.zzeb("Trying to open chrome custom tab on a null context");
            zzacrVar = zzacr.CONTEXT_NULL;
        } else if (!(context instanceof Activity)) {
            zzd.zzeb("Chrome Custom Tabs can only work with Activity context.");
            zzacrVar = zzacr.CONTEXT_NOT_AN_ACTIVITY;
        } else if (zzeqn.zzcl(context) == null) {
            zzd.zzeb("Default browser does not support custom tabs.");
            zzacrVar = zzacr.CCT_NOT_SUPPORTED;
        } else {
            zzacrVar = null;
        }
        zzaba<Boolean> zzabaVar = zzabp.zzcus;
        zzaba<Boolean> zzabaVar2 = zzabp.zzcut;
        if (((Boolean) zzwr.zzqr().zzd(zzabaVar)).equals(zzwr.zzqr().zzd(zzabaVar2))) {
            zzacrVar = zzacr.WRONG_EXP_SETUP;
        }
        if (zzacrVar != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            context.startActivity(intent);
            return zzacrVar;
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabaVar)).booleanValue()) {
            zzacp zzacpVar = new zzacp();
            zzacpVar.zza(new z(this, zzacpVar, context, uri));
            zzacpVar.zzd((Activity) context);
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabaVar2)).booleanValue()) {
            new CustomTabsIntent.Builder().build().launchUrl(context, uri);
        }
        return zzacr.CCT_READY_TO_OPEN;
    }

    public static WebResourceResponse zzd(HttpURLConnection httpURLConnection) throws IOException {
        com.google.android.gms.ads.internal.zzr.zzkr();
        String contentType = httpURLConnection.getContentType();
        String str = "";
        String trim = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
        com.google.android.gms.ads.internal.zzr.zzkr();
        String contentType2 = httpURLConnection.getContentType();
        if (!TextUtils.isEmpty(contentType2)) {
            String[] split = contentType2.split(";");
            if (split.length != 1) {
                int i2 = 1;
                while (true) {
                    if (i2 >= split.length) {
                        break;
                    }
                    if (split[i2].trim().startsWith(HttpRequest.PARAM_CHARSET)) {
                        String[] split2 = split[i2].trim().split("=");
                        if (split2.length > 1) {
                            str = split2[1].trim();
                            break;
                        }
                    }
                    i2++;
                }
            }
        }
        String str2 = str;
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        HashMap hashMap = new HashMap(headerFields.size());
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && entry.getValue().size() > 0) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return com.google.android.gms.ads.internal.zzr.zzkt().zza(trim, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
    }

    @TargetApi(18)
    public static void zzb(Context context, Intent intent) {
        if (intent != null && com.google.android.gms.common.util.o.e()) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder(CustomTabsIntent.EXTRA_SESSION, null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zzq(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 == 0) goto L12
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L12
            android.app.Activity r2 = (android.app.Activity) r2
            goto L13
        L12:
            r2 = r0
        L13:
            r1 = 0
            if (r2 != 0) goto L17
            return r1
        L17:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L1e
            goto L22
        L1e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L22:
            if (r0 == 0) goto L2d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L2d
            r2 = 1
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzj.zzq(android.view.View):boolean");
    }

    public static String zza(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
            }
        }
    }

    public static boolean zza(ClassLoader classLoader, Class<?> cls, List<String> list) {
        for (String str : list) {
            if (Class.forName(str, false, classLoader).isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public final JSONObject zza(@Nullable Bundle bundle, JSONObject jSONObject) {
        if (bundle != null) {
            try {
                return zzc(bundle);
            } catch (JSONException e2) {
                zzazk.zzc("Error converting Bundle to JSON", e2);
            }
        }
        return null;
    }

    public static DisplayMetrics zza(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static PopupWindow zza(View view, int i2, int i3, boolean z) {
        return new PopupWindow(view, i2, i3, false);
    }

    public final void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        com.google.android.gms.ads.internal.zzr.zzkr();
        bundle.putString(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zzyz());
        bundle.putString("eids", TextUtils.join(",", zzabp.zzsc()));
        zzwr.zzqn();
        zzaza.zza(context, str, str2, bundle, true, new b0(this, context, str));
    }

    public static void zza(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            context.startActivity(intent);
        }
    }

    public final boolean zza(View view, Context context) {
        Context applicationContext = context.getApplicationContext();
        return zza(view, applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null, j(context));
    }

    public static boolean zza(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z;
        if (!com.google.android.gms.ads.internal.zzr.zzkr().c) {
            if ((keyguardManager == null ? false : keyguardManager.inKeyguardRestrictedInputMode()) && !zzq(view)) {
                z = false;
                if (view.getVisibility() == 0 && view.isShown()) {
                    if ((powerManager != null || powerManager.isScreenOn()) && z) {
                        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcqq)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        z = true;
        if (view.getVisibility() == 0) {
            if (powerManager != null || powerManager.isScreenOn()) {
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcqq)).booleanValue()) {
                }
                return true;
            }
        }
        return false;
    }

    public static void zza(Context context, Throwable th) {
        if (context == null) {
            return;
        }
        boolean z = false;
        try {
            z = zzadr.zzder.get().booleanValue();
        } catch (IllegalStateException unused) {
        }
        if (z) {
            com.google.android.gms.common.util.g.a(context, th);
        }
    }

    public static void zza(DownloadManager.Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
    }
}
