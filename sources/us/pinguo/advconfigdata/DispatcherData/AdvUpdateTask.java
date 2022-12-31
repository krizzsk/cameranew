package us.pinguo.advconfigdata.DispatcherData;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.advconfigdata.AdvAddition.ExecuteAdvRepair;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.AdvDex.ExecuteAdvDex;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.Utils.AdvLog;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.advconfigdata.Utils.AdvSystemUtils;
import us.pinguo.advconfigdata.Utils.AdvUtils;
import us.pinguo.advconfigdata.Utils.SSLManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.advconfigdata.database.AdvRepairItem;
/* loaded from: classes3.dex */
public class AdvUpdateTask {
    private Context a;
    private volatile Thread b;
    private volatile c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends Thread {
        final /* synthetic */ int a;
        final /* synthetic */ boolean b;

        a(int i2, boolean z) {
            this.a = i2;
            this.b = z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.a == 2) {
                AdvConfigManager.getInstance().getAdvDataKeeper().f();
                AdvConfigManager.getInstance().refresh();
            }
            String m = AdvUpdateTask.this.m(this.b);
            if (!AdvConstants.STATUS_304.equals(m) && TextUtils.isEmpty(m)) {
                AdvUpdateTask advUpdateTask = AdvUpdateTask.this;
                c cVar = new c(advUpdateTask, null);
                cVar.c(this.b);
                advUpdateTask.c = cVar;
            }
            AdvUpdateTask.this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements SSLManager.GetDominCallback {
        b() {
        }

        @Override // us.pinguo.advconfigdata.Utils.SSLManager.GetDominCallback
        public void onFailed() {
        }

        @Override // us.pinguo.advconfigdata.Utils.SSLManager.GetDominCallback
        public void onLoaded() {
            new ExecuteAdvRepair(AdvUpdateTask.this.a).StartThread();
        }
    }

    public AdvUpdateTask(Context context) {
        this.a = context;
    }

    private void a(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Map<String, String> commonHttpParams = AdvConfigManager.getInstance().getCommonHttpParams();
            if (commonHttpParams == null) {
                commonHttpParams = new HashMap<>();
            }
            commonHttpParams.put(AdvConstants.key_cost, String.valueOf(j2));
            String b2 = b(str, commonHttpParams);
            String sigByParamMap = AdvUtils.getSigByParamMap(commonHttpParams, AdvConfigManager.getInstance().getAdvConfig().getHttpRequestMD5Secret());
            String str2 = AdvUtils.getUrl(b2, commonHttpParams) + "&sig=" + sigByParamMap;
            AdvLog.Log("send request : " + str2);
            AdvUtils.get(str2);
        } catch (Exception e2) {
            AdvLog.Log(e2.getMessage());
        }
    }

