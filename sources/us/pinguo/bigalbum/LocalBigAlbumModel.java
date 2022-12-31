package us.pinguo.bigalbum;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.rockerhieu.emoji.model.Emoticon;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.bigalbum.db.BigAlbumDataBase;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.bigalbum.db.DbControlDataTableModel;
import us.pinguo.bigalbum.db.DbGalleryTableModel;
import us.pinguo.bigalbum.db.DbPhotoAddressTableModel;
import us.pinguo.bigalbum.db.DbPhotoTableModel;
import us.pinguo.bigalbum.db.DbPhotoTagTableModel;
import us.pinguo.bigalbum.entity.Gallery;
import us.pinguo.bigalbum.entity.Photo;
import us.pinguo.bigalbum.entity.PhotoAddress;
import us.pinguo.bigalbum.entity.PhotoTag;
import us.pinguo.bigalbum.util.BigAlbumUtil;
import us.pinguo.bigalbum.util.QETag;
import us.pinguo.common.log.a;
import us.pinguo.common.utils.e;
import us.pinguo.inspire.api.QiniuAuthToken;
/* loaded from: classes3.dex */
public class LocalBigAlbumModel implements IBigAlbumModel {
    private static final int INDEX_BUCKET_ID = 8;
    private static final int INDEX_BUCKET_NAME = 10;
    private static final int INDEX_DATA = 6;
    private static final int INDEX_DATE_TAKEN = 5;
    private static final int INDEX_HEIGHT = 12;
    private static final int INDEX_ID = 0;
    private static final int INDEX_LATITUDE = 3;
    private static final int INDEX_LONGITUDE = 4;
    private static final int INDEX_MIME_TYPE = 2;
    private static final int INDEX_ORIENTATION = 7;
    private static final int INDEX_SIZE = 9;
    private static final int INDEX_TITLE = 1;
    private static final int INDEX_WIDTH = 11;
    private static final String IS_MAP_SYSTEM_DB = "is_map_system_db";
    private static final String SYSTEM_DB_MAX_ID = "system_db_max_id";
    public static final String[] SYSTEM_PHOTO_PROJECTION;
    BigAlbumConfig mBigAlbumConfig;
    IBigAlbumObserver mBigAlbumObserver;
    ContentObserver mContentObserver;
    Context mContext;
    DbControlDataTableModel mNoLoginControlDataTableModel;
    BigAlbumDataBase mNoLoginDataBase;
    DbGalleryTableModel mNoLoginGalleryTable;
    DbPhotoAddressTableModel mNoLoginPhotoAddressTable;
    DbPhotoTableModel mNoLoginPhotoTable;
    DbPhotoTagTableModel mNoLoginPhotoTagTable;
    QETag mQETag;
    ContentResolver mResolver;
    Handler mThreadHandler;
    Handler mUiHandler;

