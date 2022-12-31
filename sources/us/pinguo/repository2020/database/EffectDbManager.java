package us.pinguo.repository2020.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.database.filter.FilterItemTable;
import us.pinguo.repository2020.database.filter.FilterPackageTable;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
import us.pinguo.repository2020.database.makeup.MaterialDetailTable;
import us.pinguo.repository2020.database.makeup.MaterialItemTable;
import us.pinguo.repository2020.database.paint.PaintMaterialTable;
import us.pinguo.repository2020.database.staticsticker.BackgroundBlurMaterialTable;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategoryTable;
import us.pinguo.repository2020.database.staticsticker.StaticStickerTable;
import us.pinguo.repository2020.database.sticker.StickerItemTable;
import us.pinguo.repository2020.database.sticker.StickerTable;
/* compiled from: EffectDbManager.kt */
@Database(entities = {FilterParamsTable.class, FilterPackageTable.class, FilterItemTable.class, StickerTable.class, StickerItemTable.class, MaterialDetailTable.class, MaterialItemTable.class, PaintMaterialTable.class, us.pinguo.repository2020.database.b.c.class, StaticStickerTable.class, StaticStickerCategoryTable.class, us.pinguo.repository2020.database.staticsticker.k.class, BackgroundBlurMaterialTable.class}, exportSchema = false, version = 15)
/* loaded from: classes6.dex */
public abstract class EffectDbManager extends RoomDatabase {
    private static volatile boolean o;
    public static final n a = new n(null);
    private static final f b = new f();
    private static final g c = new g();

    /* renamed from: d  reason: collision with root package name */
    private static final h f11821d = new h();

    /* renamed from: e  reason: collision with root package name */
    private static final i f11822e = new i();

    /* renamed from: f  reason: collision with root package name */
    private static final j f11823f = new j();

    /* renamed from: g  reason: collision with root package name */
    private static final k f11824g = new k();

    /* renamed from: h  reason: collision with root package name */
    private static final l f11825h = new l();

    /* renamed from: i  reason: collision with root package name */
    private static final m f11826i = new m();

    /* renamed from: j  reason: collision with root package name */
    private static final a f11827j = new a();

    /* renamed from: k  reason: collision with root package name */
    private static final b f11828k = new b();

