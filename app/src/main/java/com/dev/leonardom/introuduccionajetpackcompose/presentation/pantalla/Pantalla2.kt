package com.dev.leonardom.introuduccionajetpackcompose.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.compiler.plugins.kotlin.lower.forEachWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.constraintlayout.compose.ConstraintSet
import androidx.datastore.core.DataStore
import androidx.navigation.NavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.dev.leonardom.introuduccionajetpackcompose.Clases.Provincia
import com.dev.leonardom.introuduccionajetpackcompose.navigation.Destinations
import java.util.prefs.Preferences

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Pantalla2(navController: NavController, text3: String, text4: String) {
    var text by remember { mutableStateOf("")}
    var text2 by remember  { mutableStateOf("")}
    Box(modifier=Modifier.fillMaxSize()){
        text=text3
        text2=text4
        val listState = rememberLazyListState()
        LazyColumn(contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            state = listState
        ){
            item{
                if(text2!="CentroDeSalud"){
                    Text(
                        text = text2+" - "+ text,
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black
                        ),textAlign = TextAlign.Center
                    )
                }
                else{
                    Text(
                        text = "Centro de Salud - "+text,
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black
                        ),textAlign = TextAlign.Center
                    )
                }
            }
            items(listaDatos){

                    ComisariaDise??o(dato = it,text,text2)


            }
        }
    }




}


@Composable
fun ComisariaDise??o(dato:Datos,text: String, text2: String) {
    var expandir by remember{ mutableStateOf(false)}
    if (text == dato.provincia && text2 == dato.tipo) {
    Column(modifier=Modifier.fillMaxWidth().border(2.dp,Color.Gray, RoundedCornerShape(8.dp))
        .padding(8.dp).background(Color.LightGray, RoundedCornerShape(8.dp))) {

            Row(
                modifier=Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            )
            {
                Text(text=dato.datos,modifier=Modifier.weight(1f), fontSize = 20.sp,fontWeight = FontWeight.Bold)
                Icon(imageVector = Icons.Default.QuestionAnswer, contentDescription = null)


            }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
                ){

            IconButton(onClick={expandir=!expandir

            }){
                Icon(imageVector = Icons.Default.ArrowRight, contentDescription = null)
            }
            if(expandir){
                Text(text=dato.Direcci??n,modifier=Modifier.weight(1f))
                OutlinedButton(onClick = {  }, contentPadding = PaddingValues(4.dp)) {
                    Text(
                        dato.Tel??fono,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Light,
                            fontStyle = FontStyle.Italic
                        )
                    )
                }
            }
        }

        }
    }


}
@Composable
fun mostrarDatos(dato:Datos):Unit{


}


data class Datos(val datos: String,val Direcci??n:String, val Tel??fono:String,val provincia:String,val tipo:String)

