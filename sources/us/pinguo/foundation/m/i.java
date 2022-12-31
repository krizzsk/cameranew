package us.pinguo.foundation.m;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import us.pinguo.common.network.WriteBodyRequest;
import us.pinguo.foundation.m.e;
/* compiled from: VolleyMultipartRequest.java */
/* loaded from: classes4.dex */
public class i<T> extends g<T> implements WriteBodyRequest {

    /* renamed from: f  reason: collision with root package name */
    private org.apache.http.entity.mime.f f11031f;

    public i(int i2, String str, e.a aVar) {
        super(i2, str);
        this.f11031f = new org.apache.http.entity.mime.f();
        if (aVar != null) {
            this.f11031f = new e(aVar);
        }
    }

    @Override // us.pinguo.foundation.m.j
    public /* bridge */ /* synthetic */ j a(String str, String str2) {
        e(str, str2);
        return this;
    }

    public i<T> d(String str, File file, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f11031f.a(str, new org.apache.http.entity.mime.g.d(file, str2));
        }
        return this;
    }

    public i<T> e(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.f11031f.a(str, org.apache.http.entity.mime.g.e.d(str2, "text/plain", Charset.defaultCharset()));
        }
        return this;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() throws AuthFailureError {
        return null;
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        try {
            return this.f11031f.getContentType().getValue();
        } catch (Exception unused) {
            return super.getBodyContentType();
        }
    }

    @Override // us.pinguo.foundation.m.j
    public long getContentLength() {
        return this.f11031f.getContentLength();
    }

    @Override // us.pinguo.common.network.WriteBodyRequest
    public void writeToBody(OutputStream outputStream) throws IOException {
        this.f11031f.writeTo(outputStream);
    }
}
