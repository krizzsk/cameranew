package com.growingio.android.sdk.data.net;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import androidx.annotation.WorkerThread;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.PersistUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
/* loaded from: classes2.dex */
public class DNSService {
    private static final long EMPTY_RESULT_HOST_TTL = 60;
    private static final int MAX_VERIFY_FAIL_NUMBER = 3;
    private static final String TAG = "GIO.DNSService";
    private static DNSService instance;
    private static final Object instanceLocker = new Object();
    private boolean enable = true;
    private int verifyFailNumber = 0;
    private final ArrayList<HostInformation> cachedHostInformation = new ArrayList<>();
    private final HttpDNSTask httpDNSTask = new HttpDNSTask();

    /* loaded from: classes2.dex */
    public static class HostInformation {
        private String hostName;
        private String ip;
        private long queryTime = System.currentTimeMillis() / 1000;
        private long ttl;

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getHostName() {
            return this.hostName;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getIp() {
            return this.ip;
        }

        boolean isExpired() {
            return this.queryTime + this.ttl < System.currentTimeMillis() / 1000;
        }

        public void setHostName(String str) {
            this.hostName = str;
        }

        void setIp(String str) {
            this.ip = str;
        }

        void setTtl(long j2) {
            this.ttl = j2;
        }

        public String toString() {
            return "HostInformation [hostName=" + this.hostName + ", ip=" + this.ip + ", ttl=" + this.ttl + ", queryTime=" + this.queryTime + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class HttpDNSTask {
        private static final String ACCOUNT_ID = "144428";
        private static final long DEFAULT_DNS_TTL = 86400;
        private static final String HTTP_DNS_SERVER_IP = "203.107.1.1";
        private static final int MAX_RETRY_NUMBER = 1;
        private String hostName;
        private int retryNumber;

        private HttpDNSTask() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00b4, code lost:
            if (r4 != null) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00b6, code lost:
            r4.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00d3, code lost:
            if (r4 != null) goto L44;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v11, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r4v8 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.growingio.android.sdk.data.net.DNSService.HostInformation query() {
            /*
                Method dump skipped, instructions count: 239
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.data.net.DNSService.HttpDNSTask.query():com.growingio.android.sdk.data.net.DNSService$HostInformation");
        }

        void resetQueryHost(String str) {
            this.hostName = str;
            this.retryNumber = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addHostInformation(HostInformation hostInformation) {
        this.cachedHostInformation.add(hostInformation);
        updateSavedHostInformation();
    }

    private boolean detectIfProxyExist() {
        int i2;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                str = System.getProperty("http.proxyHost");
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = TaskDetailBasePresenter.SCENE_LIST;
                }
                i2 = Integer.parseInt(property);
            } else {
                Context globalContext = CoreInitialize.coreAppState().getGlobalContext();
                str = Proxy.getHost(globalContext);
                i2 = Proxy.getPort(globalContext);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = -1;
        }
        return (str == null || i2 == -1) ? false : true;
    }

    public static DNSService getInstance() {
        DNSService dNSService;
        synchronized (instanceLocker) {
            if (instance == null) {
                DNSService dNSService2 = new DNSService();
                instance = dNSService2;
                dNSService2.initCachedHostInformation();
            }
            dNSService = instance;
        }
        return dNSService;
    }

    private void initCachedHostInformation() {
        String fetchHostInformationData = PersistUtil.fetchHostInformationData();
        if (fetchHostInformationData != null) {
            try {
                JSONArray jSONArray = new JSONArray(fetchHostInformationData);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    HostInformation hostInformation = new HostInformation();
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    hostInformation.ttl = jSONObject.getLong(Constants.FirelogAnalytics.PARAM_TTL);
                    hostInformation.queryTime = jSONObject.getLong("queryTime");
                    hostInformation.hostName = jSONObject.getString("hostName");
                    hostInformation.ip = jSONObject.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
                    this.cachedHostInformation.add(hostInformation);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void updateSavedHostInformation() {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<HostInformation> it = this.cachedHostInformation.iterator();
            while (it.hasNext()) {
                HostInformation next = it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.FirelogAnalytics.PARAM_TTL, next.ttl);
                jSONObject.put("queryTime", next.queryTime);
                jSONObject.put("hostName", next.hostName);
                jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, next.ip);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        PersistUtil.saveHostInformationData(jSONArray.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public HostInformation getHostInformationByHostName(String str, boolean z) {
        if (!this.enable) {
            LogUtil.e(TAG, "DNSService disable");
            return null;
        } else if (detectIfProxyExist()) {
            LogUtil.d(TAG, "ProxyExist");
            return null;
        } else if (shouldHttpDNS(str)) {
            HostInformation hostInformationInCache = getHostInformationInCache(str, this.cachedHostInformation);
            if (hostInformationInCache != null && !hostInformationInCache.isExpired()) {
                LogUtil.d(TAG, "Available hostInformation: ", hostInformationInCache);
                return hostInformationInCache;
            } else if (GConfig.ISOP()) {
                return null;
            } else {
                removeHostInformation(hostInformationInCache);
                if (z) {
                    LogUtil.d(TAG, "onlyInCache");
                    return null;
                }
                this.httpDNSTask.resetQueryHost(str);
                return this.httpDNSTask.query();
            }
        } else {
            return null;
        }
    }

    public HostInformation getHostInformationInCache(String str, ArrayList<HostInformation> arrayList) {
        Iterator<HostInformation> it = arrayList.iterator();
        while (it.hasNext()) {
            HostInformation next = it.next();
            if (next.hostName.equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeHostInformation(HostInformation hostInformation) {
        if (hostInformation == null) {
            return;
        }
        this.cachedHostInformation.remove(hostInformation);
        updateSavedHostInformation();
    }

    public boolean shouldHttpDNS(String str) {
        return NetworkConfig.getInstance().apiEndPoint().substring(7).indexOf(str) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void verifyFail(HostInformation hostInformation) {
        removeHostInformation(hostInformation);
        int i2 = this.verifyFailNumber + 1;
        this.verifyFailNumber = i2;
        if (i2 >= 3) {
            this.enable = false;
        }
    }
}
