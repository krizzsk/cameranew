package cn.sharesdk.framework.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.b.a.e;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.coremedia.iso.boxes.AuthorBox;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.collection.Constants;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: EventManager.java */
/* loaded from: classes.dex */
public class a {
    private static a a;

    /* renamed from: e  reason: collision with root package name */
    private boolean f85e = true;
    private c b = new c();

    /* renamed from: d  reason: collision with root package name */
    private e f84d = e.a();
    private DeviceHelper c = DeviceHelper.getInstance(MobSDK.getContext());

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    private String d(String str) throws Throwable {
        HashMap<String, Object> c = this.b.c(str);
        if (c != null && c.size() > 0 && c.containsKey("status") && ResHelper.parseInt(String.valueOf(c.get("status"))) == 200 && c.containsKey("url")) {
            return (String) c.get("url");
        }
        return null;
    }

    private String e(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    public void b() {
        try {
            String networkType = this.c.getNetworkType();
            if (!PortalFollowFeeds.TYPE_NONE.equals(networkType) && !TextUtils.isEmpty(networkType)) {
                long longValue = this.f84d.l().longValue();
                long currentTimeMillis = System.currentTimeMillis();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(longValue);
                int i2 = calendar.get(5);
                calendar.setTimeInMillis(currentTimeMillis);
                int i3 = calendar.get(5);
                if (currentTimeMillis - longValue >= AdvTimeUtils.MILLIS_OF_A_DAY || i2 != i3) {
                    HashMap<String, Object> a2 = this.b.a();
                    this.f84d.c(a2.containsKey("res") ? "true".equals(String.valueOf(a2.get("res"))) : true);
                    if (a2 == null || a2.size() <= 0) {
                        return;
                    }
                    this.f84d.b(System.currentTimeMillis());
                }
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }

    public void c() {
        HashMap hashMap;
        HashMap hashMap2;
        try {
            String networkType = this.c.getNetworkType();
            if (PortalFollowFeeds.TYPE_NONE.equals(networkType) || TextUtils.isEmpty(networkType) || !this.f84d.k()) {
                return;
            }
            this.f84d.a(System.currentTimeMillis());
            HashMap<String, Object> c = this.b.c();
            if (c.containsKey("status") && ResHelper.parseInt(String.valueOf(c.get("status"))) == -200) {
                SSDKLog.b().d((String) c.get("error"), new Object[0]);
                return;
            }
            if (c.containsKey("timestamp")) {
                this.f84d.a("service_time", Long.valueOf(System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(c.get("timestamp")))));
            }
            if (c.containsKey("switchs") && (hashMap2 = (HashMap) c.get("switchs")) != null) {
                String valueOf = String.valueOf(hashMap2.get(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX));
                String valueOf2 = String.valueOf(hashMap2.get(FirebaseAnalytics.Event.SHARE));
                String valueOf3 = String.valueOf(hashMap2.get(AuthorBox.TYPE));
                String valueOf4 = String.valueOf(hashMap2.get("backflow"));
                String valueOf5 = String.valueOf(hashMap2.get("loginplus"));
                String valueOf6 = String.valueOf(hashMap2.get("linkcard"));
                this.f84d.b(valueOf);
                this.f84d.d(valueOf2);
                this.f84d.c(valueOf3);
                this.f84d.a(valueOf4);
                this.f84d.e(valueOf5);
                this.f84d.f(valueOf6);
            }
            if (!c.containsKey("serpaths") || (hashMap = (HashMap) c.get("serpaths")) == null) {
                return;
            }
            String valueOf7 = String.valueOf(hashMap.get("defhost"));
            String valueOf8 = String.valueOf(hashMap.get("defport"));
            if (!TextUtils.isEmpty(valueOf7) && !TextUtils.isEmpty(valueOf8)) {
                if (!"443".equals(valueOf8) && !"80".equals(valueOf8)) {
                    c cVar = this.b;
                    cVar.b(MobSDK.checkRequestUrl(valueOf7) + ":" + valueOf8);
                }
                this.b.b(MobSDK.checkRequestUrl(valueOf7));
            }
            HashMap<String, String> hashMap3 = new HashMap<>();
            if (hashMap.containsKey("assigns")) {
                HashMap hashMap4 = (HashMap) hashMap.get("assigns");
                if (hashMap4 != null && hashMap4.size() != 0) {
                    for (String str : hashMap4.keySet()) {
                        HashMap hashMap5 = (HashMap) hashMap4.get(str);
                        String valueOf9 = String.valueOf(hashMap5.get("host"));
                        String valueOf10 = String.valueOf(hashMap5.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT));
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf9) && !TextUtils.isEmpty(valueOf10)) {
                            hashMap3.put(str, Constants.HTTP_PROTOCOL_PREFIX + valueOf9 + ":" + valueOf10);
                        }
                    }
                    this.b.a(hashMap3);
                    return;
                }
                this.b.a((HashMap<String, String>) null);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }

    public HashMap<String, Object> f() {
        if (!this.f84d.k() && this.f84d.m()) {
            return new HashMap<>();
        }
        try {
            HashMap<String, Object> d2 = this.b.d();
            this.f84d.d(true);
            return d2;
        } catch (Throwable th) {
            this.f84d.d(false);
            SSDKLog.b().d(th);
            return new HashMap<>();
        }
    }

    public void a(String str) {
        if (this.b == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.b.a(str);
    }

    public void a(cn.sharesdk.framework.b.b.c cVar) {
        try {
            if (this.f84d.k()) {
                if (cVar instanceof cn.sharesdk.framework.b.b.b) {
                    a((cn.sharesdk.framework.b.b.b) cVar);
                } else if (cVar instanceof f) {
                    a((f) cVar);
                }
                if (!this.f84d.c()) {
                    cVar.f95l = null;
                }
                long b = this.f84d.b();
                if (b == 0) {
                    b = this.b.b();
                }
                cVar.f88e = System.currentTimeMillis() - b;
                this.b.a(cVar);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }

    public void d() {
        boolean a2;
        try {
            String networkType = this.c.getNetworkType();
            if (PortalFollowFeeds.TYPE_NONE.equals(networkType) || TextUtils.isEmpty(networkType) || !this.f84d.k()) {
                return;
            }
            ArrayList<cn.sharesdk.framework.b.a.c> e2 = this.b.e();
            for (int i2 = 0; i2 < e2.size(); i2++) {
                cn.sharesdk.framework.b.a.c cVar = e2.get(i2);
                if (cVar.b.size() == 1) {
                    a2 = a(cVar.a, false);
                } else {
                    a2 = a(e(cVar.a), true);
                }
                if (a2) {
                    this.b.a(cVar.b);
                }
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }

    public HashMap<String, Object> e() {
        try {
            return this.b.f();
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return new HashMap<>();
        }
    }

    public String b(String str) {
        if (this.f84d.k()) {
            try {
                return a(str, b.BEFORE_SHARE);
            } catch (Throwable th) {
                SSDKLog.b().d(th);
                return null;
            }
        }
        return null;
    }

    private void a(cn.sharesdk.framework.b.b.b bVar) throws Throwable {
        boolean d2 = this.f84d.d();
        String str = bVar.c;
        if (d2 && !TextUtils.isEmpty(str)) {
            bVar.c = Data.Base64AES(str, bVar.f89f.substring(0, 16));
            return;
        }
        bVar.f87d = null;
        bVar.c = null;
    }

    private void a(f fVar) throws Throwable {
        ArrayList<Bitmap> arrayList;
        ArrayList<String> arrayList2;
        int f2 = this.f84d.f();
        boolean d2 = this.f84d.d();
        f.a aVar = fVar.f97d;
        if (f2 == 1) {
            int size = (aVar == null || (arrayList2 = aVar.f99e) == null) ? 0 : arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                String a2 = a(aVar.f99e.get(i2), b.FINISH_SHARE);
                if (!TextUtils.isEmpty(a2)) {
                    aVar.f98d.add(a2);
                }
            }
            int size2 = (aVar == null || (arrayList = aVar.f100f) == null) ? 0 : arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String a3 = a(aVar.f100f.get(i3), b.FINISH_SHARE);
                if (!TextUtils.isEmpty(a3)) {
                    aVar.f98d.add(a3);
                }
            }
        } else {
            fVar.f97d = null;
        }
        if (d2) {
            return;
        }
        fVar.m = null;
    }

    private String a(String str, b bVar) throws Throwable {
        double ceil;
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            String networkType = this.c.getNetworkType();
            if (!PortalFollowFeeds.TYPE_NONE.equals(networkType) && !TextUtils.isEmpty(networkType)) {
                Bitmap.CompressFormat bmpFormat = BitmapHelper.getBmpFormat(str);
                float f2 = bVar == b.BEFORE_SHARE ? 600.0f : 200.0f;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inJustDecodeBounds = false;
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                if (i2 >= i3 && i3 > f2) {
                    ceil = Math.ceil(i3 / f2);
                } else if (i2 < i3 && i2 > f2) {
                    ceil = Math.ceil(i2 / f2);
                } else {
                    return d(str);
                }
                int i4 = (int) ceil;
                if (i4 <= 0) {
                    i4 = 1;
                }
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = i4;
                options2.inPurgeable = true;
                options2.inInputShareable = true;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options2);
                decodeFile.getHeight();
                decodeFile.getWidth();
                File createTempFile = File.createTempFile("bm_tmp2", "." + bmpFormat.name().toLowerCase());
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                decodeFile.compress(bmpFormat, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return d(createTempFile.getAbsolutePath());
            }
        }
        return null;
    }

    public HashMap<String, Object> c(String str) {
        try {
            return this.b.d(str);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    private String a(Bitmap bitmap, b bVar) throws Throwable {
        File createTempFile = File.createTempFile("bm_tmp", ".png");
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return a(createTempFile.getAbsolutePath(), bVar);
    }

    private boolean a(String str, boolean z) throws Throwable {
        return this.b.a(str, z);
    }

    public String a(String str, int i2, boolean z, String str2) {
        String a2;
        try {
            if (this.f84d.k() && this.f84d.e()) {
                String networkType = this.c.getNetworkType();
                if (!PortalFollowFeeds.TYPE_NONE.equals(networkType) && !TextUtils.isEmpty(networkType)) {
                    if (z && (a2 = a(str, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", i2, str2)) != null && !a2.equals(str)) {
                        return a2;
                    }
                    String a3 = a(str, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", i2, str2);
                    if (a3 != null) {
                        if (!a3.equals(str)) {
                            return a3;
                        }
                    }
                }
            }
            return str;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return str;
        }
    }

    private String a(String str, String str2, int i2, String str3) throws Throwable {
        HashMap<String, Object> a2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Pattern compile = Pattern.compile(str2);
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            if (group != null && group.length() > 0) {
                arrayList.add(group);
            }
        }
        if (arrayList.size() != 0 && (a2 = this.b.a(str, arrayList, i2, str3)) != null && a2.size() > 0 && a2.containsKey("data")) {
            HashMap hashMap = new HashMap();
            Iterator it = ((ArrayList) a2.get("data")).iterator();
            while (it.hasNext()) {
                HashMap hashMap2 = (HashMap) it.next();
                hashMap.put(String.valueOf(hashMap2.get("source")), String.valueOf(hashMap2.get("surl")));
            }
            Matcher matcher2 = compile.matcher(str);
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            while (matcher2.find()) {
                sb.append(str.substring(i3, matcher2.start()));
                sb.append((String) hashMap.get(matcher2.group()));
                i3 = matcher2.end();
            }
            sb.append(str.substring(i3, str.length()));
            String sb2 = sb.toString();
            SSDKLog.b().i("> SERVER_SHORT_LINK_URL content after replace link ===  %s", sb2);
            return sb2;
        }
        return str;
    }

    public String a(Bitmap bitmap) {
        if (this.f84d.k()) {
            try {
                return a(bitmap, b.BEFORE_SHARE);
            } catch (Throwable th) {
                SSDKLog.b().d(th);
                return null;
            }
        }
        return null;
    }

    public void a(HashMap<String, Object> hashMap) {
        try {
            this.b.b(hashMap);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }
}
