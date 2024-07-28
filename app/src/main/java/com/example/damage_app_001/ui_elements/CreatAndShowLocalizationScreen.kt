package com.example.damage_app_001.ui_elements

import CustomizeDropDown
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.damage_app_001.data.Property


@Composable
fun CreateAndShowLocalizationScreen(
    viewModel: MainViewModel
) {

    val title = remember {
        mutableStateOf("")
    }

    val propertyList = viewModel.propertyList.collectAsState(initial = emptyList())
    val propertyNames = propertyList.value.map { it.title }
    val selectedProperty = remember {
        mutableStateOf<Int?>(null)
    }
    val componentList = viewModel.componentList.collectAsState(initial = emptyList())
    val componentNames = componentList.value.map { it.title }
    val componentTitle = remember {
        mutableStateOf("")

    }

    val selectedComponent = remember {
        mutableStateOf<Int?>(null)
    }

    val starsList = viewModel.stairsList.collectAsState(initial = emptyList())
    val stairsName = starsList.value.map{ it.title}
    val stairTitle = remember {
        mutableStateOf("")

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomizeDropDown(
                options = propertyNames,
                value = title.value,
                onValueChange = {
                    title.value = it
                    val select = propertyList.value.find { property -> property.title == it }
                    selectedProperty.value = select?.propertyId
                })
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {
                    val property = Property(title = title.value)
                    viewModel.insertProperty(property)
                }) {
                    Text(text = "Add")
                }
                Button(onClick = {
                    selectedProperty.value?.let { id ->
                        viewModel.updateProperty(id, title = title.value)
                        title.value = ""
                    }
                })
                {
                    Text(text = "Update")
                }

                Button(onClick = {
                    selectedProperty.value?.let { id ->
                        viewModel.deleteProperty(id,title.value)
                        title.value = ""
                        selectedProperty.value = null
                    }
                }) {
                    Text(text = "Delete")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        selectedProperty.value?.let {propertId ->
            Row (modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){
                //

                CustomizeDropDown(
                    options = componentNames,
                    value = componentTitle.value,
                    onValueChange ={componentTitle.value = it
                    val select = componentList.value.find { components -> components.title == it }
                        selectedComponent.value = select?.componentId
                    })

                Column {
                    Button(onClick = {
                        viewModel.insertCompoment(
                        propertId,
                        componentTitle.value
                    )
                        componentTitle.value = ""
                    }, modifier = Modifier.size(34.dp)) {
                        Text(text = "Add Component")

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = {viewModel.updateComponent(
                        propertId,
                        componentTitle.value
                    )
                        componentTitle.value = ""
                     }, modifier = Modifier.size(34.dp)) {
                        Text(text = "Update Component")

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Button(onClick = {
                        viewModel.deleteComponent(
                        propertId,
                        componentTitle.value
                    )
                        selectedComponent.value = null

                                     }, modifier = Modifier.size(34.dp)) {
                        Text(text = "Delete Component")
                    }
                }
            }
        }

        selectedComponent.value?.let { componentId ->
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween){

                CustomizeDropDown(
                    options = stairsName,
                    value = stairTitle.value,
                    onValueChange = {stairTitle.value = it})

                Column {
                    Button(onClick = {viewModel.insertStairs(componentId, stairTitle.value)}, modifier = Modifier.size(34.dp)) {
                        Text(text = "Add Stair")
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(onClick = {viewModel.updateStairs(componentId, stairTitle.value)}, modifier = Modifier.size(34.dp)) {
                        Text(text = "Update Stair")
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Button(onClick = {viewModel.deleteStairs(componentId, stairTitle.value) }, modifier = Modifier.size(34.dp)) {
                        Text(text = "Delete Stair")
                    }

                }

            }
        }

        }

    }

