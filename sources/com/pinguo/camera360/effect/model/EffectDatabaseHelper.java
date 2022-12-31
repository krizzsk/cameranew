package com.pinguo.camera360.effect.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import us.pinguo.common.log.a;
/* loaded from: classes3.dex */
public class EffectDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_EFFECT_TABLE_SQL = "CREATE TABLE effect(\n    id INTEGER PRIMARY KEY AUTOINCREMENT,\n    key TEXT,\n    type TEXT,\n    locale TEXT,\n    name TEXT,\n    description TEXT,\n    version INTEGER,\n    requirementStr TEXT,\n    icon TEXT,\n    realRender INTEGER,\n    preCmdStr TEXT,\n    gpuCmdStr TEXT,\n    cpuCmd TEXT,\n    textureStr TEXT,\n    typeKey TEXT,\n    idxInType INTEGER,\n    packKey TEXT,\n    idxInPack INTEGER,\n    installation INTEGER,\n    installTime Text,\n    isNew INTEGER,\n    paramStr TEXT,\n    resInt1 INTEGER,\n    resInt2 INTEGER,\n    resText1 TEXT,\n    resText2 TEXT,\n    like INTEGER,\n    sort INTEGER\n)";
    private static final String CREATE_EFFECT_TYPE_TABLE_SQL = "CREATE TABLE effect_type(\n    id INTEGER PRIMARY KEY AUTOINCREMENT,\n    key TEXT,\n    type TEXT,\n    locale TEXT,\n    name TEXT,\n    tag TEXT,\n    description TEXT,\n    icon TEXT,\n    opTime TEXT,\n    isNew INTEGER,\n    resInt1 INTEGER,\n    resInt2 INTEGER,\n    resText1 TEXT,\n    resText2 TEXT,\n    sort INTEGER,\n    installation INTEGER DEFAULT 1\n)";
    public static final String DB_NAME = "effect.db";
    private static final String TAG = EffectDatabaseHelper.class.getSimpleName();
    public static final String TAG_EFFECT_DB_UPDATE = "tag_effect_db_update";
    public static final int VERSION = 3;
    private String EFFECT_PARAM_STR;

    public EffectDatabaseHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
        this.EFFECT_PARAM_STR = "{\"items\":{\"noEffectItems\":[{\"defaultValue\":100,\"noEffectValue\":0,\"max\":100,\"min\":0,\"step\":1,\"value\":100,\"effectKey\":\"\",\"key\":\"EffectOpacity\",\"type\":\"NoEffectItem\"}]}}";
    }

    private void upgradeFrom2To3(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE 'effect' ADD 'like' INTEGER");
        sQLiteDatabase.execSQL("ALTER TABLE 'effect' ADD 'sort' INTEGER");
        sQLiteDatabase.execSQL("ALTER TABLE 'effect_type' ADD 'sort' INTEGER");
        sQLiteDatabase.execSQL("ALTER TABLE 'effect_type' ADD 'installation' INTEGER");
        sQLiteDatabase.execSQL("UPDATE effect_type SET installation = 1");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a.m(TAG, "Create database effect with tables: effect_type, effect", new Object[0]);
        sQLiteDatabase.execSQL(CREATE_EFFECT_TYPE_TABLE_SQL);
        sQLiteDatabase.execSQL(CREATE_EFFECT_TABLE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        a.m(TAG_EFFECT_DB_UPDATE, "b0 start onUpgrade, database from " + i2 + " to " + i3, new Object[0]);
        if (i3 != 3) {
            a.m(TAG_EFFECT_DB_UPDATE, "b1 end of onUpgrade", new Object[0]);
        } else if (i2 == 2) {
            upgradeFrom2To3(sQLiteDatabase);
        }
    }
}
