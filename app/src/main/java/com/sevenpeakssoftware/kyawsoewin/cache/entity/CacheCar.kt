package com.sevenpeakssoftware.kyawsoewin.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sevenpeakssoftware.kyawsoewin.cache.DatabaseConstants

@Entity(tableName = DatabaseConstants.CAR_TABLE_NAME)
data class CacheCar(
    @PrimaryKey
    val id: Int,
    val dateTime: String,
    val title: String,
    val image: String,
    val ingress: String,
)