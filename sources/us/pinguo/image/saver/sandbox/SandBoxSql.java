package us.pinguo.image.saver.sandbox;

import android.database.Cursor;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.bigalbum.entity.Photo;
import us.pinguo.image.saver.sandbox.SandBoxConstants;
import us.pinguo.librouter.b.c.f;
/* loaded from: classes4.dex */
public class SandBoxSql {
    private static SandBoxSql a;

    private SandBoxSql() {
    }

    private Photo a(us.pinguo.image.saver.d.a aVar) {
        Photo photo = new Photo();
        photo.cameraModeIndex = aVar.a();
        photo.pictureType = aVar.n();
        photo.createDate = aVar.b();
        if (aVar.l() != null) {
            photo.latitude = aVar.l().c();
            photo.longitude = aVar.l().d();
        } else {
            photo.latitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            photo.longitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        photo.failCount = aVar.p();
        photo.projectState = aVar.o();
        photo.orientation = aVar.m();
        photo.width = aVar.r();
        photo.height = aVar.i();
        photo.costMillis = aVar.g();
        photo.localPath = aVar.c();
        photo.projectVersionCode = aVar.q();
        photo.eftAlias = aVar.f();
        photo.eftAppendix = aVar.e();
        photo.exif = aVar.h();
        photo.jsonExpand = aVar.j();
        photo.layerEffectParams = aVar.k();
        photo.editParams = aVar.d();
        photo.mimeType = "image/jpeg";
        if (!TextUtils.isEmpty(photo.localPath)) {
            try {
                File file = new File(photo.localPath);
                photo.size = file.length();
                photo.name = file.getName();
            } catch (Exception unused) {
            }
        }
        return photo;
    }

    public static synchronized SandBoxSql getInstance() throws Exception {
        SandBoxSql sandBoxSql;
        synchronized (SandBoxSql.class) {
            if (a == null) {
                try {
                    a = new SandBoxSql();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    throw new Exception("无法打开数据库");
                }
            }
            sandBoxSql = a;
        }
        return sandBoxSql;
    }

    public synchronized void b(us.pinguo.image.saver.d.a aVar) {
        if (aVar != null) {
            BigAlbumManager.instance().insertPhotoAsync(a(aVar));
        } else {
            throw new RuntimeException("Camera360 SandBox insert database with null project");
        }
    }

    public synchronized us.pinguo.image.saver.d.a c(String str) {
        Throwable th;
        Cursor cursor;
        try {
            cursor = BigAlbumManager.instance().queryPhoto(null, "localPath IS NOT NULL AND LOWER(localPath) = LOWER(?)", new String[]{str}, null, null, null);
            try {
                us.pinguo.image.saver.d.a aVar = new us.pinguo.image.saver.d.a();
                if (cursor.moveToFirst()) {
                    aVar.E(cursor.getInt(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.PICTURE_TYPE)));
                    aVar.s(cursor.getInt(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.CAMERA_MODE_INDEX)));
                    aVar.t(cursor.getLong(cursor.getColumnIndex("createDate")));
                    f fVar = new f();
                    fVar.i(cursor.getDouble(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.LATITUDE)));
                    fVar.j(cursor.getDouble(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.LONGITUDE)));
                    aVar.C(fVar);
                    aVar.H(cursor.getInt(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.FAIL_COUNT)));
                    aVar.z(cursor.getString(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.EXIF)));
                    aVar.F(cursor.getString(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.PROJECT_STATE)));
                    aVar.D(cursor.getInt(cursor.getColumnIndex("orientation")));
                    aVar.J(cursor.getInt(cursor.getColumnIndex("width")));
                    aVar.A(cursor.getInt(cursor.getColumnIndex("height")));
                    aVar.y(cursor.getLong(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.COST_MILLIS)));
                    aVar.u(cursor.getString(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.LOCAL_PATH)));
                    aVar.I(cursor.getString(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.PROJECT_VERSION_CODE)));
                    aVar.w(cursor.getString(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.EFT_ALIAS)));
                    aVar.x(cursor.getString(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.EFT_APPENDIX)));
                    aVar.B(cursor.getString(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.LAYER_EFFECT_PARAMS)));
                    aVar.G(a.a(SandBoxConstants.SandBoxPictureType.photo_org, aVar.b()));
                    aVar.v(cursor.getString(cursor.getColumnIndex(BigAlbumStore.PhotoColumns.EDIT_PARAMS)));
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return aVar;
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }
}
