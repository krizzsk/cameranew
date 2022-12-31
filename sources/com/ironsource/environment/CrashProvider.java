package com.ironsource.environment;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes2.dex */
public class CrashProvider extends ContentProvider {
    Context a;
    String b;
    UriMatcher c = new UriMatcher(-1);

    /* renamed from: d  reason: collision with root package name */
    String f5337d;

    /* renamed from: e  reason: collision with root package name */
    String f5338e;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int match = this.c.match(uri);
        if (match != 1) {
            if (match == 2) {
                return this.f5338e;
            }
            throw new IllegalArgumentException("Invalid URI: " + uri);
        }
        return this.f5337d;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.a = getContext();
        new DbHandler(this.a);
        this.b = this.a.getPackageName();
        Uri.parse("content://" + this.b + "/REPORTS");
        this.f5337d = "vnd.android.cursor.dir/CrashReporter.Reports";
        this.f5338e = "vnd.android.cursor.item/CrashReporter/Reports";
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int match = this.c.match(uri);
        if (match != 1) {
            if (match == 2) {
                return DbHandler.u(Integer.parseInt(uri.getLastPathSegment()));
            }
            throw new IllegalArgumentException("Invalid URI: " + uri);
        }
        return DbHandler.v();
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
