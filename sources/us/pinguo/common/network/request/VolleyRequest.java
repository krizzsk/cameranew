package us.pinguo.common.network.request;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class VolleyRequest<T> extends VolleyBaseEncryptRequest<T> {
    private Map<String, String> mParams;

    /* loaded from: classes4.dex */
    public static final class Builder<T> {
        private String cacheKey;
        private boolean encrypt;
        private Map<String, String> headers;
        private int method = 0;
        private Map<String, String> params;
        private Class respType;
        private String url;

        public Builder(Class cls) {
            this.respType = cls;
        }

        private static String buildGetURL(String str, Map<String, String> map, String str2) {
            if (map == null || map.isEmpty()) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            if (!str.endsWith("?")) {
                sb.append("?");
            }
            try {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                boolean hasNext = it.hasNext();
                while (hasNext) {
                    Map.Entry<String, String> next = it.next();
                    sb.append(URLEncoder.encode(next.getKey(), str2));
                    sb.append('=');
                    sb.append(URLEncoder.encode(next.getValue(), str2));
                    hasNext = it.hasNext();
                    if (hasNext) {
                        sb.append('&');
                    }
                }
                return sb.toString();
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("Encoding not supported: " + str2, e2);
            }
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
            if (this.params == null) {
                this.params = new HashMap();
            }
            if (!TextUtils.isEmpty(str)) {
                if (obj == null) {
                    obj = "";
                }
                this.params.put(str, String.valueOf(obj));
            }
            return this;
        }

        public Builder addParams(Map<String, Object> map) {
            if (map != null && map.size() != 0) {
                if (this.params == null) {
                    this.params = new HashMap();
                }
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    this.params.put(str, obj == null ? "" : String.valueOf(obj));
                }
            }
            return this;
        }

        public VolleyRequest<T> build() {
            if (this.method == 0) {
                this.url = buildGetURL(this.url, this.params, "UTF-8");
                this.params = null;
            }
            return new VolleyRequest<>(this);
        }

        public Builder withCacheKey(String str) {
            this.cacheKey = str;
            return this;
        }

        public Builder withEncrypt(boolean z) {
            this.encrypt = z;
            return this;
        }

        public Builder withMethod(int i2) {
            this.method = i2;
            return this;
        }

        public Builder withUrl(String str) {
            this.url = str;
            return this;
        }
    }

    VolleyRequest(Builder builder) {
        super(builder.method, builder.url, builder.headers, builder.cacheKey, builder.respType, builder.encrypt);
        if (builder.params != null) {
            HashMap hashMap = new HashMap();
            this.mParams = hashMap;
            hashMap.putAll(builder.params);
        }
    }

    @Override // us.pinguo.common.network.request.VolleyBaseEncryptRequest, com.android.volley.Request
    public /* bridge */ /* synthetic */ byte[] getBody() throws AuthFailureError {
        return super.getBody();
    }

    @Override // com.android.volley.Request
    protected Map<String, String> getParams() throws AuthFailureError {
        return this.mParams;
    }
}
