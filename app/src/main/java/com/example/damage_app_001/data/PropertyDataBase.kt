package com.example.damage_app_001.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Property::class, Components:: class, Stairs:: class, Floors:: class, Elements:: class, BuildingElements:: class], version = 1)
abstract class PropertyDataBase : RoomDatabase(){
    abstract fun propertyDao() : PropertyDao
    abstract fun componentDao() : ComponentDao
    abstract fun stairsDao() : StairsDao
    abstract fun floorDao() : FloorDao
    abstract fun elementsDao()  : ElementDao
    abstract fun buildingElementsDao()  : BuildingElementsDao
}