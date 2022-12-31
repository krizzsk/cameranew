package us.pinguo.repository2020.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.pinguo.camera360.effect.model.entity.type.Frame;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.repository2020.database.filter.c;
import us.pinguo.repository2020.database.makeup.d;
import us.pinguo.repository2020.database.staticsticker.e;
import us.pinguo.repository2020.database.staticsticker.f;
import us.pinguo.repository2020.database.staticsticker.g;
import us.pinguo.repository2020.database.staticsticker.h;
import us.pinguo.repository2020.database.staticsticker.i;
import us.pinguo.repository2020.database.staticsticker.j;
import us.pinguo.repository2020.database.sticker.b;
/* loaded from: classes6.dex */
public final class EffectDbManager_Impl extends EffectDbManager {
    private volatile e A;
    private volatile i B;
    private volatile us.pinguo.repository2020.database.staticsticker.a C;
    private volatile c q;
    private volatile us.pinguo.repository2020.database.filter.a r;
    private volatile us.pinguo.repository2020.database.filter.e s;
    private volatile us.pinguo.repository2020.database.sticker.e t;
    private volatile b u;
    private volatile us.pinguo.repository2020.database.makeup.a v;
    private volatile us.pinguo.repository2020.database.makeup.c w;
    private volatile us.pinguo.repository2020.database.paint.a x;
    private volatile us.pinguo.repository2020.database.b.a y;
    private volatile g z;

