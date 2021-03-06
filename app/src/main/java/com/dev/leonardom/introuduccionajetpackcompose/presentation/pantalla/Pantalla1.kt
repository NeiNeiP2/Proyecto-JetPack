package com.dev.leonardom.introuduccionajetpackcompose.presentation

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations

@Composable
fun Pantalla1(
   navController: NavController
) {
    var textValue by remember { mutableStateOf("") }
    Button(onClick = { navController.navigate(route="pantalla4") },Modifier.padding(top = 7.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        )) {
        Icon(imageVector = Icons.Default.Dangerous, contentDescription = null)
        Text("  Emergencia")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 37.sp,fontWeight = FontWeight.Bold)){
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("L")
                    }
                    append("ugares de ")

                    withStyle(style = SpanStyle(color = Color.Red)) {
                        append("E")
                    }
                    append("mergencia")
                }

            }
        , textAlign = TextAlign.Center)
        var expandir by remember { mutableStateOf(false)}
        val list = listOf("Arequipa", "Camana", "Caraveli","Castilla", "LaUnion","Condesuyos", "Islay", "Caylloma" )
        var selectedItem by remember { mutableStateOf("")}
        var textFiledSize by remember{ mutableStateOf(Size.Zero)}

        val icon = if (expandir){
            Icons.Filled.KeyboardArrowDown
        }else {
            Icons.Filled.KeyboardArrowDown
        }
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {selectedItem=it},
            modifier= Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates -> textFiledSize = coordinates.size.toSize() },
            label={Text(text="Seleccionar Item")},
            trailingIcon = {
                Icon(icon,"" ,Modifier.clickable { expandir=!expandir })
            }

        )
        DropdownMenu(
            expanded = expandir,
            onDismissRequest = { expandir=false },
            modifier=Modifier.width(with(LocalDensity.current){textFiledSize.width.toDp()})
        ) {
            list.forEach {
                label->DropdownMenuItem(onClick = {
                    selectedItem= label
                    expandir=false
                }) {
                    Text(text=label)
                }
            }
        }


        Button(onClick = { navController.navigate(route="pantalla3/"+selectedItem) },Modifier.padding(all = 10.dp)) {
            Text("Enviar")
        }

    }
}