package us.pinguo.bigalbum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import us.pinguo.bigalbum.entity.Gallery;
import us.pinguo.bigalbum.entity.Photo;
import us.pinguo.bigalbum.entity.PhotoAddress;
import us.pinguo.bigalbum.entity.PhotoTag;
/* loaded from: classes3.dex */
public class BigAlbumManager implements IBigAlbumObserver {
    private static volatile BigAlbumManager instance;
    private IBigAlbumModel mBigAlbumModel;
    private final WeakHashMap<BigAlbumObserver, Object> mBigAlbumObservers = new WeakHashMap<>();
    private BigAlbumThread mBigAlbumThread;
    private volatile boolean mInit;
    private volatile boolean mScaning;

    private BigAlbumManager() {
    }

    public static BigAlbumManager instance() {
        if (instance == null) {
            synchronized (BigAlbumManager.class) {
                if (instance == null) {
                    instance = new BigAlbumManager();
                }
            }
        }
        return instance;
    }

    public void addPhotoToGallery(int i2, List<Integer> list) {
        try {
            checkInit();
            this.mBigAlbumModel.addPhotoToGallery(i2, list);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void addPhotoToGalleryAsync(final int i2, final List<Integer> list) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.14
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.addPhotoToGallery(i2, list);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void checkInit() throws BigAlbumInitException {
        if (!this.mInit) {
            throw new BigAlbumInitException("BigAlbumManager must init first");
        }
    }

    public void commitMapGallery() {
        try {
            checkInit();
            this.mBigAlbumModel.commitMapGallery();
        } catch (BigAlbumInitException unused) {
        }
    }

    public void deleteGallery(int i2) {
        try {
            checkInit();
            this.mBigAlbumModel.deleteGallery(i2);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void deleteGalleryAsync(final int i2) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.11
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.deleteGallery(i2);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void deletePhoto(int i2) {
        try {
            checkInit();
            this.mBigAlbumModel.deletePhoto(i2);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void deletePhotoAsync(final int i2) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.3
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.deletePhoto(i2);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void deletePhotoBySystemDbId(int i2) {
        try {
            checkInit();
            this.mBigAlbumModel.deletePhotoBySystemDbId(i2);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void deletePhotoBySystemIdAsync(final int i2) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.4
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.deletePhotoBySystemDbId(i2);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void deletePhotoFromGallery(int i2, List<Integer> list) {
        try {
            checkInit();
            this.mBigAlbumModel.deletePhotoFromGallery(i2, list);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void deletePhotoFromGalleryAsync(final int i2, final List<Integer> list) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.13
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.deletePhotoFromGallery(i2, list);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public Photo[] getFirstFavAndLocalPhoto() {
        try {
            checkInit();
            return this.mBigAlbumModel.getFirstFavAndLocalPhoto();
        } catch (BigAlbumInitException unused) {
            return new Photo[2];
        }
    }

    public Gallery getGallery(int i2) {
        try {
            checkInit();
            return this.mBigAlbumModel.getGallery(i2);
        } catch (BigAlbumInitException unused) {
            return null;
        }
    }

    public Photo getGalleryCoverPhoto(int i2) {
        try {
            checkInit();
            return this.mBigAlbumModel.getGalleryCoverPhoto(i2);
        } catch (BigAlbumInitException unused) {
            return null;
        }
    }

    public Photo getPhoto(int i2) {
        try {
            checkInit();
            return this.mBigAlbumModel.getPhoto(i2);
        } catch (BigAlbumInitException unused) {
            return null;
        }
    }

    public List<Photo> getPhotosOrderBy(String str) {
        try {
            checkInit();
            return this.mBigAlbumModel.getPhotosOrderBy(str);
        } catch (BigAlbumInitException unused) {
            return new ArrayList();
        }
    }

    public synchronized void init(Context context, BigAlbumConfig bigAlbumConfig) {
        if (this.mInit) {
            return;
        }
        BigAlbumThread bigAlbumThread = new BigAlbumThread();
        this.mBigAlbumThread = bigAlbumThread;
        bigAlbumThread.start();
        LocalBigAlbumModel localBigAlbumModel = new LocalBigAlbumModel(context, bigAlbumConfig, this);
        this.mBigAlbumModel = localBigAlbumModel;
        localBigAlbumModel.init(this.mBigAlbumThread.getBigAlbumHandler());
        this.mScaning = true;
        this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.1
            @Override // java.lang.Runnable
            public void run() {
                BigAlbumManager.this.mBigAlbumModel.scan();
                BigAlbumManager.this.mScaning = false;
                synchronized (BigAlbumManager.this) {
                    BigAlbumManager.this.notifyAll();
                }
            }
        });
        this.mInit = true;
    }

    public void insertGallery(Gallery gallery, List<Integer> list) {
        try {
            checkInit();
            this.mBigAlbumModel.insertGallery(gallery, list);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void insertGalleryAsync(final Gallery gallery, final List<Integer> list) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.10
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.insertGallery(gallery, list);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void insertPhotoAddress(List<PhotoAddress> list) {
        try {
            checkInit();
            this.mBigAlbumModel.insertPhotoAddress(list);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void insertPhotoAddressAsync(final List<PhotoAddress> list) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.15
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.insertPhotoAddress(list);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void insertPhotoAsync(final Photo photo) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.8
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.insertPhoto(photo);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void insertPhotoTag(List<PhotoTag> list) {
        try {
            checkInit();
            this.mBigAlbumModel.insertPhotoTag(list);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void insertPhotoTagAsync(final List<PhotoTag> list) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.16
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.insertPhotoTag(list);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public boolean isAlreadyMapGallery() {
        try {
            checkInit();
            return this.mBigAlbumModel.isAlreadyMapGallery();
        } catch (BigAlbumInitException unused) {
            return true;
        }
    }

    public boolean isScaning() {
        return this.mScaning;
    }

    @Override // us.pinguo.bigalbum.IBigAlbumObserver
    public void onChange(String str) {
        synchronized (this.mBigAlbumObservers) {
            for (BigAlbumObserver bigAlbumObserver : this.mBigAlbumObservers.keySet()) {
                bigAlbumObserver.onChange(str);
            }
        }
    }

    public Cursor queryGallery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        try {
            checkInit();
            return this.mBigAlbumModel.queryGallery(strArr, str, strArr2, str2, str3, str4);
        } catch (BigAlbumInitException unused) {
            return null;
        }
    }

    public Cursor queryPhoto(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        try {
            checkInit();
            return this.mBigAlbumModel.queryPhoto(strArr, str, strArr2, str2, str3, str4);
        } catch (BigAlbumInitException unused) {
            return null;
        }
    }

    public void registerObserver(BigAlbumObserver bigAlbumObserver) {
        if (bigAlbumObserver == null) {
            return;
        }
        synchronized (this.mBigAlbumObservers) {
            this.mBigAlbumObservers.put(bigAlbumObserver, null);
        }
    }

    public void rollbackMapGallery() {
        try {
            checkInit();
            this.mBigAlbumModel.rollbackMapGallery();
        } catch (BigAlbumInitException unused) {
        }
    }

    public void syncSystemAsync(final boolean z, final IBigAlbumSyncListener iBigAlbumSyncListener) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.2
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.syncSystem(z);
                    IBigAlbumSyncListener iBigAlbumSyncListener2 = iBigAlbumSyncListener;
                    if (iBigAlbumSyncListener2 != null) {
                        iBigAlbumSyncListener2.onSyncDone();
                    }
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updateGallery(int i2, ContentValues contentValues) {
        try {
            checkInit();
            this.mBigAlbumModel.updateGallery(i2, contentValues);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updateGalleryAsync(final int i2, final ContentValues contentValues) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.9
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.updateGallery(i2, contentValues);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updatePhoto(Photo photo) {
        updatePhoto(photo, true);
    }

    public void updatePhotoAsync(Photo photo) {
        updatePhotoAsync(photo, true);
    }

    public void updatePhoto(ContentValues contentValues, String str, String[] strArr) {
        updatePhoto(contentValues, str, strArr, true);
    }

    public void updatePhotoAsync(ContentValues contentValues, String str, String[] strArr) {
        updatePhotoAsync(contentValues, str, strArr, true);
    }

    public void updateGallery(Gallery gallery) {
        try {
            checkInit();
            this.mBigAlbumModel.updateGallery(gallery);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updateGalleryAsync(final Gallery gallery) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.12
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.updateGallery(gallery);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updatePhoto(int i2, ContentValues contentValues) {
        updatePhoto(i2, contentValues, true);
    }

    public void updatePhotoAsync(int i2, ContentValues contentValues) {
        updatePhotoAsync(i2, contentValues, true);
    }

    public void updatePhoto(Photo photo, boolean z) {
        try {
            checkInit();
            this.mBigAlbumModel.updatePhoto(photo, z);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updatePhotoAsync(final Photo photo, final boolean z) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.5
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.updatePhoto(photo, z);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updatePhoto(ContentValues contentValues, String str, String[] strArr, boolean z) {
        try {
            checkInit();
            this.mBigAlbumModel.updatePhoto(contentValues, str, strArr, z);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updatePhotoAsync(final ContentValues contentValues, final String str, final String[] strArr, final boolean z) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.6
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.updatePhoto(contentValues, str, strArr, z);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updatePhoto(int i2, ContentValues contentValues, boolean z) {
        try {
            checkInit();
            this.mBigAlbumModel.updatePhoto(i2, contentValues, z);
        } catch (BigAlbumInitException unused) {
        }
    }

    public void updatePhotoAsync(final int i2, final ContentValues contentValues, final boolean z) {
        try {
            checkInit();
            this.mBigAlbumThread.runTask(new Runnable() { // from class: us.pinguo.bigalbum.BigAlbumManager.7
                @Override // java.lang.Runnable
                public void run() {
                    BigAlbumManager.this.mBigAlbumModel.updatePhoto(i2, contentValues, z);
                }
            });
        } catch (BigAlbumInitException unused) {
        }
    }
}
