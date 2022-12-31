package us.pinguo.bigalbum.db;

import android.os.Environment;
import us.pinguo.common.db.c;
import us.pinguo.common.db.f;
import us.pinguo.common.db.i;
/* loaded from: classes3.dex */
public class BigAlbumStore {
    static final c BIG_ALBUM_DB;
    public static final String BIG_ALBUM_DB_NAME = "bigAlbum.db";
    public static final String BIG_ALBUM_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Camera360/TempData/.sandbox/bigAlbum/";
    static final f BIG_ALBUM_TABLE_DB_CONTROL_DATA;
    static final f BIG_ALBUM_TABLE_GALLERY;
    static final f BIG_ALBUM_TABLE_GALLERY_PHOTO_RELATIONS;
    static final f BIG_ALBUM_TABLE_PHOTO;
    static final f BIG_ALBUM_TABLE_PHOTO_ADDRESS;
    static final f BIG_ALBUM_TABLE_PHOTO_TAG;
    static i DB_1_2 = null;
    static i DB_2_3 = null;
    static i DB_3_4 = null;
    static i DB_4_5 = null;
    static final int DB_VERSION = 5;
    public static final String TABLE_GALLERY = "gallery";
    public static final String TABLE_GALLERY_PHOTO_RELATION = "galleryPhotoRelation";
    public static final String TABLE_PHOTO = "photo";
    public static final String TABLE_PHOTO_ADDRESS = "photoAddress";
    public static final String TABLE_PHOTO_TAG = "photoTag";

    /* loaded from: classes3.dex */
    interface DbControlDataColumns {
        public static final String CONTROL_KEY = "controlKey";
        public static final String CONTROL_VALUE = "controlValue";
        public static final String ID = "_id";
    }

    /* loaded from: classes3.dex */
    public interface GalleryColumns {
        public static final String CLOUD_ID = "cloudID";
        public static final String COVER_PHOTO_ID = "coverPhotoId";
        public static final String CREATE_DATE = "createDate";
        public static final String FLAGS = "flags";
        public static final String ID = "_id";
        public static final String IS_PRESET = "isPreset";
        public static final String LOCAL_ID = "localID";
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String SYSTEM_BUCKET_ID = "systemBucketID";
    }

    /* loaded from: classes3.dex */
    public interface GalleryPhotoRelationsColumns {
        public static final String GALLERY_ID = "galleryID";
        public static final String ID = "_id";
        public static final String PHOTO_ID = "photoID";
    }

    /* loaded from: classes3.dex */
    public interface PhotoAddressColumns {
        public static final String CITY = "city";
        public static final String CLOUD_ID = "cloudID";
        public static final String COORDINATE = "coordinate";
        public static final String COUNTRY = "country";
        public static final String COUNTRY_CODE = "countryCode";
        public static final String DISTRICT = "district";
        public static final String FORMATTED_ADDR = "formattedAddr";
        public static final String ID = "_id";
        public static final String IS_UPLOADED = "isUploaded";
        public static final String LOCAL_ID = "localID";
        public static final String PHOTO_ID = "photoID";
        public static final String PROVINCE = "province";
        public static final String STREET = "street";
        public static final String STREET_NUMBER = "streetNumber";
    }

    /* loaded from: classes3.dex */
    public interface PhotoColumns {
        public static final String ADD_TIME = "addTime";
        public static final String AVG_COLOR = "avgColor";
        public static final String CAMERA_MODE_INDEX = "cameraModeIndex";
        public static final String CLOUD_ID = "cloudID";
        public static final String CLOUD_RESOURCE_ID = "cloudResourceID";
        public static final String COST_MILLIS = "costMillis";
        public static final String CRC32 = "crc32";
        public static final String CREATE_DATE = "createDate";
        public static final String DELETE_TIME = "deleteTime";
        public static final String DESTROY_TIME = "destroyTime";
        public static final String EDIT_PARAMS = "editParams";
        public static final String EFT_ALIAS = "eftAlias";
        public static final String EFT_APPENDIX = "eftAppendix";
        public static final String ETAG = "etag";
        public static final String EXIF = "exif";
        public static final String FAIL_COUNT = "failCount";
        public static final String FAV_TIME = "favTime";
        public static final String FLAGS = "flags";
        public static final String HEIGHT = "height";
        public static final String HIDE_TIME = "hideTime";
        public static final String ID = "_id";
        public static final String IS_FAV = "isFav";
        public static final String IS_GETGEO = "isGetGeo";
        public static final String IS_HIDDEN = "isHidden";
        public static final String IS_UPLOADED = "isUploaded";
        public static final String JSON_EXPAND = "jsonExpand";
        public static final String LATITUDE = "latitude";
        public static final String LAYER_EFFECT_PARAMS = "layerEffectParams";
        public static final String LOCAL_ID = "localID";
        public static final String LOCAL_PATH = "localPath";
        public static final String LONGITUDE = "longitude";
        public static final String MIME_TYPE = "mimeType";
        public static final String MODIFY_DATE = "modifyDate";
        public static final String NAME = "name";
        public static final String ORIENTATION = "orientation";
        public static final String PHOTO_TYPE = "photoType";
        public static final String PICTURE_TYPE = "pictureType";
        public static final String PROJECT_STATE = "projectState";
        public static final String PROJECT_VERSION_CODE = "projectVersionCode";
        public static final String RESERVED1 = "reserved1";
        public static final String RESERVED2 = "reserved2";
        public static final String SIZE = "size";
        public static final String STATUS = "status";
        public static final String SYSTEM_BUCKET_ID = "systemBucketID";
        public static final String SYSTEM_DB_ID = "systemDbID";
        public static final String THUMBNAIL_PATH = "thumbnailPath";
        public static final String UPLOAD_STATUS = "uploadStatus";
        public static final String WIDTH = "width";
    }

