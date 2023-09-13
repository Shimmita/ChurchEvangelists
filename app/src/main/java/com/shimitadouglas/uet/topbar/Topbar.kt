package com.shimitadouglas.uet.topbar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp


private const val TAG = "Top bar"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String) {
    TopAppBar(modifier = Modifier
        .border(border = BorderStroke(0.1.dp, Color.LightGray ))
        .shadow(elevation = 10.dp),
        title = {
            Text(buildAnnotatedString {
                //leading title
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                    )
                ) {
                    append(title)
                }
                //trailing title shorthand
                withStyle(
                    style = SpanStyle(
                        baselineShift = BaselineShift.Superscript,
                        color = Color.Gray,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("UET")
                }
            })
        }, navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "menu_icon",
                modifier = Modifier.padding(end = 30.dp)
            )
        })
}