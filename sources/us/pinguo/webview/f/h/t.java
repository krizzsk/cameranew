package us.pinguo.webview.f.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ReqConfigToolBar.java */
/* loaded from: classes6.dex */
public class t implements us.pinguo.webview.f.a {
    private List<c> a = null;

    /* compiled from: ReqConfigToolBar.java */
    /* loaded from: classes6.dex */
    public static class b {
        private String a;
        private String b;

        public String a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        private b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    /* compiled from: ReqConfigToolBar.java */
    /* loaded from: classes6.dex */
    public static class c {
        private b a;
        private String b;

        public c(String str) {
            this.b = str;
        }

        public String a() {
            return this.b;
        }

        public b b() {
            return this.a;
        }

        public void c(String str, String str2) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                this.a = null;
            } else {
                this.a = new b(str, str2);
            }
        }
    }

    public void a(c cVar) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(cVar);
    }

    public List<c> b() {
        return this.a;
    }
}
