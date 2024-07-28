package com.example.damage_app_001.ui_elements

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.damage_app_001.data.BuildingElements
import com.example.damage_app_001.data.Components
import com.example.damage_app_001.data.Elements
import com.example.damage_app_001.data.Floors
import com.example.damage_app_001.data.Property
import com.example.damage_app_001.data.Stairs
import com.example.damage_app_001.domain.PropertyRepository
import kotlinx.coroutines.launch

class MainViewModel(
    val repository: PropertyRepository
) : ViewModel(){

    val propertyList = repository.allPropertiesList
    val stairsList = repository.allStaisList
    val componentList = repository.allComponentsList
    val floorList = repository.allFloorsList
    val elementList = repository.allElementsList
    val buildingElementsList = repository.allBuildingElementsList


    fun insertProperty(data: Property){
        if(data.title.isEmpty()){
            return
        }
        viewModelScope.launch {
            repository.insertProperty(data)
        }
    }

    fun deleteProperty(id : Int, title: String){
        viewModelScope.launch {
            repository.deleteProperty(Property(id,title))
        }
    }

    fun updateProperty(id: Int,title : String){
        if(title.isEmpty()){
            return
        }
        viewModelScope.launch{
            repository.updateProperty(Property(id,title))
        }
    }

    fun insertCompoment(propertyId : Int, title: String){
        if(title.isEmpty()){
            return
        }
        viewModelScope.launch {
            val component = Components(propertyId = propertyId, title = title, isOutside = false)
            repository.insertComponent(component)
        }
    }

    fun updateComponent(propertyId : Int, title: String){
        if(title.isEmpty()){
            return
        }
        viewModelScope.launch {
            val component = Components(propertyId = propertyId, title = title, isOutside = false)
            repository.updateComponent(component)
        }
    }

    fun deleteComponent(propertyId : Int, title: String){
        viewModelScope.launch {
            val component = Components(propertyId = propertyId, title = title, isOutside = false)
            repository.deleteComponent(component)
        }
    }

    fun insertStairs(componentId : Int, title: String){
        if(title.isEmpty()){
            return
        }
        viewModelScope.launch {
            val stairs = Stairs(componentId = componentId, title = title)
            repository.insertStair(stairs)
        }
    }

    fun updateStairs(componentId : Int, title: String){
        if(title.isEmpty()){
            return
        }
        viewModelScope.launch {
            val stairs = Stairs(componentId = componentId, title = title)
            repository.updateStair(stairs)
        }
    }

    fun deleteStairs(componentId : Int, title: String){
        viewModelScope.launch {
            val stairs = Stairs(componentId = componentId, title = title)
            repository.deleteStair(stairs)
        }
    }

    fun insertFloor(data : Floors){
        if(data.title.isEmpty()){
            return
        }
        viewModelScope.launch {
            repository.insertFloor(data)
        }
    }

    fun updateFloor(data: Floors){
        if(data.title.isEmpty()){
            return
        }
        viewModelScope.launch {
            repository.updateFloor(data)
        }
    }

    fun deleteFloor(data: Floors){
        viewModelScope.launch {
            repository.deleteFloor(data)
        }
    }

    fun insertElement(data: Elements){
        if(data.title.isEmpty()){
            return
        }
        viewModelScope.launch {
            repository.insertElement(data)
        }
    }

    fun updateElement(data: Elements){
        if(data.title.isEmpty()){
            return
        }
        viewModelScope.launch {
            repository.updateElement(data)
        }
    }

    fun deleteElement(data: Elements){
        viewModelScope.launch {
            repository.deleteElement(data)
        }
    }

    fun insertBuildingElement(data: BuildingElements){
        if(data.title.isEmpty()){
            return
        }
        viewModelScope.launch {
            repository.insertBuildingElement(data)
        }
    }

    fun updateBuildingEllement(data: BuildingElements){
        if(data.title.isEmpty()){
            return
        }
        viewModelScope.launch {
            repository.updateBuildingElelement(data)
        }
    }

    fun deleteBuildingElelment(data: BuildingElements){
        viewModelScope.launch {
            repository.deleteBuildingElement(data)
        }
    }
}