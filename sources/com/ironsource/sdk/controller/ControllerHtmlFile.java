package com.ironsource.sdk.controller;

import com.ironsource.sdk.fileSystem.ISNFile;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ControllerHtmlFile {
    private long a;
    private int b;
    private ControllerSourceStrategy c;

    /* renamed from: d  reason: collision with root package name */
    private LoadedControllerSource f5712d = LoadedControllerSource.NONE;

    /* renamed from: e  reason: collision with root package name */
    private String f5713e;

    /* renamed from: f  reason: collision with root package name */
    private String f5714f;

    /* renamed from: g  reason: collision with root package name */
    private d.e.d.o.b f5715g;

    /* loaded from: classes2.dex */
    public enum ControllerSourceStrategy {
        FETCH_FROM_SERVER_NO_FALLBACK,
        FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK,
        FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL
    }

    /* loaded from: classes2.dex */
    public enum LoadedControllerSource {
        NONE(0),
        PREPARED_CONTROLLER_LOADED(1),
        CONTROLLER_FROM_SERVER(2),
        MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(3),
        FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(4),
        FALLBACK_CONTROLLER_RECOVERY(5);
        
        private int mControllerSourceCode;

        LoadedControllerSource(int i2) {
            this.mControllerSourceCode = i2;
        }

        public int getCode() {
            return this.mControllerSourceCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends JSONObject {
        a() throws JSONException {
            putOpt("controllerSourceStrategy", Integer.valueOf(ControllerHtmlFile.this.b));
            putOpt("controllerSourceCode", Integer.valueOf(ControllerHtmlFile.this.f5712d.getCode()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ControllerSourceStrategy.values().length];
            a = iArr;
            try {
                iArr[ControllerSourceStrategy.FETCH_FROM_SERVER_NO_FALLBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ControllerSourceStrategy.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ControllerSourceStrategy.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ControllerHtmlFile(JSONObject jSONObject, String str, String str2, d.e.d.o.b bVar) {
        int optInt = jSONObject.optInt("controllerSourceStrategy", -1);
        this.b = optInt;
        this.c = m(optInt);
        this.f5713e = str;
        this.f5714f = str2;
        this.f5715g = bVar;
    }

    private boolean c() {
        try {
            if (p()) {
                return com.ironsource.sdk.utils.c.x(k().getPath(), j().getPath());
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean d() throws Exception {
        return com.ironsource.sdk.utils.c.x(l().getPath(), j().getPath());
    }

    private void e() {
        try {
            ISNFile j2 = j();
            if (j2.exists()) {
                ISNFile k2 = k();
                if (k2.exists()) {
                    k2.delete();
                }
                com.ironsource.sdk.utils.c.x(j2.getPath(), k2.getPath());
            }
        } catch (Exception unused) {
        }
    }

    private void f() {
        com.ironsource.sdk.utils.c.f(k());
    }

    private void g() {
        com.ironsource.sdk.utils.c.f(j());
    }

    private void h(ISNFile iSNFile) {
        if (this.f5715g.i()) {
            return;
        }
        this.f5715g.d(iSNFile, this.f5714f);
    }

    private ISNFile j() {
        return new ISNFile(this.f5713e, "mobileController.html");
    }

    private ISNFile k() {
        return new ISNFile(this.f5713e, "fallback_mobileController.html");
    }

    private ISNFile l() {
        return new ISNFile(this.f5713e, "next_mobileController.html");
    }

    private ControllerSourceStrategy m(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return ControllerSourceStrategy.FETCH_FROM_SERVER_NO_FALLBACK;
            }
            return ControllerSourceStrategy.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL;
        }
        return ControllerSourceStrategy.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK;
    }

    private boolean p() {
        return k().exists();
    }

    private void r() {
        d.e.d.a.a aVar = new d.e.d.a.a();
        aVar.a("generalmessage", Integer.valueOf(this.b));
        if (this.a > 0) {
            aVar.a("timingvalue", Long.valueOf(System.currentTimeMillis() - this.a));
        }
        d.e.d.a.d.d(d.e.d.a.f.w, aVar.b());
    }

    private void s(LoadedControllerSource loadedControllerSource) {
        d.e.d.a.a aVar = new d.e.d.a.a();
        aVar.a("generalmessage", Integer.valueOf(this.b));
        aVar.a("controllersource", Integer.valueOf(loadedControllerSource.getCode()));
        if (this.a > 0) {
            aVar.a("timingvalue", Long.valueOf(System.currentTimeMillis() - this.a));
        }
        d.e.d.a.d.d(d.e.d.a.f.v, aVar.b());
    }

    private boolean u() {
        return this.f5712d != LoadedControllerSource.NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject i() throws JSONException {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Runnable runnable, Runnable runnable2) {
        if (u()) {
            return;
        }
        if (this.c == ControllerSourceStrategy.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK && c()) {
            LoadedControllerSource loadedControllerSource = LoadedControllerSource.FALLBACK_CONTROLLER_RECOVERY;
            this.f5712d = loadedControllerSource;
            s(loadedControllerSource);
            runnable.run();
            return;
        }
        r();
        runnable2.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Runnable runnable) {
        if (u()) {
            return;
        }
        if (this.c == ControllerSourceStrategy.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK) {
            f();
        }
        LoadedControllerSource loadedControllerSource = LoadedControllerSource.CONTROLLER_FROM_SERVER;
        this.f5712d = loadedControllerSource;
        s(loadedControllerSource);
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        int i2 = b.a[this.c.ordinal()];
        if (i2 == 1) {
            g();
            h(new ISNFile(this.f5713e, com.ironsource.sdk.utils.f.n(this.f5714f)));
            return false;
        } else if (i2 == 2) {
            e();
            h(new ISNFile(this.f5713e, com.ironsource.sdk.utils.f.n(this.f5714f)));
            return false;
        } else {
            if (i2 == 3) {
                try {
                    ISNFile j2 = j();
                    ISNFile l2 = l();
                    if (!l2.exists() && !j2.exists()) {
                        h(new ISNFile(this.f5713e, com.ironsource.sdk.utils.f.n(this.f5714f)));
                        return false;
                    } else if (!l2.exists() && j2.exists()) {
                        LoadedControllerSource loadedControllerSource = LoadedControllerSource.MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                        this.f5712d = loadedControllerSource;
                        s(loadedControllerSource);
                        h(new ISNFile(this.f5713e, l2.getName()));
                        return true;
                    } else {
                        e();
                        if (d()) {
                            LoadedControllerSource loadedControllerSource2 = LoadedControllerSource.PREPARED_CONTROLLER_LOADED;
                            this.f5712d = loadedControllerSource2;
                            s(loadedControllerSource2);
                            f();
                            h(new ISNFile(this.f5713e, l2.getName()));
                            return true;
                        } else if (c()) {
                            LoadedControllerSource loadedControllerSource3 = LoadedControllerSource.FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                            this.f5712d = loadedControllerSource3;
                            s(loadedControllerSource3);
                            h(new ISNFile(this.f5713e, l2.getName()));
                            return true;
                        } else {
                            h(new ISNFile(this.f5713e, com.ironsource.sdk.utils.f.n(this.f5714f)));
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        d.e.d.a.a aVar = new d.e.d.a.a();
        aVar.a("generalmessage", Integer.valueOf(this.b));
        d.e.d.a.d.d(d.e.d.a.f.u, aVar.b());
        this.a = System.currentTimeMillis();
    }
}
