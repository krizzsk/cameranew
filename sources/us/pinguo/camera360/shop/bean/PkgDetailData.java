package us.pinguo.camera360.shop.bean;

import android.text.TextUtils;
import java.util.List;
import us.pinguo.camera360.shop.data.show.ShowDetail;
/* loaded from: classes3.dex */
public class PkgDetailData extends Package {
    public String descript;
    public String display_zip_md5;
    public String display_zip_url;
    public PkgImage[] effect_pic_info;
    public long file_size;
    public PkgItem[] items;
    public String origin_pic;
    public String package_zip;
    public String package_zip_md5;

    private ShowDetail.a getImageInfoByPkgImage(PkgImage pkgImage) {
        if (pkgImage == null || TextUtils.isEmpty(pkgImage.pic)) {
            return null;
        }
        return new ShowDetail.a(pkgImage.pic, pkgImage.name);
    }

    public ShowDetail toShowDetail() {
        PkgItem[] pkgItemArr;
        ShowDetail showDetail = new ShowDetail(this.pid, this.icon, this.name, this.descript, this.origin_pic, this.file_size, this.share_id, getFilterType(false), getCount(), this.onsale_time, this.off_time, this.unity_engine_filter, this.camera_support, this.tagContent, this.tagOnTime, this.tagOffTime);
        List<ShowDetail.a> imageInfos = showDetail.getImageInfos();
        PkgImage[] pkgImageArr = this.effect_pic_info;
        if (pkgImageArr == null) {
            return null;
        }
        for (PkgImage pkgImage : pkgImageArr) {
            ShowDetail.a imageInfoByPkgImage = getImageInfoByPkgImage(pkgImage);
            if (imageInfoByPkgImage != null) {
                imageInfos.add(imageInfoByPkgImage);
            }
        }
        showDetail.setDisplayZip(this.display_zip_url);
        showDetail.setDisplayZipMd5(this.display_zip_md5);
        showDetail.setPackageZip(this.package_zip);
        showDetail.setPackageZipMd5(this.package_zip_md5);
        for (PkgItem pkgItem : this.items) {
            ShowDetail.b bVar = new ShowDetail.b();
            bVar.a = pkgItem.id;
            String str = pkgItem.icon;
            String str2 = pkgItem.display_zip_md5;
            String str3 = pkgItem.display_zip_url;
            String str4 = pkgItem.zip_md5;
            String str5 = pkgItem.zip_url;
            showDetail.addDetailItem(bVar);
        }
        showDetail.setVip(this.vip);
        return showDetail;
    }
}
