package us.pinguo.common.network.pgrequest;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes4.dex */
public class PGRequest<T> extends PGBaseRequest<T> {
    private Map<String, String> mParams;

    /* loaded from: classes4.dex */
    public static final class Builder<T> {
        private String cacheKey;
        private String domain;
        private Map<String, String> headers;
        private float lan;
        private float lon;
        private String networkType;
        private Map<String, String> params;
        private Class respType;
        private String timeZone;
        private String token;
        private String uid;
        private String uriPath;
        private String ussEncryptAlg;
        private int method = 0;
        private PGTransHeader.Builder transBuilder = new PGTransHeader.Builder();

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

        public PGRequest<T> build() {
            if (this.method == 0) {
                this.uriPath = buildGetURL(this.uriPath, this.params, "UTF-8");
                this.params = null;
            }
            return new PGRequest<>(this);
        }

        public Builder withCacheKey(String str) {
            this.cacheKey = str;
            return this;
        }

        public Builder withDomain(String str) {
            this.domain = str;
            return this;
        }

        public Builder withEncryptAlg(String str) {
            this.transBuilder.encryptAlg(str);
            return this;
        }

        public Builder withGps(float f2, float f3) {
            this.lan = f2;
            this.lon = f3;
            return this;
        }

        public Builder withKeyAlg(String str) {
            this.transBuilder.keyAlg(str);
            return this;
        }

        public Builder withKeyInclude(int i2) {
            this.transBuilder.keyInclude(i2);
            return this;
        }

        public Builder withMethod(int i2) {
            this.method = i2;
            return this;
        }

        public Builder withNetworkType(String str) {
            this.networkType = str;
            return this;
        }

        public Builder withSigAlg(String str) {
            this.transBuilder.sigAlg(str);
            return this;
        }

        public Builder withTimeZone(String str) {
            this.timeZone = str;
            return this;
        }

        public Builder withToken(String str) {
            this.token = str;
            return this;
        }

        public Builder withUid(String str) {
            this.uid = str;
            return this;
        }

        public Builder withUriPath(String str) {
            this.uriPath = str;
            return this;
        }

        public Builder withUssEncryptAlg(String str) {
            this.ussEncryptAlg = str;
            return this;
        }
    }

    protected PGRequest(Builder builder) {
        super(builder.method, builder.domain, builder.uriPath, builder.transBuilder.build(), builder.headers, builder.ussEncryptAlg, builder.cacheKey, builder.uid, builder.token, builder.networkType, builder.lan, builder.lon, builder.timeZone, builder.respType);
        if (builder.params != null) {
            HashMap hashMap = new HashMap();
            this.mParams = hashMap;
            hashMap.putAll(builder.params);
        }
    }

    @Override // com.android.volley.Request
    protected Map<String, String> getParams() throws AuthFailureError {
        return this.mParams;
    }
}
