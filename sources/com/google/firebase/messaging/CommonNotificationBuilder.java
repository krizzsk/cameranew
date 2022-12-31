package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.google.firebase.iid.ServiceStarter;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.concurrent.atomic.AtomicInteger;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes2.dex */
public final class CommonNotificationBuilder {
    public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL = "fcm_fallback_notification_channel";
    public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL_LABEL = "fcm_fallback_notification_channel_label";
    public static final String METADATA_DEFAULT_CHANNEL_ID = "com.google.firebase.messaging.default_notification_channel_id";
    public static final String METADATA_DEFAULT_COLOR = "com.google.firebase.messaging.default_notification_color";
    public static final String METADATA_DEFAULT_ICON = "com.google.firebase.messaging.default_notification_icon";
    private static final AtomicInteger requestCodeProvider = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
    /* loaded from: classes2.dex */
    public static class DisplayNotificationInfo {
        public final int id = 0;
        public final NotificationCompat.Builder notificationBuilder;
        public final String tag;

        DisplayNotificationInfo(NotificationCompat.Builder builder, String str, int i2) {
            this.notificationBuilder = builder;
            this.tag = str;
        }
    }

    private CommonNotificationBuilder() {
    }

    @Nullable
    private static PendingIntent createContentIntent(Context context, NotificationParams notificationParams, String str, PackageManager packageManager) {
        Intent createTargetIntent = createTargetIntent(str, notificationParams, packageManager);
        if (createTargetIntent == null) {
            return null;
        }
        createTargetIntent.addFlags(67108864);
        createTargetIntent.putExtras(notificationParams.paramsWithReservedKeysRemoved());
        int generatePendingIntentRequestCode = generatePendingIntentRequestCode();
        VdsAgent.onPendingIntentGetActivityShortBefore(context, generatePendingIntentRequestCode, createTargetIntent, 1073741824);
        PendingIntent activity = PendingIntent.getActivity(context, generatePendingIntentRequestCode, createTargetIntent, 1073741824);
        VdsAgent.onPendingIntentGetActivityShortAfter(context, generatePendingIntentRequestCode, createTargetIntent, 1073741824, activity);
        return shouldUploadMetrics(notificationParams) ? wrapContentIntent(context, notificationParams, activity) : activity;
    }

    @Nullable
    private static PendingIntent createDeleteIntent(Context context, NotificationParams notificationParams) {
        if (shouldUploadMetrics(notificationParams)) {
            return createMessagingPendingIntent(context, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(notificationParams.paramsForAnalyticsIntent()));
        }
        return null;
    }

