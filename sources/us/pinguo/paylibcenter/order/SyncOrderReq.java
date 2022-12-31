package us.pinguo.paylibcenter.order;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class SyncOrderReq implements Serializable {
    private String out_trade_no;
    private String receipt;
    private String status;

    /* loaded from: classes5.dex */
    public enum SYNCPAYSTATUS {
        ALISUCCESS("1010"),
        ALIFAIL("1011"),
        WXSUCCESS("2010"),
        WXFAIL(NativeAppInstallAd.ASSET_MEDIA_VIDEO);
        
        public String value;

        SYNCPAYSTATUS(String str) {
            this.value = str;
        }
    }

    public SyncOrderReq() {
    }

    public String getOut_trade_no() {
        String str = this.out_trade_no;
        return str == null ? "" : str;
    }

    public String getReceipt() {
        String str = this.receipt;
        return str == null ? "" : str;
    }

    public String getStatus() {
        String str = this.status;
        return str == null ? "" : str;
    }

    public void setOut_trade_no(String str) {
        this.out_trade_no = str;
    }

    public void setReceipt(String str) {
        this.receipt = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public SyncOrderReq(String str, String str2, String str3) {
        this.status = str;
        this.out_trade_no = str2;
        this.receipt = str3;
    }
}
