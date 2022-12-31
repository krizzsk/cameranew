package com.growingio.android.sdk.data;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import com.growingio.android.sdk.base.event.DiagnoseEvent;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.data.net.HttpService;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.cp_annotation.Subscribe;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes2.dex */
public class DiagnoseLog {
    private static SimpleDateFormat DIAGNOSE_DATE_FORMAT = null;
    static SimpleDateFormat DIAGNOSE_DETAIL_DATE_FORMAT = null;
    private static final String SP_NAME = "growingio_diagnose";
    private static final long UploadLogDelay = 300000;
    @SuppressLint({"StaticFieldLeak"})
    private static DiagnoseLog sInstance;
    private Context mContext;
    private HashMap<String, Diagnose> mDiagnoseMap;
    private final String TYPE_UPLOAD_ALL = "TYPE_UPLOAD_ALL";
    private UploadDiagnoseLogRunnable uploadDiagnoseLogRunnable = new UploadDiagnoseLogRunnable();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class UploadDiagnoseLogRunnable implements Runnable {
        private boolean waitingForUploading;

        private UploadDiagnoseLogRunnable() {
            this.waitingForUploading = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void beginWaitForUpload() {
            if (this.waitingForUploading) {
                return;
            }
            this.waitingForUploading = true;
            DataSubscriberInitialize.messageUploader().getHandler().postDelayed(this, 300000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void uploadImmediate() {
            this.waitingForUploading = true;
            DataSubscriberInitialize.messageUploader().getHandler().removeCallbacks(this);
            DataSubscriberInitialize.messageUploader().getHandler().post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DiagnoseLog.this.saveLog("TYPE_UPLOAD_ALL");
            this.waitingForUploading = false;
        }
    }

    static {
        Locale locale = Locale.US;
        DIAGNOSE_DATE_FORMAT = new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_HYPHEN, locale);
        DIAGNOSE_DETAIL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd%20HH:mm:ss", locale);
    }

    private DiagnoseLog(Context context) {
        this.mContext = context.getApplicationContext();
        readLogFromSP();
    }

    private SharedPreferences getSharedPreferences() {
        return this.mContext.getSharedPreferences(SP_NAME, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initialize(Context context) {
        if (sInstance == null) {
            sInstance = new DiagnoseLog(context);
        }
    }

    @Subscribe
    public static void onDiagnoseEvent(DiagnoseEvent diagnoseEvent) {
        int i2 = diagnoseEvent.count;
        if (i2 == -1) {
            saveLogIfEnabled(diagnoseEvent.type);
        } else {
            saveLogIfEnabled(diagnoseEvent.type, i2);
        }
    }

    private void readLogFromSP() {
        this.mDiagnoseMap = new HashMap<>();
        for (Map.Entry<String, ?> entry : getSharedPreferences().getAll().entrySet()) {
            try {
                String key = entry.getKey();
                this.mDiagnoseMap.put(key, new Diagnose(key, new JSONObject(entry.getValue().toString())));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private synchronized void saveLog(String str, int i2) {
        if (i2 == 0) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (str == "TYPE_UPLOAD_ALL" && !GConfig.ISOP()) {
                uploadAll();
                return;
            }
            Date date = new Date();
            String format = DIAGNOSE_DATE_FORMAT.format(date);
            String format2 = DIAGNOSE_DETAIL_DATE_FORMAT.format(date);
            Diagnose diagnose = this.mDiagnoseMap.get(format);
            if (diagnose == null) {
                diagnose = new Diagnose(format, format2);
                this.mDiagnoseMap.put(format, diagnose);
            }
            Integer num = diagnose.eventCount.get(str);
            if (num != null) {
                i2 += num.intValue();
            }
            diagnose.eventCount.put(str, Integer.valueOf(i2));
            saveLogToSP(format, diagnose);
            if (this.mDiagnoseMap.size() > 0) {
                this.uploadDiagnoseLogRunnable.beginWaitForUpload();
            }
            return;
        }
        throw new AssertionError();
    }

    public static void saveLogIfEnabled(String str) {
        DiagnoseLog diagnoseLog;
        if (!CoreInitialize.config().isDiagnoseEnabled() || (diagnoseLog = sInstance) == null) {
            return;
        }
        diagnoseLog.saveLog(str);
    }

    @TargetApi(9)
    private void saveLogToSP(String str, Diagnose diagnose) {
        try {
            getSharedPreferences().edit().putString(str, diagnose.toJson()).commit();
        } catch (Throwable th) {
            LogUtil.d(th);
        }
    }

    private void upload(Diagnose diagnose) {
        if (diagnose == null) {
            return;
        }
        CoreAppState coreAppState = CoreInitialize.coreAppState();
        DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
        HashMap hashMap = new HashMap();
        hashMap.put(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_JSON);
        hashMap.put(HttpRequest.HEADER_ACCEPT, HttpRequest.CONTENT_TYPE_JSON);
        hashMap.put("X-GrowingIO-UID", deviceUUIDFactory.getDeviceId());
        String projectId = coreAppState.getProjectId();
        StringBuilder sb = new StringBuilder(390);
        try {
            sb.append(NetworkConfig.getInstance().crashReportEndPoint());
            sb.append("/");
            sb.append(projectId);
            sb.append("/android/faults?");
            sb.append("stm=");
            sb.append(System.currentTimeMillis());
            sb.append('&');
            sb.append("av=");
            sb.append(URLEncoder.encode(CoreInitialize.config().getAppVersion(), "UTF-8"));
            sb.append('&');
            sb.append("cv=");
            sb.append(GConfig.GROWING_VERSION);
            sb.append('&');
            sb.append("uid=");
            sb.append(deviceUUIDFactory.getDeviceId());
            sb.append('&');
            sb.append("appid=");
            sb.append(coreAppState.getSPN());
            sb.append('&');
            sb.append("os=");
            sb.append(Constants.PLATFORM_ANDROID);
            sb.append('&');
            sb.append("osv=");
            sb.append(Build.VERSION.SDK_INT);
            sb.append('&');
            sb.append("db=");
            sb.append(URLEncoder.encode(Build.BRAND, "UTF-8"));
            sb.append('&');
            sb.append("dm=");
            sb.append(URLEncoder.encode(Build.MODEL, "UTF-8"));
            sb.append('&');
            sb.append("date=");
            sb.append(diagnose.detailDate);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        HashMap<String, Integer> hashMap2 = diagnose.eventCount;
        if (hashMap2 != null && !hashMap2.isEmpty()) {
            for (String str : diagnose.eventCount.keySet()) {
                sb.append("&");
                sb.append(str);
                sb.append("=");
                sb.append(diagnose.eventCount.get(str));
            }
        }
        try {
            if (((Integer) new HttpService.Builder().uri(sb.toString()).headers(hashMap).build().performRequest().first).intValue() == 200) {
                this.mDiagnoseMap.remove(diagnose.dayDate);
                getSharedPreferences().edit().remove(diagnose.dayDate).commit();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void uploadAll() {
        try {
            for (Object obj : this.mDiagnoseMap.entrySet().toArray()) {
                upload((Diagnose) ((Map.Entry) obj).getValue());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void uploadImmediate() {
        DiagnoseLog diagnoseLog = sInstance;
        if (diagnoseLog != null) {
            diagnoseLog.uploadDiagnoseLogRunnable.uploadImmediate();
        }
    }

    public static void saveLogIfEnabled(String str, int i2) {
        DiagnoseLog diagnoseLog;
        if (!CoreInitialize.config().isDiagnoseEnabled() || (diagnoseLog = sInstance) == null) {
            return;
        }
        diagnoseLog.saveLog(str, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveLog(String str) {
        saveLog(str, 1);
    }
}
