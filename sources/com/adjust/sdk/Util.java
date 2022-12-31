package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.LocaleList;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.adjust.sdk.GooglePlayServicesClient;
import com.adjust.sdk.scheduler.SingleThreadFutureScheduler;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.tapjoy.TapjoyConstants;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class Util {
    private static final String fieldReadErrorMessage = "Unable to read '%s' field in migration device with message (%s)";
    public static final DecimalFormat SecondsDisplayFormat = newLocalDecimalFormat();
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z";
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.US);
    private static volatile SingleThreadFutureScheduler playAdIdScheduler = null;

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e2) {
            getLogger().debug("Unable to check permission '%s' with message (%s)", str, e2.getMessage());
            return false;
        }
    }

    public static String convertToHex(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        return formatString("%0" + (bArr.length << 1) + "x", bigInteger);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String createUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean equalBoolean(Boolean bool, Boolean bool2) {
        return equalObject(bool, bool2);
    }

    public static boolean equalEnum(Enum r0, Enum r1) {
        return equalObject(r0, r1);
    }

    public static boolean equalInt(Integer num, Integer num2) {
        return equalObject(num, num2);
    }

    public static boolean equalLong(Long l2, Long l3) {
        return equalObject(l2, l3);
    }

    public static boolean equalObject(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return obj == null && obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean equalString(String str, String str2) {
        return equalObject(str, str2);
    }

    public static boolean equalsDouble(Double d2, Double d3) {
        return (d2 == null || d3 == null) ? d2 == null && d3 == null : Double.doubleToLongBits(d2.doubleValue()) == Double.doubleToLongBits(d3.doubleValue());
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Object getAdvertisingInfoObject(final Context context, long j2) {
        return runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<Object>() { // from class: com.adjust.sdk.Util.1
            @Override // java.util.concurrent.Callable
            public Object call() {
                try {
                    return Reflection.getAdvertisingInfoObject(context);
                } catch (Exception unused) {
                    return null;
                }
            }
        }, j2);
    }

    public static String getAndroidId(Context context) {
        return AndroidIdUtil.getAndroidId(context);
    }

    public static int getConnectivityType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e2) {
            getLogger().warn("Couldn't read connectivity type (%s)", e2.getMessage());
        }
        if (connectivityManager == null) {
            return -1;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            return connectivityManager.getActiveNetworkInfo().getType();
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return -1;
        }
        if (networkCapabilities.hasTransport(1)) {
            return 1;
        }
        if (networkCapabilities.hasTransport(0)) {
            return 0;
        }
        if (networkCapabilities.hasTransport(3)) {
            return 3;
        }
        if (networkCapabilities.hasTransport(4)) {
            return 4;
        }
        if (networkCapabilities.hasTransport(2)) {
            return 2;
        }
        if (i2 < 26) {
            return -1;
        }
        if (networkCapabilities.hasTransport(5)) {
            return 5;
        }
        return (i2 >= 27 && networkCapabilities.hasTransport(6)) ? 6 : -1;
    }

    public static String getCpuAbi() {
        if (Build.VERSION.SDK_INT < 21) {
            return Build.CPU_ABI;
        }
        return null;
    }

    public static String getFireAdvertisingId(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Boolean getFireTrackingEnabled(ContentResolver contentResolver) {
        try {
            return Boolean.valueOf(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void getGoogleAdId(Context context, final OnDeviceIdsRead onDeviceIdsRead) {
        ILogger logger = AdjustFactory.getLogger();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            logger.debug("GoogleAdId being read in the background", new Object[0]);
            String googleAdId = getGoogleAdId(context);
            logger.debug("GoogleAdId read " + googleAdId, new Object[0]);
            onDeviceIdsRead.onGoogleAdIdRead(googleAdId);
            return;
        }
        logger.debug("GoogleAdId being read in the foreground", new Object[0]);
        new AsyncTask<Context, Void, String>() { // from class: com.adjust.sdk.Util.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(Context... contextArr) {
                ILogger logger2 = AdjustFactory.getLogger();
                String googleAdId2 = Util.getGoogleAdId(contextArr[0]);
                logger2.debug("GoogleAdId read " + googleAdId2, new Object[0]);
                return googleAdId2;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(String str) {
                AdjustFactory.getLogger();
                OnDeviceIdsRead.this.onGoogleAdIdRead(str);
            }
        }.execute(context);
    }

    public static Locale getLocale(Configuration configuration) {
        LocaleList locales;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 24 || (locales = configuration.getLocales()) == null || locales.isEmpty()) {
            if (i2 < 24) {
                return configuration.locale;
            }
            return null;
        }
        return locales.get(0);
    }

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    public static String getMacAddress(Context context) {
        return MacAddressUtil.getMacAddress(context);
    }

    public static String getMcc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator)) {
                AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MCC", new Object[0]);
                return null;
            }
            return networkOperator.substring(0, 3);
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mcc", new Object[0]);
            return null;
        }
    }

    public static String getMnc(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            if (TextUtils.isEmpty(networkOperator)) {
                AdjustFactory.getLogger().warn("Couldn't receive networkOperator string to read MNC", new Object[0]);
                return null;
            }
            return networkOperator.substring(3);
        } catch (Exception unused) {
            AdjustFactory.getLogger().warn("Couldn't return mnc", new Object[0]);
            return null;
        }
    }

    public static int getNetworkType(Context context) {
        int networkType;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 30) {
                networkType = telephonyManager.getDataNetworkType();
            } else {
                networkType = telephonyManager.getNetworkType();
            }
            return networkType;
        } catch (Exception e2) {
            getLogger().warn("Couldn't read network type (%s)", e2.getMessage());
            return -1;
        }
    }

    public static String getPlayAdId(final Context context, final Object obj, long j2) {
        return (String) runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<String>() { // from class: com.adjust.sdk.Util.2
            @Override // java.util.concurrent.Callable
            public String call() {
                return Reflection.getPlayAdId(context, obj);
            }
        }, j2);
    }

    public static String getReasonString(String str, Throwable th) {
        if (th != null) {
            return formatString("%s: %s", str, th);
        }
        return formatString("%s", str);
    }

    public static String getRootCause(Exception exc) {
        if (hasRootCause(exc)) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            int indexOf = stringWriter2.indexOf("Caused by:");
            return stringWriter2.substring(indexOf, stringWriter2.indexOf("\n", indexOf));
        }
        return null;
    }

    private static String getSdkPrefix(String str) {
        String[] split;
        if (str != null && str.contains("@") && (split = str.split("@")) != null && split.length == 2) {
            return split[0];
        }
        return null;
    }

    public static String getSdkPrefixPlatform(String str) {
        String[] split;
        String sdkPrefix = getSdkPrefix(str);
        if (sdkPrefix == null || (split = sdkPrefix.split("\\d+", 2)) == null || split.length == 0) {
            return null;
        }
        return split[0];
    }

    public static String getSdkVersion() {
        return Constants.CLIENT_SDK;
    }

    public static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        return null;
    }

    public static long getWaitingTime(int i2, BackoffStrategy backoffStrategy) {
        int i3 = backoffStrategy.minRetries;
        if (i2 < i3) {
            return 0L;
        }
        return (long) (Math.min(((long) Math.pow(2.0d, i2 - i3)) * backoffStrategy.milliSecondMultiplier, backoffStrategy.maxWait) * randomInRange(backoffStrategy.minRange, backoffStrategy.maxRange));
    }

    public static boolean hasRootCause(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().contains("Caused by:");
    }

    public static String hash(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(bytes, 0, bytes.length);
            return convertToHex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static int hashBoolean(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public static int hashDouble(Double d2) {
        if (d2 == null) {
            return 0;
        }
        return d2.hashCode();
    }

    public static int hashEnum(Enum r0) {
        if (r0 == null) {
            return 0;
        }
        return r0.hashCode();
    }

    public static int hashLong(Long l2) {
        if (l2 == null) {
            return 0;
        }
        return l2.hashCode();
    }

    public static int hashObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static int hashString(String str) {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    private static boolean isEqualGoogleReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTime && referrerDetails.installBeginTimestampSeconds == activityState.installBegin && referrerDetails.referrerClickTimestampServerSeconds == activityState.clickTimeServer && referrerDetails.installBeginTimestampServerSeconds == activityState.installBeginServer && equalString(referrerDetails.installReferrer, activityState.installReferrer) && equalString(referrerDetails.installVersion, activityState.installVersion) && equalBoolean(referrerDetails.googlePlayInstant, activityState.googlePlayInstant);
    }

    private static boolean isEqualHuaweiReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeHuawei && referrerDetails.installBeginTimestampSeconds == activityState.installBeginHuawei && equalString(referrerDetails.installReferrer, activityState.installReferrerHuawei);
    }

    public static boolean isEqualReferrerDetails(ReferrerDetails referrerDetails, String str, ActivityState activityState) {
        if (str.equals(Constants.REFERRER_API_GOOGLE)) {
            return isEqualGoogleReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_HUAWEI)) {
            return isEqualHuaweiReferrerDetails(referrerDetails, activityState);
        }
        return false;
    }

    public static Boolean isPlayTrackingEnabled(final Context context, final Object obj, long j2) {
        return (Boolean) runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<Boolean>() { // from class: com.adjust.sdk.Util.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                return Reflection.isPlayTrackingEnabled(context, obj);
            }
        }, j2);
    }

    public static boolean isUrlFilteredOut(Uri uri) {
        String uri2;
        return uri == null || (uri2 = uri.toString()) == null || uri2.length() == 0 || uri2.matches(Constants.FB_AUTH_REGEX);
    }

    public static boolean isValidParameter(String str, String str2, String str3) {
        if (str == null) {
            getLogger().error("%s parameter %s is missing", str3, str2);
            return false;
        } else if (str.equals("")) {
            getLogger().error("%s parameter %s is empty", str3, str2);
            return false;
        } else {
            return true;
        }
    }

    public static String md5(String str) {
        return hash(str, Constants.MD5);
    }

    public static Map<String, String> mergeParameters(Map<String, String> map, Map<String, String> map2, String str) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        ILogger logger = getLogger();
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String str2 = (String) hashMap.put(entry.getKey(), entry.getValue());
            if (str2 != null) {
                logger.warn("Key %s with value %s from %s parameter was replaced by value %s", entry.getKey(), str2, str, entry.getValue());
            }
        }
        return hashMap;
    }

    private static DecimalFormat newLocalDecimalFormat() {
        return new DecimalFormat(IdManager.DEFAULT_VERSION_NAME, new DecimalFormatSymbols(Locale.US));
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        return !Pattern.compile("\\s").matcher(str).find() ? str : formatString("'%s'", str);
    }

    private static double randomInRange(double d2, double d3) {
        return (new Random().nextDouble() * (d3 - d2)) + d2;
    }

    public static boolean readBooleanField(ObjectInputStream.GetField getField, String str, boolean z) {
        try {
            return getField.get(str, z);
        } catch (Exception e2) {
            getLogger().debug(fieldReadErrorMessage, str, e2.getMessage());
            return z;
        }
    }

    public static int readIntField(ObjectInputStream.GetField getField, String str, int i2) {
        try {
            return getField.get(str, i2);
        } catch (Exception e2) {
            getLogger().debug(fieldReadErrorMessage, str, e2.getMessage());
            return i2;
        }
    }

    public static long readLongField(ObjectInputStream.GetField getField, String str, long j2) {
        try {
            return getField.get(str, j2);
        } catch (Exception e2) {
            getLogger().debug(fieldReadErrorMessage, str, e2.getMessage());
            return j2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> T readObject(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.Class<T> r10) {
        /*
            r0 = 0
            r1 = 2
            r2 = 0
            r3 = 1
            java.io.FileInputStream r7 = r7.openFileInput(r8)     // Catch: java.lang.Exception -> L7d java.io.FileNotFoundException -> L8f
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r8.<init>(r7)     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            java.io.ObjectInputStream r7 = new java.io.ObjectInputStream     // Catch: java.lang.Exception -> L6b java.io.FileNotFoundException -> L71
            r7.<init>(r8)     // Catch: java.lang.Exception -> L6b java.io.FileNotFoundException -> L71
            java.lang.Object r8 = r7.readObject()     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            java.lang.Object r0 = r10.cast(r8)     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            com.adjust.sdk.ILogger r8 = getLogger()     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            java.lang.String r10 = "Read %s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            r4[r2] = r9     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            r4[r3] = r0     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            r8.debug(r10, r4)     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            goto La0
        L2b:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            java.lang.String r4 = "Failed to read %s object (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r5[r2] = r9     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r5[r3] = r8     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r10.error(r4, r5)     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            goto La0
        L41:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            java.lang.String r4 = "Failed to cast %s object (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r5[r2] = r9     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r5[r3] = r8     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r10.error(r4, r5)     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            goto La0
        L56:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            java.lang.String r4 = "Failed to find %s class (%s)"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r5[r2] = r9     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r5[r3] = r8     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            r10.error(r4, r5)     // Catch: java.lang.Exception -> L74 java.io.FileNotFoundException -> L79
            goto La0
        L6b:
            r7 = move-exception
            r6 = r8
            r8 = r7
            r7 = r0
            r0 = r6
            goto L7f
        L71:
            r7 = r0
            r0 = r8
            goto L90
        L74:
            r8 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L7f
        L79:
            r6 = r0
            r0 = r7
            r7 = r6
            goto L90
        L7d:
            r8 = move-exception
            r7 = r0
        L7f:
            com.adjust.sdk.ILogger r10 = getLogger()
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r2] = r9
            r4[r3] = r8
            java.lang.String r8 = "Failed to open %s file for reading (%s)"
            r10.error(r8, r4)
            goto L9d
        L8f:
            r7 = r0
        L90:
            com.adjust.sdk.ILogger r8 = getLogger()
            java.lang.Object[] r10 = new java.lang.Object[r3]
            r10[r2] = r9
            java.lang.String r4 = "%s file not found"
            r8.debug(r4, r10)
        L9d:
            r6 = r0
            r0 = r7
            r7 = r6
        La0:
            if (r7 == 0) goto Lb6
            r7.close()     // Catch: java.lang.Exception -> La6
            goto Lb6
        La6:
            r7 = move-exception
            com.adjust.sdk.ILogger r8 = getLogger()
            java.lang.Object[] r10 = new java.lang.Object[r1]
            r10[r2] = r9
            r10[r3] = r7
            java.lang.String r7 = "Failed to close %s file for reading (%s)"
            r8.error(r7, r10)
        Lb6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.Util.readObject(android.content.Context, java.lang.String, java.lang.String, java.lang.Class):java.lang.Object");
    }

    public static <T> T readObjectField(ObjectInputStream.GetField getField, String str, T t) {
        try {
            return (T) getField.get(str, t);
        } catch (Exception e2) {
            getLogger().debug(fieldReadErrorMessage, str, e2.getMessage());
            return t;
        }
    }

    public static String readStringField(ObjectInputStream.GetField getField, String str, String str2) {
        return (String) readObjectField(getField, str, str2);
    }

    public static boolean resolveContentProvider(Context context, String str) {
        try {
            return context.getPackageManager().resolveContentProvider(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void runInBackground(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            runnable.run();
        } else {
            new AsyncTask<Object, Void, Void>() { // from class: com.adjust.sdk.Util.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Object... objArr) {
                    ((Runnable) objArr[0]).run();
                    return null;
                }
            }.execute(runnable);
        }
    }

    private static <R> R runSyncInPlayAdIdSchedulerWithTimeout(Context context, Callable<R> callable, long j2) {
        if (playAdIdScheduler == null) {
            synchronized (Util.class) {
                if (playAdIdScheduler == null) {
                    playAdIdScheduler = new SingleThreadFutureScheduler("PlayAdIdLibrary", true);
                }
            }
        }
        try {
            return (R) playAdIdScheduler.scheduleFutureWithReturn(callable, 0L).get(j2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    public static String sha1(String str) {
        return hash(str, Constants.SHA1);
    }

    public static String sha256(String str) {
        return hash(str, Constants.SHA256);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> void writeObject(T r5, android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            java.io.FileOutputStream r6 = r6.openFileOutput(r7, r2)     // Catch: java.lang.Exception -> L37
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> L35
            r7.<init>(r6)     // Catch: java.lang.Exception -> L35
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch: java.lang.Exception -> L32
            r6.<init>(r7)     // Catch: java.lang.Exception -> L32
            r6.writeObject(r5)     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            com.adjust.sdk.ILogger r7 = getLogger()     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            java.lang.String r3 = "Wrote %s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            r4[r2] = r8     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            r4[r1] = r5     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            r7.debug(r3, r4)     // Catch: java.io.NotSerializableException -> L24 java.lang.Exception -> L35
            goto L48
        L24:
            com.adjust.sdk.ILogger r5 = getLogger()     // Catch: java.lang.Exception -> L35
            java.lang.String r7 = "Failed to serialize %s"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L35
            r3[r2] = r8     // Catch: java.lang.Exception -> L35
            r5.error(r7, r3)     // Catch: java.lang.Exception -> L35
            goto L48
        L32:
            r5 = move-exception
            r6 = r7
            goto L39
        L35:
            r5 = move-exception
            goto L39
        L37:
            r5 = move-exception
            r6 = 0
        L39:
            com.adjust.sdk.ILogger r7 = getLogger()
            java.lang.Object[] r3 = new java.lang.Object[r0]
            r3[r2] = r8
            r3[r1] = r5
            java.lang.String r5 = "Failed to open %s for writing (%s)"
            r7.error(r5, r3)
        L48:
            if (r6 == 0) goto L5e
            r6.close()     // Catch: java.lang.Exception -> L4e
            goto L5e
        L4e:
            r5 = move-exception
            com.adjust.sdk.ILogger r6 = getLogger()
            java.lang.Object[] r7 = new java.lang.Object[r0]
            r7[r2] = r8
            r7[r1] = r5
            java.lang.String r5 = "Failed to close %s file for writing (%s)"
            r6.error(r5, r7)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.Util.writeObject(java.lang.Object, android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getGoogleAdId(Context context) {
        Object advertisingInfoObject;
        String str = null;
        try {
            GooglePlayServicesClient.GooglePlayServicesInfo googlePlayServicesInfo = GooglePlayServicesClient.getGooglePlayServicesInfo(context, 11000L);
            if (googlePlayServicesInfo != null) {
                str = googlePlayServicesInfo.getGpsAdid();
            }
        } catch (Exception unused) {
        }
        return (str != null || (advertisingInfoObject = getAdvertisingInfoObject(context, 11000L)) == null) ? str : getPlayAdId(context, advertisingInfoObject, 1000L);
    }
}
