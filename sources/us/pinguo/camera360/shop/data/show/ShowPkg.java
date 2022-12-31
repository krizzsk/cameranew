package us.pinguo.camera360.shop.data.show;

import java.util.Arrays;
import us.pinguo.camera360.shop.bean.PayInfo;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.repository2020.entity.OperationLabel;
/* loaded from: classes4.dex */
public class ShowPkg extends BaseShow {
    private int cameraSupport;
    public int camera_support;
    private String categoryId;
    private int count;
    private boolean hasMusic;
    private String icon;
    private UnlockType mType;
    private String name;
    private long offTime;
    private long onTime;
    private FilterType packageType;
    private PayInfo payInfo;
    private int position;
    private String shareId;
    private String sid;
    public int tagContent;
    public long tagOffTime;
    public long tagOnTime;
    private String tagPic;
    public int unity_engine_filter;
    private String vip_banner;

    /* loaded from: classes4.dex */
    public enum Status {
        installed,
        uninstalled,
        failed,
        installing,
        update
    }

    public ShowPkg(String str, String str2, String str3, String str4, FilterType filterType, int i2, long j2, long j3, int i3, int i4, int i5, long j4, long j5) {
        super(str);
        this.hasMusic = false;
        this.tagPic = null;
        this.sid = null;
        this.unity_engine_filter = 0;
        this.camera_support = 1;
        this.tagContent = 0;
        this.tagOnTime = 0L;
        this.tagOffTime = 0L;
        this.icon = str2;
        this.name = str3;
        this.packageType = filterType;
        this.count = i2;
        this.shareId = str4;
        this.onTime = j2;
        this.offTime = j3;
        this.unity_engine_filter = i3;
        this.camera_support = this.cameraSupport;
        this.tagContent = i5;
        this.tagOnTime = j4;
        this.tagOffTime = j5;
    }

    public void clearRedPoint() {
        t.f().c(getId());
    }

    @Override // us.pinguo.camera360.shop.data.show.BaseShow
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ShowPkg) && obj != null && ((ShowPkg) obj).getId().equals(getId());
    }

    public int getCameraSupport() {
        return this.cameraSupport;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public int getCount() {
        return this.count;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public FilterType getPackageType() {
        return this.packageType;
    }

    public PayInfo getPayInfo() {
        return this.payInfo;
    }

    public int getPosition() {
        return this.position;
    }

    public String getShareId() {
        return this.shareId;
    }

    public String getSid() {
        return this.sid;
    }

    public String getTagPic() {
        return this.tagPic;
    }

    public UnlockType getType() {
        return this.mType;
    }

    @Override // us.pinguo.camera360.shop.data.show.BaseShow
    public int getVip() {
        return super.getVip();
    }

    public String getVipBanner() {
        return this.vip_banner;
    }

    public boolean hasRedPoint() {
        return t.f().i(this);
    }

    @Override // us.pinguo.camera360.shop.data.show.BaseShow
    public int hashCode() {
        return Arrays.hashCode(new String[]{getId()});
    }

    public boolean isFreeLabelVisible() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return this.tagContent == OperationLabel.LABEL_FREE.ordinal() && currentTimeMillis >= this.tagOnTime && currentTimeMillis <= this.tagOffTime;
    }

    public boolean isHasMusic() {
        return this.hasMusic;
    }

    public boolean isHotLabelVisible() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return this.tagContent == OperationLabel.LABEL_HOT.ordinal() && currentTimeMillis >= this.tagOnTime && currentTimeMillis <= this.tagOffTime;
    }

    public boolean isNewLabelVisible() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return this.tagContent == OperationLabel.LABEL_NEW.ordinal() && currentTimeMillis >= this.tagOnTime && currentTimeMillis <= this.tagOffTime;
    }

    public boolean isOk() {
        return true;
    }

    public boolean isSupportInCamera() {
        return this.cameraSupport == 1;
    }

    public boolean isVipLabelVisible() {
        return isVip() && !isFreeLabelVisible();
    }

    public void setCameraSupport(int i2) {
        this.cameraSupport = i2;
    }

    public void setCategoryId(String str) {
        this.categoryId = str;
    }

    public void setHasMusic(boolean z) {
        this.hasMusic = z;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setTagPic(String str) {
        this.tagPic = str;
    }

    public void setUnlockType(UnlockType unlockType, PayInfo payInfo) {
        this.mType = unlockType;
        this.payInfo = payInfo;
    }

    public void setVipBanner(String str) {
        this.vip_banner = str;
    }

    public String toString() {
        return "ShowPkg{catetoryId=" + this.categoryId + "mType=" + this.mType + ", icon='" + this.icon + "', name='" + this.name + "', shareId='" + this.shareId + "', payInfo=" + this.payInfo + ", packageType=" + this.packageType + ", count=" + this.count + ", onTime=" + this.onTime + ", offTime=" + this.offTime + ", tagContent=" + this.tagContent + ", tagOnTime=" + this.tagOnTime + ", tagOffTime=" + this.tagOffTime + '}';
    }
}
