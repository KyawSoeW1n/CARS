package com.sevenpeakssoftware.kyawsoewin.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sevenpeakssoftware.kyawsoewin.data.cache.DatabaseConstants
import com.sevenpeakssoftware.kyawsoewin.data.cache.entity.CacheCar

@Dao
interface CarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTicketList(cacheTicketList: MutableList<CacheCar>)

    @Query("SELECT * FROM ${DatabaseConstants.CAR_TABLE_NAME}")
    fun getTicketList(): MutableList<CacheCar>
}