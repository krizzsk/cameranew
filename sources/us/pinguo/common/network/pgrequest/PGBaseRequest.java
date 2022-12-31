package us.pinguo.common.network.pgrequest;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.Map;
import us.pinguo.common.log.a;
import us.pinguo.common.network.common.PGNetworkConfig;
import us.pinguo.common.network.common.PGNetworkConstants;
import us.pinguo.common.network.common.PGSecureUtils;
import us.pinguo.common.network.common.header.IPGHeader;
import us.pinguo.common.network.common.header.PGDebugHeader;
import us.pinguo.common.network.common.header.PGNetHeader;
import us.pinguo.common.network.common.header.PGParamHeader;
import us.pinguo.common.network.common.header.PGSignHeader;
import us.pinguo.common.network.common.header.PGTimeHeader;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.common.network.common.header.PGUidHeader;
import us.pinguo.common.network.common.header.PGUserAgentHeader;
import us.pinguo.common.network.common.header.PGUssHeader;
import us.pinguo.common.network.common.header.PGUssTransHeader;
import us.pinguo.common.network.common.toolbox.PGHeaderParser;
import us.pinguo.common.network.common.toolbox.PGSignVerifier;
import us.pinguo.common.network.encrypt.Base16;
import us.pinguo.common.network.request.VolleyBaseRequest;
/* loaded from: classes4.dex */
public abstract class PGBaseRequest<T> extends VolleyBaseRequest<T> {
    private PGNetworkConfig mConfig;
    private PGDebugHeader mDebug;
    private byte[] mKey;
    private PGNetHeader mNetwork;
    private PGParamHeader mParam;
    private PGSignHeader mSign;
    private PGTimeHeader mTime;
    private String mToken;
    private PGTransHeader mTrans;
    private PGUserAgentHeader mUA;
    private PGUidHeader mUid;
    private String mUriPath;
    private PGUssHeader mUss;
    private PGUssTransHeader mUssTrans;

