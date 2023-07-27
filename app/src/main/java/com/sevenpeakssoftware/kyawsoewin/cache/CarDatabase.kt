package com.sevenpeakssoftware.kyawsoewin.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sevenpeakssoftware.kyawsoewin.cache.dao.CarDao
import com.sevenpeakssoftware.kyawsoewin.cache.entity.CacheCar

@Database(
    entities = [CacheCar::class],
    version = 1,
    exportSchema = true
)
abstract class CarDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}
