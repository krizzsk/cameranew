package com.android.pgvolley.toolbox;

import android.os.SystemClock;
import com.android.pgvolley.Cache;
import com.android.pgvolley.Network;
import com.android.pgvolley.Request;
import com.android.pgvolley.RetryPolicy;
import com.android.pgvolley.ServerError;
import com.android.pgvolley.VolleyError;
import com.android.pgvolley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes.dex */
public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static int DEFAULT_POOL_SIZE = 4096;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    private void addCacheHeaders(Map<String, String> map, Cache.Entry entry) {
        if (entry == null) {
            return;
        }
        String str = entry.etag;
        if (str != null) {
            map.put(HttpRequest.HEADER_IF_NONE_MATCH, str);
        }
        if (entry.lastModified > 0) {
            map.put("If-Modified-Since", DateUtils.formatDate(new Date(entry.lastModified)));
        }
    }

    private static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e2) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e2;
        }
    }

    protected static Map<String, String> convertHeaders(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i2 = 0; i2 < headerArr.length; i2++) {
            treeMap.put(headerArr[i2].getName(), headerArr[i2].getValue());
        }
        return treeMap;
    }

    private byte[] entityToBytes(HttpEntity httpEntity) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                byte[] buf = this.mPool.getBuf(1024);
                while (true) {
                    int read = content.read(buf);
                    if (read == -1) {
                        break;
                    }
                    poolingByteArrayOutputStream.write(buf, 0, read);
                }
                byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                try {
                    httpEntity.consumeContent();
                } catch (IOException unused) {
                    VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
                }
                this.mPool.returnBuf(buf);
                poolingByteArrayOutputStream.close();
                return byteArray;
            }
            throw new ServerError();
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                VolleyLog.v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(null);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    private void logSlowRequests(long j2, Request<?> request, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j2 > SLOW_REQUEST_THRESHOLD_MS) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j2);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    protected void logError(String str, String str2, long j2) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j2), str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b8, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0156 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r16v6 */
    @Override // com.android.pgvolley.Network
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.pgvolley.NetworkResponse performRequest(com.android.pgvolley.Request<?> r23) throws com.android.pgvolley.VolleyError {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.pgvolley.toolbox.BasicNetwork.performRequest(com.android.pgvolley.Request):com.android.pgvolley.NetworkResponse");
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mPool = byteArrayPool;
    }
}