    static {
        String[] strArr = {"_id", "title", "mime_type", BigAlbumStore.PhotoColumns.LATITUDE, BigAlbumStore.PhotoColumns.LONGITUDE, "datetaken", "_data", "orientation", "bucket_id", "_size", "bucket_display_name", "0", "0"};
        SYSTEM_PHOTO_PROJECTION = strArr;
        if (BigAlbumUtil.hasField(MediaStore.MediaColumns.class, "WIDTH")) {
            strArr[11] = "width";
            strArr[12] = "height";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalBigAlbumModel(Context context, BigAlbumConfig bigAlbumConfig, IBigAlbumObserver iBigAlbumObserver) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mBigAlbumConfig = bigAlbumConfig;
        this.mBigAlbumObserver = iBigAlbumObserver;
        this.mResolver = applicationContext.getContentResolver();
        this.mQETag = new QETag();
    }

    private void generateLength(Photo photo) {
        if ((photo.width <= 0 || photo.height <= 0) && !TextUtils.isEmpty(photo.localPath) && new File(photo.localPath).exists()) {
            if (photo.width <= 0 || photo.height <= 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(photo.localPath, options);
                photo.width = options.outWidth;
                photo.height = options.outHeight;
            }
        }
    }

    private Map<String, Photo> getDataIncremental(int i2) {
        HashMap hashMap = new HashMap();
        Cursor query = this.mNoLoginPhotoTable.query(new String[]{"_id", BigAlbumStore.PhotoColumns.LOCAL_PATH, "createDate", BigAlbumStore.PhotoColumns.PROJECT_STATE}, "_id >  (SELECT IFNULL(MAX(_id), 0) FROM photo WHERE systemDbID >= 0 AND systemDbID <= ?) ", new String[]{String.valueOf(i2)}, null, null, null);
        if (query == null) {
            return hashMap;
        }
        try {
            HashMap hashMap2 = new HashMap(query.getCount() * 3);
            while (query.moveToNext()) {
                Photo photo = new Photo();
                photo.id = query.getInt(0);
                photo.localPath = query.getString(1);
                photo.createDate = query.getLong(2);
                photo.projectState = query.getString(3);
                hashMap2.put(photo.localPath, photo);
            }
            return hashMap2;
        } catch (Exception unused) {
            return hashMap;
        } finally {
            query.close();
        }
    }

    private Map<String, Photo> getDataLegacy() {
        SQLiteDatabase sQLiteDatabase;
        HashMap hashMap = new HashMap();
        if (this.mBigAlbumConfig.getLegacyDbPath() != null && new File(this.mBigAlbumConfig.getLegacyDbPath()).exists()) {
            a.c("dataMigration ===> begin", new Object[0]);
            Cursor cursor = null;
            try {
                sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.mBigAlbumConfig.getLegacyDbPath(), (SQLiteDatabase.CursorFactory) null);
            } catch (Exception unused) {
                sQLiteDatabase = null;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = null;
            }
            try {
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
                BigAlbumUtil.closeCursorSilently(cursor);
                BigAlbumUtil.closeSilently(sQLiteDatabase);
                throw th;
            }
            if (sQLiteDatabase.getVersion() <= 0) {
                BigAlbumUtil.closeCursorSilently(null);
                BigAlbumUtil.closeSilently(sQLiteDatabase);
                return hashMap;
            }
            String[] strArr = {"tokenMillis", "effectPhotoSavePath", QiniuAuthToken.TYPE_DIRECT, "width", "height", "lat", "lon", BigAlbumStore.PhotoColumns.CAMERA_MODE_INDEX, BigAlbumStore.PhotoColumns.PICTURE_TYPE, BigAlbumStore.PhotoColumns.COST_MILLIS, BigAlbumStore.PhotoColumns.FAIL_COUNT, BigAlbumStore.PhotoColumns.PROJECT_STATE, BigAlbumStore.PhotoColumns.PROJECT_VERSION_CODE, BigAlbumStore.PhotoColumns.EFT_ALIAS, BigAlbumStore.PhotoColumns.EFT_APPENDIX, BigAlbumStore.PhotoColumns.LAYER_EFFECT_PARAMS, BigAlbumStore.PhotoColumns.EXIF, BigAlbumStore.PhotoColumns.JSON_EXPAND};
            cursor = sQLiteDatabase.rawQuery("select sql from sqlite_master where tbl_name=?", new String[]{"photoproject"});
            if (cursor != null && cursor.moveToFirst()) {
                String string = cursor.getString(cursor.getColumnIndex("sql"));
                if (!string.contains("effectPhotoSavePath")) {
                    strArr[1] = "''";
                }
                if (!string.contains(QiniuAuthToken.TYPE_DIRECT)) {
                    strArr[2] = "0";
                }
                if (!string.contains("width")) {
                    strArr[3] = "0";
                }
                if (!string.contains("height")) {
                    strArr[4] = "0";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.PICTURE_TYPE)) {
                    strArr[8] = "''";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.COST_MILLIS)) {
                    strArr[9] = "''";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.FAIL_COUNT)) {
                    strArr[10] = "0";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.PROJECT_STATE)) {
                    strArr[11] = "''";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.PROJECT_VERSION_CODE)) {
                    strArr[12] = "''";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.EFT_ALIAS)) {
                    strArr[13] = "''";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.EFT_APPENDIX)) {
                    strArr[14] = "''";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.LAYER_EFFECT_PARAMS)) {
                    strArr[15] = "''";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.EXIF)) {
                    strArr[16] = "''";
                }
                if (!string.contains(BigAlbumStore.PhotoColumns.JSON_EXPAND)) {
                    strArr[17] = "''";
                }
                cursor.close();
                cursor = sQLiteDatabase.query("photoproject", strArr, null, new String[0], null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    HashMap hashMap2 = new HashMap(cursor.getCount() * 3);
                    do {
                        Photo photo = new Photo();
                        long j2 = cursor.getLong(0);
                        photo.createDate = j2;
                        if (j2 > 0) {
                            photo.modifyDate = j2;
                            photo.localPath = cursor.getString(1);
                            photo.orientation = cursor.getInt(2);
                            photo.width = cursor.getInt(3);
                            photo.height = cursor.getInt(4);
                            photo.latitude = cursor.getDouble(5);
                            photo.longitude = cursor.getDouble(6);
                            photo.cameraModeIndex = cursor.getInt(7);
                            photo.pictureType = cursor.getInt(8);
                            photo.costMillis = cursor.getLong(9);
                            photo.failCount = cursor.getInt(10);
                            photo.projectState = cursor.getString(11);
                            photo.projectVersionCode = cursor.getString(12);
                            photo.eftAlias = cursor.getString(13);
                            photo.eftAppendix = cursor.getString(14);
                            photo.layerEffectParams = cursor.getString(15);
                            photo.exif = cursor.getString(16);
                            photo.jsonExpand = cursor.getString(17);
                            hashMap2.put(photo.localPath, photo);
                        }
                    } while (cursor.moveToNext());
                    hashMap = hashMap2;
                }
            }
            BigAlbumUtil.closeCursorSilently(cursor);
            BigAlbumUtil.closeSilently(sQLiteDatabase);
            a.c("dataMigration ===> end:" + hashMap.size(), new Object[0]);
            return hashMap;
        }
        return hashMap;
    }

    private boolean isFilterThrough(String str, String str2, long j2) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            if (j2 <= 0 || j2 >= 40000 || lowerCase.contains("dcim") || lowerCase.contains("camera")) {
                if (str2 != null) {
                    String lowerCase2 = str2.toLowerCase();
                    if ((lowerCase2.endsWith(Emoticon.TYPE_PNG) || lowerCase2.endsWith(Emoticon.TYPE_GIF)) && !lowerCase.contains("dcim") && !lowerCase.contains("camera") && !lowerCase.contains("screenshot")) {
                        return false;
                    }
                }
                int lastIndexOf = lowerCase.lastIndexOf("/");
                if (lastIndexOf > 0) {
                    String substring = lowerCase.substring(0, lastIndexOf);
                    return (substring.endsWith("micromsg") || substring.endsWith("cache")) ? false : true;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    private void notifyChange(String str) {
        IBigAlbumObserver iBigAlbumObserver = this.mBigAlbumObserver;
        if (iBigAlbumObserver != null) {
            iBigAlbumObserver.onChange(str);
        }
    }

    private void removeLegacyDb() {
        try {
            if (this.mBigAlbumConfig.getLegacyDbPath() == null || !new File(this.mBigAlbumConfig.getLegacyDbPath()).exists()) {
                return;
            }
            new File(this.mBigAlbumConfig.getLegacyDbPath()).delete();
        } catch (Exception unused) {
        }
    }

    private ContentValues systemPhotoToValues(Photo photo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BigAlbumStore.PhotoColumns.SYSTEM_DB_ID, Integer.valueOf(photo.systemDbID));
        contentValues.put("createDate", Long.valueOf(photo.createDate));
        contentValues.put(BigAlbumStore.PhotoColumns.MODIFY_DATE, Long.valueOf(photo.modifyDate));
        contentValues.put(BigAlbumStore.PhotoColumns.LOCAL_PATH, photo.localPath);
        contentValues.put(BigAlbumStore.PhotoColumns.SIZE, Long.valueOf(photo.size));
        contentValues.put("name", photo.name);
        contentValues.put(BigAlbumStore.PhotoColumns.MIME_TYPE, photo.mimeType);
        contentValues.put(BigAlbumStore.PhotoColumns.LATITUDE, Double.valueOf(photo.latitude));
        contentValues.put(BigAlbumStore.PhotoColumns.LONGITUDE, Double.valueOf(photo.longitude));
        contentValues.put("orientation", Integer.valueOf(photo.orientation));
        contentValues.put("width", Integer.valueOf(photo.width));
        contentValues.put("height", Integer.valueOf(photo.height));
        contentValues.put("systemBucketID", Integer.valueOf(photo.systemBucketID));
        if (!TextUtils.isEmpty(photo.projectState)) {
            contentValues.put(BigAlbumStore.PhotoColumns.CAMERA_MODE_INDEX, Integer.valueOf(photo.cameraModeIndex));
            contentValues.put(BigAlbumStore.PhotoColumns.PICTURE_TYPE, Integer.valueOf(photo.pictureType));
            contentValues.put(BigAlbumStore.PhotoColumns.COST_MILLIS, Long.valueOf(photo.costMillis));
            contentValues.put(BigAlbumStore.PhotoColumns.FAIL_COUNT, Integer.valueOf(photo.failCount));
            contentValues.put(BigAlbumStore.PhotoColumns.PROJECT_STATE, photo.projectState);
            contentValues.put(BigAlbumStore.PhotoColumns.PROJECT_VERSION_CODE, photo.projectVersionCode);
            contentValues.put(BigAlbumStore.PhotoColumns.EFT_ALIAS, photo.eftAlias);
            contentValues.put(BigAlbumStore.PhotoColumns.LAYER_EFFECT_PARAMS, photo.layerEffectParams);
            contentValues.put(BigAlbumStore.PhotoColumns.EXIF, photo.exif);
            contentValues.put(BigAlbumStore.PhotoColumns.JSON_EXPAND, photo.jsonExpand);
            contentValues.put(BigAlbumStore.PhotoColumns.EDIT_PARAMS, photo.editParams);
            contentValues.put(BigAlbumStore.PhotoColumns.RESERVED1, photo.reserved1);
            contentValues.put(BigAlbumStore.PhotoColumns.RESERVED2, photo.reserved2);
        }
        return contentValues;
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void addPhotoToGallery(int i2, List<Integer> list) {
        this.mNoLoginGalleryTable.addPhotoToGallery(i2, list);
        notifyChange(BigAlbumStore.TABLE_GALLERY);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void commitMapGallery() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BigAlbumStore.GalleryColumns.IS_PRESET, (Integer) 0);
        this.mNoLoginGalleryTable.update(null, new String[0], contentValues);
        this.mNoLoginControlDataTableModel.putInt(IS_MAP_SYSTEM_DB, 0);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void deleteGallery(int i2) {
        this.mNoLoginGalleryTable.delete(i2);
        notifyChange(BigAlbumStore.TABLE_GALLERY);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void deletePhoto(int i2) {
        Photo photo = this.mNoLoginPhotoTable.get(i2);
        if (photo != null) {
            this.mNoLoginPhotoTable.delete(photo);
            notifyChange("photo");
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i2));
            this.mNoLoginGalleryTable.deletePhotoRelations(arrayList);
            notifyChange(BigAlbumStore.TABLE_GALLERY);
            if (!TextUtils.isEmpty(photo.localPath)) {
                File file = new File(photo.localPath);
                if (file.exists()) {
                    file.delete();
                }
            }
            int i3 = photo.systemDbID;
            if (i3 >= 0) {
                this.mResolver.delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id = ?", new String[]{String.valueOf(i3)});
            } else if (TextUtils.isEmpty(photo.localPath)) {
            } else {
                this.mResolver.delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data = ?", new String[]{photo.localPath});
            }
        }
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void deletePhotoBySystemDbId(int i2) {
        Photo bySystemId = this.mNoLoginPhotoTable.getBySystemId(i2);
        if (bySystemId != null) {
            this.mNoLoginPhotoTable.delete(bySystemId);
            notifyChange("photo");
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(bySystemId.id));
            this.mNoLoginGalleryTable.deletePhotoRelations(arrayList);
            notifyChange(BigAlbumStore.TABLE_GALLERY);
            if (TextUtils.isEmpty(bySystemId.localPath)) {
                return;
            }
            File file = new File(bySystemId.localPath);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void deletePhotoFromGallery(int i2, List<Integer> list) {
        this.mNoLoginGalleryTable.deletePhotoFromGallery(i2, list);
        notifyChange(BigAlbumStore.TABLE_GALLERY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ff, code lost:
        if (r1 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0101, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0105, code lost:
        if (r1 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0108, code lost:
        us.pinguo.common.log.a.c("construct photo data ===>", new java.lang.Object[0]);
        r1 = new java.util.ArrayList();
        r2 = null;
        r6 = r3.values().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0121, code lost:
        if (r6.hasNext() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0123, code lost:
        r1.addAll(((us.pinguo.bigalbum.entity.Gallery) r6.next()).photos);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0133, code lost:
        if (r1.size() <= 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0135, code lost:
        r6 = new android.content.ContentValues[r1.size()];
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0140, code lost:
        if (r7 >= r1.size()) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0142, code lost:
        r6[r7] = systemPhotoToValues((us.pinguo.bigalbum.entity.Photo) r1.get(r7));
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0151, code lost:
        r2 = r11.mNoLoginPhotoTable.bulkInsert(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void firstTimeScan() {
        /*
            Method dump skipped, instructions count: 533
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.LocalBigAlbumModel.firstTimeScan():void");
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public Photo[] getFirstFavAndLocalPhoto() {
        Photo[] photoArr = new Photo[2];
        List<Photo> list = this.mNoLoginPhotoTable.get(null, new String[0], "createDate DESC LIMIT 0,1");
        if (list == null || list.isEmpty()) {
            photoArr[0] = null;
        } else {
            photoArr[0] = list.get(0);
        }
        List<Photo> list2 = this.mNoLoginPhotoTable.get("isFav = 1 ", new String[0], "_id DESC LIMIT 0,1");
        if (list2 == null || list2.isEmpty()) {
            photoArr[1] = null;
        } else {
            photoArr[1] = list2.get(0);
        }
        return photoArr;
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public Gallery getGallery(int i2) {
        return this.mNoLoginGalleryTable.getGallery(i2);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public Photo getGalleryCoverPhoto(int i2) {
        return this.mNoLoginGalleryTable.getGalleryCoverPhoto(i2);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public Photo getPhoto(int i2) {
        return this.mNoLoginPhotoTable.get(i2);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public List<Photo> getPhotosOrderBy(String str) {
        a.c("getPhotos ===> begin", new Object[0]);
        List<Photo> allOrderBy = this.mNoLoginPhotoTable.getAllOrderBy(str);
        a.c("getPhotos ===> end", new Object[0]);
        return allOrderBy;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02b2, code lost:
        if (r10 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02b4, code lost:
        r4.add(java.lang.Integer.valueOf(r5.id));
        r6.append(r5.id);
        r6.append(",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02cb, code lost:
        if (r6.length() <= 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02cd, code lost:
        r6.deleteCharAt(r6.length() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02d9, code lost:
        if (r4.size() <= 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02db, code lost:
        r16.mNoLoginPhotoTable.delete("_id in (" + ((java.lang.Object) r6) + ") ", null);
        notifyChange("photo");
        r16.mNoLoginGalleryTable.deletePhotoRelations(r4);
        us.pinguo.common.log.a.c("del photos ===>{" + ((java.lang.Object) r6) + "}", new java.lang.Object[0]);
        notifyChange(us.pinguo.bigalbum.db.BigAlbumStore.TABLE_GALLERY);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x031e, code lost:
        if (r14 < 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0320, code lost:
        r16.mNoLoginControlDataTableModel.putInt(us.pinguo.bigalbum.LocalBigAlbumModel.SYSTEM_DB_MAX_ID, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0327, code lost:
        us.pinguo.common.log.a.c("incrementalScan ===> end", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x032e, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0135, code lost:
        if (r5 != null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x013c, code lost:
        if (r4.size() <= 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013e, code lost:
        r12 = r4.values();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0142, code lost:
        us.pinguo.common.log.a.c("construct photo data ===>", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x014d, code lost:
        if (r13.size() <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x014f, code lost:
        r4 = new android.content.ContentValues[r13.size()];
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x015a, code lost:
        if (r5 >= r13.size()) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015c, code lost:
        r4[r5] = systemPhotoToValues((us.pinguo.bigalbum.entity.Photo) r13.get(r5));
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x016b, code lost:
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0172, code lost:
        if (r13.size() > 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0178, code lost:
        if (r9.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x017a, code lost:
        r16.mNoLoginPhotoTable.bulkInsertAndUpdateSysId(r4, r9);
        us.pinguo.common.log.a.c("insert photos ===> insert:" + r13.size() + ", update:" + r9.size(), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a9, code lost:
        if (r13.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01ab, code lost:
        notifyChange("photo");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01ae, code lost:
        if (r18 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b0, code lost:
        r4 = r16.mResolver.query(r2, new java.lang.String[]{"_id"}, "_id <= " + r17, null, null);
        r5 = new java.util.HashSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01d7, code lost:
        if (r4 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01dd, code lost:
        if (r4.moveToNext() == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01df, code lost:
        r5.add(java.lang.Integer.valueOf(r4.getInt(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01eb, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01f1, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01f2, code lost:
        if (r4 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01f4, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01f7, code lost:
        r0 = r16.mNoLoginPhotoTable.getAllIdsBeforeSystemDbId(r17);
        r4 = new java.util.ArrayList();
        r6 = new java.lang.StringBuilder();
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0211, code lost:
        if (r0.hasNext() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0213, code lost:
        r7 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x021f, code lost:
        if (r5.contains(r7.data1) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0221, code lost:
        r4.add(r7.data2);
        r6.append(r7.data2);
        r6.append(",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x022f, code lost:
        r0 = r12.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0237, code lost:
        if (r0.hasNext() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0239, code lost:
        r5 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0241, code lost:
        if (r5.systemDbID < 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0243, code lost:
        us.pinguo.common.log.a.c("del id:" + r5.id + ",systemDbID:" + r5.systemDbID, new java.lang.Object[0]);
        r4.add(java.lang.Integer.valueOf(r5.id));
        r6.append(r5.id);
        r6.append(",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0279, code lost:
        if (r5.localPath != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x027b, code lost:
        r4.add(java.lang.Integer.valueOf(r5.id));
        r6.append(r5.id);
        r6.append(",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0298, code lost:
        if (new java.io.File(r5.localPath).exists() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02a2, code lost:
        if ("editing".equals(r5.projectState) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02ac, code lost:
        if ("waiting".equals(r5.projectState) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02af, code lost:
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x02b1, code lost:
        r10 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void incrementalScan(int r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.LocalBigAlbumModel.incrementalScan(int, boolean):void");
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void init(Handler handler) {
        this.mThreadHandler = handler;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        a.c("init ===> begin", new Object[0]);
        String absolutePath = this.mContext.getDatabasePath(BigAlbumStore.BIG_ALBUM_DB_NAME).getAbsolutePath();
        if (!new File(absolutePath).exists()) {
            String str = BigAlbumStore.BIG_ALBUM_ROOT + BigAlbumStore.BIG_ALBUM_DB_NAME;
            if (new File(str).exists()) {
                try {
                    e.f(str, absolutePath);
                    e.h(absolutePath);
                } catch (IOException unused) {
                }
            }
        }
        BigAlbumDataBase bigAlbumDataBase = new BigAlbumDataBase(this.mContext);
        this.mNoLoginDataBase = bigAlbumDataBase;
        try {
            bigAlbumDataBase.init();
        } catch (Exception unused2) {
        }
        this.mNoLoginPhotoTable = new DbPhotoTableModel(this.mNoLoginDataBase);
        this.mNoLoginGalleryTable = new DbGalleryTableModel(this.mNoLoginDataBase);
        this.mNoLoginControlDataTableModel = new DbControlDataTableModel(this.mNoLoginDataBase);
        this.mNoLoginPhotoAddressTable = new DbPhotoAddressTableModel(this.mNoLoginDataBase);
        this.mNoLoginPhotoTagTable = new DbPhotoTagTableModel(this.mNoLoginDataBase);
        this.mUiHandler.post(new Runnable() { // from class: us.pinguo.bigalbum.LocalBigAlbumModel.1
            @Override // java.lang.Runnable
            public void run() {
                LocalBigAlbumModel.this.registerListener();
            }
        });
        a.c("init ===> end", new Object[0]);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void insertGallery(Gallery gallery, List<Integer> list) {
        this.mNoLoginGalleryTable.insert(gallery, list);
        notifyChange(BigAlbumStore.TABLE_GALLERY);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void insertPhoto(Photo photo) {
        a.c("insertPhoto ===> begin", new Object[0]);
        if (photo != null) {
            long j2 = photo.createDate;
            if (j2 > 0 && photo.modifyDate == 0) {
                photo.modifyDate = j2;
            }
            if (TextUtils.isEmpty(photo.name) && !TextUtils.isEmpty(photo.localPath)) {
                photo.name = new File(photo.localPath).getName();
            }
        }
        if (this.mNoLoginPhotoTable.replaceByLocalPath(photo) >= 0) {
            notifyChange("photo");
        }
        a.c("insertPhoto ===> end", new Object[0]);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void insertPhotoAddress(List<PhotoAddress> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mNoLoginPhotoAddressTable.bulkInsert(list);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void insertPhotoTag(List<PhotoTag> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mNoLoginPhotoTagTable.bulkInsert(list);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public boolean isAlreadyMapGallery() {
        return this.mNoLoginControlDataTableModel.getInt(IS_MAP_SYSTEM_DB, 0) == 0;
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void login(String str, String str2) {
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void logout() {
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public Cursor queryGallery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        a.c("queryGallery ===> begin:" + str, new Object[0]);
        Cursor query = this.mNoLoginGalleryTable.query(strArr, str, strArr2, str2, str3, str4);
        a.c("queryGallery ===> end", new Object[0]);
        return query;
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public Cursor queryPhoto(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        a.c("queryPhoto ===> begin:" + str, new Object[0]);
        Cursor query = this.mNoLoginPhotoTable.query(strArr, str, strArr2, str2, str3, str4);
        a.c("queryPhoto ===> end", new Object[0]);
        return query;
    }

    void registerListener() {
        if (this.mContentObserver != null) {
            this.mContext.getContentResolver().unregisterContentObserver(this.mContentObserver);
            this.mContentObserver = null;
        }
        Handler handler = this.mThreadHandler;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        this.mContentObserver = new ContentObserver(handler) { // from class: us.pinguo.bigalbum.LocalBigAlbumModel.2
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                if (uri != null) {
                    boolean z2 = false;
                    a.c("observe change:" + uri, new Object[0]);
                    String str = Build.MODEL;
                    if (str == null || !str.equals("MX5") || (uri.getPath() != null && uri.getPath().equals(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath()))) {
                        z2 = true;
                    }
                    if (z2) {
                        LocalBigAlbumModel.this.mThreadHandler.postDelayed(new Runnable() { // from class: us.pinguo.bigalbum.LocalBigAlbumModel.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LocalBigAlbumModel.this.syncSystem(false);
                            }
                        }, 2000L);
                    }
                }
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                LocalBigAlbumModel.this.mThreadHandler.postDelayed(new Runnable() { // from class: us.pinguo.bigalbum.LocalBigAlbumModel.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LocalBigAlbumModel.this.syncSystem(false);
                    }
                }, 2000L);
            }
        };
        this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.mContentObserver);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void rollbackMapGallery() {
        if (this.mNoLoginControlDataTableModel.getInt(IS_MAP_SYSTEM_DB, 0) == 1) {
            this.mNoLoginGalleryTable.delete("isPreset = 1", new String[0]);
            this.mNoLoginControlDataTableModel.putInt(IS_MAP_SYSTEM_DB, 0);
        }
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void scan() {
        a.c("scanSystemPhotos ===> begin", new Object[0]);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null || !externalStorageDirectory.exists()) {
            return;
        }
        int i2 = this.mNoLoginControlDataTableModel.getInt(SYSTEM_DB_MAX_ID, -1);
        if (i2 >= 0) {
            incrementalScan(i2, true);
        } else {
            firstTimeScan();
        }
        a.c("scanSystemPhotos ===> end", new Object[0]);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void syncSystem(boolean z) {
        int i2;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null || !externalStorageDirectory.exists() || (i2 = this.mNoLoginControlDataTableModel.getInt(SYSTEM_DB_MAX_ID, -1)) < 0) {
            return;
        }
        incrementalScan(i2, z);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void updateGallery(int i2, ContentValues contentValues) {
        if (this.mNoLoginGalleryTable.update(i2, contentValues)) {
            notifyChange(BigAlbumStore.TABLE_GALLERY);
        }
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void updatePhoto(Photo photo, boolean z) {
        if (this.mNoLoginPhotoTable.update(photo) && z) {
            notifyChange("photo");
        }
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void updateGallery(Gallery gallery) {
        this.mNoLoginGalleryTable.update(gallery);
        notifyChange(BigAlbumStore.TABLE_GALLERY);
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void updatePhoto(ContentValues contentValues, String str, String[] strArr, boolean z) {
        if (this.mNoLoginPhotoTable.update(contentValues, str, strArr) && z) {
            notifyChange("photo");
        }
    }

    @Override // us.pinguo.bigalbum.IBigAlbumModel
    public void updatePhoto(int i2, ContentValues contentValues, boolean z) {
        if (this.mNoLoginPhotoTable.update(contentValues, "_id = ?", new String[]{String.valueOf(i2)}) && z) {
            notifyChange("photo");
        }
    }
}
