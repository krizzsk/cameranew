package us.pinguo.bigalbum.entity;

import android.content.ContentValues;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* loaded from: classes3.dex */
public class Photo {
    public static final String PROJECT_STATE_BROKEN = "broken";
    public static final String PROJECT_STATE_EDITING = "editing";
    public static final String PROJECT_STATE_FINISHED = "finished";
    public long addTime;
    public int avgColor;
    public int cameraModeIndex;
    public String cloudID;
    public String cloudResourceID;
    public long costMillis;
    public String crc32;
    public long createDate;
    public long deleteTime;
    public long destroyTime;
    public String editParams;
    public String eftAlias;
    public String eftAppendix;
    public String etag;
    public String exif;
    public int failCount;
    public long favTime;
    public int flags;
    public int height;
    public long hideTime;
    public boolean isFav;
    public boolean isGetGeo;
    public boolean isHidden;
    public boolean isUploaded;
    public String jsonExpand;
    public double latitude;
    public String layerEffectParams;
    public String localID;
    public String localPath;
    public double longitude;
    public String mimeType;
    public long modifyDate;
    public String name;
    public int orientation;
    public int photoType;
    public int pictureType;
    public String projectState;
    public String projectVersionCode;
    public String reserved1;
    public String reserved2;
    public long size;
    public int status;
    public String thumbnailPath;
    public int uploadStatus;
    public int width;
    public int id = -1;
    public int systemDbID = -1;
    public int systemBucketID = -1;

    public void merge(Photo photo) {
        this.orientation = photo.orientation;
        this.width = photo.width;
        this.height = photo.height;
        this.latitude = photo.latitude;
        this.longitude = photo.longitude;
        this.cameraModeIndex = photo.cameraModeIndex;
        this.pictureType = photo.pictureType;
        this.costMillis = photo.costMillis;
        this.failCount = photo.failCount;
        this.projectState = photo.projectState;
        this.projectVersionCode = photo.projectVersionCode;
        this.eftAlias = photo.eftAlias;
        this.eftAppendix = photo.eftAppendix;
        this.layerEffectParams = photo.layerEffectParams;
        this.exif = photo.exif;
        this.jsonExpand = photo.jsonExpand;
        this.editParams = photo.editParams;
        this.reserved1 = photo.reserved1;
        this.reserved2 = photo.reserved2;
    }

    public String toString() {
        return "Photo{ \nid:" + this.id + "\nsystemDbID:" + this.systemDbID + ",localID:" + this.localID + ",cloudID:" + this.cloudID + "\nname:" + this.name + "\ncreateDate:" + this.createDate + ",modifyDate:" + this.modifyDate + "\nlocalPath:" + this.localPath + ",thumbnailPath:" + this.thumbnailPath + "\ncloudResourceID:" + this.cloudResourceID + ",orientation:" + this.orientation + "\nlatitude:" + this.latitude + ",longitude:" + this.longitude + "\nwidth:" + this.width + ",height:" + this.height + ",size:" + this.size + "\nphotoType:" + this.photoType + "\nstatus:" + this.status + ",uploadStatus:" + this.uploadStatus + "\netag:" + this.etag + ",crc32:" + this.crc32 + "}\n";
    }

    public void updateToValues(ContentValues contentValues) {
        contentValues.put("orientation", Integer.valueOf(this.orientation));
        contentValues.put("width", Integer.valueOf(this.width));
        contentValues.put("height", Integer.valueOf(this.height));
        contentValues.put(BigAlbumStore.PhotoColumns.LATITUDE, Double.valueOf(this.latitude));
        contentValues.put(BigAlbumStore.PhotoColumns.LONGITUDE, Double.valueOf(this.longitude));
        contentValues.put(BigAlbumStore.PhotoColumns.CAMERA_MODE_INDEX, Integer.valueOf(this.cameraModeIndex));
        contentValues.put(BigAlbumStore.PhotoColumns.PICTURE_TYPE, Integer.valueOf(this.pictureType));
        contentValues.put(BigAlbumStore.PhotoColumns.COST_MILLIS, Long.valueOf(this.costMillis));
        contentValues.put(BigAlbumStore.PhotoColumns.FAIL_COUNT, Integer.valueOf(this.failCount));
        contentValues.put(BigAlbumStore.PhotoColumns.PROJECT_STATE, this.projectState);
        contentValues.put(BigAlbumStore.PhotoColumns.PROJECT_VERSION_CODE, this.projectVersionCode);
        contentValues.put(BigAlbumStore.PhotoColumns.EFT_ALIAS, this.eftAlias);
        contentValues.put(BigAlbumStore.PhotoColumns.EFT_APPENDIX, this.eftAppendix);
        contentValues.put(BigAlbumStore.PhotoColumns.LAYER_EFFECT_PARAMS, this.layerEffectParams);
        contentValues.put(BigAlbumStore.PhotoColumns.EXIF, this.exif);
        contentValues.put(BigAlbumStore.PhotoColumns.JSON_EXPAND, this.jsonExpand);
        contentValues.put(BigAlbumStore.PhotoColumns.EDIT_PARAMS, this.editParams);
        contentValues.put(BigAlbumStore.PhotoColumns.RESERVED1, this.reserved1);
        contentValues.put(BigAlbumStore.PhotoColumns.RESERVED2, this.reserved2);
    }
}