    private String b(String str, Map<String, String> map) {
        int indexOf;
        if (TextUtils.isEmpty(str) || map == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("?");
        if (lastIndexOf <= 0) {
            return str;
        }
        String substring = str.substring(0, lastIndexOf);
        String substring2 = str.substring(lastIndexOf + 1, str.length());
        if (!TextUtils.isEmpty(substring2) && (indexOf = substring2.indexOf("=")) > 0) {
            String substring3 = substring2.substring(0, indexOf);
            String substring4 = substring2.substring(indexOf + 1, substring2.length());
            if (TextUtils.isEmpty(substring3) || TextUtils.isEmpty(substring4)) {
                return str;
            }
            map.put(substring3, substring4);
            return substring;
        }
        return str;
    }

    private void g() {
        List<AdvRepairItem> q = AdvConfigManager.getInstance().getAdvDataKeeper().q();
        if (q == null || q.size() == 0) {
            return;
        }
        SSLManager.getInstance().getDomainList(new b());
    }

    private String h(boolean z) throws IOException, GeneralSecurityException {
        int[] screenSize = AdvSystemUtils.getScreenSize(this.a);
        Map<String, String> commonHttpParams = AdvConfigManager.getInstance().getCommonHttpParams();
        commonHttpParams.put("fromui", z ? "1" : "0");
        commonHttpParams.put("screenSize", screenSize[0] + Marker.ANY_MARKER + screenSize[1]);
        String sigByParamMap = AdvUtils.getSigByParamMap(commonHttpParams, AdvConfigManager.getInstance().getAdvConfig().getHttpRequestMD5Secret());
        String str = AdvUtils.getUrl(AdvConfigManager.AD_REQUEST_URL, commonHttpParams) + "&sig=" + sigByParamMap;
        AdvLog.Log("send request : " + str);
        return AdvUtils.get(str);
    }

    private int i(long j2) {
        Locale locale = Locale.getDefault();
        String str = locale.getLanguage() + '_' + locale.getCountry();
        String string = AdvPrefUtil.getInstance().getString("key_last_upate_ad_list_loc", null);
        AdvLog.Log("loc:" + str + ",preloc:" + string);
        if (str.equals(string)) {
            long abs = Math.abs(System.currentTimeMillis() - AdvPrefUtil.getInstance().getLong("key_last_upate_ad_list_time", 1000L));
            AdvLog.Log("interval:" + j2 + ",intervalToLast:" + abs);
            return abs > j2 ? 1 : -1;
        }
        return 2;
    }

    private int l(boolean z) {
        if ((this.c == null || !this.c.b) && !AdvConfigManager.getInstance().getAdvConfig().isStopAdv()) {
            if (z) {
                return 1;
            }
            return i(AdvConfigManager.getInstance().getAdvDataKeeper().l() * 1000);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m(boolean z) {
        JSONObject jSONObject;
        int i2;
        AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onRequestAdv();
        try {
            if (AdvSystemUtils.hasNet(this.a)) {
                long currentTimeMillis = System.currentTimeMillis();
                String h2 = h(z);
                AdvItem item = AdvConfigManager.getInstance().getItem(AdvConstants.Interface_guid);
                if (item != null) {
                    a(item.interactionUri, System.currentTimeMillis() - currentTimeMillis);
                }
                AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onRequestAdvSuccess();
                AdvLog.Log("schedule:" + h2);
                try {
                    if (TextUtils.isEmpty(h2)) {
                        return h2;
                    }
                    try {
                        jSONObject = new JSONObject(h2);
                        i2 = jSONObject.getInt("status");
                    } catch (JSONException e2) {
                        AdvLog.Log(e2.getMessage());
                        AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onParseAdvError();
                    }
                    if (i2 == 304) {
                        k();
                        AdvConfigManager.getInstance().refresh();
                        AdvConfigManager.getInstance().notifyChange();
                        AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onSaveAdvCacheFileSuccess();
                        new ExecuteAdvDex(this.a).StartThread();
                        g();
                        return AdvConstants.STATUS_304;
                    }
                    if (i2 == 200) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        us.pinguo.advconfigdata.a.a.c(jSONObject2);
                        jSONObject2.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, Locale.getDefault().toString());
                        String jSONObject3 = jSONObject.toString();
                        if (jSONObject2.has("checkSum")) {
                            AdvPrefUtil.getInstance().putString(AdvConstants.KEY_CHECKSUM, jSONObject2.getString("checkSum"));
                        }
                        if (AdvConfigManager.getInstance().getAdvDataKeeper().B(jSONObject3.getBytes())) {
                            AdvConfigManager.getInstance().refresh();
                            AdvConfigManager.getInstance().notifyChange();
                            AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onSaveAdvCacheFileSuccess();
                            new ExecuteAdvDex(this.a).StartThread();
                            g();
                        } else {
                            AdvConfigManager.getInstance().preload();
                            AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onSaveAdvCacheFileError();
                        }
                    } else {
                        if (i2 != 11033 && i2 != 11034) {
                            if (i2 == 11002) {
                                Map<String, String> commonHttpParams = AdvConfigManager.getInstance().getCommonHttpParams();
                                ArrayList arrayList = new ArrayList();
                                for (Map.Entry<String, String> entry : commonHttpParams.entrySet()) {
                                    arrayList.add(entry.getKey() + "=" + entry.getValue());
                                }
                                String stringByParams = AdvUtils.getStringByParams(arrayList);
                                String sigByParamList = AdvUtils.getSigByParamList(arrayList, AdvConfigManager.getInstance().getAdvConfig().getHttpRequestMD5Secret());
                                HashMap hashMap = new HashMap();
                                hashMap.put(FirebaseAnalytics.Param.ORIGIN, stringByParams);
                                hashMap.put("sigData", sigByParamList);
                                new us.pinguo.advconfigdata.DispatcherData.a(hashMap).execute();
                            } else {
                                AdvConfigManager.getInstance().preload();
                            }
                        }
                        AdvConfigManager.getInstance().getAdvDataKeeper().f();
                        AdvConfigManager.getInstance().refresh();
                        AdvLog.Log("test清空广告数据");
                    }
                    return h2;
                } finally {
                    k();
                }
            }
            throw new IOException("network not available");
        } catch (IOException e3) {
            AdvLog.Log(e3.getMessage());
            AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onRequestAdvIOError();
            return "";
        } catch (GeneralSecurityException e4) {
            AdvLog.Log(e4.getMessage());
            AdvConfigManager.getInstance().getAdvConfig().getLifecycleListener().onRequestAdvSecureError();
            return "";
        }
    }

    public void j(boolean z, boolean z2) {
        int l2 = l(z);
        if (l2 < 1 || this.b != null) {
            return;
        }
        this.b = new a(l2, z2);
        this.b.start();
    }

    public void k() {
        AdvPrefUtil.getInstance().putLong("key_last_upate_ad_list_time", System.currentTimeMillis());
        Locale locale = Locale.getDefault();
        AdvPrefUtil.getInstance().putString("key_last_upate_ad_list_loc", locale.getLanguage() + '_' + locale.getCountry());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c {
        private volatile a a;
        private volatile boolean b;
        private boolean c;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public class a extends BroadcastReceiver {

            /* renamed from: us.pinguo.advconfigdata.DispatcherData.AdvUpdateTask$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0354a extends Thread {
                C0354a() {
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    AdvUpdateTask.this.m(cVar.c);
                }
            }

            private a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                VdsAgent.onBroadcastReceiver(this, context, intent);
                if (AdvSystemUtils.hasNet(AdvUpdateTask.this.a)) {
                    new C0354a().start();
                    c.this.d();
                }
            }

            /* synthetic */ a(c cVar, a aVar) {
                this();
            }
        }

        private c() {
            this.c = false;
        }

        public c c(boolean z) {
            this.a = new a(this, null);
            this.b = true;
            this.c = z;
            if (!AdvSystemUtils.hasNet(AdvUpdateTask.this.a)) {
                AdvUpdateTask.this.a.registerReceiver(this.a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                return this;
            }
            try {
                Thread.sleep(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
                if (!AdvSystemUtils.hasNet(AdvUpdateTask.this.a)) {
                    AdvUpdateTask.this.a.registerReceiver(this.a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } else {
                    this.a = null;
                    AdvUpdateTask.this.m(this.c);
                    d();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return this;
        }

        public void d() {
            if (this.a != null) {
                try {
                    AdvUpdateTask.this.a.unregisterReceiver(this.a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
            this.b = false;
        }

        /* synthetic */ c(AdvUpdateTask advUpdateTask, a aVar) {
            this();
        }
    }
}
