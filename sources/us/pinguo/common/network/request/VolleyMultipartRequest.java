package us.pinguo.common.network.request;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.entity.mime.f;
import org.apache.http.entity.mime.g.d;
import org.apache.http.entity.mime.g.e;
import us.pinguo.common.network.WriteBodyRequest;
/* loaded from: classes4.dex */
public class VolleyMultipartRequest<T> extends VolleyBaseRequest<T> implements WriteBodyRequest {
    private f mMultipartEntity;

    /* loaded from: classes4.dex */
    public static final class Builder<T> {
        private String cacheKey;
        private Map<String, String> headers;
        private int method = 1;
        private f multipartEntity;
        private Class respType;
        private String url;

        public Builder(Class cls) {
            this.respType = cls;
        }

        public Builder addFile(String str, File file, String str2) {
            if (this.multipartEntity == null) {
                this.multipartEntity = new f();
            }
            if (!TextUtils.isEmpty(str)) {
                this.multipartEntity.a(str, new d(file, str2));
            }
            return this;
        }

        public Builder addHeader(String str, Object obj) {
            if (this.headers == null) {
                this.headers = new HashMap();
            }
            if (!TextUtils.isEmpty(str)) {
                if (obj == null) {
                    obj = "";
                }
                this.headers.put(str, String.valueOf(obj));
            }
            return this;
        }

        public Builder addParam(String str, Object obj) {
            if (this.multipartEntity == null) {
                this.multipartEntity = new f();
            }
            if (!TextUtils.isEmpty(str)) {
                if (obj == null) {
                    obj = "";
                }
                this.multipartEntity.a(str, e.d(String.valueOf(obj), "text/plain", Charset.defaultCharset()));
            }
            return this;
        }

        public VolleyMultipartRequest<T> build() {
            return new VolleyMultipartRequest<>(this);
        }

        public Builder withCacheKey(String str) {
            this.cacheKey = str;
            return this;
        }

        public Builder withMethod(int i2) {
            if (i2 != 0 && i2 != 3) {
                this.method = i2;
                return this;
            }
            throw new IllegalArgumentException("VolleyMultipartRequest method can not be GET or DELETE");
        }

        public Builder withUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public VolleyMultipartRequest(Builder builder) {
        super(builder.method, builder.url, builder.headers, builder.cacheKey, builder.respType);
        this.mMultipartEntity = builder.multipartEntity;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() throws AuthFailureError {
        return null;
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        try {
            return this.mMultipartEntity.getContentType().getValue();
        } catch (Exception unused) {
            return super.getBodyContentType();
        }
    }

    @Override // us.pinguo.common.network.request.VolleyBaseRequest
    public long getContentLength() {
        return this.mMultipartEntity.getContentLength();
    }

    @Override // us.pinguo.common.network.WriteBodyRequest
    public void writeToBody(OutputStream outputStream) throws IOException {
        this.mMultipartEntity.writeTo(outputStream);
    }
}
