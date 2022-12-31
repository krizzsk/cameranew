package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class g {
    private static Map<String, g> a = Collections.synchronizedMap(new HashMap());
    private static String b = null;
    private Context c;

    /* renamed from: d  reason: collision with root package name */
    private String f8208d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f8209e = null;

    /* renamed from: f  reason: collision with root package name */
    private long f8210f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f8211g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8212h = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class a extends Thread {
        final /* synthetic */ Bundle a;

        a(Bundle bundle) {
            this.a = bundle;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                g.this.a(l.d(HttpUtils.openUrl2(g.this.c, "https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", this.a).a));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            g.this.f8211g = 0;
        }
    }

    private g(Context context, String str) {
        this.c = null;
        this.f8208d = null;
        this.c = context.getApplicationContext();
        this.f8208d = str;
        a();
        b();
    }

    private void b() {
        if (this.f8211g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f8211g = 1;
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.f8208d);
        bundle.putString("appid_for_getting_config", this.f8208d);
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new a(bundle).start();
    }

    private String c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f8208d != null) {
                    str2 = str + "." + this.f8208d;
                } else {
                    str2 = str;
                }
                open = this.c.openFileInput(str2);
            } catch (IOException e2) {
                e2.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException unused) {
            open = this.c.getAssets().open(str);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    open.close();
                    bufferedReader.close();
                }
            } catch (Throwable th) {
                try {
                    open.close();
                    bufferedReader.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        }
        str3 = stringBuffer.toString();
        open.close();
        bufferedReader.close();
        return str3;
    }

    private void d(String str) {
        if (this.f8212h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.f8208d);
        }
    }

    public static g a(Context context, String str) {
        g gVar;
        synchronized (a) {
            SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                b = str;
            }
            if (str == null && (str = b) == null) {
                str = "0";
            }
            gVar = a.get(str);
            if (gVar == null) {
                gVar = new g(context, str);
                a.put(str, gVar);
            }
            SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return gVar;
    }

    private void a() {
        try {
            this.f8209e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f8209e = new JSONObject();
        }
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.f8209e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    private void a(String str, String str2) {
        try {
            if (this.f8208d != null) {
                str = str + "." + this.f8208d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.f8209e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f8210f >= optInt * com.adjust.sdk.Constants.ONE_HOUR) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f8209e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f8210f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f8209e.optInt(str);
    }
}
