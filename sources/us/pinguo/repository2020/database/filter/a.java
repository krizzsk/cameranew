package us.pinguo.repository2020.database.filter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
/* compiled from: FilterItemDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface a {
    @Query("SELECT * FROM item")
    List<FilterItemTable> a();

    @Insert(onConflict = 1)
    void b(List<FilterItemTable> list);

    @Delete
    void c(List<FilterItemTable> list);

    @Query("SELECT * FROM item WHERE packageId=:packageId")
    List<FilterItemTable> d(String str);

    @Update
    void e(FilterItemTable filterItemTable);

    @Update
    void f(List<FilterItemTable> list);

    @Insert(onConflict = 1)
    void g(FilterItemTable filterItemTable);
}
