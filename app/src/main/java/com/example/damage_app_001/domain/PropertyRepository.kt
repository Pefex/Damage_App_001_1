package com.example.damage_app_001.domain

import com.example.damage_app_001.data.BuildingElements
import com.example.damage_app_001.data.BuildingElementsDao
import com.example.damage_app_001.data.ComponentDao
import com.example.damage_app_001.data.Components
import com.example.damage_app_001.data.ElementDao
import com.example.damage_app_001.data.Elements
import com.example.damage_app_001.data.FloorDao
import com.example.damage_app_001.data.Floors
import com.example.damage_app_001.data.PropertyDao
import com.example.damage_app_001.data.Property
import com.example.damage_app_001.data.Stairs
import com.example.damage_app_001.data.StairsDao
import kotlinx.coroutines.flow.Flow

class PropertyRepository(
    val propertyDao: PropertyDao,
    val componentDao: ComponentDao,
    val stairsDao: StairsDao,

    val floorDao : FloorDao,
    val elementDao : ElementDao,
    val buildingElementsDao: BuildingElementsDao
) {
    val allPropertiesList: Flow<List<Property>> = propertyDao.getAllProperty()

    // 3. Data Modification Methods
    suspend fun insertProperty(data: Property) {
        propertyDao.insertProperty(data)
    }

    suspend fun updateProperty(data: Property){
        propertyDao.updateProperty(data)
    }

    suspend fun deleteProperty(data: Property) {
        propertyDao.deleteProperty(data)
    }

    val allComponentsList  : Flow<List<Components>>  = componentDao.getAllComponents()

    suspend fun insertComponent(data : Components){
        componentDao.insertComponent(data)
    }

    suspend fun updateComponent(data: Components){
        componentDao.updateComponent(data)
    }

    suspend fun deleteComponent(data: Components){
        componentDao.deleteComponent(data)
    }

    val allStaisList : Flow<List<Stairs>> = stairsDao.getAllStairs()

    /////////////////////

    suspend fun insertStair(data: Stairs){
        stairsDao.insertStairs(data)
    }

    suspend fun updateStair(data: Stairs){
        stairsDao.updateStairs(data)
    }

    suspend fun deleteStair(data: Stairs){
        stairsDao.deleteStairs(data)
    }

    val allFloorsList: Flow<List<Floors>>  = floorDao.getAllFloors()

    /////////////////////////////

    suspend fun insertFloor(data: Floors){
        floorDao.insertFloor(data)
    }

    suspend fun updateFloor(data: Floors){
        floorDao.updateFloor(data)
    }

    suspend fun deleteFloor(data: Floors){
        floorDao.deleteFloor(data)
    }

    val allElementsList : Flow<List<Elements>>  = elementDao.getAllElements()

    suspend fun insertElement(data: Elements){
        elementDao.insertElement(data)
    }

    suspend fun updateElement(data: Elements){
        elementDao.updateElement((data))
    }

    suspend fun deleteElement(data: Elements){
        elementDao.deleteElement(data)
    }

    val allBuildingElementsList : Flow<List<BuildingElements>>  = buildingElementsDao.getAllBuildingElements()

    suspend fun insertBuildingElement(data  : BuildingElements){
        buildingElementsDao.insertBuildingElements(data)
    }

    suspend fun updateBuildingElelement(data: BuildingElements){
        buildingElementsDao.updateBuildingElements(data)
    }

    suspend fun deleteBuildingElement(data: BuildingElements){
        buildingElementsDao.deleteBuildingElements(data)
    }












}