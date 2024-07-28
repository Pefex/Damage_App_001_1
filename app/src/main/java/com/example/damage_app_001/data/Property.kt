package com.example.damage_app_001.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity
data class Property(
    @PrimaryKey(autoGenerate = true)
    val propertyId : Int = 0,
    val title : String = ""
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = Property:: class,
        parentColumns = ["propertyId"],
        childColumns = ["propertyId"],
        onDelete = ForeignKey.CASCADE
        )]

)
data class Components(
    @PrimaryKey(autoGenerate = true)
    val componentId : Int = 0, // is the current Id
    val propertyId: Int, // is the root Id
    val title : String = "",
    val type : String = "",  //
    val isOutside : Boolean
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = Components:: class,
        parentColumns = ["componentId"],
        childColumns = ["componentId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Stairs(
    @PrimaryKey(autoGenerate = true)
    val stairsId : Int = 0,
    val componentId : Int,
    val title: String = ""
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = Stairs:: class,
        parentColumns = ["stairsId"],
        childColumns = ["stairsId"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class Floors(
    @PrimaryKey(autoGenerate = true)
    val floorId : Int = 0,
    val stairsId: Int,
    val title: String = ""
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = Floors:: class,
        parentColumns = ["floorId"],
        childColumns = ["floorId"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class Elements(
    @PrimaryKey(autoGenerate = true)
    val elementId : Int = 0,
    val floorId: Int,
    val title: String = ""
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = Elements:: class,
        parentColumns = ["elementId"],
        childColumns = ["elementId"],
        onDelete = ForeignKey.CASCADE
    )]
)

data class BuildingElements(  //die darüberliegende Entity ist die dazugehörige Entity
    @PrimaryKey(autoGenerate = true)
    val buildingId : Int = 0,
    val elementId: Int,
    val title: String = ""
)











