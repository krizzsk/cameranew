package cn.sharesdk.framework.b.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;
/* compiled from: ShareEvent.java */
/* loaded from: classes.dex */
public class f extends c {
    private static int o;
    private static long p;
    public int a;
    public String b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public a f97d = new a();
    public String m;
    public String[] n;

    /* compiled from: ShareEvent.java */
    /* loaded from: classes.dex */
    public static class a {
        public String b;

        /* renamed from: g  reason: collision with root package name */
        public HashMap<String, Object> f101g;
        public String a = "";
        public ArrayList<String> c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f98d = new ArrayList<>();

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f99e = new ArrayList<>();

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<Bitmap> f100f = new ArrayList<>();

        public String toString() {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(this.b)) {
                String replaceAll = this.b.trim().replaceAll("\r", "");
                this.b = replaceAll;
                String replaceAll2 = replaceAll.trim().replaceAll("\n", "");
                this.b = replaceAll2;
                this.b = replaceAll2.trim().replaceAll("\r\n", "");
            }
            hashMap.put("text", this.b);
            hashMap.put("url", this.c);
            ArrayList<String> arrayList = this.f98d;
            if (arrayList != null && arrayList.size() > 0) {
                hashMap.put("imgs", this.f98d);
            }
            if (this.f101g != null) {
                hashMap.put("attch", new Hashon().fromHashMap(this.f101g));
            }
            return new Hashon().fromHashMap(hashMap);
        }
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected String a() {
        return "[SHR]";
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected void a(long j2) {
        p = j2;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected int b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected int c() {
        return 30;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected long d() {
        return o;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected long e() {
        return p;
    }

    @Override // cn.sharesdk.framework.b.b.c
    protected void f() {
        o++;
    }

    @Override // cn.sharesdk.framework.b.b.c
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        sb.append(this.a);
        sb.append('|');
        sb.append(this.b);
        sb.append('|');
        sb.append(TextUtils.isEmpty(this.c) ? "" : this.c);
        String[] strArr = this.n;
        if (strArr == null || strArr.length <= 0) {
            str = "";
        } else {
            str = "[\"" + TextUtils.join("\",\"", this.n) + "\"]";
        }
        sb.append('|');
        sb.append(str);
        sb.append('|');
        a aVar = this.f97d;
        if (aVar != null) {
            try {
                String encodeToString = Base64.encodeToString(Data.AES128Encode(this.f89f.substring(0, 16), aVar.toString()), 0);
                if (encodeToString.contains("\n")) {
                    encodeToString = encodeToString.replace("\n", "");
                }
                sb.append(encodeToString);
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f95l)) {
            sb.append(this.f95l);
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.m)) {
            try {
                String encodeToString2 = Base64.encodeToString(Data.AES128Encode(this.f89f.substring(0, 16), this.m), 0);
                if (!TextUtils.isEmpty(encodeToString2) && encodeToString2.contains("\n")) {
                    encodeToString2 = encodeToString2.replace("\n", "");
                }
                sb.append(encodeToString2);
            } catch (Throwable th2) {
                SSDKLog.b().w(th2);
            }
        }
        return sb.toString();
    }
}