    private static PendingIntent createMessagingPendingIntent(Context context, Intent intent) {
        int generatePendingIntentRequestCode = generatePendingIntentRequestCode();
        Intent putExtra = new Intent(ServiceStarter.ACTION_MESSAGING_EVENT).setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent);
        VdsAgent.onPendingIntentGetBroadcastBefore(context, generatePendingIntentRequestCode, putExtra, 1073741824);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, generatePendingIntentRequestCode, putExtra, 1073741824);
        VdsAgent.onPendingIntentGetBroadcastAfter(context, generatePendingIntentRequestCode, putExtra, 1073741824, broadcast);
        return broadcast;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayNotificationInfo createNotificationInfo(Context context, NotificationParams notificationParams) {
        Bundle manifestMetadata = getManifestMetadata(context.getPackageManager(), context.getPackageName());
        return createNotificationInfo(context, context.getPackageName(), notificationParams, getOrCreateChannel(context, notificationParams.getNotificationChannelId(), manifestMetadata), context.getResources(), context.getPackageManager(), manifestMetadata);
    }

    private static Intent createTargetIntent(String str, NotificationParams notificationParams, PackageManager packageManager) {
        String string = notificationParams.getString(Constants.MessageNotificationKeys.CLICK_ACTION);
        if (!TextUtils.isEmpty(string)) {
            Intent intent = new Intent(string);
            intent.setPackage(str);
            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            return intent;
        }
        Uri link = notificationParams.getLink();
        if (link != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setPackage(str);
            intent2.setData(link);
            return intent2;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            Log.w(Constants.TAG, "No activity found to launch app");
        }
        return launchIntentForPackage;
    }

    private static int generatePendingIntentRequestCode() {
        return requestCodeProvider.incrementAndGet();
    }

    private static Integer getColor(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 56);
                sb.append("Color is invalid: ");
                sb.append(str);
                sb.append(". Notification will use default color.");
                Log.w(Constants.TAG, sb.toString());
            }
        }
        int i2 = bundle.getInt(METADATA_DEFAULT_COLOR, 0);
        if (i2 != 0) {
            try {
                return Integer.valueOf(ContextCompat.getColor(context, i2));
            } catch (Resources.NotFoundException unused2) {
                Log.w(Constants.TAG, "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    private static int getConsolidatedDefaults(NotificationParams notificationParams) {
        boolean z = notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_SOUND);
        ?? r0 = z;
        if (notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_VIBRATE_TIMINGS)) {
            r0 = (z ? 1 : 0) | true;
        }
        return notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_LIGHT_SETTINGS) ? r0 | 4 : r0;
    }

    private static Bundle getManifestMetadata(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w(Constants.TAG, sb.toString());
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    @VisibleForTesting
    public static String getOrCreateChannel(Context context, String str, Bundle bundle) {
        String string;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion >= 26) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                if (!TextUtils.isEmpty(str)) {
                    if (notificationManager.getNotificationChannel(str) != null) {
                        return str;
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                    sb.append("Notification Channel requested (");
                    sb.append(str);
                    sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                    Log.w(Constants.TAG, sb.toString());
                }
                String string2 = bundle.getString(METADATA_DEFAULT_CHANNEL_ID);
                if (!TextUtils.isEmpty(string2)) {
                    if (notificationManager.getNotificationChannel(string2) != null) {
                        return string2;
                    }
                    Log.w(Constants.TAG, "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                } else {
                    Log.w(Constants.TAG, "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                }
                if (notificationManager.getNotificationChannel(FCM_FALLBACK_NOTIFICATION_CHANNEL) == null) {
                    int identifier = context.getResources().getIdentifier(FCM_FALLBACK_NOTIFICATION_CHANNEL_LABEL, TypedValues.Custom.S_STRING, context.getPackageName());
                    if (identifier == 0) {
                        Log.e(Constants.TAG, "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                        string = "Misc";
                    } else {
                        string = context.getString(identifier);
                    }
                    notificationManager.createNotificationChannel(new NotificationChannel(FCM_FALLBACK_NOTIFICATION_CHANNEL, string, 3));
                }
                return FCM_FALLBACK_NOTIFICATION_CHANNEL;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static int getSmallIcon(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && isValidIcon(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && isValidIcon(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 61);
            sb.append("Icon resource ");
            sb.append(str2);
            sb.append(" not found. Notification will use default icon.");
            Log.w(Constants.TAG, sb.toString());
        }
        int i2 = bundle.getInt(METADATA_DEFAULT_ICON, 0);
        if (i2 == 0 || !isValidIcon(resources, i2)) {
            try {
                i2 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w(Constants.TAG, sb2.toString());
            }
        }
        if (i2 == 0 || !isValidIcon(resources, i2)) {
            return 17301651;
        }
        return i2;
    }

    private static Uri getSound(String str, NotificationParams notificationParams, Resources resources) {
        String soundResourceName = notificationParams.getSoundResourceName();
        if (TextUtils.isEmpty(soundResourceName)) {
            return null;
        }
        if (!IADStatisticBase.VARCHAR_DEFALUT_VALUE.equals(soundResourceName) && resources.getIdentifier(soundResourceName, "raw", str) != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(soundResourceName).length());
            sb.append("android.resource://");
            sb.append(str);
            sb.append("/raw/");
            sb.append(soundResourceName);
            return Uri.parse(sb.toString());
        }
        return RingtoneManager.getDefaultUri(2);
    }

    private static String getTag(NotificationParams notificationParams) {
        String string = notificationParams.getString(Constants.MessageNotificationKeys.TAG);
        if (TextUtils.isEmpty(string)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb = new StringBuilder(37);
            sb.append("FCM-Notification:");
            sb.append(uptimeMillis);
            return sb.toString();
        }
        return string;
    }

    @TargetApi(26)
    private static boolean isValidIcon(Resources resources, int i2) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (resources.getDrawable(i2, null) instanceof AdaptiveIconDrawable) {
                StringBuilder sb = new StringBuilder(77);
                sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
                sb.append(i2);
                Log.e(Constants.TAG, sb.toString());
                return false;
            }
            return true;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i2);
            sb2.append(", treating it as an invalid icon");
            Log.e(Constants.TAG, sb2.toString());
            return false;
        }
    }

    static boolean shouldUploadMetrics(@NonNull NotificationParams notificationParams) {
        return notificationParams.getBoolean(Constants.AnalyticsKeys.ENABLED);
    }

    private static PendingIntent wrapContentIntent(Context context, NotificationParams notificationParams, PendingIntent pendingIntent) {
        return createMessagingPendingIntent(context, new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(notificationParams.paramsForAnalyticsIntent()).putExtra("pending_intent", pendingIntent));
    }

    public static DisplayNotificationInfo createNotificationInfo(Context context, String str, NotificationParams notificationParams, String str2, Resources resources, PackageManager packageManager, Bundle bundle) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, str2);
        String possiblyLocalizedString = notificationParams.getPossiblyLocalizedString(resources, str, Constants.MessageNotificationKeys.TITLE);
        if (!TextUtils.isEmpty(possiblyLocalizedString)) {
            builder.setContentTitle(possiblyLocalizedString);
        }
        String possiblyLocalizedString2 = notificationParams.getPossiblyLocalizedString(resources, str, Constants.MessageNotificationKeys.BODY);
        if (!TextUtils.isEmpty(possiblyLocalizedString2)) {
            builder.setContentText(possiblyLocalizedString2);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(possiblyLocalizedString2));
        }
        builder.setSmallIcon(getSmallIcon(packageManager, resources, str, notificationParams.getString(Constants.MessageNotificationKeys.ICON), bundle));
        Uri sound = getSound(str, notificationParams, resources);
        if (sound != null) {
            builder.setSound(sound);
        }
        builder.setContentIntent(createContentIntent(context, notificationParams, str, packageManager));
        PendingIntent createDeleteIntent = createDeleteIntent(context, notificationParams);
        if (createDeleteIntent != null) {
            builder.setDeleteIntent(createDeleteIntent);
        }
        Integer color = getColor(context, notificationParams.getString(Constants.MessageNotificationKeys.COLOR), bundle);
        if (color != null) {
            builder.setColor(color.intValue());
        }
        builder.setAutoCancel(!notificationParams.getBoolean(Constants.MessageNotificationKeys.STICKY));
        builder.setLocalOnly(notificationParams.getBoolean(Constants.MessageNotificationKeys.LOCAL_ONLY));
        String string = notificationParams.getString(Constants.MessageNotificationKeys.TICKER);
        if (string != null) {
            builder.setTicker(string);
        }
        Integer notificationPriority = notificationParams.getNotificationPriority();
        if (notificationPriority != null) {
            builder.setPriority(notificationPriority.intValue());
        }
        Integer visibility = notificationParams.getVisibility();
        if (visibility != null) {
            builder.setVisibility(visibility.intValue());
        }
        Integer notificationCount = notificationParams.getNotificationCount();
        if (notificationCount != null) {
            builder.setNumber(notificationCount.intValue());
        }
        Long l2 = notificationParams.getLong(Constants.MessageNotificationKeys.EVENT_TIME);
        if (l2 != null) {
            builder.setShowWhen(true);
            builder.setWhen(l2.longValue());
        }
        long[] vibrateTimings = notificationParams.getVibrateTimings();
        if (vibrateTimings != null) {
            builder.setVibrate(vibrateTimings);
        }
        int[] lightSettings = notificationParams.getLightSettings();
        if (lightSettings != null) {
            builder.setLights(lightSettings[0], lightSettings[1], lightSettings[2]);
        }
        builder.setDefaults(getConsolidatedDefaults(notificationParams));
        return new DisplayNotificationInfo(builder, getTag(notificationParams), 0);
    }
}
