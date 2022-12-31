package us.pinguo.edit.sdk.core.resource.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import us.pinguo.edit.sdk.core.utils.SdkLog;
/* compiled from: PGEftDbHelper.java */
/* loaded from: classes4.dex */
public class a extends SQLiteOpenHelper {
    private static final String a = a.class.getSimpleName();

    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        SdkLog.c(a, "Create database effect with tables: effect_type, effect");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_pkg(\neft_pkg_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_pkg_key TEXT UNIQUE,\ntype TEXT,\npkg_group_key TEXT,\nguid TEXT,\nver_int INTEGER\n)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_pkg_disp_info(\neft_pkg_disp_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_pkg_key TEXT UNIQUE,\nname TEXT,\ndesc TEXT,\nlang TEXT,\nicon TEXT,\ncolor TEXT\n)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft(\neft_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT UNIQUE,\neft_pkg_key TEXT,\npreview_cmd TEXT,\ngpu_cmd TEXT,\ncpu_cmd TEXT,\nlive_preview INTEGER,\ntime_int INTEGER\n)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_disp_info(\neft_disp_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT,\nname TEXT,\ndesc TEXT,\nlang TEXT,\nicon TEXT,\ncolor TEXT\n)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_param(\neft_param_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT,\neft_gpu_cmd TEXT,\nparam_key TEXT,\nparam_type TEXT,\ndef_val INTEGER,\nno_eft_val INTEGER,\nmax INTEGER,\nmin INTEGER,\nstep INTEGER,\nval INTEGER\n)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_param_disp_info(\neft_param_disp_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT,\nparam_key TEXT,\nname TEXT,\ndesc TEXT,\nlang TEXT,\nicon TEXT,\ncolor TEXT\n)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_texture_pkg(\neft_texture_pkg_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT,\ndir TEXT,\nrule INTEGER\n)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_texture(\neft_texture_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_texture_pkg_dir TEXT,\ntexture_index INTEGER,\nname TEXT,\ntype INTEGER\n)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        String str = a;
        SdkLog.c(str, "Upgrade database from " + i2 + " to " + i3);
        if (i2 == 1) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS eft_pkg");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_pkg(\neft_pkg_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_pkg_key TEXT UNIQUE,\ntype TEXT,\npkg_group_key TEXT,\nguid TEXT,\nver_int INTEGER\n)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS eft_pkg_disp_info");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_pkg_disp_info(\neft_pkg_disp_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_pkg_key TEXT UNIQUE,\nname TEXT,\ndesc TEXT,\nlang TEXT,\nicon TEXT,\ncolor TEXT\n)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS eft");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft(\neft_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT UNIQUE,\neft_pkg_key TEXT,\npreview_cmd TEXT,\ngpu_cmd TEXT,\ncpu_cmd TEXT,\nlive_preview INTEGER,\ntime_int INTEGER\n)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS eft_disp_info");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_disp_info(\neft_disp_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT,\nname TEXT,\ndesc TEXT,\nlang TEXT,\nicon TEXT,\ncolor TEXT\n)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS eft_param");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_param(\neft_param_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT,\neft_gpu_cmd TEXT,\nparam_key TEXT,\nparam_type TEXT,\ndef_val INTEGER,\nno_eft_val INTEGER,\nmax INTEGER,\nmin INTEGER,\nstep INTEGER,\nval INTEGER\n)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS eft_param_disp_info");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_param_disp_info(\neft_param_disp_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT,\nparam_key TEXT,\nname TEXT,\ndesc TEXT,\nlang TEXT,\nicon TEXT,\ncolor TEXT\n)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS eft_texture_pkg");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_texture_pkg(\neft_texture_pkg_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_key TEXT,\ndir TEXT,\nrule INTEGER\n)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS eft_texture");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS eft_texture(\neft_texture_id INTEGER PRIMARY KEY AUTOINCREMENT,\neft_texture_pkg_dir TEXT,\ntexture_index INTEGER,\nname TEXT,\ntype INTEGER\n)");
        }
    }
}
