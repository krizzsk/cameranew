package us.pinguo.smaatoapi;

import android.content.Context;
import android.content.Intent;
import us.pinguo.smaatoapi.activity.WebViewActivity;
/* compiled from: SmaatoNative.java */
/* loaded from: classes6.dex */
public class b {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f11977d;

    /* renamed from: e  reason: collision with root package name */
    private String f11978e;

    /* renamed from: f  reason: collision with root package name */
    private String f11979f;

    /* renamed from: g  reason: collision with root package name */
    private String f11980g;

    /* renamed from: h  reason: collision with root package name */
    private String f11981h;

    /* renamed from: i  reason: collision with root package name */
    private c f11982i;

    /* renamed from: j  reason: collision with root package name */
    private Context f11983j;

    /* compiled from: SmaatoNative.java */
    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            us.pinguo.smaatoapi.network.a.b(b.this.f11983j, b.this.f(), null);
        }
    }

    /* compiled from: SmaatoNative.java */
    /* renamed from: us.pinguo.smaatoapi.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class RunnableC0447b implements Runnable {
        RunnableC0447b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            us.pinguo.smaatoapi.network.a.b(b.this.f11983j, b.this.d(), null);
        }
    }

    /* compiled from: SmaatoNative.java */
    /* loaded from: classes6.dex */
    public interface c {
        void a();

        void b();
    }

    /* compiled from: SmaatoNative.java */
    /* loaded from: classes6.dex */
    public interface d {
        void c(b bVar);

        void e(String str);
    }

    public String b() {
        return this.f11980g;
    }

    public String c() {
        return this.f11981h;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f11978e;
    }

    public String f() {
        return this.a;
    }

    public String g() {
        return this.f11979f;
    }

    public String h() {
        return this.f11977d;
    }

    public String i() {
        return this.c;
    }

    public void j() {
        this.f11982i.a();
        if (c() != null) {
            Intent intent = new Intent(this.f11983j, WebViewActivity.class);
            intent.putExtra("url", c());
            this.f11983j.startActivity(intent);
        }
        if (this.f11983j == null || d() == null) {
            return;
        }
        new Thread(new RunnableC0447b()).start();
    }

    public void k(Context context) {
        this.f11983j = context;
    }

    public void l() {
        this.f11982i.b();
        if (this.f11983j == null || f() == null) {
            return;
        }
        new Thread(new a()).start();
    }

    public void m(String str) {
        this.f11980g = str;
    }

    public void n(String str) {
        this.f11981h = str;
    }

    public void o(String str) {
        this.b = str;
    }

    public void p(String str) {
        this.f11978e = str;
    }

    public void q(String str) {
        this.a = str;
    }

    public void r(c cVar) {
        this.f11982i = cVar;
    }

    public void s(String str) {
        this.f11979f = str;
    }

    public void t(String str) {
        this.f11977d = str;
    }

    public void u(String str) {
        this.c = str;
    }
}
