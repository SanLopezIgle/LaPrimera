package com.dam.laprimera

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.laprimera.ui.theme.LaPrimeraTheme

@Composable
fun InterfazUsuario(miViewModel: MyViewModel){
    val TAG_LOG: String = "Mensaje IU"

    Text(
        text = "numeros: ${miViewModel.getListaRandom()}",
        modifier = Modifier
            .offset(y = 160.dp)
    )

    Button(
        onClick = {
            Log.d(TAG_LOG, "dentro del onClick")
            miViewModel.crearRandom()},
            modifier = Modifier
                .padding(vertical = 300.dp, horizontal = 100.dp)
                .offset(y = 100.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.numeros),
                contentDescription = "generar numeros",
                modifier = Modifier
                    .size(50.dp)
                    .padding(4.dp)
            )
        Text(
            text = "generar numeros"
        )
    }
    Login(miViewModel = MyViewModel())

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(miViewModel: MyViewModel){
    Column {
        TextButton(onClick = {
            miViewModel.contadorClic()},
            modifier = Modifier.offset(y = 5.dp)
        ) {
            Text(
                "clics: ${miViewModel.getContador()}"
            )
        }

        if(miViewModel.name.value.length > 3){
            Text(
                text = "nombre: ${miViewModel.getTexto()}!",
                fontSize = 24.sp,
                modifier = Modifier.offset(y = 110.dp)
            )
        }

        OutlinedTextField(
            value = miViewModel.getTexto(),
            onValueChange = {
                miViewModel.name.value = it
            },
            label = {
                Text(
                    text = "name"
                )
            },
            modifier = Modifier.offset(y = 5.dp)
        )
    }
}

@Composable
fun Greeting(NAME: String, modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ){
        Box{
            Image(
                painter = painterResource(R.drawable.icono),
                contentDescription = "icono"
            )
            Icon(
                painter = painterResource(id = R.drawable.check),
                contentDescription = "icono_check"
            )
        }
        Column {
            Text(
                text = "hola $NAME",
                fontSize = 50.sp,
                color = Color.Blue,
                modifier = modifier
            )
            Text(
                text = stringResource(R.string.saludo),
                fontSize = 20.sp,
                color = Color.Blue,
                modifier = modifier
            )

            Button(
                onClick = {
                    Log.d("no pienso calcular", "sandra")
                }) {
                Text(
                    text = "click me!"
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    LaPrimeraTheme {
        InterfazUsuario(miViewModel = MyViewModel())
    }
}
