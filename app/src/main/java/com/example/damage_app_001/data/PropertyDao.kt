package com.example.damage_app_001.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface PropertyDao {
    @Query("SELECT * FROM Property")
    fun getAllProperty(): Flow<List<Property>>

    // 3. Insert Operation for Adding or Updating Items
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProperty(data: Property)

    @Update
    suspend fun updateProperty(data: Property)  //"name" ist only a name for this function


    @Delete
    suspend fun deleteProperty(data: Property)
}

@Dao
interface ComponentDao{
    @Query("SELECT * FROM Components")
    fun getAllComponents( ): Flow<List<Components>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComponent(data: Components)

    @Update
    suspend fun updateComponent(data: Components)

    @Delete
    suspend fun deleteComponent(data: Components)
}

@Dao
interface StairsDao{
    @Query("SELECT * FROM Stairs")
    fun getAllStairs()  : Flow<List<Stairs>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStairs(data: Stairs)

    @Update
    suspend fun updateStairs(data: Stairs)

    @Delete
    suspend fun deleteStairs(data: Stairs)
}

@Dao
interface FloorDao{
    @Query("SELECT * FROM floors")
    fun getAllFloors(): Flow<List<Floors>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFloor(data: Floors)

    @Update
    suspend fun updateFloor(data:Floors)

    @Delete
    suspend fun deleteFloor(data: Floors)
}

@Dao
interface ElementDao{
    @Query("SELECT * FROM elements")
    fun getAllElements(): Flow<List<Elements>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElement(data: Elements)

    @Update
    suspend fun updateElement(data: Elements)

    @Delete
    suspend fun deleteElement(data: Elements)
}

@Dao
interface BuildingElementsDao{
    @Query("SELECT * FROM buildingelements")
    fun getAllBuildingElements(): Flow<List<BuildingElements>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBuildingElements(data: BuildingElements)

    @Update
    suspend fun updateBuildingElements(data: BuildingElements)

    @Delete
    suspend fun deleteBuildingElements(data: BuildingElements)
}



