package com.weibo.ssosdk;

import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.stat.DeviceInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* loaded from: classes3.dex */
public class WeiboSsoSdk {

    /* renamed from: e  reason: collision with root package name */
    private static WeiboSsoSdk f8480e;

    /* renamed from: f  reason: collision with root package name */
    private static com.weibo.ssosdk.c f8481f;
    private volatile ReentrantLock a = new ReentrantLock(true);
    private boolean b = true;
    private e c;

    /* renamed from: d  reason: collision with root package name */
    private int f8482d;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread.sleep(AdvTimeUtils.MILLIS_OF_A_DAY);
                    WeiboSsoSdk.getInstance().k((WeiboSsoSdk.this.c == null || TextUtils.isEmpty(WeiboSsoSdk.this.c.a())) ? WeiboSsoSdk.this.j() : WeiboSsoSdk.this.c.a(), 2);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(60000L);
                if (WeiboSsoSdk.this.b) {
                    WeiboSsoSdk.this.k((WeiboSsoSdk.this.c == null || TextUtils.isEmpty(WeiboSsoSdk.this.c.a())) ? WeiboSsoSdk.this.j() : WeiboSsoSdk.this.c.a(), 2);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WeiboSsoSdk.this.k("", 1);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    class d implements Runnable {
        final /* synthetic */ com.weibo.ssosdk.b a;

        d(com.weibo.ssosdk.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WeiboSsoSdk.this.k("", 1);
            } catch (Exception unused) {
            }
            if (WeiboSsoSdk.this.c == null) {
                WeiboSsoSdk.this.c = new e();
            }
            this.a.handler(WeiboSsoSdk.this.c);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e {
        private String a = "";
        private String b = "";

        static e c(String str) {
            e eVar = new e();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (optString.equals("20000000") && jSONObject2 != null) {
                    eVar.a = jSONObject2.optString(DeviceInfo.TAG_ANDROID_ID, "");
                    eVar.b = jSONObject2.optString("sub", "");
                    return eVar;
                }
                throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
            } catch (Exception e2) {
                throw e2;
            }
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }
    }

    static {
        System.loadLibrary("wind");
    }

    private WeiboSsoSdk() {
        com.weibo.ssosdk.c cVar = f8481f;
        if (cVar != null && cVar.n()) {
            this.f8482d = 0;
            new Thread(new a()).start();
            new Thread(new b()).start();
            return;
        }
        throw new Exception("config error");
    }

    private synchronized void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(h(1));
            try {
                fileOutputStream2.write(str.getBytes());
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (Exception unused2) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String g(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://login.sina.com.cn/visitor/signin").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.flush();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized WeiboSsoSdk getInstance() {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (f8480e == null) {
                f8480e = new WeiboSsoSdk();
            }
            weiboSsoSdk = f8480e;
        }
        return weiboSsoSdk;
    }

    private File h(int i2) {
        File filesDir = f8481f.b().getFilesDir();
        return new File(filesDir, "weibo_sso_sdk_aid" + i2);
    }

    public static synchronized boolean i(com.weibo.ssosdk.c cVar) {
        synchronized (WeiboSsoSdk.class) {
            if (cVar == null) {
                return false;
            }
            if (cVar.n()) {
                if (f8481f == null) {
                    com.weibo.ssosdk.c cVar2 = (com.weibo.ssosdk.c) cVar.clone();
                    f8481f = cVar2;
                    com.weibo.ssosdk.a.w(cVar2.b());
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j() {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(h(1));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str = new String(bArr);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return "";
                    } catch (IOException unused3) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, int i2) {
        String str2;
        if (TextUtils.isEmpty(f8481f.a(false))) {
            return;
        }
        if (!this.a.tryLock()) {
            this.a.lock();
            this.a.unlock();
            return;
        }
        this.b = false;
        String n = com.weibo.ssosdk.a.n(f8481f.b());
        try {
            str2 = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        String g2 = g(riseWind(f8481f.a(true), f8481f.b().getPackageName(), str2, n, f8481f.d(true), f8481f.e(true), f8481f.h(true), f8481f.g(true), f8481f.f(true), f8481f.c(true), i2, this.f8482d));
        this.f8482d++;
        if (g2 != null) {
            try {
                e c2 = e.c(g2);
                if (c2 != null && !TextUtils.isEmpty(c2.a())) {
                    f(c2.a());
                }
                if (i2 == 1) {
                    this.c = c2;
                }
                this.a.unlock();
                return;
            } catch (Exception e2) {
                this.a.unlock();
                throw e2;
            }
        }
        this.a.unlock();
        throw new Exception("network error.");
    }

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, int i3);

    public e l() {
        e eVar = this.c;
        if (eVar == null || TextUtils.isEmpty(eVar.a()) || TextUtils.isEmpty(this.c.b())) {
            Thread thread = new Thread(new c());
            thread.start();
            thread.join();
            e eVar2 = this.c;
            if (eVar2 == null || TextUtils.isEmpty(eVar2.a()) || TextUtils.isEmpty(this.c.b())) {
                throw new Exception("visitor login failed");
            }
        }
        return this.c;
    }

    public void m(com.weibo.ssosdk.b bVar) {
        e eVar = this.c;
        if (eVar != null && !TextUtils.isEmpty(eVar.a()) && !TextUtils.isEmpty(this.c.b())) {
            bVar.handler(this.c);
        } else {
            Executors.newSingleThreadExecutor().execute(new d(bVar));
        }
    }
}
