package us.pinguo.common.network.request;

import android.util.Base64;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.security.SecureRandom;
import java.util.Map;
/* loaded from: classes4.dex */
abstract class VolleyBaseEncryptRequest<T> extends VolleyBaseRequest<T> {
    private static final String CIPHER_NAME = "AES/CBC/PKCS5Padding";
    private static final boolean DEBUG_LOG = true;
    private static final String HEADER_ENCODE_IV = "X-Pg-Request-Iv";
    private static final String KEY_NAME = "AES";
    private static final String TAG = "EncryptRequest";
    private boolean encrypt;
    private byte[] requestIv;
    private static final String SO_KEY_STR = "ngzCfE1a/LcxJiA2SnleBg==";
    private static final byte[] SO_KEY = Base64.decode(SO_KEY_STR, 0);

    public VolleyBaseEncryptRequest(int i2, String str, Map<String, String> map, String str2, Class cls) {
        super(i2, str, map, str2, cls);
        this.encrypt = false;
        this.requestIv = null;
    }

    private void addEncryptHeader() {
        this.requestIv = new byte[16];
        new SecureRandom().nextBytes(this.requestIv);
        String encodeUrlSafe = EncryptUtils.encodeUrlSafe(Base64.encodeToString(this.requestIv, 0));
        Log.d(TAG, "requestIvHeader：" + encodeUrlSafe);
        this.mHeaders.put(HEADER_ENCODE_IV, encodeUrlSafe);
    }

    private byte[] getBodyContent() throws AuthFailureError {
        return super.getBody();
    }

    private static byte[] padding(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        if (i2 > bArr.length) {
            System.arraycopy(bArr, 0, bArr2, i2 - bArr.length, bArr.length);
        } else {
            System.arraycopy(bArr, bArr.length - i2, bArr2, 0, i2);
        }
        return bArr2;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() throws AuthFailureError {
        if (this.encrypt) {
            try {
                return EncryptUtils.makeAesEncryptBody(getBodyContent(), this.requestIv);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return getBodyContent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.common.network.request.VolleyBaseRequest, us.pinguo.common.network.pgrequest.BaseRequest, com.android.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        Map<String, String> map = networkResponse.headers;
        if (map != null && map.containsKey(HEADER_ENCODE_IV)) {
            try {
                byte[] decryptContent = EncryptUtils.decryptContent(Base64.decode(new String(networkResponse.data, "UTF-8"), 0), Base64.decode(EncryptUtils.recoverUrlSafe(networkResponse.headers.get(HEADER_ENCODE_IV)), 0));
                if (decryptContent == null) {
                    return Response.error(new VolleyError("Check hash fail"));
                }
                return super.parseNetworkResponse(new NetworkResponse(networkResponse.statusCode, decryptContent, networkResponse.notModified, networkResponse.networkTimeMs, networkResponse.allHeaders));
            } catch (Exception e2) {
                e2.printStackTrace();
                return Response.error(new VolleyError("Decrypt content fail!"));
            }
        }
        return super.parseNetworkResponse(networkResponse);
    }

    public VolleyBaseEncryptRequest(int i2, String str, Map<String, String> map, String str2, Class cls, boolean z) {
        super(i2, str, map, str2, cls);
        this.encrypt = false;
        this.requestIv = null;
        this.encrypt = z;
        if (z) {
            try {
                addEncryptHeader();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