private val listaDatos= listOf(
    //Provincia - Arequipa - Comisaria
    Datos(datos="Comisaria San Juan de Dios", Direcci??n=" C. San Juan de Dios 304, Arequipa 04001"
    ,Tel??fono=" (054)231515",provincia="Arequipa",tipo="Comisaria"),
    Datos(datos=" Comisar??a Palacio Viejo ", Direcci??n= "C. Palacio Viejo 112, Arequipa 04001 " ,
        Tel??fono= "(054) 205896", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisaria PNP Santa Marta", Direcci??n= "Calle Sta. Marta 212, Arequipa 04001",
        Tel??fono= "(054) 206259", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisar??a Yanahuara", Direcci??n= "Av. Ej??rcito 341, Yanahuara 04013",
        Tel??fono= "(054) 276444", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisaria Jose Luis Bustamante y Rivero",
            Direcci??n= "Cipreses S/N, Jos?? Luis Bustamante y Rivero 04002",
        Tel??fono= "(054) 427290", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Polic??a de Turismo", Direcci??n= "C. Jerusal??n 315, Arequipa 04001", Tel??fono= "(054) 282613",
        provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="POLIC??A NACIONAL", Direcci??n= "Av. Emmel 106, Yanahuara 04013",
        Tel??fono= "(054) 254020", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisar??a de Cayma", Direcci??n= "Calle Plaza Principal de Cayma N??412, Av. Cayma, Cayma",
        Tel??fono= "(054) 256891", provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisaria Hunter", Direcci??n= "Av. Brasilia N?? 305, Jacobo Hunter 04011", Tel??fono= "(054) 440307",
        provincia="Arequipa", tipo="Comisaria"),
    Datos(datos="Comisar??a Sachaca", Direcci??n= "HCGP+P2W, Av. Fernandini, Sachaca 04013", Tel??fono= "(054) 222179",
        provincia="Arequipa", tipo="Comisaria"),
    //          Hospitales
    Datos(datos="Hospital Regional Honorio Delgado Espinoza",
            Direcci??n= "Alcides Carri??n, Arequipa 04002", Tel??fono= "(054) 234597", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Hospital Goyeneche", Direcci??n= "Av. Goyeneche, Arequipa 04001",Tel??fono= "(054) 231313",
        provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Hospital Nacional Carlos Alberto Seguin Escobedo", Direcci??n= "JF4C+27X, Esquina de Peral y Filtro S/N, Arequipa",
        Tel??fono= "(054) 214050", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Seguro Social Essalud Arequipa", Direcci??n= "C. Peral 555, Arequipa 04001", Tel??fono= "(054) 226969",
        provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Hospital III Yanahuara EsSalud", Direcci??n= "JF34+56M, Av. Garaycochea, Arequipa 04013",
        Tel??fono= "(054) 226969", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Es Salud", Direcci??n="JF39+WP2, C. Ayacucho, Arequipa 04001",
        Tel??fono= "(054) 235155", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Cl??nica Arequipa S.A", Direcci??n= "Francisco Bolognesi 104, Arequipa 04017",
        Tel??fono= "(054) 599000", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Cl??nica San Juan de Dios", Direcci??n= "Terminal Terrestre, ??valo, Arequipa 04011",
        Tel??fono= "913 030 100", provincia="Arequipa", tipo="CentroDeSalud"),
    Datos(datos="Policlinico Barra", Direcci??n= "Av. Emmel 235, Arequipa 04013",
        Tel??fono= "(054) 692816", provincia="Arequipa", tipo="CentroDeSalud"),
    //          Bomberos
    Datos(datos="Benem??rita y Centenaria Compa????a de Bomberos Arequipa 19", Direcci??n= "C. Bolivar 120, Arequipa 04001", Tel??fono= "(054) 241833",
        provincia="Arequipa", tipo="Bomberos"),
    Datos(datos="VII COMANDANCIA DEPARTAMENTAL DE AREQUIPA CUERPO GENERAL DE BOMBEROS VOLUNTARIOS DEL PERU", Direcci??n= "JF5C+PG8, Alto Selva Alegre 04001",
        Tel??fono= "(054) 213333", provincia="Arequipa", tipo="Bomberos"),
    //PROVINCIA - CAMAN??
    Datos(datos="Comisar??a sectorial la pampa", Direcci??n= "98P2+HGQ, V??a de Evitamiento, Caman?? 04446",
        Tel??fono= "(054) 505063", provincia="Camana", tipo="Comisaria"),
    Datos(datos="Complejo Policial Caman??", Direcci??n= "Av. Mariscal Castilla 735, Caman?? 04450", Tel??fono= "(054) 572988", provincia="Camana",
        tipo="Comisaria"),
    Datos(datos="Comisaria san jose",Direcci??n= "Avenida Plaza de Armas N??150",
        Tel??fono= "(054) 573503", provincia="Camana",
        tipo="Comisaria"),

    Datos(datos="Comisar??a san gregorio", Direcci??n= "Calle Progreso N??437", Tel??fono= "(054) 505199",
    provincia="Camana", tipo="Comisaria"),
    Datos(datos="Comisar??a de El Cardo",
            Direcci??n= "97WF+R9X, Calle Comercio N?? S/N, Anexo El Puente de Fierro",
        Tel??fono= "(054) 573460",
        provincia="Camana",
        tipo="Comisaria"),
    //              HOSPITALES
    Datos(datos="Hospital de Apoyo de Caman??",
            Direcci??n= "Panamericana Sur 550, Caman?? 04450",
        Tel??fono= "(054) 571604",
        provincia="Camana",
        tipo="CentroDeSalud"),
    Datos(datos="Nuevo Hospital De Caman??",
            Direcci??n= "Av 3 de Noviembre 141, Caman?? 04450",
        Tel??fono= "(054) 571604", provincia="Camana", tipo="CentroDeSalud"),
    Datos(datos="Hospital EsSalud Camana",
            Direcci??n= "Av 13 de Noviembre, 04446",
        Tel??fono= "(054)571494", provincia="Camana", tipo="CentroDeSalud"),
    //              BOMBEROS
    Datos(datos="Compa????a de Bomberos de Camana B-35",
            Direcci??n= "Jr. Nicolas de Pierola 308, Caman?? 04451", Tel??fono="(054) 571021", provincia="Camana",
        tipo="Bomberos"),
    //PROVINCIA - Caravel??
    Datos(datos="Comisar??a Sectorial de Caravel??",
            Direcci??n= "Avenida 2 de Mayo N?? 809, Caravel?? 04740",
        Tel??fono= "(054) 511081",
        provincia="Caraveli",
        tipo="Comisaria"),
    Datos(datos="Centro de Salud de Caravel??",
            Direcci??n= "12, Caravel?? 04740",
        Tel??fono= "(054) 511089",
        provincia="Caraveli",
        tipo="CentroDeSalud"),

    //PROVINCIA . CASTILLA
    Datos(datos="CPNP Sectorial Castilla Aplao",
            Direcci??n=  "Cll. Pardo Sn Mz.J1 Lt.14",
        Tel??fono=  "(054)471187",
        provincia="Castilla",
        tipo="Comisaria"),
    Datos(datos="Comisar??a PNP Protecci??n de Carreteras Aplao",
            Direcci??n= "Pardo Mz. K1 Lt. 4, Aplao",
        Tel??fono= "(054) 471022",
        provincia="Castilla",
        tipo="Comisaria"),
    //hospital
    Datos(datos="Hospital de Aplao",
            Direcci??n= "Av. 21 de Marzo 111, Aplao",
        Tel??fono= "(054) 471021",
        provincia="Castilla",
        tipo="CentroDeSalud"),
    Datos(datos="Red de Salud Castilla - Condesuyos - La Uni??n (RED CCU)",
            Direcci??n= "Av. 21 de Marzo 105, Aplao",
        Tel??fono= "(054) 471137",
        provincia="Castilla",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de Salud Orcopampa",
            Direcci??n= "Av. Manto S/N, Orcopampa 04656",
        Tel??fono= "(054) 582339",
        provincia="Castilla",
        tipo="CentroDeSalud"),
    //PROVINCIA - LA UNION
    Datos(datos="Comisaria rural alca",
            Direcci??n= "V68P+25W, Calle Plaza de Armas S/N - La union - Alca, Alca",Tel??fono="",
        provincia="LaUnion",
                tipo="Comisaria"),
    Datos(datos="Comisaria rural charcana",
            Direcci??n= "QW5H+RXV, Calle Plaza de Armas S/N - La Union Charcana, Charcana",Tel??fono="",
        provincia="LaUnion",
        tipo="Comisaria"),
    Datos(datos="COMISARIA SECTORIAL COTAHUASI",
            Direcci??n= "Q4Q2+6J Cotahuasi, Per??",
        Tel??fono= "054581031",
        provincia="LaUnion",
        tipo="Comisaria"),
    //          HOSPITAL
    Datos(datos="CS cotahuasi",
            Direcci??n= "AV Union,Cotahuasi, la union",Tel??fono="",
        provincia="LaUnion",
        tipo="CentroDeSalud"),
    Datos(datos="PS Characana",
            Direcci??n="Calle manco capac,Characana,la union", Tel??fono="",
        provincia="LaUnion",
        tipo="CentroDeSalud"),
    // PROVINCIA - CONDESUYOS
            Datos(datos="Comisaria sectorial rural chuquibamba",
            Direcci??n= "Avenida Nicolas de Pierola N?? 100 - Condesuyos - Chuquibamba",
    Tel??fono= "(054) 474119",
    provincia="Condesuyos",
    tipo="Comisaria"),
    Datos(datos="Comisaria rural salamanca",
            Direcci??n= "F5W8+3FJ, Avenida Salamanca S/N - Condesuyos - Salamanca, Que??uamarca",
        Tel??fono= "945078655",
        provincia="Condesuyos",
        tipo="Comisaria"),
    Datos(datos="Comisaria minas oco??a",
            Direcci??n= "3V59+RF7, Calle Principal S/N - Condesuyo - Rio Grande, Cunocuno",
        Tel??fono= "957689643",
        provincia="Condesuyos",
        tipo="Comisaria"),
    Datos(datos="COMISARIA RURAL ARCATA",
            Direcci??n= "XP5F+CQX, Arcata 04195",
        Tel??fono= "#957689516",
        provincia="Condesuyos",
        tipo="Comisaria"),
    Datos(datos="COMISARIA RURAL YANAQUIHUA",
            Direcci??n= "64FF+CX Yanaquihua",
        Tel??fono= "#957690104",
        provincia="Condesuyos",
        tipo="Comisaria"),
    //      HOSPITAL
    Datos(datos="Posta Medica De Chuquibamba",
            Direcci??n="Av Mariscal Castilla 108 A",
        Tel??fono="(054) 474149",
        provincia="Condesuyos",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de Salud Yanaquihua",
            Direcci??n="AV.Rodriguez del valle,Yanaquihua",
        Tel??fono= "(054) 720350",
        provincia="Condesuyos",
        tipo="CentroDeSalud"),
    // provincia -  islay
    Datos(datos="Comisar??a Policial de Matarani",
            Direcci??n= "Matarani 04410",
        Tel??fono= "(054) 557016",
        provincia="Islay",
        tipo="Comisaria"),
    Datos(datos="Comisaria el arenal",
            Direcci??n= "V6H3+HJ2, Islay - Dean Valdivia, El Arenal",
    Tel??fono= "(054) 556042",
    provincia="Islay",
    tipo="Comisaria"),
    Datos(datos="Comisaria sectorial mollendo", Direcci??n= "C. Islay 849, Mollendo 04416",
    Tel??fono= "(054) 534242", provincia="Islay", tipo="Comisaria"),
    Datos(datos="Comisaria la curva", Direcci??n= "V54H+9CJ, Avenida Dean Valdivia S/N, La Curva",
    Tel??fono= "(054) 554042", provincia="Islay", tipo="Comisaria"),
    Datos(datos="Comisaria Alto Incl??n", Direcci??n= "XXJW+4CP, Mollendo 04416",
    Tel??fono= "(054) 532702", provincia="Islay",tipo="Comisaria"),
    Datos(datos="Comisaria Punta de Bomb??n",
            Direcci??n= "Calle Plaza 28 de Julio S/N, Punta de Bomb??n",
        Tel??fono= "(054) 553150",
        provincia="Islay",
        tipo="Comisaria"),
    Datos(datos="Comisaria cocachacra",
            Direcci??n= "Av. Libertad 824, Cocachacra 04431",
        Tel??fono= "(054) 403067",
        provincia="Islay",
        tipo="Comisaria"),
    Datos(datos="Comisaria Miramar",
            Direcci??n= "XXFR+HMM, Mollendo 04416",
        Tel??fono= "(054) 533053",
        provincia="Islay",
        tipo="Comisaria"),
    //      hospital
    Datos(datos="Posta Medica Matarani",
            Direcci??n= ",2W24+C9Q, Matarani 04410",
        Tel??fono= "(054) 557118",
        provincia="Islay",
        tipo="CentroDeSalud"),
    Datos(datos="Hospital II Manuel de Torres Nu??ez Mollendo - EsSalud",
            Direcci??n= "Hospital Manuel Torres Munoz, Juan B. Arenas 100, Mollendo 04416",
        Tel??fono= "(054) 226969",
        provincia="Islay",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de salud Alto Incl??n",
            Direcci??n= "XXJV+2XQ, Mollendo 04416",
        Tel??fono= "(054) 532331",
        provincia="Islay",
        tipo="CentroDeSalud"),
    Datos(datos="Puesto de Salud El Arenal",
            Direcci??n= "El Arenal 04425",
        Tel??fono= "(054) 556114",
        provincia="Islay",
        tipo="CentroDeSalud"),
    //          bomberos
    Datos(datos="Compa??ia de Bomberos 12",
            Direcci??n= "XXCM+4VW, Mollendo 04416",
        Tel??fono= "(054) 533333",
        provincia="Islay",
        tipo="Bomberos"),
    Datos(datos="Compa????a de Bomberos Samuel M??laga N?? 144",
            Direcci??n= "Jhon F Kennedy 206, Mollendo 04416",
        Tel??fono= "(054) 533572",
        provincia="Islay",
        tipo="Bomberos"),
    Datos(datos="Compa??ia de Bomberos B???209",
            Direcci??n= "W66M+6MW, Cocachacra 04431",
    Tel??fono= "961 968 715",
    provincia="Islay",
    tipo="Bomberos"),
    //provincia - caylloma
    Datos(datos="Comisaria rural caylloma",
            Direcci??n= "R66G+PJQ, Plaza Principal Caylloma S/N - Caylloma, Caylloma",
        Tel??fono= "(054) 531 072",
        provincia="Caylloma",
        tipo="Comisaria"),
    Datos(datos="Comisaria Rural PNP Chivay",
            Direcci??n= "997X+68W, Av. Salaverry, Chivay 04145",
        Tel??fono= "(054) 531072",
        provincia="Caylloma",
        tipo="Comisaria"),
    Datos(datos="Comisar??a huanca",
            Direcci??n= "Calle 3 De Setiembre S/N - Caylloma - Huanca",
        Tel??fono="",
        provincia="Caylloma",
        tipo="Comisaria"),
    //hospital
    Datos(datos="Centro de Salud Caylloma",
            Direcci??n= "R67H+GVG, 04190",
        Tel??fono="",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de Salud Caylloma Alta",
        Direcci??n="R67G+368, Caylloma 04190",
        Tel??fono="",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    Datos(datos="Centro de Salud - MINSA",
            Direcci??n= "9C82+G6Q, Ramon Castilla, Chivay 04145",
        Tel??fono= "950 683 783",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    Datos(datos="Posta Medica - ESSALUD",
            Direcci??n= "9C42+FXV, 2 de Mayo, Chivay 04145",
        Tel??fono= "(054) 531110",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    Datos(datos="Hospital Central de Majes",
            Direcci??n= "Majes 04110",
        Tel??fono= "987 332 969",
        provincia="Caylloma",
        tipo="CentroDeSalud"),
    //bomberos
    Datos(datos="CUERPO GENERAL DE BOMBEROS VOLUNTARIOS DEL PER??",
            Direcci??n= "B-205 - EL PEDREGAL,majes,caylloma",
        Tel??fono= "",
        provincia="Caylloma",
        tipo="Bomberos"))


