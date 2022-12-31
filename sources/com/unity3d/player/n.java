package com.unity3d.player;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TapjoyConstants;
import com.tencent.bugly.BuglyStrategy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes3.dex */
public final class n extends RelativeLayout {
    UnityPlayer a;
    m b;
    Context c;

    /* renamed from: d  reason: collision with root package name */
    int f8410d;

    /* renamed from: e  reason: collision with root package name */
    VideoView f8411e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f8412f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f8413g;

    /* renamed from: h  reason: collision with root package name */
    TextView f8414h;

    /* renamed from: i  reason: collision with root package name */
    Timer f8415i;

    /* renamed from: j  reason: collision with root package name */
    int f8416j;

    /* renamed from: k  reason: collision with root package name */
    int f8417k;

    /* renamed from: l  reason: collision with root package name */
    boolean f8418l;
    TimerTask m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends AsyncTask {
        private String[] b;

        a() {
        }

        private static void a(String str) {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL("https://splash.unity.cn/api/diagnosis").openConnection();
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_JSON);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "tracking");
                jSONObject.put("reason", str);
                jSONObject.put("platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
                byte[] bytes = jSONObject.toString().getBytes();
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();
                httpURLConnection.getResponseCode();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception unused2) {
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final Void doInBackground(String... strArr) {
            int i2;
            HttpURLConnection httpURLConnection;
            this.b = strArr;
            HttpURLConnection httpURLConnection2 = null;
            if (strArr == null) {
                return null;
            }
            while (true) {
                String[] strArr2 = this.b;
                if (i2 >= strArr2.length) {
                    return null;
                }
                String str = strArr2[i2];
                if (str != null) {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(n.f(str)).openConnection();
                        try {
                            try {
                                httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                                httpURLConnection.setRequestMethod("GET");
                                int responseCode = httpURLConnection.getResponseCode();
                                if (responseCode >= 400) {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                                    String str2 = "";
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        str2 = str2 + readLine;
                                    }
                                    a(str + " - " + responseCode + " - " + str2);
                                    bufferedReader.close();
                                }
                                if (httpURLConnection == null) {
                                }
                            } catch (Exception e2) {
                                e = e2;
                                a(str + " - " + e.toString());
                                i2 = httpURLConnection == null ? i2 + 1 : 0;
                                httpURLConnection.disconnect();
                            }
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection2 = httpURLConnection;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        httpURLConnection = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    httpURLConnection.disconnect();
                }
            }
        }
    }

