package us.pinguo.inspire.module.publish.vo;
/* loaded from: classes9.dex */
public class SliceResult {
    public String checksum;
    public int code;
    public long crc32;
    public String ctx;
    public String error;
    public String host;
    public long length;
    public long offset;
    public int order;

    public String toString() {
        return "SliceResult{ctx='" + this.ctx + "', checksum='" + this.checksum + "', crc32=" + this.crc32 + ", offset=" + this.offset + ", host='" + this.host + "', code=" + this.code + ", error='" + this.error + "', order=" + this.order + '}';
    }
}
