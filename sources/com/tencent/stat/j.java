package com.tencent.stat;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.stat.common.StatLogger;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class j implements Runnable {
    private Context a;
    private Map<String, Integer> b;

    public j(Context context, Map<String, Integer> map) {
        this.a = null;
        this.b = null;
        this.a = context;
        if (map != null) {
            this.b = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private NetworkMonitor a(String str, int i2) {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        int i3;
        StatLogger statLogger4;
        StatLogger statLogger5;
        NetworkMonitor networkMonitor = new NetworkMonitor();
        Socket socket = new Socket();
        try {
            try {
                networkMonitor.setDomain(str);
                networkMonitor.setPort(i2);
                long currentTimeMillis = System.currentTimeMillis();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
                socket.connect(inetSocketAddress, BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                networkMonitor.setMillisecondsConsume(System.currentTimeMillis() - currentTimeMillis);
                networkMonitor.setRemoteIp(inetSocketAddress.getAddress().getHostAddress());
                socket.close();
                try {
                    socket.close();
                } catch (Throwable th) {
                    statLogger5 = StatService.f8246i;
                    statLogger5.e(th);
                }
                i3 = 0;
                socket = socket;
            } catch (IOException e2) {
                statLogger = StatService.f8246i;
                statLogger.e((Exception) e2);
                try {
                    socket.close();
                    statLogger3 = socket;
                } catch (Throwable th2) {
                    statLogger2 = StatService.f8246i;
                    statLogger2.e(th2);
                    statLogger3 = statLogger2;
                }
                i3 = -1;
                socket = statLogger3;
            }
            networkMonitor.setStatusCode(i3);
            return networkMonitor;
        } catch (Throwable th3) {
            try {
                socket.close();
            } catch (Throwable th4) {
                statLogger4 = StatService.f8246i;
                statLogger4.e(th4);
            }
            throw th3;
        }
    }

    private Map<String, Integer> b() {
        String str;
        StatLogger statLogger;
        HashMap hashMap = new HashMap();
        String a = StatConfig.a("__MTA_TEST_SPEED__", (String) null);
        if (a != null && a.trim().length() != 0) {
            for (String str2 : a.split(";")) {
                String[] split = str2.split(",");
                if (split != null && split.length == 2 && (str = split[0]) != null && str.trim().length() != 0) {
                    try {
                        hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                    } catch (NumberFormatException e2) {
                        statLogger = StatService.f8246i;
                        statLogger.e((Exception) e2);
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        String str;
        try {
            if (com.tencent.stat.common.k.h(this.a)) {
                if (this.b == null) {
                    this.b = b();
                }
                Map<String, Integer> map = this.b;
                if (map != null && map.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, Integer> entry : this.b.entrySet()) {
                        String key = entry.getKey();
                        if (key != null && key.length() != 0) {
                            if (entry.getValue() == null) {
                                statLogger3 = StatService.f8246i;
                                str = "port is null for " + key;
                                statLogger3.w(str);
                            } else {
                                jSONArray.put(a(entry.getKey(), entry.getValue().intValue()).toJSONObject());
                            }
                        }
                        statLogger3 = StatService.f8246i;
                        str = "empty domain name.";
                        statLogger3.w(str);
                    }
                    if (jSONArray.length() == 0) {
                        return;
                    }
                    Context context = this.a;
                    com.tencent.stat.a.i iVar = new com.tencent.stat.a.i(context, StatService.a(context, false));
                    iVar.a(jSONArray.toString());
                    if (StatService.c(this.a) != null) {
                        StatService.c(this.a).post(new k(iVar));
                        return;
                    }
                    return;
                }
                statLogger2 = StatService.f8246i;
                statLogger2.w("empty domain list.");
            }
        } catch (Throwable th) {
            statLogger = StatService.f8246i;
            statLogger.e(th);
        }
    }
}
