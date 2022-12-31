package com.mob.tools.network;

import android.os.Build;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ReflectHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class HttpConnectionImpl implements HttpConnection {
    private Object response;

    static {
        try {
            ReflectHelper.importClass("org.apache.http.HttpResponse");
            ReflectHelper.importClass("org.apache.http.Header");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public HttpConnectionImpl(Object obj) {
        this.response = obj;
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getErrorStream() throws IOException {
        return getInputStream();
    }

    @Override // com.mob.tools.network.HttpConnection
    public Map<String, List<String>> getHeaderFields() throws IOException {
        try {
            HashMap hashMap = new HashMap();
            Object invokeInstanceMethod = ReflectHelper.invokeInstanceMethod(this.response, "getAllHeaders", new Object[0]);
            if (invokeInstanceMethod != null) {
                int intValue = ((Integer) ReflectHelper.getInstanceField(invokeInstanceMethod, "length")).intValue();
                Object[] objArr = new Object[intValue];
                System.arraycopy(invokeInstanceMethod, 0, objArr, 0, intValue);
                for (int i2 = 0; i2 < intValue; i2++) {
                    Object obj = objArr[i2];
                    String str = (String) ReflectHelper.invokeInstanceMethod(obj, "getName", new Object[0]);
                    String str2 = (String) ReflectHelper.invokeInstanceMethod(obj, "getValue", new Object[0]);
                    if (str2 == null) {
                        str2 = "";
                    }
                    hashMap.put(str, Arrays.asList(str2.split(",")));
                }
            }
            return hashMap;
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT < 9) {
                throw new IOException(th.getMessage());
            }
            throw new IOException(th);
        }
    }

    @Override // com.mob.tools.network.HttpConnection
    public InputStream getInputStream() throws IOException {
        try {
            return (InputStream) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.response, "getEntity", new Object[0]), "getContent", new Object[0]);
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT < 9) {
                throw new IOException(th.getMessage());
            }
            throw new IOException(th);
        }
    }

    @Override // com.mob.tools.network.HttpConnection
    public int getResponseCode() throws IOException {
        try {
            return ((Integer) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(this.response, "getStatusLine", new Object[0]), "getStatusCode", new Object[0])).intValue();
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT < 9) {
                throw new IOException(th.getMessage());
            }
            throw new IOException(th);
        }
    }
}
