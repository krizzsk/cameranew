package us.pinguo.repository2020.database.filter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
/* compiled from: FilterPackageDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface c {
    @Query("SELECT * FROM category ORDER BY sort DESC")
    List<FilterPackageTable> a();

    @Insert(onConflict = 1)
    void b(List<FilterPackageTable> list);

    @Delete
    void c(FilterPackageTable filterPackageTable);

    @Insert(onConflict = 1)
    void d(FilterPackageTable filterPackageTable);

    @Query("DELETE FROM category WHERE id = :key")
    void e(String str);
}
