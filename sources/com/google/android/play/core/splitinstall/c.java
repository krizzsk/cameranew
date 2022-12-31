package com.google.android.play.core.splitinstall;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class c {
    private final List<String> a;
    private final List<Locale> b;

    /* loaded from: classes2.dex */
    public static class a {
        private final List<String> a = new ArrayList();
        private final List<Locale> b = new ArrayList();

        /* synthetic */ a(byte[] bArr) {
        }

        public a b(String str) {
            this.a.add(str);
            return this;
        }

        @NonNull
        public c d() {
            return new c(this);
        }
    }

    /* synthetic */ c(a aVar) {
        this.a = new ArrayList(aVar.a);
        this.b = new ArrayList(aVar.b);
    }

    @NonNull
    public static a c() {
        return new a(null);
    }

    public List<Locale> a() {
        return this.b;
    }

    public List<String> b() {
        return this.a;
    }

    public String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", this.a, this.b);
    }
}