    /* renamed from: l  reason: collision with root package name */
    private static final c f11829l = new c();
    private static final d m = new d();
    private static final e n = new e();
    private static final Object p = new Object();

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class a extends Migration {
        a() {
            super(10, 11);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("CREATE TABLE filter_history(_aid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,filterId TEXT NOT NULL,packageId TEXT NOT NULL,position TEXT NOT NULL,number INTEGER NOT NULL)");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class b extends Migration {
        b() {
            super(11, 12);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("CREATE TABLE downloaded_static_sticker(sid TEXT PRIMARY KEY NOT NULL,name TEXT,icon TEXT,tags TEXT,display_md5 TEXT,down_url TEXT,fromTemplate INTEGER NOT NULL)");
            database.execSQL("CREATE TABLE downloaded_static_sticker_category(pid TEXT PRIMARY KEY NOT NULL,name TEXT,icon TEXT,store_icon TEXT,vip INTEGER,completed INTEGER)");
            database.execSQL("CREATE TABLE sticker_template_collection(tid TEXT PRIMARY KEY NOT NULL)");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class c extends Migration {
        c() {
            super(12, 13);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("CREATE TABLE background_blur_material(pid TEXT PRIMARY KEY NOT NULL,sid TEXT,name TEXT,icon TEXT,shape TEXT)");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class d extends Migration {
        d() {
            super(13, 14);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("ALTER TABLE category ADD COLUMN categoryId text NOT NULL DEFAULT ''");
            database.execSQL("ALTER TABLE category ADD COLUMN unity_engine_filter INTEGER");
            database.execSQL("ALTER TABLE category ADD COLUMN camera_support INTEGER");
            database.execSQL("ALTER TABLE item ADD COLUMN unity_engine_filter INTEGER");
            database.execSQL("ALTER TABLE item ADD COLUMN camera_support INTEGER");
            database.execSQL("ALTER TABLE item ADD COLUMN enableGesture INTEGER");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class e extends Migration {
        e() {
            super(14, 15);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("ALTER TABLE category ADD COLUMN tagContent INTEGER");
            database.execSQL("ALTER TABLE category ADD COLUMN tagOnTime INTEGER");
            database.execSQL("ALTER TABLE category ADD COLUMN tagOffTime INTEGER");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class f extends Migration {
        f() {
            super(2, 3);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("DELETE FROM item   WHERE _aid NOT IN (SELECT min(_aid) FROM item   GROUP BY id)");
            database.execSQL("DELETE FROM effect WHERE _aid NOT IN (SELECT min(_aid) FROM effect GROUP BY id)");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class g extends Migration {
        g() {
            super(3, 4);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class h extends Migration {
        h() {
            super(4, 5);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("ALTER TABLE effect ADD COLUMN supportPreview Integer");
            database.execSQL("ALTER TABLE effect ADD COLUMN version Integer");
            database.execSQL("ALTER TABLE effect ADD COLUMN skinParam REAL");
            database.execSQL("ALTER TABLE effect ADD COLUMN versionDir Text");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class i extends Migration {
        i() {
            super(5, 6);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("ALTER TABLE effect RENAME TO effectOld");
            database.execSQL("CREATE TABLE effect(_aid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,id TEXT,packageId TEXT,`key` TEXT,preCmd TEXT,gpuCmd TEXT,textureStr TEXT,paramStr TEXT,subType TEXT,supportPreview INTEGER,version INTEGER,skinParam TEXT,versionDir TEXT,onlineParam TEXT,temp1 TEXT,temp2 TEXT,temp3 TEXT,temp4 TEXT) ");
            database.execSQL("INSERT INTO effect(id,packageId,`key`,preCmd,gpuCmd,textureStr,paramStr,subType,supportPreview,version,skinParam,versionDir,onlineParam,temp1,temp2,temp3,temp4) SELECT id,packageId,`key`,preCmd,gpuCmd,textureStr,paramStr,subType,supportPreview,version,skinParam,versionDir,onlineParam,temp1,temp2,temp3,temp4 FROM effectOld");
            database.execSQL("DROP TABLE effectOld");
            database.execSQL("ALTER TABLE category RENAME TO categoryOld");
            database.execSQL("CREATE TABLE category(id TEXT PRIMARY KEY NOT NULL,namejson TEXT,filterType TEXT,subType TEXT,icon TEXT,sort INTEGER NOT NULL,displayMd5 TEXT,packageMd5 TEXT,temp1 TEXT,temp2 TEXT,temp3 TEXT,temp4 TEXT)");
            database.execSQL("INSERT INTO category(id,namejson,filterType,subType,icon,sort,displayMd5,packageMd5,temp1,temp2,temp3,temp4) SELECT id,namejson,filterType,subType,icon,sort,displayMd5,packageMd5,temp1,temp2,temp3,temp4 FROM categoryOld WHERE filterType!='unity' AND id IS NOT NULL");
            database.execSQL("DROP TABLE categoryOld");
            database.execSQL("ALTER TABLE item RENAME TO itemOld");
            database.execSQL("CREATE TABLE item(_aid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,id TEXT,namejson TEXT,icon TEXT,sortInPackage INTEGER,packageId TEXT,packageMd5 TEXT,isCollect INTEGER,collectTime INTEGER,hasMusic INTEGER,type TEXT,temp1 TEXT,temp2 TEXT,temp3 TEXT,temp4 TEXT,opacity INTEGER NOT NULL DEFAULT -1)");
            database.execSQL("INSERT INTO item(id,namejson,icon,sortInPackage,packageId,packageMd5,isCollect,collectTime,hasMusic,type,temp1,temp2,temp3,temp4) SELECT id,namejson,icon,sortInPackage,packageId,packageMd5,isCollect,collectTime,hasMusic,type,temp1,temp2,temp3,temp4 FROM itemOld WHERE type!='ut'");
            database.execSQL("DROP TABLE itemOld");
            database.execSQL("CREATE TABLE material_detail(id TEXT PRIMARY KEY NOT NULL,namejson TEXT,filterType TEXT,subType TEXT,icon TEXT,sort INTEGER NOT NULL,displayMd5 TEXT,packageMd5 TEXT,temp1 TEXT,temp2 TEXT,temp3 TEXT,temp4 TEXT)");
            database.execSQL("CREATE TABLE material_item(_aid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,id TEXT,namejson TEXT,icon TEXT,sortInPackage INTEGER,packageId TEXT,packageMd5 TEXT,isCollect INTEGER,collectTime INTEGER,hasMusic INTEGER,type TEXT,temp1 TEXT,temp2 TEXT,temp3 TEXT,temp4 TEXT)");
            database.execSQL("CREATE TABLE stickerPackage(id TEXT PRIMARY KEY NOT NULL,namejson TEXT,filterType TEXT DEFAULT 'unity',subType TEXT DEFAULT 'Filter',icon TEXT,sort INTEGER NOT NULL,displayMd5 TEXT,packageMd5 TEXT,temp1 TEXT,temp2 TEXT,temp3 TEXT,temp4 TEXT)");
            database.execSQL("CREATE TABLE stickerItem(_aid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,id TEXT,namejson TEXT,icon TEXT,sortInPackage INTEGER,packageId TEXT,packageMd5 TEXT,isCollect INTEGER DEFAULT 0,collectTime INTEGER,hasMusic INTEGER DEFAULT 0,type TEXT DEFAULT 'ut',temp1 TEXT,temp2 TEXT,temp3 TEXT,temp4 TEXT)");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class j extends Migration {
        j() {
            super(6, 7);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("CREATE TABLE paint_material( id TEXT PRIMARY KEY NOT NULL,icon TEXT , resourceFolderPath TEXT, resourceChildPath TEXT, autoAdjustPaintInterval INTEGER, brushSizeCalculateMode INTEGER, brushSourceType INTEGER, enableRandomSpriteIndex INTEGER, enableRotate INTEGER, paintIntervalRatio FLOAT,brushColor TEXT, enableFlow INTEGER, supportChangeColor INTEGER)");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class k extends Migration {
        k() {
            super(7, 8);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("ALTER TABLE paint_material ADD COLUMN brushSizeRatio FLOAT");
            database.execSQL("ALTER TABLE paint_material ADD COLUMN brushDisplaySizeRatio FLOAT");
            database.execSQL("ALTER TABLE paint_material ADD COLUMN brushDefaultEffectIntensity FLOAT");
            database.execSQL("ALTER TABLE paint_material ADD COLUMN brushEffectIntensity FLOAT");
            database.execSQL("ALTER TABLE paint_material ADD COLUMN resourceChildBlendMode TEXT");
            database.execSQL("ALTER TABLE paint_material ADD COLUMN brushBlendMode INTEGER");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class l extends Migration {
        l() {
            super(8, 9);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("DROP TABLE paint_material");
            database.execSQL("CREATE TABLE paint_material( id TEXT PRIMARY KEY NOT NULL,icon TEXT , resourceFolderPath TEXT, resourceChildPath TEXT, autoAdjustPaintInterval INTEGER, brushSizeCalculateMode INTEGER, brushSourceType INTEGER, enableRandomSpriteIndex INTEGER, enableRotate INTEGER, paintIntervalRatio FLOAT,brushColor TEXT, enableFlow INTEGER, supportChangeColor INTEGER,brushSizeRatio FLOAT,brushDisplaySizeRatio FLOAT,brushDefaultEffectIntensity FLOAT,brushEffectIntensity FLOAT,resourceChildBlendMode TEXT,brushBlendMode INTEGER)");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class m extends Migration {
        m() {
            super(9, 10);
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase database) {
            s.h(database, "database");
            database.execSQL("ALTER TABLE category ADD COLUMN vip INTEGER");
        }
    }

    /* compiled from: EffectDbManager.kt */
    /* loaded from: classes6.dex */
    public static final class n {
        private n() {
        }

        public /* synthetic */ n(o oVar) {
            this();
        }

        public final void a() {
            if (EffectDbManager.o) {
                return;
            }
            synchronized (EffectDbManager.p) {
                if (EffectDbManager.o) {
                    return;
                }
                RoomDatabase build = Room.databaseBuilder(us.pinguo.foundation.e.b(), EffectDbManager.class, "filter.db").addMigrations(EffectDbManager.b, EffectDbManager.c, EffectDbManager.f11821d, EffectDbManager.f11822e, EffectDbManager.f11823f, EffectDbManager.f11824g, EffectDbManager.f11825h, EffectDbManager.f11826i, EffectDbManager.f11827j, EffectDbManager.f11828k, EffectDbManager.f11829l, EffectDbManager.m, EffectDbManager.n).allowMainThreadQueries().build();
                s.g(build, "databaseBuilder(Foundati…                 .build()");
                us.pinguo.repository2020.database.a.b((EffectDbManager) build);
                n nVar = EffectDbManager.a;
                EffectDbManager.o = true;
                u uVar = u.a;
            }
        }
    }

    public abstract us.pinguo.repository2020.database.makeup.c A();

    public abstract us.pinguo.repository2020.database.paint.a B();

    public abstract us.pinguo.repository2020.database.staticsticker.e C();

    public abstract us.pinguo.repository2020.database.staticsticker.g D();

    public abstract us.pinguo.repository2020.database.staticsticker.i E();

    public abstract us.pinguo.repository2020.database.sticker.b F();

    public abstract us.pinguo.repository2020.database.sticker.e G();

    public abstract us.pinguo.repository2020.database.staticsticker.a u();

    public abstract us.pinguo.repository2020.database.b.a v();

    public abstract us.pinguo.repository2020.database.filter.a w();

    public abstract us.pinguo.repository2020.database.filter.c x();

    public abstract us.pinguo.repository2020.database.filter.e y();

    public abstract us.pinguo.repository2020.database.makeup.a z();
}
