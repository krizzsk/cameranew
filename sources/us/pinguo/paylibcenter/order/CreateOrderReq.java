package us.pinguo.paylibcenter.order;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;
import us.pinguo.paylibcenter.PayHelp;
/* loaded from: classes5.dex */
public class CreateOrderReq implements Serializable {
    private String extra;
    private String productId;
    private String purchaseTag;
    private String token;
    private String userId;
    private PayHelp.PAYWAY way;

    public CreateOrderReq() {
        this.token = "";
    }

    public String getExtra() {
        return this.extra;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPurchaseTag() {
        return this.purchaseTag;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        String str = this.userId;
        return str == null ? "" : str;
    }

    public String getWay() {
        return this.way.value;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setMolChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel", str);
            this.extra = jSONObject.toString();
        } catch (Exception unused) {
        }
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPurchaseTag(String str) {
        this.purchaseTag = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWay(PayHelp.PAYWAY payway) {
        this.way = payway;
    }

    public CreateOrderReq(String str, String str2, String str3, PayHelp.PAYWAY payway, String str4) {
        this.token = "";
        this.userId = str;
        this.token = str2;
        this.productId = str3;
        this.way = payway;
        this.purchaseTag = str4;
    }
}