    public n(Context context, UnityPlayer unityPlayer, m mVar) {
        super(context);
        this.f8410d = 5;
        this.f8416j = 0;
        this.f8417k = 5;
        this.m = new TimerTask() { // from class: com.unity3d.player.n.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                n.this.a.runOnUiThread(new Runnable() { // from class: com.unity3d.player.n.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        n nVar = n.this;
                        if (nVar.f8418l) {
                            nVar.f8417k--;
                            nVar.f8414h.setText("Skip " + n.this.f8417k);
                            n nVar2 = n.this;
                            if (nVar2.f8417k <= 0) {
                                nVar2.i();
                            }
                        }
                    }
                });
            }
        };
        this.c = context;
        this.a = unityPlayer;
        this.b = mVar;
        d();
        e();
        g();
    }

    private static String a(String str, String str2) {
        if (str == null || str.indexOf(63) == -1) {
            return null;
        }
        for (String str3 : str.split("\\?")[1].split("&")) {
            String[] split = str3.split("=");
            if (str2.equals(split[0])) {
                return split[1];
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (!str.startsWith("deeplinker")) {
            if (e(str)) {
                c(str);
                return;
            }
            return;
        }
        String f2 = f(a(str, "primaryUrl"));
        String f3 = f(a(str, "fallbackUrl"));
        if (d(f2) && f2 != null && e(f2)) {
            if (this.b.h() != null) {
                new a().execute(this.b.h());
            }
            c(f2);
        } else if (f3 == null || !e(f3)) {
        } else {
            if (this.b.i() != null) {
                new a().execute(this.b.i());
            }
            c(f3);
        }
    }

    private void c(String str) {
        if (str == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.c.startActivity(intent);
        if (this.b.e() != null) {
            new a().execute(this.b.e());
        }
    }

    private void d() {
        if (!"VIDEO".equals(this.b.j())) {
            String b = this.b.b();
            if (this.b.b() == null || this.b.b() == "" || this.f8412f != null) {
                return;
            }
            if (b.startsWith(InspirePublishFragment.FILE_HEADER)) {
                b = b.substring(7);
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(b);
            if (decodeFile == null) {
                return;
            }
            this.f8412f = new ImageView(this.c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(11);
            layoutParams.addRule(9);
            this.f8412f.setLayoutParams(layoutParams);
            this.f8412f.setImageBitmap(decodeFile);
            this.f8412f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.f8412f);
        } else if (this.b.k() == null || this.b.k() == "" || this.f8411e != null) {
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(11);
            layoutParams2.addRule(9);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.c, Uri.parse(this.b.k()));
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 2);
            ImageView imageView = new ImageView(this.c);
            imageView.setLayoutParams(layoutParams2);
            imageView.setImageBitmap(frameAtTime);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(imageView);
            VideoView videoView = new VideoView(this.c);
            this.f8411e = videoView;
            videoView.setLayoutParams(layoutParams2);
            this.f8411e.setVideoPath(this.b.k());
            addView(this.f8411e);
        }
    }

    private boolean d(String str) {
        if (str == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        return this.c.getPackageManager().resolveActivity(intent, 0) != null;
    }

    private void e() {
        if (this.a.getShowSplashSlogan().booleanValue()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("unity_splash_slogan", "drawable", this.c.getPackageName()), new BitmapFactory.Options());
            this.f8413g = new ImageView(this.c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.a.getShowSplashSloganHeight());
            layoutParams.addRule(11);
            layoutParams.addRule(9);
            layoutParams.addRule(12);
            this.f8413g.setLayoutParams(layoutParams);
            this.f8413g.setImageBitmap(decodeResource);
            this.f8413g.setScaleType(ImageView.ScaleType.CENTER);
            this.f8413g.setBackgroundColor(-1);
            addView(this.f8413g);
        }
    }

    private static boolean e(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("http");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Uri.encode(URLDecoder.decode(str, "UTF-8"), "@#&=*+-_.,:!?()/~'%");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private void f() {
        this.f8414h = new TextView(this.c);
        String str = "Skip " + this.f8410d;
        if (this.f8411e != null) {
            str = "Skip";
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = 48;
        layoutParams.topMargin = 72;
        this.f8414h.setLayoutParams(layoutParams);
        this.f8414h.setText(str);
        this.f8414h.setTextSize(15.0f);
        this.f8414h.setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-7829368);
        gradientDrawable.setCornerRadius(12.0f);
        gradientDrawable.setStroke(3, -1);
        this.f8414h.setBackground(gradientDrawable);
        this.f8414h.setPadding(20, 5, 20, 5);
        this.f8414h.setAlpha(0.8f);
        this.f8414h.setOnClickListener(new View.OnClickListener() { // from class: com.unity3d.player.n.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public final void onClick(View view) {
                VdsAgent.onClick(this, view);
                n.this.h();
            }
        });
        addView(this.f8414h);
    }

    private void g() {
        TextView textView = new TextView(this.c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.leftMargin = 32;
        layoutParams.topMargin = 64;
        textView.setLayoutParams(layoutParams);
        textView.setText("ADS");
        textView.setTextSize(8.0f);
        textView.setTextColor(-7829368);
        textView.setAlpha(0.8f);
        textView.setPadding(10, 5, 10, 5);
        addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        VideoView videoView = this.f8411e;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        Timer timer = this.f8415i;
        if (timer != null) {
            timer.cancel();
        }
        this.a.NotifySplashAdsFinished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.b.l() != null) {
            new a().execute(this.b.l());
        }
        h();
    }

    public final void a() {
        if (this.b.f() > 0) {
            int f2 = this.b.f();
            this.f8410d = f2;
            this.f8417k = f2;
        }
        f();
        VideoView videoView = this.f8411e;
        if (videoView != null) {
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.unity3d.player.n.2
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    n.this.i();
                }
            });
            this.f8411e.start();
        } else {
            Timer timer = new Timer();
            this.f8415i = timer;
            this.f8418l = true;
            timer.schedule(this.m, 1000L, 1000L);
        }
        if (this.b.d() != null) {
            new a().execute(this.b.d());
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.unity3d.player.n.3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    n nVar = n.this;
                    nVar.b(nVar.b.c());
                    return true;
                }
                return true;
            }
        });
    }

    public final void b() {
        VideoView videoView = this.f8411e;
        if (videoView != null) {
            videoView.pause();
            this.f8416j = this.f8411e.getCurrentPosition();
        }
        if (this.f8415i != null) {
            this.f8418l = false;
        }
    }

    public final void c() {
        VideoView videoView = this.f8411e;
        if (videoView != null) {
            videoView.start();
            this.f8411e.seekTo(this.f8416j);
        }
        if (this.f8415i != null) {
            this.f8418l = true;
        }
    }
}