    public PGBaseRequest(int i2, String str, String str2, PGTransHeader pGTransHeader, Map<String, String> map, String str3, String str4, String str5, String str6, String str7, float f2, float f3, String str8, Class cls) {
        super(i2, str + str2, map, str4, cls);
        this.mConfig = PGNetworkConfig.getInstance();
        this.mDebug = new PGDebugHeader(PGNetworkConstants.DEBUG_REQUEST);
        this.mTrans = pGTransHeader;
        this.mTime = new PGTimeHeader();
        this.mUA = this.mConfig.getUserAgent();
        this.mToken = str6;
        this.mUriPath = str2;
        try {
            this.mKey = PGSecureUtils.genRawDataKey(this.mTrans.getKeyAlg(), this.mTrans.getKeyInclude(), this.mUA.getAppName(), this.mUA.getDeviceId(), this.mToken, this.mTime.getValue());
            if (PGNetworkConstants.DEBUG_LOG) {
                a.d("PGNet", "raw_key_16:" + Base16.encode(this.mKey), new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(str5)) {
            this.mUid = new PGUidHeader(str5);
        }
        if (!TextUtils.isEmpty(this.mToken)) {
            if (!TextUtils.isEmpty(str3)) {
                byte[] bArr = this.mKey;
                if (bArr != null && bArr.length != 0) {
                    this.mUssTrans = new PGUssTransHeader.Builder().encryptAlg(str3).build();
                    this.mUss = new PGUssHeader.Builder().encryptAlg(this.mUssTrans.getEncrypt()).key(this.mKey).token(this.mToken).build();
                } else {
                    throw new IllegalArgumentException("key can not be null!");
                }
            } else {
                throw new IllegalArgumentException("ussEncryptAlg can not be null!");
            }
        }
        if (!TextUtils.isEmpty(str7)) {
            this.mNetwork = new PGNetHeader(str7);
        }
        if ((f2 == 0.0f || f3 == 0.0f) && TextUtils.isEmpty(str8)) {
            return;
        }
        this.mParam = new PGParamHeader(f2, f3, str8);
    }

    private void createSign() {
        byte[] bArr;
        try {
            bArr = getBody();
        } catch (AuthFailureError e2) {
            e2.printStackTrace();
            bArr = null;
        }
        this.mSign = new PGSignHeader.Builder().key(this.mKey).uaStr(this.mUA.getValue()).body(bArr).uriPath(this.mUriPath).timeStr(this.mTime.getValue()).pgEncryption(this.mTrans).build();
    }

    private boolean needEncrypt() {
        PGTransHeader pGTransHeader;
        return (this.mKey == null || (pGTransHeader = this.mTrans) == null || TextUtils.isEmpty(pGTransHeader.getEncryptAlg())) ? false : true;
    }

    @Override // com.android.volley.Request
    public final byte[] getBody() throws AuthFailureError {
        String str;
        if (needEncrypt()) {
            if (PGNetworkConstants.DEBUG_LOG) {
                str = getBodyContent() != null ? new String(getBodyContent()) : null;
                a.d("PGNet", "encrypt:true, oriBody:" + str, new Object[0]);
            }
            return PGSecureUtils.encrypt(this.mTrans.getEncryptAlg(), getBodyContent(), this.mKey);
        }
        if (PGNetworkConstants.DEBUG_LOG) {
            str = getBodyContent() != null ? new String(getBodyContent()) : null;
            a.d("PGNet", "encrypt:false, body:" + str, new Object[0]);
        }
        return getBodyContent();
    }

    public byte[] getBodyContent() throws AuthFailureError {
        return super.getBody();
    }

    @Override // us.pinguo.common.network.request.VolleyBaseRequest, com.android.volley.Request
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        putHeaders(headers, this.mDebug);
        putHeaders(headers, this.mUA);
        putHeaders(headers, this.mTime);
        putHeaders(headers, this.mTrans);
        if (this.mConfig.isDebug()) {
            putHeaders(headers, this.mUA.getUaDebugHeader());
        }
        if (this.mSign == null) {
            createSign();
        }
        putHeaders(headers, this.mSign);
        PGUidHeader pGUidHeader = this.mUid;
        if (pGUidHeader != null) {
            putHeaders(headers, pGUidHeader);
        }
        PGUssHeader pGUssHeader = this.mUss;
        if (pGUssHeader != null || this.mUssTrans != null) {
            putHeaders(headers, pGUssHeader);
            putHeaders(headers, this.mUssTrans);
        }
        PGNetHeader pGNetHeader = this.mNetwork;
        if (pGNetHeader != null) {
            putHeaders(headers, pGNetHeader);
        }
        PGParamHeader pGParamHeader = this.mParam;
        if (pGParamHeader != null) {
            putHeaders(headers, pGParamHeader);
        }
        return headers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.common.network.request.VolleyBaseRequest, us.pinguo.common.network.pgrequest.BaseRequest, com.android.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        PGTransHeader parsePGTrans = PGHeaderParser.parsePGTrans(networkResponse.headers);
        PGTimeHeader parsePGTime = PGHeaderParser.parsePGTime(networkResponse.headers);
        String parsePGSign = PGHeaderParser.parsePGSign(networkResponse.headers);
        try {
            byte[] genRawDataKey = PGSecureUtils.genRawDataKey(parsePGTrans.getKeyAlg(), parsePGTrans.getKeyInclude(), this.mUA.getAppName(), this.mUA.getDeviceId(), this.mToken, parsePGTime.getValue());
            if (PGSignVerifier.verrify(parsePGSign, parsePGTrans, this.mUA, networkResponse.data, this.mUriPath, genRawDataKey, parsePGTime)) {
                return super.parseNetworkResponse(new NetworkResponse(networkResponse.statusCode, PGSecureUtils.decrypt(parsePGTrans.getEncryptAlg(), networkResponse.data, genRawDataKey), networkResponse.headers, networkResponse.notModified));
            }
            return Response.error(new VolleyError("Sign verify error!"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return Response.error(new VolleyError("Gen response key fail"));
        }
    }

    protected void putHeaders(Map map, IPGHeader iPGHeader) {
        if (iPGHeader == null || TextUtils.isEmpty(iPGHeader.getValue())) {
            return;
        }
        map.put(iPGHeader.getName(), iPGHeader.getValue());
    }
}