    /* loaded from: classes6.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int i2) {
            super(i2);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `effect` (`_aid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `packageId` TEXT, `key` TEXT, `preCmd` TEXT, `gpuCmd` TEXT, `textureStr` TEXT, `paramStr` TEXT, `subType` TEXT, `supportPreview` INTEGER, `version` INTEGER, `skinParam` TEXT, `versionDir` TEXT, `onlineParam` TEXT, `temp1` TEXT, `temp2` TEXT, `temp3` TEXT, `temp4` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `category` (`categoryId` TEXT NOT NULL DEFAULT '', `id` TEXT NOT NULL, `namejson` TEXT, `filterType` TEXT, `subType` TEXT, `icon` TEXT, `sort` INTEGER NOT NULL, `displayMd5` TEXT, `packageMd5` TEXT, `vip` INTEGER, `unity_engine_filter` INTEGER, `camera_support` INTEGER, `tagContent` INTEGER, `tagOnTime` INTEGER, `tagOffTime` INTEGER, `temp1` TEXT, `temp2` TEXT, `temp3` TEXT, `temp4` TEXT, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `item` (`_aid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `namejson` TEXT, `icon` TEXT, `sortInPackage` INTEGER, `packageId` TEXT, `packageMd5` TEXT, `isCollect` INTEGER, `collectTime` INTEGER, `hasMusic` INTEGER, `opacity` INTEGER NOT NULL DEFAULT -1, `type` TEXT, `unity_engine_filter` INTEGER, `camera_support` INTEGER, `enableGesture` INTEGER, `temp1` TEXT, `temp2` TEXT, `temp3` TEXT, `temp4` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stickerPackage` (`id` TEXT NOT NULL, `namejson` TEXT, `filterType` TEXT DEFAULT 'unity', `subType` TEXT DEFAULT 'Filter', `icon` TEXT, `sort` INTEGER NOT NULL, `displayMd5` TEXT, `packageMd5` TEXT, `temp1` TEXT, `temp2` TEXT, `temp3` TEXT, `temp4` TEXT, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `stickerItem` (`_aid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `namejson` TEXT, `icon` TEXT, `sortInPackage` INTEGER, `packageId` TEXT, `packageMd5` TEXT, `isCollect` INTEGER DEFAULT 0, `collectTime` INTEGER, `hasMusic` INTEGER DEFAULT 0, `type` TEXT DEFAULT 'ut', `temp1` TEXT, `temp2` TEXT, `temp3` TEXT, `temp4` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `material_detail` (`id` TEXT NOT NULL, `namejson` TEXT, `packageMd5` TEXT, `subType` TEXT, `icon` TEXT, `sort` INTEGER NOT NULL, `displayMd5` TEXT, `filterType` TEXT, `temp1` TEXT, `temp2` TEXT, `temp3` TEXT, `temp4` TEXT, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `material_item` (`_aid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` TEXT, `namejson` TEXT, `icon` TEXT, `sortInPackage` INTEGER, `packageId` TEXT, `packageMd5` TEXT, `isCollect` INTEGER, `collectTime` INTEGER, `hasMusic` INTEGER, `type` TEXT, `temp1` TEXT, `temp2` TEXT, `temp3` TEXT, `temp4` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `paint_material` (`id` TEXT NOT NULL, `icon` TEXT, `resourceFolderPath` TEXT, `resourceChildPath` TEXT, `resourceChildBlendMode` TEXT, `autoAdjustPaintInterval` INTEGER, `brushSizeCalculateMode` INTEGER, `brushSourceType` INTEGER, `enableRandomSpriteIndex` INTEGER, `enableRotate` INTEGER, `paintIntervalRatio` REAL, `brushDefaultEffectIntensity` REAL, `brushEffectIntensity` REAL, `brushSizeRatio` REAL, `brushDisplaySizeRatio` REAL, `brushColor` TEXT, `enableFlow` INTEGER, `brushBlendMode` INTEGER, `supportChangeColor` INTEGER, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `filter_history` (`_aid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `filterId` TEXT NOT NULL, `packageId` TEXT NOT NULL, `position` TEXT NOT NULL, `number` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `downloaded_static_sticker` (`sid` TEXT NOT NULL, `name` TEXT, `icon` TEXT, `tags` TEXT, `display_md5` TEXT, `down_url` TEXT, `fromTemplate` INTEGER NOT NULL, PRIMARY KEY(`sid`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `downloaded_static_sticker_category` (`pid` TEXT NOT NULL, `name` TEXT, `icon` TEXT, `store_icon` TEXT, `vip` INTEGER, `completed` INTEGER, PRIMARY KEY(`pid`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `sticker_template_collection` (`tid` TEXT NOT NULL, PRIMARY KEY(`tid`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `background_blur_material` (`pid` TEXT NOT NULL, `sid` TEXT, `name` TEXT, `icon` TEXT, `shape` TEXT, PRIMARY KEY(`pid`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '873b63fc6d43674b412fc7a08d3c5dd6')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `effect`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `category`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `item`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `stickerPackage`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `stickerItem`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `material_detail`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `material_item`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `paint_material`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `filter_history`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `downloaded_static_sticker`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `downloaded_static_sticker_category`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `sticker_template_collection`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `background_blur_material`");
            if (((RoomDatabase) EffectDbManager_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) EffectDbManager_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) EffectDbManager_Impl.this).mCallbacks.get(i2)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (((RoomDatabase) EffectDbManager_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) EffectDbManager_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) EffectDbManager_Impl.this).mCallbacks.get(i2)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            ((RoomDatabase) EffectDbManager_Impl.this).mDatabase = supportSQLiteDatabase;
            EffectDbManager_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (((RoomDatabase) EffectDbManager_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) EffectDbManager_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) EffectDbManager_Impl.this).mCallbacks.get(i2)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap hashMap = new HashMap(18);
            hashMap.put("_aid", new TableInfo.Column("_aid", "INTEGER", true, 1, null, 1));
            hashMap.put(TapjoyAuctionFlags.AUCTION_ID, new TableInfo.Column(TapjoyAuctionFlags.AUCTION_ID, "TEXT", false, 0, null, 1));
            hashMap.put("packageId", new TableInfo.Column("packageId", "TEXT", false, 0, null, 1));
            hashMap.put("key", new TableInfo.Column("key", "TEXT", false, 0, null, 1));
            hashMap.put("preCmd", new TableInfo.Column("preCmd", "TEXT", false, 0, null, 1));
            hashMap.put("gpuCmd", new TableInfo.Column("gpuCmd", "TEXT", false, 0, null, 1));
            hashMap.put("textureStr", new TableInfo.Column("textureStr", "TEXT", false, 0, null, 1));
            hashMap.put("paramStr", new TableInfo.Column("paramStr", "TEXT", false, 0, null, 1));
            hashMap.put(SharePluginInfo.ISSUE_SUB_TYPE, new TableInfo.Column(SharePluginInfo.ISSUE_SUB_TYPE, "TEXT", false, 0, null, 1));
            hashMap.put("supportPreview", new TableInfo.Column("supportPreview", "INTEGER", false, 0, null, 1));
            hashMap.put("version", new TableInfo.Column("version", "INTEGER", false, 0, null, 1));
            hashMap.put("skinParam", new TableInfo.Column("skinParam", "TEXT", false, 0, null, 1));
            hashMap.put("versionDir", new TableInfo.Column("versionDir", "TEXT", false, 0, null, 1));
            hashMap.put("onlineParam", new TableInfo.Column("onlineParam", "TEXT", false, 0, null, 1));
            hashMap.put("temp1", new TableInfo.Column("temp1", "TEXT", false, 0, null, 1));
            hashMap.put("temp2", new TableInfo.Column("temp2", "TEXT", false, 0, null, 1));
            hashMap.put("temp3", new TableInfo.Column("temp3", "TEXT", false, 0, null, 1));
            hashMap.put("temp4", new TableInfo.Column("temp4", "TEXT", false, 0, null, 1));
            TableInfo tableInfo = new TableInfo("effect", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(supportSQLiteDatabase, "effect");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "effect(us.pinguo.repository2020.database.filter.FilterParamsTable).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(19);
            hashMap2.put("categoryId", new TableInfo.Column("categoryId", "TEXT", true, 0, "''", 1));
            hashMap2.put(TapjoyAuctionFlags.AUCTION_ID, new TableInfo.Column(TapjoyAuctionFlags.AUCTION_ID, "TEXT", true, 1, null, 1));
            hashMap2.put("namejson", new TableInfo.Column("namejson", "TEXT", false, 0, null, 1));
            hashMap2.put("filterType", new TableInfo.Column("filterType", "TEXT", false, 0, null, 1));
            hashMap2.put(SharePluginInfo.ISSUE_SUB_TYPE, new TableInfo.Column(SharePluginInfo.ISSUE_SUB_TYPE, "TEXT", false, 0, null, 1));
            hashMap2.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap2.put("sort", new TableInfo.Column("sort", "INTEGER", true, 0, null, 1));
            hashMap2.put("displayMd5", new TableInfo.Column("displayMd5", "TEXT", false, 0, null, 1));
            hashMap2.put("packageMd5", new TableInfo.Column("packageMd5", "TEXT", false, 0, null, 1));
            hashMap2.put("vip", new TableInfo.Column("vip", "INTEGER", false, 0, null, 1));
            hashMap2.put("unity_engine_filter", new TableInfo.Column("unity_engine_filter", "INTEGER", false, 0, null, 1));
            hashMap2.put("camera_support", new TableInfo.Column("camera_support", "INTEGER", false, 0, null, 1));
            hashMap2.put("tagContent", new TableInfo.Column("tagContent", "INTEGER", false, 0, null, 1));
            hashMap2.put("tagOnTime", new TableInfo.Column("tagOnTime", "INTEGER", false, 0, null, 1));
            hashMap2.put("tagOffTime", new TableInfo.Column("tagOffTime", "INTEGER", false, 0, null, 1));
            hashMap2.put("temp1", new TableInfo.Column("temp1", "TEXT", false, 0, null, 1));
            hashMap2.put("temp2", new TableInfo.Column("temp2", "TEXT", false, 0, null, 1));
            hashMap2.put("temp3", new TableInfo.Column("temp3", "TEXT", false, 0, null, 1));
            hashMap2.put("temp4", new TableInfo.Column("temp4", "TEXT", false, 0, null, 1));
            TableInfo tableInfo2 = new TableInfo("category", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "category");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "category(us.pinguo.repository2020.database.filter.FilterPackageTable).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(19);
            hashMap3.put("_aid", new TableInfo.Column("_aid", "INTEGER", true, 1, null, 1));
            hashMap3.put(TapjoyAuctionFlags.AUCTION_ID, new TableInfo.Column(TapjoyAuctionFlags.AUCTION_ID, "TEXT", false, 0, null, 1));
            hashMap3.put("namejson", new TableInfo.Column("namejson", "TEXT", false, 0, null, 1));
            hashMap3.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap3.put("sortInPackage", new TableInfo.Column("sortInPackage", "INTEGER", false, 0, null, 1));
            hashMap3.put("packageId", new TableInfo.Column("packageId", "TEXT", false, 0, null, 1));
            hashMap3.put("packageMd5", new TableInfo.Column("packageMd5", "TEXT", false, 0, null, 1));
            hashMap3.put("isCollect", new TableInfo.Column("isCollect", "INTEGER", false, 0, null, 1));
            hashMap3.put("collectTime", new TableInfo.Column("collectTime", "INTEGER", false, 0, null, 1));
            hashMap3.put("hasMusic", new TableInfo.Column("hasMusic", "INTEGER", false, 0, null, 1));
            hashMap3.put(Frame.PARAM_KEY_OPACITY, new TableInfo.Column(Frame.PARAM_KEY_OPACITY, "INTEGER", true, 0, TaskDetailBasePresenter.SCENE_LIST, 1));
            hashMap3.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
            hashMap3.put("unity_engine_filter", new TableInfo.Column("unity_engine_filter", "INTEGER", false, 0, null, 1));
            hashMap3.put("camera_support", new TableInfo.Column("camera_support", "INTEGER", false, 0, null, 1));
            hashMap3.put("enableGesture", new TableInfo.Column("enableGesture", "INTEGER", false, 0, null, 1));
            hashMap3.put("temp1", new TableInfo.Column("temp1", "TEXT", false, 0, null, 1));
            hashMap3.put("temp2", new TableInfo.Column("temp2", "TEXT", false, 0, null, 1));
            hashMap3.put("temp3", new TableInfo.Column("temp3", "TEXT", false, 0, null, 1));
            hashMap3.put("temp4", new TableInfo.Column("temp4", "TEXT", false, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("item", hashMap3, new HashSet(0), new HashSet(0));
            TableInfo read3 = TableInfo.read(supportSQLiteDatabase, "item");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "item(us.pinguo.repository2020.database.filter.FilterItemTable).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(12);
            hashMap4.put(TapjoyAuctionFlags.AUCTION_ID, new TableInfo.Column(TapjoyAuctionFlags.AUCTION_ID, "TEXT", true, 1, null, 1));
            hashMap4.put("namejson", new TableInfo.Column("namejson", "TEXT", false, 0, null, 1));
            hashMap4.put("filterType", new TableInfo.Column("filterType", "TEXT", false, 0, "'unity'", 1));
            hashMap4.put(SharePluginInfo.ISSUE_SUB_TYPE, new TableInfo.Column(SharePluginInfo.ISSUE_SUB_TYPE, "TEXT", false, 0, "'Filter'", 1));
            hashMap4.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap4.put("sort", new TableInfo.Column("sort", "INTEGER", true, 0, null, 1));
            hashMap4.put("displayMd5", new TableInfo.Column("displayMd5", "TEXT", false, 0, null, 1));
            hashMap4.put("packageMd5", new TableInfo.Column("packageMd5", "TEXT", false, 0, null, 1));
            hashMap4.put("temp1", new TableInfo.Column("temp1", "TEXT", false, 0, null, 1));
            hashMap4.put("temp2", new TableInfo.Column("temp2", "TEXT", false, 0, null, 1));
            hashMap4.put("temp3", new TableInfo.Column("temp3", "TEXT", false, 0, null, 1));
            hashMap4.put("temp4", new TableInfo.Column("temp4", "TEXT", false, 0, null, 1));
            TableInfo tableInfo4 = new TableInfo("stickerPackage", hashMap4, new HashSet(0), new HashSet(0));
            TableInfo read4 = TableInfo.read(supportSQLiteDatabase, "stickerPackage");
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "stickerPackage(us.pinguo.repository2020.database.sticker.StickerTable).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            HashMap hashMap5 = new HashMap(15);
            hashMap5.put("_aid", new TableInfo.Column("_aid", "INTEGER", true, 1, null, 1));
            hashMap5.put(TapjoyAuctionFlags.AUCTION_ID, new TableInfo.Column(TapjoyAuctionFlags.AUCTION_ID, "TEXT", false, 0, null, 1));
            hashMap5.put("namejson", new TableInfo.Column("namejson", "TEXT", false, 0, null, 1));
            hashMap5.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap5.put("sortInPackage", new TableInfo.Column("sortInPackage", "INTEGER", false, 0, null, 1));
            hashMap5.put("packageId", new TableInfo.Column("packageId", "TEXT", false, 0, null, 1));
            hashMap5.put("packageMd5", new TableInfo.Column("packageMd5", "TEXT", false, 0, null, 1));
            hashMap5.put("isCollect", new TableInfo.Column("isCollect", "INTEGER", false, 0, "0", 1));
            hashMap5.put("collectTime", new TableInfo.Column("collectTime", "INTEGER", false, 0, null, 1));
            hashMap5.put("hasMusic", new TableInfo.Column("hasMusic", "INTEGER", false, 0, "0", 1));
            hashMap5.put("type", new TableInfo.Column("type", "TEXT", false, 0, "'ut'", 1));
            hashMap5.put("temp1", new TableInfo.Column("temp1", "TEXT", false, 0, null, 1));
            hashMap5.put("temp2", new TableInfo.Column("temp2", "TEXT", false, 0, null, 1));
            hashMap5.put("temp3", new TableInfo.Column("temp3", "TEXT", false, 0, null, 1));
            hashMap5.put("temp4", new TableInfo.Column("temp4", "TEXT", false, 0, null, 1));
            TableInfo tableInfo5 = new TableInfo("stickerItem", hashMap5, new HashSet(0), new HashSet(0));
            TableInfo read5 = TableInfo.read(supportSQLiteDatabase, "stickerItem");
            if (!tableInfo5.equals(read5)) {
                return new RoomOpenHelper.ValidationResult(false, "stickerItem(us.pinguo.repository2020.database.sticker.StickerItemTable).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
            }
            HashMap hashMap6 = new HashMap(12);
            hashMap6.put(TapjoyAuctionFlags.AUCTION_ID, new TableInfo.Column(TapjoyAuctionFlags.AUCTION_ID, "TEXT", true, 1, null, 1));
            hashMap6.put("namejson", new TableInfo.Column("namejson", "TEXT", false, 0, null, 1));
            hashMap6.put("packageMd5", new TableInfo.Column("packageMd5", "TEXT", false, 0, null, 1));
            hashMap6.put(SharePluginInfo.ISSUE_SUB_TYPE, new TableInfo.Column(SharePluginInfo.ISSUE_SUB_TYPE, "TEXT", false, 0, null, 1));
            hashMap6.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap6.put("sort", new TableInfo.Column("sort", "INTEGER", true, 0, null, 1));
            hashMap6.put("displayMd5", new TableInfo.Column("displayMd5", "TEXT", false, 0, null, 1));
            hashMap6.put("filterType", new TableInfo.Column("filterType", "TEXT", false, 0, null, 1));
            hashMap6.put("temp1", new TableInfo.Column("temp1", "TEXT", false, 0, null, 1));
            hashMap6.put("temp2", new TableInfo.Column("temp2", "TEXT", false, 0, null, 1));
            hashMap6.put("temp3", new TableInfo.Column("temp3", "TEXT", false, 0, null, 1));
            hashMap6.put("temp4", new TableInfo.Column("temp4", "TEXT", false, 0, null, 1));
            TableInfo tableInfo6 = new TableInfo("material_detail", hashMap6, new HashSet(0), new HashSet(0));
            TableInfo read6 = TableInfo.read(supportSQLiteDatabase, "material_detail");
            if (!tableInfo6.equals(read6)) {
                return new RoomOpenHelper.ValidationResult(false, "material_detail(us.pinguo.repository2020.database.makeup.MaterialDetailTable).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
            }
            HashMap hashMap7 = new HashMap(15);
            hashMap7.put("_aid", new TableInfo.Column("_aid", "INTEGER", true, 1, null, 1));
            hashMap7.put(TapjoyAuctionFlags.AUCTION_ID, new TableInfo.Column(TapjoyAuctionFlags.AUCTION_ID, "TEXT", false, 0, null, 1));
            hashMap7.put("namejson", new TableInfo.Column("namejson", "TEXT", false, 0, null, 1));
            hashMap7.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap7.put("sortInPackage", new TableInfo.Column("sortInPackage", "INTEGER", false, 0, null, 1));
            hashMap7.put("packageId", new TableInfo.Column("packageId", "TEXT", false, 0, null, 1));
            hashMap7.put("packageMd5", new TableInfo.Column("packageMd5", "TEXT", false, 0, null, 1));
            hashMap7.put("isCollect", new TableInfo.Column("isCollect", "INTEGER", false, 0, null, 1));
            hashMap7.put("collectTime", new TableInfo.Column("collectTime", "INTEGER", false, 0, null, 1));
            hashMap7.put("hasMusic", new TableInfo.Column("hasMusic", "INTEGER", false, 0, null, 1));
            hashMap7.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
            hashMap7.put("temp1", new TableInfo.Column("temp1", "TEXT", false, 0, null, 1));
            hashMap7.put("temp2", new TableInfo.Column("temp2", "TEXT", false, 0, null, 1));
            hashMap7.put("temp3", new TableInfo.Column("temp3", "TEXT", false, 0, null, 1));
            hashMap7.put("temp4", new TableInfo.Column("temp4", "TEXT", false, 0, null, 1));
            TableInfo tableInfo7 = new TableInfo("material_item", hashMap7, new HashSet(0), new HashSet(0));
            TableInfo read7 = TableInfo.read(supportSQLiteDatabase, "material_item");
            if (!tableInfo7.equals(read7)) {
                return new RoomOpenHelper.ValidationResult(false, "material_item(us.pinguo.repository2020.database.makeup.MaterialItemTable).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
            }
            HashMap hashMap8 = new HashMap(19);
            hashMap8.put(TapjoyAuctionFlags.AUCTION_ID, new TableInfo.Column(TapjoyAuctionFlags.AUCTION_ID, "TEXT", true, 1, null, 1));
            hashMap8.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap8.put("resourceFolderPath", new TableInfo.Column("resourceFolderPath", "TEXT", false, 0, null, 1));
            hashMap8.put("resourceChildPath", new TableInfo.Column("resourceChildPath", "TEXT", false, 0, null, 1));
            hashMap8.put("resourceChildBlendMode", new TableInfo.Column("resourceChildBlendMode", "TEXT", false, 0, null, 1));
            hashMap8.put("autoAdjustPaintInterval", new TableInfo.Column("autoAdjustPaintInterval", "INTEGER", false, 0, null, 1));
            hashMap8.put("brushSizeCalculateMode", new TableInfo.Column("brushSizeCalculateMode", "INTEGER", false, 0, null, 1));
            hashMap8.put("brushSourceType", new TableInfo.Column("brushSourceType", "INTEGER", false, 0, null, 1));
            hashMap8.put("enableRandomSpriteIndex", new TableInfo.Column("enableRandomSpriteIndex", "INTEGER", false, 0, null, 1));
            hashMap8.put("enableRotate", new TableInfo.Column("enableRotate", "INTEGER", false, 0, null, 1));
            hashMap8.put("paintIntervalRatio", new TableInfo.Column("paintIntervalRatio", "REAL", false, 0, null, 1));
            hashMap8.put("brushDefaultEffectIntensity", new TableInfo.Column("brushDefaultEffectIntensity", "REAL", false, 0, null, 1));
            hashMap8.put("brushEffectIntensity", new TableInfo.Column("brushEffectIntensity", "REAL", false, 0, null, 1));
            hashMap8.put("brushSizeRatio", new TableInfo.Column("brushSizeRatio", "REAL", false, 0, null, 1));
            hashMap8.put("brushDisplaySizeRatio", new TableInfo.Column("brushDisplaySizeRatio", "REAL", false, 0, null, 1));
            hashMap8.put("brushColor", new TableInfo.Column("brushColor", "TEXT", false, 0, null, 1));
            hashMap8.put("enableFlow", new TableInfo.Column("enableFlow", "INTEGER", false, 0, null, 1));
            hashMap8.put("brushBlendMode", new TableInfo.Column("brushBlendMode", "INTEGER", false, 0, null, 1));
            hashMap8.put("supportChangeColor", new TableInfo.Column("supportChangeColor", "INTEGER", false, 0, null, 1));
            TableInfo tableInfo8 = new TableInfo("paint_material", hashMap8, new HashSet(0), new HashSet(0));
            TableInfo read8 = TableInfo.read(supportSQLiteDatabase, "paint_material");
            if (!tableInfo8.equals(read8)) {
                return new RoomOpenHelper.ValidationResult(false, "paint_material(us.pinguo.repository2020.database.paint.PaintMaterialTable).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
            }
            HashMap hashMap9 = new HashMap(5);
            hashMap9.put("_aid", new TableInfo.Column("_aid", "INTEGER", true, 1, null, 1));
            hashMap9.put("filterId", new TableInfo.Column("filterId", "TEXT", true, 0, null, 1));
            hashMap9.put("packageId", new TableInfo.Column("packageId", "TEXT", true, 0, null, 1));
            hashMap9.put("position", new TableInfo.Column("position", "TEXT", true, 0, null, 1));
            hashMap9.put("number", new TableInfo.Column("number", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo9 = new TableInfo("filter_history", hashMap9, new HashSet(0), new HashSet(0));
            TableInfo read9 = TableInfo.read(supportSQLiteDatabase, "filter_history");
            if (!tableInfo9.equals(read9)) {
                return new RoomOpenHelper.ValidationResult(false, "filter_history(us.pinguo.repository2020.database.filterhistory.FilterHistoryTable).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
            }
            HashMap hashMap10 = new HashMap(7);
            hashMap10.put("sid", new TableInfo.Column("sid", "TEXT", true, 1, null, 1));
            hashMap10.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
            hashMap10.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap10.put(JsonMarshaller.TAGS, new TableInfo.Column(JsonMarshaller.TAGS, "TEXT", false, 0, null, 1));
            hashMap10.put("display_md5", new TableInfo.Column("display_md5", "TEXT", false, 0, null, 1));
            hashMap10.put("down_url", new TableInfo.Column("down_url", "TEXT", false, 0, null, 1));
            hashMap10.put("fromTemplate", new TableInfo.Column("fromTemplate", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo10 = new TableInfo("downloaded_static_sticker", hashMap10, new HashSet(0), new HashSet(0));
            TableInfo read10 = TableInfo.read(supportSQLiteDatabase, "downloaded_static_sticker");
            if (!tableInfo10.equals(read10)) {
                return new RoomOpenHelper.ValidationResult(false, "downloaded_static_sticker(us.pinguo.repository2020.database.staticsticker.StaticStickerTable).\n Expected:\n" + tableInfo10 + "\n Found:\n" + read10);
            }
            HashMap hashMap11 = new HashMap(6);
            hashMap11.put("pid", new TableInfo.Column("pid", "TEXT", true, 1, null, 1));
            hashMap11.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
            hashMap11.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap11.put("store_icon", new TableInfo.Column("store_icon", "TEXT", false, 0, null, 1));
            hashMap11.put("vip", new TableInfo.Column("vip", "INTEGER", false, 0, null, 1));
            hashMap11.put("completed", new TableInfo.Column("completed", "INTEGER", false, 0, null, 1));
            TableInfo tableInfo11 = new TableInfo("downloaded_static_sticker_category", hashMap11, new HashSet(0), new HashSet(0));
            TableInfo read11 = TableInfo.read(supportSQLiteDatabase, "downloaded_static_sticker_category");
            if (!tableInfo11.equals(read11)) {
                return new RoomOpenHelper.ValidationResult(false, "downloaded_static_sticker_category(us.pinguo.repository2020.database.staticsticker.StaticStickerCategoryTable).\n Expected:\n" + tableInfo11 + "\n Found:\n" + read11);
            }
            HashMap hashMap12 = new HashMap(1);
            hashMap12.put("tid", new TableInfo.Column("tid", "TEXT", true, 1, null, 1));
            TableInfo tableInfo12 = new TableInfo("sticker_template_collection", hashMap12, new HashSet(0), new HashSet(0));
            TableInfo read12 = TableInfo.read(supportSQLiteDatabase, "sticker_template_collection");
            if (!tableInfo12.equals(read12)) {
                return new RoomOpenHelper.ValidationResult(false, "sticker_template_collection(us.pinguo.repository2020.database.staticsticker.StickerTemplateCollectionTable).\n Expected:\n" + tableInfo12 + "\n Found:\n" + read12);
            }
            HashMap hashMap13 = new HashMap(5);
            hashMap13.put("pid", new TableInfo.Column("pid", "TEXT", true, 1, null, 1));
            hashMap13.put("sid", new TableInfo.Column("sid", "TEXT", false, 0, null, 1));
            hashMap13.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
            hashMap13.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
            hashMap13.put("shape", new TableInfo.Column("shape", "TEXT", false, 0, null, 1));
            TableInfo tableInfo13 = new TableInfo("background_blur_material", hashMap13, new HashSet(0), new HashSet(0));
            TableInfo read13 = TableInfo.read(supportSQLiteDatabase, "background_blur_material");
            if (!tableInfo13.equals(read13)) {
                return new RoomOpenHelper.ValidationResult(false, "background_blur_material(us.pinguo.repository2020.database.staticsticker.BackgroundBlurMaterialTable).\n Expected:\n" + tableInfo13 + "\n Found:\n" + read13);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public us.pinguo.repository2020.database.makeup.c A() {
        us.pinguo.repository2020.database.makeup.c cVar;
        if (this.w != null) {
            return this.w;
        }
        synchronized (this) {
            if (this.w == null) {
                this.w = new d(this);
            }
            cVar = this.w;
        }
        return cVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public us.pinguo.repository2020.database.paint.a B() {
        us.pinguo.repository2020.database.paint.a aVar;
        if (this.x != null) {
            return this.x;
        }
        synchronized (this) {
            if (this.x == null) {
                this.x = new us.pinguo.repository2020.database.paint.b(this);
            }
            aVar = this.x;
        }
        return aVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public e C() {
        e eVar;
        if (this.A != null) {
            return this.A;
        }
        synchronized (this) {
            if (this.A == null) {
                this.A = new f(this);
            }
            eVar = this.A;
        }
        return eVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public g D() {
        g gVar;
        if (this.z != null) {
            return this.z;
        }
        synchronized (this) {
            if (this.z == null) {
                this.z = new h(this);
            }
            gVar = this.z;
        }
        return gVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public i E() {
        i iVar;
        if (this.B != null) {
            return this.B;
        }
        synchronized (this) {
            if (this.B == null) {
                this.B = new j(this);
            }
            iVar = this.B;
        }
        return iVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public b F() {
        b bVar;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            if (this.u == null) {
                this.u = new us.pinguo.repository2020.database.sticker.c(this);
            }
            bVar = this.u;
        }
        return bVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public us.pinguo.repository2020.database.sticker.e G() {
        us.pinguo.repository2020.database.sticker.e eVar;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            if (this.t == null) {
                this.t = new us.pinguo.repository2020.database.sticker.f(this);
            }
            eVar = this.t;
        }
        return eVar;
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `effect`");
            writableDatabase.execSQL("DELETE FROM `category`");
            writableDatabase.execSQL("DELETE FROM `item`");
            writableDatabase.execSQL("DELETE FROM `stickerPackage`");
            writableDatabase.execSQL("DELETE FROM `stickerItem`");
            writableDatabase.execSQL("DELETE FROM `material_detail`");
            writableDatabase.execSQL("DELETE FROM `material_item`");
            writableDatabase.execSQL("DELETE FROM `paint_material`");
            writableDatabase.execSQL("DELETE FROM `filter_history`");
            writableDatabase.execSQL("DELETE FROM `downloaded_static_sticker`");
            writableDatabase.execSQL("DELETE FROM `downloaded_static_sticker_category`");
            writableDatabase.execSQL("DELETE FROM `sticker_template_collection`");
            writableDatabase.execSQL("DELETE FROM `background_blur_material`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "effect", "category", "item", "stickerPackage", "stickerItem", "material_detail", "material_item", "paint_material", "filter_history", "downloaded_static_sticker", "downloaded_static_sticker_category", "sticker_template_collection", "background_blur_material");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(15), "873b63fc6d43674b412fc7a08d3c5dd6", "2a256f3d6954cf490814228259c3b264")).build());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(c.class, us.pinguo.repository2020.database.filter.d.f());
        hashMap.put(us.pinguo.repository2020.database.filter.a.class, us.pinguo.repository2020.database.filter.b.h());
        hashMap.put(us.pinguo.repository2020.database.filter.e.class, us.pinguo.repository2020.database.filter.f.e());
        hashMap.put(us.pinguo.repository2020.database.sticker.e.class, us.pinguo.repository2020.database.sticker.f.e());
        hashMap.put(b.class, us.pinguo.repository2020.database.sticker.c.g());
        hashMap.put(us.pinguo.repository2020.database.makeup.a.class, us.pinguo.repository2020.database.makeup.b.d());
        hashMap.put(us.pinguo.repository2020.database.makeup.c.class, d.d());
        hashMap.put(us.pinguo.repository2020.database.paint.a.class, us.pinguo.repository2020.database.paint.b.c());
        hashMap.put(us.pinguo.repository2020.database.b.a.class, us.pinguo.repository2020.database.b.b.e());
        hashMap.put(g.class, h.c());
        hashMap.put(e.class, f.f());
        hashMap.put(i.class, j.c());
        hashMap.put(us.pinguo.repository2020.database.staticsticker.a.class, us.pinguo.repository2020.database.staticsticker.b.e());
        return hashMap;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public us.pinguo.repository2020.database.staticsticker.a u() {
        us.pinguo.repository2020.database.staticsticker.a aVar;
        if (this.C != null) {
            return this.C;
        }
        synchronized (this) {
            if (this.C == null) {
                this.C = new us.pinguo.repository2020.database.staticsticker.b(this);
            }
            aVar = this.C;
        }
        return aVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public us.pinguo.repository2020.database.b.a v() {
        us.pinguo.repository2020.database.b.a aVar;
        if (this.y != null) {
            return this.y;
        }
        synchronized (this) {
            if (this.y == null) {
                this.y = new us.pinguo.repository2020.database.b.b(this);
            }
            aVar = this.y;
        }
        return aVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public us.pinguo.repository2020.database.filter.a w() {
        us.pinguo.repository2020.database.filter.a aVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            if (this.r == null) {
                this.r = new us.pinguo.repository2020.database.filter.b(this);
            }
            aVar = this.r;
        }
        return aVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public c x() {
        c cVar;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            if (this.q == null) {
                this.q = new us.pinguo.repository2020.database.filter.d(this);
            }
            cVar = this.q;
        }
        return cVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public us.pinguo.repository2020.database.filter.e y() {
        us.pinguo.repository2020.database.filter.e eVar;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            if (this.s == null) {
                this.s = new us.pinguo.repository2020.database.filter.f(this);
            }
            eVar = this.s;
        }
        return eVar;
    }

    @Override // us.pinguo.repository2020.database.EffectDbManager
    public us.pinguo.repository2020.database.makeup.a z() {
        us.pinguo.repository2020.database.makeup.a aVar;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            if (this.v == null) {
                this.v = new us.pinguo.repository2020.database.makeup.b(this);
            }
            aVar = this.v;
        }
        return aVar;
    }
}
