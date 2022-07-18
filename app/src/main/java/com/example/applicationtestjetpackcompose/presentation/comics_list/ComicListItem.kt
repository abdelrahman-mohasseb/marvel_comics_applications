package com.example.applicationtestjetpackcompose.presentation.comics_list


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applicationtestjetpackcompose.R
import com.example.applicationtestjetpackcompose.domain.model.Comic
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun ComicListItem(
    comic: Comic,
    modifier: Modifier = Modifier,
) {
   Card (
       modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(15.dp), elevation = 5.dp
           ){
           Box(modifier = Modifier.height(200.dp)) {
               GlideImage(
                   imageModel = comic.thumbnail,
                   // Crop, Fit, Inside, FillHeight, FillWidth, None
                   contentScale = ContentScale.Crop,
                   contentDescription = comic.title,
                   // shows a placeholder while loading the image.
                   placeHolder = painterResource(id = R.drawable.image_is_loading ),
                   // shows an error ImageBitmap when the request failed.
                   error = painterResource(id = R.drawable.error_image )
               )
               Box(modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(colors = listOf(Color.Transparent, Color.Black), startY = 300f)))
               Box(modifier = Modifier
                   .fillMaxSize()
                   .padding(12.dp), contentAlignment = Alignment.BottomStart) {
                 Text(comic.title, style = TextStyle(color = Color.White, fontSize = 16.sp))
               }

           }
   }
}