package us.pinguo.foundation.m;

import com.android.volley.AuthFailureError;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
/* compiled from: VolleyMkFileRequest.java */
/* loaded from: classes4.dex */
public class h<T> extends g<String> {

    /* renamed from: f  reason: collision with root package name */
    private String f11029f;

    /* renamed from: g  reason: collision with root package name */
    private String f11030g;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(String str, String str2, int i2, String str3) {
        super(i2, str3);
        this.f11030g = "";
        this.f11030g = str2;
        this.f11029f = str;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        return this.f11030g.getBytes();
    }

    @Override // us.pinguo.foundation.m.j
    public long getContentLength() {
        return this.f11030g.getBytes().length;
    }

    @Override // com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpRequest.HEADER_CONTENT_TYPE, "text/plain");
        hashMap.put(HttpRequest.HEADER_CONTENT_LENGTH, String.valueOf(this.f11030g.getBytes().length));
        hashMap.put(HttpRequest.HEADER_AUTHORIZATION, "UpToken " + this.f11029f);
        return hashMap;
    }
}
