package com.google.zxing.datamatrix.encoder;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.charset.StandardCharsets;
/* compiled from: EncoderContext.java */
/* loaded from: classes2.dex */
final class h {
    private final String a;
    private SymbolShapeHint b;
    private com.google.zxing.c c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.zxing.c f5008d;

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f5009e;

    /* renamed from: f  reason: collision with root package name */
    int f5010f;

    /* renamed from: g  reason: collision with root package name */
    private int f5011g;

    /* renamed from: h  reason: collision with root package name */
    private k f5012h;

    /* renamed from: i  reason: collision with root package name */
    private int f5013i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c = (char) (bytes[i2] & Draft_75.END_OF_FRAME);
            if (c == '?' && str.charAt(i2) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c);
        }
        this.a = sb.toString();
        this.b = SymbolShapeHint.FORCE_NONE;
        this.f5009e = new StringBuilder(str.length());
        this.f5011g = -1;
    }

    private int h() {
        return this.a.length() - this.f5013i;
    }

    public int a() {
        return this.f5009e.length();
    }

    public StringBuilder b() {
        return this.f5009e;
    }

    public char c() {
        return this.a.charAt(this.f5010f);
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.f5011g;
    }

    public int f() {
        return h() - this.f5010f;
    }

    public k g() {
        return this.f5012h;
    }

    public boolean i() {
        return this.f5010f < h();
    }

    public void j() {
        this.f5011g = -1;
    }

    public void k() {
        this.f5012h = null;
    }

    public void l(com.google.zxing.c cVar, com.google.zxing.c cVar2) {
        this.c = cVar;
        this.f5008d = cVar2;
    }

    public void m(int i2) {
        this.f5013i = i2;
    }

    public void n(SymbolShapeHint symbolShapeHint) {
        this.b = symbolShapeHint;
    }

    public void o(int i2) {
        this.f5011g = i2;
    }

    public void p() {
        q(a());
    }

    public void q(int i2) {
        k kVar = this.f5012h;
        if (kVar == null || i2 > kVar.a()) {
            this.f5012h = k.l(i2, this.b, this.c, this.f5008d, true);
        }
    }

    public void r(char c) {
        this.f5009e.append(c);
    }

    public void s(String str) {
        this.f5009e.append(str);
    }
}