    /* loaded from: classes3.dex */
    public interface PhotoTagColumns {
        public static final String EN_US_LEVEL_0 = "en_us_level_0";
        public static final String EN_US_LEVEL_1 = "en_us_level_1";
        public static final String EN_US_TAG = "en_us_tag";
        public static final String ID = "_id";
        public static final String MODEL = "model";
        public static final String PHOTO_ID = "photoID";
        public static final String WEIGHT = "weight";
        public static final String ZH_CN_LEVEL_0 = "zh_cn_level_0";
        public static final String ZH_CN_LEVEL_1 = "zh_cn_level_1";
        public static final String ZH_CN_TAG = "zh_cn_tag";
        public static final String ZH_TW_LEVEL_0 = "zh_tw_level_0";
        public static final String ZH_TW_LEVEL_1 = "zh_tw_level_1";
        public static final String ZH_TW_TAG = "zh_tw_tag";
    }

    static {
        f.b bVar = new f.b();
        bVar.w("photo");
        bVar.p("_id");
        bVar.l(PhotoColumns.SYSTEM_DB_ID, -1);
        bVar.l("systemBucketID", -1);
        bVar.s("localID");
        bVar.s("cloudID");
        bVar.s("name");
        bVar.n("createDate");
        bVar.n(PhotoColumns.MODIFY_DATE);
        bVar.t(PhotoColumns.LOCAL_PATH, 500);
        bVar.s(PhotoColumns.THUMBNAIL_PATH);
        bVar.s(PhotoColumns.CLOUD_RESOURCE_ID);
        bVar.n("orientation");
        bVar.r(PhotoColumns.LATITUDE);
        bVar.r(PhotoColumns.LONGITUDE);
        bVar.n("width");
        bVar.n("height");
        bVar.n(PhotoColumns.SIZE);
        bVar.n(PhotoColumns.PHOTO_TYPE);
        bVar.n("status");
        bVar.n(PhotoColumns.UPLOAD_STATUS);
        bVar.s(PhotoColumns.ETAG);
        bVar.s(PhotoColumns.CRC32);
        bVar.n(PhotoColumns.AVG_COLOR);
        bVar.n(PhotoColumns.IS_FAV);
        bVar.n(PhotoColumns.IS_HIDDEN);
        bVar.n(PhotoColumns.ADD_TIME);
        bVar.n(PhotoColumns.DELETE_TIME);
        bVar.n(PhotoColumns.FAV_TIME);
        bVar.n(PhotoColumns.HIDE_TIME);
        bVar.n(PhotoColumns.DESTROY_TIME);
        bVar.s(PhotoColumns.MIME_TYPE);
        bVar.n("isUploaded");
        bVar.n("flags");
        bVar.j(PhotoColumns.CAMERA_MODE_INDEX);
        bVar.j(PhotoColumns.PICTURE_TYPE);
        bVar.j(PhotoColumns.COST_MILLIS);
        bVar.j(PhotoColumns.FAIL_COUNT);
        bVar.s(PhotoColumns.PROJECT_STATE);
        bVar.s(PhotoColumns.PROJECT_VERSION_CODE);
        bVar.s(PhotoColumns.EFT_ALIAS);
        bVar.t(PhotoColumns.EFT_APPENDIX, 500);
        bVar.t(PhotoColumns.LAYER_EFFECT_PARAMS, 700);
        bVar.t(PhotoColumns.EXIF, 500);
        bVar.t(PhotoColumns.JSON_EXPAND, 700);
        bVar.t(PhotoColumns.EDIT_PARAMS, 700);
        bVar.t(PhotoColumns.RESERVED1, 700);
        bVar.t(PhotoColumns.RESERVED2, 700);
        bVar.n(PhotoColumns.IS_GETGEO);
        f f2 = bVar.f();
        BIG_ALBUM_TABLE_PHOTO = f2;
        f.b bVar2 = new f.b();
        bVar2.w(TABLE_PHOTO_ADDRESS);
        bVar2.p("_id");
        bVar2.o("photoID");
        bVar2.s("localID");
        bVar2.s("cloudID");
        bVar2.s(PhotoAddressColumns.FORMATTED_ADDR);
        bVar2.s(PhotoAddressColumns.COUNTRY);
        bVar2.s(PhotoAddressColumns.PROVINCE);
        bVar2.s(PhotoAddressColumns.CITY);
        bVar2.s(PhotoAddressColumns.DISTRICT);
        bVar2.s(PhotoAddressColumns.STREET);
        bVar2.s(PhotoAddressColumns.STREET_NUMBER);
        bVar2.s("countryCode");
        bVar2.s(PhotoAddressColumns.COORDINATE);
        bVar2.n("isUploaded");
        f f3 = bVar2.f();
        BIG_ALBUM_TABLE_PHOTO_ADDRESS = f3;
        f.b bVar3 = new f.b();
        bVar3.w(TABLE_GALLERY);
        bVar3.p("_id");
        bVar3.s("localID");
        bVar3.s("cloudID");
        bVar3.s("name");
        bVar3.n("createDate");
        bVar3.n("status");
        bVar3.n("flags");
        bVar3.n(GalleryColumns.IS_PRESET);
        bVar3.l("systemBucketID", -1);
        bVar3.l(GalleryColumns.COVER_PHOTO_ID, -1);
        f f4 = bVar3.f();
        BIG_ALBUM_TABLE_GALLERY = f4;
        f.b bVar4 = new f.b();
        bVar4.w(TABLE_GALLERY_PHOTO_RELATION);
        bVar4.p("_id");
        bVar4.o("photoID");
        bVar4.o(GalleryPhotoRelationsColumns.GALLERY_ID);
        f f5 = bVar4.f();
        BIG_ALBUM_TABLE_GALLERY_PHOTO_RELATIONS = f5;
        f.b bVar5 = new f.b();
        bVar5.w(TABLE_PHOTO_TAG);
        bVar5.p("_id");
        bVar5.o("photoID");
        bVar5.s(PhotoTagColumns.MODEL);
        bVar5.s(PhotoTagColumns.ZH_CN_TAG);
        bVar5.s(PhotoTagColumns.ZH_TW_TAG);
        bVar5.s(PhotoTagColumns.EN_US_TAG);
        bVar5.s(PhotoTagColumns.ZH_CN_LEVEL_0);
        bVar5.s(PhotoTagColumns.ZH_TW_LEVEL_0);
        bVar5.s(PhotoTagColumns.EN_US_LEVEL_0);
        bVar5.s(PhotoTagColumns.ZH_CN_LEVEL_1);
        bVar5.s(PhotoTagColumns.ZH_TW_LEVEL_1);
        bVar5.s(PhotoTagColumns.EN_US_LEVEL_1);
        bVar5.r(PhotoTagColumns.WEIGHT);
        f f6 = bVar5.f();
        BIG_ALBUM_TABLE_PHOTO_TAG = f6;
        f.b bVar6 = new f.b();
        bVar6.w("dbControlData");
        bVar6.p("_id");
        bVar6.s(DbControlDataColumns.CONTROL_KEY);
        bVar6.s(DbControlDataColumns.CONTROL_VALUE);
        f f7 = bVar6.f();
        BIG_ALBUM_TABLE_DB_CONTROL_DATA = f7;
        i.b bVar7 = new i.b();
        bVar7.e(1);
        bVar7.g(2);
        bVar7.f(new String[]{"ALTER TABLE 'photoAddress' add 'isUploaded' INTEGER DEFAULT (0)"});
        DB_1_2 = bVar7.d();
        i.b bVar8 = new i.b();
        bVar8.e(2);
        bVar8.g(3);
        bVar8.f(new String[]{"ALTER TABLE 'photo' add 'isGetGeo' INTEGER DEFAULT (0)"});
        DB_2_3 = bVar8.d();
        i.b bVar9 = new i.b();
        bVar9.e(3);
        bVar9.g(4);
        bVar9.f(new String[]{"ALTER TABLE 'gallery' add 'isPreset' INTEGER DEFAULT (0)", "ALTER TABLE 'gallery' add 'systemBucketID' INTEGER DEFAULT (-1)", "ALTER TABLE 'photo' add 'systemBucketID' INTEGER DEFAULT (-1)"});
        DB_3_4 = bVar9.d();
        i.b bVar10 = new i.b();
        bVar10.e(4);
        bVar10.g(5);
        bVar10.f(new String[]{"ALTER TABLE 'photo' add 'editParams' VARCHAR(700)", "ALTER TABLE 'photo' add 'reserved1' VARCHAR(700)", "ALTER TABLE 'photo' add 'reserved2' VARCHAR(700)"});
        DB_4_5 = bVar10.d();
        c.b bVar11 = new c.b();
        bVar11.j(5);
        bVar11.g(BIG_ALBUM_DB_NAME);
        bVar11.h(f2);
        bVar11.h(f3);
        bVar11.h(f4);
        bVar11.h(f5);
        bVar11.h(f6);
        bVar11.h(f7);
        bVar11.i(DB_1_2);
        bVar11.i(DB_2_3);
        bVar11.i(DB_3_4);
        bVar11.i(DB_4_5);
        BIG_ALBUM_DB = bVar11.f();
    }

    private BigAlbumStore() {
    }
}
