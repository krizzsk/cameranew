package us.pinguo.camera360.shop.data.show;

import android.support.v4.media.session.PlaybackStateCompat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.camera360.shop.data.FilterType;
/* loaded from: classes4.dex */
public class ShowDetail extends ShowPkg {
    private String desc;
    private String displayZip;
    private String displayZipMd5;
    private long fileSize;
    private List<a> mImageInfoList;
    private List<b> mItems;
    private String originPic;
    private String packageZip;
    private String packageZipMd5;

    /* loaded from: classes4.dex */
    public static class a {
        String a;
        String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.a;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public String a;
    }

    public ShowDetail(String str, String str2, String str3, String str4, String str5, long j2, String str6, FilterType filterType, int i2, long j3, long j4, int i3, int i4, int i5, long j5, long j6) {
        super(str, str2, str3, str6, filterType, i2, j3, j4, i3, i4, i5, j5, j6);
        this.desc = str4;
        this.originPic = str5;
        this.fileSize = j2;
    }

    public void addDetailItem(b bVar) {
        if (this.mItems == null) {
            this.mItems = new ArrayList();
        }
        this.mItems.add(bVar);
    }

    public String getDesc() {
        return this.desc;
    }

    public List<b> getDetailItems() {
        return this.mItems;
    }

    public String getDisplayZip() {
        return this.displayZip;
    }

    public String getDisplayZipMd5() {
        return this.displayZipMd5;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getFileSizeStr() {
        if (this.fileSize < 1024) {
            return this.fileSize + "B";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#0.##", new DecimalFormatSymbols(Locale.ENGLISH));
        long j2 = this.fileSize;
        if (j2 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return decimalFormat.format((this.fileSize / 1024.0d) + 0.005d) + "KB";
        } else if (j2 < IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return decimalFormat.format(((this.fileSize / 1024.0d) / 1024.0d) + 0.005d) + "MB";
        } else {
            return decimalFormat.format((((this.fileSize / 1024.0d) / 1024.0d) / 1024.0d) + 0.005d) + "GB";
        }
    }

    public List<a> getImageInfos() {
        if (this.mImageInfoList == null) {
            this.mImageInfoList = new ArrayList();
        }
        return this.mImageInfoList;
    }

    public String getOriginPic() {
        return this.originPic;
    }

    public String getPackageZip() {
        return this.packageZip;
    }

    public String getPackageZipMd5() {
        return this.packageZipMd5;
    }

    public void setDisplayZip(String str) {
        this.displayZip = str;
    }

    public void setDisplayZipMd5(String str) {
        this.displayZipMd5 = str;
    }

    public void setPackageZip(String str) {
        this.packageZip = str;
    }

    public void setPackageZipMd5(String str) {
        this.packageZipMd5 = str;
    }
}
