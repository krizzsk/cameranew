package us.pinguo.bigalbum.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.bigalbum.entity.Gallery;
import us.pinguo.bigalbum.entity.Photo;
import us.pinguo.bigalbum.util.DataPair;
import us.pinguo.common.db.b;
import us.pinguo.common.db.f;
import us.pinguo.common.db.g;
import us.pinguo.common.db.k;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
/* loaded from: classes3.dex */
public class DbGalleryTableModel extends g {
    f galleryPhotoRelationTableDefinition;
    f galleryTableDefinition;
    protected k<Gallery> galleryTypeAdapter;
    f photoTableDefinition;
    protected k<Photo> photoTypeAdapter;

    public DbGalleryTableModel(b bVar) {
        super(bVar);
        this.galleryTableDefinition = BigAlbumStore.BIG_ALBUM_TABLE_GALLERY;
        this.galleryPhotoRelationTableDefinition = BigAlbumStore.BIG_ALBUM_TABLE_GALLERY_PHOTO_RELATIONS;
        this.photoTableDefinition = BigAlbumStore.BIG_ALBUM_TABLE_PHOTO;
        this.galleryTypeAdapter = k.a(Gallery.class);
        this.photoTypeAdapter = k.a(Photo.class);
    }

    public void addPhotoToGallery(int i2, List<Integer> list) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                this.dbDataBase.writeLock().lock();
                writableDatabase = this.dbDataBase.getWritableDatabase();
            } catch (Exception e2) {
                e = e2;
            }
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception unused) {
                    }
                }
                this.dbDataBase.writeLock().unlock();
                return;
            }
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put(BigAlbumStore.GalleryPhotoRelationsColumns.GALLERY_ID, Integer.valueOf(i2));
                for (Integer num : list) {
                    contentValues.put("photoID", num);
                    writableDatabase.insert(this.galleryPhotoRelationTableDefinition.a, null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase = writableDatabase;
                e.printStackTrace();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.dbDataBase.writeLock().unlock();
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception unused2) {
                    }
                }
                this.dbDataBase.writeLock().unlock();
                throw th;
            }
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
            this.dbDataBase.writeLock().unlock();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a9, code lost:
        if (r2 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bb, code lost:
        if (r2 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
        r2.endTransaction();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void delete(java.lang.String r13, java.lang.String[] r14) {
        /*
            r12 = this;
            java.lang.String r0 = ") "
            r1 = 0
            us.pinguo.common.db.b r2 = r12.dbDataBase     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb1
            java.util.concurrent.locks.Lock r2 = r2.writeLock()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb1
            r2.lock()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb1
            us.pinguo.common.db.b r2 = r12.dbDataBase     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb1
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> Lae java.lang.Exception -> Lb1
            if (r2 != 0) goto L23
            if (r2 == 0) goto L19
            r2.endTransaction()     // Catch: java.lang.Exception -> L19
        L19:
            us.pinguo.common.db.b r13 = r12.dbDataBase
            java.util.concurrent.locks.Lock r13 = r13.writeLock()
            r13.unlock()
            return
        L23:
            r2.beginTransaction()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lca
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lca
            r11.<init>()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lca
            us.pinguo.common.db.f r3 = r12.galleryTableDefinition     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lca
            java.lang.String r4 = r3.a     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lca
            java.lang.String r3 = "_id"
            java.lang.String[] r5 = new java.lang.String[]{r3}     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lca
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r2
            r6 = r13
            r7 = r14
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lca
            if (r13 == 0) goto L5c
        L41:
            boolean r14 = r13.moveToNext()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            if (r14 == 0) goto L5c
            r14 = 0
            int r14 = r13.getInt(r14)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r11.append(r14)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            java.lang.String r14 = ","
            r11.append(r14)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            goto L41
        L55:
            r14 = move-exception
            r1 = r13
            goto Lcb
        L59:
            r14 = move-exception
            r1 = r13
            goto Lb3
        L5c:
            int r14 = r11.length()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            if (r14 <= 0) goto L6b
            int r14 = r11.length()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            int r14 = r14 + (-1)
            r11.deleteCharAt(r14)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
        L6b:
            us.pinguo.common.db.f r14 = r12.galleryPhotoRelationTableDefinition     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            java.lang.String r14 = r14.a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r3.<init>()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            java.lang.String r4 = "galleryID in ("
            r3.append(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r3.append(r11)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r3.append(r0)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r2.delete(r14, r3, r1)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            us.pinguo.common.db.f r14 = r12.galleryTableDefinition     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            java.lang.String r14 = r14.a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r3.<init>()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            java.lang.String r4 = "_id in ("
            r3.append(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r3.append(r11)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r3.append(r0)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r2.delete(r14, r0, r1)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L59
            if (r13 == 0) goto La9
            r13.close()
        La9:
            if (r2 == 0) goto Lc0
            goto Lbd
        Lac:
            r14 = move-exception
            goto Lb3
        Lae:
            r14 = move-exception
            r2 = r1
            goto Lcb
        Lb1:
            r14 = move-exception
            r2 = r1
        Lb3:
            r14.printStackTrace()     // Catch: java.lang.Throwable -> Lca
            if (r1 == 0) goto Lbb
            r1.close()
        Lbb:
            if (r2 == 0) goto Lc0
        Lbd:
            r2.endTransaction()     // Catch: java.lang.Exception -> Lc0
        Lc0:
            us.pinguo.common.db.b r13 = r12.dbDataBase
            java.util.concurrent.locks.Lock r13 = r13.writeLock()
            r13.unlock()
            return
        Lca:
            r14 = move-exception
        Lcb:
            if (r1 == 0) goto Ld0
            r1.close()
        Ld0:
            if (r2 == 0) goto Ld5
            r2.endTransaction()     // Catch: java.lang.Exception -> Ld5
        Ld5:
            us.pinguo.common.db.b r13 = r12.dbDataBase
            java.util.concurrent.locks.Lock r13 = r13.writeLock()
            r13.unlock()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbGalleryTableModel.delete(java.lang.String, java.lang.String[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (r1 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r1 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        r1.endTransaction();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void deleteAll() {
        /*
            r5 = this;
            r0 = 0
            us.pinguo.common.db.b r1 = r5.dbDataBase     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            java.util.concurrent.locks.Lock r1 = r1.writeLock()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            r1.lock()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            us.pinguo.common.db.b r1 = r5.dbDataBase     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L42
            if (r1 != 0) goto L21
            if (r1 == 0) goto L17
            r1.endTransaction()     // Catch: java.lang.Exception -> L17
        L17:
            us.pinguo.common.db.b r0 = r5.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.writeLock()
            r0.unlock()
            return
        L21:
            r1.beginTransaction()     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L58
            r2 = 0
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L58
            us.pinguo.common.db.f r3 = r5.galleryPhotoRelationTableDefinition     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L58
            java.lang.String r3 = r3.a     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L58
            r1.delete(r3, r0, r2)     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L58
            us.pinguo.common.db.f r3 = r5.galleryTableDefinition     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L58
            java.lang.String r3 = r3.a     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L58
            r1.delete(r3, r0, r2)     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L58
            r1.setTransactionSuccessful()     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L58
            if (r1 == 0) goto L4e
            goto L4b
        L3b:
            r0 = move-exception
            goto L46
        L3d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L59
        L42:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L46:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L4e
        L4b:
            r1.endTransaction()     // Catch: java.lang.Exception -> L4e
        L4e:
            us.pinguo.common.db.b r0 = r5.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.writeLock()
            r0.unlock()
            return
        L58:
            r0 = move-exception
        L59:
            if (r1 == 0) goto L5e
            r1.endTransaction()     // Catch: java.lang.Exception -> L5e
        L5e:
            us.pinguo.common.db.b r1 = r5.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.writeLock()
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbGalleryTableModel.deleteAll():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00cb, code lost:
        if (r4 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dd, code lost:
        if (r4 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00df, code lost:
        r4.endTransaction();
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void deletePhotoFromGallery(int r17, java.util.List<java.lang.Integer> r18) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbGalleryTableModel.deletePhotoFromGallery(int, java.util.List):void");
    }

    public boolean deletePhotoRelations(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : list) {
            sb.append(num);
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                this.dbDataBase.writeLock().lock();
                SQLiteDatabase writableDatabase = this.dbDataBase.getWritableDatabase();
                if (writableDatabase == null) {
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception unused) {
                        }
                    }
                    this.dbDataBase.writeLock().unlock();
                    return false;
                }
                try {
                    writableDatabase.beginTransaction();
                    String str = this.galleryPhotoRelationTableDefinition.a;
                    writableDatabase.delete(str, "photoID in (" + ((Object) sb) + ") ", null);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(BigAlbumStore.GalleryColumns.COVER_PHOTO_ID, TaskDetailBasePresenter.SCENE_LIST);
                    String str2 = this.galleryTableDefinition.a;
                    writableDatabase.update(str2, contentValues, "coverPhotoId in (" + ((Object) sb) + ") ", null);
                    writableDatabase.setTransactionSuccessful();
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Exception unused2) {
                        }
                    }
                    this.dbDataBase.writeLock().unlock();
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    sQLiteDatabase = writableDatabase;
                    e.printStackTrace();
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception unused3) {
                        }
                    }
                    this.dbDataBase.writeLock().unlock();
                    return false;
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception unused4) {
                        }
                    }
                    this.dbDataBase.writeLock().unlock();
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<us.pinguo.bigalbum.entity.Gallery> getAllGallerys() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            us.pinguo.common.db.b r2 = r11.dbDataBase     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            java.util.concurrent.locks.Lock r2 = r2.readLock()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            r2.lock()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            us.pinguo.common.db.b r2 = r11.dbDataBase     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            if (r3 != 0) goto L21
            us.pinguo.common.db.b r1 = r11.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            return r0
        L21:
            us.pinguo.common.db.f r2 = r11.galleryTableDefinition     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            java.lang.String r4 = r2.a     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            r5 = 0
            r6 = 0
            r2 = 0
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            if (r1 == 0) goto L4e
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            if (r2 == 0) goto L4e
        L39:
            us.pinguo.common.db.k<us.pinguo.bigalbum.entity.Gallery> r2 = r11.galleryTypeAdapter     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            us.pinguo.common.db.f r3 = r11.galleryTableDefinition     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            java.util.List<us.pinguo.common.db.f$c> r3 = r3.b     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            java.lang.Object r2 = r2.d(r1, r3)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            us.pinguo.bigalbum.entity.Gallery r2 = (us.pinguo.bigalbum.entity.Gallery) r2     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            r0.add(r2)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5c
            if (r2 != 0) goto L39
        L4e:
            us.pinguo.common.db.b r2 = r11.dbDataBase
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r2.unlock()
            if (r1 == 0) goto L6e
            goto L6b
        L5a:
            r0 = move-exception
            goto L6f
        L5c:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L5a
            us.pinguo.common.db.b r2 = r11.dbDataBase
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r2.unlock()
            if (r1 == 0) goto L6e
        L6b:
            r1.close()
        L6e:
            return r0
        L6f:
            us.pinguo.common.db.b r2 = r11.dbDataBase
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r2.unlock()
            if (r1 == 0) goto L7d
            r1.close()
        L7d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbGalleryTableModel.getAllGallerys():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x008c, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009e, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a0, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a3, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<us.pinguo.bigalbum.entity.Photo> getAllPhotos(int r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            us.pinguo.common.db.b r2 = r6.dbDataBase     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.util.concurrent.locks.Lock r2 = r2.readLock()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r2.lock()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            us.pinguo.common.db.b r2 = r6.dbDataBase     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r2 != 0) goto L21
            us.pinguo.common.db.b r7 = r6.dbDataBase
            java.util.concurrent.locks.Lock r7 = r7.readLock()
            r7.unlock()
            return r0
        L21:
            us.pinguo.common.db.d r3 = new us.pinguo.common.db.d     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r3.<init>()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            us.pinguo.common.db.f r4 = r6.photoTableDefinition     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r4 = r4.a     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r3.d(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r4.<init>()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r5 = "_id in  (SELECT photoID FROM "
            r4.append(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            us.pinguo.common.db.f r5 = r6.galleryPhotoRelationTableDefinition     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r5 = r5.a     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r4.append(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r5 = " WHERE "
            r4.append(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r5 = "galleryID"
            r4.append(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r5 = " = ?)"
            r4.append(r5)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r3.g(r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.String r3 = r3.c()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r5 = 0
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r4[r5] = r7     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            android.database.Cursor r1 = r2.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r1 == 0) goto L83
            boolean r7 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r7 == 0) goto L83
        L6e:
            us.pinguo.common.db.k<us.pinguo.bigalbum.entity.Photo> r7 = r6.photoTypeAdapter     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            us.pinguo.common.db.f r2 = r6.photoTableDefinition     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.util.List<us.pinguo.common.db.f$c> r2 = r2.b     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            java.lang.Object r7 = r7.d(r1, r2)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            us.pinguo.bigalbum.entity.Photo r7 = (us.pinguo.bigalbum.entity.Photo) r7     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            r0.add(r7)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            boolean r7 = r1.moveToNext()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L91
            if (r7 != 0) goto L6e
        L83:
            us.pinguo.common.db.b r7 = r6.dbDataBase
            java.util.concurrent.locks.Lock r7 = r7.readLock()
            r7.unlock()
            if (r1 == 0) goto La3
            goto La0
        L8f:
            r7 = move-exception
            goto La4
        L91:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L8f
            us.pinguo.common.db.b r7 = r6.dbDataBase
            java.util.concurrent.locks.Lock r7 = r7.readLock()
            r7.unlock()
            if (r1 == 0) goto La3
        La0:
            r1.close()
        La3:
            return r0
        La4:
            us.pinguo.common.db.b r0 = r6.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            if (r1 == 0) goto Lb2
            r1.close()
        Lb2:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbGalleryTableModel.getAllPhotos(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x008e, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a0, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a2, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<java.lang.Integer> getAllPhotosSystemDbIds(int r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            us.pinguo.common.db.b r2 = r7.dbDataBase     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.util.concurrent.locks.Lock r2 = r2.readLock()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r2.lock()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            us.pinguo.common.db.b r2 = r7.dbDataBase     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            if (r2 != 0) goto L21
            us.pinguo.common.db.b r8 = r7.dbDataBase
            java.util.concurrent.locks.Lock r8 = r8.readLock()
            r8.unlock()
            return r0
        L21:
            us.pinguo.common.db.d r3 = new us.pinguo.common.db.d     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r3.<init>()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            us.pinguo.common.db.f r4 = r7.photoTableDefinition     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r5 = r4.a     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r6 = "systemDbID"
            java.util.List r4 = r4.c(r6)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r3.e(r5, r4)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r4.<init>()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r5 = "_id in  (SELECT photoID FROM "
            r4.append(r5)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            us.pinguo.common.db.f r5 = r7.galleryPhotoRelationTableDefinition     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r5 = r5.a     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r4.append(r5)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r5 = " WHERE "
            r4.append(r5)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r5 = "galleryID"
            r4.append(r5)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r5 = " = ?)"
            r4.append(r5)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r3.g(r4)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r3 = r3.c()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            android.database.Cursor r1 = r2.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            if (r1 == 0) goto L85
            boolean r8 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            if (r8 == 0) goto L85
        L74:
            int r8 = r1.getInt(r5)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r0.add(r8)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            boolean r8 = r1.moveToNext()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            if (r8 != 0) goto L74
        L85:
            us.pinguo.common.db.b r8 = r7.dbDataBase
            java.util.concurrent.locks.Lock r8 = r8.readLock()
            r8.unlock()
            if (r1 == 0) goto La5
            goto La2
        L91:
            r8 = move-exception
            goto La6
        L93:
            r8 = move-exception
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L91
            us.pinguo.common.db.b r8 = r7.dbDataBase
            java.util.concurrent.locks.Lock r8 = r8.readLock()
            r8.unlock()
            if (r1 == 0) goto La5
        La2:
            r1.close()
        La5:
            return r0
        La6:
            us.pinguo.common.db.b r0 = r7.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            if (r1 == 0) goto Lb4
            r1.close()
        Lb4:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbGalleryTableModel.getAllPhotosSystemDbIds(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0055, code lost:
        if (r12 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
        if (r12 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARN: Type inference failed for: r12v0, types: [int] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public us.pinguo.bigalbum.entity.Gallery getGallery(int r12) {
        /*
            r11 = this;
            r0 = 0
            us.pinguo.common.db.b r1 = r11.dbDataBase     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            r1.lock()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            us.pinguo.common.db.b r1 = r11.dbDataBase     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            if (r2 != 0) goto L1c
            us.pinguo.common.db.b r12 = r11.dbDataBase
            java.util.concurrent.locks.Lock r12 = r12.readLock()
            r12.unlock()
            return r0
        L1c:
            us.pinguo.common.db.f r1 = r11.galleryTableDefinition     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            java.lang.String r3 = r1.a     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            r4 = 0
            java.lang.String r5 = "_id = ?"
            r1 = 1
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            r1 = 0
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            r6[r1] = r12     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            if (r12 == 0) goto L4c
            boolean r1 = r12.moveToFirst()     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L72
            if (r1 == 0) goto L4c
            us.pinguo.common.db.k<us.pinguo.bigalbum.entity.Gallery> r1 = r11.galleryTypeAdapter     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L72
            us.pinguo.common.db.f r2 = r11.galleryTableDefinition     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L72
            java.util.List<us.pinguo.common.db.f$c> r2 = r2.b     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L72
            java.lang.Object r1 = r1.d(r12, r2)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L72
            us.pinguo.bigalbum.entity.Gallery r1 = (us.pinguo.bigalbum.entity.Gallery) r1     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L72
            r0 = r1
            goto L4c
        L4a:
            r1 = move-exception
            goto L62
        L4c:
            us.pinguo.common.db.b r1 = r11.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            if (r12 == 0) goto L71
        L57:
            r12.close()
            goto L71
        L5b:
            r12 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L73
        L60:
            r1 = move-exception
            r12 = r0
        L62:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L72
            us.pinguo.common.db.b r1 = r11.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            if (r12 == 0) goto L71
            goto L57
        L71:
            return r0
        L72:
            r0 = move-exception
        L73:
            us.pinguo.common.db.b r1 = r11.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            if (r12 == 0) goto L81
            r12.close()
        L81:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbGalleryTableModel.getGallery(int):us.pinguo.bigalbum.entity.Gallery");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
        r14 = r1.query(r13.photoTableDefinition.a, null, "_id = ?", new java.lang.String[]{java.lang.String.valueOf(r2)}, null, null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0083, code lost:
        if (r14 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009c, code lost:
        if (r14 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009f, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARN: Type inference failed for: r14v0, types: [int] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public us.pinguo.bigalbum.entity.Photo getGalleryCoverPhoto(int r14) {
        /*
            r13 = this;
            r0 = 0
            us.pinguo.common.db.b r1 = r13.dbDataBase     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            r1.lock()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            us.pinguo.common.db.b r1 = r13.dbDataBase     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            if (r1 != 0) goto L1c
            us.pinguo.common.db.b r14 = r13.dbDataBase
            java.util.concurrent.locks.Lock r14 = r14.readLock()
            r14.unlock()
            return r0
        L1c:
            us.pinguo.common.db.f r2 = r13.galleryTableDefinition     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            java.lang.String r3 = r2.a     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            java.lang.String r2 = "coverPhotoId"
            java.lang.String[] r4 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            java.lang.String r5 = "_id = ?"
            r10 = 1
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            r11 = 0
            r6[r11] = r14     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r1
            android.database.Cursor r14 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L8e
            if (r14 == 0) goto L7a
            boolean r2 = r14.moveToFirst()     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            if (r2 == 0) goto L7a
            int r2 = r14.getInt(r11)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            r14.close()     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            if (r2 < 0) goto L7a
            us.pinguo.common.db.f r3 = r13.photoTableDefinition     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            java.lang.String r3 = r3.a     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            r4 = 0
            java.lang.String r5 = "_id = ?"
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            r6[r11] = r2     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r1
            android.database.Cursor r14 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            if (r14 == 0) goto L7a
            boolean r1 = r14.moveToFirst()     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            if (r1 == 0) goto L7a
            us.pinguo.common.db.k<us.pinguo.bigalbum.entity.Photo> r1 = r13.photoTypeAdapter     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            us.pinguo.common.db.f r2 = r13.photoTableDefinition     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            java.util.List<us.pinguo.common.db.f$c> r2 = r2.b     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            java.lang.Object r1 = r1.d(r14, r2)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            us.pinguo.bigalbum.entity.Photo r1 = (us.pinguo.bigalbum.entity.Photo) r1     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> La0
            r0 = r1
            goto L7a
        L78:
            r1 = move-exception
            goto L90
        L7a:
            us.pinguo.common.db.b r1 = r13.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            if (r14 == 0) goto L9f
        L85:
            r14.close()
            goto L9f
        L89:
            r14 = move-exception
            r12 = r0
            r0 = r14
            r14 = r12
            goto La1
        L8e:
            r1 = move-exception
            r14 = r0
        L90:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> La0
            us.pinguo.common.db.b r1 = r13.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            if (r14 == 0) goto L9f
            goto L85
        L9f:
            return r0
        La0:
            r0 = move-exception
        La1:
            us.pinguo.common.db.b r1 = r13.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            if (r14 == 0) goto Laf
            r14.close()
        Laf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbGalleryTableModel.getGalleryCoverPhoto(int):us.pinguo.bigalbum.entity.Photo");
    }

    public void insert(List<DataPair<Gallery, List<Integer>>> list) {
        SQLiteDatabase writableDatabase;
        if (list == null || list.isEmpty()) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                this.dbDataBase.writeLock().lock();
                writableDatabase = this.dbDataBase.getWritableDatabase();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (writableDatabase == null) {
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
            this.dbDataBase.writeLock().unlock();
            return;
        }
        try {
            writableDatabase.beginTransaction();
            for (DataPair<Gallery, List<Integer>> dataPair : list) {
                Gallery gallery = dataPair.data1;
                List<Integer> list2 = dataPair.data2;
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", gallery.name);
                contentValues.put("createDate", Long.valueOf(gallery.createDate));
                contentValues.put("status", Integer.valueOf(gallery.status));
                contentValues.put("flags", Integer.valueOf(gallery.flags));
                contentValues.put(BigAlbumStore.GalleryColumns.COVER_PHOTO_ID, Integer.valueOf(gallery.coverPhotoId));
                contentValues.put("systemBucketID", Integer.valueOf(gallery.systemBucketID));
                contentValues.put(BigAlbumStore.GalleryColumns.IS_PRESET, Integer.valueOf(gallery.isPreset ? 1 : 0));
                int intValue = Long.valueOf(writableDatabase.insert(this.galleryTableDefinition.a, null, contentValues)).intValue();
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(BigAlbumStore.GalleryPhotoRelationsColumns.GALLERY_ID, Integer.valueOf(intValue));
                for (Integer num : list2) {
                    contentValues2.put("photoID", num);
                    writableDatabase.insert(this.galleryPhotoRelationTableDefinition.a, null, contentValues2);
                }
            }
            writableDatabase.setTransactionSuccessful();
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase = writableDatabase;
            e.printStackTrace();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.dbDataBase.writeLock().unlock();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.dbDataBase.writeLock().unlock();
            throw th;
        }
        this.dbDataBase.writeLock().unlock();
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        SQLiteDatabase readableDatabase;
        Cursor cursor = null;
        try {
            try {
                this.dbDataBase.readLock().lock();
                readableDatabase = this.dbDataBase.getReadableDatabase();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (readableDatabase == null) {
                return null;
            }
            cursor = readableDatabase.query(this.galleryTableDefinition.a, strArr, str, strArr2, str2, str3, str4);
            return cursor;
        } finally {
            this.dbDataBase.readLock().unlock();
        }
    }

    public boolean update(int i2, ContentValues contentValues) {
        try {
            this.dbDataBase.writeLock().lock();
            SQLiteDatabase writableDatabase = this.dbDataBase.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            writableDatabase.update(this.galleryTableDefinition.a, contentValues, "_id = ?", new String[]{String.valueOf(i2)});
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        } finally {
            this.dbDataBase.writeLock().unlock();
        }
    }

    public boolean update(String str, String[] strArr, ContentValues contentValues) {
        try {
            this.dbDataBase.writeLock().lock();
            SQLiteDatabase writableDatabase = this.dbDataBase.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            writableDatabase.update(this.galleryTableDefinition.a, contentValues, str, strArr);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        } finally {
            this.dbDataBase.writeLock().unlock();
        }
    }

    public boolean update(Gallery gallery) {
        ContentValues e2 = this.galleryTypeAdapter.e(gallery, this.galleryTableDefinition.c);
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[e2.size()];
        g.constructWhere(e2, sb, strArr);
        try {
            this.dbDataBase.writeLock().lock();
            SQLiteDatabase writableDatabase = this.dbDataBase.getWritableDatabase();
            if (writableDatabase == null) {
                return false;
            }
            f fVar = this.galleryTableDefinition;
            writableDatabase.update(fVar.a, this.galleryTypeAdapter.e(gallery, fVar.f9785e), sb.toString(), strArr);
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        } finally {
            this.dbDataBase.writeLock().unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (0 == 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        r0.endTransaction();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void delete(int r4) {
        /*
            r3 = this;
            r0 = 0
            us.pinguo.common.db.b r1 = r3.dbDataBase     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            java.util.concurrent.locks.Lock r1 = r1.writeLock()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r1.lock()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            us.pinguo.common.db.b r1 = r3.dbDataBase     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r0 != 0) goto L21
            if (r0 == 0) goto L17
            r0.endTransaction()     // Catch: java.lang.Exception -> L17
        L17:
            us.pinguo.common.db.b r4 = r3.dbDataBase
            java.util.concurrent.locks.Lock r4 = r4.writeLock()
            r4.unlock()
            return
        L21:
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r2 = 0
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r1[r2] = r4     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            us.pinguo.common.db.f r4 = r3.galleryPhotoRelationTableDefinition     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            java.lang.String r4 = r4.a     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            java.lang.String r2 = "galleryID = ? "
            r0.delete(r4, r2, r1)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            us.pinguo.common.db.f r4 = r3.galleryTableDefinition     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            java.lang.String r4 = r4.a     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            java.lang.String r2 = "_id = ? "
            r0.delete(r4, r2, r1)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r0 == 0) goto L51
            goto L4e
        L46:
            r4 = move-exception
            goto L5b
        L48:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L51
        L4e:
            r0.endTransaction()     // Catch: java.lang.Exception -> L51
        L51:
            us.pinguo.common.db.b r4 = r3.dbDataBase
            java.util.concurrent.locks.Lock r4 = r4.writeLock()
            r4.unlock()
            return
        L5b:
            if (r0 == 0) goto L60
            r0.endTransaction()     // Catch: java.lang.Exception -> L60
        L60:
            us.pinguo.common.db.b r0 = r3.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.writeLock()
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbGalleryTableModel.delete(int):void");
    }

    public void insert(Gallery gallery, List<Integer> list) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                try {
                    this.dbDataBase.writeLock().lock();
                    writableDatabase = this.dbDataBase.getWritableDatabase();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused) {
        }
        if (writableDatabase == null) {
            if (writableDatabase != null) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception unused2) {
                }
            }
            this.dbDataBase.writeLock().unlock();
            return;
        }
        try {
            writableDatabase.beginTransaction();
            int intValue = Long.valueOf(writableDatabase.insert(this.galleryTableDefinition.a, null, this.galleryTypeAdapter.e(gallery, this.galleryTableDefinition.f9785e))).intValue();
            ContentValues contentValues = new ContentValues();
            contentValues.put(BigAlbumStore.GalleryPhotoRelationsColumns.GALLERY_ID, Integer.valueOf(intValue));
            for (Integer num : list) {
                contentValues.put("photoID", num);
                writableDatabase.insert(this.galleryPhotoRelationTableDefinition.a, null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase = writableDatabase;
            e.printStackTrace();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            this.dbDataBase.writeLock().unlock();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception unused3) {
                }
            }
            this.dbDataBase.writeLock().unlock();
            throw th;
        }
        if (writableDatabase != null) {
            writableDatabase.endTransaction();
        }
        this.dbDataBase.writeLock().unlock();
    }
}
