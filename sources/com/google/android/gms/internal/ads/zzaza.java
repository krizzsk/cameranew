package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.adjust.sdk.Constants;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.search.SearchAdView;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.c;
import com.google.android.gms.common.util.o;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import us.pinguo.common.network.HttpRequest;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaza {
    public static final Handler zzaac = new zzdvl(Looper.getMainLooper());
    private static final String zzehj = AdView.class.getName();
    private static final String zzehk = InterstitialAd.class.getName();
    private static final String zzehl = PublisherAdView.class.getName();
    private static final String zzehm = PublisherInterstitialAd.class.getName();
    private static final String zzehn = SearchAdView.class.getName();
    private static final String zzeho = AdLoader.class.getName();
    private float zzehp = -1.0f;

    public static void zza(boolean z, HttpURLConnection httpURLConnection, @Nullable String str) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setReadTimeout(60000);
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpRequest.HEADER_USER_AGENT, str);
        }
        httpURLConnection.setUseCaches(false);
    }

    public static int zzb(DisplayMetrics displayMetrics, int i2) {
        return Math.round(i2 / displayMetrics.density);
    }

    public static String zzbm(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        return zzeq(((contentResolver == null ? null : Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ANDROID_ID)) == null || zzzw()) ? "emulator" : "emulator");
    }

    @Nullable
    public static String zzbn(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            return null;
        }
        return Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ANDROID_ID);
    }

    public static boolean zzbo(Context context) {
        int g2 = GoogleApiAvailabilityLight.getInstance().g(context, c.a);
        return g2 == 0 || g2 == 2;
    }

    public static boolean zzbp(Context context) {
        if (context.getResources().getConfiguration().orientation != 2) {
            return false;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((int) (((float) displayMetrics.heightPixels) / displayMetrics.density)) < 600;
    }

    @TargetApi(17)
    public static boolean zzbq(Context context) {
        int intValue;
        int intValue2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (o.d()) {
            defaultDisplay.getRealMetrics(displayMetrics);
            intValue = displayMetrics.heightPixels;
            intValue2 = displayMetrics.widthPixels;
        } else {
            try {
                intValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.heightPixels == intValue && displayMetrics.widthPixels == intValue2;
    }

    public static int zzbr(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int zze(Context context, int i2) {
        return zza(context.getResources().getDisplayMetrics(), i2);
    }

    public static String zzeq(String str) {
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    public static boolean zzer(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(zzadr.zzdet.get());
    }

    public static boolean zzf(Context context, int i2) {
        return GoogleApiAvailabilityLight.getInstance().g(context, i2) == 0;
    }

    public static int zzg(Context context, int i2) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context == null) {
            return -1;
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null || (configuration = resources.getConfiguration()) == null) {
            return -1;
        }
        int i3 = configuration.orientation;
        if (i2 == 0) {
            i2 = i3;
        }
        if (i2 == i3) {
            return Math.round(displayMetrics.heightPixels / displayMetrics.density);
        }
        return Math.round(displayMetrics.widthPixels / displayMetrics.density);
    }

    public static boolean zzzw() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean zzzx() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String zzzy() {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return bigInteger;
    }

    public final int zzd(Context context, int i2) {
        if (this.zzehp < 0.0f) {
            synchronized (this) {
                if (this.zzehp < 0.0f) {
                    Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics);
                    this.zzehp = displayMetrics.density;
                }
            }
        }
        return Math.round(i2 / this.zzehp);
    }

    public static int zza(DisplayMetrics displayMetrics, int i2) {
        return (int) TypedValue.applyDimension(1, i2, displayMetrics);
    }

    public final void zza(ViewGroup viewGroup, zzvs zzvsVar, String str, String str2) {
        zzazk.zzex(str2);
        zza(viewGroup, zzvsVar, str, (int) SupportMenu.CATEGORY_MASK, (int) ViewCompat.MEASURED_STATE_MASK);
    }

    public final void zza(ViewGroup viewGroup, zzvs zzvsVar, String str) {
        zza(viewGroup, zzvsVar, str, (int) ViewCompat.MEASURED_STATE_MASK, -1);
    }

    private static void zza(ViewGroup viewGroup, zzvs zzvsVar, String str, int i2, int i3) {
        if (viewGroup.getChildCount() != 0) {
            return;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(i2);
        textView.setBackgroundColor(i3);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(i2);
        int zze = zze(context, 3);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(zzvsVar.widthPixels - zze, zzvsVar.heightPixels - zze, 17));
        viewGroup.addView(frameLayout, zzvsVar.widthPixels, zzvsVar.heightPixels);
    }

    public static Throwable zzd(Throwable th) {
        if (zzadr.zzdev.get().booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th3.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th3.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzer(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else {
                    String className = stackTraceElement.getClassName();
                    if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                        arrayList.add(stackTraceElement);
                    } else {
                        arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                    }
                }
            }
            if (z) {
                if (th2 == null) {
                    th2 = new Throwable(th3.getMessage());
                } else {
                    th2 = new Throwable(th3.getMessage(), th2);
                }
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            }
        }
        return th2;
    }

    @Nullable
    public static String zza(StackTraceElement[] stackTraceElementArr, String str) {
        int i2;
        int i3;
        String str2;
        while (true) {
            i3 = i2 + 1;
            if (i3 >= stackTraceElementArr.length) {
                str2 = null;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            String className = stackTraceElement.getClassName();
            i2 = ("loadAd".equalsIgnoreCase(stackTraceElement.getMethodName()) && (zzehj.equalsIgnoreCase(className) || zzehk.equalsIgnoreCase(className) || zzehl.equalsIgnoreCase(className) || zzehm.equalsIgnoreCase(className) || zzehn.equalsIgnoreCase(className) || zzeho.equalsIgnoreCase(className))) ? 0 : i3;
        }
        str2 = stackTraceElementArr[i3].getClassName();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            StringBuilder sb = new StringBuilder();
            int i4 = 2;
            if (stringTokenizer.hasMoreElements()) {
                sb.append(stringTokenizer.nextToken());
                while (true) {
                    int i5 = i4 - 1;
                    if (i4 <= 0 || !stringTokenizer.hasMoreElements()) {
                        break;
                    }
                    sb.append(".");
                    sb.append(stringTokenizer.nextToken());
                    i4 = i5;
                }
                str = sb.toString();
            }
            if (str2 != null && !str2.contains(str)) {
                return str2;
            }
        }
        return null;
    }

    public final void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z) {
        zza(context, str, str2, bundle, true, new zzayz(this));
    }

    public static void zza(Context context, @Nullable String str, String str2, Bundle bundle, boolean z, zzazb zzazbVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString("appid", applicationContext.getPackageName());
        if (str == null) {
            int a = GoogleApiAvailabilityLight.getInstance().a(context);
            StringBuilder sb = new StringBuilder(23);
            sb.append(a);
            sb.append(".204204000");
            str = sb.toString();
        }
        bundle.putString("js", str);
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter(TapjoyAuctionFlags.AUCTION_ID, str2);
        for (String str3 : bundle.keySet()) {
            appendQueryParameter.appendQueryParameter(str3, bundle.getString(str3));
        }
        zzazbVar.zzel(appendQueryParameter.toString());
    }

    public static AdSize zza(Context context, int i2, int i3, int i4) {
        int round;
        int zzg = zzg(context, i4);
        if (zzg == -1) {
            return AdSize.INVALID;
        }
        int min = Math.min(90, Math.round(zzg * 0.15f));
        if (i2 > 655) {
            round = Math.round((i2 / 728.0f) * 90.0f);
        } else if (i2 > 632) {
            round = 81;
        } else if (i2 > 526) {
            round = Math.round((i2 / 468.0f) * 60.0f);
        } else {
            round = i2 > 432 ? 68 : Math.round((i2 / 320.0f) * 50.0f);
        }
        return new AdSize(i2, Math.max(Math.min(round, min), 50));
    }
}
