package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.bytedance.sdk.adnet.face.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import us.pinguo.common.network.HttpRequest;
/* compiled from: BasicNetwork.java */
/* loaded from: classes.dex */
public class a implements com.bytedance.sdk.adnet.face.b {
    protected static final boolean a = o.a;
    protected final IHttpStack b;
    protected final b c;

    public a(IHttpStack iHttpStack) {
        this(iHttpStack, new b(4096));
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c2, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0150, code lost:
        throw new com.bytedance.sdk.adnet.err.f(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0177 A[SYNTHETIC] */
    @Override // com.bytedance.sdk.adnet.face.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.adnet.core.i a(com.bytedance.sdk.adnet.core.Request<?> r22) throws com.bytedance.sdk.adnet.err.VAdError {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.a.a(com.bytedance.sdk.adnet.core.Request):com.bytedance.sdk.adnet.core.i");
    }

    public a(IHttpStack iHttpStack, b bVar) {
        this.b = iHttpStack;
        this.c = bVar;
    }

    private void a(long j2, Request<?> request, byte[] bArr, int i2) {
        if (a || j2 > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j2);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().b());
            o.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void a(String str, Request<?> request, VAdError vAdError) throws VAdError {
        com.bytedance.sdk.adnet.face.d retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.a(vAdError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VAdError e2) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e2;
        }
    }

    private Map<String, String> a(a.C0044a c0044a) {
        if (c0044a == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = c0044a.c;
        if (str != null) {
            hashMap.put(HttpRequest.HEADER_IF_NONE_MATCH, str);
        }
        long j2 = c0044a.f1262e;
        if (j2 > 0) {
            hashMap.put("If-Modified-Since", com.bytedance.sdk.adnet.d.b.a(j2));
        }
        return hashMap;
    }

    protected byte[] a(Request<?> request, HttpResponse httpResponse) throws IOException, com.bytedance.sdk.adnet.err.f {
        if (request instanceof com.bytedance.sdk.adnet.b.c) {
            return ((com.bytedance.sdk.adnet.b.c) request).a(httpResponse);
        }
        InputStream content = httpResponse.getContent();
        return content != null ? a(content, httpResponse.getContentLength()) : new byte[0];
    }

    private byte[] a(InputStream inputStream, int i2) throws IOException, com.bytedance.sdk.adnet.err.f {
        c cVar = new c(this.c, i2);
        try {
            if (inputStream != null) {
                byte[] a2 = this.c.a(1024);
                while (true) {
                    int read = inputStream.read(a2);
                    if (read == -1) {
                        break;
                    }
                    cVar.write(a2, 0, read);
                }
                byte[] byteArray = cVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        o.a("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.c.a(a2);
                cVar.close();
                return byteArray;
            }
            throw new com.bytedance.sdk.adnet.err.f();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    o.a("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.c.a((byte[]) null);
            cVar.close();
            throw th;
        }
    }

    private static List<Header> a(List<Header> list, a.C0044a c0044a) {
        ArrayList arrayList = new ArrayList();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (list != null && !list.isEmpty()) {
            for (Header header : list) {
                treeSet.add(header.getName());
                arrayList.add(header);
            }
        }
        if (c0044a != null) {
            List<Header> list2 = c0044a.f1266i;
            if (list2 != null) {
                if (!list2.isEmpty()) {
                    for (Header header2 : c0044a.f1266i) {
                        if (!treeSet.contains(header2.getName())) {
                            arrayList.add(header2);
                        }
                    }
                }
            } else if (!c0044a.f1265h.isEmpty()) {
                for (Map.Entry<String, String> entry : c0044a.f1265h.entrySet()) {
                    if (!treeSet.contains(entry.getKey())) {
                        arrayList.add(new Header(entry.getKey(), entry.getValue()));
                    }
                }
            }
        }
        return arrayList;
    }
}
