package com.bytedance.sdk.adnet.core;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class HttpResponse {
    private final int a;
    private final List<Header> b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final InputStream f1216d;

    public HttpResponse(int i2, List<Header> list) {
        this(i2, list, -1, null);
    }

    public final InputStream getContent() {
        return this.f1216d;
    }

    public final int getContentLength() {
        return this.c;
    }

    public final List<Header> getHeaders() {
        return Collections.unmodifiableList(this.b);
    }

    public final int getStatusCode() {
        return this.a;
    }

    public HttpResponse(int i2, List<Header> list, int i3, InputStream inputStream) {
        this.a = i2;
        this.b = list;
        this.c = i3;
        this.f1216d = inputStream;
    }
}
