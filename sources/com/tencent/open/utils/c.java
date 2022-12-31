package com.tencent.open.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.log.SLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class c {
    private static String c;
    private String a;
    private d b;

    /* renamed from: d  reason: collision with root package name */
    private long f8204d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f8205e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<Activity> f8206f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f8207g = new b();

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.v("AsynLoadImg", "handleMessage:" + message.arg1);
            if (message.arg1 == 0) {
                c.this.b.a(message.arg1, (String) message.obj);
            } else {
                c.this.b.a(message.arg1, (String) null);
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            SLog.v("AsynLoadImg", "saveFileRunnable:");
            String str = "share_qq_" + l.f(c.this.a) + ".jpg";
            String str2 = c.c + str;
            File file = new File(str2);
            Message obtainMessage = c.this.f8205e.obtainMessage();
            if (!file.exists()) {
                Bitmap a = c.a(c.this.a);
                if (a != null) {
                    z = c.this.a(a, str);
                } else {
                    SLog.v("AsynLoadImg", "saveFileRunnable:get bmp fail---");
                    z = false;
                }
                if (z) {
                    obtainMessage.arg1 = 0;
                    obtainMessage.obj = str2;
                } else {
                    obtainMessage.arg1 = 1;
                }
                SLog.v("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - c.this.f8204d));
            } else {
                obtainMessage.arg1 = 0;
                obtainMessage.obj = str2;
                SLog.v("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - c.this.f8204d));
            }
            c.this.f8205e.sendMessage(obtainMessage);
        }
    }

    public c(Activity activity) {
        this.f8206f = new WeakReference<>(activity);
        this.f8205e = new a(activity.getMainLooper());
    }

    public void a(String str, d dVar) {
        SLog.v("AsynLoadImg", "--save---");
        if (str != null && !str.equals("")) {
            if (!l.a()) {
                dVar.a(2, (String) null);
                return;
            }
            if (this.f8206f.get() != null) {
                Activity activity = this.f8206f.get();
                File h2 = l.h(activity, "Images");
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (h2 == null) {
                    SLog.e("AsynLoadImg", "externalImageFile is null");
                    dVar.a(2, (String) null);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(i.c(activity) ? h2.getAbsolutePath() : externalStorageDirectory.getAbsolutePath());
                sb.append("/tmp/");
                c = sb.toString();
            }
            this.f8204d = System.currentTimeMillis();
            this.a = str;
            this.b = dVar;
            new Thread(this.f8207g).start();
            return;
        }
        dVar.a(1, (String) null);
    }

    public boolean a(Bitmap bitmap, String str) {
        BufferedOutputStream bufferedOutputStream;
        String str2 = c;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                SLog.v("AsynLoadImg", "saveFile:" + str);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2 + str)));
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            try {
                bufferedOutputStream.close();
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                return true;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            SLog.e("AsynLoadImg", "saveFile bmp fail---", e);
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Bitmap a(String str) {
        SLog.v("AsynLoadImg", "getbitmap:" + str);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            SLog.v("AsynLoadImg", "image download finished." + str);
            return decodeStream;
        } catch (IOException e2) {
            e2.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            SLog.v("AsynLoadImg", "getbitmap bmp fail---");
            return null;
        }
    }
}
